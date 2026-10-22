package com.larus.voicecall.impl.util;

import android.os.Bundle;
import com.baidu.platform.comapi.map.MapController;
import com.larus.audio.realtimecall.IRealtimeCallStrategy;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¨\u0006\u0012"}, d2 = {"Lcom/larus/voicecall/impl/util/RealtimeCallStrategy;", "Lcom/larus/audio/realtimecall/IRealtimeCallStrategy;", "<init>", "()V", "realtimeCallAutoHelloParam", "Landroid/os/Bundle;", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "lastMsg", "Lcom/larus/im/bean/message/Message;", "realtimeCallAutoHelloParamByCvsId", "cvsId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUnreadCount", "", MapController.ITEM_LAYER_TAG, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallStrategy implements IRealtimeCallStrategy {

    public static final class a {
    }

    static {
    }

    public RealtimeCallStrategy() {
    }

    @Override // com.larus.audio.realtimecall.IRealtimeCallStrategy
    public final Bundle a(wc9.e r100, Message r101) {
        if (z2.f365865a.isAutoSayHelloInCallBot() == false) goto L22;
        if (r100 == null) goto L22;
        if (r101 == null) goto L22;
        Integer r102 = r100.f559209l;
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
    L10:
        Integer r104 = r100.f559210m;
        if (r104 == null) goto L13;
        int r105 = r104.intValue();
    L15:
        if ((r103 - r105) <= 0) goto L22;
        Regex r106 = com.larus.bmhome.chat.bean.d.f297444a;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (com.larus.bmhome.chat.bean.d.x(r101).getProactiveBotMessage() == true) goto L23;
        if (com.larus.bmhome.chat.bean.d.z0(r101) == false) goto L22;
    L23:
        return com.larus.utils.f.c(new Pair[]{TuplesKt.to("enter_method", "read_latest_message"), TuplesKt.to("trigger_hello", "true")});
    L13:
        r105 = 0;
        goto L15
    L9:
        r103 = 0;
    L22:
        return com.larus.utils.f.c(new Pair[0]);
    }

    @Override // com.larus.audio.realtimecall.IRealtimeCallStrategy
    public final Object b(String r110, Continuation<? super Bundle> r111) {
        if ((r111 instanceof RealtimeCallStrategy$realtimeCallAutoHelloParamByCvsId$1) == false) goto L7;
        RealtimeCallStrategy$realtimeCallAutoHelloParamByCvsId$1 r100 = (RealtimeCallStrategy$realtimeCallAutoHelloParamByCvsId$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        wc9.e r113 = (wc9.e) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L35:
        return a(r113, (Message) r112);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L30:
        wc9.e r114 = (wc9.e) r112;
        IChatRepoService r104 = RepoDispatcherDelegate.f307737b.e();
        r100.L$0 = r114;
        r100.label = 2;
        Object r115 = r104.D1(r110, r100);
        if (r115 != r102) goto L33;
        return r102;
    L33:
        r112 = r115;
        r113 = r114;
        goto L35
    L16:
        ResultKt.throwOnFailure(r112);
        if (r110 != null) goto L19;
    L22:
        boolean r105 = true;
    L23:
        if (r105 == true) goto L37;
        if (StringsKt.contains$default(r110, "local", false, 2, null) == true) goto L37;
        IConversationRepoService r106 = RepoDispatcherDelegate.f307737b.f();
        r100.L$0 = r110;
        r100.label = 1;
        r112 = IConversationRepoService.a.c(r106, r110, true, null, r100, 4);
        if (r112 != r102) goto L30;
        return r102;
    L37:
        return com.larus.utils.f.c(new Pair[0]);
    L19:
        if (r110.length() == 0) goto L22;
        r105 = false;
    L7:
        r100 = new RealtimeCallStrategy$realtimeCallAutoHelloParamByCvsId$1(this, r111);
        goto L8
    }
}
