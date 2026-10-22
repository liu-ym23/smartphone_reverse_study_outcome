package ti;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public interface l {
    View b();

    View getHybridView();

    void loadUrl(String r100);

    void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101);

    <P, R> void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.g<P, R> r101);

    void release();

    void renderTemplate(String r100, Map<String, ? extends Object> r101);

    <T> void sendJsEvent(String r100, T r101);

    void updateBusinessGlobalProps(Map<String, ? extends Object> r100);

    void updateData(Map<String, ? extends Object> r100);

    void updateGlobalProps(Map<String, ? extends Object> r100);

    void updateScreenMetrics(int r100, int r101);
}
