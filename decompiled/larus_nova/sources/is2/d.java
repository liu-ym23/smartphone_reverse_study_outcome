package is2;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdk.room.data.EndReason;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public interface d extends IService {
    void addEndRoomInterceptorV2(c r100);

    void addLifecycleObserverV2(g r100);

    void addLifecycleObserverV2(g r100, int r101);

    void destroyV2();

    void endRoomV2(EndReason r100);

    void endRoomV2(EndReason r100, String r101, String r102);

    void endRoomV2(EndReason r100, boolean r101);

    void endRoomV2(ls2.e r100, String r101, String r102);

    void enterRoomV2();

    List<c> getEndRoomInterceptorsV2();

    boolean isBackendDataExpired(Long r100);

    void orientationChangeV2(int r100);

    void playerPreLoadV2();

    void preBackend();

    void preEnterRoom();

    void prePullStreamV2(String r100, boolean r101);

    void preRequestRoomEnterV2();

    void requestRoomPreload(boolean r100);

    Object roomPlayerContext();

    void startPullStreamV2(String r100, boolean r101);
}
