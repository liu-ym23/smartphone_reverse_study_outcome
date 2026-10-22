package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.ss.android.lark.chat.entity.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/ItemTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/chat/entity/Item;", "itemTypeAdapter", "Lcom/google/gson/TypeAdapter;", "Lcom/ss/android/lark/chat/entity/Item$Type;", "<init>", "(Lcom/google/gson/TypeAdapter;)V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemTypeAdapter extends JsonTreeTypeAdapter<Item> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeAdapter<Item.Type> f421082a;

    public ItemTypeAdapter(TypeAdapter<Item.Type> r100) {
        Intrinsics.checkNotNullParameter(r100, "itemTypeAdapter");
        this.f421082a = r100;
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final Item a(JsonObject r110) {
        Intrinsics.checkNotNullParameter(r110, "json");
        Long r100 = a.f(r110, "id");
        if (r100 == null) goto L5;
        long r101 = r100.longValue();
    L6:
        String r102 = a.l(r110, "entityId");
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        String r103 = r102;
        Item.Type r104 = (Item.Type) a.k(r110, "entityType", this.f421082a);
        if (r104 != null) goto L12;
        r104 = (Item.Type) a.d(Item.Type.class);
    L12:
        Item.Type r105 = r104;
        Long r106 = a.f(r110, "parentId");
        Long r107 = a.f(r110, "orderWeight");
        String r111 = a.l(r110, "nameWeight");
        Long r108 = a.f(r110, "version");
        if (r108 == null) goto L15;
        long r112 = r108.longValue();
    L16:
        Boolean r113 = a.c(r110, "isHidden");
        if (r113 == null) goto L19;
        boolean r114 = r113.booleanValue();
    L21:
        return new Item(r101, r103, r105, r106, r107, r111, r112, r114);
    L19:
        r114 = false;
        goto L21
    L15:
        r112 = 0;
        goto L16
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(Item r100) {
        Item r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        JsonObject r102 = new JsonObject();
        a.h(r102, "id", Long.valueOf(r101.getId()));
        a.j(r102, "entityId", r101.getEntityId());
        a.i(r102, "entityType", r101.getEntityType(), this.f421082a);
        a.h(r102, "parentId", r101.getParentId());
        a.h(r102, "orderWeight", r101.getOrderWeight());
        a.j(r102, "nameWeight", r101.getNameWeight());
        a.h(r102, "version", Long.valueOf(r101.getVersion()));
        a.g(r102, "isHidden", Boolean.valueOf(r101.isHidden()));
        return r102;
    }
}
