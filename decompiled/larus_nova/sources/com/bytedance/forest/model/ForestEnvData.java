package com.bytedance.forest.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/forest/model/ForestEnvData;", "", "type", "Lcom/bytedance/forest/model/ForestEnvType;", "name", "", "(Lcom/bytedance/forest/model/ForestEnvType;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getType", "()Lcom/bytedance/forest/model/ForestEnvType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "forest_release"}, k = 1, mv = {1, 1, 16})
public final class ForestEnvData {
    private final String name;
    private final ForestEnvType type;

    public static /* synthetic */ ForestEnvData copy$default(ForestEnvData r100, ForestEnvType r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.name;
    L9:
        return r100.copy(r101, r102);
    }

    public final ForestEnvType component1() {
        return this.type;
    }

    public final String component2() {
        return this.name;
    }

    public final ForestEnvData copy(ForestEnvType r100, String r101) {
        return new ForestEnvData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ForestEnvData) == false) goto L10;
        ForestEnvData r101 = (ForestEnvData) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        ForestEnvType r100 = this.type;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ForestEnvData(type=" + this.type + ", name=" + this.name + ")";
    }

    public final String getName() {
        return this.name;
    }

    public final ForestEnvType getType() {
        return this.type;
    }

    public ForestEnvData(ForestEnvType r100, String r101) {
        this.type = r100;
        this.name = r101;
    }
}
