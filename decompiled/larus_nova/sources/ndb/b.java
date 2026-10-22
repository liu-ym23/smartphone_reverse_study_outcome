package ndb;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Set f518829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f518830b;

    public final void a() {
        c r100 = this.f518830b;
        r100.f518833c = FeatureGatingModule.getDependency().mc();
        c r101 = this.f518830b;
        r101.f518834d = FeatureGatingModule.getDependency().Ue();
        Iterator r102 = this.f518829a.iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        d r103 = (d) r102.next();
        c r104 = this.f518830b;
        r104.b(r103);
        if (((CopyOnWriteArraySet) r104.f518832b).size() < r104.f518833c) goto L4;
        Object r105 = r104.f518835e;
        monitor-enter(r105);
        r104.c();     // Catch: Throwable -> L13
        monitor-exit(r105);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
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

    public b(c r100, Set r101) {
        this.f518830b = r100;
        this.f518829a = r101;
    }
}
