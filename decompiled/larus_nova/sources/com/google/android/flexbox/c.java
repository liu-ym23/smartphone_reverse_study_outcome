package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.widget.CompoundButtonCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes23.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.flexbox.a f274442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean[] f274443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f274444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long[] f274445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long[] f274446e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<com.google.android.flexbox.b> f274447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f274448b;

        public a() {
        }
    }

    public static class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f274449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f274450b;

        public b() {
        }

        public final String toString() {
            return "Order{order=" + this.f274450b + ", index=" + this.f274449a + '}';
        }

        @Override // java.lang.Comparable
        public final int compareTo(b r100) {
            b r101 = r100;
            int r102 = this.f274450b;
            int r103 = r101.f274450b;
            if (r102 == r103) goto L6;
            return r102 - r103;
        L6:
            return this.f274449a - r101.f274449a;
        }
    }

    static {
    }

    public c(com.google.android.flexbox.a r100) {
        this.f274442a = r100;
    }

    public final List<b> f(int r100) {
        ArrayList r101 = new ArrayList(r100);
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        FlexItem r103 = (FlexItem) this.f274442a.d(r102).getLayoutParams();
        b r104 = new b();
        r104.f274450b = r103.getOrder();
        r104.f274449a = r102;
        r101.add(r104);
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    public final void i(int r100) {
        int[] r101 = this.f274444c;
        if (r101 != null) goto L9;
        if (r100 >= 10) goto L7;
        r100 = 10;
    L7:
        this.f274444c = new int[r100];
        return;
    L9:
        if (r101.length >= r100) goto L16;
        int r102 = r101.length * 2;
        if (r102 < r100) goto L13;
        r100 = r102;
    L13:
        this.f274444c = Arrays.copyOf(r101, r100);
        return;
    }

    public final void j(int r100) {
        long[] r101 = this.f274445d;
        if (r101 != null) goto L9;
        if (r100 >= 10) goto L7;
        r100 = 10;
    L7:
        this.f274445d = new long[r100];
        return;
    L9:
        if (r101.length >= r100) goto L16;
        int r102 = r101.length * 2;
        if (r102 < r100) goto L13;
        r100 = r102;
    L13:
        this.f274445d = Arrays.copyOf(r101, r100);
        return;
    }

    public final void k(int r100) {
        long[] r101 = this.f274446e;
        if (r101 != null) goto L9;
        if (r100 >= 10) goto L7;
        r100 = 10;
    L7:
        this.f274446e = new long[r100];
        return;
    L9:
        if (r101.length >= r100) goto L16;
        int r102 = r101.length * 2;
        if (r102 < r100) goto L13;
        r100 = r102;
    L13:
        this.f274446e = Arrays.copyOf(r101, r100);
        return;
    }

    public final void u(int r110) {
        if (r110 < this.f274442a.getFlexItemCount()) goto L5;
        return;
    L5:
        int r100 = this.f274442a.getFlexDirection();
        if (this.f274442a.getAlignItems() != 4) goto L41;
        int[] r101 = this.f274444c;
        if (r101 == null) goto L10;
        int r102 = r101[r110];
    L11:
        List<com.google.android.flexbox.b> r103 = this.f274442a.getFlexLinesInternal();
        int r111 = r103.size();
    L12:
        if (r102 >= r111) goto L58;
        com.google.android.flexbox.b r112 = (com.google.android.flexbox.b) ListProtector.get(r103, r102);
        int r113 = r112.f274431h;
        int r114 = 0;
    L14:
        if (r114 >= r113) goto L40;
        int r115 = r112.f274438o + r114;
        if (r114 >= this.f274442a.getFlexItemCount()) goto L39;
        View r116 = this.f274442a.l(r115);
        if (r116 == null) goto L39;
        if (r116.getVisibility() == 8) goto L39;
        FlexItem r104 = (FlexItem) r116.getLayoutParams();
        if (r104.getAlignSelf() != (-1)) goto L26;
    L28:
        if (r100 == 0) goto L38;
        if (r100 == 1) goto L38;
        if (r100 != 2) goto L33;
    L37:
        s(r116, r112.f274430g, r115);
        goto L39
    L33:
        if (r100 == 3) goto L37;
        throw new IllegalArgumentException("Invalid flex direction: " + r100);
    L38:
        t(r116, r112.f274430g, r115);
        goto L39
    L26:
        if (r104.getAlignSelf() == 4) goto L28;
    L39:
        r114 = r114 + 1;
        goto L14
    L40:
        r102 = r102 + 1;
        goto L12
    L58:
        return;
    L10:
        r102 = 0;
        goto L11
    L41:
        Iterator<com.google.android.flexbox.b> r105 = this.f274442a.getFlexLinesInternal().iterator();
    L43:
        if (r105.hasNext() == false) goto L77;
        com.google.android.flexbox.b r106 = r105.next();
        Iterator r107 = ((ArrayList) r106.f274437n).iterator();
    L46:
        if (r107.hasNext() == false) goto L43;
        Integer r108 = (Integer) r107.next();
        View r109 = this.f274442a.l(r108.intValue());
        if (r100 == 0) goto L57;
        if (r100 == 1) goto L57;
        if (r100 == 2) goto L56;
        if (r100 == 3) goto L56;
        throw new IllegalArgumentException("Invalid flex direction: " + r100);
    L56:
        s(r109, r106.f274430g, r108.intValue());
    L57:
        t(r109, r106.f274430g, r108.intValue());
        goto L46
    }

    public final void c(View r100, int r101) {
        FlexItem r102 = (FlexItem) r100.getLayoutParams();
        int r103 = r100.getMeasuredWidth();
        int r104 = r100.getMeasuredHeight();
        boolean r105 = true;
        if (r103 >= r102.getMinWidth()) goto L6;
        r103 = r102.getMinWidth();
    L8:
        boolean r106 = true;
    L11:
        if (r104 >= r102.getMinHeight()) goto L14;
        r104 = r102.getMinHeight();
    L17:
        if (r105 == false) goto L20;
        int r107 = View.MeasureSpec.makeMeasureSpec(r103, 1073741824);
        int r108 = View.MeasureSpec.makeMeasureSpec(r104, 1073741824);
        r100.measure(r107, r108);
        v(r101, r107, r108, r100);
        this.f274442a.n(r101, r100);
        return;
    L20:
        return;
    L14:
        if (r104 <= r102.getMaxHeight()) goto L16;
        r104 = r102.getMaxHeight();
        goto L17
    L16:
        r105 = r106;
        goto L17
    L6:
        if (r103 <= r102.getMaxWidth()) goto L9;
        r103 = r102.getMaxWidth();
        goto L8
    L9:
        r106 = false;
        goto L11
    }

    public final void d(List<com.google.android.flexbox.b> r100, int r101) {
        int r102 = this.f274444c[r101];
        if (r102 != (-1)) goto L5;
        r102 = 0;
    L5:
        int r103 = r100.size() - 1;
    L6:
        if (r103 < r102) goto L8;
        ListProtector.remove(r100, r103);
        r103 = r103 - 1;
        goto L6
    L8:
        int[] r104 = this.f274444c;
        int r105 = r104.length - 1;
        if (r101 <= r105) goto L11;
        Arrays.fill(r104, -1);
    L12:
        long[] r106 = this.f274445d;
        int r107 = r106.length - 1;
        if (r101 <= r107) goto L15;
        Arrays.fill(r106, 0);
        return;
    L15:
        Arrays.fill(r106, r101, r107, 0);
        return;
    L11:
        Arrays.fill(r104, r101, r105, -1);
        goto L12
    }

    public static List e(List r100, int r101, int r102) {
        int r103 = (r101 - r102) / 2;
        ArrayList r104 = new ArrayList();
        com.google.android.flexbox.b r105 = new com.google.android.flexbox.b();
        r105.f274430g = r103;
        int r106 = r100.size();
        int r107 = 0;
    L3:
        if (r107 >= r106) goto L10;
        if (r107 != 0) goto L6;
        r104.add(r105);
    L6:
        r104.add((com.google.android.flexbox.b) ListProtector.get(r100, r107));
        if (r107 != (r100.size() - 1)) goto L9;
        r104.add(r105);
    L9:
        r107 = r107 + 1;
        goto L3
    L10:
        return r104;
    }

    public static int[] r(int r100, List r101, SparseIntArray r102) {
        Collections.sort(r101);
        r102.clear();
        int[] r103 = new int[r100];
        Iterator r104 = ((ArrayList) r101).iterator();
        int r105 = 0;
    L4:
        if (r104.hasNext() == false) goto L6;
        b r106 = (b) r104.next();
        int r107 = r106.f274449a;
        r103[r105] = r107;
        r102.append(r107, r106.f274450b);
        r105 = r105 + 1;
        goto L4
    L6:
        return r103;
    }

    public final void g(int r110, int r111, int r112) {
        int r100 = this.f274442a.getFlexDirection();
        if (r100 == 0) goto L11;
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L10;
        if (r100 == 3) goto L10;
        throw new IllegalArgumentException("Invalid flex direction: " + r100);
    L10:
        int r113 = View.MeasureSpec.getMode(r110);
        int r114 = View.MeasureSpec.getSize(r110);
    L12:
        List<com.google.android.flexbox.b> r101 = this.f274442a.getFlexLinesInternal();
        if (r113 != 1073741824) goto L80;
        int r115 = this.f274442a.getSumOfCrossSize() + r112;
        int r102 = 0;
        if (r101.size() != 1) goto L18;
        ((com.google.android.flexbox.b) ListProtector.get(r101, 0)).f274430g = r114 - r112;
        return;
    L18:
        if (r101.size() < 2) goto L82;
        int r116 = this.f274442a.getAlignContent();
        if (r116 == 1) goto L70;
        if (r116 != 2) goto L23;
        this.f274442a.setFlexLines(e(r101, r114, r115));
        return;
    L23:
        if (r116 != 3) goto L25;
        if (r115 >= r114) goto L89;
        float r117 = (r114 - r115) / (r101.size() - 1);
        ArrayList r118 = new ArrayList();
        int r119 = r101.size();
        float r103 = 0.0f;
    L53:
        if (r102 >= r119) goto L68;
        r118.add((com.google.android.flexbox.b) ListProtector.get(r101, r102));
        if (r102 == (r101.size() - 1)) goto L67;
        com.google.android.flexbox.b r104 = new com.google.android.flexbox.b();
        if (r102 != (r101.size() - 2)) goto L59;
        r104.f274430g = Math.round(r103 + r117);
        r103 = 0.0f;
    L60:
        int r105 = r104.f274430g;
        r103 = r103 + (r117 - r105);
        if (r103 <= 1.0f) goto L64;
        r104.f274430g = r105 + 1;
        r103 = r103 - 1.0f;
    L66:
        r118.add(r104);
        goto L67
    L64:
        if (r103 >= (-1.0f)) goto L66;
        r104.f274430g = r105 - 1;
        r103 = r103 + 1.0f;
        goto L66
    L59:
        r104.f274430g = Math.round(r117);
    L67:
        r102 = r102 + 1;
        goto L53
    L68:
        this.f274442a.setFlexLines(r118);
        return;
    L89:
        return;
    L25:
        if (r116 != 4) goto L27;
        if (r115 < r114) goto L45;
        this.f274442a.setFlexLines(e(r101, r114, r115));
        return;
    L45:
        int r120 = (r114 - r115) / (r101.size() * 2);
        ArrayList r121 = new ArrayList();
        com.google.android.flexbox.b r122 = new com.google.android.flexbox.b();
        r122.f274430g = r120;
        Iterator<com.google.android.flexbox.b> r123 = r101.iterator();
    L47:
        if (r123.hasNext() == false) goto L49;
        com.google.android.flexbox.b r106 = r123.next();
        r121.add(r122);
        r121.add(r106);
        r121.add(r122);
        goto L47
    L49:
        this.f274442a.setFlexLines(r121);
        return;
    L27:
        if (r116 != 5) goto L87;
        if (r115 >= r114) goto L88;
        float r124 = (r114 - r115) / r101.size();
        int r125 = r101.size();
        float r126 = 0.0f;
    L32:
        if (r102 >= r125) goto L90;
        com.google.android.flexbox.b r107 = (com.google.android.flexbox.b) ListProtector.get(r101, r102);
        float r108 = r107.f274430g + r124;
        if (r102 != (r101.size() - 1)) goto L36;
        r108 = r108 + r126;
        r126 = 0.0f;
    L36:
        int r109 = Math.round(r108);
        r126 = r126 + (r108 - r109);
        if (r126 <= 1.0f) goto L40;
        r109 = r109 + 1;
        r126 = r126 - 1.0f;
    L42:
        r107.f274430g = r109;
        r102 = r102 + 1;
        goto L32
    L40:
        if (r126 >= (-1.0f)) goto L42;
        r109 = r109 - 1;
        r126 = r126 + 1.0f;
        goto L42
    L90:
        return;
    L88:
        return;
    L87:
        return;
    L70:
        int r127 = r114 - r115;
        com.google.android.flexbox.b r128 = new com.google.android.flexbox.b();
        r128.f274430g = r127;
        ListProtector.add(r101, 0, r128);
        return;
    L82:
        return;
    L80:
        return;
    L11:
        int r129 = View.MeasureSpec.getMode(r111);
        int r130 = View.MeasureSpec.getSize(r111);
        r113 = r129;
        r114 = r130;
        goto L12
    }

    public final void h(int r110, int r111, int r112) {
        int r100 = this.f274442a.getFlexItemCount();
        boolean[] r101 = this.f274443b;
        int r102 = 0;
        if (r101 != null) goto L9;
        if (r100 >= 10) goto L7;
        r100 = 10;
    L7:
        this.f274443b = new boolean[r100];
    L16:
        if (r112 < this.f274442a.getFlexItemCount()) goto L18;
        return;
    L18:
        int r103 = this.f274442a.getFlexDirection();
        int r104 = this.f274442a.getFlexDirection();
        if (r104 != 0) goto L21;
    L33:
        int r105 = View.MeasureSpec.getMode(r110);
        int r106 = View.MeasureSpec.getSize(r110);
        int r107 = this.f274442a.getLargestMainSize();
        if (r105 == 1073741824) goto L39;
        if (r107 > r106) goto L39;
        r106 = r107;
    L39:
        int r108 = this.f274442a.getPaddingLeft();
        int r109 = this.f274442a.getPaddingRight();
    L40:
        int r113 = r108 + r109;
        int[] r114 = this.f274444c;
        if (r114 == null) goto L43;
        r102 = r114[r112];
    L43:
        List<com.google.android.flexbox.b> r115 = this.f274442a.getFlexLinesInternal();
        int r116 = r115.size();
    L44:
        if (r102 >= r116) goto L55;
        com.google.android.flexbox.b r117 = (com.google.android.flexbox.b) ListProtector.get(r115, r102);
        int r118 = r117.f274428e;
        if (r118 < r106) goto L48;
    L50:
        if (r118 <= r106) goto L54;
        if (r117.f274441r == false) goto L54;
        q(r110, r111, r117, r106, r113, false);
    L54:
        r102 = r102 + 1;
        goto L44
    L48:
        if (r117.f274440q == false) goto L50;
        l(r110, r111, r117, r106, r113, false);
        goto L54
    L55:
        return;
    L21:
        if (r104 == 1) goto L33;
        if (r104 != 2) goto L24;
    L28:
        int r119 = View.MeasureSpec.getMode(r111);
        r106 = View.MeasureSpec.getSize(r111);
        if (r119 == 1073741824) goto L32;
        r106 = this.f274442a.getLargestMainSize();
    L32:
        r108 = this.f274442a.getPaddingTop();
        r109 = this.f274442a.getPaddingBottom();
        goto L40
    L24:
        if (r104 == 3) goto L28;
        throw new IllegalArgumentException("Invalid flex direction: " + r103);
    L9:
        if (r101.length >= r100) goto L14;
        int r120 = r101.length * 2;
        if (r120 < r100) goto L13;
        r100 = r120;
    L13:
        this.f274443b = new boolean[r100];
        goto L16
    L14:
        Arrays.fill(r101, false);
        goto L16
    }

    public final int m(int r100, FlexItem r101, int r102) {
        com.google.android.flexbox.a r103 = this.f274442a;
        int r104 = r103.k(r100, (((r103.getPaddingTop() + this.f274442a.getPaddingBottom()) + r101.getMarginTop()) + r101.getMarginBottom()) + r102, r101.getHeight());
        int r105 = View.MeasureSpec.getSize(r104);
        if (r105 <= r101.getMaxHeight()) goto L6;
        return View.MeasureSpec.makeMeasureSpec(r101.getMaxHeight(), View.MeasureSpec.getMode(r104));
    L6:
        if (r105 < r101.getMinHeight()) goto L8;
        return r104;
    L8:
        return View.MeasureSpec.makeMeasureSpec(r101.getMinHeight(), View.MeasureSpec.getMode(r104));
    }

    public final int n(int r100, FlexItem r101, int r102) {
        com.google.android.flexbox.a r103 = this.f274442a;
        int r104 = r103.m(r100, (((r103.getPaddingLeft() + this.f274442a.getPaddingRight()) + r101.getMarginLeft()) + r101.getMarginRight()) + r102, r101.getWidth());
        int r105 = View.MeasureSpec.getSize(r104);
        if (r105 <= r101.getMaxWidth()) goto L6;
        return View.MeasureSpec.makeMeasureSpec(r101.getMaxWidth(), View.MeasureSpec.getMode(r104));
    L6:
        if (r105 < r101.getMinWidth()) goto L8;
        return r104;
    L8:
        return View.MeasureSpec.makeMeasureSpec(r101.getMinWidth(), View.MeasureSpec.getMode(r104));
    }

    public final void s(View r100, int r101, int r102) {
        FlexItem r103 = (FlexItem) r100.getLayoutParams();
        int r104 = Math.min(Math.max(((r101 - r103.getMarginLeft()) - r103.getMarginRight()) - this.f274442a.h(r100), r103.getMinWidth()), r103.getMaxWidth());
        long[] r105 = this.f274446e;
        if (r105 == null) goto L5;
        int r106 = (int) (r105[r102] >> 32);
    L6:
        int r107 = View.MeasureSpec.makeMeasureSpec(r106, 1073741824);
        int r108 = View.MeasureSpec.makeMeasureSpec(r104, 1073741824);
        r100.measure(r108, r107);
        v(r102, r108, r107, r100);
        this.f274442a.n(r102, r100);
        return;
    L5:
        r106 = r100.getMeasuredHeight();
        goto L6
    }

    public final void t(View r100, int r101, int r102) {
        FlexItem r103 = (FlexItem) r100.getLayoutParams();
        int r104 = Math.min(Math.max(((r101 - r103.getMarginTop()) - r103.getMarginBottom()) - this.f274442a.h(r100), r103.getMinHeight()), r103.getMaxHeight());
        long[] r105 = this.f274446e;
        if (r105 == null) goto L5;
        int r106 = (int) r105[r102];
    L6:
        int r107 = View.MeasureSpec.makeMeasureSpec(r106, 1073741824);
        int r108 = View.MeasureSpec.makeMeasureSpec(r104, 1073741824);
        r100.measure(r107, r108);
        v(r102, r107, r108, r100);
        this.f274442a.n(r102, r100);
        return;
    L5:
        r106 = r100.getMeasuredWidth();
        goto L6
    }

    public final void a(List<com.google.android.flexbox.b> r100, com.google.android.flexbox.b r101, int r102, int r103) {
        r101.f274436m = r103;
        this.f274442a.b(r101);
        r101.f274439p = r102;
        r100.add(r101);
    }

    public final void v(int r100, int r101, int r102, View r110) {
        long[] r103 = this.f274445d;
        if (r103 == null) goto L5;
        long r104 = ((long) r101) & BodyPartID.bodyIdMax;
        r103[r100] = r104 | (((long) r102) << 32);
    L5:
        long[] r105 = this.f274446e;
        if (r105 == null) goto L9;
        int r106 = r110.getMeasuredWidth();
        long r107 = ((long) r110.getMeasuredHeight()) << 32;
        r105[r100] = (((long) r106) & BodyPartID.bodyIdMax) | r107;
        return;
    }

    public final void l(int r210, int r211, com.google.android.flexbox.b r212, int r213, int r214, boolean r215) {
        float r100 = r212.f274433j;
        float r101 = 0.0f;
        if (r100 <= 0.0f) goto L86;
        int r102 = r212.f274428e;
        if (r213 < r102) goto L89;
        float r103 = (r213 - r102) / r100;
        r212.f274428e = r214 + r212.f274429f;
        if (r215 == true) goto L10;
        r212.f274430g = Integer.MIN_VALUE;
    L10:
        int r104 = 0;
        boolean r105 = false;
        int r106 = 0;
        float r107 = 0.0f;
    L12:
        if (r104 >= r212.f274431h) goto L77;
        int r110 = r212.f274438o + r104;
        View r111 = this.f274442a.l(r110);
        if (r111 != null) goto L16;
    L75:
        int r112 = r102;
    L76:
        r104 = r104 + 1;
        r102 = r112;
        r101 = 0.0f;
        goto L12
    L16:
        if (r111.getVisibility() == 8) goto L75;
        FlexItem r113 = (FlexItem) r111.getLayoutParams();
        int r114 = this.f274442a.getFlexDirection();
        if (r114 == 0) goto L48;
        if (r114 == 1) goto L48;
        int r115 = r111.getMeasuredHeight();
        long[] r116 = this.f274446e;
        if (r116 == null) goto L25;
        r115 = (int) (r116[r110] >> 32);
    L25:
        int r117 = r111.getMeasuredWidth();
        long[] r118 = this.f274446e;
        if (r118 == null) goto L29;
        r117 = (int) r118[r110];
    L29:
        if (this.f274443b[r110] == false) goto L31;
    L46:
        r112 = r102;
    L47:
        int r108 = Math.max(r106, ((r117 + r113.getMarginLeft()) + r113.getMarginRight()) + this.f274442a.h(r111));
        r212.f274428e += (r115 + r113.getMarginTop()) + r113.getMarginBottom();
    L74:
        r212.f274430g = Math.max(r212.f274430g, r108);
        r106 = r108;
        goto L76
    L31:
        if (r113.getFlexGrow() <= r101) goto L46;
        float r119 = r115 + (r113.getFlexGrow() * r103);
        if (r104 != (r212.f274431h - 1)) goto L35;
        r119 = r119 + r107;
        r107 = 0.0f;
    L35:
        int r120 = Math.round(r119);
        if (r120 <= r113.getMaxHeight()) goto L38;
        r120 = r113.getMaxHeight();
        this.f274443b[r110] = true;
        r212.f274433j -= r113.getFlexGrow();
        r112 = r102;
        r105 = true;
    L45:
        int r109 = n(r210, r113, r212.f274436m);
        int r121 = View.MeasureSpec.makeMeasureSpec(r120, 1073741824);
        r111.measure(r109, r121);
        r117 = r111.getMeasuredWidth();
        int r122 = r111.getMeasuredHeight();
        v(r110, r109, r121, r111);
        this.f274442a.n(r110, r111);
        r115 = r122;
        goto L47
    L38:
        r107 = r107 + (r119 - r120);
        r112 = r102;
        double r123 = r107;
        if (r123 <= 1.0d) goto L42;
        r120 = r120 + 1;
        double r124 = r123 - 1.0d;
    L44:
        r107 = (float) r124;
        goto L45
    L42:
        if (r123 >= (-1.0d)) goto L45;
        r120 = r120 - 1;
        r124 = r123 + 1.0d;
    L48:
        r112 = r102;
        int r125 = r111.getMeasuredWidth();
        long[] r126 = this.f274446e;
        if (r126 == null) goto L51;
        r125 = (int) r126[r110];
    L51:
        int r127 = r111.getMeasuredHeight();
        long[] r128 = this.f274446e;
        if (r128 == null) goto L55;
        r127 = (int) (r128[r110] >> 32);
    L55:
        if (this.f274443b[r110] == true) goto L73;
        if (r113.getFlexGrow() <= 0.0f) goto L73;
        float r129 = r125 + (r113.getFlexGrow() * r103);
        if (r104 != (r212.f274431h - 1)) goto L61;
        r129 = r129 + r107;
        r107 = 0.0f;
    L61:
        int r130 = Math.round(r129);
        if (r130 <= r113.getMaxWidth()) goto L64;
        r130 = r113.getMaxWidth();
        this.f274443b[r110] = true;
        r212.f274433j -= r113.getFlexGrow();
        r105 = true;
    L71:
        int r131 = m(r211, r113, r212.f274436m);
        int r132 = View.MeasureSpec.makeMeasureSpec(r130, 1073741824);
        r111.measure(r132, r131);
        int r133 = r111.getMeasuredWidth();
        int r134 = r111.getMeasuredHeight();
        v(r110, r132, r131, r111);
        this.f274442a.n(r110, r111);
        r125 = r133;
        r127 = r134;
        goto L73
    L64:
        r107 = r107 + (r129 - r130);
        double r135 = r107;
        if (r135 <= 1.0d) goto L68;
        r130 = r130 + 1;
        double r136 = r135 - 1.0d;
    L70:
        r107 = (float) r136;
        goto L71
    L68:
        if (r135 >= (-1.0d)) goto L71;
        r130 = r130 - 1;
        r136 = r135 + 1.0d;
    L73:
        int r137 = Math.max(r106, ((r127 + r113.getMarginTop()) + r113.getMarginBottom()) + this.f274442a.h(r111));
        r212.f274428e += (r125 + r113.getMarginLeft()) + r113.getMarginRight();
        r108 = r137;
        goto L74
    L77:
        int r138 = r102;
        if (r105 == true) goto L80;
        return;
    L80:
        if (r138 == r212.f274428e) goto L88;
        l(r210, r211, r212, r213, r214, true);
        return;
    L88:
        return;
    L89:
        return;
    }

    public final void o(View r100, com.google.android.flexbox.b r101, int r102, int r103, int r110, int r111) {
        FlexItem r104 = (FlexItem) r100.getLayoutParams();
        int r105 = this.f274442a.getAlignItems();
        if (r104.getAlignSelf() == (-1)) goto L5;
        r105 = r104.getAlignSelf();
    L5:
        int r106 = r101.f274430g;
        if (r105 == 0) goto L28;
        if (r105 == 1) goto L24;
        if (r105 != 2) goto L11;
        int r107 = (((r106 - r100.getMeasuredHeight()) + r104.getMarginTop()) - r104.getMarginBottom()) / 2;
        if (this.f274442a.getFlexWrap() == 2) goto L22;
        int r108 = r103 + r107;
        r100.layout(r102, r108, r110, r100.getMeasuredHeight() + r108);
        return;
    L22:
        int r109 = r103 - r107;
        r100.layout(r102, r109, r110, r100.getMeasuredHeight() + r109);
        return;
    L11:
        if (r105 == 3) goto L16;
        if (r105 == 4) goto L28;
        return;
    L16:
        if (this.f274442a.getFlexWrap() == 2) goto L18;
        int r112 = Math.max(r101.f274435l - r100.getBaseline(), r104.getMarginTop());
        r100.layout(r102, r103 + r112, r110, r111 + r112);
        return;
    L18:
        int r113 = Math.max((r101.f274435l - r100.getMeasuredHeight()) + r100.getBaseline(), r104.getMarginBottom());
        r100.layout(r102, r103 - r113, r110, r111 - r113);
        return;
    L24:
        if (this.f274442a.getFlexWrap() == 2) goto L26;
        int r114 = r103 + r106;
        r100.layout(r102, (r114 - r100.getMeasuredHeight()) - r104.getMarginBottom(), r110, r114 - r104.getMarginBottom());
        return;
    L26:
        r100.layout(r102, ((r103 - r106) + r100.getMeasuredHeight()) + r104.getMarginTop(), r110, ((r111 - r106) + r100.getMeasuredHeight()) + r104.getMarginTop());
        return;
    L28:
        if (this.f274442a.getFlexWrap() == 2) goto L30;
        r100.layout(r102, r103 + r104.getMarginTop(), r110, r111 + r104.getMarginTop());
        return;
    L30:
        r100.layout(r102, r103 - r104.getMarginBottom(), r110, r111 - r104.getMarginBottom());
    }

    public final void q(int r210, int r211, com.google.android.flexbox.b r212, int r213, int r214, boolean r310) {
        int r100 = r212.f274428e;
        float r101 = r212.f274434k;
        float r102 = 0.0f;
        if (r101 <= 0.0f) goto L83;
        if (r213 > r100) goto L86;
        float r103 = (r100 - r213) / r101;
        r212.f274428e = r214 + r212.f274429f;
        if (r310 == true) goto L9;
        r212.f274430g = Integer.MIN_VALUE;
    L9:
        int r104 = 0;
        boolean r105 = false;
        int r106 = 0;
        float r107 = 0.0f;
    L11:
        if (r104 >= r212.f274431h) goto L74;
        int r110 = r212.f274438o + r104;
        View r111 = this.f274442a.l(r110);
        if (r111 != null) goto L15;
    L72:
        int r108 = r100;
        int r112 = r104;
    L73:
        r104 = r112 + 1;
        r100 = r108;
        r102 = 0.0f;
        goto L11
    L15:
        if (r111.getVisibility() == 8) goto L72;
        FlexItem r113 = (FlexItem) r111.getLayoutParams();
        int r114 = this.f274442a.getFlexDirection();
        if (r114 == 0) goto L46;
        if (r114 == 1) goto L46;
        int r115 = r111.getMeasuredHeight();
        long[] r116 = this.f274446e;
        if (r116 == null) goto L24;
        r115 = (int) (r116[r110] >> 32);
    L24:
        int r117 = r111.getMeasuredWidth();
        long[] r118 = this.f274446e;
        if (r118 == null) goto L28;
        r117 = (int) r118[r110];
    L28:
        if (this.f274443b[r110] == false) goto L30;
    L44:
        r108 = r100;
        r112 = r104;
    L45:
        int r109 = Math.max(r106, ((r117 + r113.getMarginLeft()) + r113.getMarginRight()) + this.f274442a.h(r111));
        r212.f274428e += (r115 + r113.getMarginTop()) + r113.getMarginBottom();
    L71:
        r212.f274430g = Math.max(r212.f274430g, r109);
        r106 = r109;
        goto L73
    L30:
        if (r113.getFlexShrink() <= r102) goto L44;
        float r119 = r115 - (r113.getFlexShrink() * r103);
        if (r104 != (r212.f274431h - 1)) goto L34;
        r119 = r119 + r107;
        r107 = 0.0f;
    L34:
        int r120 = Math.round(r119);
        if (r120 >= r113.getMinHeight()) goto L37;
        r120 = r113.getMinHeight();
        this.f274443b[r110] = true;
        r212.f274434k -= r113.getFlexShrink();
        r108 = r100;
        r112 = r104;
        r105 = true;
    L43:
        int r121 = n(r210, r113, r212.f274436m);
        int r122 = View.MeasureSpec.makeMeasureSpec(r120, 1073741824);
        r111.measure(r121, r122);
        r117 = r111.getMeasuredWidth();
        int r123 = r111.getMeasuredHeight();
        v(r110, r121, r122, r111);
        this.f274442a.n(r110, r111);
        r115 = r123;
        goto L45
    L37:
        r107 = r107 + (r119 - r120);
        r108 = r100;
        r112 = r104;
        double r124 = r107;
        if (r124 <= 1.0d) goto L41;
        r120 = r120 + 1;
        r107 = r107 - 1.0f;
        goto L43
    L41:
        if (r124 >= (-1.0d)) goto L43;
        r120 = r120 - 1;
        r107 = r107 + 1.0f;
    L46:
        r108 = r100;
        r112 = r104;
        int r125 = r111.getMeasuredWidth();
        long[] r126 = this.f274446e;
        if (r126 == null) goto L49;
        r125 = (int) r126[r110];
    L49:
        int r127 = r111.getMeasuredHeight();
        long[] r128 = this.f274446e;
        if (r128 == null) goto L53;
        r127 = (int) (r128[r110] >> 32);
    L53:
        if (this.f274443b[r110] == true) goto L70;
        if (r113.getFlexShrink() <= 0.0f) goto L70;
        float r129 = r125 - (r113.getFlexShrink() * r103);
        if (r112 != (r212.f274431h - 1)) goto L59;
        r129 = r129 + r107;
        r107 = 0.0f;
    L59:
        int r130 = Math.round(r129);
        if (r130 >= r113.getMinWidth()) goto L62;
        r130 = r113.getMinWidth();
        this.f274443b[r110] = true;
        r212.f274434k -= r113.getFlexShrink();
        r105 = true;
    L68:
        int r131 = m(r211, r113, r212.f274436m);
        int r132 = View.MeasureSpec.makeMeasureSpec(r130, 1073741824);
        r111.measure(r132, r131);
        int r133 = r111.getMeasuredWidth();
        int r134 = r111.getMeasuredHeight();
        v(r110, r132, r131, r111);
        this.f274442a.n(r110, r111);
        r125 = r133;
        r127 = r134;
        goto L70
    L62:
        r107 = r107 + (r129 - r130);
        double r135 = r107;
        if (r135 <= 1.0d) goto L66;
        r130 = r130 + 1;
        r107 = r107 - 1.0f;
        goto L68
    L66:
        if (r135 >= (-1.0d)) goto L68;
        r130 = r130 - 1;
        r107 = r107 + 1.0f;
    L70:
        int r136 = Math.max(r106, ((r127 + r113.getMarginTop()) + r113.getMarginBottom()) + this.f274442a.h(r111));
        r212.f274428e += (r125 + r113.getMarginLeft()) + r113.getMarginRight();
        r109 = r136;
        goto L71
    L74:
        int r137 = r100;
        if (r105 == true) goto L77;
        return;
    L77:
        if (r137 == r212.f274428e) goto L85;
        q(r210, r211, r212, r213, r214, true);
        return;
    L85:
        return;
    L86:
        return;
    }

    public final void b(a r210, int r211, int r310, int r311, int r312, int r313, List<com.google.android.flexbox.b> r314) {
        boolean r100 = this.f274442a.o();
        int r101 = View.MeasureSpec.getMode(r211);
        int r102 = View.MeasureSpec.getSize(r211);
        if (r314 != null) goto L5;
        List<com.google.android.flexbox.b> r103 = new ArrayList();
    L6:
        r210.f274447a = r103;
        if (r313 != (-1)) goto L9;
        boolean r110 = true;
    L10:
        if (r100 == false) goto L12;
        int r111 = this.f274442a.getPaddingStart();
    L13:
        if (r100 == false) goto L15;
        int r112 = this.f274442a.getPaddingEnd();
    L16:
        if (r100 == false) goto L18;
        int r113 = this.f274442a.getPaddingTop();
    L19:
        if (r100 == false) goto L21;
        int r114 = this.f274442a.getPaddingBottom();
    L22:
        com.google.android.flexbox.b r104 = new com.google.android.flexbox.b();
        int r115 = r312;
        r104.f274438o = r115;
        int r116 = r111 + r112;
        r104.f274428e = r116;
        int r117 = this.f274442a.getFlexItemCount();
        boolean r315 = r110;
        int r105 = 0;
        int r106 = 0;
        int r118 = 0;
        int r119 = Integer.MIN_VALUE;
    L23:
        if (r115 >= r117) goto L187;
        int r120 = r118;
        View r121 = this.f274442a.l(r115);
        if (r121 == null) goto L27;
        int r212 = r105;
        if (r121.getVisibility() != 8) goto L47;
        int r107 = r104.f274432i + 1;
        r104.f274432i = r107;
        int r122 = r104.f274431h + 1;
        r104.f274431h = r122;
        if (r115 == (r117 - 1)) goto L40;
    L42:
        boolean r108 = false;
    L43:
        if (r108 == false) goto L45;
        a(r103, r104, r115, r106);
    L45:
        r101 = r101;
        int r109 = r102;
        int r213 = r114;
        r117 = r117;
        int r214 = r212;
        int r123 = r310;
        r103 = r103;
        boolean r124 = r315;
    L185:
        r115 = r115 + 1;
        r102 = r109;
        r315 = r124;
        r103 = r103;
        r118 = r120;
        r117 = r117;
        r101 = r101;
        r105 = r214;
        r114 = r213;
        goto L23
    L40:
        if ((r122 - r107) == 0) goto L42;
        r108 = true;
        goto L43
    L47:
        if ((r121 instanceof CompoundButton) == false) goto L62;
        CompoundButton r125 = (CompoundButton) r121;
        FlexItem r126 = (FlexItem) r125.getLayoutParams();
        int r127 = r126.getMinWidth();
        int r128 = r126.getMinHeight();
        Drawable r129 = CompoundButtonCompat.getButtonDrawable(r125);
        if (r129 != null) goto L51;
        int r215 = 0;
    L52:
        if (r129 != null) goto L54;
        int r130 = -1;
        int r216 = 0;
    L55:
        if (r127 != r130) goto L57;
        r127 = r215;
    L57:
        r126.a1(r127);
        if (r128 != r130) goto L60;
        r128 = r216;
    L60:
        r126.V0(r128);
        goto L62
    L54:
        r216 = r129.getMinimumHeight();
        r130 = -1;
        goto L55
    L51:
        r215 = r129.getMinimumWidth();
    L62:
        FlexItem r131 = (FlexItem) r121.getLayoutParams();
        if (r131.getAlignSelf() != 4) goto L65;
        ((ArrayList) r104.f274437n).add(Integer.valueOf(r115));
    L65:
        if (r100 == false) goto L67;
        int r132 = r131.getWidth();
    L69:
        if (r131.l0() != (-1.0f)) goto L71;
    L73:
        if (r100 == false) goto L75;
        int r133 = this.f274442a.m(r211, (r131.getMarginLeft() + r116) + r131.getMarginRight(), r132);
        r123 = r310;
        int r134 = this.f274442a.k(r123, (((r113 + r114) + r131.getMarginTop()) + r131.getMarginBottom()) + r106, r131.getHeight());
        r121.measure(r133, r134);
        v(r115, r133, r134, r121);
    L76:
        this.f274442a.n(r115, r121);
        c(r121, r115);
        int r135 = View.combineMeasuredStates(r212, r121.getMeasuredState());
        int r136 = r104.f274428e;
        if (r100 == false) goto L79;
        int r137 = r121.getMeasuredWidth();
    L80:
        if (r100 == false) goto L82;
        int r217 = r131.getMarginLeft();
    L83:
        int r138 = r137 + r217;
        if (r100 == false) goto L86;
        int r218 = r131.getMarginRight();
    L87:
        int r139 = r138 + r218;
        int r219 = r103.size();
        if (this.f274442a.getFlexWrap() != 0) goto L91;
    L94:
        r214 = r135;
        r213 = r114;
    L99:
        int r140 = r120;
        r109 = r102;
    L106:
        boolean r141 = false;
    L107:
        if (r141 == true) goto L109;
        r103 = r103;
        r104.f274431h++;
        int r142 = r140 + 1;
        int r143 = r119;
    L124:
        boolean r144 = r104.f274440q;
        if (r131.getFlexGrow() == 0.0f) goto L127;
        boolean r145 = true;
    L128:
        r104.f274440q = r144 | r145;
        boolean r146 = r104.f274441r;
        if (r131.getFlexShrink() == 0.0f) goto L131;
        boolean r147 = true;
    L132:
        r104.f274441r = r146 | r147;
        int[] r148 = this.f274444c;
        if (r148 == null) goto L135;
        r148[r115] = r103.size();
    L135:
        int r149 = r104.f274428e;
        if (r100 == false) goto L138;
        int r150 = r121.getMeasuredWidth();
    L139:
        if (r100 == false) goto L141;
        int r151 = r131.getMarginLeft();
    L142:
        int r152 = r150 + r151;
        if (r100 == false) goto L145;
        int r153 = r131.getMarginRight();
    L146:
        r104.f274428e = r149 + (r152 + r153);
        r104.f274433j += r131.getFlexGrow();
        r104.f274434k += r131.getFlexShrink();
        this.f274442a.j(r121, r115, r142, r104);
        if (r100 == false) goto L149;
        int r154 = r121.getMeasuredHeight();
    L150:
        if (r100 == false) goto L152;
        int r155 = r131.getMarginTop();
    L153:
        int r156 = r154 + r155;
        if (r100 == false) goto L156;
        int r157 = r131.getMarginBottom();
    L157:
        int r158 = Math.max(r143, (r156 + r157) + this.f274442a.h(r121));
        r104.f274430g = Math.max(r104.f274430g, r158);
        if (r100 == false) goto L164;
        if (this.f274442a.getFlexWrap() == 2) goto L162;
        r104.f274435l = Math.max(r104.f274435l, r121.getBaseline() + r131.getMarginTop());
        goto L164
    L162:
        r104.f274435l = Math.max(r104.f274435l, (r121.getMeasuredHeight() - r121.getBaseline()) + r131.getMarginBottom());
    L164:
        if (r115 == (r117 - 1)) goto L166;
    L168:
        boolean r159 = false;
    L169:
        if (r159 == false) goto L172;
        a(r103, r104, r115, r106);
        r106 = r106 + r104.f274430g;
    L172:
        if (r313 != (-1)) goto L174;
    L180:
        r124 = r315;
    L181:
        if (r106 <= r311) goto L184;
        if (r124 == false) goto L184;
        r105 = r214;
    L184:
        r119 = r158;
        r120 = r142;
        goto L185
    L174:
        if (r103.size() <= 0) goto L180;
        if (((com.google.android.flexbox.b) ListProtector.get(r103, r103.size() - 1)).f274439p < r313) goto L180;
        if (r115 < r313) goto L180;
        if (r315 == true) goto L180;
        r106 = -r104.f274430g;
        r124 = true;
        goto L181
    L166:
        if ((r104.f274431h - r104.f274432i) == 0) goto L168;
        r159 = true;
        goto L169
    L156:
        r157 = r131.getMarginRight();
        goto L157
    L152:
        r155 = r131.getMarginLeft();
        goto L153
    L149:
        r154 = r121.getMeasuredWidth();
        goto L150
    L145:
        r153 = r131.getMarginBottom();
        goto L146
    L141:
        r151 = r131.getMarginTop();
        goto L142
    L138:
        r150 = r121.getMeasuredHeight();
        goto L139
    L131:
        r147 = false;
        goto L132
    L127:
        r145 = false;
        goto L128
    L109:
        if ((r104.f274431h - r104.f274432i) <= 0) goto L114;
        if (r115 <= 0) goto L112;
        int r160 = r115 - 1;
    L113:
        a(r103, r104, r160, r106);
        r106 = r106 + r104.f274430g;
    L115:
        if (r100 == false) goto L120;
        if (r131.getHeight() != (-1)) goto L122;
        com.google.android.flexbox.a r161 = this.f274442a;
        r121.measure(r133, r161.k(r123, (((r161.getPaddingTop() + this.f274442a.getPaddingBottom()) + r131.getMarginTop()) + r131.getMarginBottom()) + r106, r131.getHeight()));
        c(r121, r115);
    L122:
        r104 = new com.google.android.flexbox.b();
        r104.f274431h = 1;
        r104.f274428e = r116;
        r104.f274438o = r115;
        r142 = 0;
        r143 = Integer.MIN_VALUE;
        goto L124
    L120:
        if (r131.getWidth() != (-1)) goto L122;
        com.google.android.flexbox.a r162 = this.f274442a;
        r121.measure(r162.m(r123, (((r162.getPaddingLeft() + this.f274442a.getPaddingRight()) + r131.getMarginLeft()) + r131.getMarginRight()) + r106, r131.getWidth()), r133);
        c(r121, r115);
        goto L122
    L112:
        r160 = 0;
        goto L113
    L114:
        r103 = r103;
        goto L115
    L91:
        if (r131.B1() == false) goto L93;
        r214 = r135;
        r213 = r114;
        r140 = r120;
        r109 = r102;
    L105:
        r141 = true;
        goto L107
    L93:
        if (r101 == 0) goto L94;
        int r163 = this.f274442a.getMaxLine();
        r214 = r135;
        r213 = r114;
        if (r163 != (-1)) goto L98;
    L100:
        r140 = r120;
        int r164 = this.f274442a.i(r121, r115, r140);
        if (r164 <= 0) goto L103;
        r139 = r139 + r164;
    L103:
        r109 = r102;
        if (r109 >= (r136 + r139)) goto L106;
    L98:
        if (r163 > (r219 + 1)) goto L100;
    L86:
        r218 = r131.getMarginBottom();
        goto L87
    L82:
        r217 = r131.getMarginTop();
        goto L83
    L79:
        r137 = r121.getMeasuredHeight();
        goto L80
    L75:
        r123 = r310;
        int r165 = this.f274442a.m(r123, (((r113 + r114) + r131.getMarginLeft()) + r131.getMarginRight()) + r106, r131.getWidth());
        r133 = this.f274442a.k(r211, (r131.getMarginTop() + r116) + r131.getMarginBottom(), r132);
        r121.measure(r165, r133);
        v(r115, r165, r133, r121);
        goto L76
    L71:
        if (r101 != 1073741824) goto L73;
        r132 = Math.round(r102 * r131.l0());
        goto L73
    L67:
        r132 = r131.getHeight();
        goto L69
    L27:
        if (r115 != (r117 - 1)) goto L31;
        r212 = r105;
        if ((r104.f274431h - r104.f274432i) == 0) goto L32;
        boolean r166 = true;
    L33:
        if (r166 == false) goto L45;
        a(r103, r104, r115, r106);
    L32:
        r166 = false;
        goto L33
    L31:
        r212 = r105;
    L187:
        r210.f274448b = r105;
        return;
    L21:
        r114 = this.f274442a.getPaddingEnd();
        goto L22
    L18:
        r113 = this.f274442a.getPaddingStart();
        goto L19
    L15:
        r112 = this.f274442a.getPaddingBottom();
        goto L16
    L12:
        r111 = this.f274442a.getPaddingTop();
        goto L13
    L9:
        r110 = false;
        goto L10
    L5:
        r103 = r314;
        goto L6
    }

    public final void p(View r100, com.google.android.flexbox.b r101, boolean r102, int r103, int r104, int r110, int r111) {
        FlexItem r105 = (FlexItem) r100.getLayoutParams();
        int r106 = this.f274442a.getAlignItems();
        if (r105.getAlignSelf() == (-1)) goto L5;
        r106 = r105.getAlignSelf();
    L5:
        int r107 = r101.f274430g;
        if (r106 != 0) goto L8;
    L23:
        if (r102 == true) goto L25;
        r100.layout(r103 + r105.getMarginLeft(), r104, r110 + r105.getMarginLeft(), r111);
        return;
    L25:
        r100.layout(r103 - r105.getMarginRight(), r104, r110 - r105.getMarginRight(), r111);
        return;
    L8:
        if (r106 != 1) goto L10;
        if (r102 == true) goto L22;
        r100.layout(((r103 + r107) - r100.getMeasuredWidth()) - r105.getMarginRight(), r104, ((r110 + r107) - r100.getMeasuredWidth()) - r105.getMarginRight(), r111);
        return;
    L22:
        r100.layout(((r103 - r107) + r100.getMeasuredWidth()) + r105.getMarginLeft(), r104, ((r110 - r107) + r100.getMeasuredWidth()) + r105.getMarginLeft(), r111);
        return;
    L10:
        if (r106 != 2) goto L12;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r100.getLayoutParams();
        int r109 = (((r107 - r100.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart(r108)) - MarginLayoutParamsCompat.getMarginEnd(r108)) / 2;
        if (r102 == true) goto L19;
        r100.layout(r103 + r109, r104, r110 + r109, r111);
        return;
    L19:
        r100.layout(r103 - r109, r104, r110 - r109, r111);
        return;
    L12:
        if (r106 == 3) goto L23;
        if (r106 == 4) goto L23;
    }
}
