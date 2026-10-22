package com.bytedance.ee.bear.core.toolbar.selectcolor.impl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.document.edit_toolbar.g;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;

/* JADX INFO: loaded from: classes16.dex */
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

    public void setDelegate(a r100) {
        this.delegate = r100;
    }

    public void updateHighlight(Highlight r100) {
        ((MutableLiveData) getHighlightLiveData()).setValue(r100);
    }

    public void selectColor(Highlight.ColorItem r100, Highlight.ColorItem r101, Highlight.ColorItem r102, Highlight.ColorItem r103) {
        a r104 = this.delegate;
        if (r104 == null) goto L6;
        ((g) r104).f219589a.a(r100, r101, r102, r103);
        return;
    }
}
