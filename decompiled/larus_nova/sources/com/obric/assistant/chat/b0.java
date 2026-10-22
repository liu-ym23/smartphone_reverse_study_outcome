package com.obric.assistant.chat;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.tts.TtsSwitchMode;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueDeviceSwitchState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b0 implements Function1 {
    public /* synthetic */ b0() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        BlueDeviceSwitchState r101 = (BlueDeviceSwitchState) r100;
        Intrinsics.checkNotNullParameter(r101, "state");
        FLogger.f375446a.i("ObricChatTtsIconManager", "registerBluetoothSwitchStateChanged callback with " + r101 + "...");
        if (ObricChatTtsIconManager.a.f386598c[r101.ordinal()] != 1) goto L8;
        if (ObricChatTtsIconManager.f386581a != TtsSwitchMode.BluetoothMicMode) goto L8;
        ObricChatTtsIconManager.c(TtsSwitchMode.BuildInMicMode);
    L8:
        return Unit.INSTANCE;
    }
}
