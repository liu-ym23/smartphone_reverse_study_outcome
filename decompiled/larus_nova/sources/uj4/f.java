package uj4;

import com.bytedance.dora.camera.DoraCameraTrackEvent;

/* JADX INFO: loaded from: classes15.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f550361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraCameraTrackEvent f550362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f550363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f550364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f550365e;

    public final String toString() {
        return "DoraCameraTrackItem{uuid=" + this.f550361a + ", trackEvent=" + this.f550362b + ", fireTime=" + this.f550363c + ", imageMode=" + this.f550364d + ", side=" + this.f550365e + '}';
    }

    public f(int r100, DoraCameraTrackEvent r101, long r102, int r103, int r104) {
        this.f550361a = r100;
        this.f550362b = r101;
        this.f550363c = r102;
        this.f550364d = r103;
        this.f550365e = r104;
    }
}
