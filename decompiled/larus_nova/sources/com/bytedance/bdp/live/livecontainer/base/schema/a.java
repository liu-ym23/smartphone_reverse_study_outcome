package com.bytedance.bdp.live.livecontainer.base.schema;

import android.text.TextUtils;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.TypeCastException;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f201518a = 0;

    static {
    }

    public static String a(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L6;
        return "";
    L6:
        if (StringsKt.contains$default(r110, "://", false, 2, null) == false) goto L15;
        Object[] r111 = StringsKt.split$default(r110, new String[]{"://"}, false, 0, 6, null).toArray(new String[0]);
        if (r111 == null) goto L14;
        String[] r112 = (String[]) r111;
        if (r112.length >= 2) goto L12;
        return "";
    L12:
        r110 = r112[1];
        goto L15
    L14:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L15:
        StringBuilder r100 = new StringBuilder();
        if (r110 == null) goto L26;
        r100.append(r110.substring(0, 10));
        r100.append(AppbrandHostConstants.Schema_BDP_SUM.MD5_SALT);
        r100.append(r110.substring(10));
        String r113 = com.bytedance.bdp.bdpbase.util.a.c(r100.toString());
        if (TextUtils.isEmpty(r113) == true) goto L24;
        StringBuilder r101 = new StringBuilder();
        if (r113 == null) goto L23;
        r101.append(r113.substring(2, 6));
        r101.append(r113.substring(20, 23));
        return r101.toString();
    L23:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L24:
        return "";
    L26:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
