package com.bytedance.ee.larkwebview.service.listener;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes19.dex */
public interface OnViewScrollListener {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollDirection {
    }

    void a();

    void b();

    void c(int r100, int r101);
}
