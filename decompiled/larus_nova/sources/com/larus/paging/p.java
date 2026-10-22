package com.larus.paging;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes29.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f363903a;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f1 f363904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MutableSharedFlow<f1> f363905b;

        public a() {
            this.f363905b = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f363906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f363907b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f1.a f363908c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ReentrantLock f363909d;

        public b(p r100) {
            this.f363906a = new a();
            this.f363907b = new a();
            this.f363909d = new ReentrantLock();
        }

        public final void a(f1.a r100, Function2<? super a, ? super a, Unit> r101) {
            Intrinsics.checkNotNullParameter(r101, "block");
            ReentrantLock r102 = this.f363909d;
            r102.lock();
            if (r100 != null) goto L11;
        L5:
            r101.invoke(this.f363906a, this.f363907b);     // Catch: Throwable -> L8
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L8
            r102.unlock();
            return;
        L8:
            th = move-exception;
            r102.unlock();
            throw th;
        L11:
            this.f363908c = r100;     // Catch: Throwable -> L8
            goto L5
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f363910a = null;

        static {
            int[] r100 = new int[LoadType.values().length];
            r100[LoadType.PREPEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[LoadType.APPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f363910a = r100;
        }
    }

    public p() {
        this.f363903a = new b(this);
    }

    public final MutableSharedFlow a(LoadType r100) {
        Intrinsics.checkNotNullParameter(r100, "loadType");
        int r101 = c.f363910a[r100.ordinal()];
        if (r101 == 1) goto L10;
        if (r101 != 2) goto L8;
        return this.f363903a.f363907b.f363905b;
    L8:
        throw new IllegalArgumentException("invalid load type for hints");
    L10:
        return this.f363903a.f363906a.f363905b;
    }
}
