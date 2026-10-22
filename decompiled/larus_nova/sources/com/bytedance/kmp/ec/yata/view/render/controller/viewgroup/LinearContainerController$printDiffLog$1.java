package com.bytedance.kmp.ec.yata.view.render.controller.viewgroup;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 0}, xi = 48)
final class LinearContainerController$printDiffLog$1 extends Lambda implements Function0<String> {
    final /* synthetic */ int $diffIndex;
    final /* synthetic */ List<String> $diffOrderList;
    final /* synthetic */ String $removedDiffNodeKey;
    final /* synthetic */ int $viewIndex;
    final /* synthetic */ String $viewNodeKey;
    final /* synthetic */ LinearContainerController this$0;

    public LinearContainerController$printDiffLog$1(String r100, List<String> r101, int r102, String r103, LinearContainerController r104, int r105) {
        this.$removedDiffNodeKey = r100;
        this.$diffOrderList = r101;
        this.$diffIndex = r102;
        this.$viewNodeKey = r103;
        this.this$0 = r104;
        this.$viewIndex = r105;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        String r100 = this.$removedDiffNodeKey;
        if (r100 != null) goto L9;
        List<String> r101 = this.$diffOrderList;
        if (r101 == null) goto L7;
        r100 = (String) CollectionsKt.getOrNull(r101, this.$diffIndex);
        goto L9
    L7:
        r100 = null;
    L9:
        if (Intrinsics.areEqual(r100, this.$viewNodeKey) == false) goto L11;
        String r102 = "✅";
    L13:
        return "当前状态  viewCount=" + LinearContainerController.e(this.this$0).getChildCount() + " diffIndex=" + this.$diffIndex + " viewIndex=" + this.$viewIndex + " diffNodeKey=" + r100 + "  isRight=" + r102;
    L11:
        r102 = "❌";
        goto L13
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
