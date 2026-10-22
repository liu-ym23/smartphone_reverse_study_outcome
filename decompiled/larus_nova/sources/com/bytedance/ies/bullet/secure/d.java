package com.bytedance.ies.bullet.secure;

import android.net.Uri;
import com.bytedance.ies.argus.api.params.ArgusContainerCreateType;
import com.bytedance.ies.argus.api.params.o;
import com.bytedance.ies.bullet.core.BulletContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    public static final o a(BulletContext r100, ArgusContainerCreateType r101) {
        Intrinsics.checkNotNullParameter(r101, "createType");
        Uri r102 = null;
        if (r100 == null) goto L5;
        t36.d r103 = r100.f246437e;
        if (r103 == null) goto L9;
        r102 = r103.getOriginUrl();
    L9:
        o r104 = new o(r102, r101, r100.f246438f, r100.f246452t.f246562a);
        r104.f245773f = r100.getSessionId();
        return r104;
    L5:
        return new o(null, r101, null, 8);
    }
}
