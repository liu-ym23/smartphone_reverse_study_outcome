package com.bytedance.ee.plugin.common.ttpdfreader;

import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public class Bookmark {
    private List<Bookmark> children;
    private long pageIdx;
    private String title;

    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    public List<Bookmark> getChildren() {
        return this.children;
    }

    public long getPageIdx() {
        return this.pageIdx;
    }

    public String getTitle() {
        return this.title;
    }

    public Bookmark(List<Bookmark> r100, String r101, long r102) {
        this.children = r100;
        this.title = r101;
        this.pageIdx = r102;
    }
}
