package tn6;

import android.content.Context;
import android.provider.MediaStore;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements d {
    public b() {
    }

    @Override // tn6.d
    public final void b(Context r100, com.bytedance.locallife.biz.screenshot.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "externalObserver");
        r100.getContentResolver().unregisterContentObserver(r101);
    }

    @Override // tn6.d
    public final void a(Context r100, boolean r101, com.bytedance.locallife.biz.screenshot.b r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "externalObserver");
        r100.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r101, r102);
    }
}
