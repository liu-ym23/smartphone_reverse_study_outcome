package com.bytedance.ee.space.sync;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/space/sync/PushExtraParams;", "Lcom/bytedance/ee/util/io/NonProguard;", "version", "", "objType", "<init>", "(II)V", "getVersion", "()I", "setVersion", "(I)V", "getObjType", "setObjType", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "contentmanager-space-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PushExtraParams implements NonProguard {
    private int objType;
    private int version;

    public static /* synthetic */ PushExtraParams copy$default(PushExtraParams r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.version;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.objType;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.version;
    }

    public final int component2() {
        return this.objType;
    }

    public final PushExtraParams copy(int r100, int r101) {
        return new PushExtraParams(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PushExtraParams) == true) goto L8;
        return false;
    L8:
        PushExtraParams r101 = (PushExtraParams) r100;
        if (this.version == r101.version) goto L12;
        return false;
    L12:
        if (this.objType == r101.objType) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.version * 31) + this.objType;
    }

    public String toString() {
        return "PushExtraParams(version=" + this.version + ", objType=" + this.objType + ')';
    }

    public final int getObjType() {
        return this.objType;
    }

    public final int getVersion() {
        return this.version;
    }

    public final void setObjType(int r100) {
        this.objType = r100;
    }

    public final void setVersion(int r100) {
        this.version = r100;
    }

    public PushExtraParams(int r100, int r101) {
        this.version = r100;
        this.objType = r101;
    }

    public /* synthetic */ PushExtraParams(int r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = -1;
    L5:
        this(r100, r101);
    }
}
