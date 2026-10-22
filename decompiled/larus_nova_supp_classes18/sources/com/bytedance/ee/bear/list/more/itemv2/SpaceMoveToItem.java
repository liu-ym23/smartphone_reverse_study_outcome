package com.bytedance.ee.bear.list.more.itemv2;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.s4;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import td5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SpaceMoveToItem extends MoveItemV2 {
    private static final String CCM_MOBILE_ENABLE_MORE_PANEL_DOCUMENT_INFO_REFRESH = "ccm.mobile.enable_more_panel_document_info_refresh";
    private static final String TAG = "SpaceMoveToItem";
    private PluginHost pluginHost;

    @Override // com.bytedance.ee.bear.list.more.itemv2.MoveItemV2, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        return true;
    }

    private boolean enableDocumentInfoRefresh() {
        dn4.a r2 = (dn4.a) this.pluginHost.getUserComponent().a(dn4.a.class);     // Catch: Throwable -> L9
        if (r2 != null) goto L7;
        tt5.a.k(TAG, "enableDocumentInfoRefresh: userAppSetting or fgService is null");     // Catch: Throwable -> L9
        return false;
    L7:
        r2.a();     // Catch: Throwable -> L9
        return r2.a().isEnable(CCM_MOBILE_ENABLE_MORE_PANEL_DOCUMENT_INFO_REFRESH);
    L9:
        th = move-exception;
        tt5.a.e(TAG, "enableDocumentInfoRefresh error", th, false);
        return false;
    }

    @Override // com.bytedance.ee.bear.list.more.itemv2.MoveItemV2, com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem, com.bytedance.ee.bear.more.protocol3.b, com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem, com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public void create() {
        tt5.a.h(TAG, "create: moreInfo:" + getMoreInfo());
        this.mDocument = getDocumentFromMoreInfo(getMoreInfo());
        this.mAccount = ((h0) org.koin.java.a.a(h0.class)).U5();
        getNodeToken();
    }

    @Override // com.bytedance.ee.bear.list.more.itemv2.MoveItemV2, com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getUnableTips() {
        if (this.mContext != null) goto L7;
        return "";
    L7:
        if (j.a.a.getNetworkState().a() == true) goto L11;
        return getString(2131887951);
    L11:
        return this.mContext.getString(2131887932);
    }

    @Override // com.bytedance.ee.bear.list.more.itemv2.MoveItemV2, com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        boolean r3 = true;
        if (enableDocumentInfoRefresh() == false) goto L19;
        this.mDocument = updateDocument(this.mDocument, getMoreInfo());
        if (getMoreInfo() != null) goto L7;
    L9:
        boolean r0 = false;
    L10:
        Document r5 = this.mDocument;
        if (r5 != null) goto L13;
    L16:
        r3 = false;
    L17:
        tt5.a.h(TAG, "isEnable: enable:" + r3 + " ownerTypeNotNull:" + r0 + " mDocument:" + this.mDocument);
        return r3;
    L13:
        if (TextUtils.isEmpty(r5.c) == true) goto L16;
        if (r0 == false) goto L16;
    L7:
        if (getMoreInfo().A() == null) goto L9;
        r0 = true;
        goto L10
    L19:
        Document r1 = this.mDocument;
        if (r1 != null) goto L22;
    L24:
        r3 = false;
    L25:
        tt5.a.h(TAG, "isEnable: enable:" + r3);
        return r3;
    L22:
        if (TextUtils.isEmpty(r1.c) == true) goto L24;
        goto L24
    }

    public SpaceMoveToItem(PluginHost r9) {
        this(r9.getContext(), null, null, true, "", "", "");
        this.pluginHost = r9;
    }

    private static Document getDocumentFromMoreInfo(oj5.c r2) {
        if ((r2 instanceof oj5.a) == false) goto L7;
        Document r0 = new Document();
        r0.e = r2.t();
        r0.f = r2.a();
        r0.L1 = r2.C();
        r0.n = false;
        r0.d = r2.getToken();
        r0.c = "";
        r0.b = r2.getType();
        r0.M1 = NodeType.ENTITY.getValue();
        return r0;
    L7:
        return new Document();
    }

    private static Document updateDocument(Document r2, oj5.c r3) {
        tt5.a.h(TAG, "updateDocument() called with: document = [" + r2 + "], moreInfo = [" + r3 + "]");
        if (r2 != null) goto L5;
    L7:
        return r2;
    L5:
        if ((r3 instanceof oj5.a) == false) goto L7;
        r2.e = r3.t();
        r2.f = r3.a();
        r2.L1 = r3.C();
        r2.n = false;
        r2.d = r3.getToken();
        r2.b = r3.getType();
        r2.M1 = NodeType.ENTITY.getValue();
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.more.itemv2.MoveItemV2
    public void navigationSelectorActivity(SelectorConfig r8, f r9, SpaceSelectorBean r10) {
        s4 r0 = this.pluginHost.getHostAbilityOrNull(s4.class);
        if (r0 == null) goto L6;
        Fragment r2 = r0.getFragment();
        r9.e = 1030;
        ((com.bytedance.ee.bear.contract.route.parcelable.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.route.parcelable.f.class)).a(r2, r8, r9, r10, null);
        return;
    }

    public SpaceMoveToItem(Context r1, Document r2, AccountService.Account r3, boolean r4, String r5, String r6, String r7) {
        super(r1, r2, r3, r4, r5, r6, r7);
    }
}
