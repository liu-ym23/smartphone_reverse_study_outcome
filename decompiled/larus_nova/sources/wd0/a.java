package wd0;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f559269a;

    public a() {
        ArrayList r100 = new ArrayList();
        r100.add(new d());
        Unit r101 = Unit.INSTANCE;
        this.f559269a = r100;
    }

    public final void a(b r100, List<xd0.a> r101, xd0.b r102) {
        Intrinsics.checkNotNullParameter(r100, "renderContext");
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.GAIAX_LAYERS);
        Intrinsics.checkNotNullParameter(r102, "shadowLayer");
        Iterator<T> r103 = this.f559269a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((c) r103.next()).a(r100, r101, r102);
        goto L4
    }
}
