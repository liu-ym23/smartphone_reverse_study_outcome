package com.ss.android.lark.forseti.chain;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.nova.R;
import com.ss.android.lark.api.bean.ForsetiChainType;
import com.ss.android.lark.api.bean.ForsetiPageViewType;
import com.ss.android.lark.forseti.widget.ForsetiStackChainViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
public final class ForsetiStackChainAdapter implements s {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f424373l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f424374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ForsetiChainType f424375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Lambda f424376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Boolean> f424377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f424378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f424379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BottomSheetBehavior<ForsetiStackChainViewGroup> f424380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f424381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f424382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f424383j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f424384k;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f424385a = null;

        static {
            int[] r100 = new int[ForsetiChainType.values().length];
            r100[ForsetiChainType.TYPE_HALF_STACK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ForsetiChainType.TYPE_STACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f424385a = r100;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final boolean e() {
        return false;
    }

    public final ForsetiStackChainViewGroup a() {
        return (ForsetiStackChainViewGroup) ((ViewGroup) this.f424383j.getValue()).findViewById(R.id.stack_chain_view_group);
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final ViewGroup h() {
        return (ViewGroup) this.f424383j.getValue();
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final ViewGroup j() {
        return (ViewGroup) this.f424384k.getValue();
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final ForsetiPageViewType n() {
        return a().getCurrentPageViewType();
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void b(int r100) {
        a().setPeekHeightInPx(r100);
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void c(boolean r100) {
        View r101 = this.f424381h;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stack");
        r101 = null;
    L5:
        View r102 = r101.findViewById(R.id.stack_chain_background);
        if (r100 == false) goto L8;
        int r103 = 0;
    L9:
        r102.setVisibility(r103);
        return;
    L8:
        r103 = 4;
        goto L9
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void d(int r100) {
        ForsetiStackChainViewGroup r101 = a();
        r101.getClass();
        if (r100 != 0) goto L5;
        ForsetiStackChainViewGroup.Style r102 = ForsetiStackChainViewGroup.Style.HALF_STACK;
    L10:
        if (r102 == r101.f424719o) goto L13;
        r101.setStyle(r102);
        r101.requestLayout();
        return;
    L13:
        return;
    L5:
        if (r100 == 1) goto L7;
        r102 = ForsetiStackChainViewGroup.Style.UNINITIALIZED;
        goto L10
    L7:
        r102 = ForsetiStackChainViewGroup.Style.STACK;
        goto L10
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void f(boolean r100) {
        this.f424378e = r100;
        BottomSheetBehavior<ForsetiStackChainViewGroup> r101 = this.f424380g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        r101 = null;
    L5:
        r101.setDraggable(!r100);
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void g(com.ss.android.lark.api.ui.g r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ForsetiStackChainViewGroup r101 = a();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) r101.f424715k).remove(r100);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.forseti.chain.ForsetiStackChainAdapter$setCloseHandler$1, kotlin.jvm.internal.Lambda] */
    @Override // com.ss.android.lark.forseti.chain.s
    public final void i(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f424376c = new ForsetiStackChainAdapter$setCloseHandler$1(this, r100);
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void k(boolean r100) {
        ForsetiStackChainViewGroup r101 = a();
        if (r100 == r101.f424712h) goto L6;
        r101.f424712h = r100;
        r101.requestLayout();
        return;
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void l(Function0<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        this.f424377d = r100;
    }

    public ForsetiStackChainAdapter(Context r100, ForsetiChainType r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chainType");
        this.f424374a = r100;
        this.f424375b = r101;
        this.f424376c = ForsetiStackChainAdapter$closeHandler$1.INSTANCE;
        this.f424379f = 4;
        this.f424382i = LazyKt.lazy(ForsetiStackChainAdapter$nestedScrollOptimizeDisableFG$2.INSTANCE);
        LazyThreadSafetyMode r102 = LazyThreadSafetyMode.NONE;
        this.f424383j = LazyKt.lazy(r102, new ForsetiStackChainAdapter$contentView$2(this));
        this.f424384k = LazyKt.lazy(r102, new ForsetiStackChainAdapter$fragmentParentView$2(this));
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void m(com.ss.android.lark.api.ui.g r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ForsetiStackChainViewGroup r102 = a();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (r101 == false) goto L5;
        r100.a(r102.f424714j);
    L5:
        ((ArrayList) r102.f424715k).add(r100);
    }
}
