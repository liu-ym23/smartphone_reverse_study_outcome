package dv7;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.zzb;
import com.google.android.gms.common.api.internal.zzd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public final class v<TResult> extends Task<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f470201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s<TResult> f470202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f470203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f470204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TResult f470205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Exception f470206f;

    public static class a extends LifecycleCallback {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<WeakReference<r<?>>> f470207b;

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public final void a() {
            List<WeakReference<r<?>>> r100 = this.f470207b;
            monitor-enter(r100);
            Iterator r101 = ((ArrayList) this.f470207b).iterator();     // Catch: Throwable -> L13
        L6:
            if (r101.hasNext() == false) goto L10;
            r r102 = (r) ((WeakReference) r101.next()).get();     // Catch: Throwable -> L13
            if (r102 == null) goto L6;
            r102.cancel();     // Catch: Throwable -> L13
            goto L6
        L10:
            ((ArrayList) this.f470207b).clear();     // Catch: Throwable -> L13
            monitor-exit(r100);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        public a(yu7.b r100) {
            super(r100);
            this.f470207b = new ArrayList();
            r100.NB(this);
        }

        public static a b(Activity r100) {
            Preconditions.checkNotNull(r100, "Activity must not be null");
            if ((r100 instanceof FragmentActivity) == false) goto L22;
            FragmentActivity r101 = (FragmentActivity) r100;
            WeakHashMap r102 = zzd.f274480g;
            WeakReference r103 = (WeakReference) r102.get(r101);
            if (r103 == null) goto L44;
            zzd r104 = (zzd) r103.get();
            yu7.b r105 = r104;
            if (r104 == null) goto L44;
        L33:
            a r106 = (a) r105.hY(a.class);
            if (r106 == null) goto L36;
            return r106;
        L36:
            return new a(r105);
        L44:
            zzd r107 = (zzd) r101.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");     // Catch: ClassCastException -> L18
            if (r107 == null) goto L12;
            boolean r108 = r107.isRemoving();
            zzd r109 = r107;
            if (r108 == true) goto L12;
        L17:
            r102.put(r101, new WeakReference(r109));
            r105 = r109;
        L12:
            zzd r110 = new zzd();
            FragmentTransaction r111 = r101.getSupportFragmentManager().beginTransaction();
            boolean r112 = LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r111, r110, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "SupportLifecycleFragmentImpl", 0);
            FragmentTransaction r113 = r111;
            if (r112 == true) goto L16;
            r113 = r111.add(r110, "SupportLifecycleFragmentImpl");
        L16:
            r113.commitAllowingStateLoss();
            r109 = r110;
        L18:
            e = move-exception;
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
        L22:
            if ((r100 instanceof Activity) == false) goto L41;
            WeakHashMap r114 = zzb.f274476d;
            WeakReference r115 = (WeakReference) r114.get(r100);
            if (r115 == null) goto L42;
            zzb r116 = (zzb) r115.get();
            r105 = r116;
            if (r116 != null) goto L33;
        L42:
            zzb r117 = (zzb) r100.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");     // Catch: ClassCastException -> L37
            if (r117 == null) goto L31;
            boolean r118 = r117.isRemoving();
            zzb r119 = r117;
            if (r118 == true) goto L31;
        L32:
            r114.put(r100, new WeakReference(r119));
            r105 = r119;
        L31:
            zzb r120 = new zzb();
            r100.getFragmentManager().beginTransaction().add(r120, "LifecycleFragmentImpl").commitAllowingStateLoss();
            r119 = r120;
        L37:
            e = move-exception;
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
        L41:
            throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
        }

        public final <T> void c(r<T> r100) {
            List<WeakReference<r<?>>> r101 = this.f470207b;
            monitor-enter(r101);
            List<WeakReference<r<?>>> r102 = this.f470207b;     // Catch: Throwable -> L7
            ArrayList r103 = (ArrayList) r102;     // Catch: Throwable -> L7
            r103.add(new WeakReference(r100));     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public final void b() {
        Object r100 = this.f470201a;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f470203c == false) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L8:
        this.f470203c = true;     // Catch: Throwable -> L12
        this.f470204d = true;     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        this.f470202b.a(this);
    }

    public final void c() {
        Object r100 = this.f470201a;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f470203c == true) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L11
        this.f470202b.a(this);
    }

    @Override // com.google.android.gms.tasks.Task
    public final Exception getException() {
        Object r100 = this.f470201a;
        monitor-enter(r100);
        Exception r101 = this.f470206f;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.android.gms.tasks.Task
    public final TResult getResult() {
        Object r100 = this.f470201a;
        monitor-enter(r100);
        Preconditions.checkState(this.f470203c, "Task is not yet complete");     // Catch: Throwable -> L17
        if (this.f470204d == true) goto L14;
        if (this.f470206f != null) goto L12;
        TResult r101 = this.f470205e;     // Catch: Throwable -> L17
        monitor-exit(r100);     // Catch: Throwable -> L17
        return r101;
    L12:
        throw new RuntimeExecutionException(this.f470206f);     // Catch: Throwable -> L17
    L14:
        throw new CancellationException("Task is already canceled.");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isComplete() {
        Object r100 = this.f470201a;
        monitor-enter(r100);
        boolean r101 = this.f470203c;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isSuccessful() {
        Object r100 = this.f470201a;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f470203c == true) goto L7;
    L11:
        boolean r101 = false;
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L14
        return r101;
    L7:
        if (this.f470204d == true) goto L11;
        if (this.f470206f != null) goto L11;
        r101 = true;
        goto L12
    }

    public v() {
        this.f470201a = new Object();
        this.f470202b = new s();
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isCanceled() {
        return this.f470204d;
    }

    public final void a(Exception r100) {
        Preconditions.checkNotNull(r100, "Exception must not be null");
        Object r101 = this.f470201a;
        monitor-enter(r101);
        Preconditions.checkState(!this.f470203c, "Task is already complete");     // Catch: Throwable -> L8
        this.f470203c = true;     // Catch: Throwable -> L8
        this.f470206f = r100;     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        this.f470202b.a(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCanceledListener(b r100) {
        addOnCanceledListener(c.f470160a, r100);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> r100) {
        addOnCompleteListener(c.f470160a, r100);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnFailureListener(OnFailureListener r100) {
        addOnFailureListener(c.f470160a, r100);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> r100) {
        addOnSuccessListener(c.f470160a, r100);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> r100) {
        return continueWith(c.f470160a, r100);
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> r100) {
        return continueWithTask(c.f470160a, r100);
    }

    @Override // com.google.android.gms.tasks.Task
    public final <X extends Throwable> TResult getResult(Class<X> r100) throws Throwable {
        Object r101 = this.f470201a;
        monitor-enter(r101);
        Preconditions.checkState(this.f470203c, "Task is not yet complete");     // Catch: Throwable -> L21
        if (this.f470204d == true) goto L18;
        if (r100.isInstance(this.f470206f) == true) goto L16;
        if (this.f470206f != null) goto L14;
        TResult r102 = this.f470205e;     // Catch: Throwable -> L21
        monitor-exit(r101);     // Catch: Throwable -> L21
        return r102;
    L14:
        throw new RuntimeExecutionException(this.f470206f);     // Catch: Throwable -> L21
    L16:
        throw r100.cast(this.f470206f);     // Catch: Throwable -> L21
    L18:
        throw new CancellationException("Task is already canceled.");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> r100) {
        return onSuccessTask(c.f470160a, r100);
    }

    public final void setResult(TResult r100) {
        Object r101 = this.f470201a;
        monitor-enter(r101);
        Preconditions.checkState(!this.f470203c, "Task is already complete");     // Catch: Throwable -> L8
        this.f470203c = true;     // Catch: Throwable -> L8
        this.f470205e = r100;     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        this.f470202b.a(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCanceledListener(Activity r100, b r101) {
        h r102 = new h(c.f470160a, r101);
        this.f470202b.b(r102);
        a.b(r100).c(r102);
        c();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCompleteListener(Activity r100, OnCompleteListener<TResult> r101) {
        j r102 = new j(c.f470160a, r101);
        this.f470202b.b(r102);
        a.b(r100).c(r102);
        c();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnFailureListener(Activity r100, OnFailureListener r101) {
        l r102 = new l(c.f470160a, r101);
        this.f470202b.b(r102);
        a.b(r100).c(r102);
        c();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnSuccessListener(Activity r100, OnSuccessListener<? super TResult> r101) {
        n r102 = new n(c.f470160a, r101);
        this.f470202b.b(r102);
        a.b(r100).c(r102);
        c();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor r100, Continuation<TResult, TContinuationResult> r101) {
        v r102 = new v();
        this.f470202b.b(new d(r100, r101, r102));
        c();
        return r102;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor r100, Continuation<TResult, Task<TContinuationResult>> r101) {
        v r102 = new v();
        this.f470202b.b(new f(r100, r101, r102));
        c();
        return r102;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor r100, SuccessContinuation<TResult, TContinuationResult> r101) {
        v r102 = new v();
        this.f470202b.b(new p(r100, r101, r102));
        c();
        return r102;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCanceledListener(Executor r100, b r101) {
        this.f470202b.b(new h(r100, r101));
        c();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCompleteListener(Executor r100, OnCompleteListener<TResult> r101) {
        this.f470202b.b(new j(r100, r101));
        c();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnFailureListener(Executor r100, OnFailureListener r101) {
        this.f470202b.b(new l(r100, r101));
        c();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnSuccessListener(Executor r100, OnSuccessListener<? super TResult> r101) {
        this.f470202b.b(new n(r100, r101));
        c();
        return this;
    }
}
