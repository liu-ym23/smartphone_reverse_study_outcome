package com.obric.assistant.interaction.impl.window;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowDensityManager;", "", "<init>", "()V", "lastSystemDensityDpi", "", "hasSystemDensityChanged", "", "base", "Landroid/content/Context;", "configuration", "Landroid/content/res/Configuration;", "resolveDensityDpi", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowDensityManager {
    public static final Companion Companion = null;
    private static final int INVALID_DENSITY_DPI = Integer.MIN_VALUE;
    private static final String TAG = "WindowDensityManager";
    private volatile int lastSystemDensityDpi;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowDensityManager$Companion;", "", "<init>", "()V", "TAG", "", "INVALID_DENSITY_DPI", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WindowDensityManager() {
        this.lastSystemDensityDpi = Integer.MIN_VALUE;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_WindowDensityManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private final int resolveDensityDpi(Context r100, Configuration r101) {
        Integer r102 = Integer.valueOf(r101.densityDpi);
        boolean r103 = true;
        if (r102.intValue() <= 0) goto L5;
        boolean r104 = true;
    L6:
        Integer r105 = null;
        if (r104 == true) goto L10;
        r102 = null;
    L10:
        if (r102 != null) goto L22;
        Integer r106 = Integer.valueOf(r100.getResources().getConfiguration().densityDpi);
        if (r106.intValue() > 0) goto L16;
        r103 = false;
    L16:
        if (r103 == false) goto L18;
        r105 = r106;
    L18:
        if (r105 == null) goto L21;
        return r105.intValue();
    L21:
        return INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_WindowDensityManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).densityDpi;
    L22:
        return r102.intValue();
    L5:
        r104 = false;
        goto L6
    }

    public final boolean hasSystemDensityChanged(Context r100, Configuration r101) {
        Intrinsics.checkNotNullParameter(r100, "base");
        Intrinsics.checkNotNullParameter(r101, "configuration");
        int r102 = resolveDensityDpi(r100, r101);
        if (this.lastSystemDensityDpi == r102) goto L5;
        boolean r103 = true;
    L6:
        this.lastSystemDensityDpi = r102;
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("hasSystemDensityChanged: ");
        r105.append(r103);
        r105.append(", reason=");
        if (r103 == false) goto L9;
        String r106 = "system_density_changed";
    L10:
        r105.append(r106);
        r105.append(", currentDensityDpi=");
        r105.append(r102);
        r105.append(", lastSystemDensityDpi=");
        r105.append(this.lastSystemDensityDpi);
        r105.append(", configDensityDpi=");
        r105.append(r101.densityDpi);
        r105.append(", baseDensityDpi=");
        r105.append(r100.getResources().getConfiguration().densityDpi);
        r105.append(", displayMetricsDensityDpi=");
        r105.append(INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_WindowDensityManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).densityDpi);
        r104.i(TAG, r105.toString());
        return r103;
    L9:
        r106 = "system_density_no_change";
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    public static /* synthetic */ boolean hasSystemDensityChanged$default(WindowDensityManager r100, Context r101, Configuration r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = r101.getResources().getConfiguration();
    L6:
        return r100.hasSystemDensityChanged(r101, r102);
    }
}
