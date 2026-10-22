package com.larus.canvas.core.impl;

import com.larus.im.internal.delegate.c;
import com.larus.im.internal.delegate.d1;
import cy8.w;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;
import ouc.e0;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f322946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f322947b;

    /* JADX INFO: renamed from: com.larus.canvas.core.impl.a$a, reason: collision with other inner class name */
    public static final class C4157a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f322948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f322949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f322950c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f322951d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f322952e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4157a) == true) goto L8;
            return false;
        L8:
            C4157a r101 = (C4157a) r100;
            if (this.f322948a == r101.f322948a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f322949b, r101.f322949b) == true) goto L15;
            return false;
        L15:
            if (this.f322950c == r101.f322950c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f322951d, r101.f322951d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f322952e, r101.f322952e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f322948a * 31) + this.f322949b.hashCode()) * 31) + this.f322950c) * 31;
            String r101 = this.f322951d;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + this.f322952e.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ChunkEndInfo(status=" + this.f322948a + ", errorDesc=" + this.f322949b + ", errorCode=" + this.f322950c + ", logId=" + this.f322951d + ", requestPath=" + this.f322952e + ')';
        }

        public C4157a(int r100, String r101, int r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r101, "errorDesc");
            Intrinsics.checkNotNullParameter(r104, "requestPath");
            this.f322948a = r100;
            this.f322949b = r101;
            this.f322950c = r102;
            this.f322951d = r103;
            this.f322952e = r104;
        }
    }

    public static final class b {
    }

    static {
    }

    public a() {
    }

    public final void a(w r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f322946a = 0;
        this.f322947b = c.f348197a.currentTimeMillis();
        e0 r101 = new e0();
        com.larus.canvas.core.impl.b.a(r101, "binary_type", "json");
        com.larus.canvas.core.impl.b.a(r101, "request_path", r100.f465935c);
        com.larus.canvas.core.impl.b.a(r101, "scene", "start");
        d0 r102 = r101.a();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        d1.f348206b.a("flow_canvas_chunk_request", r102);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
