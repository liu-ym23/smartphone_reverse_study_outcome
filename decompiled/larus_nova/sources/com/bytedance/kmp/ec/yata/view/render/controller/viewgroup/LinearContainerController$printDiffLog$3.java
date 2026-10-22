package com.bytedance.kmp.ec.yata.view.render.controller.viewgroup;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import ha6.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 0}, xi = 48)
final class LinearContainerController$printDiffLog$3 extends Lambda implements Function0<String> {
    final /* synthetic */ LinearContainerController this$0;

    public LinearContainerController$printDiffLog$3(LinearContainerController r100) {
        this.this$0 = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        IntRange r100 = RangesKt.until(0, LinearContainerController.e(this.this$0).getChildCount());
        LinearContainerController r101 = this.this$0;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<Integer> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        View r104 = LinearContainerController.e(r101).getChildAt(((IntIterator) r103).nextInt());
        if (r104 == null) goto L8;
        String r105 = e.b(r104);
    L9:
        r102.add(r105);
        goto L4
    L8:
        r105 = null;
        goto L9
    L11:
        return "childViewList=\n" + CollectionsKt.joinToString$default(r102, null, null, null, 0, null, AnonymousClass1.INSTANCE, 31, null);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
