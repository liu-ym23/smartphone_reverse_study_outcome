package androidx.compose.foundation.lazy.layout;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "<init>", "()V", "wasPositioned", "", "continuations", "", "Lkotlin/coroutines/Continuation;", "", "lock", "Lkotlinx/coroutines/CompletableDeferred;", "waitForFirstLayout", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AwaitFirstLayoutModifier implements OnGloballyPositionedModifier {
    public static final int $stable = 0;
    private final List<Continuation<Unit>> continuations;
    private final CompletableDeferred<Unit> lock;
    private boolean wasPositioned;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier", f = "AwaitFirstLayoutModifier.kt", i = {1}, l = {42, 70}, m = "waitForFirstLayout", n = {"continuation"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AwaitFirstLayoutModifier this$0;

        public AnonymousClass1(AwaitFirstLayoutModifier r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.waitForFirstLayout(this);
        }
    }

    public final /* synthetic */ boolean all(Function1 r1) {
        return Modifier.Element.-CC.$default$all(this, r1);
    }

    public final /* synthetic */ boolean any(Function1 r1) {
        return Modifier.Element.-CC.$default$any(this, r1);
    }

    public final /* synthetic */ Object foldIn(Object r1, Function2 r2) {
        return Modifier.Element.-CC.$default$foldIn(this, r1, r2);
    }

    public final /* synthetic */ Object foldOut(Object r1, Function2 r2) {
        return Modifier.Element.-CC.$default$foldOut(this, r1, r2);
    }

    public final /* synthetic */ Modifier then(Modifier r1) {
        return Modifier.-CC.$default$then(this, r1);
    }

    public AwaitFirstLayoutModifier() {
        this.continuations = new ArrayList();
        this.lock = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    }

    public static final /* synthetic */ List access$getContinuations$p(AwaitFirstLayoutModifier r0) {
        return r0.continuations;
    }

    public void onGloballyPositioned(LayoutCoordinates r5) {
        if (this.wasPositioned == true) goto L13;
        this.wasPositioned = true;
        if (ComposeFoundationFlags.isAwaitFirstLayoutModifierFixEnabled == false) goto L7;
        this.lock.complete(Unit.INSTANCE);
        return;
    L7:
        List<Continuation<Unit>> r6 = this.continuations;
        int r0 = r6.size();
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L10;
        Continuation r2 = (Continuation) ListProtector.get(r6, r1);
        Result.Companion r3 = Result.Companion;
        r2.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        r1 = r1 + 1;
        goto L8
    L10:
        this.continuations.clear();
        return;
    }

    public final Object waitForFirstLayout(Continuation<? super Unit> r7) {
        if ((r7 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r7;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        Ref.ObjectRef r4 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L15
    L36:
        List<Continuation<Unit>> r9 = this.continuations;
        Object r5 = r4.element;
        TypeIntrinsics.asMutableCollection(r9).remove(r5);
    L42:
        return Unit.INSTANCE;
    L15:
        Throwable th = th;
    L39:
        List<Continuation<Unit>> r6 = this.continuations;
        Object r10 = r4.element;
        TypeIntrinsics.asMutableCollection(r6).remove(r10);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r8);
    L28:
        return Unit.INSTANCE;
    L20:
        ResultKt.throwOnFailure(r8);
        if (this.wasPositioned == true) goto L42;
        if (ComposeFoundationFlags.isAwaitFirstLayoutModifierFixEnabled == false) goto L29;
        CompletableDeferred<Unit> r11 = this.lock;
        r0.label = 1;
        if (r11.await(r0) != r2) goto L28;
        return r2;
    L29:
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        r0.L$0 = r12;     // Catch: Throwable -> L37
        r0.label = 2;     // Catch: Throwable -> L37
        kotlinx.coroutines.j r13 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);     // Catch: Throwable -> L37
        r13.C();     // Catch: Throwable -> L37
        r12.element = r13;     // Catch: Throwable -> L37
        access$getContinuations$p(this).add(r13);     // Catch: Throwable -> L37
        Object r14 = r13.B();     // Catch: Throwable -> L37
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L33;
        DebugProbesKt.probeCoroutineSuspended(r0);     // Catch: Throwable -> L37
    L33:
        if (r14 != r2) goto L35;
        return r2;
    L35:
        r4 = r12;
    L37:
        th = move-exception;
        r4 = r12;
        th = th;
    L7:
        r0 = new AnonymousClass1(this, r7);
        goto L8
    }
}
