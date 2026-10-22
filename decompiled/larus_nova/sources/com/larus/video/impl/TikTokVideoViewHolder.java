package com.larus.video.impl;

import android.view.View;
import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.platform.api.IVideoController;
import com.larus.video.impl.widget.VideoView;
import com.larus.video.impl.widget.VideoViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014¨\u0006\r"}, d2 = {"Lcom/larus/video/impl/TikTokVideoViewHolder;", "Lcom/larus/video/impl/widget/VideoViewHolder;", "itemView", "Landroid/view/View;", "mCommonVideoModel", "Lcom/larus/flow/video/bean/CommonVideoModel;", "videoController", "Lcom/larus/platform/api/IVideoController;", "<init>", "(Landroid/view/View;Lcom/larus/flow/video/bean/CommonVideoModel;Lcom/larus/platform/api/IVideoController;)V", "playVideo", "", "stopVideo", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TikTokVideoViewHolder extends VideoViewHolder {
    @Override // com.larus.video.impl.widget.VideoViewHolder
    public final void D() {
        VideoView r100 = T3();
        if (r100 == null) goto L6;
        VideoView.g(r100);
        return;
    }

    @Override // com.larus.video.impl.widget.VideoViewHolder
    public final void W3() {
        VideoView r100 = T3();
        if (r100 == null) goto L6;
        r100.j();
        return;
    }

    public TikTokVideoViewHolder(View r100, CommonVideoModel r101, IVideoController r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100, r101, r102);
    }
}
