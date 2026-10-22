package com.bytedance.ee.bear.drive.core.fragment;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.mimetype.MimeTypeCategory;

/* JADX INFO: loaded from: classes16.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f224212a;

    public e(d r100) {
        this.f224212a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        MimeTypeCategory r101 = (MimeTypeCategory) r100;
        this.f224212a.l();
    }
}
