package com.obric.miniapp.lynx;

import android.content.Context;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public class i4 extends FrameLayout {
    public i4(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSetPressed(boolean r100) {
        if (r100 == true) goto L5;
        super.dispatchSetPressed(false);
        return;
    }

    @Override // android.view.View
    public void setPressed(boolean r100) {
        if (r100 == false) goto L4;
        return;
    L4:
        if (isPressed() == false) goto L8;
        super.setPressed(false);
        return;
    }
}
