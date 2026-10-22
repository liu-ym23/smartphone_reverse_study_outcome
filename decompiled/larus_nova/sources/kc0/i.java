package kc0;

import android.graphics.RectF;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public interface i {

    public static final class a {
        public static /* synthetic */ void a(p11.i r100, String r101) {
            r100.enableRenderFilter(r101, true, false);
        }
    }

    void clearStreamRegion();

    void enableRenderFilter(String r100, boolean r101, boolean r102);

    Map<String, String> getUidToStreamRegionKeyMap();

    void notifyStreamRegionUpdate();

    void registerRegionObserver(Observer<Map<String, pc0.c>> r100);

    void unRegisterRegionObserver(Observer<Map<String, pc0.c>> r100);

    boolean updateStreamRegion(String r100, RectF r101);
}
