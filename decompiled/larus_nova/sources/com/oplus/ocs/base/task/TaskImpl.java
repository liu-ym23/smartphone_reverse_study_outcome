package com.oplus.ocs.base.task;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes34.dex */
public class TaskImpl<TResult> extends Task<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f404257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TResult f404258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Exception f404259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private q<TResult> f404260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f404261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f404262f;

    private void a() {
        Object r100 = this.f404257a;
        monitor-enter(r100);
        com.oplus.ocs.base.utils.d.a(this.f404261e, "Task is not yet complete");     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void b() {
        Object r100 = this.f404257a;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f404261e == true) goto L7;
        boolean r101 = true;
    L8:
        com.oplus.ocs.base.utils.d.a(r101, "Task is already complete");     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L7:
        r101 = false;
        goto L8
    }

    private void c() {
        if (this.f404262f == true) goto L6;
        return;
    L6:
        throw new CancellationException("Task is already canceled.");
    }

    private void d() {
        Object r100 = this.f404257a;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f404261e == false) goto L7;
        this.f404260d.a(this);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    @Override // com.oplus.ocs.base.task.Task
    public Exception getException() {
        Object r100 = this.f404257a;
        monitor-enter(r100);
        Exception r101 = this.f404259c;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.oplus.ocs.base.task.Task
    public TResult getResult() {
        Object r100 = this.f404257a;
        monitor-enter(r100);
        a();     // Catch: Throwable -> L11
        c();     // Catch: Throwable -> L11
        if (this.f404259c != null) goto L10;
        TResult r101 = this.f404258b;     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return r101;
    L10:
        throw new RuntimeException(this.f404259c);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.oplus.ocs.base.task.Task
    public boolean isComplete() {
        Object r100 = this.f404257a;
        monitor-enter(r100);
        boolean r101 = this.f404261e;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.oplus.ocs.base.task.Task
    public boolean isSuccessful() {
        Object r100 = this.f404257a;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f404261e == true) goto L7;
    L11:
        boolean r101 = false;
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L14
        return r101;
    L7:
        if (this.f404262f == true) goto L11;
        if (this.f404259c != null) goto L11;
        r101 = true;
        goto L12
    }

    public boolean tryCancel() {
        Object r100 = this.f404257a;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f404261e == false) goto L7;
        boolean r101 = false;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L7:
        r101 = true;
        this.f404261e = true;     // Catch: Throwable -> L10
        this.f404262f = true;     // Catch: Throwable -> L10
        this.f404260d.a(this);     // Catch: Throwable -> L10
        goto L8
    }

    public TaskImpl() {
        this.f404257a = new Object();
        this.f404260d = new q();
    }

    @Override // com.oplus.ocs.base.task.Task
    public boolean isCanceled() {
        return this.f404262f;
    }

    @Override // com.oplus.ocs.base.task.Task
    public Task<TResult> addOnCanceledListener(OnCanceledListener r100) {
        com.oplus.ocs.base.utils.d.a(r100, "OnCanceledListener is not null");
        return addOnCanceledListener(TaskExecutors.MAIN_THREAD, r100);
    }

    @Override // com.oplus.ocs.base.task.Task
    public Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> r100) {
        com.oplus.ocs.base.utils.d.a(r100, "OnCompleteListener is not null");
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, r100);
    }

    @Override // com.oplus.ocs.base.task.Task
    public Task<TResult> addOnFailureListener(OnFailureListener r100) {
        com.oplus.ocs.base.utils.d.a(r100, "OnFailureListener is not null");
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, r100);
    }

    @Override // com.oplus.ocs.base.task.Task
    public Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> r100) {
        com.oplus.ocs.base.utils.d.a(r100, "OnSuccessListener is not null");
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, r100);
    }

    @Override // com.oplus.ocs.base.task.Task
    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> r100) {
        com.oplus.ocs.base.utils.d.a(r100, "Continuation is not null");
        return continueWith(TaskExecutors.MAIN_THREAD, r100);
    }

    @Override // com.oplus.ocs.base.task.Task
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> r100) {
        com.oplus.ocs.base.utils.d.a(r100, "Continuation is not null");
        return continueWithTask(TaskExecutors.MAIN_THREAD, r100);
    }

    @Override // com.oplus.ocs.base.task.Task
    public <X extends Throwable> TResult getResult(Class<X> r100) throws Throwable {
        Object r101 = this.f404257a;
        monitor-enter(r101);
        a();     // Catch: Throwable -> L15
        c();     // Catch: Throwable -> L15
        if (r100.isInstance(this.f404259c) == true) goto L14;
        if (this.f404259c != null) goto L12;
        TResult r102 = this.f404258b;     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        return r102;
    L12:
        throw new RuntimeException(this.f404259c);     // Catch: Throwable -> L15
    L14:
        throw r100.cast(this.f404259c);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.oplus.ocs.base.task.Task
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> r100) {
        com.oplus.ocs.base.utils.d.a(r100, "SuccessContinuation is not null");
        return onSuccessTask(TaskExecutors.MAIN_THREAD, r100);
    }

    public void setException(Exception r100) {
        com.oplus.ocs.base.utils.d.a(r100, "Exception must not be null");
        Object r101 = this.f404257a;
        monitor-enter(r101);
        b();     // Catch: Throwable -> L8
        this.f404261e = true;     // Catch: Throwable -> L8
        this.f404259c = r100;     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        this.f404260d.a(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void setResult(TResult r100) {
        Object r101 = this.f404257a;
        monitor-enter(r101);
        b();     // Catch: Throwable -> L8
        this.f404261e = true;     // Catch: Throwable -> L8
        this.f404258b = r100;     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        this.f404260d.a(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean trySetException(Exception r100) {
        com.oplus.ocs.base.utils.d.a(r100, "Exception must not be null");
        com.oplus.ocs.base.utils.d.a(r100, "Exception must not be null");
        Object r101 = this.f404257a;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f404261e == false) goto L7;
        boolean r102 = false;
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r102;
    L7:
        this.f404261e = true;     // Catch: Throwable -> L10
        this.f404259c = r100;     // Catch: Throwable -> L10
        this.f404260d.a(this);     // Catch: Throwable -> L10
        r102 = true;
        goto L8
    }

    public boolean trySetResult(TResult r100) {
        Object r101 = this.f404257a;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f404261e == false) goto L7;
        boolean r102 = false;
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r102;
    L7:
        this.f404261e = true;     // Catch: Throwable -> L10
        this.f404258b = r100;     // Catch: Throwable -> L10
        this.f404260d.a(this);     // Catch: Throwable -> L10
        r102 = true;
        goto L8
    }

    @Override // com.oplus.ocs.base.task.Task
    public Task<TResult> addOnCanceledListener(Executor r100, OnCanceledListener r101) {
        com.oplus.ocs.base.utils.d.a(r100, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(r101, "OnCanceledListener is not null");
        this.f404260d.a(new d(r100, r101));
        d();
        return this;
    }

    @Override // com.oplus.ocs.base.task.Task
    public Task<TResult> addOnCompleteListener(Executor r100, OnCompleteListener<TResult> r101) {
        com.oplus.ocs.base.utils.d.a(r100, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(r101, "OnCompleteListener is not null");
        this.f404260d.a(new f(r100, r101));
        d();
        return this;
    }

    @Override // com.oplus.ocs.base.task.Task
    public Task<TResult> addOnFailureListener(Executor r100, OnFailureListener r101) {
        com.oplus.ocs.base.utils.d.a(r100, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(r101, "OnFailureListener is not null");
        this.f404260d.a(new h(r100, r101));
        d();
        return this;
    }

    @Override // com.oplus.ocs.base.task.Task
    public Task<TResult> addOnSuccessListener(Executor r100, OnSuccessListener<? super TResult> r101) {
        com.oplus.ocs.base.utils.d.a(r100, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(r101, "OnSuccessListener is not null");
        this.f404260d.a(new j(r100, r101));
        d();
        return this;
    }

    @Override // com.oplus.ocs.base.task.Task
    public <TContinuationResult> Task<TContinuationResult> continueWith(Executor r100, Continuation<TResult, TContinuationResult> r101) {
        com.oplus.ocs.base.utils.d.a(r100, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(r101, "Continuation is not null");
        TaskImpl r102 = new TaskImpl();
        this.f404260d.a(new c(r100, r101, r102));
        d();
        return r102;
    }

    @Override // com.oplus.ocs.base.task.Task
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor r100, Continuation<TResult, Task<TContinuationResult>> r101) {
        com.oplus.ocs.base.utils.d.a(r100, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(r101, "Continuation is not null");
        TaskImpl r102 = new TaskImpl();
        this.f404260d.a(new c(r100, r101, r102));
        d();
        return r102;
    }

    @Override // com.oplus.ocs.base.task.Task
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor r100, SuccessContinuation<TResult, TContinuationResult> r101) {
        com.oplus.ocs.base.utils.d.a(r100, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(r101, "SuccessContinuation is not null");
        TaskImpl r102 = new TaskImpl();
        this.f404260d.a(new m(r100, r101, r102));
        d();
        return r102;
    }
}
