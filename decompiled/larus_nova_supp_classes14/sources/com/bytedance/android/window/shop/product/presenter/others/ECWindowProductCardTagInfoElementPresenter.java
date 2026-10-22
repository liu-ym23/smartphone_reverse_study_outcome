package com.bytedance.android.window.shop.product.presenter.others;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.utils.window.WindowAutoCleanResourceCache;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.GenericDraweeView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yo.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowProductCardTagInfoElementPresenter extends i<WindowV2ProductItemVO> implements View.OnClickListener {
    public final List<d<? extends View>> l;
    public final Lazy m;

    public static final class a extends com.bytedance.android.ec.window.base.utils.window.c<ECDraweeView> {
        public a() {
            super(1);
        }
    }

    public static final class b extends com.bytedance.android.ec.window.base.utils.window.c<TextView> {
        public b() {
            super(1);
        }
    }

    public static final class c extends com.bytedance.android.ec.window.base.utils.window.c<TextView> {
        public c() {
            super(1);
        }
    }

    public static final class d<V extends View> {
        public final Class<V> a;
        public final int b;
        public final int c;
        public final int d;
        public final com.bytedance.android.ec.window.base.utils.window.c<V> e;
        public final int f;
        public final int g;
        public final int h;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof d) == false) goto L22;
            d r4 = (d) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
            return false;
        L16:
            if (this.f == r4.f) goto L18;
            return false;
        L18:
            if (this.g == r4.g) goto L20;
            return false;
        L20:
            if (this.h == r4.h) goto L34;
            return false;
        L34:
            return true;
        L22:
            return false;
        }

        public final int hashCode() {
            Class<V> r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = ((((((r2 * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
            com.bytedance.android.ec.window.base.utils.window.c<V> r4 = this.e;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return ((((((r3 + r1) * 31) + this.f) * 31) + this.g) * 31) + this.h;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "TagParam(clazz=" + this.a + ", viewId=" + this.b + ", layoutResId=" + this.c + ", tagType=" + this.d + ", viewPool=" + this.e + ", marginLeft=" + this.f + ", marginTop=" + this.g + ", viewHeight=" + this.h + ")";
        }

        public d(Class<V> r2, int r3, int r4, int r5, com.bytedance.android.ec.window.base.utils.window.c<V> r6, int r7, int r8, int r9) {
            Intrinsics.checkNotNullParameter(r2, "clazz");
            Intrinsics.checkNotNullParameter(r6, "viewPool");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }
    }

    public ECWindowProductCardTagInfoElementPresenter(Fragment r23) {
        Intrinsics.checkNotNullParameter(r23, "fragment");
        super(r23);
        ConcurrentHashMap r3 = WindowAutoCleanResourceCache.c;
        ECWindowProductCardTagInfoElementPresenter$textPoolFragmentCache$1 r5 = ECWindowProductCardTagInfoElementPresenter$textPoolFragmentCache$1.INSTANCE;
        this.l = CollectionsKt.listOf(new d[]{new d(ECDraweeView.class, 2131371326, 2131561052, 4, (com.bytedance.android.ec.window.base.utils.window.c) WindowAutoCleanResourceCache.a.a(a.class, r23, ECWindowProductCardTagInfoElementPresenter$imagePoolFragmentCache$1.INSTANCE).a(ECWindowProductCardTagInfoElementPresenter$tagParams$1.INSTANCE), 0, 0, -2), new d(TextView.class, 2131370983, 2131561047, 1, (com.bytedance.android.ec.window.base.utils.window.c) WindowAutoCleanResourceCache.a.a(b.class, r23, r5).a(ECWindowProductCardTagInfoElementPresenter$tagParams$2.INSTANCE), 0, 0, -2), new d(TextView.class, 2131370984, 2131561053, 2, (com.bytedance.android.ec.window.base.utils.window.c) WindowAutoCleanResourceCache.a.a(c.class, r23, r5).a(ECWindowProductCardTagInfoElementPresenter$tagParams$3.INSTANCE), com.bytedance.android.window.shop.holder.d.a(10), com.bytedance.android.window.shop.holder.d.a(10), com.bytedance.android.window.shop.holder.d.a(18))});
        this.m = LazyKt.lazy(new ECWindowProductCardTagInfoElementPresenter$tagWrapper$2(this));
    }

    public final void d0(WindowV2ProductItemVO r14) {
        if ((r14 instanceof tq3.c) == true) goto L5;
        return;
    L5:
        List<WindowV2ProductItemDTO.WindowCardHeaderLabelInfo> r15 = ((tq3.c) r14).S;
        FrameLayout r0 = (FrameLayout) this.m.getValue();
        if (r0 == null) goto L35;
        int r1 = r0.getChildCount();
        int r4 = 0;
    L8:
        if (r4 >= r1) goto L32;
        FrameLayout r5 = (FrameLayout) this.m.getValue();
        if (r5 == null) goto L31;
        View r6 = r5.getChildAt(r4);
        if (r6 == null) goto L31;
        Iterator<T> r7 = this.l.iterator();
    L16:
        if (r7.hasNext() == false) goto L23;
        Object r8 = r7.next();
        if (((d) r8).b != r6.getId()) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == false) goto L16;
    L25:
        if ((r8 instanceof d) == true) goto L27;
        r8 = null;
    L27:
        d r10 = (d) r8;
        if (r10 == null) goto L31;
        r10.e.b(r6);
        goto L31
    L20:
        r9 = false;
        goto L21
    L23:
        r8 = null;
    L31:
        r4 = r4 + 1;
        goto L8
    L32:
        FrameLayout r2 = (FrameLayout) this.m.getValue();
        if (r2 == null) goto L35;
        r2.removeAllViews();
    L35:
        Iterator<T> r3 = this.l.iterator();
    L37:
        if (r3.hasNext() == false) goto L151;
        final d r11 = (d) r3.next();
        if (r15 == null) goto L60;
        List<WindowV2ProductItemDTO.WindowCardHeaderLabelInfo> r12 = r15;
        if ((r12 instanceof Collection) == true) goto L43;
    L45:
        Iterator<T> r13 = r12.iterator();
    L47:
        if (r13.hasNext() == false) goto L57;
        Integer r16 = ((WindowV2ProductItemDTO.WindowCardHeaderLabelInfo) r13.next()).getType();
        int r17 = r11.d;
        if (r16 != null) goto L52;
    L54:
        boolean r18 = false;
    L55:
        if (r18 == false) goto L47;
        boolean r19 = true;
    L58:
        if (r19 != true) goto L60;
        boolean r20 = true;
    L61:
        if (r20 == false) goto L37;
        if (Intrinsics.areEqual(r11.a, TextView.class) == false) goto L93;
        if (r15 == null) goto L93;
        ArrayList r21 = new ArrayList();
        Iterator<T> r22 = r15.iterator();
    L68:
        if (r22.hasNext() == false) goto L78;
        Object r23 = r22.next();
        Integer r24 = ((WindowV2ProductItemDTO.WindowCardHeaderLabelInfo) r23).getType();
        int r110 = r11.d;
        if (r24 != null) goto L73;
    L75:
        boolean r25 = false;
    L76:
        if (r25 == false) goto L68;
        r21.add(r23);
        goto L68
    L73:
        if (r24.intValue() != r110) goto L75;
        r25 = true;
        goto L76
    L78:
        Iterator r26 = r21.iterator();
    L80:
        if (r26.hasNext() == false) goto L93;
        WindowV2ProductItemDTO.WindowCardHeaderLabelInfo r27 = (WindowV2ProductItemDTO.WindowCardHeaderLabelInfo) r26.next();
        TextView r28 = (TextView) r11.e.a(new ECWindowProductCardTagInfoElementPresenter$getTargetTextView$textView$1(this, r11));
        FrameLayout r29 = (FrameLayout) this.m.getValue();
        if (r29 == null) goto L84;
        r29.addView(r28);
    L84:
        ViewGroup.LayoutParams r30 = r28.getLayoutParams();
        if (r30 == null) goto L91;
        FrameLayout.LayoutParams r31 = (FrameLayout.LayoutParams) r30;
        r31.width = -2;
        r31.height = r11.h;
        r31.leftMargin = r11.f;
        r31.topMargin = r11.g;
        if (r27.c() == null) goto L88;
        r28.setText(r27.c());
        r28.setVisibility(0);
        goto L80
    L88:
        r28.setVisibility(8);
        goto L80
    L91:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L93:
        if (Intrinsics.areEqual(r11.a, ECDraweeView.class) == false) goto L37;
        if (r15 == null) goto L37;
        ArrayList r32 = new ArrayList();
        Iterator<T> r33 = r15.iterator();
    L97:
        if (r33.hasNext() == false) goto L107;
        Object r34 = r33.next();
        Integer r35 = ((WindowV2ProductItemDTO.WindowCardHeaderLabelInfo) r34).getType();
        int r111 = r11.d;
        if (r35 != null) goto L102;
    L104:
        boolean r36 = false;
    L105:
        if (r36 == false) goto L97;
        r32.add(r34);
        goto L97
    L102:
        if (r35.intValue() != r111) goto L104;
        r36 = true;
        goto L105
    L107:
        Iterator r37 = r32.iterator();
    L109:
        if (r37.hasNext() == false) goto L37;
        WindowV2ProductItemDTO.WindowCardHeaderLabelInfo r38 = (WindowV2ProductItemDTO.WindowCardHeaderLabelInfo) r37.next();
        GenericDraweeView r39 = (ECDraweeView) r11.e.a(new ECWindowProductCardTagInfoElementPresenter$getTargetImageView$draweeView$1(this, r11));
        FrameLayout r40 = (FrameLayout) this.m.getValue();
        if (r40 == null) goto L113;
        r40.addView(r39);
    L113:
        WindowV2ProductItemDTO.WindowCardHeaderLabelInfo.ImageLabel r41 = r38.b();
        if (r41 == null) goto L116;
        ECUrlModel r112 = r41.b();
    L117:
        if (r112 == null) goto L118;
        ViewGroup.LayoutParams r113 = r39.getLayoutParams();
        if ((r113 instanceof FrameLayout.LayoutParams) == true) goto L122;
        r113 = null;
    L122:
        FrameLayout.LayoutParams r114 = (FrameLayout.LayoutParams) r113;
        if (r114 == null) goto L141;
        r114.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r112.getWidth()));
        r114.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r112.getHeight()));
        r114.gravity = r38.b().a();
        WindowV2ProductItemDTO.WindowCardHeaderLabelInfo.b r115 = r41.c();
        if (r115 == null) goto L127;
        int r116 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r115.b()));
    L128:
        r114.leftMargin = r116;
        WindowV2ProductItemDTO.WindowCardHeaderLabelInfo.b r117 = r41.c();
        if (r117 == null) goto L131;
        int r118 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r117.d()));
    L132:
        r114.topMargin = r118;
        WindowV2ProductItemDTO.WindowCardHeaderLabelInfo.b r119 = r41.c();
        if (r119 == null) goto L135;
        int r120 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r119.c()));
    L136:
        r114.rightMargin = r120;
        WindowV2ProductItemDTO.WindowCardHeaderLabelInfo.b r42 = r41.c();
        if (r42 == null) goto L139;
        int r43 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r42.a()));
    L140:
        r114.bottomMargin = r43;
        Unit r44 = Unit.INSTANCE;
        r39.setLayoutParams(r114);
        goto L141
    L139:
        r43 = 0;
        goto L140
    L135:
        r120 = 0;
        goto L136
    L131:
        r118 = 0;
        goto L132
    L127:
        r116 = 0;
    L141:
        y.a(r39, r112);
        r39.setVisibility(0);
        String r45 = r38.d();
        if (r45 != null) goto L144;
    L147:
        boolean r46 = true;
    L148:
        if (r46 == true) goto L149;
        r39.setOnClickListener(new com.bytedance.android.window.shop.product.presenter.others.a(this, r38));
        goto L109
    L149:
        r39.setOnClickListener(null);
        r39.setClickable(false);
        goto L109
    L144:
        if (StringsKt.isBlank(r45) == true) goto L147;
        r46 = false;
        goto L148
    L118:
        r39.setVisibility(8);
        goto L109
    L116:
        r112 = null;
        goto L117
    L52:
        if (r16.intValue() != r17) goto L54;
        r18 = true;
    L57:
        r19 = false;
        goto L58
    L43:
        if (r12.isEmpty() == false) goto L45;
    L60:
        r20 = false;
        goto L61
    }
}
