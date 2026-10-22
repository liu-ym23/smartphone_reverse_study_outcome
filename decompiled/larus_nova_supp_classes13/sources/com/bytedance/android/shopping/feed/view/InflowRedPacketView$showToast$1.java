package com.bytedance.android.shopping.feed.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.android.ui.ec.widget.tools.UnitExtensionKt;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"}, k = 3, mv = {1, 4, 3})
final class InflowRedPacketView$showToast$1 extends Lambda implements Function1<Bitmap, Unit> {
    final /* synthetic */ String $tip;
    final /* synthetic */ InflowRedPacketView this$0;

    public InflowRedPacketView$showToast$1(InflowRedPacketView r1, String r2) {
        this.this$0 = r1;
        this.$tip = r2;
        super(1);
    }

    public final void invoke(Bitmap r8) {
        if (r8 != null) goto L10;
        ECToast.showToast$default(ECToast.INSTANCE, this.this$0.getContext(), this.$tip, null, null, 8, null);
        return;
    L10:
        Bitmap r9 = Bitmap.createScaledBitmap(r8, UnitExtensionKt.dp2px(16), UnitExtensionKt.dp2px(16), true);     // Catch: Exception -> L6
        BitmapDrawable r3 = new BitmapDrawable(this.this$0.getContext().getResources(), r9);     // Catch: Exception -> L6
        ECToast.showToast$default(ECToast.INSTANCE, this.this$0.getContext(), this.$tip, r3, null, 8, null);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Bitmap) r1);
        return Unit.INSTANCE;
    }
}
