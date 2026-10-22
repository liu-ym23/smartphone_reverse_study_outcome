package com.ss.android.bytedcert.face;

import com.ss.android.bytedcert.model.LiveInfo;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements bsa.a.InterfaceC0355a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f407388a;

    public e(c r100) {
        this.f407388a = r100;
    }

    @Override // bsa.a.InterfaceC0355a
    public final void a(boolean r100) {
        LiveInfo r101 = this.f407388a.f407349c;
        if (r101 == null) goto L6;
        r101.a("depth_support", String.valueOf(r100));
        this.f407388a.f407349c.a("has_depth_image", String.valueOf(false));
        return;
    }
}
