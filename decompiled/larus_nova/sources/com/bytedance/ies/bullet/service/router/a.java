package com.bytedance.ies.bullet.service.router;

import android.net.Uri;
import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements b {
    public a() {
    }

    @Override // com.bytedance.ies.bullet.service.router.b
    public final void b(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "bulletUri");
    }

    @Override // com.bytedance.ies.bullet.service.router.b
    public final boolean a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        if (r100.isHierarchical() == true) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(r100.getScheme()) == true) goto L9;
        if (TextUtils.isEmpty(r100.getHost()) == true) goto L9;
        return true;
    }
}
