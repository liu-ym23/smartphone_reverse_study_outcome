package com.bytedance.ee.bear.wikiv2.more;

import android.view.View;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiInfoPlugin;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiMovePlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends com.bytedance.ee.bear.more.protocol3.g {
    public final PluginHost c;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ e a;

        public b(e r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.getHost().a();
            WikiMovePlugin r3 = this.a.c.findPlugin(WikiMovePlugin.class);
            if (r3 == null) goto L6;
            r3.doMove();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        WikiInfoPlugin r0 = this.c.findPlugin(WikiInfoPlugin.class);
        if (r0 == null) goto L28;
        WikNodePerm r1 = r0.getWikiPerm();
        if (r1 == null) goto L28;
        if (com.bytedance.ee.bear.wikiv2.more.b.a(this.c) == false) goto L13;
        int r2 = d.a;
        com.bytedance.ee.bear.more.protocol3.f.v r3 = com.bytedance.ee.bear.more.protocol3.f.v.c;
        if (d.b(r3.a) == false) goto L12;
        d.i(this.c, r3.a, false, false, "", "wiki_homepage");
    L12:
        return null;
    L13:
        int r4 = d.a;
        com.bytedance.ee.bear.more.protocol3.f.v r5 = com.bytedance.ee.bear.more.protocol3.f.v.c;
        if (d.b(r5.a) == false) goto L26;
        PluginHost r6 = this.c;
        String r7 = r5.a;
        if (d.c() == true) goto L18;
    L20:
        boolean r8 = false;
    L22:
        if (d.c() == true) goto L24;
        String r9 = d.a(this.c);
    L25:
        d.i(r6, r7, true, r8, r9, "network_show_move");
        goto L26
    L24:
        r9 = "";
        goto L25
    L18:
        if (r1.show_move == false) goto L20;
        r8 = true;
    L26:
        b r10 = new b(this);
        return com.bytedance.ee.bear.more.protocol3.g.i(this, r5, null, CollectionsKt.listOf(new com.bytedance.ee.bear.more.protocol3.checker.a(r5.a)), CollectionsKt.listOf(new com.bytedance.ee.bear.more.protocol3.j[]{new com.bytedance.ee.bear.more.protocol3.checker.d(), new BizChecker(xo5.a.c(this.c.getContext(), 2131887930, ResourceData.KEY_TYPE, t0.n(this.c.getContext(), 16)), r1.show_move)}), r10, 2);
    L28:
        return null;
    }

    public e(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.c = r2;
    }
}
