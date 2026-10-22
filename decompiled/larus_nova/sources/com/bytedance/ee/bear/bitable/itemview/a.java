package com.bytedance.ee.bear.bitable.itemview;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<b> f213768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LayoutInflater f213769b;

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (Intrinsics.areEqual("layout_inflater", r100) == false) goto L9;
        if (this.f213769b != null) goto L10;
        this.f213769b = LayoutInflater.from(getBaseContext()).cloneInContext(this);
    L10:
        return this.f213769b;
    L9:
        return super.getSystemService(r100);
    }

    public a(Context r100, WeakReference<b> r101) {
        Intrinsics.checkNotNullParameter(r100, "base");
        Intrinsics.checkNotNullParameter(r101, "dependency");
        super(r100);
        this.f213768a = r101;
    }
}
