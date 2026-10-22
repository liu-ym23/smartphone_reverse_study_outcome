package yg0;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements nn0.a {
    public c() {
    }

    @Override // nn0.a
    public final void a(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        Intrinsics.checkNotNullParameter(r101, "content");
        if (r102 == false) goto L5;
        ALogger.e("LayoutConfigV2", "8-14[" + r100 + "]: " + r101);
        return;
    L5:
        ALogger.i("LayoutConfigV2", "8-14[" + r100 + "]: " + r101);
    }
}
