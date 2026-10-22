package com.bytedance.ee.bear.assemble.profile;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.profile.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class OfficeProfilePageControllerAdapter implements r1c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x1c.c f206280a;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeProfilePageControllerAdapter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "profileFragment");
        if ((r100 instanceof x1c.c) == false) goto L5;
        x1c.c r101 = (x1c.c) r100;
    L6:
        this.f206280a = r101;
        if (r101 != null) goto L10;
        tt5.a.k("OfficeProfilePageControllerAdapter", "profileFragment is not IOfficeProfilePageController, fragment=" + r100);
        return;
    L10:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // r1c.a
    public final void a(final g r100) {
        x1c.c r101 = this.f206280a;
        if (r101 == null) goto L6;
        r101.DT(new OfficeProfilePageControllerAdapter$setOnProfileScrollMonitor$1$1(r100));
        return;
    }

    @Override // r1c.a
    public final void b(final r1c.a.InterfaceC7423a r100) {
        x1c.c r101 = this.f206280a;
        if (r101 == null) goto L6;
        r101.zq(new OfficeProfilePageControllerAdapter$injectBackClickEventInterceptor$1$1(r100));
        return;
    }

    @Override // r1c.a
    public final void c(boolean r100) {
        x1c.c r101 = this.f206280a;
        if (r101 == null) goto L6;
        r101.im(r100);
        return;
    }
}
