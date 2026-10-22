package com.bytedance.android.livesdk.livecommerce.promotion.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/view/ECStockProgressLayout;", "Landroid/widget/FrameLayout;", "", "progressText", "", "setTxStockDes", "label", "setLabel", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStockProgressLayout extends FrameLayout {
    public ProgressBar a;
    public ImageView b;
    public TextView c;
    public TextView d;
    public ECNewCountDownView e;

    public static final class a {
    }

    static {
    }

    public ECStockProgressLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECStockProgressLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final void setLabel(String r4) {
        TextView r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L5:
        r0.setContentDescription(r4);
        if (TextUtils.isEmpty(r4) == false) goto L11;
        TextView r5 = this.d;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L10:
        r5.setVisibility(4);
        return;
    L11:
        TextView r1 = this.d;
        if (r1 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L15:
        if (Intrinsics.areEqual(r1.getText(), r4) == false) goto L21;
        TextView r2 = this.d;
        if (r2 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L20:
        if (r2.getVisibility() != 0) goto L21;
        return;
    L21:
        TextView r3 = this.d;
        if (r3 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L24:
        r3.setText(r4);
        TextView r6 = this.d;
        if (r6 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L27:
        r6.setVisibility(4);
    }

    private final void setTxStockDes(String r5) {
        TextView r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L5:
        r0.setContentDescription(r5);
        if (TextUtils.isEmpty(r5) == false) goto L11;
        TextView r6 = this.c;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L10:
        r6.setVisibility(8);
        return;
    L11:
        TextView r1 = this.c;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L14:
        r1.setVisibility(0);
        AppCompatTextView r2 = this.e;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("countDownView");
    L17:
        r2.setVisibility(8);
        TextView r3 = this.c;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L20:
        r3.setText(r5);
    }

    public static final void a(ECStockProgressLayout r3, float r4) {
        ProgressBar r0 = r3.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
    L5:
        r0.setProgressDrawable(th.a.b(r3.getContext(), 2131234785));
        ImageView r1 = r3.b;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L8:
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof FrameLayout.LayoutParams) == true) goto L11;
        r2 = null;
    L11:
        FrameLayout.LayoutParams r5 = (FrameLayout.LayoutParams) r2;
        if (r5 == null) goto L21;
        r5.width = (int) r4;
        ImageView r6 = r3.b;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L16:
        r6.setLayoutParams(r5);
        ImageView r7 = r3.b;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("ivProgressBackground");
    L19:
        r7.setVisibility(0);
        return;
    }

    public ECStockProgressLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = th.a.c(r2, 2131564758, this, true);
        this.a = (ProgressBar) r5.findViewById(2131370816);
        this.b = (ImageView) r5.findViewById(2131370498);
        this.c = (TextView) r5.findViewById(2131371239);
        this.d = (TextView) r5.findViewById(2131370759);
        this.e = (ECNewCountDownView) r5.findViewById(2131380717);
    }

    public /* synthetic */ ECStockProgressLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void b(String r7, long r8, long r10, String r12) {
        setLabel(r12);
        post(new d(this, r8, r10));
        setTxStockDes(r7);
    }
}
