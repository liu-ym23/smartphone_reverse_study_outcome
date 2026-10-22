package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceUserPerm;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class w2 {
    public static e3 a(WikiTreeModel r1) {
        Intrinsics.checkNotNullParameter(r1, "treeModel");
        return r1.workspace;
    }

    public static boolean b(WikiTreeModel r1) {
        Intrinsics.checkNotNullParameter(r1, "treeModel");
        return r1.workspace.q.hasBenefit("ccm_my_doc_library_entrance");
    }

    public static boolean c(WikiTreeModel r5) {
        Intrinsics.checkNotNullParameter(r5, "treeModel");
        e3 r0 = r5.workspace;
        SpaceUserPerm r1 = r0.k;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        boolean r3 = r0.q(r0.a);
        boolean r4 = qc5.a.g(r5.userComponentAbility);
        if (r5.favoriteEnable == false) goto L15;
        if (r2 == false) goto L16;
        if (r3 == false) goto L17;
        if (r4 == true) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L16:
        return false;
    L15:
        return false;
    L5:
        if (r1.star_wiki != true) goto L7;
        r2 = true;
        goto L8
    }

    public static boolean d(WikiTreeModel r1) {
        Intrinsics.checkNotNullParameter(r1, "treeModel");
        e3 r2 = r1.workspace;
        return r2.q(r2.d);
    }

    public static boolean e(WikiTreeModel r1) {
        Intrinsics.checkNotNullParameter(r1, "treeModel");
        e3 r2 = r1.workspace;
        return r2.q(r2.c);
    }

    public static boolean f(WikiTreeModel r1) {
        Intrinsics.checkNotNullParameter(r1, "treeModel");
        e3 r2 = r1.workspace;
        if (r2.q(r2.e) == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.q.hasBenefit("ccm_workspace_wiki_entrance") == false) goto L7;
        return true;
    }
}
