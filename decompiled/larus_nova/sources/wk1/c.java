package wk1;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import xk1.i;
import xk1.j;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements js0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tp1.a f560075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ sp1.a f560076b;

    @Override // js0.b
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
        tp1.a r101 = this.f560075a;
        VideoRef r102 = r101.f547009j;
        if (r102 != null) goto L5;
        r101.f547009j = (VideoRef) ((HashMap) b.f560072a).get(r101.f547000a);
    L8:
        i.f().i(this.f560075a.f547000a, this.f560076b);
        i r103 = i.f();
        tp1.a r104 = this.f560075a;
        if (r104 != null) goto L11;
        r103.getClass();
        j r105 = new j(r103, null);
        r103.d();
        r105.run();
        return;
    L11:
        r103.getClass();
        j r106 = new j(r103, new tp1.a[]{r104});
        r103.d();
        r106.run();
        return;
    L5:
        String r107 = r101.f547000a;
        if (r107 == null) goto L8;
        ((HashMap) b.f560072a).put(r107, r102);
        goto L8
    }

    public c(tp1.a r100, sp1.a r101) {
        this.f560075a = r100;
        this.f560076b = r101;
    }
}
