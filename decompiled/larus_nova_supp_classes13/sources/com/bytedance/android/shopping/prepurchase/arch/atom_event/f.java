package com.bytedance.android.shopping.prepurchase.arch.atom_event;

import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends t96.a {
    public final Lazy c;

    public f() {
        Intrinsics.checkNotNullParameter("setStorage", "name");
        super("setStorage");
        this.c = LazyKt.lazy(ECSetStorageActionAtomEvent$ecSpService$2.INSTANCE);
    }

    public final void b(EventContext r9, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r10) {
        Intrinsics.checkNotNullParameter(r9, "eventContext");
        Intrinsics.checkNotNullParameter(r10, "completion");
        int r0 = i.a;
        i r11 = i.a.a(r9.k);
        String r1 = r11.a();
        Object r12 = r11.b();
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L49;
        if (r12 == null) goto L49;
        if (Intrinsics.areEqual(r12.toString(), "null") == false) goto L17;
        ((mj.a) this.c.getValue()).erase(r1);
        int r13 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L17:
        if ((r12 instanceof Boolean) == false) goto L20;
        ((mj.a) this.c.getValue()).c(r1, ((Boolean) r12).booleanValue());
    L47:
        int r14 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L20:
        if ((r12 instanceof Integer) == false) goto L22;
    L42:
        mj.a r3 = (mj.a) this.c.getValue();
        Integer r15 = ECHybridExtensionsKt.i(r12);
        if (r15 == null) goto L45;
        int r16 = r15.intValue();
    L46:
        r3.d(r1, r16);
        goto L47
    L45:
        r16 = 0;
        goto L46
    L22:
        if ((r12 instanceof Double) == true) goto L42;
        if ((r12 instanceof String) == false) goto L28;
        ((mj.a) this.c.getValue()).putString(r1, (String) r12);
        goto L47
    L28:
        if ((r12 instanceof List) == false) goto L40;
        ArrayList r5 = new ArrayList();
        Iterator r4 = ((Iterable) r12).iterator();
    L31:
        if (r4.hasNext() == false) goto L36;
        Object r6 = r4.next();
        if ((r6 instanceof String) == false) goto L31;
        r5.add(r6);
        goto L31
    L36:
        if (r5.size() == ((List) r12).size()) goto L39;
        int r17 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "List contains non-String elements, only support List<String>", null, null, 57));
        return;
    L39:
        ((mj.a) this.c.getValue()).b(r1, r5);
        goto L47
    L40:
        int r18 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "value type is not supported", null, null, 57));
        return;
    L49:
        int r19 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "key or value is empty", null, null, 57));
        return;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L9
    }
}
