package com.suite.lark.component.navroute.group;

import android.view.View;
import android.view.ViewParent;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class g implements b<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f460389a = null;

    static {
        f460389a = new g();
    }

    public g() {
    }

    public static com.suite.lark.component.navroute.api.f c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Object r101 = r100.getTag(R.id.nav_route_controller_view_tag);
        if ((r101 instanceof WeakReference) == false) goto L6;
        return (com.suite.lark.component.navroute.api.f) ((WeakReference) r101).get();
    L6:
        if ((r101 instanceof com.suite.lark.component.navroute.api.f) == true) goto L11;
        return null;
    L11:
        return (com.suite.lark.component.navroute.api.f) r101;
    }

    @Override // com.suite.lark.component.navroute.group.b
    public final /* bridge */ /* synthetic */ com.suite.lark.component.navroute.api.f a(View r100) {
        return c(r100);
    }

    @Override // com.suite.lark.component.navroute.group.b
    public final Object b(View r100) {
        View r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "source");
        ViewParent r102 = r101.getParent();
        if ((r102 instanceof View) == false) goto L6;
        return r102;
    L6:
        return r101.getContext();
    }
}
