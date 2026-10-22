package com.obric.assistant.interaction.base.util;

import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/assistant/interaction/base/util/DeviceUtil;", "", "<init>", "()V", "DEFAULT_DISPLAY_ID", "", "EXTERNAL_DISPLAY_ID", "isSamsung", "", "isVerticalFoldable", "isHorizontalFoldable", "isExternalDisplayOn", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceUtil {
    public static final int DEFAULT_DISPLAY_ID = 0;
    public static final int EXTERNAL_DISPLAY_ID = 1;
    public static final DeviceUtil INSTANCE = null;

    static {
        INSTANCE = new DeviceUtil();
    }

    private DeviceUtil() {
    }

    public final boolean isExternalDisplayOn() {
        Object r100 = AppHost.f326268a.getApplication().getSystemService("display");
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        Display r101 = ((DisplayManager) r100).getDisplay(1);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.getState() != 2) goto L7;
        return true;
    }

    public final boolean isHorizontalFoldable() {
        return StringsKt.startsWith$default(Build.DEVICE.toLowerCase(), "q", false, 2, null);
    }

    public final boolean isSamsung() {
        return Intrinsics.areEqual(SmEditTextLeakOpt.SAMSUNG, Build.MANUFACTURER.toLowerCase());
    }

    public final boolean isVerticalFoldable() {
        return StringsKt.startsWith$default(Build.DEVICE.toLowerCase(), "b", false, 2, null);
    }
}
