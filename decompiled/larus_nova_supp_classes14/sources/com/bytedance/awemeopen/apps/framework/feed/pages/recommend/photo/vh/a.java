package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model.PhotoModel;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model.ScaleType;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.g;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.bytedance.awemeopen.apps.framework.utils.g0;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a extends g<PhotoModel> implements b {
    public final View e;
    public final lz3.b f;
    public final Context g;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.a$a, reason: collision with other inner class name */
    public static final class C0083a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b
    public ImageView a() {
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b
    public void b(boolean r1) {
    }

    public abstract PhotoModel n();

    public a(View r2, lz3.b r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "params");
        super(r2);
        this.e = r2;
        this.f = r3;
        this.g = r2.getContext();
    }

    public final boolean o(AoImageView r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "view");
        if (this.f.b.getWidth() > 0) goto L5;
    L7:
        int r0 = d0.d(this.g);
        int r1 = d0.c(this.g);
    L8:
        if (r0 > r1) goto L10;
    L15:
        int r5 = r0;
        int r4 = r1;
    L16:
        int r2 = g0.a;
        if (com.bytedance.awemeopen.bizmodels.user.d.d(this.f.c) == false) goto L19;
        float r8 = 0.5507394f;
    L21:
        return g0.b(r11, r4, r5, r12, r13, r8, this.f.b.getScaleType());
    L19:
        r8 = 0.5625f;
        goto L21
    L10:
        if (this.f.b.getScaleType() == ScaleType.ALWAYS_FIT_WIDTH) goto L12;
        r4 = r0;
        r5 = r1;
        goto L16
    L12:
        if (Math.abs((r0 / r1) - 1.3333334f) >= 5120.0f) goto L15;
        r11.setBackgroundColor(r11.getContext().getResources().getColor(2131100268));
        goto L15
    L5:
        if (this.f.b.getHeight() <= 0) goto L7;
        r0 = this.f.b.getWidth();
        r1 = this.f.b.getHeight();
        goto L8
    }
}
