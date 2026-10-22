package tz9;

import com.bytedance.android.livesdkapi.vr.LiveVrEffectInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.im.bean.message.Message;
import dp8.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {
    public static final String a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r101 = r100.getExt();
        Integer r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.get("ai_create_show_mode");
    L6:
        String r104 = "";
        if (r103 != null) goto L10;
        r103 = "";
    L10:
        if (r103.length() != 0) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L39;
        int r106 = r100.getContentType();
        if (r106 != 6) goto L17;
    L36:
        r104 = "pure";
    L38:
        return r104;
    L17:
        if (r106 == 2021) goto L36;
        if (r106 != 2022) goto L38;
        CreationMsgContentData r107 = e.c(r100);
        if (r107 == null) goto L26;
        CreationInfo r108 = r107.creationInfo;
        if (r108 == null) goto L26;
        r102 = r108.layoutType;
    L26:
        if (r102 != null) goto L29;
    L31:
        if (r102 == null) goto L38;
        if (r102.intValue() != 2) goto L38;
        r104 = "two_part";
        goto L38
    L29:
        if (r102.intValue() != 1) goto L31;
        r104 = LiveVrEffectInfo.STREAM_FORMAT_LITE_MODE_6DOF_OFF_MIXED;
        goto L38
    L39:
        return r103;
    L12:
        r105 = false;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public static final String b(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r101 = r100.getExt();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get("ai_creation_tool_list");
    }
}
