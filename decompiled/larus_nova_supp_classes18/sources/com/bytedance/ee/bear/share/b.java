package com.bytedance.ee.bear.share;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import com.bytedance.ee.bear.document.WebViewFragment;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b {
    void a(Context r1, String r2);

    mv4.e b();

    Flowable<String> c(String r1, String r2);

    MutableLiveData<Integer> d();

    DocBridgeWebViewV2 e(WebViewFragment r1);

    Flowable<IShareMeta> f(String r1, String r2, String r3);

    void g(WebViewFragment r1);

    void h(int r1);

    Flowable<IShareMeta> i(String r1, String r2, String r3, Integer r4, String r5);

    String j();
}
