package yv7;

import android.util.SparseIntArray;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes23.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseIntArray f569307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseIntArray f569308b;

    public d() {
        this.f569307a = new SparseIntArray();
        this.f569308b = new SparseIntArray();
    }

    public static int a(long r100) {
        return wv7.a.a(65535 & ((int) (r100 >>> 32)), (int) (r100 & BodyPartID.bodyIdMax));
    }

    public final long b(int r100) {
        SparseIntArray r101 = this.f569308b;
        int r102 = r101.indexOfKey((2130706432 & r100) >>> 24);
        if (r102 < 0) goto L7;
        return (((long) this.f569308b.valueAt(r102)) << 32) | (((long) r100) & BodyPartID.bodyIdMax);
    L7:
        throw new IllegalStateException("Corresponding wrapped view type is not found!");
    }

    public final int c(int r100, int r101) {
        int r102 = (r100 << 16) | ((2130706432 & r101) >>> 24);
        int r103 = this.f569307a.indexOfKey(r102);
        if (r103 < 0) goto L5;
        int r104 = this.f569307a.valueAt(r103);
    L9:
        return wv7.a.a(r104, r101);
    L5:
        int r105 = this.f569307a.size() + 1;
        if (r105 > 127) goto L11;
        this.f569307a.put(r102, r105);
        this.f569308b.put(r105, r102);
        r104 = r105;
        goto L9
    L11:
        throw new IllegalStateException("Failed to allocate a new wrapped view type.");
    }
}
