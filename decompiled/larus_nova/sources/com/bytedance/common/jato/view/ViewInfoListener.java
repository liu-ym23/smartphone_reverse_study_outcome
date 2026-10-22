package com.bytedance.common.jato.view;

import android.view.View;
import com.bytedance.common.jato.view.ViewInfo;

/* JADX INFO: loaded from: classes15.dex */
public interface ViewInfoListener<T extends ViewInfo> {
    void onViewAttached(View r100, T r101);

    void onViewCreated(View r100, T r101);

    void onViewDestroy(T r100);

    void onViewDetached(View r100, T r101);
}
