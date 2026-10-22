package com.larus.dora.dorag.res;

import com.byted.cast.common.api.IMonitor;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements IMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<String, Map<String, ? extends Object>, Unit> f331843a;

    /* JADX INFO: renamed from: com.larus.dora.dorag.res.a$a, reason: collision with other inner class name */
    public static final class C4207a {
    }

    static {
    }

    public a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "reporter");
        this.f331843a = r100;
    }

    @Override // com.byted.cast.common.api.IMonitor
    public final void onAppLogEvent(String r100, JSONObject r101) {
        if (r100 != null) goto L5;
    L7:
        r100 = null;
    L9:
        if (r100 != null) goto L16;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("onAppLogEvent ignored: invalid eventName, paramCount=");
        if (r101 == null) goto L13;
        int r104 = r101.length();
    L14:
        r103.append(r104);
        r102.w("ByteCastAppLogMonitor", r103.toString());
        return;
    L13:
        r104 = 0;
        goto L14
    L16:
        LinkedHashMap r105 = new LinkedHashMap();
        if (r101 == null) goto L25;
        Iterator<String> r106 = r101.keys();
        if (r106 == null) goto L25;
    L21:
        if (r106.hasNext() == false) goto L25;
        String r107 = r106.next();
        Object r108 = r101.opt(r107);
        if (r108 == null) goto L21;
        r105.put(r107, r108);
    L25:
        FLogger r109 = FLogger.f375446a;
        StringBuilder r110 = new StringBuilder("onAppLogEvent converted: event=");
        r110.append(r100);
        r110.append(", paramCount=");
        r110.append(r105.size());
        r110.append(", params=");
        Intrinsics.checkNotNullParameter(r105, "params");
        r110.append(MapsKt.toSortedMap(r105).toString());
        r109.i("ByteCastAppLogMonitor", r110.toString());
        this.f331843a.invoke(r100, r105);
        return;
    L5:
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        goto L7
    }
}
