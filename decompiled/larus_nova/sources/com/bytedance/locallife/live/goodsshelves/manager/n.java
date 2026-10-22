package com.bytedance.locallife.live.goodsshelves.manager;

import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.locallife.live.util.LiveLocalLifeUtil;
import com.bytedance.locallife.live.viewmodel.LiveLocalLifeViewModel;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f259731a = 0;

    static {
    }

    public static String a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        LiveLocalLifeViewModel.Companion.getClass();
        LiveLocalLifeViewModel r102 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L11;
        return r100;
    L11:
        if (com.bytedance.locallife.live.util.o.a(r101) != null) goto L13;
        return r100;
    L13:
        if (r100.length() != 0) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == true) goto L24;
        JSONObject r105 = LiveLocalLifeUtil.c(r101);
        if (r105 != null) goto L22;
        return r100;
    L22:
        return LiveLifeSaaSUtil.h().b(r100, MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_from_merge", r105.optString("enter_from_merge")), TuplesKt.to("entrance_form", "life_live")}));
    L24:
        return r100;
    L15:
        r104 = false;
        goto L16
    L5:
        if (r102.isPreview() != true) goto L7;
        r103 = true;
        goto L8
    }
}
