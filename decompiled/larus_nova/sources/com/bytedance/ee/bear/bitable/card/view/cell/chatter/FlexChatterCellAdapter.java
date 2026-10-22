package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0016\u0018\u0000 N*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0005:\u0002MNB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010.\u001a\u00020/2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010)J\u001e\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\u001e\u00106\u001a\u00020/2\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u00108\u001a\u000205H\u0016J\b\u00109\u001a\u000205H\u0016J\u0010\u0010:\u001a\u0002052\u0006\u00108\u001a\u000205H\u0016J\b\u0010;\u001a\u000205H\u0016J\u0018\u0010<\u001a\u0002052\u0006\u0010=\u001a\u0002052\u0006\u0010>\u001a\u000205H\u0016J\u0017\u0010?\u001a\u00020\u000f2\b\u0010@\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020\u001fH\u0016J\b\u0010%\u001a\u00020\u001fH\u0016J\b\u0010C\u001a\u000205H\u0016R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R \u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0014\u0010D\u001a\u000205X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0014\u0010G\u001a\u000205X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bH\u0010FR\u0014\u0010I\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0011R\u0014\u0010K\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0011¨\u0006O"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/FlexChatterCellAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/FlexChatterCellAdapter$ChatterViewHolder;", "Lcom/bytedance/ee/bear/bitable/common/widgets/flex/IFlexMeasure;", "<init>", "()V", "mDelegate", "Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/IChatterDelegate;", "getMDelegate", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/IChatterDelegate;", "setMDelegate", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/IChatterDelegate;)V", "maxVisibleLine", "", "getMaxVisibleLine", "()F", "setMaxVisibleLine", "(F)V", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "language", "", "getLanguage", "()Ljava/lang/String;", "mDisableLocaleOpt", "", "fullWidth", "getFullWidth", "()Z", "setFullWidth", "(Z)V", "useNewLayout", "getUseNewLayout", "setUseNewLayout", "mData", "", "getMData", "()Ljava/util/List;", "setMData", "(Ljava/util/List;)V", "setNewData", "", "data", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "getItemViewType", "getItemViewLayoutId", "getMeasureHeight", "widthSpec", "heightSpec", "getItemWidth", "t", "(Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;)F", "isMeasureWidthExactly", "getItemTextSize", "itemHeightDp", "getItemHeightDp", "()I", "fixWidthDp", "getFixWidthDp", "itemMarginStart", "getItemMarginStart", "itemMarginEnd", "getItemMarginEnd", "ChatterViewHolder", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FlexChatterCellAdapter<T extends IChatterEntity> extends RecyclerView.Adapter<ChatterViewHolder<T>> implements com.bytedance.ee.bear.bitable.common.widgets.flex.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e<T> f207511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f207512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f207513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f207514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f207515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f207516f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f207517g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<? extends T> f207518h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f207519i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f207520j;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/FlexChatterCellAdapter$ChatterViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", RootDescription.ROOT_ELEMENT, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "chatterItemView", "Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/ChatterItemView;", "getChatterItemView", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/ChatterItemView;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChatterViewHolder<T extends IChatterEntity> extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ChatterItemView<T> f207521a;

        public ChatterViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
            super(r100);
            this.f207521a = (ChatterItemView) this.itemView.findViewById(R.id.chatter_item);
        }
    }

    public static final class a {
    }

    static {
    }

    public void A2() {
    }

    public int B2() {
        return R.layout.bitable_cell_chatter_rv_item;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public /* synthetic */ float m1() {
        return 0.0f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f207518h.size();
    }

    public FlexChatterCellAdapter() {
        this.f207513c = LazyKt.lazy(new FlexChatterCellAdapter$paint$2(this));
        String r100 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        if (r100 != null) goto L5;
        r100 = Locale.getDefault().getLanguage();
    L5:
        this.f207514d = r100;
        this.f207515e = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("bitable.record.chatter_locale_opt.disable");
        this.f207516f = true;
        this.f207518h = CollectionsKt.emptyList();
        this.f207519i = 38;
        this.f207520j = 42;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final boolean M1() {
        return this.f207517g;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final boolean R() {
        return this.f207516f;
    }

    public int y2() {
        return this.f207520j;
    }

    public int z2() {
        return this.f207519i;
    }

    public final float C2(T r100) {
        Paint r101 = (Paint) this.f207513c.getValue();
        if (r100 == null) goto L6;
        String r102 = r100.getLocalName(this.f207514d);
        if (r102 == null) goto L6;
    L8:
        return r101.measureText(r102) + com.bytedance.ee.util.ui.n.d(y2());
    L6:
        r102 = "";
        goto L8
    }

    public ChatterViewHolder E2(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(B2(), r100, false);
        Intrinsics.checkNotNull(r101);
        return new ChatterViewHolder(r101);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final /* bridge */ /* synthetic */ float g2(Object r100) {
        return C2((IChatterEntity) r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return B2();
    }

    public void D2(ChatterViewHolder<T> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        IChatterEntity r102 = (IChatterEntity) ListProtector.get(this.f207518h, r101);
        ChatterItemView<T> r103 = r100.f207521a;
        r103.setDelegate(this.f207511a);
        String r104 = this.f207514d;
        boolean r105 = this.f207515e;
        Intrinsics.checkNotNullParameter(r102, "chatter");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        BitableAtEditText r106 = r103.f207510c;
        if (r106 == null) goto L10;
        if (r105 == false) goto L6;
        r106.setText(r102.getLocalName(r104));
        goto L10
    L6:
        String r107 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        if (r107 != null) goto L9;
        r107 = Locale.getDefault().getLanguage();
    L9:
        r106.setText(r102.getLocalName(r107));
    L10:
        com.bytedance.ee.bear.bitable.common.h.a(r103.getContext(), r102.getAvatarUrl(), r102.getAvatarKey(), r103.f207509b);
        r103.setOnClickListener(new c(r103, r102));
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("base.useritemview.name.click.disable") == true) goto L16;
        BitableAtEditText r108 = r103.f207510c;
        if (r108 == null) goto L17;
        r108.setOnClickListener(new d(r103, r102));
        return;
    L17:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final int k0(int r100, int r101) {
        if (this.f207512b != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return r101;
    L9:
        if (this.f207516f == false) goto L11;
    L14:
        float r103 = com.bytedance.ee.bear.bitable.common.widgets.flex.a.a(this, this.f207518h, View.MeasureSpec.getSize(r100), this.f207512b);
    L16:
        return View.MeasureSpec.makeMeasureSpec((int) (r103 * com.bytedance.ee.util.ui.n.d(z2())), 1073741824);
    L11:
        if (this.f207517g == true) goto L14;
        r103 = 1.0f;
        goto L16
    L5:
        r102 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        D2((ChatterViewHolder) r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return E2(r100);
    }
}
