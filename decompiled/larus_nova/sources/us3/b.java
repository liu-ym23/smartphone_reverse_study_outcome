package us3;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vs3.b f551466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f551467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f551468c;

    public final void a() {
        e r100 = this.f551468c;     // Catch: Exception -> L28
    L4:
        vs3.b r101 = (vs3.b) r100.f551475b.poll();     // Catch: Exception -> L28
        if (r101 == null) goto L8;
        ((CopyOnWriteArraySet) r100.f551476c).remove(r101.f556982a);     // Catch: Exception -> L28
        goto L4
    L8:
        if ((!((CopyOnWriteArraySet) this.f551468c.f551476c).contains(this.f551466a.f556982a)) == true) goto L10;
        e r102 = this.f551468c;     // Catch: Exception -> L28
        if (r102.f551477d.f190414a == false) goto L26;
        e.a(r102);     // Catch: Exception -> L28
        e r103 = this.f551468c;     // Catch: Exception -> L28
    L16:
        vs3.b r104 = (vs3.b) r103.f551475b.poll();     // Catch: Exception -> L28
        if (r104 == null) goto L20;
        ((CopyOnWriteArraySet) r103.f551476c).remove(r104.f556982a);     // Catch: Exception -> L28
        goto L16
    L20:
        if ((!((CopyOnWriteArraySet) this.f551468c.f551476c).contains(this.f551466a.f556982a)) == true) goto L22;
        e.b(this.f551468c, this.f551466a, this.f551467b);     // Catch: Exception -> L28
        return;
    L22:
        if (com.bytedance.apm.d.j() == false) goto L35;
        ps3.b.a(new String[]{"No Leak:" + this.f551467b});     // Catch: Exception -> L28
        return;
    L35:
        return;
    L26:
        e.b(r102, this.f551466a, this.f551467b);     // Catch: Exception -> L28
        return;
    L10:
        if (com.bytedance.apm.d.j() == false) goto L34;
        ps3.b.a(new String[]{"No Leak First Check:" + this.f551467b});     // Catch: Exception -> L28
        return;
    L34:
        return;
    L28:
        e = move-exception;
        e.printStackTrace();
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

    public b(e r100, vs3.b r101, String r102) {
        this.f551468c = r100;
        this.f551466a = r101;
        this.f551467b = r102;
    }
}
