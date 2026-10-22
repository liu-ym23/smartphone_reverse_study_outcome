package pd;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public interface j {
    void a();

    View b();

    void c(LifecycleOwner r100);

    View getHybridView();

    void loadUrl(String r100);

    void registerCrashMonitor();

    void registerStatefulMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101);

    <P, R> void registerStatelessMethod(String r100, com.bytedance.ies.web.jsbridge2.g<P, R> r101);

    void release();

    void renderTemplate(String r100, Map<String, ? extends Object> r101);

    <T> void sendJsEvent(String r100, T r101);

    void updateBusinessGlobalProps(Map<String, ? extends Object> r100);

    void updateData(Map<String, ? extends Object> r100);

    void updateGlobalProps(Map<String, ? extends Object> r100);
}
