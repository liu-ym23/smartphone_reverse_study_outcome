package com.bytedance.awemeopen.apps.framework.landscape.ui;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.ImageViewCompat;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j {
    public final r14.c a;
    public final AppCompatImageView b;
    public final TextView c;
    public final o d;
    public final Activity e;
    public final o24.b f;
    public boolean g;
    public boolean h;
    public boolean i;

    public final void a(boolean r5) {
        r14.j r0 = this.a.L();
        ColorStateList r1 = null;
        if (r0 == null) goto L5;
        Long r2 = Long.valueOf(r0.b());
    L6:
        this.c.setText(k.a(k.b(r2, this.i, r5), "收藏"));
        AppCompatImageView r3 = this.b;
        if (r5 == false) goto L9;
        r1 = ColorStateList.valueOf(ColorProtector.parseColor("#FED000"));
    L9:
        ImageViewCompat.setImageTintList(r3, r1);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public j(r14.c r2, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r3, AppCompatImageView r4, TextView r5) {
        Intrinsics.checkNotNullParameter(r2, "aweme");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "favoriteIcon");
        Intrinsics.checkNotNullParameter(r5, "tvFavorites");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r3.c;
        this.e = r3.getActivity();
        d14.a r6 = b14.a.a;
        this.f = b14.a.a(o24.b.class);
    }
}
