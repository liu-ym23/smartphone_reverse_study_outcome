package com.ss.android.lark.team.parser;

import com.bytedance.lark.pb.basic.v1.Item;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class TeamModelParser$parseItems$1 extends FunctionReferenceImpl implements Function1<Item, com.ss.android.lark.chat.entity.Item> {
    public TeamModelParser$parseItems$1(Object r100) {
        super(1, r100, TeamModelParser.class, "parseItem", "parseItem(Lcom/bytedance/lark/pb/basic/v1/Item;)Lcom/ss/android/lark/chat/entity/Item;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.ss.android.lark.chat.entity.Item invoke2(Item r110) {
        Intrinsics.checkNotNullParameter(r110, "p0");
        TeamModelParser r100 = TeamModelParser.f441191a;
        Intrinsics.checkNotNullParameter(r110, "pbItem");
        long r101 = r110.f253507id.longValue();
        String r102 = r110.entity_id;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        String r103 = r102;
        Item.Type r104 = r110.entity_type;
        if (r104 == null) goto L17;
        com.ss.android.lark.chat.entity.Item.Type.a r105 = com.ss.android.lark.chat.entity.Item.Type.Companion;
        int r106 = r104.getValue();
        r105.getClass();
        com.ss.android.lark.chat.entity.Item.Type r107 = com.ss.android.lark.chat.entity.Item.Type.CHAT;
        if (r106 == r107.getValue()) goto L14;
        r107 = com.ss.android.lark.chat.entity.Item.Type.TEAM;
        if (r106 == r107.getValue()) goto L14;
        r107 = com.ss.android.lark.chat.entity.Item.Type.UNKNOWN;
    L14:
        if (r107 == null) goto L17;
        com.ss.android.lark.chat.entity.Item.Type r108 = r107;
    L18:
        Long r109 = r110.parent_id;
        Long r111 = r110.order_weight;
        String r112 = r110.name_weight;
        long r113 = r110.version.longValue();
        Boolean r114 = r110.is_hidden;
        if (r114 == null) goto L21;
        boolean r115 = r114.booleanValue();
    L23:
        return new com.ss.android.lark.chat.entity.Item(r101, r103, r108, r109, r111, r112, r113, r115);
    L21:
        r115 = false;
    L17:
        r108 = com.ss.android.lark.chat.entity.Item.Type.UNKNOWN;
        goto L18
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.ss.android.lark.chat.entity.Item invoke(Item r100) {
        return invoke2(r100);
    }
}
