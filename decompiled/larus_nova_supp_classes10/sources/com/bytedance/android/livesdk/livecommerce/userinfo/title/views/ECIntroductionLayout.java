package com.bytedance.android.livesdk.livecommerce.userinfo.title.views;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedance.android.ec.core.widget.VerticalDashLineView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.ECMaxSizeLinearLayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/views/ECIntroductionLayout;", "Lcom/bytedance/android/livesdk/livecommerce/view/ECMaxSizeLinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECIntroductionLayout extends ECMaxSizeLinearLayout {
    public static final /* synthetic */ int g = 0;
    public final List<TextView> c;
    public final List<VerticalDashLineView> d;
    public final List<ECDraweeView> e;
    public final List<ECIntroductionRotationView> f;

    public static final class a {
        public static TextView a(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            TextView r0 = new TextView(r3);
            r0.setTextSize(1, 11.0f);
            r0.setEllipsize(TextUtils.TruncateAt.END);
            r0.setMaxLines(1);
            r0.setIncludeFontPadding(false);
            if (Build.VERSION.SDK_INT < 28) goto L5;
            r0.setFallbackLineSpacing(false);
            r0.setLineHeight(UtilityKotlinExtentionsKt.d(12));
        L5:
            return r0;
        }
    }

    static {
    }

    public ECIntroductionLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        setOrientation(0);
    }

    public final <T extends View> T d(List<T> r2) {
        if ((!r2.isEmpty()) == false) goto L7;
        T r3 = (T) ListProtector.remove(r2, 0);
        if (r3.getParent() != null) goto L9;
        return r3;
    L9:
        return null;
    L7:
        return null;
    }

    public final LinearLayoutCompat.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        if (r2 != null) goto L6;
        return new LinearLayoutCompat.LayoutParams(-2, -2);
    L6:
        if ((r2 instanceof LinearLayoutCompat.LayoutParams) == false) goto L9;
        return (LinearLayoutCompat.LayoutParams) r2;
    L9:
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        return new LinearLayoutCompat.LayoutParams((ViewGroup.MarginLayoutParams) r2);
    L12:
        return super.generateLayoutParams(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewRemoved(View r2) {
        super/*android.view.ViewGroup*/.onViewRemoved(r2);
        if ((r2 instanceof TextView) == false) goto L6;
        this.c.add(r2);
        return;
    L6:
        if ((r2 instanceof VerticalDashLineView) == false) goto L9;
        this.d.add(r2);
        return;
    L9:
        if ((r2 instanceof ECDraweeView) == false) goto L12;
        this.e.add(r2);
        return;
    L12:
        if ((r2 instanceof ECIntroductionRotationView) == false) goto L18;
        this.f.add(r2);
        return;
    }

    public ECIntroductionLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, 4, 0);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        setOrientation(0);
    }

    public ECIntroductionLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        setOrientation(0);
    }
}
