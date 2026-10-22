package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.log.HMSLog;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public abstract class ErrorResultImpl<R extends Result> extends PendingResult<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private R f277702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f277703b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResultCallback f277704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ErrorResultImpl f277705b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ErrorResultImpl f277706c;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_support_api_ErrorResultImpl$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hms_support_api_ErrorResultImpl$a__run$___twin___() {
            ResultCallback r100 = this.f277704a;
            ErrorResultImpl r101 = this.f277706c;
            r100.onResult(ErrorResultImpl.a(r101, ErrorResultImpl.a(r101), this.f277705b));
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_support_api_ErrorResultImpl$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_huawei_hms_support_api_ErrorResultImpl$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ErrorResultImpl r100, ResultCallback r101, ErrorResultImpl r102) {
            this.f277706c = r100;
            this.f277704a = r101;
            this.f277705b = r102;
        }
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void cancel() {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public boolean isCanceled() {
        return false;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        return (R) await(0, null);
    }

    public ErrorResultImpl(int r100) {
        this.f277702a = null;
        this.f277703b = r100;
    }

    public static /* synthetic */ int a(ErrorResultImpl r100) {
        return r100.f277703b;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(ResultCallback<R> r100) {
        setResultCallback(Looper.getMainLooper(), r100);
    }

    private R a(int r100, ErrorResultImpl r101) {
        Type r102 = r101.getClass().getGenericSuperclass();
        if (r102 != null) goto L13;
        return null;
    L13:
        R r103 = (R) GenericTypeReflector.getType(((ParameterizedType) r102).getActualTypeArguments()[0]).newInstance();     // Catch: IllegalAccessException -> L7 InstantiationException -> L8
        this.f277702a = r103;     // Catch: IllegalAccessException -> L7 InstantiationException -> L8
        r103.setStatus(new Status(r100));     // Catch: IllegalAccessException -> L7 InstantiationException -> L8
    L10:
        return this.f277702a;
    L7:
        HMSLog.e("ErrorResultImpl", "IllegalAccessException");
    L8:
        HMSLog.e("ErrorResultImpl", "InstantiationException");
        goto L10
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long r100, TimeUnit r101) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L7;
        return (R) a(this.f277703b, this);
    L7:
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(Looper r100, ResultCallback<R> r101) {
        postRunnable(r100, r101, this);
    }

    public static /* synthetic */ Result a(ErrorResultImpl r100, int r101, ErrorResultImpl r102) {
        return r100.a(r101, r102);
    }

    public void postRunnable(Looper r100, ResultCallback<R> r101, ErrorResultImpl r102) {
        if (r100 != null) goto L5;
        r100 = Looper.myLooper();
    L5:
        new Handler(r100).post(new a(this, r101, r102));
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(ResultCallback<R> r100, long r101, TimeUnit r102) {
        setResultCallback(r100);
    }
}
