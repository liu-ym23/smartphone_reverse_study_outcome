package com.larksuite.framework.section.utils;

import android.os.Handler;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u000fB\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0006J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00028\u0000H\u0007¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larksuite/framework/section/utils/MutableLiveDataPlus;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "<init>", "()V", "value", "(Ljava/lang/Object;)V", "NOT_SET", "", "mPendingData", "mPostValueRunnable", "Ljava/lang/Runnable;", "setValueIfChanged", "", "postValueIfChanged", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MutableLiveDataPlus<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<Handler> f285696d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f285697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f285698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f285699c;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MutableLiveDataPlus<T> f285700a;

        public b(MutableLiveDataPlus<T> r100) {
            this.f285700a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MutableLiveDataPlus<T> r100 = this.f285700a;     // Catch: Throwable -> L10
            Object r101 = r100.f285697a;     // Catch: Throwable -> L10
            monitor-enter(r101);     // Catch: Throwable -> L10
            Object r102 = r100.f285698b;     // Catch: Throwable -> L7
            r100.f285698b = r100.f285697a;     // Catch: Throwable -> L7
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L10
            this.f285700a.b((T) r102);     // Catch: Throwable -> L10
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }
    }

    static {
        f285696d = LazyKt.lazy(MutableLiveDataPlus$Companion$uiHandler$2.INSTANCE);
    }

    public MutableLiveDataPlus() {
        Object r100 = new Object();
        this.f285697a = r100;
        this.f285698b = r100;
        this.f285699c = new b(this);
    }

    public MutableLiveDataPlus(T r100) {
        super(r100);
        Object r101 = new Object();
        this.f285697a = r101;
        this.f285698b = r101;
        this.f285699c = new b(this);
    }

    public final void a(T r100) {
        Object r101 = this.f285697a;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f285698b != this.f285697a) goto L7;
        boolean r102 = true;
    L8:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Any");     // Catch: Throwable -> L14
        this.f285698b = r100;     // Catch: Throwable -> L14
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r101);
        if (r102 == true) goto L12;
        return;
    L12:
        f285696d.getValue().post(this.f285699c);
        return;
    L7:
        r102 = false;
        goto L8
    }

    public final void b(T r100) {
        T r101 = getValue();
        if (r101 != null) goto L5;
    L7:
        super.setValue(r100);
        return;
    L5:
        if (Intrinsics.areEqual(r101, r100) == false) goto L7;
    }
}
