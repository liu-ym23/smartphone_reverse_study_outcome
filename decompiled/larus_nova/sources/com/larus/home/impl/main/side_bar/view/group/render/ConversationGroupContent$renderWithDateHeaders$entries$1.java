package com.larus.home.impl.main.side_bar.view.group.render;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ConversationGroupContent$renderWithDateHeaders$entries$1 extends FunctionReferenceImpl implements Function1<com.larus.home.impl.main.side_bar.data.j0, Integer> {
    public static final ConversationGroupContent$renderWithDateHeaders$entries$1 INSTANCE = null;

    static {
        INSTANCE = new ConversationGroupContent$renderWithDateHeaders$entries$1();
    }

    public ConversationGroupContent$renderWithDateHeaders$entries$1() {
        super(1, com.larus.home.impl.main.side_bar.data.j0.class, "calculateRedBadgeCount", "calculateRedBadgeCount()I", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Integer invoke2(com.larus.home.impl.main.side_bar.data.j0 r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return Integer.valueOf(r100.a());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(com.larus.home.impl.main.side_bar.data.j0 r100) {
        return invoke2(r100);
    }
}
