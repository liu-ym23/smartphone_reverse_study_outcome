package com.bytedance.applet.task;

import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r {
    public static final String a(int r3) {
        int r4 = ContextCompat.getColor(AppHost.a.getApplication(), r3);
        int r5 = ((r4 & 16777215) << 8) | ((r4 >>> 24) & 255);
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(r5)}, 1));
    }
}
