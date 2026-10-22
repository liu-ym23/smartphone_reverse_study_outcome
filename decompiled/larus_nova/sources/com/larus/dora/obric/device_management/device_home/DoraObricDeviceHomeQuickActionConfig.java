package com.larus.dora.obric.device_management.device_home;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÂ\u0003J\u001b\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0015\u001a\u00020\rHÖ\u0001R\u0018\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeQuickActionConfig;", "", "rawActions", "", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeQuickActionConfigItem;", "<init>", "(Ljava/util/List;)V", SlcCommonAction.KEY_ACTIONS, "getActions", "()Ljava/util/List;", "resolveOrder", "", "key", "", "defaultOrder", "component1", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricDeviceHomeQuickActionConfig {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final List<DoraObricDeviceHomeQuickActionConfigItem> rawActions;

    /* JADX WARN: Multi-variable type inference failed */
    public DoraObricDeviceHomeQuickActionConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final List<DoraObricDeviceHomeQuickActionConfigItem> component1() {
        return this.rawActions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DoraObricDeviceHomeQuickActionConfig copy$default(DoraObricDeviceHomeQuickActionConfig r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.rawActions;
    L6:
        return r100.copy(r101);
    }

    public final DoraObricDeviceHomeQuickActionConfig copy(List<DoraObricDeviceHomeQuickActionConfigItem> r100) {
        return new DoraObricDeviceHomeQuickActionConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoraObricDeviceHomeQuickActionConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.rawActions, ((DoraObricDeviceHomeQuickActionConfig) r100).rawActions) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<DoraObricDeviceHomeQuickActionConfigItem> r100 = this.rawActions;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "DoraObricDeviceHomeQuickActionConfig(rawActions=" + this.rawActions + ')';
    }

    public final List<DoraObricDeviceHomeQuickActionConfigItem> getActions() {
        List<DoraObricDeviceHomeQuickActionConfigItem> r100 = this.rawActions;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public DoraObricDeviceHomeQuickActionConfig(List<DoraObricDeviceHomeQuickActionConfigItem> r100) {
        this.rawActions = r100;
    }

    public final int resolveOrder(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Iterator<T> r102 = getActions().iterator();
    L3:
        Integer r103 = null;
        if (r102.hasNext() == false) goto L8;
        Object r104 = r102.next();
        if (Intrinsics.areEqual(((DoraObricDeviceHomeQuickActionConfigItem) r104).getKey(), r100) == false) goto L3;
    L9:
        DoraObricDeviceHomeQuickActionConfigItem r105 = (DoraObricDeviceHomeQuickActionConfigItem) r104;
        if (r105 == null) goto L25;
        Integer r106 = r105.getOrder();
        if (r106 != null) goto L14;
        return r101;
    L14:
        if (r106.intValue() < 0) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L19;
        r103 = r106;
    L19:
        if (r103 != null) goto L21;
        return r101;
    L21:
        return r103.intValue();
    L16:
        r107 = false;
        goto L17
    L25:
        return r101;
    L8:
        r104 = null;
        goto L9
    }

    public /* synthetic */ DoraObricDeviceHomeQuickActionConfig(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
