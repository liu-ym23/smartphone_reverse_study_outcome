package com.bytedance.sdk.account.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "it", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 15})
final class StringUtilKt$prependTabs$1 extends Lambda implements Function1<String, String> {
    public static final StringUtilKt$prependTabs$1 INSTANCE = null;

    static {
        INSTANCE = new StringUtilKt$prependTabs$1();
    }

    public StringUtilKt$prependTabs$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String r100) {
        return "\t" + r100;
    }
}
