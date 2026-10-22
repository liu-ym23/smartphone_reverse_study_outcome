package com.bytedance.ee.bear.bitable.infoarch.block;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.common.widgets.ClippingRecyclerView;
import com.bytedance.ee.bear.bitable.infoarch.header.BitableHeaderContainer;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.panel.e;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.catalog.CatalogItemAdapter;
import com.bytedance.ee.bear.bitable.uikit.catalog.CatalogItemModel;
import com.bytedance.ee.bear.bitable.uikit.catalog.CatalogItemTreeAdapter;
import com.bytedance.ee.bear.bitable.uikit.empty.EmptyData;
import com.bytedance.ee.bear.bitable.uikit.empty.EmptyView;
import com.bytedance.ee.bear.bitable.uikit.search.SearchBar;
import com.bytedance.ee.bear.bitable.uikit.search.SearchBarModel;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.MenuItemView;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.bear.bitable.uikit.tree.TreeListData;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larksuite.framework.thread.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
public abstract class AbstractBlockCatalogContainer extends BaseDrawerContainer {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f213183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f213184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f213185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EmptyView f213186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<CatalogItemModel> f213187h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public gv4.a f213188i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f213189j;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractBlockCatalogContainer f213190a;

        public b(AbstractBlockCatalogContainer r100) {
            this.f213190a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AbstractBlockCatalogContainer.a(this.f213190a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    private final CatalogItemAdapter getAdapter() {
        return (CatalogItemAdapter) this.f213184e.getValue();
    }

    private final CatalogItemTreeAdapter getTreeAdapter() {
        return (CatalogItemTreeAdapter) this.f213185f.getValue();
    }

    public final View getDismissArea() {
        View r100 = findViewById(this.f213183d);
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final LinearLayout getBottomMenu() {
        View r100 = findViewById(R.id.bottom_menu);
        if (r100 == null) goto L7;
        return (LinearLayout) r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final LinearLayout getBottomWrapper() {
        View r100 = findViewById(R.id.bottom_wrapper);
        if (r100 == null) goto L7;
        return (LinearLayout) r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final SearchBar getSearchBar() {
        View r100 = findViewById(R.id.search_bar);
        if (r100 == null) goto L7;
        return (SearchBar) r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final ClippingRecyclerView getBlockCatalogRecyclerView() {
        View r100 = findViewById(R.id.blockCatalogRv);
        if (r100 == null) goto L7;
        return (ClippingRecyclerView) r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final View getCatalogTopPlaceholder() {
        View r100 = findViewById(R.id.catalog_top_compat);
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final BitableHeaderContainer getDrawerHeader() {
        View r100 = findViewById(R.id.bitable_drawer_header);
        if (r100 == null) goto L7;
        return (BitableHeaderContainer) r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final BitableHeaderContainer getHeader() {
        return getDrawerHeader();
    }

    public static final void a(AbstractBlockCatalogContainer r100) {
        RecyclerView.LayoutManager r101 = r100.getBlockCatalogRecyclerView().getLayoutManager();
        if ((r101 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r102 = (LinearLayoutManager) r101;
    L6:
        if (r102 == null) goto L31;
        int r103 = r100.getTreeAdapter().getItemCount();
        boolean r104 = false;
        int r105 = 0;
    L10:
        if (r105 >= r103) goto L20;
        CatalogItemModel r106 = r100.getTreeAdapter().H2(r105);
        if (r106 != null) goto L14;
    L16:
        boolean r107 = false;
    L17:
        if (r107 == true) goto L21;
        r105 = r105 + 1;
    L21:
        int r108 = r102.findFirstVisibleItemPosition();
        if (r105 > r102.findLastVisibleItemPosition()) goto L25;
        if (r108 > r105) goto L25;
        r104 = true;
    L25:
        if (r104 == true) goto L30;
        r100.getBlockCatalogRecyclerView().smoothScrollToPosition(r105);
        return;
    L30:
        return;
    L14:
        if (r106.isSelected() != true) goto L16;
        r107 = true;
        goto L17
    L20:
        r105 = 0;
        goto L21
    L31:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static final /* synthetic */ CatalogItemTreeAdapter b(AbstractBlockCatalogContainer r100) {
        return r100.getTreeAdapter();
    }

    public static void f(AbstractBlockCatalogContainer r100) {
        boolean r101 = r100.getTreeAdapter().f216233c.isEmpty();
        ClippingRecyclerView r102 = r100.getBlockCatalogRecyclerView();
        int r103 = 8;
        if (r101 == false) goto L5;
        int r104 = 8;
    L6:
        r102.setVisibility(r104);
        EmptyView r105 = r100.f213186g;
        if (r101 == false) goto L9;
        r103 = 0;
    L9:
        r105.setVisibility(r103);
        return;
    L5:
        r104 = 0;
        goto L6
    }

    public final void c(boolean r100) {
        gv4.a r101 = this.f213188i;
        if (r101 == null) goto L6;
        r101.a(new ToggleDrawerAction(r100));
        return;
    }

    public final void setHeaderVisible(boolean r100) {
        BitableHeaderContainer r101 = getDrawerHeader();
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        m.z(getCatalogTopPlaceholder(), !r100);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setStatusBarInset(int r100) {
        this.f213189j = RangesKt.coerceAtLeast(r100, 0);
        BitableHeaderContainer r101 = getDrawerHeader();
        r101.setPadding(r101.getPaddingLeft(), this.f213189j, r101.getPaddingRight(), r101.getPaddingBottom());
    }

    public final void setToggleListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        getDrawerHeader().setOnClickListener(r100);
        getDismissArea().setOnClickListener(r100);
        getCatalogTopPlaceholder().setOnClickListener(r100);
    }

    public final void d(BlockCatalogModel r110, gv4.a r111) {
        Intrinsics.checkNotNullParameter(r111, "handler");
        Intrinsics.checkNotNullParameter(r111, "handler");
        this.f213188i = r111;
        if (r110 == null) goto L7;
        Boolean r100 = r110.getCanSort();
        if (r100 == null) goto L7;
        boolean r101 = r100.booleanValue();
    L8:
        if (r110 == null) goto L13;
        SearchBarModel r102 = r110.getSearchBar();
        if (r102 == null) goto L13;
        getSearchBar().a();
        getSearchBar().b(r102, new com.bytedance.ee.bear.bitable.infoarch.block.a(r111, this, r110));
    L13:
        if (r110 == null) goto L15;
        TreeListData<CatalogItemModel> r103 = r110.getTreeListData();
    L16:
        if (r110 == null) goto L18;
        String r104 = r110.getScrollId();
    L19:
        if (r103 == null) goto L21;
        getTreeAdapter().O2(r103, r111, r104);
    L21:
        getTreeAdapter().y2(r101);
        f(this);
        ThreadUtils.runOnUIThread(new com.bytedance.ee.bear.bitable.infoarch.block.b(this, r110), 200);
        if (r110 == null) goto L26;
        ArrayList<SimpleItemModel> r105 = r110.getBottomMenu();
        if (r105 == null) goto L26;
        int r106 = r105.size();
    L27:
        LinearLayout r107 = getBottomWrapper();
        if (r106 <= 0) goto L30;
        int r108 = 0;
    L31:
        r107.setVisibility(r108);
        if (r106 <= 0) goto L68;
        int r109 = getBottomMenu().getChildCount();
        int r112 = 0;
    L35:
        if (r112 >= r109) goto L75;
        View r113 = getBottomMenu().getChildAt(r112);
        if ((r113 instanceof MenuItemView) == false) goto L39;
        MenuItemView r114 = (MenuItemView) r113;
    L40:
        if (r114 == null) goto L67;
        r114.setVisibility(8);
        if (r110 == null) goto L67;
        ArrayList<SimpleItemModel> r115 = r110.getBottomMenu();
        if (r115 == null) goto L67;
        SimpleItemModel r116 = (SimpleItemModel) CollectionsKt.getOrNull(r115, r112);
        if (r116 == null) goto L67;
        Intrinsics.checkNotNullParameter(r116, "data");
        Intrinsics.checkNotNullParameter(r111, "actionHandler");
        e.n(r114.getMenuIconFromXml(), r116.getIcon());
        TextView r117 = r114.getMenuTextFromXml();
        if (r117 == null) goto L51;
        r117.setText(r116.getText());
    L51:
        com.bytedance.ee.bear.bitable.common.e.b(r114, 0.0f, 6);
        if (TextUtils.equals(r116.getStyle(), "disable") == false) goto L56;
        r114.getMenuIconFromXml().setImageTintList(AppCompatResources.getColorStateList(r114.getContext(), R.color.icon_disable));
        TextView r118 = r114.getMenuTextFromXml();
        if (r118 == null) goto L66;
        r118.setTextColor(AppCompatResources.getColorStateList(r114.getContext(), R.color.text_disable));
    L66:
        r114.setOnClickListener(new jv4.a(r111, r116, r114));
        r114.setVisibility(0);
        goto L67
    L56:
        Icon r119 = r116.getIcon();
        if (r119 == null) goto L63;
        String r120 = r119.getIconTintColor();
        if (r120 == null) goto L63;
        AppCompatImageView r121 = r114.getMenuIconFromXml();
        if (r121 == null) goto L63;
        r121.setImageTintList(ColorStateList.valueOf(ColorUtils.h(r120)));
    L63:
        TextView r122 = r114.getMenuTextFromXml();
        if (r122 == null) goto L66;
        r122.setTextColor(ContextCompat.getColor(r114.getContext(), R.color.text_placeholder));
    L67:
        r112 = r112 + 1;
        goto L35
    L39:
        r114 = null;
        goto L40
    L75:
        return;
    L68:
        return;
    L30:
        r108 = 8;
    L26:
        r106 = 0;
        goto L27
    L18:
        r104 = null;
        goto L19
    L15:
        r103 = null;
    L7:
        r101 = false;
        goto L8
    }

    public final void e(boolean r100, boolean r101, boolean r102, int r103) {
        int r104 = 8;
        if (r100 == false) goto L5;
        int r105 = 0;
    L6:
        setVisibility(r105);
        SearchBar r106 = getSearchBar();
        if (r101 == false) goto L9;
        int r107 = 8;
    L10:
        r106.setVisibility(r107);
        if (r100 == false) goto L15;
        getBlockCatalogRecyclerView().post(new b(this));
        gv4.a r108 = this.f213188i;
        if (r108 == null) goto L15;
        r108.a(new Action("", "getDataAction"));
    L15:
        BitableHeaderContainer r109 = getDrawerHeader();
        if (r102 == false) goto L18;
        r104 = 0;
    L18:
        r109.setVisibility(r104);
        m.z(getCatalogTopPlaceholder(), !r102);
        if (r102 == true) goto L21;
        m.p(getCatalogTopPlaceholder(), RangesKt.coerceAtLeast(r103 + this.f213189j, 0), false);
        return;
    L21:
        if (getVisibility() != 0) goto L25;
        getDrawerHeader().c();
        return;
    L25:
        return;
    L9:
        r107 = 0;
        goto L10
    L5:
        r105 = 8;
        goto L6
    }

    public AbstractBlockCatalogContainer(final Context r100, AttributeSet r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f213183d = r104;
        this.f213184e = LazyKt.lazy(new AbstractBlockCatalogContainer$adapter$2(r100));
        this.f213185f = LazyKt.lazy(new AbstractBlockCatalogContainer$treeAdapter$2(r100, this));
        this.f213187h = new ArrayList();
        com.bytedance.ee.bear.bitable.uikit.catalog.search.b r105 = new com.bytedance.ee.bear.bitable.uikit.catalog.search.b(null);
        LayoutInflater.from(r100).inflate(r103, this, true);
        View r106 = findViewById(R.id.search_empty_view);
        if (r106 == null) goto L7;
        EmptyView r107 = (EmptyView) r106;
        EmptyData r108 = new EmptyData();
        r108.setText(r100.getString(R.string.Bitable_Mobile_NoContent_Desc));
        Icon r109 = new Icon();
        r109.setImgRes(Integer.valueOf(R.drawable.ccm_empty_neutral_no_content));
        r108.setIcon(r109);
        r107.a(r108, null);
        this.f213186g = r107;
        setBackgroundResource(R.color.transparent);
        setClipChildren(false);
        setClickable(true);
        ClippingRecyclerView r110 = getBlockCatalogRecyclerView();
        r110.setLayoutManager(new LinearLayoutManager(r100));
        r110.setNestedScrollingEnabled(false);
        getTreeAdapter().f216076w = r105;
        r110.setAdapter(getTreeAdapter());
        com.bytedance.ee.bear.bitable.common.e.b(getDrawerHeader(), 0.97f, 4);
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
