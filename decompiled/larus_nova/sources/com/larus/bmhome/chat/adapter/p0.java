package com.larus.bmhome.chat.adapter;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class p0 implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f297111a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f297112b = null;

    public p0() {
    }

    static {
        f297111a = new p0();
        f297112b = LazyKt.lazy(new o0());
    }

    public static long b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        return ((Keva) f297112b.getValue()).getLong("last_action_id_".concat(r100), 0);
    }

    public static String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        return ((Keva) f297112b.getValue()).getString("last_reply_id_".concat(r100), "");
    }

    @Override // com.larus.bmhome.chat.adapter.j
    public final void a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        ((Keva) f297112b.getValue()).erase("last_action_id_" + r100);
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }
}
