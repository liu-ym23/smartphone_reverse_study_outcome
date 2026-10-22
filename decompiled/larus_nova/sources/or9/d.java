package or9;

import com.larus.platform.model.video.business.EnterVideoMethod;
import com.larus.platform.model.video.business.VideoFeedConfigure;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class d {
    public long A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EnterVideoMethod f524974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f524975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f524976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f524977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<Pair<String, String>> f524978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f524979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f524980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f524981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f524982i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f524983j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f524984k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f524985l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f524986m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f524987n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public JSONObject f524988o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f524989p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f524990q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f524991r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f524992s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f524993t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f524994u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f524995v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f524996w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f524997x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f524998y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f524999z;

    public static final class a {
    }

    static {
    }

    public final VideoFeedConfigure a() {
        VideoFeedConfigure r100 = new VideoFeedConfigure();
        r100.f365674f = this.f524974a;
        List<String> r101 = this.f524975b;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f365676h = r101;
        r100.f365678j = this.f524979f;
        r100.f365679k = this.f524980g;
        r100.f365690v = this.f524981h;
        r100.f365691w = this.f524982i;
        r100.f365692x = this.f524987n;
        r100.f365693y = this.f524989p;
        r100.f365677i = this.f524991r;
        r100.f365688t = this.f524984k;
        r100.f365670b = this.f524999z;
        r100.f365687s = this.f524983j;
        JSONObject r102 = this.f524976c;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r100.f365675g = r102;
        r100.f365671c = this.f524977d;
        r100.f365689u = this.f524992s;
        JSONObject r103 = new JSONObject();
        EnterVideoMethod r104 = r100.f365674f;
        if (r104 == null) goto L5;
        String r105 = r104.getValue();
    L6:
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r103.put("host_enter_from", r105);
        Iterator<String> r106 = this.f524988o.keys();
    L10:
        if (r106.hasNext() == false) goto L12;
        String r107 = r106.next();
        r103.put(r107, this.f524988o.get(r107));
        goto L10
    L12:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r100.f365672d = r103;
        JSONObject r108 = new JSONObject();
        Iterator<T> r109 = this.f524978e.iterator();
    L14:
        if (r109.hasNext() == false) goto L16;
        Pair r110 = (Pair) r109.next();
        r108.put((String) r110.getFirst(), r110.getSecond());
        goto L14
    L16:
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r100.f365673e = r108;
        r100.f365680l = this.f524993t;
        r100.f365694z = this.f524995v;
        r100.f365669a = this.f524996w;
        r100.f365686r = this.f524998y;
        r100.f365681m = 0.0f;
        r100.f365685q = this.f524997x;
        r100.f365683o = this.f524986m;
        r100.f365682n = this.f524985l;
        r100.f365684p = this.f524994u;
        r100.A = this.f524990q;
        r100.B = this.A;
        return r100;
    L5:
        r105 = null;
        goto L6
    }

    public d() {
        this.f524974a = EnterVideoMethod.MAIN_DOUBLE_TAG;
        this.f524975b = CollectionsKt.emptyList();
        this.f524976c = new JSONObject();
        this.f524978e = CollectionsKt.emptyList();
        this.f524979f = true;
        this.f524980g = true;
        this.f524981h = true;
        this.f524982i = true;
        this.f524984k = true;
        this.f524987n = "";
        this.f524988o = new JSONObject();
        this.f524989p = "";
        this.f524990q = -1;
        this.f524991r = "";
        this.f524993t = true;
        this.f524996w = -1;
        this.f524997x = 300;
        this.f524999z = true;
    }
}
