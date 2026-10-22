package com.larus.dora.obric.device_management.setting.earbuds;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoGeneraGroupLayoutBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.dora.impl.dynamic.dsl.DslTemplateType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u0000 &2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002&'B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013J\u0010\u0010\u0014\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001e\u0010\u001f\u001a\u00020\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010!\u001a\u00020\u001eH\u0016J\u0016\u0010\"\u001a\u00020\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010#\u001a\u00020\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsDslCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "actionHandler", "Lcom/larus/dora/impl/dynamic/event/ActionHandler;", "<init>", "(Lcom/larus/dora/impl/dynamic/event/ActionHandler;)V", "items", "", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "handler", "Landroid/os/Handler;", "setCards", "", "newItems", "", "setCardContext", "updateConnectionState", "newState", "handleEvent", "event", "Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsDslCardAdapter$DslCardAdapterEvent;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "onViewDetachedFromWindow", "onViewRecycled", "getItemCount", "getItemViewType", "Companion", "DslCardAdapterEvent", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsDslCardAdapter extends RecyclerView.Adapter<BaseViewHolder<c59.i>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f339692f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e59.a f339693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c59.i> f339694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d59.b f339695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e59.b f339696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f339697e;

    public static final class a {
    }

    static {
    }

    public DoraObricEarbudsDslCardAdapter() {
        this(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f339694b).size();
    }

    public DoraObricEarbudsDslCardAdapter(e59.a r100) {
        this.f339693a = r100;
        this.f339694b = new ArrayList();
        this.f339696d = e59.b.d.f471064a;
        this.f339697e = new Handler(Looper.getMainLooper());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (((ArrayList) this.f339694b).isEmpty() == false) goto L5;
        return 0;
    L5:
        if (((c59.i) ListProtector.get(this.f339694b, r100)).f22513b == null) goto L13;
        DslTemplateType r101 = ((c59.i) ListProtector.get(this.f339694b, r100)).f22512a;
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.ordinal();
    L13:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        BaseViewHolder r101 = (BaseViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewDetachedFromWindow(r101);
        r101.V3();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        BaseViewHolder r101 = (BaseViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewRecycled(r101);
        r101.onViewRecycled();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BaseViewHolder r102 = (BaseViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        r102.U3();
        r102.T3(ListProtector.get(this.f339694b, r101), this.f339696d, this.f339695c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != DslTemplateType.GENERAL_GROUP.ordinal()) goto L6;
        int r102 = DoraObricEarbudsSettingsGeneralGroupHolder.f339710e;
        Intrinsics.checkNotNullParameter(r100, "parent");
        BaseViewHolder r103 = new DoraObricEarbudsSettingsGeneralGroupHolder(LarusDoraDeviceInfoGeneraGroupLayoutBinding.a(LayoutInflater.from(r100.getContext()), r100));
    L9:
        e59.a r104 = this.f339693a;
        if (r104 == null) goto L12;
        Intrinsics.checkNotNullParameter(r104, "handler");
        r103.f335049a = r104;
    L12:
        return r103;
    L6:
        if (r101 != DslTemplateType.RECONNECT_UNBIND_PANEL.ordinal()) goto L8;
        int r105 = DoraObricEarbudsReconnectUnbindHolder.f339698j;
        Intrinsics.checkNotNullParameter(r100, "parent");
        r103 = new DoraObricEarbudsReconnectUnbindHolder(r100);
        goto L9
    L8:
        r103 = com.larus.dora.impl.dynamic.viewholder.n.a(r100, r101);
        goto L9
    }
}
