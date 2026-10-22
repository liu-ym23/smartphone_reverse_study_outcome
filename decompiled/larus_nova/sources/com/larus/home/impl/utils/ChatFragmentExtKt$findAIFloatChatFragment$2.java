package com.larus.home.impl.utils;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ChatFragmentExtKt$findAIFloatChatFragment$2 extends FunctionReferenceImpl implements Function1<Fragment, Boolean> {
    public static final ChatFragmentExtKt$findAIFloatChatFragment$2 INSTANCE = null;

    static {
        INSTANCE = new ChatFragmentExtKt$findAIFloatChatFragment$2();
    }

    public ChatFragmentExtKt$findAIFloatChatFragment$2() {
        super(1, b.class, "isAvailableHostFragment", "isAvailableHostFragment(Landroidx/fragment/app/Fragment;)Z", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return Boolean.valueOf(b.c(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Fragment r100) {
        return invoke2(r100);
    }
}
