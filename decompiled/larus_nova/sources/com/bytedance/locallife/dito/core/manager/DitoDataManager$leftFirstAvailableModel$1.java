package com.bytedance.locallife.dito.core.manager;

import com.bytedance.locallife.dito.data.m;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class DitoDataManager$leftFirstAvailableModel$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List<BaseDitoModel<?>> $modelList;
    final /* synthetic */ m $oldTreeNode;
    final /* synthetic */ Ref.ObjectRef<BaseDitoModel<?>> $result;
    final /* synthetic */ DitoDataManager this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public DitoDataManager$leftFirstAvailableModel$1(Ref.ObjectRef<BaseDitoModel<?>> r100, DitoDataManager r101, m r102, List<? extends BaseDitoModel<?>> r103) {
        this.$result = r100;
        this.this$0 = r101;
        this.$oldTreeNode = r102;
        this.$modelList = r103;
        super(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Ref.ObjectRef<BaseDitoModel<?>> r100 = this.$result;
        IndexedValue r101 = DitoDataManager.c(this.this$0, this.$oldTreeNode, this.$modelList);
        if (r101 == null) goto L5;
        T r102 = (BaseDitoModel) r101.getValue();
    L6:
        r100.element = r102;
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
