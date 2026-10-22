package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/IslandCardSession;", "Landroid/os/Parcelable;", "type", "", "flags", "", "<init>", "(IJ)V", "getType", "()I", "getFlags", "()J", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IslandCardSession implements Parcelable {
    public static final Parcelable.Creator<IslandCardSession> CREATOR = null;
    private final long flags;
    private final int type;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<IslandCardSession> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final IslandCardSession createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new IslandCardSession(r100.readInt(), r100.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final IslandCardSession[] newArray(int r100) {
            return new IslandCardSession[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ IslandCardSession copy$default(IslandCardSession r100, int r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.flags;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.type;
    }

    public final long component2() {
        return this.flags;
    }

    public final IslandCardSession copy(int r100, long r101) {
        return new IslandCardSession(r100, r101);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IslandCardSession) == true) goto L8;
        return false;
    L8:
        IslandCardSession r101 = (IslandCardSession) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (this.flags == r101.flags) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.type * 31;
        long r101 = this.flags;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public String toString() {
        return "IslandCardSession(type=" + this.type + ", flags=" + this.flags + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.type);
        r100.writeLong(this.flags);
    }

    public final long getFlags() {
        return this.flags;
    }

    public final int getType() {
        return this.type;
    }

    public IslandCardSession(int r100, long r101) {
        this.type = r100;
        this.flags = r101;
    }
}
