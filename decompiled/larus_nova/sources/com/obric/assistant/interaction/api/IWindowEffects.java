package com.obric.assistant.interaction.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, d2 = {"Lcom/obric/assistant/interaction/api/IWindowEffects;", "", "setWakeupState", "", "weakUpState", "Lcom/obric/assistant/interaction/api/WeakUpState;", "getValidWakeUpState", "startActivateEffect", "withRipple", "", "playRippleEffect", "stopActivateEffect", "showScreenShotEffect", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IWindowEffects {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void setWakeupState$default(IWindowEffects r100, WeakUpState r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = new WeakUpState(false, false, 3, null);
        L6:
            r100.setWakeupState(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setWakeupState");
        }

        public static /* synthetic */ void startActivateEffect$default(IWindowEffects r100, boolean r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = false;
        L6:
            r100.startActivateEffect(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startActivateEffect");
        }
    }

    WeakUpState getValidWakeUpState();

    void playRippleEffect();

    void setWakeupState(WeakUpState r100);

    void showScreenShotEffect();

    void startActivateEffect(boolean r100);

    void stopActivateEffect();
}
