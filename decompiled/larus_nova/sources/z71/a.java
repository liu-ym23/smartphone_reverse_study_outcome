package z71;

import com.bytedance.android.live.room.api.screenrotation.rotate.c;
import com.bytedance.android.live.room.api.screenrotation.rotate.d;
import com.bytedance.android.livesdkapi.util.IScreenRotateMonitor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public interface a {
    Map<a81.b, Disposable> getConfigChangeListeners();

    DataCenter getDataCenter();

    c getHandleRegistry();

    IScreenRotateMonitor getMonitor();

    d getRotateSession();
}
