package com.larus.dora.impl.device.settings.gesture;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001aHÖ\u0001J\t\u0010 \u001a\u00020\u000fHÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006&"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/GestureSettings;", "Landroid/os/Parcelable;", "role", "", "status", "gesture", "function", "<init>", "(BBBB)V", "getRole", "()B", "getStatus", "getGesture", "getFunction", "roleText", "", "statusText", "gestureText", "functionText", "functionSubText", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GestureSettings implements Parcelable {
    public static final Parcelable.Creator<GestureSettings> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f334387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f334388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte f334389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte f334390d;

    public static final class a implements Parcelable.Creator<GestureSettings> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GestureSettings createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new GestureSettings(r100.readByte(), r100.readByte(), r100.readByte(), r100.readByte());
        }

        @Override // android.os.Parcelable.Creator
        public final GestureSettings[] newArray(int r100) {
            return new GestureSettings[r100];
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
        if ((r100 instanceof GestureSettings) == true) goto L8;
        return false;
    L8:
        GestureSettings r101 = (GestureSettings) r100;
        if (this.f334387a == r101.f334387a) goto L12;
        return false;
    L12:
        if (this.f334388b == r101.f334388b) goto L15;
        return false;
    L15:
        if (this.f334389c == r101.f334389c) goto L18;
        return false;
    L18:
        if (this.f334390d == r101.f334390d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f334387a * 31) + this.f334388b) * 31) + this.f334389c) * 31) + this.f334390d;
    }

    public final String toString() {
        return "GestureSettings(role=" + this.f334387a + ", status=" + this.f334388b + ", gesture=" + this.f334389c + ", function=" + this.f334390d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeByte(this.f334387a);
        r100.writeByte(this.f334388b);
        r100.writeByte(this.f334389c);
        r100.writeByte(this.f334390d);
    }

    public GestureSettings(byte r100, byte r101, byte r102, byte r103) {
        this.f334387a = r100;
        this.f334388b = r101;
        this.f334389c = r102;
        this.f334390d = r103;
    }
}
