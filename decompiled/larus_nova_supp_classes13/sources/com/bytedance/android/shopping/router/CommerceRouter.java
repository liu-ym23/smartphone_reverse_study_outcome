package com.bytedance.android.shopping.router;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CommerceRouter {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(long r5, final Activity r7, final String r8, Function1 r9) {
        Intrinsics.checkNotNullParameter(r9, "jumpAppSuccess");
        if (TextUtils.isEmpty(r8) == true) goto L24;
        if (r7 == null) goto L24;
        SourceType.Companion.getClass();
        boolean r2 = true;
        if (r5 != SourceType.JINGDONG.getType()) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L13;
        String r6 = "com.jingdong.app.mall";
    L19:
        Function0<Boolean> r10 = new CommerceRouter$openApp$1(r7, r8);
        if (ita.k.h(r7, r6) == false) goto L22;
        r9.invoke(Boolean.valueOf(((Boolean) r10.invoke()).booleanValue()));
        return;
    L22:
        r9.invoke(Boolean.FALSE);
        return;
    L13:
        if (r5 == SourceType.KAOLA.getType()) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L18;
        r6 = "com.kaola";
        goto L19
    L18:
        r6 = "";
        goto L19
    L9:
        r0 = false;
    L24:
        r9.invoke(Boolean.FALSE);
    }
}
