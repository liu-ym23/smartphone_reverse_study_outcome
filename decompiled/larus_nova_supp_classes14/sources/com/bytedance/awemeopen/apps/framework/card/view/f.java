package com.bytedance.awemeopen.apps.framework.card.view;

import android.view.View;
import android.widget.TextView;
import com.bytedance.awemeopen.apps.framework.card.impression.AosImpressionRelativeLayout;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends AosImpressionRelativeLayout {
    public String a;

    @Override // com.bytedance.awemeopen.apps.framework.card.impression.AosImpressionRelativeLayout
    public final void a(boolean r1) {
    }

    public final void setOnCardShowListener(com.bytedance.awemeopen.apps.framework.card.e r2) {
        Intrinsics.checkNotNullParameter(r2, "cardShowListener");
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
        return this.a;
    }

    public final void setEventPage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public void setOnCardClickListener(final x44.a r2) {
        Intrinsics.checkNotNullParameter(r2, "smallCardListener");
        setOnClickListener(new e(this, r2));
    }
}
