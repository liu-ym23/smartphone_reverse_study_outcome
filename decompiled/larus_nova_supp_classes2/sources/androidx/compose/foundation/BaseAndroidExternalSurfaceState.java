package androidx.compose.foundation;

import android.view.Surface;
import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\"\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006Ju\u0010\t\u001a\u00020\u00142f\u0010\t\u001ab\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\n¢\u0006\u0002\b\u0016H\u0016¢\u0006\u0002\u0010\u001eJO\u0010\u001f\u001a\u00020\u0014*\u00020\f2A\u0010\u001f\u001a=\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u0016H\u0016J%\u0010 \u001a\u00020\u0014*\u00020\f2\u0017\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u001b¢\u0006\u0002\b\u0016H\u0016J\u001e\u0010!\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u001e\u0010\"\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010#\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRr\u0010\t\u001ad\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\n¢\u0006\u0002\b\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017RK\u0010\u0018\u001a?\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0019¢\u0006\u0002\b\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u001a\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001b¢\u0006\u0002\b\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/compose/foundation/BaseAndroidExternalSurfaceState;", "Landroidx/compose/foundation/AndroidExternalSurfaceScope;", "Landroidx/compose/foundation/SurfaceScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "onSurface", "Lkotlin/Function5;", "Landroidx/compose/foundation/SurfaceCoroutineScope;", "Landroid/view/Surface;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "surface", "", "width", "height", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function5;", "onSurfaceChanged", "Lkotlin/Function3;", "onSurfaceDestroyed", "Lkotlin/Function1;", "job", "Lkotlinx/coroutines/Job;", "(Lkotlin/jvm/functions/Function5;)V", "onChanged", "onDestroyed", "dispatchSurfaceCreated", "dispatchSurfaceChanged", "dispatchSurfaceDestroyed", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
abstract class BaseAndroidExternalSurfaceState implements AndroidExternalSurfaceScope, SurfaceScope {
    private Job job;
    private Function5<? super SurfaceCoroutineScope, ? super Surface, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> onSurface;
    private Function3<? super Surface, ? super Integer, ? super Integer, Unit> onSurfaceChanged;
    private Function1<? super Surface, Unit> onSurfaceDestroyed;
    private final CoroutineScope scope;

    /* JADX INFO: renamed from: androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1", f = "AndroidExternalSurface.android.kt", i = {0}, l = {130, 136}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $height;
        final /* synthetic */ Surface $surface;
        final /* synthetic */ int $width;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BaseAndroidExternalSurfaceState this$0;

        public AnonymousClass1(BaseAndroidExternalSurfaceState r1, Surface r2, int r3, int r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$surface = r2;
            this.$width = r3;
            this.$height = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass1 r6 = new AnonymousClass1(this.this$0, this.$surface, this.$width, this.$height, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r10);
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            CoroutineScope r2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r10);
        L15:
            BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1$receiver$1 r4 = new BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1$receiver$1(this.this$0, r2);
            Function5 r3 = BaseAndroidExternalSurfaceState.access$getOnSurface$p(this.this$0);
            if (r3 == null) goto L21;
            Surface r5 = this.$surface;
            Integer r6 = Boxing.boxInt(this.$width);
            Integer r7 = Boxing.boxInt(this.$height);
            this.L$0 = null;
            this.label = 2;
            if (r3.invoke(r4, r5, r6, r7, this) != r0) goto L21;
            return r0;
        L10:
            ResultKt.throwOnFailure(r10);
            r2 = (CoroutineScope) this.L$0;
            Job r11 = BaseAndroidExternalSurfaceState.access$getJob$p(this.this$0);
            if (r11 == null) goto L15;
            this.L$0 = r2;
            this.label = 1;
            if (JobKt.cancelAndJoin(r11, this) != r0) goto L15;
            return r0;
        }
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public BaseAndroidExternalSurfaceState(CoroutineScope r1) {
        this.scope = r1;
    }

    public static final /* synthetic */ Job access$getJob$p(BaseAndroidExternalSurfaceState r0) {
        return r0.job;
    }

    public static final /* synthetic */ Function5 access$getOnSurface$p(BaseAndroidExternalSurfaceState r0) {
        return r0.onSurface;
    }

    public final void dispatchSurfaceDestroyed(Surface r3) {
        Function1<? super Surface, Unit> r0 = this.onSurfaceDestroyed;
        if (r0 == null) goto L5;
        r0.invoke(r3);
    L5:
        Job r4 = this.job;
        if (r4 == null) goto L9;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
        return;
    }

    @Override // androidx.compose.foundation.AndroidExternalSurfaceScope
    public void onSurface(Function5<? super SurfaceCoroutineScope, ? super Surface, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> r1) {
        this.onSurface = r1;
    }

    @Override // androidx.compose.foundation.SurfaceScope
    public void onChanged(Surface r1, Function3<? super Surface, ? super Integer, ? super Integer, Unit> r2) {
        this.onSurfaceChanged = r2;
    }

    @Override // androidx.compose.foundation.SurfaceScope
    public void onDestroyed(Surface r1, Function1<? super Surface, Unit> r2) {
        this.onSurfaceDestroyed = r2;
    }

    public final void dispatchSurfaceChanged(Surface r2, int r3, int r4) {
        Function3<? super Surface, ? super Integer, ? super Integer, Unit> r0 = this.onSurfaceChanged;
        if (r0 == null) goto L6;
        r0.invoke(r2, Integer.valueOf(r3), Integer.valueOf(r4));
        return;
    }

    public final void dispatchSurfaceCreated(Surface r11, int r12, int r13) {
        if (this.onSurface == null) goto L6;
        this.job = BuildersKt.launch$default(this.scope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this, r11, r12, r13, null), 1, null);
        return;
    }
}
