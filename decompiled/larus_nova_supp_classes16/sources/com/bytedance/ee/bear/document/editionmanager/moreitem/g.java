package com.bytedance.ee.bear.document.editionmanager.moreitem;

import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.editionmanager.plugin.EditionListPlugin;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g extends com.bytedance.ee.bear.more.protocol3.g {
    public final DocumentPluginHost c;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ g a;

        public b(g r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r20) {
            g r1 = this.a;
            r1.getHost().a();
            EditionListPlugin r2 = (EditionListPlugin) r1.c.findPlugin(EditionListPlugin.class);
            if (r2 == null) goto L5;
            r2.handleClick();
        L5:
            ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).b(((com.bytedance.ee.bear.more.protocol3.f) com.bytedance.ee.bear.more.protocol3.f.q.c).a);
            oj5.a r3 = r1.c();
            if ((r3 instanceof oj5.a) == false) goto L9;
            com.bytedance.ee.bear.more.b r4 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
            Bundle r5 = r1.getHost().getHostFragment().getArguments();
            oj5.a r6 = r3;
            r4.c(new com.bytedance.ee.bear.more.i(r5, r6.c, r6.getType(), false, r6.b(), "view_saved_version", "ccm_doc_saved_version_view", "", "", r3 instanceof oj5.f, r6.k, r6.r, r6.isOwner(), r6.L()));
            return;
        }
    }

    static {
    }

    public final com.bytedance.ee.bear.more.protocol3.k a() {
        com.bytedance.ee.bear.more.protocol3.f.q r1 = com.bytedance.ee.bear.more.protocol3.f.q.c;
        com.bytedance.ee.bear.more.protocol3.e.e r2 = new com.bytedance.ee.bear.more.protocol3.e.e(true);
        List r3 = CollectionsKt.listOf(new i(this));
        com.bytedance.ee.bear.more.protocol3.a[] r4 = new com.bytedance.ee.bear.more.protocol3.a[2];
        oj5.c r5 = c();
        if (r5 == null) goto L5;
        int r6 = r5.i();
    L6:
        r4[0] = new h(z05.i.b(r6), this);
        r4[1] = new com.bytedance.ee.bear.more.protocol3.checker.c(((com.bytedance.ee.bear.more.protocol3.f) r1).a);
        return h(r1, r2, r3, CollectionsKt.listOf(r4), new b(this));
    L5:
        r6 = -1;
        goto L6
    }

    public g(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.c = r2;
    }
}
