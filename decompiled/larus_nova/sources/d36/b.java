package d36;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f466725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f466726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f466727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f466728d;

    public b(Ref.IntRef r100, c r101, String r102, String r103) {
        this.f466725a = r100;
        this.f466726b = r101;
        this.f466727c = r102;
        this.f466728d = r103;
    }

    public final void a() {
        Long r100 = (Long) ((HashMap) a.b()).get("mem_java_used");
        if (r100 == null) goto L7;
        c r101 = this.f466726b;
        String r102 = this.f466727c;
        String r103 = this.f466728d;
        Ref.IntRef r104 = this.f466725a;
        long r105 = r100.longValue();
        if (r101 == null) goto L7;
        r101.b(r102, r103 + '_' + r104.element, r105);
    L7:
        Double r106 = (Double) ((HashMap) a.a()).get("cpu_rate");
        if (r106 == null) goto L12;
        c r107 = this.f466726b;
        String r108 = this.f466727c;
        String r109 = this.f466728d;
        Ref.IntRef r110 = this.f466725a;
        double r111 = r106.doubleValue();
        if (r107 == null) goto L12;
        r107.a(r108, r109 + '_' + r110.element, r111);
    L12:
        this.f466725a.element++;
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
}
