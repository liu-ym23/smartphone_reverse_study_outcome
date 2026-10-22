package com.larus.bmhome.chat.component.list.pipeline.pre_dependent;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e implements td8.c {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        return true;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r100, xc8.b r101, xc8.b r110, List<xc8.b> r111) {
        Intrinsics.checkNotNullParameter(r110, "current");
        Intrinsics.checkNotNullParameter(r111, "input");
        ArrayList r102 = new ArrayList();
        Iterator<T> r112 = r111.iterator();
        int r103 = 0;
        boolean r104 = false;
    L4:
        if (r112.hasNext() == false) goto L39;
        Object r105 = r112.next();
        int r106 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        xc8.b r107 = (xc8.b) r105;
        Message r108 = r107.getMessage();
        boolean r109 = com.larus.bmhome.chat.bean.d.V(r108);
        boolean r113 = m99.a.f(r108);
        if (r109 == false) goto L13;
        if (r113 == true) goto L13;
        if (r104 == false) goto L13;
        FLogger.f375446a.i("Pipeline_List_AwemeVideoSuggestFilterTask", "filter aweme video suggest at index " + r100);
    L38:
        r103 = r106;
    L13:
        Intrinsics.checkNotNullParameter(r108, "<this>");
        if (m99.a.f(r108) == true) goto L16;
    L20:
        boolean r114 = false;
    L21:
        if (r114 == false) goto L24;
        FLogger.f375446a.e("Pipeline_List_AwemeVideoSuggestFilterTask", "filter aweme video summary with invalid data at index " + r100 + ", messageId = " + r108.getMessageId());
        goto L38
    L24:
        if (r108.getSourceFromAsr() == false) goto L34;
        Map<String, String> r115 = r108.getBusinessExt();
        if (r115 == null) goto L28;
        String r116 = r115.get("is_real_audio_text");
    L30:
        if (Intrinsics.areEqual(r116, "1") == true) goto L34;
        if (Intrinsics.areEqual(com.larus.bmhome.chat.bean.d.j(r108), "is_mock_sending") == true) goto L34;
    L36:
        r104 = false;
    L37:
        r102.add(r107);
        goto L38
    L28:
        r116 = null;
    L34:
        if (com.larus.bmhome.chat.bean.d.V(r108) == true) goto L36;
        r104 = true;
        goto L37
    L16:
        if (o0.d(r108.getMessageId()) == false) goto L20;
        if (r108.getExt() != null) goto L20;
        r114 = true;
        goto L21
    L39:
        return r102;
    }
}
