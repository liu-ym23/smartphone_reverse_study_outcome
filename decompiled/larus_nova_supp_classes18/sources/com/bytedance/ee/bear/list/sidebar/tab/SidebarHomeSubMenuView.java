package com.bytedance.ee.bear.list.sidebar.tab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.ee.bear.list.homepage.title.SubMenuView;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0012H\u0002J\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0018J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/list/sidebar/tab/SidebarHomeSubMenuView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "magicIndicator", "Lnet/lucode/hackware/magicindicator/MagicIndicator;", "getMagicIndicator", "()Lnet/lucode/hackware/magicindicator/MagicIndicator;", "setMagicIndicator", "(Lnet/lucode/hackware/magicindicator/MagicIndicator;)V", "sortAndFilterEntry", "Landroid/widget/ImageView;", "onSortAndFilterClickListener", "Lkotlin/Function0;", "", "getOnSortAndFilterClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnSortAndFilterClickListener", "(Lkotlin/jvm/functions/Function0;)V", "mFilterDesc", "", "initView", "initListeners", "showSortAndFilter", "show", "", "onClickSortAndFilterEntry", "showFilterDesc", "desc", "setFilterState", "filterState", "Lcom/bytedance/ee/bear/list/homepage/title/SubMenuView$FilterState;", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SidebarHomeSubMenuView extends FrameLayout {
    public MagicIndicator a;
    public ImageView b;
    public Function0<Unit> c;

    public static final class a {
    }

    static {
    }

    public final MagicIndicator getMagicIndicator() {
        return this.a;
    }

    public final Function0<Unit> getOnSortAndFilterClickListener() {
        return this.c;
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "desc");
        tt5.a.h("SidebarHomeSubMenuView", "showFilterDesc()...desc = " + r3);
        if (TextUtils.isEmpty(r3) == false) goto L5;
        SubMenuView.FilterState r4 = SubMenuView.FilterState.DEFAULT;
    L6:
        setFilterState(r4);
        return;
    L5:
        r4 = SubMenuView.FilterState.CHECKED;
        goto L6
    }

    public final void setFilterState(SubMenuView.FilterState r4) {
        Intrinsics.checkNotNullParameter(r4, "filterState");
        ImageView r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4 != SubMenuView.FilterState.DEFAULT) goto L7;
        r0.setBackgroundDrawable(null);
        int r5 = 2131102418;
    L8:
        l.c(r0, r5);
        return;
    L7:
        r0.setBackgroundDrawable(getResources().getDrawable(2131243704, null));
        l.b(r0, 2131106271);
        r5 = 2131106273;
        goto L8
    }

    public final void setMagicIndicator(MagicIndicator r1) {
        this.a = r1;
    }

    public final void setOnSortAndFilterClickListener(Function0<Unit> r1) {
        this.c = r1;
    }

    public SidebarHomeSubMenuView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        MagicIndicator r4 = new MagicIndicator(getContext());
        this.a = r4;
        r4.setClipToPadding(false);
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, -2);
        r5.gravity = 17;
        addView(this.a, r5);
        ImageView r6 = new ImageView(getContext());
        this.b = r6;
        r6.setImageResource(2131255024);
        ImageView r7 = this.b;
        if (r7 == null) goto L5;
        r7.setImageTintList(ColorStateList.valueOf(getResources().getColor(2131102418)));
    L5:
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(n.d(24), n.d(24));
        r8.rightMargin = n.d(12);
        r8.gravity = 21;
        ImageView r9 = this.b;
        if (r9 == null) goto L8;
        int r0 = n.d(3);
        r9.setPadding(r0, r0, r0, r0);
    L8:
        addView(this.b, r8);
        ImageView r10 = this.b;
        if (r10 == null) goto L12;
        r10.setOnClickListener(new yd5.a(this));
        return;
    }
}
