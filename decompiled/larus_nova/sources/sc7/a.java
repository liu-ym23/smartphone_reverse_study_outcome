package sc7;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f541360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f541361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, cra.a> f541362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Map<String, cra.a>> f541363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f541364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f541365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f541366g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f541367h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f541368i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f541369j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f541370k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f541371l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f541372m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f541373n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public JSONObject f541374o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public JSONObject f541375p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public JSONObject f541376q;

    public a() {
        this.f541362c = new HashMap();
        this.f541363d = new HashMap();
    }

    public a(JSONObject r100) {
        this.f541362c = new HashMap();
        this.f541363d = new HashMap();
        this.f541375p = r100;
        JSONObject r101 = r100.optJSONObject("data");
        this.f541374o = r101;
        this.f541376q = r101;
    }

    public a(JSONObject r100, JSONObject r101) {
        this.f541362c = new HashMap();
        this.f541363d = new HashMap();
        this.f541375p = r100;
        this.f541374o = r100.optJSONObject("data");
        this.f541376q = r101;
    }
}
