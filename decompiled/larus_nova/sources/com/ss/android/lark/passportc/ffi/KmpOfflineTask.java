package com.ss.android.lark.passportc.ffi;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.task.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import gy7.p;
import gy7.q;
import gy7.w;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import j0c.e;
import java.util.List;
import javax.inject.Inject;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes37.dex */
public final class KmpOfflineTask implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0c.b f438141a = null;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KmpOfflineTask f438142a;

        public b(KmpOfflineTask r100) {
            this.f438142a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            Log.e("PassportKmpOfflineTask", "execute offline tasks failed: " + ExceptionsKt.stackTraceToString(r101));
            this.f438142a.getClass();
            j0c.b r102 = KmpOfflineTask.f438141a;
            String r103 = r101.getMessage();
            if (r103 != null) goto L6;
            r103 = "execute KMP offline tasks failed";
        L6:
            return new j0c.c(r102, false, r103, 4);
        }
    }

    @Inject
    public KmpOfflineTask() {
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
        f438141a = new j0c.b("Kmp UserState offline Task");
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final List dependencies() {
        return CollectionsKt.emptyList();
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final j0c.b F() {
        return f438141a;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final Observable<j0c.c> I(final e r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = com.ss.android.lark.passportc.ffi.b.f438166a;
        final p r102 = com.ss.android.lark.passportc.ffi.b.b(r100.f496852a);
        if (r102 != null) goto L6;
        Log.e("PassportKmpOfflineTask", "execute skipped: KMP user payload is null");
        return Observable.just(new j0c.c(f438141a, false, "KMP user payload is null", 4));
    L6:
        com.lark.kmp.containerization.b r103 = iy7.a.a();
        if (r103 == null) goto L14;
        Object r104 = r103.a(Reflection.getOrCreateKotlinClass(w.class));
        if (r104 == null) goto L13;
        final w r105 = (w) r104;
        UserSession r106 = r100.f496852a.f475034b;
        final q r107 = new q(r106.f438138b, r106.f438137a);
        return Observable.fromCallable(new KmpOfflineTask$execute$1(this, r105, r107, r102, r100)).onErrorReturn(new b(this));
    L13:
        throw new IllegalArgumentException("No instance of " + Reflection.getOrCreateKotlinClass(w.class).getSimpleName() + " found");
    L14:
        Log.e("PassportKmpOfflineTask", "execute skipped: KMP task executor not found");
        return Observable.just(new j0c.c(f438141a, false, "KMP task executor not found", 4));
    }
}
