package p22;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends f<a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f527384d;

    public final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f527385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f527386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f527387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f527388d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f527389e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f527390f;

        public a(int r100, int r101, int r102, int r103, int r104, int r105) {
            this.f527385a = r100;
            this.f527386b = r101;
            this.f527387c = r102;
            this.f527388d = r103;
            this.f527389e = r104;
            this.f527390f = r105;
        }
    }

    public c(BarrageSettingArea r110, BarrageSettingFont r111, float r210) {
        Intrinsics.checkNotNullParameter(r110, "barrageArea");
        Intrinsics.checkNotNullParameter(r111, "barrageFont");
        super(r110, r111, r210);
        int r100 = d.f527391a[r111.ordinal()];
        if (r100 != 1) goto L5;
        m.a(32.0f);
        a r101 = new a(m.a(32.0f), m.a(60.0f), m.a(32.0f), m.a(20.0f), m.a(26.0f), m.a(22.0f));
    L15:
        this.f527384d = r101;
        return;
    L5:
        if (r100 != 2) goto L7;
        m.a(28.0f);
        r101 = new a(m.a(28.0f), m.a(52.5f), m.a(28.0f), m.a(17.5f), m.a(24.0f), m.a(14.0f));
        goto L15
    L7:
        if (r100 != 3) goto L9;
        m.a(24.0f);
        r101 = new a(m.a(21.0f), m.a(40.5f), m.a(21.0f), m.a(13.5f), m.a(18.0f), m.a(12.0f));
        goto L15
    L9:
        if (r100 == 4) goto L11;
        m.a(28.0f);
        r101 = new a(m.a(28.0f), m.a(52.5f), m.a(28.0f), m.a(17.5f), m.a(24.0f), m.a(14.0f));
        goto L15
    L11:
        m.a(20.0f);
        r101 = new a(m.a(20.0f), m.a(37.5f), m.a(20.0f), m.a(12.5f), m.a(18.0f), m.a(14.0f));
        goto L15
    }
}
