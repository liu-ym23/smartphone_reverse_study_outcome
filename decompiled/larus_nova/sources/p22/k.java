package p22;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.mt.protector.impl.color.ColorProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class k extends f<b> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f527412h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f527413i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f527414j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f527415k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f527416l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f527417m = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f527418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f527419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f527420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f527421g;

    public static final class a {
    }

    public final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f527422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f527423b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f527424c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f527425d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f527426e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f527427f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f527428g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f527429h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f527430i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f527431j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f527432k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f527433l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f527434m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f527435n;

        public b(int r100, int r101, int r102, int r110, int r111, int r112, int r113) {
            int r103 = k.f527415k;
            int r104 = k.f527416l;
            int r105 = m.a(16.0f);
            int r106 = k.f527413i;
            int r107 = k.f527414j;
            m.a(16.0f);
            int r108 = k.f527412h;
            this.f527422a = r100;
            this.f527423b = r101;
            this.f527424c = r102;
            this.f527425d = r110;
            this.f527426e = r111;
            this.f527427f = r112;
            this.f527428g = r113;
            this.f527429h = r103;
            this.f527430i = r104;
            this.f527431j = r105;
            this.f527432k = r106;
            this.f527433l = r107;
            this.f527434m = -1;
            this.f527435n = r108;
        }
    }

    static {
        f527412h = ColorProtector.parseColor("#80000000");
        f527413i = ColorProtector.parseColor("#D1F4FF");
        f527414j = ColorProtector.parseColor("#8000315E");
        f527415k = ColorProtector.parseColor("#FFE8AE");
        f527416l = ColorProtector.parseColor("#802F1600");
        f527417m = m.a(24.0f);
    }

    public final void a(int r100) {
        int r101 = r100 - 1;
        if (this.f527392a != BarrageSettingArea.FULL) goto L5;
        int r102 = r101 / 2;
        int[] r103 = {r102 - 1, r102};
    L6:
        this.f527419e = r103;
        if (r101 > 0) goto L10;
        this.f527419e = new int[]{0, 0};
        return;
    L10:
        return;
    L5:
        r103 = new int[]{r101 - 1, r101};
        goto L6
    }

    public k(BarrageSettingArea r210, BarrageSettingFont r211, float r310) {
        super(r210, r211, r310);
        if (r211 == null) goto L11;
        int r100 = l.f527436a[r211.ordinal()];
        if (r100 != 1) goto L8;
        m.a(32.0f);
        int r110 = m.a(20.0f);
        int r111 = m.a(30.0f);
        int r212 = m.a(14.0f);
        int r213 = m.a(20.0f);
        int r214 = m.a(30.0f);
        int r215 = m.a(130.0f);
        int r216 = m.a(100.0f);
        m.a(50.0f);
        b r101 = new b(r110, r111, r212, r213, r214, r215, r216);
    L15:
        this.f527418d = r101;
        this.f527419e = new int[0];
        this.f527420f = m.a(200.0f);
        m.a(140.0f);
        this.f527421g = m.a(100.0f);
        m.a(40.0f);
        return;
    L8:
        if (r100 != 2) goto L10;
        m.a(28.0f);
        int r112 = m.a(16.0f);
        int r113 = m.a(24.0f);
        int r114 = m.a(13.0f);
        int r115 = m.a(16.0f);
        int r116 = m.a(24.0f);
        int r117 = m.a(100.0f);
        int r118 = m.a(75.0f);
        m.a(45.0f);
        r101 = new b(r112, r113, r114, r115, r116, r117, r118);
        goto L15
    L10:
        if (r100 != 3) goto L11;
        m.a(24.0f);
        int r217 = m.a(12.0f);
        int r218 = m.a(19.0f);
        int r219 = m.a(12.0f);
        int r220 = m.a(12.0f);
        int r221 = m.a(19.0f);
        int r222 = m.a(70.0f);
        int r223 = m.a(50.0f);
        m.a(40.0f);
        r101 = new b(r217, r218, r219, r220, r221, r222, r223);
    L11:
        m.a(28.0f);
        int r119 = m.a(16.0f);
        int r120 = m.a(24.0f);
        int r121 = m.a(13.0f);
        int r122 = m.a(16.0f);
        int r123 = m.a(24.0f);
        int r124 = m.a(100.0f);
        int r125 = m.a(75.0f);
        m.a(40.0f);
        r101 = new b(r119, r120, r121, r122, r123, r124, r125);
        goto L15
    }
}
