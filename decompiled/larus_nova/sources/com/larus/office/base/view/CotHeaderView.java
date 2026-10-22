package com.larus.office.base.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerLinearLayout;
import com.larus.bmhome.chat.layout.widget.ThreeLoadingIndicator;
import com.larus.bmhome.chat.layout.widget.v0;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.office.base.impl.databinding.LarusCotHeaderBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import ic8.t;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mn9.b;
import po8.z;
import v19.i5;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0014J\u0018\u0010\u001e\u001a\u00020\u00182\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/office/base/view/CotHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "switcherAdapter", "Lcom/larus/bmhome/chat/view/SearchSwitcherAdapter;", "lastSwitcherList", "", "", "binding", "Lcom/larus/office/base/impl/databinding/LarusCotHeaderBinding;", "getBinding", "()Lcom/larus/office/base/impl/databinding/LarusCotHeaderBinding;", "binding$delegate", "Lkotlin/Lazy;", "multiLoading", "Lcom/larus/bmhome/chat/layout/widget/ThreeLoadingIndicator;", "refreshHeadView", "", "input", "Lcom/larus/bmhome/chat/bean/HeadTitleInfoSimplify;", "updateTitleStreamEnd", "updateLoadingTitle", "onDetachedFromWindow", "tryInitSwitchAdapter", "switcherList", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CotHeaderView extends ConstraintLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f361204e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f361205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f361206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f361207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ThreeLoadingIndicator f361208d;

    public static final class a {
    }

    static {
    }

    public CotHeaderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CotHeaderView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final LarusCotHeaderBinding getBinding() {
        return (LarusCotHeaderBinding) this.f361207c.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getBinding().f360544f.setText("");
        e1.x(getBinding().f360544f);
        e1.o(getBinding().f360545g);
        ThreeLoadingIndicator r100 = this.f361208d;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        z r101 = this.f361205a;
        if (r101 == null) goto L8;
        r101.b();
    L8:
        this.f361205a = null;
        this.f361206b = null;
    }

    public final void R5(t r110) {
        Intrinsics.checkNotNullParameter(r110, "input");
        int r100 = r110.f489254f;
        boolean r101 = true;
        if (r100 != 0) goto L5;
        LarusCotHeaderBinding r102 = getBinding();
        if (r102 == null) goto L114;
        ShimmerLinearLayout r103 = r102.f360540b;
        if (r103 == null) goto L114;
        r103.a();
    L114:
        LarusCotHeaderBinding r104 = getBinding();
        if (r104 == null) goto L119;
        ShimmerLinearLayout r105 = r104.f360540b;
        if (r105 == null) goto L119;
        e1.o(r105);
    L119:
        LarusCotHeaderBinding r106 = getBinding();
        if (r106 == null) goto L147;
        TextView r107 = r106.f360542d;
        if (r107 == null) goto L148;
        e1.x(r107);
        SpannableStringBuilder r108 = new SpannableStringBuilder("");
        ThreeLoadingIndicator r109 = this.f361208d;
        if (r109 == null) goto L126;
        r109.b(false);
    L126:
        ThreeLoadingIndicator r111 = new ThreeLoadingIndicator(r107, R.drawable.larus_common_ui_office_loading_dot, r107.getContext(), Integer.valueOf(r107.getResources().getColor(R.color.larus_neutral_100)));
        this.f361208d = r111;
        List<v0> r112 = r111.f304930b;
        if (r112 == null) goto L132;
        Iterator<T> r113 = r112.iterator();
    L130:
        if (r113.hasNext() == false) goto L132;
        r108.append("⚫", (v0) r113.next(), 17);
    L132:
        ThreeLoadingIndicator r114 = this.f361208d;
        if (r114 == null) goto L135;
        r114.b(true);
    L135:
        ThreeLoadingIndicator r115 = this.f361208d;
        if (r115 == null) goto L138;
        r115.d();
    L138:
        r107.setText(r108, TextView.BufferType.SPANNABLE);
        return;
    L148:
        return;
    L147:
        return;
    L5:
        if (r100 != 1) goto L7;
        LarusCotHeaderBinding r116 = getBinding();
        if (r116 == null) goto L49;
        TextView r117 = r116.f360542d;
        if (r117 == null) goto L49;
        e1.o(r117);
    L49:
        LarusCotHeaderBinding r118 = getBinding();
        if (r118 == null) goto L54;
        ShimmerLinearLayout r119 = r118.f360540b;
        if (r119 == null) goto L54;
        e1.x(r119);
    L54:
        getBinding().f360544f.setText(r110.f489250b);
        we8.a.b(getBinding().f360544f, i5.t(), false, null, null, 12);
        List<String> r120 = r110.f489251c;
        if (r120 != null) goto L57;
    L60:
        boolean r121 = true;
    L61:
        if (r121 == false) goto L63;
        e1.o(getBinding().f360545g);
        e1.x(getBinding().f360544f);
    L79:
        String r122 = r110.f489252d;
        if (r122 != null) goto L82;
    L85:
        if (r101 == false) goto L91;
        e1.o(getBinding().f360541c);
        LarusCotHeaderBinding r123 = getBinding();
        if (r123 == null) goto L106;
        ShimmerLinearLayout r124 = r123.f360540b;
        if (r124 == null) goto L106;
        int r125 = i5.q();
        int r126 = i5.q();
        int r127 = r124.getPaddingTop();
        int r128 = r124.getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r124.getClass().getSimpleName() + ",source:,start:" + r125 + ",top:" + r127 + ",end:" + r126 + ",bottom:" + r128);
        r124.setPaddingRelative(r125, r127, r126, r128);
    L106:
        if (r110.f489249a == false) goto L108;
        getBinding().f360540b.b();
        return;
    L108:
        getBinding().f360540b.a();
        return;
    L91:
        e1.x(getBinding().f360541c);
        ImageLoaderKt.u(getBinding().f360541c, r110.f489252d, "deep_think_title_icon");
        getBinding().f360541c.setBackgroundResource(android.R.color.transparent);
        LarusCotHeaderBinding r129 = getBinding();
        if (r129 == null) goto L100;
        SimpleDraweeView r130 = r129.f360541c;
        if (r130 == null) goto L100;
        ViewGroup.LayoutParams r131 = r130.getLayoutParams();
        if (r131 == null) goto L99;
        ViewGroup.MarginLayoutParams r132 = (ViewGroup.MarginLayoutParams) r131;
        r132.setMarginEnd(0);
        r132.width = i5.J();
        r132.height = i5.J();
        r130.setLayoutParams(r132);
        goto L100
    L99:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L100:
        LarusCotHeaderBinding r133 = getBinding();
        if (r133 == null) goto L106;
        ShimmerLinearLayout r134 = r133.f360540b;
        if (r134 == null) goto L106;
        int r135 = i5.h();
        int r136 = i5.q();
        int r137 = r134.getPaddingTop();
        int r138 = r134.getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r134.getClass().getSimpleName() + ",source:,start:" + r135 + ",top:" + r137 + ",end:" + r136 + ",bottom:" + r138);
        r134.setPaddingRelative(r135, r137, r136, r138);
        goto L106
    L82:
        if (r122.length() == 0) goto L85;
        r101 = false;
        goto L85
    L63:
        e1.x(getBinding().f360545g);
        e1.o(getBinding().f360544f);
        List<String> r139 = r110.f489251c;
        if (r139 == null) goto L79;
        List<String> r140 = this.f361206b;
        if (r140 == null) goto L69;
        int r141 = r140.hashCode();
    L71:
        if (r141 == r139.hashCode()) goto L79;
        this.f361206b = r139;
        final Context r142 = getBinding().f360539a.getContext();
        z r143 = this.f361205a;
        if (r143 == null) goto L76;
        r143.b();
    L76:
        getBinding().f360545g.removeAllViews();
        getBinding().f360545g.setFactory(new mn9.a(r142));
        z r144 = new z(getBinding().f360545g, r139);
        this.f361205a = r144;
        Intrinsics.checkNotNull(r142);
        r144.a(r142);
        z r145 = this.f361205a;
        if (r145 == null) goto L79;
        r145.c();
        goto L79
    L69:
        r141 = 0;
        goto L71
    L57:
        if (r120.isEmpty() == true) goto L60;
        r121 = false;
        goto L61
    L7:
        if (r100 != 2) goto L9;
        LarusCotHeaderBinding r146 = getBinding();
        if (r146 == null) goto L24;
        TextView r147 = r146.f360542d;
        if (r147 == null) goto L24;
        e1.o(r147);
    L24:
        LarusCotHeaderBinding r148 = getBinding();
        if (r148 == null) goto L29;
        ShimmerLinearLayout r149 = r148.f360540b;
        if (r149 == null) goto L29;
        e1.x(r149);
    L29:
        getBinding().f360544f.setText(getResources().getText(R.string.larus_slides_status_completingSlides));
        we8.a.b(getBinding().f360544f, i5.t(), false, null, null, 12);
        e1.o(getBinding().f360545g);
        e1.x(getBinding().f360544f);
        e1.x(getBinding().f360541c);
        ImageLoaderKt.e(getBinding().f360541c);
        getBinding().f360541c.setBackgroundResource(R.drawable.larus_icon_pencil);
        LarusCotHeaderBinding r150 = getBinding();
        if (r150 == null) goto L38;
        SimpleDraweeView r151 = r150.f360541c;
        if (r151 == null) goto L38;
        ViewGroup.LayoutParams r152 = r151.getLayoutParams();
        if (r152 == null) goto L37;
        ViewGroup.MarginLayoutParams r153 = (ViewGroup.MarginLayoutParams) r152;
        r153.setMarginEnd(i5.Y());
        r153.width = i5.C();
        r153.height = i5.C();
        r151.setLayoutParams(r153);
        goto L38
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L38:
        LarusCotHeaderBinding r154 = getBinding();
        if (r154 == null) goto L43;
        ShimmerLinearLayout r155 = r154.f360540b;
        if (r155 == null) goto L43;
        int r156 = i5.q();
        int r157 = i5.q();
        int r158 = r155.getPaddingTop();
        int r159 = r155.getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r155.getClass().getSimpleName() + ",source:,start:" + r156 + ",top:" + r158 + ",end:" + r157 + ",bottom:" + r159);
        r155.setPaddingRelative(r156, r158, r157, r159);
    L43:
        getBinding().f360540b.b();
        return;
    L9:
        if (r100 != 3) goto L149;
        ThreeLoadingIndicator r160 = this.f361208d;
        if (r160 == null) goto L14;
        r160.a();
    L14:
        LarusCotHeaderBinding r161 = getBinding();
        if (r161 == null) goto L141;
        ShimmerLinearLayout r162 = r161.f360540b;
        if (r162 == null) goto L142;
        r162.a();
        return;
    L142:
        return;
    L141:
        return;
    }

    public CotHeaderView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f361207c = LazyKt.lazy(new b(r100, this));
    }

    public /* synthetic */ CotHeaderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
