package com.larus.canvas.core.impl.sse;

import cy8.w;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.c1;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f322996c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f322997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CanvasSseChunkParser f322998b;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f322999a = null;

            static {
                f322999a = new a();
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                a r101 = (a) r100;
                return true;
            }

            public final int hashCode() {
                return -377411020;
            }

            public final String toString() {
                return "Done";
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.larus.canvas.core.impl.sse.m$b$b, reason: collision with other inner class name */
        public static final class C4158b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f323000a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f323001b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4158b) == true) goto L8;
                return false;
            L8:
                C4158b r101 = (C4158b) r100;
                if (this.f323000a == r101.f323000a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f323001b, r101.f323001b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f323000a * 31;
                String r101 = this.f323001b;
                if (r101 != null) goto L5;
                int r102 = 0;
            L7:
                return r100 + r102;
            L5:
                r102 = r101.hashCode();
                goto L7
            }

            public final String toString() {
                return "Error(code=" + this.f323000a + ", message=" + this.f323001b + ')';
            }

            public C4158b(int r100, String r101) {
                this.f323000a = r100;
                this.f323001b = r101;
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f323002a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f323002a, ((c) r100).f323002a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                String r100 = this.f323002a;
                if (r100 != null) goto L6;
                return 0;
            L6:
                return r100.hashCode();
            }

            public final String toString() {
                return "Failed(message=" + this.f323002a + ')';
            }

            public c(String r100) {
                this.f323002a = r100;
            }
        }

        public b() {
        }
    }

    static {
    }

    public m(int r100) {
        c r101 = new c(0);
        CanvasSseChunkParser r102 = new CanvasSseChunkParser();
        Intrinsics.checkNotNullParameter(r101, "parser");
        Intrinsics.checkNotNullParameter(r102, "sseChunkParser");
        this.f322997a = r101;
        this.f322998b = r102;
    }

    public final c1 c(w r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        return new c1(new CanvasStreamPullHandler$start$1(r100, this, null));
    }

    public static final Map b(m r100, w r101) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("connect_timeout", Long.valueOf(r101.f465939g.f465942a)), TuplesKt.to("interval_timeout", Long.valueOf(r101.f465939g.f465943b)), TuplesKt.to("write_timeout", Long.valueOf(r101.f465939g.f465944c)), TuplesKt.to("protect_timeout", Long.valueOf(r101.f465939g.f465945d))});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, com.larus.canvas.core.impl.sse.m$b$c] */
    public static final Object a(m r110, BufferedSource r111, com.larus.canvas.core.impl.sse.a r112, String r113, Function2 r114, Continuation r115) {
        r110.getClass();
        if ((r115 instanceof CanvasStreamPullHandler$readStream$1) == false) goto L7;
        CanvasStreamPullHandler$readStream$1 r100 = (CanvasStreamPullHandler$readStream$1) r115;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        CanvasStreamPullHandler$readStream$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L16;
        if (r105 != 1) goto L15;
        Ref.ObjectRef r106 = (Ref.ObjectRef) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L23
    L21:
        Object r107 = Result.m9449constructorimpl((b) r106.element);     // Catch: Throwable -> L23
    L25:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L30;
        r107 = new b.c(r108.getMessage());
    L30:
        return r107;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L23
        Ref.ObjectRef r116 = new Ref.ObjectRef();     // Catch: Throwable -> L23
        r116.element = new b.c("stream ended without done");     // Catch: Throwable -> L23
        CanvasSseChunkParser r117 = r110.f322998b;     // Catch: Throwable -> L23
        CanvasStreamPullHandler$readStream$2$1 r118 = new CanvasStreamPullHandler$readStream$2$1(r110, r112, r113, r114, r116, null);     // Catch: Throwable -> L23
        r102.L$0 = r116;     // Catch: Throwable -> L23
        r102.label = 1;     // Catch: Throwable -> L23
        if (r117.a(r111, r118, r102) == r104) goto L33;
        r106 = r116;
        goto L21
    L33:
        return r104;
    L23:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new CanvasStreamPullHandler$readStream$1(r110, r115);
        goto L8
    }
}
