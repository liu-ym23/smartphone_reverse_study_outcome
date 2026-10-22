package com.larus.dora.impl.device.manage.holder;

import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementMoreFeaturesBinding;
import com.larus.dora.impl.device.manage.p0;
import com.larus.dora.impl.device.manage.s0;
import com.larus.dora.impl.resource.DoraDrawableDensity;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB#\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/dora/impl/device/manage/holder/MoreFeaturesViewHolder;", "Lcom/larus/dora/impl/device/manage/holder/BaseViewHolder;", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "binding", "Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementMoreFeaturesBinding;", "onMoreFeaturesClick", "Lkotlin/Function0;", "", "<init>", "(Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementMoreFeaturesBinding;Lkotlin/jvm/functions/Function0;)V", "onBind", "data", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoreFeaturesViewHolder extends BaseViewHolder<p0> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f333801c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemDoraGDeviceManagementMoreFeaturesBinding f333802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f333803b;

    public static final class a {
    }

    static {
    }

    public MoreFeaturesViewHolder() {
        throw null;
    }

    @Override // com.larus.dora.impl.device.manage.holder.BaseViewHolder
    public final void U3(p0 r100) {
        p0 r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        s0 r102 = (s0) r101;
        g49.d.d("MoreFeaturesViewHolder", "onBind: title=" + r102.f333911b);
        this.f333802a.f333393e.setText(r102.f333911b);
        this.f333802a.f333392d.setText(r102.f333912c);
        LarusItemDoraGDeviceManagementMoreFeaturesBinding r103 = this.f333802a;
        r103.f333391c.setImageDrawable(com.larus.dora.impl.resource.j0.f(com.larus.dora.impl.resource.j0.f337886a, r103.f333389a.getContext(), DoraResourceDeviceType.G1, r102.f333913d, DoraDrawableDensity.XXHDPI, 8));
        this.f333802a.f333389a.setOnClickListener(new o(this));
        this.f333802a.f333390b.setOnClickListener(new p(this));
    }

    public MoreFeaturesViewHolder(LarusItemDoraGDeviceManagementMoreFeaturesBinding r100, Function0 r101) {
        super(r100.f333389a);
        this.f333802a = r100;
        this.f333803b = r101;
    }
}
