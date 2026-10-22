package uc2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<Integer> f549452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<c> f549453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f549454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f549455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f549456e;

    public static final class a {
    }

    static {
    }

    public k(q72.a r100) {
        Intrinsics.checkNotNullParameter(r100, "initialConfig");
        this.f549452a = new ArrayList();
        this.f549453b = new ArrayList();
        this.f549454c = new int[]{3, 9};
        this.f549455d = RangesKt.random(new IntRange(18, 36), Random.Default);
        this.f549456e = new int[]{3, 9, 0, 6, 2, 4, 8, 10, 1, 5, 7, 11};
        int r101 = 0;
    L3:
        if (r101 >= 12) goto L5;
        this.f549453b.add(new i(r101));
        r101 = r101 + 1;
        goto L3
    }

    public final void a(int r100, com.bytedance.android.livesdk.interactivity.zdanmaku.i r101) {
        Intrinsics.checkNotNullParameter(r101, "danmaku");
        Object r102 = ListProtector.get(this.f549453b, r100);
        if (r102 == null) goto L7;
        ((i) r102).f549449e.remove(r101);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.LiveRadiusDanmakuLine");
    }
}
