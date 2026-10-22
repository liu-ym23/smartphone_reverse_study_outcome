package com.obric.memorydata.sdk.screencapture.rule;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotCacheStrategy;", "Landroid/os/Parcelable;", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Lcom/obric/memorydata/sdk/screencapture/rule/CacheStrategy;", "uniqueNodeViewId", "", "<init>", "(Lcom/obric/memorydata/sdk/screencapture/rule/CacheStrategy;Ljava/lang/String;)V", "getStrategy", "()Lcom/obric/memorydata/sdk/screencapture/rule/CacheStrategy;", "getUniqueNodeViewId", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenshotCacheStrategy implements Parcelable {
    public static final Parcelable.Creator<ScreenshotCacheStrategy> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CacheStrategy f397280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397281b;

    public static final class a implements Parcelable.Creator<ScreenshotCacheStrategy> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ScreenshotCacheStrategy createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ScreenshotCacheStrategy(CacheStrategy.valueOf(r100.readString()), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ScreenshotCacheStrategy[] newArray(int r100) {
            return new ScreenshotCacheStrategy[r100];
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
        if ((r100 instanceof ScreenshotCacheStrategy) == true) goto L8;
        return false;
    L8:
        ScreenshotCacheStrategy r101 = (ScreenshotCacheStrategy) r100;
        if (this.f397280a == r101.f397280a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397281b, r101.f397281b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f397280a.hashCode() * 31;
        String r101 = this.f397281b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ScreenshotCacheStrategy(strategy=" + this.f397280a + ", uniqueNodeViewId=" + this.f397281b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f397280a.name());
        r100.writeString(this.f397281b);
    }

    public ScreenshotCacheStrategy(CacheStrategy r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f397280a = r100;
        this.f397281b = r101;
    }
}
