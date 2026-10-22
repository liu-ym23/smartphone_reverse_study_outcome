package com.larus.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Lcom/larus/paging/LoadType;", "loadType", "Lcom/larus/paging/u;", "loadState", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/larus/paging/LoadType;Lcom/larus/paging/u;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class PagedListAdapter$withLoadStateFooter$1 extends Lambda implements Function2<LoadType, u, Unit> {
    final /* synthetic */ LoadStateAdapter<?> $footer;

    public PagedListAdapter$withLoadStateFooter$1(LoadStateAdapter<?> r100) {
        this.$footer = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LoadType r100, u r101) {
        Intrinsics.checkNotNullParameter(r100, "loadType");
        Intrinsics.checkNotNullParameter(r101, "loadState");
        if (r100 != LoadType.APPEND) goto L6;
        this.$footer.B2(r101);
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(LoadType r100, u r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
