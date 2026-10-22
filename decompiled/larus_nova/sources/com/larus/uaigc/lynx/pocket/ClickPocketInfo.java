package com.larus.uaigc.lynx.pocket;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0011JT\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\b\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/larus/uaigc/lynx/pocket/ClickPocketInfo;", "", "pocket", "Lcom/larus/uaigc/lynx/pocket/Pocket;", "originData", "", "", "extra", "isFromAvatarResult", "", "<init>", "(Lcom/larus/uaigc/lynx/pocket/Pocket;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;)V", "getPocket", "()Lcom/larus/uaigc/lynx/pocket/Pocket;", "getOriginData", "()Ljava/util/Map;", "getExtra", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Lcom/larus/uaigc/lynx/pocket/Pocket;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;)Lcom/larus/uaigc/lynx/pocket/ClickPocketInfo;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClickPocketInfo {
    private final Map<String, Object> extra;
    private final Boolean isFromAvatarResult;
    private final Map<String, Object> originData;
    private final Pocket pocket;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClickPocketInfo copy$default(ClickPocketInfo r100, Pocket r101, Map r102, Map r103, Boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.pocket;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.originData;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.extra;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.isFromAvatarResult;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Pocket component1() {
        return this.pocket;
    }

    public final Map<String, Object> component2() {
        return this.originData;
    }

    public final Map<String, Object> component3() {
        return this.extra;
    }

    public final Boolean component4() {
        return this.isFromAvatarResult;
    }

    public final ClickPocketInfo copy(Pocket r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102, Boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "pocket");
        Intrinsics.checkNotNullParameter(r101, "originData");
        Intrinsics.checkNotNullParameter(r102, "extra");
        return new ClickPocketInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ClickPocketInfo) == true) goto L8;
        return false;
    L8:
        ClickPocketInfo r101 = (ClickPocketInfo) r100;
        if (Intrinsics.areEqual(this.pocket, r101.pocket) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.originData, r101.originData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isFromAvatarResult, r101.isFromAvatarResult) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.pocket.hashCode() * 31) + this.originData.hashCode()) * 31) + this.extra.hashCode()) * 31;
        Boolean r101 = this.isFromAvatarResult;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ClickPocketInfo(pocket=" + this.pocket + ", originData=" + this.originData + ", extra=" + this.extra + ", isFromAvatarResult=" + this.isFromAvatarResult + ')';
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final Map<String, Object> getOriginData() {
        return this.originData;
    }

    public final Pocket getPocket() {
        return this.pocket;
    }

    public final Boolean isFromAvatarResult() {
        return this.isFromAvatarResult;
    }

    public ClickPocketInfo(Pocket r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102, Boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "pocket");
        Intrinsics.checkNotNullParameter(r101, "originData");
        Intrinsics.checkNotNullParameter(r102, "extra");
        this.pocket = r100;
        this.originData = r101;
        this.extra = r102;
        this.isFromAvatarResult = r103;
    }

    public /* synthetic */ ClickPocketInfo(Pocket r100, Map r101, Map r102, Boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = MapsKt.emptyMap();
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        this(r100, r101, r102, r103);
    }
}
