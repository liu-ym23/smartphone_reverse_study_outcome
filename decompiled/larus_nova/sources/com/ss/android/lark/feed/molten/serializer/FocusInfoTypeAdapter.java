package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.ss.android.lark.biz.im.api.FocusInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/FocusInfoTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/biz/im/api/FocusInfo;", "<init>", "()V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FocusInfoTypeAdapter extends JsonTreeTypeAdapter<FocusInfo> {
    public FocusInfoTypeAdapter() {
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final FocusInfo a(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Long r101 = a.f(r100, "messageId");
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
    L7:
        return new FocusInfo(r102);
    L5:
        r102 = 0;
        goto L7
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(FocusInfo r100) {
        FocusInfo r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        JsonObject r102 = new JsonObject();
        a.h(r102, "messageId", Long.valueOf(r101.getMessageId()));
        return r102;
    }
}
