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
import com.bytedance.ee.bear.sheet.exportimage.exportshare.ExportShareModel;
import com.bytedance.ee.bear.sheet.exportimage.preview.SheetImagePreviewPlugin;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.lark.android.encryption.CipherManager;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 T2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001TB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010/\u001a\u00020-H\u0016J\b\u00100\u001a\u00020-H\u0002J\u0010\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020#H\u0002J\b\u00103\u001a\u00020-H\u0002J\u000e\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0002J\b\u00107\u001a\u000208H\u0002J\u0012\u00109\u001a\u00020:2\b\b\u0001\u0010;\u001a\u00020\u001eH\u0002J\b\u0010<\u001a\u00020-H\u0002J\b\u0010=\u001a\u00020-H\u0002J\b\u0010>\u001a\u00020-H\u0002J\u0010\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020AH\u0002J\u0012\u0010B\u001a\u00020-2\b\u0010C\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u00020FH\u0003J\u0010\u0010G\u001a\u00020-2\u0006\u0010H\u001a\u000206H\u0003J\u0018\u0010I\u001a\u00020-2\u0006\u0010H\u001a\u0002062\u0006\u0010J\u001a\u00020AH\u0002J\b\u0010K\u001a\u00020-H\u0002J\b\u0010L\u001a\u00020-H\u0003J\u001e\u0010M\u001a\b\u0012\u0004\u0012\u00020A0N2\u0006\u0010E\u001a\u00020F2\u0006\u0010O\u001a\u00020:H\u0002J\u0018\u0010P\u001a\b\u0012\u0004\u0012\u00020A0N2\b\u0010Q\u001a\u0004\u0018\u00010AH\u0002J\b\u0010R\u001a\u00020-H\u0016J\u0006\u0010S\u001a\u00020:R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/bytedance/ee/bear/sheet/exportimage/alert/ScreenshotImageAlertFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/ee/bear/share/export/ISharePanel;", "<init>", "()V", "panelSession", "", "getPanelSession", "()Ljava/lang/String;", "viewModel", "Lcom/bytedance/ee/bear/sheet/exportimage/alert/ScreenshotImageAlertViewModel;", "titleTv", "Landroid/widget/TextView;", "messageTv", "saveTv", "shareTv", "closeIv", "Landroid/widget/ImageView;", "screenshotImageContainer", "Landroid/widget/FrameLayout;", "screenshotImageIv", "Lcom/davemorrissey/labs/subscaleview/SubsamplingScaleImageView;", "loadingView", "Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "screenshtRoot", "externalShareView", "Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareView;", "externalShareViewContainer", "imageWidth", "", "imageHeight", "minScale", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onViewCreated", "", "view", "onStart", "initObservers", "initViews", "root", "updateExternalConfig", "getShareItems", "", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareItemModel;", "buildShareItemModelParams", "Lcom/bytedance/ee/bear/share/externalshare/DocumentShareItemModelParams;", "canPassCipher", "", "toastTextResId", "showExternalView", "hideExternalView", "startLoading", "endLoadingStatus", ExportShareModel.EXPORT_SHARE_TYPE_IMAGE, "Ljava/io/File;", SendEventContainerMethodParamModel.EventKinds.onClick, "v", "shareToExternalApp", "shareType", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareType;", "handleCustomShare", "shareItem", "doShareImageToCustom", "imageFile", "onShare", "onSave", "getImageInner", "Lio/reactivex/Single;", "isWatermarkRemainingEnable", "getWatermarkedImage", "originalFile", "onDestroyView", "onBackPressed", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenshotImageAlertFragment extends BaseAntiScreenshotsDialogFragment implements View.OnClickListener, i {
    public static final /* synthetic */ int w = 0;
    public final String h;
    public ScreenshotImageAlertViewModel i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public FrameLayout n;
    public SubsamplingScaleImageView o;
    public BearLottieView p;
    public FrameLayout q;
    public ExternalShareView r;
    public FrameLayout s;
    public int t;
    public int u;
    public float v;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ScreenshotImageAlertFragment a;

        public b(ScreenshotImageAlertFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            File r4 = (File) r3;
            int r0 = ScreenshotImageAlertFragment.w;
            StringBuilder r1 = new StringBuilder("getImageInner: [watermark remaining] generated file=");
            if (r4 == null) goto L5;
            String r2 = r4.getAbsolutePath();
        L6:
            r1.append(r2);
            tt5.a.h("ScreenshotImageAlertFragment", r1.toString());
            ScreenshotImageAlertViewModel r5 = this.a.i;
            if (r5 == null) goto L10;
            r5.setWatermarkedImageBitmap(r4);
            return;
        L10:
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class c implements DialogInterface.OnKeyListener {
        public final /* synthetic */ ScreenshotImageAlertFragment a;

        public c(ScreenshotImageAlertFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r3, int r4, KeyEvent r5) {
            boolean r6 = false;
            if (r4 == 4) goto L6;
            return false;
        L6:
            if (r4 != 4) goto L23;
            if (r5 != null) goto L9;
        L11:
            boolean r7 = false;
        L12:
            if (r7 == false) goto L23;
            ScreenshotImageAlertFragment r8 = this.a;
            FrameLayout r9 = r8.s;
            if (r9 != null) goto L16;
        L18:
            if (r6 == false) goto L20;
            r8.ca0();
            goto L23
        L20:
            ScreenshotImageAlertViewModel r10 = r8.i;
            if (r10 == null) goto L23;
            r10.close();
            goto L23
        L16:
            if (r9.getVisibility() != 0) goto L18;
            r6 = true;
            goto L18
        L9:
            if (r5.getAction() != 1) goto L11;
            r7 = true;
        L23:
            return true;
        }
    }

    public static final class d implements Action {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void run() {
            Toast.cancelLoading();
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ScreenshotImageAlertFragment a;
        public final /* synthetic */ ShareType b;

        public e(ScreenshotImageAlertFragment r1, ShareType r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Context r0 = this.a.getContext();
            ShareType r1 = this.b;
            o.c(r0, r1, (File) r3);
            ScreenshotImageAlertViewModel r4 = this.a.i;
            if (r4 == null) goto L6;
            r4.onShareSuccess(this.b);
            return;
        }
    }

    static {
    }

    public final km5.a Z90() {
        return new km5.a(0, 3, null, false, false, null, CollectionsKt.arrayListOf(new Integer[]{Integer.valueOf(ShareType.Download.ordinal())}), null, false, false, false, false, null, null, false, false, ShareScene.EXPORT_IMAGE, 49152);
    }

    public final void ca0() {
        FrameLayout r0 = this.s;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        ExternalShareView r1 = this.r;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).H9(this, SharePanelState.NOT_SHOW, Z90());
    }

    public ScreenshotImageAlertFragment() {
        this.h = String.valueOf(hashCode());
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        BearLottieView r0 = this.p;
        if (r0 == null) goto L5;
        r0.cancelAnimation();
    L5:
        ExternalShareView r1 = this.r;
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L14;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).H9(this, SharePanelState.NOT_SHOW, Z90());
    L14:
        FrameLayout r3 = this.q;
        if (r3 == null) goto L18;
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).detachWatermark(r3);
        return;
    L18:
        return;
    L8:
        if (r1.getVisibility() != 0) goto L10;
        r2 = true;
        goto L12
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L5;
        Window r1 = r0.getWindow();
    L7:
        if (r1 == null) goto L9;
        WindowManager.LayoutParams r3 = r1.getAttributes();
        r3.dimAmount = 0.4f;
        r3.width = -1;
        r3.gravity = 80;
        r3.height = -1;
        r3.windowAnimations = 0;
        r1.setAttributes(r3);
        r1.setBackgroundDrawable(new ColorDrawable(0));
        r0.setOnKeyListener(new c(this));
    L9:
        setCancelable(false);
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.share.export.i
    public final String getPanelSession() {
        return this.h;
    }

    public final boolean aa0(int r3) {
        if (CipherManager.d() != 1) goto L9;
        Context r0 = getContext();
        if (r0 == null) goto L10;
        Toast.showText(r0, r0.getString(r3), 1);
        CipherManager.h();
        return false;
    L10:
        return false;
    L9:
        return true;
    }

    public final void da0(ShareType r5) {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.h("admin.watermark.filewatermark.remaining");
        CharSequence r1 = null;
        if (r0 == true) goto L5;
    L11:
        Context r2 = getContext();
        Context r3 = getContext();
        if (r3 == null) goto L14;
        r1 = r3.getText(2131888211);
    L14:
        Toast.showLoading(r2, r1);
    L15:
        ba0(r5, r0).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).doFinally(d.a).subscribe(new e(this, r5));
        return;
    L5:
        if (r5 == ShareType.Lark) goto L15;
        ScreenshotImageAlertViewModel r4 = this.i;
        if (r4 == null) goto L9;
        File r6 = r4.getWatermarkedImageBitmap();
    L10:
        if (r6 != null) goto L15;
    L9:
        r6 = null;
        goto L10
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (r4 == null) goto L49;
        int r5 = r4.getId();
        CharSequence r1 = null;
        if (r5 != 2131374953) goto L24;
        ScreenshotImageAlertViewModel r6 = this.i;
        if (r6 == null) goto L9;
        r6.onClickSaveBtn();
    L9:
        if (aa0(2131887290) == false) goto L57;
        boolean r7 = com.bytedance.ee.bear.appsetting.c.a.a.h("admin.watermark.filewatermark.remaining");
        if (r7 == false) goto L18;
        ScreenshotImageAlertViewModel r0 = this.i;
        if (r0 == null) goto L16;
        File r2 = r0.getWatermarkedImageBitmap();
    L17:
        if (r2 == null) goto L18;
    L22:
        ba0(ShareType.Download, r7).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).doFinally(sm5.d.a).subscribe(new f(this));
        return;
    L16:
        r2 = null;
    L18:
        Context r3 = getContext();
        Context r8 = getContext();
        if (r8 == null) goto L21;
        r1 = r8.getText(2131888211);
    L21:
        Toast.showLoading(r3, r1);
        goto L22
    L57:
        return;
    L24:
        if (r5 != 2131374954) goto L41;
        if (CipherManager.d() != 1) goto L30;
        Context r9 = getContext();
        if (r9 == null) goto L51;
        Toast.showText(r9, r9.getString(2131887299), 1);
        CipherManager.h();
        return;
    L51:
        return;
    L30:
        ScreenshotImageAlertViewModel r10 = this.i;
        if (r10 == null) goto L33;
        r10.onClickShareBtn();
    L33:
        FrameLayout r11 = this.s;
        if (r11 == null) goto L36;
        r11.setVisibility(0);
    L36:
        ExternalShareView r12 = this.r;
        if (r12 == null) goto L39;
        r12.setVisibility(0);
    L39:
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).H9(this, SharePanelState.SHOWING, Z90());
        return;
    L41:
        if (r5 != 2131374949) goto L46;
        ScreenshotImageAlertViewModel r13 = this.i;
        if (r13 == null) goto L54;
        r13.close();
        return;
    L54:
        return;
    L46:
        if (r5 != 2131372010) goto L56;
        ca0();
        return;
    L56:
        return;
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Context r0 = getContext();
        Intrinsics.checkNotNull(r0);
        return new Dialog(r0, 2131953403);
    }

    public final Single<File> ba0(ShareType r5, boolean r6) {
        ScreenshotImageAlertViewModel r0 = this.i;
        File r1 = null;
        if (r0 == null) goto L7;
        MutableLiveData<File> r2 = r0.getImageBitmap();
        if (r2 == null) goto L7;
        File r3 = (File) r2.getValue();
    L9:
        if (r3 != null) goto L12;
        tt5.a.d("ScreenshotImageAlertFragment", "getImageInner: imageBitmap is null");
        return Single.error(new Throwable("[watermark remaining] getImageInner, imageBitmap is null"));
    L12:
        tt5.a.h("ScreenshotImageAlertFragment", "getImageInner: isWatermarkRemainingEnable " + r6 + " shareType " + r5);
        if (r6 == true) goto L15;
    L35:
        tt5.a.h("ScreenshotImageAlertFragment", "getImageInner: watermark not remaining or share to chat");
        ScreenshotImageAlertViewModel r7 = this.i;
        if (r7 == null) goto L40;
        MutableLiveData<File> r8 = r7.getImageBitmap();
        if (r8 == null) goto L40;
        r1 = (File) r8.getValue();
    L40:
        Single<File> r9 = Single.just(r1);
        Intrinsics.checkNotNull(r9);
        return r9;
    L15:
        if (r5 == ShareType.Lark) goto L35;
        ScreenshotImageAlertViewModel r10 = this.i;
        if (r10 == null) goto L20;
        File r11 = r10.getWatermarkedImageBitmap();
    L21:
        if (r11 == null) goto L26;
        tt5.a.h("ScreenshotImageAlertFragment", "getImageInner: watermark remaining, has cached watermarked image");
        ScreenshotImageAlertViewModel r12 = this.i;
        if (r12 == null) goto L25;
        r1 = r12.getWatermarkedImageBitmap();
    L25:
        Single<File> r13 = Single.just(r1);
        Intrinsics.checkNotNull(r13);
        return r13;
    L26:
        tt5.a.h("ScreenshotImageAlertFragment", "getImageInner: [watermark remaining] apply watermark");
        ScreenshotImageAlertViewModel r14 = this.i;
        if (r14 == null) goto L31;
        MutableLiveData<File> r15 = r14.getImageBitmap();
        if (r15 == null) goto L31;
        r1 = (File) r15.getValue();
    L31:
        if (r1 != null) goto L33;
        Single r16 = Single.error(new Throwable("[watermark remaining] getWatermarkedImage, originalFile is null"));
    L34:
        Single<File> r17 = r16.doOnSuccess(new b(this));
        Intrinsics.checkNotNull(r17);
        return r17;
    L33:
        VFSPath r18 = ay4.d.a().z(r1.getAbsolutePath());
        tt5.a.h(SheetImagePreviewPlugin.TAG, "[watermark remaining] originalFile=" + r1.getAbsolutePath());
        Lazy r19 = CCMWatermarkManager.a;
        String r20 = r18.getRealPath();
        Intrinsics.checkNotNullParameter(r20, "filePath");
        r16 = ((zo5.b) CCMWatermarkManager.a.getValue()).e(r20).map(sm5.a.a);
        goto L34
    L20:
        r11 = null;
    L7:
        r3 = null;
        goto L9
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r3, r4);
        this.q = (FrameLayout) r3.findViewById(2131385181);
        this.j = (TextView) r3.findViewById(2131374955);
        this.k = (TextView) r3.findViewById(2131374952);
        TextView r5 = (TextView) r3.findViewById(2131374953);
        this.l = r5;
        if (r5 == null) goto L5;
        r5.setOnClickListener(this);
    L5:
        TextView r6 = (TextView) r3.findViewById(2131374954);
        this.m = r6;
        if (r6 == null) goto L8;
        r6.setOnClickListener(this);
    L8:
        ImageView r7 = (ImageView) r3.findViewById(2131374949);
        if (r7 == null) goto L11;
        r7.setOnClickListener(this);
    L11:
        this.n = (FrameLayout) r3.findViewById(2131385209);
        this.p = r3.findViewById(2131376579);
        this.o = r3.findViewById(2131387147);
        this.s = (FrameLayout) r3.findViewById(2131372010);
        this.r = r3.findViewById(2131374951);
        FrameLayout r8 = this.s;
        if (r8 == null) goto L14;
        r8.setOnClickListener(this);
    L14:
        ExternalShareView r9 = this.r;
        if (r9 == null) goto L17;
        r9.b(((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).getProvider().a(Z90()));
    L17:
        ExternalShareView r10 = this.r;
        if (r10 == null) goto L20;
        r10.setOnShareItemClickListener(new g(this));
    L20:
        ca0();
        FrameLayout r11 = this.q;
        if (r11 == null) goto L23;
        r11.post(new sm5.c(this));
    L23:
        ScreenshotImageAlertViewModel r12 = this.i;
        if (r12 == null) goto L28;
        MutableLiveData<ImageAlertModel> r13 = r12.getImageAlertData();
        if (r13 == null) goto L28;
        r13.observe(this, new ScreenshotImageAlertFragment$initObservers$1(this));
    L28:
        ScreenshotImageAlertViewModel r14 = this.i;
        if (r14 == null) goto L34;
        MutableLiveData<File> r15 = r14.getImageBitmap();
        if (r15 == null) goto L35;
        r15.observe(this, new ScreenshotImageAlertFragment$initObservers$2(this));
        return;
    L35:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        this.i = (ScreenshotImageAlertViewModel) q.a(this, ScreenshotImageAlertViewModel.class);
        return r2.inflate(2131564579, r3, false);
    }
}
