package com.ss.android.lark.forseti.chain;

import android.content.Context;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.ss.android.lark.api.bean.ForsetiChainType;
import com.ss.android.lark.api.bean.ForsetiPageViewType;
import com.ss.android.lark.forseti.widget.ForsetiPopoverViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ForsetiPopoverChainAdapter implements s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f424365e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f424366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f424367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f424368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f424369d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void b(int r100) {
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void c(boolean r100) {
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void d(int r100) {
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final boolean e() {
        return false;
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void f(boolean r100) {
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void k(boolean r100) {
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final ViewGroup h() {
        return (ViewGroup) this.f424368c.getValue();
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final ViewGroup j() {
        return (ViewGroup) this.f424369d.getValue();
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final ForsetiPageViewType n() {
        return ((ForsetiPopoverViewGroup) ((ViewGroup) this.f424368c.getValue()).findViewById(R.id.popover_view_group)).getCurrentPageViewType();
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void g(com.ss.android.lark.api.ui.g r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ForsetiPopoverViewGroup r101 = (ForsetiPopoverViewGroup) ((ViewGroup) this.f424368c.getValue()).findViewById(R.id.popover_view_group);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) r101.f424700h).remove(r100);
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void i(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f424367b = r100;
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void l(Function0<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void m(com.ss.android.lark.api.ui.g r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ForsetiPopoverViewGroup r102 = (ForsetiPopoverViewGroup) ((ViewGroup) this.f424368c.getValue()).findViewById(R.id.popover_view_group);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (r101 == false) goto L5;
        r100.a(r102.f424699g);
    L5:
        ((ArrayList) r102.f424700h).add(r100);
    }

    public ForsetiPopoverChainAdapter(Context r100, ForsetiChainType r101, final uua.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chainType");
        Intrinsics.checkNotNullParameter(r102, "forsetiInnerOptions");
        this.f424366a = r100;
        this.f424367b = ForsetiPopoverChainAdapter$closeHandler$1.INSTANCE;
        LazyThreadSafetyMode r103 = LazyThreadSafetyMode.NONE;
        this.f424368c = LazyKt.lazy(r103, new ForsetiPopoverChainAdapter$contentView$2(this, r102));
        this.f424369d = LazyKt.lazy(r103, new ForsetiPopoverChainAdapter$fragmentParentView$2(this));
    }
}
