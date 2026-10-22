package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/IronListHeaderReputationLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IronListHeaderReputationLayout extends LinearLayout {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final ImageView d;
    public final TextView e;

    public IronListHeaderReputationLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IronListHeaderReputationLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public IronListHeaderReputationLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        th.a.c(r2, 2131560770, this, true);
        this.a = (TextView) findViewById(2131390182);
        this.b = (TextView) findViewById(2131390181);
        this.c = (TextView) findViewById(2131390179);
        this.d = (ImageView) findViewById(2131376553);
        this.e = (TextView) findViewById(2131390180);
    }

    public final void a(final ECPromotionList.d r11, final Map<String, String> r12, final gi2.a r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r12 != null) goto L6;
    L9:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L106;
        TextView r3 = this.a;
        if (r3 == null) goto L15;
        r3.setText(r11.text);
    L15:
        TextView r4 = this.a;
        if (r4 == null) goto L18;
        r4.setTypeface(Typeface.defaultFromStyle(1));
    L18:
        TextView r5 = this.a;
        if (r5 == null) goto L21;
        r5.setTextColor(th.a.a(getContext(), 2131101625));
    L21:
        int r6 = r11.level;
        int r7 = 8;
        if (1 <= r6) goto L25;
    L77:
        TextView r8 = this.b;
        if (r8 == null) goto L80;
        r8.setVisibility(8);
    L80:
        TextView r9 = this.c;
        if (r9 == null) goto L83;
        r9.setVisibility(8);
    L83:
        ImageView r10 = this.d;
        if (r10 == null) goto L94;
        hh2.g r14 = hh2.f.a.a;
        if (r14 == null) goto L90;
        Boolean r15 = r14.a();
        if (r15 == null) goto L90;
        boolean r16 = r15.booleanValue();
    L91:
        if (r16 == false) goto L93;
        r7 = 0;
    L93:
        r10.setVisibility(r7);
    L90:
        r16 = true;
    L94:
        TextView r17 = this.e;
        if (r17 == null) goto L97;
        r17.setVisibility(0);
    L97:
        TextView r18 = this.e;
        if (r18 == null) goto L100;
        r18.setTextColor(th.a.a(getContext(), 2131105982));
    L100:
        TextView r19 = this.e;
        if (r19 == null) goto L103;
        r19.setTypeface(Typeface.defaultFromStyle(1));
    L103:
        com.bytedance.android.ec.core.widget.f.c(this, null, "bind_key_live_promotion_list", new IronListHeaderReputationLayout$bindData$2(this, r12, r11, r13), 1);
        f.b(false, this, r12, r11, r13);
        return;
    L25:
        if (3 < r6) goto L77;
        if (r11.score == 0.0d) goto L77;
        TextView r20 = this.b;
        if (r20 == null) goto L31;
        r20.setVisibility(0);
    L31:
        TextView r21 = this.c;
        if (r21 == null) goto L34;
        r21.setVisibility(0);
    L34:
        ImageView r22 = this.d;
        if (r22 == null) goto L46;
        hh2.g r23 = hh2.f.a.a;
        if (r23 == null) goto L41;
        Boolean r24 = r23.a();
        if (r24 == null) goto L41;
        boolean r25 = r24.booleanValue();
    L42:
        if (r25 == false) goto L44;
        int r26 = 0;
    L45:
        r22.setVisibility(r26);
        goto L46
    L44:
        r26 = 8;
    L41:
        r25 = true;
    L46:
        TextView r27 = this.e;
        if (r27 == null) goto L49;
        r27.setVisibility(8);
    L49:
        TextView r28 = this.b;
        if (r28 == null) goto L52;
        StringCompanionObject r29 = StringCompanionObject.INSTANCE;
        r28.setText(String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r11.score)}, 1)));
    L52:
        Integer[] r30 = {2131101672, 2131101595, 2131101546};
        Integer[] r31 = {2131896347, 2131896349, 2131896348};
        int r32 = r11.level - 1;
        int r33 = getResources().getColor(new Integer[]{2131101672, 2131101595, 2131101546}[r32].intValue());
        TextView r34 = this.b;
        if (r34 == null) goto L55;
        r34.setTextColor(ContextCompat.getColor(getContext(), r30[r32].intValue()));
    L55:
        TextView r35 = this.c;
        if (r35 == null) goto L58;
        r35.setText(getResources().getString(r31[r32].intValue()));
    L58:
        TextView r36 = this.c;
        if (r36 == null) goto L61;
        r36.setTextColor(r33);
    L61:
        Typeface r37 = ECFontHelper.e.b("DouyinNumberABC", MonitorLevel.FATAL, true);
        if (r37 == null) goto L66;
        TextView r38 = this.b;
        if (r38 == null) goto L66;
        r38.setTypeface(r37);
    L66:
        TextView r39 = this.c;
        if (r39 == null) goto L69;
        r39.setTypeface(Typeface.defaultFromStyle(1));
    L69:
        ImageView r40 = this.d;
        if (r40 == null) goto L73;
        r40.setColorFilter(2131101621);
    L73:
        if (r13 != null) goto L75;
        gi2.a r41 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L76:
        new v("livesdk_influence_entrance_show", r41).i(null);
        goto L103
    L75:
        r41 = r13;
        goto L76
    L106:
        return;
    L6:
        if (r12.isEmpty() == true) goto L9;
        r2 = false;
        goto L10
    }

    public /* synthetic */ IronListHeaderReputationLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
