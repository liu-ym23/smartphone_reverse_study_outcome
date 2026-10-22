package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import com.bytedance.android.shopping.anchorv4.dto.ImageOCRResponseDTO;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ AnchorV4DetailImageView a;
    public final /* synthetic */ d b;

    public f(AnchorV4DetailImageView r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        this.a.setContentDescription(com.bytedance.android.shopping.extensions.j.e(2131913857, Integer.valueOf(this.b.c + 1), ((ImageOCRResponseDTO) r4).getOcrTexts()));
    }
}
