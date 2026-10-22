package com.ss.android.lark.officesdk.api.init;

import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0003J1\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/HostUriParamGroup;", "", "uris", "", "", "params", "", "<init>", "(Ljava/util/Set;Ljava/util/Map;)V", "getUris", "()Ljava/util/Set;", "getParams", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HostUriParamGroup {
    private final Map<String, String> params;
    private final Set<String> uris;

    /* JADX WARN: Multi-variable type inference failed */
    public HostUriParamGroup() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HostUriParamGroup copy$default(HostUriParamGroup r100, Set r101, Map r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.uris;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.params;
    L9:
        return r100.copy(r101, r102);
    }

    public final Set<String> component1() {
        return this.uris;
    }

    public final Map<String, String> component2() {
        return this.params;
    }

    public final HostUriParamGroup copy(Set<String> r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        return new HostUriParamGroup(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HostUriParamGroup) == true) goto L8;
        return false;
    L8:
        HostUriParamGroup r101 = (HostUriParamGroup) r100;
        if (Intrinsics.areEqual(this.uris, r101.uris) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Set<String> r100 = this.uris;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.params.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "HostUriParamGroup(uris=" + this.uris + ", params=" + this.params + ')';
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final Set<String> getUris() {
        return this.uris;
    }

    public HostUriParamGroup(Set<String> r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        this.uris = r100;
        this.params = r101;
    }

    public /* synthetic */ HostUriParamGroup(Set r100, Map r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = SetsKt.emptySet();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = MapsKt.emptyMap();
    L8:
        this(r100, r101);
    }
}
