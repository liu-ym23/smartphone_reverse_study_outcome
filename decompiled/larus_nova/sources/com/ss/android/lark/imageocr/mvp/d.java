package com.ss.android.lark.imageocr.mvp;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.NetworkUtils;
import com.larus.nova.R;
import com.ss.android.lark.imageocr.ImageOCRKit;
import com.ss.android.lark.imageocr.view.OCRBottomView;
import com.ss.android.lark.imageocr.view.OCRPickTextLayout;
import com.ss.android.lark.imageocr.view.OCRScanView;
import com.ss.android.lark.imageocr.view.OCRTipView;
import com.ss.android.lark.imageocr_export.OCRParams;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.pan.ImageOCRResponse;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements IView<com.ss.android.lark.imageocr.mvp.a>, OCRBottomView.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f426469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OCRParams f426470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f426471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f426472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LargeImageView f426473e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final OCRBottomView f426474f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OCRScanView f426475g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OCRTipView f426476h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OCRPickTextLayout f426477i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageOCRResponse f426478j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<ilb.b> f426479k;

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        this.f426471c.setVisibility(4);
        LargeImageView r100 = this.f426473e;
        VFSPath r101 = VFSFiles.f444819b.z(this.f426470b.getLocalImagePath());
        nlb.g r102 = new nlb.g();
        r102.f519575a = r101;
        r100.o(r102);
        this.f426473e.setLoadPreviewListener(new e(this));
        this.f426472d.setOnClickListener(new f(this));
        this.f426474f.setItemListener(this);
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        Log.i("ImageOCRView", MapMonitorConst.EVENT_DESTROY);
        this.f426475g.b();
        LargeImageView r100 = this.f426473e;
        SubsamplingScaleImageView r101 = r100.f426675b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getVisibility() != 0) goto L9;
        SubsamplingScaleImageView r102 = r100.f426675b;
        r102.G(true);
        r102.G1 = null;
        r102.H1 = null;
        r102.L1 = null;
        r102.M1 = null;
        return;
    }

    @Override // com.ss.android.lark.imageocr.view.OCRBottomView.c
    public final void h(int r110) {
        Log.i("ImageOCRView", "onBottomItemClick, clickId" + r110);
        ImageOCRResponse r111 = null;
        switch(r110) {
            case 1: goto L53;
            case 2: goto L45;
            case 3: goto L34;
            case 4: goto L24;
            case 5: goto L16;
            case 6: goto L5;
            default: goto L71;
        };
    L5:
        com.ss.android.lark.imageocr.utils.a.a("select_accurate_character", true, "public_select_accurate_character_view");
        int r112 = klb.d.f504031a;
        ArrayList<ilb.b> r113 = this.f426479k;
        if (r113 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("allLines");
        r113 = null;
    L8:
        ImageOCRResponse r100 = this.f426478j;
        if (r100 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("response");
        r100 = null;
    L11:
        SpannableStringBuilder r114 = klb.d.b(r113, r100, false);
        Activity r101 = this.f426469a;
        ImageOCRResponse r102 = this.f426478j;
        if (r102 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("response");
    L15:
        klb.d.a(r101, r114, r111);
        this.f426477i.h(r114);
        return;
    L14:
        r111 = r102;
        goto L15
    L16:
        com.ss.android.lark.imageocr.utils.a.a("forward", true, "public_multi_select_share_view");
        int r115 = klb.d.f504031a;
        ArrayList<ilb.b> r116 = this.f426479k;
        if (r116 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("allLines");
        r116 = null;
    L19:
        ImageOCRResponse r103 = this.f426478j;
        if (r103 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("response");
    L23:
        SpannableStringBuilder r117 = klb.d.b(r116, r111, false);
        llb.a r104 = ImageOCRKit.a();
        r117.toString();
        r104.c();
        return;
    L22:
        r111 = r103;
        goto L23
    L24:
        com.ss.android.lark.imageocr.utils.a.a("copy", true, "none");
        int r118 = klb.d.f504031a;
        ArrayList<ilb.b> r119 = this.f426479k;
        if (r119 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("allLines");
        r119 = null;
    L27:
        ImageOCRResponse r105 = this.f426478j;
        if (r105 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("response");
    L32:
        if (com.ss.android.lark.imageocr.utils.b.b(this.f426469a, klb.d.b(r119, r111, false)) == false) goto L66;
        UDToast.show(this.f426469a, R.string.Lark_IM_ImageToText_Copied_Toast);
        return;
    L66:
        return;
    L30:
        r111 = r105;
        goto L32
    L34:
        com.ss.android.lark.imageocr.utils.a.a("select_accurate_character", false, "public_select_accurate_character_view");
        int r120 = klb.d.f504031a;
        ArrayList<ilb.b> r121 = this.f426479k;
        if (r121 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("allLines");
        r121 = null;
    L37:
        ImageOCRResponse r106 = this.f426478j;
        if (r106 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("response");
        r106 = null;
    L40:
        SpannableStringBuilder r122 = klb.d.b(r121, r106, true);
        Activity r107 = this.f426469a;
        ImageOCRResponse r108 = this.f426478j;
        if (r108 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("response");
    L44:
        klb.d.a(r107, r122, r111);
        this.f426477i.h(r122);
        return;
    L43:
        r111 = r108;
        goto L44
    L45:
        com.ss.android.lark.imageocr.utils.a.a("forward", false, "public_multi_select_share_view");
        int r123 = klb.d.f504031a;
        ArrayList<ilb.b> r124 = this.f426479k;
        if (r124 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("allLines");
        r124 = null;
    L48:
        ImageOCRResponse r109 = this.f426478j;
        if (r109 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("response");
    L52:
        SpannableStringBuilder r125 = klb.d.b(r124, r111, true);
        llb.a r126 = ImageOCRKit.a();
        r125.toString();
        r126.c();
        return;
    L51:
        r111 = r109;
        goto L52
    L53:
        com.ss.android.lark.imageocr.utils.a.a("copy", false, "none");
        int r127 = klb.d.f504031a;
        ArrayList<ilb.b> r128 = this.f426479k;
        if (r128 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("allLines");
        r128 = null;
    L56:
        ImageOCRResponse r129 = this.f426478j;
        if (r129 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("response");
    L61:
        if (com.ss.android.lark.imageocr.utils.b.b(this.f426469a, klb.d.b(r128, r111, true)) == false) goto L70;
        UDToast.show(this.f426469a, R.string.Lark_IM_ImageToText_Copied_Toast);
        return;
    L70:
        return;
    L59:
        r111 = r129;
        goto L61
    }

    public final void k(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        Log.i("ImageOCRView", "onOCRError:" + r100);
        if (r100.getErrorCode() != (-10000)) goto L6;
        UDToast.show(this.f426469a, R.string.Lark_IM_ImageToText_NoTextFound_Text);
    L9:
        this.f426475g.b();
        this.f426469a.finish();
        return;
    L6:
        if (NetworkUtils.d(this.f426469a) == false) goto L8;
        UDToast.show(this.f426469a, R.string.Lark_IM_ImageToText_FailedToExtractText_Toast);
        goto L9
    L8:
        UDToast.show(this.f426469a, R.string.Lark_Legacy_NetworkError);
        goto L9
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        Intrinsics.checkNotNullParameter((com.ss.android.lark.imageocr.mvp.a) r100, "viewDelegate");
    }

    public d(FragmentActivity r100, OCRParams r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "param");
        this.f426469a = r100;
        this.f426470b = r101;
        this.f426471c = r100.findViewById(R.id.image_ocr_layout);
        this.f426472d = (ImageView) r100.findViewById(R.id.image_ocr_close);
        this.f426473e = (LargeImageView) r100.findViewById(R.id.image_ocr_large_image);
        this.f426474f = (OCRBottomView) r100.findViewById(R.id.image_ocr_bottom_view);
        this.f426475g = (OCRScanView) r100.findViewById(R.id.image_ocr_scan_view);
        this.f426476h = (OCRTipView) r100.findViewById(R.id.image_ocr_tip_view);
        this.f426477i = (OCRPickTextLayout) r100.findViewById(R.id.image_ocr_pick_layout);
    }
}
