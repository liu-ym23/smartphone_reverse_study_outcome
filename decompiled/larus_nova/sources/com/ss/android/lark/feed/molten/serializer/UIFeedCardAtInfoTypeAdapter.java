package com.ss.android.lark.feed.molten.serializer;

import com.bytedance.lark.pb.feed.v1.AtInfo;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/UIFeedCardAtInfoTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard$AtInfo;", "atTypeAdapter", "Lcom/google/gson/TypeAdapter;", "Lcom/bytedance/lark/pb/feed/v1/AtInfo$AtType;", "<init>", "(Lcom/google/gson/TypeAdapter;)V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UIFeedCardAtInfoTypeAdapter extends JsonTreeTypeAdapter<UIFeedCard.AtInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeAdapter<AtInfo.AtType> f421089a;

    public UIFeedCardAtInfoTypeAdapter(WireEnumTypeAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "atTypeAdapter");
        this.f421089a = r100;
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final UIFeedCard.AtInfo a(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        UIFeedCard.AtInfo r101 = new UIFeedCard.AtInfo(a.l(r100, "id"), a.l(r100, "avatarKey"), a.l(r100, "localizedUserName"));
        Long r102 = a.f(r100, "atDisplayTime");
        long r103 = 0;
        if (r102 == null) goto L5;
        long r104 = r102.longValue();
    L6:
        r101.setAtDisplayTime(r104);
        Long r105 = a.f(r100, "atRankTime");
        if (r105 == null) goto L9;
        r103 = r105.longValue();
    L9:
        r101.setAtRankTime(r103);
        r101.setAtContent(a.l(r100, "atContent"));
        AtInfo.AtType r106 = (AtInfo.AtType) a.k(r100, "atType", this.f421089a);
        if (r106 == null) goto L12;
        r101.setAtType(r106);
    L12:
        return r101;
    L5:
        r104 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(UIFeedCard.AtInfo r100) {
        UIFeedCard.AtInfo r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        JsonObject r102 = new JsonObject();
        a.j(r102, "id", r101.getId());
        a.j(r102, "avatarKey", r101.getAvatarKey());
        a.j(r102, "localizedUserName", r101.getLocalizedUserName());
        a.h(r102, "atDisplayTime", Long.valueOf(r101.getAtDisplayTime()));
        a.h(r102, "atRankTime", Long.valueOf(r101.getAtRankTime()));
        a.j(r102, "atContent", r101.getAtContent());
        a.i(r102, "atType", r101.getAtType(), this.f421089a);
        return r102;
    }
}
