package mo;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f514575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f514576b;

    public c(b r100, List r101) {
        this.f514575a = r100;
        this.f514576b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        b r101 = this.f514575a;
        List r102 = this.f514576b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, "events");
        Iterator r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L20;
        a r104 = (a) r103.next();
        String r105 = r104.b();
        Iterator<T> r106 = r101.f514574a.iterator();
    L7:
        if (r106.hasNext() == false) goto L11;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((no.a) r107).f519880a, r105) == false) goto L7;
    L12:
        no.a r108 = (no.a) r107;
        if (r108 == null) goto L15;
    L18:
        if (r108 == null) goto L4;
        String r109 = r104.a();
        Intrinsics.checkNotNullParameter(r100, "view");
        r108.a(r100, r108.b(r109));
        goto L4
    L15:
        if (com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a == true) goto L18;
        new StringBuilder("event type is ").append(r104.b());
        goto L18
    L11:
        r107 = null;
        goto L12
    }
}
