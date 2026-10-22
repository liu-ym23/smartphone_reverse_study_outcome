package com.larus.im.internal.core.message;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.IMCoreMechanismKt;
import com.larus.im.internal.TokenHolder;
import com.larus.im.internal.core.message.converter.MessageEntityConverterKt;
import com.larus.im.internal.core.message.regen.RegenHelper;
import com.larus.im.internal.core.message.utils.MessageIndexStrategy;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.database.utils.OmniDatabaseExtKt;
import com.larus.im.internal.protocol.bean.MessageBody;
import com.larus.im.internal.protocol.bean.RegenMsgGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.TimeSource;

/* JADX INFO: loaded from: classes4.dex */
public final class RemoteMessageListHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RemoteMessageListHandler f347763a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static com.larus.im.internal.h f347764b;

    public RemoteMessageListHandler() {
    }

    static {
        f347763a = new RemoteMessageListHandler();
        int r100 = com.larus.im.internal.h.f348640d;
        f347764b = IMCoreMechanismKt.f347157a;
    }

    public static void a(String r100) {
        com.larus.im.internal.delegate.a.f348188b.i("RemoteMessageListHandler", r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.util.Map] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:158:0x03f9 -> B:159:0x03fa). Please report as a decompilation issue!!! */
    public final Object b(String r310, List<MessageBody> r311, Map<String, MessageBody> r312, Function2<? super List<MessageEntity>, ? super Continuation<? super Unit>, ? extends Object> r313, Continuation<? super List<Message>> r410) {
        if ((r410 instanceof RemoteMessageListHandler$onHandle$1) == false) goto L7;
        RemoteMessageListHandler$onHandle$1 r100 = (RemoteMessageListHandler$onHandle$1) r410;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        Collection r105 = (Collection) r100.L$2;
        Iterator r106 = (Iterator) r100.L$1;
        Collection r107 = (Collection) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L159:
        r105.add((Message) r102);
        r105 = r107;
    L154:
        if (r106.hasNext() == false) goto L161;
        MessageEntity r108 = (MessageEntity) r106.next();
        r100.L$0 = r105;
        r100.L$1 = r106;
        r100.L$2 = r105;
        r100.label = 2;
        r102 = MessageEntityConverterKt.a(r108, r100);
        if (r102 != r103) goto L158;
        return r103;
    L158:
        r107 = r105;
        goto L159
    L161:
        return (List) r105;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r102);
        Object r109 = r103;
    L146:
        ArrayList r110 = new ArrayList();
        Iterator r111 = ((List) r102).iterator();
    L148:
        if (r111.hasNext() == false) goto L152;
        Object r112 = r111.next();
        if (com.larus.im.internal.database.utils.k.n((MessageEntity) r112) == false) goto L148;
        r110.add(r112);
        goto L148
    L152:
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        r106 = r110.iterator();
        r103 = r109;
        r105 = r113;
        goto L154
    L16:
        ResultKt.throwOnFailure(r102);
        StringBuilder r114 = new StringBuilder("onHandle, from:");
        r114.append(r310);
        r114.append(", messages size:");
        if (r311 == null) goto L19;
        Integer r115 = Boxing.boxInt(r311.size());
    L20:
        r114.append(r115);
        r114.append(",regenMessages size:");
        if (r312 == null) goto L23;
        Integer r116 = Boxing.boxInt(r312.size());
    L24:
        r114.append(r116);
        a(r114.toString());
        if (r311 != null) goto L27;
    L30:
        boolean r117 = true;
    L31:
        if (r117 == true) goto L33;
        HashMap r118 = new HashMap();
        Iterator<MessageBody> r119 = r311.iterator();
    L35:
        String r120 = "";
        if (r119.hasNext() == false) goto L114;
        MessageBody r121 = r119.next();
        RegenHelper r122 = RegenHelper.f347820a;
        Intrinsics.checkNotNullParameter(r121, RootDescription.ROOT_ELEMENT);
        TimeSource.Monotonic r123 = TimeSource.Monotonic.INSTANCE;
        RemoteMessageListHandler$onHandle$1 r411 = r100;
        long r124 = r123.m10932markNowz9LOYto();
        List<RegenMsgGroup> r125 = r121.regenMsgList;
        MessageIndexStrategy r126 = MessageIndexStrategy.f347844a;
        long r127 = r121.indexInConv;
        if (com.larus.im.internal.database.utils.j.d(r121) != 1001) goto L40;
        boolean r128 = true;
    L41:
        long r129 = MessageIndexStrategy.a(r127, r128);
        if (com.larus.im.internal.database.utils.j.g(r121) == false) goto L112;
        List<RegenMsgGroup> r130 = r125;
        if (r130 != null) goto L46;
    L49:
        boolean r131 = true;
    L50:
        if (r131 == true) goto L112;
        if (r129 < 0) goto L112;
        ?? r132 = new HashMap();
        ListIterator<RegenMsgGroup> r133 = r125.listIterator(r125.size());
    L56:
        if (r133.hasPrevious() == false) goto L61;
        if (r133.previous().isVisible == false) goto L56;
        int r134 = r133.nextIndex();
    L62:
        Integer r135 = Integer.valueOf(r134);
        if (r135.intValue() < 0) goto L65;
        boolean r136 = true;
    L66:
        if (r136 == true) goto L69;
        r135 = null;
    L69:
        if (r135 == null) goto L71;
        int r137 = r135.intValue();
    L72:
        RegenHelper.c(JSEventListener.ACTION_RESOLVE, "start resolve message(" + r121.messageId + "), is_regen_root(" + com.larus.im.internal.database.utils.j.g(r121) + "), regen_group_list(" + r121.regenMsgList + "), local_index(" + r129 + ")root(" + r121.messageId + ") visible regen group index(" + r137 + ')');
        int r138 = r125.size();
        int r139 = 0;
        int r140 = 0;
    L73:
        if (r139 >= r138) goto L111;
        int r210 = r138;
        RegenMsgGroup r141 = (RegenMsgGroup) ListProtector.get(r125, r139);
        int r211 = r137;
        if (r139 != r137) goto L77;
        boolean r212 = true;
    L78:
        int r142 = r125.size();
        List<RegenMsgGroup> r314 = r125;
        if (r142 <= 1) goto L92;
        if (r139 < 0) goto L83;
        if (r139 >= r142) goto L83;
        boolean r143 = true;
    L84:
        if (r143 == false) goto L92;
        if (r139 != 0) goto L89;
        int r144 = 1;
    L93:
        List<String> r145 = r141.msgIdList;
        List<String> r146 = r145;
        if (r146 != null) goto L96;
    L99:
        boolean r147 = true;
    L100:
        if (r147 == false) goto L102;
        Object r315 = r103;
        String r316 = r120;
    L110:
        r139 = r139 + 1;
        r138 = r210;
        r137 = r211;
        r125 = r314;
        r120 = r316;
        r103 = r315;
        goto L73
    L102:
        int r148 = r146.size();
        r316 = r120;
        int r149 = 0;
    L103:
        if (r149 >= r148) goto L109;
        String r150 = (String) ListProtector.get(r145, r149);
        int r317 = r148;
        if (r150 != null) goto L107;
        String r318 = r316;
    L108:
        r132.put(r318, new RegenHelper.a(r318, r139, r144, r212, r129, r149 + r140));
        r149 = r149 + 1;
        r148 = r317;
        r103 = r103;
        goto L103
    L107:
        r318 = r150;
        goto L108
    L109:
        r315 = r103;
        r140 = r140 + r145.size();
        goto L110
    L96:
        if (r146.isEmpty() == true) goto L99;
        r147 = false;
        goto L100
    L89:
        if (r139 != (r142 - 1)) goto L91;
        r144 = 3;
        goto L93
    L91:
        r144 = 2;
    L83:
        r143 = false;
    L92:
        r144 = 0;
        goto L93
    L77:
        r212 = false;
        goto L78
    L111:
        Object r319 = r103;
        RegenHelper.c(JSEventListener.ACTION_RESOLVE, "resolve finished. spent time(" + Duration.m10839toLongimpl(TimeSource.Monotonic.ValueTimeMark.m10943minus6eNON_k(TimeSource.Monotonic.INSTANCE.m10932markNowz9LOYto(), r124), DurationUnit.NANOSECONDS) + ')');
    L113:
        r118.putAll(r132);
        r100 = r411;
        r119 = r119;
        r103 = r319;
        goto L35
    L71:
        r137 = 0;
        goto L72
    L65:
        r136 = false;
        goto L66
    L61:
        r134 = -1;
        goto L62
    L46:
        if (r130.isEmpty() == true) goto L49;
        r131 = false;
    L112:
        r319 = r103;
        RegenHelper.c(JSEventListener.ACTION_RESOLVE, "terminated because it did not pass the check. spent time(" + Duration.m10839toLongimpl(TimeSource.Monotonic.ValueTimeMark.m10943minus6eNON_k(r123.m10932markNowz9LOYto(), r124), DurationUnit.NANOSECONDS) + ')');
        r132 = MapsKt.emptyMap();
        goto L113
    L40:
        r128 = false;
        goto L41
    L114:
        RemoteMessageListHandler$onHandle$1 r412 = r100;
        Object r320 = r103;
        a("all calculated regen result(" + r118 + ')');
        HashMap r151 = new HashMap();
        if (r312 == null) goto L124;
        Collection<MessageBody> r152 = r312.values();
        if (r152 == null) goto L124;
        ?? r153 = new ArrayList();
        Iterator r154 = r152.iterator();
    L120:
        if (r154.hasNext() == false) goto L125;
        Object r155 = r154.next();
        if (com.larus.im.internal.database.utils.j.g((MessageBody) r155) == true) goto L120;
        r153.add(r155);
    L125:
        List r156 = CollectionsKt.plus(r311, (Iterable) r153);
        if ((!r156.isEmpty()) == false) goto L143;
        List r157 = r156;
        Iterator r158 = r157.iterator();
    L129:
        if (r158.hasNext() == false) goto L134;
        MessageBody r159 = (MessageBody) r158.next();
        String r160 = r159.messageId;
        if (r160 != null) goto L133;
        r160 = "";
    L133:
        r151.put(r160, new TokenHolder(r159.fetchToken, r159.token));
        goto L129
    L134:
        StringBuilder r161 = new StringBuilder("from:");
        r161.append(r310);
        r161.append(",allMessages info:");
        ArrayList r162 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r157, 10));
        Iterator r163 = r157.iterator();
    L136:
        if (r163.hasNext() == false) goto L142;
        MessageBody r164 = (MessageBody) r163.next();
        Pair r165 = TuplesKt.to(r164.messageId, Boxing.boxInt(r164.contentStatus));
        String r166 = r164.content;
        if (r166 == null) goto L140;
        Integer r167 = Boxing.boxInt(r166.length());
    L141:
        r162.add(TuplesKt.to(TuplesKt.to(r165, r167), Boxing.boxInt(r164.status)));
        goto L136
    L140:
        r167 = null;
        goto L141
    L142:
        r161.append(r162);
        a(r161.toString());
    L143:
        RemoteMessageListHandler$onHandle$result$1 r168 = new RemoteMessageListHandler$onHandle$result$1(r156, r118, r313, r151, null);
        r100 = r412;
        r100.label = 1;
        r102 = OmniDatabaseExtKt.e(r168, r100);
        r109 = r320;
        if (r102 != r109) goto L146;
        return r109;
    L124:
        r153 = CollectionsKt.emptyList();
        goto L125
    L33:
        return CollectionsKt.emptyList();
    L27:
        if (r311.isEmpty() == true) goto L30;
        r117 = false;
        goto L31
    L23:
        r116 = null;
        goto L24
    L19:
        r115 = null;
    L7:
        r100 = new RemoteMessageListHandler$onHandle$1(this, r410);
        goto L8
    }
}
