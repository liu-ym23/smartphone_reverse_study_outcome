package com.bytedance.ee.bear.office.common.screenmenu;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ScreenMenu$show$1 extends Lambda implements Function0<View> {
    final /* synthetic */ View $anchor;
    final /* synthetic */ Bitmap $bitmap;

    public ScreenMenu$show$1(View r100, Bitmap r101) {
        this.$anchor = r100;
        this.$bitmap = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final View invoke() {
        ImageView r100 = new ImageView(this.$anchor.getContext());
        r100.setImageBitmap(this.$bitmap);
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ View invoke() {
        return invoke();
    }
}
