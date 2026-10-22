package m58;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.servicesapi.network.ByteNetEnvHeaderName;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static x58.a f512130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static s f512131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static r f512132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static q f512133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static i f512134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static w f512135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static j f512136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static m58.a f512137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static v f512138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static m f512139j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static b f512140k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static u f512141l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static t f512142m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static o f512143n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static p f512144o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f512145p = null;

    /* JADX INFO: loaded from: classes24.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f512146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile Function0<Unit> f512147b;

        public final void a() {
            if (this.f512146a.compareAndSet(false, true) == false) goto L8;
            Function0<Unit> r100 = this.f512147b;
            if (r100 == null) goto L9;
            r100.invoke();
            return;
        L9:
            return;
        }

        public a() {
            this.f512146a = new AtomicBoolean(false);
        }
    }

    public h() {
    }

    static {
        f512145p = new MutableLiveData(Boolean.FALSE);
    }

    public static t c() {
        return f512142m;
    }

    public static u d() {
        return f512141l;
    }

    public static String a(boolean r100, boolean r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r102, "jsonObject");
    L22:
        e = move-exception;
        m58.a r103 = f512137h;
        if (r103 == null) goto L31;
        r103.ensureNotReachHere(e);
        return "";
    L31:
        return "";
    L4:
        if (c78.a.a().length() <= 0) goto L6;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
        r102.put("proto-version", "v2");     // Catch: JSONException -> L22
        r102.put(ByteNetEnvHeaderName.PPE, "1");     // Catch: JSONException -> L22
        r102.put("x-tt-env", c78.a.a());     // Catch: JSONException -> L22
    L10:
        if (r100 == false) goto L12;
        r102.put("proto-version", "v2");     // Catch: JSONException -> L22
    L12:
        if (r101 == false) goto L14;
        r102.put("concurrent-session-mode", "true");     // Catch: JSONException -> L22
    L14:
        j r105 = f512136g;     // Catch: JSONException -> L22
        if (r105 == null) goto L20;
        Iterator<Map.Entry<String, String>> r106 = r105.a().entrySet().iterator();     // Catch: JSONException -> L22
    L18:
        if (r106.hasNext() == false) goto L20;
        Map.Entry<String, String> r107 = r106.next();     // Catch: JSONException -> L22
        r102.put(r107.getKey(), r107.getValue());     // Catch: JSONException -> L22
    L20:
        return r102.toString();
    L6:
        r104 = false;
        goto L8
    }

    public static /* synthetic */ String b(boolean r100, JSONObject r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 4) == 0) goto L9;
        r101 = new JSONObject();
    L9:
        return a(r100, false, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Runnable, m58.c] */
    public static a e(final long r110, final Function0 r111, final Function0 r112) {
        Intrinsics.checkNotNullParameter(r112, "block");
        final a r100 = new a();
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        final Ref.ObjectRef r113 = new Ref.ObjectRef();
        final ?? r114 = new c(r100, r112, r101, r113, r110, r111);
        r100.f512147b = new d(r114, r101, r113);
        o68.b.f522207a.post(r114);
        return r100;
    }
}
