package com.obric.aiagent.real;

import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"shouldUseForegroundServiceStart", "", "zeus_api_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KeepAliveServiceKt {
    public static final boolean shouldUseForegroundServiceStart() {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        return true;
    L5:
        return false;
    }
}
