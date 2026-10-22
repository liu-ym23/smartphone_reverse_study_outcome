package com.larus.voicecall.impl.video;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes32.dex */
public final class a0 implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f379583a;

    @Override // com.larus.voicecall.impl.video.f
    public final void onClick() {
        FLogger.f375446a.d("ViewPortSwitcher", SendEventContainerMethodParamModel.EventKinds.onClick);
        Function0<Unit> r100 = this.f379583a.f379633i;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    @Override // com.larus.voicecall.impl.video.f
    public final void onDragStart() {
        FLogger.f375446a.d("ViewPortSwitcher", "onDragStart");
    }

    public a0(y r100) {
        this.f379583a = r100;
    }

    @Override // com.larus.voicecall.impl.video.f
    public final void f5(float r110, float r111) {
        FLogger r100 = FLogger.f375446a;
        r100.d("ViewPortSwitcher", "onDragEnd, x = " + r110 + ", y = " + r111);
        y r101 = this.f379583a;
        View r102 = r101.f379626b;
        r101.getClass();
        int[] r103 = new int[2];
        r102.getLocationOnScreen(r103);
        View r104 = this.f379583a.f379626b;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L7;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        int r107 = r106.topMargin;
        int r108 = r106.leftMargin;
        int r109 = r106.getMarginStart();
        r106.topMargin = (int) ((r111 - r103[1]) + r107);
        int r112 = r103[0];
        r106.leftMargin = (int) ((r110 - r112) + r108);
        r106.setMarginStart((int) ((r110 - r112) + r109));
        r100.d("ViewPortSwitcher", "update place holder layout params: curTopMargin = " + r107 + ", curLeftMargin = " + r108 + ", curMarginStart = " + r109 + ", topMargin = " + r106.topMargin + ", leftMargin = " + r106.leftMargin + ", marginStart = " + r106.getMarginStart());
        r104.setLayoutParams(r106);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
