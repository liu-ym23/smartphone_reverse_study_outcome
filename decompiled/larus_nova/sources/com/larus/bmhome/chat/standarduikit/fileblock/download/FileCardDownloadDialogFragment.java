package com.larus.bmhome.chat.standarduikit.fileblock.download;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.crash.d;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.chat.resp.FileUrlData;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.home.impl.utils.c;
import com.larus.image.loader.ResourceUrlExpireHandleUtil;
import com.larus.mainbot.impl.databinding.LarusDialogFileCardDownloadBinding;
import com.larus.nova.R;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import t19.s;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0002J \u0010\u001e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\fH\u0082@¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\fH\u0002J\u0018\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020\fH\u0002J\u001e\u0010(\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010)J\u001e\u0010*\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010)J\u001e\u0010+\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010)J\u001e\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0082@¢\u0006\u0002\u00101J\u0018\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020'2\u0006\u0010$\u001a\u00020\fH\u0002J\u0010\u00104\u001a\u00020\f2\u0006\u0010$\u001a\u00020\fH\u0002J\b\u00105\u001a\u00020\u0010H\u0002J\b\u00106\u001a\u00020\u0010H\u0002J\u0017\u00107\u001a\u00020\u00102\b\u00108\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u00109J\u0010\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/fileblock/download/FileCardDownloadDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusDialogFileCardDownloadBinding;", "resolveJob", "Lkotlinx/coroutines/Job;", "saveJob", "downloadId", "", "tempFilePath", "", "terminal", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", WidgetCostModule.TYPE_ON_START, "onDestroyView", "startDownload", "resolveDownloadUrl", "originalUrl", "resourceUri", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDownloadListener", "Lcom/ss/android/socialbase/downloader/depend/AbsDownloadListener;", "fileName", "saveDownloadedFile", "localFile", "Ljava/io/File;", "exportFileToSystemDownloads", "(Ljava/io/File;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exportWithMediaStore", "exportToLegacyDownloads", "copyToWithCancellation", "input", "Ljava/io/InputStream;", BdpAppEventConstant.PARAMS_OUTPUT, "Ljava/io/OutputStream;", "(Ljava/io/InputStream;Ljava/io/OutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildUniqueFile", "directory", "sanitizeFileName", "cancelDownload", "cancelActiveWork", "finishWithFailure", "errorCode", "(Ljava/lang/Integer;)V", "deleteTempFile", "path", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileCardDownloadDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f309058j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogFileCardDownloadBinding f309059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f309060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Job f309061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f309062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f309063h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f309064i;

    public static final class a {
    }

    static {
    }

    public final void W90() {
        Job r100 = this.f309060e;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        Job r101 = this.f309061f;
        if (r101 == null) goto L9;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L9:
        if (this.f309062g <= 0) goto L16;
        Context r102 = getContext();
        if (r102 == null) goto L15;
        Context r103 = r102.getApplicationContext();
        if (r103 == null) goto L15;
        Downloader.getInstance(r103).cancel(this.f309062g);
    L15:
        this.f309062g = 0;
    L16:
        String r104 = this.f309063h;
        if (r104 == null) goto L19;
        Z90(r104);
    L19:
        this.f309063h = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        if (this.f309064i == true) goto L5;
        this.f309064i = true;
        W90();
    L5:
        this.f309059d = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L5;
        r100.setCanceledOnTouchOutside(false);
    L5:
        Dialog r101 = getDialog();
        if (r101 == null) goto L16;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L17;
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.addFlags(2);
        r102.setDimAmount(0.32f);
        View r103 = r102.getDecorView();
        if (c.f346345e == false) goto L14;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == c.f346341a) goto L14;
        c.a(r104, "getDecorView");
    L14:
        r103.setPadding(0, 0, 0, 0);
        r102.setGravity(17);
        r102.setLayout(c7.b(288), c7.b(144));
        return;
    L17:
        return;
    }

    public FileCardDownloadDialogFragment() {
    }

    public static void Z90(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Boolean.valueOf(new PolarisFileWrapper(r100).delete()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setCancelable(false);
    }

    public static final void U90(FileCardDownloadDialogFragment r100, Integer r101) {
        if (r100.f309064i == true) goto L20;
        r100.f309064i = true;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("download terminated, fileName=");
        Bundle r104 = r100.getArguments();
        if (r104 == null) goto L8;
        String r105 = r104.getString("file_name");
    L9:
        r103.append(r105);
        r103.append(", errorCode=");
        r103.append(r101);
        r102.e("FileCardDownloadDialog", r103.toString());
        r100.W90();
        s r106 = s.f544207a;
        Context r107 = r100.getContext();
        r106.getClass();
        s.b(r107, R.string.larus_update_download_failed, false);
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r108 = DialogFragmentLancet.sLastShowStack;
        if (r108 == null) goto L19;
        d.d(r108, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L19:
        return;
    L8:
        r105 = null;
        goto L9
    }

    public static void X90(ContentResolver r210, Uri r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, null, null};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240019);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        f06.d r107 = r106.preInvoke(240019, "android/content/ContentResolver", "delete", r210, r101, "int", r110);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L20;
        ((Integer) r107.f474983b).intValue();
        return;
    L20:
        r210.delete(r211, null, null);
        return;
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        r110.setClipToOutline(true);
        LarusDialogFileCardDownloadBinding r112 = this.f309059d;
        if (r112 == null) goto L7;
        TextView r113 = r112.f358583b;
        if (r113 == null) goto L7;
        r113.setOnClickListener(new com.larus.bmhome.chat.standarduikit.fileblock.download.a(this));
    L7:
        Context r100 = getContext();
        if (r100 == null) goto L45;
        Bundle r114 = getArguments();
        if (r114 == null) goto L13;
        String r115 = r114.getString(ShareType.FILE_URL);
    L15:
        if (r115 != null) goto L17;
        String r101 = "";
    L18:
        Bundle r116 = getArguments();
        if (r116 == null) goto L21;
        String r117 = r116.getString("resource_uri");
    L22:
        if (r117 != null) goto L24;
        String r102 = "";
    L25:
        Bundle r118 = getArguments();
        if (r118 == null) goto L28;
        String r119 = r118.getString("file_name");
    L29:
        if (r119 != null) goto L31;
        String r103 = "";
    L32:
        String r120 = StringsKt.trim(StringsKt.replace$default(StringsKt.substringAfterLast$default(StringsKt.replace$default(r103, '\\', '/', false, 4, null), '/', null, 2, null), "\u0000", "", false, 4, null)).toString();
        if (r120.length() != 0) goto L35;
        boolean r104 = true;
    L36:
        if (r104 == false) goto L38;
        r120 = "doubao_" + System.currentTimeMillis();
    L38:
        String r105 = r120;
        LarusDialogFileCardDownloadBinding r121 = this.f309059d;
        if (r121 == null) goto L43;
        ProgressBar r122 = r121.f358585d;
        if (r122 == null) goto L43;
        r122.setIndeterminate(true);
    L43:
        this.f309060e = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new FileCardDownloadDialogFragment$startDownload$1(this, r101, r102, r105, r100, null), 3, null);
        return;
    L35:
        r104 = false;
        goto L36
    L31:
        r103 = r119;
        goto L32
    L28:
        r119 = null;
        goto L29
    L24:
        r102 = r117;
        goto L25
    L21:
        r117 = null;
        goto L22
    L17:
        r101 = r115;
        goto L18
    L13:
        r115 = null;
        goto L15
    }

    public static void Y90(ContentResolver r210, Uri r211, ContentValues r212) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, r212, null, null};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240018);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r112 = r111.length;
        int r104 = 0;
    L8:
        if (r104 >= r112) goto L15;
        f06.a r105 = r111[r104];
        int r113 = r104;
        int r114 = r112;
        f06.a[] r213 = r111;
        f06.d r106 = r105.preInvoke(240018, "android/content/ContentResolver", "update", r210, r101, "int", r110);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L20;
        ((Integer) r106.f474983b).intValue();
        return;
    L20:
        r210.update(r211, r212, null, null);
        return;
    L14:
        r104 = r113 + 1;
        r112 = r114;
        r111 = r213;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_dialog_file_card_download, r101, false);
        int r104 = R.id.download_cancel;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r103, R.id.download_cancel);
        if (r105 == null) goto L16;
        ConstraintLayout r106 = (ConstraintLayout) r103;
        View r107 = ViewBindings.findChildViewById(r103, R.id.download_divider);
        if (r107 == null) goto L14;
        ProgressBar r108 = (ProgressBar) ViewBindings.findChildViewById(r103, R.id.download_progress);
        if (r108 != null) goto L9;
        r104 = R.id.download_progress;
        goto L16
    L9:
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.download_title)) == null) goto L12;
        this.f309059d = new LarusDialogFileCardDownloadBinding(r106, r105, r107, r108);
        return r106;
    L12:
        r104 = R.id.download_title;
        goto L16
    L14:
        r104 = R.id.download_divider;
    L16:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r13v14, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v9, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r15v5, types: [com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper, java.io.InputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v9 */
    public static final Object S90(FileCardDownloadDialogFragment r110, File r111, String r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof FileCardDownloadDialogFragment$exportToLegacyDownloads$1) == false) goto L7;
        FileCardDownloadDialogFragment$exportToLegacyDownloads$1 r100 = (FileCardDownloadDialogFragment$exportToLegacyDownloads$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        Closeable r115 = (Closeable) r100.L$4;
        ?? r116 = (Closeable) r100.L$3;
        File r117 = (File) r100.L$2;
        Context r105 = (Context) r100.L$1;
        String r106 = (String) r100.L$0;
        ResultKt.throwOnFailure(r114);     // Catch: Throwable -> L14
        File r107 = r117;
        r112 = r106;
        r115 = r115;
        r116 = r116;
    L84:
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L60
        CloseableKt.closeFinally(r115, null);     // Catch: Throwable -> L58
        CloseableKt.closeFinally(r116, null);     // Catch: Throwable -> L54 CancellationException -> L56
        JobKt.ensureActive(r100.getContext());     // Catch: Throwable -> L54 CancellationException -> L56
        MediaScannerConnection.scanFile(r105, new String[]{r107.getAbsolutePath()}, null, null);     // Catch: Throwable -> L54 CancellationException -> L56
    L103:
        return Boxing.boxBoolean(r104);
    L58:
        th = th;
    L94:
        throw th;     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        CloseableKt.closeFinally(r116, th);     // Catch: Throwable -> L54 CancellationException -> L56
        throw th;     // Catch: Throwable -> L54 CancellationException -> L56
    L60:
        Throwable th10 = th;
        r106 = r112;
        r117 = r107;
    L62:
        ?? r119 = r116;
        Closeable r120 = r115;
    L63:
        ?? r121 = r119;
        throw th10;     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        CloseableKt.closeFinally(r120, th10);     // Catch: Throwable -> L70
        throw th;     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        ?? r122 = r121;
        th = th;
    L73:
        r116 = r122;
    L14:
        th10 = th;
        goto L62
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r114);
        Context r123 = r110.getContext();
        if (r123 == null) goto L83;
        Context r124 = r123.getApplicationContext();
        if (r124 == null) goto L83;
        PolarisFileWrapper r125 = new PolarisFileWrapper(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Doubao");
        if (r125.exists() == false) goto L26;
    L28:
        int r108 = StringsKt.lastIndexOf$default(r112, '.', 0, false, 6, null);
        if (r108 <= 0) goto L31;
        String r109 = r112.substring(0, r108);
    L32:
        if (r108 <= 0) goto L34;
        String r126 = r112.substring(r108);
    L35:
        r107 = new PolarisFileWrapper(r125, r112);
        int r127 = 1;
    L37:
        if (r107.exists() == false) goto L100;
        r107 = new PolarisFileWrapper(r125, r109 + '(' + r127 + ')' + r126);
        r127 = r127 + 1;
        goto L37
    L100:
        r122 = new PolarisFileInputStreamWrapper(r111);     // Catch: Throwable -> L54 CancellationException -> L56
        PolarisFileOutputStreamWrapper r128 = new PolarisFileOutputStreamWrapper(r107);     // Catch: Throwable -> L72
        r100.L$0 = r112;     // Catch: Throwable -> L64
        r100.L$1 = r124;     // Catch: Throwable -> L64
        r100.L$2 = r107;     // Catch: Throwable -> L64
        r100.L$3 = r122;     // Catch: Throwable -> L64
        r100.L$4 = r128;     // Catch: Throwable -> L64
        r100.label = 1;     // Catch: Throwable -> L64
        byte[] r129 = new byte[8192];     // Catch: Throwable -> L64
    L42:
        JobKt.ensureActive(r100.getContext());     // Catch: Throwable -> L64
        int r130 = r122.read(r129);     // Catch: Throwable -> L64
        if (r130 < 0) goto L45;
        r128.write(r129, 0, r130);     // Catch: Throwable -> L64
        goto L42
    L45:
        if (Unit.INSTANCE == r102) goto L104;
        r105 = r124;
        r115 = r128;
        r116 = r122;
        goto L84
    L104:
        return r102;
    L64:
        th = move-exception;
        r119 = r122;
        th10 = th;
        r120 = r128;
    L72:
        th = th;
    L56:
        e = move-exception;
        r107.delete();
        throw e;
    L54:
        th = move-exception;
        r107.delete();
        FLogger.f375446a.e("FileCardDownloadDialog", "save to legacy Downloads failed, fileName=" + r112, th);
        r104 = false;
        goto L103
    L34:
        r126 = "";
        goto L35
    L31:
        r109 = r112;
        goto L32
    L26:
        if (r125.mkdirs() == true) goto L28;
        return Boxing.boxBoolean(false);
    L83:
        return Boxing.boxBoolean(false);
    L7:
        r100 = new FileCardDownloadDialogFragment$exportToLegacyDownloads$1(r110, r113);
        goto L8
    }

    public static final Object T90(FileCardDownloadDialogFragment r210, File r211, String r310, Continuation r311) {
        String r100 = r310;
        r210.getClass();
        if ((r311 instanceof FileCardDownloadDialogFragment$exportWithMediaStore$1) == false) goto L7;
        FileCardDownloadDialogFragment$exportWithMediaStore$1 r101 = (FileCardDownloadDialogFragment$exportWithMediaStore$1) r311;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        Closeable r106 = (Closeable) r101.L$5;
        Closeable r107 = (Closeable) r101.L$4;
        Uri r108 = (Uri) r101.L$3;
        ContentValues r109 = (ContentValues) r101.L$2;
        ContentResolver r110 = (ContentResolver) r101.L$1;
        String r111 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L14
        Closeable r112 = r106;
        r100 = r111;
        r107 = r107;
    L103:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L68
        CloseableKt.closeFinally(r112, null);     // Catch: Throwable -> L66
        CloseableKt.closeFinally(r107, null);     // Catch: Throwable -> L62 CancellationException -> L64
        JobKt.ensureActive(r101.getContext());     // Catch: Throwable -> L62 CancellationException -> L64
        r109.clear();     // Catch: Throwable -> L62 CancellationException -> L64
        r109.put("is_pending", Boxing.boxInt(0));     // Catch: Throwable -> L62 CancellationException -> L64
        Y90(r110, r108, r109);     // Catch: Throwable -> L62 CancellationException -> L64
        boolean r114 = true;
    L123:
        return Boxing.boxBoolean(r114);
    L64:
        e = e;
    L95:
        X90(r110, r108);
        throw e;
    L62:
        th = th;
    L92:
        X90(r110, r108);
        FLogger.f375446a.e("FileCardDownloadDialog", "save to MediaStore failed, fileName=" + r100, th);
        r114 = false;
    L66:
        th = move-exception;
        Throwable r115 = th;
        Closeable r116 = r107;
    L101:
        throw r115;     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        CloseableKt.closeFinally(r116, r115);     // Catch: Throwable -> L85 CancellationException -> L87
        throw th;     // Catch: Throwable -> L85 CancellationException -> L87
    L68:
        Throwable th10 = th;
        Closeable r212 = r112;
        r111 = r100;
        r106 = r212;
    L70:
        Throwable r117 = th10;
        Closeable r118 = r106;
        Closeable r119 = r107;
    L109:
        throw r117;     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        CloseableKt.closeFinally(r118, r117);     // Catch: Throwable -> L78
        throw th;     // Catch: Throwable -> L78
    L14:
        th10 = th;
        goto L70
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        Context r120 = r210.getContext();
        if (r120 == null) goto L98;
        Context r121 = r120.getApplicationContext();
        if (r121 == null) goto L98;
        ContentResolver r122 = r121.getContentResolver();
        r109 = new ContentValues();
        r109.put("_display_name", r100);
        r109.put("title", r100);
        String r123 = URLConnection.guessContentTypeFromName(r310);
        if (r123 != null) goto L26;
        r123 = "application/octet-stream";
    L26:
        r109.put("mime_type", r123);
        r109.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS + "/Doubao");
        r109.put("is_pending", Boxing.boxInt(1));
        Uri r124 = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
        ArrayList r125 = new ArrayList();
        Object[] r126 = {r124, r109};
        f06.b r127 = new f06.b();
        g06.a r128 = ApiHookConfig.f245611b.get(240017);
        if (r128 == null) goto L29;
        f06.a[] r129 = r128.f479473i;
    L30:
        f06.a[] r130 = r129;
        int r131 = r130.length;
        int r132 = 0;
    L32:
        if (r132 >= r131) goto L39;
        f06.a r133 = r130[r132];
        int r213 = r132;
        int r214 = r131;
        f06.a[] r215 = r130;
        Object[] r216 = r126;
        ArrayList r134 = r125;
        f06.d r135 = r133.preInvoke(240017, "android/content/ContentResolver", "insert", r122, r216, "android.net.Uri", r127);     // Catch: Exception -> L99
        if (r135.f474982a == true) goto L41;
        r134.add(r133);     // Catch: Exception -> L99
    L41:
        if (r135.f474982a == false) goto L43;
        Uri r136 = (Uri) r135.f474983b;
    L44:
        Uri r137 = r136;
        if (r137 == null) goto L122;
        OutputStream r138 = ContentResolverWrapper.openOutputStream(r122, r137);     // Catch: Throwable -> L85 CancellationException -> L87
        if (r138 == null) goto L90;
        PolarisFileInputStreamWrapper r139 = new PolarisFileInputStreamWrapper(r211);     // Catch: Throwable -> L78
        r101.L$0 = r100;     // Catch: Throwable -> L71
        r101.L$1 = r122;     // Catch: Throwable -> L71
        r101.L$2 = r109;     // Catch: Throwable -> L71
        r101.L$3 = r137;     // Catch: Throwable -> L71
        r101.L$4 = r138;     // Catch: Throwable -> L71
        r101.L$5 = r139;     // Catch: Throwable -> L71
        r101.label = 1;     // Catch: Throwable -> L71
        byte[] r140 = new byte[8192];     // Catch: Throwable -> L71
    L51:
        JobKt.ensureActive(r101.getContext());     // Catch: Throwable -> L71
        int r141 = r139.read(r140);     // Catch: Throwable -> L71
        if (r141 < 0) goto L54;
        r138.write(r140, 0, r141);     // Catch: Throwable -> L71
        goto L51
    L54:
        if (Unit.INSTANCE == r104) goto L124;
        r108 = r137;
        r110 = r122;
        r107 = r138;
        r112 = r139;
        goto L103
    L124:
        return r104;
    L71:
        th = move-exception;
        r117 = th;
        r119 = r138;
        r118 = r139;
        goto L109
    L90:
        throw new IOException("Open Downloads output stream failed");     // Catch: Throwable -> L85 CancellationException -> L87
    L87:
        e = e;
        r110 = r122;
        r108 = r137;
    L85:
        th = th;
        r110 = r122;
        r108 = r137;
        goto L92
    L122:
        return Boxing.boxBoolean(false);
    L43:
        r136 = r122.insert(r124, r109);
    L38:
        r132 = r213 + 1;
        r125 = r134;
        r131 = r214;
        r130 = r215;
        r126 = r216;
        goto L32
    L39:
        r135 = new f06.d(false, null);
        goto L41
    L29:
        r129 = ApiHookConfig.f245613d;
    L98:
        return Boxing.boxBoolean(false);
    L78:
        th = move-exception;
        r115 = th;
        r116 = r119;
    L7:
        r101 = new FileCardDownloadDialogFragment$exportWithMediaStore$1(r210, r311);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object V90(FileCardDownloadDialogFragment r100, String r101, String r102, Continuation r103) {
        r100.getClass();
        if ((r103 instanceof FileCardDownloadDialogFragment$resolveDownloadUrl$1) == false) goto L7;
        FileCardDownloadDialogFragment$resolveDownloadUrl$1 r104 = (FileCardDownloadDialogFragment$resolveDownloadUrl$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L19;
        if (r108 == 1) goto L16;
        if (r108 != 2) goto L15;
        ResultKt.throwOnFailure(r106);     // Catch: Throwable -> L51
    L37:
        FileUrlRespData r109 = (FileUrlRespData) ((com.larus.network.http.a) r106).f360135b;     // Catch: Throwable -> L51
        if (r109 == null) goto L48;
        List<FileUrlData> r110 = r109.getFileUrlList();     // Catch: Throwable -> L51
        if (r110 == null) goto L48;
        FileUrlData r111 = (FileUrlData) CollectionsKt.firstOrNull(r110);     // Catch: Throwable -> L51
        if (r111 == null) goto L48;
        String r112 = r111.getMainUrl();     // Catch: Throwable -> L51
        if (r112 == null) goto L48;
        if (y0.e(r112) == false) goto L48;
    L49:
        Object r113 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L51
    L53:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L60;
        FLogger r115 = FLogger.f375446a;
        StringBuilder r116 = new StringBuilder("resolve download url failed, fileName=");
        Bundle r117 = r100.getArguments();
        if (r117 == null) goto L58;
        String r118 = r117.getString("file_name");
    L59:
        r116.append(r118);
        r115.e("FileCardDownloadDialog", r116.toString(), r114);
        goto L60
    L58:
        r118 = null;
    L60:
        boolean r119 = Result.m9455isFailureimpl(r113);
        Object r120 = r113;
        if (r119 == true) goto L63;
    L69:
        return r120;
    L63:
        return null;
    L48:
        r112 = null;
        goto L49
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r121 = (String) r104.L$0;
        ResultKt.throwOnFailure(r106);     // Catch: Throwable -> L26
        r101 = r121;
    L24:
        Object r122 = Result.m9449constructorimpl((String) r106);     // Catch: Throwable -> L26
        String r123 = r101;
    L28:
        Object r124 = r122;
        r120 = r123;
        if (Result.m9455isFailureimpl(r124) == true) goto L69;
        return r124;
    L19:
        ResultKt.throwOnFailure(r106);
        if (y0.e(r101) == false) goto L32;
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L26
        ResourceUrlExpireHandleUtil r126 = ResourceUrlExpireHandleUtil.f350961a;     // Catch: Throwable -> L26
        r104.L$0 = r101;     // Catch: Throwable -> L26
        r104.label = 1;     // Catch: Throwable -> L26
        r106 = r126.a(r101, r104);     // Catch: Throwable -> L26
        r101 = r101;
        if (r106 != r107) goto L24;
        return r107;
    L32:
        if (StringsKt.isBlank(r102) == true) goto L63;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L51
        Lazy<ChatApi> r128 = ChatApi.f297153a;     // Catch: Throwable -> L51
        ChatApi r129 = ChatApi.a.a();     // Catch: Throwable -> L51
        List r130 = CollectionsKt.listOf(r102);     // Catch: Throwable -> L51
        String r131 = UploadDataType.FILE.getType();     // Catch: Throwable -> L51
        r104.label = 2;     // Catch: Throwable -> L51
        r129.getClass();     // Catch: Throwable -> L51
        r106 = ChatApi.e(r130, r131, r104);     // Catch: Throwable -> L51
        if (r106 != r107) goto L37;
        return r107;
    L26:
        th = move-exception;
        Result.Companion r132 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r123 = r101;
    L51:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r104 = new FileCardDownloadDialogFragment$resolveDownloadUrl$1(r100, r103);
        goto L8
    }
}
