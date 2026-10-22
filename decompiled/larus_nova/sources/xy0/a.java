package xy0;

import android.view.View;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import wy0.e;

/* JADX INFO: loaded from: classes47.dex */
public interface a<VIEW extends View> extends e, Disposable {
    void dispose();

    VIEW getHybridView();

    boolean isDisposed();

    void load();

    void load(String r100);

    void load(String r100, Map<String, ? extends Object> r101);

    HybridType o();

    @Override // wy0.e
    void registerMethod(String r100, f.b r101);

    @Override // wy0.e
    void registerMethod(String r100, g<?, ?> r101);

    @Override // wy0.e
    void sendJsEvent(String r100, Object r101);

    void updateData(Map<String, ? extends Object> r100);

    void updateGlobalProps(Map<String, ? extends Object> r100);

    void updateScreenMetrics(int r100, int r101);
}
