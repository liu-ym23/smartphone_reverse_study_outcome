package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes23.dex */
public class e<TResult> implements OnSuccessListener<TResult>, OnFailureListener, OnCanceledListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f276785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f276786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i<Void> f276787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f276788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Exception f276789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f276790f;

    public e(int r100, i<Void> r101) {
        this.f276785a = new Object();
        this.f276786b = r100;
        this.f276787c = r101;
    }

    public final void a() {
        if (this.f276788d >= this.f276786b) goto L5;
        return;
    L5:
        if (this.f276789e == null) goto L8;
        this.f276787c.a(new ExecutionException("a task failed", this.f276789e));
        return;
    L8:
        if (this.f276790f == false) goto L10;
        this.f276787c.a();
        return;
    L10:
        this.f276787c.a(null);
    }

    @Override // com.huawei.hmf.tasks.OnCanceledListener
    public void onCanceled() {
        Object r100 = this.f276785a;
        monitor-enter(r100);
        this.f276788d++;     // Catch: Throwable -> L7
        this.f276790f = true;     // Catch: Throwable -> L7
        a();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.huawei.hmf.tasks.OnFailureListener
    public void onFailure(Exception r100) {
        Object r101 = this.f276785a;
        monitor-enter(r101);
        this.f276788d++;     // Catch: Throwable -> L7
        this.f276789e = r100;     // Catch: Throwable -> L7
        a();     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.huawei.hmf.tasks.OnSuccessListener
    public void onSuccess(TResult r100) {
        Object r101 = this.f276785a;
        monitor-enter(r101);
        this.f276788d++;     // Catch: Throwable -> L7
        a();     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
