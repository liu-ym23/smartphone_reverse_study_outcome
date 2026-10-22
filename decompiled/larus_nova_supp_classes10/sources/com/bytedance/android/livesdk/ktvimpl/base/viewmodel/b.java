package com.bytedance.android.livesdk.ktvimpl.base.viewmodel;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.base.sei.w;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.message.KtvStreamSingSyncData;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface b {
    void handleStateChange(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r1);

    void notifyClear(Function0<Unit> r1);

    void onMusicListChange(List<MusicPanel> r1);

    void onSeiResult(w r1);

    void playPreviewMv(KtvStreamSingSyncData r1);
}
