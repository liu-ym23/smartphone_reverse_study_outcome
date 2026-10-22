package rc0;

import com.bytedance.android.live.link.player.DeviceType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class n {
    public static final boolean a(DeviceType r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isPad");
        if (r100 != DeviceType.PAD_V) goto L5;
    L8:
        return true;
    L5:
        if (r100 == DeviceType.PAD_H) goto L8;
        return false;
    }
}
