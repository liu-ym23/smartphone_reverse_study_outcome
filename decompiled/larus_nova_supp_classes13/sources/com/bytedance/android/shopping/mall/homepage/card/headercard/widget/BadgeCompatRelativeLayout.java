package com.bytedance.android.shopping.mall.homepage.card.headercard.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import androidx.core.util.Pools;
import com.bytedance.android.shopping.api.mall.MallPreloadState;
import com.bytedance.android.shopping.buynow.data.model.TTPayCode;
import com.bytedance.android.shopping.sameproduct.viewmodel.SameProductViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@RemoteViews.RemoteView
public class BadgeCompatRelativeLayout extends ViewGroup {
    public static final int[] o = null;
    public static final int[] p = null;
    public View a;
    public int b;
    public final Rect c;
    public final Rect d;
    public int e;
    public boolean f;
    public View[] g;
    public View[] h;
    public final a i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        @ViewDebug.ExportedProperty(category = "layout", indexMapping = {@ViewDebug.IntToString(from = 2, to = "above"), @ViewDebug.IntToString(from = 4, to = "alignBaseline"), @ViewDebug.IntToString(from = 8, to = "alignBottom"), @ViewDebug.IntToString(from = 5, to = "alignLeft"), @ViewDebug.IntToString(from = 12, to = "alignParentBottom"), @ViewDebug.IntToString(from = TTPayCode.IS_PAY_PROGRESS, to = "alignParentLeft"), @ViewDebug.IntToString(from = 11, to = "alignParentRight"), @ViewDebug.IntToString(from = 10, to = "alignParentTop"), @ViewDebug.IntToString(from = 7, to = "alignRight"), @ViewDebug.IntToString(from = SameProductViewModel.INTERNAL_FEED_PAGE_SIZE, to = "alignTop"), @ViewDebug.IntToString(from = 3, to = "below"), @ViewDebug.IntToString(from = 14, to = "centerHorizontal"), @ViewDebug.IntToString(from = 13, to = "center"), @ViewDebug.IntToString(from = 15, to = "centerVertical"), @ViewDebug.IntToString(from = 0, to = "leftOf"), @ViewDebug.IntToString(from = 1, to = "rightOf"), @ViewDebug.IntToString(from = 18, to = "alignStart"), @ViewDebug.IntToString(from = 19, to = "alignEnd"), @ViewDebug.IntToString(from = 20, to = "alignParentStart"), @ViewDebug.IntToString(from = 21, to = "alignParentEnd"), @ViewDebug.IntToString(from = 16, to = "startOf"), @ViewDebug.IntToString(from = 17, to = "endOf")}, mapping = {@ViewDebug.IntToString(from = MallPreloadState.FAILED, to = "true"), @ViewDebug.IntToString(from = 0, to = "false/NO_ID")}, resolveId = true)
        public final int[] a;
        public final int[] b;
        public int c;
        public int d;
        public int e;
        public int f;
        public boolean g;
        public boolean h;
        public final boolean i;

        @ViewDebug.ExportedProperty(category = "layout")
        public final boolean j;

        public LayoutParams(LayoutParams r6) {
            super(r6);
            int[] r1 = new int[22];
            this.a = r1;
            int[] r2 = new int[22];
            this.b = r2;
            this.h = false;
            this.i = false;
            this.i = r6.i;
            this.h = r6.h;
            this.j = r6.j;
            System.arraycopy(r6.a, 0, r1, 0, 22);
            System.arraycopy(r6.b, 0, r2, 0, 22);
        }

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        public final void resolveLayoutDirection(int r19) {
            if (this.g == true) goto L21;
            int[] r2 = this.b;
            if (r2[16] == 0) goto L7;
        L18:
            boolean r3 = true;
        L19:
            if (r3 == true) goto L21;
        L25:
            boolean r4 = false;
        L27:
            if (r4 == false) goto L122;
            if (r19 != 1) goto L30;
            char r5 = 1;
        L31:
            System.arraycopy(this.b, 0, this.a, 0, 22);
            char r12 = 7;
            char r13 = 11;
            if (this.i == false) goto L69;
            int[] r6 = this.a;
            int r11 = r6[18];
            if (r11 != 0) goto L36;
        L39:
            int r7 = r6[19];
            if (r7 != 0) goto L42;
        L45:
            int r8 = r6[16];
            if (r8 != 0) goto L48;
        L51:
            int r9 = r6[17];
            if (r9 != 0) goto L54;
        L57:
            int r10 = r6[20];
            if (r10 != 0) goto L60;
        L63:
            int r14 = r6[21];
            if (r14 != 0) goto L66;
        L121:
            this.h = false;
            this.g = false;
            goto L122
        L66:
            if (r6[11] != 0) goto L68;
            r6[11] = r14;
        L68:
            r6[21] = 0;
            goto L121
        L60:
            if (r6[9] != 0) goto L62;
            r6[9] = r10;
        L62:
            r6[20] = 0;
            goto L63
        L54:
            if (r6[1] != 0) goto L56;
            r6[1] = r9;
        L56:
            r6[17] = 0;
            goto L57
        L48:
            if (r6[0] != 0) goto L50;
            r6[0] = r8;
        L50:
            r6[16] = 0;
            goto L51
        L42:
            if (r6[7] != 0) goto L44;
            r6[7] = r7;
        L44:
            r6[19] = 0;
            goto L45
        L36:
            if (r6[5] != 0) goto L38;
            r6[5] = r11;
        L38:
            r6[18] = 0;
            goto L39
        L69:
            int[] r15 = this.a;
            int r16 = r15[18];
            if (r16 != 0) goto L74;
            if (r15[19] != 0) goto L74;
        L78:
            if (r16 == 0) goto L83;
            if (r5 == 0) goto L81;
            char r17 = 7;
        L82:
            r15[r17] = r16;
            r15[18] = 0;
            goto L83
        L81:
            r17 = 5;
        L83:
            int r18 = r15[19];
            if (r18 == 0) goto L88;
            if (r5 == 0) goto L87;
            r12 = 5;
        L87:
            r15[r12] = r18;
            r15[19] = 0;
        L88:
            int r20 = r15[16];
            if (r20 != 0) goto L93;
            if (r15[17] != 0) goto L93;
        L97:
            if (r20 == 0) goto L99;
            r15[r5] = r20;
            r15[16] = 0;
        L99:
            int r21 = r15[17];
            if (r21 == 0) goto L102;
            r15[r5 ^ 1] = r21;
            r15[17] = 0;
        L102:
            int r22 = r15[20];
            if (r22 != 0) goto L107;
            if (r15[21] != 0) goto L107;
        L111:
            if (r22 == 0) goto L116;
            if (r5 == 0) goto L114;
            char r23 = 11;
        L115:
            r15[r23] = r22;
            r15[20] = 0;
            goto L116
        L114:
            r23 = '\t';
        L116:
            int r24 = r15[21];
            if (r24 == 0) goto L121;
            if (r5 == 0) goto L120;
            r13 = '\t';
        L120:
            r15[r13] = r24;
            r15[21] = 0;
        L107:
            if (r15[9] == 0) goto L109;
        L110:
            r15[9] = 0;
            r15[11] = 0;
            goto L111
        L109:
            if (r15[11] == 0) goto L111;
        L93:
            if (r15[0] == 0) goto L95;
        L96:
            r15[0] = 0;
            r15[1] = 0;
            goto L97
        L95:
            if (r15[1] == 0) goto L97;
        L74:
            if (r15[5] == 0) goto L76;
        L77:
            r15[5] = 0;
            r15[7] = 0;
            goto L78
        L76:
            if (r15[7] == 0) goto L78;
        L30:
            r5 = 0;
        L122:
            super.resolveLayoutDirection(r19);
            return;
        L7:
            if (r2[17] != 0) goto L18;
            if (r2[18] != 0) goto L18;
            if (r2[19] != 0) goto L18;
            if (r2[20] != 0) goto L18;
            if (r2[21] != 0) goto L18;
            r3 = false;
        L21:
            if (this.h == false) goto L23;
        L26:
            r4 = true;
            goto L27
        L23:
            if (r19 == getLayoutDirection()) goto L25;
            goto L25
        }

