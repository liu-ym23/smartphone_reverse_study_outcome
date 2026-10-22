package com.larus.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Lcom/larus/paging/i;", "loadStates", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/larus/paging/i;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class PagingDataAdapter$withLoadStateHeaderAndFooter$1 extends Lambda implements Function1<i, Unit> {
    final /* synthetic */ LoadStateAdapter<?> $footer;
    final /* synthetic */ LoadStateAdapter<?> $header;

    public PagingDataAdapter$withLoadStateHeaderAndFooter$1(LoadStateAdapter<?> r100, LoadStateAdapter<?> r101) {
        this.$header = r100;
        this.$footer = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(i r100) {
        Intrinsics.checkNotNullParameter(r100, "loadStates");
        this.$header.B2(r100.f363858b);
        this.$footer.B2(r100.f363859c);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(i r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
