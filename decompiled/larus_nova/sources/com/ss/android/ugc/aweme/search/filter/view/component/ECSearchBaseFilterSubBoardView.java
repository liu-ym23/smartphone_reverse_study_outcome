package com.ss.android.ugc.aweme.search.filter.view.component;

import android.animation.Animator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Looper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.lighten.loader.SmartImageView;
import com.ss.android.ugc.aweme.discover.model.commodity.select.IconStruct;
import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderItem;
import com.ss.android.ugc.aweme.discover.model.commodity.select.StyleItem;
import com.ss.android.ugc.aweme.search.common.utils.StringExtKt;
import com.ss.android.ugc.aweme.search.filter.ECSearchBaseFilterViewHolder;
import com.ss.android.ugc.aweme.search.filter.ECSearchFilterBoard;
import com.ss.android.ugc.aweme.search.filter.ECSearchFilterViewModel;
import com.ss.android.ugc.aweme.search.filter.IFilterAbility;
import com.ss.android.ugc.aweme.search.filter.view.good.ECSearchFilterCornerBg;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/component/ECSearchBaseFilterSubBoardView;", "Lcom/ss/android/ugc/aweme/search/filter/view/component/FilterTextView;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECSearchBaseFilterSubBoardView extends FilterTextView {
    public boolean A;

    @Override // com.ss.android.ugc.aweme.search.filter.view.component.FilterTextView
    public final void B() {
    }

    public abstract View H();

    public void J() {
    }

    public void K() {
    }

    public void L() {
    }

    public boolean N() {
        return false;
    }

    public float I() {
        ECSearchFilterViewModel r100 = this.f452777e;
        if (r100 == null) goto L28;
        IFilterAbility r101 = r100.getFilterContainer();
        if (r101 == null) goto L30;
        View r102 = r101.getContainerView();
        if (r102 == null) goto L31;
        int[] r103 = {0, 0};
        r102.getLocationOnScreen(r103);
        ECSearchFilterViewModel r104 = this.f452777e;
        if (r104 == null) goto L16;
        IFilterAbility r105 = r104.getFilterContainer();
        if (r105 == null) goto L16;
        Integer r106 = r105.a(r102);
        if (r106 == null) goto L16;
        int r107 = r106.intValue();
    L17:
        View r108 = C(this.f452782j);
        if (r108 != null) goto L21;
        r108 = this.f452782j;
    L21:
        r108.getLocationOnScreen(r103);
        int r109 = r103[1];
        ECSearchFilterViewModel r110 = this.f452777e;
        if (r110 == null) goto L27;
        IFilterAbility r111 = r110.getFilterContainer();
        if (r111 == null) goto L27;
        r111.i();
    L27:
        return ((r109 + r108.getHeight()) - r107) + 0;
    L16:
        r107 = r103[1];
        goto L17
    L31:
        return 0.0f;
    L30:
        return 0.0f;
    L28:
        return 0.0f;
    }

    @Override // com.ss.android.ugc.aweme.search.filter.view.component.ECSearchBaseSearchFilterViewHolder, com.ss.android.ugc.aweme.search.filter.ECSearchBaseFilterViewHolder
    public void o() {
        super.o();
        this.A = false;
    }

    public void M(RenderItem r100) {
        Intrinsics.checkNotNullParameter(r100, "renderItem");
        if (this.A == false) goto L64;
        TextView r101 = this.f453052x;
        if (r101 == null) goto L7;
        r101.setTypeface(Typeface.DEFAULT_BOLD);
    L7:
        IconStruct r102 = null;
        if (Intrinsics.areEqual(r100.getGradualChangeEnable(), Boolean.TRUE) == false) goto L34;
        TextView r103 = this.f453052x;
        if (r103 == null) goto L14;
        ColorStateList r104 = r103.getTextColors();
        if (r104 == null) goto L14;
        Integer r105 = Integer.valueOf(r104.getDefaultColor());
    L15:
        if (r105 == null) goto L34;
        StyleItem r106 = r100.getStyleItem();
        if (r106 == null) goto L34;
        String r107 = r106.getSelectingTextColor();
        if (r107 == null) goto L34;
        if (StringExtKt.a(r107) != true) goto L34;
        ColorStateList r108 = this.f453052x.getTextColors();
        if (r108 == null) goto L25;
        Integer r109 = Integer.valueOf(r108.getDefaultColor());
    L62:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L32
        StyleItem r111 = r100.getStyleItem();     // Catch: Throwable -> L32
        if (r111 == null) goto L29;
        String r112 = r111.getSelectingTextColor();     // Catch: Throwable -> L32
    L30:
        F(r109, Integer.valueOf(Color.parseColor(r112)));     // Catch: Throwable -> L32
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L41:
        SmartImageView r113 = this.f453049u;
        if (r113 == null) goto L48;
        StyleItem r114 = r100.getStyleItem();
        if (r114 == null) goto L46;
        IconStruct r115 = r114.getSelectingHeadIcon();
    L47:
        ECSearchBaseFilterViewHolder.r(r113, r115);
        goto L48
    L46:
        r115 = null;
    L48:
        SmartImageView r116 = this.f453050v;
        if (r116 == null) goto L55;
        StyleItem r117 = r100.getStyleItem();
        if (r117 == null) goto L53;
        IconStruct r118 = r117.getSelectingTailIcon();
    L54:
        ECSearchBaseFilterViewHolder.r(r116, r118);
        goto L55
    L53:
        r118 = null;
    L55:
        SmartImageView r119 = this.f453051w;
        if (r119 == null) goto L65;
        StyleItem r120 = r100.getStyleItem();
        if (r120 == null) goto L60;
        r102 = r120.getSelectingComponentImage();
    L60:
        ECSearchBaseFilterViewHolder.r(r119, r102);
        return;
    L65:
        return;
    L29:
        r112 = null;
    L32:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L41
    L25:
        r109 = null;
    L14:
        r105 = null;
    L34:
        TextView r122 = this.f453052x;
        if (r122 == null) goto L41;
        StyleItem r123 = r100.getStyleItem();
        if (r123 == null) goto L39;
        String r124 = r123.getSelectingTextColor();
    L40:
        ECSearchBaseFilterViewHolder.u(this, r122, r124);
        goto L41
    L39:
        r124 = null;
        goto L40
    }

    @Override // com.ss.android.ugc.aweme.search.filter.view.component.FilterTextView, com.ss.android.ugc.aweme.search.filter.view.component.ECSearchBaseSearchFilterViewHolder, com.ss.android.ugc.aweme.search.filter.ECSearchBaseFilterViewHolder, android.view.View.OnClickListener
    public void onClick(View r100) {
        Animator r101 = this.f452780h;
        if (r101 != null) goto L5;
    L14:
        ECSearchFilterViewModel r102 = this.f452777e;
        if (r102 == null) goto L29;
        ECSearchFilterBoard r103 = r102.getFilterBoard();
        if (r103 == null) goto L29;
        if (r103.getVisibility() != 0) goto L21;
        boolean r104 = true;
    L22:
        if (r104 != true) goto L29;
        boolean r105 = this.A;
        ECSearchFilterViewModel r106 = this.f452777e;
        if (r106 == null) goto L26;
        r106.hideFilterBoard(!r105);
    L26:
        if (r105 == false) goto L29;
        this.A = false;
        h(false);
        return;
    L21:
        r104 = false;
    L29:
        boolean r107 = N();
        this.A = true;
        RenderItem r108 = this.f450505a;
        if (r108 == null) goto L32;
        f(r108);
    L32:
        O(r100, r107);
        return;
    L5:
        if (Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread()) == true) goto L7;
    L9:
        boolean r109 = false;
    L10:
        if (r109 == false) goto L14;
        if (r101.isRunning() == false) goto L14;
        r101.end();
        goto L14
    L7:
        if (Looper.myLooper() == null) goto L9;
        r109 = true;
        goto L10
    }

    public void O(final View r100, boolean r101) {
        final ECSearchBaseFilterSubBoardView$showPanel$func$1 r102 = new ECSearchBaseFilterSubBoardView$showPanel$func$1(this, r100);
        ECSearchFilterViewModel r103 = this.f452777e;
        if (r103 == null) goto L7;
        ECSearchFilterBoard r104 = r103.getFilterBoard();
        if (r104 == null) goto L7;
        r104.setContentType("default");
    L7:
        if (r101 == false) goto L10;
        if (r100 == null) goto L12;
        r100.postOnAnimation(new ECSearchBaseFilterSubBoardView$showPanel$1(r100, r102));
        return;
    L12:
        return;
    L10:
        r102.invoke();
    }

    public ECSearchBaseFilterSubBoardView(View r100, SmartImageView r110, TextView r111) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        super(r100, null, null, r110, null, r111, null);
    }

    public ECSearchBaseFilterSubBoardView(View r100, LinearLayout r101, SmartImageView r102, SmartImageView r103, SmartImageView r104, TextView r105, ECSearchFilterCornerBg r106) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        super(r100, r101, r102, r103, r104, r105, r106);
    }
}
