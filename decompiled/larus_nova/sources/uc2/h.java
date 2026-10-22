package uc2;

import com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.IHeatChangeController;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h extends uc2.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f549441g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Random f549442h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f549443i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IHeatChangeController f549444j;

    public static final class a implements com.bytedance.android.livesdk.interactivity.zdanmaku.f {
        public a() {
        }

        @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.f
        public final com.bytedance.android.livesdk.interactivity.zdanmaku.e a(float r100, com.bytedance.android.livesdk.interactivity.zdanmaku.i r101) {
            Intrinsics.checkNotNullParameter(r101, "danmaku");
            return new com.bytedance.android.livesdk.interactivity.zdanmaku.e((-r100) * r101.f141634d);
        }
    }

    public static final class b implements com.bytedance.android.livesdk.interactivity.zdanmaku.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f549445a;

        public b(h r100) {
            this.f549445a = r100;
        }

        @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.g
        public final float a(com.bytedance.android.livesdk.interactivity.zdanmaku.i r100) {
            Intrinsics.checkNotNullParameter(r100, "danmakuWithLineDanmaku");
            IHeatChangeController r101 = this.f549445a.f549444j;
            if (r101 == null) goto L5;
            IHeatChangeController.DanmakuHeat r102 = r101.a();
        L6:
            if (r102 == null) goto L15;
            int r103 = g.f549440a[r102.ordinal()];
            if (r103 == 1) goto L14;
            if (r103 != 2) goto L15;
        L14:
            return this.f549445a.f549422b;
        L15:
            return this.f549445a.f549442h.nextInt(6);
        L5:
            r102 = null;
            goto L6
        }
    }

    @Override // uc2.b
    public final boolean c() {
        if (this.f549422b <= (-6.0f)) goto L6;
        this.f549422b = -6.0f;
        return true;
    L6:
        return false;
    }

    @Override // uc2.b
    public final boolean d() {
        if (this.f549422b >= 0.0f) goto L6;
        this.f549422b = 0.0f;
        return true;
    L6:
        return false;
    }

    @Override // uc2.b
    public final boolean e() {
        if (this.f549421a <= 1.0f) goto L6;
        this.f549421a = 1.0f;
        return true;
    L6:
        return false;
    }

    @Override // uc2.b
    public final boolean f() {
        if (this.f549421a >= 1.5f) goto L6;
        this.f549421a = 1.5f;
        return true;
    L6:
        return false;
    }

    @Override // uc2.b
    public final a a() {
        return this.f549441g;
    }

    @Override // uc2.b
    public final b b() {
        return this.f549443i;
    }

    public h(int r100, boolean r101, boolean r102, IHeatChangeController r103) {
        super(r100, r101, r102);
        this.f549444j = r103;
        this.f549441g = new a();
        this.f549442h = new Random();
        this.f549443i = new b(this);
    }
}
