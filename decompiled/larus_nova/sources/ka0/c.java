package ka0;

import com.bytedance.android.live.browser.jsbridge.f;
import com.bytedance.ies.web.jsbridge2.g;

/* JADX INFO: loaded from: classes45.dex */
public interface c extends f {
    void loadUrl(String r100);

    void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101);

    <P, R> void registerMethod(String r100, g<P, R> r101);

    void release();

    void reload();
}
