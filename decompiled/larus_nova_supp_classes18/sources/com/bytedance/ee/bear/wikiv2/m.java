package com.bytedance.ee.bear.wikiv2;

import android.content.Context;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.ee.bear.wikiv2.sidebar.home.SidebarHomeTreeView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeActivityContract;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements tp5.a {
    public m() {
    }

    @Override // tp5.a
    public final void a(SpaceBean r4) {
        Intrinsics.checkNotNullParameter(r4, "spaceBean");
        WikiTreeActivityContract r0 = new WikiTreeActivityContract();
        r0.setSpaceId(r4.space_id);
        r0.setDocumentToken("");
        r0.setWikiDocument(zp5.a.c(r4));
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).w2("/wikiv2/treehome/activity").o(WikiTreeActivityContract.class.getName(), r0).k(0).e();
    }

    @Override // tp5.a
    public final SidebarHomeTreeView b(Context r2, ce5.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        return new SidebarHomeTreeView(r2, r3);
    }
}
