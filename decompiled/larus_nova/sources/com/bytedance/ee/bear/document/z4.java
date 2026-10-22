package com.bytedance.ee.bear.document;

import android.content.Context;
import android.webkit.WebViewClient;
import com.bytedance.ee.bear.document.statistics.SendEventData;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.jsbridge.Message;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes16.dex */
public interface z4 extends vv4.k {

    public interface a {
    }

    void C(v2 r100);

    void D(com.bytedance.ee.bear.document.ssrrender.a.b r100);

    boolean E(Message r100, tb5.m r101);

    void F(zv4.f r100);

    boolean G();

    void b(String r100, Serializable r101);

    int computeVerticalScrollRange();

    void d(zv4.f r100);

    ConcurrentHashMap<String, String> e();

    boolean f();

    /* synthetic */ Context getContext();

    WebViewClient getWebViewClient();

    void m(com.bytedance.ee.bear.contract.m0 r100);

    void onDestroy();

    void q(com.bytedance.ee.bear.document.ssrrender.a.b r100);

    int r();

    void s(boolean r100, Integer r101);

    void t(BearUrl r100, String r101);

    void v();

    void x(com.bytedance.ee.bear.contract.m0 r100);

    void y(SendEventData r100);

    void z(boolean r100);
}
