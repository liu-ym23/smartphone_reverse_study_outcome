package vf8;

import com.larus.bmhome.chat.list.cell.loading.LoadingType;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i {
    public static final LoadingType a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (b0.h(r100) == true) goto L54;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r101 = r100.getBusinessExt();
        if (r101 == null) goto L8;
        String r102 = r101.get("is_mock_text");
    L10:
        if (Intrinsics.areEqual(r102, "1") == false) goto L13;
    L55:
        return null;
    L13:
        if (com.larus.bmhome.chat.bean.d.S(r100) == true) goto L56;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getSourceFromAsr() == true) goto L18;
    L26:
        boolean r103 = false;
    L27:
        if (r103 == false) goto L30;
        return LoadingType.OUT;
    L30:
        if (com.larus.im.bean.message.a.b0(r100) == true) goto L32;
        String r104 = r100.getContent();
        if (r104 != null) goto L38;
    L39:
        boolean r105 = true;
    L40:
        if (r105 == false) goto L55;
        if (CollectionsKt.listOf(new Integer[]{1, 9999}).contains(Integer.valueOf(r100.getContentType())) == false) goto L55;
        int r106 = r100.getMessageStatusLocal();
        if (r106 == 10) goto L53;
        if (r106 == 12) goto L53;
        if (r106 == 20) goto L58;
        if (r106 != 22) goto L55;
    L58:
        return LoadingType.IN;
    L53:
        return LoadingType.OUT;
    L38:
        if (r104.length() == 0) goto L39;
    L34:
        r105 = false;
        goto L40
    L32:
        if (com.larus.im.bean.message.a.e(r100).length() != 0) goto L34;
    L18:
        if (r100.getMessageStatusLocal() != 12) goto L26;
        Map<String, String> r107 = r100.getBusinessExt();
        if (r107 == null) goto L22;
        String r108 = r107.get("is_real_audio_text");
    L24:
        if (Intrinsics.areEqual(r108, "1") == true) goto L26;
        r103 = true;
        goto L27
    L22:
        r108 = null;
        goto L24
    L56:
        return LoadingType.OUT;
    L8:
        r102 = null;
        goto L10
    L54:
        return LoadingType.IN;
    }
}
