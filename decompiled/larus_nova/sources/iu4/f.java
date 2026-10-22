package iu4;

import com.bytedance.ee.bear.bitable.preload.BitablePreloadConfig;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f {
    public static final void a(String r100, String r101, String r102, String r103, NetService.f<String> r104) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.BLOCK_ID);
        Intrinsics.checkNotNullParameter(r101, "viewId");
        Intrinsics.checkNotNullParameter(r102, "openType");
        Intrinsics.checkNotNullParameter(r103, "recordId");
        Intrinsics.checkNotNullParameter(r104, "request");
        BitablePreloadConfig.Companion.getClass();
        int r105 = BitablePreloadConfig.a.a().getBitableRecordNumWhenPageLoad();
        r104.f216906c = 2;
        r104.b("needBase", "true");
        r104.b("recordLimit", "20");
        r104.b("ondemandLimit", String.valueOf(r105));
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.mobile.partial_load_enabled") == false) goto L5;
        r104.b("ondemandVer", "2");
    L5:
        r104.b("noMissCS", "true");
        r104.b("queryMode", "1");
        r104.b("openType", r102);
        r104.b("viewLazyLoad", "true");
        r104.b("tableID", r100);
        r104.b("viewID", r101);
        r104.b("record", r103);
        int r106 = com.bytedance.ee.bear.bitable.c.f207079a;
        r104.b("removeFmlExtra", String.valueOf(com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.formula.request_fxdb_value_only")));
    }
}
