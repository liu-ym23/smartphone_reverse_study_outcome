package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PanelBottomDialog f411507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f411508b;

    public c(PanelBottomDialog r100, g r101) {
        this.f411507a = r100;
        this.f411508b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f411507a.f411474i.contains(this.f411508b) == false) goto L5;
        this.f411507a.f411474i.remove(this.f411508b);
        PanelBottomDialog r101 = this.f411507a;
        Intrinsics.checkNotNull(r100);
        r101.aa0(r100, false, this.f411508b.f411513c);
        return;
    L5:
        this.f411507a.f411474i.add(this.f411508b);
        PanelBottomDialog r102 = this.f411507a;
        Intrinsics.checkNotNull(r100);
        r102.aa0(r100, true, this.f411508b.f411513c);
    }
}
