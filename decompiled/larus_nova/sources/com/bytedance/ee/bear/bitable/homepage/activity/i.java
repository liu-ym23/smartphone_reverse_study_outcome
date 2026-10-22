package com.bytedance.ee.bear.bitable.homepage.activity;

import androidx.lifecycle.Observer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes15.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableMessageFragment f212316a;

    public i(BitableMessageFragment r100) {
        this.f212316a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        BitableMessageFragment r101 = this.f212316a;
        int r102 = BitableMessageFragment.f212271t;
        r101.ba0((ArrayList) r100);
    }
}
