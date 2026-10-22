package com.bytedance.awemeopen.apps.framework.card.view;

import android.view.View;
import android.widget.TextView;
import com.bytedance.awemeopen.apps.framework.card.impression.AosImpressionRelativeLayout;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends AosImpressionRelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f193910a;

    @Override // com.bytedance.awemeopen.apps.framework.card.impression.AosImpressionRelativeLayout
    public final void a(boolean r100) {
    }

    public final void setOnCardShowListener(com.bytedance.awemeopen.apps.framework.card.e r100) {
        Intrinsics.checkNotNullParameter(r100, "cardShowListener");
    }

    private final View getVideoBottomShadow() {
        throw null;
    }

    private final AoImageView getVideoCoverBorder() {
        throw null;
    }

    private final AoImageView getVideoCoverIv() {
        throw null;
    }

    private final View getVideoDouyinTag() {
        throw null;
    }

    private final View getVideoPlayIcon() {
        throw null;
    }

    private final TextView getVideoTitleTv() {
        throw null;
    }

    public final String getEventPage() {
        return this.f193910a;
    }

    public final void setEventPage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f193910a = r100;
    }

    public void setOnCardClickListener(final x44.a r100) {
        Intrinsics.checkNotNullParameter(r100, "smallCardListener");
        setOnClickListener(new e(this, r100));
    }
}
