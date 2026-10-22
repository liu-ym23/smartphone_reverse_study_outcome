package com.ss.android.lark.passportc.ffi;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.task.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import gy7.p;
import gy7.q;
import gy7.w;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import j0c.c;
import j0c.e;
import java.util.List;
import javax.inject.Inject;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes37.dex */
public final class KmpOnlineTask implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0c.b f438149a = null;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KmpOnlineTask f438150a;

        public b(KmpOnlineTask r100) {
            this.f438150a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            Log.e("PassportKmpOnlineTask", "execute online tasks failed: " + ExceptionsKt.stackTraceToString(r101));
            this.f438150a.getClass();
            j0c.b r102 = KmpOnlineTask.f438149a;
            String r103 = r101.getMessage();
            if (r103 != null) goto L6;
            r103 = "execute KMP online tasks failed";
        L6:
            return new c(r102, false, r103, 4);
        }
    }

    @Inject
    public KmpOnlineTask() {
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final boolean G() {
        return true;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final /* synthetic */ Observable H(e r100) {
        return com.ss.android.lark.passportc.task.e.a(this, r100);
    }

    static {
        f438149a = new j0c.b("Kmp UserState online Task");
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final List dependencies() {
        return CollectionsKt.emptyList();
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final j0c.b F() {
        return f438149a;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final Observable<c> I(final e r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = com.ss.android.lark.passportc.ffi.b.f438166a;
        final p r102 = com.ss.android.lark.passportc.ffi.b.b(r100.f496852a);
        if (r102 == null) goto L5;
        com.lark.kmp.containerization.b r103 = iy7.a.a();
        if (r103 == null) goto L14;
        Object r104 = r103.a(Reflection.getOrCreateKotlinClass(w.class));
        if (r104 == null) goto L13;
        final w r105 = (w) r104;
        UserSession r106 = r100.f496852a.f475034b;
        final q r107 = new q(r106.f438138b, r106.f438137a);
        return Observable.fromCallable(new KmpOnlineTask$execute$1(this, r105, r107, r102, r100)).onErrorReturn(new b(this));
    L13:
        throw new IllegalArgumentException("No instance of " + Reflection.getOrCreateKotlinClass(w.class).getSimpleName() + " found");
    L14:
        Log.e("PassportKmpOnlineTask", "execute skipped: KMP task executor not found");
        return Observable.just(new c(f438149a, false, "KMP task executor not found", 4));
    L5:
        return Observable.just(new c(f438149a, false, "KMP user payload is null", 4));
    }
}
