package com.bytedance.ee.bear.document.offline.sync.rust;

import android.util.Pair;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.lark.pb.space.doc.v1.CCMRustSetDataRequest;
import k25.e0;
import k25.m0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Pair a(AccountService$Account r8, CCMRustSetDataRequest r9) {
        Intrinsics.checkNotNullParameter(r8, "account");
        Intrinsics.checkNotNullParameter(r9, "request");
        Intrinsics.checkNotNullParameter(r8, "account");
        Intrinsics.checkNotNullParameter(r9, "request");
        m0 r1 = new m0();
        String r2 = r9.key;
        Intrinsics.checkNotNullParameter(r8, "account");
        Intrinsics.checkNotNullParameter(r2, "key");
        switch(r2.hashCode()) {
            case 261424942: goto L17;
            case 1185671968: goto L13;
            case 1720096323: goto L9;
            case 2008878624: goto L6;
            default: goto L20;
        };
    L20:
        r1.b = r2;
        r1.k = r9.obj_token;
        r1.c = new String(r9.data.toByteArray(), Charsets.UTF_8);
        String r10 = r9.key;
        Intrinsics.checkNotNullParameter(r10, "key");
        boolean r3 = false;
        if (Intrinsics.areEqual(r10, "SHEET_CLIENT_VARS") == false) goto L23;
    L36:
        e r11 = e.h;
    L37:
        r1.i = r11.getType();
        Boolean r12 = r9.need_sync;
        if (r12 == null) goto L40;
        r3 = r12.booleanValue();
    L40:
        r1.g = r3;
        r1.e = Long.valueOf(System.currentTimeMillis());
        r1.f = Long.valueOf(System.currentTimeMillis());
        r1.v = 1;
        r1.t = r9.category;
        tt5.a.h("DocsRustPreloadCacheBridge", "[rust_preload] store key=" + r9.key + ", resKey=" + r1.b + ", token=" + du5.b.g(r9.obj_token));
        return e0.m().w(r1);
    L23:
        if (Intrinsics.areEqual(r10, "SHEET_DATA_COMPLETE") == true) goto L36;
        if (StringsKt.endsWith$default(r10, "_SHEET_CLIENT_VARS", false, 2, null) == true) goto L36;
        if (StringsKt.endsWith$default(r10, "_SHEET_DATA_COMPLETE", false, 2, null) == true) goto L36;
        if (Intrinsics.areEqual(r10, "SLIDES_CLIENT_VARS") == false) goto L32;
    L35:
        r11 = e.m;
        goto L37
    L32:
        if (StringsKt.endsWith$default(r10, "_SLIDES_CLIENT_VARS", false, 2, null) == true) goto L35;
        r11 = e.o;
        goto L37
    L6:
        if (r2.equals("CLIENT_VARS") == false) goto L20;
        r2 = n35.a.a(r8, "docx");
        goto L20
    L9:
        if (r2.equals("SLIDES_CLIENT_VARS") == false) goto L20;
        r2 = n35.a.a(r8, "slides");
        goto L20
    L13:
        if (r2.equals("SHEET_CLIENT_VARS") == false) goto L20;
        r2 = n35.a.a(r8, "sheet");
        goto L20
    L17:
        if (r2.equals("SHEET_DATA_COMPLETE") == false) goto L20;
        r2 = r8.tenantId + '_' + r8.uid + '_' + r2;
        goto L20
    }
}
