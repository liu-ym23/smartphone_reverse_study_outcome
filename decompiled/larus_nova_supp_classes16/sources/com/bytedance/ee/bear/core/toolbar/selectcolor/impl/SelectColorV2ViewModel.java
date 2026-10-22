package com.bytedance.ee.bear.core.toolbar.selectcolor.impl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.document.edit_toolbar.g;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectColorV2ViewModel extends ViewModel {
    private a delegate;
    private MutableLiveData<Highlight> highlightLiveData;

    public interface a {
    }

    public LiveData<Highlight> getHighlightLiveData() {
        if (this.highlightLiveData != null) goto L6;
        this.highlightLiveData = new MutableLiveData();
    L6:
        return this.highlightLiveData;
    }

    public SelectColorV2ViewModel() {
    }

    public void setDelegate(a r1) {
        this.delegate = r1;
    }

    public void updateHighlight(Highlight r2) {
        getHighlightLiveData().setValue(r2);
    }

    public void selectColor(Highlight.ColorItem r2, Highlight.ColorItem r3, Highlight.ColorItem r4, Highlight.ColorItem r5) {
        a r0 = this.delegate;
        if (r0 == null) goto L6;
        ((g) r0).a.a(r2, r3, r4, r5);
        return;
    }
}
