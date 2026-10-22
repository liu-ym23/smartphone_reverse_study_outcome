package wk1;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;
import xk1.i;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements js0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f560077a;

    public d(String r100) {
        this.f560077a = r100;
    }

    @Override // js0.b
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
        i r101 = i.f();
        String r102 = this.f560077a;
        if (r101.f564145a.containsKey(r102) == false) goto L6;
        r101.f564147c.d(r102);
        return;
    }
}
