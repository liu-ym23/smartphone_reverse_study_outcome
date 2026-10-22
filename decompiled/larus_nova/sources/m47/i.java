package m47;

import com.bytedance.pia.core.api.bridge.PiaMethod;

/* JADX INFO: loaded from: classes21.dex */
public final /* synthetic */ class i implements l47.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f511870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f511871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l47.a f511872c;

    public /* synthetic */ i(o r100, String r101, Object r102, long r103, l47.a r104) {
        this.f511870a = r100;
        this.f511871b = r102;
        this.f511872c = r104;
    }

    @Override // l47.a
    public final void accept(Object r100) {
        o r101 = this.f511870a;
        l47.a r102 = this.f511872c;
        r101.getClass();
        PiaMethod.Error r103 = (PiaMethod.Error) r100;
        r101.b(r103.getCode(), null, r103.getMessage(), r103.getCause());
        o.c(r102, r103);
    }
}
