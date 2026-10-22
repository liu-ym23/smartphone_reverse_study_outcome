package com.bytedance.android.livesdk.linkvideo.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import java.text.DecimalFormat;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends me.drakeet.multitype.b<gf2.a, AnchorLinkVideoListViewHolder> {
    public static final float d = 0.0f;
    public static final int e = 0;
    public static final float f = 0.0f;
    public final boolean b;
    public final h c;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.linkvideo.view.a$a, reason: collision with other inner class name */
    public static final class C0059a {
    }

    static {
        d = UtilityKotlinExtentionsKt.h(1);
        e = 3;
        f = 1.3333334f;
    }

    public a(h r2) {
        this.b = false;
        this.c = r2;
    }

    public final void b(RecyclerView.ViewHolder r14, Object r15) {
        AnchorLinkVideoListViewHolder r16 = (AnchorLinkVideoListViewHolder) r14;
        gf2.a r17 = (gf2.a) r15;
        Intrinsics.checkNotNullParameter(r16, "holder");
        Intrinsics.checkNotNullParameter(r17, "item");
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "awemeVideo");
        h r0 = r16.f;
        if (r0 == null) goto L5;
        gf2.a r1 = r0.J9();
    L7:
        if (r16.e == false) goto L11;
        ImageView r2 = r16.b;
        if (r2 == null) goto L20;
        r2.setVisibility(8);
    L20:
        HSImageView r3 = r16.a;
        if (r3 == null) goto L25;
        GenericDraweeHierarchy r4 = r3.getHierarchy();
        if (r4 == null) goto L25;
        r4.setPlaceholderImage(2131108477);
    L25:
        ImageLoader.bindImage(r16.a, r17.a());
        TextView r5 = r16.d;
        if (r5 == null) goto L52;
        Long r6 = r17.c();
        if (r6 == null) goto L47;
        long r7 = r6.longValue();
        long r8 = 10000;
        if (r7 >= r8) goto L32;
        StringBuilder r9 = new StringBuilder();
        r9.append(r7);
        r9.append(' ');
        String r10 = r9.toString();
    L48:
        if (r10 == null) goto L51;
        r5.setText(StringsKt.trim(r10).toString());
        goto L52
    L51:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L32:
        long r11 = 99999999;
        if (r8 <= r7) goto L36;
    L41:
        long r12 = 100000000;
        if (r7 < r12) goto L47;
        if ((r7 / r12) < 1000) goto L46;
        r10 = ((int) Math.ceil(r7 / ((double) 100000000))) + " 亿";
        goto L48
    L46:
        DecimalFormat r13 = new DecimalFormat();
        r13.setMaximumFractionDigits(1);
        r10 = r13.format(r7 / ((double) 100000000)) + " 亿";
        goto L48
    L36:
        if (r11 < r7) goto L41;
        if ((r7 / r8) < 1000) goto L40;
        r10 = ((int) Math.ceil(r7 / ((double) 10000))) + " 万";
        goto L48
    L40:
        DecimalFormat r18 = new DecimalFormat();
        r18.setMaximumFractionDigits(1);
        r10 = r18.format(r7 / ((double) 10000)) + " 万";
    L47:
        r10 = "";
    L52:
        ImageView r19 = r16.b;
        if (r19 == null) goto L55;
        r19.setOnClickListener(new c(r16, r1, r17));
    L55:
        View r20 = r16.c;
        if (r20 == null) goto L58;
        r20.setOnClickListener(new d(r16, r1, r17));
    L58:
        HSImageView r21 = r16.a;
        if (r21 == null) goto L61;
        Object r22 = r21.getParent();
    L63:
        if ((r22 instanceof View) == true) goto L65;
        r22 = null;
    L65:
        View r23 = (View) r22;
        if (r23 != null) goto L68;
        return;
    L68:
        if (r17.a == false) goto L70;
        r23.setAlpha(0.5f);
        r23.setOnClickListener(null);
        return;
    L70:
        r23.setAlpha(1.0f);
        r23.setOnClickListener(new b(r16, r17));
        return;
    L61:
        r22 = null;
        goto L63
    L11:
        if (r1 != null) goto L13;
    L17:
        ImageView r24 = r16.b;
        if (r24 == null) goto L20;
        r24.setBackgroundResource(2131253238);
        goto L20
    L13:
        if (Intrinsics.areEqual(r1.b(), r17.b()) == false) goto L17;
        ImageView r25 = r16.b;
        if (r25 == null) goto L20;
        r25.setBackgroundResource(2131253237);
        goto L20
    L5:
        r1 = null;
        goto L7
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        View r6 = r4.inflate(2131566693, r5, false);
        if (PadConfigUtils.c() == false) goto L5;
        float r7 = s1.f(484.0f) * 0.75f;
        float r0 = 3.0f;
    L6:
        int r8 = (int) (r7 / r0);
        int r1 = (int) (r8 * f);
        r6.getLayoutParams().width = r8;
        r6.getLayoutParams().height = r1;
        View r2 = r6.findViewById(2131375721);
        if (r2 == null) goto L11;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L11;
        r3.width = r8;
    L11:
        if (r2 == null) goto L16;
        ViewGroup.LayoutParams r9 = r2.getLayoutParams();
        if (r9 == null) goto L16;
        r9.height = r1;
    L16:
        return new AnchorLinkVideoListViewHolder(r6, this.b, this.c);
    L5:
        float r10 = s1.y();
        int r11 = e;
        r7 = r10 - ((r11 - 1) * d);
        r0 = r11;
        goto L6
    }
}
