package com.ss.android.lark.coremd.ext;

import com.bytedance.android.livesdk.gift.model.n;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class l {
    public static final void a(com.ss.android.lark.coremd.impl.parse.b.a r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L8;
        Iterator r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        r100.b((com.ss.android.lark.coremd.base.parse.f) r102.next());
        goto L6
    L10:
        return;
    }

    public static final void b(com.ss.android.lark.coremd.impl.parse.b.a r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, n.KEY_PLUGINS);
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r100.e((com.ss.android.lark.coremd.base.parse.g) r102.next());
        goto L4
    }
}
