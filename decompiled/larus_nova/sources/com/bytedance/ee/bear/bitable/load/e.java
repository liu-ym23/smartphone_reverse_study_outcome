package com.bytedance.ee.bear.bitable.load;

import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.b5;
import com.bytedance.ee.bear.document.s1;
import com.bytedance.ee.bear.document.u1;
import com.bytedance.ee.bear.domain.BearUrl;
import java.io.Serializable;

/* JADX INFO: loaded from: classes15.dex */
public interface e {
    void A(String r100, long r101);

    s1 b();

    void c(int r100, Throwable r101);

    <T extends zt4.a> void d(Class<T> r100, T r101);

    <T extends zt4.a> T e(Class<T> r100);

    com.bytedance.ee.bear.bitable.preload.util.b f();

    DocumentPluginHost getPluginHost();

    String getTraceId();

    void h(String r100, Serializable r101);

    DocBridgeWebViewV2 i();

    com.bytedance.ee.bear.document.b.a j();

    String l();

    BitableSceneType o();

    BitableLoadContext.b p();

    b5 q();

    u1 r();

    DocBridgeWebViewV2 s();

    void t(String r100, Boolean r101);

    BearUrl u();

    void v(String r100, long r101);

    void z();
}
