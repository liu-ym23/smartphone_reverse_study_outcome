package com.ss.android.lark.search.doubao.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;
import com.ss.android.lark.widget.ptr.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y9c.d;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\bJ\u0010\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\u0012\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010*\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010+\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010,\u001a\u00020-H\u0016J,\u0010.\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/ss/android/lark/search/doubao/util/DoubaoSearchPtrFooter;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/lark/widget/ptr/LKUIPtrUIHandler;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mRotateAniTime", "mFlipAnimation", "Landroid/view/animation/RotateAnimation;", "mReverseFlipAnimation", "mRotateView", "Landroid/view/View;", "mLoadingContainer", "mLoadingImg", "Landroid/widget/ImageView;", "mLoadingTxt", "Landroid/widget/TextView;", "mLoadingDrawable", "Lcom/larksuite/component/universe_design/loading/UDLoadingDrawable;", "initViews", "", "onDetachedFromWindow", "setRotateAniTime", "time", "setLastUpdateTimeKey", "key", "", "setLastUpdateTimeRelateObject", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "", "buildAnimation", "resetView", "hideRotateView", "onUIReset", "frame", "Lcom/ss/android/lark/widget/ptr/LKUIPtrFrameLayout;", "onUIRefreshPrepare", "onUIRefreshBegin", "onUIRefreshComplete", "isHeader", "", "onUIPositionChange", "isUnderTouch", "status", "", "ptrIndicator", "Lcom/ss/android/lark/widget/ptr/indicator/LKUIPtrIndicator;", "search-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoSearchPtrFooter extends FrameLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f440111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RotateAnimation f440112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RotateAnimation f440113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f440114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f440115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f440116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UDLoadingDrawable f440117g;

    public DoubaoSearchPtrFooter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DoubaoSearchPtrFooter(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void f() {
        RotateAnimation r100 = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        r100.setInterpolator(new LinearInterpolator());
        r100.setDuration(this.f440111a);
        r100.setFillAfter(true);
        this.f440112b = r100;
        RotateAnimation r101 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        r101.setInterpolator(new LinearInterpolator());
        r101.setDuration(this.f440111a);
        r101.setFillAfter(true);
        this.f440113c = r101;
    }

    public final void g() {
        View r100 = this.f440114d;
        View r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRotateView");
        r100 = null;
    L5:
        r100.clearAnimation();
        View r102 = this.f440114d;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRotateView");
    L9:
        r101.setVisibility(4);
        return;
    L8:
        r101 = r102;
        goto L9
    }

    public final void h() {
        g();
        View r100 = this.f440115e;
        UDLoadingDrawable r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingContainer");
        r100 = null;
    L5:
        r100.setVisibility(4);
        UDLoadingDrawable r102 = this.f440117g;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingDrawable");
    L9:
        r101.stop();
        return;
    L8:
        r101 = r102;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        UDLoadingDrawable r100 = this.f440117g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingDrawable");
        r100 = null;
    L5:
        r100.stop();
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void b(LKUIPtrFrameLayout r100) {
        h();
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void d(LKUIPtrFrameLayout r100) {
        View r101 = this.f440115e;
        View r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingContainer");
        r101 = null;
    L5:
        r101.setVisibility(4);
        View r103 = this.f440114d;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRotateView");
    L9:
        r102.setVisibility(0);
        return;
    L8:
        r102 = r103;
        goto L9
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void e(LKUIPtrFrameLayout r100) {
        g();
        View r101 = this.f440115e;
        UDLoadingDrawable r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingContainer");
        r101 = null;
    L5:
        r101.setVisibility(0);
        UDLoadingDrawable r103 = this.f440117g;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingDrawable");
        r103 = null;
    L8:
        r103.stop();
        UDLoadingDrawable r104 = this.f440117g;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingDrawable");
    L12:
        r102.start();
        return;
    L11:
        r102 = r104;
        goto L12
    }

    public final void setLastUpdateTimeKey(String r100) {
        TextUtils.isEmpty(r100);
    }

    public final void setLastUpdateTimeRelateObject(Object r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        setLastUpdateTimeKey(r100.getClass().getName().concat(ContainerPosition.FOOTER));
    }

    public final void setRotateAniTime(int r100) {
        if (r100 == this.f440111a) goto L8;
        if (r100 == 0) goto L9;
        this.f440111a = r100;
        f();
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void a(LKUIPtrFrameLayout r100, boolean r101) {
        if (r101 == false) goto L4;
        return;
    L4:
        g();
        View r102 = this.f440115e;
        UDLoadingDrawable r103 = null;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingContainer");
        r102 = null;
    L7:
        r102.setVisibility(4);
        UDLoadingDrawable r104 = this.f440117g;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingDrawable");
    L11:
        r103.stop();
        return;
    L10:
        r103 = r104;
        goto L11
    }

    public DoubaoSearchPtrFooter(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f440111a = 150;
        f();
        LayoutInflater.from(getContext()).inflate(R.layout.doubao_search_ptr_footer_with_text, this, true);
        this.f440114d = findViewById(R.id.ptr_classic_header_rotate_view);
        this.f440115e = findViewById(R.id.ptr_footer_loading_container);
        this.f440116f = (ImageView) findViewById(R.id.ptr_footer_loading_img);
        TextView r103 = (TextView) findViewById(R.id.ptr_footer_loading_txt);
        UDLoadingDrawable r104 = new UDLoadingDrawable(getContext());
        r104.setColorSchemeColors(new int[]{d.c(getContext(), R.color.primary_fill_default)});
        this.f440117g = r104;
        ImageView r105 = this.f440116f;
        UDLoadingDrawable r106 = null;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingImg");
        r105 = null;
    L5:
        UDLoadingDrawable r107 = this.f440117g;
        if (r107 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingDrawable");
    L9:
        r105.setImageDrawable(r106);
        h();
        return;
    L8:
        r106 = r107;
        goto L9
    }

    public /* synthetic */ DoubaoSearchPtrFooter(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void c(LKUIPtrFrameLayout r100, boolean r101, byte r110, wdc.a r111) {
        boolean r102 = false;
        if (r100 == null) goto L5;
        int r103 = r100.getOffsetToRefresh();
    L6:
        if (r111 == null) goto L8;
        int r104 = r111.f559318e;
    L9:
        if (r111 == null) goto L11;
        int r112 = r111.f559319f;
    L13:
        if ((r104 + 1) > r103) goto L16;
        if (r103 > r112) goto L16;
        boolean r105 = true;
    L17:
        RotateAnimation r106 = null;
        if (r105 == false) goto L32;
        if (r101 == false) goto L50;
        if (r110 != 2) goto L51;
        View r107 = this.f440114d;
        if (r107 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mRotateView");
        r107 = null;
    L24:
        r107.clearAnimation();
        View r108 = this.f440114d;
        if (r108 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mRotateView");
        r108 = null;
    L27:
        RotateAnimation r109 = this.f440113c;
        if (r109 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mReverseFlipAnimation");
    L31:
        r108.startAnimation(r106);
        return;
    L30:
        r106 = r109;
        goto L31
    L51:
        return;
    L50:
        return;
    L32:
        if (r112 > r103) goto L35;
        if (r103 >= r104) goto L35;
        r102 = true;
    L35:
        if (r102 == false) goto L53;
        if (r101 == false) goto L54;
        if (r110 != 2) goto L55;
        View r113 = this.f440114d;
        if (r113 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mRotateView");
        r113 = null;
    L41:
        r113.clearAnimation();
        View r114 = this.f440114d;
        if (r114 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mRotateView");
        r114 = null;
    L44:
        RotateAnimation r115 = this.f440112b;
        if (r115 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mFlipAnimation");
    L48:
        r114.startAnimation(r106);
        return;
    L47:
        r106 = r115;
        goto L48
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L16:
        r105 = false;
        goto L17
    L11:
        r112 = 0;
        goto L13
    L8:
        r104 = 0;
        goto L9
    L5:
        r103 = 0;
        goto L6
    }
}
