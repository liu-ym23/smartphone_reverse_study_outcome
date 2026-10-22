package com.bytedance.ug.sdk.deeplink.interfaces;

import android.content.ClipData;
import mi7.e;

/* JADX INFO: loaded from: classes22.dex */
public abstract class AbstractClipboardObserver implements Comparable<AbstractClipboardObserver> {
    private int mPriority;
    private String mTag;

    public abstract boolean notifyClipboardContent(ClipData r100);

    public String getClassName() {
        return getClass().getName();
    }

    public int getPriority() {
        return this.mPriority;
    }

    public String getTag() {
        return this.mTag;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(AbstractClipboardObserver r100) {
        int r101 = this.mPriority;
        int r102 = r100.mPriority;
        if (r101 >= r102) goto L5;
        return -1;
    L5:
        if (r101 != r102) goto L7;
        return 0;
    L7:
        return 1;
    }

    public final boolean process(ClipData r100) {
        long r101 = System.currentTimeMillis();
        boolean r102 = notifyClipboardContent(r100);
        e.a(this.mTag, "ClipboardObserver : " + this.mTag + " has consumed the clipData for " + (System.currentTimeMillis() - r101) + "ms");
        return r102;
    }

    public void setPriority(int r100) {
        this.mPriority = r100;
    }

    public void setTag(String r100) {
        this.mTag = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(AbstractClipboardObserver r100) {
        return compareTo2(r100);
    }

    public AbstractClipboardObserver(String r100, int r101) {
        this.mTag = r100;
        this.mPriority = r101;
    }
}
