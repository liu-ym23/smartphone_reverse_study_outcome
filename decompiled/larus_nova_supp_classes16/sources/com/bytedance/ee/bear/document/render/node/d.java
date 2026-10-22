package com.bytedance.ee.bear.document.render.node;

import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.domain.BearUrl;
import java.util.Map;
import k25.e0;
import k25.m0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements l {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final void c(DocumentLoaderV3 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final Object b(DocumentLoaderV3 r12, Continuation r13) {
        com.bytedance.ee.bear.document.d r14 = r12.getDocumentMetadata();
        BearUrl r0 = r14.getBearUrl();
        BearUrl r1 = r14.getOriginBearUrl();
        int r3 = 1;
        String r4 = "";
        int r5 = 0;
        if (r14.isSyncBlock() == false) goto L8;
        String r16 = r1.b;
        if (r16 == null) goto L22;
    L23:
        AccountService$Account r2 = ((h0) r12.a(h0.class)).G2();
        String r6 = r0.a;
        Map<String, String> r7 = r1.d;
        int r8 = n35.a.a;
        Intrinsics.checkNotNullParameter(r2, "account");
        m0 r17 = e0.m().n(n35.a.a(r2, r6), r16);
        StringBuilder r9 = new StringBuilder();
        r9.append(r12.i);
        r9.append("clientvars.size = ");
        String r10 = r17.c;
        if (r10 == null) goto L26;
        Integer r11 = Boxing.boxInt(r10.length());
    L27:
        r9.append(r11);
        com.ss.android.lark.officesdk.utils.di.j.e("GetClientVarNode", r9.toString());
        String r18 = r17.c;
        if (r18 != null) goto L30;
    L35:
        r3 = 0;
    L36:
        f r19 = r12.c;
        String r20 = r17.s;
        if (r20 != null) goto L39;
        r20 = "unknown";
    L39:
        r19.f(r20);
        r12.c.p(r3);
        f r21 = r12.c;
        String r22 = r17.c;
        if (r22 == null) goto L42;
        r5 = r22.length();
    L42:
        r21.k(r5);
        if (r3 == 0) goto L48;
        boolean r23 = com.bytedance.ee.bear.document.render.node.a.a;
        Intrinsics.checkNotNullParameter(r12, "context");
        if (com.bytedance.ee.bear.document.render.node.a.a == false) goto L48;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r12.d.getFragment()), null, null, new CacheDebugToastUtils$showClientVarCacheToast$1(r12, null), 3, null);
    L48:
        o r110 = r12.h;
        String r111 = r17.c;
        if (r111 == null) goto L52;
        r4 = r111;
    L52:
        r110.getClass();
        Intrinsics.checkNotNullParameter("clientvars", "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        r110.b.put("clientvars", r4);
        q.a.getClass();
        return new q.c();
    L30:
        if (r18.length() <= 0) goto L32;
        boolean r24 = true;
    L33:
        if (r24 != true) goto L35;
    L32:
        r24 = false;
        goto L33
    L26:
        r11 = null;
    L22:
        r16 = "";
        goto L23
    L8:
        if (r14.isEditionDoc() == false) goto L20;
        String r26 = r14.getEditionToken();
        if (r26 != null) goto L12;
    L15:
        boolean r27 = true;
    L16:
        if (r27 == true) goto L20;
        r16 = r14.getEditionToken();
        if (r16 != null) goto L23;
    L12:
        if (r26.length() == 0) goto L15;
        r27 = false;
    L20:
        r16 = r0.b;
        if (r16 != null) goto L23;
        goto L22
    }
}
