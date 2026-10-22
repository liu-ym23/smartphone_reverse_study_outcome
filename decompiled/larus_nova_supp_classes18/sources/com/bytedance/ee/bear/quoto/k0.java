package com.bytedance.ee.bear.quoto;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k0 {
    public static final List<String> a = null;
    public static final List<String> b = null;

    public static final class a {
    }

    static {
        a = CollectionsKt.listOf(new String[]{"1", "2", "3", "4", "5", "6"});
        b = CollectionsKt.listOf(new String[]{"7", "8", "9"});
    }

    @JvmStatic
    public static final String a(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (TextUtils.equals(r2, "1") == false) goto L5;
    L16:
        String r3 = r1.getString(2131887565);
        Intrinsics.checkNotNull(r3);
        return r3;
    L5:
        if (TextUtils.equals(r2, "3") == true) goto L16;
        if (TextUtils.equals(r2, "4") == true) goto L16;
        if (TextUtils.equals(r2, "2") == false) goto L12;
    L15:
        String r4 = r1.getString(2131887564);
        Intrinsics.checkNotNull(r4);
        return r4;
    L12:
        if (TextUtils.equals(r2, "6") == true) goto L15;
        String r5 = r1.getString(2131887563);
        Intrinsics.checkNotNull(r5);
        return r5;
    }
}
