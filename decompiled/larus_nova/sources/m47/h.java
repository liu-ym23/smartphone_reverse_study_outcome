package m47;

import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.utils.GsonUtils;
import com.google.gson.JsonObject;
import kotlin.Unit;

/* JADX INFO: loaded from: classes21.dex */
public final /* synthetic */ class h implements l47.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f511864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l47.a f511865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Class f511866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f511867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ l47.a f511868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f511869f;

    public /* synthetic */ h(o r100, l47.a r101, Class r102, String r103, l47.a r104, Object r105, long r106) {
        this.f511864a = r100;
        this.f511865b = r101;
        this.f511866c = r102;
        this.f511867d = r103;
        this.f511868e = r104;
        this.f511869f = r105;
    }

    @Override // l47.a
    public final void accept(Object r100) {
        o r101 = this.f511864a;
        l47.a r102 = this.f511865b;
        Class r103 = this.f511866c;
        String r104 = this.f511867d;
        l47.a r105 = this.f511868e;
        r101.getClass();
        if (r102 == null) goto L32;
        Class<?> r106 = com.bytedance.pia.core.utils.e.a(r102, l47.a.class, 0);
        Object r107 = null;
        if (Void.class != r103) goto L8;
    L26:
        r102.accept(r107);
        return;
    L8:
        if (Unit.class == r103) goto L26;
        if (r106 == null) goto L15;
        if (r106.isInstance(r100) == false) goto L15;
    L21:
        if (r100 == null) goto L23;
    L25:
        r107 = r100;
        goto L26
    L23:
        if (Void.class == r106) goto L25;
        r101.b(-4, r104, "unsupported result type.", null);
        o.c(r105, new PiaMethod.InvalidResultError());
        return;
    L15:
        if (JsonObject.class == r106) goto L28;
        r100 = null;
        goto L21
    L28:
        r100 = GsonUtils.b().toJsonTree(r100);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r101.b(-4, r104, null, th);
        o.c(r105, new PiaMethod.InvalidResultError());
        return;
    }
}
