package com.obric.capabilitykit.common;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/common/VersionInfo;", "", "version", "", "(I)V", "getVersion", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VersionInfo {

    @SerializedName("Version")
    private final int version;

    public VersionInfo(int r100) {
        this.version = r100;
    }

    public static /* synthetic */ VersionInfo copy$default(VersionInfo r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.version;
    L6:
        return r100.copy(r101);
    }

    public final int component1() {
        return this.version;
    }

    public final VersionInfo copy(int r100) {
        return new VersionInfo(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VersionInfo) == true) goto L9;
        return false;
    L9:
        if (this.version == ((VersionInfo) r100).version) goto L11;
        return false;
    L11:
        return true;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.version;
    }

    public String toString() {
        return "VersionInfo(version=" + this.version + ')';
    }
}
