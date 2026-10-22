package com.bytedance.kmp.performance.api;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import md6.f1;

/* JADX INFO: loaded from: classes19.dex */
public final class DumpUpload {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DumpUpload f252580a = null;

    static {
        f252580a = new DumpUpload();
    }

    public DumpUpload() {
    }

    public final Object a(f1 r210, final com.bytedance.kmp.performance.r r211, gb6.c r212, Continuation<? super Unit> r213) {
        if ((r213 instanceof DumpUpload$uploadDumpFileLocked$1) == false) goto L7;
        DumpUpload$uploadDumpFileLocked$1 r100 = (DumpUpload$uploadDumpFileLocked$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DumpUpload$uploadDumpFileLocked$1 r110 = r100;
        Object r102 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r110.label;
        String r104 = "last_upload_timestamp";
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        gb6.c r105 = (gb6.c) r110.L$0;
        ResultKt.throwOnFailure(r102);
        r104 = "last_upload_timestamp";
    L57:
        r r106 = (r) r102;
        gb6.c r107 = r105;
    L58:
        ld6.a.a(ld6.b.f508697a, new e());
        r107.storeLong(r104, com.bytedance.kmp.performance.utils.c.b());
    L60:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        f r108 = (f) r110.L$1;
        r107 = (gb6.c) r110.L$0;
        ResultKt.throwOnFailure(r102);
        Object r112 = r111;
    L52:
        if (((String) r102) == null) goto L58;
        r110.L$0 = r107;
        r110.L$1 = null;
        r110.label = 2;
        r102 = r108.g3();
        Object r109 = r112;
        if (r102 != r109) goto L56;
        return r109;
    L56:
        r105 = r107;
        goto L57
    L16:
        ResultKt.throwOnFailure(r102);
        Intrinsics.checkNotNullParameter(r210, "memoryInfo");
        Intrinsics.checkNotNullParameter(r211, "config");
        boolean r113 = false;
        if (r211.f252826a == false) goto L24;
        Intrinsics.checkNotNullParameter(r210, "memoryInfo");
        long r114 = 1024;
        if (((r210.f513338m / r114) / r114) < r211.f252827b) goto L21;
        boolean r115 = true;
    L22:
        if (r115 == false) goto L24;
        r113 = true;
        goto L24
    L21:
        r115 = false;
    L24:
        if (r113 == false) goto L26;
        pd6.b r116 = pd6.c.f528682a;
        f r117 = (f) pd6.c.a(Reflection.getOrCreateKotlinClass(f.class));
        if (r117 == null) goto L30;
        o96.b r118 = (o96.b) pd6.c.a(Reflection.getOrCreateKotlinClass(o96.b.class));
        if (r118 == null) goto L34;
        if (r212 == null) goto L37;
        Intrinsics.checkNotNullParameter(r210, "memoryInfo");
        long r119 = 1024;
        final long r120 = (r210.f513338m / r119) / r119;
        String r121 = r118.getUpdateVersionCode();
        final long r122 = r212.getLong("last_upload_timestamp", -1);
        r112 = r111;
        final long r123 = (com.bytedance.kmp.performance.utils.c.b() - r122) / ((long) 60000);
        ld6.a r124 = ld6.b.f508697a;
        ld6.a.a(r124, new c(r122, r120, r123, r211));
        if (r123 <= r211.f252828c) goto L60;
        if (Intrinsics.areEqual(r121, r212.getString("update_version_code", "")) == true) goto L44;
        r212.storeString("update_version_code", r121);
        r212.storeLong("app_version_update_timestamp", com.bytedance.kmp.performance.utils.c.b());
    L44:
        if ((com.bytedance.kmp.performance.utils.c.b() - r212.getLong("app_version_update_timestamp", com.bytedance.kmp.performance.utils.c.b())) > 604800000) goto L46;
        ld6.a.a(r124, new d());
        r110.L$0 = r212;
        r110.L$1 = r117;
        r110.label = 1;
        if (r112 != null) goto L50;
        return r112;
    L50:
        r108 = r117;
        r107 = r212;
        r102 = null;
        goto L52
    L46:
        return Unit.INSTANCE;
    L37:
        return Unit.INSTANCE;
    L34:
        return Unit.INSTANCE;
    L30:
        return Unit.INSTANCE;
    L26:
        return Unit.INSTANCE;
    L7:
        r100 = new DumpUpload$uploadDumpFileLocked$1(this, r213);
        goto L8
    }
}
