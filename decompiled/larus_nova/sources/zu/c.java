package zu;

import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import com.bytedance.android.gamecp.common.track.model.GPTrackDataType;
import com.bytedance.android.gamecp.common.track.model.GPViewTrackData;
import com.bytedance.android.gamecp.common.track.model.GPViewTrackType;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {
    public static final GPViewTrackData a(String r110, Map<String, ? extends Object> r111, boolean r112, TrackRegisterStrategy r113) {
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r111, "attrs");
        return new GPViewTrackData(r110, r111, null, null, null, null, r112, new WeakReference(r113), 60, null);
    }

    public static final GPViewTrackData b(String r110, Map<String, ? extends Object> r111, Map<String, ? extends Object> r112, boolean r113, TrackRegisterStrategy r114) {
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r111, "attrs");
        Intrinsics.checkNotNullParameter(r112, "routerData");
        return new GPViewTrackData(r110, r111, GPViewTrackType.ROOT_VIEW, GPTrackDataType.PAGE, r112, null, r113, new WeakReference(r114), 32, null);
    }
}
