package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.bytedance.android.livesdk.livecommerce.iron.model.ECCustomizedElementBannerData;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0007B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/ECCustomizedElementBannerView;", "Landroid/widget/RelativeLayout;", "", "roomId", "", "setRoomId", "Lcom/bytedance/android/livesdk/livecommerce/iron/model/ECCustomizedElementBannerData;", "a", "Lcom/bytedance/android/livesdk/livecommerce/iron/model/ECCustomizedElementBannerData;", "getCurrentData", "()Lcom/bytedance/android/livesdk/livecommerce/iron/model/ECCustomizedElementBannerData;", "setCurrentData", "(Lcom/bytedance/android/livesdk/livecommerce/iron/model/ECCustomizedElementBannerData;)V", "currentData", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCustomizedElementBannerView extends RelativeLayout {
    public ECCustomizedElementBannerData a;
    public final ECCustomizedElementView b;
    public final ECCustomizedElementView c;
    public final ECDraweeView d;
    public final int e;

    public static final class a {
    }

    static {
    }

    public ECCustomizedElementBannerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECCustomizedElementBannerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setRoomId(String r1) {
    }

    public final ECCustomizedElementBannerData getCurrentData() {
        return this.a;
    }

    public final void setCurrentData(ECCustomizedElementBannerData r1) {
        this.a = r1;
    }

    public ECCustomizedElementBannerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = UtilityKotlinExtentionsKt.d(Float.valueOf(26.0f));
        th.a.c(r2, 2131564710, this, true);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ECDraweeView r5 = findViewById(2131370421);
        this.b = (ECCustomizedElementView) findViewById(2131365441);
        this.c = (ECCustomizedElementView) findViewById(2131365442);
        this.d = findViewById(2131392520);
    }

    public /* synthetic */ ECCustomizedElementBannerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if ((this.c.getLeft() - this.b.getRight()) >= this.e) goto L6;
        ECCustomizedElementView r6 = this.c;
        r6.layout(r6.getLeft(), 0, this.c.getLeft(), 0);
        return;
    L6:
        if (this.d.getVisibility() != 0) goto L8;
        boolean r7 = true;
    L9:
        if (r7 == false) goto L13;
        ECDraweeView r8 = this.d;
        r8.layout(r8.getLeft(), 0, this.d.getLeft(), 0);
        return;
    L13:
        return;
    L8:
        r7 = false;
        goto L9
    }
}
