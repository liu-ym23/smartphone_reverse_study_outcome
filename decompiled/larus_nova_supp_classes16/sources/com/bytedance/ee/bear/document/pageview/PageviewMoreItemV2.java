package com.bytedance.ee.bear.document.pageview;

import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.more.b;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import e35.a;
import oj5.c;
import oj5.f;
import org.json.JSONObject;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PageviewMoreItemV2 extends BaseMoreItem implements ITextMoreItem {
    private static final String NAME = "pageviewV2";
    private static final String TAG = "PageviewMoreItemV2";
    private PluginHost pluginHost;

    public static /* synthetic */ void a(PageviewMoreItemV2 r0, PageviewPlugin r1) {
        r0.lambda$onClick$0(r1);
    }

    public int getIcon() {
        return 2131254921;
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

    public String getUnableTips() {
        return "";
    }

    public boolean isEnable() {
        return true;
    }

    public boolean needShowBadge() {
        return false;
    }

    public void onDisableClick() {
    }

    public void onClick() {
        this.pluginHost.findPluginToDo(PageviewPlugin.class, new a(this));
        ((b) org.koin.java.a.a(b.class)).s(getMoreInfo(), "reading_data");
        if (ForsetiHelper.s(getHost().getHostFragment()) == true) goto L5;
        getHost().a();
    L5:
        reportShowDocDetails();
        if ((getMoreInfo() instanceof oj5.a) == false) goto L9;
        oj5.a r1 = getMoreInfo();
        ((b) org.koin.java.a.a(b.class)).c(new i(getHost().getHostFragment().getArguments(), r1.c, r1.getType(), false, r1.b(), "docs_details", "ccm_space_docs_details_view", "", "", r1 instanceof f, r1.k, r1.r, r1.isOwner(), r1.L()));
        return;
    }

    private void reportShowDocDetails() {
        c r0 = getMoreInfo();
        if (r0 == null) goto L12;
        JSONObject r1 = new JSONObject();
        r1.put("module", "doc");     // Catch: Exception -> L7
        r1.put("sub_module", "null");     // Catch: Exception -> L7
        r1.put("file_id", du5.b.g(r0.getToken()));     // Catch: Exception -> L7
        r1.put("file_type", e.c(r0.getType()));     // Catch: Exception -> L7
        r1.put("sub_file_type", "null");     // Catch: Exception -> L7
        r1.put("container_id", "null");     // Catch: Exception -> L7
        r1.put("container_type", "null");     // Catch: Exception -> L7
        r1.put("app_form", "null");     // Catch: Exception -> L7
        ((d) org.koin.java.a.a(d.class)).i("ccm_space_docs_details_view", r1);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.d(TAG, "reportShowDocDetails()...error = " + e);
        return;
    }

    public String getTitle() {
        return getString(2131889043);
    }

    public boolean isVisible() {
        c r0 = getMoreInfo();
        if (r0 != null) goto L5;
    L19:
        return false;
    L5:
        if (r0.getType() != e.g.b) goto L7;
    L18:
        return true;
    L7:
        if (r0.getType() == e.o.b) goto L18;
        if (r0.getType() == e.h.b) goto L18;
        if (r0.getType() == e.k.b) goto L18;
        if (r0.getType() == e.i.b) goto L18;
        if (r0.getType() != e.m.b) goto L19;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.slides_enabled") == false) goto L19;
        goto L18
    }

    public PageviewMoreItemV2(PluginHost r1) {
        this.pluginHost = r1;
    }

    private /* synthetic */ void lambda$onClick$0(PageviewPlugin r2) {
        r2.showPageview(getHost().getHostFragment());
    }
}
