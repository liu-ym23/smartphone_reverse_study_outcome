package com.larus.business.multitask_management.impl.sheet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.business.multitask_management.impl.component.SectionCardStyle;
import com.larus.business.multitask_management.impl.databinding.LarusMtmItemServiceBinding;
import com.larus.multitask_management.api.data.quick_access.NodeType;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.larus.utils.w0;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002?@B»\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012:\b\u0002\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010\u0012:\b\u0002\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\rH\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\rH\u0016J\u0018\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\rH\u0016J\b\u0010)\u001a\u00020\rH\u0016J\u0015\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0000¢\u0006\u0002\b,J$\u0010-\u001a\u00020\u00152\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u000bJ\u0010\u0010/\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020\rJ\b\u00100\u001a\u00020\rH\u0002J$\u00101\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J,\u00101\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002JT\u00102\u001a\u00020\u00152\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\r2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020\rH\u0002J(\u0010;\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010>\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u000bH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/larus/business/multitask_management/impl/sheet/MtmServiceSectionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "tag", "", "items", "", "Lcom/larus/multitask_management/api/data/quick_access/QuickAccessNode;", "renderConfig", "Lcom/larus/business/multitask_management/impl/component/SectionRenderConfig;", "enableFold", "", "foldThreshold", "", "enableCardShadow", "onItemClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "bindingAdapterPosition", "clickFrom", "", "onItemLongClick", "Landroid/view/View;", "anchorView", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/larus/business/multitask_management/impl/component/SectionRenderConfig;ZIZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getTag", "()Ljava/lang/String;", "getRenderConfig$impl_mainlandRelease", "()Lcom/larus/business/multitask_management/impl/component/SectionRenderConfig;", "isFolded", "hasUserExpanded", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemCount", "getSpanSize", "spanCount", "getSpanSize$impl_mainlandRelease", "updateItems", "hasMore", "getItemAt", "visibleItemCount", "displayItems", "updateDataInternal", "oldDisplayItems", "newDisplayItems", "oldFullItemCount", "newFullItemCount", "oldIsFolded", "newIsFolded", "oldFoldThreshold", "newFoldThreshold", "isFoldTriggerCardAt", "fullItemCount", "folded", "updateFoldStateAfterItemsChanged", "LargeServiceViewHolder", "SmallServiceViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MtmServiceSectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f320934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<ll9.t> f320935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.business.multitask_management.impl.component.j f320936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f320937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f320938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f320939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function2<Integer, String, Unit> f320940g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function2<Integer, View, Unit> f320941h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f320942i;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u008e\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e2:\b\u0002\u0010\u0015\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/business/multitask_management/impl/sheet/MtmServiceSectionAdapter$LargeServiceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/business/multitask_management/impl/databinding/LarusMtmItemServiceBinding;", "<init>", "(Lcom/larus/business/multitask_management/impl/databinding/LarusMtmItemServiceBinding;)V", "longPressActive", "", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/multitask_management/api/data/quick_access/QuickAccessNode;", "isFoldTriggerCard", "onItemClick", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "bindingAdapterPosition", "", "clickFrom", "onItemLongClick", "Landroid/view/View;", "anchorView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LargeServiceViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f320943c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LarusMtmItemServiceBinding f320944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f320945b;

        public LargeServiceViewHolder(LarusMtmItemServiceBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            super(r100.f320835a);
            this.f320944a = r100;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u008e\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072:\b\u0002\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u00102:\b\u0002\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\f\u0018\u00010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/business/multitask_management/impl/sheet/MtmServiceSectionAdapter$SmallServiceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/business/multitask_management/impl/databinding/LarusMtmItemServiceBinding;", "<init>", "(Lcom/larus/business/multitask_management/impl/databinding/LarusMtmItemServiceBinding;)V", "value", "", "isFoldTriggerCard", "()Z", "longPressActive", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/multitask_management/api/data/quick_access/QuickAccessNode;", "onItemClick", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "bindingAdapterPosition", "", "clickFrom", "onItemLongClick", "Landroid/view/View;", "anchorView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SmallServiceViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f320946d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LarusMtmItemServiceBinding f320947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f320948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f320949c;

        public SmallServiceViewHolder(LarusMtmItemServiceBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            super(r100.f320835a);
            this.f320947a = r100;
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f320950a = null;

        static {
            int[] r100 = new int[SectionCardStyle.values().length];
            r100[SectionCardStyle.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[SectionCardStyle.LARGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f320950a = r100;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (this.f320937d == false) goto L8;
        if (this.f320942i == false) goto L8;
        return RangesKt.coerceIn(this.f320938e, 0, this.f320935b.size());
    L8:
        return this.f320935b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return this.f320936c.f320818d.ordinal();
    }

    public final ll9.t y2(int r100) {
        return (ll9.t) CollectionsKt.getOrNull(this.f320935b, r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        final boolean r100 = z2(r111, this.f320935b.size(), this.f320942i, this.f320938e);
        int r101 = 8;
        if ((r110 instanceof SmallServiceViewHolder) == false) goto L10;
        final SmallServiceViewHolder r112 = (SmallServiceViewHolder) r110;
        ll9.t r113 = (ll9.t) ListProtector.get(this.f320935b, r111);
        final Function2<Integer, String, Unit> r102 = this.f320940g;
        final Function2<Integer, View, Unit> r103 = this.f320941h;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r113, MapController.ITEM_LAYER_TAG);
        r112.f320948b = r100;
        r112.f320949c = false;
        if (r100 == false) goto L7;
        SimpleDraweeView r114 = r112.f320947a.f320837c;
        NodeType r104 = NodeType.UNKNOWN;
        h.b(r114, r104);
        h.a(r112.f320947a.f320837c, r104);
        TextView r115 = r112.f320947a.f320839e;
        int r105 = j0.f375426a;
        r115.setText(j0.d(R.string.larus_appEntryManage_bottomSheet_btn_viewMore));
        com.larus.business.multitask_management.impl.view.f.c(r112.itemView.getContext(), r112.f320947a.f320837c, "res:///2131243073", null, null);
    L8:
        r112.f320947a.f320836b.setVisibility(8);
        r112.f320947a.f320838d.setVisibility(8);
        r112.f320947a.f320835a.setOnTouchListener(new e(r112));
        e1.d(r112.f320947a.f320835a, new f(r102, r112, r100));
        r112.f320947a.f320835a.setOnLongClickListener(new g(r100, r112, r103));
        return;
    L7:
        h.b(r112.f320947a.f320837c, r113.f509774a);
        h.a(r112.f320947a.f320837c, r113.f509774a);
        r112.f320947a.f320839e.setText(r113.f509776c);
        com.larus.business.multitask_management.impl.view.f.c(r112.itemView.getContext(), r112.f320947a.f320837c, r113.f509777d, r113.f509779f, Integer.valueOf(com.larus.business.multitask_management.impl.view.f.b(r113)));
        goto L8
    L10:
        if ((r110 instanceof LargeServiceViewHolder) == false) goto L17;
        final LargeServiceViewHolder r116 = (LargeServiceViewHolder) r110;
        ll9.t r117 = (ll9.t) ListProtector.get(this.f320935b, r111);
        final Function2<Integer, String, Unit> r106 = this.f320940g;
        final Function2<Integer, View, Unit> r107 = this.f320941h;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r117, MapController.ITEM_LAYER_TAG);
        r116.f320945b = false;
        r116.f320944a.f320839e.setText(r117.f509776c);
        h.b(r116.f320944a.f320837c, r117.f509774a);
        h.a(r116.f320944a.f320837c, r117.f509774a);
        com.larus.business.multitask_management.impl.view.f.c(r116.itemView.getContext(), r116.f320944a.f320837c, r117.f509777d, r117.f509779f, Integer.valueOf(com.larus.business.multitask_management.impl.view.f.b(r117)));
        r116.f320944a.f320836b.setVisibility(0);
        e1.d(r116.f320944a.f320836b, new com.larus.business.multitask_management.impl.sheet.a(r106, r116));
        View r118 = r116.f320944a.f320838d;
        if (r100 == false) goto L14;
        r101 = 0;
    L14:
        r118.setVisibility(r101);
        r116.f320944a.f320835a.setOnTouchListener(new b(r116));
        e1.d(r116.f320944a.f320835a, new c(r106, r116, r100));
        r116.f320944a.f320835a.setOnLongClickListener(new d(r116, r107));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        SectionCardStyle r102 = this.f320936c.f320818d;
        int r103 = a.f320950a[r102.ordinal()];
        if (r103 != 1) goto L5;
        LarusMtmItemServiceBinding r104 = LarusMtmItemServiceBinding.a(LayoutInflater.from(r100.getContext()), r100);
        w0.e(r104.f320837c, c7.b(8));
        if (this.f320939f == false) goto L16;
        com.larus.business.multitask_management.impl.view.f.a(r104.f320835a);
    L16:
        return new SmallServiceViewHolder(r104);
    L5:
        if (r103 != 2) goto L11;
        LarusMtmItemServiceBinding r105 = LarusMtmItemServiceBinding.a(LayoutInflater.from(r100.getContext()), r100);
        w0.e(r105.f320837c, c7.b(8));
        if (this.f320939f == false) goto L17;
        com.larus.business.multitask_management.impl.view.f.a(r105.f320835a);
    L17:
        return new LargeServiceViewHolder(r105);
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public final void A2(List<ll9.t> r110, int r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "items");
        final boolean r100 = this.f320942i;
        final int r101 = this.f320938e;
        final int r102 = this.f320935b.size();
        List<ll9.t> r103 = this.f320935b;
        if (this.f320937d == false) goto L6;
        if (r100 == false) goto L6;
        r103 = CollectionsKt.take(r103, RangesKt.coerceIn(r101, 0, r103.size()));
    L6:
        if (r111 <= 0) goto L8;
        this.f320938e = r111;
    L8:
        this.f320935b = r110;
        if (this.f320937d == true) goto L12;
        this.f320942i = false;
    L15:
        final boolean r104 = this.f320942i;
        final int r113 = this.f320938e;
        final int r105 = this.f320935b.size();
        List<ll9.t> r114 = this.f320935b;
        if (this.f320937d == false) goto L19;
        if (r104 == false) goto L19;
        r114 = CollectionsKt.take(r114, RangesKt.coerceIn(r113, 0, r114.size()));
    L19:
        final List<ll9.t> r106 = r114;
        final List<ll9.t> r107 = r103;
        DiffUtil.calculateDiff(new MtmServiceSectionAdapter$updateDataInternal$diffResult$1(r107, r106, this, r102, r100, r101, r105, r104, r113)).dispatchUpdatesTo(this);
        return;
    L12:
        if (r110.size() > this.f320938e) goto L14;
        this.f320942i = r112;
        goto L15
    L14:
        this.f320942i = true;
        goto L15
    }

    public final boolean z2(int r100, int r101, boolean r102, int r103) {
        if (this.f320937d == false) goto L9;
        if (r102 == true) goto L6;
        return false;
    L6:
        if (r100 != (RangesKt.coerceIn(r103, 0, r101) - 1)) goto L11;
        return true;
    L11:
        return false;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MtmServiceSectionAdapter(String r100, List<ll9.t> r101, com.larus.business.multitask_management.impl.component.j r102, boolean r103, int r104, boolean r105, Function2<? super Integer, ? super String, Unit> r106, Function2<? super Integer, ? super View, Unit> r107) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "items");
        Intrinsics.checkNotNullParameter(r102, "renderConfig");
        this.f320934a = r100;
        this.f320935b = r101;
        this.f320936c = r102;
        this.f320937d = r103;
        this.f320938e = r104;
        this.f320939f = r105;
        this.f320940g = r106;
        this.f320941h = r107;
    }
}
