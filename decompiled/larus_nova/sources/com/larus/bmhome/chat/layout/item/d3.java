package com.larus.bmhome.chat.layout.item;

import android.view.View;
import androidx.core.view.OneShotPreDrawListener;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes25.dex */
public final class d3 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f304295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f304296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c3 f304297c;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r8v10, types: [T, android.view.View] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v4, types: [T, android.view.View] */
    /* JADX WARN: Type inference failed for: r8v5, types: [T] */
    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        this.f304295a.removeOnAttachStateChangeListener(this);
        if (this.f304296b != this.f304297c.f304282e) goto L23;
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        ?? r103 = this.f304297c.f304278a;
        r102.element = r103;
        ?? r104 = r103.getParent();
        ?? r105 = r103;
    L7:
        if ((r104 instanceof View) == false) goto L12;
        if ((r104 instanceof RecyclerView) == true) goto L10;
        View r106 = (View) r104;
        r104 = r106.getParent();
        r105 = r106;
        goto L7
    L10:
        r101.element = r104;
        r102.element = r105;
    L12:
        RecyclerView r107 = (RecyclerView) r101.element;
        if (r107 == null) goto L18;
        RecyclerView.ViewHolder r108 = r107.findContainingViewHolder(this.f304297c.f304278a);
        if (r108 == null) goto L18;
        View r109 = r108.itemView;
        ?? r110 = r109;
        if (r109 == null) goto L18;
    L19:
        r102.element = r110;
        View r111 = (View) r110;
        ?? r112 = r110;
        OneShotPreDrawListener.add(r110, new f3(r112, this.f304296b, this.f304297c, r101, r102));
        return;
    L18:
        r110 = (View) r102.element;
        goto L19
    }

    public d3(View r100, int r101, c3 r102) {
        this.f304295a = r100;
        this.f304296b = r101;
        this.f304297c = r102;
    }
}
