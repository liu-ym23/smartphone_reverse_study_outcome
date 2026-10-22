package ok4;

import com.larus.dora.api.model.FlowDoraWifiScene;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C7062a f523633b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f523634c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f523635d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f523636e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f523637f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f523638g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f523639a;

    /* JADX INFO: renamed from: ok4.a$a, reason: collision with other inner class name */
    public class C7062a extends a {
        public C7062a() {
            super(FlowDoraWifiScene.OTA);
        }
    }

    public class b extends a {
        public b() {
            super(FlowDoraWifiScene.ALBUM);
        }
    }

    public class c extends a {
        public c() {
            super(FlowDoraWifiScene.ALBUM_SILENT);
        }
    }

    public class d extends a {
        public d() {
            super(FlowDoraWifiScene.LOG_FROM_FEEDBACK);
        }
    }

    public class e extends a {
        public e() {
            super("ALBUM_THUMBNAIL");
        }
    }

    public class f extends a {
        public f() {
            super("ALBUM_THUMBNAIL_SMALL");
        }
    }

    public static final class g extends a {
        public g(int r100) {
            super("VUI(mode:" + r100 + ")");
        }
    }

    static {
        f523633b = new C7062a();
        f523634c = new b();
        f523635d = new c();
        f523636e = new d();
        f523637f = new e();
        f523638g = new f();
    }

    public a(String r100) {
        this.f523639a = r100;
    }
}
