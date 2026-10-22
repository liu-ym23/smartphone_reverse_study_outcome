package com.haibin.calendarview;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes23.dex */
public final class z extends b<Month> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f276249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f276250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f276251g;

    public static class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final YearView f276252a;

        public a(YearView r100, l r101) {
            super(r100);
            this.f276252a = r100;
            r100.setup(r101);
        }
    }

    public z(Context r100) {
        super(r100);
    }
}
