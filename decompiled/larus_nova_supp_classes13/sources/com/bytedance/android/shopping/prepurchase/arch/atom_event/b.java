package com.bytedance.android.shopping.prepurchase.arch.atom_event;

import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends t96.a {
    public final Lazy c;

    public b() {
        Intrinsics.checkNotNullParameter("getStorage", "name");
        super("getStorage");
        this.c = LazyKt.lazy(ECGetStorageActionAtomEvent$ecSpService$2.INSTANCE);
    }

    public final void b(EventContext r7, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r8) {
        Intrinsics.checkNotNullParameter(r7, "eventContext");
        Intrinsics.checkNotNullParameter(r8, "completion");
        int r0 = i.a;
        i r1 = i.a.a(r7.k);
        String r2 = r1.a();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        Object r3 = r1.b();
        if ((r3 instanceof String) == true) goto L8;
        r3 = null;
    L8:
        String r4 = (String) r3;
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        if (StringsKt.isBlank(r2) == false) goto L16;
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "key or value is blank", null, null, 57));
        return;
    L16:
        switch(r4.hashCode()) {
            case -891985903: goto L28;
            case 104431: goto L25;
            case 3029738: goto L22;
            case 93090393: goto L19;
            default: goto L32;
        };
    L32:
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "value type not support", null, null, 57));
        return;
    L19:
        if (r4.equals("array") == false) goto L32;
        Object r5 = ((mj.a) this.c.getValue()).a(r2, CollectionsKt.emptyList());
    L30:
        r7.e.c.putAll(MapsKt.mapOf(TuplesKt.to(r2, r5)));
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L22:
        if (r4.equals("bool") == false) goto L32;
        r5 = Boolean.valueOf(((mj.a) this.c.getValue()).getBoolean(r2, false));
        goto L30
    L25:
        if (r4.equals("int") == false) goto L32;
        r5 = Integer.valueOf(((mj.a) this.c.getValue()).getInt(r2, 0));
        goto L30
    L28:
        if (r4.equals("string") == false) goto L32;
        r5 = ((mj.a) this.c.getValue()).getString(r2, "");
        goto L30
    }
}
