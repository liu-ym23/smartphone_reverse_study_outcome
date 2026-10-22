package com.bytedance.assem.arch.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import com.bytedance.assem.arch.core.InflateMode;
import com.bytedance.assem.arch.core.UIAssem;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/assem/arch/view/UISlotAssem;", "Lcom/bytedance/assem/arch/core/UIAssem;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "assem_release"}, k = 1, mv = {1, 4, 0})
public abstract class UISlotAssem extends UIAssem {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f193058l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f193059m = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f193060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public InflateMode f193061j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f193062k;

    public static final class a {
    }

    public abstract int s();

    static {
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.NONE;
        f193058l = LazyKt.lazy(r100, UISlotAssem$Companion$SUPPORT_ASYNC_LAYOUT_INFLATER$2.INSTANCE);
        f193059m = LazyKt.lazy(r100, UISlotAssem$Companion$SUPPORT_AND_INFLATER$2.INSTANCE);
    }

    @Override // com.bytedance.assem.arch.core.UIAssem
    public final void p() {
        if (this.f193060i == 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L54;
        int r101 = s();
        if (r101 == 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L52;
        View r103 = j().f192875f;
        if (r103 == null) goto L15;
        View r104 = r103.findViewById(this.f193060i);
    L17:
        if (r104 == null) goto L50;
        if ((r104 instanceof ViewGroup) == false) goto L48;
        InflateMode r105 = this.f193061j;
        int r106 = com.bytedance.assem.arch.view.a.f193063a[r105.ordinal()];
        if (r106 != 1) goto L23;
        Context r107 = getContext();
        if (r107 == null) goto L46;
        new AsyncLayoutInflater(r107).inflate(r101, (ViewGroup) r104, new b(this, r104));
        return;
    L46:
        throw new IllegalArgumentException("Required value was null.".toString());
    L23:
        if (r106 != 2) goto L25;
        Context r108 = getContext();
        if (r108 == null) goto L40;
        View r109 = b2.a.a(r108, r101);
        if (r109 == null) goto L57;
        ((ViewGroup) r104).addView(r109);
        this.f193062k = r109;
        this.f192883h = r104;
        r(r109);
        return;
    L57:
        return;
    L40:
        throw new IllegalArgumentException("Required value was null.".toString());
    L25:
        if (r106 != 3) goto L59;
        Context r110 = getContext();
        if (r110 == null) goto L33;
        ViewGroup r111 = (ViewGroup) r104;
        View r112 = LayoutInflater.from(r110).inflate(r101, r111, false);
        if (r112 == null) goto L55;
        r111.addView(r112);
        this.f193062k = r112;
        this.f192883h = r104;
        r(r112);
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
        r104 = null;
        goto L17
    L52:
        throw new IllegalStateException("layoutId must be assigned.".toString());
    L10:
        r102 = false;
        goto L11
    L54:
        throw new IllegalStateException("slotLayoutId must be assigned.".toString());
    L5:
        r100 = false;
        goto L6
    }

    public UISlotAssem() {
        this.f193061j = InflateMode.SYNC;
    }
}
