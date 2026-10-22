package com.ss.android.lark.flow.passport.ui.widget.layout;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CommonContainerLayout$onImeChangeHandler$1 extends FunctionReferenceImpl implements Function3<View, Boolean, Integer, Unit> {
    public CommonContainerLayout$onImeChangeHandler$1(Object r100) {
        super(3, r100, CommonContainerLayout.class, "onImeChanged", "onImeChanged(Landroid/view/View;ZI)V", 0);
    }

    public final void invoke(View r100, boolean r110, int r111) {
        CommonContainerLayout r101 = (CommonContainerLayout) this.receiver;
        r101.setContentScrollable(!r110);
        if (r110 == true) goto L5;
        r111 = 0;
    L26:
        ValueAnimator r102 = r101.f423864d;
        if (r102 == null) goto L29;
        r102.cancel();
    L29:
        ValueAnimator r112 = ValueAnimator.ofInt(new int[]{r101.getPaddingBottom(), r111});
        r101.f423864d = r112;
        r112.setDuration(160);
        r112.addUpdateListener(new e(r101));
        r112.start();
        Intrinsics.checkNotNull(r112);
        r112.addUpdateListener(new a(r100, r101));
        r112.addListener(new b(r101, r110));
        return;
    L5:
        LinearLayout r103 = r101.f423867g;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        Intrinsics.checkNotNullParameter(r103, "<this>");
        qyb.b r104 = new qyb.b(r103);
        Object r105 = null;
    L7:
        if (r104.hasNext() == false) goto L15;
        Object r106 = r104.next();
        if (((View) r106).getVisibility() != 8) goto L11;
        boolean r107 = true;
    L13:
        if ((!r107) == false) goto L7;
        r105 = r106;
        goto L7
    L11:
        r107 = false;
        goto L13
    L15:
        View r108 = (View) r105;
        if (r108 == null) goto L26;
        int r109 = r101.R5(r108);
        if (r109 >= ((r101.getHeight() - r111) - r101.f423868h.getHeight())) goto L22;
        r101.f423873m.c();
    L25:
        r111 = r111 + 0;
        goto L26
    L22:
        if (r109 >= (r101.getHeight() - r111)) goto L24;
        r111 = (r101.getHeight() - r109) - r101.f423868h.getHeight();
        r101.f423873m.b();
        goto L25
    L24:
        r111 = r111 - r101.f423868h.getHeight();
        r101.f423873m.a();
        goto L25
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(View r100, Boolean r101, Integer r102) {
        invoke(r100, r101.booleanValue(), r102.intValue());
        return Unit.INSTANCE;
    }
}
