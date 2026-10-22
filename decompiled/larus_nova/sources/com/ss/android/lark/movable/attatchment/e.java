package com.ss.android.lark.movable.attatchment;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/movable/attatchment/CGFrame;", "", PlayerResolution.SDKKEY.ORIGIN, "Lcom/ss/android/lark/movable/attatchment/CGPoint;", "size", "Lcom/ss/android/lark/movable/attatchment/CGSize;", "<init>", "(Lcom/ss/android/lark/movable/attatchment/CGPoint;Lcom/ss/android/lark/movable/attatchment/CGSize;)V", "getOrigin", "()Lcom/ss/android/lark/movable/attatchment/CGPoint;", "getSize", "()Lcom/ss/android/lark/movable/attatchment/CGSize;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName(PlayerResolution.SDKKEY.ORIGIN)
    private final f origin;

    @SerializedName("size")
    private final g size;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.origin, r101.origin) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.size, r101.size) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.origin.hashCode() * 31) + this.size.hashCode();
    }

    public final String toString() {
        return "CGFrame(origin=" + this.origin + ", size=" + this.size + ')';
    }

    public final f a() {
        return this.origin;
    }

    public final g b() {
        return this.size;
    }

    public e(f r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r101, "size");
        this.origin = r100;
        this.size = r101;
    }
}
