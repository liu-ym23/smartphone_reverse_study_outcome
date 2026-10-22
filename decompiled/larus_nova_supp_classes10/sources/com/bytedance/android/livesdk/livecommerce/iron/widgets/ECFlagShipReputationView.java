package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.MetricAffectingSpan;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.livesdk.livecommerce.event.e2;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u000f\u0010B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/ECFlagShipReputationView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$d;", "authorReputation", "", "setReputationInfo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFlagShipReputationView extends ConstraintLayout {
    public final ECDraweeView a;
    public final ECDraweeView b;
    public final TextView c;
    public final ImageView d;

    public static final class a {
    }

    public static final class b extends MetricAffectingSpan {
        public final Typeface a;

        public b(Context r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            Typeface r5 = ECFontHelper.e.b("DouyinNumberABC", MonitorLevel.FATAL, true);
            if (r5 != null) goto L5;
            r5 = Typeface.DEFAULT;
        L5:
            this.a = r5;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            if (r2 == null) goto L5;
            r2.setTypeface(this.a);
            return;
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "textPaint");
            r2.setTypeface(this.a);
        }
    }

    static {
    }

    public ECFlagShipReputationView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECFlagShipReputationView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setReputationInfo(final ECPromotionList.d r13) {
        if (r13 != null) goto L6;
        setVisibility(8);
        return;
    L6:
        ECRitTag r1 = r13.shopTag;
        Long r2 = null;
        if (r1 == null) goto L16;
        ECUrlModel r3 = r1.getIconUrlModel();
        h0.d(this.a, r3, null, null, null, null, null, 120);
        if (r3 == null) goto L11;
        Integer r4 = Integer.valueOf(r3.getWidth());
    L12:
        if (r3 == null) goto L14;
        Integer r5 = Integer.valueOf(r3.getHeight());
    L15:
        R5(r4, r5, new ECFlagShipReputationView$setReputationInfo$$inlined$let$lambda$1(this, r13));
    L17:
        ECPromotionList.e r6 = r13.scoreContent;
        if (r6 == null) goto L52;
        h0.d(this.b, r6.background, null, null, null, null, null, 120);
        ECUrlModel r7 = r6.background;
        if (r7 == null) goto L22;
        Integer r8 = Integer.valueOf(r7.getWidth());
    L23:
        ECUrlModel r9 = r6.background;
        if (r9 == null) goto L26;
        Integer r10 = Integer.valueOf(r9.getHeight());
    L27:
        R5(r8, r10, new ECFlagShipReputationView$setReputationInfo$$inlined$let$lambda$2(this, r13));
        TextView r11 = this.c;
        int r12 = s.a;
        Integer r14 = s.b(r6.textColor);
        if (r14 == null) goto L30;
        int r15 = r14.intValue();
    L31:
        Long r16 = Long.valueOf(r6.fontSize);
        if (r16.longValue() <= 0) goto L34;
        boolean r17 = true;
    L35:
        if (r17 == false) goto L37;
        r2 = r16;
    L37:
        if (r2 == null) goto L39;
        float r18 = r2.longValue();
    L41:
        if (r13.score <= 0) goto L46;
        String r19 = r6.text;
        if (r19 != null) goto L45;
        r19 = "";
    L45:
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        b r20 = new b(getContext());
        AbsoluteSizeSpan r21 = new AbsoluteSizeSpan(UtilityKotlinExtentionsKt.d(Float.valueOf(r18)));
        ForegroundColorSpan r22 = new ForegroundColorSpan(r15);
        r0.append(r19);
        r0.setSpan(r21, 0, r0.length(), 18);
        r0.setSpan(r20, 0, r0.length(), 18);
        r0.setSpan(r22, 0, r0.length(), 18);
        this.d.setColorFilter(r15);
        r11.setText(r0);
        this.d.setVisibility(0);
    L51:
        setContentDescription(r6.text);
        goto L52
    L46:
        r11.setText(r6.text);
        r11.setTextSize(r18);
        r11.setTextColor(r15);
        if (r6.isBold == false) goto L49;
        Typeface r110 = Typeface.DEFAULT_BOLD;
    L50:
        r11.setTypeface(r110);
        this.d.setVisibility(8);
        goto L51
    L49:
        r110 = Typeface.DEFAULT;
        goto L50
    L39:
        r18 = 10.0f;
        goto L41
    L34:
        r17 = false;
        goto L35
    L30:
        int r23 = g1.a;
        r15 = g1.a.a(r11.getContext(), 2131101182);
        goto L31
    L26:
        r10 = null;
        goto L27
    L22:
        r8 = null;
    L52:
        new e2().k();
        return;
    L14:
        r5 = null;
        goto L15
    L11:
        r4 = null;
        goto L12
    L16:
        this.a.setVisibility(8);
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECFlagShipReputationView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        th.a.c(r2, 2131560702, this, true);
        this.a = findViewById(2131376604);
        this.b = findViewById(2131376576);
        this.c = (TextView) findViewById(2131391294);
        this.d = (ImageView) findViewById(2131376237);
    }

    public static void R5(Integer r3, Integer r4, Function2 r5) {
        int r0 = 0;
        if (r4 != null) goto L5;
    L16:
        r5.invoke(0, 0);
        return;
    L5:
        if (r4.intValue() == 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L16;
        float r6 = 16.0f / r4.intValue();
        if (r3 == null) goto L15;
        r0 = r3.intValue();
    L15:
        r5.invoke(Integer.valueOf(UtilityKotlinExtentionsKt.d(Float.valueOf(r6 * r0))), Integer.valueOf(UtilityKotlinExtentionsKt.d(Float.valueOf(16.0f))));
        return;
    L7:
        r2 = false;
        goto L8
    }

    public /* synthetic */ ECFlagShipReputationView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
