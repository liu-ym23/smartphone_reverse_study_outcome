package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import com.bytedance.android.ec.core.anchorv3.PdpMessageOpt;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends z53.a {
    public final /* synthetic */ ItemMediaLayer f;
    public final /* synthetic */ int g;
    public final /* synthetic */ ECDraweeView h;
    public final /* synthetic */ ECUrlModel i;
    public final /* synthetic */ Integer j;
    public final /* synthetic */ Function0 k;
    public final /* synthetic */ Function0 l;

    public final void a(String r7, ImageInfo r8, Animatable r9) {
        super.a(r7, r8, r9);
        Lazy r10 = PdpPerfOpt.a;
        if (PdpMessageOpt.b.e() == false) goto L12;
        s r11 = this.f.k;
        int r12 = this.g;
        Bitmap r1 = null;
        if ((r8 instanceof CloseableStaticBitmap) == true) goto L7;
        ImageInfo r0 = null;
    L8:
        CloseableStaticBitmap r2 = (CloseableStaticBitmap) r0;
        if (r2 == null) goto L11;
        r1 = r2.getUnderlyingBitmap();
    L11:
        r11.Kb(r12, r1);
        goto L12
    L7:
        r0 = r8;
    L12:
        ECDraweeView r13 = this.f.h;
        if (r13 == null) goto L15;
        r13.setVisibility(4);
    L15:
        this.h.setTag(this.i.getUri());
        ItemMediaLayer r3 = this.f;
        int r4 = this.g;
        Integer r14 = this.j;
        if (r14 == null) goto L18;
        int r5 = r14.intValue();
    L19:
        ItemMediaLayer.g(r3, r4, r8, false, r5, 4);
        return;
    L18:
        r5 = -1;
        goto L19
    }

    public final /* bridge */ /* synthetic */ void onFinalImageSet(String r1, Object r2, Animatable r3) {
        a(r1, (ImageInfo) r2, r3);
    }

    public d(ItemMediaLayer r1, int r2, ECDraweeView r3, ECUrlModel r4, Integer r5, Function0 r6, Function0 r7, List r8, String r9, Function0 r10, Function0 r11, boolean r12) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.l = r7;
        super(r8, r9, r10, r11, r12);
    }
}
