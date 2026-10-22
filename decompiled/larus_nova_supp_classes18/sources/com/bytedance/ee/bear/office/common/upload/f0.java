package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(h0 r3) {
        if (r3.n != OfficeUploadTaskSource.LOCAL) goto L19;
        String r0 = r3.b;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L21;
        OfficeUploadStatus r4 = r3.k;
        if (r4 != OfficeUploadStatus.UNSTARTED) goto L16;
    L17:
        return true;
    L16:
        if (r4 == OfficeUploadStatus.UPLOADING) goto L17;
        return false;
    L21:
        return false;
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r1 = false;
        goto L11
    L19:
        return false;
    }

    public static List c(List r1, List r2) {
        Intrinsics.checkNotNullParameter(r1, "current");
        Intrinsics.checkNotNullParameter(r2, "recoveredTasks");
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r1 = d(r1, (h0) r3.next());
        goto L4
    L6:
        return r1;
    }

    public static List d(List r29, h0 r30) {
        Intrinsics.checkNotNullParameter(r29, "current");
        Intrinsics.checkNotNullParameter(r30, "recoveredTask");
        String r5 = r30.b;
        if (r5 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return r29;
    L11:
        Iterator r2 = r29.iterator();
        int r3 = 0;
    L12:
        int r4 = -1;
        if (r2.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((h0) r2.next()).b, r5) == true) goto L19;
        r3 = r3 + 1;
    L19:
        List r21 = r29;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r21.iterator();
    L21:
        if (r7.hasNext() == false) goto L25;
        Object r8 = r7.next();
        if (a((h0) r8) == false) goto L21;
        r6.add(r8);
        goto L21
    L25:
        Iterator r9 = r29.iterator();
        int r10 = 0;
    L27:
        if (r9.hasNext() == false) goto L32;
        if (b((h0) r9.next(), r30, r6.size()) == true) goto L30;
        r10 = r10 + 1;
        goto L27
    L30:
        r4 = r10;
    L32:
        if (r4 >= 0) goto L35;
        r4 = r3;
    L35:
        if (r4 < 0) goto L37;
        h0 r0 = (h0) ListProtector.get(r29, r4);
        String r11 = r0.a;
        String r15 = r0.c;
        boolean r14 = r0.d;
        String r13 = r0.e;
        String r12 = r0.f;
        if (r12 != null) goto L41;
        r12 = r30.f;
    L41:
        int r28 = r4;
        String r27 = r5;
        h0 r16 = h0.a(r30, r11, null, r15, r14, r13, r12, null, null, r0.i, r0.j, null, null, null, r0.n, r0.o, System.currentTimeMillis(), 7362);
        ArrayList r17 = new ArrayList();
        Iterator r18 = r21.iterator();
        int r19 = 0;
    L43:
        if (r18.hasNext() == false) goto L60;
        Object r20 = r18.next();
        int r22 = r19 + 1;
        if (r19 >= 0) goto L47;
        CollectionsKt.throwIndexOverflow();
    L47:
        h0 r23 = (h0) r20;
        int r24 = r28;
        if (r19 != r24) goto L50;
        r23 = r16;
        String r25 = r27;
    L57:
        if (r23 == null) goto L59;
        r17.add(r23);
    L59:
        r28 = r24;
        r27 = r25;
        r19 = r22;
        goto L43
    L50:
        r25 = r27;
        if (Intrinsics.areEqual(r23.b, r25) == true) goto L56;
        if (b(r23, r30, r6.size()) == false) goto L57;
    L56:
        r23 = null;
        goto L57
    L60:
        return r17;
    L37:
        return CollectionsKt.plus(r29, r30);
    L18:
        r3 = -1;
        goto L19
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static boolean b(h0 r3, h0 r4, int r5) {
        if (a(r3) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r3.e, r4.e) == false) goto L8;
        return true;
    L8:
        if (r5 != 1) goto L10;
        return true;
    L10:
        Long r6 = r3.g;
        Long r7 = r4.g;
        if (r6 == null) goto L17;
        if (r7 != null) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(r6, r7) == false) goto L19;
        return true;
    L19:
        return false;
    L17:
        return false;
    }
}
