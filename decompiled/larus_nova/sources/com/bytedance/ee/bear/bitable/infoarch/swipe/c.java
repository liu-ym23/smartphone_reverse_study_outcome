package com.bytedance.ee.bear.bitable.infoarch.swipe;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f213689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f213690b;

    public final Activity getActivity() {
        return this.f213689a;
    }

    public c(Activity r100, m r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f213689a = r100;
        this.f213690b = r101;
    }
}
