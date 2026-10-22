package com.obric.oui.constraintlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f400476h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final SparseIntArray f400477i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final SparseIntArray f400478j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f400479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f400480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f400481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f400482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, ConstraintAttribute> f400483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f400484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<Integer, C4670a> f400485g;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.widget.a$a, reason: collision with other inner class name */
    public static class C4670a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f400486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f400487b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f400488c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f400489d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f400490e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final e f400491f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public HashMap<String, ConstraintAttribute> f400492g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public C4671a f400493h;

        /* JADX INFO: renamed from: com.obric.oui.constraintlayout.widget.a$a$a, reason: collision with other inner class name */
        public static class C4671a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int[] f400494a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int[] f400495b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f400496c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int[] f400497d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public float[] f400498e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f400499f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int[] f400500g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String[] f400501h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public int f400502i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int[] f400503j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public boolean[] f400504k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public int f400505l;

            public C4671a() {
                this.f400494a = new int[10];
                this.f400495b = new int[10];
                this.f400496c = 0;
                this.f400497d = new int[10];
                this.f400498e = new float[10];
                this.f400499f = 0;
                this.f400500g = new int[5];
                this.f400501h = new String[5];
                this.f400502i = 0;
                this.f400503j = new int[4];
                this.f400504k = new boolean[4];
                this.f400505l = 0;
            }

            public final void e(C4670a r100) {
                int r101 = 0;
                int r102 = 0;
            L4:
                if (r102 >= this.f400496c) goto L104;
                int r103 = this.f400494a[r102];
                int r104 = this.f400495b[r102];
                int[] r105 = a.f400476h;
                if (r103 != 6) goto L8;
                r100.f400490e.D = r104;
            L103:
                r102 = r102 + 1;
                goto L4
            L8:
                if (r103 != 7) goto L10;
                r100.f400490e.E = r104;
                goto L103
            L10:
                if (r103 != 8) goto L12;
                r100.f400490e.K = r104;
                goto L103
            L12:
                if (r103 != 27) goto L14;
                r100.f400490e.F = r104;
                goto L103
            L14:
                if (r103 != 28) goto L16;
                r100.f400490e.H = r104;
                goto L103
            L16:
                if (r103 != 41) goto L18;
                r100.f400490e.W = r104;
                goto L103
            L18:
                if (r103 != 42) goto L20;
                r100.f400490e.X = r104;
                goto L103
            L20:
                if (r103 != 61) goto L22;
                r100.f400490e.A = r104;
                goto L103
            L22:
                if (r103 != 62) goto L24;
                r100.f400490e.B = r104;
                goto L103
            L24:
                if (r103 != 72) goto L26;
                r100.f400490e.f400521g0 = r104;
                goto L103
            L26:
                if (r103 != 73) goto L28;
                r100.f400490e.f400523h0 = r104;
                goto L103
            L28:
                if (r103 != 88) goto L30;
                r100.f400489d.f400562l = r104;
                goto L103
            L30:
                if (r103 != 89) goto L32;
                r100.f400489d.f400563m = r104;
                goto L103
            L32:
                if (r103 != 2) goto L34;
                r100.f400490e.f400507J = r104;
                goto L103
            L34:
                if (r103 != 31) goto L36;
                r100.f400490e.L = r104;
                goto L103
            L36:
                if (r103 != 34) goto L38;
                r100.f400490e.I = r104;
                goto L103
            L38:
                if (r103 != 38) goto L40;
                r100.f400486a = r104;
                goto L103
            L40:
                if (r103 != 64) goto L42;
                r100.f400489d.f400552b = r104;
                goto L103
            L42:
                if (r103 != 66) goto L44;
                r100.f400489d.f400556f = r104;
                goto L103
            L44:
                if (r103 != 76) goto L46;
                r100.f400489d.f400555e = r104;
                goto L103
            L46:
                if (r103 != 78) goto L48;
                r100.f400488c.f400566c = r104;
                goto L103
            L48:
                if (r103 != 97) goto L50;
                r100.f400490e.f400539p0 = r104;
                goto L103
            L50:
                if (r103 != 93) goto L52;
                r100.f400490e.M = r104;
                goto L103
            L52:
                if (r103 == 94) goto L79;
                switch(r103) {
                    case 11: goto L65;
                    case 12: goto L64;
                    case 13: goto L63;
                    case 14: goto L62;
                    case 15: goto L61;
                    case 16: goto L60;
                    case 17: goto L59;
                    case 18: goto L58;
                    default: goto L54;
                };
            L54:
                switch(r103) {
                    case 21: goto L69;
                    case 22: goto L68;
                    case 23: goto L67;
                    case 24: goto L66;
                    default: goto L55;
                };
            L55:
                switch(r103) {
                    case 54: goto L75;
                    case 55: goto L74;
                    case 56: goto L73;
                    case 57: goto L72;
                    case 58: goto L71;
                    case 59: goto L70;
                    default: goto L56;
                };
            L56:
                switch(r103) {
                    case 82: goto L78;
                    case 83: goto L77;
                    case 84: goto L76;
                    default: goto L103;
                };
            L76:
                r100.f400489d.f400560j = r104;
                goto L103
            L77:
                r100.f400491f.f400578i = r104;
                goto L103
            L78:
                r100.f400489d.f400553c = r104;
                goto L103
            L70:
                r100.f400490e.f400515d0 = r104;
                goto L103
            L71:
                r100.f400490e.f400513c0 = r104;
                goto L103
            L72:
                r100.f400490e.f400511b0 = r104;
                goto L103
            L73:
                r100.f400490e.f400509a0 = r104;
                goto L103
            L74:
                r100.f400490e.Z = r104;
                goto L103
            L75:
                r100.f400490e.Y = r104;
                goto L103
            L66:
                r100.f400490e.G = r104;
                goto L103
            L67:
                r100.f400490e.f400512c = r104;
                goto L103
            L68:
                r100.f400488c.f400565b = r104;
                goto L103
            L69:
                r100.f400490e.f400514d = r104;
                goto L103
            L58:
                r100.f400490e.f400518f = r104;
                goto L103
            L59:
                r100.f400490e.f400516e = r104;
                goto L103
            L60:
                r100.f400490e.O = r104;
                goto L103
            L61:
                r100.f400490e.S = r104;
                goto L103
            L62:
                r100.f400490e.P = r104;
                goto L103
            L63:
                r100.f400490e.N = r104;
                goto L103
            L64:
                r100.f400490e.R = r104;
                goto L103
            L65:
                r100.f400490e.Q = r104;
                goto L103
            L79:
                r100.f400490e.T = r104;
                goto L103
            L104:
                int r106 = 0;
            L106:
                if (r106 >= this.f400499f) goto L153;
                int r107 = this.f400497d[r106];
                float r108 = this.f400498e[r106];
                int[] r109 = a.f400476h;
                if (r107 != 19) goto L110;
                r100.f400490e.f400520g = r108;
            L152:
                r106 = r106 + 1;
                goto L106
            L110:
                if (r107 != 20) goto L112;
                r100.f400490e.f400547x = r108;
                goto L152
            L112:
                if (r107 != 37) goto L114;
                r100.f400490e.f400548y = r108;
                goto L152
            L114:
                if (r107 != 60) goto L116;
                r100.f400491f.f400571b = r108;
                goto L152
            L116:
                if (r107 != 63) goto L118;
                r100.f400490e.C = r108;
                goto L152
            L118:
                if (r107 != 79) goto L120;
                r100.f400489d.f400557g = r108;
                goto L152
            L120:
                if (r107 != 85) goto L122;
                r100.f400489d.f400559i = r108;
                goto L152
            L122:
                if (r107 != 39) goto L124;
                r100.f400490e.V = r108;
                goto L152
            L124:
                if (r107 == 40) goto L143;
                switch(r107) {
                    case 43: goto L138;
                    case 44: goto L137;
                    case 45: goto L136;
                    case 46: goto L135;
                    case 47: goto L134;
                    case 48: goto L133;
                    case 49: goto L132;
                    case 50: goto L131;
                    case 51: goto L130;
                    case 52: goto L129;
                    case 53: goto L128;
                    default: goto L126;
                };
            L126:
                switch(r107) {
                    case 67: goto L142;
                    case 68: goto L141;
                    case 69: goto L140;
                    case 70: goto L139;
                    default: goto L152;
                };
            L139:
                r100.f400490e.f400519f0 = r108;
                goto L152
            L140:
                r100.f400490e.f400517e0 = r108;
                goto L152
            L141:
                r100.f400488c.f400568e = r108;
                goto L152
            L142:
                r100.f400489d.f400558h = r108;
                goto L152
            L128:
                r100.f400491f.f400581l = r108;
                goto L152
            L129:
                r100.f400491f.f400580k = r108;
                goto L152
            L130:
                r100.f400491f.f400579j = r108;
                goto L152
            L131:
                r100.f400491f.f400577h = r108;
                goto L152
            L132:
                r100.f400491f.f400576g = r108;
                goto L152
            L133:
                r100.f400491f.f400575f = r108;
                goto L152
            L134:
                r100.f400491f.f400574e = r108;
                goto L152
            L135:
                r100.f400491f.f400573d = r108;
                goto L152
            L136:
                r100.f400491f.f400572c = r108;
                goto L152
            L137:
                e r110 = r100.f400491f;
                r110.f400583n = r108;
                r110.f400582m = true;
                goto L152
            L138:
                r100.f400488c.f400567d = r108;
                goto L152
            L143:
                r100.f400490e.U = r108;
                goto L152
            L153:
                int r111 = 0;
            L155:
                if (r111 >= this.f400502i) goto L174;
                int r112 = this.f400500g[r111];
                String r113 = this.f400501h[r111];
                int[] r114 = a.f400476h;
                if (r112 != 5) goto L159;
                r100.f400490e.f400549z = r113;
            L172:
                r111 = r111 + 1;
                goto L155
            L159:
                if (r112 != 65) goto L161;
                r100.f400489d.f400554d = r113;
                goto L172
            L161:
                if (r112 != 74) goto L163;
                b r115 = r100.f400490e;
                r115.f400529k0 = r113;
                r115.f400527j0 = null;
                goto L172
            L163:
                if (r112 != 77) goto L165;
                r100.f400490e.f400531l0 = r113;
                goto L172
            L165:
                if (r112 != 90) goto L172;
                r100.f400489d.f400561k = r113;
            L174:
                if (r101 >= this.f400505l) goto L189;
                int r116 = this.f400503j[r101];
                boolean r117 = this.f400504k[r101];
                int[] r118 = a.f400476h;
                if (r116 != 44) goto L178;
                r100.f400491f.f400582m = r117;
            L188:
                r101 = r101 + 1;
                goto L174
            L178:
                if (r116 != 75) goto L180;
                r100.f400490e.f400537o0 = r117;
                goto L188
            L180:
                if (r116 != 80) goto L182;
                r100.f400490e.f400533m0 = r117;
                goto L188
            L182:
                if (r116 != 81) goto L188;
                r100.f400490e.f400535n0 = r117;
                goto L188
            }

            public final void a(int r100, float r101) {
                int r102 = this.f400499f;
                int[] r103 = this.f400497d;
                if (r102 < r103.length) goto L5;
                this.f400497d = Arrays.copyOf(r103, r103.length * 2);
                float[] r104 = this.f400498e;
                this.f400498e = Arrays.copyOf(r104, r104.length * 2);
            L5:
                int[] r105 = this.f400497d;
                int r106 = this.f400499f;
                r105[r106] = r100;
                float[] r107 = this.f400498e;
                this.f400499f = r106 + 1;
                r107[r106] = r101;
            }

            public final void b(int r100, int r101) {
                int r102 = this.f400496c;
                int[] r103 = this.f400494a;
                if (r102 < r103.length) goto L5;
                this.f400494a = Arrays.copyOf(r103, r103.length * 2);
                int[] r104 = this.f400495b;
                this.f400495b = Arrays.copyOf(r104, r104.length * 2);
            L5:
                int[] r105 = this.f400494a;
                int r106 = this.f400496c;
                r105[r106] = r100;
                int[] r107 = this.f400495b;
                this.f400496c = r106 + 1;
                r107[r106] = r101;
            }

            public final void c(int r100, String r101) {
                int r102 = this.f400502i;
                int[] r103 = this.f400500g;
                if (r102 < r103.length) goto L5;
                this.f400500g = Arrays.copyOf(r103, r103.length * 2);
                String[] r104 = this.f400501h;
                this.f400501h = (String[]) Arrays.copyOf(r104, r104.length * 2);
            L5:
                int[] r105 = this.f400500g;
                int r106 = this.f400502i;
                r105[r106] = r100;
                String[] r107 = this.f400501h;
                this.f400502i = r106 + 1;
                r107[r106] = r101;
            }

            public final void d(int r100, boolean r101) {
                int r102 = this.f400505l;
                int[] r103 = this.f400503j;
                if (r102 < r103.length) goto L5;
                this.f400503j = Arrays.copyOf(r103, r103.length * 2);
                boolean[] r104 = this.f400504k;
                this.f400504k = Arrays.copyOf(r104, r104.length * 2);
            L5:
                int[] r105 = this.f400503j;
                int r106 = this.f400505l;
                r105[r106] = r100;
                boolean[] r107 = this.f400504k;
                this.f400505l = r106 + 1;
                r107[r106] = r101;
            }
        }

        public final C4670a b() {
            C4670a r100 = new C4670a();
            r100.f400490e.a(this.f400490e);
            r100.f400489d.a(this.f400489d);
            d r101 = r100.f400488c;
            d r102 = this.f400488c;
            r101.getClass();
            r101.f400564a = r102.f400564a;
            r101.f400565b = r102.f400565b;
            r101.f400567d = r102.f400567d;
            r101.f400568e = r102.f400568e;
            r101.f400566c = r102.f400566c;
            r100.f400491f.a(this.f400491f);
            r100.f400486a = this.f400486a;
            r100.f400493h = this.f400493h;
            return r100;
        }

        public C4670a() {
            this.f400488c = new d();
            this.f400489d = new c();
            this.f400490e = new b();
            this.f400491f = new e();
            this.f400492g = new HashMap();
        }

        public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return b();
        }

        public final void a(ConstraintLayout.LayoutParams r100) {
            b r101 = this.f400490e;
            r100.f400411e = r101.f400524i;
            r100.f400413f = r101.f400526j;
            r100.f400415g = r101.f400528k;
            r100.f400417h = r101.f400530l;
            r100.f400419i = r101.f400532m;
            r100.f400421j = r101.f400534n;
            r100.f400423k = r101.f400536o;
            r100.f400425l = r101.f400538p;
            r100.f400427m = r101.f400540q;
            r100.f400429n = r101.f400541r;
            r100.f400431o = r101.f400542s;
            r100.f400438s = r101.f400543t;
            r100.f400439t = r101.f400544u;
            r100.f400440u = r101.f400545v;
            r100.f400441v = r101.f400546w;
            ((ViewGroup.MarginLayoutParams) r100).leftMargin = r101.G;
            ((ViewGroup.MarginLayoutParams) r100).rightMargin = r101.H;
            ((ViewGroup.MarginLayoutParams) r100).topMargin = r101.I;
            ((ViewGroup.MarginLayoutParams) r100).bottomMargin = r101.f400507J;
            r100.A = r101.S;
            r100.B = r101.R;
            r100.f400443x = r101.O;
            r100.f400445z = r101.Q;
            r100.E = r101.f400547x;
            r100.F = r101.f400548y;
            r100.f400433p = r101.A;
            r100.f400435q = r101.B;
            r100.f400437r = r101.C;
            r100.G = r101.f400549z;
            r100.T = r101.D;
            r100.U = r101.E;
            r100.I = r101.U;
            r100.H = r101.V;
            r100.K = r101.X;
            r100.f400402J = r101.W;
            r100.W = r101.f400533m0;
            r100.X = r101.f400535n0;
            r100.L = r101.Y;
            r100.M = r101.Z;
            r100.P = r101.f400509a0;
            r100.Q = r101.f400511b0;
            r100.N = r101.f400513c0;
            r100.O = r101.f400515d0;
            r100.R = r101.f400517e0;
            r100.S = r101.f400519f0;
            r100.V = r101.F;
            r100.f400407c = r101.f400520g;
            r100.f400403a = r101.f400516e;
            r100.f400405b = r101.f400518f;
            ((ViewGroup.MarginLayoutParams) r100).width = r101.f400512c;
            ((ViewGroup.MarginLayoutParams) r100).height = r101.f400514d;
            String r102 = r101.f400531l0;
            if (r102 == null) goto L5;
            r100.Y = r102;
        L5:
            r100.Z = r101.f400539p0;
            r100.setMarginStart(r101.L);
            r100.setMarginEnd(this.f400490e.K);
            r100.a();
        }

        public final void c(int r100, ConstraintLayout.LayoutParams r101) {
            this.f400486a = r100;
            b r102 = this.f400490e;
            r102.f400524i = r101.f400411e;
            r102.f400526j = r101.f400413f;
            r102.f400528k = r101.f400415g;
            r102.f400530l = r101.f400417h;
            r102.f400532m = r101.f400419i;
            r102.f400534n = r101.f400421j;
            r102.f400536o = r101.f400423k;
            r102.f400538p = r101.f400425l;
            r102.f400540q = r101.f400427m;
            r102.f400541r = r101.f400429n;
            r102.f400542s = r101.f400431o;
            r102.f400543t = r101.f400438s;
            r102.f400544u = r101.f400439t;
            r102.f400545v = r101.f400440u;
            r102.f400546w = r101.f400441v;
            r102.f400547x = r101.E;
            r102.f400548y = r101.F;
            r102.f400549z = r101.G;
            r102.A = r101.f400433p;
            r102.B = r101.f400435q;
            r102.C = r101.f400437r;
            r102.D = r101.T;
            r102.E = r101.U;
            r102.F = r101.V;
            r102.f400520g = r101.f400407c;
            r102.f400516e = r101.f400403a;
            r102.f400518f = r101.f400405b;
            r102.f400512c = ((ViewGroup.MarginLayoutParams) r101).width;
            r102.f400514d = ((ViewGroup.MarginLayoutParams) r101).height;
            r102.G = ((ViewGroup.MarginLayoutParams) r101).leftMargin;
            r102.H = ((ViewGroup.MarginLayoutParams) r101).rightMargin;
            r102.I = ((ViewGroup.MarginLayoutParams) r101).topMargin;
            r102.f400507J = ((ViewGroup.MarginLayoutParams) r101).bottomMargin;
            r102.M = r101.D;
            r102.U = r101.I;
            r102.V = r101.H;
            r102.X = r101.K;
            r102.W = r101.f400402J;
            r102.f400533m0 = r101.W;
            r102.f400535n0 = r101.X;
            r102.Y = r101.L;
            r102.Z = r101.M;
            r102.f400509a0 = r101.P;
            r102.f400511b0 = r101.Q;
            r102.f400513c0 = r101.N;
            r102.f400515d0 = r101.O;
            r102.f400517e0 = r101.R;
            r102.f400519f0 = r101.S;
            r102.f400531l0 = r101.Y;
            r102.O = r101.f400443x;
            r102.Q = r101.f400445z;
            r102.N = r101.f400442w;
            r102.P = r101.f400444y;
            r102.S = r101.A;
            r102.R = r101.B;
            r102.T = r101.C;
            r102.f400539p0 = r101.Z;
            r102.K = r101.getMarginEnd();
            b r103 = this.f400490e;
            r103.L = r101.getMarginStart();
        }

        public final void d(int r100, Constraints.LayoutParams r101) {
            c(r100, r101);
            d r102 = this.f400488c;
            r102.f400567d = r101.f400457r0;
            e r103 = this.f400491f;
            r103.f400571b = r101.f400460u0;
            r103.f400572c = r101.f400461v0;
            r103.f400573d = r101.f400462w0;
            r103.f400574e = r101.f400463x0;
            r103.f400575f = r101.f400464y0;
            r103.f400576g = r101.f400465z0;
            r103.f400577h = r101.A0;
            r103.f400579j = r101.B0;
            r103.f400580k = r101.C0;
            r103.f400581l = r101.D0;
            r103.f400583n = r101.f400459t0;
            r103.f400582m = r101.f400458s0;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public static final SparseIntArray f400506q0 = null;
        public int A;
        public int B;
        public float C;
        public int D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f400507J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public int R;
        public int S;
        public int T;
        public float U;
        public float V;
        public int W;
        public int X;
        public int Y;
        public int Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f400508a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public int f400509a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f400510b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public int f400511b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f400512c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public int f400513c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f400514d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f400515d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f400516e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public float f400517e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f400518f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public float f400519f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f400520g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public int f400521g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f400522h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public int f400523h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f400524i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public int f400525i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f400526j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public int[] f400527j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f400528k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public String f400529k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f400530l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public String f400531l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f400532m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public boolean f400533m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f400534n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public boolean f400535n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f400536o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public boolean f400537o0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f400538p;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public int f400539p0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f400540q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f400541r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f400542s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f400543t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f400544u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f400545v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f400546w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public float f400547x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public float f400548y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f400549z;

        static {
            SparseIntArray r100 = new SparseIntArray();
            f400506q0 = r100;
            r100.append(43, 24);
            r100.append(44, 25);
            r100.append(46, 28);
            r100.append(47, 29);
            r100.append(52, 35);
            r100.append(51, 34);
            r100.append(24, 4);
            r100.append(23, 3);
            r100.append(19, 1);
            r100.append(61, 6);
            r100.append(62, 7);
            r100.append(31, 17);
            r100.append(32, 18);
            r100.append(33, 19);
            r100.append(15, 90);
            r100.append(0, 26);
            r100.append(48, 31);
            r100.append(49, 32);
            r100.append(30, 10);
            r100.append(29, 9);
            r100.append(66, 13);
            r100.append(69, 16);
            r100.append(67, 14);
            r100.append(64, 11);
            r100.append(68, 15);
            r100.append(65, 12);
            r100.append(55, 38);
            r100.append(41, 37);
            r100.append(40, 39);
            r100.append(54, 40);
            r100.append(39, 20);
            r100.append(53, 36);
            r100.append(28, 5);
            r100.append(42, 91);
            r100.append(50, 91);
            r100.append(45, 91);
            r100.append(22, 91);
            r100.append(18, 91);
            r100.append(3, 23);
            r100.append(5, 27);
            r100.append(7, 30);
            r100.append(8, 8);
            r100.append(4, 33);
            r100.append(6, 2);
            r100.append(1, 22);
            r100.append(2, 21);
            r100.append(56, 41);
            r100.append(34, 42);
            r100.append(17, 87);
            r100.append(16, 88);
            r100.append(71, 76);
            r100.append(25, 61);
            r100.append(27, 62);
            r100.append(26, 63);
            r100.append(60, 69);
            r100.append(38, 70);
            r100.append(12, 71);
            r100.append(10, 72);
            r100.append(11, 73);
            r100.append(13, 74);
            r100.append(9, 75);
            r100.append(58, 84);
            r100.append(59, 86);
            r100.append(58, 83);
            r100.append(37, 85);
            r100.append(56, 87);
            r100.append(34, 88);
            r100.append(91, 89);
            r100.append(15, 90);
        }

        public b() {
            this.f400508a = false;
            this.f400510b = false;
            this.f400516e = -1;
            this.f400518f = -1;
            this.f400520g = -1.0f;
            this.f400522h = true;
            this.f400524i = -1;
            this.f400526j = -1;
            this.f400528k = -1;
            this.f400530l = -1;
            this.f400532m = -1;
            this.f400534n = -1;
            this.f400536o = -1;
            this.f400538p = -1;
            this.f400540q = -1;
            this.f400541r = -1;
            this.f400542s = -1;
            this.f400543t = -1;
            this.f400544u = -1;
            this.f400545v = -1;
            this.f400546w = -1;
            this.f400547x = 0.5f;
            this.f400548y = 0.5f;
            this.f400549z = null;
            this.A = -1;
            this.B = 0;
            this.C = 0.0f;
            this.D = -1;
            this.E = -1;
            this.F = -1;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.f400507J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = Integer.MIN_VALUE;
            this.O = Integer.MIN_VALUE;
            this.P = Integer.MIN_VALUE;
            this.Q = Integer.MIN_VALUE;
            this.R = Integer.MIN_VALUE;
            this.S = Integer.MIN_VALUE;
            this.T = Integer.MIN_VALUE;
            this.U = -1.0f;
            this.V = -1.0f;
            this.W = 0;
            this.X = 0;
            this.Y = 0;
            this.Z = 0;
            this.f400509a0 = 0;
            this.f400511b0 = 0;
            this.f400513c0 = 0;
            this.f400515d0 = 0;
            this.f400517e0 = 1.0f;
            this.f400519f0 = 1.0f;
            this.f400521g0 = -1;
            this.f400523h0 = 0;
            this.f400525i0 = -1;
            this.f400533m0 = false;
            this.f400535n0 = false;
            this.f400537o0 = true;
            this.f400539p0 = 0;
        }

        public final void a(b r100) {
            this.f400508a = r100.f400508a;
            this.f400512c = r100.f400512c;
            this.f400510b = r100.f400510b;
            this.f400514d = r100.f400514d;
            this.f400516e = r100.f400516e;
            this.f400518f = r100.f400518f;
            this.f400520g = r100.f400520g;
            this.f400522h = r100.f400522h;
            this.f400524i = r100.f400524i;
            this.f400526j = r100.f400526j;
            this.f400528k = r100.f400528k;
            this.f400530l = r100.f400530l;
            this.f400532m = r100.f400532m;
            this.f400534n = r100.f400534n;
            this.f400536o = r100.f400536o;
            this.f400538p = r100.f400538p;
            this.f400540q = r100.f400540q;
            this.f400541r = r100.f400541r;
            this.f400542s = r100.f400542s;
            this.f400543t = r100.f400543t;
            this.f400544u = r100.f400544u;
            this.f400545v = r100.f400545v;
            this.f400546w = r100.f400546w;
            this.f400547x = r100.f400547x;
            this.f400548y = r100.f400548y;
            this.f400549z = r100.f400549z;
            this.A = r100.A;
            this.B = r100.B;
            this.C = r100.C;
            this.D = r100.D;
            this.E = r100.E;
            this.F = r100.F;
            this.G = r100.G;
            this.H = r100.H;
            this.I = r100.I;
            this.f400507J = r100.f400507J;
            this.K = r100.K;
            this.L = r100.L;
            this.M = r100.M;
            this.N = r100.N;
            this.O = r100.O;
            this.P = r100.P;
            this.Q = r100.Q;
            this.R = r100.R;
            this.S = r100.S;
            this.T = r100.T;
            this.U = r100.U;
            this.V = r100.V;
            this.W = r100.W;
            this.X = r100.X;
            this.Y = r100.Y;
            this.Z = r100.Z;
            this.f400509a0 = r100.f400509a0;
            this.f400511b0 = r100.f400511b0;
            this.f400513c0 = r100.f400513c0;
            this.f400515d0 = r100.f400515d0;
            this.f400517e0 = r100.f400517e0;
            this.f400519f0 = r100.f400519f0;
            this.f400521g0 = r100.f400521g0;
            this.f400523h0 = r100.f400523h0;
            this.f400525i0 = r100.f400525i0;
            this.f400531l0 = r100.f400531l0;
            int[] r101 = r100.f400527j0;
            if (r101 != null) goto L5;
        L7:
            this.f400527j0 = null;
        L8:
            this.f400529k0 = r100.f400529k0;
            this.f400533m0 = r100.f400533m0;
            this.f400535n0 = r100.f400535n0;
            this.f400537o0 = r100.f400537o0;
            this.f400539p0 = r100.f400539p0;
            return;
        L5:
            if (r100.f400529k0 != null) goto L7;
            this.f400527j0 = Arrays.copyOf(r101, r101.length);
            goto L8
        }

        public final void b(Context r100, AttributeSet r101) {
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.orientation, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.layout_marginStart, R.attr.layout_marginEnd, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_wrapBehaviorInParent, com.larus.nova.R.attr.maxHeight, com.larus.nova.R.attr.maxWidth, com.larus.nova.R.attr.minHeight, com.larus.nova.R.attr.minWidth});
            this.f400510b = true;
            int r103 = r102.getIndexCount();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L78;
            int r105 = r102.getIndex(r104);
            SparseIntArray r106 = f400506q0;
            int r107 = r106.get(r105);
            switch(r107) {
                case 1: goto L76;
                case 2: goto L75;
                case 3: goto L74;
                case 4: goto L73;
                case 5: goto L72;
                case 6: goto L71;
                case 7: goto L70;
                case 8: goto L69;
                case 9: goto L68;
                case 10: goto L67;
                case 11: goto L66;
                case 12: goto L65;
                case 13: goto L64;
                case 14: goto L63;
                case 15: goto L62;
                case 16: goto L61;
                case 17: goto L60;
                case 18: goto L59;
                case 19: goto L58;
                case 20: goto L57;
                case 21: goto L56;
                case 22: goto L55;
                case 23: goto L54;
                case 24: goto L53;
                case 25: goto L52;
                case 26: goto L51;
                case 27: goto L50;
                case 28: goto L49;
                case 29: goto L48;
                case 30: goto L47;
                case 31: goto L46;
                case 32: goto L45;
                case 33: goto L44;
                case 34: goto L43;
                case 35: goto L42;
                case 36: goto L41;
                case 37: goto L40;
                case 38: goto L39;
                case 39: goto L38;
                case 40: goto L37;
                case 41: goto L36;
                case 42: goto L35;
                default: goto L6;
            };
        L6:
            switch(r107) {
                case 61: goto L34;
                case 62: goto L33;
                case 63: goto L32;
                default: goto L8;
            };
        L32:
            this.C = r102.getFloat(r105, this.C);
        L77:
            r104 = r104 + 1;
            goto L3
        L33:
            this.B = r102.getDimensionPixelSize(r105, this.B);
            goto L77
        L34:
            this.A = a.l(r102, r105, this.A);
            goto L77
        L8:
            switch(r107) {
                case 69: goto L31;
                case 70: goto L30;
                case 71: goto L77;
                case 72: goto L29;
                case 73: goto L28;
                case 74: goto L27;
                case 75: goto L26;
                case 76: goto L25;
                case 77: goto L24;
                case 78: goto L23;
                case 79: goto L22;
                case 80: goto L21;
                case 81: goto L20;
                case 82: goto L19;
                case 83: goto L18;
                case 84: goto L17;
                case 85: goto L16;
                case 86: goto L15;
                case 87: goto L14;
                case 88: goto L13;
                case 89: goto L12;
                case 90: goto L11;
                case 91: goto L10;
                default: goto L9;
            };
        L9:
            Integer.toHexString(r105);
            r106.get(r105);
            goto L77
        L10:
            Integer.toHexString(r105);
            r106.get(r105);
            goto L77
        L11:
            this.f400522h = r102.getBoolean(r105, this.f400522h);
            goto L77
        L12:
            this.f400531l0 = r102.getString(r105);
            goto L77
        L13:
            this.f400535n0 = r102.getBoolean(r105, this.f400535n0);
            goto L77
        L14:
            this.f400533m0 = r102.getBoolean(r105, this.f400533m0);
            goto L77
        L15:
            this.f400513c0 = r102.getDimensionPixelSize(r105, this.f400513c0);
            goto L77
        L16:
            this.f400515d0 = r102.getDimensionPixelSize(r105, this.f400515d0);
            goto L77
        L17:
            this.f400509a0 = r102.getDimensionPixelSize(r105, this.f400509a0);
            goto L77
        L18:
            this.f400511b0 = r102.getDimensionPixelSize(r105, this.f400511b0);
            goto L77
        L19:
            this.Z = r102.getInt(r105, this.Z);
            goto L77
        L20:
            this.Y = r102.getInt(r105, this.Y);
            goto L77
        L21:
            this.M = r102.getDimensionPixelSize(r105, this.M);
            goto L77
        L22:
            this.T = r102.getDimensionPixelSize(r105, this.T);
            goto L77
        L23:
            this.f400542s = a.l(r102, r105, this.f400542s);
            goto L77
        L24:
            this.f400541r = a.l(r102, r105, this.f400541r);
            goto L77
        L25:
            this.f400539p0 = r102.getInt(r105, this.f400539p0);
            goto L77
        L26:
            this.f400537o0 = r102.getBoolean(r105, this.f400537o0);
            goto L77
        L27:
            this.f400529k0 = r102.getString(r105);
            goto L77
        L28:
            this.f400523h0 = r102.getDimensionPixelSize(r105, this.f400523h0);
            goto L77
        L29:
            this.f400521g0 = r102.getInt(r105, this.f400521g0);
            goto L77
        L30:
            this.f400519f0 = r102.getFloat(r105, 1.0f);
            goto L77
        L31:
            this.f400517e0 = r102.getFloat(r105, 1.0f);
            goto L77
        L35:
            a.m(this, r102, r105, 1);
            goto L77
        L36:
            a.m(this, r102, r105, 0);
            goto L77
        L37:
            this.X = r102.getInt(r105, this.X);
            goto L77
        L38:
            this.W = r102.getInt(r105, this.W);
            goto L77
        L39:
            this.U = r102.getFloat(r105, this.U);
            goto L77
        L40:
            this.V = r102.getFloat(r105, this.V);
            goto L77
        L41:
            this.f400548y = r102.getFloat(r105, this.f400548y);
            goto L77
        L42:
            this.f400532m = a.l(r102, r105, this.f400532m);
            goto L77
        L43:
            this.f400534n = a.l(r102, r105, this.f400534n);
            goto L77
        L44:
            this.I = r102.getDimensionPixelSize(r105, this.I);
            goto L77
        L45:
            this.f400544u = a.l(r102, r105, this.f400544u);
            goto L77
        L46:
            this.f400543t = a.l(r102, r105, this.f400543t);
            goto L77
        L47:
            this.L = r102.getDimensionPixelSize(r105, this.L);
            goto L77
        L48:
            this.f400530l = a.l(r102, r105, this.f400530l);
            goto L77
        L49:
            this.f400528k = a.l(r102, r105, this.f400528k);
            goto L77
        L50:
            this.H = r102.getDimensionPixelSize(r105, this.H);
            goto L77
        L51:
            this.F = r102.getInt(r105, this.F);
            goto L77
        L52:
            this.f400526j = a.l(r102, r105, this.f400526j);
            goto L77
        L53:
            this.f400524i = a.l(r102, r105, this.f400524i);
            goto L77
        L54:
            this.G = r102.getDimensionPixelSize(r105, this.G);
            goto L77
        L55:
            this.f400512c = r102.getLayoutDimension(r105, this.f400512c);
            goto L77
        L56:
            this.f400514d = r102.getLayoutDimension(r105, this.f400514d);
            goto L77
        L57:
            this.f400547x = r102.getFloat(r105, this.f400547x);
            goto L77
        L58:
            this.f400520g = r102.getFloat(r105, this.f400520g);
            goto L77
        L59:
            this.f400518f = r102.getDimensionPixelOffset(r105, this.f400518f);
            goto L77
        L60:
            this.f400516e = r102.getDimensionPixelOffset(r105, this.f400516e);
            goto L77
        L61:
            this.O = r102.getDimensionPixelSize(r105, this.O);
            goto L77
        L62:
            this.S = r102.getDimensionPixelSize(r105, this.S);
            goto L77
        L63:
            this.P = r102.getDimensionPixelSize(r105, this.P);
            goto L77
        L64:
            this.N = r102.getDimensionPixelSize(r105, this.N);
            goto L77
        L65:
            this.R = r102.getDimensionPixelSize(r105, this.R);
            goto L77
        L66:
            this.Q = r102.getDimensionPixelSize(r105, this.Q);
            goto L77
        L67:
            this.f400545v = a.l(r102, r105, this.f400545v);
            goto L77
        L68:
            this.f400546w = a.l(r102, r105, this.f400546w);
            goto L77
        L69:
            this.K = r102.getDimensionPixelSize(r105, this.K);
            goto L77
        L70:
            this.E = r102.getDimensionPixelOffset(r105, this.E);
            goto L77
        L71:
            this.D = r102.getDimensionPixelOffset(r105, this.D);
            goto L77
        L72:
            this.f400549z = r102.getString(r105);
            goto L77
        L73:
            this.f400536o = a.l(r102, r105, this.f400536o);
            goto L77
        L74:
            this.f400538p = a.l(r102, r105, this.f400538p);
            goto L77
        L75:
            this.f400507J = r102.getDimensionPixelSize(r105, this.f400507J);
            goto L77
        L76:
            this.f400540q = a.l(r102, r105, this.f400540q);
            goto L77
        L78:
            r102.recycle();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final SparseIntArray f400550n = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f400551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f400552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f400553c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f400554d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f400555e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f400556f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f400557g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f400558h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f400559i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f400560j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f400561k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f400562l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f400563m;

        static {
            SparseIntArray r100 = new SparseIntArray();
            f400550n = r100;
            r100.append(4, 1);
            r100.append(6, 2);
            r100.append(10, 3);
            r100.append(3, 4);
            r100.append(1, 5);
            r100.append(0, 6);
            r100.append(5, 7);
            r100.append(9, 8);
            r100.append(8, 9);
            r100.append(7, 10);
        }

        public c() {
            this.f400551a = false;
            this.f400552b = -1;
            this.f400553c = 0;
            this.f400554d = null;
            this.f400555e = -1;
            this.f400556f = 0;
            this.f400557g = Float.NaN;
            this.f400558h = Float.NaN;
            this.f400559i = Float.NaN;
            this.f400560j = -1;
            this.f400561k = null;
            this.f400562l = -3;
            this.f400563m = -1;
        }

        public final void a(c r100) {
            this.f400551a = r100.f400551a;
            this.f400552b = r100.f400552b;
            this.f400554d = r100.f400554d;
            this.f400555e = r100.f400555e;
            this.f400556f = r100.f400556f;
            this.f400558h = r100.f400558h;
            this.f400557g = r100.f400557g;
        }

        public final void b(Context r100, AttributeSet r110) {
            TypedArray r101 = r100.obtainStyledAttributes(r110, new int[]{com.larus.nova.R.attr.animateCircleAngleTo, com.larus.nova.R.attr.animateRelativeTo, com.larus.nova.R.attr.animate_relativeTo, com.larus.nova.R.attr.drawPath, com.larus.nova.R.attr.motionPathRotate, com.larus.nova.R.attr.motionStagger, com.larus.nova.R.attr.pathMotionArc, com.larus.nova.R.attr.quantizeMotionInterpolator, com.larus.nova.R.attr.quantizeMotionPhase, com.larus.nova.R.attr.quantizeMotionSteps, com.larus.nova.R.attr.transitionEasing});
            this.f400551a = true;
            int r102 = r101.getIndexCount();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L31;
            int r104 = r101.getIndex(r103);
            switch(f400550n.get(r104)) {
                case 1: goto L29;
                case 2: goto L28;
                case 3: goto L25;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L20;
                case 8: goto L19;
                case 9: goto L18;
                case 10: goto L7;
                default: goto L30;
            };
        L7:
            int r105 = r101.peekValue(r104).type;
            if (r105 != 1) goto L12;
            int r106 = r101.getResourceId(r104, -1);
            this.f400563m = r106;
            if (r106 == (-1)) goto L30;
            this.f400562l = -2;
            goto L30
        L12:
            if (r105 != 3) goto L17;
            String r107 = r101.getString(r104);
            this.f400561k = r107;
            if (r107.indexOf(HTTP.URL_DEFAULT) <= 0) goto L16;
            this.f400563m = r101.getResourceId(r104, -1);
            this.f400562l = -2;
            goto L30
        L16:
            this.f400562l = -1;
            goto L30
        L17:
            this.f400562l = r101.getInteger(r104, this.f400563m);
            goto L30
        L18:
            this.f400559i = r101.getFloat(r104, this.f400559i);
            goto L30
        L19:
            this.f400560j = r101.getInteger(r104, this.f400560j);
            goto L30
        L20:
            this.f400557g = r101.getFloat(r104, this.f400557g);
            goto L30
        L21:
            this.f400553c = r101.getInteger(r104, this.f400553c);
            goto L30
        L22:
            this.f400552b = a.l(r101, r104, this.f400552b);
            goto L30
        L23:
            this.f400556f = r101.getInt(r104, 0);
            goto L30
        L28:
            this.f400555e = r101.getInt(r104, this.f400555e);
            goto L30
        L29:
            this.f400558h = r101.getFloat(r104, this.f400558h);
            goto L30
        L25:
            if (r101.peekValue(r104).type != 3) goto L27;
            this.f400554d = r101.getString(r104);
            goto L30
        L27:
            this.f400554d = tla.c.f546670c[r101.getInteger(r104, 0)];
        L30:
            r103 = r103 + 1;
            goto L3
        L31:
            r101.recycle();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f400564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f400565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f400566c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f400567d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f400568e;

        public d() {
            this.f400564a = false;
            this.f400565b = 0;
            this.f400566c = 0;
            this.f400567d = 1.0f;
            this.f400568e = Float.NaN;
        }

        public final void a(Context r100, AttributeSet r101) {
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.visibility, R.attr.alpha, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.motionProgress, com.larus.nova.R.attr.visibilityMode});
            this.f400564a = true;
            int r103 = r102.getIndexCount();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L16;
            int r105 = r102.getIndex(r104);
            if (r105 != 1) goto L7;
            this.f400567d = r102.getFloat(r105, this.f400567d);
        L15:
            r104 = r104 + 1;
            goto L3
        L7:
            if (r105 != 0) goto L10;
            int r106 = r102.getInt(r105, this.f400565b);
            this.f400565b = r106;
            this.f400565b = a.f400476h[r106];
            goto L15
        L10:
            if (r105 != 4) goto L13;
            this.f400566c = r102.getInt(r105, this.f400566c);
            goto L15
        L13:
            if (r105 != 3) goto L15;
            this.f400568e = r102.getFloat(r105, this.f400568e);
            goto L15
        L16:
            r102.recycle();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final SparseIntArray f400569o = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f400570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f400571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f400572c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f400573d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f400574e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f400575f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f400576g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f400577h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f400578i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f400579j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f400580k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f400581l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f400582m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f400583n;

        static {
            SparseIntArray r100 = new SparseIntArray();
            f400569o = r100;
            r100.append(6, 1);
            r100.append(7, 2);
            r100.append(8, 3);
            r100.append(4, 4);
            r100.append(5, 5);
            r100.append(0, 6);
            r100.append(1, 7);
            r100.append(2, 8);
            r100.append(3, 9);
            r100.append(9, 10);
            r100.append(10, 11);
            r100.append(11, 12);
        }

        public e() {
            this.f400570a = false;
            this.f400571b = 0.0f;
            this.f400572c = 0.0f;
            this.f400573d = 0.0f;
            this.f400574e = 1.0f;
            this.f400575f = 1.0f;
            this.f400576g = Float.NaN;
            this.f400577h = Float.NaN;
            this.f400578i = -1;
            this.f400579j = 0.0f;
            this.f400580k = 0.0f;
            this.f400581l = 0.0f;
            this.f400582m = false;
            this.f400583n = 0.0f;
        }

        public final void a(e r100) {
            this.f400570a = r100.f400570a;
            this.f400571b = r100.f400571b;
            this.f400572c = r100.f400572c;
            this.f400573d = r100.f400573d;
            this.f400574e = r100.f400574e;
            this.f400575f = r100.f400575f;
            this.f400576g = r100.f400576g;
            this.f400577h = r100.f400577h;
            this.f400578i = r100.f400578i;
            this.f400579j = r100.f400579j;
            this.f400580k = r100.f400580k;
            this.f400581l = r100.f400581l;
            this.f400582m = r100.f400582m;
            this.f400583n = r100.f400583n;
        }

        public final void b(Context r100, AttributeSet r101) {
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.transformPivotX, R.attr.transformPivotY, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.translationZ, R.attr.elevation, com.larus.nova.R.attr.transformPivotTarget});
            this.f400570a = true;
            int r103 = r102.getIndexCount();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L20;
            int r105 = r102.getIndex(r104);
            switch(f400569o.get(r105)) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L19;
            };
        L7:
            this.f400578i = a.l(r102, r105, this.f400578i);
            goto L19
        L8:
            this.f400582m = true;
            this.f400583n = r102.getDimension(r105, this.f400583n);
            goto L19
        L9:
            this.f400581l = r102.getDimension(r105, this.f400581l);
            goto L19
        L10:
            this.f400580k = r102.getDimension(r105, this.f400580k);
            goto L19
        L11:
            this.f400579j = r102.getDimension(r105, this.f400579j);
            goto L19
        L12:
            this.f400577h = r102.getDimension(r105, this.f400577h);
            goto L19
        L13:
            this.f400576g = r102.getDimension(r105, this.f400576g);
            goto L19
        L14:
            this.f400575f = r102.getFloat(r105, this.f400575f);
            goto L19
        L15:
            this.f400574e = r102.getFloat(r105, this.f400574e);
            goto L19
        L16:
            this.f400573d = r102.getFloat(r105, this.f400573d);
            goto L19
        L17:
            this.f400572c = r102.getFloat(r105, this.f400572c);
            goto L19
        L18:
            this.f400571b = r102.getFloat(r105, this.f400571b);
        L19:
            r104 = r104 + 1;
            goto L3
        L20:
            r102.recycle();
        }
    }

    static {
        f400476h = new int[]{0, 4, 8};
        SparseIntArray r100 = new SparseIntArray();
        f400477i = r100;
        SparseIntArray r101 = new SparseIntArray();
        f400478j = r101;
        r100.append(83, 25);
        r100.append(84, 26);
        r100.append(86, 29);
        r100.append(87, 30);
        r100.append(93, 36);
        r100.append(92, 35);
        r100.append(64, 4);
        r100.append(63, 3);
        r100.append(59, 1);
        r100.append(61, 91);
        r100.append(60, 92);
        r100.append(102, 6);
        r100.append(103, 7);
        r100.append(71, 17);
        r100.append(72, 18);
        r100.append(73, 19);
        r100.append(55, 99);
        r100.append(0, 27);
        r100.append(88, 32);
        r100.append(89, 33);
        r100.append(70, 10);
        r100.append(69, 9);
        r100.append(107, 13);
        r100.append(110, 16);
        r100.append(108, 14);
        r100.append(105, 11);
        r100.append(109, 15);
        r100.append(106, 12);
        r100.append(96, 40);
        r100.append(81, 39);
        r100.append(80, 41);
        r100.append(95, 42);
        r100.append(79, 20);
        r100.append(94, 37);
        r100.append(68, 5);
        r100.append(82, 87);
        r100.append(91, 87);
        r100.append(85, 87);
        r100.append(62, 87);
        r100.append(58, 87);
        r100.append(5, 24);
        r100.append(7, 28);
        r100.append(23, 31);
        r100.append(24, 8);
        r100.append(6, 34);
        r100.append(8, 2);
        r100.append(3, 23);
        r100.append(4, 21);
        r100.append(97, 95);
        r100.append(74, 96);
        r100.append(2, 22);
        r100.append(13, 43);
        r100.append(26, 44);
        r100.append(21, 45);
        r100.append(22, 46);
        r100.append(20, 60);
        r100.append(18, 47);
        r100.append(19, 48);
        r100.append(14, 49);
        r100.append(15, 50);
        r100.append(16, 51);
        r100.append(17, 52);
        r100.append(25, 53);
        r100.append(98, 54);
        r100.append(75, 55);
        r100.append(99, 56);
        r100.append(76, 57);
        r100.append(100, 58);
        r100.append(77, 59);
        r100.append(65, 61);
        r100.append(67, 62);
        r100.append(66, 63);
        r100.append(28, 64);
        r100.append(122, 65);
        r100.append(36, 66);
        r100.append(123, 67);
        r100.append(114, 79);
        r100.append(1, 38);
        r100.append(113, 68);
        r100.append(101, 69);
        r100.append(78, 70);
        r100.append(112, 97);
        r100.append(33, 71);
        r100.append(31, 72);
        r100.append(32, 73);
        r100.append(34, 74);
        r100.append(30, 75);
        r100.append(115, 76);
        r100.append(90, 77);
        r100.append(124, 78);
        r100.append(57, 80);
        r100.append(56, 81);
        r100.append(117, 82);
        r100.append(121, 83);
        r100.append(120, 84);
        r100.append(119, 85);
        r100.append(118, 86);
        r101.append(85, 6);
        r101.append(85, 7);
        r101.append(0, 27);
        r101.append(89, 13);
        r101.append(92, 16);
        r101.append(90, 14);
        r101.append(87, 11);
        r101.append(91, 15);
        r101.append(88, 12);
        r101.append(78, 40);
        r101.append(71, 39);
        r101.append(70, 41);
        r101.append(77, 42);
        r101.append(69, 20);
        r101.append(76, 37);
        r101.append(60, 5);
        r101.append(72, 87);
        r101.append(75, 87);
        r101.append(73, 87);
        r101.append(57, 87);
        r101.append(56, 87);
        r101.append(5, 24);
        r101.append(7, 28);
        r101.append(23, 31);
        r101.append(24, 8);
        r101.append(6, 34);
        r101.append(8, 2);
        r101.append(3, 23);
        r101.append(4, 21);
        r101.append(79, 95);
        r101.append(64, 96);
        r101.append(2, 22);
        r101.append(13, 43);
        r101.append(26, 44);
        r101.append(21, 45);
        r101.append(22, 46);
        r101.append(20, 60);
        r101.append(18, 47);
        r101.append(19, 48);
        r101.append(14, 49);
        r101.append(15, 50);
        r101.append(16, 51);
        r101.append(17, 52);
        r101.append(25, 53);
        r101.append(80, 54);
        r101.append(65, 55);
        r101.append(81, 56);
        r101.append(66, 57);
        r101.append(82, 58);
        r101.append(67, 59);
        r101.append(59, 62);
        r101.append(58, 63);
        r101.append(28, 64);
        r101.append(105, 65);
        r101.append(34, 66);
        r101.append(106, 67);
        r101.append(96, 79);
        r101.append(1, 38);
        r101.append(97, 98);
        r101.append(95, 68);
        r101.append(83, 69);
        r101.append(68, 70);
        r101.append(32, 71);
        r101.append(30, 72);
        r101.append(31, 73);
        r101.append(33, 74);
        r101.append(29, 75);
        r101.append(98, 76);
        r101.append(74, 77);
        r101.append(107, 78);
        r101.append(55, 80);
        r101.append(54, 81);
        r101.append(100, 82);
        r101.append(104, 83);
        r101.append(103, 84);
        r101.append(102, 85);
        r101.append(101, 86);
        r101.append(94, 97);
    }

    public a() {
        this.f400480b = "";
        this.f400481c = new String[0];
        this.f400482d = 0;
        this.f400483e = new HashMap();
        this.f400484f = true;
        this.f400485g = new HashMap();
    }

    public final void a(ConstraintLayout r100) {
        int r101 = r100.getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L21;
        View r103 = r100.getChildAt(r102);
        int r104 = r103.getId();
        if (this.f400485g.containsKey(Integer.valueOf(r104)) == true) goto L8;
        com.obric.oui.constraintlayout.motion.widget.a.d(r103);
    L20:
        r102 = r102 + 1;
        goto L3
    L8:
        if (this.f400484f == false) goto L15;
        if (r104 != (-1)) goto L15;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L15:
        if (this.f400485g.containsKey(Integer.valueOf(r104)) == false) goto L20;
        C4670a r105 = this.f400485g.get(Integer.valueOf(r104));
        if (r105 == null) goto L20;
        ConstraintAttribute.e(r103, r105.f400492g);
        goto L20
    }

    public final void b(ConstraintLayout r100) {
        c(r100);
        r100.setConstraintSet(null);
        r100.requestLayout();
    }

    public final void c(ConstraintLayout r110) {
        int r100 = r110.getChildCount();
        HashSet r101 = new HashSet(this.f400485g.keySet());
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r103 >= r100) goto L52;
        View r104 = r110.getChildAt(r103);
        int r105 = r104.getId();
        if (this.f400485g.containsKey(Integer.valueOf(r105)) == true) goto L9;
        com.obric.oui.constraintlayout.motion.widget.a.d(r104);
    L51:
        r103 = r103 + 1;
        goto L4
    L9:
        if (this.f400484f == false) goto L14;
        if (r105 != (-1)) goto L14;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L14:
        if (r105 == (-1)) goto L51;
        if (this.f400485g.containsKey(Integer.valueOf(r105)) == false) goto L51;
        r101.remove(Integer.valueOf(r105));
        C4670a r106 = this.f400485g.get(Integer.valueOf(r105));
        if (r106 == null) goto L51;
        if ((r104 instanceof Barrier) == false) goto L29;
        r106.f400490e.f400525i0 = 1;
        Barrier r107 = (Barrier) r104;
        r107.setId(r105);
        r107.setType(r106.f400490e.f400521g0);
        r107.setMargin(r106.f400490e.f400523h0);
        r107.setAllowsGoneWidget(r106.f400490e.f400537o0);
        b r108 = r106.f400490e;
        int[] r109 = r108.f400527j0;
        if (r109 == null) goto L26;
        r107.setReferencedIds(r109);
        goto L29
    L26:
        String r111 = r108.f400529k0;
        if (r111 == null) goto L29;
        r108.f400527j0 = f(r107, r111);
        r107.setReferencedIds(r106.f400490e.f400527j0);
    L29:
        ConstraintLayout.LayoutParams r112 = (ConstraintLayout.LayoutParams) r104.getLayoutParams();
        r112.a();
        r106.a(r112);
        ConstraintAttribute.e(r104, r106.f400492g);
        r104.setLayoutParams(r112);
        d r113 = r106.f400488c;
        if (r113.f400566c != 0) goto L32;
        r104.setVisibility(r113.f400565b);
    L32:
        r104.setAlpha(r106.f400488c.f400567d);
        r104.setRotation(r106.f400491f.f400571b);
        r104.setRotationX(r106.f400491f.f400572c);
        r104.setRotationY(r106.f400491f.f400573d);
        r104.setScaleX(r106.f400491f.f400574e);
        r104.setScaleY(r106.f400491f.f400575f);
        e r114 = r106.f400491f;
        if (r114.f400578i == (-1)) goto L42;
        View r115 = ((View) r104.getParent()).findViewById(r106.f400491f.f400578i);
        if (r115 == null) goto L47;
        float r116 = (r115.getTop() + r115.getBottom()) / 2.0f;
        float r117 = (r115.getLeft() + r115.getRight()) / 2.0f;
        if ((r104.getRight() - r104.getLeft()) <= 0) goto L47;
        if ((r104.getBottom() - r104.getTop()) <= 0) goto L47;
        float r118 = r117 - r104.getLeft();
        float r119 = r116 - r104.getTop();
        r104.setPivotX(r118);
        r104.setPivotY(r119);
    L47:
        r104.setTranslationX(r106.f400491f.f400579j);
        r104.setTranslationY(r106.f400491f.f400580k);
        r104.setTranslationZ(r106.f400491f.f400581l);
        e r120 = r106.f400491f;
        if (r120.f400582m == false) goto L51;
        r104.setElevation(r120.f400583n);
        goto L51
    L42:
        if (Float.isNaN(r114.f400576g) == true) goto L45;
        r104.setPivotX(r106.f400491f.f400576g);
    L45:
        if (Float.isNaN(r106.f400491f.f400577h) == true) goto L47;
        r104.setPivotY(r106.f400491f.f400577h);
        goto L47
    L52:
        Iterator r121 = r101.iterator();
    L54:
        if (r121.hasNext() == false) goto L70;
        Integer r122 = (Integer) r121.next();
        C4670a r123 = this.f400485g.get(r122);
        if (r123 == null) goto L54;
        if (r123.f400490e.f400525i0 != 1) goto L68;
        Barrier r124 = new Barrier(r110.getContext());
        r124.setId(r122.intValue());
        b r125 = r123.f400490e;
        int[] r126 = r125.f400527j0;
        if (r126 == null) goto L63;
        r124.setReferencedIds(r126);
    L66:
        r124.setType(r123.f400490e.f400521g0);
        r124.setMargin(r123.f400490e.f400523h0);
        com.obric.oui.constraintlayout.widget.b r127 = ConstraintLayout.f400386p;
        ConstraintLayout.LayoutParams r128 = new ConstraintLayout.LayoutParams(-2, -2);
        r124.t();
        r123.a(r128);
        r110.addView(r124, r128);
        goto L68
    L63:
        String r129 = r125.f400529k0;
        if (r129 == null) goto L66;
        r125.f400527j0 = f(r124, r129);
        r124.setReferencedIds(r123.f400490e.f400527j0);
    L68:
        if (r123.f400490e.f400508a == false) goto L54;
        View r130 = new Guideline(r110.getContext());
        r130.setId(r122.intValue());
        com.obric.oui.constraintlayout.widget.b r131 = ConstraintLayout.f400386p;
        ConstraintLayout.LayoutParams r132 = new ConstraintLayout.LayoutParams(-2, -2);
        r123.a(r132);
        r110.addView(r130, r132);
    L70:
        if (r102 >= r100) goto L75;
        View r133 = r110.getChildAt(r102);
        if ((r133 instanceof ConstraintHelper) == false) goto L74;
        ((ConstraintHelper) r133).j(r110);
    L74:
        r102 = r102 + 1;
        goto L70
    }

    public final C4670a h(int r100) {
        if (this.f400485g.containsKey(Integer.valueOf(r100)) == true) goto L6;
        this.f400485g.put(Integer.valueOf(r100), new C4670a());
    L6:
        return this.f400485g.get(Integer.valueOf(r100));
    }

    public final C4670a i(int r100) {
        if (this.f400485g.containsKey(Integer.valueOf(r100)) == true) goto L5;
        return null;
    L5:
        return this.f400485g.get(Integer.valueOf(r100));
    }

    public static C4670a d(Context r100, XmlPullParser r101) {
        AttributeSet r102 = Xml.asAttributeSet(r101);
        C4670a r103 = new C4670a();
        TypedArray r104 = r100.obtainStyledAttributes(r102, new int[]{R.attr.orientation, R.attr.id, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.alpha, R.attr.transformPivotX, R.attr.transformPivotY, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.translationZ, R.attr.elevation, com.larus.nova.R.attr.animateCircleAngleTo, com.larus.nova.R.attr.animateRelativeTo, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.drawPath, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_wrapBehaviorInParent, com.larus.nova.R.attr.motionProgress, com.larus.nova.R.attr.motionStagger, com.larus.nova.R.attr.motionTarget, com.larus.nova.R.attr.pathMotionArc, com.larus.nova.R.attr.pivotAnchor, com.larus.nova.R.attr.polarRelativeTo, com.larus.nova.R.attr.quantizeMotionInterpolator, com.larus.nova.R.attr.quantizeMotionPhase, com.larus.nova.R.attr.quantizeMotionSteps, com.larus.nova.R.attr.transformPivotTarget, com.larus.nova.R.attr.transitionEasing, com.larus.nova.R.attr.transitionPathRotate, com.larus.nova.R.attr.visibilityMode});
        o(r103, r104);
        r104.recycle();
        return r103;
    }

    public static int[] f(Barrier r110, String r111) {
        String[] r112 = r111.split(",");
        Context r100 = r110.getContext();
        int[] r101 = new int[r112.length];
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= r112.length) goto L29;
        String r104 = r112[r102].trim();
        Integer r105 = null;
        int r106 = R.id.class.getField(r104).getInt(null);     // Catch: Exception -> L8
    L9:
        if (r106 != 0) goto L11;
        r106 = r100.getResources().getIdentifier(r104, "id", r100.getPackageName());
    L11:
        if (r106 != 0) goto L27;
        if (r110.isInEditMode() == false) goto L27;
        if ((r110.getParent() instanceof ConstraintLayout) == false) goto L27;
        ConstraintLayout r107 = (ConstraintLayout) r110.getParent();
        r107.getClass();
        if ((r104 instanceof String) == false) goto L23;
        HashMap<String, Integer> r108 = r107.f400399m;
        if (r108 == null) goto L23;
        if (r108.containsKey(r104) == false) goto L23;
        r105 = r107.f400399m.get(r104);
    L23:
        if (r105 == null) goto L27;
        if ((r105 instanceof Integer) == false) goto L27;
        r106 = r105.intValue();
    L27:
        r101[r103] = r106;
        r102 = r102 + 1;
        r103 = r103 + 1;
    L8:
        r106 = 0;
        goto L9
    L29:
        if (r103 != r112.length) goto L31;
        return r101;
    L31:
        return Arrays.copyOf(r101, r103);
    }

    public static void n(ConstraintLayout.LayoutParams r100, String r101) {
        if (r101 == null) goto L34;
        int r102 = r101.length();
        int r103 = r101.indexOf(44);
        int r104 = 0;
        int r105 = -1;
        if (r103 > 0) goto L6;
    L15:
        int r106 = r101.indexOf(58);
        if (r106 >= 0) goto L18;
    L31:
        String r107 = r101.substring(r104);
        if (r107.length() <= 0) goto L34;
        CastFloatProtector.parseFloat(r107);     // Catch: NumberFormatException -> L36
    L37:
        goto L34
    L18:
        if (r106 >= (r102 - 1)) goto L31;
        String r108 = r101.substring(r104, r106);
        String r109 = r101.substring(r106 + 1);
        if (r108.length() <= 0) goto L34;
        if (r109.length() <= 0) goto L34;
        float r110 = CastFloatProtector.parseFloat(r108);     // Catch: NumberFormatException -> L36
        float r111 = CastFloatProtector.parseFloat(r109);     // Catch: NumberFormatException -> L36
        if (r110 <= 0.0f) goto L37;
        if (r111 <= 0.0f) goto L37;
        if (r105 != 1) goto L29;
        Math.abs(r111 / r110);     // Catch: NumberFormatException -> L36
        goto L37
    L29:
        Math.abs(r110 / r111);     // Catch: NumberFormatException -> L36
        goto L37
    L6:
        if (r103 >= (r102 - 1)) goto L15;
        String r112 = r101.substring(0, r103);
        if (r112.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST) == false) goto L11;
    L14:
        r105 = r104;
        r104 = r103 + 1;
        goto L15
    L11:
        if (r112.equalsIgnoreCase(FaceService.neutralLabel) == false) goto L13;
        r104 = 1;
        goto L14
    L13:
        r104 = -1;
    L34:
        r100.G = r101;
    }

    public static void o(C4670a r110, TypedArray r111) {
        int r100 = r111.getIndexCount();
        C4670a.C4671a r101 = new C4670a.C4671a();
        r110.f400493h = r101;
        r110.f400489d.f400551a = false;
        r110.f400490e.f400510b = false;
        r110.f400488c.f400564a = false;
        r110.f400491f.f400570a = false;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L108;
        int r103 = r111.getIndex(r102);
        switch(f400478j.get(r103)) {
            case 2: goto L106;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L105;
            case 6: goto L104;
            case 7: goto L103;
            case 8: goto L102;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L101;
            case 12: goto L100;
            case 13: goto L99;
            case 14: goto L98;
            case 15: goto L97;
            case 16: goto L96;
            case 17: goto L95;
            case 18: goto L94;
            case 19: goto L93;
            case 20: goto L92;
            case 21: goto L91;
            case 22: goto L90;
            case 23: goto L89;
            case 24: goto L88;
            case 25: goto L6;
            case 26: goto L6;
            case 27: goto L87;
            case 28: goto L86;
            case 29: goto L6;
            case 30: goto L6;
            case 31: goto L85;
            case 32: goto L6;
            case 33: goto L6;
            case 34: goto L84;
            case 35: goto L6;
            case 36: goto L6;
            case 37: goto L83;
            case 38: goto L82;
            case 39: goto L81;
            case 40: goto L80;
            case 41: goto L79;
            case 42: goto L78;
            case 43: goto L77;
            case 44: goto L76;
            case 45: goto L75;
            case 46: goto L74;
            case 47: goto L73;
            case 48: goto L72;
            case 49: goto L71;
            case 50: goto L70;
            case 51: goto L69;
            case 52: goto L68;
            case 53: goto L67;
            case 54: goto L66;
            case 55: goto L65;
            case 56: goto L64;
            case 57: goto L63;
            case 58: goto L62;
            case 59: goto L61;
            case 60: goto L60;
            case 61: goto L6;
            case 62: goto L59;
            case 63: goto L58;
            case 64: goto L57;
            case 65: goto L54;
            case 66: goto L52;
            case 67: goto L51;
            case 68: goto L50;
            case 69: goto L49;
            case 70: goto L48;
            case 71: goto L107;
            case 72: goto L47;
            case 73: goto L46;
            case 74: goto L45;
            case 75: goto L44;
            case 76: goto L43;
            case 77: goto L42;
            case 78: goto L41;
            case 79: goto L40;
            case 80: goto L39;
            case 81: goto L38;
            case 82: goto L37;
            case 83: goto L36;
            case 84: goto L35;
            case 85: goto L34;
            case 86: goto L23;
            case 87: goto L22;
            case 88: goto L6;
            case 89: goto L6;
            case 90: goto L6;
            case 91: goto L6;
            case 92: goto L6;
            case 93: goto L21;
            case 94: goto L20;
            case 95: goto L19;
            case 96: goto L18;
            case 97: goto L17;
            case 98: goto L9;
            case 99: goto L7;
            default: goto L6;
        };
    L6:
        Integer.toHexString(r103);
        f400477i.get(r103);
        goto L107
    L7:
        r101.d(99, r111.getBoolean(r103, r110.f400490e.f400522h));
        goto L107
    L17:
        r101.b(97, r111.getInt(r103, r110.f400490e.f400539p0));
        goto L107
    L18:
        m(r101, r111, r103, 1);
        goto L107
    L19:
        m(r101, r111, r103, 0);
        goto L107
    L20:
        r101.b(94, r111.getDimensionPixelSize(r103, r110.f400490e.T));
        goto L107
    L21:
        r101.b(93, r111.getDimensionPixelSize(r103, r110.f400490e.M));
        goto L107
    L22:
        Integer.toHexString(r103);
        f400477i.get(r103);
        goto L107
    L23:
        int r104 = r111.peekValue(r103).type;
        if (r104 != 1) goto L28;
        c r105 = r110.f400489d;
        r105.f400563m = r111.getResourceId(r103, -1);
        r101.b(89, r110.f400489d.f400563m);
        c r106 = r110.f400489d;
        if (r106.f400563m == (-1)) goto L107;
        r106.f400562l = -2;
        r101.b(88, -2);
        goto L107
    L28:
        if (r104 != 3) goto L33;
        c r107 = r110.f400489d;
        r107.f400561k = r111.getString(r103);
        r101.c(90, r110.f400489d.f400561k);
        if (r110.f400489d.f400561k.indexOf(HTTP.URL_DEFAULT) <= 0) goto L32;
        c r108 = r110.f400489d;
        r108.f400563m = r111.getResourceId(r103, -1);
        r101.b(89, r110.f400489d.f400563m);
        r110.f400489d.f400562l = -2;
        r101.b(88, -2);
        goto L107
    L32:
        r110.f400489d.f400562l = -1;
        r101.b(88, -1);
        goto L107
    L33:
        c r109 = r110.f400489d;
        r109.f400562l = r111.getInteger(r103, r109.f400563m);
        r101.b(88, r110.f400489d.f400562l);
        goto L107
    L34:
        r101.a(85, r111.getFloat(r103, r110.f400489d.f400559i));
        goto L107
    L35:
        r101.b(84, r111.getInteger(r103, r110.f400489d.f400560j));
        goto L107
    L36:
        r101.b(83, l(r111, r103, r110.f400491f.f400578i));
        goto L107
    L37:
        r101.b(82, r111.getInteger(r103, r110.f400489d.f400553c));
        goto L107
    L38:
        r101.d(81, r111.getBoolean(r103, r110.f400490e.f400535n0));
        goto L107
    L39:
        r101.d(80, r111.getBoolean(r103, r110.f400490e.f400533m0));
        goto L107
    L40:
        r101.a(79, r111.getFloat(r103, r110.f400489d.f400557g));
        goto L107
    L41:
        r101.b(78, r111.getInt(r103, r110.f400488c.f400566c));
        goto L107
    L42:
        r101.c(77, r111.getString(r103));
        goto L107
    L43:
        r101.b(76, r111.getInt(r103, r110.f400489d.f400555e));
        goto L107
    L44:
        r101.d(75, r111.getBoolean(r103, r110.f400490e.f400537o0));
        goto L107
    L45:
        r101.c(74, r111.getString(r103));
        goto L107
    L46:
        r101.b(73, r111.getDimensionPixelSize(r103, r110.f400490e.f400523h0));
        goto L107
    L47:
        r101.b(72, r111.getInt(r103, r110.f400490e.f400521g0));
        goto L107
    L48:
        r101.a(70, r111.getFloat(r103, 1.0f));
        goto L107
    L49:
        r101.a(69, r111.getFloat(r103, 1.0f));
        goto L107
    L50:
        r101.a(68, r111.getFloat(r103, r110.f400488c.f400568e));
        goto L107
    L51:
        r101.a(67, r111.getFloat(r103, r110.f400489d.f400558h));
        goto L107
    L52:
        r101.b(66, r111.getInt(r103, 0));
        goto L107
    L57:
        r101.b(64, l(r111, r103, r110.f400489d.f400552b));
        goto L107
    L58:
        r101.a(63, r111.getFloat(r103, r110.f400490e.C));
        goto L107
    L59:
        r101.b(62, r111.getDimensionPixelSize(r103, r110.f400490e.B));
        goto L107
    L60:
        r101.a(60, r111.getFloat(r103, r110.f400491f.f400571b));
        goto L107
    L61:
        r101.b(59, r111.getDimensionPixelSize(r103, r110.f400490e.f400515d0));
        goto L107
    L62:
        r101.b(58, r111.getDimensionPixelSize(r103, r110.f400490e.f400513c0));
        goto L107
    L63:
        r101.b(57, r111.getDimensionPixelSize(r103, r110.f400490e.f400511b0));
        goto L107
    L64:
        r101.b(56, r111.getDimensionPixelSize(r103, r110.f400490e.f400509a0));
        goto L107
    L65:
        r101.b(55, r111.getInt(r103, r110.f400490e.Z));
        goto L107
    L66:
        r101.b(54, r111.getInt(r103, r110.f400490e.Y));
        goto L107
    L67:
        r101.a(53, r111.getDimension(r103, r110.f400491f.f400581l));
        goto L107
    L68:
        r101.a(52, r111.getDimension(r103, r110.f400491f.f400580k));
        goto L107
    L69:
        r101.a(51, r111.getDimension(r103, r110.f400491f.f400579j));
        goto L107
    L70:
        r101.a(50, r111.getDimension(r103, r110.f400491f.f400577h));
        goto L107
    L71:
        r101.a(49, r111.getDimension(r103, r110.f400491f.f400576g));
        goto L107
    L72:
        r101.a(48, r111.getFloat(r103, r110.f400491f.f400575f));
        goto L107
    L73:
        r101.a(47, r111.getFloat(r103, r110.f400491f.f400574e));
        goto L107
    L74:
        r101.a(46, r111.getFloat(r103, r110.f400491f.f400573d));
        goto L107
    L75:
        r101.a(45, r111.getFloat(r103, r110.f400491f.f400572c));
        goto L107
    L76:
        r101.d(44, true);
        r101.a(44, r111.getDimension(r103, r110.f400491f.f400583n));
        goto L107
    L77:
        r101.a(43, r111.getFloat(r103, r110.f400488c.f400567d));
        goto L107
    L78:
        r101.b(42, r111.getInt(r103, r110.f400490e.X));
        goto L107
    L79:
        r101.b(41, r111.getInt(r103, r110.f400490e.W));
        goto L107
    L80:
        r101.a(40, r111.getFloat(r103, r110.f400490e.U));
        goto L107
    L81:
        r101.a(39, r111.getFloat(r103, r110.f400490e.V));
        goto L107
    L82:
        int r112 = r111.getResourceId(r103, r110.f400486a);
        r110.f400486a = r112;
        r101.b(38, r112);
        goto L107
    L83:
        r101.a(37, r111.getFloat(r103, r110.f400490e.f400548y));
        goto L107
    L84:
        r101.b(34, r111.getDimensionPixelSize(r103, r110.f400490e.I));
        goto L107
    L85:
        r101.b(31, r111.getDimensionPixelSize(r103, r110.f400490e.L));
        goto L107
    L86:
        r101.b(28, r111.getDimensionPixelSize(r103, r110.f400490e.H));
        goto L107
    L87:
        r101.b(27, r111.getInt(r103, r110.f400490e.F));
        goto L107
    L88:
        r101.b(24, r111.getDimensionPixelSize(r103, r110.f400490e.G));
        goto L107
    L89:
        r101.b(23, r111.getLayoutDimension(r103, r110.f400490e.f400512c));
        goto L107
    L90:
        r101.b(22, f400476h[r111.getInt(r103, r110.f400488c.f400565b)]);
        goto L107
    L91:
        r101.b(21, r111.getLayoutDimension(r103, r110.f400490e.f400514d));
        goto L107
    L92:
        r101.a(20, r111.getFloat(r103, r110.f400490e.f400547x));
        goto L107
    L93:
        r101.a(19, r111.getFloat(r103, r110.f400490e.f400520g));
        goto L107
    L94:
        r101.b(18, r111.getDimensionPixelOffset(r103, r110.f400490e.f400518f));
        goto L107
    L95:
        r101.b(17, r111.getDimensionPixelOffset(r103, r110.f400490e.f400516e));
        goto L107
    L96:
        r101.b(16, r111.getDimensionPixelSize(r103, r110.f400490e.O));
        goto L107
    L97:
        r101.b(15, r111.getDimensionPixelSize(r103, r110.f400490e.S));
        goto L107
    L98:
        r101.b(14, r111.getDimensionPixelSize(r103, r110.f400490e.P));
        goto L107
    L99:
        r101.b(13, r111.getDimensionPixelSize(r103, r110.f400490e.N));
        goto L107
    L100:
        r101.b(12, r111.getDimensionPixelSize(r103, r110.f400490e.R));
        goto L107
    L101:
        r101.b(11, r111.getDimensionPixelSize(r103, r110.f400490e.Q));
        goto L107
    L102:
        r101.b(8, r111.getDimensionPixelSize(r103, r110.f400490e.K));
        goto L107
    L103:
        r101.b(7, r111.getDimensionPixelOffset(r103, r110.f400490e.E));
        goto L107
    L104:
        r101.b(6, r111.getDimensionPixelOffset(r103, r110.f400490e.D));
        goto L107
    L105:
        r101.c(5, r111.getString(r103));
        goto L107
    L106:
        r101.b(2, r111.getDimensionPixelSize(r103, r110.f400490e.f400507J));
        goto L107
    L9:
        if (MotionLayout.F2 == false) goto L14;
        int r113 = r111.getResourceId(r103, r110.f400486a);
        r110.f400486a = r113;
        if (r113 != (-1)) goto L107;
        r110.f400487b = r111.getString(r103);
        goto L107
    L14:
        if (r111.peekValue(r103).type != 3) goto L16;
        r110.f400487b = r111.getString(r103);
        goto L107
    L16:
        r110.f400486a = r111.getResourceId(r103, r110.f400486a);
        goto L107
    L54:
        if (r111.peekValue(r103).type != 3) goto L56;
        r101.c(65, r111.getString(r103));
        goto L107
    L56:
        r101.c(65, tla.c.f546670c[r111.getInteger(r103, 0)]);
    L107:
        r102 = r102 + 1;
        goto L3
    }

    public final void e(Context r110, int r111) {
        a r100 = this;
        ConstraintLayout r101 = (ConstraintLayout) LayoutInflater.from(r110).inflate(r111, null);
        int r102 = r101.getChildCount();
        r100.f400485g.clear();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L47;
        View r104 = r101.getChildAt(r103);
        ConstraintLayout.LayoutParams r105 = (ConstraintLayout.LayoutParams) r104.getLayoutParams();
        int r106 = r104.getId();
        if (r100.f400484f == false) goto L12;
        if (r106 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (r100.f400485g.containsKey(Integer.valueOf(r106)) == true) goto L14;
        r100.f400485g.put(Integer.valueOf(r106), new C4670a());
    L14:
        C4670a r107 = r100.f400485g.get(Integer.valueOf(r106));
        if (r107 == null) goto L46;
        HashMap<String, ConstraintAttribute> r108 = r100.f400483e;
        HashMap<String, ConstraintAttribute> r112 = new HashMap();
        Class<?> r113 = r104.getClass();
        Iterator<String> r114 = r108.keySet().iterator();
    L19:
        if (r114.hasNext() == false) goto L35;
        String r115 = r114.next();
        ConstraintAttribute r116 = r108.get(r115);
        if (r115.equals("BackgroundColor") == true) goto L23;
        r112.put(r115, new ConstraintAttribute(r116, r113.getMethod("getMap" + r115, new Class[0]).invoke(r104, new Object[0])));     // Catch: InvocationTargetException -> L48 IllegalAccessException -> L49 NoSuchMethodException -> L50
        goto L19
    L23:
        r112.put(r115, new ConstraintAttribute(r116, Integer.valueOf(((ColorDrawable) r104.getBackground()).getColor())));     // Catch: InvocationTargetException -> L28 IllegalAccessException -> L30 NoSuchMethodException -> L32
        goto L19
        goto L19
    L35:
        r107.f400492g = r112;
        r107.c(r106, r105);
        r107.f400488c.f400565b = r104.getVisibility();
        r107.f400488c.f400567d = r104.getAlpha();
        r107.f400491f.f400571b = r104.getRotation();
        r107.f400491f.f400572c = r104.getRotationX();
        r107.f400491f.f400573d = r104.getRotationY();
        r107.f400491f.f400574e = r104.getScaleX();
        r107.f400491f.f400575f = r104.getScaleY();
        float r109 = r104.getPivotX();
        float r117 = r104.getPivotY();
        if (r109 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L38;
    L39:
        e r118 = r107.f400491f;
        r118.f400576g = r109;
        r118.f400577h = r117;
    L40:
        r107.f400491f.f400579j = r104.getTranslationX();
        r107.f400491f.f400580k = r104.getTranslationY();
        r107.f400491f.f400581l = r104.getTranslationZ();
        e r119 = r107.f400491f;
        if (r119.f400582m == false) goto L44;
        r119.f400583n = r104.getElevation();
    L44:
        if ((r104 instanceof Barrier) == false) goto L46;
        Barrier r120 = (Barrier) r104;
        r107.f400490e.f400537o0 = r120.getAllowsGoneWidget();
        r107.f400490e.f400527j0 = r120.getReferencedIds();
        r107.f400490e.f400521g0 = r120.getType();
        r107.f400490e.f400523h0 = r120.getMargin();
        goto L46
    L38:
        if (r117 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L40;
    L46:
        r103 = r103 + 1;
        r100 = this;
        goto L3
    }

    public final void j(Context r100, int r101) {
        XmlResourceParser r102 = r100.getResources().getXml(r101);
        int r103 = r102.getEventType();     // Catch: IOException -> L15 XmlPullParserException -> L16
    L5:
        if (r103 == 1) goto L25;
        if (r103 != 2) goto L13;
        String r104 = r102.getName();     // Catch: IOException -> L15 XmlPullParserException -> L16
        C4670a r105 = g(r100, Xml.asAttributeSet(r102), false);     // Catch: IOException -> L15 XmlPullParserException -> L16
        if (r104.equalsIgnoreCase("Guideline") == false) goto L12;
        r105.f400490e.f400508a = true;     // Catch: IOException -> L15 XmlPullParserException -> L16
    L12:
        this.f400485g.put(Integer.valueOf(r105.f400486a), r105);     // Catch: IOException -> L15 XmlPullParserException -> L16
    L13:
        r103 = r102.next();     // Catch: IOException -> L15 XmlPullParserException -> L16
    L25:
        return;
    L24:
        return;
    }

    public final void k(Context r110, XmlPullParser r111) {
        int r100 = r111.getEventType();     // Catch: Throwable -> L99
        C4670a r101 = null;
    L4:
        if (r100 == 1) goto L119;
        if (r100 == 0) goto L95;
        byte r102 = 0;
        byte r103 = 2;
        if (r100 == 2) goto L33;
        if (r100 != 3) goto L96;
        String r104 = r111.getName().toLowerCase(Locale.ROOT);     // Catch: Throwable -> L99
        switch(r104.hashCode()) {
            case -2075718416: goto L23;
            case -190376483: goto L20;
            case 426575017: goto L17;
            case 2146106725: goto L14;
            default: goto L25;
        };     // Catch: Throwable -> L99
    L25:
        r102 = -1;
    L26:
        if (r102 == 0) goto L32;
        if (r102 == 1) goto L31;
        if (r102 == 2) goto L31;
        if (r102 != 3) goto L96;
    L31:
        this.f400485g.put(Integer.valueOf(r101.f400486a), r101);     // Catch: Throwable -> L99
        r101 = null;
        goto L96
    L32:
        return;
    L14:
        if (r104.equals("constraintset") == false) goto L25;
    L17:
        if (r104.equals("constraintoverride") == false) goto L25;
        r102 = 2;
        goto L26
    L20:
        if (r104.equals("constraint") == false) goto L25;
        r102 = 1;
        goto L26
    L23:
        if (r104.equals("guideline") == false) goto L25;
        r102 = 3;
    L96:
        r100 = r111.next();     // Catch: Throwable -> L99 Throwable -> L99
        goto L4
    L33:
        String r105 = r111.getName();     // Catch: Throwable -> L99
        switch(r105.hashCode()) {
            case -2025855158: goto L64;
            case -1984451626: goto L61;
            case -1962203927: goto L58;
            case -1269513683: goto L55;
            case -1238332596: goto L52;
            case -71750448: goto L49;
            case 366511058: goto L46;
            case 1331510167: goto L43;
            case 1791837707: goto L40;
            case 1803088381: goto L37;
            default: goto L66;
        };     // Catch: Throwable -> L99
    L66:
        r103 = -1;
    L68:
        switch(r103) {
            case 0: goto L93;
            case 1: goto L92;
            case 2: goto L91;
            case 3: goto L90;
            case 4: goto L86;
            case 5: goto L82;
            case 6: goto L78;
            case 7: goto L74;
            case 8: goto L70;
            case 9: goto L70;
            default: goto L96;
        };
    L70:
        if (r101 == null) goto L73;
        ConstraintAttribute.d(r110, r111, r101.f400492g);     // Catch: Throwable -> L99 Throwable -> L99
        goto L96
    L73:
        throw new RuntimeException("XML parser error must be within a Constraint " + r111.getLineNumber());     // Catch: Throwable -> L99 Throwable -> L99
    L74:
        if (r101 == null) goto L77;
        r101.f400489d.b(r110, Xml.asAttributeSet(r111));     // Catch: Throwable -> L99 Throwable -> L99
        goto L96
    L77:
        throw new RuntimeException("XML parser error must be within a Constraint " + r111.getLineNumber());     // Catch: Throwable -> L99 Throwable -> L99
    L78:
        if (r101 == null) goto L81;
        r101.f400490e.b(r110, Xml.asAttributeSet(r111));     // Catch: Throwable -> L99 Throwable -> L99
        goto L96
    L81:
        throw new RuntimeException("XML parser error must be within a Constraint " + r111.getLineNumber());     // Catch: Throwable -> L99 Throwable -> L99
    L82:
        if (r101 == null) goto L85;
        r101.f400491f.b(r110, Xml.asAttributeSet(r111));     // Catch: Throwable -> L99 Throwable -> L99
        goto L96
    L85:
        throw new RuntimeException("XML parser error must be within a Constraint " + r111.getLineNumber());     // Catch: Throwable -> L99 Throwable -> L99
    L86:
        if (r101 == null) goto L89;
        r101.f400488c.a(r110, Xml.asAttributeSet(r111));     // Catch: Throwable -> L99 Throwable -> L99
        goto L96
    L89:
        throw new RuntimeException("XML parser error must be within a Constraint " + r111.getLineNumber());     // Catch: Throwable -> L99 Throwable -> L99
    L90:
        C4670a r106 = g(r110, Xml.asAttributeSet(r111), false);     // Catch: Throwable -> L99 Throwable -> L99
        r106.f400490e.f400525i0 = 1;     // Catch: Throwable -> L99 Throwable -> L99
    L94:
        r101 = r106;
        goto L96
    L91:
        r106 = g(r110, Xml.asAttributeSet(r111), false);     // Catch: Throwable -> L99 Throwable -> L99
        b r107 = r106.f400490e;     // Catch: Throwable -> L99 Throwable -> L99
        r107.f400508a = true;     // Catch: Throwable -> L99 Throwable -> L99
        r107.f400510b = true;     // Catch: Throwable -> L99 Throwable -> L99
        goto L94
    L92:
        r106 = g(r110, Xml.asAttributeSet(r111), true);     // Catch: Throwable -> L99 Throwable -> L99
        goto L94
    L93:
        r106 = g(r110, Xml.asAttributeSet(r111), false);     // Catch: Throwable -> L99 Throwable -> L99
        goto L94
    L37:
        if (r105.equals("Constraint") == false) goto L66;
        r103 = 0;
        goto L68
    L40:
        if (r105.equals("CustomAttribute") == false) goto L66;
        r103 = 8;
        goto L68
    L43:
        if (r105.equals("Barrier") == false) goto L66;
        r103 = 3;
        goto L68
    L46:
        if (r105.equals("CustomMethod") == false) goto L66;
        r103 = 9;
        goto L68
    L49:
        if (r105.equals("Guideline") == false) goto L66;
    L52:
        if (r105.equals("Transform") == false) goto L66;
        r103 = 5;
        goto L68
    L55:
        if (r105.equals("PropertySet") == false) goto L66;
        r103 = 4;
        goto L68
    L58:
        if (r105.equals("ConstraintOverride") == false) goto L66;
        r103 = 1;
        goto L68
    L61:
        if (r105.equals("Motion") == false) goto L66;
        r103 = 7;
        goto L68
    L64:
        if (r105.equals("Layout") == false) goto L66;
        r103 = 6;
        goto L68
    L95:
        r111.getName();     // Catch: Throwable -> L99 Throwable -> L99
        goto L96
    L119:
        return;
    }

    public static C4670a g(Context r100, AttributeSet r101, boolean r110) {
        C4670a r102 = new C4670a();
        if (r110 == false) goto L5;
        int[] r103 = {R.attr.orientation, R.attr.id, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.alpha, R.attr.transformPivotX, R.attr.transformPivotY, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.translationZ, R.attr.elevation, com.larus.nova.R.attr.animateCircleAngleTo, com.larus.nova.R.attr.animateRelativeTo, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.drawPath, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_wrapBehaviorInParent, com.larus.nova.R.attr.motionProgress, com.larus.nova.R.attr.motionStagger, com.larus.nova.R.attr.motionTarget, com.larus.nova.R.attr.pathMotionArc, com.larus.nova.R.attr.pivotAnchor, com.larus.nova.R.attr.polarRelativeTo, com.larus.nova.R.attr.quantizeMotionInterpolator, com.larus.nova.R.attr.quantizeMotionPhase, com.larus.nova.R.attr.quantizeMotionSteps, com.larus.nova.R.attr.transformPivotTarget, com.larus.nova.R.attr.transitionEasing, com.larus.nova.R.attr.transitionPathRotate, com.larus.nova.R.attr.visibilityMode};
    L6:
        TypedArray r104 = r100.obtainStyledAttributes(r101, r103);
        if (r110 == false) goto L9;
        o(r102, r104);
    L131:
        r104.recycle();
        return r102;
    L9:
        int r105 = r104.getIndexCount();
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L128;
        int r107 = r104.getIndex(r106);
        if (r107 != 1) goto L14;
    L18:
        SparseIntArray r108 = f400477i;
        switch(r108.get(r107)) {
            case 1: goto L126;
            case 2: goto L125;
            case 3: goto L124;
            case 4: goto L123;
            case 5: goto L122;
            case 6: goto L121;
            case 7: goto L120;
            case 8: goto L119;
            case 9: goto L118;
            case 10: goto L117;
            case 11: goto L116;
            case 12: goto L115;
            case 13: goto L114;
            case 14: goto L113;
            case 15: goto L112;
            case 16: goto L111;
            case 17: goto L110;
            case 18: goto L109;
            case 19: goto L108;
            case 20: goto L107;
            case 21: goto L106;
            case 22: goto L105;
            case 23: goto L104;
            case 24: goto L103;
            case 25: goto L102;
            case 26: goto L101;
            case 27: goto L100;
            case 28: goto L99;
            case 29: goto L98;
            case 30: goto L97;
            case 31: goto L96;
            case 32: goto L95;
            case 33: goto L94;
            case 34: goto L93;
            case 35: goto L92;
            case 36: goto L91;
            case 37: goto L90;
            case 38: goto L89;
            case 39: goto L88;
            case 40: goto L87;
            case 41: goto L86;
            case 42: goto L85;
            case 43: goto L84;
            case 44: goto L83;
            case 45: goto L82;
            case 46: goto L81;
            case 47: goto L80;
            case 48: goto L79;
            case 49: goto L78;
            case 50: goto L77;
            case 51: goto L76;
            case 52: goto L75;
            case 53: goto L74;
            case 54: goto L73;
            case 55: goto L72;
            case 56: goto L71;
            case 57: goto L70;
            case 58: goto L69;
            case 59: goto L68;
            case 60: goto L67;
            case 61: goto L66;
            case 62: goto L65;
            case 63: goto L64;
            case 64: goto L63;
            case 65: goto L60;
            case 66: goto L58;
            case 67: goto L57;
            case 68: goto L56;
            case 69: goto L55;
            case 70: goto L54;
            case 71: goto L127;
            case 72: goto L53;
            case 73: goto L52;
            case 74: goto L51;
            case 75: goto L50;
            case 76: goto L49;
            case 77: goto L48;
            case 78: goto L47;
            case 79: goto L46;
            case 80: goto L45;
            case 81: goto L44;
            case 82: goto L43;
            case 83: goto L42;
            case 84: goto L41;
            case 85: goto L40;
            case 86: goto L29;
            case 87: goto L28;
            case 88: goto L20;
            case 89: goto L20;
            case 90: goto L20;
            case 91: goto L27;
            case 92: goto L26;
            case 93: goto L25;
            case 94: goto L24;
            case 95: goto L23;
            case 96: goto L22;
            case 97: goto L21;
            default: goto L20;
        };
    L20:
        Integer.toHexString(r107);
        r108.get(r107);
        goto L127
    L21:
        b r109 = r102.f400490e;
        r109.f400539p0 = r104.getInt(r107, r109.f400539p0);
        goto L127
    L22:
        m(r102.f400490e, r104, r107, 1);
        goto L127
    L23:
        m(r102.f400490e, r104, r107, 0);
        goto L127
    L24:
        b r111 = r102.f400490e;
        r111.T = r104.getDimensionPixelSize(r107, r111.T);
        goto L127
    L25:
        b r112 = r102.f400490e;
        r112.M = r104.getDimensionPixelSize(r107, r112.M);
        goto L127
    L26:
        b r113 = r102.f400490e;
        r113.f400542s = l(r104, r107, r113.f400542s);
        goto L127
    L27:
        b r114 = r102.f400490e;
        r114.f400541r = l(r104, r107, r114.f400541r);
        goto L127
    L28:
        Integer.toHexString(r107);
        r108.get(r107);
        goto L127
    L29:
        int r115 = r104.peekValue(r107).type;
        if (r115 != 1) goto L34;
        c r116 = r102.f400489d;
        r116.f400563m = r104.getResourceId(r107, -1);
        c r117 = r102.f400489d;
        if (r117.f400563m == (-1)) goto L127;
        r117.f400562l = -2;
        goto L127
    L34:
        if (r115 != 3) goto L39;
        c r118 = r102.f400489d;
        r118.f400561k = r104.getString(r107);
        if (r102.f400489d.f400561k.indexOf(HTTP.URL_DEFAULT) <= 0) goto L38;
        c r119 = r102.f400489d;
        r119.f400563m = r104.getResourceId(r107, -1);
        r102.f400489d.f400562l = -2;
        goto L127
    L38:
        r102.f400489d.f400562l = -1;
        goto L127
    L39:
        c r120 = r102.f400489d;
        r120.f400562l = r104.getInteger(r107, r120.f400563m);
        goto L127
    L40:
        c r121 = r102.f400489d;
        r121.f400559i = r104.getFloat(r107, r121.f400559i);
        goto L127
    L41:
        c r122 = r102.f400489d;
        r122.f400560j = r104.getInteger(r107, r122.f400560j);
        goto L127
    L42:
        e r123 = r102.f400491f;
        r123.f400578i = l(r104, r107, r123.f400578i);
        goto L127
    L43:
        c r124 = r102.f400489d;
        r124.f400553c = r104.getInteger(r107, r124.f400553c);
        goto L127
    L44:
        b r125 = r102.f400490e;
        r125.f400535n0 = r104.getBoolean(r107, r125.f400535n0);
        goto L127
    L45:
        b r126 = r102.f400490e;
        r126.f400533m0 = r104.getBoolean(r107, r126.f400533m0);
        goto L127
    L46:
        c r127 = r102.f400489d;
        r127.f400557g = r104.getFloat(r107, r127.f400557g);
        goto L127
    L47:
        d r128 = r102.f400488c;
        r128.f400566c = r104.getInt(r107, r128.f400566c);
        goto L127
    L48:
        b r129 = r102.f400490e;
        r129.f400531l0 = r104.getString(r107);
        goto L127
    L49:
        c r130 = r102.f400489d;
        r130.f400555e = r104.getInt(r107, r130.f400555e);
        goto L127
    L50:
        b r131 = r102.f400490e;
        r131.f400537o0 = r104.getBoolean(r107, r131.f400537o0);
        goto L127
    L51:
        b r132 = r102.f400490e;
        r132.f400529k0 = r104.getString(r107);
        goto L127
    L52:
        b r133 = r102.f400490e;
        r133.f400523h0 = r104.getDimensionPixelSize(r107, r133.f400523h0);
        goto L127
    L53:
        b r134 = r102.f400490e;
        r134.f400521g0 = r104.getInt(r107, r134.f400521g0);
        goto L127
    L54:
        b r135 = r102.f400490e;
        r135.f400519f0 = r104.getFloat(r107, 1.0f);
        goto L127
    L55:
        b r136 = r102.f400490e;
        r136.f400517e0 = r104.getFloat(r107, 1.0f);
        goto L127
    L56:
        d r137 = r102.f400488c;
        r137.f400568e = r104.getFloat(r107, r137.f400568e);
        goto L127
    L57:
        c r138 = r102.f400489d;
        r138.f400558h = r104.getFloat(r107, r138.f400558h);
        goto L127
    L58:
        c r139 = r102.f400489d;
        r139.f400556f = r104.getInt(r107, 0);
        goto L127
    L63:
        c r140 = r102.f400489d;
        r140.f400552b = l(r104, r107, r140.f400552b);
        goto L127
    L64:
        b r141 = r102.f400490e;
        r141.C = r104.getFloat(r107, r141.C);
        goto L127
    L65:
        b r142 = r102.f400490e;
        r142.B = r104.getDimensionPixelSize(r107, r142.B);
        goto L127
    L66:
        b r143 = r102.f400490e;
        r143.A = l(r104, r107, r143.A);
        goto L127
    L67:
        e r144 = r102.f400491f;
        r144.f400571b = r104.getFloat(r107, r144.f400571b);
        goto L127
    L68:
        b r145 = r102.f400490e;
        r145.f400515d0 = r104.getDimensionPixelSize(r107, r145.f400515d0);
        goto L127
    L69:
        b r146 = r102.f400490e;
        r146.f400513c0 = r104.getDimensionPixelSize(r107, r146.f400513c0);
        goto L127
    L70:
        b r147 = r102.f400490e;
        r147.f400511b0 = r104.getDimensionPixelSize(r107, r147.f400511b0);
        goto L127
    L71:
        b r148 = r102.f400490e;
        r148.f400509a0 = r104.getDimensionPixelSize(r107, r148.f400509a0);
        goto L127
    L72:
        b r149 = r102.f400490e;
        r149.Z = r104.getInt(r107, r149.Z);
        goto L127
    L73:
        b r150 = r102.f400490e;
        r150.Y = r104.getInt(r107, r150.Y);
        goto L127
    L74:
        e r151 = r102.f400491f;
        r151.f400581l = r104.getDimension(r107, r151.f400581l);
        goto L127
    L75:
        e r152 = r102.f400491f;
        r152.f400580k = r104.getDimension(r107, r152.f400580k);
        goto L127
    L76:
        e r153 = r102.f400491f;
        r153.f400579j = r104.getDimension(r107, r153.f400579j);
        goto L127
    L77:
        e r154 = r102.f400491f;
        r154.f400577h = r104.getDimension(r107, r154.f400577h);
        goto L127
    L78:
        e r155 = r102.f400491f;
        r155.f400576g = r104.getDimension(r107, r155.f400576g);
        goto L127
    L79:
        e r156 = r102.f400491f;
        r156.f400575f = r104.getFloat(r107, r156.f400575f);
        goto L127
    L80:
        e r157 = r102.f400491f;
        r157.f400574e = r104.getFloat(r107, r157.f400574e);
        goto L127
    L81:
        e r158 = r102.f400491f;
        r158.f400573d = r104.getFloat(r107, r158.f400573d);
        goto L127
    L82:
        e r159 = r102.f400491f;
        r159.f400572c = r104.getFloat(r107, r159.f400572c);
        goto L127
    L83:
        e r160 = r102.f400491f;
        r160.f400582m = true;
        r160.f400583n = r104.getDimension(r107, r160.f400583n);
        goto L127
    L84:
        d r161 = r102.f400488c;
        r161.f400567d = r104.getFloat(r107, r161.f400567d);
        goto L127
    L85:
        b r162 = r102.f400490e;
        r162.X = r104.getInt(r107, r162.X);
        goto L127
    L86:
        b r163 = r102.f400490e;
        r163.W = r104.getInt(r107, r163.W);
        goto L127
    L87:
        b r164 = r102.f400490e;
        r164.U = r104.getFloat(r107, r164.U);
        goto L127
    L88:
        b r165 = r102.f400490e;
        r165.V = r104.getFloat(r107, r165.V);
        goto L127
    L89:
        r102.f400486a = r104.getResourceId(r107, r102.f400486a);
        goto L127
    L90:
        b r166 = r102.f400490e;
        r166.f400548y = r104.getFloat(r107, r166.f400548y);
        goto L127
    L91:
        b r167 = r102.f400490e;
        r167.f400532m = l(r104, r107, r167.f400532m);
        goto L127
    L92:
        b r168 = r102.f400490e;
        r168.f400534n = l(r104, r107, r168.f400534n);
        goto L127
    L93:
        b r169 = r102.f400490e;
        r169.I = r104.getDimensionPixelSize(r107, r169.I);
        goto L127
    L94:
        b r170 = r102.f400490e;
        r170.f400544u = l(r104, r107, r170.f400544u);
        goto L127
    L95:
        b r171 = r102.f400490e;
        r171.f400543t = l(r104, r107, r171.f400543t);
        goto L127
    L96:
        b r172 = r102.f400490e;
        r172.L = r104.getDimensionPixelSize(r107, r172.L);
        goto L127
    L97:
        b r173 = r102.f400490e;
        r173.f400530l = l(r104, r107, r173.f400530l);
        goto L127
    L98:
        b r174 = r102.f400490e;
        r174.f400528k = l(r104, r107, r174.f400528k);
        goto L127
    L99:
        b r175 = r102.f400490e;
        r175.H = r104.getDimensionPixelSize(r107, r175.H);
        goto L127
    L100:
        b r176 = r102.f400490e;
        r176.F = r104.getInt(r107, r176.F);
        goto L127
    L101:
        b r177 = r102.f400490e;
        r177.f400526j = l(r104, r107, r177.f400526j);
        goto L127
    L102:
        b r178 = r102.f400490e;
        r178.f400524i = l(r104, r107, r178.f400524i);
        goto L127
    L103:
        b r179 = r102.f400490e;
        r179.G = r104.getDimensionPixelSize(r107, r179.G);
        goto L127
    L104:
        b r180 = r102.f400490e;
        r180.f400512c = r104.getLayoutDimension(r107, r180.f400512c);
        goto L127
    L105:
        d r181 = r102.f400488c;
        r181.f400565b = r104.getInt(r107, r181.f400565b);
        d r182 = r102.f400488c;
        r182.f400565b = f400476h[r182.f400565b];
        goto L127
    L106:
        b r183 = r102.f400490e;
        r183.f400514d = r104.getLayoutDimension(r107, r183.f400514d);
        goto L127
    L107:
        b r184 = r102.f400490e;
        r184.f400547x = r104.getFloat(r107, r184.f400547x);
        goto L127
    L108:
        b r185 = r102.f400490e;
        r185.f400520g = r104.getFloat(r107, r185.f400520g);
        goto L127
    L109:
        b r186 = r102.f400490e;
        r186.f400518f = r104.getDimensionPixelOffset(r107, r186.f400518f);
        goto L127
    L110:
        b r187 = r102.f400490e;
        r187.f400516e = r104.getDimensionPixelOffset(r107, r187.f400516e);
        goto L127
    L111:
        b r188 = r102.f400490e;
        r188.O = r104.getDimensionPixelSize(r107, r188.O);
        goto L127
    L112:
        b r189 = r102.f400490e;
        r189.S = r104.getDimensionPixelSize(r107, r189.S);
        goto L127
    L113:
        b r190 = r102.f400490e;
        r190.P = r104.getDimensionPixelSize(r107, r190.P);
        goto L127
    L114:
        b r191 = r102.f400490e;
        r191.N = r104.getDimensionPixelSize(r107, r191.N);
        goto L127
    L115:
        b r192 = r102.f400490e;
        r192.R = r104.getDimensionPixelSize(r107, r192.R);
        goto L127
    L116:
        b r193 = r102.f400490e;
        r193.Q = r104.getDimensionPixelSize(r107, r193.Q);
        goto L127
    L117:
        b r194 = r102.f400490e;
        r194.f400545v = l(r104, r107, r194.f400545v);
        goto L127
    L118:
        b r195 = r102.f400490e;
        r195.f400546w = l(r104, r107, r195.f400546w);
        goto L127
    L119:
        b r196 = r102.f400490e;
        r196.K = r104.getDimensionPixelSize(r107, r196.K);
        goto L127
    L120:
        b r197 = r102.f400490e;
        r197.E = r104.getDimensionPixelOffset(r107, r197.E);
        goto L127
    L121:
        b r198 = r102.f400490e;
        r198.D = r104.getDimensionPixelOffset(r107, r198.D);
        goto L127
    L122:
        b r199 = r102.f400490e;
        r199.f400549z = r104.getString(r107);
        goto L127
    L123:
        b r200 = r102.f400490e;
        r200.f400536o = l(r104, r107, r200.f400536o);
        goto L127
    L124:
        b r201 = r102.f400490e;
        r201.f400538p = l(r104, r107, r201.f400538p);
        goto L127
    L125:
        b r202 = r102.f400490e;
        r202.f400507J = r104.getDimensionPixelSize(r107, r202.f400507J);
        goto L127
    L126:
        b r203 = r102.f400490e;
        r203.f400540q = l(r104, r107, r203.f400540q);
        goto L127
    L60:
        if (r104.peekValue(r107).type != 3) goto L62;
        c r204 = r102.f400489d;
        r204.f400554d = r104.getString(r107);
        goto L127
    L62:
        c r205 = r102.f400489d;
        r205.f400554d = tla.c.f546670c[r104.getInteger(r107, 0)];
    L127:
        r106 = r106 + 1;
        goto L10
    L14:
        if (23 == r107) goto L18;
        if (24 == r107) goto L18;
        r102.f400489d.f400551a = true;
        r102.f400490e.f400510b = true;
        r102.f400488c.f400564a = true;
        r102.f400491f.f400570a = true;
        goto L18
    L128:
        b r206 = r102.f400490e;
        if (r206.f400529k0 == null) goto L131;
        r206.f400527j0 = null;
        goto L131
    L5:
        r103 = new int[]{R.attr.orientation, R.attr.id, R.attr.visibility, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.alpha, R.attr.transformPivotX, R.attr.transformPivotY, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.translationZ, R.attr.elevation, com.larus.nova.R.attr.animateCircleAngleTo, com.larus.nova.R.attr.animateRelativeTo, com.larus.nova.R.attr.animate_relativeTo, com.larus.nova.R.attr.barrierAllowsGoneWidgets, com.larus.nova.R.attr.barrierDirection, com.larus.nova.R.attr.barrierMargin, com.larus.nova.R.attr.chainUseRtl, com.larus.nova.R.attr.constraint_referenced_ids, com.larus.nova.R.attr.constraint_referenced_tags, com.larus.nova.R.attr.drawPath, com.larus.nova.R.attr.flow_firstHorizontalBias, com.larus.nova.R.attr.flow_firstHorizontalStyle, com.larus.nova.R.attr.flow_firstVerticalBias, com.larus.nova.R.attr.flow_firstVerticalStyle, com.larus.nova.R.attr.flow_horizontalAlign, com.larus.nova.R.attr.flow_horizontalBias, com.larus.nova.R.attr.flow_horizontalGap, com.larus.nova.R.attr.flow_horizontalStyle, com.larus.nova.R.attr.flow_lastHorizontalBias, com.larus.nova.R.attr.flow_lastHorizontalStyle, com.larus.nova.R.attr.flow_lastVerticalBias, com.larus.nova.R.attr.flow_lastVerticalStyle, com.larus.nova.R.attr.flow_maxElementsWrap, com.larus.nova.R.attr.flow_verticalAlign, com.larus.nova.R.attr.flow_verticalBias, com.larus.nova.R.attr.flow_verticalGap, com.larus.nova.R.attr.flow_verticalStyle, com.larus.nova.R.attr.flow_wrapMode, com.larus.nova.R.attr.guidelineUseRtl, com.larus.nova.R.attr.layout_constrainedHeight, com.larus.nova.R.attr.layout_constrainedWidth, com.larus.nova.R.attr.layout_constraintBaseline_creator, com.larus.nova.R.attr.layout_constraintBaseline_toBaselineOf, com.larus.nova.R.attr.layout_constraintBaseline_toBottomOf, com.larus.nova.R.attr.layout_constraintBaseline_toTopOf, com.larus.nova.R.attr.layout_constraintBottom_creator, com.larus.nova.R.attr.layout_constraintBottom_toBottomOf, com.larus.nova.R.attr.layout_constraintBottom_toTopOf, com.larus.nova.R.attr.layout_constraintCircle, com.larus.nova.R.attr.layout_constraintCircleAngle, com.larus.nova.R.attr.layout_constraintCircleRadius, com.larus.nova.R.attr.layout_constraintDimensionRatio, com.larus.nova.R.attr.layout_constraintEnd_toEndOf, com.larus.nova.R.attr.layout_constraintEnd_toStartOf, com.larus.nova.R.attr.layout_constraintGuide_begin, com.larus.nova.R.attr.layout_constraintGuide_end, com.larus.nova.R.attr.layout_constraintGuide_percent, com.larus.nova.R.attr.layout_constraintHeight, com.larus.nova.R.attr.layout_constraintHeight_default, com.larus.nova.R.attr.layout_constraintHeight_max, com.larus.nova.R.attr.layout_constraintHeight_min, com.larus.nova.R.attr.layout_constraintHeight_percent, com.larus.nova.R.attr.layout_constraintHorizontal_bias, com.larus.nova.R.attr.layout_constraintHorizontal_chainStyle, com.larus.nova.R.attr.layout_constraintHorizontal_weight, com.larus.nova.R.attr.layout_constraintLeft_creator, com.larus.nova.R.attr.layout_constraintLeft_toLeftOf, com.larus.nova.R.attr.layout_constraintLeft_toRightOf, com.larus.nova.R.attr.layout_constraintRight_creator, com.larus.nova.R.attr.layout_constraintRight_toLeftOf, com.larus.nova.R.attr.layout_constraintRight_toRightOf, com.larus.nova.R.attr.layout_constraintStart_toEndOf, com.larus.nova.R.attr.layout_constraintStart_toStartOf, com.larus.nova.R.attr.layout_constraintTag, com.larus.nova.R.attr.layout_constraintTop_creator, com.larus.nova.R.attr.layout_constraintTop_toBottomOf, com.larus.nova.R.attr.layout_constraintTop_toTopOf, com.larus.nova.R.attr.layout_constraintVertical_bias, com.larus.nova.R.attr.layout_constraintVertical_chainStyle, com.larus.nova.R.attr.layout_constraintVertical_weight, com.larus.nova.R.attr.layout_constraintWidth, com.larus.nova.R.attr.layout_constraintWidth_default, com.larus.nova.R.attr.layout_constraintWidth_max, com.larus.nova.R.attr.layout_constraintWidth_min, com.larus.nova.R.attr.layout_constraintWidth_percent, com.larus.nova.R.attr.layout_editor_absoluteX, com.larus.nova.R.attr.layout_editor_absoluteY, com.larus.nova.R.attr.layout_goneMarginBaseline, com.larus.nova.R.attr.layout_goneMarginBottom, com.larus.nova.R.attr.layout_goneMarginEnd, com.larus.nova.R.attr.layout_goneMarginLeft, com.larus.nova.R.attr.layout_goneMarginRight, com.larus.nova.R.attr.layout_goneMarginStart, com.larus.nova.R.attr.layout_goneMarginTop, com.larus.nova.R.attr.layout_marginBaseline, com.larus.nova.R.attr.layout_wrapBehaviorInParent, com.larus.nova.R.attr.motionProgress, com.larus.nova.R.attr.motionStagger, com.larus.nova.R.attr.pathMotionArc, com.larus.nova.R.attr.pivotAnchor, com.larus.nova.R.attr.polarRelativeTo, com.larus.nova.R.attr.quantizeMotionInterpolator, com.larus.nova.R.attr.quantizeMotionPhase, com.larus.nova.R.attr.quantizeMotionSteps, com.larus.nova.R.attr.transformPivotTarget, com.larus.nova.R.attr.transitionEasing, com.larus.nova.R.attr.transitionPathRotate, com.larus.nova.R.attr.visibilityMode};
        goto L6
    }

    public static int l(TypedArray r100, int r101, int r102) {
        int r103 = r100.getResourceId(r101, r102);
        if (r103 == (-1)) goto L5;
        return r103;
    L5:
        return r100.getInt(r101, -1);
    }

    public static void m(Object r100, TypedArray r101, int r110, int r111) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r102 = r101.peekValue(r110).type;
        boolean r103 = true;
        int r104 = 0;
        if (r102 == 3) goto L37;
        if (r102 == 5) goto L15;
        int r105 = r101.getInt(r110, 0);
        if (r105 != (-4)) goto L10;
        r104 = -2;
    L19:
        if ((r100 instanceof ConstraintLayout.LayoutParams) == false) goto L25;
        ConstraintLayout.LayoutParams r106 = (ConstraintLayout.LayoutParams) r100;
        if (r111 != 0) goto L23;
        ((ViewGroup.MarginLayoutParams) r106).width = r104;
        r106.W = r103;
        return;
    L23:
        ((ViewGroup.MarginLayoutParams) r106).height = r104;
        r106.X = r103;
        return;
    L25:
        if ((r100 instanceof b) == false) goto L31;
        b r107 = (b) r100;
        if (r111 != 0) goto L29;
        r107.f400512c = r104;
        r107.f400533m0 = r103;
        return;
    L29:
        r107.f400514d = r104;
        r107.f400535n0 = r103;
        return;
    L31:
        if ((r100 instanceof C4670a.C4671a) == false) goto L111;
        C4670a.C4671a r108 = (C4670a.C4671a) r100;
        if (r111 != 0) goto L35;
        r108.b(23, r104);
        r108.d(80, r103);
        return;
    L35:
        r108.b(21, r104);
        r108.d(81, r103);
        return;
    L111:
        return;
    L10:
        if (r105 == (-3)) goto L17;
        if (r105 == (-2)) goto L16;
        if (r105 != (-1)) goto L17;
    L16:
        r104 = r105;
    L17:
        r103 = false;
        goto L19
    L15:
        r105 = r101.getDimensionPixelSize(r110, 0);
        goto L16
    L37:
        String r109 = r101.getString(r110);
        if (r109 == null) goto L121;
        int r112 = r109.indexOf(61);
        int r113 = r109.length();
        if (r112 > 0) goto L43;
        return;
    L43:
        if (r112 >= (r113 - 1)) goto L114;
        String r114 = r109.substring(0, r112);
        String r115 = r109.substring(r112 + 1);
        if (r115.length() <= 0) goto L115;
        String r116 = r114.trim();
        String r117 = r115.trim();
        if (MapBundleKey.OfflineMapKey.OFFLINE_RATION.equalsIgnoreCase(r116) == false) goto L105;
        if ((r100 instanceof ConstraintLayout.LayoutParams) == false) goto L56;
        ConstraintLayout.LayoutParams r118 = (ConstraintLayout.LayoutParams) r100;
        if (r111 != 0) goto L53;
        ((ViewGroup.MarginLayoutParams) r118).width = 0;
    L54:
        n(r118, r117);
        return;
    L53:
        ((ViewGroup.MarginLayoutParams) r118).height = 0;
        goto L54
    L56:
        if ((r100 instanceof b) == false) goto L59;
        ((b) r100).f400549z = r117;
        return;
    L59:
        if ((r100 instanceof C4670a.C4671a) == false) goto L118;
        ((C4670a.C4671a) r100).c(5, r117);
        return;
    L118:
        return;
    L105:
        if ("weight".equalsIgnoreCase(r116) == false) goto L83;
        float r119 = CastFloatProtector.parseFloat(r117);     // Catch: NumberFormatException -> L103
        if ((r100 instanceof ConstraintLayout.LayoutParams) == false) goto L70;
        ConstraintLayout.LayoutParams r120 = (ConstraintLayout.LayoutParams) r100;     // Catch: NumberFormatException -> L103
        if (r111 != 0) goto L68;
        ((ViewGroup.MarginLayoutParams) r120).width = 0;     // Catch: NumberFormatException -> L103
        r120.H = r119;     // Catch: NumberFormatException -> L103
    L104:
        return;
    L68:
        ((ViewGroup.MarginLayoutParams) r120).height = 0;     // Catch: NumberFormatException -> L103
        r120.I = r119;     // Catch: NumberFormatException -> L103
        goto L104
    L70:
        if ((r100 instanceof b) == false) goto L76;
        b r121 = (b) r100;     // Catch: NumberFormatException -> L103
        if (r111 != 0) goto L74;
        r121.f400512c = 0;     // Catch: NumberFormatException -> L103
        r121.V = r119;     // Catch: NumberFormatException -> L103
        goto L104
    L74:
        r121.f400514d = 0;     // Catch: NumberFormatException -> L103
        r121.U = r119;     // Catch: NumberFormatException -> L103
        goto L104
    L76:
        if ((r100 instanceof C4670a.C4671a) == false) goto L104;
        C4670a.C4671a r122 = (C4670a.C4671a) r100;     // Catch: NumberFormatException -> L103
        if (r111 != 0) goto L80;
        r122.b(23, 0);     // Catch: NumberFormatException -> L103
        r122.a(39, r119);     // Catch: NumberFormatException -> L103
        goto L104
    L80:
        r122.b(21, 0);     // Catch: NumberFormatException -> L103
        r122.a(40, r119);     // Catch: NumberFormatException -> L103
        goto L104
    L83:
        if ("parent".equalsIgnoreCase(r116) == false) goto L120;
        float r123 = Math.max(0.0f, Math.min(1.0f, CastFloatProtector.parseFloat(r117)));     // Catch: NumberFormatException -> L103
        if ((r100 instanceof ConstraintLayout.LayoutParams) == false) goto L91;
        ConstraintLayout.LayoutParams r124 = (ConstraintLayout.LayoutParams) r100;     // Catch: NumberFormatException -> L103
        if (r111 != 0) goto L89;
        ((ViewGroup.MarginLayoutParams) r124).width = 0;     // Catch: NumberFormatException -> L103
        r124.R = r123;     // Catch: NumberFormatException -> L103
        r124.L = 2;     // Catch: NumberFormatException -> L103
        goto L104
    L89:
        ((ViewGroup.MarginLayoutParams) r124).height = 0;     // Catch: NumberFormatException -> L103
        r124.S = r123;     // Catch: NumberFormatException -> L103
        r124.M = 2;     // Catch: NumberFormatException -> L103
        goto L104
    L91:
        if ((r100 instanceof b) == false) goto L97;
        b r125 = (b) r100;     // Catch: NumberFormatException -> L103
        if (r111 != 0) goto L95;
        r125.f400512c = 0;     // Catch: NumberFormatException -> L103
        r125.f400517e0 = r123;     // Catch: NumberFormatException -> L103
        r125.Y = 2;     // Catch: NumberFormatException -> L103
        goto L104
    L95:
        r125.f400514d = 0;     // Catch: NumberFormatException -> L103
        r125.f400519f0 = r123;     // Catch: NumberFormatException -> L103
        r125.Z = 2;     // Catch: NumberFormatException -> L103
        goto L104
    L97:
        if ((r100 instanceof C4670a.C4671a) == false) goto L104;
        C4670a.C4671a r126 = (C4670a.C4671a) r100;     // Catch: NumberFormatException -> L103
        if (r111 != 0) goto L101;
        r126.b(23, 0);     // Catch: NumberFormatException -> L103
        r126.b(54, 2);     // Catch: NumberFormatException -> L103
        goto L104
    L101:
        r126.b(21, 0);     // Catch: NumberFormatException -> L103
        r126.b(55, 2);     // Catch: NumberFormatException -> L103
        goto L104
    L120:
        return;
    L122:
        return;
    L115:
        return;
    L114:
        return;
    }
}
