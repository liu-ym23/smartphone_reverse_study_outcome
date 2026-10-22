package com.huawei.hmf.tasks.a;

import android.app.Activity;
import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.SuccessContinuation;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public class i<TResult> extends Task<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f276803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f276804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f276805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TResult f276806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Exception f276807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<ExecuteResult<TResult>> f276808f;

    public class a implements OnSuccessListener<TResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuccessContinuation f276809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f276810b;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* JADX INFO: renamed from: com.huawei.hmf.tasks.a.i$a$a, reason: collision with other inner class name */
        public class C3871a<TContinuationResult> implements OnCompleteListener<TContinuationResult> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f276811a;

            public C3871a(a r100) {
                this.f276811a = r100;
            }

            @Override // com.huawei.hmf.tasks.OnCompleteListener
            public void onComplete(Task<TContinuationResult> r100) {
                if (r100.isSuccessful() == false) goto L6;
                this.f276811a.f276810b.a(r100.getResult());
                return;
            L6:
                if (((i) r100).f276805c == false) goto L8;
                this.f276811a.f276810b.a();
                return;
            L8:
                this.f276811a.f276810b.a(r100.getException());
            }
        }

        public a(i r100, SuccessContinuation r101, i r102) {
            this.f276809a = r101;
            this.f276810b = r102;
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public void onSuccess(TResult r100) {
            Task r101 = this.f276809a.then(r100);     // Catch: Exception -> L8
            if (r101 != null) goto L6;
            this.f276810b.a(new NullPointerException("SuccessContinuation returned null"));
            return;
        L6:
            C3871a r102 = new C3871a(this);
            ((i) r101).addOnCompleteListener(TaskExecutors.uiThread(), r102);
            return;
        L8:
            e = move-exception;
            this.f276810b.a(e);
        }
    }

    public class b implements OnFailureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f276812a;

        public b(i r100, i r101) {
            this.f276812a = r101;
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public void onFailure(Exception r100) {
            this.f276812a.a(r100);
        }
    }

    public class c implements OnCanceledListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f276813a;

        public c(i r100, i r101) {
            this.f276813a = r101;
        }

        @Override // com.huawei.hmf.tasks.OnCanceledListener
        public void onCanceled() {
            this.f276813a.a();
        }
    }

    public class d implements OnCompleteListener<TResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f276814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f276815b;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        public class a<TContinuationResult> implements OnCompleteListener<TContinuationResult> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f276816a;

            public a(d r100) {
                this.f276816a = r100;
            }

            @Override // com.huawei.hmf.tasks.OnCompleteListener
            public void onComplete(Task<TContinuationResult> r100) {
                if (r100.isSuccessful() == false) goto L6;
                this.f276816a.f276815b.a(r100.getResult());
                return;
            L6:
                if (((i) r100).f276805c == false) goto L8;
                this.f276816a.f276815b.a();
                return;
            L8:
                this.f276816a.f276815b.a(r100.getException());
            }
        }

        public d(i r100, Continuation r101, i r102) {
            this.f276814a = r101;
            this.f276815b = r102;
        }

        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public void onComplete(Task<TResult> r100) {
            Task r101 = (Task) this.f276814a.then(r100);     // Catch: Exception -> L8
            if (r101 != null) goto L6;
            this.f276815b.a(new NullPointerException("Continuation returned null"));
            return;
        L6:
            a r102 = new a(this);
            ((i) r101).addOnCompleteListener(TaskExecutors.uiThread(), r102);
            return;
        L8:
            e = move-exception;
            this.f276815b.a(e);
        }
    }

    public class e implements OnCompleteListener<TResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f276817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Continuation f276818b;

        public e(i r100, i r101, Continuation r102) {
            this.f276817a = r101;
            this.f276818b = r102;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public void onComplete(Task<TResult> r100) {
            if (((i) r100).f276805c == false) goto L11;
            this.f276817a.a();
            return;
        L11:
            Object r101 = this.f276818b.then(r100);     // Catch: Exception -> L8
            this.f276817a.a(r101);     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            this.f276817a.a(e);
        }
    }

    public i() {
        this.f276803a = new Object();
        this.f276808f = new ArrayList();
    }

    public Task<TResult> a(ExecuteResult<TResult> r100) {
        Object r101 = this.f276803a;
        monitor-enter(r101);
        boolean r102 = isComplete();     // Catch: Throwable -> L11
        if (r102 == true) goto L7;
        this.f276808f.add(r100);     // Catch: Throwable -> L11
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L11
        if (r102 == false) goto L10;
        r100.onComplete(this);
    L10:
        return this;
    L11:
        th = move-exception;
        throw th;
    }

    public final void a(Exception r100) {
        Object r101 = this.f276803a;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f276804b == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        this.f276804b = true;     // Catch: Throwable -> L11
        this.f276807e = r100;     // Catch: Throwable -> L11
        this.f276803a.notifyAll();     // Catch: Throwable -> L11
        b();     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    public final void a(TResult r100) {
        Object r101 = this.f276803a;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f276804b == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        this.f276804b = true;     // Catch: Throwable -> L11
        this.f276806d = r100;     // Catch: Throwable -> L11
        this.f276803a.notifyAll();     // Catch: Throwable -> L11
        b();     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    public final boolean a() {
        Object r100 = this.f276803a;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f276804b == false) goto L9;
        monitor-exit(r100);     // Catch: Throwable -> L12
        return false;
    L9:
        this.f276804b = true;     // Catch: Throwable -> L12
        this.f276805c = true;     // Catch: Throwable -> L12
        this.f276803a.notifyAll();     // Catch: Throwable -> L12
        b();     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return true;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCanceledListener(Activity r100, OnCanceledListener r101) {
        com.huawei.hmf.tasks.a.b r102 = new com.huawei.hmf.tasks.a.b(TaskExecutors.uiThread(), r101);
        g.a(r100, r102);
        return a(r102);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCanceledListener(Executor r100, OnCanceledListener r101) {
        return a(new com.huawei.hmf.tasks.a.b(r100, r101));
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCompleteListener(Activity r100, OnCompleteListener<TResult> r101) {
        com.huawei.hmf.tasks.a.d r102 = new com.huawei.hmf.tasks.a.d(TaskExecutors.uiThread(), r101);
        g.a(r100, r102);
        return a(r102);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> r100) {
        return addOnCompleteListener(TaskExecutors.uiThread(), r100);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCompleteListener(Executor r100, OnCompleteListener<TResult> r101) {
        return a(new com.huawei.hmf.tasks.a.d(r100, r101));
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnFailureListener(Activity r100, OnFailureListener r101) {
        f r102 = new f(TaskExecutors.uiThread(), r101);
        g.a(r100, r102);
        return a(r102);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnFailureListener(Executor r100, OnFailureListener r101) {
        return a(new f(r100, r101));
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnSuccessListener(Activity r100, OnSuccessListener<TResult> r101) {
        h r102 = new h(TaskExecutors.uiThread(), r101);
        g.a(r100, r102);
        return a(r102);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnSuccessListener(OnSuccessListener<TResult> r100) {
        return addOnSuccessListener(TaskExecutors.uiThread(), r100);
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnSuccessListener(Executor r100, OnSuccessListener<TResult> r101) {
        return a(new h(r100, r101));
    }

    public final void b() {
        Object r100 = this.f276803a;
        monitor-enter(r100);
        Iterator<ExecuteResult<TResult>> r101 = this.f276808f.iterator();     // Catch: Throwable -> L18
    L6:
        if (r101.hasNext() == false) goto L15;
        r101.next().onComplete(this);     // Catch: Exception -> L10 RuntimeException -> L13 Throwable -> L18
    L13:
        e = move-exception;
        throw e;     // Catch: Throwable -> L18
    L10:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L18
    L15:
        this.f276808f = null;     // Catch: Throwable -> L18
        monitor-exit(r100);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWith(Executor r100, Continuation<TResult, TContinuationResult> r101) {
        i r102 = new i();
        addOnCompleteListener(r100, new e(this, r102, r101));
        return r102;
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor r100, Continuation<TResult, Task<TContinuationResult>> r101) {
        i r102 = new i();
        addOnCompleteListener(r100, new d(this, r101, r102));
        return r102;
    }

    @Override // com.huawei.hmf.tasks.Task
    public Exception getException() {
        Object r100 = this.f276803a;
        monitor-enter(r100);
        Exception r101 = this.f276807e;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.huawei.hmf.tasks.Task
    public TResult getResult() {
        Object r100 = this.f276803a;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f276807e != null) goto L10;
        TResult r101 = this.f276806d;     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return r101;
    L10:
        throw new RuntimeException(this.f276807e);     // Catch: Throwable -> L11
    }

    @Override // com.huawei.hmf.tasks.Task
    public final <E extends Throwable> TResult getResultThrowException(Class<E> r100) throws Throwable {
        Object r101 = this.f276803a;
        monitor-enter(r101);
        if (r100 == null) goto L11;
    L17:
        th = move-exception;
        throw th;
    L6:
        if (r100.isInstance(this.f276807e) == false) goto L11;
        throw r100.cast(this.f276807e);     // Catch: Throwable -> L17
    L11:
        if (this.f276807e != null) goto L16;
        TResult r102 = this.f276806d;     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
        return r102;
    L16:
        throw new RuntimeException(this.f276807e);     // Catch: Throwable -> L17
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isCanceled() {
        return this.f276805c;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isComplete() {
        Object r100 = this.f276803a;
        monitor-enter(r100);
        boolean r101 = this.f276804b;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.huawei.hmf.tasks.Task
    public boolean isSuccessful() {
        Object r100 = this.f276803a;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f276804b == true) goto L7;
    L11:
        boolean r101 = false;
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L14
        return r101;
    L7:
        if (this.f276805c == true) goto L11;
        if (this.f276807e != null) goto L11;
        r101 = true;
        goto L12
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnCanceledListener(OnCanceledListener r100) {
        return a(new com.huawei.hmf.tasks.a.b(TaskExecutors.uiThread(), r100));
    }

    @Override // com.huawei.hmf.tasks.Task
    public Task<TResult> addOnFailureListener(OnFailureListener r100) {
        return a(new f(TaskExecutors.uiThread(), r100));
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> r100) {
        Executor r101 = TaskExecutors.uiThread();
        i r102 = new i();
        addOnCompleteListener(r101, new e(this, r102, r100));
        return r102;
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> r100) {
        Executor r101 = TaskExecutors.uiThread();
        i r102 = new i();
        addOnCompleteListener(r101, new d(this, r100, r102));
        return r102;
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> r100) {
        Executor r101 = TaskExecutors.uiThread();
        i r102 = new i();
        addOnSuccessListener(r101, new a(this, r100, r102));
        addOnFailureListener(new b(this, r102));
        c r103 = new c(this, r102);
        a(new com.huawei.hmf.tasks.a.b(TaskExecutors.uiThread(), r103));
        return r102;
    }

    @Override // com.huawei.hmf.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor r100, SuccessContinuation<TResult, TContinuationResult> r101) {
        i r102 = new i();
        addOnSuccessListener(r100, new a(this, r101, r102));
        addOnFailureListener(new b(this, r102));
        c r103 = new c(this, r102);
        a(new com.huawei.hmf.tasks.a.b(TaskExecutors.uiThread(), r103));
        return r102;
    }
}
