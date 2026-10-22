package com.bytedance.ies.bullet.ui.common.loader;

import android.net.Uri;
import b36.e;
import com.bytedance.ies.bullet.core.q;
import com.bytedance.ies.bullet.core.v;
import com.bytedance.ies.bullet.secure.SccConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f248274c;

    public c(q r100, e r101) {
        this.f248274c = r101;
        super(r100);
    }

    @Override // com.bytedance.ies.bullet.core.v, com.bytedance.ies.bullet.core.s
    public final void onLoadFail(Uri r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "e");
        if (this.f248274c.i() != SccConfig.SccLevel.SAFE) goto L5;
        this.f248274c.g();
        super.onLoadFail(r100, r101);
        return;
    L5:
        super.onLoadFail(r100, r101);
    }
}
