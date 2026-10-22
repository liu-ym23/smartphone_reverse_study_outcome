package com.larus.common.app_ops;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.common.app_ops.trasmitter.AsyncContext;
import com.larus.common.app_ops.trasmitter.AsyncContextLegacy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class e {
    static {
    }

    public static List a() {
        LinkedList r100 = new LinkedList(CollectionsKt.emptyList());
        AsyncContext r101 = b.f326262a.getContext();
        Integer r102 = null;
        if ((r101 instanceof AsyncContextLegacy) == false) goto L5;
        AsyncContextLegacy r103 = (AsyncContextLegacy) r101;
    L6:
        StringBuilder r104 = new StringBuilder();
        if (r103 == null) goto L16;
        int r105 = d.f326267a;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        Object r106 = r103.getData("stack_index");
        if (r106 != null) goto L12;
    L14:
        if (r102 == null) goto L16;
        int r107 = r102.intValue();
    L17:
        r104.append(r107);
        r104.append(':');
        r104.append(System.currentTimeMillis());
        r100.addLast(new Throwable(r104.toString()));
        return r100;
    L12:
        if ((r106 instanceof Integer) == false) goto L14;
        r102 = (Integer) r106;
    L16:
        r107 = 0;
        goto L17
    L5:
        r103 = null;
        goto L6
    }

    @JvmStatic
    public static final String b(List<? extends Throwable> r110) {
        StringBuilder r100 = new StringBuilder();
        int r101 = d09.a.f466236a;
        List r111 = CollectionsKt.reversed(r110);
        if (r111 == null) goto L26;
        Iterator r112 = r111.iterator();
        int r102 = -1;
    L6:
        if (r112.hasNext() == false) goto L26;
        Throwable r103 = (Throwable) r112.next();
        String r104 = r103.getMessage();
        String r113 = null;
        if (r104 == null) goto L10;
        List r105 = StringsKt.split$default(r104, new String[]{":"}, false, 0, 6, null);
    L11:
        int r106 = 0;
        if (r105 == null) goto L16;
        String r107 = (String) ListProtector.get(r105, 0);
        if (r107 == null) goto L16;
        Integer r108 = Integer.valueOf(CastIntegerProtector.parseInt(r107));
    L18:
        if (r102 != (-1)) goto L22;
        if (r108 == null) goto L21;
        r106 = r108.intValue();
    L21:
        r102 = r106 + 1;
    L22:
        if (r105 == null) goto L24;
        r113 = (String) ListProtector.get(r105, 1);
    L24:
        r100.append("max_stack_count:" + r102 + ", cur_index:" + r108 + ", timestamp:" + r113);
        r100.append(jh7.a.a(r103));
        StringsKt.appendln(r100);
    L16:
        r108 = null;
        goto L18
    L10:
        r105 = null;
    L26:
        return r100.toString();
    }
}
