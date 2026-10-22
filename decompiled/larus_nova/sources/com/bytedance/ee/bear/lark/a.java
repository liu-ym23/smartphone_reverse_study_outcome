package com.bytedance.ee.bear.lark;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseHeaderFragment f227207a;

    public a(BaseHeaderFragment r100) {
        this.f227207a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        tt5.a.h(this.f227207a.getLogTag(), "secondNodeWidth: " + r101);
        boolean r102 = true;
        boolean r103 = false;
        if (r101.intValue() >= this.f227207a.f227163j) goto L8;
        r102 = false;
        if (r101.intValue() >= this.f227207a.f227164k) goto L8;
        r103 = true;
    L8:
        BaseHeaderFragment r104 = this.f227207a;
        if (r102 == r104.f227165l) goto L11;
    L13:
        r104.f227165l = r102;
        r104.f227166m = r103;
        if (r104.getView() == null) goto L17;
        BaseHeaderFragment r105 = this.f227207a;
        View r106 = r105.getView();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.view.ViewGroup");
        r105.Z90((ViewGroup) r106);
        return;
    L17:
        return;
    L11:
        if (r103 != r104.f227166m) goto L13;
    }
}
