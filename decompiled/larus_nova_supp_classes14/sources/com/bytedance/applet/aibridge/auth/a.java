package com.bytedance.applet.aibridge.auth;

import com.larus.platform.api.d5;
import f3.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements d5 {
    public final /* synthetic */ h<AbsCheckDouyinOpenAuthStatusMethodIDL.b> a;

    public a(h<AbsCheckDouyinOpenAuthStatusMethodIDL.b> r1) {
        this.a = r1;
    }

    public final void a(boolean r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "clientKey");
        Intrinsics.checkNotNullParameter(r4, "scope");
        Intrinsics.checkNotNullParameter(r5, "state");
        h<AbsCheckDouyinOpenAuthStatusMethodIDL.b> r6 = this.a;
        Intrinsics.checkNotNullParameter(AbsCheckDouyinOpenAuthStatusMethodIDL.b.class, "<this>");
        AbsCheckDouyinOpenAuthStatusMethodIDL.b r7 = k3.c.a(AbsCheckDouyinOpenAuthStatusMethodIDL.b.class);
        r7.setAuthorized(r2);
        h.a.b(r6, r7);
    }
}
