package com.bytedance.android.livesdk.livecommerce.room.smallwindow.view.livesmallwindowview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.room.smallwindow.view.carouseview.CarouselView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yi2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/smallwindow/view/livesmallwindowview/CarouseViewItem;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/livecommerce/room/smallwindow/view/carouseview/CarouselView$b;", "Lyi2/b;", "getData", "Landroid/view/View;", "getView", "", "getRollingInterval", "()Ljava/lang/Long;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CarouseViewItem extends FrameLayout implements CarouselView.b {

    public static final class a {
    }

    static {
    }

    public CarouseViewItem(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CarouseViewItem(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final b getData() {
        return null;
    }

    public View getView() {
        return this;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.smallwindow.view.carouseview.CarouselView.b
    public Long getRollingInterval() {
        return -1L;
    }

    public CarouseViewItem(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        th.a.c(r2, 2131560780, this, true);
        ECDraweeView r5 = findViewById(2131374718);
        TextView r6 = (TextView) findViewById(2131368819);
    }

    public /* synthetic */ CarouseViewItem(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
