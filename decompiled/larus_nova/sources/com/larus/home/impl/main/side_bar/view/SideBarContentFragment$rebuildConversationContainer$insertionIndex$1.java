package com.larus.home.impl.main.side_bar.view;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class SideBarContentFragment$rebuildConversationContainer$insertionIndex$1 extends FunctionReferenceImpl implements Function1<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> {
    public SideBarContentFragment$rebuildConversationContainer$insertionIndex$1(Object r100) {
        super(1, r100, CollectionsKt.class, "indexOf", "indexOf(Ljava/util/List;Ljava/lang/Object;)I", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Integer invoke2(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return Integer.valueOf(CollectionsKt.indexOf((List) this.receiver, r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r100) {
        return invoke2(r100);
    }
}
