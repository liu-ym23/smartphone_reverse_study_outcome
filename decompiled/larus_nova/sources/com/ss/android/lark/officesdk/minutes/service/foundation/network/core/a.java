package com.ss.android.lark.officesdk.minutes.service.foundation.network.core;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.google.gson.reflect.TypeToken;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpBaseResp;
import com.ss.android.lark.utils.e0;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    static {
    }

    public static Object a(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r101, "respType");
        boolean r102 = true;
        MmHttpBaseResp r103 = (MmHttpBaseResp) e0.b(r100, TypeToken.getParameterized(MmHttpBaseResp.class, new Type[]{r101}).getType());
        if (r103 != null) goto L5;
        Object r104 = new JSONObject(r100).opt("data");
        if ((r104 instanceof String) == false) goto L17;
        String r105 = StringsKt.trim((String) r104).toString();
        if (r105.length() == 0) goto L13;
        r102 = false;
    L13:
        if (r102 == false) goto L16;
        r105 = SliceInitService.DEFAULT_SWITCH;
    L16:
        if (Intrinsics.areEqual(r105, "null") == true) goto L17;
        return e0.a(r105, r101);
    L17:
        return null;
    L5:
        return r103.getData();
    }
}
