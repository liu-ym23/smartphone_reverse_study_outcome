package com.bytedance.helios.sdk;

import android.app.Activity;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f245498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Lifecycle.Event f245499b;

    public final String toString() {
        return this.f245498a + '/' + this.f245499b;
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (TextUtils.equals(this.f245498a, r101.f245498a) == true) goto L11;
        return false;
    L11:
        if (this.f245499b != r101.f245499b) goto L15;
        return true;
    L15:
        return false;
    }

    public c(Activity r100, Lifecycle.Event r101) {
        this.f245498a = r100.toString();
        this.f245499b = r101;
        r100.hashCode();
    }
}
