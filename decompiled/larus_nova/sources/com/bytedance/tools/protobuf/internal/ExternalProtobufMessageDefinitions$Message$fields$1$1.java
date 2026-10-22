package com.bytedance.tools.protobuf.internal;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00012\u000e\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "Lcom/google/gson/JsonObject;", "it", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ExternalProtobufMessageDefinitions$Message$fields$1$1 extends Lambda implements Function1<String, Pair<? extends String, ? extends JsonObject>> {
    final /* synthetic */ JsonObject $jsonObject;

    public ExternalProtobufMessageDefinitions$Message$fields$1$1(JsonObject r100) {
        this.$jsonObject = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pair<String, JsonObject> invoke2(String r100) {
        JsonElement r101 = this.$jsonObject.get(r100);
        if (r101 == null) goto L5;
        JsonObject r102 = r101.getAsJsonObject();
    L6:
        Intrinsics.checkNotNull(r102);
        return new Pair(r100, r102);
    L5:
        r102 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Pair<? extends String, ? extends JsonObject> invoke(String r100) {
        return invoke2(r100);
    }
}
