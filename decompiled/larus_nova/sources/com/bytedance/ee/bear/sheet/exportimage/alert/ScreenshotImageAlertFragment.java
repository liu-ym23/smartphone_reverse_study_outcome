package com.bytedance.ee.bear.sheet.exportimage.alert;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareView;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.matermark.CCMWatermarkManager;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.share.export.SharePanelState;
import com.bytedance.ee.bear.share.export.i;
import com.bytedance.ee.bear.share.externalshare.ShareScene;
import com.bytedance.ee.bear.sheet.exportimage.preview.SheetImagePreviewPlugin;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.lark.android.encryption.CipherManager;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.io.File;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rm5.o;
import sm5.f;
import sm5.g;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 T2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001TB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010/\u001a\u00020-H\u0016J\b\u00100\u001a\u00020-H\u0002J\u0010\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020#H\u0002J\b\u00103\u001a\u00020-H\u0002J\u000e\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0002J\b\u00107\u001a\u000208H\u0002J\u0012\u00109\u001a\u00020:2\b\b\u0001\u0010;\u001a\u00020\u001eH\u0002J\b\u0010<\u001a\u00020-H\u0002J\b\u0010=\u001a\u00020-H\u0002J\b\u0010>\u001a\u00020-H\u0002J\u0010\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020AH\u0002J\u0012\u0010B\u001a\u00020-2\b\u0010C\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u00020FH\u0003J\u0010\u0010G\u001a\u00020-2\u0006\u0010H\u001a\u000206H\u0003J\u0018\u0010I\u001a\u00020-2\u0006\u0010H\u001a\u0002062\u0006\u0010J\u001a\u00020AH\u0002J\b\u0010K\u001a\u00020-H\u0002J\b\u0010L\u001a\u00020-H\u0003J\u001e\u0010M\u001a\b\u0012\u0004\u0012\u00020A0N2\u0006\u0010E\u001a\u00020F2\u0006\u0010O\u001a\u00020:H\u0002J\u0018\u0010P\u001a\b\u0012\u0004\u0012\u00020A0N2\b\u0010Q\u001a\u0004\u0018\u00010AH\u0002J\b\u0010R\u001a\u00020-H\u0016J\u0006\u0010S\u001a\u00020:R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/bytedance/ee/bear/sheet/exportimage/alert/ScreenshotImageAlertFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/ee/bear/share/export/ISharePanel;", "<init>", "()V", "panelSession", "", "getPanelSession", "()Ljava/lang/String;", "viewModel", "Lcom/bytedance/ee/bear/sheet/exportimage/alert/ScreenshotImageAlertViewModel;", "titleTv", "Landroid/widget/TextView;", "messageTv", "saveTv", "shareTv", "closeIv", "Landroid/widget/ImageView;", "screenshotImageContainer", "Landroid/widget/FrameLayout;", "screenshotImageIv", "Lcom/davemorrissey/labs/subscaleview/SubsamplingScaleImageView;", "loadingView", "Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "screenshtRoot", "externalShareView", "Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareView;", "externalShareViewContainer", "imageWidth", "", "imageHeight", "minScale", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onViewCreated", "", "view", WidgetCostModule.TYPE_ON_START, "initObservers", "initViews", RootDescription.ROOT_ELEMENT, "updateExternalConfig", "getShareItems", "", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareItemModel;", "buildShareItemModelParams", "Lcom/bytedance/ee/bear/share/externalshare/DocumentShareItemModelParams;", "canPassCipher", "", "toastTextResId", "showExternalView", "hideExternalView", "startLoading", "endLoadingStatus", "image", "Ljava/io/File;", SendEventContainerMethodParamModel.EventKinds.onClick, BaseSwitches.V, "shareToExternalApp", "shareType", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareType;", "handleCustomShare", "shareItem", "doShareImageToCustom", "imageFile", "onShare", "onSave", "getImageInner", "Lio/reactivex/Single;", "isWatermarkRemainingEnable", "getWatermarkedImage", "originalFile", "onDestroyView", "onBackPressed", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenshotImageAlertFragment extends BaseAntiScreenshotsDialogFragment implements View.OnClickListener, i {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f237478w = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f237479h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ScreenshotImageAlertViewModel f237480i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f237481j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f237482k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f237483l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f237484m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FrameLayout f237485n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SubsamplingScaleImageView f237486o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public BearLottieView f237487p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public FrameLayout f237488q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ExternalShareView f237489r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public FrameLayout f237490s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f237491t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f237492u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f237493v;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScreenshotImageAlertFragment f237494a;

        public b(ScreenshotImageAlertFragment r100) {
            this.f237494a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            File r101 = (File) r100;
            int r102 = ScreenshotImageAlertFragment.f237478w;
            StringBuilder r103 = new StringBuilder("getImageInner: [watermark remaining] generated file=");
            if (r101 == null) goto L5;
            String r104 = r101.getAbsolutePath();
        L6:
            r103.append(r104);
            tt5.a.h("ScreenshotImageAlertFragment", r103.toString());
            ScreenshotImageAlertViewModel r105 = this.f237494a.f237480i;
            if (r105 == null) goto L10;
            r105.setWatermarkedImageBitmap(r101);
            return;
        L10:
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class c implements DialogInterface.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScreenshotImageAlertFragment f237495a;

        public c(ScreenshotImageAlertFragment r100) {
            this.f237495a = r100;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
            boolean r103 = false;
            if (r101 == 4) goto L6;
            return false;
        L6:
            if (r101 != 4) goto L23;
            if (r102 != null) goto L9;
        L11:
            boolean r104 = false;
        L12:
            if (r104 == false) goto L23;
            ScreenshotImageAlertFragment r105 = this.f237495a;
            FrameLayout r106 = r105.f237490s;
            if (r106 != null) goto L16;
        L18:
            if (r103 == false) goto L20;
            r105.ca0();
            goto L23
        L20:
            ScreenshotImageAlertViewModel r107 = r105.f237480i;
            if (r107 == null) goto L23;
            r107.close();
            goto L23
        L16:
            if (r106.getVisibility() != 0) goto L18;
            r103 = true;
            goto L18
        L9:
            if (r102.getAction() != 1) goto L11;
            r104 = true;
        L23:
            return true;
        }
    }

    public static final class d implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f237496a = null;

        static {
            f237496a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            Toast.cancelLoading();
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScreenshotImageAlertFragment f237497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ShareType f237498b;

        public e(ScreenshotImageAlertFragment r100, ShareType r101) {
            this.f237497a = r100;
            this.f237498b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Context r101 = this.f237497a.getContext();
            ShareType r102 = this.f237498b;
            o.c(r101, r102, (File) r100);
            ScreenshotImageAlertViewModel r103 = this.f237497a.f237480i;
            if (r103 == null) goto L6;
            r103.onShareSuccess(this.f237498b);
            return;
        }
    }

    static {
    }

    public final km5.a Z90() {
        return new km5.a(0, 3, null, false, false, null, CollectionsKt.arrayListOf(new Integer[]{Integer.valueOf(ShareType.Download.ordinal())}), null, false, false, false, false, null, null, false, false, ShareScene.EXPORT_IMAGE, 49152);
    }

    public final void ca0() {
        FrameLayout r100 = this.f237490s;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        ExternalShareView r101 = this.f237489r;
        if (r101 == null) goto L8;
        r101.setVisibility(8);
    L8:
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).H9(this, SharePanelState.NOT_SHOW, Z90());
    }

    public ScreenshotImageAlertFragment() {
        this.f237479h = String.valueOf(hashCode());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        BearLottieView r100 = this.f237487p;
        if (r100 == null) goto L5;
        r100.cancelAnimation();
    L5:
        ExternalShareView r101 = this.f237489r;
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L14;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).H9(this, SharePanelState.NOT_SHOW, Z90());
    L14:
        FrameLayout r103 = this.f237488q;
        if (r103 == null) goto L18;
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).detachWatermark(r103);
        return;
    L18:
        return;
    L8:
        if (r101.getVisibility() != 0) goto L10;
        r102 = true;
        goto L12
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L5;
        Window r101 = r100.getWindow();
    L7:
        if (r101 == null) goto L9;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.dimAmount = 0.4f;
        r102.width = -1;
        r102.gravity = 80;
        r102.height = -1;
        r102.windowAnimations = 0;
        r101.setAttributes(r102);
        r101.setBackgroundDrawable(new ColorDrawable(0));
        r100.setOnKeyListener(new c(this));
    L9:
        setCancelable(false);
        return;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.share.export.i
    public final String getPanelSession() {
        return this.f237479h;
    }

    public final boolean aa0(int r100) {
        if (CipherManager.d() != 1) goto L9;
        Context r101 = getContext();
        if (r101 == null) goto L10;
        Toast.showText(r101, r101.getString(r100), 1);
        CipherManager.h();
        return false;
    L10:
        return false;
    L9:
        return true;
    }

    public final void da0(ShareType r100) {
        boolean r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("admin.watermark.filewatermark.remaining");
        CharSequence r102 = null;
        if (r101 == true) goto L5;
    L11:
        Context r103 = getContext();
        Context r104 = getContext();
        if (r104 == null) goto L14;
        r102 = r104.getText(R.string.Doc_Share_ExportImageLoading);
    L14:
        Toast.showLoading(r103, r102);
    L15:
        ba0(r100, r101).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).doFinally(d.f237496a).subscribe(new e(this, r100));
        return;
    L5:
        if (r100 == ShareType.Lark) goto L15;
        ScreenshotImageAlertViewModel r105 = this.f237480i;
        if (r105 == null) goto L9;
        File r106 = r105.getWatermarkedImageBitmap();
    L10:
        if (r106 != null) goto L15;
    L9:
        r106 = null;
        goto L10
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 == null) goto L49;
        int r101 = r100.getId();
        CharSequence r102 = null;
        if (r101 != R.id.image_alert_save) goto L24;
        ScreenshotImageAlertViewModel r103 = this.f237480i;
        if (r103 == null) goto L9;
        r103.onClickSaveBtn();
    L9:
        if (aa0(R.string.CreationMobile_ECM_SecuritySettingKAToast) == false) goto L57;
        boolean r104 = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("admin.watermark.filewatermark.remaining");
        if (r104 == false) goto L18;
        ScreenshotImageAlertViewModel r105 = this.f237480i;
        if (r105 == null) goto L16;
        File r106 = r105.getWatermarkedImageBitmap();
    L17:
        if (r106 == null) goto L18;
    L22:
        ba0(ShareType.Download, r104).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).doFinally(sm5.d.f542577a).subscribe(new f(this));
        return;
    L16:
        r106 = null;
    L18:
        Context r107 = getContext();
        Context r108 = getContext();
        if (r108 == null) goto L21;
        r102 = r108.getText(R.string.Doc_Share_ExportImageLoading);
    L21:
        Toast.showLoading(r107, r102);
        goto L22
    L57:
        return;
    L24:
        if (r101 != R.id.image_alert_share) goto L41;
        if (CipherManager.d() != 1) goto L30;
        Context r109 = getContext();
        if (r109 == null) goto L51;
        Toast.showText(r109, r109.getString(R.string.CreationMobile_ECM_ShareSecuritySettingKAToast), 1);
        CipherManager.h();
        return;
    L51:
        return;
    L30:
        ScreenshotImageAlertViewModel r110 = this.f237480i;
        if (r110 == null) goto L33;
        r110.onClickShareBtn();
    L33:
        FrameLayout r111 = this.f237490s;
        if (r111 == null) goto L36;
        r111.setVisibility(0);
    L36:
        ExternalShareView r112 = this.f237489r;
        if (r112 == null) goto L39;
        r112.setVisibility(0);
    L39:
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).H9(this, SharePanelState.SHOWING, Z90());
        return;
    L41:
        if (r101 != R.id.image_alert_close) goto L46;
        ScreenshotImageAlertViewModel r113 = this.f237480i;
        if (r113 == null) goto L54;
        r113.close();
        return;
    L54:
        return;
    L46:
        if (r101 != R.id.external_share_view_container) goto L56;
        ca0();
        return;
    L56:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Context r101 = getContext();
        Intrinsics.checkNotNull(r101);
        return new Dialog(r101, R.style.ScreenshotFragmentStyle);
    }

    public final Single<File> ba0(ShareType r100, boolean r101) {
        ScreenshotImageAlertViewModel r102 = this.f237480i;
        File r103 = null;
        if (r102 == null) goto L7;
        MutableLiveData<File> r104 = r102.getImageBitmap();
        if (r104 == null) goto L7;
        File r105 = r104.getValue();
    L9:
        if (r105 != null) goto L12;
        tt5.a.d("ScreenshotImageAlertFragment", "getImageInner: imageBitmap is null");
        return Single.error(new Throwable("[watermark remaining] getImageInner, imageBitmap is null"));
    L12:
        tt5.a.h("ScreenshotImageAlertFragment", "getImageInner: isWatermarkRemainingEnable " + r101 + " shareType " + r100);
        if (r101 == true) goto L15;
    L35:
        tt5.a.h("ScreenshotImageAlertFragment", "getImageInner: watermark not remaining or share to chat");
        ScreenshotImageAlertViewModel r106 = this.f237480i;
        if (r106 == null) goto L40;
        MutableLiveData<File> r107 = r106.getImageBitmap();
        if (r107 == null) goto L40;
        r103 = r107.getValue();
    L40:
        Single<File> r108 = Single.just(r103);
        Intrinsics.checkNotNull(r108);
        return r108;
    L15:
        if (r100 == ShareType.Lark) goto L35;
        ScreenshotImageAlertViewModel r109 = this.f237480i;
        if (r109 == null) goto L20;
        File r110 = r109.getWatermarkedImageBitmap();
    L21:
        if (r110 == null) goto L26;
        tt5.a.h("ScreenshotImageAlertFragment", "getImageInner: watermark remaining, has cached watermarked image");
        ScreenshotImageAlertViewModel r111 = this.f237480i;
        if (r111 == null) goto L25;
        r103 = r111.getWatermarkedImageBitmap();
    L25:
        Single<File> r112 = Single.just(r103);
        Intrinsics.checkNotNull(r112);
        return r112;
    L26:
        tt5.a.h("ScreenshotImageAlertFragment", "getImageInner: [watermark remaining] apply watermark");
        ScreenshotImageAlertViewModel r113 = this.f237480i;
        if (r113 == null) goto L31;
        MutableLiveData<File> r114 = r113.getImageBitmap();
        if (r114 == null) goto L31;
        r103 = r114.getValue();
    L31:
        if (r103 != null) goto L33;
        Single r115 = Single.error(new Throwable("[watermark remaining] getWatermarkedImage, originalFile is null"));
    L34:
        Single<File> r116 = r115.doOnSuccess(new b(this));
        Intrinsics.checkNotNull(r116);
        return r116;
    L33:
        VFSPath r117 = ay4.d.a().z(r103.getAbsolutePath());
        tt5.a.h(SheetImagePreviewPlugin.TAG, "[watermark remaining] originalFile=" + r103.getAbsolutePath());
        Lazy<zo5.b> r118 = CCMWatermarkManager.f220231a;
        String r119 = r117.getRealPath();
        Intrinsics.checkNotNullParameter(r119, "filePath");
        r115 = CCMWatermarkManager.f220231a.getValue().e(r119).map(sm5.a.f542574a);
        goto L34
    L20:
        r110 = null;
    L7:
        r105 = null;
        goto L9
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f237488q = (FrameLayout) r100.findViewById(R.id.screeenshot_root);
        this.f237481j = (TextView) r100.findViewById(R.id.image_alert_title);
        this.f237482k = (TextView) r100.findViewById(R.id.image_alert_message);
        TextView r102 = (TextView) r100.findViewById(R.id.image_alert_save);
        this.f237483l = r102;
        if (r102 == null) goto L5;
        r102.setOnClickListener(this);
    L5:
        TextView r103 = (TextView) r100.findViewById(R.id.image_alert_share);
        this.f237484m = r103;
        if (r103 == null) goto L8;
        r103.setOnClickListener(this);
    L8:
        ImageView r104 = (ImageView) r100.findViewById(R.id.image_alert_close);
        if (r104 == null) goto L11;
        r104.setOnClickListener(this);
    L11:
        this.f237485n = (FrameLayout) r100.findViewById(R.id.screenshot_image_container);
        this.f237487p = (BearLottieView) r100.findViewById(R.id.iv_screenshot_loading);
        this.f237486o = (SubsamplingScaleImageView) r100.findViewById(R.id.ssiv_screenshot_image);
        this.f237490s = (FrameLayout) r100.findViewById(R.id.external_share_view_container);
        this.f237489r = (ExternalShareView) r100.findViewById(R.id.image_alert_external_share_view);
        FrameLayout r105 = this.f237490s;
        if (r105 == null) goto L14;
        r105.setOnClickListener(this);
    L14:
        ExternalShareView r106 = this.f237489r;
        if (r106 == null) goto L17;
        r106.b(((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).getProvider().a(Z90()));
    L17:
        ExternalShareView r107 = this.f237489r;
        if (r107 == null) goto L20;
        r107.setOnShareItemClickListener(new g(this));
    L20:
        ca0();
        FrameLayout r108 = this.f237488q;
        if (r108 == null) goto L23;
        r108.post(new sm5.c(this));
    L23:
        ScreenshotImageAlertViewModel r109 = this.f237480i;
        if (r109 == null) goto L28;
        MutableLiveData<ImageAlertModel> r110 = r109.getImageAlertData();
        if (r110 == null) goto L28;
        r110.observe(this, new ScreenshotImageAlertFragment$initObservers$1(this));
    L28:
        ScreenshotImageAlertViewModel r111 = this.f237480i;
        if (r111 == null) goto L34;
        MutableLiveData<File> r112 = r111.getImageBitmap();
        if (r112 == null) goto L35;
        r112.observe(this, new ScreenshotImageAlertFragment$initObservers$2(this));
        return;
    L35:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        this.f237480i = (ScreenshotImageAlertViewModel) q.a(this, ScreenshotImageAlertViewModel.class);
        return r100.inflate(R.layout.sheet_screenshot_image_alert_fragment, r101, false);
    }
}
