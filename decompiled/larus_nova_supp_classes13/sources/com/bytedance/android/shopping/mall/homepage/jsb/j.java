package com.bytedance.android.shopping.mall.homepage.jsb;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j extends qf3.e {
    public final String d;

    public final String getName() {
        return "ec.mallLocalImageDisplayCheck";
    }

    public j(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "file://";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r4, IBDXBridgeContext r5, Map<String, ? extends Object> r6, Map<String, Object> r7) {
        Intrinsics.checkNotNullParameter(r4, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "result");
        Context r8 = r4.a;
        boolean r9 = true;
        boolean r0 = false;
        if (r8 != null) goto L5;
    L7:
        boolean r10 = false;
    L9:
        if (r10 == false) goto L12;
        r7.put("canDisplayImage", Boolean.FALSE);
        r7.put("displayFailReason", "album_not_authorized");
        return qf3.e.f(this);
    L12:
        Object r11 = r6.get("imageLocalPath");
        if ((r11 instanceof String) == true) goto L15;
        r11 = null;
    L15:
        String r12 = (String) r11;
        if (r12 != null) goto L18;
    L21:
        if (r9 == true) goto L24;
        r0 = new PolarisFileWrapper(r12).exists();
    L24:
        if (r0 == false) goto L27;
        r7.put("canDisplayImage", Boolean.TRUE);
        r7.put("imagePath", this.d + r12);
        return qf3.e.f(this);
    L27:
        r7.put("canDisplayImage", Boolean.FALSE);
        r7.put("displayFailReason", "picture_not_exist");
        return qf3.e.f(this);
    L18:
        if (r12.length() == 0) goto L21;
        r9 = false;
        goto L21
    L5:
        if (ContextCompat.checkSelfPermission(r8, "android.permission.READ_EXTERNAL_STORAGE") != (-1)) goto L7;
        r10 = true;
        goto L9
    }
}
