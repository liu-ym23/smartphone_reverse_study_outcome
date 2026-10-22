package com.ss.android.lark.flow.passport.ui.widget.layout;

import androidx.core.widget.NestedScrollView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements NestedScrollView.OnScrollChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonContainerLayout f423882a;

    public d(CommonContainerLayout r100) {
        this.f423882a = r100;
    }

    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
    public final void onScrollChange(NestedScrollView r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "<unused var>");
        CommonContainerLayout r105 = this.f423882a;
        int r106 = r105.R5(r105.getTitleBarContainer());
        CommonContainerLayout r107 = this.f423882a;
        r107.f423862b.getLocationOnScreen(r107.f423863c);
        CommonContainerLayout r108 = this.f423882a;
        int r109 = r108.f423863c[1] + r108.f423862b.getHeight();
        Function1<Integer, Unit> r110 = this.f423882a.getOnContentScrollListener();
        if (r110 == null) goto L6;
        r110.invoke(Integer.valueOf(r109 - r106));
        return;
    }
}
