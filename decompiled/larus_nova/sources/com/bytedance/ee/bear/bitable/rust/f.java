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

/* JADX INFO: loaded from: classes16.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f215276a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f215277a = null;

        static {
            int[] r100 = new int[BitableCacheDocumentType.values().length];
            r100[BitableCacheDocumentType.Main.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[BitableCacheDocumentType.Record.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[BitableCacheDocumentType.AddRecord.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f215277a = r100;
        }
    }

    static {
        f215276a = new f();
    }

    public f() {
    }

    @Override // com.bytedance.ee.bear.bitable.rust.e
    public final d a(String r210, BitableCacheDocumentType r211, String r212) {
        Intrinsics.checkNotNullParameter(r210, "token");
        Intrinsics.checkNotNullParameter(r211, "documentType");
        Intrinsics.checkNotNullParameter(r212, "url");
        boolean r100 = true;
        int r101 = 0;
        if (r210.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L10;
        tt5.a.h("BitablePreloadRustBridge", "getCacheResource skipped, scene=" + r211 + ", token is empty");
        return new d(null, null, null, null, BitableCacheBlockType.Unsupported, null, null);
    L10:
        long r103 = System.currentTimeMillis();
        tt5.a.h("BitablePreloadRustBridge", "getCacheResource start, scene=" + r211);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L67
        ULong r105 = UStringsKt.toULongOrNull(com.bytedance.ee.bear.contract.a.a().docDynamicConfig().f216922f.f216928a);     // Catch: Throwable -> L67
        if (r105 == null) goto L65;
        k r106 = new k(r105.m9675unboximpl());     // Catch: Throwable -> L67
        int r107 = a.f215277a[r211.ordinal()];     // Catch: Throwable -> L67
        if (r107 != 1) goto L16;
        BitableDocumentType r108 = BitableDocumentType.Main;     // Catch: Throwable -> L67
    L24:
        r0 r109 = r106.c(r210, r108, r212);     // Catch: Throwable -> L67
        Integer r110 = r109.f253111f;     // Catch: Throwable -> L67
        BitableCacheBlockType.Companion.getClass();     // Catch: Throwable -> L67
        BitableCacheBlockType[] r111 = BitableCacheBlockType.values();     // Catch: Throwable -> L67
        int r112 = r111.length;     // Catch: Throwable -> L67
        int r113 = 0;
    L25:
        if (r113 >= r112) goto L36;
        BitableCacheBlockType r114 = r111[r113];     // Catch: Throwable -> L67
        int r115 = r114.getRustValue();     // Catch: Throwable -> L67
        if (r110 != null) goto L30;
    L32:
        boolean r116 = false;
    L33:
        if (r116 == true) goto L37;
        r113 = r113 + 1;     // Catch: Throwable -> L67
    L37:
        if (r114 != null) goto L39;
        r114 = BitableCacheBlockType.Unsupported;     // Catch: Throwable -> L67
    L39:
        d r117 = new d(r109.f253107b, r109.f253108c, r109.f253109d, r109.f253110e, r114, r109.f253112g, r109.f253113h);     // Catch: Throwable -> L67
        StringBuilder r118 = new StringBuilder();     // Catch: Throwable -> L67
        r118.append("getCacheResource success, scene=");     // Catch: Throwable -> L67
        r118.append(r211);     // Catch: Throwable -> L67
        r118.append(", cost=");     // Catch: Throwable -> L67
        r118.append(System.currentTimeMillis() - r103);     // Catch: Throwable -> L67
        r118.append(", firstBlock=");     // Catch: Throwable -> L67
        String r119 = r117.f215269a;     // Catch: Throwable -> L67
        if (r119 != null) goto L42;
    L45:
        boolean r120 = true;
    L46:
        if (r120 == false) goto L49;
        r100 = false;
    L49:
        r118.append(r100);     // Catch: Throwable -> L67
        r118.append(", blockType=");     // Catch: Throwable -> L67
        r118.append(r114);     // Catch: Throwable -> L67
        r118.append(", rustBlockType=");     // Catch: Throwable -> L67
        r118.append(r110);     // Catch: Throwable -> L67
        r118.append(", clientVars=");     // Catch: Throwable -> L67
        String r121 = r117.f215271c;     // Catch: Throwable -> L67
        if (r121 == null) goto L52;
        int r122 = r121.length();     // Catch: Throwable -> L67
    L53:
        r118.append(r122);     // Catch: Throwable -> L67
        r118.append(", mainPage=");     // Catch: Throwable -> L67
        String r123 = r117.f215272d;     // Catch: Throwable -> L67
        if (r123 == null) goto L56;
        int r124 = r123.length();     // Catch: Throwable -> L67
    L57:
        r118.append(r124);     // Catch: Throwable -> L67
        r118.append(", recordData=");     // Catch: Throwable -> L67
        String r125 = r117.f215274f;     // Catch: Throwable -> L67
        if (r125 == null) goto L60;
        int r126 = r125.length();     // Catch: Throwable -> L67
    L61:
        r118.append(r126);     // Catch: Throwable -> L67
        r118.append(", addRecordPage=");     // Catch: Throwable -> L67
        String r127 = r117.f215275g;     // Catch: Throwable -> L67
        if (r127 == null) goto L64;
        r101 = r127.length();     // Catch: Throwable -> L67
    L64:
        r118.append(r101);     // Catch: Throwable -> L67
        tt5.a.h("BitablePreloadRustBridge", r118.toString());     // Catch: Throwable -> L67
        Object r128 = Result.m9449constructorimpl(r117);     // Catch: Throwable -> L67
    L69:
        Throwable r129 = Result.m9452exceptionOrNullimpl(r128);
        if (r129 == null) goto L73;
        tt5.a.l("BitablePreloadRustBridge", "getCacheResource failed, scene=" + r211 + ", cost=" + (System.currentTimeMillis() - r103) + ", error=" + r129.getClass().getSimpleName(), r129);
    L73:
        if (Result.m9452exceptionOrNullimpl(r128) == null) goto L77;
        f215276a.getClass();
        r128 = new d(null, null, null, null, BitableCacheBlockType.Unsupported, null, null);
    L77:
        return (d) r128;
    L60:
        r126 = 0;
        goto L61
    L56:
        r124 = 0;
        goto L57
    L52:
        r122 = 0;
        goto L53
    L42:
        if (r119.length() == 0) goto L45;
        r120 = false;
        goto L46
    L30:
        if (r115 != r110.intValue()) goto L32;
        r116 = true;
        goto L33
    L36:
        r114 = null;
        goto L37
    L16:
        if (r107 != 2) goto L18;
        r108 = BitableDocumentType.Record;     // Catch: Throwable -> L67
        goto L24
    L18:
        if (r107 != 3) goto L21;
        r108 = BitableDocumentType.AddRecord;     // Catch: Throwable -> L67
        goto L24
    L21:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L67
    L65:
        tt5.a.h("BitablePreloadRustBridge", "getCacheResource skipped, scene=" + r211 + ", userId is invalid");     // Catch: Throwable -> L67
        return new d(null, null, null, null, BitableCacheBlockType.Unsupported, null, null);
    L67:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L69
    L5:
        r102 = false;
        goto L7
    }
}
