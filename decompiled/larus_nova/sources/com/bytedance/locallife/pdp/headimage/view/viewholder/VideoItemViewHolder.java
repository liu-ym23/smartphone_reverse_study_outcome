package com.bytedance.locallife.pdp.headimage.view.viewholder;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.biz.common.utils.e;
import com.larus.nova.R;
import df6.q;
import df6.u;
import jx6.i;
import jx6.i0;
import jx6.p;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/pdp/headimage/view/viewholder/VideoItemViewHolder;", "Lcom/bytedance/locallife/pdp/headimage/view/viewholder/BaseItemViewHolder;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class VideoItemViewHolder extends BaseItemViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SmartImageView f261546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SmartImageView f261547b;

    public VideoItemViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        SmartImageView r101 = (SmartImageView) r100.findViewById(R.id.image_view);
        this.f261546a = r101;
        this.f261547b = (SmartImageView) r100.findViewById(R.id.icon);
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        r102.height = e.b();
        r101.setLayoutParams(r102);
    }

    @Override // com.bytedance.locallife.pdp.headimage.view.viewholder.BaseItemViewHolder
    public final void T3(p r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "itemInfo");
        Intrinsics.checkNotNullParameter(r101, "contextData");
        i0 r102 = r100.b().b();
        if (r102 == null) goto L5;
        String r103 = r102.a();
    L6:
        u r104 = q.d(r103);
        r104.f468295u = this.f261546a;
        r104.c();
        u r105 = q.e("https://lf3-static.bytednsdoc.com/obj/eden-cn/zljybvzly_lcpahu_lmps_shjvs/ljhwZthlaukjlkulzlp/img/video_play_anchor.png");
        r105.f468295u = this.f261547b;
        r105.c();
        return;
    L5:
        r103 = null;
        goto L6
    }
}
