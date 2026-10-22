package x17;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.HashMap;
import s17.c;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile String f562122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f562123j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f562124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f562125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f562126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f562127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f562128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile String f562129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f562130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f562131h;

    static {
        f562123j = new a();
        new HashMap();
    }

    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("cant clone ReportMgr");
    }

    public a() {
        this.f562124a = "uploadCheck";
        this.f562125b = "uploadCheck";
        this.f562126c = null;
        this.f562127d = 0;
        this.f562128e = 0;
        this.f562129f = null;
        this.f562130g = System.currentTimeMillis();
        this.f562131h = 1;
        c.b().getClass();
        f562122i = c.f540158h;
    }

    public final void a(HashMap r100) {
        r100.put(ST.UUID_DEVICE, f562122i);
        r100.put("enter_from", this.f562125b);
        r100.put("state", this.f562124a);
        int r101 = this.f562131h;
        this.f562131h = r101 + 1;
        r100.put("number", Integer.valueOf(r101));
        if (this.f562126c == null) goto L6;
        r100.put("uploadUrl", this.f562126c);
        r100.put("uploadCount", Integer.valueOf(this.f562127d));
    L6:
        if (this.f562129f == null) goto L9;
        r100.put("partUploadId", this.f562129f);
    L9:
        if (this.f562128e <= 0) goto L11;
        r100.put("after_hprof_compress_size", Long.valueOf(this.f562128e));
    L11:
        long r102 = System.currentTimeMillis();
        r100.put(ChameleonOpenTracker.ParamKey.COST, Long.valueOf(r102 - this.f562130g));
        this.f562130g = r102;
        r17.c.b((String) r100.get("state"), new Object[0]);
        q17.a.e().f().getTeaReport();
    }

    public final void c(String r100) {
        this.f562124a = r100;
        a(new HashMap());
    }

    public final void b(String r100, HashMap<String, Object> r101) {
        this.f562124a = r100;
        a(new HashMap(r101));
    }
}