        public LayoutParams(ViewGroup.LayoutParams r2) {
            super(r2);
            this.a = new int[22];
            this.b = new int[22];
            this.h = false;
            this.i = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r2) {
            super(r2);
            this.a = new int[22];
            this.b = new int[22];
            this.h = false;
            this.i = false;
        }

        public LayoutParams(Context r18, AttributeSet r19) {
            super(r18, r19);
            int[] r2 = new int[22];
            this.a = r2;
            int[] r3 = new int[22];
            this.b = r3;
            this.h = false;
            this.i = false;
            TypedArray r5 = r18.obtainStyledAttributes(r19, new int[]{2130972375, 2130972376, 2130972377, 2130972378, 2130972379, 2130972380, 2130972381, 2130972382, 2130972383, 2130972384, 2130972385, 2130972386, 2130972388, 2130972389, 2130972390, 2130972395, 2130972396, 2130972397, 2130972398, 2130972485, 2130972486, 2130972487, 2130972488});
            int r8 = 1;
            if (r18.getApplicationInfo().targetSdkVersion >= 17) goto L5;
        L8:
            boolean r6 = true;
        L9:
            this.i = r6;
            int r7 = r5.getIndexCount();
            int r9 = 0;
        L10:
            if (r9 >= r7) goto L113;
            int r10 = r5.getIndex(r9);
            if (r10 != 14) goto L15;
            this.j = r5.getBoolean(r10, false);
        L112:
            r9 = r9 + 1;
            r8 = 1;
            goto L10
        L15:
            if (r10 != 20) goto L18;
            r2[0] = r5.getResourceId(r10, 0);
            goto L112
        L18:
            if (r10 != 21) goto L21;
            r2[r8] = r5.getResourceId(r10, 0);
            goto L112
        L21:
            if (r10 != 0) goto L24;
            r2[2] = r5.getResourceId(r10, 0);
            goto L112
        L24:
            if (r10 != 15) goto L27;
            r2[3] = r5.getResourceId(r10, 0);
            goto L112
        L27:
            if (r10 != r8) goto L30;
            r2[4] = r5.getResourceId(r10, 0);
            goto L112
        L30:
            if (r10 != 4) goto L33;
            r2[5] = r5.getResourceId(r10, 0);
            goto L112
        L33:
            if (r10 != 13) goto L36;
            r2[6] = r5.getResourceId(r10, 0);
            goto L112
        L36:
            if (r10 != 11) goto L39;
            r2[7] = r5.getResourceId(r10, 0);
            goto L112
        L39:
            if (r10 != 2) goto L41;
            r2[8] = r5.getResourceId(r10, 0);
            goto L112
        L41:
            int r16 = -1;
            if (r10 != 7) goto L49;
            if (r5.getBoolean(r10, false) == true) goto L47;
            r16 = 0;
        L47:
            r2[9] = r16;
            goto L112
        L49:
            if (r10 == 10) goto L51;
            if (r10 != 8) goto L62;
            if (r5.getBoolean(r10, false) == true) goto L60;
            r16 = 0;
        L60:
            r2[11] = r16;
            goto L112
        L62:
            if (r10 == 5) goto L64;
            if (r10 != 17) goto L75;
            if (r5.getBoolean(r10, false) == true) goto L73;
            r16 = 0;
        L73:
            r2[13] = r16;
            goto L112
        L75:
            if (r10 != 16) goto L82;
            if (r5.getBoolean(r10, false) == true) goto L80;
            r16 = 0;
        L80:
            r2[14] = r16;
            goto L112
        L82:
            if (r10 != 18) goto L89;
            if (r5.getBoolean(r10, false) == false) goto L86;
            char r1 = 15;
        L87:
            r2[r1] = r16;
            goto L112
        L86:
            r1 = 15;
            r16 = 0;
            goto L87
        L89:
            if (r10 != 22) goto L92;
            r2[16] = r5.getResourceId(r10, 0);
            goto L112
        L92:
            if (r10 != 19) goto L94;
            r2[17] = r5.getResourceId(r10, 0);
            goto L112
        L94:
            if (r10 != 12) goto L97;
            r2[18] = r5.getResourceId(r10, 0);
            goto L112
        L97:
            if (r10 != 3) goto L99;
            r2[19] = r5.getResourceId(r10, 0);
            goto L112
        L99:
            if (r10 != 9) goto L106;
            if (r5.getBoolean(r10, false) == false) goto L103;
            char r4 = 20;
        L104:
            r2[r4] = r16;
            goto L112
        L103:
            r4 = 20;
            r16 = 0;
            goto L104
        L106:
            if (r10 != 6) goto L112;
            if (r5.getBoolean(r10, false) == false) goto L110;
            char r11 = 21;
        L111:
            r2[r11] = r16;
            goto L112
        L110:
            r11 = 21;
            r16 = 0;
            goto L111
        L64:
            if (r5.getBoolean(r10, false) == true) goto L67;
            r16 = 0;
        L67:
            r2[12] = r16;
            goto L112
        L51:
            if (r5.getBoolean(r10, false) == true) goto L54;
            r16 = 0;
        L54:
            r2[10] = r16;
            goto L112
        L113:
            this.h = true;
            System.arraycopy(r2, 0, r3, 0, 22);
            r5.recycle();
            return;
        L5:
            if ((r18.getApplicationInfo().flags & 4194304) != 4194304) goto L8;
            r6 = false;
            goto L9
        }

