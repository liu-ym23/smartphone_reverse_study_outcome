package com.larus.bmhome.chat.map;

import com.google.gson.Gson;
import com.larus.bmhome.chat.layout.item.w1;
import com.larus.utils.cache.DiskCache;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes25.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f306919a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f306920b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DiskCache f306921c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, List<wq9.a>> f306922d = null;

    static {
        f306919a = new Gson();
        f306920b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        f306921c = new DiskCache("plugin-data-map");
        f306922d = new LinkedHashMap();
    }

    public static void a(String r100, w1 r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Map<String, List<wq9.a>> r102 = f306922d;
        if (r102.containsKey(r100) == false) goto L5;
        FLogger.f375446a.d("PoiRouteStore", "[readPolylineByMessageId] from memory with messageId:".concat(r100));
        r101.invoke(((LinkedHashMap) r102).get(r100));
        return;
    L5:
        Intrinsics.checkNotNullParameter(r100, "messageId");
        if (f306921c.b(r100) == false) goto L10;
        BuildersKt.launch$default(f306920b, null, null, new PoiRouteStore$readPolylineByMessageId$1(r100, r101, null), 3, null);
        return;
    }
}
