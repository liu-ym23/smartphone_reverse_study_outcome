package gr2;

import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import com.bytedance.android.livesdk.revenue.service.livecore.IVideoQualityEnumParam;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class t implements IConfig.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f482333b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f482334c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final t f482335d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final t f482336e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final t f482337f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final t f482338g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final t f482339h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f482340i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qi6.g f482341a;

    public static final class a {
        public a() {
        }

        public static t a(IVideoQualityEnumParam r100) {
            Intrinsics.checkNotNullParameter(r100, "param");
            switch(s.f482332a[r100.ordinal()]) {
                case 1: goto L13;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                default: goto L5;
            };
        L5:
            throw new NoWhenBranchMatchedException();
        L14:
            return t.f482339h;
        L15:
            return t.f482338g;
        L16:
            return t.f482337f;
        L17:
            return t.f482336e;
        L18:
            return t.f482335d;
        L19:
            return t.f482334c;
        L13:
            return t.f482333b;
        }
    }

    static {
        f482340i = new a();
        qi6.g r100 = qi6.g.f533173g;
        f482333b = new t(qi6.g.f533173g);
        f482334c = new t(qi6.g.f533174h);
        f482335d = new t(qi6.g.f533175i);
        f482336e = new t(qi6.g.f533176j);
        f482337f = new t(qi6.g.f533177k);
        f482338g = new t(new qi6.g(640, 480, 15, 800));
        f482339h = new t(new qi6.g(640, 360, 15, 800));
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IConfig.e
    public final int getHeight() {
        return this.f482341a.f533181d;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IConfig.e
    public final int getWidth() {
        return this.f482341a.f533180c;
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f482341a;
    }

    public t(qi6.g r100) {
        this.f482341a = r100;
    }
}
