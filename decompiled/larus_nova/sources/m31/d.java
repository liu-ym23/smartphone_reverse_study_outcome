package m31;

import com.bytedance.android.live.revlink.impl.multianchor.player.utils.LiveType;
import com.bytedance.android.livesdk.revenue.room.RevLiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {
    public static final LiveType a(ILiveMode r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toLiveType");
        if (r100 == LiveMode.THIRD_PARTY) goto L35;
        if (r100 == RevLiveMode.THIRD_PARTY) goto L35;
        if (r100 == LiveMode.VIDEO) goto L33;
        if (r100 == RevLiveMode.VIDEO) goto L33;
        if (r100 == LiveMode.MEDIA) goto L31;
        if (r100 == RevLiveMode.MEDIA) goto L31;
        if (r100 == LiveMode.AUDIO) goto L29;
        if (r100 == RevLiveMode.AUDIO) goto L29;
        if (r100 != LiveMode.SCREEN_RECORD) goto L27;
        return LiveType.SCREEN_RECORD;
    L27:
        return LiveType.OTHERS;
    L29:
        return LiveType.AUDIO;
    L31:
        return LiveType.VIDEO;
    L33:
        return LiveType.VIDEO;
    L35:
        return LiveType.PC_LIVE;
    }
}
