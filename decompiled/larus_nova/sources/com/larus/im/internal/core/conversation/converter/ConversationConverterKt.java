package com.larus.im.internal.core.conversation.converter;

import be9.b;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.conversation.Templates;
import com.larus.im.internal.database.entity.ConversationEntity;
import com.larus.im.internal.protocol.bean.ConvOperateType;
import com.larus.im.internal.protocol.bean.ConversationInfo;
import com.larus.im.internal.protocol.bean.Image;
import com.larus.im.internal.protocol.bean.MsgTemplate;
import com.larus.im.internal.tracking.f;
import com.ss.ttm.player.C;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import nuc.v2;
import wc9.e;
import zd9.i;

/* JADX INFO: loaded from: classes29.dex */
public final class ConversationConverterKt {
    public static final long a(long r100) {
        if (r100 > 0) goto L6;
        return r100;
    L6:
        if (r100 < 100000000000000000L) goto L10;
        return r100 / C.NANOS_PER_SECOND;
    L10:
        if (r100 < 100000000000000L) goto L14;
        return r100 / 1000000;
    L14:
        if (r100 >= 100000000000L) goto L16;
        return r100;
    L16:
        return r100 / 1000;
    }

    public static e c(ConversationEntity r410) {
        ReadCvsInfoFrom r100 = ReadCvsInfoFrom.UNKNOWN;
        Intrinsics.checkNotNullParameter(r410, "<this>");
        Intrinsics.checkNotNullParameter(r100, "from");
        List r110 = i.b(r410.getTemplates(), Templates.Companion.serializer());
        String r101 = r410.getTraceMap();
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        kuc.a.f(r102);
        v2 r103 = v2.f520790a;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Map r104 = (Map) i.a(r101, kuc.a.c(r103, kuc.a.d(r103)));
        if (r104 == null) goto L11;
        String r105 = (String) r104.get("request_id");
        if (r105 == null) goto L11;
        if (r110 == null) goto L11;
        Iterator r106 = r110.iterator();
    L9:
        if (r106.hasNext() == false) goto L11;
        ((Templates) r106.next()).setRequestId(r105);
    L11:
        int r107 = f.f350317a;
        if (f.a(r410.getExt()) == false) goto L14;
        f.b(r410.getConversationId(), 0, r100.getValue(), r410.getExt());
    L14:
        String r108 = r410.getConversationId();
        IconImage r109 = (IconImage) i.a(r410.getIconImage(), IconImage.Companion.serializer());
        String r111 = r410.getName();
        Long r112 = r410.getUpdateTime();
        Integer r113 = r410.getPinned();
        Integer r114 = r410.isLocal();
        ConversationPage r115 = (ConversationPage) i.a(r410.getConversationPage(), ConversationPage.Companion.serializer());
        boolean r116 = r410.getTtsEnable();
        Integer r117 = r410.getConversationType();
        Integer r118 = r410.getParticipantCount();
        Integer r119 = r410.getBadgeCount();
        Integer r120 = r410.getReadBadgeCount();
        String r121 = r410.getBriefMessageLocalId();
        String r210 = r410.getExt();
        Integer r211 = r410.getStatus();
        int r122 = r410.getBotType();
        Long r212 = r410.getReadMessageIndex();
        Long r213 = r410.getMessageCursor();
        Long r214 = r410.getLatestMessageIndex();
        Long r123 = r410.getVersion();
        if (r123 == null) goto L17;
        long r215 = r123.longValue();
    L18:
        long r411 = r410.getPinTime();
        String r124 = r410.getBizExtra();
        StringCompanionObject r125 = StringCompanionObject.INSTANCE;
        kuc.a.f(r125);
        v2 r126 = v2.f520790a;
        Intrinsics.checkNotNullParameter(r125, "<this>");
        Map r310 = (Map) i.a(r124, kuc.a.c(r126, r126));
        String r127 = r410.getBizModel();
        String r311 = r410.getOwnerId();
        boolean r128 = r410.isDeleted();
        Long r216 = r410.getRetentionCursor();
        String r312 = r410.getLastSectionId();
        Integer r313 = r410.getInputLeftActionStyle();
        Integer r314 = r410.getGroupReviewStatus();
        Integer r315 = r410.getCreateScene();
        Integer r129 = r410.getCellType();
        if (r129 == null) goto L21;
        int r316 = r129.intValue();
    L22:
        Integer r130 = r410.getCreateChannel();
        if (r130 == null) goto L25;
        int r317 = r130.intValue();
    L26:
        String r412 = r410.getParentCellId();
        String r413 = r410.getProjectId();
        return new e(r108, r109, r111, r112, r113, r114, r115, r110, r116, r117, r118, r119, r120, r121, r212, r213, r214, r210, r127, r211, r215, Integer.valueOf(r122), r216, r310, r104, r311, Boolean.valueOf(r128), r312, r313, r314, r315, r316, r317, r412, r413, r411, 0, 24);
    L25:
        r317 = 0;
        goto L26
    L21:
        r316 = 0;
        goto L22
    L17:
        r215 = 0;
        goto L18
    }

