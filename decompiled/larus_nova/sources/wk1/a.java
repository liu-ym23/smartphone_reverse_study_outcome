package wk1;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;
import xk1.i;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements js0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f560070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ sp1.a f560071b;

    @Override // js0.b
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
        i.f().i(this.f560070a, this.f560071b);
    }

    public a(String r100, sp1.a r101) {
        this.f560070a = r100;
        this.f560071b = r101;
    }
}
