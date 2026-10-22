package com.bytedance.ee.bear.widgets.viewpager.viewpager2.adapter;

import android.os.Parcelable;

/* JADX INFO: loaded from: classes18.dex */
public interface StatefulAdapter {
    void restoreState(Parcelable r100);

    Parcelable saveState();
}
