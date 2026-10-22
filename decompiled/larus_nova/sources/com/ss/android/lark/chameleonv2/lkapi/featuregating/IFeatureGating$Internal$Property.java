package com.ss.android.lark.chameleonv2.lkapi.featuregating;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/featuregating/IFeatureGating$Internal$Property;", "Lcom/bytedance/ee/util/io/NonProguard;", "runtimeConfigs", "Lcom/ss/android/lark/chameleonv2/lkapi/featuregating/IFeatureGating$Internal$AllStatusesAndValues;", "runtimeTimestamp", "", "startupConfigs", "startupTimestamp", "<init>", "(Lcom/ss/android/lark/chameleonv2/lkapi/featuregating/IFeatureGating$Internal$AllStatusesAndValues;ILcom/ss/android/lark/chameleonv2/lkapi/featuregating/IFeatureGating$Internal$AllStatusesAndValues;I)V", "getRuntimeConfigs", "()Lcom/ss/android/lark/chameleonv2/lkapi/featuregating/IFeatureGating$Internal$AllStatusesAndValues;", "getRuntimeTimestamp", "()I", "getStartupConfigs", "getStartupTimestamp", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IFeatureGating$Internal$Property implements NonProguard {
    private final IFeatureGating$Internal$AllStatusesAndValues runtimeConfigs;
    private final int runtimeTimestamp;
    private final IFeatureGating$Internal$AllStatusesAndValues startupConfigs;
    private final int startupTimestamp;

    public static /* synthetic */ IFeatureGating$Internal$Property copy$default(IFeatureGating$Internal$Property r100, IFeatureGating$Internal$AllStatusesAndValues r101, int r102, IFeatureGating$Internal$AllStatusesAndValues r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.runtimeConfigs;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.runtimeTimestamp;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.startupConfigs;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.startupTimestamp;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final IFeatureGating$Internal$AllStatusesAndValues component1() {
        return this.runtimeConfigs;
    }

    public final int component2() {
        return this.runtimeTimestamp;
    }

    public final IFeatureGating$Internal$AllStatusesAndValues component3() {
        return this.startupConfigs;
    }

    public final int component4() {
        return this.startupTimestamp;
    }

    public final IFeatureGating$Internal$Property copy(IFeatureGating$Internal$AllStatusesAndValues r100, int r101, IFeatureGating$Internal$AllStatusesAndValues r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "runtimeConfigs");
        Intrinsics.checkNotNullParameter(r102, "startupConfigs");
        return new IFeatureGating$Internal$Property(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IFeatureGating$Internal$Property) == true) goto L8;
        return false;
    L8:
        IFeatureGating$Internal$Property r101 = (IFeatureGating$Internal$Property) r100;
        if (Intrinsics.areEqual(this.runtimeConfigs, r101.runtimeConfigs) == true) goto L12;
        return false;
    L12:
        if (this.runtimeTimestamp == r101.runtimeTimestamp) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.startupConfigs, r101.startupConfigs) == true) goto L18;
        return false;
    L18:
        if (this.startupTimestamp == r101.startupTimestamp) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.runtimeConfigs.hashCode() * 31) + this.runtimeTimestamp) * 31) + this.startupConfigs.hashCode()) * 31) + this.startupTimestamp;
    }

    public String toString() {
        return "Property(runtimeConfigs=" + this.runtimeConfigs + ", runtimeTimestamp=" + this.runtimeTimestamp + ", startupConfigs=" + this.startupConfigs + ", startupTimestamp=" + this.startupTimestamp + ')';
    }

    public final IFeatureGating$Internal$AllStatusesAndValues getRuntimeConfigs() {
        return this.runtimeConfigs;
    }

    public final int getRuntimeTimestamp() {
        return this.runtimeTimestamp;
    }

    public final IFeatureGating$Internal$AllStatusesAndValues getStartupConfigs() {
        return this.startupConfigs;
    }

    public final int getStartupTimestamp() {
        return this.startupTimestamp;
    }

    public IFeatureGating$Internal$Property(IFeatureGating$Internal$AllStatusesAndValues r100, int r101, IFeatureGating$Internal$AllStatusesAndValues r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "runtimeConfigs");
        Intrinsics.checkNotNullParameter(r102, "startupConfigs");
        this.runtimeConfigs = r100;
        this.runtimeTimestamp = r101;
        this.startupConfigs = r102;
        this.startupTimestamp = r103;
    }
}
