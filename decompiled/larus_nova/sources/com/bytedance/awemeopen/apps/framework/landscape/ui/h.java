package com.bytedance.awemeopen.apps.framework.landscape.ui;

import android.content.res.ColorStateList;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.ImageViewCompat;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r14.c f197209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a f197210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f197211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f197212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f197213e;

    public final void a(boolean r100) {
        r14.j r101 = this.f197209a.L();
        ColorStateList r102 = null;
        if (r101 == null) goto L5;
        Long r103 = Long.valueOf(r101.d());
    L6:
        this.f197212d.setText(k.a(k.b(r103, this.f197213e, r100), "点赞"));
        AppCompatImageView r104 = this.f197211c;
        if (r100 == false) goto L9;
        r102 = ColorStateList.valueOf(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED));
    L9:
        ImageViewCompat.setImageTintList(r104, r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public h(r14.c r100, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r101, AppCompatImageView r102, TextView r103) {
        Intrinsics.checkNotNullParameter(r100, ShareChannel.DOUYIN);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "iconLike");
        Intrinsics.checkNotNullParameter(r103, "tvCountLikes");
        this.f197209a = r100;
        this.f197210b = r101;
        this.f197211c = r102;
        this.f197212d = r103;
    }
}
