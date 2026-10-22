package fx2;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface f {
    View getHybridView();

    View getKitView();

    void release();

    void renderTemplate(String r100, Map<String, ? extends Object> r101);

    void sendEvent(String r100, Object r101);

    void updateGlobalProps(Map<String, ? extends Object> r100);
}
