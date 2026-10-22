package com.obric.oui.constraintlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.oui.constraintlayout.core.c;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun;
import com.obric.oui.constraintlayout.core.widgets.analyzer.e;
import com.obric.oui.constraintlayout.core.widgets.analyzer.k;
import com.obric.oui.constraintlayout.core.widgets.analyzer.m;
import com.obric.oui.constraintlayout.core.widgets.d;
import com.obric.oui.constraintlayout.core.widgets.f;
import com.obric.oui.constraintlayout.core.widgets.g;
import com.obric.oui.constraintlayout.core.widgets.i;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public class ConstraintLayout extends ViewGroup {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static com.obric.oui.constraintlayout.widget.b f400386p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<View> f400387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<ConstraintHelper> f400388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f400389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f400390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f400391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f400392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f400393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f400394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f400395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.obric.oui.constraintlayout.widget.a f400396j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public wla.a f400397k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f400398l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HashMap<String, Integer> f400399m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SparseArray<ConstraintWidget> f400400n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f400401o;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public final int C;
        public final int D;
        public float E;
        public float F;
        public String G;
        public float H;
        public float I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f400402J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public float R;
        public float S;
        public int T;
        public int U;
        public int V;
        public boolean W;
        public boolean X;
        public String Y;
        public int Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f400403a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public boolean f400404a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f400405b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public boolean f400406b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f400407c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public boolean f400408c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f400409d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public boolean f400410d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f400411e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public boolean f400412e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f400413f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public boolean f400414f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f400415g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public int f400416g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f400417h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public int f400418h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f400419i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public int f400420i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f400421j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public int f400422j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f400423k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public int f400424k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f400425l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public int f400426l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f400427m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public float f400428m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f400429n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public int f400430n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f400431o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public int f400432o0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f400433p;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public float f400434p0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f400435q;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public ConstraintWidget f400436q0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f400437r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f400438s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f400439t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f400440u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f400441v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final int f400442w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f400443x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final int f400444y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f400445z;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f400446a = null;

            static {
                SparseIntArray r100 = new SparseIntArray();
                f400446a = r100;
                r100.append(98, 64);
                r100.append(75, 65);
                r100.append(84, 8);
                r100.append(85, 9);
                r100.append(87, 10);
                r100.append(88, 11);
                r100.append(94, 12);
                r100.append(93, 13);
                r100.append(65, 14);
                r100.append(64, 15);
                r100.append(60, 16);
                r100.append(62, 52);
                r100.append(61, 53);
                r100.append(66, 2);
                r100.append(68, 3);
                r100.append(67, 4);
                r100.append(103, 49);
                r100.append(104, 50);
                r100.append(72, 5);
                r100.append(73, 6);
                r100.append(74, 7);
                r100.append(55, 67);
                r100.append(0, 1);
                r100.append(89, 17);
                r100.append(90, 18);
                r100.append(71, 19);
                r100.append(70, 20);
                r100.append(108, 21);
                r100.append(111, 22);
                r100.append(109, 23);
                r100.append(106, 24);
                r100.append(110, 25);
                r100.append(107, 26);
                r100.append(105, 55);
                r100.append(112, 54);
                r100.append(80, 29);
                r100.append(95, 30);
                r100.append(69, 44);
                r100.append(82, 45);
                r100.append(97, 46);
                r100.append(81, 47);
                r100.append(96, 48);
                r100.append(58, 27);
                r100.append(57, 28);
                r100.append(99, 31);
                r100.append(76, 32);
                r100.append(101, 33);
                r100.append(100, 34);
                r100.append(102, 35);
                r100.append(78, 36);
                r100.append(77, 37);
                r100.append(79, 38);
                r100.append(83, 39);
                r100.append(92, 40);
                r100.append(86, 41);
                r100.append(63, 42);
                r100.append(59, 43);
                r100.append(91, 51);
                r100.append(114, 66);
            }
        }

        public final void a() {
            this.f400410d0 = false;
            this.f400404a0 = true;
            this.f400406b0 = true;
            int r100 = ((ViewGroup.MarginLayoutParams) this).width;
            if (r100 == (-2)) goto L5;
        L9:
            int r101 = ((ViewGroup.MarginLayoutParams) this).height;
            if (r101 != (-2)) goto L17;
            if (this.X == false) goto L17;
            this.f400406b0 = false;
            if (this.M != 0) goto L17;
            this.M = 1;
        L17:
            if (r100 == 0) goto L19;
            if (r100 == (-1)) goto L19;
        L24:
            if (r101 == 0) goto L26;
            if (r101 == (-1)) goto L26;
        L32:
            if (this.f400407c == (-1.0f)) goto L34;
        L37:
            this.f400410d0 = true;
            this.f400404a0 = true;
            this.f400406b0 = true;
            if ((this.f400436q0 instanceof f) == true) goto L40;
            this.f400436q0 = new f();
        L40:
            ((f) this.f400436q0).U(this.V);
            return;
        L34:
            if (this.f400403a != (-1)) goto L37;
            if (this.f400405b != (-1)) goto L37;
            return;
        L26:
            this.f400406b0 = false;
            if (r101 != 0) goto L32;
            if (this.M != 1) goto L32;
            ((ViewGroup.MarginLayoutParams) this).height = -2;
            this.X = true;
        L19:
            this.f400404a0 = false;
            if (r100 != 0) goto L24;
            if (this.L != 1) goto L24;
            ((ViewGroup.MarginLayoutParams) this).width = -2;
            this.W = true;
            goto L24
        L5:
            if (this.W == false) goto L9;
            this.f400404a0 = false;
            if (this.L != 0) goto L9;
            this.L = 1;
            goto L9
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.f400403a = -1;
            this.f400405b = -1;
            this.f400407c = -1.0f;
            this.f400409d = true;
            this.f400411e = -1;
            this.f400413f = -1;
            this.f400415g = -1;
            this.f400417h = -1;
            this.f400419i = -1;
            this.f400421j = -1;
            this.f400423k = -1;
            this.f400425l = -1;
            this.f400427m = -1;
            this.f400429n = -1;
            this.f400431o = -1;
            this.f400433p = -1;
            this.f400435q = 0;
            this.f400437r = 0.0f;
            this.f400438s = -1;
            this.f400439t = -1;
            this.f400440u = -1;
            this.f400441v = -1;
            this.f400442w = Integer.MIN_VALUE;
            this.f400443x = Integer.MIN_VALUE;
            this.f400444y = Integer.MIN_VALUE;
            this.f400445z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.f400402J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.f400404a0 = true;
            this.f400406b0 = true;
            this.f400408c0 = false;
            this.f400410d0 = false;
            this.f400412e0 = false;
            this.f400414f0 = false;
            this.f400416g0 = -1;
            this.f400418h0 = -1;
            this.f400420i0 = -1;
            this.f400422j0 = -1;
            this.f400424k0 = Integer.MIN_VALUE;
            this.f400426l0 = Integer.MIN_VALUE;
            this.f400428m0 = 0.5f;
            this.f400436q0 = new ConstraintWidget();
            if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
            ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r101.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r101.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = r101.topMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = r101.bottomMargin;
            setMarginStart(r101.getMarginStart());
            setMarginEnd(r101.getMarginEnd());
        L6:
            if ((r100 instanceof LayoutParams) == true) goto L8;
            return;
        L8:
            LayoutParams r102 = (LayoutParams) r100;
            this.f400403a = r102.f400403a;
            this.f400405b = r102.f400405b;
            this.f400407c = r102.f400407c;
            this.f400409d = r102.f400409d;
            this.f400411e = r102.f400411e;
            this.f400413f = r102.f400413f;
            this.f400415g = r102.f400415g;
            this.f400417h = r102.f400417h;
            this.f400419i = r102.f400419i;
            this.f400421j = r102.f400421j;
            this.f400423k = r102.f400423k;
            this.f400425l = r102.f400425l;
            this.f400427m = r102.f400427m;
            this.f400429n = r102.f400429n;
            this.f400431o = r102.f400431o;
            this.f400433p = r102.f400433p;
            this.f400435q = r102.f400435q;
            this.f400437r = r102.f400437r;
            this.f400438s = r102.f400438s;
            this.f400439t = r102.f400439t;
            this.f400440u = r102.f400440u;
            this.f400441v = r102.f400441v;
            this.f400442w = r102.f400442w;
            this.f400443x = r102.f400443x;
            this.f400444y = r102.f400444y;
            this.f400445z = r102.f400445z;
            this.A = r102.A;
            this.B = r102.B;
            this.C = r102.C;
            this.D = r102.D;
            this.E = r102.E;
            this.F = r102.F;
            this.G = r102.G;
            this.H = r102.H;
            this.I = r102.I;
            this.f400402J = r102.f400402J;
            this.K = r102.K;
            this.W = r102.W;
            this.X = r102.X;
            this.L = r102.L;
            this.M = r102.M;
            this.N = r102.N;
            this.P = r102.P;
            this.O = r102.O;
            this.Q = r102.Q;
            this.R = r102.R;
            this.S = r102.S;
            this.T = r102.T;
            this.U = r102.U;
            this.V = r102.V;
            this.f400404a0 = r102.f400404a0;
            this.f400406b0 = r102.f400406b0;
            this.f400408c0 = r102.f400408c0;
            this.f400410d0 = r102.f400410d0;
            this.f400416g0 = r102.f400416g0;
            this.f400418h0 = r102.f400418h0;
            this.f400420i0 = r102.f400420i0;
            this.f400422j0 = r102.f400422j0;
            this.f400424k0 = r102.f400424k0;
            this.f400426l0 = r102.f400426l0;
            this.f400428m0 = r102.f400428m0;
            this.Y = r102.Y;
            this.Z = r102.Z;
            this.f400436q0 = r102.f400436q0;
        }

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        public final void resolveLayoutDirection(int r110) {
            int r100 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int r101 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(r110);
            boolean r102 = false;
            if (1 != getLayoutDirection()) goto L5;
            boolean r111 = true;
        L6:
            this.f400420i0 = -1;
            this.f400422j0 = -1;
            this.f400416g0 = -1;
            this.f400418h0 = -1;
            this.f400424k0 = this.f400442w;
            this.f400426l0 = this.f400444y;
            float r103 = this.E;
            this.f400428m0 = r103;
            int r104 = this.f400403a;
            this.f400430n0 = r104;
            int r105 = this.f400405b;
            this.f400432o0 = r105;
            float r106 = this.f400407c;
            this.f400434p0 = r106;
            if (r111 == false) goto L43;
            int r112 = this.f400438s;
            if (r112 == (-1)) goto L12;
            this.f400420i0 = r112;
        L11:
            r102 = true;
        L15:
            int r113 = this.f400440u;
            if (r113 == (-1)) goto L18;
            this.f400418h0 = r113;
            r102 = true;
        L18:
            int r114 = this.f400441v;
            if (r114 == (-1)) goto L21;
            this.f400416g0 = r114;
            r102 = true;
        L21:
            int r115 = this.A;
            if (r115 == Integer.MIN_VALUE) goto L24;
            this.f400426l0 = r115;
        L24:
            int r116 = this.B;
            if (r116 == Integer.MIN_VALUE) goto L28;
            this.f400424k0 = r116;
        L28:
            if (r102 == false) goto L31;
            this.f400428m0 = 1.0f - r103;
        L31:
            if (this.f400410d0 == false) goto L62;
            if (this.V != 1) goto L62;
            if (this.f400409d == false) goto L62;
            if (r106 == (-1.0f)) goto L39;
            this.f400434p0 = 1.0f - r106;
            this.f400430n0 = -1;
            this.f400432o0 = -1;
            goto L62
        L39:
            if (r104 == (-1)) goto L41;
            this.f400432o0 = r104;
            this.f400430n0 = -1;
            this.f400434p0 = -1.0f;
            goto L62
        L41:
            if (r105 == (-1)) goto L62;
            this.f400430n0 = r105;
            this.f400432o0 = -1;
            this.f400434p0 = -1.0f;
        L62:
            if (this.f400440u == (-1)) goto L64;
            return;
        L64:
            if (this.f400441v == (-1)) goto L66;
            return;
        L66:
            if (this.f400439t == (-1)) goto L68;
            return;
        L68:
            if (this.f400438s != (-1)) goto L97;
            int r117 = this.f400415g;
            if (r117 == (-1)) goto L75;
            this.f400420i0 = r117;
            if (((ViewGroup.MarginLayoutParams) this).rightMargin > 0) goto L81;
            if (r101 <= 0) goto L81;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r101;
        L81:
            int r118 = this.f400411e;
            if (r118 == (-1)) goto L87;
            this.f400416g0 = r118;
            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0) goto L98;
            if (r100 <= 0) goto L99;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r100;
            return;
        L99:
            return;
        L98:
            return;
        L87:
            int r119 = this.f400413f;
            if (r119 == (-1)) goto L101;
            this.f400418h0 = r119;
            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0) goto L102;
            if (r100 <= 0) goto L103;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r100;
            return;
        L103:
            return;
        L102:
            return;
        L101:
            return;
        L75:
            int r120 = this.f400417h;
            if (r120 == (-1)) goto L81;
            this.f400422j0 = r120;
            if (((ViewGroup.MarginLayoutParams) this).rightMargin > 0) goto L81;
            if (r101 <= 0) goto L81;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r101;
            goto L81
        L97:
            return;
        L12:
            int r121 = this.f400439t;
            if (r121 == (-1)) goto L15;
            this.f400422j0 = r121;
            goto L11
        L43:
            int r122 = this.f400438s;
            if (r122 == (-1)) goto L46;
            this.f400418h0 = r122;
        L46:
            int r123 = this.f400439t;
            if (r123 == (-1)) goto L49;
            this.f400416g0 = r123;
        L49:
            int r124 = this.f400440u;
            if (r124 == (-1)) goto L52;
            this.f400420i0 = r124;
        L52:
            int r125 = this.f400441v;
            if (r125 == (-1)) goto L55;
            this.f400422j0 = r125;
        L55:
            int r126 = this.A;
            if (r126 == Integer.MIN_VALUE) goto L58;
            this.f400424k0 = r126;
        L58:
            int r127 = this.B;
            if (r127 == Integer.MIN_VALUE) goto L62;
            this.f400426l0 = r127;
            goto L62
        L5:
            r111 = false;
            goto L6
        }

        public LayoutParams(Context r110, AttributeSet r111) {
            super(r110, r111);
            this.f400403a = -1;
            this.f400405b = -1;
            this.f400407c = -1.0f;
            this.f400409d = true;
            this.f400411e = -1;
            this.f400413f = -1;
            this.f400415g = -1;
            this.f400417h = -1;
            this.f400419i = -1;
            this.f400421j = -1;
            this.f400423k = -1;
            this.f400425l = -1;
            this.f400427m = -1;
            this.f400429n = -1;
            this.f400431o = -1;
            this.f400433p = -1;
            this.f400435q = 0;
            this.f400437r = 0.0f;
            this.f400438s = -1;
            this.f400439t = -1;
            this.f400440u = -1;
            this.f400441v = -1;
            this.f400442w = Integer.MIN_VALUE;
            this.f400443x = Integer.MIN_VALUE;
            this.f400444y = Integer.MIN_VALUE;
            this.f400445z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.f400402J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.f400404a0 = true;
            this.f400406b0 = true;
            this.f400408c0 = false;
            this.f400410d0 = false;
            this.f400412e0 = false;
            this.f400414f0 = false;
            this.f400416g0 = -1;
            this.f400418h0 = -1;
            this.f400420i0 = -1;
            this.f400422j0 = -1;
            this.f400424k0 = Integer.MIN_VALUE;
            this.f400426l0 = Integer.MIN_VALUE;
            this.f400428m0 = 0.5f;
            this.f400436q0 = new ConstraintWidget();
            TypedArray r112 = r110.obtainStyledAttributes(r111, new int[]{R.attr.orientation, R.attr.padding, R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.paddingStart, R.attr.paddingEnd, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.elevation, R.attr.layout_marginHorizontal, R.attr.layout_marginVertical, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.circularflow_angles, com.larus.nova.R.attr.circularflow_defaultAngle, com.larus.nova.R.attr.circularflow_defaultRadius, com.larus.nova.R.attr.circularflow_radiusInDP, com.larus.nova.R.attr.circularflow_viewCenter, com.larus.nova.R.attr.constraintSet, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layoutDescription, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_optimizationLevel, com.larus.nova.R.attr.layout_wrapBehaviorInParent});
            int r113 = r112.getIndexCount();
            int r100 = 0;
        L3:
            if (r100 >= r113) goto L114;
            int r101 = r112.getIndex(r100);
            int r102 = a.f400446a.get(r101);
            switch(r102) {
                case 1: goto L92;
                case 2: goto L89;
                case 3: goto L88;
                case 4: goto L85;
                case 5: goto L84;
                case 6: goto L83;
                case 7: goto L82;
                case 8: goto L79;
                case 9: goto L76;
                case 10: goto L73;
                case 11: goto L70;
                case 12: goto L67;
                case 13: goto L64;
                case 14: goto L61;
                case 15: goto L58;
                case 16: goto L55;
                case 17: goto L52;
                case 18: goto L49;
                case 19: goto L46;
                case 20: goto L43;
                case 21: goto L42;
                case 22: goto L41;
                case 23: goto L40;
                case 24: goto L39;
                case 25: goto L38;
                case 26: goto L37;
                case 27: goto L36;
                case 28: goto L35;
                case 29: goto L34;
                case 30: goto L33;
                case 31: goto L32;
                case 32: goto L31;
                case 33: goto L122;
                case 34: goto L118;
                case 35: goto L20;
                case 36: goto L120;
                case 37: goto L116;
                case 38: goto L9;
                default: goto L6;
            };
        L6:
            switch(r102) {
                case 44: goto L108;
                case 45: goto L107;
                case 46: goto L106;
                case 47: goto L105;
                case 48: goto L104;
                case 49: goto L103;
                case 50: goto L102;
                case 51: goto L101;
                case 52: goto L98;
                case 53: goto L95;
                case 54: goto L94;
                case 55: goto L93;
                default: goto L7;
            };
        L7:
            switch(r102) {
                case 64: goto L112;
                case 65: goto L111;
                case 66: goto L110;
                case 67: goto L109;
                default: goto L113;
            };
        L109:
            this.f400409d = r112.getBoolean(r101, this.f400409d);
            goto L113
        L110:
            this.Z = r112.getInt(r101, this.Z);
            goto L113
        L111:
            com.obric.oui.constraintlayout.widget.a.m(this, r112, r101, 1);
            goto L113
        L112:
            com.obric.oui.constraintlayout.widget.a.m(this, r112, r101, 0);
        L113:
            r100 = r100 + 1;
            goto L3
        L93:
            this.C = r112.getDimensionPixelSize(r101, this.C);
            goto L113
        L94:
            this.D = r112.getDimensionPixelSize(r101, this.D);
            goto L113
        L95:
            int r103 = r112.getResourceId(r101, this.f400431o);
            this.f400431o = r103;
            if (r103 != (-1)) goto L113;
            this.f400431o = r112.getInt(r101, -1);
            goto L113
        L98:
            int r104 = r112.getResourceId(r101, this.f400429n);
            this.f400429n = r104;
            if (r104 != (-1)) goto L113;
            this.f400429n = r112.getInt(r101, -1);
            goto L113
        L101:
            this.Y = r112.getString(r101);
            goto L113
        L102:
            this.U = r112.getDimensionPixelOffset(r101, this.U);
            goto L113
        L103:
            this.T = r112.getDimensionPixelOffset(r101, this.T);
            goto L113
        L104:
            this.K = r112.getInt(r101, 0);
            goto L113
        L105:
            this.f400402J = r112.getInt(r101, 0);
            goto L113
        L106:
            this.I = r112.getFloat(r101, this.I);
            goto L113
        L107:
            this.H = r112.getFloat(r101, this.H);
            goto L113
        L108:
            com.obric.oui.constraintlayout.widget.a.n(this, r112.getString(r101));
            goto L113
        L9:
            this.S = Math.max(0.0f, r112.getFloat(r101, this.S));
            this.M = 2;
            goto L113
        L20:
            this.R = Math.max(0.0f, r112.getFloat(r101, this.R));
            this.L = 2;
            goto L113
        L31:
            this.M = r112.getInt(r101, 0);
            goto L113
        L32:
            this.L = r112.getInt(r101, 0);
            goto L113
        L33:
            this.F = r112.getFloat(r101, this.F);
            goto L113
        L34:
            this.E = r112.getFloat(r101, this.E);
            goto L113
        L35:
            this.X = r112.getBoolean(r101, this.X);
            goto L113
        L36:
            this.W = r112.getBoolean(r101, this.W);
            goto L113
        L37:
            this.B = r112.getDimensionPixelSize(r101, this.B);
            goto L113
        L38:
            this.A = r112.getDimensionPixelSize(r101, this.A);
            goto L113
        L39:
            this.f400445z = r112.getDimensionPixelSize(r101, this.f400445z);
            goto L113
        L40:
            this.f400444y = r112.getDimensionPixelSize(r101, this.f400444y);
            goto L113
        L41:
            this.f400443x = r112.getDimensionPixelSize(r101, this.f400443x);
            goto L113
        L42:
            this.f400442w = r112.getDimensionPixelSize(r101, this.f400442w);
            goto L113
        L43:
            int r105 = r112.getResourceId(r101, this.f400441v);
            this.f400441v = r105;
            if (r105 != (-1)) goto L113;
            this.f400441v = r112.getInt(r101, -1);
            goto L113
        L46:
            int r106 = r112.getResourceId(r101, this.f400440u);
            this.f400440u = r106;
            if (r106 != (-1)) goto L113;
            this.f400440u = r112.getInt(r101, -1);
            goto L113
        L49:
            int r107 = r112.getResourceId(r101, this.f400439t);
            this.f400439t = r107;
            if (r107 != (-1)) goto L113;
            this.f400439t = r112.getInt(r101, -1);
            goto L113
        L52:
            int r108 = r112.getResourceId(r101, this.f400438s);
            this.f400438s = r108;
            if (r108 != (-1)) goto L113;
            this.f400438s = r112.getInt(r101, -1);
            goto L113
        L55:
            int r109 = r112.getResourceId(r101, this.f400427m);
            this.f400427m = r109;
            if (r109 != (-1)) goto L113;
            this.f400427m = r112.getInt(r101, -1);
            goto L113
        L58:
            int r114 = r112.getResourceId(r101, this.f400425l);
            this.f400425l = r114;
            if (r114 != (-1)) goto L113;
            this.f400425l = r112.getInt(r101, -1);
            goto L113
        L61:
            int r115 = r112.getResourceId(r101, this.f400423k);
            this.f400423k = r115;
            if (r115 != (-1)) goto L113;
            this.f400423k = r112.getInt(r101, -1);
            goto L113
        L64:
            int r116 = r112.getResourceId(r101, this.f400421j);
            this.f400421j = r116;
            if (r116 != (-1)) goto L113;
            this.f400421j = r112.getInt(r101, -1);
            goto L113
        L67:
            int r117 = r112.getResourceId(r101, this.f400419i);
            this.f400419i = r117;
            if (r117 != (-1)) goto L113;
            this.f400419i = r112.getInt(r101, -1);
            goto L113
        L70:
            int r118 = r112.getResourceId(r101, this.f400417h);
            this.f400417h = r118;
            if (r118 != (-1)) goto L113;
            this.f400417h = r112.getInt(r101, -1);
            goto L113
        L73:
            int r119 = r112.getResourceId(r101, this.f400415g);
            this.f400415g = r119;
            if (r119 != (-1)) goto L113;
            this.f400415g = r112.getInt(r101, -1);
            goto L113
        L76:
            int r120 = r112.getResourceId(r101, this.f400413f);
            this.f400413f = r120;
            if (r120 != (-1)) goto L113;
            this.f400413f = r112.getInt(r101, -1);
            goto L113
        L79:
            int r121 = r112.getResourceId(r101, this.f400411e);
            this.f400411e = r121;
            if (r121 != (-1)) goto L113;
            this.f400411e = r112.getInt(r101, -1);
            goto L113
        L82:
            this.f400407c = r112.getFloat(r101, this.f400407c);
            goto L113
        L83:
            this.f400405b = r112.getDimensionPixelOffset(r101, this.f400405b);
            goto L113
        L84:
            this.f400403a = r112.getDimensionPixelOffset(r101, this.f400403a);
            goto L113
        L85:
            float r122 = r112.getFloat(r101, this.f400437r) % 360.0f;
            this.f400437r = r122;
            if (r122 >= 0.0f) goto L113;
            this.f400437r = (360.0f - r122) % 360.0f;
            goto L113
        L88:
            this.f400435q = r112.getDimensionPixelSize(r101, this.f400435q);
            goto L113
        L89:
            int r123 = r112.getResourceId(r101, this.f400433p);
            this.f400433p = r123;
            if (r123 != (-1)) goto L113;
            this.f400433p = r112.getInt(r101, -1);
            goto L113
        L92:
            this.V = r112.getInt(r101, this.V);
            goto L113
        L116:
            this.Q = r112.getDimensionPixelSize(r101, this.Q);     // Catch: Exception -> L12
        L13:
            if (r112.getInt(r101, this.Q) != (-2)) goto L113;
            this.Q = -2;
            goto L113
        L118:
            this.P = r112.getDimensionPixelSize(r101, this.P);     // Catch: Exception -> L23
        L24:
            if (r112.getInt(r101, this.P) != (-2)) goto L113;
            this.P = -2;
            goto L113
        L120:
            this.O = r112.getDimensionPixelSize(r101, this.O);     // Catch: Exception -> L17
        L18:
            if (r112.getInt(r101, this.O) != (-2)) goto L113;
            this.O = -2;
            goto L113
        L122:
            this.N = r112.getDimensionPixelSize(r101, this.N);     // Catch: Exception -> L28
        L29:
            if (r112.getInt(r101, this.N) != (-2)) goto L113;
            this.N = -2;
            goto L113
        L114:
            r112.recycle();
            a();
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.f400403a = -1;
            this.f400405b = -1;
            this.f400407c = -1.0f;
            this.f400409d = true;
            this.f400411e = -1;
            this.f400413f = -1;
            this.f400415g = -1;
            this.f400417h = -1;
            this.f400419i = -1;
            this.f400421j = -1;
            this.f400423k = -1;
            this.f400425l = -1;
            this.f400427m = -1;
            this.f400429n = -1;
            this.f400431o = -1;
            this.f400433p = -1;
            this.f400435q = 0;
            this.f400437r = 0.0f;
            this.f400438s = -1;
            this.f400439t = -1;
            this.f400440u = -1;
            this.f400441v = -1;
            this.f400442w = Integer.MIN_VALUE;
            this.f400443x = Integer.MIN_VALUE;
            this.f400444y = Integer.MIN_VALUE;
            this.f400445z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.f400402J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.f400404a0 = true;
            this.f400406b0 = true;
            this.f400408c0 = false;
            this.f400410d0 = false;
            this.f400412e0 = false;
            this.f400414f0 = false;
            this.f400416g0 = -1;
            this.f400418h0 = -1;
            this.f400420i0 = -1;
            this.f400422j0 = -1;
            this.f400424k0 = Integer.MIN_VALUE;
            this.f400426l0 = Integer.MIN_VALUE;
            this.f400428m0 = 0.5f;
            this.f400436q0 = new ConstraintWidget();
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f400447a = null;

        static {
            int[] r100 = new int[ConstraintWidget.DimensionBehaviour.values().length];
            f400447a = r100;
            r100[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f400447a[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f400447a[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f400447a[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class b implements com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC4669b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConstraintLayout f400448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f400449b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f400450c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f400451d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f400452e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f400453f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f400454g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f400455h;

        public b(ConstraintLayout r100, ConstraintLayout r101) {
            this.f400455h = r100;
            this.f400448a = r101;
        }

        public final void b(ConstraintWidget r110, com.obric.oui.constraintlayout.core.widgets.analyzer.b.a r210) {
            if (r110 != null) goto L6;
            return;
        L6:
            if (r110.f399722k0 != 8) goto L12;
            if (r110.H == true) goto L12;
            r210.f399786e = 0;
            r210.f399787f = 0;
            r210.f399788g = 0;
            return;
        L12:
            if (r110.X != null) goto L14;
            return;
        L14:
            ConstraintLayout r100 = this.f400455h;
            com.obric.oui.constraintlayout.widget.b r101 = ConstraintLayout.f400386p;
            r100.getClass();
            ConstraintWidget.DimensionBehaviour r102 = r210.f399782a;
            ConstraintWidget.DimensionBehaviour r103 = r210.f399783b;
            int r104 = r210.f399784c;
            int r105 = r210.f399785d;
            int r106 = this.f400449b + this.f400450c;
            int r107 = this.f400451d;
            View r111 = (View) r110.f399720j0;
            int[] r112 = a.f400447a;
            int r113 = r112[r102.ordinal()];
            if (r113 == 1) goto L54;
            if (r113 == 2) goto L53;
            if (r113 == 3) goto L45;
            if (r113 == 4) goto L20;
            int r108 = 0;
        L55:
            int r109 = r112[r103.ordinal()];
            if (r109 == 1) goto L96;
            if (r109 == 2) goto L95;
            if (r109 != 3) goto L60;
            int r114 = this.f400454g;
            if (r110.L == null) goto L90;
            int r115 = r110.M.f399695g + 0;
        L92:
            if (r110.N == null) goto L94;
            r115 = r115 + r110.O.f399695g;
        L94:
            int r116 = ViewGroup.getChildMeasureSpec(r114, r106 + r115, -1);
        L97:
            d r117 = (d) r110.X;
            if (r117 != null) goto L100;
        L122:
            ConstraintWidget.DimensionBehaviour r118 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (r102 != r118) goto L125;
            boolean r119 = true;
        L126:
            if (r103 != r118) goto L128;
            boolean r120 = true;
        L129:
            ConstraintWidget.DimensionBehaviour r121 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (r103 != r121) goto L132;
        L135:
            boolean r122 = true;
        L136:
            if (r102 != r121) goto L138;
        L141:
            boolean r123 = true;
        L143:
            if (r119 == true) goto L145;
        L147:
            boolean r124 = false;
        L148:
            if (r120 == true) goto L150;
        L152:
            boolean r125 = false;
        L153:
            if (r111 != null) goto L155;
            return;
        L155:
            LayoutParams r126 = (LayoutParams) r111.getLayoutParams();
            int r127 = r210.f399791j;
            if (r127 == 1) goto L167;
            if (r127 == 2) goto L167;
            if (r119 == false) goto L167;
            if (r110.f399739t != 0) goto L167;
            if (r120 == false) goto L167;
            if (r110.f399741u != 0) goto L167;
            int r128 = 0;
            int r129 = 0;
            int r130 = -1;
            boolean r131 = false;
            int r132 = 0;
        L207:
            if (r132 == r130) goto L209;
            boolean r133 = true;
        L211:
            if (r128 == r210.f399784c) goto L213;
        L214:
            r131 = true;
        L215:
            r210.f399790i = r131;
            if (r126.f400408c0 == false) goto L218;
            boolean r134 = true;
        L219:
            if (r134 == true) goto L221;
        L225:
            r210.f399786e = r128;
            r210.f399787f = r129;
            r210.f399789h = r134;
            r210.f399788g = r132;
            this.f400455h.getClass();
            return;
        L221:
            if (r132 == (-1)) goto L225;
            if (r110.f399710e0 == r132) goto L225;
            r210.f399790i = true;
            goto L225
        L218:
            r134 = r133;
            goto L219
        L213:
            if (r129 == r210.f399785d) goto L215;
        L209:
            r133 = false;
        L167:
            if ((r111 instanceof VirtualLayout) == true) goto L169;
        L171:
            r111.measure(r108, r116);
        L172:
            r110.f399700J = r108;
            r110.K = r116;
            r110.f399713g = false;
            int r135 = r111.getMeasuredWidth();
            int r136 = r111.getMeasuredHeight();
            r132 = r111.getBaseline();
            int r137 = r110.f399745w;
            if (r137 <= 0) goto L175;
            int r138 = Math.max(r137, r135);
        L176:
            int r139 = r110.f399747x;
            if (r139 <= 0) goto L179;
            r138 = Math.min(r139, r138);
        L179:
            int r140 = r110.f399749z;
            if (r140 <= 0) goto L182;
            int r141 = Math.max(r140, r136);
        L183:
            int r142 = r110.A;
            if (r142 <= 0) goto L186;
            r141 = Math.min(r142, r141);
        L186:
            int r143 = r116;
            if (g.b(this.f400455h.f400395i, 1) == false) goto L189;
        L195:
            int r144 = r138;
        L196:
            if (r135 != r144) goto L200;
            if (r136 != r141) goto L200;
            r129 = r141;
            r128 = r144;
            r130 = -1;
            r131 = false;
        L200:
            if (r135 == r144) goto L202;
            int r145 = 1073741824;
            int r146 = View.MeasureSpec.makeMeasureSpec(r144, 1073741824);
        L203:
            if (r136 == r141) goto L205;
            int r147 = View.MeasureSpec.makeMeasureSpec(r141, r145);
        L206:
            r111.measure(r146, r147);
            r110.f399700J = r146;
            r110.K = r147;
            r131 = false;
            r110.f399713g = false;
            r128 = r111.getMeasuredWidth();
            r129 = r111.getMeasuredHeight();
            r132 = r111.getBaseline();
            r130 = -1;
            goto L207
        L205:
            r147 = r143;
            goto L206
        L202:
            r145 = 1073741824;
            r146 = r108;
            goto L203
        L189:
            if (r124 == false) goto L192;
            if (r122 == false) goto L192;
            r144 = (int) ((r141 * r110.f399702a0) + 0.5f);
        L192:
            if (r125 == false) goto L195;
            if (r123 == false) goto L195;
            r141 = (int) ((r138 / r110.f399702a0) + 0.5f);
            goto L195
        L182:
            r141 = r136;
            goto L183
        L175:
            r138 = r135;
            goto L176
        L169:
            if ((r110 instanceof i) == false) goto L171;
            ((VirtualLayout) r111).u((i) r110, r108, r116);
            goto L172
        L150:
            if (r110.f399702a0 <= 0.0f) goto L152;
            r125 = true;
            goto L153
        L145:
            if (r110.f399702a0 <= 0.0f) goto L147;
            r124 = true;
            goto L148
        L138:
            if (r102 == ConstraintWidget.DimensionBehaviour.FIXED) goto L141;
            r123 = false;
            goto L143
        L132:
            if (r103 == ConstraintWidget.DimensionBehaviour.FIXED) goto L135;
            r122 = false;
            goto L136
        L128:
            r120 = false;
            goto L129
        L125:
            r119 = false;
            goto L126
        L100:
            if (g.b(this.f400455h.f400395i, 256) == false) goto L122;
            if (r111.getMeasuredWidth() != r110.t()) goto L122;
            if (r111.getMeasuredWidth() >= r117.t()) goto L122;
            if (r111.getMeasuredHeight() != r110.n()) goto L122;
            if (r111.getMeasuredHeight() >= r117.n()) goto L122;
            if (r111.getBaseline() != r110.f399710e0) goto L122;
            if (r110.C() == true) goto L122;
            if (a(r110.f399700J, r108, r110.t()) == true) goto L116;
        L118:
            boolean r148 = false;
        L119:
            if (r148 == false) goto L122;
            r210.f399786e = r110.t();
            r210.f399787f = r110.n();
            r210.f399788g = r110.f399710e0;
            return;
        L116:
            if (a(r110.K, r116, r110.n()) == false) goto L118;
            r148 = true;
            goto L119
        L90:
            r115 = 0;
            goto L92
        L60:
            if (r109 == 4) goto L62;
            r116 = 0;
            goto L97
        L62:
            r116 = ViewGroup.getChildMeasureSpec(this.f400454g, r106, -2);
            if (r110.f399741u != 1) goto L65;
            boolean r149 = true;
        L66:
            int r150 = r210.f399791j;
            if (r150 == 1) goto L70;
            if (r150 != 2) goto L97;
        L70:
            if (r111.getMeasuredWidth() != r110.t()) goto L72;
            boolean r151 = true;
        L74:
            if (r210.f399791j == 2) goto L84;
            if (r149 == false) goto L84;
            if (r149 == false) goto L79;
            if (r151 == true) goto L84;
        L79:
            if ((r111 instanceof Placeholder) == true) goto L84;
            if (r110.E() == true) goto L84;
            boolean r152 = false;
        L85:
            if (r152 == false) goto L97;
            r116 = View.MeasureSpec.makeMeasureSpec(r110.n(), 1073741824);
        L84:
            r152 = true;
            goto L85
        L72:
            r151 = false;
            goto L74
        L65:
            r149 = false;
            goto L66
        L95:
            r116 = ViewGroup.getChildMeasureSpec(this.f400454g, r106, -2);
            goto L97
        L96:
            r116 = View.MeasureSpec.makeMeasureSpec(r105, 1073741824);
            goto L97
        L20:
            r108 = ViewGroup.getChildMeasureSpec(this.f400453f, r107, -2);
            if (r110.f399739t != 1) goto L23;
            boolean r153 = true;
        L24:
            int r154 = r210.f399791j;
            if (r154 == 1) goto L28;
            if (r154 != 2) goto L55;
        L28:
            if (r111.getMeasuredHeight() != r110.n()) goto L30;
            boolean r155 = true;
        L32:
            if (r210.f399791j == 2) goto L42;
            if (r153 == false) goto L42;
            if (r153 == false) goto L37;
            if (r155 == true) goto L42;
        L37:
            if ((r111 instanceof Placeholder) == true) goto L42;
            if (r110.D() == true) goto L42;
            boolean r156 = false;
        L43:
            if (r156 == false) goto L55;
            r108 = View.MeasureSpec.makeMeasureSpec(r110.t(), 1073741824);
        L42:
            r156 = true;
            goto L43
        L30:
            r155 = false;
            goto L32
        L23:
            r153 = false;
            goto L24
        L45:
            int r157 = this.f400453f;
            ConstraintAnchor r158 = r110.L;
            if (r158 == null) goto L48;
            int r159 = r158.f399695g + 0;
        L49:
            ConstraintAnchor r160 = r110.N;
            if (r160 == null) goto L52;
            r159 = r159 + r160.f399695g;
        L52:
            r108 = ViewGroup.getChildMeasureSpec(r157, r107 + r159, -1);
            goto L55
        L48:
            r159 = 0;
            goto L49
        L53:
            r108 = ViewGroup.getChildMeasureSpec(this.f400453f, r107, -2);
            goto L55
        L54:
            r108 = View.MeasureSpec.makeMeasureSpec(r104, 1073741824);
            goto L55
        }

        public static boolean a(int r100, int r101, int r102) {
            if (r100 != r101) goto L5;
            return true;
        L5:
            int r103 = View.MeasureSpec.getMode(r100);
            int r104 = View.MeasureSpec.getMode(r101);
            int r105 = View.MeasureSpec.getSize(r101);
            if (r104 == 1073741824) goto L8;
        L12:
            return false;
        L8:
            if (r103 == Integer.MIN_VALUE) goto L10;
            if (r103 != 0) goto L12;
        L10:
            if (r102 != r105) goto L12;
            return true;
        }
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.f400394h = true;
        super.forceLayout();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f400394h = true;
        super.requestLayout();
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public static com.obric.oui.constraintlayout.widget.b getSharedValues() {
        if (f400386p != null) goto L6;
        f400386p = new com.obric.oui.constraintlayout.widget.b();
    L6:
        return f400386p;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public int getOptimizationLevel() {
        return this.f400389c.K0;
    }

    public String getSceneString() {
        StringBuilder r100 = new StringBuilder();
        if (this.f400389c.f399723l != null) goto L8;
        int r101 = getId();
        if (r101 == (-1)) goto L7;
        this.f400389c.f399723l = getContext().getResources().getResourceEntryName(r101);
        goto L8
    L7:
        this.f400389c.f399723l = "parent";
    L8:
        d r102 = this.f400389c;
        if (r102.f399726m0 != null) goto L11;
        r102.f399726m0 = r102.f399723l;
    L11:
        Iterator<ConstraintWidget> r103 = r102.f550644x0.iterator();
    L13:
        if (r103.hasNext() == false) goto L24;
        ConstraintWidget r104 = r103.next();
        View r105 = (View) r104.f399720j0;
        if (r105 == null) goto L13;
        if (r104.f399723l != null) goto L22;
        int r106 = r105.getId();
        if (r106 == (-1)) goto L22;
        r104.f399723l = getContext().getResources().getResourceEntryName(r106);
    L22:
        if (r104.f399726m0 != null) goto L13;
        r104.f399726m0 = r104.f399723l;
        goto L13
    L24:
        this.f400389c.q(r100);
        return r100.toString();
    }

    private int getPaddingWidth() {
        int r100 = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int r101 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        if (r101 > 0) goto L5;
        return r100;
    L5:
        return r101;
    }

    public final boolean e() {
        if ((getContext().getApplicationInfo().flags & 4194304) == 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        return false;
    L8:
        if (1 != getLayoutDirection()) goto L12;
        return true;
    L12:
        return false;
    L5:
        r100 = false;
        goto L6
    }

    public int getMaxHeight() {
        return this.f400393g;
    }

    public int getMaxWidth() {
        return this.f400392f;
    }

    public int getMinHeight() {
        return this.f400391e;
    }

    public int getMinWidth() {
        return this.f400390d;
    }

    public ConstraintLayout(Context r100) {
        super(r100);
        this.f400387a = new SparseArray();
        this.f400388b = new ArrayList(4);
        this.f400389c = new d();
        this.f400390d = 0;
        this.f400391e = 0;
        this.f400392f = Integer.MAX_VALUE;
        this.f400393g = Integer.MAX_VALUE;
        this.f400394h = true;
        this.f400395i = 257;
        this.f400396j = null;
        this.f400397k = null;
        this.f400398l = -1;
        this.f400399m = new HashMap();
        this.f400400n = new SparseArray();
        this.f400401o = new b(this, this);
        d(null, 0);
    }

    public final View b(int r100) {
        return this.f400387a.get(r100);
    }

    public final ConstraintWidget c(View r100) {
        if (r100 == this) goto L4;
        if (r100 != null) goto L7;
        return null;
    L7:
        if ((r100.getLayoutParams() instanceof LayoutParams) == true) goto L9;
        r100.setLayoutParams(generateLayoutParams(r100.getLayoutParams()));
        if ((r100.getLayoutParams() instanceof LayoutParams) == true) goto L13;
        return null;
    L13:
        return ((LayoutParams) r100.getLayoutParams()).f400436q0;
    L9:
        return ((LayoutParams) r100.getLayoutParams()).f400436q0;
    L4:
        return this.f400389c;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r110) {
        ArrayList<ConstraintHelper> r100 = this.f400388b;
        if (r100 == null) goto L9;
        int r101 = r100.size();
        if (r101 <= 0) goto L9;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L9;
        ((ConstraintHelper) ListProtector.get(this.f400388b, r102)).r(this);
        r102 = r102 + 1;
    L9:
        super.dispatchDraw(r110);
        if (isInEditMode() == false) goto L24;
        float r103 = getWidth();
        float r104 = getHeight();
        int r105 = getChildCount();
        int r106 = 0;
    L12:
        if (r106 >= r105) goto L32;
        View r107 = getChildAt(r106);
        if (r107.getVisibility() == 8) goto L23;
        Object r108 = r107.getTag();
        if (r108 == null) goto L23;
        if ((r108 instanceof String) == false) goto L23;
        String[] r109 = ((String) r108).split(",");
        if (r109.length != 4) goto L23;
        int r111 = CastIntegerProtector.parseInt(r109[0]);
        int r112 = CastIntegerProtector.parseInt(r109[1]);
        int r113 = CastIntegerProtector.parseInt(r109[2]);
        int r114 = (int) ((r111 / 1080.0f) * r103);
        int r115 = (int) ((r112 / 1920.0f) * r104);
        int r116 = (int) ((CastIntegerProtector.parseInt(r109[3]) / 1920.0f) * r104);
        Paint r117 = new Paint();
        r117.setColor(-65536);
        float r118 = r114;
        float r119 = r115;
        float r120 = r114 + ((int) ((r113 / 1080.0f) * r103));
        r110.drawLine(r118, r119, r120, r119, r117);
        float r121 = r115 + r116;
        r110.drawLine(r120, r119, r120, r121, r117);
        r110.drawLine(r120, r121, r118, r121, r117);
        r110.drawLine(r118, r121, r118, r119, r117);
        r117.setColor(FakePickerAvatarCreator.GREEN);
        r110.drawLine(r118, r119, r120, r121, r117);
        r110.drawLine(r118, r121, r120, r119, r117);
    L23:
        r106 = r106 + 1;
        goto L12
    L32:
        return;
    }

    public void f(int r100) {
        this.f400397k = new wla.a(getContext(), this, r100);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r100) {
        super.onViewAdded(r100);
        ConstraintWidget r101 = c(r100);
        if ((r100 instanceof Guideline) == false) goto L8;
        if ((r101 instanceof f) == true) goto L8;
        LayoutParams r102 = (LayoutParams) r100.getLayoutParams();
        f r103 = new f();
        r102.f400436q0 = r103;
        r102.f400410d0 = true;
        r103.U(r102.V);
    L8:
        if ((r100 instanceof ConstraintHelper) == false) goto L12;
        ConstraintHelper r104 = (ConstraintHelper) r100;
        r104.t();
        ((LayoutParams) r100.getLayoutParams()).f400412e0 = true;
        if (this.f400388b.contains(r104) == true) goto L12;
        this.f400388b.add(r104);
    L12:
        this.f400387a.put(r100.getId(), r100);
        this.f400394h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r100) {
        super.onViewRemoved(r100);
        this.f400387a.remove(r100.getId());
        ConstraintWidget r101 = c(r100);
        this.f400389c.f550644x0.remove(r101);
        r101.F();
        this.f400388b.remove(r100);
        this.f400394h = true;
    }

    public void setConstraintSet(com.obric.oui.constraintlayout.widget.a r100) {
        this.f400396j = r100;
    }

    @Override // android.view.View
    public void setId(int r100) {
        this.f400387a.remove(getId());
        super.setId(r100);
        this.f400387a.put(getId(), this);
    }

    public void setMaxHeight(int r100) {
        if (r100 != this.f400393g) goto L5;
        return;
    L5:
        this.f400393g = r100;
        requestLayout();
    }

    public void setMaxWidth(int r100) {
        if (r100 != this.f400392f) goto L5;
        return;
    L5:
        this.f400392f = r100;
        requestLayout();
    }

    public void setMinHeight(int r100) {
        if (r100 != this.f400391e) goto L5;
        return;
    L5:
        this.f400391e = r100;
        requestLayout();
    }

    public void setMinWidth(int r100) {
        if (r100 != this.f400390d) goto L5;
        return;
    L5:
        this.f400390d = r100;
        requestLayout();
    }

    public void setOnConstraintsChanged(wla.b r100) {
        wla.a r101 = this.f400397k;
        if (r101 == null) goto L6;
        r101.getClass();
        return;
    }

    public void setOptimizationLevel(int r100) {
        this.f400395i = r100;
        d r101 = this.f400389c;
        r101.K0 = r100;
        c.f399634q = r101.Y(512);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new LayoutParams(r100);
    }

    public ConstraintLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f400387a = new SparseArray();
        this.f400388b = new ArrayList(4);
        this.f400389c = new d();
        this.f400390d = 0;
        this.f400391e = 0;
        this.f400392f = Integer.MAX_VALUE;
        this.f400393g = Integer.MAX_VALUE;
        this.f400394h = true;
        this.f400395i = 257;
        this.f400396j = null;
        this.f400397k = null;
        this.f400398l = -1;
        this.f400399m = new HashMap();
        this.f400400n = new SparseArray();
        this.f400401o = new b(this, this);
        d(r101, 0);
    }

    private void d(AttributeSet r100, int r101) {
        d r102 = this.f400389c;
        r102.f399720j0 = this;
        b r103 = this.f400401o;
        r102.B0 = r103;
        r102.f399835z0.f399799f = r103;
        this.f400387a.put(getId(), this);
        this.f400396j = null;
        if (r100 == null) goto L37;
        TypedArray r104 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.orientation, R.attr.padding, R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.paddingStart, R.attr.paddingEnd, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.elevation, R.attr.layout_marginHorizontal, R.attr.layout_marginVertical, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.circularflow_angles, com.larus.nova.R.attr.circularflow_defaultAngle, com.larus.nova.R.attr.circularflow_defaultRadius, com.larus.nova.R.attr.circularflow_radiusInDP, com.larus.nova.R.attr.circularflow_viewCenter, com.larus.nova.R.attr.constraintSet, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layoutDescription, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_optimizationLevel, com.larus.nova.R.attr.layout_wrapBehaviorInParent}, r101, 0);
        int r105 = r104.getIndexCount();
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L36;
        int r107 = r104.getIndex(r106);
        if (r107 != 16) goto L10;
        this.f400390d = r104.getDimensionPixelOffset(r107, this.f400390d);
    L35:
        r106 = r106 + 1;
        goto L5
    L10:
        if (r107 != 17) goto L13;
        this.f400391e = r104.getDimensionPixelOffset(r107, this.f400391e);
        goto L35
    L13:
        if (r107 != 14) goto L16;
        this.f400392f = r104.getDimensionPixelOffset(r107, this.f400392f);
        goto L35
    L16:
        if (r107 != 15) goto L19;
        this.f400393g = r104.getDimensionPixelOffset(r107, this.f400393g);
        goto L35
    L19:
        if (r107 != 113) goto L22;
        this.f400395i = r104.getInt(r107, this.f400395i);
        goto L35
    L22:
        if (r107 != 56) goto L29;
        int r108 = r104.getResourceId(r107, 0);
        if (r108 == 0) goto L35;
        f(r108);     // Catch: Resources.NotFoundException -> L27
    L27:
        this.f400397k = null;
        goto L35
    L29:
        if (r107 != 34) goto L35;
        int r109 = r104.getResourceId(r107, 0);
        com.obric.oui.constraintlayout.widget.a r110 = new com.obric.oui.constraintlayout.widget.a();     // Catch: Resources.NotFoundException -> L33
        this.f400396j = r110;     // Catch: Resources.NotFoundException -> L33
        r110.j(getContext(), r109);     // Catch: Resources.NotFoundException -> L33
    L34:
        this.f400398l = r109;
    L33:
        this.f400396j = null;
        goto L34
    L36:
        r104.recycle();
    L37:
        d r111 = this.f400389c;
        r111.K0 = this.f400395i;
        c.f399634q = r111.Y(512);
    }

    @Override // android.view.View
    public void onMeasure(int r110, int r111) {
        boolean r100 = this.f400394h | false;
        this.f400394h = r100;
        if (r100 == true) goto L10;
        int r101 = getChildCount();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L10;
        if (getChildAt(r102).isLayoutRequested() == true) goto L8;
        r102 = r102 + 1;
        goto L5
    L8:
        this.f400394h = true;
    L10:
        d r103 = this.f400389c;
        r103.C0 = e();
        if (this.f400394h == false) goto L117;
        this.f400394h = false;
        int r104 = getChildCount();
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L18;
        if (getChildAt(r105).isLayoutRequested() == true) goto L16;
        r105 = r105 + 1;
        goto L13
    L16:
        boolean r106 = true;
    L19:
        if (r106 == false) goto L115;
        boolean r107 = isInEditMode();
        int r108 = getChildCount();
        int r109 = 0;
    L21:
        if (r109 >= r108) goto L28;
        ConstraintWidget r112 = c(getChildAt(r109));
        if (r112 == null) goto L26;
        r112.F();
    L26:
        r109 = r109 + 1;
        goto L21
    L28:
        if (r107 == false) goto L54;
        int r113 = 0;
    L30:
        if (r113 >= r108) goto L54;
        View r114 = getChildAt(r113);
        String r115 = getResources().getResourceName(r114.getId());     // Catch: Resources.NotFoundException -> L119
        i(0, r115, Integer.valueOf(r114.getId()));     // Catch: Resources.NotFoundException -> L119
        int r116 = r115.indexOf(47);     // Catch: Resources.NotFoundException -> L119
        if (r116 == (-1)) goto L35;
        r115 = r115.substring(r116 + 1);     // Catch: Resources.NotFoundException -> L119
    L35:
        int r117 = r114.getId();     // Catch: Resources.NotFoundException -> L119
        if (r117 != 0) goto L38;
        ConstraintWidget r118 = this.f400389c;     // Catch: Resources.NotFoundException -> L119
    L51:
        r118.f399726m0 = r115;     // Catch: Resources.NotFoundException -> L119
        goto L52
    L38:
        View r119 = this.f400387a.get(r117);     // Catch: Resources.NotFoundException -> L119
        if (r119 != null) goto L46;
        r119 = findViewById(r117);     // Catch: Resources.NotFoundException -> L119
        if (r119 == null) goto L46;
        if (r119 == this) goto L46;
        if (r119.getParent() != this) goto L46;
        onViewAdded(r119);     // Catch: Resources.NotFoundException -> L119
    L46:
        if (r119 != this) goto L48;
        r118 = this.f400389c;     // Catch: Resources.NotFoundException -> L119
        goto L51
    L48:
        if (r119 != null) goto L50;
        r118 = null;
        goto L51
    L50:
        r118 = ((LayoutParams) r119.getLayoutParams()).f400436q0;     // Catch: Resources.NotFoundException -> L119
    L52:
        r113 = r113 + 1;
    L54:
        if (this.f400398l == (-1)) goto L63;
        int r120 = 0;
    L56:
        if (r120 >= r108) goto L63;
        View r121 = getChildAt(r120);
        if (r121.getId() != this.f400398l) goto L62;
        if ((r121 instanceof Constraints) == false) goto L62;
        this.f400396j = ((Constraints) r121).getConstraintSet();
    L62:
        r120 = r120 + 1;
    L63:
        com.obric.oui.constraintlayout.widget.a r122 = this.f400396j;
        if (r122 == null) goto L66;
        r122.c(this);
    L66:
        this.f400389c.f550644x0.clear();
        int r123 = this.f400388b.size();
        if (r123 <= 0) goto L89;
        int r124 = 0;
    L69:
        if (r124 >= r123) goto L89;
        ConstraintHelper r125 = (ConstraintHelper) ListProtector.get(this.f400388b, r124);
        if (r125.isInEditMode() == false) goto L73;
        r125.setIds(r125.f400382f);
    L73:
        ula.b r126 = r125.f400380d;
        if (r126 == null) goto L88;
        r126.removeAllIds();
        int r127 = 0;
    L78:
        if (r127 >= r125.f400378b) goto L87;
        int r128 = r125.f400377a[r127];
        View r129 = b(r128);
        if (r129 != null) goto L84;
        String r130 = r125.f400385i.get(Integer.valueOf(r128));
        int r131 = r125.k(this, r130);
        if (r131 == 0) goto L84;
        r125.f400377a[r127] = r131;
        r125.f400385i.put(Integer.valueOf(r131), r130);
        r129 = b(r131);
    L84:
        if (r129 == null) goto L86;
        r125.f400380d.b(c(r129));
    L86:
        r127 = r127 + 1;
        goto L78
    L87:
        r125.f400380d.a();
    L88:
        r124 = r124 + 1;
    L89:
        int r132 = 0;
    L90:
        if (r132 >= r108) goto L102;
        View r133 = getChildAt(r132);
        if ((r133 instanceof Placeholder) == false) goto L101;
        Placeholder r134 = (Placeholder) r133;
        if (r134.f400467a == (-1)) goto L96;
    L98:
        View r135 = findViewById(r134.f400467a);
        r134.f400468b = r135;
        if (r135 == null) goto L101;
        ((LayoutParams) r135.getLayoutParams()).f400414f0 = true;
        r134.f400468b.setVisibility(0);
        r134.setVisibility(0);
        goto L101
    L96:
        if (r134.isInEditMode() == true) goto L98;
        r134.setVisibility(r134.f400469c);
    L101:
        r132 = r132 + 1;
        goto L90
    L102:
        this.f400400n.clear();
        this.f400400n.put(0, this.f400389c);
        this.f400400n.put(getId(), this.f400389c);
        int r136 = 0;
    L103:
        if (r136 >= r108) goto L105;
        View r137 = getChildAt(r136);
        ConstraintWidget r138 = c(r137);
        this.f400400n.put(r137.getId(), r138);
        r136 = r136 + 1;
        goto L103
    L105:
        int r139 = 0;
    L106:
        if (r139 >= r108) goto L115;
        View r140 = getChildAt(r139);
        ConstraintWidget r141 = c(r140);
        if (r141 == null) goto L114;
        LayoutParams r142 = (LayoutParams) r140.getLayoutParams();
        d r143 = this.f400389c;
        r143.f550644x0.add(r141);
        ConstraintWidget r144 = r141.X;
        if (r144 == null) goto L113;
        ((ula.c) r144).f550644x0.remove(r141);
        r141.F();
    L113:
        r141.X = r143;
        a(r107, r140, r141, r142, this.f400400n);
    L114:
        r139 = r139 + 1;
    L115:
        if (r106 == false) goto L117;
        d r145 = this.f400389c;
        r145.f399834y0.c(r145);
        goto L117
    L18:
        r106 = false;
    L117:
        this.f400389c.D0.getClass();
        h(this.f400389c, this.f400395i, r110, r111);
        int r146 = this.f400389c.t();
        int r147 = this.f400389c.n();
        d r148 = this.f400389c;
        g(r110, r111, r146, r147, r148.L0, r148.M0);
    }

    public ConstraintLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f400387a = new SparseArray();
        this.f400388b = new ArrayList(4);
        this.f400389c = new d();
        this.f400390d = 0;
        this.f400391e = 0;
        this.f400392f = Integer.MAX_VALUE;
        this.f400393g = Integer.MAX_VALUE;
        this.f400394h = true;
        this.f400395i = 257;
        this.f400396j = null;
        this.f400397k = null;
        this.f400398l = -1;
        this.f400399m = new HashMap();
        this.f400400n = new SparseArray();
        this.f400401o = new b(this, this);
        d(r101, r102);
    }

    public final void i(int r100, Object r101, Object r102) {
        if ((r101 instanceof String) == true) goto L5;
        return;
    L5:
        if ((r102 instanceof Integer) == true) goto L7;
        return;
    L7:
        if (this.f400399m != null) goto L9;
        this.f400399m = new HashMap();
    L9:
        String r103 = (String) r101;
        int r104 = r103.indexOf(HTTP.URL_DEFAULT);
        if (r104 == (-1)) goto L12;
        r103 = r103.substring(r104 + 1);
    L12:
        int r105 = ((Integer) r102).intValue();
        this.f400399m.put(r103, Integer.valueOf(r105));
    }

    public final void h(d r210, int r211, int r212, int r213) {
        d r100 = r210;
        int r101 = View.MeasureSpec.getMode(r212);
        int r102 = View.MeasureSpec.getSize(r212);
        int r103 = View.MeasureSpec.getMode(r213);
        int r104 = View.MeasureSpec.getSize(r213);
        int r105 = Math.max(0, getPaddingTop());
        int r106 = Math.max(0, getPaddingBottom());
        int r110 = r105 + r106;
        int r111 = getPaddingWidth();
        b r112 = this.f400401o;
        r112.f400449b = r105;
        r112.f400450c = r106;
        r112.f400451d = r111;
        r112.f400452e = r110;
        r112.f400453f = r212;
        r112.f400454g = r213;
        int r107 = Math.max(0, getPaddingStart());
        int r113 = Math.max(0, getPaddingEnd());
        if (r107 > 0) goto L8;
        if (r113 > 0) goto L8;
        r107 = Math.max(0, getPaddingLeft());
    L10:
        int r108 = r102 - r111;
        int r109 = r104 - r110;
        b r114 = this.f400401o;
        int r115 = r114.f400452e;
        int r116 = r114.f400451d;
        ConstraintWidget.DimensionBehaviour r117 = ConstraintWidget.DimensionBehaviour.FIXED;
        int r118 = getChildCount();
        if (r101 == Integer.MIN_VALUE) goto L20;
        if (r101 == 0) goto L16;
        if (r101 == 1073741824) goto L15;
        ConstraintWidget.DimensionBehaviour r119 = r117;
    L19:
        ConstraintWidget.DimensionBehaviour r120 = r119;
        int r121 = Integer.MIN_VALUE;
        int r122 = 0;
    L26:
        if (r103 == r121) goto L36;
        if (r103 != 0) goto L29;
        r117 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r118 != 0) goto L35;
        int r123 = Math.max(0, this.f400391e);
    L41:
        if (r122 == r210.t()) goto L43;
    L44:
        r100.f399835z0.f399796c = true;
    L45:
        r100.f399706c0 = 0;
        r100.f399708d0 = 0;
        int r124 = this.f400392f - r116;
        int[] r125 = r100.E;
        r125[0] = r124;
        r125[1] = this.f400393g - r115;
        r100.f399712f0 = 0;
        r100.f399714g0 = 0;
        r100.O(r120);
        r100.Q(r122);
        r100.P(r117);
        r100.N(r123);
        int r126 = this.f400390d - r116;
        if (r126 >= 0) goto L48;
        int r127 = 0;
        r100.f399712f0 = 0;
    L49:
        int r128 = this.f400391e - r115;
        if (r128 >= 0) goto L52;
        r100.f399714g0 = r127;
    L53:
        r100.E0 = r107;
        r100.F0 = r105;
        com.obric.oui.constraintlayout.core.widgets.analyzer.b r129 = r100.f399834y0;
        r129.getClass();
        com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC4669b r130 = r100.B0;
        int r131 = r100.f550644x0.size();
        int r132 = r210.t();
        int r133 = r210.n();
        boolean r134 = g.b(r211, 128);
        if (r134 == false) goto L56;
    L59:
        boolean r135 = true;
    L60:
        if (r135 == false) goto L96;
        int r136 = 0;
    L62:
        if (r136 >= r131) goto L96;
        ConstraintWidget r137 = (ConstraintWidget) ListProtector.get(r100.f550644x0, r136);
        ConstraintWidget.DimensionBehaviour[] r138 = r137.W;
        ConstraintWidget.DimensionBehaviour r139 = r138[0];
        ConstraintWidget.DimensionBehaviour r140 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r139 != r140) goto L66;
        boolean r141 = true;
    L68:
        if (r138[1] != r140) goto L70;
        boolean r142 = true;
    L71:
        if (r141 == false) goto L76;
        if (r142 == false) goto L76;
        if (r137.f399702a0 <= 0.0f) goto L76;
        boolean r143 = true;
    L78:
        if (r137.A() == false) goto L82;
        if (r143 == false) goto L82;
    L94:
        r135 = false;
    L82:
        if (r137.B() == false) goto L86;
        if (r143 == true) goto L94;
    L86:
        if ((r137 instanceof i) == true) goto L94;
        if (r137.A() == true) goto L94;
        if (r137.B() == true) goto L94;
        r136 = r136 + 1;
    L76:
        r143 = false;
        goto L78
    L70:
        r142 = false;
        goto L71
    L66:
        r141 = false;
    L96:
        if (r101 != 1073741824) goto L98;
        if (r103 != 1073741824) goto L98;
    L99:
        boolean r144 = true;
    L101:
        boolean r145 = r135 & r144;
        if (r145 == false) goto L221;
        int r146 = Math.min(r100.E[0], r108);
        int r147 = Math.min(r100.E[1], r109);
        if (r101 == 1073741824) goto L106;
    L108:
        int r148 = 1073741824;
        if (r103 == 1073741824) goto L111;
        boolean r149 = true;
    L116:
        if (r101 != r148) goto L199;
        if (r103 != r148) goto L199;
        e r150 = r100.f399835z0;
        boolean r151 = r134 & r149;
        if (r150.f399795b == false) goto L121;
    L124:
        Iterator<ConstraintWidget> r152 = r150.f399794a.f550644x0.iterator();
    L126:
        if (r152.hasNext() == false) goto L128;
        ConstraintWidget r153 = r152.next();
        r153.k();
        r153.f399701a = false;
        r153.f399707d.m();
        r153.f399709e.l();
        goto L126
    L128:
        int r154 = 0;
        r150.f399794a.k();
        d r155 = r150.f399794a;
        r155.f399701a = false;
        r155.f399707d.m();
        r150.f399794a.f399709e.l();
        r150.f399796c = false;
    L129:
        r150.b(r150.f399797d);
        d r156 = r150.f399794a;
        r156.f399706c0 = r154;
        r156.f399708d0 = r154;
        ConstraintWidget.DimensionBehaviour r157 = r156.m(r154);
        ConstraintWidget.DimensionBehaviour r158 = r150.f399794a.m(1);
        if (r150.f399795b == false) goto L132;
        r150.c();
    L132:
        int r159 = r150.f399794a.u();
        int r160 = r150.f399794a.v();
        r150.f399794a.f399707d.f399774h.c(r159);
        r150.f399794a.f399709e.f399774h.c(r160);
        r150.g();
        ConstraintWidget.DimensionBehaviour r161 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r157 == r161) goto L137;
        if (r158 == r161) goto L137;
        r145 = r145;
        r130 = r130;
    L153:
        d r162 = r150.f399794a;
        ConstraintWidget.DimensionBehaviour r163 = r162.W[0];
        ConstraintWidget.DimensionBehaviour r164 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r163 != r164) goto L156;
    L159:
        int r165 = r162.t() + r159;
        r150.f399794a.f399707d.f399775i.c(r165);
        r150.f399794a.f399707d.f399771e.c(r165 - r159);
        r150.g();
        d r166 = r150.f399794a;
        ConstraintWidget.DimensionBehaviour r167 = r166.W[1];
        if (r167 != r164) goto L162;
    L163:
        int r168 = r166.n() + r160;
        r150.f399794a.f399709e.f399775i.c(r168);
        r150.f399794a.f399709e.f399771e.c(r168 - r160);
    L164:
        r150.g();
        boolean r169 = true;
    L165:
        Iterator<WidgetRun> r170 = r150.f399798e.iterator();
    L167:
        if (r170.hasNext() == false) goto L174;
        WidgetRun r171 = r170.next();
        if (r171.f399768b != r150.f399794a) goto L173;
        if (r171.f399773g == false) goto L167;
    L173:
        r171.d();
        goto L167
    L174:
        Iterator<WidgetRun> r172 = r150.f399798e.iterator();
    L176:
        if (r172.hasNext() == false) goto L197;
        WidgetRun r173 = r172.next();
        if (r169 == true) goto L183;
        if (r173.f399768b == r150.f399794a) goto L176;
    L183:
        if (r173.f399774h.f399763j == false) goto L196;
        if (r173.f399775i.f399763j == true) goto L191;
        if ((r173 instanceof com.obric.oui.constraintlayout.core.widgets.analyzer.i) == false) goto L196;
    L191:
        if (r173.f399771e.f399763j == true) goto L176;
        if ((r173 instanceof com.obric.oui.constraintlayout.core.widgets.analyzer.c) == true) goto L176;
        if ((r173 instanceof com.obric.oui.constraintlayout.core.widgets.analyzer.i) == true) goto L176;
    L196:
        boolean r174 = false;
    L198:
        r150.f399794a.O(r157);
        r150.f399794a.P(r158);
        boolean r175 = r174;
        int r176 = 1073741824;
        int r177 = 2;
    L213:
        if (r175 == false) goto L222;
        if (r101 != r176) goto L216;
        boolean r178 = true;
    L217:
        if (r103 != r176) goto L219;
        boolean r179 = true;
    L220:
        r100.R(r178, r179);
        goto L222
    L219:
        r179 = false;
        goto L220
    L216:
        r178 = false;
    L222:
        if (r175 == true) goto L224;
    L225:
        int r180 = r100.K0;
        if (r131 <= 0) goto L306;
        int r181 = r100.f550644x0.size();
        boolean r182 = r100.Y(64);
        com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC4669b r183 = r100.B0;
        int r184 = 0;
    L228:
        if (r184 >= r181) goto L286;
        ConstraintWidget r185 = (ConstraintWidget) ListProtector.get(r100.f550644x0, r184);
        if ((r185 instanceof f) == true) goto L285;
        if ((r185 instanceof com.obric.oui.constraintlayout.core.widgets.a) == true) goto L285;
        if (r185.I == true) goto L285;
        if (r182 == false) goto L248;
        k r186 = r185.f399707d;
        if (r186 == null) goto L248;
        m r187 = r185.f399709e;
        if (r187 == null) goto L248;
        if (r186.f399771e.f399763j == false) goto L248;
        if (r187.f399771e.f399763j == true) goto L285;
    L248:
        ConstraintWidget.DimensionBehaviour r188 = r185.m(0);
        ConstraintWidget.DimensionBehaviour r189 = r185.m(1);
        ConstraintWidget.DimensionBehaviour r190 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r188 == r190) goto L251;
    L256:
        boolean r191 = false;
    L257:
        if (r191 == true) goto L282;
        if (r100.Y(1) == false) goto L282;
        if ((r185 instanceof i) == true) goto L282;
        if (r188 == r190) goto L264;
    L269:
        if (r189 == r190) goto L271;
    L276:
        if (r188 == r190) goto L279;
        if (r189 != r190) goto L282;
    L279:
        if (r185.f399702a0 <= 0.0f) goto L282;
        r191 = true;
        goto L282
    L271:
        if (r185.f399741u != 0) goto L276;
        if (r188 == r190) goto L276;
        if (r185.A() == true) goto L276;
        r191 = true;
        goto L276
    L264:
        if (r185.f399739t != 0) goto L269;
        if (r189 == r190) goto L269;
        if (r185.A() == true) goto L269;
        r191 = true;
    L282:
        if (r191 == true) goto L285;
        r129.a(r183, r185, 0);
        goto L285
    L251:
        if (r185.f399739t == 1) goto L256;
        if (r189 != r190) goto L256;
        if (r185.f399741u == 1) goto L256;
        r191 = true;
    L285:
        r184 = r184 + 1;
        goto L228
    L286:
        b r192 = (b) r183;
        int r193 = r192.f400448a.getChildCount();
        int r194 = 0;
    L287:
        if (r194 >= r193) goto L301;
        View r195 = r192.f400448a.getChildAt(r194);
        if ((r195 instanceof Placeholder) == false) goto L300;
        Placeholder r196 = (Placeholder) r195;
        if (r196.f400468b == null) goto L300;
        LayoutParams r197 = (LayoutParams) r196.getLayoutParams();
        LayoutParams r198 = (LayoutParams) r196.f400468b.getLayoutParams();
        ConstraintWidget r199 = r198.f400436q0;
        r199.f399722k0 = 0;
        ConstraintWidget r1100 = r197.f400436q0;
        ConstraintWidget.DimensionBehaviour r1101 = r1100.W[0];
        ConstraintWidget.DimensionBehaviour r1102 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r1101 == r1102) goto L296;
        r1100.Q(r199.t());
    L296:
        ConstraintWidget r200 = r197.f400436q0;
        if (r200.W[1] == r1102) goto L299;
        r200.N(r198.f400436q0.n());
    L299:
        r198.f400436q0.f399722k0 = 8;
    L300:
        r194 = r194 + 1;
        goto L287
    L301:
        int r201 = r192.f400448a.f400388b.size();
        if (r201 <= 0) goto L306;
        int r1103 = 0;
    L304:
        if (r1103 >= r201) goto L306;
        ((ConstraintHelper) ListProtector.get(r192.f400448a.f400388b, r1103)).getClass();
        r1103 = r1103 + 1;
    L306:
        r129.c(r100);
        int r202 = r129.f399779a.size();
        if (r131 <= 0) goto L309;
        r129.b(r100, 0, r132, r133);
    L309:
        if (r202 <= 0) goto L393;
        ConstraintWidget.DimensionBehaviour[] r203 = r100.W;
        ConstraintWidget.DimensionBehaviour r204 = r203[0];
        ConstraintWidget.DimensionBehaviour r205 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r204 != r205) goto L313;
        boolean r206 = true;
    L315:
        if (r203[1] != r205) goto L317;
        boolean r207 = true;
    L318:
        int r208 = Math.max(r210.t(), r129.f399781c.f399712f0);
        int r209 = Math.max(r210.n(), r129.f399781c.f399714g0);
        int r1104 = 0;
        boolean r1105 = false;
    L319:
        if (r1104 >= r202) goto L341;
        ConstraintWidget r1106 = (ConstraintWidget) ListProtector.get(r129.f399779a, r1104);
        if ((r1106 instanceof i) == true) goto L323;
        com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC4669b r1107 = r130;
    L340:
        r1104 = r1104 + 1;
        r130 = r1107;
        r180 = r180;
        goto L319
    L323:
        int r1108 = r1106.t();
        int r1109 = r1106.n();
        r1107 = r130;
        boolean r214 = r1105 | r129.a(r1107, r1106, 1);
        int r1110 = r1106.t();
        int r215 = r1106.n();
        if (r1110 == r1108) goto L331;
        r1106.Q(r1110);
        if (r206 == true) goto L328;
    L330:
        boolean r1111 = true;
    L332:
        if (r215 == r1109) goto L339;
        r1106.N(r215);
        if (r207 == true) goto L336;
    L338:
        r1111 = true;
        goto L339
    L336:
        if ((r1106.v() + r1106.Z) <= r209) goto L338;
        r209 = Math.max(r209, (r1106.v() + r1106.Z) + r1106.l(ConstraintAnchor.Type.BOTTOM).e());
    L339:
        r1105 = ((i) r1106).F0 | r1111;
        goto L340
    L328:
        if ((r1106.u() + r1106.Y) <= r208) goto L330;
        r208 = Math.max(r208, (r1106.u() + r1106.Y) + r1106.l(ConstraintAnchor.Type.RIGHT).e());
        goto L330
    L331:
        r1111 = r214;
        goto L332
    L341:
        int r1112 = r180;
        com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC4669b r1113 = r130;
        int r216 = 0;
        int r1114 = 2;
    L342:
        if (r216 >= r1114) goto L394;
        boolean r1115 = r1105;
        int r1116 = 0;
    L344:
        if (r1116 >= r202) goto L389;
        ConstraintWidget r1117 = (ConstraintWidget) ListProtector.get(r129.f399779a, r1116);
        if ((r1117 instanceof ula.a) == false) goto L350;
        if ((r1117 instanceof i) == true) goto L350;
    L363:
        int r217 = r202;
    L388:
        r1116 = r1116 + 1;
        r202 = r217;
    L350:
        if ((r1117 instanceof f) == true) goto L363;
        if (r1117.f399722k0 == 8) goto L363;
        if (r145 == false) goto L362;
        if (r1117.f399707d.f399771e.f399763j == false) goto L362;
        if (r1117.f399709e.f399771e.f399763j == true) goto L363;
    L362:
        if ((r1117 instanceof i) == true) goto L363;
        int r1118 = r1117.t();
        int r1119 = r1117.n();
        r217 = r202;
        int r218 = r1117.f399710e0;
        int r219 = 1;
        if (r216 != 1) goto L367;
        r219 = 2;
    L367:
        boolean r220 = r129.a(r1113, r1117, r219) | r1115;
        int r1120 = r1117.t();
        boolean r221 = r220;
        int r222 = r1117.n();
        if (r1120 == r1118) goto L375;
        r1117.Q(r1120);
        if (r206 == true) goto L372;
    L374:
        r221 = true;
        goto L375
    L372:
        if ((r1117.u() + r1117.Y) <= r208) goto L374;
        r208 = Math.max(r208, (r1117.u() + r1117.Y) + r1117.l(ConstraintAnchor.Type.RIGHT).e());
    L375:
        if (r222 == r1119) goto L383;
        r1117.N(r222);
        if (r207 == true) goto L379;
    L381:
        r221 = true;
        goto L383
    L379:
        if ((r1117.v() + r1117.Z) <= r209) goto L381;
        r209 = Math.max(r209, (r1117.v() + r1117.Z) + r1117.l(ConstraintAnchor.Type.BOTTOM).e());
    L383:
        if (r1117.G == true) goto L385;
    L387:
        r1115 = r221;
        goto L388
    L385:
        if (r218 == r1117.f399710e0) goto L387;
        r1115 = true;
        goto L388
    L389:
        int r223 = r202;
        if (r1115 == false) goto L392;
        r216 = r216 + 1;
        r100 = r210;
        r129.b(r100, r216, r132, r133);
        r202 = r223;
        r1114 = 2;
        r1105 = false;
        goto L342
    L392:
        r100 = r210;
    L394:
        r100.K0 = r1112;
        c.f399634q = r100.Y(512);
        return;
    L317:
        r207 = false;
        goto L318
    L313:
        r206 = false;
        goto L315
    L393:
        r1112 = r180;
        goto L394
    L224:
        if (r177 != 2) goto L225;
        return;
    L197:
        r174 = true;
        goto L198
    L162:
        if (r167 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L164;
    L156:
        if (r163 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L159;
        r169 = false;
    L137:
        if (r151 == false) goto L144;
        Iterator<WidgetRun> r224 = r150.f399798e.iterator();
    L140:
        if (r224.hasNext() == false) goto L144;
        if (r224.next().j() == true) goto L140;
        r151 = false;
    L144:
        if (r151 == false) goto L149;
        if (r157 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L149;
        r150.f399794a.O(ConstraintWidget.DimensionBehaviour.FIXED);
        d r225 = r150.f399794a;
        r225.Q(r150.d(r225, 0));
        d r226 = r150.f399794a;
        r226.f399707d.f399771e.c(r226.t());
    L149:
        if (r151 == false) goto L153;
        if (r158 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L153;
        r150.f399794a.P(ConstraintWidget.DimensionBehaviour.FIXED);
        d r227 = r150.f399794a;
        r227.N(r150.d(r227, 1));
        d r228 = r150.f399794a;
        r228.f399709e.f399771e.c(r228.n());
        goto L153
    L121:
        if (r150.f399796c == true) goto L124;
        r154 = 0;
    L199:
        r145 = r145;
        r130 = r130;
        e r229 = r100.f399835z0;
        if (r229.f399795b == false) goto L206;
        Iterator<ConstraintWidget> r230 = r229.f399794a.f550644x0.iterator();
    L203:
        if (r230.hasNext() == false) goto L205;
        ConstraintWidget r231 = r230.next();
        r231.k();
        r231.f399701a = false;
        k r1121 = r231.f399707d;
        r1121.f399771e.f399763j = false;
        r1121.f399773g = false;
        r1121.m();
        m r232 = r231.f399709e;
        r232.f399771e.f399763j = false;
        r232.f399773g = false;
        r232.l();
        goto L203
    L205:
        int r1122 = 0;
        r229.f399794a.k();
        d r233 = r229.f399794a;
        r233.f399701a = false;
        k r234 = r233.f399707d;
        r234.f399771e.f399763j = false;
        r234.f399773g = false;
        r234.m();
        m r235 = r229.f399794a.f399709e;
        r235.f399771e.f399763j = false;
        r235.f399773g = false;
        r235.l();
        r229.c();
    L207:
        r229.b(r229.f399797d);
        d r236 = r229.f399794a;
        r236.f399706c0 = r1122;
        r236.f399708d0 = r1122;
        r236.f399707d.f399774h.c(r1122);
        r229.f399794a.f399709e.f399774h.c(r1122);
        r176 = 1073741824;
        if (r101 != 1073741824) goto L210;
        int r237 = 1;
        r175 = r100.W(r134, r1122) & true;
        r177 = 1;
    L211:
        if (r103 != 1073741824) goto L213;
        r177 = r177 + 1;
        r175 = r100.W(r134, r237) & r175;
        goto L213
    L210:
        r237 = 1;
        r177 = 0;
        r175 = true;
        goto L211
    L206:
        r1122 = 0;
        goto L207
    L111:
        if (r210.n() == r147) goto L113;
        r100.N(r147);
        r149 = true;
        r100.f399835z0.f399795b = true;
    L114:
        r148 = 1073741824;
        goto L116
    L113:
        r149 = true;
        goto L114
    L106:
        if (r210.t() == r146) goto L108;
        r100.Q(r146);
        r100.f399835z0.f399795b = true;
        goto L108
    L221:
        r145 = r145;
        r130 = r130;
        r177 = 0;
        r175 = false;
    L98:
        if (r134 == true) goto L99;
        r144 = false;
        goto L101
    L56:
        if (g.b(r211, 64) == true) goto L59;
        r135 = false;
        goto L60
    L52:
        r100.f399714g0 = r128;
        goto L53
    L48:
        r127 = 0;
        r100.f399712f0 = r126;
        goto L49
    L43:
        if (r123 == r210.n()) goto L45;
    L35:
        r123 = 0;
        goto L41
    L29:
        if (r103 != 1073741824) goto L35;
        r123 = Math.min(this.f400393g - r115, r109);
        goto L41
    L36:
        r117 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r118 != 0) goto L39;
        r123 = Math.max(0, this.f400391e);
        goto L41
    L39:
        r123 = r109;
        goto L41
    L15:
        r122 = Math.min(this.f400392f - r116, r108);
        r120 = r117;
    L24:
        r121 = Integer.MIN_VALUE;
        goto L26
    L16:
        r119 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r118 != 0) goto L19;
        int r1123 = Math.max(0, this.f400390d);
    L23:
        ConstraintWidget.DimensionBehaviour r238 = r119;
        r122 = r1123;
        r120 = r238;
        goto L24
    L20:
        r119 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r118 != 0) goto L25;
        r1123 = Math.max(0, this.f400390d);
        goto L23
    L25:
        r120 = r119;
        r121 = Integer.MIN_VALUE;
        r122 = r108;
    L8:
        if (e() == false) goto L10;
        r107 = r113;
        goto L10
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:153:0x02d2 -> B:154:0x02d3). Please report as a decompilation issue!!! */
    public final void a(boolean r110, View r111, ConstraintWidget r210, LayoutParams r211, SparseArray<ConstraintWidget> r212) {
        r211.a();
        r210.f399722k0 = r111.getVisibility();
        if (r211.f400414f0 == false) goto L5;
        r210.H = true;
        r210.f399722k0 = 8;
    L5:
        r210.f399720j0 = r111;
        if ((r111 instanceof ConstraintHelper) == false) goto L9;
        ((ConstraintHelper) r111).p(r210, this.f400389c.C0);
    L9:
        int r112 = -1;
        if (r211.f400410d0 == false) goto L21;
        f r100 = (f) r210;
        int r101 = r211.f400430n0;
        int r102 = r211.f400432o0;
        float r103 = r211.f400434p0;
        if (r103 == (-1.0f)) goto L15;
        if (r103 <= (-1.0f)) goto L185;
        r100.f399863x0 = r103;
        r100.f399864y0 = -1;
        r100.f399865z0 = -1;
        return;
    L185:
        return;
    L15:
        if (r101 == (-1)) goto L18;
        if (r101 <= (-1)) goto L187;
        r100.f399863x0 = -1.0f;
        r100.f399864y0 = r101;
        r100.f399865z0 = -1;
        return;
    L187:
        return;
    L18:
        if (r102 == (-1)) goto L189;
        if (r102 <= (-1)) goto L190;
        r100.f399863x0 = -1.0f;
        r100.f399864y0 = -1;
        r100.f399865z0 = r102;
        return;
    L190:
        return;
    L189:
        return;
    L21:
        int r104 = r211.f400416g0;
        int r105 = r211.f400418h0;
        int r113 = r211.f400420i0;
        int r114 = r211.f400422j0;
        int r106 = r211.f400424k0;
        int r115 = r211.f400426l0;
        float r116 = r211.f400428m0;
        int r107 = r211.f400433p;
        if (r107 == (-1)) goto L28;
        ConstraintWidget r108 = r212.get(r107);
        if (r108 == null) goto L27;
        float r109 = r211.f400437r;
        int r117 = r211.f400435q;
        ConstraintAnchor.Type r118 = ConstraintAnchor.Type.CENTER;
        r210.y(r118, r108, r118, r117, 0);
        r210.F = r109;
    L27:
        float r119 = 0.0f;
    L81:
        if (r110 == false) goto L87;
        int r120 = r211.T;
        if (r120 == (-1)) goto L85;
    L86:
        int r121 = r211.U;
        r210.f399706c0 = r120;
        r210.f399708d0 = r121;
        goto L87
    L85:
        if (r211.U != (-1)) goto L86;
    L87:
        int r122 = 0;
        if (r211.f400404a0 == false) goto L90;
        r210.O(ConstraintWidget.DimensionBehaviour.FIXED);
        r210.Q(((ViewGroup.MarginLayoutParams) r211).width);
        if (((ViewGroup.MarginLayoutParams) r211).width != (-2)) goto L101;
        r210.O(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L101:
        if (r211.f400406b0 == false) goto L103;
        r210.P(ConstraintWidget.DimensionBehaviour.FIXED);
        r210.N(((ViewGroup.MarginLayoutParams) r211).height);
        if (((ViewGroup.MarginLayoutParams) r211).height != (-2)) goto L113;
        r210.P(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L113:
        String r123 = r211.G;
        if (r123 != null) goto L116;
    L157:
        r210.f399702a0 = r119;
    L158:
        float r124 = r211.H;
        float[] r125 = r210.f399734q0;
        r125[0] = r124;
        r125[1] = r211.I;
        r210.f399730o0 = r211.f400402J;
        r210.f399732p0 = r211.K;
        int r126 = r211.Z;
        if (r126 >= 0) goto L161;
    L163:
        int r127 = r211.L;
        int r128 = r211.N;
        int r129 = r211.P;
        float r130 = r211.R;
        r210.f399739t = r127;
        r210.f399745w = r128;
        if (r129 != Integer.MAX_VALUE) goto L166;
        r129 = 0;
    L166:
        r210.f399747x = r129;
        r210.f399748y = r130;
        if (r130 > r119) goto L169;
    L172:
        int r131 = r211.M;
        int r132 = r211.O;
        int r133 = r211.Q;
        float r134 = r211.S;
        r210.f399741u = r131;
        r210.f399749z = r132;
        if (r133 == Integer.MAX_VALUE) goto L176;
        r122 = r133;
    L176:
        r210.A = r122;
        r210.B = r134;
        if (r134 > r119) goto L179;
        return;
    L179:
        if (r134 >= 1.0f) goto L193;
        if (r131 != 0) goto L194;
        r210.f399741u = 2;
        return;
    L194:
        return;
    L193:
        return;
    L169:
        if (r130 >= 1.0f) goto L172;
        if (r127 != 0) goto L172;
        r210.f399739t = 2;
        goto L172
    L161:
        if (r126 > 3) goto L163;
        r210.f399737s = r126;
        goto L163
    L116:
        if (r123.length() == 0) goto L157;
        int r135 = r123.length();
        int r136 = r123.indexOf(44);
        if (r136 > 0) goto L121;
    L130:
        int r137 = 1;
        int r138 = 0;
    L131:
        int r139 = r123.indexOf(58);
        if (r139 >= 0) goto L134;
    L148:
        String r140 = r123.substring(r138);
        if (r140.length() <= 0) goto L153;
        float r141 = CastFloatProtector.parseFloat(r140);     // Catch: NumberFormatException -> L152
    L154:
        if (r141 <= r119) goto L158;
        r210.f399702a0 = r141;
        r210.f399704b0 = r112;
        goto L158
    L134:
        if (r139 >= (r135 - r137)) goto L148;
        String r142 = r123.substring(r138, r139);
        String r143 = r123.substring(r139 + r137);
        if (r142.length() <= 0) goto L153;
        if (r143.length() <= 0) goto L153;
        float r144 = CastFloatProtector.parseFloat(r142);     // Catch: NumberFormatException -> L152
        float r145 = CastFloatProtector.parseFloat(r143);     // Catch: NumberFormatException -> L152
        if (r144 <= r119) goto L153;
        if (r145 <= r119) goto L153;
        if (r112 != 1) goto L146;
        r141 = Math.abs(r145 / r144);     // Catch: NumberFormatException -> L152
        goto L154
    L146:
        r141 = Math.abs(r144 / r145);     // Catch: NumberFormatException -> L152
    L153:
        r141 = 0.0f;
        goto L154
    L121:
        if (r136 >= (r135 - 1)) goto L130;
        String r146 = r123.substring(0, r136);
        if (r146.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST) == false) goto L126;
        r137 = 1;
        r112 = 0;
    L129:
        r138 = r136 + r137;
        goto L131
    L126:
        if (r146.equalsIgnoreCase(FaceService.neutralLabel) == false) goto L128;
        r137 = 1;
        r112 = 1;
        goto L129
    L128:
        r137 = 1;
        goto L129
    L103:
        if (((ViewGroup.MarginLayoutParams) r211).height == (-1)) goto L105;
        r210.P(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r210.N(0);
        goto L113
    L105:
        if (r211.X == false) goto L107;
        r210.P(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
    L108:
        r210.l(ConstraintAnchor.Type.TOP).f399695g = ((ViewGroup.MarginLayoutParams) r211).topMargin;
        r210.l(ConstraintAnchor.Type.BOTTOM).f399695g = ((ViewGroup.MarginLayoutParams) r211).bottomMargin;
        goto L113
    L107:
        r210.P(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        goto L108
    L90:
        if (((ViewGroup.MarginLayoutParams) r211).width == (-1)) goto L92;
        r210.O(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r210.Q(0);
        goto L101
    L92:
        if (r211.W == false) goto L94;
        r210.O(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
    L95:
        r210.l(ConstraintAnchor.Type.LEFT).f399695g = ((ViewGroup.MarginLayoutParams) r211).leftMargin;
        r210.l(ConstraintAnchor.Type.RIGHT).f399695g = ((ViewGroup.MarginLayoutParams) r211).rightMargin;
        goto L101
    L94:
        r210.O(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        goto L95
    L28:
        if (r104 == (-1)) goto L33;
        ConstraintWidget r147 = r212.get(r104);
        if (r147 == null) goto L32;
        ConstraintAnchor.Type r148 = ConstraintAnchor.Type.LEFT;
        r119 = 0.0f;
        r210.y(r148, r147, r148, ((ViewGroup.MarginLayoutParams) r211).leftMargin, r106);
    L38:
        if (r113 == (-1)) goto L42;
        ConstraintWidget r149 = r212.get(r113);
        if (r149 == null) goto L46;
        r210.y(ConstraintAnchor.Type.RIGHT, r149, ConstraintAnchor.Type.LEFT, ((ViewGroup.MarginLayoutParams) r211).rightMargin, r115);
    L46:
        int r150 = r211.f400419i;
        if (r150 == (-1)) goto L51;
        ConstraintWidget r151 = r212.get(r150);
        if (r151 == null) goto L56;
        ConstraintAnchor.Type r152 = ConstraintAnchor.Type.TOP;
        r210.y(r152, r151, r152, ((ViewGroup.MarginLayoutParams) r211).topMargin, r211.f400443x);
    L56:
        int r153 = r211.f400423k;
        if (r153 == (-1)) goto L61;
        ConstraintWidget r154 = r212.get(r153);
        if (r154 == null) goto L66;
        r210.y(ConstraintAnchor.Type.BOTTOM, r154, ConstraintAnchor.Type.TOP, ((ViewGroup.MarginLayoutParams) r211).bottomMargin, r211.f400445z);
    L66:
        int r155 = r211.f400427m;
        if (r155 == (-1)) goto L69;
        j(r210, r211, r212, r155, ConstraintAnchor.Type.BASELINE);
    L76:
        if (r116 < r119) goto L78;
        r210.f399716h0 = r116;
    L78:
        float r156 = r211.F;
        if (r156 < r119) goto L81;
        r210.f399718i0 = r156;
        goto L81
    L69:
        int r157 = r211.f400429n;
        if (r157 == (-1)) goto L72;
        j(r210, r211, r212, r157, ConstraintAnchor.Type.TOP);
        goto L76
    L72:
        int r158 = r211.f400431o;
        if (r158 == (-1)) goto L76;
        j(r210, r211, r212, r158, ConstraintAnchor.Type.BOTTOM);
        goto L76
    L61:
        int r159 = r211.f400425l;
        if (r159 == (-1)) goto L66;
        ConstraintWidget r160 = r212.get(r159);
        if (r160 == null) goto L66;
        ConstraintAnchor.Type r161 = ConstraintAnchor.Type.BOTTOM;
        r210.y(r161, r160, r161, ((ViewGroup.MarginLayoutParams) r211).bottomMargin, r211.f400445z);
        goto L66
    L51:
        int r162 = r211.f400421j;
        if (r162 == (-1)) goto L56;
        ConstraintWidget r163 = r212.get(r162);
        if (r163 == null) goto L56;
        r210.y(ConstraintAnchor.Type.TOP, r163, ConstraintAnchor.Type.BOTTOM, ((ViewGroup.MarginLayoutParams) r211).topMargin, r211.f400443x);
        goto L56
    L42:
        if (r114 == (-1)) goto L46;
        ConstraintWidget r164 = r212.get(r114);
        if (r164 == null) goto L46;
        ConstraintAnchor.Type r165 = ConstraintAnchor.Type.RIGHT;
        r210.y(r165, r164, r165, ((ViewGroup.MarginLayoutParams) r211).rightMargin, r115);
        goto L46
    L32:
        r119 = 0.0f;
        goto L38
    L33:
        r119 = 0.0f;
        if (r105 == (-1)) goto L38;
        ConstraintWidget r166 = r212.get(r105);
        if (r166 == null) goto L38;
        r210.y(ConstraintAnchor.Type.LEFT, r166, ConstraintAnchor.Type.RIGHT, ((ViewGroup.MarginLayoutParams) r211).leftMargin, r106);
        goto L38
    }

    public final void j(ConstraintWidget r100, LayoutParams r101, SparseArray<ConstraintWidget> r102, int r103, ConstraintAnchor.Type r104) {
        View r105 = this.f400387a.get(r103);
        ConstraintWidget r106 = r102.get(r103);
        if (r106 == null) goto L12;
        if (r105 != null) goto L6;
        return;
    L6:
        if ((r105.getLayoutParams() instanceof LayoutParams) == false) goto L14;
        r101.f400408c0 = true;
        ConstraintAnchor.Type r107 = ConstraintAnchor.Type.BASELINE;
        if (r104 != r107) goto L10;
        LayoutParams r108 = (LayoutParams) r105.getLayoutParams();
        r108.f400408c0 = true;
        r108.f400436q0.G = true;
    L10:
        r100.l(r107).b(r106.l(r104), r101.D, r101.C, true);
        r100.G = true;
        r100.l(ConstraintAnchor.Type.TOP).j();
        r100.l(ConstraintAnchor.Type.BOTTOM).j();
        return;
    L14:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r110) {
        int r104 = getChildCount();
        boolean r105 = isInEditMode();
        int r106 = 0;
        int r107 = 0;
    L3:
        if (r107 >= r104) goto L21;
        View r111 = getChildAt(r107);
        LayoutParams r108 = (LayoutParams) r111.getLayoutParams();
        ConstraintWidget r109 = r108.f400436q0;
        if (r111.getVisibility() != 8) goto L13;
        if (r108.f400410d0 == true) goto L13;
        if (r108.f400412e0 == true) goto L13;
        if (r105 == true) goto L13;
    L20:
        r107 = r107 + 1;
    L13:
        if (r108.f400414f0 == true) goto L20;
        int r112 = r109.u();
        int r113 = r109.v();
        int r114 = r109.t() + r112;
        int r115 = r109.n() + r113;
        r111.layout(r112, r113, r114, r115);
        if ((r111 instanceof Placeholder) == false) goto L20;
        View r116 = ((Placeholder) r111).getContent();
        if (r116 == null) goto L20;
        r116.setVisibility(0);
        r116.layout(r112, r113, r114, r115);
        goto L20
    L21:
        int r117 = this.f400388b.size();
        if (r117 <= 0) goto L25;
    L23:
        if (r106 >= r117) goto L33;
        ((ConstraintHelper) ListProtector.get(this.f400388b, r106)).q();
        r106 = r106 + 1;
        goto L23
    L33:
        return;
    }

    public final void g(int r100, int r101, int r102, int r103, boolean r104, boolean r105) {
        b r106 = this.f400401o;
        int r107 = r106.f400452e;
        int r108 = ViewGroup.resolveSizeAndState(r102 + r106.f400451d, r100, 0);
        int r109 = ViewGroup.resolveSizeAndState(r103 + r107, r101, 0) & 16777215;
        int r110 = this.f400392f;
        int r111 = Math.min(r110, r108 & 16777215);
        int r112 = Math.min(this.f400393g, r109);
        if (r104 == false) goto L5;
        r111 = r111 | 16777216;
    L5:
        if (r105 == false) goto L7;
        r112 = r112 | 16777216;
    L7:
        setMeasuredDimension(r111, r112);
    }
}
