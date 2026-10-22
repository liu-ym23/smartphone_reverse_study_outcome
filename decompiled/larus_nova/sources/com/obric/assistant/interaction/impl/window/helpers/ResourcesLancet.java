package com.obric.assistant.interaction.impl.window.helpers;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.This;

/* JADX INFO: loaded from: classes33.dex */
public class ResourcesLancet {
    public ResourcesLancet() {
    }

    public DisplayMetrics getDisplayMetrics() {
        return WindowDisplayMetricsOverride.apply((Resources) This.get(), (DisplayMetrics) Origin.call());
    }
}
