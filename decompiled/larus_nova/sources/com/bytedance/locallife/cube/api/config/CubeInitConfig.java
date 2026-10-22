package com.bytedance.locallife.cube.api.config;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0000J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/locallife/cube/api/config/CubeInitConfig;", "", "enterFrom", "", "identifierId", "(Ljava/lang/String;Ljava/lang/String;)V", "getEnterFrom", "()Ljava/lang/String;", "setEnterFrom", "(Ljava/lang/String;)V", "getIdentifierId", "setIdentifierId", "component1", "component2", "copy", "different", "", "cubeInitConfig", "equals", "", "other", "hashCode", "", "toString", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CubeInitConfig {
    private String enterFrom;
    private String identifierId;

    /* JADX WARN: Multi-variable type inference failed */
    public CubeInitConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CubeInitConfig copy$default(CubeInitConfig r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enterFrom;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.identifierId;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.enterFrom;
    }

    public final String component2() {
        return this.identifierId;
    }

    public final CubeInitConfig copy(String r100, String r101) {
        return new CubeInitConfig(r100, r101);
    }

    public String toString() {
        return "CubeInitConfig(enterFrom=" + this.enterFrom + ", identifierId=" + this.identifierId + ')';
    }

    public int hashCode() {
        String r100 = this.enterFrom;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        String r102 = this.identifierId;
        if (r102 != null) goto L9;
        return r101;
    L9:
        return (r101 * 31) + r102.hashCode();
    L5:
        r101 = 0;
        goto L6
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getIdentifierId() {
        return this.identifierId;
    }

    public final List<String> different(CubeInitConfig r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L7;
        r101.add("CubeInitConfig");
        return r101;
    L7:
        if (Intrinsics.areEqual(this.enterFrom, r100.enterFrom) == true) goto L10;
        r101.add("CubeInitConfig.enterFrom");
    L10:
        if (Intrinsics.areEqual(this.identifierId, r100.identifierId) == true) goto L12;
        r101.add("CubeInitConfig.identifierId");
    L12:
        return r101;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(CubeInitConfig.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.locallife.cube.api.config.CubeInitConfig");
        CubeInitConfig r102 = (CubeInitConfig) r100;
        if (Intrinsics.areEqual(this.enterFrom, r102.enterFrom) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.identifierId, r102.identifierId) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setEnterFrom(String r100) {
        this.enterFrom = r100;
    }

    public final void setIdentifierId(String r100) {
        this.identifierId = r100;
    }

    public CubeInitConfig(String r100, String r101) {
        this.enterFrom = r100;
        this.identifierId = r101;
    }

    public /* synthetic */ CubeInitConfig(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
