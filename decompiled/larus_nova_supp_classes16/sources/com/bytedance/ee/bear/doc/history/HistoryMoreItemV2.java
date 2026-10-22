package com.bytedance.ee.bear.doc.history;

import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.doc.editmodeswitchplugin.EditModeSwitchPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.more.protocol3.panel.y;
import com.bytedance.ee.util.info.AppInfoUtils;
import oj5.c;
import oj5.f;
import sbb.e;
import ty4.a;
import ty4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class HistoryMoreItemV2 extends BaseMoreItem implements ITextMoreItem {
    private static final String TAG = "HistoryMoreItemV2";
    private DocumentPluginHost pluginHost;

    public static /* synthetic */ void a(HistoryMoreItemV2 r0, HistoryPlugin r1) {
        r0.lambda$showHistory$0(r1);
    }

    private String resolveDisableReason(boolean r1, boolean r2, boolean r3) {
        if (r2 == true) goto L5;
        return "network";
    L5:
        if (r3 == false) goto L8;
        return "admin_preview_block";
    L8:
        if (r1 == true) goto L11;
        return "edit_permission";
    L11:
        return "";
    }

    public int getIcon() {
        return 2131254879;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return "historyV2";
    }

    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.-CC.$default$getMoreAction(this);
    }

    public String getStateTips() {
        return "";
    }

    public boolean needShowBadge() {
        return false;
    }

    public void onDisableClick() {
    }

    private void showHistory() {
        this.pluginHost.findPluginToDo(EditModeSwitchPlugin.class, new a());
        this.pluginHost.findPluginToDo(HistoryPlugin.class, new b(this));
    }

    public String getTitle() {
        return getString(2131889050);
    }

    public String getUnableTips() {
        c r0 = getMoreInfo();
        if (y.a() == false) goto L9;
        if (j.a.a.getNetworkState().a() == true) goto L9;
        return this.pluginHost.getContext().getString(2131887951);
    L9:
        if (y.a() == false) goto L16;
        if (r0 == null) goto L16;
        if (isAdminPreviewBlocked(r0) == false) goto L16;
        return this.pluginHost.getContext().getString(2131887246);
    L16:
        return this.pluginHost.getContext().getString(2131887776);
    }

    public boolean isEnable() {
        c r0 = getMoreInfo();
        boolean r2 = false;
        if (isVisible() == false) goto L8;
        if (r0 == null) goto L8;
        if (r0.n() == false) goto L8;
        boolean r1 = true;
    L10:
        if (y.a() == true) goto L13;
        y.c(TAG, getId());
        return r1;
    L13:
        boolean r4 = j.a.a.getNetworkState().a();
        if (r0 != null) goto L16;
    L18:
        boolean r3 = false;
    L19:
        if (r1 == false) goto L23;
        if (r4 == false) goto L23;
        if (r3 == true) goto L23;
        r2 = true;
    L23:
        String r6 = getId();
        boolean r7 = isVisible();
        if (r2 == false) goto L26;
        String r5 = "";
    L27:
        boolean r8 = r2;
        y.b(TAG, r6, r7, r8, r5, "edit_permission_network_admin,baselineEnabled=" + r1 + ",networkConnected=" + r4 + ",adminPreviewBlocked=" + r3);
        return r2;
    L26:
        r5 = resolveDisableReason(r1, r4, r3);
        goto L27
    L16:
        if (isAdminPreviewBlocked(r0) == false) goto L18;
        r3 = true;
    L8:
        r1 = false;
        goto L10
    }

    public boolean isVisible() {
        c r0 = getMoreInfo();
        boolean r1 = false;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.m() == false) goto L9;
        return false;
    L9:
        if (isAdminPreviewBlocked(r0) == true) goto L11;
    L14:
        boolean r2 = isSlideHistory(r0);
        if (r0.getType() != e.g.b) goto L17;
        boolean r3 = true;
    L19:
        if (com.bytedance.ee.bear.appsetting.c.a.a.f("spacekit.mobile.docx_history_enable") == true) goto L21;
    L23:
        boolean r4 = false;
    L24:
        if (r3 == true) goto L27;
        if (r4 == true) goto L27;
        if (r2 == true) goto L27;
    L28:
        y.b(TAG, getId(), r1, r1, "", "document_type,adminPreviewBlocked=" + isAdminPreviewBlocked(r0));
        return r1;
    L27:
        r1 = true;
        goto L28
    L21:
        if (r0.getType() != e.o.b) goto L23;
        r4 = true;
        goto L24
    L17:
        r3 = false;
        goto L19
    L11:
        if (y.a() == true) goto L14;
        y.c(TAG, getId());
        return false;
    }

    public void onClick() {
        showHistory();
        if ((getMoreInfo() instanceof oj5.a) == false) goto L10;
        oj5.a r0 = getMoreInfo();
        if (isSlideHistory(getMoreInfo()) == true) goto L7;
    L9:
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), r0.c, r0.getType(), false, r0.b(), "history_version", "ccm_docs_history_page_view", "", "", r0 instanceof f, r0.k, r0.r, r0.isOwner(), r0.L()));
        goto L10
    L7:
        if (DowngradeSettingUtil.a("downgradeSlideHistoryUt") == true) goto L9;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), r0.c, r0.getType(), false, r0.b(), "history", "ccm_space_docs_more_menu_click", "", "", r0 instanceof f, r0.k, r0.r, r0.isOwner(), r0.L()));
    L10:
        getHost().a();
    }

    public HistoryMoreItemV2(DocumentPluginHost r1) {
        this.pluginHost = r1;
    }

    private boolean isAdminPreviewBlocked(c r4) {
        if (r4.c() != null) goto L5;
    L9:
        return false;
    L5:
        if (r4.c().a == null) goto L9;
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r4, r4.c().a, "PERCEIVE_CONTROL").booleanValue() == false) goto L9;
        return true;
    }

    private static boolean isSlideHistory(c r2) {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.j("ccm.mobile.slides_editor_enable");
        if (r2.getType() != e.m.b) goto L8;
        if (r0 == false) goto L6;
    L7:
        return true;
    L6:
        if (Boolean.TRUE.equals(AppInfoUtils.f()) == true) goto L7;
    L8:
        return false;
    }

    private /* synthetic */ void lambda$showHistory$0(HistoryPlugin r4) {
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).s(getMoreInfo(), "history_record");
        r4.showHistory();
    }
}
