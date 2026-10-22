package com.bytedance.ee.bear.templates.topic;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bytedance.ee.bear.facade.common.widget.NiceImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements RequestListener<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTopicView f239434a;

    public d(BaseTopicView r100) {
        this.f239434a = r100;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final boolean onLoadFailed(GlideException r100, Object r101, Target<Drawable> r102, boolean r103) {
        ((NiceImageView) this.f239434a.f239413c.findViewById(R.id.bannerIv)).setVisibility(8);
        tt5.a.e("BaseTopicView", " load iv fail", r100, false);
        return true;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final boolean onResourceReady(Drawable r100, Object r101, Target<Drawable> r102, DataSource r103, boolean r104) {
        ((NiceImageView) this.f239434a.f239413c.findViewById(R.id.bannerIv)).setVisibility(0);
        NiceImageView r105 = (NiceImageView) this.f239434a.f239413c.findViewById(R.id.bannerIv);
        r105.setImageDrawable(r100);
        return true;
    }
}
