package com.bytedance.ee.bear.wikiv2.more;

import android.content.Context;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.more.protocol3.panel.y;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiInfoPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f241012a = 0;

    static {
    }

    public static boolean c() {
        return com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a();
    }

    public static String a(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        Context r101 = r100.getContext();
        if (r101 == null) goto L5;
        String r102 = r101.getString(R.string.Doc_List_OperateFailedNoNet);
    L6:
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public static boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        boolean r101 = y.a();
        if (r101 == true) goto L5;
        y.c("WikiMorePermissionHelper", r100);
    L5:
        return r101;
    }

    public static boolean d(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        WikiInfoPlugin r101 = (WikiInfoPlugin) r100.findPlugin(WikiInfoPlugin.class);
        if (r101 == null) goto L9;
        WikNodePerm r102 = r101.getWikiPerm();
        if (r102 == null) goto L9;
        if (r102.getOriginCanClone(h(r100)) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean e(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        WikiInfoPlugin r101 = (WikiInfoPlugin) r100.findPlugin(WikiInfoPlugin.class);
        if (r101 == null) goto L12;
        TreeNode r102 = r101.getWikiMeta();
        if (r102 == null) goto L12;
        if (r102.isShortcut() == false) goto L12;
        if (r102.getOriginIsDeleted() == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean f(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        WikiInfoPlugin r101 = (WikiInfoPlugin) r100.findPlugin(WikiInfoPlugin.class);
        if (r101 == null) goto L9;
        WikNodePerm r102 = r101.getWikiPerm();
        if (r102 == null) goto L9;
        if (r102.getOriginCanExploreStar(h(r100)) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean g(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        WikiInfoPlugin r101 = (WikiInfoPlugin) r100.findPlugin(WikiInfoPlugin.class);
        if (r101 == null) goto L9;
        WikNodePerm r102 = r101.getWikiPerm();
        if (r102 == null) goto L9;
        if (r102.getOriginCanShortcut(h(r100)) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean h(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        WikiInfoPlugin r101 = (WikiInfoPlugin) r100.findPlugin(WikiInfoPlugin.class);
        if (r101 == null) goto L7;
        TreeNode r102 = r101.getWikiMeta();
        if (r102 == null) goto L7;
        return r102.isShortcut();
    L7:
        return false;
    }

    public static void i(PluginHost r100, String r101, boolean r102, boolean r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        Intrinsics.checkNotNullParameter(r101, "itemId");
        Intrinsics.checkNotNullParameter(r104, "disableReason");
        Intrinsics.checkNotNullParameter(r105, "source");
        WikiInfoPlugin r106 = (WikiInfoPlugin) r100.findPlugin(WikiInfoPlugin.class);
        WikNodePerm r107 = null;
        if (r106 == null) goto L5;
        TreeNode r108 = r106.getWikiMeta();
    L6:
        StringBuilder r109 = new StringBuilder("Wiki more item permission decision, itemId=");
        r109.append(r101);
        r109.append(", visible=");
        r109.append(r102);
        r109.append(", enabled=");
        r109.append(r103);
        r109.append(", disableReason=");
        r109.append(r104);
        r109.append(", source=");
        r109.append(r105);
        r109.append(", isShortcut=");
        if (r108 == null) goto L9;
        Boolean r110 = Boolean.valueOf(r108.isShortcut());
    L10:
        r109.append(r110);
        r109.append(", originDeleted=");
        if (r108 == null) goto L13;
        Boolean r111 = Boolean.valueOf(r108.getOriginIsDeleted());
    L14:
        r109.append(r111);
        r109.append(", isWikiHomePage=");
        if (r108 == null) goto L17;
        Boolean r112 = Boolean.valueOf(r108.isWikiHomePage);
    L18:
        r109.append(r112);
        r109.append(", wikiPerm=");
        if (r106 == null) goto L21;
        r107 = r106.getWikiPerm();
    L21:
        r109.append(r107);
        tt5.a.h("WikiMorePermissionHelper", r109.toString());
        return;
    L17:
        r112 = null;
        goto L18
    L13:
        r111 = null;
        goto L14
    L9:
        r110 = null;
        goto L10
    L5:
        r108 = null;
        goto L6
    }
}
