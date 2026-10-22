package com.bytedance.ee.bear.wikiv2.more;

import android.content.Context;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiExploreFavoritePlugin;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiInfoPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/more/WikiExploreStarItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/IGridMoreItem;", "pluginHost", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "<init>", "(Lcom/bytedance/ee/bear/browser/plugin/PluginHost;)V", "isStared", "", "()Z", "getId", "", "getTitle", "getIcon", "", "getIconTint", "isVisible", "needShowBadge", "isEnable", "getUnableTips", SendEventContainerMethodParamModel.EventKinds.onClick, "", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiExploreStarItem extends BaseMoreItem implements IGridMoreItem {
    public static final a Companion = null;
    private static final String TAG = "WikiExploreStarItem";
    private final PluginHost pluginHost;

    public static final class a {
        public a() {
        }
    }

    public static final class b<P extends com.bytedance.ee.bear.browser.plugin.f> implements com.bytedance.ee.bear.browser.plugin.g {
        public final /* synthetic */ WikiExploreStarItem a;

        public b(WikiExploreStarItem r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.ee.bear.browser.plugin.f r2) {
            WikiExploreFavoritePlugin r3 = (WikiExploreFavoritePlugin) r2;
            Intrinsics.checkNotNullParameter(r3, "plugin");
            r3.exploreFavorite(!WikiExploreStarItem.access$isStared(this.a));
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return TAG;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean needShowBadge() {
        return false;
    }

    private final boolean isStared() {
        WikiInfoPlugin r0 = this.pluginHost.findPlugin(WikiInfoPlugin.class);
        if (r0 == null) goto L7;
        TreeNode r1 = r0.getWikiMeta();
        if (r1 == null) goto L7;
        return r1.is_explorer_star;
    L7:
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public String getUnableTips() {
        int r0 = d.a;
        if (d.b(getId()) == true) goto L6;
        return "";
    L6:
        if (d.c() == false) goto L8;
        PluginHost r1 = this.pluginHost;
        Intrinsics.checkNotNullParameter(r1, "pluginHost");
        Context r2 = r1.getContext();
        if (r2 == null) goto L12;
        String r3 = r2.getString(2131887803);
    L13:
        if (r3 != null) goto L16;
        return "";
    L16:
        return r3;
    L12:
        r3 = null;
        goto L13
    L8:
        return d.a(this.pluginHost);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean isEnable() {
        int r0 = d.a;
        boolean r1 = true;
        if (d.b(getId()) == true) goto L6;
        return true;
    L6:
        if (d.e(this.pluginHost) == false) goto L8;
    L12:
        r1 = false;
    L13:
        boolean r5 = r1;
        d.i(this.pluginHost, getId(), true, r5, getUnableTips(), "network_origin_can_explorer_star");
        return r1;
    L8:
        if (d.f(this.pluginHost) == false) goto L12;
        if (d.c() == false) goto L12;
        goto L12
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        int r0 = d.a;
        if (d.b(getId()) == true) goto L5;
        return true;
    L5:
        oj5.c r1 = getMoreInfo();
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L13;
    L19:
        boolean r3 = false;
    L20:
        PluginHost r4 = this.pluginHost;
        String r5 = getId();
        if (r3 == true) goto L23;
    L25:
        boolean r6 = false;
    L26:
        if (r3 == true) goto L28;
    L30:
        String r7 = "";
    L31:
        boolean r8 = r3;
        d.i(r4, r5, r8, r6, r7, "origin_can_explorer_star");
        return r3;
    L28:
        if (d.c() == true) goto L30;
        r7 = "network_unavailable";
        goto L31
    L23:
        if (d.c() == false) goto L25;
        r6 = true;
        goto L26
    L13:
        if (com.bytedance.ee.bear.wikiv2.more.b.a(this.pluginHost) == true) goto L19;
        if (d.e(this.pluginHost) == true) goto L19;
        if (d.f(this.pluginHost) == false) goto L19;
        r3 = true;
        goto L20
    L8:
        if (r1.m() != true) goto L10;
        r2 = true;
        goto L11
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        this.pluginHost.findPluginToDo(WikiExploreFavoritePlugin.class, new b(this));
        getHost().a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        if (isStared() == false) goto L5;
        return 2131254025;
    L5:
        return 2131254139;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        if (isStared() == false) goto L5;
        int r0 = 2131889631;
    L7:
        return getString(r0);
    L5:
        r0 = 2131887713;
        goto L7
    }

    public WikiExploreStarItem(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.pluginHost = r2;
    }

    public static final /* synthetic */ boolean access$isStared(WikiExploreStarItem r0) {
        return r0.isStared();
    }
}
