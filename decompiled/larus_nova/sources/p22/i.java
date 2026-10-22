package p22;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i extends f<a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f527406d;

    public final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f527407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f527408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String[] f527409c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String[] f527410d;

        public a(int r100, int r101, String[] r102, String[] r103) {
            Intrinsics.checkNotNullParameter(r102, "textColorArr");
            Intrinsics.checkNotNullParameter(r103, "textStrokeColorArr");
            this.f527407a = r100;
            this.f527408b = r101;
            this.f527409c = r102;
            this.f527410d = r103;
        }
    }

    public i(BarrageSettingArea r100, BarrageSettingFont r101, float r102) {
        super(r100, r101, r102);
        if (r101 == null) goto L13;
        int r103 = j.f527411a[r101.ordinal()];
        if (r103 != 1) goto L8;
        a r104 = new a(m.a(20.0f), m.a(32.0f), new String[]{"#ffffff"}, new String[]{"#e6000000"});
    L18:
        this.f527406d = r104;
        return;
    L8:
        if (r103 != 2) goto L10;
        r104 = new a(m.a(16.0f), m.a(28.0f), new String[]{"#ffffff"}, new String[]{"#e6000000"});
        goto L18
    L10:
        if (r103 != 3) goto L12;
        r104 = new a(m.a(12.0f), m.a(24.0f), new String[]{"#ffffff"}, new String[]{"#e6000000"});
        goto L18
    L12:
        if (r103 != 4) goto L13;
        r104 = new a(m.a(14.0f), m.a(22.0f), new String[]{"#ffffff"}, new String[]{"#e6000000"});
    L13:
        r104 = new a(m.a(16.0f), m.a(28.0f), new String[]{"#ffffff"}, new String[]{"#e6000000"});
        goto L18
    }
}
