package ug4;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {
    public static final void a(Object... r110) {
        Intrinsics.checkNotNullParameter(r110, "msg");
        ALogger.i("KmpLyricComponent", ArraysKt.joinToString$default(r110, "====", null, null, 0, null, null, 62, null));
    }
}
