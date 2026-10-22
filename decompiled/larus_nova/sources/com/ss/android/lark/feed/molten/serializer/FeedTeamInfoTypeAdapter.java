package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.ss.android.lark.biz.im.api.FeedTeamInfo;
import com.ss.android.lark.chat.entity.chat.TeamChatType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/FeedTeamInfoTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/biz/im/api/FeedTeamInfo;", "teamChatTypeAdapter", "Lcom/google/gson/TypeAdapter;", "Lcom/ss/android/lark/chat/entity/chat/TeamChatType;", "<init>", "(Lcom/google/gson/TypeAdapter;)V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedTeamInfoTypeAdapter extends JsonTreeTypeAdapter<FeedTeamInfo> {
    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final FeedTeamInfo a(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Long r101 = a.f(r100, "teamId");
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
    L6:
        long r103 = r102;
        String r104 = a.l(r100, "teamName");
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        String r105 = r104;
        TeamChatType r106 = (TeamChatType) a.k(r100, "teamChatType", null);
        if (r106 != null) goto L13;
        r106 = (TeamChatType) a.d(TeamChatType.class);
    L13:
        return new FeedTeamInfo(r103, r105, r106, a.f(r100, "orderWeight"));
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(FeedTeamInfo r100) {
        FeedTeamInfo r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        JsonObject r102 = new JsonObject();
        a.h(r102, "teamId", Long.valueOf(r101.teamId));
        a.j(r102, "teamName", r101.teamName);
        a.i(r102, "teamChatType", r101.teamChatType, null);
        a.h(r102, "orderWeight", r101.orderWeight);
        return r102;
    }
}
