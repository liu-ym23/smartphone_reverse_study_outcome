package com.bytedance.ee.plugin.common.ttpdfreader;

import android.graphics.Bitmap;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes19.dex */
public class PagePart {
    private int cacheOrder;
    private int page;
    private RectF pageRelativeBounds;
    private Bitmap renderedBitmap;
    private boolean thumbnail;

    public int getCacheOrder() {
        return this.cacheOrder;
    }

    public int getPage() {
        return this.page;
    }

    public RectF getPageRelativeBounds() {
        return this.pageRelativeBounds;
    }

    public Bitmap getRenderedBitmap() {
        return this.renderedBitmap;
    }

    public boolean isThumbnail() {
        return this.thumbnail;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof PagePart) == true) goto L5;
        return false;
    L5:
        PagePart r101 = (PagePart) r100;
        if (r101.getPage() == this.page) goto L8;
        return false;
    L8:
        if (r101.getPageRelativeBounds().left == this.pageRelativeBounds.left) goto L10;
        return false;
    L10:
        if (r101.getPageRelativeBounds().right == this.pageRelativeBounds.right) goto L12;
        return false;
    L12:
        if (r101.getPageRelativeBounds().top == this.pageRelativeBounds.top) goto L14;
        return false;
    L14:
        if (r101.getPageRelativeBounds().bottom != this.pageRelativeBounds.bottom) goto L21;
        return true;
    L21:
        return false;
    }

    public void setCacheOrder(int r100) {
        this.cacheOrder = r100;
    }

    public PagePart(int r100, Bitmap r101, RectF r102, boolean r103, int r104) {
        this.page = r100;
        this.renderedBitmap = r101;
        this.pageRelativeBounds = r102;
        this.thumbnail = r103;
        this.cacheOrder = r104;
    }
}
