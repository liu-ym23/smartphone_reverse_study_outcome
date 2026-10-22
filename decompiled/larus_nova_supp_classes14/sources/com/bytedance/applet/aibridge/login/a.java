package com.bytedance.applet.aibridge.login;

import com.larus.login.api.TouristManager;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements tj9.b {
    public final /* synthetic */ b a;
    public final /* synthetic */ Ref.ObjectRef<tj9.b> b;

    public final void onClose() {
        TouristManager r0 = TouristManager.a;
        r0.p(this.a);
        tj9.b r1 = (tj9.b) this.b.element;
        if (r1 == null) goto L6;
        r0.z(r1);
        return;
    }

    public final void onOpen() {
        TouristManager.a.v(this.a);
    }

    public a(b r1, Ref.ObjectRef<tj9.b> r2) {
        this.a = r1;
        this.b = r2;
    }
}
