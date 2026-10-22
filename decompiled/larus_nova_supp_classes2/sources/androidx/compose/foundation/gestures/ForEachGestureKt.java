package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.material.MenuKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\b\u0007H\u0087@¢\u0006\u0002\u0010\b\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0000\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u0002H\u0080@¢\u0006\u0002\u0010\r\u001a\u001c\u0010\f\u001a\u00020\u0001*\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0080@¢\u0006\u0002\u0010\u0010\u001a;\u0010\u0011\u001a\u00020\u0001*\u00020\u00022'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\b\u0007H\u0086@¢\u0006\u0002\u0010\b¨\u0006\u0012"}, d2 = {"forEachGesture", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "allPointersUp", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "awaitAllPointersUp", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitEachGesture", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ForEachGestureKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$2", f = "ForEachGesture.kt", i = {}, l = {MenuKt.OutTransitionDuration}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass2 r0 = new AnonymousClass2(r3);
            r0.L$0 = r2;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            AwaitPointerEventScope r5 = (AwaitPointerEventScope) this.L$0;
            this.label = 1;
            if (ForEachGestureKt.awaitAllPointersUp$default(r5, null, this, 1, null) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ForEachGestureKt", f = "ForEachGesture.kt", i = {0, 0}, l = {84}, m = "awaitAllPointersUp", n = {"$this$awaitAllPointersUp", "pass"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(Continuation<? super AnonymousClass3> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return ForEachGestureKt.awaitAllPointersUp(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2", f = "ForEachGesture.kt", i = {0, 1, 2}, l = {102, 105, 110}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, s = {"L$0", "L$0", "L$0"})
    public static final class C01412 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ CoroutineContext $currentContext;
        private /* synthetic */ Object L$0;
        int label;

        public C01412(CoroutineContext r1, Function2<? super AwaitPointerEventScope, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super C01412> r3) {
            this.$currentContext = r1;
            this.$block = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C01412 r0 = new C01412(this.$currentContext, this.$block, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARN: Type inference failed for: r10v11, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v19 */
        /* JADX WARN: Type inference failed for: r10v7 */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10, types: [androidx.compose.ui.input.pointer.AwaitPointerEventScope, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v1, types: [androidx.compose.ui.input.pointer.AwaitPointerEventScope, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v3 */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r8v0 */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0063 -> B:20:0x0040). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0084 -> B:20:0x0040). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r1 = this.label;
            if (r1 != 0) goto L47;
            ResultKt.throwOnFailure(r10);
            AwaitPointerEventScope r11 = (AwaitPointerEventScope) this.L$0;
        L19:
            C01412 r2 = this;
            ?? r12 = r11;
        L21:
            if (JobKt.isActive(r2.$currentContext) == false) goto L42;
            Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> r6 = r2.$block;     // Catch: CancellationException -> L32
            r2.L$0 = r12;     // Catch: CancellationException -> L32
            r2.label = 1;     // Catch: CancellationException -> L32
            if (r6.invoke(r12, r2) != r0) goto L25;
            return r0;
        L25:
            C01412 r8 = r2;
            ?? r3 = r12;
            C01412 r13 = r8;
        L45:
            r13.L$0 = r3;     // Catch: CancellationException -> L30
            r13.label = 2;     // Catch: CancellationException -> L30
            if (ForEachGestureKt.awaitAllPointersUp$default(r3, null, r13, 1, null) != r0) goto L29;
            return r0;
        L29:
            ?? r9 = r3;
            r2 = r13;
            r12 = r9;
        L30:
            e = move-exception;
            ?? r14 = r3;
            r2 = r13;
            e = e;
            ?? r7 = r14;
        L35:
            if (JobKt.isActive(r2.$currentContext) == false) goto L40;
            r2.L$0 = r7;
            r2.label = 3;
            if (ForEachGestureKt.awaitAllPointersUp$default(r7, null, r2, 1, null) != r0) goto L39;
            return r0;
        L39:
            r12 = r7;
            goto L21
        L40:
            throw e;
        L32:
            e = move-exception;
            r7 = r12;
            e = e;
            goto L35
        L42:
            return Unit.INSTANCE;
        L47:
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            AwaitPointerEventScope r4 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r10);
        L12:
            r11 = r4;
            goto L19
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            r4 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: CancellationException -> L16
            goto L12
        L13:
            AwaitPointerEventScope r5 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: CancellationException -> L16
            r13 = this;
            r3 = r5;
        L16:
            e = e;
            r7 = r1;
            r2 = this;
            goto L35
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ForEachGestureKt", f = "ForEachGesture.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {48, 51, 56}, m = "forEachGesture", n = {"$this$forEachGesture", "block", "currentContext", "$this$forEachGesture", "block", "currentContext", "$this$forEachGesture", "block", "currentContext"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return ForEachGestureKt.forEachGesture(null, null, this);
        }
    }

    public static final boolean allPointersUp(AwaitPointerEventScope r5) {
        List r6 = r5.getCurrentEvent().getChanges();
        int r0 = r6.size();
        boolean r1 = false;
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L10;
        if (((PointerInputChange) ListProtector.get(r6, r2)).getPressed() == true) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        r1 = true;
    L10:
        return !r1;
    }

    public static final Object awaitAllPointersUp(PointerInputScope r2, Continuation<? super Unit> r3) {
        Object r4 = r2.awaitPointerEventScope(new AnonymousClass2(null), r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004f -> B:19:0x0052). Please report as a decompilation issue!!! */
    public static final Object awaitAllPointersUp(AwaitPointerEventScope r8, PointerEventPass r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof AnonymousClass3) == false) goto L7;
        AnonymousClass3 r0 = (AnonymousClass3) r10;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        PointerEventPass r12 = (PointerEventPass) r0.L$1;
        AwaitPointerEventScope r13 = (AwaitPointerEventScope) r0.L$0;
        ResultKt.throwOnFailure(r11);
        r9 = r12;
        r8 = r13;
    L19:
        List r14 = ((PointerEvent) r11).getChanges();
        int r4 = r14.size();
        boolean r5 = false;
        int r6 = 0;
    L20:
        if (r6 >= r4) goto L25;
        if (((PointerInputChange) ListProtector.get(r14, r6)).getPressed() == true) goto L23;
        r6 = r6 + 1;
        goto L20
    L23:
        r5 = true;
    L25:
        if (r5 == false) goto L27;
    L16:
        r0.L$0 = r8;
        r0.L$1 = r9;
        r0.label = 1;
        r11 = r8.awaitPointerEvent(r9, r0);
        if (r11 != r2) goto L19;
        return r2;
    L27:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        if (allPointersUp(r8) == true) goto L27;
    L7:
        r0 = new AnonymousClass3(r10);
        goto L8
    }

    public static final Object awaitEachGesture(PointerInputScope r3, Function2<? super AwaitPointerEventScope, ? super Continuation<? super Unit>, ? extends Object> r4, Continuation<? super Unit> r5) {
        Object r6 = r3.awaitPointerEventScope(new C01412(r5.getContext(), r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.ui.input.pointer.PointerInputScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.ui.input.pointer.PointerInputScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0091 -> B:18:0x0052). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ab -> B:18:0x0052). Please report as a decompilation issue!!! */
    @Deprecated(message = "Use awaitEachGesture instead. forEachGesture() can drop events between gestures.", replaceWith = @ReplaceWith(expression = "awaitEachGesture(block)", imports = {}))
    public static final Object forEachGesture(PointerInputScope r8, Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r3 = r0.label;
        if (r3 == 0) goto L24;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        PointerInputScope r12 = (CoroutineContext) r0.L$2;
        r9 = (Function2) r0.L$1;
        PointerInputScope r4 = (PointerInputScope) r0.L$0;
        ResultKt.throwOnFailure(r11);
        ?? r5 = r4;
        PointerInputScope r13 = r12;
    L18:
        PointerInputScope r14 = r13;
        ?? r15 = r5;
    L26:
        if (JobKt.isActive(r14) == false) goto L43;
        r0.L$0 = r15;     // Catch: CancellationException -> L34
        r0.L$1 = r9;     // Catch: CancellationException -> L34
        r0.L$2 = r14;     // Catch: CancellationException -> L34
        r0.label = 1;     // Catch: CancellationException -> L34
        if (r9.invoke(r15, r0) != r2) goto L30;
        return r2;
    L30:
        r3 = r15;
        r8 = r14;
    L31:
        r0.L$0 = r3;     // Catch: CancellationException -> L22
        r0.L$1 = r9;     // Catch: CancellationException -> L22
        r0.L$2 = r8;     // Catch: CancellationException -> L22
        r0.label = 2;     // Catch: CancellationException -> L22
        Object r16 = awaitAllPointersUp(r3, r0);     // Catch: CancellationException -> L22
        r5 = r3;
        r13 = r8;
        if (r16 != r2) goto L18;
        return r2;
    L34:
        e = move-exception;
        r3 = r15;
        r8 = r14;
        e = e;
    L37:
        if (JobKt.isActive(r8) == false) goto L41;
        r0.L$0 = r3;
        r0.L$1 = r9;
        r0.L$2 = r8;
        r0.label = 3;
        Object r17 = awaitAllPointersUp(r3, r0);
        r5 = r3;
        r13 = r8;
        if (r17 != r2) goto L18;
        return r2;
    L41:
        throw e;
    L43:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        PointerInputScope r18 = (CoroutineContext) r0.L$2;
        r9 = (Function2) r0.L$1;
        PointerInputScope r6 = (PointerInputScope) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: CancellationException -> L22
        r5 = r6;
        r13 = r18;
        goto L18
    L19:
        PointerInputScope r19 = (CoroutineContext) r0.L$2;
        r9 = (Function2) r0.L$1;
        PointerInputScope r7 = (PointerInputScope) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: CancellationException -> L22
        r3 = r7;
        r8 = r19;
        goto L31
    L24:
        ResultKt.throwOnFailure(r11);
        r15 = r8;
        r14 = r0.getContext();
    L22:
        e = e;
    L7:
        r0 = new AnonymousClass1(r10);
        goto L8
    }

    public static /* synthetic */ Object awaitAllPointersUp$default(AwaitPointerEventScope r0, PointerEventPass r1, Continuation r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = PointerEventPass.Final;
    L6:
        return awaitAllPointersUp(r0, r1, r2);
    }
}