    public static final Object b(ConversationInfo r710, WriteCvsInfo2EntityFrom r711, Continuation<? super ConversationEntity> r712) {
        ConversationInfo r100 = r710;
        if ((r712 instanceof ConversationConverterKt$toEntity$1) == false) goto L7;
        ConversationConverterKt$toEntity$1 r101 = (ConversationConverterKt$toEntity$1) r712;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        WriteCvsInfo2EntityFrom r106 = (WriteCvsInfo2EntityFrom) r101.L$1;
        ConversationInfo r107 = (ConversationInfo) r101.L$0;
        ResultKt.throwOnFailure(r103);
        WriteCvsInfo2EntityFrom r108 = r106;
        r100 = r107;
    L20:
        ConversationEntity r109 = (ConversationEntity) r103;
        com.larus.im.internal.delegate.a r110 = com.larus.im.internal.delegate.a.f348188b;
        StringBuilder r111 = new StringBuilder("info version(");
        r111.append(r100.version);
        r111.append("), entity version(");
        if (r109 == null) goto L23;
        Long r112 = r109.getVersion();
    L24:
        r111.append(r112);
        r111.append(')');
        r110.i("ConversationInfo#toEntity", r111.toString());
        int r113 = f.f350317a;
        if (f.a(r100.extra) == false) goto L31;
        String r114 = r100.conversationId;
        if (r114 != null) goto L29;
        r114 = "";
    L29:
        f.b(r114, 1, r108.getValue(), r100.extra);
    L31:
        if (r109 == null) goto L71;
        long r115 = r100.pinnedTime;
        if (r115 >= 0) goto L36;
        Integer r116 = r109.getPinned();
    L35:
        Integer r117 = r116;
        Long r118 = Boxing.boxLong(r100.version);
        if (r118.longValue() <= 0) goto L42;
        boolean r119 = true;
    L43:
        if (r119 == true) goto L46;
        r118 = null;
    L46:
        if (r118 != null) goto L48;
        r118 = r109.getVersion();
    L48:
        Long r310 = r118;
        int r120 = r100.botType;
        String r121 = i.c(ud9.a.a(r100), Image.Companion.serializer());
        String r122 = ud9.a.b(r100);
        long r123 = r100.pinnedTime;
        if (r123 < 0) goto L51;
        long r124 = a(r123);
    L52:
        long r125 = r124;
        String r210 = i.c(r100.conversationPage, com.larus.im.internal.protocol.bean.ConversationPage.Companion.serializer());
        String r211 = i.c(r100.msgTemplates, kuc.a.b(MsgTemplate.Companion.serializer()));
        long r126 = r100.msgCursor;
        int r127 = r100.conversationType;
        int r128 = (int) r100.participantCount;
        long r129 = r100.lastReadIndex;
        String r130 = r100.extra;
        String r131 = r100.bizModel;
        int r132 = r100.status;
        long r133 = r100.latestIndex;
        Map<String, String> r134 = r100.traceMap;
        StringCompanionObject r135 = StringCompanionObject.INSTANCE;
        kuc.a.f(r135);
        v2 r136 = v2.f520790a;
        Intrinsics.checkNotNullParameter(r135, "<this>");
        String r410 = i.c(r134, kuc.a.c(r136, r136));
        String r137 = r100.creatorId;
        Integer r411 = r100.getInputLeftActionStyle();
        int r138 = r100.getGroupReviewStatus();
        int r139 = r100.getCreateScene();
        int r311 = r100.getCreateChannel();
        String r140 = r100.getParentCellId();
        if (r140 != null) goto L55;
        String r412 = "";
    L56:
        String r141 = r100.getSectionId();
        if (r141 != null) goto L59;
    L62:
        boolean r212 = true;
    L64:
        if ((!r212) == true) goto L67;
        r141 = null;
    L67:
        if (r141 != null) goto L70;
        r141 = r109.getLastSectionId();
    L70:
        return ConversationEntity.copy$default(r109, null, null, null, r120, r121, r122, null, null, r117, r125, null, r210, r211, Boxing.boxLong(r126), false, Boxing.boxInt(r127), Boxing.boxInt(r128), null, null, null, Boxing.boxLong(r129), r130, r131, r310, Boxing.boxInt(r132), null, null, Boxing.boxLong(r133), r137, false, r410, r411, Boxing.boxInt(r138), Boxing.boxInt(r139), null, Boxing.boxInt(r311), r412, r141, null, 638469319, 68, null);
    L59:
        if (r141.length() == 0) goto L62;
        r212 = false;
        goto L64
    L55:
        r412 = r140;
        goto L56
    L51:
        r124 = r109.getPinTime();
        goto L52
    L42:
        r119 = false;
        goto L43
    L36:
        if (r115 != 0) goto L38;
        r116 = Boxing.boxInt(ConvOperateType.OPERATE_TYPE_UNKNOWN.value);
        goto L35
    L38:
        r116 = Boxing.boxInt(ConvOperateType.TOP.value);
        goto L35
    L71:
        Long r142 = Boxing.boxLong(r100.version);
        if (r142.longValue() <= 0) goto L74;
        boolean r143 = true;
    L75:
        if (r143 == false) goto L77;
        Long r510 = r142;
    L78:
        String r144 = r100.conversationId;
        if (r144 != null) goto L81;
        String r213 = "";
    L82:
        int r145 = r100.botType;
        String r312 = i.c(ud9.a.a(r100), Image.Companion.serializer());
        String r313 = ud9.a.b(r100);
        long r146 = r100.pinnedTime;
        if (r146 <= 0) goto L85;
        int r147 = 1;
    L86:
        long r314 = a(RangesKt.coerceAtLeast(r146, 0));
        String r413 = i.c(r100.conversationPage, com.larus.im.internal.protocol.bean.ConversationPage.Companion.serializer());
        String r414 = i.c(r100.msgTemplates, kuc.a.b(MsgTemplate.Companion.serializer()));
        long r148 = r100.msgCursor;
        int r149 = r100.conversationType;
        int r150 = (int) r100.participantCount;
        long r151 = r100.lastReadIndex;
        String r152 = r100.extra;
        String r153 = r100.bizModel;
        int r154 = r100.status;
        String r155 = r100.creatorId;
        Integer r610 = r100.getInputLeftActionStyle();
        long r156 = r100.retentionCursor;
        long r157 = r100.latestIndex;
        Map<String, String> r158 = r100.traceMap;
        StringCompanionObject r159 = StringCompanionObject.INSTANCE;
        kuc.a.f(r159);
        v2 r160 = v2.f520790a;
        Intrinsics.checkNotNullParameter(r159, "<this>");
        String r511 = i.c(r158, kuc.a.c(r160, r160));
        int r161 = r100.getGroupReviewStatus();
        int r162 = r100.getCreateScene();
        int r163 = r100.getCreateChannel();
        String r164 = r100.getParentCellId();
        if (r164 != null) goto L89;
        String r611 = "";
    L90:
        String r165 = r100.getSectionId();
        if (r165 != null) goto L93;
        String r612 = "";
    L95:
        return new ConversationEntity(r213, null, null, r145, r312, r313, null, null, Boxing.boxInt(r147), r314, Boxing.boxInt(0), r413, r414, Boxing.boxLong(r148), false, Boxing.boxInt(r149), Boxing.boxInt(r150), Boxing.boxInt(0), Boxing.boxInt(0), null, Boxing.boxLong(r151), r152, r153, r510, Boxing.boxInt(r154), null, Boxing.boxLong(r156), Boxing.boxLong(r157), r155, false, r511, r610, Boxing.boxInt(r161), Boxing.boxInt(r162), null, Boxing.boxInt(r163), r611, r612, null, 570966214, 68, null);
    L93:
        r612 = r165;
        goto L95
    L89:
        r611 = r164;
        goto L90
    L85:
        r147 = 0;
        goto L86
    L81:
        r213 = r144;
        goto L82
    L77:
        r510 = null;
        goto L78
    L74:
        r143 = false;
        goto L75
    L23:
        r112 = null;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        b r166 = ae9.b.a();
        String r167 = r100.conversationId;
        if (r167 != null) goto L17;
        r167 = "";
    L17:
        r101.L$0 = r100;
        r108 = r711;
        r101.L$1 = r108;
        r101.label = 1;
        r103 = b.C0295b.a(r166, r167, 0, r101, 6);
        if (r103 != r104) goto L20;
        return r104;
    L7:
        r101 = new ConversationConverterKt$toEntity$1(r712);
        goto L8
    }
}
