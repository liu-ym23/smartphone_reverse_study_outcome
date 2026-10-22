package com.bytedance.ee.bear.lark.selector.base;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.widget.recyclerview.MultiTypeAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectorAdapter<Value> extends MultiTypeAdapter<Value> {
    public final List<Value> a;

    public final RecyclerView.Adapter<?> e() {
        return this;
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public SelectorAdapter() {
        this.a = new ArrayList();
    }

    public final Value getItem(int r2) {
        return (Value) ListProtector.get(this.a, r2);
    }
}
