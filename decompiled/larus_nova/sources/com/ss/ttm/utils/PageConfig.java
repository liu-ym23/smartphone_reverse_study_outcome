package com.ss.ttm.utils;

/* JADX INFO: loaded from: classes40.dex */
public class PageConfig extends ReuseConfig {
    public PageConfig copy() {
        return new PageConfig(this);
    }

    private PageConfig(PageConfig r100) {
        super(r100, 1);
    }

    public PageConfig(UserConfig r100) {
        super(r100, 0);
    }
}
