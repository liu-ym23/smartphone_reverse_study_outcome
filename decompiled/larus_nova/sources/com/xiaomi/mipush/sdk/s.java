package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.av;

/* JADX INFO: loaded from: classes41.dex */
public class s {
    public static AbstractPushManager a(Context r100, d r101) {
        return b(r100, r101);
    }

    private static AbstractPushManager b(Context r100, d r101) {
        g.a r102 = g.a(r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r102.f463066a) == false) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(r102.f463067b) == false) goto L9;
        return null;
    L9:
        return (AbstractPushManager) av.a(r102.f463066a, r102.f463067b, new Object[]{r100});
    }
}
