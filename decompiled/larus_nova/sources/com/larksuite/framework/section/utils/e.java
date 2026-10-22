package com.larksuite.framework.section.utils;

import android.view.View;
import com.larksuite.component.universe_design.button.UDButton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f285715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f285716b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f285715a, r101.f285715a) == true) goto L12;
        return false;
    L12:
        if (this.f285716b == r101.f285716b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f285715a.hashCode() * 31;
        long r101 = this.f285716b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "DebounceView(view=" + this.f285715a + ", lastClickTime=" + this.f285716b + ')';
    }

    public e(UDButton r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f285715a = r100;
        this.f285716b = 0;
    }
}
