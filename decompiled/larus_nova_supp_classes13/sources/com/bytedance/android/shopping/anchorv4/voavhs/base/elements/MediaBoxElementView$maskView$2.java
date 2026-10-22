package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.content.Context;
import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final class MediaBoxElementView$maskView$2 extends Lambda implements Function0<View> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MediaBoxElementView this$0;

    public MediaBoxElementView$maskView$2(MediaBoxElementView r1, Context r2) {
        this.this$0 = r1;
        this.$context = r2;
        super(0);
    }

    public final View invoke() {
        View r0 = new View(this.$context);
        ViewCompat.setBackground(r0, com.bytedance.commerce.base.drawable.a.a(new MediaBoxElementView$maskView$2$$special$$inlined$apply$lambda$1(this)));
        r0.setVisibility(4);
        return r0;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m16invoke() {
        return invoke();
    }
}
