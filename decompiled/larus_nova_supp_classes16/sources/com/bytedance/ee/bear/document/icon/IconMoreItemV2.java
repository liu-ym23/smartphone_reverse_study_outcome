package com.bytedance.ee.bear.document.icon;

import android.os.Bundle;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/document/icon/IconMoreItemV2;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ITextMoreItem;", "pluginHost", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "<init>", "(Lcom/bytedance/ee/bear/document/DocumentPluginHost;)V", "isEnable", "", "getIcon", "", "getIconTint", "getTitle", "", "getStateTips", "onDisableClick", "", "onClick", "getId", "getUnableTips", "isVisible", "needShowBadge", "openIconSetting", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IconMoreItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final a Companion = null;
    public static final String NAME = "iconV2";
    private static final Set<sbb.e> sSupportDocumentTypes = null;
    private final DocumentPluginHost pluginHost;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.bytedance.ee.bear.browser.plugin.g<IconPlugin> {
        public b() {
        }

        @Override // com.bytedance.ee.bear.browser.plugin.g
        public final void a(com.bytedance.ee.bear.browser.plugin.f r3) {
            IconPlugin r4 = (IconPlugin) r3;
            Intrinsics.checkNotNullParameter(r4, "plugin");
            r4.showIconSelectList();
            ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).b(IconMoreItemV2.NAME);
        }
    }

    public int getIcon() {
        return 2131254312;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return NAME;
    }

    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.-CC.$default$getMoreAction(this);
    }

    public String getStateTips() {
        return "";
    }

    public void onDisableClick() {
    }

    static {
        Companion = new a();
        sSupportDocumentTypes = SetsKt.setOf(new sbb.e[]{sbb.e.g, sbb.e.h, sbb.e.k});
    }

    private final void openIconSetting() {
        this.pluginHost.findPluginToDo(IconPlugin.class, new b());
    }

    public String getUnableTips() {
        return this.pluginHost.getContext().getString(2131887666);
    }

    public boolean isVisible() {
        Set<sbb.e> r0 = sSupportDocumentTypes;
        oj5.c r1 = getMoreInfo();
        if (r1 == null) goto L5;
        int r2 = r1.getType();
    L6:
        boolean r3 = r0.contains(sbb.e.d(r2));
        boolean r4 = this.pluginHost.a().isType(sbb.e.n);
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.docs_diy_icon", false) == false) goto L12;
        if (r3 == false) goto L13;
        if (r4 == true) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L12:
        return false;
    L5:
        r2 = sbb.e.g.b;
        goto L6
    }

    public boolean needShowBadge() {
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).l(NAME);
    }

    public String getTitle() {
        return getString(2131887669);
    }

    public boolean isEnable() {
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L6;
        return false;
    L6:
        if ((r0 instanceof oj5.b) == false) goto L8;
        return false;
    L8:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L13;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).v(r0, r0.c().a, "EDIT").booleanValue();
    L13:
        return r0.n();
    }

    public void onClick() {
        getHost().a();
        openIconSetting();
        oj5.a r0 = getMoreInfo();
        if ((r0 instanceof oj5.a) == false) goto L6;
        com.bytedance.ee.bear.more.b r1 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        Bundle r3 = getHost().getHostFragment().getArguments();
        oj5.a r2 = r0;
        r1.c(new i(r3, r2.c, r2.getType(), false, r2.b(), CustomHeaderConfig.Menu.Style.ICON_STYLE, "none", "", "", r0 instanceof oj5.f, r2.k, r2.r, r2.isOwner(), r2.L()));
        return;
    }

    public IconMoreItemV2(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.pluginHost = r2;
    }
}
