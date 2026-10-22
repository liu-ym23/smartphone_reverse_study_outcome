package com.bytedance.ee.bear.wikiv2.more;

import android.content.Context;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.more.protocol3.panel.y;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiInfoPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean c() {
        return com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
    }

    public static String a(PluginHost r1) {
        Intrinsics.checkNotNullParameter(r1, "pluginHost");
        Context r2 = r1.getContext();
        if (r2 == null) goto L5;
        String r3 = r2.getString(2131887951);
    L6:
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    L5:
        r3 = null;
        goto L6
    }

    public static boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        boolean r0 = y.a();
        if (r0 == true) goto L5;
        y.c("WikiMorePermissionHelper", r2);
    L5:
        return r0;
    }

    public static boolean d(PluginHost r1) {
        Intrinsics.checkNotNullParameter(r1, "pluginHost");
        WikiInfoPlugin r0 = r1.findPlugin(WikiInfoPlugin.class);
        if (r0 == null) goto L9;
        WikNodePerm r2 = r0.getWikiPerm();
        if (r2 == null) goto L9;
        if (r2.getOriginCanClone(h(r1)) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean e(PluginHost r1) {
        Intrinsics.checkNotNullParameter(r1, "pluginHost");
        WikiInfoPlugin r2 = r1.findPlugin(WikiInfoPlugin.class);
        if (r2 == null) goto L12;
        TreeNode r3 = r2.getWikiMeta();
        if (r3 == null) goto L12;
        if (r3.isShortcut() == false) goto L12;
        if (r3.getOriginIsDeleted() == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean f(PluginHost r1) {
        Intrinsics.checkNotNullParameter(r1, "pluginHost");
        WikiInfoPlugin r0 = r1.findPlugin(WikiInfoPlugin.class);
        if (r0 == null) goto L9;
        WikNodePerm r2 = r0.getWikiPerm();
        if (r2 == null) goto L9;
        if (r2.getOriginCanExploreStar(h(r1)) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean g(PluginHost r1) {
        Intrinsics.checkNotNullParameter(r1, "pluginHost");
        WikiInfoPlugin r0 = r1.findPlugin(WikiInfoPlugin.class);
        if (r0 == null) goto L9;
        WikNodePerm r2 = r0.getWikiPerm();
        if (r2 == null) goto L9;
        if (r2.getOriginCanShortcut(h(r1)) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean h(PluginHost r1) {
        Intrinsics.checkNotNullParameter(r1, "pluginHost");
        WikiInfoPlugin r2 = r1.findPlugin(WikiInfoPlugin.class);
        if (r2 == null) goto L7;
        TreeNode r3 = r2.getWikiMeta();
        if (r3 == null) goto L7;
        return r3.isShortcut();
    L7:
        return false;
    }

    public static void i(PluginHost r4, String r5, boolean r6, boolean r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r4, "pluginHost");
        Intrinsics.checkNotNullParameter(r5, "itemId");
        Intrinsics.checkNotNullParameter(r8, "disableReason");
        Intrinsics.checkNotNullParameter(r9, "source");
        WikiInfoPlugin r10 = r4.findPlugin(WikiInfoPlugin.class);
        WikNodePerm r0 = null;
        if (r10 == null) goto L5;
        TreeNode r1 = r10.getWikiMeta();
    L6:
        StringBuilder r2 = new StringBuilder("Wiki more item permission decision, itemId=");
        r2.append(r5);
        r2.append(", visible=");
        r2.append(r6);
        r2.append(", enabled=");
        r2.append(r7);
        r2.append(", disableReason=");
        r2.append(r8);
        r2.append(", source=");
        r2.append(r9);
        r2.append(", isShortcut=");
        if (r1 == null) goto L9;
        Boolean r11 = Boolean.valueOf(r1.isShortcut());
    L10:
        r2.append(r11);
        r2.append(", originDeleted=");
        if (r1 == null) goto L13;
        Boolean r12 = Boolean.valueOf(r1.getOriginIsDeleted());
    L14:
        r2.append(r12);
        r2.append(", isWikiHomePage=");
        if (r1 == null) goto L17;
        Boolean r13 = Boolean.valueOf(r1.isWikiHomePage);
    L18:
        r2.append(r13);
        r2.append(", wikiPerm=");
        if (r10 == null) goto L21;
        r0 = r10.getWikiPerm();
    L21:
        r2.append(r0);
        tt5.a.h("WikiMorePermissionHelper", r2.toString());
        return;
    L17:
        r13 = null;
        goto L18
    L13:
        r12 = null;
        goto L14
    L9:
        r11 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
