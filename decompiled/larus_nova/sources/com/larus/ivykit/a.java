package com.larus.ivykit;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J!\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b\u0018\u00010\u0005HÆ\u0003JO\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR.\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/larus/ivykit/GeckoCleanTargetConfig;", "", "enabled", "", "expiredTargetGroups", "", "", "expiredTargetChannels", "", "<init>", "(ZLjava/util/Map;Ljava/util/Map;)V", "getEnabled", "()Z", "getExpiredTargetGroups", "()Ljava/util/Map;", "getExpiredTargetChannels", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "ivykit_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class a {

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("expired_target_channels")
    private final Map<String, List<String>> expiredTargetChannels;

    @SerializedName("expired_target_groups")
    private final Map<String, String> expiredTargetGroups;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.enabled == r101.enabled) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.expiredTargetGroups, r101.expiredTargetGroups) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.expiredTargetChannels, r101.expiredTargetChannels) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.enabled == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        Map<String, String> r102 = this.expiredTargetGroups;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        Map<String, List<String>> r106 = this.expiredTargetChannels;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "GeckoCleanTargetConfig(enabled=" + this.enabled + ", expiredTargetGroups=" + this.expiredTargetGroups + ", expiredTargetChannels=" + this.expiredTargetChannels + ')';
    }

    public a() {
        Map<String, String> r100 = MapsKt.emptyMap();
        Map<String, List<String>> r101 = MapsKt.emptyMap();
        this.enabled = false;
        this.expiredTargetGroups = r100;
        this.expiredTargetChannels = r101;
    }

    public final boolean a() {
        return this.enabled;
    }

    public final Map<String, List<String>> b() {
        return this.expiredTargetChannels;
    }

    public final Map<String, String> c() {
        return this.expiredTargetGroups;
    }
}
