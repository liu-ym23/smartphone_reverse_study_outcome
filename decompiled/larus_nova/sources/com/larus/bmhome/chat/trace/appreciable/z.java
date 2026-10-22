package com.larus.bmhome.chat.trace.appreciable;

import com.google.gson.reflect.TypeToken;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type f310150a = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/chat/trace/appreciable/ChatMobUtilKt$ANY_MAP_TYPE$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<Map<Object, ? extends Object>> {
        public a() {
        }
    }

    static {
        f310150a = new a().getType();
    }

    public static final Map<String, String> a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "logTag");
        LinkedHashMap r102 = new LinkedHashMap();     // Catch: Throwable -> L11
        zd9.h.f571481a.getClass();     // Catch: Throwable -> L11
        Map r103 = (Map) zd9.h.f571482b.fromJson(r100, f310150a);     // Catch: Throwable -> L11
        if (r103 != null) goto L6;
        r103 = MapsKt.emptyMap();     // Catch: Throwable -> L11
    L6:
        Iterator r104 = r103.entrySet().iterator();     // Catch: Throwable -> L11
    L7:
        if (r104.hasNext() == false) goto L17;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L11
        r102.put(String.valueOf(r105.getKey()), String.valueOf(r105.getValue()));     // Catch: Throwable -> L11
        goto L7
    L17:
        return r102;
    L11:
        th = move-exception;
        FLogger.f375446a.e(r101, "toStringMap err=" + th.getMessage());
        return new LinkedHashMap();
    }
}
