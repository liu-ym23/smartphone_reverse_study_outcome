package cp0;

import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f464615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f464616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f464617c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f464618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f464619b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f464620c;

        public a(String r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "appId");
            this.f464618a = r100;
            this.f464619b = r101;
            this.f464620c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public IOpenPlatformAnchorService.a f464621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IOpenPlatformAnchorService.a f464622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f464623c;

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "sessionId");
            this.f464623c = r100;
        }
    }

    public d() {
    }

    static {
        f464617c = new d();
    }

    @JvmStatic
    public static final synchronized boolean a() {
        monitor-enter(d.class);
        if (f464616b == null) goto L7;
        boolean r100 = true;
    L8:
        monitor-exit(d.class);
        return r100;
    L7:
        r100 = false;
    L10:
        th = move-exception;
        throw th;
    }
}
