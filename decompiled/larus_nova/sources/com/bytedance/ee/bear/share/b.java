package com.bytedance.ee.bear.share;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import com.bytedance.ee.bear.document.WebViewFragment;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: classes18.dex */
public interface b {
    void a(Context r100, String r101);

    mv4.e b();

    Flowable<String> c(String r100, String r101);

    MutableLiveData<Integer> d();

    DocBridgeWebViewV2 e(WebViewFragment r100);

    Flowable<IShareMeta> f(String r100, String r101, String r102);

    void g(WebViewFragment r100);

    void h(int r100);

    Flowable<IShareMeta> i(String r100, String r101, String r102, Integer r103, String r104);

    String j();
}
