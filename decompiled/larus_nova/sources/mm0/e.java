package mm0;

import com.bytedance.android.live.room.api.messagewindow.trigger.TriggerId;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.JvmStatic;
import lm0.g;

/* JADX INFO: loaded from: classes46.dex */
public final class e {
    static {
    }

    @JvmStatic
    public static final lm0.a a(DataCenter r100, int r101, Long r102, int r103) {
        if (r101 != TriggerId.ENTER_ROOM_TIME_LIMIT.getValue()) goto L6;
        return new lm0.c(r100, r102, r103);
    L6:
        if (r101 != TriggerId.EXIT_MIC_TIME_LIMIT.getValue()) goto L9;
        return new lm0.e(r100, r102, r103);
    L9:
        if (r101 != TriggerId.NO_LIMIT_TRIGGER.getValue()) goto L12;
        return new g(r100, r102, r103);
    L12:
        if (r101 == TriggerId.CYCLE_DISPLAY_WITH_LIMITED_TIMES_TRIGGER.getValue()) goto L19;
        return null;
    L19:
        return new lm0.b(r100, r102, r103);
    }
}
