package cq7;

import android.os.PowerManager;
import android.os.SystemClock;
import aq7.c;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f464791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f464792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f464793c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final boolean a() {
        long r100 = SystemClock.elapsedRealtime();
        long r101 = this.f464793c;
        if (r101 != 0) goto L5;
    L6:
        this.f464793c = r100;
        bq7.a r102 = (bq7.a) this.f464791a;
        float r103 = r102.f20042b.f469683f;
        int r104 = r102.a();
        PowerManager r105 = ((bq7.a) this.f464791a).f20042b.f469679b;
        if (r105 == null) goto L9;
        ?? r106 = r105.isPowerSaveMode();
    L10:
        ((bq7.a) this.f464791a).f20046f.getClass();
        boolean r107 = false;
        if (r103 <= 37) goto L13;
        boolean r108 = false;
    L14:
        ((bq7.a) this.f464791a).f20046f.getClass();
        if (r104 >= 30) goto L17;
        r108 = false;
    L17:
        if (r106 == 1) goto L20;
        r107 = r108;
    L20:
        boolean r109 = hq7.a.f486512a;
        this.f464792b = r107;
    L22:
        return this.f464792b;
    L13:
        r108 = true;
        goto L14
    L9:
        r106 = -1;
        goto L10
    L5:
        if ((r100 - r101) < 5000) goto L22;
        goto L6
    }

    public a(c r100) {
        this.f464792b = false;
        this.f464791a = r100;
    }
}
