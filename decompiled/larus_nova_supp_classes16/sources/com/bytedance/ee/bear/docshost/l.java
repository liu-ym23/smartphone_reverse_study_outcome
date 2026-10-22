package com.bytedance.ee.bear.docshost;

import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l {
    public static final /* synthetic */ int c = 0;
    public LoginIdentifyService$LoginIdentify a;
    public final HashMap<String, Map<LoginIdentifyService$LoginIdentify, Object>> b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ l a;

        public a(l r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            l r0 = this.a;
            int r1 = l.c;
            tt5.a.h("LoginIdentifyServiceImp", "accept: register success: " + ((Boolean) r4));
            r0.a(((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2());
        }
    }

    public static final class b<T> implements Consumer {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            int r0 = l.c;
            tt5.a.l("LoginIdentifyServiceImp", "accept: register error: ", (Throwable) r3);
        }
    }

    public static final class c implements com.bytedance.ee.bear.contract.b {
        public final /* synthetic */ l a;

        public c(l r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.contract.b
        public final void a(AccountService$Account r2) {
            this.a.a(r2);
        }
    }

    public static final class d {
    }

    public static final class e {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    static {
    }

    public l() {
        LoginIdentifyService$LoginIdentify r1 = LoginIdentifyService$LoginIdentify.Suite_single_Lark;
        this.a = r1;
        HashMap<String, Map<LoginIdentifyService$LoginIdentify, Object>> r2 = new HashMap();
        this.b = r2;
        int r3 = e.a;
        LoginIdentifyService$LoginIdentify r5 = LoginIdentifyService$LoginIdentify.single_LarkDocs;
        Boolean r6 = Boolean.TRUE;
        LoginIdentifyService$LoginIdentify r7 = LoginIdentifyService$LoginIdentify.single_Lark;
        LoginIdentifyService$LoginIdentify r9 = LoginIdentifyService$LoginIdentify.Suite_single_LarkDocs;
        Boolean r11 = Boolean.FALSE;
        LoginIdentifyService$LoginIdentify r12 = LoginIdentifyService$LoginIdentify.Suite_enterprise_LarkDocs;
        LoginIdentifyService$LoginIdentify r16 = LoginIdentifyService$LoginIdentify.Suite_enterprise_Lark;
        r2.put("A", MapsKt.mapOf(new Pair[]{TuplesKt.to(r5, r6), TuplesKt.to(r7, r6), TuplesKt.to(r9, r11), TuplesKt.to(r1, r11), TuplesKt.to(r12, r6), TuplesKt.to(r16, r6)}));
        r2.put("REMOVE_ORG", MapsKt.mapOf(new Pair[]{TuplesKt.to(r5, r6), TuplesKt.to(r7, r6), TuplesKt.to(r9, r6), TuplesKt.to(r1, r6), TuplesKt.to(r12, r11), TuplesKt.to(r16, r11)}));
        a(((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2());
        ((h0) org.koin.java.a.c(h0.class, null, null, 6)).Be(((b0) org.koin.java.a.c(b0.class, null, null, 6)).t()).subscribe(new a(this), b.a);
        ((h0) org.koin.java.a.c(h0.class, null, null, 6)).Pe(new c(this));
    }

    public final void a(AccountService$Account r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.hasLogin() == false) goto L24;
        String r0 = r3.tenantTag;
        if (r0 != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r0, DiagramData$RESULT.FAIL) == false) goto L12;
        LoginIdentifyService$LoginIdentify r1 = LoginIdentifyService$LoginIdentify.Suite_enterprise_Lark;
    L21:
        this.a = r1;
        tt5.a.h("LoginIdentifyServiceImp", "updateLoginIdentify   tenantTag: " + r3.tenantTag + "    isSingleproduct: " + r3.isSingleproduct + "    mLoginIdentify: " + this.a);
        return;
    L12:
        if (Intrinsics.areEqual(r0, "2") == false) goto L20;
        boolean r2 = r3.isSingleproduct;
        if (r2 != true) goto L16;
        r1 = LoginIdentifyService$LoginIdentify.single_Lark;
        goto L21
    L16:
        if (r2 == true) goto L19;
        r1 = LoginIdentifyService$LoginIdentify.Suite_single_Lark;
        goto L21
    L19:
        throw new NoWhenBranchMatchedException();
    L20:
        r1 = LoginIdentifyService$LoginIdentify.Suite_enterprise_Lark;
        goto L21
    }
}
