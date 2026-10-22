package com.ss.android.lark.message.vote.message;

import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.PutActionRequest;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.statistics.Statistics;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final /* synthetic */ class a implements trb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoteMessageCell f432301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v5b.c f432302b;

    public /* synthetic */ a(VoteMessageCell r100, v5b.c r101) {
        this.f432301a = r100;
        this.f432302b = r101;
    }

    public final void a(String r100, Map r101) {
        final VoteMessageCell r102 = this.f432301a;
        v5b.c r103 = this.f432302b;
        r102.getClass();
        String r104 = r103.getId();
        UIGetDataCallback<rrb.a> r105 = new VoteMessageCell.AnonymousClass1(r102);
        PutActionRequest.Builder r106 = new PutActionRequest.Builder().action_id(r100).message_id(r104).is_ephemeral(Boolean.FALSE);
        if (((HashMap) r101).size() <= 0) goto L5;
        r106.params(r101);
    L5:
        SdkSender.asynSendRequestNonWrap(Command.PUT_ACTION, r106, r105, new srb.b());
        int r107 = hva.a.f487359a;
        HashMap r108 = (HashMap) r101;
        String r109 = String.valueOf(r108.size());
        boolean r110 = true;
        if (r108.size() <= 1) goto L8;
        r110 = false;
    L8:
        Intrinsics.checkNotNullParameter(r109, "itemCount");
        Intrinsics.checkNotNullParameter(r100, "voteId");
        JSONObject r111 = new JSONObject().put("item_count", r109);
        if (r110 == false) goto L11;
        String r112 = "single";
    L12:
        Statistics.sendEvent("ex_platform_click_vote_submit", r111.put("vote_type", r112).put("vote_id", r100));
        int r113 = urb.b.f551390a;
        urb.b.a.a(r103.getChatId(), r103.getId(), r103.getcId(), Message.Type.CARD);
        return;
    L11:
        r112 = PriorityModule.SCENE_MULTI;
        goto L12
    }
}
