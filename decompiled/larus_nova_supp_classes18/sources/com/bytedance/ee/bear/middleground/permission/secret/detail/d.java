package com.bytedance.ee.bear.middleground.permission.secret.detail;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public final Context a;
    public final View b;
    public List<j> c;
    public List<a> d;
    public List<b> e;
    public final int f;

    public final Context getContext() {
        return this.a;
    }

    public d(Context r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "mRootView");
        this.a = r2;
        this.b = r3;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = 3;
    }
}
