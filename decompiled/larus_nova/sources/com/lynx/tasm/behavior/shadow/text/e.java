package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import java.text.Bidi;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import y6a.l;
import z6a.j;
import z6a.k;
import z6a.m;
import z6a.n;
import z6a.p;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Layout f382287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f382288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f382289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f382290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f382291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f382292f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f382293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f382294b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f382295c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f382296d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f382297e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public TextPaint f382298f;

        public a() {
        }
    }

    static {
        new BoringLayout.Metrics();
    }

    public final float d() {
        float r100 = this.f382292f;
        if (r100 < 0.0f) goto L5;
        return r100;
    L5:
        this.f382292f = -1.0f;
        int r101 = 0;
    L7:
        if (r101 >= h()) goto L14;
        float r102 = this.f382292f;
        if (this.f382288b.f382299a.f382309b.d(false) != Layout.Alignment.ALIGN_NORMAL) goto L11;
        float r103 = this.f382287a.getLineMax(r101);
    L12:
        this.f382292f = Math.max(r102, r103);
        r101 = r101 + 1;
        goto L7
    L11:
        r103 = this.f382287a.getLineMax(r101) - this.f382287a.getParagraphLeft(r101);
        goto L12
    L14:
        if (this.f382288b.f382299a.f382308a.length() != 0) goto L16;
    L15:
        boolean r104 = false;
    L35:
        if (r104 == false) goto L38;
        this.f382292f = (float) (((double) this.f382292f) + (((double) (-this.f382287a.getLineAscent(0))) * 0.2d));
    L38:
        return this.f382292f;
    L16:
        r104 = true;
        if (this.f382288b.f382299a.f382309b.f382252h == 2) goto L35;
        int r105 = this.f382287a.getLineEnd(h() - 1);
        if (Build.VERSION.SDK_INT < 28) goto L28;
        z6a.g[] r106 = (z6a.g[]) ((SpannableStringBuilder) this.f382288b.f382299a.f382308a).getSpans(0, r105, z6a.g.class);
        int r107 = 0;
    L23:
        if (r107 >= r106.length) goto L15;
        if (r106[r107].f570568a == 2) goto L35;
        r107 = r107 + 1;
        goto L23
    L28:
        StyleSpan[] r108 = (StyleSpan[]) ((SpannableStringBuilder) this.f382288b.f382299a.f382308a).getSpans(0, r105, StyleSpan.class);
        int r109 = 0;
    L30:
        if (r109 >= r108.length) goto L15;
        if (r108[r109].getStyle() == 2) goto L35;
        r109 = r109 + 1;
        goto L30
    }

    public final int g() {
        if (this.f382288b.f382300b != MeasureMode.EXACTLY) goto L9;
        float r100 = this.f382287a.getWidth();
        float r101 = this.f382288b.f382302d;
        if (r100 > r101) goto L9;
        double r102 = Math.ceil(r101);
    L8:
        return (int) r102;
    L9:
        r102 = Math.ceil(d());
        goto L8
    }

    public final int h() {
        int r100 = this.f382288b.f382299a.f382309b.f382245a;
        if (r100 == (-1)) goto L9;
        if (r100 > this.f382287a.getLineCount()) goto L9;
        return r100;
    L9:
        return this.f382287a.getLineCount();
    }

    public final boolean j() {
        if (l.a(this.f382288b.f382299a.f382309b.f382255k) == true) goto L15;
        f r100 = this.f382288b;
        if (r100.f382307i == false) goto L15;
        if (r100.f382306h == false) goto L15;
        com.lynx.tasm.behavior.shadow.text.a r101 = r100.f382299a.f382309b;
        if (r101.f382253i != 1) goto L15;
        if (r101.f382261q == true) goto L15;
        if (r101.f382262r == true) goto L15;
        return true;
    L15:
        return false;
    }

    public final boolean k() {
        if (this.f382288b.f382301c == MeasureMode.UNDEFINED) goto L7;
        if (this.f382287a.getHeight() <= this.f382288b.f382303e) goto L7;
    L12:
        return true;
    L7:
        if (d() > this.f382288b.f382302d) goto L12;
        if (l() == true) goto L12;
        return false;
    }

    public final boolean l() {
        if (this.f382287a.getLineCount() > h()) goto L11;
        Layout r100 = this.f382287a;
        if (r100.getEllipsisCount(r100.getLineCount() - 1) > 0) goto L12;
        Layout r101 = this.f382287a;
        if (r101.getLineEnd(r101.getLineCount() - 1) < this.f382287a.getText().length()) goto L13;
        return false;
    L13:
        return true;
    L12:
        return true;
    L11:
        return true;
    }

    public final int i() {
        if (j() == true) goto L5;
        com.lynx.tasm.behavior.shadow.text.a r100 = this.f382288b.f382299a.f382309b;
        int r101 = r100.f382245a;
        if (r100.f382253i == 1) goto L11;
        if (r101 == 1) goto L11;
        boolean r102 = false;
    L12:
        if (r102 == false) goto L15;
        r101 = 1;
    L15:
        if (r101 == (-1)) goto L22;
        if (r101 > this.f382287a.getLineCount()) goto L22;
        return this.f382287a.getLineBottom(r101 - 1);
    L22:
        return this.f382287a.getHeight();
    L11:
        r102 = true;
        goto L12
    L5:
        return (int) Math.ceil(this.f382288b.f382299a.f382309b.f382255k);
    }

    public final void a(a r110) {
        com.lynx.tasm.behavior.shadow.text.a r100 = this.f382288b.f382299a.f382309b;
        int r101 = r100.f382248d;
        if (r101 == 0) goto L6;
        if (r101 == 2) goto L6;
    L14:
        Layout.Alignment r102 = r100.d(false);
    L15:
        SpannableStringBuilder r103 = (SpannableStringBuilder) r110.f382293a;
        f r104 = this.f382288b;
        if (r104.f382307i == false) goto L40;
        com.lynx.tasm.behavior.shadow.text.a r105 = r104.f382299a.f382309b;
        if (r105.f382262r == true) goto L40;
        if (r105.f382261q == true) goto L40;
        if (r105.f382249e == 2) goto L40;
        if (r105.H == 1) goto L40;
        if (r105.f382253i == 1) goto L34;
        if (r105.f382245a != 1) goto L32;
        if (r105.f382254j == 1) goto L34;
    L32:
        if (r104.f382300b != MeasureMode.UNDEFINED) goto L40;
    L34:
        if (r103.length() != 0) goto L36;
    L39:
        boolean r106 = true;
    L42:
        if (r106 == false) goto L50;
        BoringLayout.Metrics r107 = BoringLayout.isBoring(r110.f382293a, r110.f382298f);
        if (r107 != null) goto L46;
    L51:
        if (r107 != null) goto L105;
        int r108 = Build.VERSION.SDK_INT;
        if (r108 < 23) goto L100;
        StaticLayout.Builder r109 = e(r110.f382293a, r102, r110.f382298f, r110.f382295c);
        if (r110.f382296d != 0) goto L57;
        r109.setEllipsize(TextUtils.TruncateAt.END).setEllipsizedWidth((int) Math.floor(r110.f382295c)).setMaxLines(r110.f382297e);
    L57:
        int r111 = r110.f382297e;
        if (r111 <= 0) goto L61;
        r109.setMaxLines(r111);
    L61:
        if (r110.f382294b == false) goto L63;
        r109.setMaxLines(1);
    L63:
        com.lynx.tasm.behavior.shadow.text.a r112 = this.f382288b.f382299a.f382309b;
        if (r112.f382248d != 5) goto L71;
        if (r112.f382262r == true) goto L71;
        if (r108 < 26) goto L71;
        r109.setJustificationMode(1);
    L71:
        if (this.f382288b.f382299a.f382309b.C == false) goto L73;
        r109.setHyphenationFrequency(2);
        r109.setBreakStrategy(1);
    L73:
        StaticLayout r113 = r109.build();
        this.f382287a = r113;
        if (r110.f382296d != 0) goto L105;
        int r114 = r113.getLineCount() - 1;
        if (r108 > 28) goto L95;
        com.lynx.tasm.behavior.shadow.text.a r115 = this.f382288b.f382299a.f382309b;
        if (r115.f382261q == true) goto L82;
        if (r115.f382262r == false) goto L95;
    L82:
        if (this.f382287a.getEllipsisCount(r114) <= 0) goto L95;
        int r116 = (this.f382287a.getLineStart(r114) + this.f382287a.getEllipsisStart(r114)) - 1;
        SpannableStringBuilder r117 = (SpannableStringBuilder) r110.f382293a;
        if (r116 >= r117.length()) goto L91;
        int r118 = r116 + 1;
        if (((com.lynx.tasm.behavior.ui.text.a[]) r117.getSpans(r116, r118, com.lynx.tasm.behavior.ui.text.a.class)).length <= 0) goto L89;
    L92:
        boolean r119 = true;
    L93:
        if (r119 == false) goto L95;
        CharSequence r120 = f((SpannableStringBuilder) r110.f382293a, r116 + 1);
        r110.f382293a = r120;
        this.f382287a = e(r120, r102, r110.f382298f, r110.f382295c).build();
        goto L95
    L89:
        if (((n[]) r117.getSpans(r116, r118, n.class)).length > 0) goto L92;
    L91:
        r119 = false;
    L95:
        Layout r121 = this.f382287a;
        if (r121.getLineWidth(r121.getLineCount() - 1) <= r110.f382295c) goto L105;
        Layout r122 = this.f382287a;
        if (r122.getEllipsisCount(r122.getLineCount() - 1) <= 0) goto L105;
        StaticLayout.Builder r123 = e(r110.f382293a, r102, r110.f382298f, r110.f382295c);
        r123.setMaxLines(r110.f382297e);
        r123.setEllipsize(TextUtils.TruncateAt.END);
        double r124 = Math.floor(r110.f382295c) * 2.0d;
        Layout r125 = this.f382287a;
        r123.setEllipsizedWidth((int) (r124 - ((double) r125.getLineWidth(r125.getLineCount() - 1))));
        this.f382287a = r123.build();
        goto L105
    L100:
        CharSequence r126 = r110.f382293a;
        int r127 = r126.length();
        TextPaint r128 = r110.f382298f;
        int r129 = (int) Math.floor(r110.f382295c);
        com.lynx.tasm.behavior.shadow.text.a r130 = this.f382288b.f382299a.f382309b;
        float r131 = r130.f382257m;
        boolean r132 = r130.f382264t;
        if (r110.f382296d != 0) goto L103;
        TextUtils.TruncateAt r133 = TextUtils.TruncateAt.END;
    L104:
        this.f382287a = p.a(r126, r127, r128, r129, r102, 1.0f, r131, r132, r133, r110.f382297e, r130.b());
        goto L105
    L103:
        r133 = null;
    L105:
        this.f382292f = -1.0f;
        return;
    L46:
        if (r110.f382296d != 0) goto L48;
        CharSequence r134 = r110.f382293a;
        TextPaint r135 = r110.f382298f;
        int r136 = (int) Math.floor(r110.f382295c);
        com.lynx.tasm.behavior.shadow.text.a r137 = this.f382288b.f382299a.f382309b;
        BoringLayout r138 = BoringLayout.make(r134, r135, r136, r102, 1.0f, r137.f382257m, r107, r137.f382264t, TextUtils.TruncateAt.END, (int) Math.floor(r110.f382295c));
    L49:
        this.f382287a = r138;
        goto L51
    L48:
        CharSequence r139 = r110.f382293a;
        TextPaint r140 = r110.f382298f;
        int r141 = (int) Math.floor(r110.f382295c);
        com.lynx.tasm.behavior.shadow.text.a r142 = this.f382288b.f382299a.f382309b;
        r138 = BoringLayout.make(r139, r140, r141, r102, 1.0f, r142.f382257m, r107, r142.f382264t);
        goto L49
    L50:
        r107 = null;
        goto L51
    L36:
        if (((z6a.d[]) r103.getSpans(0, r103.length(), z6a.d.class)).length != 0) goto L40;
        if (((k[]) r103.getSpans(0, r103.length(), k.class)).length == 0) goto L39;
    L40:
        r106 = false;
    L6:
        if (r100.f382249e != 0) goto L14;
        int r143 = r100.H;
        if (r143 == 0) goto L13;
        if (r143 != 1) goto L11;
        boolean r144 = true;
    L12:
        r102 = r100.d(r144);
        goto L15
    L11:
        r144 = false;
        goto L12
    L13:
        r102 = this.f382288b.f382299a.f382309b.d(!new Bidi(r110.f382293a.toString(), -2).baseIsLeftToRight());
        goto L15
    }

    public final float c(float r100) {
        if (this.f382287a.getLineLeft(0) != 0.0f) goto L6;
        return 0.0f;
    L6:
        if (this.f382287a.getAlignment() != Layout.Alignment.ALIGN_CENTER) goto L9;
        return (-(this.f382287a.getWidth() - r100)) / 2.0f;
    L9:
        if (this.f382287a.getAlignment() == Layout.Alignment.ALIGN_OPPOSITE) goto L15;
        if (this.f382287a.getParagraphDirection(0) == (-1)) goto L15;
        if (this.f382287a.getParagraphAlignment(0) == Layout.Alignment.ALIGN_OPPOSITE) goto L15;
        return 0.0f;
    L15:
        return -(this.f382287a.getWidth() - r100);
    }

    public final void m(LynxContext r110) {
        f.a r100 = this.f382288b.f382299a;
        if (r100.f382308a == null) goto L285;
        a r101 = new a();
        com.lynx.tasm.behavior.shadow.text.a r102 = r100.f382309b;
        DecimalFormat r103 = b.f382275a;
        String r104 = r102.f382265u;
        float[] r105 = null;
        if (TextUtils.isEmpty(r104) == true) goto L7;
        Typeface r106 = g.d(r110, r104, r102.e());
    L8:
        r101.f382298f = b.l(this.f382288b.f382299a.f382309b, r106);
        f.a r107 = this.f382288b.f382299a;
        com.lynx.tasm.behavior.shadow.text.a r108 = r107.f382309b;
        int r109 = r108.f382253i;
        boolean r111 = false;
        if (r109 != 1) goto L11;
    L14:
        boolean r112 = true;
    L15:
        r101.f382294b = r112;
        if (r108.f382254j != 1) goto L18;
        boolean r113 = true;
    L19:
        if (r109 != 1) goto L21;
        int r114 = 1;
    L23:
        if (r113 == false) goto L27;
        if (r114 == (-1)) goto L26;
        int r115 = 0;
    L28:
        r101.f382296d = r115;
        CharSequence r116 = r107.f382308a;
        int r117 = r108.f382246b;
        int r118 = r116.length();
        if (r117 == (-1)) goto L32;
        if (r117 >= r118) goto L32;
        r116 = f((SpannableStringBuilder) r116, r117);
    L32:
        r101.f382293a = r116;
        f r119 = this.f382288b;
        MeasureMode r120 = r119.f382300b;
        if (r120 != MeasureMode.EXACTLY) goto L35;
    L38:
        float r121 = r119.f382302d;
    L39:
        r101.f382295c = r121;
        if (r101.f382294b == false) goto L42;
        int r122 = 1;
    L43:
        r101.f382297e = r122;
        if (r119.f382299a.f382309b.f382253i != 1) goto L52;
        String r123 = r116.toString();
        SpannableStringBuilder r124 = new SpannableStringBuilder(r101.f382293a);
        int r125 = r123.indexOf(10);
        if (r125 <= 0) goto L49;
        r124.delete(r125, r124.length());
    L49:
        r101.f382293a = r124;
        if (this.f382288b.f382299a.f382309b.f382254j == 1) goto L52;
        r101.f382295c = 32767.0f;
    L52:
        a(r101);
        f r126 = this.f382288b;
        f.a r127 = r126.f382299a;
        com.lynx.tasm.behavior.shadow.text.a r128 = r127.f382309b;
        if (r128.f382266v == false) goto L201;
        if (r126.f382300b == MeasureMode.UNDEFINED) goto L201;
        if (Build.VERSION.SDK_INT < 24) goto L59;
    L61:
        int r129 = (int) r128.f382258n;
        CharSequence r130 = r127.f382308a;
        AbsoluteSizeSpan[] r131 = (AbsoluteSizeSpan[]) ((Spanned) r130).getSpans(0, r130.length(), AbsoluteSizeSpan.class);
        int r132 = 0;
    L63:
        if (r132 >= r131.length) goto L68;
        if (r129 >= r131[r132].getSize()) goto L67;
        r129 = r131[r132].getSize();
    L67:
        r132 = r132 + 1;
        goto L63
    L68:
        int r133 = h();
        List<com.lynx.tasm.behavior.shadow.text.a.C4563a> r134 = this.f382288b.f382299a.f382309b.A;
        if (r134 != null) goto L71;
    L73:
        boolean r135 = false;
    L74:
        if (r133 <= 0) goto L90;
        List<com.lynx.tasm.behavior.shadow.text.a.C4563a> r136 = this.f382288b.f382299a.f382309b.A;
        if (r136 == null) goto L90;
        if (r136.isEmpty() == true) goto L90;
        int r137 = 0;
    L83:
        if (r137 >= r136.size()) goto L90;
        com.lynx.tasm.behavior.shadow.text.a.C4563a r138 = (com.lynx.tasm.behavior.shadow.text.a.C4563a) ListProtector.get(r136, r137);
        if (r133 < r138.f382271a) goto L89;
        if (r133 > r138.f382272b) goto L89;
    L91:
        if (r135 == false) goto L94;
        if (r138 == null) goto L201;
    L94:
        com.lynx.tasm.behavior.shadow.text.a r139 = this.f382288b.f382299a.f382309b;
        float[] r140 = r139.f382270z;
        float r141 = r139.f382268x;
        float r142 = r139.f382267w;
        float r143 = r139.f382269y;
        if (r143 > 0.0f) goto L98;
        r143 = 1.0f;
    L98:
        if (r138 == null) goto L100;
        r141 = r138.f382273c;
        r142 = r138.f382274d;
    L102:
        if (r142 <= 0.0f) goto L107;
        if (r141 <= r142) goto L107;
        float r144 = r142;
        r142 = r141;
        r141 = r144;
    L107:
        if (k() == false) goto L118;
        if (l.a(this.f382288b.f382299a.f382309b.f382255k) == true) goto L118;
        f r145 = this.f382288b;
        if (r145.f382301c == MeasureMode.UNDEFINED) goto L118;
        if (r145.f382299a.f382309b.f382255k <= r145.f382303e) goto L118;
        if (l() == false) goto L201;
    L118:
        if (k() == true) goto L125;
        if (r138 != null) goto L121;
    L124:
        int r146 = r129;
        int r147 = r146;
    L127:
        if (k() == true) goto L131;
        if (r138 == null) goto L147;
        if (h() > r138.f382272b) goto L131;
    L147:
        if (k() == false) goto L152;
        if (r138 == null) goto L201;
        if (r147 < 0) goto L151;
        b(r147, r101);
        goto L201
    L151:
        b(r129, r101);
        goto L201
    L152:
        if (r138 == null) goto L158;
        if (h() <= r138.f382272b) goto L158;
        if (r147 < 0) goto L157;
        b(r147, r101);
        goto L201
    L157:
        b(r129, r101);
    L158:
        if (r105 == null) goto L166;
        int r148 = 0;
    L161:
        if (r148 >= r105.length) goto L172;
        float r149 = r105[r148];
        if (r149 > r146) goto L164;
        r148 = r148 + 1;
        goto L161
    L164:
        r146 = (int) r149;
    L173:
        if (r146 < 0) goto L188;
        b(r146, r101);
        if (k() == true) goto L185;
        if (r138 != null) goto L179;
    L181:
        if (r138 == null) goto L184;
        if (h() < r138.f382271a) goto L158;
    L184:
        r147 = r146;
        goto L158
    L179:
        if (h() <= r138.f382272b) goto L181;
    L185:
        if (r147 < 0) goto L187;
        b(r147, r101);
        goto L188
    L187:
        b(r129, r101);
    L188:
        if (r138 == null) goto L201;
        if (r147 >= 0) goto L201;
        b(r129, r101);
    L172:
        r146 = -1;
        goto L173
    L166:
        int r150 = (int) (r146 + r143);
        if (r150 == r146) goto L172;
        if (r150 > r142) goto L172;
        r146 = r150;
    L131:
        if (r105 == null) goto L138;
        int r151 = r105.length - 1;
    L133:
        if (r151 < 0) goto L144;
        float r152 = r105[r151];
        if (r152 < r146) goto L136;
        r151 = r151 - 1;
        goto L133
    L136:
        int r153 = (int) r152;
    L145:
        if (r153 < 0) goto L147;
        b(r153, r101);
        if (k() == true) goto L199;
        if (r138 != null) goto L195;
    L198:
        r147 = r153;
        goto L199
    L195:
        if (h() < r138.f382271a) goto L199;
        if (h() <= r138.f382272b) goto L198;
    L199:
        r146 = r153;
    L144:
        r153 = -1;
        goto L145
    L138:
        r153 = (int) (r146 - r143);
        if (r153 == r146) goto L144;
        if (r153 < r141) goto L144;
    L121:
        if (h() < r138.f382271a) goto L125;
        if (h() <= r138.f382272b) goto L124;
    L125:
        r146 = r129;
        r147 = -1;
        goto L127
    L100:
        r105 = r140;
    L89:
        r137 = r137 + 1;
    L90:
        r138 = null;
        goto L91
    L71:
        if (r134.isEmpty() == true) goto L73;
        r135 = true;
        goto L74
    L59:
        if (r128.f382263s == true) goto L61;
    L201:
        if (r101.f382296d == (-1)) goto L221;
        float r154 = this.f382288b.f382299a.f382309b.f382255k;
        int r155 = this.f382287a.getLineCount();
        int r156 = this.f382287a.getHeight();
        if (l.a(r154) == false) goto L206;
        double r157 = 0.0d;
    L207:
        int r158 = (int) Math.ceil(((double) this.f382288b.f382303e) + Math.max(r157, AudioStats.AUDIO_AMPLITUDE_NONE));
        if (this.f382288b.f382301c == MeasureMode.UNDEFINED) goto L221;
        if (r156 <= r158) goto L221;
        if (r101.f382294b == true) goto L221;
        int r159 = r155 - 1;
    L214:
        if (r159 <= 0) goto L219;
        if (this.f382287a.getLineBottom(r159) <= this.f382288b.f382303e) goto L219;
        r159 = r159 - 1;
    L219:
        r101.f382297e = r159 + 1;
        r101.f382296d = 0;
        a(r101);
        goto L221
    L206:
        double r160 = r154;
        r157 = (Math.ceil(r160) - r160) * ((double) r155);
    L221:
        if (r101.f382296d != (-1)) goto L223;
    L265:
        f r161 = this.f382288b;
        MeasureMode r162 = r161.f382300b;
        MeasureMode r163 = MeasureMode.EXACTLY;
        if (r162 == r163) goto L268;
    L270:
        float r164 = d();
        f r165 = this.f382288b;
        com.lynx.tasm.behavior.shadow.text.a r166 = r165.f382299a.f382309b;
        if (r166.f382253i == 1) goto L273;
    L279:
        this.f382290d = c(r164);
    L280:
        this.f382291e = 0.0f;
        if (j() == false) goto L320;
        this.f382291e = b.a((int) Math.ceil(this.f382288b.f382299a.f382309b.f382255k), this.f382287a.getPaint().getFontMetricsInt(), this.f382288b.f382299a.f382309b.f382264t);
        return;
    L320:
        return;
    L273:
        if (r165.f382300b != r163) goto L279;
        float r167 = r165.f382302d;
        if (r167 <= r164) goto L279;
        if (r166.f382254j == 1) goto L280;
        this.f382290d = c(r167);
        goto L280
    L268:
        if (r161.f382299a.f382309b.f382253i == 1) goto L270;
    L223:
        if (this.f382288b.f382299a.f382309b.b() == TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L225;
    L227:
        int r168 = this.f382287a.getLineCount() - 1;
        int r169 = this.f382287a.getEllipsisCount(r168);
        this.f382289c = r169;
        if (r169 <= 0) goto L265;
        int r170 = this.f382287a.getLineStart(r168) + this.f382287a.getEllipsisStart(r168);
        SpannableStringBuilder r171 = new SpannableStringBuilder(this.f382287a.getText().subSequence(0, r170 + 1));
        if (this.f382288b.f382305g == false) goto L238;
        j[] r172 = (j[]) r171.getSpans(0, 1, j.class);
        if (r172 == null) goto L238;
        if (r172.length == 0) goto L238;
        r171.setSpan(new j(r172[0].f570585a), r170, r171.length(), 17);
        r111 = true;
    L238:
        if (this.f382288b.f382299a.f382309b.b() == TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L250;
        if (r170 >= 0) goto L241;
    L249:
        r111 = true;
        goto L250
    L241:
        if (r170 > r171.length()) goto L249;
        if (this.f382288b.f382299a.f382309b.b() != TextDirectionHeuristics.LTR) goto L247;
        r171.insert(r170, "\u200e");
        goto L249
    L247:
        if (this.f382288b.f382299a.f382309b.b() != TextDirectionHeuristics.RTL) goto L249;
        r171.insert(r170, "\u200f");
    L250:
        if (r111 == false) goto L265;
        r101.f382293a = r171;
        r101.f382296d = -1;
        int r173 = this.f382287a.getLineCount();
        a(r101);
        if (this.f382287a.getLineCount() <= r173) goto L265;
    L255:
        if (this.f382287a.getLineCount() <= r173) goto L265;
        int r174 = 2;
        if (r101.f382293a.length() < 2) goto L265;
        CharSequence r175 = r101.f382293a;
        if (Character.isLowSurrogate(r175.charAt(r175.length() - 2)) == true) goto L261;
    L263:
        r174 = 1;
    L264:
        CharSequence r176 = r101.f382293a;
        r101.f382293a = ((SpannableStringBuilder) r176).delete((r176.length() - 1) - r174, r101.f382293a.length() - 1);
        a(r101);
        goto L255
    L261:
        if (r101.f382293a.length() <= 2) goto L263;
    L225:
        if (this.f382288b.f382305g == true) goto L227;
    L42:
        r122 = r119.f382299a.f382309b.f382245a;
        goto L43
    L35:
        if (r120 == MeasureMode.AT_MOST) goto L38;
        r121 = 32767.0f;
        goto L39
    L26:
        r115 = 1;
        goto L28
    L27:
        r115 = -1;
        goto L28
    L21:
        r114 = r108.f382245a;
        goto L23
    L18:
        r113 = false;
        goto L19
    L11:
        if (r108.f382245a == 1) goto L14;
        r112 = false;
        goto L15
    L7:
        r106 = null;
        goto L8
    L285:
        throw new RuntimeException("prepareSpan() should be called!");
    }

    public e(LynxContext r110, f r111) {
        this.f382289c = 0;
        this.f382290d = 0.0f;
        this.f382291e = 0.0f;
        this.f382292f = -1.0f;
        this.f382288b = r111;
        m(r110);
        if (r111.f382305g == false) goto L27;
        if (r111.f382306h == true) goto L27;
        Layout r100 = this.f382287a;
        if (r100.getEllipsisCount(r100.getLineCount() - 1) == 0) goto L27;
        if ((r111.f382299a.f382308a instanceof SpannableStringBuilder) == false) goto L27;
        int r101 = this.f382287a.getLineCount() - 1;
        int r102 = this.f382287a.getLineStart(r101) + this.f382287a.getEllipsisStart(r101);
        SpannableStringBuilder r103 = new SpannableStringBuilder(r111.f382299a.f382308a);
        j[] r104 = (j[]) r103.getSpans(0, 1, j.class);
        if (r104 == null) goto L27;
        if (r104.length == 0) goto L27;
        j[] r105 = (j[]) r103.getSpans(r102, r102 + 1, j.class);
        if (r105 == null) goto L27;
        if (r105.length == 0) goto L27;
        j r106 = r105[r105.length - 1];
        int r107 = r103.getSpanStart(r106);
        int r108 = r103.getSpanEnd(r106);
        r103.removeSpan(r106);
        if (r107 >= r102) goto L25;
        r103.setSpan(r106, r107, r102, 33);
    L25:
        r103.setSpan(new j(r104[0].f570585a), r102, r108, 34);
        r111.f382299a.f382308a = r103;
        this.f382287a = null;
        m(r110);
    L27:
        if (this.f382287a.getWidth() != 0) goto L29;
        return;
    L29:
        if (this.f382287a.getHeight() == 0) goto L85;
        Spanned r109 = (Spanned) this.f382287a.getText();
        m[] r112 = (m[]) r109.getSpans(0, r109.length(), m.class);
        int r113 = r112.length;
        int r114 = 0;
    L32:
        if (r114 >= r113) goto L52;
        m r115 = r112[r114];
        int r116 = r109.getSpanStart(r115);
        int r117 = r109.getSpanEnd(r115);
        if (r116 == 0) goto L36;
    L38:
        int r118 = this.f382287a.getLineForOffset(r116);
        int r119 = this.f382287a.getLineForOffset(r117);
        Rect r120 = new Rect();
        int r121 = r118;
    L39:
        if (r121 > r119) goto L50;
        Rect r122 = new Rect();
        this.f382287a.getLineBounds(r121, r122);
        if (r121 != r118) goto L43;
        r122.left = Math.max(r122.left, (int) this.f382287a.getPrimaryHorizontal(r116));
    L43:
        if (r121 != r119) goto L46;
        r122.right = Math.min(r122.right, (int) this.f382287a.getPrimaryHorizontal(r117));
    L46:
        if (r122.right == 0) goto L49;
        r120.union(r122);
    L49:
        r121 = r121 + 1;
        goto L39
    L50:
        r115.f570599a.set(r120);
    L51:
        r114 = r114 + 1;
        goto L32
    L36:
        if (r117 != r109.length()) goto L38;
        float r123 = d();
        float r124 = -this.f382290d;
        r115.f570599a.set(new Rect((int) r124, 0, (int) (r124 + r123), this.f382287a.getHeight()));
        goto L51
    L52:
        z6a.l[] r125 = (z6a.l[]) r109.getSpans(0, r109.length(), z6a.l.class);
        int r126 = 0;
    L54:
        if (r126 >= r125.length) goto L86;
        z6a.l r127 = r125[r126];
        Layout r128 = this.f382287a;
        r127.getClass();
        r127.f570597d = new HashMap();
        int r129 = r128.getLineForOffset(r127.f570594a);
    L57:
        if (r129 > r128.getLineForOffset(r127.f570595b)) goto L73;
        int r130 = r128.getLineStart(r129);
        int r131 = r128.getLineEnd(r129);
        int r132 = r127.f570594a;
        if (r132 <= r130) goto L62;
        if (r132 >= r131) goto L62;
        r130 = r132;
    L62:
        int r133 = r127.f570595b;
        if (r133 <= r130) goto L66;
        if (r133 >= r131) goto L66;
        r131 = r133;
    L66:
        int r134 = (int) r128.getPrimaryHorizontal(r130);
        int r135 = (int) r128.getPrimaryHorizontal(r131);
        if (r130 != r128.getLineStart(r129)) goto L70;
        r134 = (int) r128.getLineLeft(r129);
    L70:
        if (r131 != r128.getLineEnd(r129)) goto L72;
        r135 = (int) r128.getLineRight(r129);
    L72:
        r127.f570597d.put(Integer.valueOf(r129), new int[]{r134, r135});
        r129 = r129 + 1;
        goto L57
    L73:
        r126 = r126 + 1;
        goto L54
    L86:
        return;
    }

    public final void b(int r100, a r101) {
        SpannableStringBuilder r102 = (SpannableStringBuilder) r101.f382293a;
        int r103 = 0;
        AbsoluteSizeSpan[] r104 = (AbsoluteSizeSpan[]) r102.getSpans(0, r102.length(), AbsoluteSizeSpan.class);
    L4:
        if (r103 >= r104.length) goto L6;
        r102.removeSpan(r104[r103]);
        r103 = r103 + 1;
        goto L4
    L6:
        r101.f382298f.setTextSize(r100);
        a(r101);
    }

    public final CharSequence f(SpannableStringBuilder r100, int r101) {
        int r102 = Math.max(0, r101);
        SpannableStringBuilder r103 = (SpannableStringBuilder) r100.subSequence(0, Math.min(r100.length(), r102));
        if (this.f382288b.f382299a.f382309b.b() != TextDirectionHeuristics.LTR) goto L6;
        r103.append("\u200e");
    L8:
        r103.append("…");
        return r103;
    L6:
        if (this.f382288b.f382299a.f382309b.b() != TextDirectionHeuristics.RTL) goto L8;
        r103.append("\u200f");
        goto L8
    }

    public final StaticLayout.Builder e(CharSequence r100, Layout.Alignment r101, TextPaint r102, float r103) {
        StaticLayout.Builder r104 = StaticLayout.Builder.obtain(r100, 0, r100.length(), r102, (int) Math.floor(r103));
        r104.setAlignment(r101);
        r104.setLineSpacing(this.f382288b.f382299a.f382309b.f382257m, 1.0f);
        r104.setIncludePad(this.f382288b.f382299a.f382309b.f382264t);
        r104.setTextDirection(this.f382288b.f382299a.f382309b.b());
        r104.setBreakStrategy(this.f382288b.f382304f);
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r104.setUseLineSpacingFromFallbacks(true);
    L5:
        return r104;
    }
}