        public final void a(int r3, int r4) {
            if (this.g == false) goto L5;
        L24:
            this.a[r3] = r4;
            this.b[r3] = r4;
            this.h = true;
            return;
        L5:
            if (r3 != 16) goto L7;
        L18:
            boolean r0 = true;
        L19:
            if (r0 == false) goto L24;
            if (this.b[r3] == 0) goto L24;
            if (r4 != 0) goto L24;
            this.g = true;
            goto L24
        L7:
            if (r3 == 17) goto L18;
            if (r3 == 18) goto L18;
            if (r3 == 19) goto L18;
            if (r3 == 20) goto L18;
            if (r3 == 21) goto L18;
            r0 = false;
            goto L19
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.a = new int[22];
            this.b = new int[22];
            this.h = false;
            this.i = false;
        }
    }

    public static class a {
        public final ArrayList<C0100a> a;
        public final SparseArray<C0100a> b;
        public final ArrayDeque<C0100a> c;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.card.headercard.widget.BadgeCompatRelativeLayout$a$a, reason: collision with other inner class name */
        public static class C0100a {
            public static final Pools.SynchronizedPool<C0100a> d = null;
            public View a;
            public final ArrayMap<C0100a, a> b;
            public final SparseArray<C0100a> c;

            static {
                d = new Pools.SynchronizedPool(100);
            }

            public C0100a() {
                this.b = new ArrayMap();
                this.c = new SparseArray();
            }
        }

        public a() {
            this.a = new ArrayList();
            this.b = new SparseArray();
            this.c = new ArrayDeque();
        }

        public final void a(View[] r13, int... r14) {
            SparseArray<C0100a> r0 = this.b;
            ArrayList<C0100a> r1 = this.a;
            int r2 = r1.size();
            int r4 = 0;
        L3:
            if (r4 >= r2) goto L5;
            C0100a r5 = (C0100a) ListProtector.get(r1, r4);
            r5.b.clear();
            r5.c.clear();
            r4 = r4 + 1;
            goto L3
        L5:
            int r6 = 0;
        L6:
            if (r6 >= r2) goto L27;
            C0100a r7 = (C0100a) ListProtector.get(r1, r6);
            int[] r8 = ((LayoutParams) r7.a.getLayoutParams()).a;
            int r9 = r14.length;
            int r10 = 0;
        L8:
            if (r10 >= r9) goto L26;
            int r11 = r8[r14[r10]];
            if (r11 > 0) goto L20;
            int[] r12 = BadgeCompatRelativeLayout.o;
            if (r11 != (-1)) goto L14;
        L18:
            boolean r15 = false;
        L19:
            if (r15 == true) goto L20;
        L25:
            r10 = r10 + 1;
            goto L8
        L14:
            if (((-16777216) & r11) == 0) goto L18;
            if ((16711680 & r11) == 0) goto L18;
            r15 = true;
        L20:
            C0100a r16 = r0.get(r11);
            if (r16 == null) goto L25;
            if (r16 == r7) goto L25;
            r16.b.put(r7, this);
            r7.c.put(r11, r16);
            goto L25
        L26:
            r6 = r6 + 1;
            goto L6
        L27:
            ArrayDeque<C0100a> r17 = this.c;
            r17.clear();
            int r3 = 0;
        L28:
            if (r3 >= r2) goto L33;
            C0100a r18 = (C0100a) ListProtector.get(r1, r3);
            if (r18.c.size() != 0) goto L32;
            r17.addLast(r18);
        L32:
            r3 = r3 + 1;
            goto L28
        L33:
            int r19 = 0;
        L34:
            C0100a r20 = r17.pollLast();
            if (r20 == null) goto L44;
            View r21 = r20.a;
            int r22 = r21.getId();
            int r23 = r19 + 1;
            r13[r19] = r21;
            ArrayMap<C0100a, a> r24 = r20.b;
            int r25 = r24.size();
            int r26 = 0;
        L37:
            if (r26 >= r25) goto L42;
            C0100a r27 = r24.keyAt(r26);
            SparseArray<C0100a> r28 = r27.c;
            r28.remove(r22);
            if (r28.size() != 0) goto L41;
            r17.add(r27);
        L41:
            r26 = r26 + 1;
            goto L37
        L42:
            r19 = r23;
            goto L34
        L44:
            if (r19 < r13.length) goto L47;
            return;
        L47:
            throw new IllegalStateException("Circular dependencies cannot exist in RelativeLayout");
        }
    }

    static {
        o = new int[]{2, 3, 4, 6, 8};
        p = new int[]{0, 1, 5, 7, 16, 17, 18, 19};
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return BadgeCompatRelativeLayout.class.getName();
    }

    @Override // android.view.View
    public int getBaseline() {
        View r0 = this.a;
        if (r0 == null) goto L6;
        return r0.getBaseline();
    L6:
        return super.getBaseline();
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        this.f = true;
    }

    public int getGravity() {
        return this.b;
    }

    public int getIgnoreGravity() {
        return this.e;
    }

    public BadgeCompatRelativeLayout(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        if ((r2 instanceof LayoutParams) == false) goto L7;
        return new LayoutParams((LayoutParams) r2);
    L7:
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r2);
    L11:
        return new LayoutParams(r2);
    }

    public void setAllowChildHorizontalBeyond(boolean r1) {
        this.l = r1;
    }

    public void setAllowChildVerticalBeyond(boolean r1) {
        this.m = r1;
    }

    public void setGravity(int r2) {
        if (this.b != r2) goto L5;
        return;
    L5:
        if ((8388615 & r2) != 0) goto L8;
        r2 = r2 | 8388611;
    L8:
        if ((r2 & 112) != 0) goto L10;
        r2 = r2 | 48;
    L10:
        this.b = r2;
        requestLayout();
    }

    public void setHorizontalGravity(int r3) {
        int r4 = r3 & 8388615;
        int r1 = this.b;
        if ((8388615 & r1) == r4) goto L6;
        this.b = r4 | ((-8388616) & r1);
        requestLayout();
        return;
    }

    public void setIgnoreAlignMarginForLeftRightOf(boolean r1) {
        this.n = r1;
    }

    public void setIgnoreGravity(int r1) {
        this.e = r1;
    }

    public void setVerticalGravity(int r3) {
        int r4 = r3 & 112;
        int r0 = this.b;
        if ((r0 & 112) == r4) goto L6;
        this.b = r4 | (r0 & (-113));
        requestLayout();
        return;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    public BadgeCompatRelativeLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final View b(int[] r4, int r5) {
        int r6 = r4[r5];
        if (r6 == 0) goto L18;
        a.C0100a r7 = this.i.b.get(r6);
        if (r7 != null) goto L7;
        return null;
    L7:
        View r8 = r7.a;
    L9:
        if (r8.getVisibility() != 8) goto L17;
        LayoutParams r1 = (LayoutParams) r8.getLayoutParams();
        r1.resolveLayoutDirection(r8.getLayoutDirection());
        int[] r2 = r1.a;
        a.C0100a r3 = this.i.b.get(r2[r5]);
        if (r3 == null) goto L16;
        View r9 = r3.a;
        if (r8 == r9) goto L16;
        r8 = r9;
    L16:
        return null;
    L17:
        return r8;
    L18:
        return null;
    }

    public final LayoutParams c(int[] r1, int r2) {
        View r3 = b(r1, r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        if ((r3.getLayoutParams() instanceof LayoutParams) == true) goto L7;
        return null;
    L7:
        return (LayoutParams) r3.getLayoutParams();
    }

    @Override // android.view.View
    public final void onMeasure(int r46, int r47) {
        int r13 = 0;
        if (this.f == false) goto L27;
        this.f = false;
        int r0 = getChildCount();
        View[] r1 = this.h;
        if (r1 != null) goto L7;
    L8:
        this.h = new View[r0];
    L9:
        View[] r2 = this.g;
        if (r2 != null) goto L12;
    L13:
        this.g = new View[r0];
    L14:
        a r3 = this.i;
        ArrayList<a.C0100a> r4 = r3.a;
        int r5 = r4.size();
        int r6 = 0;
    L15:
        if (r6 >= r5) goto L17;
        a.C0100a r7 = (a.C0100a) ListProtector.get(r4, r6);
        r7.a = null;
        r7.b.clear();
        r7.c.clear();
        a.C0100a.d.release(r7);
        r6 = r6 + 1;
        goto L15
    L17:
        r4.clear();
        r3.b.clear();
        r3.c.clear();
        int r8 = 0;
    L18:
        if (r8 >= r0) goto L26;
        View r9 = getChildAt(r8);
        int r10 = r9.getId();
        a.C0100a r11 = (a.C0100a) a.C0100a.d.acquire();
        if (r11 != null) goto L22;
        r11 = new a.C0100a();
    L22:
        r11.a = r9;
        if (r10 == (-1)) goto L25;
        r3.b.put(r10, r11);
    L25:
        r3.a.add(r11);
        r8 = r8 + 1;
        goto L18
    L26:
        r3.a(this.h, o);
        r3.a(this.g, p);
        goto L27
    L12:
        if (r2.length == r0) goto L14;
    L7:
        if (r1.length == r0) goto L9;
    L27:
        int r12 = View.MeasureSpec.getMode(r46);
        int r14 = View.MeasureSpec.getMode(r47);
        int r15 = View.MeasureSpec.getSize(r46);
        int r16 = View.MeasureSpec.getSize(r47);
        if (r12 == 0) goto L30;
        int r17 = r15;
    L31:
        if (r14 == 0) goto L33;
        int r18 = r16;
    L35:
        if (r12 != 1073741824) goto L37;
        int r19 = r17;
    L38:
        if (r14 != 1073741824) goto L40;
        int r110 = r18;
    L41:
        int r20 = this.b;
        int r21 = 8388615 & r20;
        int r22 = 1;
        if (r21 == 8388611) goto L45;
        if (r21 == 0) goto L45;
        boolean r111 = true;
    L46:
        int r23 = r20 & 112;
        if (r23 == 48) goto L50;
        if (r23 == 0) goto L50;
        boolean r112 = true;
    L51:
        if (r111 == true) goto L53;
        if (r112 == true) goto L53;
    L56:
        View r24 = null;
    L57:
        if (r12 == 1073741824) goto L59;
        boolean r25 = true;
    L60:
        if (r14 == 1073741824) goto L62;
        boolean r26 = true;
    L63:
        int r27 = getLayoutDirection();
        View[] r28 = this.g;
        int r29 = r28.length;
        int r30 = 0;
        boolean r210 = false;
    L64:
        int r31 = 8;
        if (r30 >= r29) goto L168;
        View r113 = r28[r30];
        if (r113.getVisibility() == 8) goto L166;
        LayoutParams r32 = (LayoutParams) r113.getLayoutParams();
        r32.resolveLayoutDirection(r27);
        int[] r33 = r32.a;
        r32.c = Integer.MIN_VALUE;
        r32.e = Integer.MIN_VALUE;
        LayoutParams r34 = c(r33, r13);
        if (r34 == null) goto L76;
        if (this.n == true) goto L73;
        int r35 = ((ViewGroup.MarginLayoutParams) r34).leftMargin;
    L74:
        r32.e = r34.c - (r35 + ((ViewGroup.MarginLayoutParams) r32).rightMargin);
    L81:
        LayoutParams r36 = c(r33, r22);
        if (r36 == null) goto L89;
        if (this.n == true) goto L86;
        int r37 = ((ViewGroup.MarginLayoutParams) r36).rightMargin;
    L87:
        r32.c = r36.e + (r37 + ((ViewGroup.MarginLayoutParams) r32).leftMargin);
    L93:
        LayoutParams r38 = c(r33, 5);
        if (r38 == null) goto L97;
        r32.c = r38.c + ((ViewGroup.MarginLayoutParams) r32).leftMargin;
    L101:
        LayoutParams r39 = c(r33, 7);
        if (r39 == null) goto L105;
        r32.e = r39.e - ((ViewGroup.MarginLayoutParams) r32).rightMargin;
    L111:
        if (r33[9] == 0) goto L114;
        r32.c = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r32).leftMargin;
    L114:
        if (r33[11] == 0) goto L117;
        if (r17 < 0) goto L117;
        r32.e = (r17 - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r32).rightMargin;
    L117:
        boolean r40 = this.l;
        if ((r113 instanceof BadgeView) == false) goto L120;
        boolean r41 = true;
    L121:
        int r114 = r30;
        int r211 = r29;
        View[] r212 = r28;
        int r310 = r27;
        View r311 = r24;
        int r42 = a(r32.c, r32.e, ((ViewGroup.MarginLayoutParams) r32).width, ((ViewGroup.MarginLayoutParams) r32).leftMargin, ((ViewGroup.MarginLayoutParams) r32).rightMargin, getPaddingLeft(), getPaddingRight(), r17, r41);
        if (r18 >= 0) goto L131;
        if (this.j == true) goto L131;
        int r43 = ((ViewGroup.MarginLayoutParams) r32).height;
        if (r43 < 0) goto L128;
        int r44 = View.MeasureSpec.makeMeasureSpec(r43, 1073741824);
    L139:
        r34.measure(r42, r44);
        r32.resolveLayoutDirection(getLayoutDirection());
        int[] r45 = r32.a;
        int r48 = r32.c;
        if (r48 != Integer.MIN_VALUE) goto L144;
        int r49 = r32.e;
        if (r49 == Integer.MIN_VALUE) goto L144;
        r32.c = r49 - r113.getMeasuredWidth();
    L161:
        if (r45[21] == 0) goto L163;
    L162:
        boolean r50 = true;
    L164:
        if (r50 == false) goto L167;
        r210 = true;
    L167:
        r30 = r114 + 1;
        r29 = r211;
        r28 = r212;
        r27 = r310;
        r24 = r311;
        r22 = 1;
        r13 = 0;
        goto L64
    L163:
        r50 = false;
    L144:
        if (r48 != Integer.MIN_VALUE) goto L146;
    L148:
        if (r48 != Integer.MIN_VALUE) goto L161;
        if (r32.e != Integer.MIN_VALUE) goto L161;
        if (r45[13] == 0) goto L154;
    L157:
        if (r25 == true) goto L159;
        int r51 = r34.getMeasuredWidth();
        int r52 = (r17 - r51) / 2;
        r32.c = r52;
        r32.e = r52 + r51;
        goto L162
    L159:
        int r53 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r32).leftMargin;
        r32.c = r53;
        r32.e = r53 + r34.getMeasuredWidth();
        goto L162
    L154:
        if (r45[14] != 0) goto L157;
        int r54 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r32).leftMargin;
        r32.c = r54;
        r32.e = r54 + r34.getMeasuredWidth();
        goto L161
    L146:
        if (r32.e != Integer.MIN_VALUE) goto L148;
        r32.e = r48 + r34.getMeasuredWidth();
        goto L161
    L128:
        r44 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L131:
        if (this.k == false) goto L133;
        int r55 = Math.max(0, (((r18 - getPaddingTop()) - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r32).topMargin) - ((ViewGroup.MarginLayoutParams) r32).bottomMargin);
    L135:
        if (((ViewGroup.MarginLayoutParams) r32).height != (-1)) goto L137;
        int r56 = 1073741824;
    L138:
        r44 = View.MeasureSpec.makeMeasureSpec(r55, r56);
        goto L139
    L137:
        r56 = Integer.MIN_VALUE;
        goto L138
    L133:
        r55 = Math.max(0, r18);
        goto L135
    L120:
        r41 = r40;
        goto L121
    L105:
        if (r32.j == false) goto L111;
        if (r33[7] == 0) goto L111;
        if (r17 < 0) goto L111;
        r32.e = (r17 - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r32).rightMargin;
        goto L111
    L97:
        if (r32.j == false) goto L101;
        if (r33[5] == 0) goto L101;
        r32.c = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r32).leftMargin;
        goto L101
    L86:
        r37 = 0;
        goto L87
    L89:
        if (r32.j == false) goto L93;
        if (r33[r22] == 0) goto L93;
        r32.c = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r32).leftMargin;
        goto L93
    L73:
        r35 = 0;
        goto L74
    L76:
        if (r32.j == false) goto L81;
        if (r33[r13] == 0) goto L81;
        if (r17 < 0) goto L81;
        r32.e = (r17 - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r32).rightMargin;
        goto L81
    L166:
        r114 = r30;
        r211 = r29;
        r212 = r28;
        r310 = r27;
        r311 = r24;
        goto L167
    L168:
        int r312 = r27;
        View r313 = r24;
        View[] r115 = this.h;
        int r116 = r115.length;
        int r117 = getContext().getApplicationInfo().targetSdkVersion;
        int r57 = r19;
        int r314 = r110;
        int r58 = 0;
        int r59 = Integer.MIN_VALUE;
        int r60 = Integer.MIN_VALUE;
        int r61 = Integer.MAX_VALUE;
        int r62 = Integer.MAX_VALUE;
        boolean r118 = false;
    L170:
        if (r58 >= r116) goto L283;
        View r63 = r115[r58];
        if (r63.getVisibility() == r31) goto L281;
        LayoutParams r64 = (LayoutParams) r63.getLayoutParams();
        int r65 = r63.getBaseline();
        int[] r66 = r64.a;
        int r213 = r57;
        View r67 = b(r66, 4);
        if (r67 == null) goto L180;
        int r315 = r58;
        int r68 = r67.getBaseline();
        int r316 = r59;
        if (r68 != (-1)) goto L178;
    L181:
        int r69 = -1;
        int r70 = -1;
    L182:
        if (r70 == r69) goto L186;
        if (r65 == r69) goto L185;
        r70 = r70 - r65;
    L185:
        r64.d = r70;
        r64.f = Integer.MIN_VALUE;
    L227:
        boolean r71 = this.l;
        if ((r63 instanceof BadgeView) == false) goto L230;
        boolean r214 = true;
    L231:
        int r317 = r60;
        int r318 = r61;
        View[] r410 = r115;
        int r215 = r315;
        int r72 = r316;
        int r216 = r116;
        int r119 = r62;
        int r411 = r17;
        r63.measure(a(r64.c, r64.e, ((ViewGroup.MarginLayoutParams) r64).width, ((ViewGroup.MarginLayoutParams) r64).leftMargin, ((ViewGroup.MarginLayoutParams) r64).rightMargin, getPaddingLeft(), getPaddingRight(), r17, r214), a(r64.d, r64.f, ((ViewGroup.MarginLayoutParams) r64).height, ((ViewGroup.MarginLayoutParams) r64).topMargin, ((ViewGroup.MarginLayoutParams) r64).bottomMargin, getPaddingTop(), getPaddingBottom(), r18, this.m));
        int[] r73 = r64.a;
        int r74 = r64.d;
        if (r74 != Integer.MIN_VALUE) goto L236;
        int r75 = r64.f;
        if (r75 == Integer.MIN_VALUE) goto L236;
        r64.d = r75 - r63.getMeasuredHeight();
    L253:
        if (r73[12] == 0) goto L255;
    L254:
        boolean r76 = true;
    L256:
        if (r76 == false) goto L258;
        boolean r77 = true;
    L260:
        if (r25 == false) goto L264;
        if (r117 >= 19) goto L263;
        int r78 = Math.max(r213, r64.e);
    L265:
        if (r26 == false) goto L270;
        if (r117 >= 19) goto L268;
        r314 = Math.max(r314, r64.f);
        goto L270
    L268:
        r314 = Math.max(r314, r64.f + ((ViewGroup.MarginLayoutParams) r64).bottomMargin);
    L270:
        View r79 = r313;
        if (r63 != r79) goto L275;
        if (r112 == true) goto L275;
        int r80 = r119;
        r61 = r318;
    L276:
        if (r63 != r79) goto L280;
        if (r111 == true) goto L280;
        int r81 = r80;
        r57 = r78;
        r118 = r77;
        r60 = r317;
        r59 = r72;
    L282:
        r58 = r215 + 1;
        r313 = r79;
        r62 = r81;
        r116 = r216;
        r115 = r410;
        r17 = r411;
        r31 = 8;
    L280:
        r59 = Math.max(r72, r64.e + ((ViewGroup.MarginLayoutParams) r64).rightMargin);
        r60 = Math.max(r317, r64.f + ((ViewGroup.MarginLayoutParams) r64).bottomMargin);
        r81 = r80;
        r57 = r78;
        r118 = r77;
    L275:
        r80 = Math.min(r119, r64.c - ((ViewGroup.MarginLayoutParams) r64).leftMargin);
        r61 = Math.min(r318, r64.d - ((ViewGroup.MarginLayoutParams) r64).topMargin);
        goto L276
    L263:
        r78 = Math.max(r213, r64.e + ((ViewGroup.MarginLayoutParams) r64).rightMargin);
        goto L265
    L264:
        r78 = r213;
        goto L265
    L258:
        r77 = r118;
        goto L260
    L255:
        r76 = false;
    L236:
        if (r74 != Integer.MIN_VALUE) goto L238;
    L240:
        if (r74 != Integer.MIN_VALUE) goto L253;
        if (r64.f != Integer.MIN_VALUE) goto L253;
        if (r73[13] == 0) goto L246;
    L249:
        if (r26 == true) goto L251;
        int r82 = r63.getMeasuredHeight();
        int r84 = (r18 - r82) / 2;
        r64.d = r84;
        r64.f = r84 + r82;
        goto L254
    L251:
        int r85 = getPaddingTop() + ((ViewGroup.MarginLayoutParams) r64).topMargin;
        r64.d = r85;
        r64.f = r85 + r63.getMeasuredHeight();
        goto L254
    L246:
        if (r73[15] != 0) goto L249;
        int r86 = getPaddingTop() + ((ViewGroup.MarginLayoutParams) r64).topMargin;
        r64.d = r86;
        r64.f = r86 + r63.getMeasuredHeight();
        goto L253
    L238:
        if (r64.f != Integer.MIN_VALUE) goto L240;
        r64.f = r74 + r63.getMeasuredHeight();
        goto L253
    L230:
        r214 = r71;
        goto L231
    L186:
        r64.d = Integer.MIN_VALUE;
        r64.f = Integer.MIN_VALUE;
        LayoutParams r87 = c(r66, 2);
        if (r87 == null) goto L190;
        r64.f = r87.d - (((ViewGroup.MarginLayoutParams) r87).topMargin + ((ViewGroup.MarginLayoutParams) r64).bottomMargin);
    L195:
        LayoutParams r88 = c(r66, 3);
        if (r88 == null) goto L199;
        r64.d = r88.f + (((ViewGroup.MarginLayoutParams) r88).bottomMargin + ((ViewGroup.MarginLayoutParams) r64).topMargin);
    L203:
        LayoutParams r89 = c(r66, 6);
        if (r89 == null) goto L207;
        r64.d = r89.d + ((ViewGroup.MarginLayoutParams) r64).topMargin;
    L211:
        LayoutParams r90 = c(r66, 8);
        if (r90 == null) goto L215;
        r64.f = r90.f - ((ViewGroup.MarginLayoutParams) r64).bottomMargin;
    L221:
        if (r66[10] == 0) goto L224;
        r64.d = getPaddingTop() + ((ViewGroup.MarginLayoutParams) r64).topMargin;
    L224:
        if (r66[12] == 0) goto L227;
        if (r18 < 0) goto L227;
        r64.f = (r18 - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r64).bottomMargin;
        goto L227
    L215:
        if (r64.j == false) goto L221;
        if (r66[8] == 0) goto L221;
        if (r18 < 0) goto L221;
        r64.f = (r18 - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r64).bottomMargin;
        goto L221
    L207:
        if (r64.j == false) goto L211;
        if (r66[6] == 0) goto L211;
        r64.d = getPaddingTop() + ((ViewGroup.MarginLayoutParams) r64).topMargin;
        goto L211
    L199:
        if (r64.j == false) goto L203;
        if (r66[3] == 0) goto L203;
        r64.d = getPaddingTop() + ((ViewGroup.MarginLayoutParams) r64).topMargin;
        goto L203
    L190:
        if (r64.j == false) goto L195;
        if (r66[2] == 0) goto L195;
        if (r18 < 0) goto L195;
        r64.f = (r18 - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r64).bottomMargin;
        goto L195
    L178:
        if ((r67.getLayoutParams() instanceof LayoutParams) == false) goto L181;
        r70 = r68 + ((LayoutParams) r67.getLayoutParams()).d;
        r69 = -1;
        goto L182
    L180:
        r315 = r58;
        r316 = r59;
        goto L181
    L281:
        r215 = r58;
        r81 = r62;
        r410 = r115;
        r216 = r116;
        r411 = r17;
        r79 = r313;
        r60 = r60;
        r59 = r59;
        goto L282
    L283:
        int r91 = r61;
        int r92 = r62;
        View[] r412 = r115;
        int r217 = r116;
        View r94 = r313;
        int r120 = r59;
        int r121 = r60;
        int r95 = r314;
        int r96 = r57;
        View r97 = null;
        int r98 = 0;
        LayoutParams r99 = null;
    L284:
        if (r98 >= r217) goto L297;
        View r100 = r412[r98];
        if (r100.getVisibility() == 8) goto L296;
        LayoutParams r122 = (LayoutParams) r100.getLayoutParams();
        if (r97 == null) goto L295;
        if (r99 == null) goto L295;
        int r123 = r122.d - r99.d;
        if (r123 != 0) goto L294;
        r123 = r122.c - r99.c;
    L294:
        if (r123 >= 0) goto L296;
    L295:
        r97 = r100;
        r99 = r122;
    L296:
        r98 = r98 + 1;
        goto L284
    L297:
        this.a = r97;
        if (r25 == false) goto L322;
        int r101 = getPaddingRight() + r96;
        if (getLayoutParams() != null) goto L302;
    L304:
        int r102 = ViewGroup.resolveSize(Math.max(r101, getSuggestedMinimumWidth()), r46);
        if (r210 == false) goto L321;
        int r103 = 0;
    L307:
        if (r103 >= r217) goto L321;
        View r104 = r412[r103];
        if (r104.getVisibility() == 8) goto L319;
        LayoutParams r105 = (LayoutParams) r104.getLayoutParams();
        int r106 = r312;
        r105.resolveLayoutDirection(r106);
        int[] r124 = r105.a;
        if (r124[13] == 0) goto L313;
    L318:
        int r107 = r104.getMeasuredWidth();
        int r125 = (r102 - r107) / 2;
        r105.c = r125;
        r105.e = r125 + r107;
    L320:
        r103 = r103 + 1;
        r312 = r106;
        goto L307
    L313:
        if (r124[14] != 0) goto L318;
        if (r124[11] == 0) goto L320;
        int r108 = r104.getMeasuredWidth();
        int r126 = (r102 - getPaddingRight()) - r108;
        r105.c = r126;
        r105.e = r126 + r108;
        goto L320
    L319:
        r106 = r312;
    L321:
        int r109 = r312;
        int r127 = r102;
    L323:
        if (r26 == false) goto L346;
        int r128 = getPaddingBottom() + r95;
        if (getLayoutParams() != null) goto L327;
    L329:
        int r319 = ViewGroup.resolveSize(Math.max(r128, getSuggestedMinimumHeight()), r47);
        if (r118 == false) goto L345;
        int r129 = 0;
    L332:
        if (r129 >= r217) goto L345;
        View r130 = r412[r129];
        if (r130.getVisibility() == 8) goto L344;
        LayoutParams r131 = (LayoutParams) r130.getLayoutParams();
        r131.resolveLayoutDirection(r109);
        int[] r132 = r131.a;
        if (r132[13] == 0) goto L338;
    L343:
        int r133 = r130.getMeasuredHeight();
        int r134 = (r319 - r133) / 2;
        r131.d = r134;
        r131.f = r134 + r133;
        goto L344
    L338:
        if (r132[15] != 0) goto L343;
        if (r132[12] == 0) goto L344;
        int r135 = r130.getMeasuredHeight();
        int r136 = (r319 - getPaddingBottom()) - r135;
        r131.d = r136;
        r131.f = r136 + r135;
    L344:
        r129 = r129 + 1;
    L345:
        int r137 = r319;
    L347:
        if (r111 == true) goto L349;
        if (r112 == true) goto L349;
    L363:
        setMeasuredDimension(r127, r137);
        return;
    L349:
        Rect r138 = this.d;
        r138.set(getPaddingLeft(), getPaddingTop(), r127 - getPaddingRight(), r137 - getPaddingBottom());
        Rect r139 = this.c;
        Gravity.apply(this.b, r120 - r92, r121 - r91, r138, r139, r109);
        int r140 = r139.left - r92;
        int r141 = r139.top - r91;
        if (r140 != 0) goto L352;
        if (r141 == 0) goto L363;
    L352:
        int r142 = 0;
    L353:
        if (r142 >= r217) goto L363;
        View r143 = r412[r142];
        if (r143.getVisibility() == 8) goto L362;
        if (r143 == r94) goto L362;
        LayoutParams r144 = (LayoutParams) r143.getLayoutParams();
        if (r111 == false) goto L360;
        r144.c += r140;
        r144.e += r140;
    L360:
        if (r112 == false) goto L362;
        r144.d += r141;
        r144.f += r141;
    L362:
        r142 = r142 + 1;
        goto L353
    L327:
        if (getLayoutParams().height < 0) goto L329;
        r128 = Math.max(r128, getLayoutParams().height);
        goto L329
    L346:
        r137 = r95;
        goto L347
    L302:
        if (getLayoutParams().width < 0) goto L304;
        r101 = Math.max(r101, getLayoutParams().width);
        goto L304
    L322:
        r109 = r312;
        r127 = r96;
        goto L323
    L62:
        r26 = false;
        goto L63
    L59:
        r25 = false;
    L53:
        int r145 = this.e;
        if (r145 == (-1)) goto L56;
        r24 = findViewById(r145);
    L50:
        r112 = false;
    L45:
        r111 = false;
        goto L46
    L40:
        r110 = 0;
        goto L41
    L37:
        r19 = 0;
        goto L38
    L33:
        r18 = -1;
        goto L35
    L30:
        r17 = -1;
        goto L31
    }

    public BadgeCompatRelativeLayout(Context r11, AttributeSet r12, int r13) {
        boolean r0 = false;
        super(r11, r12, r13, 0);
        this.a = null;
        this.b = 8388659;
        this.c = new Rect();
        this.d = new Rect();
        this.i = new a();
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        TypedArray r2 = r11.obtainStyledAttributes(r12, new int[]{2130970173, 2130970316}, r13, 0);
        if (Build.VERSION.SDK_INT < 29) goto L5;
        saveAttributeDataForStyleable(r11, new int[]{2130970173, 2130970316}, r12, r2, r13, 0);
    L5:
        this.e = r2.getResourceId(1, -1);
        this.b = r2.getInt(0, this.b);
        r2.recycle();
        int r14 = r11.getApplicationInfo().targetSdkVersion;
        if (r14 > 17) goto L8;
        boolean r15 = true;
    L9:
        this.j = r15;
        if (r14 < 18) goto L12;
        r0 = true;
    L12:
        this.k = r0;
        return;
    L8:
        r15 = false;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        int r8 = getChildCount();
        int r9 = 0;
    L3:
        if (r9 >= r8) goto L8;
        View r10 = getChildAt(r9);
        if (r10.getVisibility() == 8) goto L7;
        LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
        r10.layout(r11.c, r11.d, r11.e, r11.f);
    L7:
        r9 = r9 + 1;
        goto L3
    }

    public final int a(int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, boolean r14) {
        int r0 = 0;
        if (r13 >= 0) goto L5;
        boolean r1 = true;
    L6:
        int r2 = 1073741824;
        if (r1 == true) goto L9;
    L18:
        if (r6 != Integer.MIN_VALUE) goto L20;
        int r15 = r11 + r9;
    L21:
        if (r7 != Integer.MIN_VALUE) goto L23;
        int r16 = (r13 - r12) - r10;
    L24:
        int r17 = r16 - r15;
        if (r6 == Integer.MIN_VALUE) goto L31;
        if (r7 == Integer.MIN_VALUE) goto L31;
        if (r1 == false) goto L29;
        r2 = 0;
    L29:
        r8 = Math.max(0, r17);
    L30:
        r0 = r2;
    L50:
        return View.MeasureSpec.makeMeasureSpec(r8, r0);
    L31:
        if (r8 < 0) goto L38;
        if (r17 < 0) goto L36;
        if (r14 == false) goto L35;
        r8 = Math.max(r17, r8);
        goto L36
    L35:
        r8 = Math.min(r17, r8);
    L36:
        r0 = 1073741824;
        goto L50
    L38:
        if (r8 != (-1)) goto L43;
        if (r1 == false) goto L41;
        r2 = 0;
    L41:
        r8 = Math.max(0, r17);
        goto L30
    L43:
        if (r8 != (-2)) goto L48;
        if (r17 < 0) goto L48;
        if (r14 == true) goto L48;
        r8 = r17;
        r0 = Integer.MIN_VALUE;
    L48:
        r8 = 0;
        goto L50
    L23:
        r16 = r7;
        goto L24
    L20:
        r15 = r6;
        goto L21
    L9:
        if (this.j == true) goto L18;
        if (r6 == Integer.MIN_VALUE) goto L13;
        if (r7 == Integer.MIN_VALUE) goto L13;
        r8 = Math.max(0, r7 - r6);
    L14:
        r0 = 1073741824;
    L17:
        return View.MeasureSpec.makeMeasureSpec(r8, r0);
    L13:
        if (r8 >= 0) goto L14;
        r8 = 0;
        goto L17
    L5:
        r1 = false;
        goto L6
    }
}
