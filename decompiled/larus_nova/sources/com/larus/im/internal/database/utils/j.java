package com.larus.im.internal.database.utils;

import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.block.Block;
import com.larus.im.internal.protocol.bean.ContentStatus;
import com.larus.im.internal.protocol.bean.MessageBody;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IntRange f348165a = null;

    static {
        f348165a = RangesKt.until(ContentStatus.CONTENT_STATUS_CONTENT_IN_STREAMING.value, ContentStatus.CONTENT_STATUS_INTERRUPT.value);
    }

    public static final int a(MessageBody r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r101 = r100.ext;
        if (r101 == null) goto L9;
        String r102 = r101.get("before_content_type");
        if (r102 == null) goto L9;
        Integer r103 = StringsKt.toIntOrNull(r102);
        if (r103 == null) goto L9;
        return r103.intValue();
    L9:
        return 0;
    }

    public static final String b(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.get("chat_id");
    }

    public static final int c(MessageBody r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Intrinsics.areEqual(r100.senderId, com.larus.im.internal.delegate.b.f348193b.getUserId()) == false) goto L6;
        return 11;
    L6:
        if (i(r100) == false) goto L8;
        return 20;
    L8:
        int r101 = r100.contentStatus;
        if (r101 != ContentStatus.CONTENT_STATUS_INTERRUPT.value) goto L12;
        return 23;
    L12:
        if (r101 != ContentStatus.CONTENT_STATUS_FAILED.value) goto L14;
        return 22;
    L14:
        return 21;
    }

    public static final int d(MessageBody r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a(r100);
        if (r101 <= 0) goto L6;
        return r101;
    L6:
        return r100.contentType;
    }

    public static final Integer e(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.get("refer_msg_content_type");
        if (r101 != null) goto L7;
        return null;
    L7:
        return StringsKt.toIntOrNull(r101);
    }

    public static final boolean f(MessageBody r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r101 = r100.ext;
        if (r101 == null) goto L5;
        String r102 = r101.get("use_content_block");
    L7:
        if (Intrinsics.areEqual(r102, "1") == true) goto L19;
        List<Block> r103 = r100.contentBlock;
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L20;
        return false;
    L20:
        return true;
    L11:
        if (r103.isEmpty() == true) goto L14;
        r104 = false;
        goto L15
    L19:
        return true;
    L5:
        r102 = null;
        goto L7
    }

    public static final boolean g(MessageBody r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.status != MessageStatus.MessageStatus_REGEN_ROOT.value) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean h(MessageBody r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.senderId;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r100.senderId, com.larus.im.internal.delegate.b.f348193b.getUserId()) == false) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }

    public static final boolean i(MessageBody r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        IntRange r101 = f348165a;
        int r102 = r101.getFirst();
        int r103 = r101.getLast();
        int r104 = r100.contentStatus;
        if (r102 > r104) goto L7;
        if (r104 > r103) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }

    public static final boolean j(Map<String, String> r100) {
        String r101 = r100.get("refer_msg_id");
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L20;
        String r103 = r100.get("sub_msg_index");
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == true) goto L21;
        return true;
    L21:
        return false;
    L13:
        if (r103.length() == 0) goto L16;
        r104 = false;
        goto L17
    L20:
        return false;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static final boolean k(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (j(r100) == false) goto L10;
        Integer r101 = e(r100);
        if (r101 == null) goto L10;
        if (r101.intValue() != 67) goto L10;
        return true;
    L10:
        return false;
    }

    public static final boolean l(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (j(r100) == true) goto L5;
    L12:
        return false;
    L5:
        if (e(r100) == null) goto L11;
        Integer r101 = e(r100);
        if (r101 == null) goto L12;
        if (r101.intValue() != 66) goto L12;
    L11:
        return true;
    }
}
