package com.larus.office.plugins.input.view;

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
import com.larus.office.impl.databinding.LarusOfficeSdkCotHeaderBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import ic8.t;
import java.util.Iterator;
import java.util.List;
import ko9.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import po8.z;
import v19.i5;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0014J\u0018\u0010\u001e\u001a\u00020\u00182\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/office/plugins/input/view/CotHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "switcherAdapter", "Lcom/larus/bmhome/chat/view/SearchSwitcherAdapter;", "lastSwitcherList", "", "", "binding", "Lcom/larus/office/impl/databinding/LarusOfficeSdkCotHeaderBinding;", "getBinding", "()Lcom/larus/office/impl/databinding/LarusOfficeSdkCotHeaderBinding;", "binding$delegate", "Lkotlin/Lazy;", "multiLoading", "Lcom/larus/bmhome/chat/layout/widget/ThreeLoadingIndicator;", "refreshHeadView", "", "input", "Lcom/larus/bmhome/chat/bean/HeadTitleInfoSimplify;", "updateTitleStreamEnd", "updateLoadingTitle", "onDetachedFromWindow", "tryInitSwitchAdapter", "switcherList", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CotHeaderView extends ConstraintLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f362632e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f362633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f362634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f362635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ThreeLoadingIndicator f362636d;

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

    private final LarusOfficeSdkCotHeaderBinding getBinding() {
        return (LarusOfficeSdkCotHeaderBinding) this.f362635c.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getBinding().f362188f.setText("");
        e1.x(getBinding().f362188f);
        e1.o(getBinding().f362189g);
        ThreeLoadingIndicator r100 = this.f362636d;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        z r101 = this.f362633a;
        if (r101 == null) goto L8;
        r101.b();
    L8:
        this.f362633a = null;
        this.f362634b = null;
    }

    public final void R5(t r110) {
        Intrinsics.checkNotNullParameter(r110, "input");
        int r100 = r110.f489254f;
        boolean r101 = true;
        if (r100 != 0) goto L5;
        LarusOfficeSdkCotHeaderBinding r102 = getBinding();
        if (r102 == null) goto L118;
        ShimmerLinearLayout r103 = r102.f362184b;
        if (r103 == null) goto L118;
        r103.a();
    L118:
        LarusOfficeSdkCotHeaderBinding r104 = getBinding();
        if (r104 == null) goto L123;
        ShimmerLinearLayout r105 = r104.f362184b;
        if (r105 == null) goto L123;
        e1.o(r105);
    L123:
        LarusOfficeSdkCotHeaderBinding r106 = getBinding();
        if (r106 == null) goto L151;
        TextView r107 = r106.f362186d;
        if (r107 == null) goto L152;
        e1.x(r107);
        SpannableStringBuilder r108 = new SpannableStringBuilder("");
        ThreeLoadingIndicator r109 = this.f362636d;
        if (r109 == null) goto L130;
        r109.b(false);
    L130:
        ThreeLoadingIndicator r111 = new ThreeLoadingIndicator(r107, R.drawable.larus_office_bg_loading_dot, r107.getContext(), Integer.valueOf(r107.getResources().getColor(R.color.larus_neutral_100)));
        this.f362636d = r111;
        List<v0> r112 = r111.f304930b;
        if (r112 == null) goto L136;
        Iterator<T> r113 = r112.iterator();
    L134:
        if (r113.hasNext() == false) goto L136;
        r108.append("⚫", (v0) r113.next(), 17);
    L136:
        ThreeLoadingIndicator r114 = this.f362636d;
        if (r114 == null) goto L139;
        r114.b(true);
    L139:
        ThreeLoadingIndicator r115 = this.f362636d;
        if (r115 == null) goto L142;
        r115.d();
    L142:
        r107.setText(r108, TextView.BufferType.SPANNABLE);
        return;
    L152:
        return;
    L151:
        return;
    L5:
        if (r100 != 1) goto L7;
        LarusOfficeSdkCotHeaderBinding r116 = getBinding();
        if (r116 == null) goto L49;
        TextView r117 = r116.f362186d;
        if (r117 == null) goto L49;
        e1.o(r117);
    L49:
        LarusOfficeSdkCotHeaderBinding r118 = getBinding();
        if (r118 == null) goto L54;
        ShimmerLinearLayout r119 = r118.f362184b;
        if (r119 == null) goto L54;
        e1.x(r119);
    L54:
        getBinding().f362188f.setText(r110.f489250b);
        we8.a.b(getBinding().f362188f, i5.t(), false, null, null, 12);
        FLogger r120 = FLogger.f375446a;
        StringBuilder r121 = new StringBuilder("Head title list size: ");
        List<String> r122 = r110.f489251c;
        if (r122 == null) goto L57;
        Integer r123 = Integer.valueOf(r122.size());
    L58:
        r121.append(r123);
        r120.i("CotHeaderView", r121.toString());
        List<String> r124 = r110.f489251c;
        if (r124 != null) goto L61;
    L64:
        boolean r125 = true;
    L65:
        if (r125 == false) goto L67;
        e1.o(getBinding().f362189g);
        e1.x(getBinding().f362188f);
    L83:
        String r126 = r110.f489252d;
        if (r126 != null) goto L86;
    L89:
        if (r101 == false) goto L95;
        e1.o(getBinding().f362185c);
        LarusOfficeSdkCotHeaderBinding r127 = getBinding();
        if (r127 == null) goto L110;
        ShimmerLinearLayout r128 = r127.f362184b;
        if (r128 == null) goto L110;
        int r129 = i5.q();
        int r130 = i5.q();
        int r131 = r128.getPaddingTop();
        int r132 = r128.getPaddingBottom();
        r120.i("updatePaddingRelative", "view:" + r128.getClass().getSimpleName() + ",source:,start:" + r129 + ",top:" + r131 + ",end:" + r130 + ",bottom:" + r132);
        r128.setPaddingRelative(r129, r131, r130, r132);
    L110:
        if (r110.f489249a == false) goto L112;
        getBinding().f362184b.b();
        return;
    L112:
        getBinding().f362184b.a();
        return;
    L95:
        e1.x(getBinding().f362185c);
        ImageLoaderKt.u(getBinding().f362185c, r110.f489252d, "deep_think_title_icon");
        getBinding().f362185c.setBackgroundResource(android.R.color.transparent);
        LarusOfficeSdkCotHeaderBinding r133 = getBinding();
        if (r133 == null) goto L104;
        SimpleDraweeView r134 = r133.f362185c;
        if (r134 == null) goto L104;
        ViewGroup.LayoutParams r135 = r134.getLayoutParams();
        if (r135 == null) goto L103;
        ViewGroup.MarginLayoutParams r136 = (ViewGroup.MarginLayoutParams) r135;
        r136.setMarginEnd(0);
        r136.width = i5.J();
        r136.height = i5.J();
        r134.setLayoutParams(r136);
        goto L104
    L103:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L104:
        LarusOfficeSdkCotHeaderBinding r137 = getBinding();
        if (r137 == null) goto L110;
        ShimmerLinearLayout r138 = r137.f362184b;
        if (r138 == null) goto L110;
        int r139 = i5.h();
        int r140 = i5.q();
        int r141 = r138.getPaddingTop();
        int r142 = r138.getPaddingBottom();
        r120.i("updatePaddingRelative", "view:" + r138.getClass().getSimpleName() + ",source:,start:" + r139 + ",top:" + r141 + ",end:" + r140 + ",bottom:" + r142);
        r138.setPaddingRelative(r139, r141, r140, r142);
        goto L110
    L86:
        if (r126.length() == 0) goto L89;
        r101 = false;
        goto L89
    L67:
        e1.x(getBinding().f362189g);
        e1.o(getBinding().f362188f);
        List<String> r143 = r110.f489251c;
        if (r143 == null) goto L83;
        List<String> r144 = this.f362634b;
        if (r144 == null) goto L73;
        int r145 = r144.hashCode();
    L75:
        if (r145 == r143.hashCode()) goto L83;
        this.f362634b = r143;
        final Context r146 = getBinding().f362183a.getContext();
        z r147 = this.f362633a;
        if (r147 == null) goto L80;
        r147.b();
    L80:
        getBinding().f362189g.removeAllViews();
        getBinding().f362189g.setFactory(new ko9.a(r146));
        z r148 = new z(getBinding().f362189g, r143);
        this.f362633a = r148;
        Intrinsics.checkNotNull(r146);
        r148.a(r146);
        z r149 = this.f362633a;
        if (r149 == null) goto L83;
        r149.c();
        goto L83
    L73:
        r145 = 0;
        goto L75
    L61:
        if (r124.isEmpty() == true) goto L64;
        r125 = false;
        goto L65
    L57:
        r123 = null;
        goto L58
    L7:
        if (r100 != 2) goto L9;
        LarusOfficeSdkCotHeaderBinding r150 = getBinding();
        if (r150 == null) goto L24;
        TextView r151 = r150.f362186d;
        if (r151 == null) goto L24;
        e1.o(r151);
    L24:
        LarusOfficeSdkCotHeaderBinding r152 = getBinding();
        if (r152 == null) goto L29;
        ShimmerLinearLayout r153 = r152.f362184b;
        if (r153 == null) goto L29;
        e1.x(r153);
    L29:
        getBinding().f362188f.setText(getResources().getText(R.string.larus_slides_status_completingSlides));
        we8.a.b(getBinding().f362188f, i5.t(), false, null, null, 12);
        e1.o(getBinding().f362189g);
        e1.x(getBinding().f362188f);
        e1.x(getBinding().f362185c);
        ImageLoaderKt.e(getBinding().f362185c);
        getBinding().f362185c.setBackgroundResource(R.drawable.larus_office_sdk_cot_reference_pencil_icon);
        LarusOfficeSdkCotHeaderBinding r154 = getBinding();
        if (r154 == null) goto L38;
        SimpleDraweeView r155 = r154.f362185c;
        if (r155 == null) goto L38;
        ViewGroup.LayoutParams r156 = r155.getLayoutParams();
        if (r156 == null) goto L37;
        ViewGroup.MarginLayoutParams r157 = (ViewGroup.MarginLayoutParams) r156;
        r157.setMarginEnd(i5.Y());
        r157.width = i5.C();
        r157.height = i5.C();
        r155.setLayoutParams(r157);
        goto L38
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L38:
        LarusOfficeSdkCotHeaderBinding r158 = getBinding();
        if (r158 == null) goto L43;
        ShimmerLinearLayout r159 = r158.f362184b;
        if (r159 == null) goto L43;
        int r160 = i5.q();
        int r161 = i5.q();
        int r162 = r159.getPaddingTop();
        int r163 = r159.getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r159.getClass().getSimpleName() + ",source:,start:" + r160 + ",top:" + r162 + ",end:" + r161 + ",bottom:" + r163);
        r159.setPaddingRelative(r160, r162, r161, r163);
    L43:
        getBinding().f362184b.b();
        return;
    L9:
        if (r100 != 3) goto L153;
        ThreeLoadingIndicator r164 = this.f362636d;
        if (r164 == null) goto L14;
        r164.a();
    L14:
        LarusOfficeSdkCotHeaderBinding r165 = getBinding();
        if (r165 == null) goto L145;
        ShimmerLinearLayout r166 = r165.f362184b;
        if (r166 == null) goto L146;
        r166.a();
        return;
    L146:
        return;
    L145:
        return;
    }

    public CotHeaderView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f362635c = LazyKt.lazy(new b(r100, this));
    }

    public /* synthetic */ CotHeaderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
