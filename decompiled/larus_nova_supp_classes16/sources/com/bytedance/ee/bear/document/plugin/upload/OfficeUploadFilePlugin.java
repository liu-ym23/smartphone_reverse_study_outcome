package com.bytedance.ee.bear.document.plugin.upload;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeUploadFilePlugin extends DocumentPluginV3 {
    private static final String BIZ_UTIL_CANCEL_UPLOAD = "biz.util.cancelUploadFile";

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OfficeUploadFilePlugin() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getBridgeHandlers(Map<String, tb5.i<?>> r9) {
        r9.put(BIZ_UTIL_CANCEL_UPLOAD, new d());
        r9.put("biz.util.uploadFile", new OfficeUploadFileHandler(getContext(), (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), (NetService) org.koin.java.a.a(NetService.class), com.bytedance.ee.bear.contract.j.a.a, OfficeUploadFileHandler.From.WebView));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromHost(ChameleonPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
        CopyOnWriteArrayList r3 = (CopyOnWriteArrayList) OfficeUploadFileHandler.h;
        if (r3.isEmpty() == true) goto L6;
        String[] r0 = new String[r3.size()];
        r3.toArray(r0);
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().d(r0);
        return;
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }
}
