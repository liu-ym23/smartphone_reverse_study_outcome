package wh9;

import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.larus.larkfeed.impl.mixedfeed.model.DouBaoConversationFeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import kotlin.jvm.internal.Intrinsics;
import meb.e;

/* JADX INFO: loaded from: classes30.dex */
public final class b implements meb.b<DouBaoConversationFeedCard> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f559720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter<wh8.a> f559721b;

    @Override // meb.b
    public final JsonObject a(UIFeedCard r100) {
        DouBaoConversationFeedCard r101 = (DouBaoConversationFeedCard) r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        JsonObject r102 = new JsonObject();
        this.f559720a.a(r102, r101);
        com.ss.android.lark.feed.molten.serializer.a.i(r102, "conversationData", r101.getConversationData(), this.f559721b);
        return r102;
    }

    @Override // meb.b
    public final DouBaoConversationFeedCard b(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        DouBaoConversationFeedCard r101 = new DouBaoConversationFeedCard();
        this.f559720a.b(r100, r101);
        r101.setConversationData((wh8.a) com.ss.android.lark.feed.molten.serializer.a.k(r100, "conversationData", this.f559721b));
        return r101;
    }

    public b(e r100, TypeAdapter<wh8.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "uiFeedCardCodec");
        Intrinsics.checkNotNullParameter(r101, "conversationDataAdapter");
        this.f559720a = r100;
        this.f559721b = r101;
    }
}
