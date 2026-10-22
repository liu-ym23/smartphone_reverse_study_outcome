package com.bytedance.ee.bear.document.editionmanager.moreitem;

import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.editionmanager.plugin.EditionListPlugin;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class g extends com.bytedance.ee.bear.more.protocol3.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DocumentPluginHost f219641c;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f219642a;

        public b(g r100) {
            this.f219642a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r210) {
            g r100 = this.f219642a;
            r100.getHost().a();
            EditionListPlugin r101 = (EditionListPlugin) r100.f219641c.findPlugin(EditionListPlugin.class);
            if (r101 == null) goto L5;
            r101.handleClick();
        L5:
            ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).b(com.bytedance.ee.bear.more.protocol3.f.q.f234877c.f234853a);
            oj5.c r102 = r100.c();
            if ((r102 instanceof oj5.a) == false) goto L9;
            com.bytedance.ee.bear.more.b r103 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
            Bundle r104 = r100.getHost().getHostFragment().getArguments();
            oj5.a r105 = (oj5.a) r102;
            r103.c(new com.bytedance.ee.bear.more.i(r104, r105.f523532c, r105.getType(), false, r105.b(), "view_saved_version", "ccm_doc_saved_version_view", "", "", r102 instanceof oj5.f, r105.f523540k, r105.f523547r, r105.isOwner(), r105.L()));
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        com.bytedance.ee.bear.more.protocol3.f.q r100 = com.bytedance.ee.bear.more.protocol3.f.q.f234877c;
        com.bytedance.ee.bear.more.protocol3.e.C3365e r101 = new com.bytedance.ee.bear.more.protocol3.e.C3365e(true);
        List<? extends com.bytedance.ee.bear.more.protocol3.m> r102 = CollectionsKt.listOf(new i(this));
        com.bytedance.ee.bear.more.protocol3.a[] r103 = new com.bytedance.ee.bear.more.protocol3.a[2];
        oj5.c r104 = c();
        if (r104 == null) goto L5;
        int r105 = r104.i();
    L6:
        r103[0] = new h(z05.i.b(r105), this);
        r103[1] = new com.bytedance.ee.bear.more.protocol3.checker.c(r100.f234853a);
        return h(r100, r101, r102, CollectionsKt.listOf(r103), new b(this));
    L5:
        r105 = -1;
        goto L6
    }

    public g(DocumentPluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        this.f219641c = r100;
    }
}
