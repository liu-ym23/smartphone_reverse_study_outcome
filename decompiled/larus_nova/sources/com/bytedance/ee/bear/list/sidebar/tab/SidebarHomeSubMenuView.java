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
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0012H\u0002J\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0018J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/list/sidebar/tab/SidebarHomeSubMenuView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "magicIndicator", "Lnet/lucode/hackware/magicindicator/MagicIndicator;", "getMagicIndicator", "()Lnet/lucode/hackware/magicindicator/MagicIndicator;", "setMagicIndicator", "(Lnet/lucode/hackware/magicindicator/MagicIndicator;)V", "sortAndFilterEntry", "Landroid/widget/ImageView;", "onSortAndFilterClickListener", "Lkotlin/Function0;", "", "getOnSortAndFilterClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnSortAndFilterClickListener", "(Lkotlin/jvm/functions/Function0;)V", "mFilterDesc", "", "initView", "initListeners", "showSortAndFilter", "show", "", "onClickSortAndFilterEntry", "showFilterDesc", SocialConstants.PARAM_APP_DESC, "setFilterState", "filterState", "Lcom/bytedance/ee/bear/list/homepage/title/SubMenuView$FilterState;", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SidebarHomeSubMenuView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MagicIndicator f229624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f229625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f229626c;

    public static final class a {
    }

    static {
    }

    public final MagicIndicator getMagicIndicator() {
        return this.f229624a;
    }

    public final Function0<Unit> getOnSortAndFilterClickListener() {
        return this.f229626c;
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        tt5.a.h("SidebarHomeSubMenuView", "showFilterDesc()...desc = " + r100);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        SubMenuView.FilterState r101 = SubMenuView.FilterState.DEFAULT;
    L6:
        setFilterState(r101);
        return;
    L5:
        r101 = SubMenuView.FilterState.CHECKED;
        goto L6
    }

    public final void setFilterState(SubMenuView.FilterState r100) {
        Intrinsics.checkNotNullParameter(r100, "filterState");
        ImageView r101 = this.f229625b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 != SubMenuView.FilterState.DEFAULT) goto L7;
        r101.setBackgroundDrawable(null);
        int r102 = R.color.icon_n1;
    L8:
        l.c(r101, r102);
        return;
    L7:
        r101.setBackgroundDrawable(getResources().getDrawable(R.drawable.list_filter_icon_offline_bg, null));
        l.b(r101, R.color.space_list_bg_filter_icon_selected);
        r102 = R.color.space_list_icon_filter_blue;
        goto L8
    }

    public final void setMagicIndicator(MagicIndicator r100) {
        this.f229624a = r100;
    }

    public final void setOnSortAndFilterClickListener(Function0<Unit> r100) {
        this.f229626c = r100;
    }

    public SidebarHomeSubMenuView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        MagicIndicator r102 = new MagicIndicator(getContext());
        this.f229624a = r102;
        r102.setClipToPadding(false);
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, -2);
        r103.gravity = 17;
        addView(this.f229624a, r103);
        ImageView r104 = new ImageView(getContext());
        this.f229625b = r104;
        r104.setImageResource(R.drawable.ud_icon_list_setting_outlined);
        ImageView r105 = this.f229625b;
        if (r105 == null) goto L5;
        r105.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.icon_n1)));
    L5:
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(n.d(24), n.d(24));
        r106.rightMargin = n.d(12);
        r106.gravity = 21;
        ImageView r107 = this.f229625b;
        if (r107 == null) goto L8;
        int r108 = n.d(3);
        r107.setPadding(r108, r108, r108, r108);
    L8:
        addView(this.f229625b, r106);
        ImageView r109 = this.f229625b;
        if (r109 == null) goto L12;
        r109.setOnClickListener(new yd5.a(this));
        return;
    }
}
