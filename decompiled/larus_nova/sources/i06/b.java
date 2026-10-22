package i06;

import com.bytedance.ies.abmock.datacenter.init.IABMockInitConfig;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile b f487886e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f487887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f487888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f487889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C6217b f487890d;

    public class a extends j06.b<k06.a> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f487891c;

        @Override // j06.b
        public final k06.a b() {
            c r100 = this.f487891c.f487890d.a();
            if (r100 != null) goto L5;
        L14:
            return null;
        L5:
            if (r100.b() == null) goto L14;
            if (r100.a() == false) goto L16;
            k06.a r101 = r100.b();
            IABMockInitConfig r102 = (IABMockInitConfig) ServiceManager.get().getService(IABMockInitConfig.class);
            if (r102 == null) goto L12;
            r102.getApplication();
        L12:
            r101.init();
        L16:
            return r100.b();
        }

        public a(b r100) {
            this.f487891c = r100;
        }
    }

    /* JADX INFO: renamed from: i06.b$b, reason: collision with other inner class name */
    public class C6217b extends j06.b<c> {
        @Override // j06.b
        public final c b() {
            return j06.a.a();
        }

        public C6217b() {
        }
    }

    public static b a() {
        if (f487886e != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f487886e != null) goto L9;
        f487886e = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f487886e;
    }

    public b() {
        this.f487887a = new ConcurrentHashMap();
        this.f487888b = new ConcurrentHashMap();
        this.f487889c = new a(this);
        this.f487890d = new C6217b();
        new Gson();
    }

    static {
    }
}
