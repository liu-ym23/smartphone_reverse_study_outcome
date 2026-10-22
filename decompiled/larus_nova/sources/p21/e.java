package p21;

import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements com.bytedance.android.live.revlink.impl.pk.utils.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f527376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.global.c f527377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f527378c;

    @Override // com.bytedance.android.live.revlink.impl.pk.utils.d
    public final long a() {
        i97.a r100 = i97.a.f488802a;
        long r101 = System.currentTimeMillis();
        long r102 = this.f527378c;
        Long r103 = this.f527376a;
        if (r103 == null) goto L5;
        long r104 = r103.longValue();
    L7:
        return r102 + (r101 - r104);
    L5:
        r104 = r101;
        goto L7
    }

    public final void b() {
        i97.a r100 = i97.a.f488802a;
        long r101 = System.currentTimeMillis();
        long r102 = this.f527378c;
        Long r103 = this.f527376a;
        if (r103 == null) goto L5;
        long r104 = r103.longValue();
    L6:
        this.f527378c = r102 + RangesKt.coerceAtLeast(r101 - r104, 0);
        return;
    L5:
        r104 = r101;
        goto L6
    }

    public e(com.bytedance.android.live.revlink.impl.global.c r100) {
        this.f527377b = r100;
        this.f527378c = 0;
    }
}
