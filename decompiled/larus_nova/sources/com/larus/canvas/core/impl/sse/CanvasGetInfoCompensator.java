package com.larus.canvas.core.impl.sse;

import com.larus.im.internal.delegate.c0;
import com.larus.im.internal.delegate.o0;
import cy8.u;
import cy8.w;
import gd9.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import ouc.v;

/* JADX INFO: loaded from: classes4.dex */
public final class CanvasGetInfoCompensator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f322953b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<w, cy8.c, Continuation<? super j>, Object> f322954a;

    /* JADX INFO: renamed from: com.larus.canvas.core.impl.sse.CanvasGetInfoCompensator$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<w, cy8.c, Continuation<? super j>, Object>, SuspendFunction {
        public AnonymousClass1(Object r100) {
            super(3, r100, a.class, "defaultRequestGetInfo", "defaultRequestGetInfo(Lcom/larus/canvas/core/api/model/CanvasSSEStartParams;Lcom/larus/canvas/core/api/model/CanvasBlockSnapshot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(w r100, cy8.c r101, Continuation<? super j> r110) {
            ((a) this.receiver).getClass();
            Object r111 = null;
            if (r101 == null) goto L11;
            List<cy8.b> r102 = r101.f465812a;
            if (r102 == null) goto L11;
            cy8.b r103 = (cy8.b) CollectionsKt.firstOrNull(r102);
            if (r103 == null) goto L11;
            cy8.a r104 = r103.f465810e;
            if (r104 == null) goto L11;
            cy8.k r105 = r104.f465801a;
        L13:
            if (r105 == null) goto L15;
            Long r106 = r105.f465853a;
        L16:
            if (r105 == null) goto L18;
            Long r107 = r105.f465854b;
        L19:
            String r108 = r100.f465936d.f465923e;
            i r109 = new i(r106, r107, r108);
            if (r106 != null) goto L24;
            if (r107 != null) goto L24;
            if (r108 != null) goto L24;
            return null;
        L24:
            v r112 = e.f322963a;
            r112.getClass();
            String r113 = r112.a(i.Companion.serializer(), r109);
            o0 r114 = o0.f348249a;
            gd9.e r115 = t.a.a(o0.l(), "/creativity/canvas/get_canvas_block_info", r113, MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json; encoding=utf-8")), null, 16);
            if (r115.c() == false) goto L70;
            String r116 = r115.f480968d;
            if (r116 == null) goto L71;
            Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L32
            Object r118 = Result.m9449constructorimpl((h) r112.c(h.Companion.serializer(), r116));     // Catch: Throwable -> L32
        L34:
            Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
            if (r119 == null) goto L38;
            c0.f348199b.e("SSE_KMP", "compensator.parseResponse wrapped failed type=" + Reflection.getOrCreateKotlinClass(r119.getClass()).getSimpleName() + " msg=" + r119.getMessage());
        L38:
            if (Result.m9455isFailureimpl(r118) == false) goto L40;
            r118 = null;
        L40:
            h r120 = (h) r118;
            if (r120 == null) goto L43;
            j r121 = r120.f322974c;
        L44:
            if (r121 == null) goto L46;
            j r122 = r120.f322974c;
            return new j(r122.f322982a, r122.f322983b, r122.f322984c, r120.f322972a, r120.f322973b);
        L46:
            if (r120 != null) goto L48;
        L63:
            Object r123 = Result.m9449constructorimpl((j) e.f322963a.c(j.Companion.serializer(), r116));     // Catch: Throwable -> L52
        L54:
            Throwable r124 = Result.m9452exceptionOrNullimpl(r123);
            if (r124 == null) goto L58;
            c0.f348199b.e("SSE_KMP", "compensator.parseResponse flat failed type=" + Reflection.getOrCreateKotlinClass(r124.getClass()).getSimpleName() + " msg=" + r124.getMessage());
        L58:
            if (Result.m9455isFailureimpl(r123) == true) goto L62;
            r111 = r123;
        L62:
            return (j) r111;
        L52:
            th = move-exception;
            Result.Companion r125 = Result.Companion;
            r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L54
        L48:
            if (r120.f322972a == 0) goto L63;
            return new j(r120.f322972a, r120.f322973b, 7);
        L43:
            r121 = null;
        L32:
            th = move-exception;
            Result.Companion r126 = Result.Companion;
            r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L34
        L71:
            return null;
        L70:
            return null;
        L18:
            r107 = null;
            goto L19
        L15:
            r106 = null;
        L11:
            r105 = null;
            goto L13
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(w r100, cy8.c r101, Continuation<? super j> r102) {
            return invoke2(r100, r101, r102);
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        f322953b = new a();
    }

    public CanvasGetInfoCompensator(int r100) {
        AnonymousClass1 r101 = new AnonymousClass1(f322953b);
        Intrinsics.checkNotNullParameter(r101, "requestGetInfo");
        this.f322954a = r101;
    }

    public static cy8.c b(cy8.c r100, j r110) {
        String r101 = null;
        if (r100 == null) goto L5;
        List<cy8.b> r102 = r100.f465812a;
    L6:
        if (r102 != null) goto L8;
        r102 = CollectionsKt.emptyList();
    L8:
        com.larus.canvas.core.impl.sse.a r103 = new com.larus.canvas.core.impl.sse.a(r102);
        String r104 = r110.f322982a;
        if (r104 != null) goto L11;
    L27:
        List<cy8.b> r105 = CollectionsKt.emptyList();
    L28:
        Long r111 = r110.f322984c;
        if (r111 != null) goto L33;
        if (r100 == null) goto L32;
        r111 = r100.f465813b;
        goto L33
    L32:
        r111 = null;
    L33:
        if (r100 == null) goto L36;
        r101 = r100.f465814c;
    L36:
        return r103.b(r105, r111, true, r101);
    L11:
        if ((!StringsKt.isBlank(r104)) == true) goto L14;
        r104 = null;
    L14:
        if (r104 == null) goto L27;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L18
        k.f322989a.getClass();     // Catch: Throwable -> L18
        Object r107 = Result.m9449constructorimpl(k.g(r104));     // Catch: Throwable -> L18
    L20:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L23;
        c0.f348199b.e("SSE_KMP", "compensator.blocks decode failed type=" + Reflection.getOrCreateKotlinClass(r108.getClass()).getSimpleName() + " msg=" + r108.getMessage() + " contentPrefix=" + StringsKt.take(r104, 500));
    L23:
        List r109 = CollectionsKt.emptyList();
        if (Result.m9455isFailureimpl(r107) == false) goto L26;
        r107 = r109;
    L26:
        r105 = (List) r107;
    L18:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L5:
        r102 = null;
        goto L6
    }

    public final Object a(w r110, u r111, cy8.c r112, Continuation<? super u> r113) {
        cy8.c r100 = r112;
        if ((r113 instanceof CanvasGetInfoCompensator$compensate$1) == false) goto L7;
        CanvasGetInfoCompensator$compensate$1 r101 = (CanvasGetInfoCompensator$compensate$1) r113;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        j r106 = null;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        r100 = (cy8.c) r101.L$1;
        u r107 = (u) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L14
    L54:
        r106 = (j) r103;     // Catch: Throwable -> L14
    L62:
        if (r106 != null) goto L65;
        return r107;
    L65:
        if (r106.f322985d == 0) goto L68;
        c0.f348199b.w("SSE_KMP", "compensator business error code=" + r106.f322985d + " msg=" + r106.f322986e);
        return new u.d((int) r106.f322985d, r106.f322986e, b(r100, r106));
    L68:
        cy8.c r108 = b(r100, r106);
        if ((r107 instanceof u.c) == false) goto L72;
        return new u.c(r108);
    L72:
        if ((r107 instanceof u.d) == false) goto L87;
        c0.f348199b.i("SSE_KMP", "compensator promote Error->Done isFinish=" + r106.f322983b);
        return new u.c(r108);
    L87:
        return r107;
    L14:
        th = th;
        u r109 = r107;
    L61:
        c0.f348199b.e("SSE_KMP", "compensator.requestGetInfo threw type=" + Reflection.getOrCreateKotlinClass(th.getClass()).getSimpleName() + " msg=" + th.getMessage());
        r107 = r109;
        goto L62
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        if (r100 == null) goto L21;
        List<cy8.b> r114 = r100.f465812a;
    L22:
        if (r114 != null) goto L24;
        r114 = CollectionsKt.emptyList();
    L24:
        List<cy8.b> r115 = r114;
        boolean r116 = false;
        if ((r115 instanceof Collection) == true) goto L27;
    L29:
        Iterator<T> r117 = r115.iterator();
    L31:
        if (r117.hasNext() == false) goto L45;
        cy8.a r118 = ((cy8.b) r117.next()).f465810e;
        if (r118 == null) goto L42;
        cy8.k r119 = r118.f465801a;
        if (r119 == null) goto L42;
        Long r120 = r119.f465857e;
        if (r120 == null) goto L42;
        if (r120.longValue() != 20000008) goto L42;
        boolean r121 = true;
    L43:
        if (r121 == false) goto L31;
        r116 = true;
    L42:
        r121 = false;
    L45:
        if (r116 == true) goto L47;
        Function3<w, cy8.c, Continuation<? super j>, Object> r122 = this.f322954a;     // Catch: Throwable -> L59
        r109 = r111;
        r101.L$0 = r109;     // Catch: Throwable -> L57
        r101.L$1 = r100;     // Catch: Throwable -> L57
        r101.label = 1;     // Catch: Throwable -> L57
        r103 = r122.invoke(r110, r100, r101);     // Catch: Throwable -> L57
        if (r103 != r104) goto L53;
        return r104;
    L53:
        r107 = r109;
    L57:
        th = th;
    L59:
        th = th;
        r109 = r111;
        goto L61
    L47:
        return new u.c(r100);
    L27:
        if (r115.isEmpty() == false) goto L29;
    L21:
        r114 = null;
    L7:
        r101 = new CanvasGetInfoCompensator$compensate$1(this, r113);
        goto L8
    }
}
