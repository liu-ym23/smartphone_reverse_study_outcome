package com.bytedance.ee.bear.lark.selector.base;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.widget.recyclerview.MultiTypeAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class SelectorAdapter<Value> extends MultiTypeAdapter<Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Value> f227494a;

    @Override // com.ss.android.lark.widget.recyclerview.MultiTypeAdapter, zdc.c
    public final RecyclerView.Adapter<?> e() {
        return this;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f227494a).size();
    }

    public SelectorAdapter() {
        this.f227494a = new ArrayList();
    }

    @Override // com.ss.android.lark.widget.recyclerview.MultiTypeAdapter, zdc.c
    public final Value getItem(int r100) {
        return (Value) ListProtector.get(this.f227494a, r100);
    }
}
