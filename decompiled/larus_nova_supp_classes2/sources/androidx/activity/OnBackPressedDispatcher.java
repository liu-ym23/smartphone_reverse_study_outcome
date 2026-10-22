package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.autofill.HintConstants;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0004)*+,B\u0013\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0007J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\fH\u0007J\u0015\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\fH\u0001¢\u0006\u0002\b\u001aJ\b\u0010\u001b\u001a\u00020\u0014H\u0007J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\n\u001a\u00020\u0007H\u0007J\b\u0010 \u001a\u00020\u0014H\u0003J\b\u0010!\u001a\u00020\u0014H\u0007J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0003J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0003J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u000eH\u0007J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0007H\u0003J\b\u0010(\u001a\u00020\u0014H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher;", "", "fallbackOnBackPressed", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", "onHasEnabledCallbacksChanged", "Landroidx/core/util/Consumer;", "", "(Ljava/lang/Runnable;Landroidx/core/util/Consumer;)V", "backInvokedCallbackRegistered", "hasEnabledCallbacks", "inProgressCallback", "Landroidx/activity/OnBackPressedCallback;", "invokedDispatcher", "Landroid/window/OnBackInvokedDispatcher;", "onBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "onBackPressedCallbacks", "Lkotlin/collections/ArrayDeque;", "addCallback", "", "onBackPressedCallback", "owner", "Landroidx/lifecycle/LifecycleOwner;", "addCancellableCallback", "Landroidx/activity/Cancellable;", "addCancellableCallback$activity_release", "dispatchOnBackCancelled", "dispatchOnBackProgressed", "backEvent", "Landroidx/activity/BackEventCompat;", "dispatchOnBackStarted", "onBackCancelled", "onBackPressed", "onBackProgressed", "onBackStarted", "setOnBackInvokedDispatcher", "invoker", "updateBackInvokedCallbackState", "shouldBeRegistered", "updateEnabledCallbacks", "Api33Impl", "Api34Impl", "LifecycleOnBackPressedCancellable", "OnBackPressedCancellable", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OnBackPressedDispatcher {
    private boolean backInvokedCallbackRegistered;
    private final Runnable fallbackOnBackPressed;
    private boolean hasEnabledCallbacks;
    private OnBackPressedCallback inProgressCallback;
    private OnBackInvokedDispatcher invokedDispatcher;
    private OnBackInvokedCallback onBackInvokedCallback;
    private final ArrayDeque<OnBackPressedCallback> onBackPressedCallbacks;
    private final Consumer<Boolean> onHasEnabledCallbacksChanged;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J \u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0007J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0007¨\u0006\u000e"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$Api33Impl;", "", "()V", "createOnBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "onBackInvoked", "Lkotlin/Function0;", "", "registerOnBackInvokedCallback", "dispatcher", "priority", "", "callback", "unregisterOnBackInvokedCallback", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api33Impl {
        public static final Api33Impl INSTANCE = null;

        static {
            INSTANCE = new Api33Impl();
        }

        private Api33Impl() {
        }

        public static /* synthetic */ void a(Function0 r0) {
            createOnBackInvokedCallback$lambda$0(r0);
        }

        private static final void createOnBackInvokedCallback$lambda$0(Function0 r1) {
            Intrinsics.checkNotNullParameter(r1, "$onBackInvoked");
            r1.invoke();
        }

        public final OnBackInvokedCallback createOnBackInvokedCallback(final Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "onBackInvoked");
            return new h(r2);
        }

        public final void unregisterOnBackInvokedCallback(Object r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "dispatcher");
            Intrinsics.checkNotNullParameter(r3, "callback");
            ((OnBackInvokedDispatcher) r2).unregisterOnBackInvokedCallback((OnBackInvokedCallback) r3);
        }

        public final void registerOnBackInvokedCallback(Object r2, int r3, Object r4) {
            Intrinsics.checkNotNullParameter(r2, "dispatcher");
            Intrinsics.checkNotNullParameter(r4, "callback");
            ((OnBackInvokedDispatcher) r2).registerOnBackInvokedCallback(r3, (OnBackInvokedCallback) r4);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jj\u0010\u0003\u001a\u00020\u00042!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00062!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0007¨\u0006\u0010"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$Api34Impl;", "", "()V", "createOnBackAnimationCallback", "Landroid/window/OnBackInvokedCallback;", "onBackStarted", "Lkotlin/Function1;", "Landroidx/activity/BackEventCompat;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "backEvent", "", "onBackProgressed", "onBackInvoked", "Lkotlin/Function0;", "onBackCancelled", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api34Impl {
        public static final Api34Impl INSTANCE = null;

        static {
            INSTANCE = new Api34Impl();
        }

        private Api34Impl() {
        }

        public final OnBackInvokedCallback createOnBackAnimationCallback(final Function1<? super BackEventCompat, Unit> r2, final Function1<? super BackEventCompat, Unit> r3, final Function0<Unit> r4, final Function0<Unit> r5) {
            Intrinsics.checkNotNullParameter(r2, "onBackStarted");
            Intrinsics.checkNotNullParameter(r3, "onBackProgressed");
            Intrinsics.checkNotNullParameter(r4, "onBackInvoked");
            Intrinsics.checkNotNullParameter(r5, "onBackCancelled");
            return new OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1(r2, r3, r4, r5);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$LifecycleOnBackPressedCancellable;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/activity/Cancellable;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/lifecycle/Lifecycle;Landroidx/activity/OnBackPressedCallback;)V", "currentCancellable", "cancel", "", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {
        private Cancellable currentCancellable;
        private final Lifecycle lifecycle;
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.lifecycle.removeObserver(this);
            this.onBackPressedCallback.removeCancellable(this);
            Cancellable r0 = this.currentCancellable;
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            this.currentCancellable = null;
        }

        public void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
            Intrinsics.checkNotNullParameter(r2, "source");
            Intrinsics.checkNotNullParameter(r3, "event");
            if (r3 != Lifecycle.Event.ON_START) goto L6;
            this.currentCancellable = this.this$0.addCancellableCallback$activity_release(this.onBackPressedCallback);
            return;
        L6:
            if (r3 != Lifecycle.Event.ON_STOP) goto L11;
            Cancellable r4 = this.currentCancellable;
            if (r4 == null) goto L15;
            r4.cancel();
            return;
        L15:
            return;
        L11:
            if (r3 != Lifecycle.Event.ON_DESTROY) goto L17;
            cancel();
            return;
        }

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher r2, Lifecycle r3, OnBackPressedCallback r4) {
            Intrinsics.checkNotNullParameter(r3, "lifecycle");
            Intrinsics.checkNotNullParameter(r4, "onBackPressedCallback");
            this.this$0 = r2;
            this.lifecycle = r3;
            this.onBackPressedCallback = r4;
            r3.addObserver(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$OnBackPressedCancellable;", "Landroidx/activity/Cancellable;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/activity/OnBackPressedCallback;)V", "cancel", "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class OnBackPressedCancellable implements Cancellable {
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        @Override // androidx.activity.Cancellable
        public void cancel() {
            OnBackPressedDispatcher.access$getOnBackPressedCallbacks$p(this.this$0).remove(this.onBackPressedCallback);
            if (Intrinsics.areEqual(OnBackPressedDispatcher.access$getInProgressCallback$p(this.this$0), this.onBackPressedCallback) == false) goto L5;
            this.onBackPressedCallback.handleOnBackCancelled();
            OnBackPressedDispatcher.access$setInProgressCallback$p(this.this$0, null);
        L5:
            this.onBackPressedCallback.removeCancellable(this);
            Function0 r0 = this.onBackPressedCallback.getEnabledChangedCallback$activity_release();
            if (r0 == null) goto L8;
            r0.invoke();
        L8:
            this.onBackPressedCallback.setEnabledChangedCallback$activity_release(null);
        }

        public OnBackPressedCancellable(OnBackPressedDispatcher r2, OnBackPressedCallback r3) {
            Intrinsics.checkNotNullParameter(r3, "onBackPressedCallback");
            this.this$0 = r2;
            this.onBackPressedCallback = r3;
        }
    }

    /* JADX INFO: renamed from: androidx.activity.OnBackPressedDispatcher$addCallback$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class C00791 extends FunctionReferenceImpl implements Function0<Unit> {
        public C00791(Object r8) {
            super(0, r8, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m48invoke() {
            OnBackPressedDispatcher.access$updateEnabledCallbacks((OnBackPressedDispatcher) ((CallableReference) this).receiver);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m48invoke();
            return Unit.INSTANCE;
        }
    }

    public OnBackPressedDispatcher() {
        Runnable r0 = null;
        this(r0, 1, r0);
    }

    private final void onBackCancelled() {
        ArrayDeque<OnBackPressedCallback> r0 = this.onBackPressedCallbacks;
        ListIterator r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        Object r2 = r1.previous();
        if (((OnBackPressedCallback) r2).isEnabled() == false) goto L4;
    L9:
        OnBackPressedCallback r3 = (OnBackPressedCallback) r2;
        this.inProgressCallback = null;
        if (r3 == null) goto L16;
        r3.handleOnBackCancelled();
        return;
    L16:
        return;
    L8:
        r2 = null;
        goto L9
    }

    private final void updateEnabledCallbacks() {
        boolean r0 = this.hasEnabledCallbacks;
        ArrayDeque<OnBackPressedCallback> r1 = this.onBackPressedCallbacks;
        boolean r3 = false;
        if ((r1 instanceof Collection) == true) goto L5;
    L7:
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        if (((OnBackPressedCallback) r2.next()).isEnabled() == false) goto L9;
        r3 = true;
    L13:
        this.hasEnabledCallbacks = r3;
        if (r3 == r0) goto L25;
        Consumer<Boolean> r4 = this.onHasEnabledCallbacksChanged;
        if (r4 == null) goto L19;
        r4.accept(Boolean.valueOf(r3));
    L19:
        if (Build.VERSION.SDK_INT < 33) goto L26;
        updateBackInvokedCallbackState(r3);
        return;
    L26:
        return;
    L25:
        return;
    L5:
        if (r1.isEmpty() == false) goto L7;
        goto L7
    }

    public final void onBackPressed() {
        ArrayDeque<OnBackPressedCallback> r0 = this.onBackPressedCallbacks;
        ListIterator r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        Object r2 = r1.previous();
        if (((OnBackPressedCallback) r2).isEnabled() == false) goto L4;
    L9:
        OnBackPressedCallback r3 = (OnBackPressedCallback) r2;
        this.inProgressCallback = null;
        if (r3 == null) goto L13;
        r3.handleOnBackPressed();
        return;
    L13:
        Runnable r4 = this.fallbackOnBackPressed;
        if (r4 == null) goto L20;
        r4.run();
        return;
    L20:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final void dispatchOnBackCancelled() {
        onBackCancelled();
    }

    public final boolean hasEnabledCallbacks() {
        return this.hasEnabledCallbacks;
    }

    public OnBackPressedDispatcher(Runnable r2) {
        this(r2, null);
    }

    public static final /* synthetic */ OnBackPressedCallback access$getInProgressCallback$p(OnBackPressedDispatcher r0) {
        return r0.inProgressCallback;
    }

    public static final /* synthetic */ ArrayDeque access$getOnBackPressedCallbacks$p(OnBackPressedDispatcher r0) {
        return r0.onBackPressedCallbacks;
    }

    public static final /* synthetic */ void access$onBackCancelled(OnBackPressedDispatcher r0) {
        r0.onBackCancelled();
    }

    public static final /* synthetic */ void access$updateEnabledCallbacks(OnBackPressedDispatcher r0) {
        r0.updateEnabledCallbacks();
    }

    private final void onBackProgressed(BackEventCompat r4) {
        ArrayDeque<OnBackPressedCallback> r0 = this.onBackPressedCallbacks;
        ListIterator r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        Object r2 = r1.previous();
        if (((OnBackPressedCallback) r2).isEnabled() == false) goto L4;
    L9:
        OnBackPressedCallback r3 = (OnBackPressedCallback) r2;
        if (r3 == null) goto L16;
        r3.handleOnBackProgressed(r4);
        return;
    L16:
        return;
    L8:
        r2 = null;
        goto L9
    }

    private final void onBackStarted(BackEventCompat r4) {
        ArrayDeque<OnBackPressedCallback> r0 = this.onBackPressedCallbacks;
        ListIterator r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        Object r2 = r1.previous();
        if (((OnBackPressedCallback) r2).isEnabled() == false) goto L4;
    L9:
        OnBackPressedCallback r3 = (OnBackPressedCallback) r2;
        this.inProgressCallback = r3;
        if (r3 == null) goto L16;
        r3.handleOnBackStarted(r4);
        return;
    L16:
        return;
    L8:
        r2 = null;
        goto L9
    }

    private final void updateBackInvokedCallbackState(boolean r5) {
        OnBackInvokedDispatcher r0 = this.invokedDispatcher;
        OnBackInvokedCallback r1 = this.onBackInvokedCallback;
        if (r0 == null) goto L15;
        if (r1 != null) goto L6;
        return;
    L6:
        if (r5 == true) goto L8;
    L10:
        if (r5 == false) goto L12;
        return;
    L12:
        if (this.backInvokedCallbackRegistered == false) goto L19;
        Api33Impl.INSTANCE.unregisterOnBackInvokedCallback(r0, r1);
        this.backInvokedCallbackRegistered = false;
        return;
    L19:
        return;
    L8:
        if (this.backInvokedCallbackRegistered == true) goto L10;
        Api33Impl.INSTANCE.registerOnBackInvokedCallback(r0, 0, r1);
        this.backInvokedCallbackRegistered = true;
        return;
    }

    public final void addCallback(OnBackPressedCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "onBackPressedCallback");
        addCancellableCallback$activity_release(r2);
    }

    public final Cancellable addCancellableCallback$activity_release(OnBackPressedCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "onBackPressedCallback");
        this.onBackPressedCallbacks.add(r3);
        OnBackPressedCancellable r0 = new OnBackPressedCancellable(this, r3);
        r3.addCancellable(r0);
        updateEnabledCallbacks();
        r3.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return r0;
    }

    public final void dispatchOnBackProgressed(BackEventCompat r2) {
        Intrinsics.checkNotNullParameter(r2, "backEvent");
        onBackProgressed(r2);
    }

    public final void dispatchOnBackStarted(BackEventCompat r2) {
        Intrinsics.checkNotNullParameter(r2, "backEvent");
        onBackStarted(r2);
    }

    public final void setOnBackInvokedDispatcher(OnBackInvokedDispatcher r2) {
        Intrinsics.checkNotNullParameter(r2, "invoker");
        this.invokedDispatcher = r2;
        updateBackInvokedCallbackState(this.hasEnabledCallbacks);
    }

    public OnBackPressedDispatcher(Runnable r4, Consumer<Boolean> r5) {
        this.fallbackOnBackPressed = r4;
        this.onHasEnabledCallbacksChanged = r5;
        this.onBackPressedCallbacks = new ArrayDeque();
        int r6 = Build.VERSION.SDK_INT;
        if (r6 >= 33) goto L5;
        return;
    L5:
        if (r6 < 34) goto L7;
        OnBackInvokedCallback r7 = Api34Impl.INSTANCE.createOnBackAnimationCallback(new AnonymousClass1(this), new AnonymousClass2(this), new AnonymousClass3(this), new AnonymousClass4(this));
    L8:
        this.onBackInvokedCallback = r7;
        return;
    L7:
        r7 = Api33Impl.INSTANCE.createOnBackInvokedCallback(new AnonymousClass5(this));
        goto L8
    }

    public static final /* synthetic */ void access$onBackProgressed(OnBackPressedDispatcher r0, BackEventCompat r1) {
        r0.onBackProgressed(r1);
    }

    public static final /* synthetic */ void access$onBackStarted(OnBackPressedDispatcher r0, BackEventCompat r1) {
        r0.onBackStarted(r1);
    }

    public static final /* synthetic */ void access$setInProgressCallback$p(OnBackPressedDispatcher r0, OnBackPressedCallback r1) {
        r0.inProgressCallback = r1;
    }

    public final void addCallback(LifecycleOwner r3, OnBackPressedCallback r4) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        Intrinsics.checkNotNullParameter(r4, "onBackPressedCallback");
        Lifecycle r5 = r3.getLifecycle();
        if (r5.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        r4.addCancellable(new LifecycleOnBackPressedCancellable(this, r5, r4));
        updateEnabledCallbacks();
        r4.setEnabledChangedCallback$activity_release(new C00791(this));
    }

    public /* synthetic */ OnBackPressedDispatcher(Runnable r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
