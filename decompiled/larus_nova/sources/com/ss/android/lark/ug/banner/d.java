package com.ss.android.lark.ug.banner;

import com.ss.android.lark.statistics.Statistics;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class d {
    public static final void a(String r100, Function1<? super JSONObject, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "params");
        JSONObject r102 = new JSONObject();
        r101.invoke(r102);
        Statistics.sendEvent(r100, r102);
    }
}
