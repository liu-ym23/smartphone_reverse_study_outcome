package com.obric.assistant.interaction.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, d2 = {"Lcom/obric/assistant/interaction/api/IKeyguardState;", "", "isKeyguardLocked", "", "getKeyguardLockTime", "", "registerKeyguardLockStateChangedListener", "", "listener", "Lcom/obric/assistant/interaction/api/OnKeyguardLockStateChangedListener;", "unregisterKeyguardLockStateChangedListener", "isDeviceLocked", "isDeviceSecure", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKeyguardState {

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void registerKeyguardLockStateChangedListener(IKeyguardState r100, OnKeyguardLockStateChangedListener r101) {
            Intrinsics.checkNotNullParameter(r101, "listener");
        }

        public static void unregisterKeyguardLockStateChangedListener(IKeyguardState r100, OnKeyguardLockStateChangedListener r101) {
            Intrinsics.checkNotNullParameter(r101, "listener");
        }
    }

    long getKeyguardLockTime();

    boolean isDeviceLocked();

    boolean isDeviceSecure();

    boolean isKeyguardLocked();

    void registerKeyguardLockStateChangedListener(OnKeyguardLockStateChangedListener r100);

    void unregisterKeyguardLockStateChangedListener(OnKeyguardLockStateChangedListener r100);
}
