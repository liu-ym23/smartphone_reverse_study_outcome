package com.larus.avlink.aiproactive.repo;

import b49.i;
import b49.j;
import com.larus.avlink.aiproactive.api.AiProactiveTaskApi;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.HealthService;
import com.larus.network.bean.BizResponse;
import com.larus.settings.value.e10;
import com.larus.settings.value.y6;
import com.larus.utils.l0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import dm9.a;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import nu9.c;
import t88.e;
import t88.g;
import t88.h;
import t88.l;
import t88.m;
import t88.n;
import t88.o;

/* JADX INFO: loaded from: classes23.dex */
public final class AiProactiveTaskRepository {
    public AiProactiveTaskRepository() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.larus.dora.api.IDoraService$f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [com.larus.dora.api.IDoraService$f] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v14, types: [com.larus.dora.api.IDoraService$f] */
    /* JADX WARN: Type inference failed for: r8v16, types: [com.larus.dora.api.IDoraService$f] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [com.larus.dora.api.IDoraService$f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final Object b(Continuation<? super l> r110) {
        if ((r110 instanceof AiProactiveTaskRepository$createImuCapability$1) == false) goto L7;
        AiProactiveTaskRepository$createImuCapability$1 r100 = (AiProactiveTaskRepository$createImuCapability$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r104 = r100.label;
        Integer r111 = null;
        if (r104 == 0) goto L34;
        if (r104 == 1) goto L31;
        if (r104 == 2) goto L26;
        if (r104 == 3) goto L21;
        if (r104 != 4) goto L20;
        boolean r105 = r100.Z$1;
        boolean r106 = r100.Z$0;
        j r107 = (j) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L17
    L83:
        Object r108 = Result.m9449constructorimpl((i) r102);     // Catch: Throwable -> L17
        j r109 = r107;
        boolean r112 = r105;
    L89:
        if (Result.m9455isFailureimpl(r108) == false) goto L91;
        r108 = null;
    L91:
        i r113 = (i) r108;
        boolean r114 = r112;
    L93:
        if (r106 == true) goto L97;
        if (r114 == true) goto L97;
        return null;
    L97:
        if (r109 == null) goto L99;
        Integer r115 = Boxing.boxInt(r109.f17681b);
    L100:
        if (r109 == null) goto L102;
        Integer r116 = Boxing.boxInt(r109.f17682c);
    L103:
        if (r113 == null) goto L105;
        Integer r117 = Boxing.boxInt(r113.f17678b);
    L106:
        if (r113 == null) goto L109;
        r111 = Boxing.boxInt(r113.f17679c);
    L109:
        return new l(true, r115, r116, r114, r117, r111);
    L105:
        r117 = null;
        goto L106
    L102:
        r116 = null;
        goto L103
    L99:
        r115 = null;
    L17:
        th = th;
        r109 = r107;
        r112 = r105;
    L87:
        Result.Companion r118 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L89
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        r106 = r100.Z$0;
        r109 = (j) r100.L$1;
        ?? r119 = (IDoraService.f) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L24
        r119 = r119;
    L69:
        Object r120 = Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r102).booleanValue()));     // Catch: Throwable -> L24
        ?? r121 = r119;
    L74:
        Boolean r122 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r120) == false) goto L77;
        r120 = r122;
    L77:
        r112 = ((Boolean) r120).booleanValue();
        if (r112 == true) goto L121;
        r114 = r112;
        r113 = null;
        goto L93
    L121:
        r100.L$0 = r109;     // Catch: Throwable -> L86
        r100.L$1 = null;     // Catch: Throwable -> L86
        r100.Z$0 = r106;     // Catch: Throwable -> L86
        r100.Z$1 = r112;     // Catch: Throwable -> L86
        r100.label = 4;     // Catch: Throwable -> L86
        r102 = r121.e(r100);     // Catch: Throwable -> L86
        if (r102 != r103) goto L82;
        return r103;
    L82:
        r105 = r112;
        r107 = r109;
    L86:
        th = th;
    L24:
        th = th;
        boolean r123 = r106;
        j r124 = r109;
    L73:
        Result.Companion r125 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r109 = r124;
        r106 = r123;
        r121 = r119;
        goto L74
    L26:
        boolean r126 = r100.Z$0;
        ?? r127 = (IDoraService.f) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L29
        r127 = r127;
    L55:
        Object r128 = Result.m9449constructorimpl((j) r102);     // Catch: Throwable -> L29
        r123 = r126;
        ?? r129 = r127;
    L61:
        if (Result.m9455isFailureimpl(r128) == false) goto L63;
        r128 = null;
    L63:
        r124 = (j) r128;
        r119 = r129;
    L123:
        r100.L$0 = r119;     // Catch: Throwable -> L72
        r100.L$1 = r124;     // Catch: Throwable -> L72
        r100.Z$0 = r123;     // Catch: Throwable -> L72
        r100.label = 3;     // Catch: Throwable -> L72
        r102 = r119.f(r100);     // Catch: Throwable -> L72
        if (r102 != r103) goto L68;
        return r103;
    L68:
        r109 = r124;
        r106 = r123;
        r119 = r119;
    L72:
        th = th;
    L29:
        th = th;
        r123 = r126;
        ?? r130 = r127;
    L59:
        Result.Companion r131 = Result.Companion;
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r129 = r130;
        goto L61
    L31:
        IDoraService.f r132 = (IDoraService.f) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L44
        r104 = r132;
    L42:
        Object r133 = Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r102).booleanValue()));     // Catch: Throwable -> L44
        r130 = r104;
    L46:
        Boolean r134 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r133) == false) goto L49;
        r133 = r134;
    L49:
        r123 = ((Boolean) r133).booleanValue();
        if (r123 == true) goto L111;
        r119 = r130;
        r124 = null;
        goto L123
    L111:
        r100.L$0 = r130;     // Catch: Throwable -> L58
        r100.Z$0 = r123;     // Catch: Throwable -> L58
        r100.label = 2;     // Catch: Throwable -> L58
        r102 = r130.b(r100);     // Catch: Throwable -> L58
        if (r102 != r103) goto L54;
        return r103;
    L54:
        r127 = r130;
        r126 = r123;
    L58:
        th = th;
        goto L59
    L34:
        ResultKt.throwOnFailure(r102);
        IDoraService r135 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r135 == null) goto L110;
        HealthService r136 = r135.w();
        if (r136 == null) goto L110;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L44
        r100.L$0 = r136;     // Catch: Throwable -> L44
        r100.label = 1;     // Catch: Throwable -> L44
        r102 = r136.i();     // Catch: Throwable -> L44
        r104 = r136;
        if (r102 != r103) goto L42;
        return r103;
    L110:
        return null;
    L44:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r130 = r104;
    L7:
        r100 = new AiProactiveTaskRepository$createImuCapability$1(this, r110);
        goto L8
    }

    public final Object f(Continuation<? super Result<? extends List<n>>> r100) {
        if ((r100 instanceof AiProactiveTaskRepository$getTaskList$1) == false) goto L7;
        AiProactiveTaskRepository$getTaskList$1 r101 = (AiProactiveTaskRepository$getTaskList$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        List r106 = null;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L20:
        a r107 = (a) r103;
        if ((r107 instanceof a.b) == false) goto L37;
        BizResponse<T> r108 = ((a.b) r107).f469231a;
        if (r108.isSuccess() == false) goto L32;
        Result.Companion r109 = Result.Companion;
        t88.j r110 = (t88.j) r108.getData();
        if (r110 == null) goto L29;
        List<n> r111 = r110.a();
        if (r111 == null) goto L29;
        r106 = CollectionsKt.filterNotNull(r111);
    L29:
        if (r106 != null) goto L45;
        r106 = CollectionsKt.emptyList();
    L45:
        return Result.m9449constructorimpl(r106);
    L32:
        Result.Companion r112 = Result.Companion;
        String r113 = r108.getMsg();
        if (r113 != null) goto L46;
        r113 = "server error: " + r108.getCode();
    L46:
        return Result.m9449constructorimpl(ResultKt.createFailure(new RuntimeException(r113)));
    L37:
        if ((r107 instanceof a.C5690a) == false) goto L44;
        Result.Companion r114 = Result.Companion;
        a.C5690a r115 = (a.C5690a) r107;
        Throwable r116 = r115.f469230c;
        if (r116 != null) goto L42;
        r116 = new RuntimeException(r115.f469229b);
    L42:
        return Result.m9449constructorimpl(ResultKt.createFailure(r116));
    L44:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        e10 r117 = e10.f368561a;
        int r118 = l0.f375430a;
        int r119 = 0;
        Integer r120 = ((c) l0.a(new c(0), new y6())).a();
        if (r120 == null) goto L17;
        r119 = r120.intValue();
    L17:
        t88.i r121 = new t88.i(Boxing.boxInt(r119), 1);
        AiProactiveTaskApi.a r122 = AiProactiveTaskApi.f291553a;
        AiProactiveTaskRepository$getTaskList$result$1 r123 = new AiProactiveTaskRepository$getTaskList$result$1(r121, null);
        r101.label = 1;
        r122.getClass();
        r103 = AiProactiveTaskApi.a.a(r123, r101);
        if (r103 != r104) goto L20;
        return r104;
    L7:
        r101 = new AiProactiveTaskRepository$getTaskList$1(this, r100);
        goto L8
    }

    public final Object d(long r100, Continuation<? super Result<Unit>> r101) {
        if ((r101 instanceof AiProactiveTaskRepository$deleteTask$1) == false) goto L7;
        AiProactiveTaskRepository$deleteTask$1 r102 = (AiProactiveTaskRepository$deleteTask$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        a r107 = (a) r104;
        if ((r107 instanceof a.b) == false) goto L27;
        BizResponse<T> r108 = ((a.b) r107).f469231a;
        if (r108.isSuccess() == false) goto L22;
        Result.Companion r109 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L22:
        Result.Companion r110 = Result.Companion;
        String r111 = r108.getMsg();
        if (r111 != null) goto L36;
        r111 = "server error: " + r108.getCode();
    L36:
        return Result.m9449constructorimpl(ResultKt.createFailure(new RuntimeException(r111)));
    L27:
        if ((r107 instanceof a.C5690a) == false) goto L34;
        Result.Companion r112 = Result.Companion;
        a.C5690a r113 = (a.C5690a) r107;
        Throwable r114 = r113.f469230c;
        if (r114 != null) goto L32;
        r114 = new RuntimeException(r113.f469229b);
    L32:
        return Result.m9449constructorimpl(ResultKt.createFailure(r114));
    L34:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        g r115 = new g(r100, 1);
        AiProactiveTaskApi.a r116 = AiProactiveTaskApi.f291553a;
        AiProactiveTaskRepository$deleteTask$result$1 r117 = new AiProactiveTaskRepository$deleteTask$result$1(r115, null);
        r102.label = 1;
        r116.getClass();
        r104 = AiProactiveTaskApi.a.a(r117, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new AiProactiveTaskRepository$deleteTask$1(this, r101);
        goto L8
    }

    public final Object g(String r100, Continuation<? super Result<o>> r101) {
        if ((r101 instanceof AiProactiveTaskRepository$parseUserAonTaskDraft$1) == false) goto L7;
        AiProactiveTaskRepository$parseUserAonTaskDraft$1 r102 = (AiProactiveTaskRepository$parseUserAonTaskDraft$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L22:
        a r107 = (a) r104;
        if ((r107 instanceof a.b) == false) goto L30;
        BizResponse<T> r108 = ((a.b) r107).f469231a;
        o r109 = (o) r108.getData();
        if (r108.isSuccess() == false) goto L28;
        if (r109 == null) goto L28;
        return Result.m9449constructorimpl(r109);
    L28:
        Result.Companion r110 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new AiProactiveTaskApiException(Boxing.boxLong(r108.getCode()), r108.getMsg())));
    L30:
        if ((r107 instanceof a.C5690a) == false) goto L34;
        Result.Companion r111 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new AiProactiveTaskApiException(null, ((a.C5690a) r107).f469229b)));
    L34:
        throw new NoWhenBranchMatchedException();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L19:
        m r112 = new m(r100, (l) r104, 1);
        AiProactiveTaskApi.a r113 = AiProactiveTaskApi.f291553a;
        AiProactiveTaskRepository$parseUserAonTaskDraft$result$1 r114 = new AiProactiveTaskRepository$parseUserAonTaskDraft$result$1(r112, null);
        r102.L$0 = null;
        r102.label = 2;
        r113.getClass();
        r104 = AiProactiveTaskApi.a.a(r114, r102);
        if (r104 != r105) goto L22;
        return r105;
    L16:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = r100;
        r102.label = 1;
        r104 = b(r102);
        if (r104 != r105) goto L19;
        return r105;
    L7:
        r102 = new AiProactiveTaskRepository$parseUserAonTaskDraft$1(this, r101);
        goto L8
    }

    public final Object a(long r110, boolean r111, Continuation<? super Result<Unit>> r112) {
        if ((r112 instanceof AiProactiveTaskRepository$changeTaskStatus$1) == false) goto L7;
        AiProactiveTaskRepository$changeTaskStatus$1 r100 = (AiProactiveTaskRepository$changeTaskStatus$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L17;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r102);
    L27:
        a r105 = (a) r102;
        if ((r105 instanceof a.b) == false) goto L34;
        BizResponse<T> r106 = ((a.b) r105).f469231a;
        if (r106.isSuccess() == false) goto L32;
        Result.Companion r107 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L32:
        Result.Companion r108 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new AiProactiveTaskApiException(Boxing.boxLong(r106.getCode()), r106.getMsg())));
    L34:
        if ((r105 instanceof a.C5690a) == false) goto L38;
        Result.Companion r109 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new AiProactiveTaskApiException(null, ((a.C5690a) r105).f469229b)));
    L38:
        throw new NoWhenBranchMatchedException();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r113 = r100.I$0;
        long r114 = r100.J$0;
        ResultKt.throwOnFailure(r102);
    L24:
        t88.c r115 = new t88.c(r114, r113, (l) r102, 1);
        AiProactiveTaskApi.a r116 = AiProactiveTaskApi.f291553a;
        AiProactiveTaskRepository$changeTaskStatus$result$1 r117 = new AiProactiveTaskRepository$changeTaskStatus$result$1(r115, null);
        r100.label = 2;
        r116.getClass();
        r102 = AiProactiveTaskApi.a.a(r117, r100);
        if (r102 != r103) goto L27;
        return r103;
    L17:
        ResultKt.throwOnFailure(r102);
        r114 = r110;
        if (r111 == false) goto L20;
        r113 = 1;
    L21:
        r100.J$0 = r114;
        r100.I$0 = r113;
        r100.label = 1;
        r102 = b(r100);
        if (r102 != r103) goto L24;
        return r103;
    L20:
        r113 = 2;
    L7:
        r100 = new AiProactiveTaskRepository$changeTaskStatus$1(this, r112);
        goto L8
    }

    public final Object c(o r100, long r101, Continuation<? super Result<Unit>> r102) {
        if ((r102 instanceof AiProactiveTaskRepository$createTask$1) == false) goto L7;
        AiProactiveTaskRepository$createTask$1 r103 = (AiProactiveTaskRepository$createTask$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        a r108 = (a) r105;
        if ((r108 instanceof a.b) == false) goto L24;
        BizResponse<T> r109 = ((a.b) r108).f469231a;
        if (r109.isSuccess() == false) goto L22;
        Result.Companion r110 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L22:
        Result.Companion r111 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new AiProactiveTaskApiException(Boxing.boxLong(r109.getCode()), r109.getMsg())));
    L24:
        if ((r108 instanceof a.C5690a) == false) goto L28;
        Result.Companion r112 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new AiProactiveTaskApiException(null, ((a.C5690a) r108).f469229b)));
    L28:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        e r113 = new e(r100.b(), Boxing.boxLong(r101), 1);
        AiProactiveTaskApi.a r114 = AiProactiveTaskApi.f291553a;
        AiProactiveTaskRepository$createTask$result$1 r115 = new AiProactiveTaskRepository$createTask$result$1(r113, null);
        r103.label = 1;
        r114.getClass();
        r105 = AiProactiveTaskApi.a.a(r115, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new AiProactiveTaskRepository$createTask$1(this, r102);
        goto L8
    }

    public final Object e(long r110, o r111, int r112, Continuation<? super Result<Unit>> r113) {
        if ((r113 instanceof AiProactiveTaskRepository$editTask$1) == false) goto L7;
        AiProactiveTaskRepository$editTask$1 r100 = (AiProactiveTaskRepository$editTask$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r114);
    L17:
        a r115 = (a) r114;
        if ((r115 instanceof a.b) == false) goto L27;
        BizResponse<T> r116 = ((a.b) r115).f469231a;
        if (r116.isSuccess() == false) goto L22;
        Result.Companion r117 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L22:
        Result.Companion r118 = Result.Companion;
        String r119 = r116.getMsg();
        if (r119 != null) goto L36;
        r119 = "server error: " + r116.getCode();
    L36:
        return Result.m9449constructorimpl(ResultKt.createFailure(new RuntimeException(r119)));
    L27:
        if ((r115 instanceof a.C5690a) == false) goto L34;
        Result.Companion r120 = Result.Companion;
        a.C5690a r121 = (a.C5690a) r115;
        Throwable r122 = r121.f469230c;
        if (r122 != null) goto L32;
        r122 = new RuntimeException(r121.f469229b);
    L32:
        return Result.m9449constructorimpl(ResultKt.createFailure(r122));
    L34:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        h r123 = new h(r110, r111.b(), r112, 1);
        AiProactiveTaskApi.a r124 = AiProactiveTaskApi.f291553a;
        AiProactiveTaskRepository$editTask$result$1 r125 = new AiProactiveTaskRepository$editTask$result$1(r123, null);
        r100.label = 1;
        r124.getClass();
        r114 = AiProactiveTaskApi.a.a(r125, r100);
        if (r114 != r102) goto L17;
        return r102;
    L7:
        r100 = new AiProactiveTaskRepository$editTask$1(this, r113);
        goto L8
    }
}
