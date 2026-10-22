package com.larus.dora.impl.device.manage.holder;

import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementFirmwareUpdateBinding;
import com.larus.dora.impl.device.manage.p0;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/impl/device/manage/holder/FirmwareUpdateViewHolder;", "Lcom/larus/dora/impl/device/manage/holder/BaseViewHolder;", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "binding", "Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementFirmwareUpdateBinding;", "onFirmwareUpdateClick", "Lkotlin/Function1;", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementFirmwareUpdateItem;", "", "<init>", "(Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementFirmwareUpdateBinding;Lkotlin/jvm/functions/Function1;)V", "onBind", "data", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FirmwareUpdateViewHolder extends BaseViewHolder<p0> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f333792c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemDoraGDeviceManagementFirmwareUpdateBinding f333793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<com.larus.dora.impl.device.manage.g, Unit> f333794b;

    public static final class a {
    }

    static {
    }

    public FirmwareUpdateViewHolder() {
        throw null;
    }

    @Override // com.larus.dora.impl.device.manage.holder.BaseViewHolder
    public final void U3(p0 r100) {
        p0 r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        final com.larus.dora.impl.device.manage.g r102 = (com.larus.dora.impl.device.manage.g) r101;
        g49.d.d("FirmwareUpdateViewHolder", "onBind: subtitle=" + r102.f333769c);
        this.f333793a.f333381c.setText(r102.f333768b);
        this.f333793a.f333380b.setText(r102.f333769c);
        this.f333793a.f333382d.setText(r102.f333770d);
        e1.d(this.f333793a.f333379a, new k(this, r102));
        e1.d(this.f333793a.f333382d, new l(this, r102));
    }

    public FirmwareUpdateViewHolder(LarusItemDoraGDeviceManagementFirmwareUpdateBinding r100, Function1 r101) {
        super(r100.f333379a);
        this.f333793a = r100;
        this.f333794b = r101;
    }
}
