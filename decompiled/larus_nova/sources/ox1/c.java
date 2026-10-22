package ox1;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final InnerContextEntity.FloatWindowDataSource a(InnerContextEntity.InnerFloatExtra r100) {
        if (r100 == null) goto L7;
        Long r101 = r100.getEnterRoomId();
        if (r101 == null) goto L7;
        long r102 = r101.longValue();
    L8:
        if (r100 == null) goto L10;
        Room r103 = r100.getOuterRoom();
    L11:
        if (r103 == null) goto L14;
        return new e(r100.getOuterRoom());
    L14:
        if (r102 <= 0) goto L17;
        return new b(r102);
    L17:
        return new a();
    L10:
        r103 = null;
    L7:
        r102 = 0;
        goto L8
    }
}
