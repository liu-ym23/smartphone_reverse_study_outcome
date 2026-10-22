package p22;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g extends f<a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f527395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f527396e;

    public final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f527397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f527398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f527399c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f527400d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f527401e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f527402f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f527403g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f527404h;

        public a(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107) {
            this.f527397a = r100;
            this.f527398b = r101;
            this.f527399c = r102;
            this.f527400d = r103;
            this.f527401e = r104;
            this.f527402f = r105;
            this.f527403g = r106;
            this.f527404h = r107;
        }
    }

    public g(BarrageSettingArea r310, BarrageSettingFont r311, float r312, boolean r313) {
        Intrinsics.checkNotNullParameter(r310, "barrageArea");
        Intrinsics.checkNotNullParameter(r311, "barrageFont");
        super(r310, r311, r312);
        this.f527396e = r313;
        int r100 = h.f527405a[r311.ordinal()];
        if (r100 != 1) goto L5;
        int r210 = m.a(32.0f);
        int r211 = m.a(32.0f);
        int r212 = m.a(30.0f);
        int r213 = m.a(18.0f);
        int r214 = m.a(14.0f);
        int r215 = m.a(22.0f);
        int r314 = m.a(14.0f);
        int r315 = m.a(12.0f);
        m.a(20.0f);
        a r101 = new a(r210, r211, r212, r213, r214, r215, r314, r315);
    L15:
        this.f527395d = r101;
        return;
    L5:
        if (r100 != 2) goto L7;
        int r110 = m.a(28.0f);
        int r111 = m.a(28.0f);
        int r112 = m.a(24.0f);
        int r113 = m.a(14.0f);
        int r114 = m.a(12.0f);
        int r216 = m.a(18.0f);
        int r217 = m.a(12.0f);
        int r218 = m.a(10.0f);
        m.a(16.0f);
        r101 = new a(r110, r111, r112, r113, r114, r216, r217, r218);
        goto L15
    L7:
        if (r100 != 3) goto L9;
        int r102 = m.a(24.0f);
        int r103 = m.a(24.0f);
        int r104 = m.a(18.0f);
        int r105 = m.a(10.0f);
        int r115 = m.a(10.0f);
        int r116 = m.a(14.0f);
        int r117 = m.a(10.0f);
        int r118 = m.a(8.0f);
        m.a(12.0f);
        r101 = new a(r102, r103, r104, r105, r115, r116, r117, r118);
        goto L15
    L9:
        if (r100 == 4) goto L11;
        int r119 = m.a(28.0f);
        int r120 = m.a(28.0f);
        int r121 = m.a(24.0f);
        int r122 = m.a(14.0f);
        int r123 = m.a(12.0f);
        int r124 = m.a(18.0f);
        int r125 = m.a(12.0f);
        int r219 = m.a(10.0f);
        m.a(16.0f);
        r101 = new a(r119, r120, r121, r122, r123, r124, r125, r219);
        goto L15
    L11:
        int r220 = m.a(20.0f);
        int r221 = m.a(20.0f);
        int r222 = m.a(18.0f);
        int r223 = m.a(14.0f);
        int r224 = m.a(10.0f);
        int r225 = m.a(14.0f);
        int r226 = m.a(10.0f);
        int r227 = m.a(8.0f);
        m.a(15.0f);
        r101 = new a(r220, r221, r222, r223, r224, r225, r226, r227);
        goto L15
    }
}
