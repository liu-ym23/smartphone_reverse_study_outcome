package com.ss.android.lark.cameraview;

import android.content.res.Configuration;
import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f410869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<Integer, Integer, Unit> f410870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f410871c;

    public final void a(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        int r101 = this.f410869a.getWindowManager().getDefaultDisplay().getRotation();
        int r102 = this.f410871c;
        if (r101 == r102) goto L6;
        this.f410871c = r101;
        this.f410870b.invoke(Integer.valueOf(r102), Integer.valueOf(r101));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b1(FragmentActivity r100, Function2<? super Integer, ? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r101, "doOnRotationChanged");
        this.f410869a = r100;
        this.f410870b = r101;
        this.f410871c = r100.getWindowManager().getDefaultDisplay().getRotation();
    }
}
