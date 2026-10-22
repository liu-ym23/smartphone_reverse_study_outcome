package com.bytedance.applet.aibridge.login;

import com.larus.bmhome.utils.t3;
import com.larus.bmhome.utils.v2;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements tj9.a {
    public final /* synthetic */ AbsOpenLoginPanelMethodIDL.a a;

    public final void a() {
        final String r0 = this.a.getMsgId();
        if (r0 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(this.a.getReSendAfterLogin(), Boolean.TRUE) == true) goto L8;
        return;
    L8:
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        final AbsOpenLoginPanelMethodIDL.a r3 = this.a;
        t3 r2 = new t3(new pv3.a(r1, r3, r0));
        r1.element = r2;
        List r4 = v2.a;
        Intrinsics.checkNotNullParameter(r2, "task");
        ((ArrayList) v2.a).add(r2);
    }

    public b(AbsOpenLoginPanelMethodIDL.a r1) {
        this.a = r1;
    }
}
