package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/ReactionTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/chat/entity/reaction/Reaction;", "<init>", "()V", "stringListAdapter", "Lcom/ss/android/lark/feed/molten/serializer/ListTypeAdapter;", "", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactionTypeAdapter extends JsonTreeTypeAdapter<Reaction> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ListTypeAdapter<String> f421086a;

    public ReactionTypeAdapter() {
        this.f421086a = new ListTypeAdapter(new ReactionTypeAdapter$stringListAdapter$1());
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final Reaction a(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Reaction r101 = new Reaction();
        r101.setType(a.l(r100, "type"));
        Integer r102 = a.e(r100, "count");
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        r101.setCount(r103);
        r101.setChatterIds(a.b(r100, "chatterIds", this.f421086a));
        r101.setMessageId(a.l(r100, "messageId"));
        return r101;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(Reaction r100) {
        Reaction r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        JsonObject r102 = new JsonObject();
        a.j(r102, "type", r101.getType());
        a.h(r102, "count", Integer.valueOf(r101.getCount()));
        a.a(r102, "chatterIds", r101.getChatterIds(), this.f421086a);
        a.j(r102, "messageId", r101.getMessageId());
        return r102;
    }
}
