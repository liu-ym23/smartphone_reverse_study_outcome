package p22;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends f<C7142a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C7142a f527379d;

    /* JADX INFO: renamed from: p22.a$a, reason: collision with other inner class name */
    public final class C7142a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f527380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f527381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f527382c;

        public C7142a(int r100, int r101, int r102) {
            this.f527380a = r100;
            this.f527381b = r101;
            this.f527382c = r102;
        }
    }

    public a(BarrageSettingArea r100, BarrageSettingFont r101, float r102) {
        super(r100, r101, r102);
        if (r101 == null) goto L13;
        int r103 = b.f527383a[r101.ordinal()];
        if (r103 != 1) goto L8;
        C7142a r104 = new C7142a(m.a(20.0f), m.a(27.5f), m.a(46.0f));
    L18:
        this.f527379d = r104;
        return;
    L8:
        if (r103 != 2) goto L10;
        r104 = new C7142a(m.a(16.0f), m.a(24.0f), m.a(42.0f));
        goto L18
    L10:
        if (r103 != 3) goto L12;
        r104 = new C7142a(m.a(12.0f), m.a(18.0f), m.a(29.0f));
        goto L18
    L12:
        if (r103 != 4) goto L13;
        r104 = new C7142a(m.a(16.0f), m.a(20.0f), m.a(38.0f));
    L13:
        r104 = new C7142a(m.a(16.0f), m.a(24.0f), m.a(42.0f));
        goto L18
    }
}
