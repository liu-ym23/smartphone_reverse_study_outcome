package com.larus.im.internal.network.impl;

import com.larus.im.internal.network.NetworkCommonAbility;
import com.larus.im.internal.protocol.bean.BatchGetConversationInfoDownlinkBody;
import com.larus.im.internal.protocol.bean.BatchGetConversationInfoUplinkBody;
import com.larus.im.internal.protocol.bean.BatchGetConversationParticipantsDownlinkBody;
import com.larus.im.internal.protocol.bean.BatchGetConversationParticipantsUplinkBody;
import com.larus.im.internal.protocol.bean.ConsistencyUplinkBody;
import com.larus.im.internal.protocol.bean.DeleteUserConversationUplinkBody;
import com.larus.im.internal.protocol.bean.GetConversationInfoDownlinkBody;
import com.larus.im.internal.protocol.bean.GetConversationInfoUplinkBody;
import com.larus.im.internal.protocol.bean.GetConversationParticipantDownlinkBody;
import com.larus.im.internal.protocol.bean.GetConversationParticipantUplinkBody;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes30.dex */
public final class ConversationNetworkImpl implements com.larus.im.internal.network.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConversationNetworkImpl f349198b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f349199c = null;

    public ConversationNetworkImpl() {
    }

    static {
        f349198b = new ConversationNetworkImpl();
        f349199c = new LinkedHashSet();
    }

    public final Object b(final BatchGetConversationParticipantsUplinkBody r100, Continuation<? super com.larus.im.internal.network.e<BatchGetConversationParticipantsDownlinkBody>> r101) {
        if ((r101 instanceof ConversationNetworkImpl$batchGetParticipants$1) == false) goto L7;
        ConversationNetworkImpl$batchGetParticipants$1 r102 = (ConversationNetworkImpl$batchGetParticipants$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return com.larus.im.internal.network.stragery.f.b((com.larus.im.internal.network.e) r104, new c());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        NetworkCommonAbility r107 = NetworkCommonAbility.f349012a;
        Function1 r108 = new b(r100);
        r102.label = 1;
        r104 = NetworkCommonAbility.b(null, r108, r102);
        if (r104 != r105) goto L18;
        return r105;
    L7:
        r102 = new ConversationNetworkImpl$batchGetParticipants$1(this, r101);
        goto L8
    }

    public final Object c(final DeleteUserConversationUplinkBody r100, Continuation<? super com.larus.im.internal.network.e<Boolean>> r101) {
        if ((r101 instanceof ConversationNetworkImpl$deleteConversation$1) == false) goto L7;
        ConversationNetworkImpl$deleteConversation$1 r102 = (ConversationNetworkImpl$deleteConversation$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return com.larus.im.internal.network.stragery.f.b((com.larus.im.internal.network.e) r104, new d());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        NetworkCommonAbility r107 = NetworkCommonAbility.f349012a;
        Function1 r108 = new a(r100);
        r102.label = 1;
        r104 = NetworkCommonAbility.b(null, r108, r102);
        if (r104 != r105) goto L18;
        return r105;
    L7:
        r102 = new ConversationNetworkImpl$deleteConversation$1(this, r101);
        goto L8
    }

    public final Object e(final GetConversationParticipantUplinkBody r100, Continuation<? super com.larus.im.internal.network.e<GetConversationParticipantDownlinkBody>> r101) {
        if ((r101 instanceof ConversationNetworkImpl$getConversationParticipant$1) == false) goto L7;
        ConversationNetworkImpl$getConversationParticipant$1 r102 = (ConversationNetworkImpl$getConversationParticipant$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return com.larus.im.internal.network.stragery.f.b((com.larus.im.internal.network.e) r104, new h());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        NetworkCommonAbility r107 = NetworkCommonAbility.f349012a;
        Function1 r108 = new g(r100);
        r102.label = 1;
        r104 = NetworkCommonAbility.b(null, r108, r102);
        if (r104 != r105) goto L18;
        return r105;
    L7:
        r102 = new ConversationNetworkImpl$getConversationParticipant$1(this, r101);
        goto L8
    }

    public final Object f(final ConsistencyUplinkBody r100, Continuation<? super com.larus.im.internal.network.e<Boolean>> r101) {
        if ((r101 instanceof ConversationNetworkImpl$reportConsistencyData$1) == false) goto L7;
        ConversationNetworkImpl$reportConsistencyData$1 r102 = (ConversationNetworkImpl$reportConsistencyData$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return com.larus.im.internal.network.stragery.f.b((com.larus.im.internal.network.e) r104, new j());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        NetworkCommonAbility r107 = NetworkCommonAbility.f349012a;
        Function1 r108 = new i(r100);
        r102.label = 1;
        r104 = NetworkCommonAbility.b(null, r108, r102);
        if (r104 != r105) goto L18;
        return r105;
    L7:
        r102 = new ConversationNetworkImpl$reportConsistencyData$1(this, r101);
        goto L8
    }

    public final Object a(final BatchGetConversationInfoUplinkBody r100, final boolean r101, Continuation<? super com.larus.im.internal.network.e<BatchGetConversationInfoDownlinkBody>> r102) {
        if ((r102 instanceof ConversationNetworkImpl$batchGetConversationInfo$1) == false) goto L7;
        ConversationNetworkImpl$batchGetConversationInfo$1 r103 = (ConversationNetworkImpl$batchGetConversationInfo$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L18:
        return com.larus.im.internal.network.stragery.f.b((com.larus.im.internal.network.e) r105, new l());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        NetworkCommonAbility r108 = NetworkCommonAbility.f349012a;
        Function1 r109 = new k(r100, r101);
        r103.label = 1;
        r105 = NetworkCommonAbility.b(null, r109, r103);
        if (r105 != r106) goto L18;
        return r106;
    L7:
        r103 = new ConversationNetworkImpl$batchGetConversationInfo$1(this, r102);
        goto L8
    }

    public final Object d(final GetConversationInfoUplinkBody r100, String r110, boolean r111, Continuation<? super com.larus.im.internal.network.e<GetConversationInfoDownlinkBody>> r112) {
        if ((r112 instanceof ConversationNetworkImpl$getConversationInfo$1) == false) goto L7;
        ConversationNetworkImpl$getConversationInfo$1 r101 = (ConversationNetworkImpl$getConversationInfo$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r113 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L24:
        return com.larus.im.internal.network.stragery.f.b((com.larus.im.internal.network.e) r113, new f());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        final Ref.BooleanRef r114 = new Ref.BooleanRef();
        r114.element = r111;
        String r115 = r100.conversationId;
        com.larus.im.internal.delegate.b r105 = com.larus.im.internal.delegate.b.f348193b;
        boolean r106 = r105.isLogin();
        boolean r107 = r105.e();
        if (com.larus.im.j.f(r115) == false) goto L17;
        r114.element = true;
    L17:
        com.larus.im.internal.delegate.a.f348188b.i("ConversationNetworkImpl", "getConversationInfoRequest, conversationId:" + r115 + ",from:" + r110 + ",finalIsAuto:" + r114.element + ",isLogin:" + r106 + ",isTouristMode:" + r107);
        Map<String, String> r116 = r100.ext;
        if (r116 != null) goto L20;
        r116 = MapsKt.emptyMap();
    L20:
        Map<String, String> r117 = MapsKt.toMutableMap(r116);
        Set<String> r108 = f349199c;
        r117.put("cold_start", String.valueOf(!r108.contains(r115)));
        r100.ext = r117;
        r108.add(r115);
        NetworkCommonAbility r118 = NetworkCommonAbility.f349012a;
        Function1 r119 = new e(r100, r114);
        r101.label = 1;
        r113 = NetworkCommonAbility.b(null, r119, r101);
        if (r113 != r103) goto L24;
        return r103;
    L7:
        r101 = new ConversationNetworkImpl$getConversationInfo$1(this, r112);
        goto L8
    }
}
