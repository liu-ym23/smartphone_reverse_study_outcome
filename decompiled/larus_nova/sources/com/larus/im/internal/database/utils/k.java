package com.larus.im.internal.database.utils;

import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.TextContent;
import com.larus.im.bean.message.block.Block;
import com.larus.im.internal.database.entity.MessageEntity;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import nuc.v2;
import vd9.r;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Integer[] f348166a = null;

    static {
        f348166a = new Integer[]{Integer.valueOf(MessageStatus.MessageStatus_INVISIBLE.value), Integer.valueOf(MessageStatus.MessageStatus_NOT_EXIST.value), Integer.valueOf(MessageStatus.MessageStatus_DELETED.value), Integer.valueOf(MessageStatus.MessageStatus_BEFOREEDIT.value)};
    }

    public static final List<Block> a(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Lazy r101 = r.f554249a;
        Intrinsics.checkNotNullParameter(r100, "entity");
        List<Block> r102 = (List) ((vd9.c) r.f554254f.getValue()).c(r100.getMessageId(), r100.getContent(), true);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return CollectionsKt.emptyList();
    }

    public static final List<Block> b(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isNewBlockType() == false) goto L11;
        String r101 = r100.getContent();
        if (r101 == null) goto L12;
        String r102 = r100.getMessageId();
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        return com.larus.im.bean.message.a.a(r101, r102);
    L12:
        return null;
    L11:
        return null;
    }

    public static final Map<String, String> c(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.getExt();
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        kuc.a.f(r102);
        v2 r103 = v2.f520790a;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Map<String, String> r104 = (Map) zd9.i.a(r101, kuc.a.c(r103, r103));
        if (r104 == null) goto L5;
        return r104;
    L5:
        return MapsKt.emptyMap();
    }

    public static final String d(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return "logIds::conversationId:" + r100.getConversationId() + ",threadId:" + r100.getThreadId() + ",messageId:" + r100.getMessageId() + ",localMessageId:" + r100.getLocalMessageId() + ",replyId:" + r100.getReplyId();
    }

    public static final int e(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getBeforeContentType() <= 0) goto L6;
        return r100.getBeforeContentType();
    L6:
        return r100.getContentType();
    }

    public static final String f(MessageEntity r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r100 = r110.getContent();
        String r101 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        com.larus.im.internal.stream.b r102 = com.larus.im.internal.stream.b.f350138a;
        String r103 = r110.getMessageId();
        if (r103 == null) goto L9;
        r101 = r103;
    L9:
        Integer r104 = r102.c(r101);
        if (r104 == null) goto L40;
        int r105 = r104.intValue();
        if (g(r110) == false) goto L19;
        Lazy r106 = com.larus.im.internal.core.message.concat.b.f347788a;
        List r111 = com.larus.im.internal.core.message.concat.b.e(r105, a(r110));
        wt7.c r107 = wt7.a.f561230a;
        List r112 = CollectionsKt.toList(r111);
        nuc.f r108 = kuc.a.b(Block.Companion.serializer());
        r107.getClass();
        String r113 = wt7.c.b(r112, r108);
        if (r113 != null) goto L17;
        return r100;
    L17:
        return r113;
    L19:
        if (e(r110) != 1) goto L41;
        TextContent r109 = r.c(r110);
        if (r109 != null) goto L23;
        return r100;
    L23:
        String r114 = r109.text;
        if (r114 != null) goto L27;
        return r100;
    L27:
        if (r105 >= 0) goto L29;
    L31:
        boolean r115 = false;
    L32:
        if (r115 == false) goto L34;
        r114 = r114.substring(0, r105 + 1);
    L34:
        TextContent r116 = TextContent.copy$default(r109, r114, null, null, null, null, null, null, null, 254, null);
        wt7.c r117 = wt7.a.f561230a;
        juc.d<TextContent> r118 = TextContent.Companion.serializer();
        r117.getClass();
        String r119 = wt7.c.b(r116, r118);
        if (r119 != null) goto L38;
        return r100;
    L38:
        return r119;
    L29:
        if (r105 >= r114.length()) goto L31;
        r115 = true;
        goto L32
    L41:
        return r100;
    L40:
        return r100;
    }

    public static final boolean g(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getContentType() == 9999) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        return true;
    L10:
        if (r100.isNewBlockType() == true) goto L15;
        return false;
    L15:
        return true;
    L5:
        if (r100.isNewBlockType() == true) goto L7;
        r101 = true;
        goto L8
    }

    public static final boolean h(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (e(r100) == 800) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r100.getBizContentType(), "dora_record") == false) goto L7;
        return true;
    }

    public static final boolean i(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getStatus() != 20) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean j(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.getMessageId();
        String r102 = r100.getReplyId();
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        if (Intrinsics.areEqual(r101, e.b(r102)) == false) goto L8;
    L11:
        return true;
    L8:
        if (r100.getStatus() == 24) goto L11;
        return false;
    }

    public static final boolean k(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        com.larus.im.internal.stream.b r101 = com.larus.im.internal.stream.b.f350138a;
        String r102 = r100.getMessageId();
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        if (r101.c(r102) != null) goto L8;
    L10:
        return false;
    L8:
        if (r100.getStatus() == 23) goto L10;
        return true;
    }

    public static final boolean l(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return j.l(c(r100));
    }

    public static final boolean m(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (l(r100) == false) goto L21;
        String r101 = r100.getMessageId();
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L22;
        String r103 = r100.getMessageId();
        if (r103 != null) goto L15;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == true) goto L23;
        return true;
    L23:
        return false;
    L15:
        if (StringsKt.contains$default(r103, "#", false, 2, null) != true) goto L17;
        r104 = true;
        goto L18
    L22:
        return false;
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    L21:
        return false;
    }

    public static final boolean n(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (ArraysKt.contains(f348166a, Integer.valueOf(r100.getMessageStatus())) == false) goto L7;
        return false;
    L7:
        if (r100.getMessageStatus() == MessageStatus.MessageStatus_REGENATED.value) goto L14;
        if (r100.getMessageStatus() == MessageStatus.MessageStatus_REGEN_ROOT.value) goto L14;
        return true;
    L14:
        return r100.getRegenVisible();
    }

    public static final String o(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = null;
        List<Block> r102 = null;
        String r103 = "";
        if (g(r100) == false) goto L14;
        String r104 = r100.getContent();
        if (r104 == null) goto L11;
        String r105 = r100.getMessageId();
        if (r105 == null) goto L10;
        r103 = r105;
    L10:
        r102 = com.larus.im.bean.message.a.a(r104, r103);
    L11:
        if (r102 != null) goto L24;
        r102 = CollectionsKt.emptyList();
    L24:
        return com.larus.im.internal.core.message.concat.b.d(com.larus.im.internal.core.message.concat.b.c(r102));
    L14:
        String r106 = r100.getContent();
        if (r106 == null) goto L20;
        String r107 = r100.getMessageId();
        if (r107 != null) goto L19;
        r107 = "";
    L19:
        r101 = com.larus.im.bean.message.a.H0(r106, r107);
    L20:
        if (r101 != null) goto L23;
        return "";
    L23:
        return r101;
    }
}
