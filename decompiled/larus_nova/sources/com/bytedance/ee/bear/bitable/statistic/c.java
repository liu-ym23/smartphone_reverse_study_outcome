package com.bytedance.ee.bear.bitable.statistic;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes16.dex */
public interface c extends n {
    void a(long r100);

    void d(h r100);

    void f(RecyclerView r100);

    void g();

    @Override // com.bytedance.ee.bear.bitable.statistic.n
    BitableTraceType getType();

    void start();

    void stop();
}
