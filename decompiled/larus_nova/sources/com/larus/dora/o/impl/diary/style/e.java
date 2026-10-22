package com.larus.dora.o.impl.diary.style;

import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.swipeaction.OSwipeLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class e extends com.obric.oui.swipeaction.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ODiaryStyleAdapter.StyleViewHolder f338627a;

    @Override // com.obric.oui.swipeaction.OSwipeLayout.j
    public final void onClose() {
        ODiaryStyleAdapter.StyleViewHolder r100 = this.f338627a;
        int r101 = ODiaryStyleAdapter.StyleViewHolder.f338591g;
        OCardListItem r102 = r100.f338592a;
        OStateGradientDrawable r103 = r102.f401324g;
        if (r103 == null) goto L6;
        r103.setSolidColors(r102.getContentContainerBgColor());
    L6:
        r100.f338592a.getContentContainer().setSelected(false);
    }

    public e(ODiaryStyleAdapter.StyleViewHolder r100) {
        this.f338627a = r100;
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.j
    public final void c(OSwipeLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        ODiaryStyleAdapter.StyleViewHolder r101 = this.f338627a;
        r101.f338596e.invoke(r101.f338592a);
    }
}
