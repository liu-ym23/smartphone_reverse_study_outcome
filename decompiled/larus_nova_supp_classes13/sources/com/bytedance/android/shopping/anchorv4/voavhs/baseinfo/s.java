package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.widget.TextView;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ TextElement b;

    /* JADX WARN: Multi-variable type inference failed */
    public s(InlineLongTitleComponentView r1, TextElement r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.setText(v.a(this.b));
    }
}
