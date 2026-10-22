package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.keyboard.base.ChatAttachmentEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b1 {
    static {
    }

    public static m5b.d a(com.ss.android.lark.keyboard.base.q r310) {
        Intrinsics.checkNotNullParameter(r310, "sendInfo");
        com.ss.android.lark.keyboard.base.r r100 = r310.f428258j;
        m5b.d r101 = new m5b.d(r310.f428249a, r310.f428250b, r310.f428251c, r310.f428252d, null);
        ArrayList r102 = null;
        if (r100 == null) goto L5;
        Context r110 = r100.getContext();
    L7:
        if (r100 != null) goto L9;
    L11:
        boolean r111 = false;
    L12:
        if (r100 != null) goto L14;
    L16:
        boolean r112 = false;
    L17:
        if (r100 == null) goto L19;
        Long r113 = r100.f428262d;
    L20:
        if (r100 == null) goto L22;
        Boolean r114 = r100.f428263e;
    L23:
        if (r100 == null) goto L25;
        String r115 = r100.f428264f;
    L26:
        if (r100 == null) goto L28;
        String r116 = r100.f428265g;
    L29:
        if (r100 == null) goto L31;
        String r117 = r100.f428266h;
    L32:
        if (r100 == null) goto L34;
        String r118 = r100.f428267i;
    L35:
        if (r100 == null) goto L37;
        String r119 = r100.f428270l;
    L38:
        if (r100 == null) goto L40;
        String r210 = r100.f428271m;
    L41:
        if (r100 == null) goto L43;
        Integer r211 = r100.f428272n;
    L44:
        if (r100 == null) goto L46;
        Integer r212 = r100.f428273o;
    L47:
        if (r100 == null) goto L49;
        String r213 = r100.f428274p;
    L50:
        if (r100 == null) goto L52;
        Uri r214 = r100.f428275q;
    L53:
        if (r100 != null) goto L55;
    L57:
        boolean r215 = false;
    L58:
        if (r100 == null) goto L60;
        xcb.a r216 = r100.f428277s;
    L61:
        if (r100 == null) goto L63;
        List<ChatAttachmentEntity> r103 = r100.f428269k;
    L64:
        List<ChatAttachmentEntity> r104 = r103;
        if (r104 != null) goto L67;
    L70:
        boolean r105 = true;
    L71:
        if (r105 == false) goto L73;
    L72:
        ArrayList r217 = r102;
        if (r100 != null) goto L79;
    L81:
        boolean r218 = false;
    L82:
        r101.f512222e = new m5b.e(r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, 285179904);
        return r101;
    L79:
        if (r100.f428280v != true) goto L81;
        r218 = true;
        goto L82
    L73:
        List<ChatAttachmentEntity> r106 = r103;
        r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r107 = r106.iterator();
    L75:
        if (r107.hasNext() == false) goto L72;
        r102.add(((ChatAttachmentEntity) r107.next()).toSendPbFile());
        goto L75
    L67:
        if (r104.isEmpty() == true) goto L70;
        r105 = false;
        goto L71
    L63:
        r103 = null;
        goto L64
    L60:
        r216 = null;
        goto L61
    L55:
        if (r100.f428276r != true) goto L57;
        r215 = true;
        goto L58
    L52:
        r214 = null;
        goto L53
    L49:
        r213 = null;
        goto L50
    L46:
        r212 = null;
        goto L47
    L43:
        r211 = null;
        goto L44
    L40:
        r210 = null;
        goto L41
    L37:
        r119 = null;
        goto L38
    L34:
        r118 = null;
        goto L35
    L31:
        r117 = null;
        goto L32
    L28:
        r116 = null;
        goto L29
    L25:
        r115 = null;
        goto L26
    L22:
        r114 = null;
        goto L23
    L19:
        r113 = null;
        goto L20
    L14:
        if (r100.f428261c != true) goto L16;
        r112 = true;
        goto L17
    L9:
        if (r100.f428260b != true) goto L11;
        r111 = true;
        goto L12
    L5:
        r110 = null;
        goto L7
    }
}
