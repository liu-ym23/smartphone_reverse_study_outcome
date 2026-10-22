package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.business.IFindSameGoodsResponseWrapperDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.PicSearchGoodsData;
import com.bytedance.android.shopping.anchorv4.dto.business.PicSearchGoodsResponseWrapperDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.SameGoodsItem;
import com.bytedance.android.shopping.anchorv4.voavhs.head.CommonFindSameElement;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/AnchorV4FindSameView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/c;", "node", "", "update", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4FindSameView extends ConstraintLayout {
    public final SimpleDraweeView a;
    public final TextView b;
    public final ImageView c;
    public final ImageView d;
    public final ConstraintLayout e;
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.holder.e f;
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.d g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ AnchorV4FindSameView b;
        public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.head.c c;

        public b(TextView r1, AnchorV4FindSameView r2, com.bytedance.android.shopping.anchorv4.voavhs.head.c r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            com.bytedance.android.shopping.anchorv4.voavhs.head.holder.e r7 = this.b.f;
            Integer r0 = null;
            if (r7 == null) goto L21;
            com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r8 = r7.b;
            if (r8 == null) goto L21;
            com.bytedance.android.shopping.anchorv4.voavhs.head.c r1 = this.c;
            if (r1 == null) goto L13;
            CommonFindSameElement r2 = r1.r;
            if (r2 == null) goto L13;
            String r3 = r2.getSchema();
            if (r3 == null) goto L13;
            String r4 = com.bytedance.android.ec.core.btm.c.c(r3, this.a, "a1.b8094.c86220.d09040", new Pair[0]);
        L14:
            com.bytedance.android.shopping.anchorv4.voavhs.head.c r5 = this.c;
            if (r5 == null) goto L19;
            CommonFindSameElement r9 = r5.r;
            if (r9 == null) goto L19;
            Integer r10 = r9.getType();
        L20:
            r8.g(r4, null, r10);
        L19:
            r10 = null;
        L13:
            r4 = null;
        L21:
            com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r11 = this.b.g;
            if (r11 == null) goto L32;
            c63.d r12 = r11.t();
            if (r12 == null) goto L33;
            com.bytedance.android.shopping.anchorv4.voavhs.head.c r13 = this.c;
            if (r13 == null) goto L30;
            CommonFindSameElement r14 = r13.r;
            if (r14 == null) goto L30;
            r0 = r14.getType();
        L30:
            r12.m(3, 1, r0);
            return;
        L33:
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ AnchorV4FindSameView a;
        public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.head.c b;

        public c(AnchorV4FindSameView r1, com.bytedance.android.shopping.anchorv4.voavhs.head.c r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            com.bytedance.android.shopping.anchorv4.voavhs.head.holder.e r8 = this.a.f;
            Integer r1 = null;
            if (r8 == null) goto L17;
            com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r9 = r8.b;
            if (r9 == null) goto L17;
            CommonFindSameElement r2 = this.b.r;
            if (r2 == null) goto L11;
            String r3 = r2.getSchema();
            if (r3 == null) goto L11;
            String r4 = com.bytedance.android.ec.core.btm.c.c(r3, this.a, "a1.b8094.c86220.d09040", new Pair[0]);
        L12:
            com.bytedance.android.shopping.anchorv4.voavhs.head.c r5 = this.b;
            com.bytedance.android.shopping.anchorv4.dto.business.d r6 = r5.s;
            CommonFindSameElement r10 = r5.r;
            if (r10 == null) goto L15;
            Integer r11 = r10.getType();
        L16:
            r9.g(r4, r6, r11);
            goto L17
        L15:
            r11 = null;
        L11:
            r4 = null;
        L17:
            com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r12 = this.a.g;
            if (r12 == null) goto L26;
            c63.d r13 = r12.t();
            if (r13 == null) goto L27;
            CommonFindSameElement r14 = this.b.r;
            if (r14 == null) goto L24;
            r1 = r14.getType();
        L24:
            r13.m(3, 0, r1);
            return;
        L27:
            return;
        }
    }

    public static final class d<T> implements y.c {
        public final /* synthetic */ AnchorV4FindSameView a;

        public d(AnchorV4FindSameView r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.post(new g(this, (Bitmap) r3));
        }
    }

    static {
    }

    public AnchorV4FindSameView(Context r8) {
        this(r8, null, 0, null, null, 30);
    }

    public AnchorV4FindSameView(Context r8, AttributeSet r9) {
        this(r8, r9, 0, null, null, 28);
    }

    public AnchorV4FindSameView(Context r8, AttributeSet r9, int r10) {
        this(r8, r9, r10, null, null, 24);
    }

    public final void update(com.bytedance.android.shopping.anchorv4.voavhs.head.c r15) {
        Integer r0 = null;
        if (r15 == null) goto L5;
        com.bytedance.android.shopping.anchorv4.dto.business.d r1 = r15.s;
    L7:
        if ((r1 instanceof IFindSameGoodsResponseWrapperDTO) == true) goto L9;
        r1 = null;
    L9:
        IFindSameGoodsResponseWrapperDTO r2 = (IFindSameGoodsResponseWrapperDTO) r1;
        if (r2 == null) goto L12;
        List r3 = r2.getFeed();
    L13:
        if (r15 == null) goto L15;
        com.bytedance.android.shopping.anchorv4.dto.business.d r4 = r15.s;
    L17:
        if ((r4 instanceof PicSearchGoodsResponseWrapperDTO) == true) goto L19;
        r4 = null;
    L19:
        PicSearchGoodsResponseWrapperDTO r5 = (PicSearchGoodsResponseWrapperDTO) r4;
        if (r5 == null) goto L22;
        List r6 = r5.getBusinessData();
    L24:
        if (r3 == null) goto L26;
        int r7 = r3.size();
    L27:
        boolean r8 = true;
        if (r7 < 3) goto L30;
        boolean r9 = true;
    L31:
        if (r6 == null) goto L33;
        int r10 = r6.size();
    L34:
        if (r10 < 3) goto L36;
        boolean r11 = true;
    L37:
        if (r15 == null) goto L41;
        com.bytedance.android.shopping.anchorv4.dto.business.d r12 = r15.s;
        if (r12 == null) goto L41;
        Integer r13 = r12.getStatusCodeInt();
    L42:
        if (r13 != null) goto L45;
    L123:
        ConstraintLayout r14 = this.e;
        if (r14 == null) goto L126;
        List r16 = com.bytedance.commerce.base.view.b.a(r14);
    L127:
        if (r16 == null) goto L129;
        int r17 = r16.size();
    L130:
        if (r17 <= 3) goto L132;
        boolean r18 = true;
    L133:
        if (r18 == true) goto L136;
        r16 = null;
    L136:
        if (r16 == null) goto L143;
        List r19 = r16.subList(0, 4);
        if (r19 == null) goto L143;
        Iterator r20 = r19.iterator();
    L141:
        if (r20.hasNext() == false) goto L143;
        ((View) r20.next()).setVisibility(8);
    L143:
        SimpleDraweeView r21 = this.a;
        if (r15 == null) goto L150;
        CommonFindSameElement r22 = r15.r;
        if (r22 == null) goto L150;
        ImageModel r23 = r22.getDefaultImage();
        if (r23 == null) goto L150;
        ECUrlModel r24 = r23.getRemote();
    L151:
        y.a(r21, r24);
        ImageView r25 = this.d;
        if (r25 == null) goto L154;
        r25.setVisibility(0);
    L154:
        TextView r26 = this.b;
        if (r26 == null) goto L157;
        r26.setVisibility(0);
        r26.setOnClickListener(new b(r26, this, r15));
    L157:
        SimpleDraweeView r27 = this.a;
        if (r27 == null) goto L160;
        r27.setVisibility(0);
    L160:
        if (r15 == null) goto L166;
        CommonFindSameElement r28 = r15.r;
        if (r28 == null) goto L166;
        ImageModel r29 = r28.getDefaultImage();
        if (r29 == null) goto L166;
        ECUrlModel r30 = r29.getRemote();
    L167:
        y.l(r30, -1, -1, new d(this));
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r31 = this.g;
        if (r31 == null) goto L187;
        c63.d r32 = r31.t();
        if (r32 != null) goto L172;
        return;
    L172:
        if (r15 == null) goto L176;
        CommonFindSameElement r110 = r15.r;
        if (r110 == null) goto L176;
        r0 = r110.getType();
    L176:
        r32.G(3, 1, r0);
        return;
    L187:
        return;
    L166:
        r30 = null;
    L150:
        r24 = null;
        goto L151
    L132:
        r18 = false;
        goto L133
    L129:
        r17 = 0;
        goto L130
    L126:
        r16 = null;
        goto L127
    L45:
        if (r13.intValue() != 0) goto L123;
        if (r9 == true) goto L48;
        if (r11 == false) goto L123;
    L48:
        if (r3 != null) goto L50;
    L80:
        if (r6 != null) goto L82;
    L112:
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r33 = this.g;
        if (r33 == null) goto L120;
        c63.d r34 = r33.t();
        if (r34 == null) goto L120;
        CommonFindSameElement r35 = r15.r;
        if (r35 == null) goto L119;
        r0 = r35.getType();
    L119:
        r34.G(3, 0, r0);
    L120:
        ImageView r36 = this.c;
        if (r36 == null) goto L185;
        r36.setOnClickListener(new c(this, r15));
        return;
    L185:
        return;
    L82:
        if (r6.size() >= 3) goto L85;
        r8 = false;
    L85:
        if (r8 == true) goto L88;
        r6 = null;
    L88:
        if (r6 == null) goto L112;
        List r37 = r6.subList(0, 3);
        if (r37 == null) goto L112;
        Iterator r38 = r37.iterator();
        int r39 = 0;
    L93:
        if (r38.hasNext() == false) goto L112;
        Object r40 = r38.next();
        int r41 = r39 + 1;
        if (r39 >= 0) goto L97;
        CollectionsKt.throwIndexOverflow();
    L97:
        PicSearchGoodsData r111 = (PicSearchGoodsData) r40;
        ConstraintLayout r42 = this.e;
        if (r42 == null) goto L100;
        View r43 = r42.getChildAt(r39);
    L102:
        if ((r43 instanceof AnchorV4FindSameItemView) == true) goto L104;
        r43 = null;
    L104:
        AnchorV4FindSameItemView r44 = (AnchorV4FindSameItemView) r43;
        if (r44 == null) goto L111;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r45 = this.g;
        CommonFindSameElement r46 = r15.r;
        if (r46 == null) goto L109;
        Integer r112 = r46.getType();
    L110:
        r44.update(r39, r45, null, r111, r112);
        goto L111
    L109:
        r112 = null;
    L111:
        r39 = r41;
        goto L93
    L100:
        r43 = null;
        goto L102
    L50:
        if (r3.size() < 3) goto L52;
        boolean r47 = true;
    L53:
        if (r47 == true) goto L56;
        r3 = null;
    L56:
        if (r3 == null) goto L80;
        List r48 = r3.subList(0, 3);
        if (r48 == null) goto L80;
        Iterator r49 = r48.iterator();
        int r50 = 0;
    L61:
        if (r49.hasNext() == false) goto L80;
        Object r51 = r49.next();
        int r113 = r50 + 1;
        if (r50 >= 0) goto L65;
        CollectionsKt.throwIndexOverflow();
    L65:
        SameGoodsItem r114 = (SameGoodsItem) r51;
        ConstraintLayout r52 = this.e;
        if (r52 == null) goto L68;
        View r53 = r52.getChildAt(r50);
    L70:
        if ((r53 instanceof AnchorV4FindSameItemView) == true) goto L72;
        r53 = null;
    L72:
        AnchorV4FindSameItemView r54 = (AnchorV4FindSameItemView) r53;
        if (r54 == null) goto L79;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r55 = this.g;
        CommonFindSameElement r56 = r15.r;
        if (r56 == null) goto L77;
        Integer r115 = r56.getType();
    L78:
        r54.update(r50, r55, r114, null, r115);
        goto L79
    L77:
        r115 = null;
    L79:
        r50 = r113;
        goto L61
    L68:
        r53 = null;
        goto L70
    L52:
        r47 = false;
    L41:
        r13 = null;
        goto L42
    L36:
        r11 = false;
        goto L37
    L33:
        r10 = 0;
        goto L34
    L30:
        r9 = false;
        goto L31
    L26:
        r7 = 0;
        goto L27
    L22:
        r6 = null;
        goto L24
    L15:
        r4 = null;
        goto L17
    L12:
        r3 = null;
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4FindSameView(Context r3, AttributeSet r4, int r5, com.bytedance.android.shopping.anchorv4.voavhs.head.holder.e r6, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r8 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r8 & 16) == 0) goto L14;
        r7 = null;
    L14:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.f = r6;
        this.g = r7;
        ShoppingAsyncInflater.e.getClass();
        View r9 = ShoppingAsyncInflater.a.a(r3).aU(2131560493, this, true);
        if (s73.b.b() == false) goto L17;
        int r10 = g1.a;
        setBackgroundColor(g1.a.a(r3, 2131109391));
    L18:
        this.a = r9.findViewById(2131372539);
        this.b = (TextView) r9.findViewById(2131372540);
        this.c = (ImageView) r9.findViewById(2131372547);
        this.d = (ImageView) r9.findViewById(2131372538);
        this.e = r9.findViewById(2131362799);
        return;
    L17:
        int r11 = g1.a;
        setBackgroundColor(g1.a.a(r3, 2131105900));
        goto L18
    }
}
