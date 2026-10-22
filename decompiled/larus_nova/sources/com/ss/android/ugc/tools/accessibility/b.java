package com.ss.android.ugc.tools.accessibility;

import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.ss.android.ugc.tools.CukaieManifest;
import com.ss.android.ugc.tools.utils.g;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f454815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f454816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f454817c;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f454815a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        View r100 = this.f454815a;
        int r101 = this.f454816b;
        int r102 = this.f454817c;
    L3:
        Object r103 = r100.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L5;
        ViewGroup r104 = (ViewGroup) r103;
        if (r104.getWidth() < r101) goto L17;
        if (r104.getHeight() < r102) goto L17;
        ViewGroup r105 = r104;
    L11:
        if (r105 == null) goto L22;
        g r106 = CukaieManifest.c();
        Objects.toString(this.f454815a);
        r105.toString();
        r106.d();
        View r107 = this.f454815a;
        int r108 = this.f454816b;
        int r109 = this.f454817c;
        TouchDelegate r110 = r105.getTouchDelegate();
        if ((r110 instanceof a) == false) goto L15;
        a r111 = (a) r110;
        TouchDelegateChildren r112 = new TouchDelegateChildren(r108, r109, r105, r107, null);
        r111.getClass();
        Intrinsics.checkNotNullParameter(r112, "touchDelegate");
        ((ArrayList) r111.f454813a).add(r112);
        return;
    L15:
        a r113 = new a(r107);
        r105.setTouchDelegate(r113);
        TouchDelegateChildren r114 = new TouchDelegateChildren(r108, r109, r105, r107, null);
        Intrinsics.checkNotNullParameter(r114, "touchDelegate");
        ((ArrayList) r113.f454813a).add(r114);
        return;
    L22:
        return;
    L17:
        r100 = (View) r103;
        goto L3
    L5:
        r105 = null;
        goto L11
    }

    public b(View r100, int r101, int r102) {
        this.f454815a = r100;
        this.f454816b = r101;
        this.f454817c = r102;
    }
}
