package com.bytedance.tools.protobuf.internal;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.JsonElement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/google/gson/JsonElement;", "Lcom/bytedance/revenue/platform/api/core/JsonElement;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ExternalProtobufShrinkConfigsKt$fromJsonObject$1 extends Lambda implements Function1<JsonElement, String> {
    public static final ExternalProtobufShrinkConfigsKt$fromJsonObject$1 INSTANCE = null;

    static {
        INSTANCE = new ExternalProtobufShrinkConfigsKt$fromJsonObject$1();
    }

    public ExternalProtobufShrinkConfigsKt$fromJsonObject$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(JsonElement r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return r100.getAsString();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(JsonElement r100) {
        return invoke2(r100);
    }
}
