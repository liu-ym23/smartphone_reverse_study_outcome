package com.larus.livetutor.impl.view;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;

/* JADX INFO: loaded from: classes30.dex */
public final class k2 implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f356864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TutorLogPanel f356865b;

    public k2(LinearLayoutManager r100, TutorLogPanel r101) {
        this.f356864a = r100;
        this.f356865b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        LinearLayoutManager r109 = this.f356864a;
        if (r109 == null) goto L10;
        View r110 = r109.findViewByPosition(this.f356865b.f356787c.getItemCount() - 1);
        if (r110 == null) goto L11;
        int r111 = r110.getBottom() - (r100.getBottom() - r100.getPaddingBottom());
        if (r111 <= 0) goto L12;
        r100.scrollBy(0, r111);
        return;
    L12:
        return;
    L11:
        return;
    }
}
