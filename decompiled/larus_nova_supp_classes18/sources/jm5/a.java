package jm5;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.core.content.ContextCompat;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public int A;
    public int B;
    public float[] C;
    public boolean D;
    public final RectF E;
    public int F;
    public int G;
    public int H;
    public final WeakReference<View> I;
    public boolean J;
    public final Path K;
    public boolean L;
    public int M;
    public float N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public int s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;
    public int x;
    public Paint y;
    public final Paint z;

    /* JADX INFO: renamed from: jm5.a$a, reason: collision with other inner class name */
    public class C0252a extends ViewOutlineProvider {
        public final /* synthetic */ a a;

        public C0252a(a r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r13, Outline r14) {
            int r0 = r13.getWidth();
            int r1 = r13.getHeight();
            if (r0 == 0) goto L35;
            if (r1 == 0) goto L37;
            int r2 = this.a.a();
            a r3 = this.a;
            if (r3.D == false) goto L24;
            int r15 = r3.B;
            if (r15 != 4) goto L13;
            int r6 = 0 - r2;
            int r8 = r0;
            int r9 = r1;
        L11:
            int r7 = 0;
        L22:
            r14.setRoundRect(r6, r7, r8, r9, r2);
            return;
        L13:
            if (r15 != 1) goto L16;
            r7 = 0 - r2;
            r8 = r0;
            r9 = r1;
            r6 = 0;
            goto L22
        L16:
            if (r15 != 2) goto L19;
            r0 = r0 + r2;
        L21:
            r8 = r0;
            r9 = r1;
            r6 = 0;
            goto L11
        L19:
            if (r15 != 3) goto L21;
            r1 = r1 + r2;
            goto L21
        L24:
            int r4 = r3.R;
            int r5 = Math.max(r4 + 1, r1 - r3.S);
            a r10 = this.a;
            int r11 = r10.P;
            int r12 = r0 - r10.Q;
            if (r10.J == false) goto L27;
            r11 = r11 + r13.getPaddingLeft();
            r4 = r4 + r13.getPaddingTop();
            r12 = Math.max(r11 + 1, r12 - r13.getPaddingRight());
            r5 = Math.max(r4 + 1, r5 - r13.getPaddingBottom());
        L27:
            int r16 = r12;
            int r17 = r5;
            int r18 = r4;
            int r19 = r11;
            a r110 = this.a;
            float r20 = r110.N;
            if (r110.M != 0) goto L30;
            r20 = 1.0f;
        L30:
            r14.setAlpha(r20);
            if (r2 > 0) goto L33;
            r14.setRect(r19, r18, r16, r17);
            return;
        L33:
            r14.setRoundRect(r19, r18, r16, r17, r2);
            return;
        L37:
            return;
        }
    }

    public final int a() {
        View r0 = this.I.get();
        if (r0 == null) goto L5;
        int r1 = this.A;
        if (r1 != (-1)) goto L10;
        return r0.getHeight() / 2;
    L10:
        if (r1 == (-2)) goto L12;
        return r1;
    L12:
        return r0.getWidth() / 2;
    L5:
        return this.A;
    }

    public a(Context r10, AttributeSet r11, int r12, View r13) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.i = 255;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.n = 255;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.s = 255;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.x = 255;
        this.B = 0;
        this.F = 0;
        this.G = 1;
        this.H = 0;
        this.J = false;
        this.K = new Path();
        this.L = true;
        this.M = 0;
        this.O = -16777216;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.I = new WeakReference(r13);
        int r14 = ContextCompat.getColor(r10, 2131103453);
        this.h = r14;
        this.m = r14;
        new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        Paint r15 = new Paint();
        this.z = r15;
        r15.setAntiAlias(true);
        this.N = 0.17f;
        this.E = new RectF();
        if (r11 != null) goto L6;
        if (r12 != 0) goto L6;
        int r4 = 0;
        int r6 = 0;
    L111:
        int r5 = this.B;
        float r8 = this.N;
        b(r4, r5, r6, this.O, r8);
        return;
    L6:
        TypedArray r16 = r10.obtainStyledAttributes(r11, new int[]{R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, 2130969028, 2130969032, 2130969039, 2130969040, 2130969041, 2130969042, 2130969505, 2130970210, 2130970222, 2130970223, 2130970224, 2130970225, 2130970226, 2130970227, 2130970228, 2130970229, 2130970230, 2130970231, 2130970232, 2130970233, 2130970234, 2130970235, 2130970236, 2130970237, 2130970238, 2130970239, 2130970240, 2130970241, 2130970242, 2130970243, 2130970244, 2130970245, 2130970246, 2130970247, 2130970248, 2130970249, 2130972495, 2130972496, 2130972497, 2130972498, 2130973410, 2130973413, 2130973414, 2130973415, 2130973416, 2130973417, 2130973712, 2130973774, 2130973775, 2130973776, 2130973777, 2130974025, 2130974029, 2130974053, 2130974614, 2130974615, 2130974616, 2130974617, 2130975010, 2130975014, 2130975015, 2130975016, 2130975017, 2130975018, 2130975019}, r12, 0);
        int r17 = r16.getIndexCount();
        int r18 = 0;
        int r19 = 0;
        int r2 = 0;
    L7:
        if (r18 >= r17) goto L110;
        int r3 = r16.getIndex(r18);
        if (r3 != 0) goto L11;
        this.a = r16.getDimensionPixelSize(r3, this.a);
    L109:
        r18 = r18 + 1;
        goto L7
    L11:
        if (r3 != 1) goto L14;
        this.b = r16.getDimensionPixelSize(r3, this.b);
        goto L109
    L14:
        if (r3 != 2) goto L17;
        this.c = r16.getDimensionPixelSize(r3, this.c);
        goto L109
    L17:
        if (r3 != 3) goto L20;
        this.d = r16.getDimensionPixelSize(r3, this.d);
        goto L109
    L20:
        if (r3 != 58) goto L23;
        this.h = r16.getColor(r3, this.h);
        goto L109
    L23:
        if (r3 != 59) goto L26;
        this.e = r16.getDimensionPixelSize(r3, this.e);
        goto L109
    L26:
        if (r3 != 60) goto L29;
        this.f = r16.getDimensionPixelSize(r3, this.f);
        goto L109
    L29:
        if (r3 != 61) goto L32;
        this.g = r16.getDimensionPixelSize(r3, this.g);
        goto L109
    L32:
        if (r3 != 6) goto L35;
        this.m = r16.getColor(r3, this.m);
        goto L109
    L35:
        if (r3 != 7) goto L38;
        this.j = r16.getDimensionPixelSize(r3, this.j);
        goto L109
    L38:
        if (r3 != 8) goto L41;
        this.k = r16.getDimensionPixelSize(r3, this.k);
        goto L109
    L41:
        if (r3 != 9) goto L44;
        this.l = r16.getDimensionPixelSize(r3, this.l);
        goto L109
    L44:
        if (r3 != 40) goto L47;
        this.r = r16.getColor(r3, this.r);
        goto L109
    L47:
        if (r3 != 43) goto L50;
        this.o = r16.getDimensionPixelSize(r3, this.o);
        goto L109
    L50:
        if (r3 != 42) goto L53;
        this.p = r16.getDimensionPixelSize(r3, this.p);
        goto L109
    L53:
        if (r3 != 41) goto L56;
        this.q = r16.getDimensionPixelSize(r3, this.q);
        goto L109
    L56:
        if (r3 != 51) goto L59;
        this.w = r16.getColor(r3, this.w);
        goto L109
    L59:
        if (r3 != 54) goto L62;
        this.t = r16.getDimensionPixelSize(r3, this.t);
        goto L109
    L62:
        if (r3 != 53) goto L65;
        this.u = r16.getDimensionPixelSize(r3, this.u);
        goto L109
    L65:
        if (r3 != 52) goto L68;
        this.v = r16.getDimensionPixelSize(r3, this.v);
        goto L109
    L68:
        if (r3 != 4) goto L71;
        this.F = r16.getColor(r3, this.F);
        goto L109
    L71:
        if (r3 != 5) goto L74;
        this.G = r16.getDimensionPixelSize(r3, this.G);
        goto L109
    L74:
        if (r3 != 50) goto L77;
        r19 = r16.getDimensionPixelSize(r3, 0);
        goto L109
    L77:
        if (r3 != 44) goto L80;
        this.H = r16.getColor(r3, this.H);
        goto L109
    L80:
        if (r3 != 11) goto L83;
        this.B = r16.getInt(r3, this.B);
        goto L109
    L83:
        if (r3 != 57) goto L86;
        this.L = r16.getBoolean(r3, this.L);
        goto L109
    L86:
        if (r3 != 56) goto L89;
        r2 = r16.getDimensionPixelSize(r3, r2);
        goto L109
    L89:
        if (r3 != 55) goto L92;
        this.N = r16.getFloat(r3, this.N);
        goto L109
    L92:
        if (r3 != 62) goto L95;
        r16.getBoolean(r3, false);
        goto L109
    L95:
        if (r3 != 47) goto L98;
        this.P = r16.getDimensionPixelSize(r3, 0);
        goto L109
    L98:
        if (r3 != 48) goto L101;
        this.Q = r16.getDimensionPixelSize(r3, 0);
        goto L109
    L101:
        if (r3 != 49) goto L104;
        this.R = r16.getDimensionPixelSize(r3, 0);
        goto L109
    L104:
        if (r3 != 46) goto L107;
        this.S = r16.getDimensionPixelSize(r3, 0);
        goto L109
    L107:
        if (r3 != 45) goto L109;
        this.J = r16.getBoolean(r3, false);
        goto L109
    L110:
        r16.recycle();
        r4 = r19;
        r6 = r2;
        goto L111
    }

    public final void b(int r6, int r7, int r8, int r9, float r10) {
        View r0 = this.I.get();
        if (r0 != null) goto L5;
        return;
    L5:
        this.A = r6;
        this.B = r7;
        boolean r1 = false;
        if (r6 == (-1)) goto L9;
        if (r6 == (-2)) goto L9;
        if (r6 > 0) goto L9;
    L11:
        boolean r11 = false;
    L12:
        this.D = r11;
        this.M = r8;
        this.N = r10;
        this.O = r9;
        if (r8 == 0) goto L17;
        if (r11 == true) goto L17;
        r0.setElevation(r8);
    L18:
        int r12 = this.O;
        if (Build.VERSION.SDK_INT < 28) goto L24;
        View r13 = this.I.get();
        if (r13 == null) goto L24;
        r13.setOutlineAmbientShadowColor(r12);
        r13.setOutlineSpotShadowColor(r12);
    L24:
        r0.setOutlineProvider(new C0252a(this));
        int r14 = this.A;
        if (r14 == (-2)) goto L28;
        if (r14 == (-1)) goto L28;
        if (r14 > 0) goto L28;
    L29:
        r0.setClipToOutline(r1);
        r0.invalidate();
        return;
    L28:
        r1 = true;
    L17:
        r0.setElevation(0.0f);
    L9:
        if (r7 == 0) goto L11;
        r11 = true;
        goto L12
    }
}
