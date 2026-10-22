package xs3;

import com.larus.apm.impl.protector.RunnableProtector;
import ff7.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f564964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f564965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f564966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f564967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f564968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ JSONObject f564969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f564970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ e f564971h;

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f564964a, this.f564965b, this.f564966c, this.f564967d, this.f564968e, this.f564969f, this.f564970g, this.f564971h);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(String r100, String r101, String r102, String r103, String r104, String r105, e r106) {
        this.f564964a = r100;
        this.f564965b = r101;
        this.f564966c = r102;
        this.f564967d = r103;
        this.f564968e = r104;
        this.f564969f = null;
        this.f564970g = r105;
        this.f564971h = r106;
    }
}
