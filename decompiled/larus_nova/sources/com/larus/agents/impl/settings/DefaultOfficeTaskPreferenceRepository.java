package com.larus.agents.impl.settings;

import com.larus.agents.api.OfficeTaskPreferenceSaveResult;
import com.larus.agents.impl.network.NetworkOfficeTaskPreferenceRemoteDataSource;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes24.dex */
public final class DefaultOfficeTaskPreferenceRepository implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f286707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f286708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<String> f286709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutexImpl f286710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutexImpl f286711e;

    public static final class a {
    }

    static {
    }

    public DefaultOfficeTaskPreferenceRepository(int r100) {
        KevaOfficeTaskPreferenceRepository r101 = new KevaOfficeTaskPreferenceRepository();
        NetworkOfficeTaskPreferenceRemoteDataSource r102 = new NetworkOfficeTaskPreferenceRemoteDataSource();
        Function0<String> r103 = new com.larus.agents.impl.settings.a();
        Intrinsics.checkNotNullParameter(r101, "local");
        Intrinsics.checkNotNullParameter(r102, "remote");
        Intrinsics.checkNotNullParameter(r103, "accountIdProvider");
        this.f286707a = r101;
        this.f286708b = r102;
        this.f286709c = r103;
        this.f286710d = kotlinx.coroutines.sync.b.a();
        this.f286711e = kotlinx.coroutines.sync.b.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v10, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v30, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    @Override // com.larus.agents.impl.settings.e
    public final Object a(Continuation<? super b> r110) {
        if ((r110 instanceof DefaultOfficeTaskPreferenceRepository$get$1) == false) goto L7;
        DefaultOfficeTaskPreferenceRepository$get$1 r100 = (DefaultOfficeTaskPreferenceRepository$get$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r103 = r100.label;
        switch(r103) {
            case 0: goto L30;
            case 1: goto L29;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L17;
            case 8: goto L12;
            default: goto L11;
        };
    L12:
        ?? r104 = (kotlinx.coroutines.sync.a) r100.L$1;
        b r105 = (b) r100.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L15
        r104 = r104;
    L67:
        if (r111 == OfficeTaskPreferenceSaveResult.SUCCESS) goto L69;
        FLogger.f375446a.w("DefaultOfficeTaskPreferenceRepo", "cache remote preference failed");     // Catch: Throwable -> L15
    L69:
        b r112 = r105;
        ?? r106 = r104;
    L71:
        r106.unlock(null);
        return r112;
    L15:
        th = th;
        r103 = r104;
    L73:
        r103.unlock(null);
        throw th;
    L17:
        long r107 = r100.J$0;
        kotlinx.coroutines.sync.a r108 = (kotlinx.coroutines.sync.a) r100.L$2;
        b r109 = (b) r100.L$1;
        String r113 = (String) r100.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L20
        r103 = r108;
    L57:
        r112 = (b) r111;     // Catch: Throwable -> L20
        r106 = r103;
        if (Intrinsics.areEqual(this.f286709c.invoke(), r113) == false) goto L71;
        if (r112.f286713b == r107) goto L62;
        r106 = r103;
        goto L71
    L62:
        e r114 = this.f286707a;     // Catch: Throwable -> L20
        String r115 = r109.f286712a;     // Catch: Throwable -> L20
        r100.L$0 = r109;     // Catch: Throwable -> L20
        r100.L$1 = r103;     // Catch: Throwable -> L20
        r100.L$2 = null;     // Catch: Throwable -> L20
        r100.label = 8;     // Catch: Throwable -> L20
        r111 = r114.b(r115, r100);     // Catch: Throwable -> L20
        if (r111 != r102) goto L65;
        return r102;
    L65:
        r104 = r103;
        r105 = r109;
        goto L67
    L22:
        r107 = r100.J$0;
        kotlinx.coroutines.sync.a r116 = (kotlinx.coroutines.sync.a) r100.L$2;
        r109 = (b) r100.L$1;
        r113 = (String) r100.L$0;
        ResultKt.throwOnFailure(r111);
        kotlinx.coroutines.sync.a r117 = r116;
    L54:
        e r118 = this.f286707a;     // Catch: Throwable -> L20
        r100.L$0 = r113;     // Catch: Throwable -> L20
        r100.L$1 = r109;     // Catch: Throwable -> L20
        r100.L$2 = r117;     // Catch: Throwable -> L20
        r100.J$0 = r107;     // Catch: Throwable -> L20
        r100.label = 7;     // Catch: Throwable -> L20
        r111 = r118.a(r100);     // Catch: Throwable -> L20
        r103 = r117;
        if (r111 != r102) goto L57;
        return r102;
    L23:
        ResultKt.throwOnFailure(r111);
    L49:
        return r111;
    L24:
        ResultKt.throwOnFailure(r111);
    L78:
        return r111;
    L25:
        r107 = r100.J$0;
        String r119 = (String) r100.L$0;
        ResultKt.throwOnFailure(r111);
        Object r120 = ((Result) r111).m9458unboximpl();
    L43:
        if (Result.m9452exceptionOrNullimpl(r120) != null) goto L75;
        r109 = (b) r120;
        int r121 = c.f286714a;
        if (c.a(r109.f286712a) == true) goto L50;
        FLogger.f375446a.w("DefaultOfficeTaskPreferenceRepo", "remote preference is too long, use local cache");
        e r122 = this.f286707a;
        r100.L$0 = null;
        r100.label = 5;
        r111 = r122.a(r100);
        if (r111 != r102) goto L49;
        return r102;
    L50:
        MutexImpl r123 = this.f286710d;
        r100.L$0 = r119;
        r100.L$1 = r109;
        r100.L$2 = r123;
        r100.J$0 = r107;
        r100.label = 6;
        if (r123.a(null, r100) != r102) goto L53;
        return r102;
    L53:
        r113 = r119;
        r117 = r123;
        goto L54
    L75:
        FLogger.f375446a.w("DefaultOfficeTaskPreferenceRepo", "fetch remote preference failed, use local cache");
        e r124 = this.f286707a;
        r100.L$0 = null;
        r100.label = 4;
        r111 = r124.a(r100);
        if (r111 != r102) goto L78;
        return r102;
    L26:
        kotlinx.coroutines.sync.a r125 = (kotlinx.coroutines.sync.a) r100.L$1;
        String r126 = (String) r100.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L79
        r103 = r125;
    L37:
        long r127 = ((b) r111).f286713b;     // Catch: Throwable -> L79
        r103.unlock(null);
        d r128 = this.f286708b;
        r100.L$0 = r126;
        r100.L$1 = null;
        r100.J$0 = r127;
        r100.label = 3;
        r120 = r128.a(r100);
        if (r120 != r102) goto L41;
        return r102;
    L41:
        r119 = r126;
        r107 = r127;
        goto L43
    L29:
        kotlinx.coroutines.sync.a r129 = (kotlinx.coroutines.sync.a) r100.L$1;
        r126 = (String) r100.L$0;
        ResultKt.throwOnFailure(r111);
        kotlinx.coroutines.sync.a r130 = r129;
    L34:
        e r131 = this.f286707a;     // Catch: Throwable -> L79
        r100.L$0 = r126;     // Catch: Throwable -> L79
        r100.L$1 = r130;     // Catch: Throwable -> L79
        r100.label = 2;     // Catch: Throwable -> L79
        r111 = r131.a(r100);     // Catch: Throwable -> L79
        r103 = r130;
        if (r111 != r102) goto L37;
        return r102;
    L30:
        ResultKt.throwOnFailure(r111);
        r126 = this.f286709c.invoke();
        MutexImpl r132 = this.f286710d;
        r100.L$0 = r126;
        r100.L$1 = r132;
        r100.label = 1;
        if (r132.a(null, r100) != r102) goto L33;
        return r102;
    L33:
        r130 = r132;
        goto L34
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        th = th;
    L79:
        th = move-exception;
        r103.unlock(null);
        throw th;
    L7:
        r100 = new DefaultOfficeTaskPreferenceRepository$get$1(this, r110);
        goto L8
    }

    @Override // com.larus.agents.impl.settings.e
    public final Object b(String r110, Continuation<? super OfficeTaskPreferenceSaveResult> r111) {
        if ((r111 instanceof DefaultOfficeTaskPreferenceRepository$save$1) == false) goto L7;
        DefaultOfficeTaskPreferenceRepository$save$1 r100 = (DefaultOfficeTaskPreferenceRepository$save$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L30;
        if (r104 == 1) goto L29;
        if (r104 == 2) goto L24;
        if (r104 == 3) goto L21;
        if (r104 != 4) goto L20;
        kotlinx.coroutines.sync.a r105 = (kotlinx.coroutines.sync.a) r100.L$1;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L17
    L57:
        if (r102 == OfficeTaskPreferenceSaveResult.SUCCESS) goto L59;
        FLogger.f375446a.w("DefaultOfficeTaskPreferenceRepo", "cache uploaded preference failed");     // Catch: Throwable -> L17
    L59:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L17
        r105.unlock(null);     // Catch: Throwable -> L64
        OfficeTaskPreferenceSaveResult r108 = OfficeTaskPreferenceSaveResult.SUCCESS;     // Catch: Throwable -> L64
        kotlinx.coroutines.sync.a r109 = r106;
    L62:
        r109.unlock(null);
        return r108;
    L64:
        th = th;
    L75:
        r106.unlock(null);
        throw th;
    L17:
        th = th;
        kotlinx.coroutines.sync.a r112 = r106;
    L68:
        r105.unlock(null);     // Catch: Throwable -> L70
        throw th;     // Catch: Throwable -> L70
    L70:
        th = th;
    L74:
        r106 = r112;
        goto L75
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        r105 = (kotlinx.coroutines.sync.a) r100.L$3;
        String r113 = (String) r100.L$2;
        r112 = (kotlinx.coroutines.sync.a) r100.L$1;
        String r114 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L70
    L77:
    L67:
        th = th;
        goto L68
    L50:
        if (Intrinsics.areEqual(this.f286709c.invoke(), r113) == true) goto L52;
        FLogger.f375446a.w("DefaultOfficeTaskPreferenceRepo", "account changed before caching uploaded preference");     // Catch: Throwable -> L67
        r106 = r112;
        goto L59
    L52:
        e r115 = this.f286707a;     // Catch: Throwable -> L67
        r100.L$0 = r112;     // Catch: Throwable -> L67
        r100.L$1 = r105;     // Catch: Throwable -> L67
        r100.L$2 = null;     // Catch: Throwable -> L67
        r100.L$3 = null;     // Catch: Throwable -> L67
        r100.label = 4;     // Catch: Throwable -> L67
        r102 = r115.b(r114, r100);     // Catch: Throwable -> L67
        if (r102 != r103) goto L55;
        return r103;
    L55:
        r106 = r112;
        goto L57
    L24:
        r113 = (String) r100.L$2;
        r109 = (kotlinx.coroutines.sync.a) r100.L$1;
        String r116 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L27
    L42:
        r108 = (OfficeTaskPreferenceSaveResult) r102;     // Catch: Throwable -> L27
        if (r108 == OfficeTaskPreferenceSaveResult.SUCCESS) goto L45;
        FLogger.f375446a.w("DefaultOfficeTaskPreferenceRepo", "upload remote preference failed, result=" + r108);     // Catch: Throwable -> L27
        goto L62
    L45:
        r105 = this.f286710d;     // Catch: Throwable -> L27
        r100.L$0 = r116;     // Catch: Throwable -> L27
        r100.L$1 = r109;     // Catch: Throwable -> L27
        r100.L$2 = r113;     // Catch: Throwable -> L27
        r100.L$3 = r105;     // Catch: Throwable -> L27
        r100.label = 3;     // Catch: Throwable -> L27
        if (r105.a(null, r100) != r103) goto L48;
        return r103;
    L48:
        r112 = r109;
        r114 = r116;
    L27:
        th = th;
        r112 = r109;
        goto L74
    L29:
        kotlinx.coroutines.sync.a r117 = (kotlinx.coroutines.sync.a) r100.L$1;
        String r118 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        kotlinx.coroutines.sync.a r119 = r117;
        String r120 = r118;
    L83:
        String r121 = this.f286709c.invoke();     // Catch: Throwable -> L72
        d r122 = this.f286708b;     // Catch: Throwable -> L72
        b r123 = new b(r120, 0);     // Catch: Throwable -> L72
        r100.L$0 = r120;     // Catch: Throwable -> L72
        r100.L$1 = r119;     // Catch: Throwable -> L72
        r100.L$2 = r121;     // Catch: Throwable -> L72
        r100.label = 2;     // Catch: Throwable -> L72
        Object r124 = r122.b(r123, r100);     // Catch: Throwable -> L72
        if (r124 != r103) goto L41;
        return r103;
    L41:
        String r125 = r120;
        r113 = r121;
        r102 = r124;
        r109 = r119;
        r116 = r125;
    L72:
        th = th;
        r112 = r119;
        goto L74
    L30:
        ResultKt.throwOnFailure(r102);
        if (c.a(r110) == false) goto L33;
        MutexImpl r126 = this.f286711e;
        r120 = r110;
        r100.L$0 = r120;
        r100.L$1 = r126;
        r100.label = 1;
        if (r126.a(null, r100) != r103) goto L37;
        return r103;
    L37:
        r119 = r126;
        goto L83
    L33:
        return OfficeTaskPreferenceSaveResult.MAX_CHARACTER_LIMIT_EXCEEDED;
    L7:
        r100 = new DefaultOfficeTaskPreferenceRepository$save$1(this, r111);
        goto L8
    }
}
