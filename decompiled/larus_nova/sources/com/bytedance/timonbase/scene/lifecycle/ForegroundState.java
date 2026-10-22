package com.bytedance.timonbase.scene.lifecycle;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/timonbase/scene/lifecycle/ForegroundState;", "Landroid/os/Parcelable;", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "timonbase_release"}, k = 1, mv = {1, 4, 0})
public final class ForegroundState implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f270886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f270887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f270888c;

    public static final class a implements Parcelable.Creator<ForegroundState> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForegroundState createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            boolean r102 = false;
            if (r100.readByte() == ((byte) 0)) goto L6;
            r102 = true;
        L6:
            return new ForegroundState(r101, r102, r100.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final ForegroundState[] newArray(int r100) {
            return new ForegroundState[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ForegroundState) == false) goto L12;
        ForegroundState r101 = (ForegroundState) r100;
        if (this.f270886a == r101.f270886a) goto L8;
        return false;
    L8:
        if (this.f270887b == r101.f270887b) goto L10;
        return false;
    L10:
        if (this.f270888c == r101.f270888c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final int hashCode() {
        int r100 = this.f270886a * 31;
        boolean r101 = this.f270887b;
        ?? r102 = r101;
        if (r101 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = (r100 + r102) * 31;
        long r104 = this.f270888c;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "ForegroundState(pid=" + this.f270886a + ", foreground=" + this.f270887b + ", time=" + this.f270888c + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f270886a);
        r100.writeByte(this.f270887b ? 1 : 0);
        r100.writeLong(this.f270888c);
    }

    public ForegroundState(int r100, boolean r101, long r102) {
        this.f270886a = r100;
        this.f270887b = r101;
        this.f270888c = r102;
    }
}
