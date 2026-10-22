package com.larus.ui.arch.component.external.delegate;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.larus.ui.arch.component.internal.attach.Attachable;
import com.larus.ui.arch.component.internal.control.ComponentStateController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import x1a.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/delegate/BaseComponentWidget;", "Lcom/larus/ui/arch/context/external/EmptyVWidgetData;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "featureName", "", "kotlin.jvm.PlatformType", "getFeatureName", "()Ljava/lang/String;", "onCreateView", "", "afterViewBind", "component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseContentWidget extends BaseComponentWidget<Object> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f375155k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f375156l;

    public void P2() {
    }

    public BaseContentWidget() {
        this.f375156l = getClass().getSimpleName();
    }

    @Override // m1a.e
    public final void S1() {
        Context r100 = getContext();
        ViewGroup r101 = null;
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r102 = (FragmentActivity) r100;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        Attachable.Companion.getClass();
        Attachable r103 = Attachable.a.a(r102);
        if (this.f375154j == null) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L16;
        N2(F2(), r103);
        return;
    L16:
        if (U2() == 0) goto L32;
        ComponentStateController r105 = this.f375151e;
        if (r105 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("stateController");
        r105 = null;
    L21:
        Object r106 = r105.f375169e;
        if ((r106 instanceof ViewGroup) == false) goto L24;
        r101 = (ViewGroup) r106;
    L24:
        if (r101 == null) goto L32;
        View r107 = r101.findViewById(U2());     // Catch: NullPointerException -> L27
        Intrinsics.checkNotNullParameter(r107, "<set-?>");     // Catch: NullPointerException -> L27
        this.f375154j = r107;     // Catch: NullPointerException -> L27
        N2(F2(), r103);     // Catch: NullPointerException -> L27
    L27:
        e = move-exception;
        IllegalStateException r108 = new IllegalStateException("contentViewId is invalid for " + this.f375156l + ", " + e);
        if (a.f562150a == true) goto L31;
        Intrinsics.checkNotNullParameter(r108, "e");
        this.f375150d = true;
        int r109 = y1a.a.f565679a;
        y1a.a.b("illegal_cut_off_for_component", "illegal state " + r108);
        y1a.a.c(r108, "illegal_cut_off_for_component");
        goto L32
    L31:
        throw r108;
    L32:
        P2();
        return;
    L11:
        r104 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public int U2() {
        return this.f375155k;
    }

    public void X2(int r100) {
        this.f375155k = r100;
    }
}
