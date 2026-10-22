package com.bytedance.ee.bear.attachment.filereader;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.supervisor.token.Token;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Flowable;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u0000 M2\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0014J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020>H\u0002J\b\u0010F\u001a\u00020@H\u0002J\b\u0010G\u001a\u00020@H\u0002J\b\u0010H\u001a\u00020@H\u0002J\u0010\u0010I\u001a\u00020@2\u0006\u0010J\u001a\u00020>H\u0002J\u0010\u0010K\u001a\u00020@2\u0006\u0010J\u001a\u00020>H\u0002J\b\u0010L\u001a\u00020@H\u0014R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u0004\u0018\u00010#8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010#8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001e\u0010+\u001a\u0004\u0018\u00010#8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082.¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/bytedance/ee/bear/attachment/filereader/FileReaderActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseActivity;", "<init>", "()V", "fileReaderTitleFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getFileReaderTitleFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setFileReaderTitleFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "fileReaderTbsreaderFromXml", "Landroid/widget/FrameLayout;", "getFileReaderTbsreaderFromXml", "()Landroid/widget/FrameLayout;", "setFileReaderTbsreaderFromXml", "(Landroid/widget/FrameLayout;)V", "fileReaderLoadingFromXml", "Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "getFileReaderLoadingFromXml", "()Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "setFileReaderLoadingFromXml", "(Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;)V", "fileReaderOtherFromXml", "Landroid/widget/LinearLayout;", "getFileReaderOtherFromXml", "()Landroid/widget/LinearLayout;", "setFileReaderOtherFromXml", "(Landroid/widget/LinearLayout;)V", "fileReaderFileIconFromXml", "Landroid/widget/ImageView;", "getFileReaderFileIconFromXml", "()Landroid/widget/ImageView;", "setFileReaderFileIconFromXml", "(Landroid/widget/ImageView;)V", "fileReaderFileNameFromXml", "Landroid/widget/TextView;", "getFileReaderFileNameFromXml", "()Landroid/widget/TextView;", "setFileReaderFileNameFromXml", "(Landroid/widget/TextView;)V", "fileReaderFileSizeFromXml", "getFileReaderFileSizeFromXml", "setFileReaderFileSizeFromXml", "fileReaderBtnJumpFromXml", "getFileReaderBtnJumpFromXml", "setFileReaderBtnJumpFromXml", "mDownloadPath", "", "mFileId", "mFileDriveKey", "mFileName", "mFileMimeType", "mFileSize", "", "mSaveVideo", "mSaveName", "mToken", "mMountNodeToken", "mMountPoint", "mType", "", "mCurrentPath", "Lcom/ss/android/lark/vfs/VFSPath;", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "isPathValid", "", "vfsPath", "init", "checkStoragePermissions", "saveVideo", "displayFile", "path", "openWithOtherApp", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "features-attachment-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FileReaderActivity extends BaseActivity {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f206363x = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BaseTitleBar f206364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f206365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BearLottieView f206366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f206367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f206368g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f206369h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f206370i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f206371j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f206372k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f206373l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f206374m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f206375n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f206376o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f206377p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f206378q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f206379r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f206380s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f206381t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f206382u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f206383v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public VFSPath f206384w;

    public static final class a {
    }

    public static final class b extends BaseTitleBar.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ FileReaderActivity f206385k;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FileReaderActivity f206386a;

            public a(FileReaderActivity r100) {
                this.f206386a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                FileReaderActivity r101 = this.f206386a;
                VFSPath r102 = r101.f206384w;
                if (r102 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("mCurrentPath");
                r102 = null;
            L5:
                r101.f206378q = r102.getRealPath();
                FileReaderActivity r103 = this.f206386a;
                r103.getClass();
                com.ss.android.lark.utils.h.g(r103, new i(r103), com.ss.android.lark.utils.n.a(), new Token("LARK-PSDA-ccm_docs_attachment_nottos_export"), new String[0]);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.attachment.filereader.FileReaderActivity$b$b, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC2973b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FileReaderActivity f206387a;

            public ViewOnClickListenerC2973b(FileReaderActivity r100) {
                this.f206387a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                FileReaderActivity r101 = this.f206387a;
                VFSPath r102 = r101.f206384w;
                if (r102 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("mCurrentPath");
                r102 = null;
            L5:
                FileUtils.I(r101, r102, this.f206387a.f206376o);
                String r103 = x.f206422a;
                x.a.e("click_attachment_open", "2", "0");
            }
        }

        public b(FileReaderActivity r100) {
            this.f206385k = r100;
            super(R.drawable.attachment_widget_title_file_reader_more_selector);
        }

        @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.b, com.bytedance.ee.bear.widgets.BaseTitleBar.a
        public final void performAction(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            com.bytedance.ee.bear.widgets.a r101 = new com.bytedance.ee.bear.widgets.a(this.f206385k);
            String r102 = this.f206385k.f206376o;
            boolean r103 = false;
            if (r102 != null) goto L5;
        L7:
            if (r103 == false) goto L9;
            r101.e(R.string.Doc_Facade_SaveToAlbum, new a(this.f206385k));
        L9:
            r101.e(R.string.Doc_Facade_OpenInOtherApp, new ViewOnClickListenerC2973b(this.f206385k));
            r101.a();
            r101.q();
            return;
        L5:
            if (StringsKt.contains$default(r102, "video", false, 2, null) != true) goto L7;
            r103 = true;
            goto L7
        }
    }

    public static final class c implements h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FileReaderActivity f206388a;

        public static final class a implements DialogInterface.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FileReaderActivity f206389a;

            public a(FileReaderActivity r100) {
                this.f206389a = r100;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r100, int r101) {
                FileReaderActivity r102 = this.f206389a;
                int r103 = FileReaderActivity.f206363x;
                r102.init();
                String r104 = x.f206422a;
                x.a.e("client_attachment_downloaddonw_alert_goon", "-1", "0");
            }
        }

        public static final class b implements DialogInterface.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FileReaderActivity f206390a;

            public b(FileReaderActivity r100) {
                this.f206390a = r100;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r100, int r101) {
                this.f206390a.finish();
                String r102 = x.f206422a;
                x.a.e("client_attachment_downloaddonw_alert_cancel", "-1", "0");
            }
        }

        @Override // com.bytedance.ee.bear.attachment.filereader.h.a
        public final void b() {
        }

        @Override // com.bytedance.ee.bear.attachment.filereader.h.a
        public final void a() {
            this.f206388a.D1().setVisibility(8);
            this.f206388a.D1().cancelAnimation();
            if (com.bytedance.ee.util.ui.b.a(this.f206388a) == true) goto L5;
            return;
        L5:
            FileReaderActivity r100 = this.f206388a;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            UDDialogBuilder r101 = new UDDialogBuilder(r100);
            r101.autoDismiss(true);
            r101.message(R.string.Doc_Facade_DownloadFailed);
            r101.addActionButton(R.id.ud_dialog_btn_primary, R.string.Doc_Facade_DownloadRetry, new a(this.f206388a));
            r101.addActionButton(R.id.ud_dialog_btn_secondary, R.string.Doc_Facade_Cancel, new b(this.f206388a));
            UDDialog r102 = r101.build();
            if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L13;
            DialogLancet.handleBlockedDialogShow(r102);
        L10:
            String r103 = x.f206422a;
            x.a.e("client_attachment_downloaddonw_alert", "-1", "0");
            x.a.e("client_attachment_cache", "-1", "1");
            return;
        L13:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
        L9:
            DialogLancet.beforeDialogShow(r102);
            r102.show();
            DialogLancet.afterDialogShow(r102);
            goto L10
        }

        @Override // com.bytedance.ee.bear.attachment.filereader.h.a
        public final void c() {
            if (com.bytedance.ee.util.ui.b.a(this.f206388a) == true) goto L5;
            return;
        L5:
            FileReaderActivity r100 = this.f206388a;
            VFSPath r101 = r100.f206384w;
            if (r101 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentPath");
            r101 = null;
        L8:
            r100.C1(r101);
            String r102 = x.f206422a;
            x.a.e("client_attachment_cache", "-1", "0");
        }

        public c(FileReaderActivity r100) {
            this.f206388a = r100;
        }
    }

    static {
    }

    public final BearLottieView D1() {
        KeyEvent.Callback r100 = this.f206366e;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.file_reader_loading);
        this.f206366e = (BearLottieView) r100;
    L6:
        return (BearLottieView) r100;
    }

    public final void init() {
        KeyEvent.Callback r100 = this.f206364c;
        if (r100 != null) goto L5;
        r100 = findViewById(R.id.file_reader_title);
        this.f206364c = (BaseTitleBar) r100;
    L5:
        ((BaseTitleBar) r100).setTitle(this.f206375n);
        VFSPath r101 = this.f206384w;
        VFSPath r102 = null;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mCurrentPath");
        r101 = null;
    L9:
        if (r101.toFile().exists() == false) goto L15;
        VFSPath r103 = this.f206384w;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mCurrentPath");
    L14:
        C1(r102);
        return;
    L13:
        r102 = r103;
        goto L14
    L15:
        KeyEvent.Callback r104 = this.f206365d;
        if (r104 != null) goto L18;
        r104 = findViewById(R.id.file_reader_tbsreader);
        this.f206365d = (FrameLayout) r104;
    L18:
        ((FrameLayout) r104).setVisibility(8);
        D1().setVisibility(0);
        D1().playAnimation();
        KeyEvent.Callback r105 = this.f206367f;
        if (r105 != null) goto L21;
        r105 = findViewById(R.id.file_reader_other);
        this.f206367f = (LinearLayout) r105;
    L21:
        ((LinearLayout) r105).setVisibility(8);
        FileDownloadModel r106 = new FileDownloadModel(this.f206374m, this.f206372k, this.f206379r, this.f206383v);
        int r107 = this.f206383v;
        if (r107 != 0) goto L24;
        r106.setToken(this.f206380s);
    L26:
        String r108 = x.f206422a;
        NetService r109 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        c r110 = new c(this);
        Intrinsics.checkNotNullParameter(r109, "netService");
        Intrinsics.checkNotNullParameter(r106, "downloadModel");
        Intrinsics.checkNotNullParameter(r110, "callback");
        if (r106.getType() != 0) goto L30;
        Flowable.just("").observeOn(fo5.d.c()).map(new n(r106)).subscribe(new p(r106, r109, r110), new r(r110));
        return;
    L30:
        if (r106.getType() != 1) goto L32;
        Flowable.just("").observeOn(fo5.d.c()).map(new s(r106)).subscribe(new t(r106, r109, r110), new v(r110));
        return;
    L32:
        tt5.a.d("FileReaderUtil", "download type can not parse");
        return;
    L24:
        if (r107 != 1) goto L26;
        r106.setMountNodeToken(this.f206381t);
        r106.setMountPoint(this.f206382u);
        goto L26
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        BearLottieView r100 = D1();
        if (r100 != null) goto L8;
    L10:
        boolean r101 = false;
    L11:
        if (r101 == false) goto L14;
        D1().cancelAnimation();
        return;
    L14:
        return;
    L8:
        if (r100.getVisibility() != 0) goto L10;
        r101 = true;
        goto L11
    }

    public FileReaderActivity() {
        this.f206372k = "";
        this.f206373l = "";
        this.f206374m = "";
        this.f206375n = "";
        this.f206376o = "";
        this.f206377p = -1;
        this.f206378q = "";
        this.f206379r = "";
        this.f206380s = "";
        this.f206381t = "";
        this.f206382u = "";
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0108 */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L50;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r100) {
        setContentView(R.layout.attachment_main_file_reader);
        String r101 = x.f206422a;
        this.f206372k = x.a.b().getRealPath();
        this.f206373l = getIntent().getStringExtra("file_reader_file_id");
        this.f206374m = getIntent().getStringExtra("file_reader_file_drive_key");
        this.f206375n = getIntent().getStringExtra("file_reader_file_name");
        this.f206376o = getIntent().getStringExtra("file_reader_file_mime_type");
        this.f206377p = getIntent().getLongExtra("file_reader_file_size", -1);
        this.f206380s = getIntent().getStringExtra("obj_token");
        boolean r102 = false;
        this.f206383v = getIntent().getIntExtra("file_reader_file_type", 0);
        this.f206381t = getIntent().getStringExtra("file_reader_file_mount_node_token");
        this.f206382u = getIntent().getStringExtra("file_reader_file_mount_point");
        String r103 = getIntent().getStringExtra("file_reader_download_path");
        if (TextUtils.isEmpty(r103) == true) goto L5;
        Intrinsics.checkNotNull(r103);
        this.f206372k = r103;
    L5:
        this.f206379r = this.f206380s + '_' + this.f206373l + '_' + this.f206375n;
        com.ss.android.lark.vfs.h r104 = ay4.d.a();
        String r105 = this.f206372k;
        String r106 = this.f206379r;
        String r107 = "";
        if (r106 != null) goto L8;
        r106 = "";
    L8:
        VFSPath r108 = r104.u(r105, r106);
        this.f206384w = r108;
        if (r108 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mCurrentPath");
        r108 = null;
    L46:
        String r109 = r108.toFile().getCanonicalPath();     // Catch: Exception -> L13
    L15:
        if (r109 != null) goto L17;
    L22:
        boolean r110 = false;
    L23:
        if (r110 == true) goto L48;
    L38:
        if (r102 == true) goto L44;
        tt5.a.k("FileReaderActivity", "path is not valid, use default path");
        String r111 = x.f206422a;
        this.f206372k = x.a.b().getRealPath();
        this.f206379r = String.valueOf(System.currentTimeMillis());
        com.ss.android.lark.vfs.h r112 = ay4.d.a();
        String r113 = this.f206372k;
        String r114 = this.f206379r;
        if (r114 == null) goto L43;
        r107 = r114;
    L43:
        this.f206384w = r112.u(r113, r107);
    L44:
        init();
        return;
    L48:
        String r115 = Environment.getExternalStorageDirectory().getAbsolutePath();     // Catch: Throwable -> L37
        File r116 = getExternalFilesDir(null);     // Catch: Throwable -> L37
        if (r116 == null) goto L28;
        String r117 = r116.getAbsolutePath();     // Catch: Throwable -> L37
    L29:
        Intrinsics.checkNotNull(r115);     // Catch: Throwable -> L37
        boolean r118 = StringsKt.startsWith$default(r109, r115, false, 2, null);     // Catch: Throwable -> L37
        if (r117 == null) goto L33;
        boolean r119 = StringsKt.startsWith$default(r109, r117, false, 2, null);     // Catch: Throwable -> L37
    L34:
        if (r118 == true) goto L36;
        if (r119 == false) goto L38;
    L36:
        r102 = true;
        goto L38
    L33:
        r119 = false;
        goto L34
    L28:
        r117 = null;
        goto L29
    L17:
        if (r109.length() != 0) goto L19;
        boolean r120 = true;
    L20:
        if (r120 == true) goto L22;
        r110 = true;
        goto L23
    L19:
        r120 = false;
    L13:
        r109 = null;
        goto L15
    }

    public final void C1(VFSPath r100) {
        KeyEvent.Callback r101 = this.f206364c;
        if (r101 != null) goto L5;
        r101 = findViewById(R.id.file_reader_title);
        this.f206364c = (BaseTitleBar) r101;
    L5:
        ((BaseTitleBar) r101).a(new b(this), true);
        KeyEvent.Callback r102 = this.f206368g;
        if (r102 != null) goto L8;
        r102 = findViewById(R.id.file_reader_file_icon);
        this.f206368g = (ImageView) r102;
    L8:
        ImageView r103 = (ImageView) r102;
        String r104 = x.f206422a;
        String r105 = this.f206376o;
        if (TextUtils.isEmpty(r105) == true) goto L51;
        Intrinsics.checkNotNull(r105);
        String r106 = r105.toLowerCase();
        if (StringsKt.contains$default(r106, ExportFileExtension.PDF, false, 2, null) == false) goto L15;
        int r107 = R.drawable.icon_file_pdf;
    L56:
        r103.setImageResource(r107);
        KeyEvent.Callback r108 = this.f206369h;
        if (r108 != null) goto L59;
        r108 = findViewById(R.id.file_reader_file_name);
        this.f206369h = (TextView) r108;
    L59:
        ((TextView) r108).setText(this.f206375n);
        KeyEvent.Callback r109 = this.f206370i;
        if (r109 != null) goto L62;
        r109 = findViewById(R.id.file_reader_file_size);
        this.f206370i = (TextView) r109;
    L62:
        ((TextView) r109).setText(FileUtils.r(this.f206377p));
        KeyEvent.Callback r110 = this.f206371j;
        if (r110 != null) goto L65;
        r110 = findViewById(R.id.file_reader_btn_jump);
        this.f206371j = (TextView) r110;
    L65:
        ((TextView) r110).setOnClickListener(new j(this, r100));
        KeyEvent.Callback r111 = this.f206365d;
        if (r111 != null) goto L68;
        r111 = findViewById(R.id.file_reader_tbsreader);
        this.f206365d = (FrameLayout) r111;
    L68:
        ((FrameLayout) r111).setVisibility(8);
        D1().setVisibility(8);
        D1().cancelAnimation();
        KeyEvent.Callback r112 = this.f206367f;
        if (r112 != null) goto L71;
        r112 = findViewById(R.id.file_reader_other);
        this.f206367f = (LinearLayout) r112;
    L71:
        ((LinearLayout) r112).setVisibility(0);
        return;
    L15:
        if (StringsKt.contains$default(r106, "ms-powerpoint", false, 2, null) == false) goto L17;
    L55:
        r107 = R.drawable.icon_file_ppt;
        goto L56
    L17:
        if (StringsKt.contains$default(r106, "presentationml", false, 2, null) == true) goto L55;
        if (StringsKt.contains$default(r106, "ms-works", false, 2, null) == true) goto L55;
        if (StringsKt.contains$default(r106, "rtf", false, 2, null) == false) goto L24;
    L54:
        r107 = R.drawable.icon_file_doc;
        goto L56
    L24:
        if (StringsKt.contains$default(r106, "msword", false, 2, null) == true) goto L54;
        if (StringsKt.contains$default(r106, "wordprocessingml", false, 2, null) == true) goto L54;
        if (StringsKt.contains$default(r106, "ms-excel", false, 2, null) == false) goto L31;
    L53:
        r107 = R.drawable.icon_file_xls;
        goto L56
    L31:
        if (StringsKt.contains$default(r106, "spreadsheetml", false, 2, null) == true) goto L53;
        if (StringsKt.contains$default(r106, "zip", false, 2, null) == false) goto L36;
    L52:
        r107 = R.drawable.icon_file_zip;
        goto L56
    L36:
        if (StringsKt.contains$default(r106, "rar", false, 2, null) == true) goto L52;
        if (StringsKt.contains$default(r106, VideoTools.ERROR_TYPE_COMPRESS, false, 2, null) == true) goto L52;
        if (StringsKt.contains$default(r106, "tar", false, 2, null) == true) goto L52;
        if (StringsKt.contains$default(r106, "video", false, 2, null) == false) goto L46;
        r107 = R.drawable.icon_file_video;
        goto L56
    L46:
        if (StringsKt.contains$default(r106, "android.package", false, 2, null) == false) goto L49;
        r107 = R.drawable.attachment_icon_file_apk;
        goto L56
    L49:
        if (StringsKt.contains$default(r106, "audio", false, 2, null) == false) goto L51;
        r107 = R.drawable.attachment_icon_file_audio;
    L51:
        r107 = R.drawable.icon_file_default;
        goto L56
    }
}
