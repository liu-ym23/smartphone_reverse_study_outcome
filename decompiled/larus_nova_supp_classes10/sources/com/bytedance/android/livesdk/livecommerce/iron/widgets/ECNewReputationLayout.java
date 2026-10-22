package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.livesdk.livecommerce.event.e2;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tB'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R#\u0010\r\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR#\u0010\u0011\u001a\n \b*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0014\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\fR#\u0010\u0017\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/ECNewReputationLayout;", "Landroid/widget/LinearLayout;", "", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$d;", "authorReputation", "", "setReputationInfo", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getDescribeTV", "()Landroid/widget/TextView;", "describeTV", "b", "getScoreGroup", "()Landroid/widget/LinearLayout;", "scoreGroup", "c", "getScoreTV", "scoreTV", "d", "getLevelTV", "levelTV", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECNewReputationLayout extends LinearLayout {
    public static final Integer[] e = null;
    public static final Integer[] f = null;
    public static final Integer[] g = null;
    public static final Integer[] h = null;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;

    public static final class a {
    }

    public ECNewReputationLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECNewReputationLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final TextView getDescribeTV() {
        return (TextView) this.a.getValue();
    }

    private final TextView getLevelTV() {
        return (TextView) this.d.getValue();
    }

    private final LinearLayout getScoreGroup() {
        return (LinearLayout) this.b.getValue();
    }

    private final TextView getScoreTV() {
        return (TextView) this.c.getValue();
    }

    static {
        e = new Integer[]{2131234264, 2131234276, 2131234275, 2131234277};
        f = new Integer[]{2131101672, 2131101595, 2131101546, 2131105982};
        g = new Integer[]{2131896347, 2131896349, 2131896348, 2131896350};
        h = new Integer[]{2131231882, 2131231884, 2131231883, 2131231885};
    }

    public void setReputationInfo(ECPromotionList.d r11) {
        if (r11 == null) goto L20;
        StringBuilder r0 = new StringBuilder();
        getDescribeTV().setText(r11.text);
        r0.append(r11.text);
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        int r5 = 0;
        String r2 = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r11.score)}, 1));
        getScoreTV().setText(r2);
        int r3 = r11.level;
        if (1 > r3) goto L10;
        if (3 < r3) goto L10;
        if (r11.score <= 0) goto L10;
        int r4 = r3 - 1;
    L11:
        TextView r12 = getScoreTV();
        if (r4 != 3) goto L14;
        r5 = 8;
    L15:
        r12.setVisibility(r5);
        int r13 = th.a.a(getContext(), f[r4].intValue());
        Typeface r6 = ECFontHelper.e.b("DouyinNumberABC", MonitorLevel.FATAL, true);
        if (r6 == null) goto L18;
        getScoreTV().setTypeface(r6);
    L18:
        String r7 = getResources().getString(g[r4].intValue());
        r0.append(r7);
        getLevelTV().setText(r7);
        getScoreGroup().setBackgroundResource(h[r4].intValue());
        getScoreTV().setTextColor(r13);
        getDescribeTV().setTextColor(r13);
        getLevelTV().setTextColor(r13);
        setBackgroundResource(e[r4].intValue());
        setContentDescription(r0.toString());
        new e2().k();
        return;
    L14:
        r0.append(r2);
    L10:
        r4 = 3;
        goto L11
    }

    public ECNewReputationLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new ECNewReputationLayout$describeTV$2(this));
        this.b = LazyKt.lazy(new ECNewReputationLayout$scoreGroup$2(this));
        this.c = LazyKt.lazy(new ECNewReputationLayout$scoreTV$2(this));
        this.d = LazyKt.lazy(new ECNewReputationLayout$levelTV$2(this));
        th.a.c(r2, 2131560387, this, true);
    }

    public /* synthetic */ ECNewReputationLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
