package com.bytedance.awemeopen.apps.framework.player;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.infra.base.player.AoVideoView;
import com.bytedance.awemeopen.infra.base.player.g;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010B\u001a\u00020A\u0012\b\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0004\bE\u0010FJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0003J\u0006\u0010\u000b\u001a\u00020\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010.\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00106\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010:\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00101\u001a\u0004\b8\u00103\"\u0004\b9\u00105R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006G"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/player/FullVideoView;", "Landroid/widget/FrameLayout;", "", "", "urls", "", "setForegroundUrl", "Lcom/bytedance/awemeopen/infra/base/image/b;", "options", "getPlayerType", "", "getVideoPlayerBaseline", "Lcom/bytedance/awemeopen/infra/base/player/AoVideoView;", "a", "Lcom/bytedance/awemeopen/infra/base/player/AoVideoView;", "getVideoView", "()Lcom/bytedance/awemeopen/infra/base/player/AoVideoView;", "setVideoView", "(Lcom/bytedance/awemeopen/infra/base/player/AoVideoView;)V", "videoView", "Lcom/bytedance/awemeopen/infra/base/image/AoImageView;", "b", "Lcom/bytedance/awemeopen/infra/base/image/AoImageView;", "getForegroundImageView", "()Lcom/bytedance/awemeopen/infra/base/image/AoImageView;", "setForegroundImageView", "(Lcom/bytedance/awemeopen/infra/base/image/AoImageView;)V", "foregroundImageView", "c", "getBackgroundImageView", "setBackgroundImageView", "backgroundImageView", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "getVideoViewWrapperRL", "()Landroid/widget/RelativeLayout;", "setVideoViewWrapperRL", "(Landroid/widget/RelativeLayout;)V", "videoViewWrapperRL", "e", "Landroid/widget/FrameLayout;", "getVideoViewWrapper", "()Landroid/widget/FrameLayout;", "setVideoViewWrapper", "(Landroid/widget/FrameLayout;)V", "videoViewWrapper", "Lcom/bytedance/awemeopen/apps/framework/player/EdgeTransparentView;", "f", "Lcom/bytedance/awemeopen/apps/framework/player/EdgeTransparentView;", "getTopMask", "()Lcom/bytedance/awemeopen/apps/framework/player/EdgeTransparentView;", "setTopMask", "(Lcom/bytedance/awemeopen/apps/framework/player/EdgeTransparentView;)V", "topMask", "g", "getBottomMask", "setBottomMask", "bottomMask", "h", "Ljava/util/List;", "getUrls", "()Ljava/util/List;", "setUrls", "(Ljava/util/List;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class FullVideoView extends FrameLayout {
    public AoVideoView a;
    public AoImageView b;
    public AoImageView c;
    public RelativeLayout d;
    public FrameLayout e;
    public EdgeTransparentView f;
    public EdgeTransparentView g;
    public List<String> h;
    public b i;

    public final String getPlayerType() {
        g r0 = this.a.getCustomPlayer();
        if (r0 == null) goto L6;
        String r1 = r0.getPlayerType();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "Unknown";
    }

    public final int getVideoPlayerBaseline() {
        return this.e.getBottom();
    }

    public final AoImageView getBackgroundImageView() {
        return this.c;
    }

    public final EdgeTransparentView getBottomMask() {
        return this.g;
    }

    public final AoImageView getForegroundImageView() {
        return this.b;
    }

    public final EdgeTransparentView getTopMask() {
        return this.f;
    }

    public final List<String> getUrls() {
        return this.h;
    }

    public final AoVideoView getVideoView() {
        return this.a;
    }

    public final FrameLayout getVideoViewWrapper() {
        return this.e;
    }

    public final RelativeLayout getVideoViewWrapperRL() {
        return this.d;
    }

    public final void setBackgroundImageView(AoImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setBottomMask(EdgeTransparentView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    public final void setForegroundImageView(AoImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setForegroundUrl(List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "urls");
        this.h = r3;
        AoImageView r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "urls");
        r1.j(new com.bytedance.awemeopen.infra.base.image.b(r3));
    }

    public final void setTopMask(EdgeTransparentView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void setUrls(List<String> r1) {
        this.h = r1;
    }

    public final void setVideoView(AoVideoView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void setVideoViewWrapper(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setVideoViewWrapperRL(RelativeLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setForegroundUrl(com.bytedance.awemeopen.infra.base.image.b r2) {
        Intrinsics.checkNotNullParameter(r2, "options");
        this.b.j(r2);
    }

    public FullVideoView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3);
        View r4 = FrameLayout.inflate(r2, 2131558707, this);
        this.a = r4.findViewById(2131373356);
        this.b = r4.findViewById(2131373355);
        this.c = r4.findViewById(2131373354);
        this.d = (RelativeLayout) r4.findViewById(2131373358);
        this.e = (FrameLayout) r4.findViewById(2131373357);
        this.f = (EdgeTransparentView) r4.findViewById(2131392434);
        this.g = (EdgeTransparentView) r4.findViewById(2131392433);
    }
}
