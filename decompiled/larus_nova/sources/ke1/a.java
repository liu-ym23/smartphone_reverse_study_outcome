package ke1;

import com.bytedance.android.livesdk.toolbarservice.api.IToolbarService;
import jc1.k;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes7.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C6543a f502996a = null;

    /* JADX INFO: renamed from: ke1.a$a, reason: collision with other inner class name */
    public static final class C6543a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C6543a f502997a = null;

        public C6543a() {
        }

        static {
            f502997a = new C6543a();
        }

        @JvmStatic
        public static a a() {
            IToolbarService r100 = (IToolbarService) k.f(IToolbarService.class);
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.tbMonitor();
        }
    }

    static {
        f502996a = C6543a.f502997a;
    }

    void a(f r100);

    void b();

    void c(com.bytedance.android.live.room.api.base.alog.a r100);
}
