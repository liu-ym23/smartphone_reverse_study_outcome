package com.larus.bmhome.taskskill.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.larus.flowskill.impl.databinding.LayoutPcHintContainerBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewStub f314656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LayoutPcHintContainerBinding f314657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f314658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Integer, Unit> f314659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f314660e;

    public v() {
    }

    public final ViewGroup a() {
        LayoutPcHintContainerBinding r100 = this.f314657b;
        if (r100 == null) goto L7;
        FrameLayout r101 = r100.f343580a;
        if (r101 == null) goto L7;
        return r101;
    L7:
        ViewStub r102 = this.f314656a;
        if (r102 == null) goto L13;
        final View r103 = r102.inflate();
        if (r103 == null) goto L14;
        this.f314656a = null;
        FrameLayout r104 = (FrameLayout) r103;
        this.f314657b = new LayoutPcHintContainerBinding(r104, r104);
        r103.addOnLayoutChangeListener(new s(this, r103));
        return r104;
    L14:
        return null;
    L13:
        return null;
    }

    public final void b(View r100, int r101) {
        if (r100.getVisibility() != 0) goto L7;
        if (r101 > 0) goto L8;
        r101 = r100.getHeight();
    L8:
        View r102 = this.f314658c;
        if (r102 != null) goto L26;
        ViewParent r103 = r100.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L13;
        ViewGroup r104 = (ViewGroup) r103;
    L14:
        if (r104 != null) goto L16;
        return;
    L16:
        int r105 = r104.getResources().getIdentifier("message_list_parent", "id", r104.getContext().getPackageName());
        if (r105 != 0) goto L19;
        return;
    L19:
        View r106 = r104.findViewById(r105);
        if (r106 == null) goto L22;
        this.f314658c = r106;
        r102 = r106;
    L23:
        if (r102 != null) goto L26;
        return;
    L22:
        r102 = null;
        goto L23
    L13:
        r104 = null;
    L26:
        if (r102.getPaddingBottom() == r101) goto L28;
        r102.setPadding(r102.getPaddingLeft(), r102.getPaddingTop(), r102.getPaddingRight(), r101);
    L28:
        Function1<? super Integer, Unit> r107 = this.f314659d;
        if (r107 == null) goto L32;
        r107.invoke(Integer.valueOf(r101));
        return;
    L32:
        return;
    L7:
        r101 = 0;
        goto L8
    }
}
