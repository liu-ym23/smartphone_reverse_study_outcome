package gr2;

import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import com.bytedance.android.livesdk.revenue.service.livecore.IInteractModeEnumParam;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements IConfig.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f482305b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f482306c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f482307d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f482308e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f482309f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InteractMode f482310a;

    public static final class a {
        public a() {
        }

        public static g a(IInteractModeEnumParam r100) {
            Intrinsics.checkNotNullParameter(r100, "param");
            if (r100 != IInteractModeEnumParam.MULTI_ANCHOR) goto L7;
            return g.f482305b;
        L7:
            if (r100 != IInteractModeEnumParam.PK) goto L11;
            return g.f482306c;
        L11:
            if (r100 != IInteractModeEnumParam.GAME_AUDIO) goto L15;
            return g.f482307d;
        L15:
            if (r100 == IInteractModeEnumParam.NORMAL) goto L17;
            return null;
        L17:
            return g.f482308e;
        }

        public static g b(InteractMode r100) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            if (r100 != InteractMode.MULTI_ANCHOR) goto L7;
            return a(IInteractModeEnumParam.MULTI_ANCHOR);
        L7:
            if (r100 != InteractMode.PK) goto L11;
            return a(IInteractModeEnumParam.PK);
        L11:
            if (r100 != InteractMode.GAME_AUDIO) goto L15;
            return a(IInteractModeEnumParam.GAME_AUDIO);
        L15:
            if (r100 == InteractMode.NORMAL) goto L17;
            return null;
        L17:
            return a(IInteractModeEnumParam.NORMAL);
        }
    }

    static {
        f482309f = new a();
        f482305b = new g(InteractMode.MULTI_ANCHOR);
        f482306c = new g(InteractMode.PK);
        f482307d = new g(InteractMode.GAME_AUDIO);
        f482308e = new g(InteractMode.NORMAL);
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f482310a;
    }

    public g(InteractMode r100) {
        this.f482310a = r100;
    }
}
