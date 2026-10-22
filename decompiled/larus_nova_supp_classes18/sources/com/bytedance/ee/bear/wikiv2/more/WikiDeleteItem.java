package com.bytedance.ee.bear.wikiv2.more;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiDeletePlugin;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiInfoPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J \u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\nH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/more/WikiDeleteItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/IGridMoreItem;", "pluginHost", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "<init>", "(Lcom/bytedance/ee/bear/browser/plugin/PluginHost;)V", "getPluginHost", "()Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "getId", "", "getTitle", "getIcon", "", "getIconTint", "isVisible", "", SendEventContainerMethodParamModel.EventKinds.onClick, "", "needShowBadge", "isEnable", "getUnableTips", "isSpaceShortcut", "treeNode", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;", "logDecision", "visible", "enabled", "source", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiDeleteItem extends BaseMoreItem implements IGridMoreItem {
    public static final a Companion = null;
    private static final String TAG = "WikiDeleteItem";
    private final PluginHost pluginHost;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return 2131254201;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean needShowBadge() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return com.bytedance.ee.bear.more.protocol3.f.l0.c.a;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        WikiInfoPlugin r0 = this.pluginHost.findPlugin(WikiInfoPlugin.class);
        if (r0 == null) goto L5;
        TreeNode r1 = r0.getWikiMeta();
    L7:
        if (isSpaceShortcut(r1) == true) goto L9;
        boolean r2 = false;
        if (r1 != null) goto L13;
    L15:
        if (r2 == false) goto L18;
        return getString(2131887529);
    L18:
        return getString(2131887736);
    L13:
        if (r1.isShortcut() != true) goto L15;
        r2 = true;
        goto L15
    L9:
        return getString(2131887736);
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public String getUnableTips() {
        int r0 = d.a;
        if (d.b(getId()) == true) goto L6;
        return "";
    L6:
        if (d.c() == false) goto L8;
        WikiInfoPlugin r1 = this.pluginHost.findPlugin(WikiInfoPlugin.class);
        if (r1 == null) goto L22;
        WikNodePerm r2 = r1.getWikiPerm();
        if (r2 == null) goto L22;
        if (r2.parent_can_move_from == true) goto L21;
        if (r2.parent_root == false) goto L24;
        return getString(2131889853);
    L24:
        return getString(2131889864);
    L21:
        return getString(2131887803);
    L22:
        return "";
    L8:
        return d.a(this.pluginHost);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean isEnable() {
        int r0 = d.a;
        boolean r1 = true;
        if (d.b(getId()) == true) goto L5;
        return true;
    L5:
        WikiInfoPlugin r2 = this.pluginHost.findPlugin(WikiInfoPlugin.class);
        WikNodePerm r3 = null;
        if (r2 == null) goto L8;
        TreeNode r4 = r2.getWikiMeta();
    L9:
        WikiInfoPlugin r5 = this.pluginHost.findPlugin(WikiInfoPlugin.class);
        if (r5 == null) goto L13;
        r3 = r5.getWikiPerm();
    L13:
        if (d.c() == true) goto L15;
    L23:
        r1 = false;
    L24:
        d.i(this.pluginHost, getId(), true, r1, getUnableTips(), "network_parent_can_move_from");
        return r1;
    L15:
        if (isSpaceShortcut(r4) == true) goto L24;
        if (r3 != null) goto L18;
    L20:
        boolean r6 = false;
    L21:
        if (r6 == false) goto L23;
    L18:
        if (r3.parent_can_move_from != true) goto L20;
        r6 = true;
        goto L21
    L8:
        r4 = null;
        goto L9
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        WikiInfoPlugin r0 = this.pluginHost.findPlugin(WikiInfoPlugin.class);
        if (r0 == null) goto L5;
        TreeNode r1 = r0.getWikiMeta();
    L7:
        if (isSpaceShortcut(r1) == false) goto L10;
        new rj5.g(this.pluginHost.getActivity()).b(getMoreInfo());
        getHost().a();
        return;
    L10:
        this.pluginHost.findPluginToDo(WikiDeletePlugin.class, b.a);
        getHost().a();
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        oj5.c r0 = getMoreInfo();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L12;
        logDecision(false, false, "vc_scene");
        return false;
    L12:
        if (isItemInvisibleByBenefit() == false) goto L16;
        logDecision(false, false, "benefit");
        return false;
    L16:
        if (com.bytedance.ee.bear.wikiv2.more.b.a(this.pluginHost) == false) goto L19;
        logDecision(false, false, "wiki_homepage");
        return false;
    L19:
        WikiInfoPlugin r3 = this.pluginHost.findPlugin(WikiInfoPlugin.class);
        if (r3 == null) goto L22;
        TreeNode r4 = r3.getWikiMeta();
    L24:
        if (isSpaceShortcut(r4) == false) goto L38;
        oj5.c r5 = getMoreInfo();
        if (r5 != null) goto L28;
    L30:
        boolean r6 = false;
    L31:
        if (r6 == true) goto L33;
    L35:
        r1 = false;
    L36:
        logDecision(r6, r1, "space_shortcut_owner");
        return r6;
    L33:
        if (isEnable() == false) goto L35;
    L28:
        if (r5.isOwner() != true) goto L30;
        r6 = true;
        goto L31
    L38:
        WikiInfoPlugin r7 = this.pluginHost.findPlugin(WikiInfoPlugin.class);
        if (r7 == null) goto L43;
        WikNodePerm r8 = r7.getWikiPerm();
        if (r8 == null) goto L43;
        boolean r9 = r8.show_delete;
    L44:
        if (r9 == true) goto L46;
    L48:
        r1 = false;
    L49:
        logDecision(r9, r1, "show_delete");
        return r9;
    L46:
        if (isEnable() == false) goto L48;
    L43:
        r9 = false;
        goto L44
    L22:
        r4 = null;
        goto L24
    L5:
        if (r0.m() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final PluginHost getPluginHost() {
        return this.pluginHost;
    }

    public WikiDeleteItem(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.pluginHost = r2;
    }

    private final boolean isSpaceShortcut(TreeNode r4) {
        if (r4 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
    L12:
        return false;
    L10:
        if (r4.isShortcut() == false) goto L12;
        return true;
    L5:
        if (r4.origin_is_external != true) goto L7;
        r2 = true;
        goto L8
    }

    private final void logDecision(boolean r8, boolean r9, String r10) {
        int r0 = d.a;
        if (d.b(getId()) == true) goto L5;
        return;
    L5:
        d.i(this.pluginHost, getId(), r8, r9, getUnableTips(), r10);
    }
}
