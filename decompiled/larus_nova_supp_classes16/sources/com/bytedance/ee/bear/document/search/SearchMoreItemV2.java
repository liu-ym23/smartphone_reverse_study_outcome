package com.bytedance.ee.bear.document.search;

import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SearchMoreItemV2 extends BaseMoreItem implements ITextMoreItem {
    private static final String SEARCH_ID = "searchV2";
    private static final String TAG = "SearchItemV2";
    private DocumentPluginHost pluginHost;

    public static /* synthetic */ void a(oj5.c r0, BaseSearchPlugin r1) {
        lambda$startSearch$0(r0, r1);
    }

    public int getIcon() {
        return 2131254041;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return SEARCH_ID;
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

    public void onDisableClick() {
    }

    public void onClick() {
        oj5.c r1 = getMoreInfo();
        tt5.a.b(TAG, "onItemClick: docInfoData = " + r1);
        if (r1 == null) goto L6;
        startSearch(r1);
    L6:
        if ((getMoreInfo() instanceof oj5.a) == false) goto L10;
        oj5.a r2 = getMoreInfo();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new com.bytedance.ee.bear.more.i(getHost().getHostFragment().getArguments(), r2.c, r2.getType(), false, r2.b(), "find_replace", "ccm_doc_find_replace_panel_view", "", "", r2 instanceof oj5.f, r2.k, r2.r, r2.isOwner(), r2.L()));
        if (this.pluginHost.a().isEditionDoc() == false) goto L10;
        ((com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class)).q(this.pluginHost.a().getDocumentTypeValue(), "find_replace", "ccm_doc_find_replace_panel_view", null, null, null);
    L10:
        getHost().a();
    }

    public String getTitle() {
        return getString(2131887770);
    }

    public boolean isEnable() {
        if ((getMoreInfo() instanceof oj5.a) == true) goto L5;
    L11:
        return true;
    L5:
        if (getMoreInfo().i() != 3) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        boolean r1 = isItemDisabledByJSMsg();
        tt5.a.h(TAG, "is sheet, isSearchDisabled :" + r1);
        return !r1;
    L7:
        r0 = false;
        goto L8
    }

    public boolean isVisible() {
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (isItemInvisibleByJSMsg() == false) goto L9;
        return false;
    L9:
        if (r0.c() == null) goto L16;
        if (r0.c().a == null) goto L16;
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r0, r0.c().a, "PERCEIVE_CONTROL").booleanValue() == false) goto L16;
        return false;
    L16:
        if (r0.getType() != sbb.e.g.b) goto L18;
    L25:
        return true;
    L18:
        if (r0.getType() == sbb.e.h.b) goto L25;
        if (r0.getType() == sbb.e.i.b) goto L25;
        if (r0.getType() == sbb.e.o.b) goto L24;
        return false;
    L24:
        if (com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.doc.moblie.find") == true) goto L25;
        return false;
    }

    public boolean needShowBadge() {
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.getType() == sbb.e.h.b) goto L8;
        return false;
    L8:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).l(SEARCH_ID) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public SearchMoreItemV2(DocumentPluginHost r1) {
        this.pluginHost = r1;
    }

    private void startSearch(final oj5.c r4) {
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).s(r4, "search_replace");
        this.pluginHost.findPluginToDo(BaseSearchPlugin.class, new c(r4));
    }

    private static void lambda$startSearch$0(oj5.c r3, final BaseSearchPlugin r4) {
        Objects.requireNonNull(r4);
        com.bytedance.ee.util.ui.j.d(new b(r4), 300);
        if (r3.getType() != sbb.e.h.b) goto L6;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).b(SEARCH_ID);
        return;
    }
}
