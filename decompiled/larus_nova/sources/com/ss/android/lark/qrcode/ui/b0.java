package com.ss.android.lark.qrcode.ui;

import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f439040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<Integer, Integer, Unit> f439041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f439042c;

    /* JADX WARN: Multi-variable type inference failed */
    public b0(FragmentActivity r100, Function2<? super Integer, ? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r101, "doOnRotationChanged");
        this.f439040a = r100;
        this.f439041b = r101;
        this.f439042c = r100.getWindowManager().getDefaultDisplay().getRotation();
    }
}
