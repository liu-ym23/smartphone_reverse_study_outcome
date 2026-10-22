package com.larus.kmp.voice_setting.voice.base.api;

import com.larus.audio.bean.VoiceListTabInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {
    public static final Map<String, List<i>> a(Map<String, ? extends List<VoiceListTabInfo>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LinkedHashMap r101 = new LinkedHashMap(MapsKt.mapCapacity(r100.size()));
        Iterator<T> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry r103 = (Map.Entry) r102.next();
        Object r104 = r103.getKey();
        List r105 = (List) r103.getValue();
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L7:
        if (r107.hasNext() == false) goto L9;
        VoiceListTabInfo r108 = (VoiceListTabInfo) r107.next();
        r106.add(new i(r108.c(), r108.b(), r108.a()));
        goto L7
    L9:
        r101.put(r104, r106);
        goto L4
    L10:
        return r101;
    }
}
