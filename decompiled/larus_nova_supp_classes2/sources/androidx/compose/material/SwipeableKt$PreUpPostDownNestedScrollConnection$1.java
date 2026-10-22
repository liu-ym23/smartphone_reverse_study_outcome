package androidx.compose.material;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0003*\u00020\u0015H\u0002¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0015*\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"androidx/compose/material/SwipeableKt$PreUpPostDownNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toOffset", "", "(F)J", "toFloat", "(J)F", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwipeableKt$PreUpPostDownNestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ SwipeableState<T> $this_PreUpPostDownNestedScrollConnection;

    public SwipeableKt$PreUpPostDownNestedScrollConnection$1(SwipeableState<T> r1) {
        this.$this_PreUpPostDownNestedScrollConnection = r1;
    }

    private final float toFloat(long r3) {
        return Float.intBitsToFloat((int) (r3 & 4294967295L));
    }

    private final long toOffset(float r7) {
        return Offset.constructor-impl((Float.floatToRawIntBits(androidx.compose.material3.MenuKt.ClosedAlphaTarget) << 32) | (((long) Float.floatToRawIntBits(r7)) & 4294967295L));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public Object m2188onPreFlingQWom1Mo(long r11, Continuation<? super Velocity> r13) {
        if ((r13 instanceof SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1) == false) goto L7;
        Continuation<? super Unit> r0 = (SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1) r13;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r11 = r0.J$0;
        ResultKt.throwOnFailure(r14);
    L23:
        return Velocity.box-impl(r11);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        float r15 = Velocity.getX-impl(r11);
        float r4 = Velocity.getY-impl(r11);
        float r16 = toFloat(Offset.constructor-impl((Float.floatToRawIntBits(r15) << 32) | (((long) Float.floatToRawIntBits(r4)) & 4294967295L)));
        if (r16 < androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L17;
    L21:
        r11 = Velocity.Companion.getZero-9UxMQ8M();
        goto L23
    L17:
        if (((Number) this.$this_PreUpPostDownNestedScrollConnection.getOffset().getValue()).floatValue() <= this.$this_PreUpPostDownNestedScrollConnection.getMinBound$material()) goto L21;
        SwipeableState<T> r5 = this.$this_PreUpPostDownNestedScrollConnection;
        r0.J$0 = r11;
        r0.label = 1;
        if (r5.performFling(r16, r0) != r2) goto L23;
        return r2;
    L7:
        r0 = new SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1(this, r13);
        goto L8
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public long m2189onPreScrollOzD1aCk(long r1, int r3) {
        float r2 = toFloat(r1);
        if (r2 >= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L8;
        if (NestedScrollSource.equals-impl0(r3, NestedScrollSource.Companion.getUserInput-WNlRxjI()) == false) goto L8;
        return toOffset(this.$this_PreUpPostDownNestedScrollConnection.performDrag(r2));
    L8:
        return Offset.Companion.getZero-F1C5BW0();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public Object m2186onPostFlingRZ2iAVY(long r10, long r12, Continuation<? super Velocity> r14) {
        if ((r14 instanceof SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1) == false) goto L7;
        Continuation<? super Unit> r11 = (SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1) r14;
        int r13 = r11.label;
        if ((r13 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r11.label = r13 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r15 = r11.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = r11.label;
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L13;
        r12 = r11.J$0;
        ResultKt.throwOnFailure(r15);
    L18:
        return Velocity.box-impl(r12);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        SwipeableState<T> r17 = this.$this_PreUpPostDownNestedScrollConnection;
        float r1 = Velocity.getX-impl(r12);
        float r2 = Velocity.getY-impl(r12);
        float r3 = toFloat(Offset.constructor-impl((Float.floatToRawIntBits(r1) << 32) | (Float.floatToRawIntBits(r2) & 4294967295L)));
        r11.J$0 = r12;
        r11.label = 1;
        if (r17.performFling(r3, r11) != r16) goto L18;
        return r16;
    L7:
        r11 = new SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1(this, r14);
        goto L8
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long m2187onPostScrollDzOQY0M(long r1, long r3, int r5) {
        if (NestedScrollSource.equals-impl0(r5, NestedScrollSource.Companion.getUserInput-WNlRxjI()) == false) goto L6;
        return toOffset(this.$this_PreUpPostDownNestedScrollConnection.performDrag(toFloat(r3)));
    L6:
        return Offset.Companion.getZero-F1C5BW0();
    }
}
