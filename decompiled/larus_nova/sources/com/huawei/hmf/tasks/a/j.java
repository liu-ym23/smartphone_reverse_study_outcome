package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.TaskExecutors;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class j {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f276819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Callable f276820b;

        public a(j r100, TaskCompletionSource r101, Callable r102) {
            this.f276819a = r101;
            this.f276820b = r102;
        }

        public void com_huawei_hmf_tasks_a_j$a__run$___twin___() {
            this.f276819a.setResult(this.f276820b.call());     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            this.f276819a.setException(e);
        }

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hmf_tasks_a_j$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hmf_tasks_a_j$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_huawei_hmf_tasks_a_j$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class b implements Continuation<Void, List<Task<?>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Collection f276821a;

        public b(Collection r100) {
            this.f276821a = r100;
        }

        @Override // com.huawei.hmf.tasks.Continuation
        public List<Task<?>> then(Task<Void> r100) throws Exception {
            ArrayList r101 = new ArrayList(this.f276821a.size());
            r101.addAll(this.f276821a);
            return r101;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [TResult] */
    public static class c<TResult> implements Continuation<Void, List<TResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Collection f276822a;

        public c(Collection r100) {
            this.f276822a = r100;
        }

        @Override // com.huawei.hmf.tasks.Continuation
        public Object then(Task<Void> r100) throws Exception {
            ArrayList r101 = new ArrayList();
            Iterator r102 = this.f276822a.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r101.add(((Task) r102.next()).getResult());
            goto L4
        L6:
            return r101;
        }
    }

    public static class d<TResult> implements OnSuccessListener<TResult>, OnFailureListener, OnCanceledListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch f276823a;

        public d() {
            this.f276823a = new CountDownLatch(1);
        }

        @Override // com.huawei.hmf.tasks.OnCanceledListener
        public void onCanceled() {
            this.f276823a.countDown();
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public final void onFailure(Exception r100) {
            this.f276823a.countDown();
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public final void onSuccess(TResult r100) {
            this.f276823a.countDown();
        }
    }

    public j() {
    }

    public <TResult> Task<TResult> a(Executor r100, Callable<TResult> r101) {
        TaskCompletionSource r102 = new TaskCompletionSource();
        r100.execute(new a(this, r102, r101));     // Catch: Exception -> L5
    L8:
        return r102.getTask();
    L5:
        e = move-exception;
        r102.setException(e);
        goto L8
    }

    public final <TResult> TResult a(Task<TResult> r100) throws ExecutionException {
        if (r100.isSuccessful() == false) goto L7;
        return r100.getResult();
    L7:
        throw new ExecutionException(r100.getException());
    }

    public static Task<List<Task<?>>> a(Collection<? extends Task<?>> r100) {
        Task<Void> r101 = b(r100);
        b r102 = new b(r100);
        i r103 = (i) r101;
        r103.getClass();
        Executor r104 = TaskExecutors.uiThread();
        i r105 = new i();
        r103.addOnCompleteListener(r104, new i.e(r103, r105, r102));
        return r105;
    }

    public static Task<Void> b(Collection<? extends Task<?>> r100) {
        if (r100.isEmpty() == false) goto L6;
        TaskCompletionSource r101 = new TaskCompletionSource();
        r101.setResult(null);
        return r101.getTask();
    L6:
        Iterator<? extends Task<?>> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        if (r102.next() != null) goto L8;
        throw new NullPointerException("task can not is null");
    L14:
        i r103 = new i();
        e r104 = new e(r100.size(), r103);
        Iterator<? extends Task<?>> r105 = r100.iterator();
    L16:
        if (r105.hasNext() == false) goto L18;
        Task<?> r106 = r105.next();
        r106.addOnSuccessListener(TaskExecutors.immediate(), r104);
        i r107 = (i) r106;
        r107.a(new f(TaskExecutors.immediate(), r104));
        r107.a(new com.huawei.hmf.tasks.a.b(TaskExecutors.immediate(), r104));
        goto L16
    L18:
        return r103;
    }

    public static <TResult> Task<List<TResult>> c(Collection<? extends Task<?>> r100) {
        Task<Void> r101 = b(r100);
        c r102 = new c(r100);
        i r103 = (i) r101;
        r103.getClass();
        Executor r104 = TaskExecutors.uiThread();
        i r105 = new i();
        r103.addOnCompleteListener(r104, new i.e(r103, r105, r102));
        return r105;
    }
}
