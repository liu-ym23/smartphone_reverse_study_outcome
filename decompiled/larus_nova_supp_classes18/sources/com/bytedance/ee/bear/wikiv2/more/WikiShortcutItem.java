package com.bytedance.ee.bear.wikiv2.more;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiInfoPlugin;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiShortcutPlugin;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/more/WikiShortcutItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/IGridMoreItem;", "pluginHost", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "documentName", "", "<init>", "(Lcom/bytedance/ee/bear/browser/plugin/PluginHost;Ljava/lang/String;)V", "getPluginHost", "()Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "getDocumentName", "()Ljava/lang/String;", "getId", "getTitle", "getIcon", "", "getIconTint", "isVisible", "", SendEventContainerMethodParamModel.EventKinds.onClick, "", "needShowBadge", "isEnable", "getUnableTips", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiShortcutItem extends BaseMoreItem implements IGridMoreItem {
    public static final a Companion = null;
    private static final String TAG = "WikiShortcutItem";
    private final String documentName;
    private final PluginHost pluginHost;

    public static final class a {
        public a() {
        }
    }

    public static final class b<P extends com.bytedance.ee.bear.browser.plugin.f> implements com.bytedance.ee.bear.browser.plugin.g {
        public final /* synthetic */ WikiShortcutItem a;

        public b(WikiShortcutItem r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.ee.bear.browser.plugin.f r2) {
            WikiShortcutPlugin r3 = (WikiShortcutPlugin) r2;
            Intrinsics.checkNotNullParameter(r3, "plugin");
            r3.shortcut(this.a.getDocumentName());
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
        d.i(this.pluginHost, getId(), true, r5, getUnableTips(), "network_origin_can_add_shortcut");
        return r1;
    L8:
        if (d.g(this.pluginHost) == false) goto L12;
        if (d.c() == false) goto L12;
        goto L12
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        int r0 = d.a;
        if (d.b(getId()) == true) goto L10;
        WikiInfoPlugin r1 = this.pluginHost.findPlugin(WikiInfoPlugin.class);
        if (r1 == null) goto L38;
        WikNodePerm r2 = r1.getWikiPerm();
        if (r2 != null) goto L9;
        return false;
    L9:
        return r2.getOriginCanShortcut(d.h(this.pluginHost));
    L38:
        return false;
    L10:
        oj5.c r3 = getMoreInfo();
        if (r3 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L18;
    L24:
        boolean r5 = false;
    L25:
        PluginHost r6 = this.pluginHost;
        String r7 = getId();
        if (r5 == true) goto L28;
    L30:
        boolean r8 = false;
    L31:
        if (r5 == true) goto L33;
    L35:
        String r9 = "";
    L36:
        boolean r10 = r5;
        d.i(r6, r7, r10, r8, r9, "origin_can_add_shortcut");
        return r5;
    L33:
        if (d.c() == true) goto L35;
        r9 = "network_unavailable";
        goto L36
    L28:
        if (d.c() == false) goto L30;
        r8 = true;
        goto L31
    L18:
        if (com.bytedance.ee.bear.wikiv2.more.b.a(this.pluginHost) == true) goto L24;
        if (d.e(this.pluginHost) == true) goto L24;
        if (d.g(this.pluginHost) == false) goto L24;
        r5 = true;
        goto L25
    L13:
        if (r3.m() != true) goto L15;
        r4 = true;
        goto L16
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        tt5.a.h(TAG, "onClick()...");
        sj5.b r0 = getHost();
        if (r0 == null) goto L5;
        r0.a();
    L5:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).setActivity(this.pluginHost.getActivity());
        this.pluginHost.findPluginToDo(WikiShortcutPlugin.class, new b(this));
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return kac.a.b(2131255216);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        String r0 = getString(2131889880);
    L7:
        th = move-exception;
        tt5.a.e(TAG, "getTitle()...", th, false);
        return r0;
    L4:
        if (TextUtils.equals(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(), Locale.CHINESE.getLanguage()) == false) goto L12;
        return r0.substring(0, 4) + '\n' + r0.substring(4);
    L12:
        return r0;
    }

    public final String getDocumentName() {
        return this.documentName;
    }

    public final PluginHost getPluginHost() {
        return this.pluginHost;
    }

    public WikiShortcutItem(PluginHost r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.pluginHost = r2;
        this.documentName = r3;
    }
}
