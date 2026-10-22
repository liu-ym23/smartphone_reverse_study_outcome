package i88;

import com.larus.av_call.util.ScreenWidthType;
import com.larus.utils.logger.FLogger;
import v19.c7;

/* JADX INFO: loaded from: classes24.dex */
public final class f {
    public static final ScreenWidthType a(int r100) {
        FLogger.f375446a.d("VoiceCallBottomLayout", "windowWidth: " + r100);
        float r101 = c7.d(Integer.valueOf(r100));
        if (r101 > 411.0f) goto L6;
        return ScreenWidthType.Small;
    L6:
        if (r101 > 600.0f) goto L9;
        return ScreenWidthType.Medium;
    L9:
        return ScreenWidthType.Large;
    }
}
