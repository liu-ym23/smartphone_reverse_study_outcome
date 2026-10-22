package com.bytedance.locallife.cube.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.lynx.tasm.LynxView;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f257276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxView f257277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f257278c;

    public b(String r100, LynxView r101, ViewGroup r102) {
        this.f257276a = r100;
        this.f257277b = r101;
        this.f257278c = r102;
    }

    public final void a() {
        int r100 = CubeLynxTagView.f257274a;
        String r101 = this.f257276a;
        LynxView r102 = this.f257277b;
        ViewGroup r103 = this.f257278c;
        int r104 = r103.getChildCount();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L11;
        if (r102.getHeight() == 0) goto L29;
        if ((r103.getChildAt(r105) instanceof CubeLynxTagView) == true) goto L30;
        r105 = r105 + 1;
        goto L3
    L30:
        return;
    L29:
        return;
    L11:
        if ((r103 instanceof FrameLayout) == false) goto L14;
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-2, -2);
        r106.gravity = 8388691;
        int r107 = CubeLynxTagView.f257274a;
        r106.leftMargin = r107;
        r106.bottomMargin = r107;
        ViewGroup.LayoutParams r108 = r106;
    L16:
        CubeLynxTagView r109 = null;
        View r110 = LayoutInflater.from(r102.getContext()).inflate(R.layout.cube_impl_debug_tag_saas, null);
        if ((r110 instanceof CubeLynxTagView) == false) goto L19;
        CubeLynxTagView r111 = (CubeLynxTagView) r110;
    L20:
        if (r111 == null) goto L22;
        r111.setText(r101);
        r111.setOnClickListener(new c(r102));
        r109 = r111;
    L22:
        r103.addView(r109, r108);
        return;
    L19:
        r111 = null;
        goto L20
    L14:
        if ((r103 instanceof RelativeLayout) == false) goto L23;
        RelativeLayout.LayoutParams r112 = new RelativeLayout.LayoutParams(-2, -2);
        r112.addRule(9);
        r112.addRule(12);
        int r113 = CubeLynxTagView.f257274a;
        r112.leftMargin = r113;
        r112.bottomMargin = r113;
        r108 = r112;
        goto L16
    L23:
        Toast.makeText(r102.getContext(), "LynxView非法父视图，不显示tag", 0).show();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
