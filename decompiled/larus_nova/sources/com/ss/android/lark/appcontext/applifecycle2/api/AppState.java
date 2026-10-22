package com.ss.android.lark.appcontext.applifecycle2.api;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0005J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/ss/android/lark/appcontext/applifecycle2/api/AppState;", "Landroid/os/Parcelable;", "isForeground", "", "topProcess", "", "topActivityName", "timestamp", "", "<init>", "(ZLjava/lang/String;Ljava/lang/String;J)V", "()Z", "getTopProcess", "()Ljava/lang/String;", "getTopActivityName", "getTimestamp", "()J", "toText", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "appcontext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppState implements Parcelable {
    public static final Parcelable.Creator<AppState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f408871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f408872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f408873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f408874d;

    public static final class a implements Parcelable.Creator<AppState> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AppState createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() == 0) goto L5;
            boolean r101 = true;
        L7:
            return new AppState(r101, r100.readString(), r100.readString(), r100.readLong());
        L5:
            r101 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final AppState[] newArray(int r100) {
            return new AppState[r100];
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
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AppState) == true) goto L8;
        return false;
    L8:
        AppState r101 = (AppState) r100;
        if (this.f408871a == r101.f408871a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f408872b, r101.f408872b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f408873c, r101.f408873c) == true) goto L18;
        return false;
    L18:
        if (this.f408874d == r101.f408874d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f408871a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f408872b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f408873c;
        if (r106 == null) goto L14;
        r103 = r106.hashCode();
    L14:
        long r107 = this.f408874d;
        return ((r105 + r103) * 31) + ((int) (r107 ^ (r107 >>> 32)));
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppState(isForeground=" + this.f408871a + ", topProcess=" + this.f408872b + ", topActivityName=" + this.f408873c + ", timestamp=" + this.f408874d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f408871a ? 1 : 0);
        r100.writeString(this.f408872b);
        r100.writeString(this.f408873c);
        r100.writeLong(this.f408874d);
    }

    public AppState(boolean r100, String r101, String r102, long r103) {
        this.f408871a = r100;
        this.f408872b = r101;
        this.f408873c = r102;
        this.f408874d = r103;
    }
}
