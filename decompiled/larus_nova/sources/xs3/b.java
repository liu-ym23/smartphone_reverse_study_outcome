package xs3;

import com.larus.apm.impl.protector.RunnableProtector;
import ff7.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f564957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f564958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f564959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f564960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f564961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ JSONObject f564962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ e f564963g;

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f564957a, this.f564958b, this.f564959c, this.f564960d, this.f564961e, this.f564962f, null, this.f564963g);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(String r100, String r101, String r102, String r103, String r104, e r105) {
        this.f564957a = r100;
        this.f564958b = r101;
        this.f564959c = r102;
        this.f564960d = r103;
        this.f564961e = r104;
        this.f564962f = null;
        this.f564963g = r105;
    }
}
