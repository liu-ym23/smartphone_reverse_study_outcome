package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/AnchorV4DetailImageMoreInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/d;", "c", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/d;", "getDetailImageVO", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/d;", "setDetailImageVO", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/d;)V", "detailImageVO", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailImageMoreInfoView extends ConstraintLayout {
    public static final /* synthetic */ int d = 0;
    public final SimpleDraweeView a;
    public final TextView b;
    public d c;

    public static final class a {
    }

    static {
    }

    public AnchorV4DetailImageMoreInfoView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4DetailImageMoreInfoView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final d getDetailImageVO() {
        return this.c;
    }

    public final void setDetailImageVO(d r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4DetailImageMoreInfoView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131564712, this, true);
        this.a = findViewById(2131385272);
        ConstraintLayout r5 = findViewById(2131366877);
        LinearLayout r6 = (LinearLayout) findViewById(2131378755);
        this.b = (TextView) findViewById(2131390965);
    }

    public /* synthetic */ AnchorV4DetailImageMoreInfoView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
