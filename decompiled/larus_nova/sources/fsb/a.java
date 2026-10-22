package fsb;

import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f478716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f478717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f478718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f478719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentLinkedQueue<C5948a> f478720e;

    /* JADX INFO: renamed from: fsb.a$a, reason: collision with other inner class name */
    public static final class C5948a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f478721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f478722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f478723c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f478724d;

        public C5948a() {
            this.f478721a = "unknown";
            this.f478722b = -1;
            this.f478723c = -1;
        }
    }

    public final synchronized JSONObject a() {
        monitor-enter(this);
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L16
        r100.put("page_name", this.f478716a);     // Catch: Exception -> L12 Throwable -> L16
        r100.put("page_show", this.f478718c);     // Catch: Exception -> L12 Throwable -> L16
        r100.put("page_complete", this.f478719d);     // Catch: Exception -> L12 Throwable -> L16
        JSONArray r101 = new JSONArray();     // Catch: Exception -> L12 Throwable -> L16
    L6:
        if (this.f478720e.isEmpty() == true) goto L10;
        C5948a r102 = this.f478720e.remove();     // Catch: Exception -> L12 Throwable -> L16
        if (r102.f478723c == (-1)) goto L6;
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L12 Throwable -> L16
        r103.put("span_name", r102.f478721a);     // Catch: Exception -> L12 Throwable -> L16
        r103.put("span_time", r102.f478723c);     // Catch: Exception -> L12 Throwable -> L16
        r103.put("span_thread", r102.f478724d);     // Catch: Exception -> L12 Throwable -> L16
        r101.put(r103);     // Catch: Exception -> L12 Throwable -> L16
        goto L6
    L10:
        r100.put("span", r101.toString());     // Catch: Exception -> L12 Throwable -> L16
    L14:
        monitor-exit(this);
        return r100;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public a() {
        this.f478716a = "unknown";
        this.f478717b = -1;
        this.f478718c = -1;
        this.f478719d = -1;
        this.f478720e = new ConcurrentLinkedQueue();
    }
}
