package com.larus.avlink.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0003J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\""}, d2 = {"Lcom/larus/avlink/model/CameraQualitySetting;", "Landroid/os/Parcelable;", "mode", "", "resolution", GearStrategyConsts.EV_QUALITY, "<init>", "(III)V", "getMode", "()I", "setMode", "(I)V", "getResolution", "setResolution", "getQuality", "setQuality", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraQualitySetting implements Parcelable {
    public static final Parcelable.Creator<CameraQualitySetting> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f293403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f293404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f293405c;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<CameraQualitySetting> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final CameraQualitySetting createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new CameraQualitySetting(r100.readInt(), r100.readInt(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final CameraQualitySetting[] newArray(int r100) {
            return new CameraQualitySetting[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CameraQualitySetting) == true) goto L8;
        return false;
    L8:
        CameraQualitySetting r101 = (CameraQualitySetting) r100;
        if (this.f293403a == r101.f293403a) goto L12;
        return false;
    L12:
        if (this.f293404b == r101.f293404b) goto L15;
        return false;
    L15:
        if (this.f293405c == r101.f293405c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f293403a * 31) + this.f293404b) * 31) + this.f293405c;
    }

    public final String toString() {
        return "CameraQualitySetting(mode=" + this.f293403a + ", resolution=" + this.f293404b + ", quality=" + this.f293405c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f293403a);
        r100.writeInt(this.f293404b);
        r100.writeInt(this.f293405c);
    }

    public CameraQualitySetting(int r100, int r101, int r102) {
        this.f293403a = r100;
        this.f293404b = r101;
        this.f293405c = r102;
    }
}
