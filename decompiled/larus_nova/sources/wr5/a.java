package wr5;

import android.webkit.JavascriptInterface;
import com.ss.android.lark.log.Log;
import tr5.b;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public a() {
    }

    @JavascriptInterface
    public boolean supportNativeComponent() {
        b r100 = b.a.f547309a;
        r100.getClass();
        Log.i("NativeRenderManager", "getOpenMixRender = " + r100.f547308b);
        return r100.f547308b;
    }
}
