package com.bytedance.ee.bear.wikiv2.more;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.more.itemv2.PinItemV2;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiInfoPlugin;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiPinPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiPinItem extends PinItemV2 {
    private static final String TAG = "WikiPinItem";
    private final PluginHost mPluginHost;
    private TreeNode mWikiInfo;

    public static /* synthetic */ void a(WikiPinItem r0, oj5.c r1, WikiPinPlugin r2) {
        r0.lambda$onClick$0(r1, r2);
    }

    @Override // com.bytedance.ee.bear.more.itemv2.PinItemV2, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return TAG;
    }

    private TreeNode getWikiInfo() {
        TreeNode r0 = this.mWikiInfo;
        if (r0 == null) goto L5;
        return r0;
    L5:
        PluginHost r1 = this.mPluginHost;
        if (r1 != null) goto L8;
        return null;
    L8:
        WikiInfoPlugin r2 = r1.findPlugin(WikiInfoPlugin.class);
        if (r2 != null) goto L11;
        return null;
    L11:
        TreeNode r3 = r2.getWikiMeta();
        this.mWikiInfo = r3;
        return r3;
    }

    @Override // com.bytedance.ee.bear.more.itemv2.PinItemV2
    public boolean isPined() {
        TreeNode r0 = getWikiInfo();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.is_explorer_pin == false) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.more.itemv2.PinItemV2, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        TreeNode r0 = getWikiInfo();
        if (r0 == null) goto L13;
        boolean r2 = r0.origin_is_external;
        boolean r3 = r0.isShortcut();
        if (r0.getOriginIsDeleted() == false) goto L7;
        return false;
    L7:
        if (r3 == false) goto L12;
        if (r2 == false) goto L12;
        return true;
    L12:
        return yp5.c.j();
    L13:
        return false;
    }

    @Override // com.bytedance.ee.bear.more.itemv2.PinItemV2, com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        final oj5.c r0 = getMoreInfo();
        tt5.a.b(TAG, "onItemClick: docInfoData = " + r0);
        if (r0 != null) goto L5;
        return;
    L5:
        this.mPluginHost.findPluginToDo(WikiPinPlugin.class, new f(this, r0));
        getHost().a();
    }

    public WikiPinItem(PluginHost r3) {
        super(((dn4.a) r3.getUserComponent().a(dn4.a.class)).a());
        this.mPluginHost = r3;
    }

    @Override // com.bytedance.ee.bear.more.itemv2.PinItemV2
    public String getPinToken(oj5.c r2) {
        TreeNode r0 = getWikiInfo();
        if (r0 == null) goto L13;
        if (r0.origin_is_external == true) goto L11;
        if (yp5.c.j() == false) goto L11;
        return r0.getOriginToken();
    L11:
        return r0.obj_token;
    L13:
        return super.getPinToken(r2);
    }

    @Override // com.bytedance.ee.bear.more.itemv2.PinItemV2
    public int getPinType(oj5.c r2) {
        TreeNode r0 = getWikiInfo();
        if (r0 == null) goto L13;
        if (r0.origin_is_external == true) goto L11;
        if (yp5.c.j() == false) goto L11;
        return sbb.e.n.b;
    L11:
        return r0.obj_type;
    L13:
        return super.getPinType(r2);
    }

    private /* synthetic */ void lambda$onClick$0(oj5.c r2, WikiPinPlugin r3) {
        if (isPined() == true) goto L5;
        r3.pin(getPinToken(r2), getPinType(r2));
        return;
    L5:
        r3.unpin(getPinToken(r2), getPinType(r2));
    }
}
