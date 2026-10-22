package com.bytedance.ee.bear.bitable.rust;

import com.bytedance.ee.bear.bitable.chameleon.render.cache.BitableCacheBlockType;
import com.bytedance.lark.lark_bitable_android.BitableDocumentType;
import com.bytedance.lark.lark_bitable_android.k;
import com.bytedance.lark.lark_bitable_android.r0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements e {
    public static final f a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BitableCacheDocumentType.values().length];
            r0[BitableCacheDocumentType.Main.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[BitableCacheDocumentType.Record.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[BitableCacheDocumentType.AddRecord.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        a = new f();
    }

    public f() {
    }

    @Override // com.bytedance.ee.bear.bitable.rust.e
    public final d a(String r22, BitableCacheDocumentType r23, String r24) {
        Intrinsics.checkNotNullParameter(r22, "token");
        Intrinsics.checkNotNullParameter(r23, "documentType");
        Intrinsics.checkNotNullParameter(r24, "url");
        boolean r5 = true;
        int r6 = 0;
        if (r22.length() != 0) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L10;
        tt5.a.h("BitablePreloadRustBridge", "getCacheResource skipped, scene=" + r23 + ", token is empty");
        return new d(null, null, null, null, BitableCacheBlockType.Unsupported, null, null);
    L10:
        long r9 = System.currentTimeMillis();
        tt5.a.h("BitablePreloadRustBridge", "getCacheResource start, scene=" + r23);
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L67
        ULong r8 = UStringsKt.toULongOrNull(com.bytedance.ee.bear.contract.a.a().docDynamicConfig().f.a);     // Catch: Throwable -> L67
        if (r8 == null) goto L65;
        k r10 = new k(r8.unbox-impl());     // Catch: Throwable -> L67
        int r11 = a.a[r23.ordinal()];     // Catch: Throwable -> L67
        if (r11 != 1) goto L16;
        BitableDocumentType r12 = BitableDocumentType.Main;     // Catch: Throwable -> L67
    L24:
        r0 r0 = r10.c(r22, r12, r24);     // Catch: Throwable -> L67
        Integer r2 = r0.f;     // Catch: Throwable -> L67
        BitableCacheBlockType.Companion.getClass();     // Catch: Throwable -> L67
        BitableCacheBlockType[] r13 = BitableCacheBlockType.values();     // Catch: Throwable -> L67
        int r14 = r13.length;     // Catch: Throwable -> L67
        int r16 = 0;
    L25:
        if (r16 >= r14) goto L36;
        BitableCacheBlockType r17 = r13[r16];     // Catch: Throwable -> L67
        int r18 = r17.getRustValue();     // Catch: Throwable -> L67
        if (r2 != null) goto L30;
    L32:
        boolean r19 = false;
    L33:
        if (r19 == true) goto L37;
        r16 = r16 + 1;     // Catch: Throwable -> L67
    L37:
        if (r17 != null) goto L39;
        r17 = BitableCacheBlockType.Unsupported;     // Catch: Throwable -> L67
    L39:
        d r20 = new d(r0.b, r0.c, r0.d, r0.e, r17, r0.g, r0.h);     // Catch: Throwable -> L67
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L67
        r1.append("getCacheResource success, scene=");     // Catch: Throwable -> L67
        r1.append(r23);     // Catch: Throwable -> L67
        r1.append(", cost=");     // Catch: Throwable -> L67
        r1.append(System.currentTimeMillis() - r9);     // Catch: Throwable -> L67
        r1.append(", firstBlock=");     // Catch: Throwable -> L67
        String r21 = r20.a;     // Catch: Throwable -> L67
        if (r21 != null) goto L42;
    L45:
        boolean r26 = true;
    L46:
        if (r26 == false) goto L49;
        r5 = false;
    L49:
        r1.append(r5);     // Catch: Throwable -> L67
        r1.append(", blockType=");     // Catch: Throwable -> L67
        r1.append(r17);     // Catch: Throwable -> L67
        r1.append(", rustBlockType=");     // Catch: Throwable -> L67
        r1.append(r2);     // Catch: Throwable -> L67
        r1.append(", clientVars=");     // Catch: Throwable -> L67
        String r3 = r20.c;     // Catch: Throwable -> L67
        if (r3 == null) goto L52;
        int r27 = r3.length();     // Catch: Throwable -> L67
    L53:
        r1.append(r27);     // Catch: Throwable -> L67
        r1.append(", mainPage=");     // Catch: Throwable -> L67
        String r28 = r20.d;     // Catch: Throwable -> L67
        if (r28 == null) goto L56;
        int r29 = r28.length();     // Catch: Throwable -> L67
    L57:
        r1.append(r29);     // Catch: Throwable -> L67
        r1.append(", recordData=");     // Catch: Throwable -> L67
        String r30 = r20.f;     // Catch: Throwable -> L67
        if (r30 == null) goto L60;
        int r31 = r30.length();     // Catch: Throwable -> L67
    L61:
        r1.append(r31);     // Catch: Throwable -> L67
        r1.append(", addRecordPage=");     // Catch: Throwable -> L67
        String r32 = r20.g;     // Catch: Throwable -> L67
        if (r32 == null) goto L64;
        r6 = r32.length();     // Catch: Throwable -> L67
    L64:
        r1.append(r6);     // Catch: Throwable -> L67
        tt5.a.h("BitablePreloadRustBridge", r1.toString());     // Catch: Throwable -> L67
        Object r33 = Result.constructor-impl(r20);     // Catch: Throwable -> L67
    L69:
        Throwable r34 = Result.exceptionOrNull-impl(r33);
        if (r34 == null) goto L73;
        tt5.a.l("BitablePreloadRustBridge", "getCacheResource failed, scene=" + r23 + ", cost=" + (System.currentTimeMillis() - r9) + ", error=" + r34.getClass().getSimpleName(), r34);
    L73:
        if (Result.exceptionOrNull-impl(r33) == null) goto L77;
        a.getClass();
        r33 = new d(null, null, null, null, BitableCacheBlockType.Unsupported, null, null);
    L77:
        return (d) r33;
    L60:
        r31 = 0;
        goto L61
    L56:
        r29 = 0;
        goto L57
    L52:
        r27 = 0;
        goto L53
    L42:
        if (r21.length() == 0) goto L45;
        r26 = false;
        goto L46
    L30:
        if (r18 != r2.intValue()) goto L32;
        r19 = true;
        goto L33
    L36:
        r17 = null;
        goto L37
    L16:
        if (r11 != 2) goto L18;
        r12 = BitableDocumentType.Record;     // Catch: Throwable -> L67
        goto L24
    L18:
        if (r11 != 3) goto L21;
        r12 = BitableDocumentType.AddRecord;     // Catch: Throwable -> L67
        goto L24
    L21:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L67
    L65:
        tt5.a.h("BitablePreloadRustBridge", "getCacheResource skipped, scene=" + r23 + ", userId is invalid");     // Catch: Throwable -> L67
        return new d(null, null, null, null, BitableCacheBlockType.Unsupported, null, null);
    L67:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r33 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L69
    L5:
        r4 = false;
        goto L7
    }
}
