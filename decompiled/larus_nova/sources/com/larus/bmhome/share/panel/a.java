package com.larus.bmhome.share.panel;

import android.content.Context;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class a extends FrameLayout {
    public void a(List<j> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
    }

    public void b() {
    }

    public abstract boolean c(String r100, boolean r101);

    public abstract void d(b r100, h r101);

    public abstract void setPanelViewClickable(boolean r100);

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
