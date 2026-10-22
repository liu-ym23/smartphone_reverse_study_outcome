package com.bytedance.ee.bear.office.list;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o {
    public static final List<OfficeSpaceItem> b(ed5.a r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        r6.getClass();
        ArrayList r1 = new ArrayList(r6.d);
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Document r4 = (Document) r3.next();
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r4, "<this>");
        r2.add(a(r4, CollectionsKt.emptyList()));
        goto L4
    L6:
        ArrayList r0 = new ArrayList(r6.c);
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r5 = r0.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        Document r8 = (Document) r5.next();
        Intrinsics.checkNotNull(r8);
        r7.add(a(r8, r2));
        goto L8
    L10:
        return r7;
    }

    public static final OfficeSpaceItem a(Document r16, List<OfficeSpaceItem> r17) {
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Intrinsics.checkNotNullParameter(r17, "fileList");
        String r0 = r16.d;
        String r2 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        boolean r4 = true;
        if (r0.length() != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L13;
        r0 = r16.c;
        if (r0 != null) goto L13;
        r0 = "";
    L13:
        String r5 = r0;
        int r6 = r16.getType();
        String r1 = t0.g(eu5.b.a, r16);
        if (r1.length() != 0) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == false) goto L21;
        r1 = r16.a;
        if (r1 != null) goto L21;
        r1 = "";
    L21:
        String r8 = r1;
        String r9 = t0.i(r16);
        String r10 = r16.h;
        if (r10 != null) goto L25;
        r10 = "";
    L25:
        if (r10.length() != 0) goto L27;
        boolean r11 = true;
    L28:
        if (r11 == false) goto L34;
        String r12 = r16.C;
        if (r12 == null) goto L33;
        r2 = r12;
    L33:
        String r13 = r2;
    L36:
        if (r16.getType() != sbb.e.f.b) goto L38;
        boolean r14 = true;
    L39:
        String r15 = r16.O;
        Integer r18 = null;
        if (r15 != null) goto L42;
    L64:
        String r19 = null;
    L65:
        if (r19 != null) goto L67;
        r19 = r16.Z;
    L67:
        LinkedHashMap r110 = new LinkedHashMap();
        String r111 = r16.F;
        if (r111 != null) goto L70;
    L78:
        if (r19 != null) goto L80;
    L88:
        String r20 = r16.J2;
        if (r20 != null) goto L91;
    L99:
        String r21 = r16.Q;
        if (r21 != null) goto L102;
    L110:
        String r22 = r16.R;
        if (r22 != null) goto L113;
    L121:
        Integer r23 = Integer.valueOf(r16.y1);
        if (r23.intValue() > 0) goto L125;
        r4 = false;
    L125:
        if (r4 == false) goto L127;
        r18 = r23;
    L127:
        if (r18 == null) goto L129;
        int r24 = r18.intValue();
    L131:
        return new OfficeSpaceItem(r5, r6, r8, r9, r13, r14, r110, r17, Integer.valueOf(r24), r16.M2);
    L129:
        r24 = r16.getType();
        goto L131
    L113:
        if (r22.length() <= 0) goto L115;
        boolean r112 = true;
    L116:
        if (r112 == true) goto L119;
        r22 = null;
    L119:
        if (r22 == null) goto L121;
        r110.put("mount_point", r22);
        goto L121
    L115:
        r112 = false;
        goto L116
    L102:
        if (r21.length() <= 0) goto L104;
        boolean r113 = true;
    L105:
        if (r113 == true) goto L108;
        r21 = null;
    L108:
        if (r21 == null) goto L110;
        String r25 = (String) r110.put("mount_node_token", r21);
        goto L110
    L104:
        r113 = false;
        goto L105
    L91:
        if (r20.length() <= 0) goto L93;
        boolean r114 = true;
    L94:
        if (r114 == true) goto L97;
        r20 = null;
    L97:
        if (r20 == null) goto L99;
        String r26 = (String) r110.put("doubao_ai_skill_status", r20);
        goto L99
    L93:
        r114 = false;
        goto L94
    L80:
        if (r19.length() <= 0) goto L82;
        boolean r115 = true;
    L83:
        if (r115 == true) goto L86;
        r19 = null;
    L86:
        if (r19 == null) goto L88;
        String r27 = (String) r110.put("size", r19);
        goto L88
    L82:
        r115 = false;
        goto L83
    L70:
        if (r111.length() <= 0) goto L72;
        boolean r116 = true;
    L73:
        if (r116 == true) goto L76;
        r111 = null;
    L76:
        if (r111 == null) goto L78;
        String r117 = (String) r110.put("file_ext", r111);
        goto L78
    L72:
        r116 = false;
        goto L73
    L42:
        if (r15.length() <= 0) goto L44;
        boolean r118 = true;
    L45:
        if (r118 == true) goto L48;
        r15 = null;
    L48:
        if (r15 == null) goto L64;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L51
        Object r28 = Result.constructor-impl(new JSONObject(r15).optString("size"));     // Catch: Throwable -> L51
    L54:
        if (Result.isFailure-impl(r28) == false) goto L56;
        r28 = null;
    L56:
        r19 = (String) r28;
        if (r19 == null) goto L64;
        if (r19.length() <= 0) goto L61;
        boolean r120 = true;
    L62:
        if (r120 == false) goto L64;
    L61:
        r120 = false;
    L51:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L54
    L44:
        r118 = false;
        goto L45
    L38:
        r14 = false;
        goto L39
    L34:
        r13 = r10;
        goto L36
    L27:
        r11 = false;
        goto L28
    L16:
        r7 = false;
        goto L17
    L8:
        r3 = false;
        goto L9
    }
}
