package com.bytedance.locallife.pdp.album.page;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.dito.baseview.RoundRelativeLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/locallife/pdp/album/page/PictureViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PictureViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoundRelativeLayout f261003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f261004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DuxTextView f261005c;

    public interface a {
        void a(int r100, SimpleDraweeView r101);
    }

    public PictureViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f261003a = (RoundRelativeLayout) r100.findViewById(R.id.photo_container);
        this.f261004b = (SimpleDraweeView) r100.findViewById(R.id.photo_imageview);
        this.f261005c = (DuxTextView) r100.findViewById(R.id.photo_type);
    }
}
