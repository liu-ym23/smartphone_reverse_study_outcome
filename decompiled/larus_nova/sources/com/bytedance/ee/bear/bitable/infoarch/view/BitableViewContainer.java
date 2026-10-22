package com.bytedance.ee.bear.bitable.infoarch.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.infoarch.BaseLoadingContainer;
import com.bytedance.ee.bear.bitable.loading.ELoadingType;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.bear.widgets.CenterLayoutManager;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020#H\u0002J\u0016\u0010(\u001a\u00020\u001c2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00120*H\u0002J\b\u0010+\u001a\u00020\bH\u0002J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020#H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u00060"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/view/BitableViewContainer;", "Lcom/bytedance/ee/bear/bitable/infoarch/BaseLoadingContainer;", "Lcom/bytedance/ee/bear/bitable/infoarch/IContainerLifecycle;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "catalogView", "Landroidx/recyclerview/widget/RecyclerView;", "catalogMoreView", "Landroid/view/View;", "catalogMoreViewWrapper", "menuItems", "", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "currentViewId", "", "adapter", "Lcom/bytedance/ee/bear/bitable/infoarch/view/CatalogMenuAdapter;", "getAdapter", "()Lcom/bytedance/ee/bear/bitable/infoarch/view/CatalogMenuAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "setData", "", "data", "Lcom/bytedance/ee/bear/bitable/infoarch/view/ViewContainerModel;", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "adjustPosition", "smooth", "", "onScreenOrientationChanged", "landscape", "setCatalogMoreViewVisible", "visible", "setItemList", "list", "", "findTargetPositionByViewId", "getLoadingType", "Lcom/bytedance/ee/bear/bitable/loading/ELoadingType;", "interruptLoading", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableViewContainer extends BaseLoadingContainer {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f213720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f213721e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f213722f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<SimpleItemModel> f213723g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f213724h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f213725i;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gv4.a f213727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewContainerModel f213728b;

        public b(gv4.a r100, ViewContainerModel r101) {
            this.f213727a = r100;
            this.f213728b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f213727a.a(new Action("item_more", this.f213728b.getMoreAction()));
        }
    }

    static {
    }

    public BitableViewContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BitableViewContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final CatalogMenuAdapter getAdapter() {
        return (CatalogMenuAdapter) this.f213725i.getValue();
    }

    public final void b() {
        Iterator r100 = ((ArrayList) this.f213723g).iterator();
        boolean r101 = false;
        int r102 = 0;
    L4:
        if (r100.hasNext() == false) goto L12;
        Object r103 = r100.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (TextUtils.equals(((SimpleItemModel) r103).getId(), this.f213724h) == true) goto L13;
        r102 = r104;
    L13:
        if (r102 >= 0) goto L15;
    L17:
        if (r101 == false) goto L24;
        RecyclerView r105 = this.f213720d;
        if (r105 == null) goto L25;
        r105.post(new com.bytedance.ee.bear.bitable.infoarch.view.a(r105, r102));
        return;
    L25:
        return;
    L24:
        return;
    L15:
        if (r102 >= ((ArrayList) this.f213723g).size()) goto L17;
        r101 = true;
        goto L17
    L12:
        r102 = -1;
        goto L13
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.BaseLoadingContainer, com.bytedance.ee.bear.bitable.loading.a
    public final boolean A30() {
        super.A30();
        return true;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.BaseLoadingContainer, com.bytedance.ee.bear.bitable.loading.a
    public ELoadingType getLoadingType() {
        return ELoadingType.VIEW_CATALOG;
    }

    private final void setCatalogMoreViewVisible(boolean r100) {
        View r101 = this.f213721e;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 4;
        goto L7
    }

    private final void setItemList(List<SimpleItemModel> r100) {
        ((ArrayList) this.f213723g).clear();
        ((ArrayList) this.f213723g).addAll(r100);
        boolean r101 = true;
        if ((!this.f213723g.isEmpty()) == false) goto L14;
        View r102 = this.f213722f;
        if (r102 != null) goto L7;
    L9:
        r101 = false;
    L10:
        if (r101 == true) goto L14;
        View r103 = this.f213722f;
        if (r103 == null) goto L14;
        r103.setVisibility(0);
        goto L14
    L7:
        if (r102.getVisibility() != 0) goto L9;
    L14:
        CatalogMenuAdapter r104 = getAdapter();
        r104.f213730b = this.f213724h;
        List<SimpleItemModel> r105 = this.f213723g;
        Intrinsics.checkNotNullParameter(r105, "menuList");
        r104.f213729a = r105;
        r104.notifyDataSetChanged();
    }

    public final void c(ViewContainerModel r100, gv4.a r101) {
        Intrinsics.checkNotNullParameter(r101, "handler");
        getAdapter().f213733e = r101;
        if (r100 == null) goto L13;
        this.f213724h = r100.getCurrentViewId();
        setCatalogMoreViewVisible(!r100.getHideMoreBtn());
        ArrayList<SimpleItemModel> r102 = r100.getViewList();
        if (r102 == null) goto L7;
        setItemList(r102);
    L7:
        View r103 = this.f213721e;
        if (r103 == null) goto L11;
        r103.setOnClickListener(new b(r101, r100));
    L11:
        if (ArraysKt.filterNotNull(new Object[]{this.f213720d, this.f213724h}).size() != 2) goto L13;
        b();
    L13:
        a();
    }

    public BitableViewContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f213723g = new ArrayList();
        this.f213725i = LazyKt.lazy(new BitableViewContainer$adapter$2(this));
        LayoutInflater.from(r100).inflate(R.layout.bitable_view_container_layout, this, true);
        RecyclerView r103 = (RecyclerView) findViewById(R.id.bitable_header_catalog);
        this.f213720d = r103;
        this.f213721e = findViewById(R.id.bitable_header_catalog_more);
        this.f213722f = findViewById(R.id.bitable_header_catalog_more_wrapper);
        if (r103 == null) goto L6;
        r103.setLayoutManager(new CenterLayoutManager(r100, 0));
        r103.setAdapter(getAdapter());
        return;
    }

    public /* synthetic */ BitableViewContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
