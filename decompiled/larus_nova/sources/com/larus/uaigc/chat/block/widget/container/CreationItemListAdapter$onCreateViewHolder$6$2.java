package com.larus.uaigc.chat.block.widget.container;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CreationItemListAdapter$onCreateViewHolder$6$2 extends FunctionReferenceImpl implements Function3<CreationItemListAdapter, cz9.b, Float, Unit> {
    public static final CreationItemListAdapter$onCreateViewHolder$6$2 INSTANCE = null;

    static {
        INSTANCE = new CreationItemListAdapter$onCreateViewHolder$6$2();
    }

    public CreationItemListAdapter$onCreateViewHolder$6$2() {
        super(3, CreationItemListAdapter.class, "reportItemExposure", "reportItemExposure(Lcom/larus/uaigc/chat/block/widget/CreationItemData;F)V", 0);
    }

    public final void invoke(CreationItemListAdapter r100, cz9.b r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        r100.f370590g.invoke(r101, Float.valueOf(r102));
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(CreationItemListAdapter r100, cz9.b r101, Float r102) {
        invoke(r100, r101, r102.floatValue());
        return Unit.INSTANCE;
    }
}
