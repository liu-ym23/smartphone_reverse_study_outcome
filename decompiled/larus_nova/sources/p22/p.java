package p22;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class p extends f<a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f527447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f527448e;

    public final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f527449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f527450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f527451c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f527452d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f527453e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f527454f;

        public a(int r100, int r101, int r102, int r103, int r104, int r105) {
            this.f527449a = r100;
            this.f527450b = r101;
            this.f527451c = r102;
            this.f527452d = r103;
            this.f527453e = r104;
            this.f527454f = r105;
        }
    }

    public final void a(int r100, boolean r101) {
        if (r101 == false) goto L6;
        this.f527447d = new int[]{0, 1};
        return;
    L6:
        if (r100 >= 4) goto L8;
        int[] r102 = {0, RangesKt.coerceAtMost(2, r100 - 1)};
    L9:
        this.f527447d = r102;
        return;
    L8:
        r102 = new int[]{1, RangesKt.coerceAtMost(3, r100 - 1)};
        goto L9
    }

    public p(BarrageSettingArea r210, BarrageSettingFont r211, float r212) {
        super(r210, r211, r212);
        this.f527447d = new int[0];
        if (r211 == null) goto L11;
        int r100 = q.f527455a[r211.ordinal()];
        if (r100 != 1) goto L8;
        a r101 = new a(m.a(20.0f), m.a(30.0f), m.a(28.0f), m.a(24.0f), m.a(10.0f), m.a(32.0f));
    L15:
        this.f527448e = r101;
        return;
    L8:
        if (r100 != 2) goto L10;
        r101 = new a(m.a(16.0f), m.a(24.0f), m.a(20.0f), m.a(18.0f), m.a(10.0f), m.a(24.0f));
        goto L15
    L10:
        if (r100 != 3) goto L11;
        int r110 = m.a(12.0f);
        int r111 = m.a(18.0f);
        int r112 = m.a(17.0f);
        int r213 = m.a(8.0f);
        r101 = new a(r110, r111, r112, m.a(15.0f), r213, m.a(21.0f));
    L11:
        int r102 = m.a(16.0f);
        int r113 = m.a(24.0f);
        int r114 = m.a(20.0f);
        int r115 = m.a(10.0f);
        r101 = new a(r102, r113, r114, m.a(18.0f), r115, m.a(24.0f));
        goto L15
    }
}
