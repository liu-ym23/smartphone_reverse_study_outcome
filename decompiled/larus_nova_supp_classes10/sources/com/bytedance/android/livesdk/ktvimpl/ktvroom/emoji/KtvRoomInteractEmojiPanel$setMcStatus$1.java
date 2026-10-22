package com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji;

import am2.x;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.ChatRoomPanelItemAdapter;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.nd;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/nd$b;", "it", "", "invoke", "(Lcom/bytedance/android/livesdk/message/model/nd$b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class KtvRoomInteractEmojiPanel$setMcStatus$1 extends Lambda implements Function1<nd.b, Unit> {
    final /* synthetic */ LinkApi.UpdateMcAction $action;
    final /* synthetic */ String $userId;
    final /* synthetic */ KtvRoomInteractEmojiPanel this$0;

    public KtvRoomInteractEmojiPanel$setMcStatus$1(KtvRoomInteractEmojiPanel r1, String r2, LinkApi.UpdateMcAction r3) {
        this.this$0 = r1;
        this.$userId = r2;
        this.$action = r3;
        super(1);
    }

    public final void invoke(nd.b r7) {
        Intrinsics.checkNotNullParameter(r7, "it");
        KtvRoomInteractEmojiPanel r0 = this.this$0;
        int r2 = KtvRoomInteractEmojiPanel.G;
        HashMap r8 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("live_type", "voice_live"), TuplesKt.to("anchor_id", ((InteractEmojiPanel) r0).i.getAnchorId()), TuplesKt.to("room_id", String.valueOf(((InteractEmojiPanel) this.this$0).i.getId())), TuplesKt.to("function_type", "ktv"), TuplesKt.to("to_user_id", this.$userId.toString())});
        if (this.$action != LinkApi.UpdateMcAction.SET_KTV_HOST) goto L5;
        ((InteractEmojiPanel) this.this$0).C.setMcStatus(1);
        f2.b(2131919293, 0);
        String r1 = "livesdk_audience_host_set_up";
    L6:
        j0.l().sendLog(r1, r8, new Object[]{IRoom.class, x.class});
        KtvRoomInteractEmojiPanel r9 = this.this$0;
        ChatRoomPanelItemAdapter r3 = ((InteractEmojiPanel) r9).p;
        if (r3 == null) goto L10;
        r3.y2(r9.S0());
        return;
    L10:
        return;
    L5:
        ((InteractEmojiPanel) this.this$0).C.setMcStatus(0);
        f2.b(2131919305, 0);
        r8.put("user_type", "anchor");
        r1 = "livesdk_audience_host_cancel";
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((nd.b) r1);
        return Unit.INSTANCE;
    }
}
