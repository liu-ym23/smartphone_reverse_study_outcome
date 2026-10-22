package com.bytedance.kmp.ec.yata.view.render.controller.viewgroup;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 0}, xi = 48)
final class LinearContainerController$printDiffLog$2 extends Lambda implements Function0<String> {
    final /* synthetic */ List<String> $diffOrderList;

    public LinearContainerController$printDiffLog$2(List<String> r100) {
        this.$diffOrderList = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        StringBuilder r100 = new StringBuilder("diffOrderList=\n");
        List<String> r101 = this.$diffOrderList;
        if (r101 == null) goto L5;
        String r102 = CollectionsKt.joinToString$default(r101, null, null, null, 0, null, AnonymousClass1.INSTANCE, 31, null);
    L6:
        r100.append(r102);
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
