package com.bytedance.creativex.mediaimport.view.internal.viewholder;

import android.view.View;
import com.bytedance.creativex.mediaimport.view.internal.base.BaseSelectorViewHolder;
import com.bytedance.creativex.mediaimport.view.internal.base.k;
import ki4.r;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ti4.w;
import ui4.b;
import ui4.d;
import ui4.f;
import ui4.l;
import zi4.e;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B±\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012K\u0010\u0006\u001aG\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0007\u0012K\u0010\u0010\u001aG\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0007¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0015H\u0014J\u0016\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0014R)\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/bytedance/creativex/mediaimport/view/internal/viewholder/SelectionListViewHolder;", "Lcom/bytedance/creativex/mediaimport/view/internal/base/BaseSelectorViewHolder;", "Lcom/bytedance/creativex/mediaimport/repository/api/IMaterialItem;", "itemView", "Landroid/view/View;", "cancelView", "contentClickListener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "data", "", "position", "Lcom/bytedance/creativex/mediaimport/view/internal/MaterialSelectedState;", "state", "", "cancelClickListener", "<init>", "(Landroid/view/View;Landroid/view/View;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;)V", "holderBindHandler", "Lcom/bytedance/creativex/mediaimport/view/internal/IMediaViewHolderBindController;", "Lcom/bytedance/creativex/mediaimport/view/internal/base/BaseSelectorViewHolder$State;", "getHolderBindHandler", "()Lcom/bytedance/creativex/mediaimport/view/internal/IMediaViewHolderBindController;", "holderBindHandler$delegate", "Lkotlin/Lazy;", "bindDataAndState", "mediaData", "provideBindHandler", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SelectionListViewHolder extends BaseSelectorViewHolder<r> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f204114d = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f204115c;

    public w<r, BaseSelectorViewHolder.a> U3() {
        int r100 = b.f550153b;
        return b.a.a(CollectionsKt.listOf(new Object[]{new l.b(this.itemView), new f.a(this.itemView, null), new d.a(this.itemView)}));
    }

    public final void T3(Object r100, int r101, BaseSelectorViewHolder.a.C2958a r102) {
        r r103 = (r) r100;
        Intrinsics.checkNotNullParameter(r103, "mediaData");
        Intrinsics.checkNotNullParameter(r102, "state");
        w r104 = (w) this.f204115c.getValue();
        if (r104 == null) goto L6;
        r104.c(r103, r101, r102);
        return;
    }

    public SelectionListViewHolder(View r100, View r101, k r102, com.bytedance.creativex.mediaimport.view.internal.base.l r103) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "cancelView");
        Intrinsics.checkNotNullParameter(r102, "contentClickListener");
        Intrinsics.checkNotNullParameter(r103, "cancelClickListener");
        super(r100, r101, r102, r103);
        this.f204115c = LazyKt.lazy(new e(this));
    }
}
