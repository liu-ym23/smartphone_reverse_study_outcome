package et3;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f473878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f473879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f473880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b f473881d;

    public final void a() {
        b.a r100 = this.f473881d.f473883b.get(this.f473878a);
        if (r100 != null) goto L5;
        this.f473881d.f473883b.put(this.f473878a, new b.a(this.f473879b, this.f473880c));
        return;
    L5:
        r100.f473885b += this.f473880c;
        r100.f473887d++;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(b r100, String r101, Map r102, float r103) {
        this.f473881d = r100;
        this.f473878a = r101;
        this.f473879b = r102;
        this.f473880c = r103;
    }
}
