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

/* JADX INFO: loaded from: classes18.dex */
public final class AlignAndScrollManager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f230873e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f230874f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f230875g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float f230876h = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f230877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f230878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, AsidePageAdapter.ViewHolder> f230879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f230880d;

    public static final class a {
    }

    static {
        int r100 = n.c(12.0f);
        f230873e = r100;
        f230874f = n.c(6.0f);
        f230875g = r100;
        f230876h = 0.3f;
    }

    public final Integer a(int r100) {
        AsidePageAdapter.ViewHolder r101 = this.f230879c.get(Integer.valueOf(r100));     // Catch: Exception -> L12
        if (r101 == null) goto L6;
        View r102 = r101.f230934b;     // Catch: Exception -> L12
    L7:
        if (r102 != null) goto L11;
        tt5.a.h("Comment#AlignAndScrollManager", "calculateItemHeight failed, view is null");     // Catch: Exception -> L12
        return null;
    L11:
        return Integer.valueOf((int) (n.b(this.f230878b).bottom - n.b(r102).top));
    L6:
        r102 = null;
    L12:
        e = move-exception;
        tt5.a.i("Comment#AlignAndScrollManager", "calculateItemHeight failed", e);
        return null;
    }

    public final boolean c(int r100) {
        RecyclerView.Adapter r101 = this.f230878b.getAdapter();
        if (r101 == null) goto L9;
        int r102 = r101.getItemCount();
        if (r100 < 0) goto L10;
        if (r100 >= r102) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    L9:
        return false;
    }

    public final Object k(ContinuationImpl r100) {
        Object r101 = b.a(this.f230878b, r100);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    public final Object b(int r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof AlignAndScrollManager$ensureVisible$1) == false) goto L7;
        AlignAndScrollManager$ensureVisible$1 r100 = (AlignAndScrollManager$ensureVisible$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L20;
        if (r103 == 1) goto L19;
        if (r103 == 2) goto L18;
        if (r103 == 3) goto L17;
        if (r103 == 4) goto L17;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r112);
    L61:
        return Boxing.boxBoolean(r104);
    L18:
        r110 = r100.I$0;
        ResultKt.throwOnFailure(r112);
    L26:
        tt5.a.h("Comment#AlignAndScrollManager", "ensureVisible positionToScroll = " + r110);
        Integer r113 = a(r110);
        if (r113 == null) goto L65;
        int r114 = r113.intValue();
        AsidePageAdapter.ViewHolder r105 = this.f230879c.get(Boxing.boxInt(r110));
        if (r105 == null) goto L63;
        View r106 = r105.f230933a;
        if (r106 == null) goto L63;
        if (c(r110) == true) goto L37;
        tt5.a.h("Comment#AlignAndScrollManager", "ensureVisible positionToScroll = " + r110 + " is not valid");
        return Boxing.boxBoolean(false);
    L37:
        LinearLayoutManager r107 = null;
        if (r114 <= this.f230878b.getHeight()) goto L48;
        RecyclerView.LayoutManager r115 = this.f230878b.getLayoutManager();
        if ((r115 instanceof LinearLayoutManager) == false) goto L42;
        r107 = (LinearLayoutManager) r115;
    L42:
        if (r107 == null) goto L44;
        r107.scrollToPosition(r110);
    L44:
        r100.label = 3;
        if (k(r100) != r102) goto L61;
        return r102;
    L48:
        if (((r106.getHeight() - f230873e) - r114) <= f230875g) goto L59;
        int r108 = (int) (this.f230878b.getHeight() * f230876h);
        if (r108 >= (this.f230878b.getHeight() - r114)) goto L61;
        RecyclerView.LayoutManager r116 = this.f230878b.getLayoutManager();
        if ((r116 instanceof LinearLayoutManager) == false) goto L54;
        r107 = (LinearLayoutManager) r116;
    L54:
        if (r107 == null) goto L56;
        r107.scrollToPositionWithOffset(r110, r108);
    L56:
        r100.label = 4;
        if (k(r100) != r102) goto L61;
        return r102;
    L59:
        r104 = false;
    L63:
        return Boxing.boxBoolean(false);
    L65:
        return Boxing.boxBoolean(false);
    L19:
        r110 = r100.I$0;
        ResultKt.throwOnFailure(r112);
    L23:
        r100.I$0 = r110;
        r100.label = 2;
        if (k(r100) != r102) goto L26;
        return r102;
    L20:
        ResultKt.throwOnFailure(r112);
        r100.I$0 = r110;
        r100.label = 1;
        if (k(r100) != r102) goto L23;
        return r102;
    L7:
        r100 = new AlignAndScrollManager$ensureVisible$1(this, r111);
        goto L8
    }

    public final Object f(int r100, Continuation<? super Unit> r110) {
        if ((r110 instanceof AlignAndScrollManager$notifyHighLightHeightUpdate$1) == false) goto L7;
        AlignAndScrollManager$notifyHighLightHeightUpdate$1 r101 = (AlignAndScrollManager$notifyHighLightHeightUpdate$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L18;
        if (r104 == 3) goto L17;
        if (r104 != 4) goto L16;
        ResultKt.throwOnFailure(r111);
    L36:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r100 = r101.I$0;
        Ref.BooleanRef r105 = (Ref.BooleanRef) r101.L$1;
        Ref.BooleanRef r106 = (Ref.BooleanRef) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L30:
        r105.element = ((Boolean) r111).booleanValue();
        if (r106.element == true) goto L38;
        tt5.a.h("Comment#AlignAndScrollManager", "notifyHighLightHeightUpdate failed");
        MainCoroutineDispatcher r112 = Dispatchers.getMain();
        AlignAndScrollManager$notifyHighLightHeightUpdate$2 r107 = new AlignAndScrollManager$notifyHighLightHeightUpdate$2(r106, this, r100, null);
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 4;
        if (BuildersKt.withContext(r112, r107, r101) != r103) goto L36;
        return r103;
    L38:
        return Unit.INSTANCE;
    L18:
        r100 = r101.I$0;
        ResultKt.throwOnFailure(r111);
    L26:
        r105 = new Ref.BooleanRef();
        r101.L$0 = r105;
        r101.L$1 = r105;
        r101.I$0 = r100;
        r101.label = 3;
        r111 = g(r100, r101);
        if (r111 != r103) goto L29;
        return r103;
    L29:
        r106 = r105;
        goto L30
    L19:
        r100 = r101.I$0;
        ResultKt.throwOnFailure(r111);
    L23:
        r101.I$0 = r100;
        r101.label = 2;
        if (k(r101) != r103) goto L26;
        return r103;
    L20:
        ResultKt.throwOnFailure(r111);
        tt5.a.h("Comment#AlignAndScrollManager", "notifyHighLightHeightUpdate position = " + r100);
        r101.I$0 = r100;
        r101.label = 1;
        if (k(r101) != r103) goto L23;
        return r103;
    L7:
        r101 = new AlignAndScrollManager$notifyHighLightHeightUpdate$1(this, r110);
        goto L8
    }

    public final Object g(int r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof AlignAndScrollManager$notifyWebHighLightHeightUpdate$1) == false) goto L7;
        AlignAndScrollManager$notifyWebHighLightHeightUpdate$1 r102 = (AlignAndScrollManager$notifyWebHighLightHeightUpdate$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = r102.I$0;
        ResultKt.throwOnFailure(r104);
    L19:
        Integer r107 = a(r100);
        if (r107 == null) goto L24;
        int r108 = r107.intValue();
        tt5.a.h("Comment#AlignAndScrollManager", "notifyWebHighLightHeightUpdate position:" + r100 + " height:" + r108);
        this.f230880d.W().invoke(Boxing.boxInt(n.E(r108)));
        return Boxing.boxBoolean(true);
    L24:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (this.f230877a.f232243s == false) goto L19;
        r102.I$0 = r100;
        r102.label = 1;
        if (DelayKt.delay(200, r102) != r105) goto L19;
        return r105;
    L7:
        r102 = new AlignAndScrollManager$notifyWebHighLightHeightUpdate$1(this, r101);
        goto L8
    }

    public final Object d(int r100, int r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof AlignAndScrollManager$lockAnchorPointWithPosition$1) == false) goto L7;
        AlignAndScrollManager$lockAnchorPointWithPosition$1 r103 = (AlignAndScrollManager$lockAnchorPointWithPosition$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        int r108 = r103.I$1;
        r101 = r103.I$0;
        ResultKt.throwOnFailure(r105);
    L26:
        AsidePageAdapter.ViewHolder r109 = this.f230879c.get(Boxing.boxInt(r101));
        LinearLayoutManager r110 = null;
        if (r109 == null) goto L31;
        View r111 = r109.f230933a;
        if (r111 == null) goto L31;
        Integer r112 = Boxing.boxInt((int) r111.getY());
    L32:
        if (r112 != null) goto L34;
    L35:
        RecyclerView.LayoutManager r113 = this.f230878b.getLayoutManager();
        if ((r113 instanceof LinearLayoutManager) == false) goto L38;
        r110 = (LinearLayoutManager) r113;
    L38:
        if (r110 == null) goto L41;
        r110.scrollToPositionWithOffset(r101, r108 - f230873e);
    L41:
        return Unit.INSTANCE;
    L34:
        if (r112.intValue() == r108) goto L41;
    L31:
        r112 = null;
        goto L32
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        AsidePageAdapter.ViewHolder r114 = this.f230879c.get(Boxing.boxInt(r100));
        if (r114 == null) goto L43;
        View r115 = r114.f230933a;
        if (r115 == null) goto L43;
        r108 = (int) r115.getY();
        if (c(r101) == true) goto L23;
        tt5.a.h("Comment#AlignAndScrollManager", "lockAnchorPointWithPosition positionNew = " + r101 + " is not valid");
        return Unit.INSTANCE;
    L23:
        r103.I$0 = r101;
        r103.I$1 = r108;
        r103.label = 1;
        if (k(r103) != r106) goto L26;
        return r106;
    L43:
        return Unit.INSTANCE;
    L7:
        r103 = new AlignAndScrollManager$lockAnchorPointWithPosition$1(this, r102);
        goto L8
    }

    public final Object e(int r110, int r111, Continuation<? super Boolean> r112) {
        if ((r112 instanceof AlignAndScrollManager$makeHighLightOnHeight$1) == false) goto L7;
        AlignAndScrollManager$makeHighLightOnHeight$1 r100 = (AlignAndScrollManager$makeHighLightOnHeight$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L20;
        if (r103 == 1) goto L19;
        if (r103 == 2) goto L18;
        if (r103 == 3) goto L17;
        if (r103 != 4) goto L16;
        boolean r114 = r100.Z$0;
        int r115 = r100.I$1;
        int r104 = r100.I$0;
        ResultKt.throwOnFailure(r113);
    L45:
        int r116 = r104;
    L46:
        if (r114 == true) goto L48;
    L52:
        int r117 = (this.f230878b.getHeight() - r115) - f230873e;
        RecyclerView.LayoutManager r118 = this.f230878b.getLayoutManager();
        if ((r118 instanceof LinearLayoutManager) == false) goto L55;
        LinearLayoutManager r119 = (LinearLayoutManager) r118;
    L56:
        if (r119 == null) goto L60;
        View r120 = r119.findViewByPosition(r116);
        if (r120 == null) goto L60;
        float r121 = r120.getY();
        tt5.a.h("Comment#AlignAndScrollManager", "checkCanScroll targetPosition:" + r116 + " targetOffset:" + r117 + " currentOffset:" + r121 + " canScroll:" + this.f230878b.canScrollVertically(-((int) (r117 - r121))));
    L60:
        tt5.a.h("Comment#AlignAndScrollManager", "makeHighLightOnHeight failed");
        return Boxing.boxBoolean(false);
    L55:
        r119 = null;
        goto L56
    L48:
        if (this.f230877a.f232243s == true) goto L52;
        return Boxing.boxBoolean(true);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r122 = r100.I$1;
        int r123 = r100.I$0;
        ResultKt.throwOnFailure(r113);
    L35:
        boolean r124 = ((Boolean) r113).booleanValue();
    L36:
        int r105 = r123;
        r115 = r122;
        r114 = r124;
        r116 = r105;
        if (r114 == false) goto L40;
        tt5.a.h("Comment#AlignAndScrollManager", "makeHighLightOnHeight success");
    L40:
        if (this.f230877a.f232243s == false) goto L46;
        r100.I$0 = r116;
        r100.I$1 = r115;
        r100.Z$0 = r114;
        r100.label = 4;
        if (DelayKt.delay(100, r100) != r102) goto L44;
        return r102;
    L44:
        r104 = r116;
        goto L45
    L18:
        r122 = r100.I$1;
        r123 = r100.I$0;
        ResultKt.throwOnFailure(r113);
    L29:
        r124 = ((Boolean) r113).booleanValue();
    L31:
        if (r124 == true) goto L36;
        tt5.a.h("Comment#AlignAndScrollManager", "makeHighLightOnHeight retry twice");
        r100.I$0 = r123;
        r100.I$1 = r122;
        r100.label = 3;
        r113 = h(r123, r122, r100);
        if (r113 != r102) goto L35;
        return r102;
    L19:
        r111 = r100.I$1;
        r110 = r100.I$0;
        ResultKt.throwOnFailure(r113);
    L23:
        r124 = ((Boolean) r113).booleanValue();
        if (r124 == true) goto L30;
        tt5.a.h("Comment#AlignAndScrollManager", "makeHighLightOnHeight retry once");
        r100.I$0 = r110;
        r100.I$1 = r111;
        r100.label = 2;
        r113 = h(r110, r111, r100);
        if (r113 != r102) goto L28;
        return r102;
    L28:
        int r106 = r111;
        r123 = r110;
        r122 = r106;
        goto L29
    L30:
        int r107 = r111;
        r123 = r110;
        r122 = r107;
        goto L31
    L20:
        ResultKt.throwOnFailure(r113);
        tt5.a.h("Comment#AlignAndScrollManager", "makeHighLightOnHeight position:" + r110 + " height:" + r111);
        r100.I$0 = r110;
        r100.I$1 = r111;
        r100.label = 1;
        r113 = h(r110, r111, r100);
        if (r113 != r102) goto L23;
        return r102;
    L7:
        r100 = new AlignAndScrollManager$makeHighLightOnHeight$1(this, r112);
        goto L8
    }

    public final Object h(int r100, int r101, Continuation<? super Boolean> r102) {
        if ((r102 instanceof AlignAndScrollManager$realMakeHighLightOnHeight$1) == false) goto L7;
        AlignAndScrollManager$realMakeHighLightOnHeight$1 r103 = (AlignAndScrollManager$realMakeHighLightOnHeight$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        ResultKt.throwOnFailure(r105);
    L22:
        return r105;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = r103.I$1;
        r100 = r103.I$0;
        ResultKt.throwOnFailure(r105);
    L19:
        MainCoroutineDispatcher r108 = Dispatchers.getMain();
        AlignAndScrollManager$realMakeHighLightOnHeight$2 r109 = new AlignAndScrollManager$realMakeHighLightOnHeight$2(this, r100, r101, null);
        r103.label = 2;
        r105 = BuildersKt.withContext(r108, r109, r103);
        if (r105 != r106) goto L22;
        return r106;
    L16:
        ResultKt.throwOnFailure(r105);
        r103.I$0 = r100;
        r103.I$1 = r101;
        r103.label = 1;
        if (j(r100, r101, r103) != r106) goto L19;
        return r106;
    L7:
        r103 = new AlignAndScrollManager$realMakeHighLightOnHeight$1(this, r102);
        goto L8
    }

    public final Object j(int r100, int r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof AlignAndScrollManager$scrollToPositionWithOffset$1) == false) goto L7;
        AlignAndScrollManager$scrollToPositionWithOffset$1 r103 = (AlignAndScrollManager$scrollToPositionWithOffset$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = r103.I$1;
        r100 = r103.I$0;
        ResultKt.throwOnFailure(r105);
    L17:
        RecyclerView.LayoutManager r109 = this.f230878b.getLayoutManager();
        if ((r109 instanceof LinearLayoutManager) == false) goto L20;
        LinearLayoutManager r110 = (LinearLayoutManager) r109;
    L21:
        RecyclerView.Adapter r111 = this.f230878b.getAdapter();
        if (r111 == null) goto L24;
        int r112 = r111.getItemCount();
    L25:
        if (r100 < 0) goto L28;
        if (r100 >= r112) goto L28;
    L29:
        if (r108 == false) goto L33;
        if (r110 == null) goto L33;
        r110.scrollToPositionWithOffset(r100, ((this.f230878b.getHeight() - r101) - f230873e) - f230874f);
    L33:
        return Unit.INSTANCE;
    L28:
        r108 = false;
        goto L29
    L24:
        r112 = 0;
        goto L25
    L20:
        r110 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.I$0 = r100;
        r103.I$1 = r101;
        r103.label = 1;
        if (k(r103) != r106) goto L17;
        return r106;
    L7:
        r103 = new AlignAndScrollManager$scrollToPositionWithOffset$1(this, r102);
        goto L8
    }

    public AlignAndScrollManager(p r100, RecyclerView r101, Map<Integer, AsidePageAdapter.ViewHolder> r102, z r103) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "commentCardRecyclerView");
        Intrinsics.checkNotNullParameter(r102, "currentPagers");
        Intrinsics.checkNotNullParameter(r103, "mIListeners");
        this.f230877a = r100;
        this.f230878b = r101;
        this.f230879c = r102;
        this.f230880d = r103;
    }

    public final Object i(int r110, int r111, float r112, Continuation<? super Unit> r113) {
        if ((r113 instanceof AlignAndScrollManager$scrollToPosition$1) == false) goto L7;
        AlignAndScrollManager$scrollToPosition$1 r100 = (AlignAndScrollManager$scrollToPosition$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L21;
        if (r103 == 1) goto L18;
        if (r103 != 2) goto L17;
        ResultKt.throwOnFailure(r114);     // Catch: Exception -> L14
    L70:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r112 = r100.F$0;
        r111 = r100.I$1;
        r110 = r100.I$0;
        ResultKt.throwOnFailure(r114);     // Catch: Exception -> L14
    L42:
        AsidePageAdapter.ViewHolder r115 = this.f230879c.get(Boxing.boxInt(r110));     // Catch: Exception -> L14
        if (r115 == null) goto L47;
        RecyclerView r116 = r115.f230938f;     // Catch: Exception -> L14
        if (r116 == null) goto L47;
        RecyclerView.LayoutManager r117 = r116.getLayoutManager();     // Catch: Exception -> L14
    L49:
        if ((r117 instanceof LinearLayoutManager) == false) goto L51;
        LinearLayoutManager r118 = (LinearLayoutManager) r117;     // Catch: Exception -> L14
    L52:
        if (r118 == null) goto L54;
        float r104 = 0.0f;
        if (r112 >= 0.0f) goto L59;
        r112 = 0.0f;
    L61:
        View r119 = r118.findViewByPosition(r111);     // Catch: Exception -> L14
        if (r119 == null) goto L65;
        r104 = r119.getHeight() * r112;     // Catch: Exception -> L14
    L65:
        float r120 = (n.b(r119).top + r104) - n.b(this.f230878b).top;     // Catch: Exception -> L14
        tt5.a.h("Comment#AlignAndScrollManager", "scrollToPosition: " + r110 + ' ' + r111 + ' ' + r112 + ' ' + r104 + ' ' + r120);     // Catch: Exception -> L14
        this.f230878b.smoothScrollBy(0, (int) r120, null, 200);     // Catch: Exception -> L14
        r100.label = 2;     // Catch: Exception -> L14
        if (DelayKt.delay(250, r100) != r102) goto L70;
        return r102;
    L59:
        if (r112 <= 1.0f) goto L61;
        r112 = 1.0f;
        goto L61
    L54:
        return Unit.INSTANCE;
    L51:
        r118 = null;
    L47:
        r117 = null;
        goto L49
    L21:
        ResultKt.throwOnFailure(r114);
        tt5.a.h("Comment#AlignAndScrollManager", "scrollToPosition outPosition = " + r110 + ", innerPosition = " + r111 + ", percentage = " + r112);
        RecyclerView.LayoutManager r121 = this.f230878b.getLayoutManager();
        if ((r121 instanceof LinearLayoutManager) == false) goto L24;
        LinearLayoutManager r122 = (LinearLayoutManager) r121;
    L25:
        if (r122 == null) goto L27;
        RecyclerView.Adapter r105 = this.f230878b.getAdapter();
        if (r105 == null) goto L74;
        int r106 = r105.getItemCount();
        if (r110 < 0) goto L71;
        if (r110 >= r106) goto L71;
        this.f230878b.stopScroll();     // Catch: Exception -> L14
        int r107 = r122.findFirstVisibleItemPosition();     // Catch: Exception -> L14
        int r108 = r122.findLastVisibleItemPosition();     // Catch: Exception -> L14
        if (r110 >= r107) goto L37;
        r122.scrollToPositionWithOffset(r110, 0);     // Catch: Exception -> L14
    L39:
        r100.I$0 = r110;     // Catch: Exception -> L14
        r100.I$1 = r111;     // Catch: Exception -> L14
        r100.F$0 = r112;     // Catch: Exception -> L14
        r100.label = 1;     // Catch: Exception -> L14
        if (DelayKt.delay(100, r100) != r102) goto L42;
        return r102;
    L37:
        if (r110 <= r108) goto L39;
        r122.scrollToPositionWithOffset(r110, this.f230878b.getHeight() - f230873e);     // Catch: Exception -> L14
    L71:
        tt5.a.h("Comment#AlignAndScrollManager", "scrollToPosition outPosition = " + r110 + " is out of range, itemCount = " + r106);
        return Unit.INSTANCE;
    L74:
        return Unit.INSTANCE;
    L27:
        return Unit.INSTANCE;
    L24:
        r122 = null;
    L14:
        e = move-exception;
        tt5.a.i("Comment#AlignAndScrollManager", "scrollToPosition failed", e);
    L7:
        r100 = new AlignAndScrollManager$scrollToPosition$1(this, r113);
        goto L8
    }
}
