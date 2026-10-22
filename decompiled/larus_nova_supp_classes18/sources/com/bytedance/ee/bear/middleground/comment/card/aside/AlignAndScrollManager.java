package com.bytedance.ee.bear.middleground.comment.card.aside;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.control.z;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.bytedance.ee.util.ui.n;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class AlignAndScrollManager {
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = 0;
    public static final float h = 0.0f;
    public final p a;
    public final RecyclerView b;
    public final Map<Integer, AsidePageAdapter.ViewHolder> c;
    public final z d;

    public static final class a {
    }

    static {
        int r0 = n.c(12.0f);
        e = r0;
        f = n.c(6.0f);
        g = r0;
        h = 0.3f;
    }

    public final Integer a(int r4) {
        AsidePageAdapter.ViewHolder r5 = this.c.get(Integer.valueOf(r4));     // Catch: Exception -> L12
        if (r5 == null) goto L6;
        View r6 = r5.b;     // Catch: Exception -> L12
    L7:
        if (r6 != null) goto L11;
        tt5.a.h("Comment#AlignAndScrollManager", "calculateItemHeight failed, view is null");     // Catch: Exception -> L12
        return null;
    L11:
        return Integer.valueOf((int) (n.b(this.b).bottom - n.b(r6).top));
    L6:
        r6 = null;
    L12:
        e = move-exception;
        tt5.a.i("Comment#AlignAndScrollManager", "calculateItemHeight failed", e);
        return null;
    }

    public final boolean c(int r3) {
        RecyclerView.Adapter r0 = this.b.getAdapter();
        if (r0 == null) goto L9;
        int r1 = r0.getItemCount();
        if (r3 < 0) goto L10;
        if (r3 >= r1) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    L9:
        return false;
    }

    public final Object k(ContinuationImpl r2) {
        Object r3 = b.a(this.b, r2);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    public final Object b(int r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof AlignAndScrollManager$ensureVisible$1) == false) goto L7;
        AlignAndScrollManager$ensureVisible$1 r0 = (AlignAndScrollManager$ensureVisible$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r6 = true;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        if (r3 == 4) goto L17;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r13);
    L61:
        return Boxing.boxBoolean(r6);
    L18:
        r11 = r0.I$0;
        ResultKt.throwOnFailure(r13);
    L26:
        tt5.a.h("Comment#AlignAndScrollManager", "ensureVisible positionToScroll = " + r11);
        Integer r14 = a(r11);
        if (r14 == null) goto L65;
        int r15 = r14.intValue();
        AsidePageAdapter.ViewHolder r8 = this.c.get(Boxing.boxInt(r11));
        if (r8 == null) goto L63;
        View r9 = r8.a;
        if (r9 == null) goto L63;
        if (c(r11) == true) goto L37;
        tt5.a.h("Comment#AlignAndScrollManager", "ensureVisible positionToScroll = " + r11 + " is not valid");
        return Boxing.boxBoolean(false);
    L37:
        LinearLayoutManager r5 = null;
        if (r15 <= this.b.getHeight()) goto L48;
        RecyclerView.LayoutManager r16 = this.b.getLayoutManager();
        if ((r16 instanceof LinearLayoutManager) == false) goto L42;
        r5 = (LinearLayoutManager) r16;
    L42:
        if (r5 == null) goto L44;
        r5.scrollToPosition(r11);
    L44:
        r0.label = 3;
        if (k(r0) != r2) goto L61;
        return r2;
    L48:
        if (((r9.getHeight() - e) - r15) <= g) goto L59;
        int r4 = (int) (this.b.getHeight() * h);
        if (r4 >= (this.b.getHeight() - r15)) goto L61;
        RecyclerView.LayoutManager r17 = this.b.getLayoutManager();
        if ((r17 instanceof LinearLayoutManager) == false) goto L54;
        r5 = (LinearLayoutManager) r17;
    L54:
        if (r5 == null) goto L56;
        r5.scrollToPositionWithOffset(r11, r4);
    L56:
        r0.label = 4;
        if (k(r0) != r2) goto L61;
        return r2;
    L59:
        r6 = false;
    L63:
        return Boxing.boxBoolean(false);
    L65:
        return Boxing.boxBoolean(false);
    L19:
        r11 = r0.I$0;
        ResultKt.throwOnFailure(r13);
    L23:
        r0.I$0 = r11;
        r0.label = 2;
        if (k(r0) != r2) goto L26;
        return r2;
    L20:
        ResultKt.throwOnFailure(r13);
        r0.I$0 = r11;
        r0.label = 1;
        if (k(r0) != r2) goto L23;
        return r2;
    L7:
        r0 = new AlignAndScrollManager$ensureVisible$1(this, r12);
        goto L8
    }

    public final Object f(int r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof AlignAndScrollManager$notifyHighLightHeightUpdate$1) == false) goto L7;
        Continuation<? super Boolean> r0 = (AlignAndScrollManager$notifyHighLightHeightUpdate$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L16;
        ResultKt.throwOnFailure(r11);
    L36:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r9 = r0.I$0;
        Ref.BooleanRef r4 = (Ref.BooleanRef) r0.L$1;
        Ref.BooleanRef r5 = (Ref.BooleanRef) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L30:
        r4.element = ((Boolean) r11).booleanValue();
        if (r5.element == true) goto L38;
        tt5.a.h("Comment#AlignAndScrollManager", "notifyHighLightHeightUpdate failed");
        MainCoroutineDispatcher r12 = Dispatchers.getMain();
        AlignAndScrollManager$notifyHighLightHeightUpdate$2 r6 = new AlignAndScrollManager$notifyHighLightHeightUpdate$2(r5, this, r9, null);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 4;
        if (BuildersKt.withContext(r12, r6, r0) != r2) goto L36;
        return r2;
    L38:
        return Unit.INSTANCE;
    L18:
        r9 = r0.I$0;
        ResultKt.throwOnFailure(r11);
    L26:
        r4 = new Ref.BooleanRef();
        r0.L$0 = r4;
        r0.L$1 = r4;
        r0.I$0 = r9;
        r0.label = 3;
        r11 = g(r9, r0);
        if (r11 != r2) goto L29;
        return r2;
    L29:
        r5 = r4;
        goto L30
    L19:
        r9 = r0.I$0;
        ResultKt.throwOnFailure(r11);
    L23:
        r0.I$0 = r9;
        r0.label = 2;
        if (k(r0) != r2) goto L26;
        return r2;
    L20:
        ResultKt.throwOnFailure(r11);
        tt5.a.h("Comment#AlignAndScrollManager", "notifyHighLightHeightUpdate position = " + r9);
        r0.I$0 = r9;
        r0.label = 1;
        if (k(r0) != r2) goto L23;
        return r2;
    L7:
        r0 = new AlignAndScrollManager$notifyHighLightHeightUpdate$1(this, r10);
        goto L8
    }

    public final Object g(int r7, Continuation<? super Boolean> r8) {
        if ((r8 instanceof AlignAndScrollManager$notifyWebHighLightHeightUpdate$1) == false) goto L7;
        AlignAndScrollManager$notifyWebHighLightHeightUpdate$1 r0 = (AlignAndScrollManager$notifyWebHighLightHeightUpdate$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = r0.I$0;
        ResultKt.throwOnFailure(r9);
    L19:
        Integer r10 = a(r7);
        if (r10 == null) goto L24;
        int r11 = r10.intValue();
        tt5.a.h("Comment#AlignAndScrollManager", "notifyWebHighLightHeightUpdate position:" + r7 + " height:" + r11);
        this.d.W().invoke(Boxing.boxInt(n.E(r11)));
        return Boxing.boxBoolean(true);
    L24:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        if (this.a.s == false) goto L19;
        r0.I$0 = r7;
        r0.label = 1;
        if (DelayKt.delay(200, r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new AlignAndScrollManager$notifyWebHighLightHeightUpdate$1(this, r8);
        goto L8
    }

    public final Object d(int r5, int r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof AlignAndScrollManager$lockAnchorPointWithPosition$1) == false) goto L7;
        AlignAndScrollManager$lockAnchorPointWithPosition$1 r0 = (AlignAndScrollManager$lockAnchorPointWithPosition$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r9 = r0.I$1;
        r6 = r0.I$0;
        ResultKt.throwOnFailure(r8);
    L26:
        AsidePageAdapter.ViewHolder r10 = this.c.get(Boxing.boxInt(r6));
        LinearLayoutManager r4 = null;
        if (r10 == null) goto L31;
        View r11 = r10.a;
        if (r11 == null) goto L31;
        Integer r12 = Boxing.boxInt((int) r11.getY());
    L32:
        if (r12 != null) goto L34;
    L35:
        RecyclerView.LayoutManager r13 = this.b.getLayoutManager();
        if ((r13 instanceof LinearLayoutManager) == false) goto L38;
        r4 = (LinearLayoutManager) r13;
    L38:
        if (r4 == null) goto L41;
        r4.scrollToPositionWithOffset(r6, r9 - e);
    L41:
        return Unit.INSTANCE;
    L34:
        if (r12.intValue() == r9) goto L41;
    L31:
        r12 = null;
        goto L32
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        AsidePageAdapter.ViewHolder r14 = this.c.get(Boxing.boxInt(r5));
        if (r14 == null) goto L43;
        View r15 = r14.a;
        if (r15 == null) goto L43;
        r9 = (int) r15.getY();
        if (c(r6) == true) goto L23;
        tt5.a.h("Comment#AlignAndScrollManager", "lockAnchorPointWithPosition positionNew = " + r6 + " is not valid");
        return Unit.INSTANCE;
    L23:
        r0.I$0 = r6;
        r0.I$1 = r9;
        r0.label = 1;
        if (k(r0) != r2) goto L26;
        return r2;
    L43:
        return Unit.INSTANCE;
    L7:
        r0 = new AlignAndScrollManager$lockAnchorPointWithPosition$1(this, r7);
        goto L8
    }

    public final Object e(int r10, int r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof AlignAndScrollManager$makeHighLightOnHeight$1) == false) goto L7;
        AlignAndScrollManager$makeHighLightOnHeight$1 r0 = (AlignAndScrollManager$makeHighLightOnHeight$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L16;
        boolean r14 = r0.Z$0;
        int r15 = r0.I$1;
        int r4 = r0.I$0;
        ResultKt.throwOnFailure(r13);
    L45:
        int r16 = r4;
    L46:
        if (r14 == true) goto L48;
    L52:
        int r17 = (this.b.getHeight() - r15) - e;
        LinearLayoutManager r18 = this.b.getLayoutManager();
        if ((r18 instanceof LinearLayoutManager) == false) goto L55;
        LinearLayoutManager r19 = r18;
    L56:
        if (r19 == null) goto L60;
        View r110 = r19.findViewByPosition(r16);
        if (r110 == null) goto L60;
        float r111 = r110.getY();
        tt5.a.h("Comment#AlignAndScrollManager", "checkCanScroll targetPosition:" + r16 + " targetOffset:" + r17 + " currentOffset:" + r111 + " canScroll:" + this.b.canScrollVertically(-((int) (r17 - r111))));
    L60:
        tt5.a.h("Comment#AlignAndScrollManager", "makeHighLightOnHeight failed");
        return Boxing.boxBoolean(false);
    L55:
        r19 = null;
        goto L56
    L48:
        if (this.a.s == true) goto L52;
        return Boxing.boxBoolean(true);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r112 = r0.I$1;
        int r113 = r0.I$0;
        ResultKt.throwOnFailure(r13);
    L35:
        boolean r114 = ((Boolean) r13).booleanValue();
    L36:
        int r8 = r113;
        r15 = r112;
        r14 = r114;
        r16 = r8;
        if (r14 == false) goto L40;
        tt5.a.h("Comment#AlignAndScrollManager", "makeHighLightOnHeight success");
    L40:
        if (this.a.s == false) goto L46;
        r0.I$0 = r16;
        r0.I$1 = r15;
        r0.Z$0 = r14;
        r0.label = 4;
        if (DelayKt.delay(100, r0) != r2) goto L44;
        return r2;
    L44:
        r4 = r16;
        goto L45
    L18:
        r112 = r0.I$1;
        r113 = r0.I$0;
        ResultKt.throwOnFailure(r13);
    L29:
        r114 = ((Boolean) r13).booleanValue();
    L31:
        if (r114 == true) goto L36;
        tt5.a.h("Comment#AlignAndScrollManager", "makeHighLightOnHeight retry twice");
        r0.I$0 = r113;
        r0.I$1 = r112;
        r0.label = 3;
        r13 = h(r113, r112, r0);
        if (r13 != r2) goto L35;
        return r2;
    L19:
        r11 = r0.I$1;
        r10 = r0.I$0;
        ResultKt.throwOnFailure(r13);
    L23:
        r114 = ((Boolean) r13).booleanValue();
        if (r114 == true) goto L30;
        tt5.a.h("Comment#AlignAndScrollManager", "makeHighLightOnHeight retry once");
        r0.I$0 = r10;
        r0.I$1 = r11;
        r0.label = 2;
        r13 = h(r10, r11, r0);
        if (r13 != r2) goto L28;
        return r2;
    L28:
        int r9 = r11;
        r113 = r10;
        r112 = r9;
        goto L29
    L30:
        int r20 = r11;
        r113 = r10;
        r112 = r20;
        goto L31
    L20:
        ResultKt.throwOnFailure(r13);
        tt5.a.h("Comment#AlignAndScrollManager", "makeHighLightOnHeight position:" + r10 + " height:" + r11);
        r0.I$0 = r10;
        r0.I$1 = r11;
        r0.label = 1;
        r13 = h(r10, r11, r0);
        if (r13 != r2) goto L23;
        return r2;
    L7:
        r0 = new AlignAndScrollManager$makeHighLightOnHeight$1(this, r12);
        goto L8
    }

    public final Object h(int r6, int r7, Continuation<? super Boolean> r8) {
        if ((r8 instanceof AlignAndScrollManager$realMakeHighLightOnHeight$1) == false) goto L7;
        AlignAndScrollManager$realMakeHighLightOnHeight$1 r0 = (AlignAndScrollManager$realMakeHighLightOnHeight$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
    L22:
        return r9;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r7 = r0.I$1;
        r6 = r0.I$0;
        ResultKt.throwOnFailure(r9);
    L19:
        MainCoroutineDispatcher r10 = Dispatchers.getMain();
        AlignAndScrollManager$realMakeHighLightOnHeight$2 r4 = new AlignAndScrollManager$realMakeHighLightOnHeight$2(this, r6, r7, null);
        r0.label = 2;
        r9 = BuildersKt.withContext(r10, r4, r0);
        if (r9 != r2) goto L22;
        return r2;
    L16:
        ResultKt.throwOnFailure(r9);
        r0.I$0 = r6;
        r0.I$1 = r7;
        r0.label = 1;
        if (j(r6, r7, r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new AlignAndScrollManager$realMakeHighLightOnHeight$1(this, r8);
        goto L8
    }

    public final Object j(int r5, int r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof AlignAndScrollManager$scrollToPositionWithOffset$1) == false) goto L7;
        AlignAndScrollManager$scrollToPositionWithOffset$1 r0 = (AlignAndScrollManager$scrollToPositionWithOffset$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = r0.I$1;
        r5 = r0.I$0;
        ResultKt.throwOnFailure(r8);
    L17:
        LinearLayoutManager r9 = this.b.getLayoutManager();
        if ((r9 instanceof LinearLayoutManager) == false) goto L20;
        LinearLayoutManager r10 = r9;
    L21:
        RecyclerView.Adapter r11 = this.b.getAdapter();
        if (r11 == null) goto L24;
        int r12 = r11.getItemCount();
    L25:
        if (r5 < 0) goto L28;
        if (r5 >= r12) goto L28;
    L29:
        if (r4 == false) goto L33;
        if (r10 == null) goto L33;
        r10.scrollToPositionWithOffset(r5, ((this.b.getHeight() - r6) - e) - f);
    L33:
        return Unit.INSTANCE;
    L28:
        r4 = false;
        goto L29
    L24:
        r12 = 0;
        goto L25
    L20:
        r10 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r0.I$0 = r5;
        r0.I$1 = r6;
        r0.label = 1;
        if (k(r0) != r2) goto L17;
        return r2;
    L7:
        r0 = new AlignAndScrollManager$scrollToPositionWithOffset$1(this, r7);
        goto L8
    }

    public AlignAndScrollManager(p r2, RecyclerView r3, Map<Integer, AsidePageAdapter.ViewHolder> r4, z r5) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "commentCardRecyclerView");
        Intrinsics.checkNotNullParameter(r4, "currentPagers");
        Intrinsics.checkNotNullParameter(r5, "mIListeners");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public final Object i(int r12, int r13, float r14, Continuation<? super Unit> r15) {
        if ((r15 instanceof AlignAndScrollManager$scrollToPosition$1) == false) goto L7;
        AlignAndScrollManager$scrollToPosition$1 r1 = (AlignAndScrollManager$scrollToPosition$1) r15;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r16 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L21;
        if (r4 == 1) goto L18;
        if (r4 != 2) goto L17;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L14
    L70:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r14 = r1.F$0;
        r13 = r1.I$1;
        r12 = r1.I$0;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L14
    L42:
        AsidePageAdapter.ViewHolder r17 = this.c.get(Boxing.boxInt(r12));     // Catch: Exception -> L14
        if (r17 == null) goto L47;
        RecyclerView r18 = r17.f;     // Catch: Exception -> L14
        if (r18 == null) goto L47;
        RecyclerView.LayoutManager r19 = r18.getLayoutManager();     // Catch: Exception -> L14
    L49:
        if ((r19 instanceof LinearLayoutManager) == false) goto L51;
        LinearLayoutManager r110 = (LinearLayoutManager) r19;     // Catch: Exception -> L14
    L52:
        if (r110 == null) goto L54;
        float r5 = 0.0f;
        if (r14 >= 0.0f) goto L59;
        r14 = 0.0f;
    L61:
        View r111 = r110.findViewByPosition(r13);     // Catch: Exception -> L14
        if (r111 == null) goto L65;
        r5 = r111.getHeight() * r14;     // Catch: Exception -> L14
    L65:
        float r112 = (n.b(r111).top + r5) - n.b(this.b).top;     // Catch: Exception -> L14
        tt5.a.h("Comment#AlignAndScrollManager", "scrollToPosition: " + r12 + ' ' + r13 + ' ' + r14 + ' ' + r5 + ' ' + r112);     // Catch: Exception -> L14
        this.b.smoothScrollBy(0, (int) r112, null, 200);     // Catch: Exception -> L14
        r1.label = 2;     // Catch: Exception -> L14
        if (DelayKt.delay(250, r1) != r3) goto L70;
        return r3;
    L59:
        if (r14 <= 1.0f) goto L61;
        r14 = 1.0f;
        goto L61
    L54:
        return Unit.INSTANCE;
    L51:
        r110 = null;
    L47:
        r19 = null;
        goto L49
    L21:
        ResultKt.throwOnFailure(r16);
        tt5.a.h("Comment#AlignAndScrollManager", "scrollToPosition outPosition = " + r12 + ", innerPosition = " + r13 + ", percentage = " + r14);
        LinearLayoutManager r113 = this.b.getLayoutManager();
        if ((r113 instanceof LinearLayoutManager) == false) goto L24;
        LinearLayoutManager r114 = r113;
    L25:
        if (r114 == null) goto L27;
        RecyclerView.Adapter r9 = this.b.getAdapter();
        if (r9 == null) goto L74;
        int r10 = r9.getItemCount();
        if (r12 < 0) goto L71;
        if (r12 >= r10) goto L71;
        this.b.stopScroll();     // Catch: Exception -> L14
        int r6 = r114.findFirstVisibleItemPosition();     // Catch: Exception -> L14
        int r11 = r114.findLastVisibleItemPosition();     // Catch: Exception -> L14
        if (r12 >= r6) goto L37;
        r114.scrollToPositionWithOffset(r12, 0);     // Catch: Exception -> L14
    L39:
        r1.I$0 = r12;     // Catch: Exception -> L14
        r1.I$1 = r13;     // Catch: Exception -> L14
        r1.F$0 = r14;     // Catch: Exception -> L14
        r1.label = 1;     // Catch: Exception -> L14
        if (DelayKt.delay(100, r1) != r3) goto L42;
        return r3;
    L37:
        if (r12 <= r11) goto L39;
        r114.scrollToPositionWithOffset(r12, this.b.getHeight() - e);     // Catch: Exception -> L14
    L71:
        tt5.a.h("Comment#AlignAndScrollManager", "scrollToPosition outPosition = " + r12 + " is out of range, itemCount = " + r10);
        return Unit.INSTANCE;
    L74:
        return Unit.INSTANCE;
    L27:
        return Unit.INSTANCE;
    L24:
        r114 = null;
    L14:
        e = move-exception;
        tt5.a.i("Comment#AlignAndScrollManager", "scrollToPosition failed", e);
    L7:
        r1 = new AlignAndScrollManager$scrollToPosition$1(this, r15);
        goto L8
    }
}
