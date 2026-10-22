package com.bytedance.ee.util.ui;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public class RecyclerItemsDiff extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f243152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f243153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f243154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f243155d;

    public interface a<T> {
        Object a(T r100, T r101);
    }

    public interface b<T> {
        boolean areContentsTheSame(T r100, T r101);

        boolean areItemsTheSame(T r100, T r101);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        List r100 = this.f243153b;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        List r100 = this.f243152a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        return this.f243154c.areContentsTheSame(ListProtector.get(this.f243152a, r100), ListProtector.get(this.f243153b, r101));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        return this.f243154c.areItemsTheSame(ListProtector.get(this.f243152a, r100), ListProtector.get(this.f243153b, r101));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final Object getChangePayload(int r100, int r101) {
        a r102 = this.f243155d;
        if (r102 == null) goto L7;
        return r102.a(ListProtector.get(this.f243152a, r100), ListProtector.get(this.f243153b, r101));
    L7:
        return super.getChangePayload(r100, r101);
    }

    public RecyclerItemsDiff(List r100, List r101, b r102) {
        this.f243152a = r100;
        this.f243153b = r101;
        this.f243154c = r102;
    }
}
