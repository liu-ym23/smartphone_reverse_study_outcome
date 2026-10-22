package com.bytedance.awemeopen.apps.framework.feed.slide.framework.element;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class c<E extends a, M extends b> {
    public final Context a;
    public final E b;
    public final M c;
    public View d;

    public abstract View a(ViewGroup r1);

    public abstract void c();

    public final View b() {
        View r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    }

    public final Context getContext() {
        return this.a;
    }

    public c(Context r2, E r3, M r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
