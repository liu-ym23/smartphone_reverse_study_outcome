package com.bytedance.bdp.bdpbase.core;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\t\u0010\f\u001a\u00020\tHÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/bytedance/bdp/bdpbase/core/BdpError;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "toString", "component1", "component2", "code", "msg", "copy", "hashCode", "", "other", "", "equals", "I", "getCode", "()I", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "<init>", "(ILjava/lang/String;)V", "(Landroid/os/Parcel;)V", "Companion", "b", "bdp-base-di_release"}, k = 1, mv = {1, 4, 0})
public final class BdpError implements Parcelable {
    public static final Parcelable.Creator<BdpError> CREATOR = null;
    public static final b Companion = null;
    private final int code;
    private final String msg;

    public static final class a implements Parcelable.Creator<BdpError> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BdpError createFromParcel(Parcel r100) {
            return new BdpError(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BdpError[] newArray(int r100) {
            return new BdpError[r100];
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static /* synthetic */ BdpError copy$default(BdpError r100, int r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.msg;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final BdpError copy(int r100, String r101) {
        return new BdpError(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BdpError) == false) goto L10;
        BdpError r101 = (BdpError) r100;
        if (this.code == r101.code) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r100 = this.code * 31;
        String r101 = this.msg;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    static {
        Companion = new b();
        CREATOR = new a();
    }

    public String toString() {
        return "code:" + this.code + ", msg:" + this.msg;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public BdpError(Parcel r100) {
        int r101 = r100.readInt();
        String r102 = r100.readString();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        this(r101, r102);
    }

    public BdpError(int r100, String r101) {
        this.code = r100;
        this.msg = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.code);
        r100.writeString(this.msg);
    }
}
