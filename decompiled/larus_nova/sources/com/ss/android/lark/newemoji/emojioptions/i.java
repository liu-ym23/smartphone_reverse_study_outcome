package com.ss.android.lark.newemoji.emojioptions;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes36.dex */
public interface i {

    public static final class a {
        public static float a(i r100, int r101) {
            Resources r102 = r100.a().getResources();
            return TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
        }
    }

    Context a();
}
