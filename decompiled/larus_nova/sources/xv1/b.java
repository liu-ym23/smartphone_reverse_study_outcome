package xv1;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.strategy.api.IStrategyService;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: classes8.dex */
public final class b {
    public static Map a() {
        LinkedHashMap r100 = new LinkedHashMap();
        IStrategyService r101 = (IStrategyService) k.f(IStrategyService.class);
        if (r101 == null) goto L11;
        LiveData r102 = IStrategyService.a.a(r101, "drawer_preview_autoplay", r100, true, 8);
        if (r102 == null) goto L12;
        Map r103 = (Map) r102.getValue();
        if (r103 != null) goto L10;
        return r100;
    L10:
        return r103;
    L12:
        return r100;
    L11:
        return r100;
    }

    static {
    }
}
