package iz2;

import com.bytedance.android.monitorV2.DataReporter;
import com.bytedance.android.monitorV2.dataprocessor.TypedDataDispatcher;
import com.bytedance.android.monitorV2.util.l;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, c> f496624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f496625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f496626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f496627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f496628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.monitorV2.webview.b f496629f;

    /* JADX INFO: renamed from: iz2.a$a, reason: collision with other inner class name */
    public static final class C6372a implements c {
        public C6372a() {
        }

        @Override // iz2.a.c
        public final boolean a(JSONObject r100, JSONObject r101) {
            if (r100 != null) goto L6;
            return false;
        L6:
            return r101.toString().equals(r100.toString());
        }
    }

    public static final class b implements c {
        public b() {
        }

        @Override // iz2.a.c
        public final boolean a(JSONObject r100, JSONObject r101) {
            return l.f(l.i(r101, "nativeInfo"), l.i(r100, "nativeInfo"), new String[]{"url", com.alipay.sdk.m.p.e.f25671s, "status_code", "request_error_code", "request_error_msg", "error_no", "error_msg"});
        }
    }

    public interface c {
        boolean a(JSONObject r100, JSONObject r101);
    }

    public static final class d implements c {
        public d() {
        }

        @Override // iz2.a.c
        public final boolean a(JSONObject r100, JSONObject r101) {
            return l.f(l.i(r101, "nativeInfo"), l.i(r100, "nativeInfo"), new String[]{"bridge_name", "error_code", "error_message"});
        }
    }

    public static final class e implements c {
        public e() {
        }

        @Override // iz2.a.c
        public final boolean a(JSONObject r100, JSONObject r101) {
            return l.f(l.i(r101, "nativeInfo"), l.i(r100, "nativeInfo"), new String[]{"bridge_name", "status_code", "status_description"});
        }
    }

    public static final class f implements c {
        public f() {
        }

        @Override // iz2.a.c
        public final boolean a(JSONObject r100, JSONObject r101) {
            return l.f(l.i(r101, "nativeInfo"), l.i(r100, "nativeInfo"), new String[]{"scene", "error_code", "error_msg", BdpAppEventConstant.HTTP_STATUS});
        }
    }

    public final void a() {
        int r100 = this.f496626c;
        if (r100 <= 0) goto L6;
        l.n(this.f496625b, "native_repeat_count", r100);
        TypedDataDispatcher r101 = DataReporter.f162979a;
        DataReporter.f(this.f496629f, this.f496625b, this.f496627d, this.f496628e, null);
        this.f496626c = 0;
        return;
    }

    public a() {
        this.f496624a = MapsKt.mapOf(new Pair[]{TuplesKt.to("jsbError", new d()), TuplesKt.to("fetchError", new b()), TuplesKt.to("nativeError", new f()), TuplesKt.to("jsbPerf", new e()), TuplesKt.to("custom", new C6372a())});
    }
}
