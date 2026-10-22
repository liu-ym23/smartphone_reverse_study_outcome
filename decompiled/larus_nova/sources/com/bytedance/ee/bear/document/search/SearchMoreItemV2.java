package com.bytedance.ee.bear.document.search;

import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.larus.nova.R;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public class SearchMoreItemV2 extends BaseMoreItem implements ITextMoreItem {
    private static final String SEARCH_ID = "searchV2";
    private static final String TAG = "SearchItemV2";
    private DocumentPluginHost pluginHost;

    public static /* synthetic */ void a(oj5.c r100, BaseSearchPlugin r101) {
        lambda$startSearch$0(r100, r101);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return R.drawable.ud_icon_card_search_outlined;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return R.color.icon_n1;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return SEARCH_ID;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.CC.$default$getMoreAction(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getStateTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getUnableTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        oj5.c r100 = getMoreInfo();
        tt5.a.b(TAG, "onItemClick: docInfoData = " + r100);
        if (r100 == null) goto L6;
        startSearch(r100);
    L6:
        if ((getMoreInfo() instanceof oj5.a) == false) goto L10;
        oj5.a r101 = (oj5.a) getMoreInfo();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new com.bytedance.ee.bear.more.i(getHost().getHostFragment().getArguments(), r101.f523532c, r101.getType(), false, r101.b(), "find_replace", "ccm_doc_find_replace_panel_view", "", "", r101 instanceof oj5.f, r101.f523540k, r101.f523547r, r101.isOwner(), r101.L()));
        if (this.pluginHost.a().isEditionDoc() == false) goto L10;
        ((com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class)).q(this.pluginHost.a().getDocumentTypeValue(), "find_replace", "ccm_doc_find_replace_panel_view", null, null, null);
    L10:
        getHost().a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(R.string.Doc_Facade_LookFor);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        if ((getMoreInfo() instanceof oj5.a) == true) goto L5;
    L11:
        return true;
    L5:
        if (((oj5.a) getMoreInfo()).i() != 3) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == false) goto L11;
        boolean r101 = isItemDisabledByJSMsg();
        tt5.a.h(TAG, "is sheet, isSearchDisabled :" + r101);
        return !r101;
    L7:
        r100 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        oj5.c r100 = getMoreInfo();
        if (r100 != null) goto L6;
        return false;
    L6:
        if (isItemInvisibleByJSMsg() == false) goto L9;
        return false;
    L9:
        if (r100.c() == null) goto L16;
        if (r100.c().f234419a == null) goto L16;
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r100, r100.c().f234419a, "PERCEIVE_CONTROL").booleanValue() == false) goto L16;
        return false;
    L16:
        if (r100.getType() != sbb.e.f541296g.f541317b) goto L18;
    L25:
        return true;
    L18:
        if (r100.getType() == sbb.e.f541297h.f541317b) goto L25;
        if (r100.getType() == sbb.e.f541298i.f541317b) goto L25;
        if (r100.getType() == sbb.e.f541304o.f541317b) goto L24;
        return false;
    L24:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.f("ccm.doc.moblie.find") == true) goto L25;
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean needShowBadge() {
        oj5.c r100 = getMoreInfo();
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getType() == sbb.e.f541297h.f541317b) goto L8;
        return false;
    L8:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).l(SEARCH_ID) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public SearchMoreItemV2(DocumentPluginHost r100) {
        this.pluginHost = r100;
    }

    private void startSearch(final oj5.c r100) {
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).s(r100, "search_replace");
        this.pluginHost.findPluginToDo(BaseSearchPlugin.class, new c(r100));
    }

    private static void lambda$startSearch$0(oj5.c r100, final BaseSearchPlugin r101) {
        Objects.requireNonNull(r101);
        com.bytedance.ee.util.ui.j.d(new b(r101), 300);
        if (r100.getType() != sbb.e.f541297h.f541317b) goto L6;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).b(SEARCH_ID);
        return;
    }
}
