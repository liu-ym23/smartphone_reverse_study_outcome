package le7;

import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthErrorCode;
import com.bytedance.sdk.xbridge.cn.auth.bean.FeAuthSource;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a<INPUT> {
    public int A;
    public String B;
    public String C;
    public int D;
    public JSONObject E;
    public boolean F;
    public String G;
    public int H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f508942J;
    public boolean K;
    public final Map<String, Object> L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f508944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f508946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f508947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f508948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f508949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f508950h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f508951i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f508952j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f508953k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f508954l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f508955m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IDLXBridgeMethod.XBridgeThreadType f508956n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f508957o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f508958p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f508959q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f508960r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Integer f508961s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f508962t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f508963u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f508964v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f508965w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f508966x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f508967y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f508968z;

    public abstract INPUT b();

    public abstract PlatformType c();

    public abstract String d();

    public JSONObject a() {
        return new JSONObject();
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        this.f508943a = r100;
        this.f508944b = System.currentTimeMillis();
        this.f508945c = UUID.randomUUID().toString();
        this.f508946d = "";
        this.f508947e = "default_bid";
        this.f508948f = System.currentTimeMillis();
        this.f508951i = System.currentTimeMillis();
        this.f508952j = System.currentTimeMillis();
        this.f508953k = -1000;
        this.f508954l = "Get message before callback";
        this.f508957o = true;
        this.f508958p = "argus://unset_argus_auth_url";
        this.f508959q = "";
        this.f508960r = "";
        this.f508961s = 0;
        this.f508963u = IDLXBridgeMethod.Access.PRIVATE.getValue();
        AuthErrorCode r101 = AuthErrorCode.NO_FE_ID_CONFIG;
        this.f508964v = -1;
        this.f508965w = System.currentTimeMillis();
        this.f508966x = System.currentTimeMillis();
        this.f508968z = "";
        this.B = "";
        this.C = "";
        this.F = true;
        this.G = FeAuthSource.NULL.getDesc();
        this.L = new LinkedHashMap();
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f508946d = r100;
    }
}
