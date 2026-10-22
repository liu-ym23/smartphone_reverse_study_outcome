package meb;

import com.google.gson.JsonObject;
import com.larus.larkfeed.impl.mixedfeed.model.DouBaoConversationFeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCard;

/* JADX INFO: loaded from: classes35.dex */
public interface b<T extends UIFeedCard> {
    JsonObject a(T r100);

    DouBaoConversationFeedCard b(JsonObject r100);
}
