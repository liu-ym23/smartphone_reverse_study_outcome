package uy4;

import com.bytedance.geckox.model.UpdatePackage;
import io.reactivex.Flowable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r extends yy4.b {
    public final /* synthetic */ s k;

    public r(s r1) {
        this.k = r1;
    }

    @Override // yy4.b
    public final void e(String r4) {
        tt5.a.h("LocalResUpdateServiceImpl", "retry gecko download, channel = " + r4);
        ArrayList r0 = new ArrayList();
        r0.add(r4);
        yy4.b r5 = b();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r5.b = r0;
        this.k.m(r0, r5, false);
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.d
    public final void onUpdateSuccess(UpdatePackage r5, final long r6) {
        super.onUpdateSuccess(r5, r6);
        final String r0 = r5.getChannel();
        final s r1 = this.k;
        final String r7 = r5.getChannel();
        r1.getClass();
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new d(r1, r7, r6)).doOnError(new e(r1, r7)).subscribe(new p(this, r0), new q(this, r0));
    }
}
