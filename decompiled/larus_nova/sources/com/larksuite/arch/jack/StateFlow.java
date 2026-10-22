package com.larksuite.arch.jack;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0000\u0018\u0000 #*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u00042\u00020\u0005:\u0001#B#\b\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\rH\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002J\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0014\u001a\u00020\u0013J&\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rJ\u001a\u0010\u001a\u001a\u00020\u00052\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\rJ\u0015\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u000fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/larksuite/arch/jack/StateFlow;", ExifInterface.LATITUDE_SOUTH, "R", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Lcom/larksuite/arch/jack/Disposable;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observable", "Lcom/larksuite/arch/jack/StateObservable;", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lcom/larksuite/arch/jack/StateObservable;)V", "mapper", "Lkotlin/Function1;", "realSubscriber", "", "lastValue", "Ljava/lang/Object;", "distinctUntilChanged", "", "skipInit", "disposed", "requireSourceObserver", "requireOwner", "requireObserable", "map", "subscriber", "onChanged", "newValue", "(Ljava/lang/Object;)V", LiveCommonConstants.REASON_ON_DEDTROY, "lifecycleOwner", "dispose", "isDisposed", "()Z", "Companion", "jack_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StateFlow<S, R> implements Observer<S>, DefaultLifecycleObserver, c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f282786h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LifecycleOwner f282787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k<S> f282788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super S, ? extends R> f282789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super S, Unit> f282790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public S f282791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f282792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f282793g;

    public static final class a {
    }

    static {
    }

    public StateFlow() {
        throw null;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onCreate(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onCreate(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onPause(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onPause(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onResume(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onResume(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStart(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStart(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStop(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStop(this, r100);
    }

    @Override // com.larksuite.arch.jack.c
    public final void dispose() {
        if (this.f282793g == true) goto L13;
        this.f282793g = true;
        LifecycleOwner r100 = this.f282787a;
        if (r100 == null) goto L12;
        r100.getLifecycle().removeObserver(this);
        k<S> r101 = this.f282788b;
        if (r101 == null) goto L10;
        r101.a(this);
        goto L13
    L10:
        throw new IllegalArgumentException("cannot access observable after destroy".toString());
    L12:
        throw new IllegalArgumentException("cannot access owner after destroy".toString());
    L13:
        this.f282787a = null;
        this.f282788b = null;
        this.f282790d = null;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(S r100) {
        if (this.f282792f == false) goto L17;
        S r101 = this.f282791e;
        Function1<? super S, ? extends R> r102 = null;
        if (r101 == null) goto L10;
        Function1<? super S, ? extends R> r103 = this.f282789c;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mapper");
        r103 = null;
    L9:
        R r104 = r103.invoke(r101);
    L11:
        Function1<? super S, ? extends R> r105 = this.f282789c;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mapper");
    L16:
        if (Objects.equals(r104, r102.invoke(r100)) == false) goto L17;
        return;
    L14:
        r102 = r105;
        goto L16
    L10:
        r104 = null;
    L17:
        this.f282791e = r100;
        Function1<? super S, Unit> r106 = this.f282790d;
        if (r106 == null) goto L22;
        r106.invoke(r100);
        return;
    L22:
        throw new IllegalArgumentException("cannot access observer after destroy".toString());
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        dispose();
    }

    public StateFlow(LifecycleOwner r100, JackViewModel.a r101) {
        this.f282787a = r100;
        this.f282788b = r101;
    }
}
