package com.github.alexzhirkevich.customqrgenerator;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J=\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H¦Bø\u0001\u0000¢\u0006\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/ThreadPolicy;", "", "", "width", "height", "Lkotlin/Function2;", "Lkotlin/ranges/IntRange;", "", "block", AbsMethodDelegate.TAG_INVOKE, "(IILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SingleThread", "DoubleThread", "QuadThread", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0})
public abstract enum ThreadPolicy extends Enum<ThreadPolicy> {
    public static final ThreadPolicy DoubleThread = null;
    public static final ThreadPolicy QuadThread = null;
    public static final ThreadPolicy SingleThread = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThreadPolicy[] f274240a = null;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\bH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/ThreadPolicy$DoubleThread;", "Lcom/github/alexzhirkevich/customqrgenerator/ThreadPolicy;", AbsMethodDelegate.TAG_INVOKE, "", "width", "", "height", "block", "Lkotlin/Function2;", "Lkotlin/ranges/IntRange;", "(IILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DoubleThread extends ThreadPolicy {
        public DoubleThread(String r100, int r101) {
            super(r100, r101, null);
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.ThreadPolicy
        public Object invoke(int r100, int r101, Function2<? super IntRange, ? super IntRange, Unit> r102, Continuation<? super Unit> r103) {
            if ((r103 instanceof ThreadPolicy$DoubleThread$invoke$1) == false) goto L7;
            ThreadPolicy$DoubleThread$invoke$1 r104 = (ThreadPolicy$DoubleThread$invoke$1) r103;
            int r105 = r104.label;
            if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
            r104.label = r105 - Integer.MIN_VALUE;
        L8:
            Object r106 = r104.result;
            Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r108 = r104.label;
            if (r108 == 0) goto L16;
            if (r108 == 1) goto L15;
            if (r108 != 2) goto L14;
            ResultKt.throwOnFailure(r106);
        L23:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r106);
        L19:
            r104.label = 2;
            if (AwaitKt.c((Collection) r106, r104) != r107) goto L23;
            return r107;
        L16:
            ResultKt.throwOnFailure(r106);
            ThreadPolicy$DoubleThread$invoke$2 r109 = new ThreadPolicy$DoubleThread$invoke$2(r100, r101, r102, null);
            r104.label = 1;
            r106 = CoroutineScopeKt.coroutineScope(r109, r104);
            if (r106 != r107) goto L19;
            return r107;
        L7:
            r104 = new ThreadPolicy$DoubleThread$invoke$1(this, r103);
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0001\u0018\u00002\u00020\u0001J;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\bH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/ThreadPolicy$QuadThread;", "Lcom/github/alexzhirkevich/customqrgenerator/ThreadPolicy;", AbsMethodDelegate.TAG_INVOKE, "", "width", "", "height", "block", "Lkotlin/Function2;", "Lkotlin/ranges/IntRange;", "(IILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class QuadThread extends ThreadPolicy {
        public QuadThread(String r100, int r101) {
            super(r100, r101, null);
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.ThreadPolicy
        public Object invoke(int r100, int r101, Function2<? super IntRange, ? super IntRange, Unit> r102, Continuation<? super Unit> r103) {
            if ((r103 instanceof ThreadPolicy$QuadThread$invoke$1) == false) goto L7;
            ThreadPolicy$QuadThread$invoke$1 r104 = (ThreadPolicy$QuadThread$invoke$1) r103;
            int r105 = r104.label;
            if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
            r104.label = r105 - Integer.MIN_VALUE;
        L8:
            Object r106 = r104.result;
            Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r108 = r104.label;
            if (r108 == 0) goto L16;
            if (r108 == 1) goto L15;
            if (r108 != 2) goto L14;
            ResultKt.throwOnFailure(r106);
        L23:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r106);
        L19:
            r104.label = 2;
            if (AwaitKt.c((Collection) r106, r104) != r107) goto L23;
            return r107;
        L16:
            ResultKt.throwOnFailure(r106);
            ThreadPolicy$QuadThread$invoke$2 r109 = new ThreadPolicy$QuadThread$invoke$2(r100, r101, r102, null);
            r104.label = 1;
            r106 = CoroutineScopeKt.coroutineScope(r109, r104);
            if (r106 != r107) goto L19;
            return r107;
        L7:
            r104 = new ThreadPolicy$QuadThread$invoke$1(this, r103);
            goto L8
        }
    }

    public ThreadPolicy() {
        throw null;
    }

    public static ThreadPolicy valueOf(String r100) {
        return (ThreadPolicy) r27.a.a(ThreadPolicy.class, r100);
    }

    public static ThreadPolicy[] values() {
        return (ThreadPolicy[]) f274240a.clone();
    }

    public abstract Object invoke(int r100, int r101, Function2<? super IntRange, ? super IntRange, Unit> r102, Continuation<? super Unit> r103);

    static {
        final String r100 = "SingleThread";
        final int r101 = 0;
        ThreadPolicy r102 = new SingleThread(r100, r101);
        SingleThread = r102;
        DoubleThread r103 = new DoubleThread("DoubleThread", 1);
        DoubleThread = r103;
        QuadThread r104 = new QuadThread("QuadThread", 2);
        QuadThread = r104;
        f274240a = new ThreadPolicy[]{r102, r103, r104};
    }

    public ThreadPolicy(String r100, int r101, DefaultConstructorMarker r102) {
        super(r100, r101);
    }
}
