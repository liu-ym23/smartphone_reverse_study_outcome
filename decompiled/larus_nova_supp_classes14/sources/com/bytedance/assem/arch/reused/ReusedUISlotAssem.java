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
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/assem/arch/reused/ReusedUISlotAssem;", "Lcom/bytedance/tiktok/proxy/a;", "RECEIVER", "Lcom/bytedance/assem/arch/reused/ReusedUIAssem;", "<init>", "()V", "a", "assem_release"}, k = 1, mv = {1, 4, 0})
public abstract class ReusedUISlotAssem<RECEIVER extends com.bytedance.tiktok.proxy.a> extends ReusedUIAssem<RECEIVER> {
    public static final Lazy B = null;
    public static final Lazy C = null;
    public View A;
    public int x;
    public InflateMode y;
    public final Lazy z;

    public static final class a {
    }

    public abstract int D();

    static {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        B = LazyKt.lazy(r0, ReusedUISlotAssem$Companion$SUPPORT_ASYNC_LAYOUT_INFLATER$2.INSTANCE);
        C = LazyKt.lazy(r0, ReusedUISlotAssem$Companion$SUPPORT_AND_INFLATER$2.INSTANCE);
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onDestroy() {
        E(new AnonymousClass1(this));
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onPause() {
        E(new C02181(this));
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onResume() {
        E(new C02191(this));
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onStart() {
        E(new C02201(this));
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onStop() {
        E(new C02211(this));
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem
    public final void u() {
        if (this.j == false) goto L9;
        if (this.A == null) goto L9;
        p(r());
        r();
        return;
    L9:
        if (this.x == 0) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L68;
        int r1 = D();
        if (r1 == 0) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == false) goto L66;
        if (this.h == null) goto L21;
        boolean r4 = true;
    L22:
        if (r4 == false) goto L24;
        View r5 = r();
    L30:
        if ((r5 instanceof ViewGroup) == false) goto L62;
        int r6 = p.a[this.y.ordinal()];
        if (r6 != 1) goto L34;
        Context r2 = getContext();
        if (r2 == null) goto L60;
        new AsyncLayoutInflater(r2).inflate(r1, (ViewGroup) r5, new q(this, r5));
        return;
    L60:
        throw new IllegalArgumentException("Required value was null.".toString());
    L34:
        if (r6 != 2) goto L36;
        Context r7 = getContext();
        if (r7 == null) goto L54;
        View r8 = b2.a.a(r7, r1);
        if (r8 == null) goto L72;
        ((ViewGroup) r5).addView(r8);
        this.h = r5;
        this.A = r8;
        p(r8);
        return;
    L72:
        return;
    L54:
        throw new IllegalArgumentException("Required value was null.".toString());
    L36:
        if (r6 != 3) goto L38;
        HostInjector.a().execute(new r(this, r1, r5));
        return;
    L38:
        if (r6 != 4) goto L74;
        Context r9 = getContext();
        if (r9 == null) goto L46;
        ViewGroup r10 = (ViewGroup) r5;
        View r11 = LayoutInflater.from(r9).inflate(r1, r10, false);
        if (r11 == null) goto L69;
        r10.addView(r11);
        this.h = r5;
        this.A = r11;
        p(r11);
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
        View r12 = j().f;
        if (r12 == null) goto L27;
        r5 = r12.findViewById(this.x);
    L28:
        if (r5 != null) goto L30;
        throw new IllegalStateException(("assem: " + this + ", slotView is null").toString());
    L27:
        r5 = null;
        goto L28
    L21:
        r4 = false;
        goto L22
    L66:
        throw new IllegalStateException("layoutId must be assigned.".toString());
    L16:
        r3 = false;
        goto L17
    L68:
        throw new IllegalStateException("slotLayoutId must be assigned.".toString());
    L11:
        r0 = false;
        goto L12
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem
    public final void v() {
        View r0 = this.A;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L6:
        r0.setVisibility(8);
        return;
    }

    public ReusedUISlotAssem() {
        this.y = InflateMode.SYNC;
        this.z = LazyKt.lazy(LazyThreadSafetyMode.NONE, ReusedUISlotAssem$handler$2.INSTANCE);
    }

    public static final /* synthetic */ void A(ReusedUISlotAssem r0) {
        super.onResume();
    }

    public static final /* synthetic */ void B(ReusedUISlotAssem r0) {
        super.onStart();
    }

    public static final /* synthetic */ void C(ReusedUISlotAssem r0) {
        super.onStop();
    }

    public static final Handler x(ReusedUISlotAssem r0) {
        return (Handler) r0.z.getValue();
    }

    public static final /* synthetic */ void y(ReusedUISlotAssem r0) {
        super.onDestroy();
    }

    public static final /* synthetic */ void z(ReusedUISlotAssem r0) {
        super.onPause();
    }

    public final void E(final Function0<Unit> r3) {
        if (this.y != InflateMode.ASYNC_X2C) goto L5;
        HostInjector.a().execute(new ReusedUISlotAssem$runAsyncLifecycle$1(this, r3));
        return;
    L5:
        r3.invoke();
    }
}
