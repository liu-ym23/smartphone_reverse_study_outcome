package com.larus.browsertakeover.signaling;

import com.larus.im.internal.jni.bean.RoomMeta;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class j {
    public static final boolean b(RoomMeta r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.rtcAppId;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L36;
        String r103 = r100.roomId;
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == true) goto L37;
        String r105 = r100.rtcUserId;
        if (r105 != null) goto L21;
    L24:
        boolean r106 = true;
    L25:
        if (r106 == true) goto L38;
        String r107 = r100.token;
        if (r107 != null) goto L29;
    L32:
        boolean r108 = true;
    L33:
        if (r108 == true) goto L39;
        return true;
    L39:
        return false;
    L29:
        if (StringsKt.isBlank(r107) == true) goto L32;
        r108 = false;
        goto L33
    L38:
        return false;
    L21:
        if (StringsKt.isBlank(r105) == true) goto L24;
        r106 = false;
        goto L25
    L37:
        return false;
    L13:
        if (StringsKt.isBlank(r103) == true) goto L16;
        r104 = false;
        goto L17
    L36:
        return false;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }

    public static final boolean a(RoomMeta r100, RoomMeta r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "previous");
        if (b(r100) == false) goto L26;
        String r102 = r100.sessionId;
        if (r102 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r100.sessionId, r101.sessionId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(r100.rtcAppId, r101.rtcAppId) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(r100.roomId, r101.roomId) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(r100.rtcUserId, r101.rtcUserId) == true) goto L21;
        return false;
    L21:
        if (r100.useRtcTestDomain == r101.useRtcTestDomain) goto L23;
        return false;
    L23:
        if (r100.expireTimeMs <= r101.expireTimeMs) goto L33;
        return true;
    L33:
        return false;
    L7:
        if (StringsKt.isBlank(r102) == true) goto L10;
        r103 = false;
        goto L11
    L26:
        return false;
    }
}
