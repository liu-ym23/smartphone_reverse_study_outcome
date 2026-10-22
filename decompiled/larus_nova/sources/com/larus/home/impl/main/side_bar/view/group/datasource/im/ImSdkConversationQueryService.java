package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniArchiveStatus;
import com.larus.im.internal.jni.bean.OmniConversationProjectStatus;
import com.larus.im.internal.jni.bean.OmniConversationSortType;
import com.larus.im.internal.jni.bean.OmniPinStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class ImSdkConversationQueryService implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImSdkConversationQueryService f345305a = null;

    static {
        f345305a = new ImSdkConversationQueryService();
    }

    public ImSdkConversationQueryService() {
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.im.m
    public final Object a(final Set<String> r100, Continuation<? super Map<String, Message>> r110) {
        if ((r110 instanceof ImSdkConversationQueryService$getBriefMessages$1) == false) goto L7;
        ImSdkConversationQueryService$getBriefMessages$1 r101 = (ImSdkConversationQueryService$getBriefMessages$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        ImSdkConversationQueryService$getBriefMessages$1 r103 = r101;
        Object r111 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L21:
        Map r112 = (Map) r111;
        if (r112 != null) goto L24;
        return null;
    L24:
        List r113 = CollectionsKt.filterNotNull(r112.values());
        ArrayList r106 = new ArrayList();
        Iterator r114 = r113.iterator();
    L26:
        if (r114.hasNext() == false) goto L43;
        Message r107 = (Message) r114.next();
        String r108 = r107.getConversationId();
        if (r108 != null) goto L30;
    L39:
        Pair r109 = null;
    L40:
        if (r109 == null) goto L26;
        r106.add(r109);
        goto L26
    L30:
        if (r108.length() <= 0) goto L32;
        boolean r115 = true;
    L33:
        if (r115 == true) goto L36;
        r108 = null;
    L36:
        if (r108 == null) goto L39;
        r109 = TuplesKt.to(r108, r107);
        goto L40
    L32:
        r115 = false;
        goto L33
    L43:
        return MapsKt.toMap(r106);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        if (r100.isEmpty() == true) goto L17;
        String r116 = "requested=" + r100.size();
        Function1 r117 = new f0(r100);
        r103.label = 1;
        r111 = p.a(2500, "query_brief", r116, r117, r103);
        if (r111 != r104) goto L21;
        return r104;
    L17:
        return MapsKt.emptyMap();
    L7:
        r101 = new ImSdkConversationQueryService$getBriefMessages$1(this, r110);
        goto L8
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.im.m
    public final Object b(final OmniPinStatus r210, final OmniConversationProjectStatus r211, final k0 r212, final OmniArchiveStatus r310, final long r311, final String r312, final int r313, final OmniConversationSortType r314, boolean r315, final boolean r316, final wc9.f r317, Continuation<? super l0> r318) {
        k0 r110 = r212;
        boolean r111 = r316;
        if ((r318 instanceof ImSdkConversationQueryService$getConversations$1) == false) goto L7;
        ImSdkConversationQueryService$getConversations$1 r100 = (ImSdkConversationQueryService$getConversations$1) r318;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ImSdkConversationQueryService$getConversations$1 r112 = r100;
        Object r102 = r112.result;
        Object r113 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r112.label;
        wc9.f r114 = null;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        boolean r104 = r112.Z$0;
        k0 r105 = (k0) r112.L$0;
        ResultKt.throwOnFailure(r102);
        r111 = r104;
        r110 = r105;
    L55:
        wc9.s r106 = (wc9.s) r102;
        if (r106 != null) goto L58;
        return null;
    L58:
        List<wc9.l> r107 = r106.f559261a;
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r107.iterator();
    L60:
        if (r109.hasNext() == false) goto L82;
        Object r115 = r109.next();
        wc9.l r116 = (wc9.l) r115;
        if (r111 == true) goto L79;
        if ((r110 instanceof k0.b) == false) goto L79;
        wc9.e r117 = r116.f559248a;
        if (r117 == null) goto L74;
        Integer r118 = r117.f559219v;
        if (r118 == null) goto L74;
        if (r118.intValue() != 1) goto L74;
        boolean r119 = true;
    L75:
        if (r119 == false) goto L79;
        boolean r120 = false;
    L80:
        if (r120 == false) goto L60;
        r108.add(r115);
    L74:
        r119 = false;
    L79:
        r120 = true;
        goto L80
    L82:
        ArrayList r121 = new ArrayList();
        Iterator r122 = r108.iterator();
    L84:
        if (r122.hasNext() == false) goto L88;
        wc9.e r123 = ((wc9.l) r122.next()).f559248a;
        if (r123 == null) goto L84;
        r121.add(r123);
        goto L84
    L88:
        ArrayList r124 = new ArrayList();
        Iterator r125 = r108.iterator();
    L90:
        if (r125.hasNext() == false) goto L114;
        wc9.l r126 = (wc9.l) r125.next();
        wc9.e r127 = r126.f559248a;
        if (r127 == null) goto L110;
        String r128 = r127.f559198a;
        if (r128 == null) goto L110;
        if (r128.length() <= 0) goto L98;
        boolean r129 = true;
    L99:
        if (r129 == true) goto L102;
        r128 = null;
    L102:
        if (r128 == null) goto L110;
        List<Message> r130 = r126.f559249b;
        if (r130 == null) goto L110;
        Message r131 = (Message) CollectionsKt.firstOrNull(r130);
        if (r131 == null) goto L110;
        Pair r132 = TuplesKt.to(r128, r131);
    L111:
        if (r132 == null) goto L90;
        r124.add(r132);
        goto L90
    L98:
        r129 = false;
    L110:
        r132 = null;
        goto L111
    L114:
        return new l0(r121, MapsKt.toMap(r124), r106.f559263c, null, 8);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r133 = r112.Z$0;
        ResultKt.throwOnFailure(r102);
        r111 = r133;
    L29:
        wc9.h r134 = (wc9.h) r102;
        if (r134 != null) goto L32;
        return null;
    L32:
        List<wc9.e> r135 = r134.f559233a;
        ArrayList r136 = new ArrayList();
        Iterator<T> r137 = r135.iterator();
    L34:
        if (r137.hasNext() == false) goto L47;
        Object r138 = r137.next();
        wc9.e r139 = (wc9.e) r138;
        if (r111 == true) goto L44;
        Integer r140 = r139.f559219v;
        if (r140 == null) goto L44;
        if (r140.intValue() != 1) goto L44;
        boolean r141 = false;
    L45:
        if (r141 == false) goto L34;
        r136.add(r138);
    L44:
        r141 = true;
        goto L45
    L47:
        Map r142 = null;
        boolean r143 = r134.f559234b;
        wc9.e r144 = (wc9.e) CollectionsKt.lastOrNull(r134.f559233a);
        if (r144 == null) goto L51;
        r114 = p.c(r144);
    L51:
        return new l0(r136, r142, r143, r114, 2);
    L16:
        ResultKt.throwOnFailure(r102);
        if (r315 == true) goto L19;
    L52:
        final long r145 = RangesKt.coerceIn(r313, 1, 100);
        Function1 r213 = new h0(r212, r210, r310, r311, r312, r314, r145, r211, r316);
        r112.L$0 = r110;
        r112.Z$0 = r111;
        r112.label = 2;
        r102 = p.a(KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL, "query_request", "pin=" + r210 + " project=" + r211 + " device=" + r110 + " archive=" + r310 + " limit=" + r313, r213, r112);
        if (r102 != r113) goto L55;
        return r113;
    L19:
        if (r210 != OmniPinStatus.PinStatus_PIN) goto L52;
        StringBuilder r146 = new StringBuilder("limit=");
        r146.append(r313);
        r146.append(" anchor=");
        if (r317 == null) goto L23;
        String r147 = r317.f559224a;
    L24:
        if (r147 != null) goto L26;
        r147 = "";
    L26:
        r146.append(r147);
        String r148 = r146.toString();
        Function1 r149 = new g0(r313, r317, r310);
        r112.Z$0 = r111;
        r112.label = 1;
        r102 = p.a(KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL, "query_pinned_request", r148, r149, r112);
        if (r102 != r113) goto L29;
        return r113;
    L23:
        r147 = null;
    L7:
        r100 = new ImSdkConversationQueryService$getConversations$1(this, r318);
        goto L8
    }
}
