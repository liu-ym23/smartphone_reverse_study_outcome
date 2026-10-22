package com.bytedance.awemeopen.apps.framework.landscape.ui;

import android.content.res.ColorStateList;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.ImageViewCompat;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public final r14.c a;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a b;
    public final AppCompatImageView c;
    public final TextView d;
    public boolean e;

    public final void a(boolean r5) {
        r14.j r0 = this.a.L();
        ColorStateList r1 = null;
        if (r0 == null) goto L5;
        Long r2 = Long.valueOf(r0.d());
    L6:
        this.d.setText(k.a(k.b(r2, this.e, r5), "点赞"));
        AppCompatImageView r3 = this.c;
        if (r5 == false) goto L9;
        r1 = ColorStateList.valueOf(ColorProtector.parseColor("#FE2C55"));
    L9:
        ImageViewCompat.setImageTintList(r3, r1);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public h(r14.c r2, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r3, AppCompatImageView r4, TextView r5) {
        Intrinsics.checkNotNullParameter(r2, "aweme");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "iconLike");
        Intrinsics.checkNotNullParameter(r5, "tvCountLikes");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
