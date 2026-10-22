package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class d<TResult> implements ExecuteResult<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnCompleteListener<TResult> f276780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f276781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f276782c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Task f276783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f276784b;

        public a(d r100, Task r101) {
            this.f276784b = r100;
            this.f276783a = r101;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hmf_tasks_a_d$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hmf_tasks_a_d$a__run$___twin___() {
            Object r100 = this.f276784b.f276782c;
            monitor-enter(r100);
            OnCompleteListener<TResult> r101 = this.f276784b.f276780a;     // Catch: Throwable -> L9
            if (r101 == null) goto L7;
            r101.onComplete(this.f276783a);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r100);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hmf_tasks_a_d$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_huawei_hmf_tasks_a_d$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public d(Executor r100, OnCompleteListener<TResult> r101) {
        this.f276782c = new Object();
        this.f276780a = r101;
        this.f276781b = r100;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public void cancel() {
        Object r100 = this.f276782c;
        monitor-enter(r100);
        this.f276780a = null;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> r100) {
        this.f276781b.execute(new a(this, r100));
    }
}
