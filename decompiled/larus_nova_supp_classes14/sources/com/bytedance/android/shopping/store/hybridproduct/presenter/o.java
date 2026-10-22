package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.hybridproduct.dto.Position;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o extends QPresenter {
    public final ViewGroup e;

    public o(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "rootViewGroup");
        this.e = r2;
    }

    public final void A(QModel r17) {
        QModel r1 = r17;
        if ((r1 instanceof ej3.d) == true) goto L5;
        r1 = null;
    L5:
        ej3.d r2 = (ej3.d) r1;
        if (r2 != null) goto L8;
        return;
    L8:
        ViewGroup r3 = this.e;
        dj3.h r4 = r2.k;
        if (r4 == null) goto L13;
        Integer r5 = r4.b();
        if (r5 == null) goto L13;
        int r6 = com.bytedance.android.ec.hybrid.list.util.c.a;
        Integer r7 = Integer.valueOf(com.bytedance.android.ec.hybrid.list.util.c.d(r5));
    L14:
        int r8 = com.bytedance.android.shopping.extensions.k.f(r7);
        dj3.h r9 = r2.k;
        if (r9 == null) goto L19;
        Integer r10 = r9.d();
        if (r10 == null) goto L19;
        int r11 = com.bytedance.android.ec.hybrid.list.util.c.a;
        Integer r12 = Integer.valueOf(com.bytedance.android.ec.hybrid.list.util.c.d(r10));
    L20:
        int r13 = com.bytedance.android.shopping.extensions.k.f(r12);
        dj3.h r14 = r2.k;
        if (r14 == null) goto L25;
        Integer r15 = r14.c();
        if (r15 == null) goto L25;
        int r16 = com.bytedance.android.ec.hybrid.list.util.c.a;
        Integer r18 = Integer.valueOf(com.bytedance.android.ec.hybrid.list.util.c.d(r15));
    L26:
        int r19 = com.bytedance.android.shopping.extensions.k.f(r18);
        dj3.h r20 = r2.k;
        if (r20 == null) goto L31;
        Integer r21 = r20.a();
        if (r21 == null) goto L31;
        int r22 = com.bytedance.android.ec.hybrid.list.util.c.a;
        Integer r23 = Integer.valueOf(com.bytedance.android.ec.hybrid.list.util.c.d(r21));
    L32:
        r3.setPadding(r8, r13, r19, com.bytedance.android.shopping.extensions.k.f(r23));
        TextView r24 = (TextView) this.e.findViewById(2131380949);
        SimpleDraweeView r25 = this.e.findViewById(2131380947);
        String r26 = r2.b;
        boolean r110 = true;
        if (r26 != null) goto L35;
    L38:
        boolean r27 = true;
    L39:
        int r28 = 8;
        if (r27 == false) goto L42;
        int r29 = 8;
    L43:
        r24.setVisibility(r29);
        ECUrlModel r30 = r2.e;
        if (r30 == null) goto L46;
        List r31 = r30.getUrlList();
    L47:
        List r32 = r31;
        if (r32 != null) goto L50;
    L53:
        boolean r33 = true;
    L54:
        if (r33 == true) goto L57;
        r28 = 0;
    L57:
        r25.setVisibility(r28);
        r24.setText(r2.b);
        Integer r34 = r2.d;
        if (r34 == null) goto L60;
        float r35 = r34.intValue();
    L61:
        r24.setTextSize(r35);
        int r36 = com.bytedance.android.ec.core.utils.s.a;
        r24.setTextColor(com.bytedance.android.ec.core.utils.s.a(r2.c, -16777216));
        com.bytedance.android.ec.core.imagex.h0.d(r25, r2.e, null, null, null, null, null, 120);
        ViewGroup.LayoutParams r37 = r25.getLayoutParams();
        ECUrlModel r38 = r2.e;
        if (r38 == null) goto L64;
        Integer r39 = Integer.valueOf(r38.getHeight());
        int r40 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r111 = com.bytedance.android.ec.hybrid.list.util.c.d(r39);
    L65:
        r37.height = r111;
        ViewGroup.LayoutParams r41 = r25.getLayoutParams();
        ECUrlModel r42 = r2.e;
        if (r42 == null) goto L68;
        Integer r43 = Integer.valueOf(r42.getWidth());
        int r44 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r112 = com.bytedance.android.ec.hybrid.list.util.c.d(r43);
    L69:
        r41.width = r112;
        ViewGroup r45 = this.e;
        Double r46 = r2.a;
        if (r46 == null) goto L72;
        int r47 = com.bytedance.android.ec.hybrid.list.util.c.a;
        Integer r48 = Integer.valueOf(com.bytedance.android.ec.hybrid.list.util.c.d(r46));
    L73:
        int r49 = com.bytedance.android.shopping.extensions.k.f(r48);
        dj3.h r50 = r2.k;
        if (r50 == null) goto L78;
        Integer r51 = r50.d();
        if (r51 == null) goto L78;
        int r52 = com.bytedance.android.ec.hybrid.list.util.c.a;
        Integer r53 = Integer.valueOf(com.bytedance.android.ec.hybrid.list.util.c.d(r51));
    L79:
        int r54 = r49 + com.bytedance.android.shopping.extensions.k.f(r53);
        dj3.h r55 = r2.k;
        if (r55 == null) goto L84;
        Integer r56 = r55.a();
        if (r56 == null) goto L84;
        int r57 = com.bytedance.android.ec.hybrid.list.util.c.a;
        Integer r58 = Integer.valueOf(com.bytedance.android.ec.hybrid.list.util.c.d(r56));
    L85:
        wg.a.d(r45, r54 + com.bytedance.android.shopping.extensions.k.f(r58));
        ConstraintSet r59 = new ConstraintSet();
        ConstraintLayout r60 = this.e;
        if (r60 == null) goto L150;
        r59.clone(r60);
        Position r61 = r2.f;
        if (r61 != Position.LEFT) goto L95;
        r59.connect(2131380949, 6, 0, 6);
        r59.connect(2131380949, 7, 2131380947, 6);
        r59.connect(2131380947, 6, 2131380949, 7);
        r59.connect(2131380947, 7, 0, 7);
        r59.setHorizontalChainStyle(2131380949, 2);
        r59.centerVertically(2131380949, 0);
        r59.centerVertically(2131380947, 0);
        Double r62 = r2.g;
        if (r62 == null) goto L92;
        int r63 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r113 = com.bytedance.android.ec.hybrid.list.util.c.d(r62);
    L93:
        r59.setMargin(2131380947, 6, r113);
    L115:
        r59.applyTo(this.e);
        String r64 = r2.h;
        if (r64 != null) goto L118;
    L147:
        this.e.requestLayout();
        return;
    L118:
        if (r64.length() <= 0) goto L120;
        boolean r114 = true;
    L121:
        if (r114 != true) goto L147;
        if (r2.f != Position.BOTTOM) goto L147;
        TextView r65 = (TextView) this.e.findViewById(2131380948);
        r65.setText(r2.h);
        ExtensionsKt.visible(r65);
        dj3.l r66 = r2.j;
        if (r66 == null) goto L131;
        String r67 = r66.b();
        if (r67 == null) goto L131;
        Integer r68 = com.bytedance.android.ec.core.utils.s.b(r67);
        if (r68 == null) goto L131;
        r65.setTextColor(r68.intValue());
    L131:
        dj3.l r69 = r2.j;
        if (r69 == null) goto L136;
        Integer r70 = r69.a();
        if (r70 == null) goto L136;
        r65.setTextSize(r70.intValue());
    L136:
        Integer r71 = r2.i;
        if (r71 == null) goto L147;
        if (r71.intValue() > 0) goto L142;
        r110 = false;
    L142:
        if (r110 == false) goto L144;
        Integer r72 = r71;
    L145:
        if (r72 == null) goto L147;
        int r73 = r72.intValue();
        int r74 = com.bytedance.android.ec.hybrid.list.util.c.a;
        d2.f(r65, com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(r73)));
        goto L147
    L144:
        r72 = null;
        goto L145
    L120:
        r114 = false;
        goto L121
    L92:
        r113 = 0;
        goto L93
    L95:
        if (r61 != Position.RIGHT) goto L102;
        r59.connect(2131380947, 6, 0, 6);
        r59.connect(2131380947, 7, 2131380949, 6);
        r59.connect(2131380949, 6, 2131380947, 7);
        r59.connect(2131380949, 7, 0, 7);
        r59.setHorizontalChainStyle(2131380947, 2);
        r59.centerVertically(2131380949, 0);
        r59.centerVertically(2131380947, 0);
        Double r75 = r2.g;
        if (r75 == null) goto L99;
        int r76 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r115 = com.bytedance.android.ec.hybrid.list.util.c.d(r75);
    L100:
        r59.setMargin(2131380949, 6, r115);
        goto L115
    L99:
        r115 = 0;
        goto L100
    L102:
        if (r61 != Position.TOP) goto L109;
        r59.connect(2131380949, 3, 0, 3);
        r59.connect(2131380949, 4, 2131380947, 3);
        r59.connect(2131380947, 3, 2131380949, 4);
        r59.connect(2131380947, 4, 0, 4);
        r59.setVerticalChainStyle(2131380949, 2);
        r59.centerHorizontally(2131380949, 0);
        r59.centerHorizontally(2131380947, 0);
        Double r77 = r2.g;
        if (r77 == null) goto L106;
        int r78 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r116 = com.bytedance.android.ec.hybrid.list.util.c.d(r77);
    L107:
        r59.setMargin(2131380947, 3, r116);
        goto L115
    L106:
        r116 = 0;
        goto L107
    L109:
        if (r61 != Position.BOTTOM) goto L115;
        r59.connect(2131380947, 3, 0, 3);
        r59.connect(2131380949, 3, 2131380947, 4);
        r59.centerHorizontally(2131380949, 0);
        r59.centerHorizontally(2131380947, 0);
        Double r79 = r2.g;
        if (r79 == null) goto L113;
        int r80 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r117 = com.bytedance.android.ec.hybrid.list.util.c.d(r79);
    L114:
        r59.setMargin(2131380949, 3, r117);
        goto L115
    L113:
        r117 = 0;
        goto L114
    L150:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L84:
        r58 = null;
    L78:
        r53 = null;
        goto L79
    L72:
        r48 = null;
        goto L73
    L68:
        r112 = 0;
        goto L69
    L64:
        r111 = 0;
        goto L65
    L60:
        r35 = 0.0f;
        goto L61
    L50:
        if (r32.isEmpty() == true) goto L53;
        r33 = false;
        goto L54
    L46:
        r31 = null;
        goto L47
    L42:
        r29 = 0;
        goto L43
    L35:
        if (r26.length() == 0) goto L38;
        r27 = false;
    L31:
        r23 = null;
    L25:
        r18 = null;
    L19:
        r12 = null;
    L13:
        r7 = null;
        goto L14
    }
}
