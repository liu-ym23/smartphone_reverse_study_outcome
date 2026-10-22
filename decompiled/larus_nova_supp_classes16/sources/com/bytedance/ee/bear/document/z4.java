package com.bytedance.ee.bear.document;

import android.content.Context;
import android.webkit.WebViewClient;
import com.bytedance.ee.bear.document.statistics.SendEventData;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.jsbridge.Message;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface z4 extends vv4.k {

    public interface a {
    }

    void C(v2 r1);

    void D(com.bytedance.ee.bear.document.ssrrender.a.b r1);

    boolean E(Message r1, tb5.m r2);

    void F(zv4.f r1);

    boolean G();

    void b(String r1, Serializable r2);

    int computeVerticalScrollRange();

    void d(zv4.f r1);

    ConcurrentHashMap<String, String> e();

    boolean f();

    /* synthetic */ Context getContext();

    WebViewClient getWebViewClient();

    void m(com.bytedance.ee.bear.contract.m0 r1);

    void onDestroy();

    void q(com.bytedance.ee.bear.document.ssrrender.a.b r1);

    int r();

    void s(boolean r1, Integer r2);

    void t(BearUrl r1, String r2);

    void v();

    void x(com.bytedance.ee.bear.contract.m0 r1);

    void y(SendEventData r1);

    void z(boolean r1);
}
