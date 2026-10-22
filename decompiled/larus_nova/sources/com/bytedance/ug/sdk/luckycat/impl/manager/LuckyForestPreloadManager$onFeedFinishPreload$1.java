package com.bytedance.ug.sdk.luckycat.impl.manager;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/popup/f;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/ug/sdk/luckycat/impl/popup/f;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class LuckyForestPreloadManager$onFeedFinishPreload$1 extends Lambda implements Function1<com.bytedance.ug.sdk.luckycat.impl.popup.f, Boolean> {
    public static final LuckyForestPreloadManager$onFeedFinishPreload$1 INSTANCE = null;

    static {
        INSTANCE = new LuckyForestPreloadManager$onFeedFinishPreload$1();
    }

    public LuckyForestPreloadManager$onFeedFinishPreload$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(com.bytedance.ug.sdk.luckycat.impl.popup.f r100) {
        ArrayList r101 = new ArrayList();
        r101.add("feed");
        r101.add("all");
        if (r100 == null) goto L7;
        String r102 = r100.f();
        if (r102 == null) goto L7;
    L9:
        return r101.contains(r102);
    L7:
        r102 = "";
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(com.bytedance.ug.sdk.luckycat.impl.popup.f r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
