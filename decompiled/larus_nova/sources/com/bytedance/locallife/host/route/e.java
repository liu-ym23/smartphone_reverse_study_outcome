package com.bytedance.locallife.host.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements fo6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fo6.d f258917a;

    public static final class a {
    }

    static {
    }

    @Override // fo6.d
    public final void b(Context r100, Uri r101, Intent r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "intent");
        this.f258917a.b(r100, r101, r102);
    }

    public e(com.bytedance.locallife.adapter.impl.router.c r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f258917a = r100;
    }

    @Override // fo6.d
    public final boolean a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        String r101 = UriProtector.getQueryParameter(r100, "url");
        if (r101 != null) goto L6;
        r101 = UriProtector.getQueryParameter(r100, "surl");
    L6:
        if (r101 == null) goto L10;
        boolean r102 = true;
        if (StringsKt.contains$default(r101, "life.scsjsd.com/life-service/common-h5/poi", false, 2, null) != true) goto L10;
    L11:
        if (r102 == true) goto L14;
        return false;
    L14:
        return this.f258917a.a(r100);
    L10:
        r102 = false;
        goto L11
    }
}
