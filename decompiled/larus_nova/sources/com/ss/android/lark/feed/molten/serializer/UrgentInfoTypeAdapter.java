package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.biz.im.api.UrgentInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/UrgentInfoTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/biz/im/api/UrgentInfo;", "<init>", "()V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrgentInfoTypeAdapter extends JsonTreeTypeAdapter<UrgentInfo> {
    public UrgentInfoTypeAdapter() {
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final UrgentInfo a(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        UrgentInfo r101 = new UrgentInfo();
        r101.setId(a.l(r100, "id"));
        r101.setMessageId(a.l(r100, "messageId"));
        Long r102 = a.f(r100, RemoteMessageConst.SEND_TIME);
        if (r102 == null) goto L5;
        long r103 = r102.longValue();
    L6:
        r101.setSendTime(r103);
        Boolean r104 = a.c(r100, "isClosed");
        boolean r105 = false;
        if (r104 == null) goto L9;
        boolean r106 = r104.booleanValue();
    L10:
        r101.setClosed(r106);
        Boolean r107 = a.c(r100, "isMuted");
        if (r107 == null) goto L13;
        r105 = r107.booleanValue();
    L13:
        r101.setMuted(r105);
        return r101;
    L9:
        r106 = false;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(UrgentInfo r100) {
        UrgentInfo r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        JsonObject r102 = new JsonObject();
        a.j(r102, "id", r101.getId());
        a.j(r102, "messageId", r101.getMessageId());
        a.h(r102, RemoteMessageConst.SEND_TIME, Long.valueOf(r101.getSendTime()));
        a.g(r102, "isClosed", Boolean.valueOf(r101.isClosed()));
        a.g(r102, "isMuted", Boolean.valueOf(r101.isMuted()));
        return r102;
    }
}
