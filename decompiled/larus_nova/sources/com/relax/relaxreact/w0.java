package com.relax.relaxreact;

import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class w0<T> extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l<T> f405595c;

    public w0(Context<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(HookType.Provider);
        l<T> r102 = new l(r100, r101);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f405595c = r102;
        d r103 = this.f405462b;
        if (r103 == null) goto L12;
        int r104 = r100.f405396a;
        Intrinsics.checkNotNullParameter(r102, ShortVideoSegments.KEY_PROP_PROVIDER);
        if (r103.f405482i == true) goto L10;
        final LinkedHashMap r105 = new LinkedHashMap();
        Map<Integer, k> r106 = r103.f405483j;
        if (r106 == null) goto L9;
        com.bytedance.rts.kmp.foundation.j.b(r106, new ComponentInstance$provideContext$1(r105));
    L9:
        r103.f405483j = r105;
        r103.f405482i = true;
    L10:
        Map<Integer, k> r107 = r103.f405483j;
        Intrinsics.checkNotNull(r107);
        com.bytedance.rts.kmp.foundation.j.e(r107, Integer.valueOf(r104), r102);
        return;
    }
}
