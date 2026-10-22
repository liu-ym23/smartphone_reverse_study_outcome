package na;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.anniex.lite.container.AnnieXLiteContainer;
import com.bytedance.ies.bullet.core.kit.bridge.h;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public interface a {
    void a();

    void b(String r100, Map r101, m16.b r102, AnnieXLiteContainer.b r103);

    void c(Activity r100);

    boolean canGoBack();

    View d();

    void e(Activity r100);

    void enterBackground();

    void enterForeground();

    void goBack();

    void release();

    boolean reload();

    void sendEvent(h r100);

    void updateData(String r100);

    void updateData(Map<String, ? extends Object> r100);

    void updateGlobalProps(Map<String, ? extends Object> r100);
}
