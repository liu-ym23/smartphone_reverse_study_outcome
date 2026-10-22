package com.bytedance.ee.bear.document.offline.file.upload;

import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class UploadFilePlugin extends DocumentPlugin {
    private static final String BIZ_UTIL_CANCEL_UPLOAD = "biz.util.cancelUploadFile";

    public static /* synthetic */ void c(UploadFilePlugin r0, UploadFileHandler r1, DocumentInfo r2) {
        r0.lambda$getBridgeHandlers$0(r1, r2);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public UploadFilePlugin() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r9) {
        r9.put(BIZ_UTIL_CANCEL_UPLOAD, new d());
        final UploadFileHandler r0 = new UploadFileHandler(getContext(), (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), (NetService) org.koin.java.a.a(NetService.class), com.bytedance.ee.bear.contract.j.a.a, UploadFileHandler.From.WebView);
        r9.put("biz.util.uploadFile", r0);
        getDocViewModel().getDocumentInfoProvider().g().observe(((DocumentPluginHost) getHost()).c(), new w(this, r0));
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        super.onDetachFromHost(r2);
        CopyOnWriteArrayList r3 = (CopyOnWriteArrayList) UploadFileHandler.j;
        if (r3.isEmpty() == true) goto L6;
        String[] r0 = new String[r3.size()];
        r3.toArray(r0);
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().d(r0);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void lambda$getBridgeHandlers$0(UploadFileHandler r2, DocumentInfo r3) {
        if (getDocViewModel().getOriginBearUrl() != null) goto L5;
    L7:
        AccountService$Account r4 = ((h0) ((DocumentPluginHost) getHost()).getUserComponent().a(h0.class)).G2();
        if (r4 != null) goto L10;
    L13:
        String r5 = "";
    L14:
        boolean r6 = TextUtils.equals(r5, getDocViewModel().getCreatorTenantId());
    L15:
        r2.h = r6;
        return;
    L10:
        if (TextUtils.isEmpty(r4.tenantId) == true) goto L13;
        r5 = r4.tenantId;
        goto L14
    L5:
        if (((a4) org.koin.java.a.a(a4.class)).c(getDocViewModel().getOriginBearUrl().b) == false) goto L7;
        r6 = true;
        goto L15
    }
}
