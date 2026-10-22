package com.bytedance.android.livesdk.ktvimpl.base.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface c {
    void clearData();

    KtvRoomLyricsStateMachineConfig.d getCurState();

    KtvRoomLyricsStateMachineConfig.d getState();

    boolean inOnSing();

    boolean isPaused();

    void observeState(LifecycleOwner r1, Observer<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r2, boolean r3);

    void observerOnLyricsChange(LifecycleOwner r1, Function1<? super ub0.a, Unit> r2);

    void observerOnProgress(LifecycleOwner r1, Function1<? super Long, Unit> r2);

    long obtainCurMusicProgress();

    void registerKtvCoreListener(ArrayList<String> r1, e r2, boolean r3);

    void sendEvent(KtvRoomLyricsStateMachineConfig.a r1, String r2);

    void unregisterKtvCoreListener(e r1);
}
