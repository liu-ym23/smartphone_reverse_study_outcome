package com.haibin.calendarview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes23.dex */
public final class YearRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f276114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f276115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f276116c;

    public class a implements com.haibin.calendarview.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ YearRecyclerView f276117a;

        public a(YearRecyclerView r100) {
            this.f276117a = r100;
        }
    }

    public interface b {
    }

    public YearRecyclerView(Context r100) {
        this(r100, null);
    }

    public final void setOnMonthSelectedListener(b r100) {
        this.f276116c = r100;
    }

    public final void setup(l r100) {
        this.f276114a = r100;
        this.f276115b.f276249e = r100;
    }

    public YearRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
        z r102 = new z(r100);
        this.f276115b = r102;
        setLayoutManager(new GridLayoutManager(r100, 3));
        setAdapter(r102);
        r102.f276143b = new a(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = View.MeasureSpec.getSize(r101);
        int r103 = View.MeasureSpec.getSize(r100);
        z r104 = this.f276115b;
        r104.f276250f = r103 / 3;
        r104.f276251g = r102 / 4;
    }
}
