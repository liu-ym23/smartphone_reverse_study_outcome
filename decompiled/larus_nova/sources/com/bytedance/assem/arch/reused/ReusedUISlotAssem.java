package com.bytedance.assem.arch.reused;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import com.bytedance.assem.arch.core.InflateMode;
import com.bytedance.assem.arch.extensions.HostInjector;
import com.bytedance.tiktok.proxy.a;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/assem/arch/reused/ReusedUISlotAssem;", "Lcom/bytedance/tiktok/proxy/a;", "RECEIVER", "Lcom/bytedance/assem/arch/reused/ReusedUIAssem;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "assem_release"}, k = 1, mv = {1, 4, 0})
public abstract class ReusedUISlotAssem<RECEIVER extends com.bytedance.tiktok.proxy.a> extends ReusedUIAssem<RECEIVER> {
    public static final Lazy B = null;
    public static final Lazy C = null;
    public View A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f193008x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public InflateMode f193009y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f193010z;

    public static final class a {
    }

    public abstract int D();

    static {
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.NONE;
        B = LazyKt.lazy(r100, ReusedUISlotAssem$Companion$SUPPORT_ASYNC_LAYOUT_INFLATER$2.INSTANCE);
        C = LazyKt.lazy(r100, ReusedUISlotAssem$Companion$SUPPORT_AND_INFLATER$2.INSTANCE);
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onDestroy() {
        E(new AnonymousClass1(this));
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onPause() {
        E(new C104251(this));
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onResume() {
        E(new C104261(this));
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onStart() {
        E(new C104271(this));
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onStop() {
        E(new C104281(this));
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem
    public final void u() {
        if (this.f192986j == false) goto L9;
        if (this.A == null) goto L9;
        p(r());
        r();
        return;
    L9:
        if (this.f193008x == 0) goto L11;
        boolean r100 = true;
    L12:
        if (r100 == false) goto L68;
        int r101 = D();
        if (r101 == 0) goto L16;
        boolean r102 = true;
    L17:
        if (r102 == false) goto L66;
        if (this.f192984h == null) goto L21;
        boolean r103 = true;
    L22:
        if (r103 == false) goto L24;
        View r104 = r();
    L30:
        if ((r104 instanceof ViewGroup) == false) goto L62;
        int r105 = p.f193031a[this.f193009y.ordinal()];
        if (r105 != 1) goto L34;
        Context r106 = getContext();
        if (r106 == null) goto L60;
        new AsyncLayoutInflater(r106).inflate(r101, (ViewGroup) r104, new q(this, r104));
        return;
    L60:
        throw new IllegalArgumentException("Required value was null.".toString());
    L34:
        if (r105 != 2) goto L36;
        Context r107 = getContext();
        if (r107 == null) goto L54;
        View r108 = b2.a.a(r107, r101);
        if (r108 == null) goto L72;
        ((ViewGroup) r104).addView(r108);
        this.f192984h = r104;
        this.A = r108;
        p(r108);
        return;
    L72:
        return;
    L54:
        throw new IllegalArgumentException("Required value was null.".toString());
    L36:
        if (r105 != 3) goto L38;
        HostInjector.a().execute(new r(this, r101, r104));
        return;
    L38:
        if (r105 != 4) goto L74;
        Context r109 = getContext();
        if (r109 == null) goto L46;
        ViewGroup r110 = (ViewGroup) r104;
        View r111 = LayoutInflater.from(r109).inflate(r101, r110, false);
        if (r111 == null) goto L69;
        r110.addView(r111);
        this.f192984h = r104;
        this.A = r111;
        p(r111);
        return;
    L69:
        return;
    L46:
        throw new IllegalArgumentException("Required value was null.".toString());
    L74:
        return;
    L62:
        throw new IllegalStateException("container must be a ViewGroup.".toString());
    L24:
        View r112 = j().f192875f;
        if (r112 == null) goto L27;
        r104 = r112.findViewById(this.f193008x);
    L28:
        if (r104 != null) goto L30;
        throw new IllegalStateException(("assem: " + this + ", slotView is null").toString());
    L27:
        r104 = null;
        goto L28
    L21:
        r103 = false;
        goto L22
    L66:
        throw new IllegalStateException("layoutId must be assigned.".toString());
    L16:
        r102 = false;
        goto L17
    L68:
        throw new IllegalStateException("slotLayoutId must be assigned.".toString());
    L11:
        r100 = false;
        goto L12
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem
    public final void v() {
        View r100 = this.A;
        if (r100 == null) goto L8;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L6:
        r100.setVisibility(8);
        return;
    }

    public ReusedUISlotAssem() {
        this.f193009y = InflateMode.SYNC;
        this.f193010z = LazyKt.lazy(LazyThreadSafetyMode.NONE, ReusedUISlotAssem$handler$2.INSTANCE);
    }

    public static final /* synthetic */ void A(ReusedUISlotAssem r100) {
        super.onResume();
    }

    public static final /* synthetic */ void B(ReusedUISlotAssem r100) {
        super.onStart();
    }

    public static final /* synthetic */ void C(ReusedUISlotAssem r100) {
        super.onStop();
    }

    public static final Handler x(ReusedUISlotAssem r100) {
        return (Handler) r100.f193010z.getValue();
    }

    public static final /* synthetic */ void y(ReusedUISlotAssem r100) {
        super.onDestroy();
    }

    public static final /* synthetic */ void z(ReusedUISlotAssem r100) {
        super.onPause();
    }

    public final void E(final Function0<Unit> r100) {
        if (this.f193009y != InflateMode.ASYNC_X2C) goto L5;
        HostInjector.a().execute(new ReusedUISlotAssem$runAsyncLifecycle$1(this, r100));
        return;
    L5:
        r100.invoke();
    }
}
