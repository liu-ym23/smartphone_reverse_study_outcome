package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer;

import android.graphics.drawable.Animatable;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends z53.a {
    public final /* synthetic */ ItemMediaLayer f;
    public final /* synthetic */ int g;

    public final void b(String r7, ImageInfo r8) {
        this.f.y();
        ItemMediaLayer.g(this.f, this.g, r8, true, 0, 8);
    }

    public final /* bridge */ /* synthetic */ void onIntermediateImageSet(String r1, Object r2) {
        b(r1, (ImageInfo) r2);
    }

    public final void a(String r7, ImageInfo r8, Animatable r9) {
        this.f.y();
        ItemMediaLayer.g(this.f, this.g, r8, true, 0, 8);
    }

    public final /* bridge */ /* synthetic */ void onFinalImageSet(String r1, Object r2, Animatable r3) {
        a(r1, (ImageInfo) r2, r3);
    }

    public h(ItemMediaLayer r7, int r8, List r9, String r10) {
        this.f = r7;
        this.g = r8;
        super(r9, r10, null, false, 12);
    }
}
