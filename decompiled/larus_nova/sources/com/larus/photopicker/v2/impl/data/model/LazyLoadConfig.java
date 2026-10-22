package com.larus.photopicker.v2.impl.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0003J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006#"}, d2 = {"Lcom/larus/photopicker/v2/impl/data/model/LazyLoadConfig;", "Landroid/os/Parcelable;", "scrollThreshold", "", "pageSize", "preloadBuffer", "delayLoadOffscreenPageLimitDuration", "", "<init>", "(IIIJ)V", "getScrollThreshold", "()I", "getPageSize", "getPreloadBuffer", "getDelayLoadOffscreenPageLimitDuration", "()J", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LazyLoadConfig implements Parcelable {
    public static final Parcelable.Creator<LazyLoadConfig> CREATOR = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LazyLoadConfig f364366e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f364367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f364368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f364369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f364370d;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<LazyLoadConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final LazyLoadConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new LazyLoadConfig(r100.readInt(), r100.readInt(), r100.readInt(), r100.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final LazyLoadConfig[] newArray(int r100) {
            return new LazyLoadConfig[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LazyLoadConfig) == true) goto L8;
        return false;
    L8:
        LazyLoadConfig r101 = (LazyLoadConfig) r100;
        if (this.f364367a == r101.f364367a) goto L12;
        return false;
    L12:
        if (this.f364368b == r101.f364368b) goto L15;
        return false;
    L15:
        if (this.f364369c == r101.f364369c) goto L18;
        return false;
    L18:
        if (this.f364370d == r101.f364370d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f364367a * 31) + this.f364368b) * 31) + this.f364369c) * 31;
        long r101 = this.f364370d;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "LazyLoadConfig(scrollThreshold=" + this.f364367a + ", pageSize=" + this.f364368b + ", preloadBuffer=" + this.f364369c + ", delayLoadOffscreenPageLimitDuration=" + this.f364370d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f364367a);
        r100.writeInt(this.f364368b);
        r100.writeInt(this.f364369c);
        r100.writeLong(this.f364370d);
    }

    static {
        CREATOR = new b();
        f364366e = new LazyLoadConfig(15, 64, 16, 100);
    }

    public LazyLoadConfig(int r100, int r101, int r102, long r103) {
        this.f364367a = r100;
        this.f364368b = r101;
        this.f364369c = r102;
        this.f364370d = r103;
    }
}
