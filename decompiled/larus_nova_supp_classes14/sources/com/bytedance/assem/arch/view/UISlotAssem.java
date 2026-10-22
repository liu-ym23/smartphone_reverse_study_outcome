package com.bytedance.assem.arch.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import com.bytedance.assem.arch.core.InflateMode;
import com.bytedance.assem.arch.core.UIAssem;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/assem/arch/view/UISlotAssem;", "Lcom/bytedance/assem/arch/core/UIAssem;", "<init>", "()V", "a", "assem_release"}, k = 1, mv = {1, 4, 0})
public abstract class UISlotAssem extends UIAssem {
    public static final Lazy l = null;
    public static final Lazy m = null;
    public int i;
    public InflateMode j;
    public View k;

    public static final class a {
    }

    public abstract int s();

    static {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        l = LazyKt.lazy(r0, UISlotAssem$Companion$SUPPORT_ASYNC_LAYOUT_INFLATER$2.INSTANCE);
        m = LazyKt.lazy(r0, UISlotAssem$Companion$SUPPORT_AND_INFLATER$2.INSTANCE);
    }

    @Override // com.bytedance.assem.arch.core.UIAssem
    public final void p() {
        if (this.i == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L54;
        int r1 = s();
        if (r1 == 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L52;
        View r4 = j().f;
        if (r4 == null) goto L15;
        View r5 = r4.findViewById(this.i);
    L17:
        if (r5 == null) goto L50;
        if ((r5 instanceof ViewGroup) == false) goto L48;
        InflateMode r6 = this.j;
        int r7 = com.bytedance.assem.arch.view.a.a[r6.ordinal()];
        if (r7 != 1) goto L23;
        Context r2 = getContext();
        if (r2 == null) goto L46;
        new AsyncLayoutInflater(r2).inflate(r1, (ViewGroup) r5, new b(this, r5));
        return;
    L46:
        throw new IllegalArgumentException("Required value was null.".toString());
    L23:
        if (r7 != 2) goto L25;
        Context r8 = getContext();
        if (r8 == null) goto L40;
        View r9 = b2.a.a(r8, r1);
        if (r9 == null) goto L57;
        ((ViewGroup) r5).addView(r9);
        this.k = r9;
        this.h = r5;
        r(r9);
        return;
    L57:
        return;
    L40:
        throw new IllegalArgumentException("Required value was null.".toString());
    L25:
        if (r7 != 3) goto L59;
        Context r10 = getContext();
        if (r10 == null) goto L33;
        ViewGroup r11 = (ViewGroup) r5;
        View r12 = LayoutInflater.from(r10).inflate(r1, r11, false);
        if (r12 == null) goto L55;
        r11.addView(r12);
        this.k = r12;
        this.h = r5;
        r(r12);
        return;
    L55:
        return;
    L33:
        throw new IllegalArgumentException("Required value was null.".toString());
    L59:
        return;
    L48:
        throw new IllegalStateException("container must be a ViewGroup.".toString());
    L50:
        throw new IllegalStateException("Required value was null.".toString());
    L15:
        r5 = null;
        goto L17
    L52:
        throw new IllegalStateException("layoutId must be assigned.".toString());
    L10:
        r3 = false;
        goto L11
    L54:
        throw new IllegalStateException("slotLayoutId must be assigned.".toString());
    L5:
        r0 = false;
        goto L6
    }

    public UISlotAssem() {
        this.j = InflateMode.SYNC;
    }
}
