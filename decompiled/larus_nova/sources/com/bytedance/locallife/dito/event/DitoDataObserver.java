package com.bytedance.locallife.dito.event;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.bytedance.locallife.dito.core.c0;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/dito/event/DitoDataObserver;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/Observer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DitoDataObserver<T> implements Observer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observer<? super T> f258266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f258267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f258268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f258269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f258270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f258271f;

    public static final class a {
    }

    static {
    }

    public final long a() {
        if (this.f258269d == null) goto L8;
        Long r100 = this.f258270e;
        if (r100 == null) goto L10;
        Intrinsics.checkNotNull(r100);
        long r101 = r100.longValue();
        Long r102 = this.f258269d;
        Intrinsics.checkNotNull(r102);
        return r101 - r102.longValue();
    L10:
        return 0;
    L8:
        return 0;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        this.f258269d = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L11
        c0 r102 = this.f258268c;     // Catch: Throwable -> L11
        if (r102 == null) goto L6;
        r102.a(this);     // Catch: Throwable -> L11
    L6:
        this.f258266a.onChanged(r100);     // Catch: Throwable -> L11
        this.f258270e = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L11
        c0 r103 = this.f258268c;     // Catch: Throwable -> L11
        if (r103 == null) goto L9;
        r103.b(this);     // Catch: Throwable -> L11
    L9:
        rq6.a.f538927a.c("DitoDataObserver", "originObserver:$" + this.f258271f + ",method " + this.f258267b + " cost:" + a());     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 != null) goto L16;
        return;
    L16:
        rq6.a.f538927a.b("DitoDataObserver", "DitoDataObserver error:" + this.f258266a.getClass() + ",e:" + r105.getMessage() + ",stack:" + Log.getStackTraceString(r105) + ',');
        throw r105;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public DitoDataObserver(Observer<? super T> r100, String r101, c0 r102) {
        Intrinsics.checkNotNullParameter(r100, "originObserver");
        this.f258266a = r100;
        this.f258267b = r101;
        this.f258268c = r102;
    }
}
