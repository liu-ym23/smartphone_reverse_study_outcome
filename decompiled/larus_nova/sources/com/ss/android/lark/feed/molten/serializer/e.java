package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import com.ss.android.lark.feed.shared.data.preview.FeedPreview;
import com.ss.android.lark.feed.shared.data.preview.ThreadFeedPreview;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e {
    public static final PolymorphicFeedCardType a(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = a.l(r100, "_runtimeType");
        PolymorphicFeedCardType r102 = PolymorphicFeedCardType.CHAT_FEED_PREVIEW;
        if (Intrinsics.areEqual(r101, r102.getValue()) == true) goto L13;
        PolymorphicFeedCardType r103 = PolymorphicFeedCardType.THREAD_FEED_PREVIEW;
        if (Intrinsics.areEqual(r101, r103.getValue()) == true) goto L14;
        PolymorphicFeedCardType r104 = PolymorphicFeedCardType.FEED_PREVIEW;
        if (Intrinsics.areEqual(r101, r104.getValue()) == false) goto L12;
        return r104;
    L12:
        return PolymorphicFeedCardType.UI_FEED_CARD;
    L14:
        return r103;
    L13:
        return r102;
    }

    public static final void b(JsonObject r100, UIFeedCard r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "value");
        if ((r101 instanceof ChatFeedPreview) == false) goto L6;
        String r102 = PolymorphicFeedCardType.CHAT_FEED_PREVIEW.getValue();
    L12:
        a.j(r100, "_runtimeType", r102);
        return;
    L6:
        if ((r101 instanceof ThreadFeedPreview) == false) goto L9;
        r102 = PolymorphicFeedCardType.THREAD_FEED_PREVIEW.getValue();
        goto L12
    L9:
        if ((r101 instanceof FeedPreview) == false) goto L11;
        r102 = PolymorphicFeedCardType.FEED_PREVIEW.getValue();
        goto L12
    L11:
        r102 = PolymorphicFeedCardType.UI_FEED_CARD.getValue();
        goto L12
    }
}
