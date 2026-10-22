package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.larus.bmhome.chat.view.FixHorizontalDisallowRecyclerView;

/* JADX INFO: loaded from: classes25.dex */
public class ScrollToRecyclerView extends FixHorizontalDisallowRecyclerView {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f304869k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f304870l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f304871m;

    public interface a {
        void a(int r100);
    }

    public ScrollToRecyclerView(Context r100) {
        super(r100);
        this.f304869k = 0;
        this.f304870l = 0;
        this.f304871m = null;
        addOnScrollListener(new c1(this));
    }

    public void setRecyclerScrollListener(a r100) {
        this.f304871m = r100;
        addOnScrollListener(new c1(this));
    }

    public ScrollToRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f304869k = 0;
        this.f304870l = 0;
        this.f304871m = null;
        addOnScrollListener(new c1(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void scrollTo(int r100, int r101) {
        super.scrollTo(r100, r101);
        scrollBy(r100 - this.f304869k, r101 - this.f304870l);
    }

    public ScrollToRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f304869k = 0;
        this.f304870l = 0;
        this.f304871m = null;
        addOnScrollListener(new c1(this));
    }
}
