package com.larus.office.base.watermark.poller;

import com.larus.office.base.watermark.api.remote.WatermarkApiImpl;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes29.dex */
public final class AsyncTaskPoller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nn9.a f361242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f361243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f361244c;

    public static final class a {
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f361245a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f361245a, ((a) r100).f361245a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f361245a.hashCode();
            }

            public final String toString() {
                return "Failed(reason=" + this.f361245a + ')';
            }

            public a(String r100) {
                Intrinsics.checkNotNullParameter(r100, "reason");
                this.f361245a = r100;
            }
        }

        /* JADX INFO: renamed from: com.larus.office.base.watermark.poller.AsyncTaskPoller$b$b, reason: collision with other inner class name */
        public static final class C4439b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f361246a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4439b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f361246a, ((C4439b) r100).f361246a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f361246a.hashCode();
            }

            public final String toString() {
                return "Ok(url=" + this.f361246a + ')';
            }

            public C4439b(String r100) {
                Intrinsics.checkNotNullParameter(r100, "url");
                this.f361246a = r100;
            }
        }

        public b() {
        }
    }

    static {
    }

    public AsyncTaskPoller(WatermarkApiImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "api");
        this.f361242a = r100;
        this.f361243b = 1500;
        this.f361244c = 60000;
    }

    public final Object a(String r100, Continuation<? super b> r101) {
        if ((r101 instanceof AsyncTaskPoller$poll$1) == false) goto L7;
        AsyncTaskPoller$poll$1 r102 = (AsyncTaskPoller$poll$1) r101;
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
        b r107 = (b) r104;
        if (r107 == null) goto L20;
        return r107;
    L20:
        return new b.a("timeout_" + this.f361244c + "ms");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        long r108 = this.f361244c;
        AsyncTaskPoller$poll$outcome$1 r109 = new AsyncTaskPoller$poll$outcome$1(this, r100, null);
        r102.label = 1;
        r104 = TimeoutKt.c(r108, r109, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new AsyncTaskPoller$poll$1(this, r101);
        goto L8
    }
}
