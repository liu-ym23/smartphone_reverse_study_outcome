package com.bytedance.awemeopen.apps.photo.utils;

import android.content.Context;
import android.util.Size;
import androidx.core.math.MathUtils;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r14.y;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements c {
    public b() {
    }

    @Override // com.bytedance.awemeopen.apps.photo.utils.c
    public final Size a(r14.c r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, ShareChannel.DOUYIN);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        List<y> r102 = r100.v();
        int r103 = 0;
        if (r102 == null) goto L5;
        y r104 = (y) CollectionsKt.getOrNull(r102, 0);
    L6:
        if (r104 == null) goto L8;
        int r105 = r104.d();
    L9:
        if (r104 == null) goto L11;
        r103 = r104.a();
    L11:
        if (r103 != 0) goto L13;
        float r106 = 1.0f;
    L14:
        int r107 = d0.d(r101);
        return new Size(r107, (int) (r107 / MathUtils.clamp(r106, 0.75f, 1.3333334f)));
    L13:
        r106 = r105 / r103;
        goto L14
    L8:
        r105 = 0;
        goto L9
    L5:
        r104 = null;
        goto L6
    }
}
