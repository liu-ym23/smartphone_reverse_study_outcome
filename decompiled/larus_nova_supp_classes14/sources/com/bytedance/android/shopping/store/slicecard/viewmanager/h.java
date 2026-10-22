package com.bytedance.android.shopping.store.slicecard.viewmanager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.hybrid.tools.TransitionAnimationHelper;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.view.q;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends com.bytedance.android.ecom.arch.slice.render.elements.b<ECStoreCollapsibleTextView> {
    public boolean H3;

    public static final class a {
    }

    public static final class b implements ECStoreCollapsibleTextView.c {
        public final /* synthetic */ int a;

        public static final class a implements Runnable {
            public final /* synthetic */ TextView a;

            public a(TextView r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Lazy r0 = TransitionAnimationHelper.a;     // Catch: Throwable -> L4
                TextView r1 = this.a;     // Catch: Throwable -> L4
                TransitionAnimationHelper.e(r1, r1.getHeight() / 2, false);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView.c
        public final Drawable b() {
            return null;
        }

        public b(int r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView.c
        public final TextView c(ECStoreCollapsibleTextView r5) {
            Intrinsics.checkNotNullParameter(r5, "parentView");
            TextView r0 = new TextView(r5.getContext());
            LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-2, -2);
            r6.setMargins(0, 0, com.bytedance.android.shopping.extensions.b.b(12), 0);
            r0.setLayoutParams(r6);
            r0.setPadding(com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(4), com.bytedance.android.shopping.extensions.b.b(0), com.bytedance.android.shopping.extensions.b.b(4));
            r0.post(new a(r0));
            return r0;
        }

        @Override // com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView.c
        public final View d(ECStoreCollapsibleTextView r7) {
            Intrinsics.checkNotNullParameter(r7, "parentView");
            if (ECShopABSettings.getEC_SHOP_SEARCH_HINT_GRADIENT() == 1) goto L5;
            TextView r0 = new TextViewGradient(r7.getContext(), null, 0, this.a);
        L6:
            r0.setTextSize(2, 15.0f);
            LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(0), -2);
            r8.weight = 1.0f;
            r8.setMargins(0, 0, com.bytedance.android.shopping.extensions.b.b(8), 0);
            Unit r2 = Unit.INSTANCE;
            r0.setLayoutParams(r8);
            r0.setMaxLines(1);
            r0.setEllipsize(null);
            return r0;
        L5:
            r0 = new TextView(r7.getContext());
            goto L6
        }

        @Override // com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView.c
        public final void a(ECStoreCollapsibleTextView r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "view");
            Intrinsics.checkNotNullParameter(r1, "view");
        }
    }

    static {
    }

    public h(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.H3 = true;
    }

    public final void H0(Map<String, ? extends Object> r18) {
        Intrinsics.checkNotNullParameter(r18, "props");
        if (((ECStoreCollapsibleTextView) k1()) != null) goto L5;
        return;
    L5:
        dm.a.a("ShopScrollTextViewManager").a("onUpdateProp, props: " + r18);
        int r3 = s.a;
        Object r4 = r18.get("expand_backgroundColor");
        Object r5 = null;
        if ((r4 instanceof String) == true) goto L8;
        r4 = null;
    L8:
        Integer r6 = s.b((String) r4);
        boolean r7 = false;
        if (r6 == null) goto L11;
        int r8 = r6.intValue();
    L12:
        Object r9 = r18.get("collapse_backgroundColor");
        if ((r9 instanceof String) == true) goto L15;
        r9 = null;
    L15:
        Integer r10 = s.b((String) r9);
        if (r10 == null) goto L18;
        int r11 = r10.intValue();
    L19:
        Object r12 = r18.get("placeholder_color");
        if ((r12 instanceof String) == true) goto L22;
        r12 = null;
    L22:
        Integer r13 = s.b((String) r12);
        int r14 = -1;
        if (r13 == null) goto L25;
        int r15 = r13.intValue();
    L26:
        Object r16 = r18.get("placeholder_color");
        if ((r16 instanceof String) == true) goto L29;
        r16 = null;
    L29:
        Integer r17 = s.b((String) r16);
        if (r17 == null) goto L32;
        int r19 = r17.intValue();
    L33:
        Object r20 = r18.get("search_text_color");
        if ((r20 instanceof String) == true) goto L36;
        r20 = null;
    L36:
        Integer r21 = s.b((String) r20);
        if (r21 == null) goto L39;
        int r22 = r21.intValue();
    L40:
        Object r23 = r18.get("search_text_color");
        if ((r23 instanceof String) == true) goto L43;
        r23 = null;
    L43:
        Integer r24 = s.b((String) r23);
        if (r24 == null) goto L46;
        int r25 = r24.intValue();
    L47:
        Object r110 = r18.get("search_icon_color");
        if ((r110 instanceof String) == true) goto L50;
        r110 = null;
    L50:
        Integer r111 = s.b((String) r110);
        if (r111 == null) goto L53;
        int r112 = r111.intValue();
    L54:
        Object r113 = r18.get("search_icon_color");
        if ((r113 instanceof String) == true) goto L57;
        r113 = null;
    L57:
        Integer r114 = s.b((String) r113);
        if (r114 == null) goto L60;
        r14 = r114.intValue();
    L60:
        ECStoreCollapsibleTextView.b r115 = new ECStoreCollapsibleTextView.b(r8, r11, r15, r19, Integer.valueOf(r22), Integer.valueOf(r25), Integer.valueOf(r112), Integer.valueOf(r14));
        ECStoreCollapsibleTextView r26 = (ECStoreCollapsibleTextView) k1();
        if (r26 == null) goto L63;
        r26.setStyleConfig(r115);
    L63:
        Object r27 = r18.get("factor");
        if (r27 == null) goto L72;
        float r28 = com.bytedance.android.ecom.arch.slice.render.util.b.c(r27, 0.0f);
        dm.a.b r2 = dm.a.a("ShopScrollTextViewManager");
        StringBuilder r29 = new StringBuilder("测试一下滑动_factor: ");
        Object r30 = r18.get("factor");
        Intrinsics.checkNotNull(r30);
        r29.append(r30.getClass());
        r2.a(r29.toString());
        ECStoreCollapsibleTextView r31 = (ECStoreCollapsibleTextView) k1();
        if (r31 == null) goto L68;
        r31.h(1 - r28);
    L68:
        ECStoreCollapsibleTextView r32 = (ECStoreCollapsibleTextView) k1();
        if (r32 == null) goto L72;
        float r33 = 1 - r28;
        int r34 = ECStoreCollapsibleTextView.o;
        r32.j(r33, null);
    L72:
        if (this.H3 == false) goto L136;
        this.H3 = false;
        ECStoreCollapsibleTextView r35 = (ECStoreCollapsibleTextView) k1();
        if (r35 == null) goto L76;
        r35.setComponentCreator(new b(r15));
    L76:
        ECStoreCollapsibleTextView r36 = (ECStoreCollapsibleTextView) k1();
        if (r36 == null) goto L79;
        r36.setSearchIconSize(com.bytedance.android.shopping.extensions.b.b(16));
    L79:
        ECStoreCollapsibleTextView r37 = (ECStoreCollapsibleTextView) k1();
        if (r37 == null) goto L82;
        r37.setSearchIconMargin(com.bytedance.android.shopping.extensions.b.b(10));
    L82:
        ECStoreCollapsibleTextView r38 = (ECStoreCollapsibleTextView) k1();
        if (r38 == null) goto L85;
        r38.setSearchIconAlphaChangeAble(false);
    L85:
        ECStoreCollapsibleTextView r39 = (ECStoreCollapsibleTextView) k1();
        if (r39 == null) goto L90;
        SimpleDraweeView r40 = r39.c;
        if (r40 == null) goto L90;
        r40.setImageResource(2131247831);
    L90:
        ECStoreCollapsibleTextView r41 = (ECStoreCollapsibleTextView) k1();
        if (r41 == null) goto L101;
        Object r42 = r18.get("default_placeholder");
        if ((r42 instanceof String) == true) goto L95;
        r42 = null;
    L95:
        q r43 = r41.i((String) r42);
        r41.m = r43;
        r43.a(0.0f);
        View r44 = r41.f;
        if ((r44 instanceof TextView) == true) goto L98;
        r44 = null;
    L98:
        TextView r45 = (TextView) r44;
        if (r45 == null) goto L101;
        r45.setText(r41.m);
    L101:
        Object r46 = r18.get("show_search_buttons");
        if ((r46 instanceof Boolean) == true) goto L104;
        r46 = null;
    L104:
        Boolean r47 = (Boolean) r46;
        if (r47 == null) goto L107;
        r7 = r47.booleanValue();
    L107:
        if (r7 == false) goto L137;
        Lazy r48 = ECAppInfoService.a;
        if (we.a.a == true) goto L122;
        ECStoreCollapsibleTextView r49 = (ECStoreCollapsibleTextView) k1();
        if (r49 == null) goto L116;
        Object r50 = r18.get("camera_color");
        if ((r50 instanceof String) == true) goto L115;
        r50 = null;
    L115:
        r49.b(2131247832, s.b((String) r50));
    L116:
        ECStoreCollapsibleTextView r51 = (ECStoreCollapsibleTextView) k1();
        if (r51 == null) goto L122;
        Object r52 = r18.get("seperator_color");
        if ((r52 instanceof String) == true) goto L121;
        r52 = null;
    L121:
        r51.a(s.b((String) r52));
    L122:
        Object r1 = r18.get("search_text");
        if ((r1 instanceof String) == false) goto L126;
        r5 = r1;
    L126:
        String r53 = (String) r5;
        if (r53 != null) goto L129;
        r53 = "搜索";
    L129:
        ECStoreCollapsibleTextView r54 = (ECStoreCollapsibleTextView) k1();
        if (r54 == null) goto L132;
        r54.c(r53, true);
    L132:
        ECStoreCollapsibleTextView r55 = (ECStoreCollapsibleTextView) k1();
        if (r55 == null) goto L138;
        r55.setCollapseEnable(true);
        return;
    L138:
        return;
    L137:
        return;
    L136:
        return;
    L53:
        r112 = -1;
        goto L54
    L46:
        r25 = -1;
        goto L47
    L39:
        r22 = -1;
        goto L40
    L32:
        r19 = -1;
        goto L33
    L25:
        r15 = -1;
        goto L26
    L18:
        r11 = 0;
        goto L19
    L11:
        r8 = 0;
        goto L12
    }

    public final View n1(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        ECStoreCollapsibleTextView r0 = new ECStoreCollapsibleTextView(r4, null, 0);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return r0;
    }
}
