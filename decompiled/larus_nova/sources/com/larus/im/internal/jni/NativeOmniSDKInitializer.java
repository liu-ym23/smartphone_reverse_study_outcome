package com.larus.im.internal.jni;

import com.flow.kmp.common.util.CoroutineExtKt;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\nH\u0002R\u0012\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/im/internal/jni/NativeOmniSDKInitializer;", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "<init>", "(Ljava/util/concurrent/locks/ReentrantLock;)V", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialize", "", "async", "", "initInternal", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeOmniSDKInitializer {
    public static final Companion Companion = null;
    private static final String TAG = "NativeOmniSDKInitializer";
    private final AtomicBoolean initialized;
    private final ReentrantLock lock;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/im/internal/jni/NativeOmniSDKInitializer$Companion;", "", "<init>", "()V", "TAG", "", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.larus.im.internal.jni.NativeOmniSDKInitializer$initialize$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.jni.NativeOmniSDKInitializer$initialize$1", f = "NativeOmniSDKInitializer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ NativeOmniSDKInitializer this$0;

        public AnonymousClass1(NativeOmniSDKInitializer r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            NativeOmniSDKInitializer.access$initInternal(this.this$0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final void initInternal() {
        if (this.initialized.get() == false) goto L5;
        return;
    L5:
        ReentrantLock r100 = this.lock;
        r100.lock();
    L22:
        th = move-exception;
        r100.unlock();
        throw th;
    L7:
        if (this.initialized.get() == false) goto L26;
        r100.unlock();
        return;
    L26:
        OmniFoundationInitializer.INSTANCE.initialize();     // Catch: Throwable -> L17
        OmniSoNameProvider.INSTANCE.loadIMLibraries();     // Catch: Throwable -> L17
        if (this.initialized.get() == false) goto L15;
        com.larus.im.internal.delegate.a.f348188b.i(TAG, "already initialized, skip repeat inject");     // Catch: Throwable -> L17
        r100.unlock();
        return;
    L15:
        com.larus.im.internal.delegate.a.f348188b.i(TAG, "init success");     // Catch: Throwable -> L17
        this.initialized.set(true);     // Catch: Throwable -> L17
    L19:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L22
        r100.unlock();
        return;
    L17:
        th = move-exception;
        com.larus.im.internal.delegate.a.f348188b.e(TAG, "init exception: " + th);     // Catch: Throwable -> L22
        this.initialized.set(false);     // Catch: Throwable -> L22
        goto L19
    }

    public NativeOmniSDKInitializer(ReentrantLock r100) {
        Intrinsics.checkNotNullParameter(r100, "lock");
        this.lock = r100;
        this.initialized = new AtomicBoolean(false);
    }

    public static final /* synthetic */ void access$initInternal(NativeOmniSDKInitializer r100) {
        r100.initInternal();
    }

    public final void initialize(boolean r100) {
        if (r100 == false) goto L4;
        CoroutineExtKt.a(new AnonymousClass1(this, null));
        return;
    L4:
        initInternal();
    }
}
