package fu7;

import com.larus.apm.api.IApmTrace;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes23.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f478908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f478909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f478910c;

    public /* synthetic */ d(String r100, String r101, Function1 r102) {
        this.f478908a = r100;
        this.f478909b = r101;
        this.f478910c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f478908a;
        String r101 = this.f478909b;
        Function1 r102 = this.f478910c;
        h r103 = h.f478911a;
        monitor-enter(r103);
        h.f478912b = (i) r102.invoke(h.f478912b);     // Catch: Throwable -> L8
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r103);
        IApmTrace.f286937a.d(r100, r101);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
