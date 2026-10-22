package com.bytedance.ee.larkwebview.quality.safe;

import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static final void a(Intent r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.putExtra("android.intent.extra.ALLOW_MULTIPLE", r101);
    }
}
