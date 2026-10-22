package com.larus.settings.provider.bootprotector;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/larus/settings/provider/bootprotector/BootProtectDebugConfig;", "", "simulators", "", "Lcom/larus/settings/provider/bootprotector/Simulator;", "version", "", "<init>", "(Ljava/util/List;I)V", "getSimulators", "()Ljava/util/List;", "getVersion", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BootProtectDebugConfig {

    @SerializedName("simulators")
    private final List<Simulator> simulators;

    @SerializedName("version")
    private final int version;

    /* JADX WARN: Multi-variable type inference failed */
    public BootProtectDebugConfig() {
        List r100 = null;
        this(r100, 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BootProtectDebugConfig copy$default(BootProtectDebugConfig r100, List r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.simulators;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.version;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<Simulator> component1() {
        return this.simulators;
    }

    public final int component2() {
        return this.version;
    }

    public final BootProtectDebugConfig copy(List<Simulator> r100, int r101) {
        return new BootProtectDebugConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BootProtectDebugConfig) == true) goto L8;
        return false;
    L8:
        BootProtectDebugConfig r101 = (BootProtectDebugConfig) r100;
        if (Intrinsics.areEqual(this.simulators, r101.simulators) == true) goto L12;
        return false;
    L12:
        if (this.version == r101.version) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<Simulator> r100 = this.simulators;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.version;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "BootProtectDebugConfig(simulators=" + this.simulators + ", version=" + this.version + ')';
    }

    public final List<Simulator> getSimulators() {
        return this.simulators;
    }

    public final int getVersion() {
        return this.version;
    }

    public BootProtectDebugConfig(List<Simulator> r100, int r101) {
        this.simulators = r100;
        this.version = r101;
    }

    public /* synthetic */ BootProtectDebugConfig(List r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
