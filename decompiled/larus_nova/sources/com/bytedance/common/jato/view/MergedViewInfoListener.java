package com.bytedance.common.jato.view;

import android.view.View;
import com.bytedance.common.jato.view.ViewInfo;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes15.dex */
public class MergedViewInfoListener<T extends ViewInfo> implements ViewInfoListener<T> {
    private final CopyOnWriteArrayList<ViewInfoListener<T>> listeners;

    public MergedViewInfoListener() {
        this.listeners = new CopyOnWriteArrayList();
    }

    public void add(ViewInfoListener<T> r100) {
        this.listeners.add(r100);
    }

    @Override // com.bytedance.common.jato.view.ViewInfoListener
    public void onViewDestroy(T r100) {
        if (this.listeners.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<ViewInfoListener<T>> r101 = this.listeners.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().onViewDestroy(r100);
        goto L7
    }

    public void remove(ViewInfoListener<T> r100) {
        this.listeners.remove(r100);
    }

    @Override // com.bytedance.common.jato.view.ViewInfoListener
    public void onViewAttached(View r100, T r101) {
        if (this.listeners.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<ViewInfoListener<T>> r102 = this.listeners.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r102.next().onViewAttached(r100, r101);
        goto L7
    }

    @Override // com.bytedance.common.jato.view.ViewInfoListener
    public void onViewCreated(View r100, T r101) {
        if (this.listeners.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<ViewInfoListener<T>> r102 = this.listeners.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r102.next().onViewCreated(r100, r101);
        goto L7
    }

    @Override // com.bytedance.common.jato.view.ViewInfoListener
    public void onViewDetached(View r100, T r101) {
        if (this.listeners.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<ViewInfoListener<T>> r102 = this.listeners.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r102.next().onViewDetached(r100, r101);
        goto L7
    }
}
