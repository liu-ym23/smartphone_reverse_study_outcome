package com.larus.ugc.community.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import f0a.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B4\u0012#\u0010\u0002\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0016\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R+\u0010\u0002\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/ugc/community/adapter/RefViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onRefViewClickListener", "Lkotlin/Function1;", "Lcom/larus/ugc/community/adapter/RefData;", "Lkotlin/ParameterName;", "name", MapController.ITEM_LAYER_TAG, "", "itemView", "Landroid/view/View;", "<init>", "(Lkotlin/jvm/functions/Function1;Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "refView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "audioView", "audioIcon", "Landroid/widget/ImageView;", "audioDuration", "Landroid/widget/TextView;", "bindData", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RefViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f374293g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<a, Unit> f374294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f374295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f374296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f374297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f374298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f374299f;

    /* JADX WARN: Multi-variable type inference failed */
    public RefViewHolder(Function1<? super a, Unit> r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "onRefViewClickListener");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        super(r101);
        this.f374294a = r100;
        this.f374295b = r101;
        this.f374296c = (SimpleDraweeView) r101.findViewById(R.id.ref_view);
        this.f374297d = r101.findViewById(R.id.audio_view);
        this.f374298e = (ImageView) r101.findViewById(R.id.audio_icon);
        this.f374299f = (TextView) r101.findViewById(R.id.audio_duration);
    }
}
