package l7a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.core.resource.LynxResourceLoader;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f507880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f507881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f507882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f507883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f507884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ LynxResourceLoader f507885f;

    public final void a() {
        com.lynx.tasm.i r100 = this.f507885f.f383309e.get();
        if (r100 != null) goto L5;
        return;
    L5:
        LynxError r101 = new LynxError(this.f507880a, String.format("%s %s failed, the error message is: %s", new Object[]{"LynxResourceLoader", this.f507881b, this.f507882c}), LynxError.LYNX_ERROR_SUGGESTION_REF_OFFICIAL_SITE, "error");
        r101.setRootCause(this.f507883d);
        r101.addCustomInfo("src", this.f507884e);
        r100.onErrorOccurred(r101);
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

    public d(LynxResourceLoader r100, int r101, String r102, String r103, String r104, String r105) {
        this.f507885f = r100;
        this.f507880a = r101;
        this.f507881b = r102;
        this.f507882c = r103;
        this.f507883d = r104;
        this.f507884e = r105;
    }
}
