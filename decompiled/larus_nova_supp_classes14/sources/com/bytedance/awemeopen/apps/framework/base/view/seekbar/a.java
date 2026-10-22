package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import android.graphics.Canvas;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a {
    public abstract boolean a();

    public abstract void b(Canvas r1);

    public abstract int c();

    public a(NoAnchorSeekBar r2) {
        Intrinsics.checkNotNullParameter(r2, "seekBar");
        r2.getDrawers().add(this);
    }
}
