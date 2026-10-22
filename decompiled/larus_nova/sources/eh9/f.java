package eh9;

import com.larus.kmp.voice_setting.voice.list.managed.ManagedVoiceListFooterState;
import com.larus.kmp.voice_setting.voice.list.managed.ManagedVoiceListOverlayState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f {
    public static final boolean a(ManagedVoiceListFooterState r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100 != ManagedVoiceListFooterState.READY) goto L5;
    L8:
        return true;
    L5:
        if (r100 == ManagedVoiceListFooterState.ERROR) goto L8;
        return false;
    }

    public static ManagedVoiceListFooterState c(Integer r100) {
        ManagedVoiceListFooterState r101 = ManagedVoiceListFooterState.HIDDEN;
        Intrinsics.checkNotNullParameter(r101, "successFallback");
        if (r100 != null) goto L6;
    L8:
        if (r100 != null) goto L11;
    L13:
        if (r100 != null) goto L16;
    L18:
        if (r100 == null) goto L25;
        r100.intValue();
        return r101;
    L25:
        return r101;
    L16:
        if (r100.intValue() != 2) goto L18;
        return ManagedVoiceListFooterState.END;
    L11:
        if (r100.intValue() != 1) goto L13;
        return ManagedVoiceListFooterState.ERROR;
    L6:
        if (r100.intValue() != 0) goto L8;
        return ManagedVoiceListFooterState.READY;
    }

    public static final ManagedVoiceListFooterState b(ManagedVoiceListOverlayState r100, boolean r101, ManagedVoiceListFooterState r102) {
        Intrinsics.checkNotNullParameter(r100, "overlayState");
        Intrinsics.checkNotNullParameter(r102, "footerState");
        if (r100 != ManagedVoiceListOverlayState.NONE) goto L7;
        if (r101 == false) goto L7;
        return r102;
    L7:
        return ManagedVoiceListFooterState.HIDDEN;
    }
}
