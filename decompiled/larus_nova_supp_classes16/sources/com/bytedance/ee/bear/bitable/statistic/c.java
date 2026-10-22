package com.bytedance.ee.bear.bitable.statistic;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface c extends n {
    void a(long r1);

    void d(h r1);

    void f(RecyclerView r1);

    void g();

    @Override // com.bytedance.ee.bear.bitable.statistic.n
    BitableTraceType getType();

    void start();

    void stop();
}
