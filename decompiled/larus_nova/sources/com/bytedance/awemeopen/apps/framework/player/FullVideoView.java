package com.bytedance.awemeopen.apps.framework.player;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.amap.api.col.s.ce;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.infra.base.player.AoVideoView;
import com.bytedance.awemeopen.infra.base.player.g;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010B\u001a\u00020A\u0012\b\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0004\bE\u0010FJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0003J\u0006\u0010\u000b\u001a\u00020\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010.\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00106\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010:\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00101\u001a\u0004\b8\u00103\"\u0004\b9\u00105R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006G"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/player/FullVideoView;", "Landroid/widget/FrameLayout;", "", "", "urls", "", "setForegroundUrl", "Lcom/bytedance/awemeopen/infra/base/image/b;", "options", "getPlayerType", "", "getVideoPlayerBaseline", "Lcom/bytedance/awemeopen/infra/base/player/AoVideoView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/awemeopen/infra/base/player/AoVideoView;", "getVideoView", "()Lcom/bytedance/awemeopen/infra/base/player/AoVideoView;", "setVideoView", "(Lcom/bytedance/awemeopen/infra/base/player/AoVideoView;)V", "videoView", "Lcom/bytedance/awemeopen/infra/base/image/AoImageView;", "b", "Lcom/bytedance/awemeopen/infra/base/image/AoImageView;", "getForegroundImageView", "()Lcom/bytedance/awemeopen/infra/base/image/AoImageView;", "setForegroundImageView", "(Lcom/bytedance/awemeopen/infra/base/image/AoImageView;)V", "foregroundImageView", "c", "getBackgroundImageView", "setBackgroundImageView", "backgroundImageView", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "getVideoViewWrapperRL", "()Landroid/widget/RelativeLayout;", "setVideoViewWrapperRL", "(Landroid/widget/RelativeLayout;)V", "videoViewWrapperRL", "e", "Landroid/widget/FrameLayout;", "getVideoViewWrapper", "()Landroid/widget/FrameLayout;", "setVideoViewWrapper", "(Landroid/widget/FrameLayout;)V", "videoViewWrapper", "Lcom/bytedance/awemeopen/apps/framework/player/EdgeTransparentView;", "f", "Lcom/bytedance/awemeopen/apps/framework/player/EdgeTransparentView;", "getTopMask", "()Lcom/bytedance/awemeopen/apps/framework/player/EdgeTransparentView;", "setTopMask", "(Lcom/bytedance/awemeopen/apps/framework/player/EdgeTransparentView;)V", "topMask", ce.f26391f, "getBottomMask", "setBottomMask", "bottomMask", "h", "Ljava/util/List;", "getUrls", "()Ljava/util/List;", "setUrls", "(Ljava/util/List;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class FullVideoView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AoVideoView f197253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AoImageView f197254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AoImageView f197255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RelativeLayout f197256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f197257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EdgeTransparentView f197258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EdgeTransparentView f197259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<String> f197260h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f197261i;

    public final String getPlayerType() {
        g r100 = this.f197253a.getCustomPlayer();
        if (r100 == null) goto L6;
        String r101 = r100.getPlayerType();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "Unknown";
    }

    public final int getVideoPlayerBaseline() {
        return this.f197257e.getBottom();
    }

    public final AoImageView getBackgroundImageView() {
        return this.f197255c;
    }

    public final EdgeTransparentView getBottomMask() {
        return this.f197259g;
    }

    public final AoImageView getForegroundImageView() {
        return this.f197254b;
    }

    public final EdgeTransparentView getTopMask() {
        return this.f197258f;
    }

    public final List<String> getUrls() {
        return this.f197260h;
    }

    public final AoVideoView getVideoView() {
        return this.f197253a;
    }

    public final FrameLayout getVideoViewWrapper() {
        return this.f197257e;
    }

    public final RelativeLayout getVideoViewWrapperRL() {
        return this.f197256d;
    }

    public final void setBackgroundImageView(AoImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f197255c = r100;
    }

    public final void setBottomMask(EdgeTransparentView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f197259g = r100;
    }

    public final void setForegroundImageView(AoImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f197254b = r100;
    }

    public final void setForegroundUrl(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "urls");
        this.f197260h = r100;
        AoImageView r101 = this.f197254b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "urls");
        r101.j(new com.bytedance.awemeopen.infra.base.image.b(r100));
    }

    public final void setTopMask(EdgeTransparentView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f197258f = r100;
    }

    public final void setUrls(List<String> r100) {
        this.f197260h = r100;
    }

    public final void setVideoView(AoVideoView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f197253a = r100;
    }

    public final void setVideoViewWrapper(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f197257e = r100;
    }

    public final void setVideoViewWrapperRL(RelativeLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f197256d = r100;
    }

    public final void setForegroundUrl(com.bytedance.awemeopen.infra.base.image.b r100) {
        Intrinsics.checkNotNullParameter(r100, "options");
        this.f197254b.j(r100);
    }

    public FullVideoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101);
        View r102 = FrameLayout.inflate(r100, R.layout.aos_view_fullvideo, this);
        this.f197253a = (AoVideoView) r102.findViewById(R.id.fullvideo_videoview);
        this.f197254b = (AoImageView) r102.findViewById(R.id.fullvideo_play_foreground);
        this.f197255c = (AoImageView) r102.findViewById(R.id.fullvideo_play_background);
        this.f197256d = (RelativeLayout) r102.findViewById(R.id.fullvideo_videoview_wrapper_rl);
        this.f197257e = (FrameLayout) r102.findViewById(R.id.fullvideo_videoview_wrapper);
        this.f197258f = (EdgeTransparentView) r102.findViewById(R.id.videoview_top_mask);
        this.f197259g = (EdgeTransparentView) r102.findViewById(R.id.videoview_bottom_mask);
    }
}
