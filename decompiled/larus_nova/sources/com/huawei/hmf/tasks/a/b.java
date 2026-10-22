package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.Task;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class b<TResult> implements ExecuteResult<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnCanceledListener f276773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f276774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f276775c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f276776a;

        public a(b r100) {
            this.f276776a = r100;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hmf_tasks_a_b$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hmf_tasks_a_b$a__run$___twin___() {
            Object r100 = this.f276776a.f276775c;
            monitor-enter(r100);
            OnCanceledListener r101 = this.f276776a.f276773a;     // Catch: Throwable -> L9
            if (r101 == null) goto L7;
            r101.onCanceled();     // Catch: Throwable -> L9
        L7:
            monitor-exit(r100);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hmf_tasks_a_b$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_huawei_hmf_tasks_a_b$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b(Executor r100, OnCanceledListener r101) {
        this.f276775c = new Object();
        this.f276773a = r101;
        this.f276774b = r100;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public void cancel() {
        Object r100 = this.f276775c;
        monitor-enter(r100);
        this.f276773a = null;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> r100) {
        if (((i) r100).f276805c == false) goto L6;
        this.f276774b.execute(new a(this));
        return;
    }
}
