package gu0;

import com.bytedance.android.scope.l;
import com.bytedance.android.scope.o;
import cy0.f;
import e33.k;
import fu0.c;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;
import yz0.m;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements o, m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f482738a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    @Override // yz0.m
    public final void i() {
        f r100 = this.f482738a;
        Intrinsics.checkNotNullParameter(r100, "parent");
        c r101 = new c(r100);
        Intrinsics.checkNotNullParameter(r101, "scope");
        Object r102 = k.f470908a;
        if (r101.f478852e != r102) goto L6;
        String r103 = "revenueInstance";
    L12:
        if (r103 != null) goto L16;
        l.a(r101);
        return;
    L16:
        throw new UninitializedPropertyAccessException(r103);
    L6:
        if (r101.f478853f != r102) goto L9;
        r103 = "revenueInstanceExt";
        goto L12
    L9:
        if (r101.f478854g != r102) goto L11;
        r103 = "roomInstance";
        goto L12
    L11:
        r103 = null;
        goto L12
    }

    public a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "instScope");
        this.f482738a = r100;
    }
}
