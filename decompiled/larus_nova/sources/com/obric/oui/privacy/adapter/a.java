package com.obric.oui.privacy.adapter;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends RecyclerView.y {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f402462w = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final OCardListItem f402463u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final LinearLayout f402464v;

    /* JADX INFO: renamed from: com.obric.oui.privacy.adapter.a$a, reason: collision with other inner class name */
    public static final class C4678a {
    }

    static {
    }

    public a(OCardListItem r100) {
        Intrinsics.checkNotNullParameter(r100, "cardListItem");
        super(r100);
        this.f402463u = r100;
        r100.setCardType(2);
        OCardListItem.h(r100, 0);
        LinearLayout r101 = new LinearLayout(r100.getContext());
        r101.setOrientation(1);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f402464v = r101;
        r100.setCustomStartView(r101);
        r100.n(true);
    }
}
