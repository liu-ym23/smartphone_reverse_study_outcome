package com.ss.android.lark.integrator.ccm.config.viewbinder;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements RequestListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocCardViewBinder.DocCardViewHolder f427808a;

    public f(DocCardViewBinder.DocCardViewHolder r100) {
        this.f427808a = r100;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final boolean onLoadFailed(GlideException r100, Object r101, Target r102, boolean r103) {
        tt5.a.f("DocCardViewBinder", r100, false);
        this.f427808a.thumbImageView.setVisibility(8);
        this.f427808a.thumbLoadFailView.setImageResource(R.drawable.common_failed_chat_picture);
        this.f427808a.thumbLoadFailView.setVisibility(0);
        return true;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final boolean onResourceReady(Object r100, Object r101, Target r102, DataSource r103, boolean r104) {
        this.f427808a.thumbImageView.setVisibility(0);
        this.f427808a.thumbLoadFailView.setVisibility(8);
        return false;
    }
}
