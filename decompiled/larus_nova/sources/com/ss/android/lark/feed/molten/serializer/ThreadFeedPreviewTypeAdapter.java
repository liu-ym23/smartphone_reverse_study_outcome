package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.feed.shared.data.preview.ThreadFeedPreview;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/ThreadFeedPreviewTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/feed/shared/data/preview/ThreadFeedPreview;", "fieldCodec", "Lcom/ss/android/lark/feed/molten/serializer/FeedPreviewFieldCodec;", "chatTypeAdapter", "Lcom/google/gson/TypeAdapter;", "Lcom/ss/android/lark/chat/entity/chat/Chat$Type;", "<init>", "(Lcom/ss/android/lark/feed/molten/serializer/FeedPreviewFieldCodec;Lcom/google/gson/TypeAdapter;)V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThreadFeedPreviewTypeAdapter extends JsonTreeTypeAdapter<ThreadFeedPreview> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f421087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter<Chat.Type> f421088b;

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final /* bridge */ /* synthetic */ ThreadFeedPreview a(JsonObject r100) {
        return c(r100);
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final /* bridge */ /* synthetic */ JsonObject b(ThreadFeedPreview r100) {
        return d(r100);
    }

    public final ThreadFeedPreview c(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        ThreadFeedPreview r101 = new ThreadFeedPreview();
        this.f421087a.a(r100, r101);
        r101.setChatId(a.l(r100, "chatId"));
        Boolean r102 = a.c(r100, "isMsgThread");
        if (r102 == null) goto L5;
        boolean r103 = r102.booleanValue();
    L6:
        r101.setMsgThread(r103);
        r101.setP2pChatterId(a.l(r100, "p2pChatterId"));
        Chat.Type r104 = (Chat.Type) a.k(r100, "chatType", this.f421088b);
        if (r104 == null) goto L9;
        r101.setChatType(r104);
    L9:
        return r101;
    L5:
        r103 = false;
        goto L6
    }

    public final JsonObject d(ThreadFeedPreview r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        JsonObject r101 = new JsonObject();
        e.b(r101, r100);
        this.f421087a.b(r101, r100);
        a.j(r101, "chatId", r100.getChatId());
        a.g(r101, "isMsgThread", Boolean.valueOf(r100.isMsgThread()));
        a.j(r101, "p2pChatterId", r100.getP2pChatterId());
        a.i(r101, "chatType", r100.getChatType(), this.f421088b);
        return r101;
    }

    public ThreadFeedPreviewTypeAdapter(c r100, TypeAdapter<Chat.Type> r101) {
        Intrinsics.checkNotNullParameter(r100, "fieldCodec");
        Intrinsics.checkNotNullParameter(r101, "chatTypeAdapter");
        this.f421087a = r100;
        this.f421088b = r101;
    }
}
