package com.larus.home.impl.main.side_bar.view.adapter;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class SideBarScheduledJobIndicatorProvider$scanStatusPages$1$onSuccess$1$updatedConversationIds$3 extends FunctionReferenceImpl implements Function1<String, Boolean> {
    public static final SideBarScheduledJobIndicatorProvider$scanStatusPages$1$onSuccess$1$updatedConversationIds$3 INSTANCE = null;

    static {
        INSTANCE = new SideBarScheduledJobIndicatorProvider$scanStatusPages$1$onSuccess$1$updatedConversationIds$3();
    }

    public SideBarScheduledJobIndicatorProvider$scanStatusPages$1$onSuccess$1$updatedConversationIds$3() {
        super(1, StringsKt.class, "isNotBlank", "isNotBlank(Ljava/lang/CharSequence;)Z", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return Boolean.valueOf(!StringsKt.isBlank(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(String r100) {
        return invoke2(r100);
    }
}
