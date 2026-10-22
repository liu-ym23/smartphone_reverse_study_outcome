package com.bytedance.awemeopen.apps.framework.comment.widget.view;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public final View a;
    public a b;

    public interface a {
        void a(int r1);
    }

    public d(View r2) {
        Intrinsics.checkNotNullParameter(r2, "watchedView");
        this.a = r2;
    }
}
