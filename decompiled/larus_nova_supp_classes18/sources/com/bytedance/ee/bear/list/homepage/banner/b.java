package com.bytedance.ee.bear.list.homepage.banner;

import androidx.lifecycle.Observer;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ a<f, g<Object>, g.a> a;

    public b(a<f, g<Object>, g.a> r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        a<f, g<Object>, g.a> r0 = this.a;
        r0.O8((ArrayList) r2);
    }
}
