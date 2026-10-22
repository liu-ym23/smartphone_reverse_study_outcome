package com.bytedance.tools.protobuf.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes22.dex */
public final class ExternalProtobufShrinkConfigsKt {
    public static final a a(final a r100, final Map<String, a> r101, final Map<String, a> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "initialMap");
        Intrinsics.checkNotNullParameter(r102, "mergedMap");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (((b.d) ((LinkedHashMap) r100.f271027d).get("config")) == null) goto L5;
        a r104 = r102.get(null);
        if (r104 != null) goto L20;
        a r105 = r101.get(null);
        if (r105 == null) goto L19;
        r104 = a(r105, r101, r102, true);
        goto L20
    L19:
        throw new IllegalArgumentException("failed to find [null]".toString());
    L20:
        a r106 = new a(r100.f271024a, SetsKt.plus(r100.f271025b, r104.f271025b), MapsKt.toMap(SequencesKt.map(SequencesKt.plus(MapsKt.asSequence(r100.f271026c), SequencesKt.filterNot(MapsKt.asSequence(r104.f271026c), new ExternalProtobufShrinkConfigsKt$mergedConfigs$children$1(r100))), new ExternalProtobufShrinkConfigsKt$mergedConfigs$traverse$1(r101, r102))), SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.filterNot(MapsKt.asSequence(r104.f271027d), new ExternalProtobufShrinkConfigsKt$mergedConfigs$options$1(r100)), new ExternalProtobufShrinkConfigsKt$mergedConfigs$traverse$2(r101, r102))));
        if (r103 == false) goto L23;
        r102.put(r106.f271024a, r106);
    L23:
        return r106;
    L5:
        if (r100.f271026c.isEmpty() == true) goto L7;
    L9:
        r100 = new a(r100.f271024a, r100.f271025b, MapsKt.toMap(SequencesKt.map(MapsKt.asSequence(r100.f271026c), new ExternalProtobufShrinkConfigsKt$mergedConfigs$traverse$1(r101, r102))), SequencesKt.toList(SequencesKt.mapNotNull(MapsKt.asSequence(r100.f271027d), new ExternalProtobufShrinkConfigsKt$mergedConfigs$traverse$2(r101, r102))));
    L10:
        if (r103 == false) goto L12;
        r102.put(r100.f271024a, r100);
    L12:
        return r100;
    L7:
        if (r100.f271027d.isEmpty() == false) goto L9;
        goto L9
    }
}
