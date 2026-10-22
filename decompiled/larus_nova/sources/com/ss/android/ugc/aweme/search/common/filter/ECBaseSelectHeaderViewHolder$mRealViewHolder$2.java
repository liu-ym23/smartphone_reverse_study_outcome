package com.ss.android.ugc.aweme.search.common.filter;

import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", AbsMethodDelegate.TAG_INVOKE, "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;"}, k = 3, mv = {1, 4, 3})
final class ECBaseSelectHeaderViewHolder$mRealViewHolder$2 extends Lambda implements Function0<RecyclerView.ViewHolder> {
    final /* synthetic */ ECBaseSelectHeaderViewHolder this$0;

    public ECBaseSelectHeaderViewHolder$mRealViewHolder$2(ECBaseSelectHeaderViewHolder r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final RecyclerView.ViewHolder invoke() {
        RecyclerView.ViewHolder r100 = this.this$0.T3();
        View r101 = this.this$0.itemView;
        if ((r101 instanceof ViewGroup) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup r102 = (ViewGroup) r101;
        if (r102 == null) goto L8;
        r102.addView(r100.itemView);
    L8:
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder invoke() {
        return invoke();
    }
}
