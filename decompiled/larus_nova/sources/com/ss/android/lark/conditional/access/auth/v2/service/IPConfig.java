package com.ss.android.lark.conditional.access.auth.v2.service;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/conditional/access/auth/v2/service/IPConfig;", "", "ipConfigInfo", "", "", "", "<init>", "(Ljava/util/Map;)V", "getIpConfigInfo", "()Ljava/util/Map;", "component1", "copy", "equals", "other", "hashCode", "", "toString", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IPConfig {
    private final Map<String, Boolean> ipConfigInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public IPConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IPConfig copy$default(IPConfig r100, Map r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.ipConfigInfo;
    L6:
        return r100.copy(r101);
    }

    public final Map<String, Boolean> component1() {
        return this.ipConfigInfo;
    }

    public final IPConfig copy(Map<String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "ipConfigInfo");
        return new IPConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IPConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.ipConfigInfo, ((IPConfig) r100).ipConfigInfo) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.ipConfigInfo.hashCode();
    }

    public String toString() {
        return "IPConfig(ipConfigInfo=" + this.ipConfigInfo + ')';
    }

    public final Map<String, Boolean> getIpConfigInfo() {
        return this.ipConfigInfo;
    }

    public IPConfig(Map<String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "ipConfigInfo");
        this.ipConfigInfo = r100;
    }

    public /* synthetic */ IPConfig(Map r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new HashMap();
    L5:
        this(r100);
    }
}
