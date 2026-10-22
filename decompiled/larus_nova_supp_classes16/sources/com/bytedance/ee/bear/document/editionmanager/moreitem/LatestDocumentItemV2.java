package com.bytedance.ee.bear.document.editionmanager.moreitem;

import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.ss.android.lark.utils.LarkContext;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class LatestDocumentItemV2 extends BaseMoreItem implements IGridMoreItem {
    private static final String LATEST_DOCUMENT_ID = "latestDocumentItemV2";
    private static final String TAG = "LatestDocumentItemV2";
    protected final DocumentPluginHost pluginHost;

    public int getIcon() {
        return 2131256151;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return LATEST_DOCUMENT_ID;
    }

    public String getUnableTips() {
        return "";
    }

    public boolean needShowBadge() {
        return false;
    }

    public void onClick() {
        getHost().a();
        BearUrl r3 = this.pluginHost.a().getBearUrl();     // Catch: Exception -> L9
        String r4 = ((t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class)).Fd(this.pluginHost.a().getUrl(), r3.a, r3.b, new HashMap());     // Catch: Exception -> L9
        tt5.a.h(TAG, "onClick url: " + du5.b.k(r4));     // Catch: Exception -> L9
        String r2 = z05.i.c(r4);     // Catch: Exception -> L9
        tt5.a.h(TAG, "onClick resultUrl: " + du5.b.k(r2));     // Catch: Exception -> L9
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).u5(r2);     // Catch: Exception -> L9
        if (getMoreInfo() == null) goto L6;
        int r5 = getMoreInfo().getType();     // Catch: Exception -> L9
    L7:
        ((com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class)).q(r5, "back_to_source_doc", "none", null, null, null);     // Catch: Exception -> L9
        return;
    L6:
        r5 = -1;
    L9:
        e = move-exception;
        tt5.a.d(TAG, "onClick()...err: " + e.getMessage());
    }

    private int getRealType() {
        if (getMoreInfo() != null) goto L7;
        return -1;
    L7:
        return getMoreInfo().i();
    }

    public String getTitle() {
        return getString(2131889376);
    }

    public boolean isEnable() {
        if (z05.i.b(getRealType()) == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == false) goto L7;
        return true;
    }

    public boolean isVisible() {
        return z05.i.b(getRealType());
    }

    public LatestDocumentItemV2(DocumentPluginHost r1) {
        this.pluginHost = r1;
    }
}
