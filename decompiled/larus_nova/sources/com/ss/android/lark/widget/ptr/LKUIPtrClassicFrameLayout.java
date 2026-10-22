package com.ss.android.lark.widget.ptr;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes38.dex */
public class LKUIPtrClassicFrameLayout extends LKUIPtrFrameLayout {
    private LKUIPtrDefaultFooter mPtrClassicFooter;
    private LKUIPtrDefaultHeader mPtrClassicHeader;

    private void initViews() {
        LKUIPtrDefaultHeader r100 = new LKUIPtrDefaultHeader(getContext());
        this.mPtrClassicHeader = r100;
        setHeaderView(r100);
        addPtrUIHandler(this.mPtrClassicHeader);
        LKUIPtrDefaultFooter r101 = new LKUIPtrDefaultFooter(getContext());
        this.mPtrClassicFooter = r101;
        setFooterView(r101);
        addPtrUIHandler(this.mPtrClassicFooter);
    }

    public LKUIPtrDefaultHeader getHeader() {
        return this.mPtrClassicHeader;
    }

    public LKUIPtrClassicFrameLayout(Context r100) {
        super(r100);
        initViews();
    }

    public void setLastUpdateTimeFooterKey(String r100) {
        LKUIPtrDefaultFooter r101 = this.mPtrClassicFooter;
        if (r101 == null) goto L6;
        r101.setLastUpdateTimeKey(r100);
        return;
    }

    public void setLastUpdateTimeFooterRelateObject(Object r100) {
        LKUIPtrDefaultFooter r101 = this.mPtrClassicFooter;
        if (r101 == null) goto L6;
        r101.setLastUpdateTimeRelateObject(r100);
        return;
    }

    public void setLastUpdateTimeHeaderKey(String r100) {
        LKUIPtrDefaultHeader r101 = this.mPtrClassicHeader;
        if (r101 == null) goto L6;
        r101.setLastUpdateTimeKey(r100);
        return;
    }

    public void setLastUpdateTimeHeaderRelateObject(Object r100) {
        LKUIPtrDefaultHeader r101 = this.mPtrClassicHeader;
        if (r101 == null) goto L6;
        r101.setLastUpdateTimeRelateObject(r100);
        return;
    }

    public void setLastUpdateTimeKey(String r100) {
        setLastUpdateTimeHeaderKey(r100);
        setLastUpdateTimeFooterKey(r100);
    }

    public void setLastUpdateTimeRelateObject(Object r100) {
        setLastUpdateTimeHeaderRelateObject(r100);
        setLastUpdateTimeFooterRelateObject(r100);
    }

    public LKUIPtrClassicFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        initViews();
    }

    public LKUIPtrClassicFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        initViews();
    }
}
