package com.bytedance.ee.bear.list.homepage.banner;

import androidx.lifecycle.Observer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a<f, g<Object>, g.a> f228285a;

    public b(a<f, g<Object>, g.a> r100) {
        this.f228285a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        a<f, g<Object>, g.a> r101 = this.f228285a;
        r101.O8((ArrayList) r100);
    }
}
