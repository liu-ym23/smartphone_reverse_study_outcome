package pd;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public interface b {
    View getHybridView();

    void load(String r100, Map<String, ? extends Object> r101);

    void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101);

    <P, R> void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.g<P, R> r101);

    void release();

    <T> void sendJsEvent(String r100, T r101);

    void updateData(Map<String, ? extends Object> r100);

    void updateGlobalProps(Map<String, ? extends Object> r100);
}
