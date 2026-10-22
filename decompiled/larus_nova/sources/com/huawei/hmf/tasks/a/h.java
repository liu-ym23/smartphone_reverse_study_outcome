package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class h<TResult> implements ExecuteResult<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnSuccessListener<TResult> f276798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f276799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f276800c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Task f276801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f276802b;

        public a(h r100, Task r101) {
            this.f276802b = r100;
            this.f276801a = r101;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hmf_tasks_a_h$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hmf_tasks_a_h$a__run$___twin___() {
            Object r100 = this.f276802b.f276800c;
            monitor-enter(r100);
            OnSuccessListener<TResult> r101 = this.f276802b.f276798a;     // Catch: Throwable -> L9
            if (r101 == null) goto L7;
            r101.onSuccess((TResult) this.f276801a.getResult());     // Catch: Throwable -> L9
        L7:
            monitor-exit(r100);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hmf_tasks_a_h$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_huawei_hmf_tasks_a_h$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public h(Executor r100, OnSuccessListener<TResult> r101) {
        this.f276800c = new Object();
        this.f276798a = r101;
        this.f276799b = r100;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public void cancel() {
        Object r100 = this.f276800c;
        monitor-enter(r100);
        this.f276798a = null;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> r100) {
        if (r100.isSuccessful() == true) goto L5;
        return;
    L5:
        if (((i) r100).f276805c == true) goto L9;
        this.f276799b.execute(new a(this, r100));
        return;
    }
}
