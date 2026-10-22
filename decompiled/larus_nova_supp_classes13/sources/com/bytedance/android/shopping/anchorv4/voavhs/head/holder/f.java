package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.dto.ImageOCRResponseDTO;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ View a;
    public final /* synthetic */ h83.b b;

    public f(View r1, h83.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        this.a.setContentDescription(com.bytedance.android.shopping.extensions.j.e(2131913860, Integer.valueOf(this.b.b + 1), ((ImageOCRResponseDTO) r4).getOcrTexts()));
    }
}
