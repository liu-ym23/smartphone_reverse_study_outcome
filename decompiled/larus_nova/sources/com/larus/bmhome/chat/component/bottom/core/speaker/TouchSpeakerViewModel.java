package com.larus.bmhome.chat.component.bottom.core.speaker;

import com.larus.ui.arch.vm.ComponentViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\f¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/speaker/TouchSpeakerViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/TouchSpeakerState;", "<init>", "()V", "updateLongPressTimeout", "", "millis", "", "longPressTimeout", "updateSpeakerTouchEnable", "enable", "", "speakerTouchEnable", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TouchSpeakerViewModel extends ComponentViewModel<TouchSpeakerState> {
    public static /* synthetic */ TouchSpeakerState No(boolean r100, TouchSpeakerState r101) {
        return updateSpeakerTouchEnable$lambda$1(r100, r101);
    }

    public static /* synthetic */ TouchSpeakerState Oo(long r100, TouchSpeakerState r101) {
        return updateLongPressTimeout$lambda$0(r100, r101);
    }

    public final long longPressTimeout() {
        return getState().getLongPressTimeout();
    }

    public final boolean speakerTouchEnable() {
        return getState().getSpeakerTouchEnable();
    }

    public TouchSpeakerViewModel() {
    }

    public final void updateLongPressTimeout(final long r100) {
        setState(new o(r100));
    }

    public final void updateSpeakerTouchEnable(final boolean r100) {
        setState(new p(r100));
    }

    private static final TouchSpeakerState updateLongPressTimeout$lambda$0(long r100, TouchSpeakerState r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$setState");
        return TouchSpeakerState.copy$default(r101, false, r100, 1, null);
    }

    private static final TouchSpeakerState updateSpeakerTouchEnable$lambda$1(boolean r100, TouchSpeakerState r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$setState");
        return TouchSpeakerState.copy$default(r101, r100, 0, 2, null);
    }
}
