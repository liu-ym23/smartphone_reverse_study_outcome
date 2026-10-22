package com.bytedance.ee.bear.bitable.card.view.table;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a implements n {
    public a() {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.table.n
    public void f() {
        View r100 = ((hq4.b) this).f486501a;
        r100.setTranslationX(0.0f);
        r100.setTranslationY(0.0f);
        r100.setScaleX(0.95f);
        r100.setScaleY(0.95f);
        r100.setAlpha(0.8f);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.table.n
    public void a() {
        View r100 = getRootView();
        r100.setScaleX(0.95f);
        r100.setScaleY(0.95f);
        r100.setAlpha(0.8f);
    }
}
