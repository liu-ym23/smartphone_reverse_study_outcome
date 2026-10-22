package com.ss.android.ugc.aweme.search.common.list.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010'\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "", "", "", "Lcom/ss/android/ugc/aweme/search/common/list/utils/PendingTask;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ItemShowReporter$logPendingTaskKeys$keys$1 extends Lambda implements Function1<Map.Entry<String, List<PendingTask>>, CharSequence> {
    public static final ItemShowReporter$logPendingTaskKeys$keys$1 INSTANCE = null;

    static {
        INSTANCE = new ItemShowReporter$logPendingTaskKeys$keys$1();
    }

    public ItemShowReporter$logPendingTaskKeys$keys$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Map.Entry<String, List<PendingTask>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return r100.getKey() + '-' + r100.getValue().size();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<String, List<PendingTask>> r100) {
        return invoke2(r100);
    }
}
