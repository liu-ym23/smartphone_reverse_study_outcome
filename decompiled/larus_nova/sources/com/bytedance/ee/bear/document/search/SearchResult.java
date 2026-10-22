package com.bytedance.ee.bear.document.search;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: classes16.dex */
public class SearchResult implements BaseJSModel {
    private int currentIndex;
    private int totalNum;

    public SearchResult() {
    }

    public String toString() {
        return "SearchResult{currentIndex=" + this.currentIndex + ", totalNum=" + this.totalNum + '}';
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public int getTotalNum() {
        return this.totalNum;
    }

    public void setCurrentIndex(int r100) {
        this.currentIndex = r100;
    }

    public void setTotalNum(int r100) {
        this.totalNum = r100;
    }
}
