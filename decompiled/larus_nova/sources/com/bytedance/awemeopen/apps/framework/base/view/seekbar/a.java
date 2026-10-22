package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import android.graphics.Canvas;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class a {
    public abstract boolean a();

    public abstract void b(Canvas r100);

    public abstract int c();

    public a(NoAnchorSeekBar r100) {
        Intrinsics.checkNotNullParameter(r100, "seekBar");
        r100.getDrawers().add(this);
    }
}
