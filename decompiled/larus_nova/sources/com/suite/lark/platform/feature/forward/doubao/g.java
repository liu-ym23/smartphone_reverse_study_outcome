package com.suite.lark.platform.feature.forward.doubao;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoubaoForwardConfirmFragment f461347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f461348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f461349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f461350d;

    public g(DoubaoForwardConfirmFragment r100, Ref.FloatRef r101, Ref.FloatRef r102, int r103) {
        this.f461347a = r100;
        this.f461348b = r101;
        this.f461349c = r102;
        this.f461350d = r103;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        DoubaoForwardConfirmFragment r102 = this.f461347a;
        boolean r103 = true;
        if (r102.f461224u == true) goto L9;
        HorizontalScrollView r104 = r102.f461211h;
        if (r104 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("avatarScroll");
        r104 = null;
    L7:
        r104.scrollTo(0, 0);
        return true;
    L9:
        int r105 = r101.getActionMasked();
        if (r105 == 0) goto L27;
        if (r105 != 1) goto L13;
    L26:
        r100.getParent().requestDisallowInterceptTouchEvent(false);
    L28:
        return false;
    L13:
        if (r105 != 2) goto L15;
        float r106 = Math.abs(r101.getX() - this.f461348b.element);
        float r107 = Math.abs(r101.getY() - this.f461349c.element);
        int r108 = this.f461350d;
        if (r106 <= r108) goto L20;
    L21:
        ViewParent r109 = r100.getParent();
        if (r106 > r107) goto L25;
        r103 = false;
    L25:
        r109.requestDisallowInterceptTouchEvent(r103);
        goto L28
    L20:
        if (r107 <= r108) goto L28;
    L15:
        if (r105 == 3) goto L26;
    L27:
        this.f461348b.element = r101.getX();
        this.f461349c.element = r101.getY();
        r100.getParent().requestDisallowInterceptTouchEvent(true);
        goto L28
    }
}
