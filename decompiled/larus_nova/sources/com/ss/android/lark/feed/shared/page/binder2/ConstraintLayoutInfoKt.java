package com.ss.android.lark.feed.shared.page.binder2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes35.dex */
public final class ConstraintLayoutInfoKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    public static final View a(ConstraintLayout r100, FeedCardComponent<?, ?>[] r101, final a r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "components");
        Intrinsics.checkNotNullParameter(r102, "layoutInfo");
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        if (r101.length <= 1) goto L5;
        ?? r104 = new LinearLayout(r100.getContext());
        ConstraintLayout.LayoutParams r105 = new ConstraintLayout.LayoutParams(0, -2);
        r105.startToEnd = r102.f421339a;
        r105.topToBottom = r102.f421340b;
        r105.endToStart = r102.f421341c;
        r105.bottomToTop = r102.f421342d;
        ((ViewGroup.MarginLayoutParams) r105).topMargin = r102.f421344f;
        ((ViewGroup.MarginLayoutParams) r105).leftMargin = r102.f421343e;
        ((ViewGroup.MarginLayoutParams) r105).rightMargin = r102.f421345g;
        ((ViewGroup.MarginLayoutParams) r105).bottomMargin = r102.f421346h;
        r100.addView(r104, r105);
        b(r104, r101, ConstraintLayoutInfoKt$addComponents$1.INSTANCE);
        r103.element = r104;
    L7:
        return (View) r103.element;
    L5:
        b(r100, r101, new ConstraintLayoutInfoKt$addComponents$2(r103, r102));
        goto L7
    }

    public static final void b(ViewGroup r100, FeedCardComponent<?, ?>[] r101, Function1<? super FeedCardComponent<?, ?>, ? extends ViewGroup.LayoutParams> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "components");
        Intrinsics.checkNotNullParameter(r102, "getLayoutParams");
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        FeedCardComponent<?, ?> r105 = r101[r104];
        r100.addView(r105.c(), r102.invoke(r105));
        r104 = r104 + 1;
        goto L3
    }
}
