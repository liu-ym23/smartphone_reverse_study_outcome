package com.obric.assistant.activation.presentation.runtime.manager;

import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.contract.ObricListeningVisualMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class z {
    public static final ObricListeningViewState a(ObricListeningVisualMode r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        if (r100 != ObricListeningVisualMode.CLICK_TALK) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r100 == ObricListeningVisualMode.HIDDEN) goto L17;
        if (r102 == false) goto L15;
        if (r101 == false) goto L17;
    L15:
        return new ObricListeningViewState(r100, true, 0.0f);
    L17:
        return ObricListeningViewState.f385269d;
    L5:
        if (r100 == ObricListeningVisualMode.PRESS_TALK) goto L8;
        r102 = false;
        goto L10
    }
}
