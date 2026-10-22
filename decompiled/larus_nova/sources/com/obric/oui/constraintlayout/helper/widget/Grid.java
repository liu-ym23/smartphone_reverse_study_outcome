package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.VirtualLayout;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes34.dex */
public class Grid extends VirtualLayout {
    public final Set<Integer> A;
    public int[] B;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View[] f399896l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ConstraintLayout f399897m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f399898n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f399899o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f399900p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f399901q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f399902r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f399903s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f399904t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f399905u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f399906v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f399907w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f399908x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f399909y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean[][] f399910z;

    private int getNextPosition() {
        boolean r100 = false;
        int r101 = 0;
    L3:
        if (r100 == true) goto L12;
        r101 = this.f399909y;
        if (r101 >= (this.f399898n * this.f399900p)) goto L6;
        int r102 = A(r101);
        int r103 = z(this.f399909y);
        boolean[] r104 = this.f399910z[r102];
        if (r104[r103] == false) goto L11;
        r104[r103] = false;
        r100 = true;
    L11:
        this.f399909y++;
        goto L3
    L6:
        return -1;
    L12:
        return r101;
    }

    public final void B() {
        int r100 = 0;
        boolean[][] r101 = (boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{this.f399898n, this.f399900p});
        this.f399910z = r101;
        int r102 = r101.length;
    L3:
        if (r100 >= r102) goto L5;
        Arrays.fill(r101[r100], true);
        r100 = r100 + 1;
        goto L3
    }

    public final View D() {
        View r100 = new View(getContext());
        r100.setId(View.generateViewId());
        r100.setVisibility(4);
        ConstraintLayout.LayoutParams r101 = new ConstraintLayout.LayoutParams(0, 0);
        this.f399897m.addView(r100, r101);
        return r100;
    }

    public final void H() {
        int r100 = this.f399899o;
        if (r100 == 0) goto L8;
        int r101 = this.f399901q;
        if (r101 == 0) goto L8;
        this.f399898n = r100;
        this.f399900p = r101;
        return;
    L8:
        int r102 = this.f399901q;
        if (r102 <= 0) goto L11;
        this.f399900p = r102;
        this.f399898n = ((this.f400378b + r102) - 1) / r102;
        return;
    L11:
        if (r100 <= 0) goto L13;
        this.f399898n = r100;
        this.f399900p = ((this.f400378b + r100) - 1) / r100;
        return;
    L13:
        int r103 = (int) (Math.sqrt(this.f400378b) + 1.5d);
        this.f399898n = r103;
        this.f399900p = ((this.f400378b + r103) - 1) / r103;
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f399897m = (ConstraintLayout) getParent();
        y(false);
    }

    public String getColumnWeights() {
        return this.f399905u;
    }

    public int getColumns() {
        return this.f399901q;
    }

    public float getHorizontalGaps() {
        return this.f399906v;
    }

    public int getOrientation() {
        return this.f399908x;
    }

    public String getRowWeights() {
        return this.f399904t;
    }

    public int getRows() {
        return this.f399899o;
    }

    public String getSkips() {
        return this.f399903s;
    }

    public String getSpans() {
        return this.f399902r;
    }

    public float getVerticalGaps() {
        return this.f399907w;
    }

    public Grid(Context r100) {
        super(r100);
        this.f399909y = 0;
        this.A = new HashSet();
    }

    public static ConstraintLayout.LayoutParams E(View r100) {
        return (ConstraintLayout.LayoutParams) r100.getLayoutParams();
    }

    public static int[][] F(String r100) {
        String[] r101 = r100.split(",");
        int[][] r102 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r101.length, 3});
        int r103 = 0;
    L4:
        if (r103 >= r101.length) goto L6;
        String[] r104 = r101[r103].trim().split(":");
        String[] r105 = r104[1].split("x");
        r102[r103][0] = CastIntegerProtector.parseInt(r104[0]);
        r102[r103][1] = CastIntegerProtector.parseInt(r105[0]);
        r102[r103][2] = CastIntegerProtector.parseInt(r105[1]);
        r103 = r103 + 1;
        goto L4
    L6:
        return r102;
    }

    public static void v(View r100) {
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) r100.getLayoutParams();
        r101.H = -1.0f;
        r101.f400413f = -1;
        r101.f400411e = -1;
        r101.f400415g = -1;
        r101.f400417h = -1;
        ((ViewGroup.MarginLayoutParams) r101).leftMargin = -1;
        r100.setLayoutParams(r101);
    }

    public static void w(View r100) {
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) r100.getLayoutParams();
        r101.I = -1.0f;
        r101.f400421j = -1;
        r101.f400419i = -1;
        r101.f400423k = -1;
        r101.f400425l = -1;
        ((ViewGroup.MarginLayoutParams) r101).topMargin = -1;
        r100.setLayoutParams(r101);
    }

    public final int A(int r100) {
        if (this.f399908x != 1) goto L7;
        return r100 % this.f399898n;
    L7:
        return r100 / this.f399900p;
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void n(AttributeSet r100) {
        super.n(r100);
        this.f400381e = true;
        if (r100 == null) goto L53;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.grid_columnWeights, R.attr.grid_columns, R.attr.grid_horizontalGaps, R.attr.grid_orientation, R.attr.grid_rowWeights, R.attr.grid_rows, R.attr.grid_skips, R.attr.grid_spans, R.attr.grid_useRtl, R.attr.grid_validateInputs, R.attr.grid_verticalGaps});
        int r102 = r101.getIndexCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L38;
        int r104 = r101.getIndex(r103);
        if (r104 != 5) goto L9;
        this.f399899o = r101.getInteger(r104, 0);
    L37:
        r103 = r103 + 1;
        goto L5
    L9:
        if (r104 != 1) goto L12;
        this.f399901q = r101.getInteger(r104, 0);
        goto L37
    L12:
        if (r104 != 7) goto L15;
        this.f399902r = r101.getString(r104);
        goto L37
    L15:
        if (r104 != 6) goto L18;
        this.f399903s = r101.getString(r104);
        goto L37
    L18:
        if (r104 != 4) goto L20;
        this.f399904t = r101.getString(r104);
        goto L37
    L20:
        if (r104 != 0) goto L23;
        this.f399905u = r101.getString(r104);
        goto L37
    L23:
        if (r104 != 3) goto L26;
        this.f399908x = r101.getInt(r104, 0);
        goto L37
    L26:
        if (r104 != 2) goto L29;
        this.f399906v = r101.getDimension(r104, 0.0f);
        goto L37
    L29:
        if (r104 != 10) goto L32;
        this.f399907w = r101.getDimension(r104, 0.0f);
        goto L37
    L32:
        if (r104 != 9) goto L35;
        r101.getBoolean(r104, false);
        goto L37
    L35:
        if (r104 != 8) goto L37;
        r101.getBoolean(r104, false);
        goto L37
    L38:
        H();
        B();
        r101.recycle();
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onDraw(Canvas r110) {
        if (isInEditMode() == true) goto L5;
        return;
    L5:
        Paint r100 = new Paint();
        r100.setColor(-65536);
        r100.setStyle(Paint.Style.STROKE);
        int r101 = getTop();
        int r102 = getLeft();
        int r103 = getBottom();
        int r111 = getRight();
        View[] r112 = this.f399896l;
        int r113 = r112.length;
        int r114 = 0;
    L6:
        if (r114 >= r113) goto L8;
        View r104 = r112[r114];
        int r105 = r104.getLeft() - r102;
        int r115 = r104.getTop() - r101;
        int r106 = r104.getRight() - r102;
        int r107 = r104.getBottom() - r101;
        r110.drawRect(r105, 0.0f, r106, r103 - r101, r100);
        r110.drawRect(0.0f, r115, r111 - r102, r107, r100);
        r114 = r114 + 1;
        r101 = r101;
        goto L6
    }

    public void setColumnWeights(String r100) {
        String r101 = this.f399905u;
        if (r101 != null) goto L5;
    L7:
        this.f399905u = r100;
        y(true);
        invalidate();
        return;
    L5:
        if (r101.equals(r100) == false) goto L7;
    }

    public void setColumns(int r100) {
        if (r100 <= 50) goto L6;
        return;
    L6:
        if (this.f399901q != r100) goto L8;
        return;
    L8:
        this.f399901q = r100;
        H();
        B();
        y(false);
        invalidate();
    }

    public void setHorizontalGaps(float r100) {
        if (r100 >= 0.0f) goto L6;
        return;
    L6:
        if (this.f399906v != r100) goto L8;
        return;
    L8:
        this.f399906v = r100;
        y(true);
        invalidate();
    }

    public void setOrientation(int r100) {
        if (r100 == 0) goto L7;
        if (r100 == 1) goto L7;
        return;
    L7:
        if (this.f399908x != r100) goto L9;
        return;
    L9:
        this.f399908x = r100;
        y(true);
        invalidate();
    }

    public void setRowWeights(String r100) {
        String r101 = this.f399904t;
        if (r101 != null) goto L5;
    L7:
        this.f399904t = r100;
        y(true);
        invalidate();
        return;
    L5:
        if (r101.equals(r100) == false) goto L7;
    }

    public void setRows(int r100) {
        if (r100 <= 50) goto L6;
        return;
    L6:
        if (this.f399899o != r100) goto L8;
        return;
    L8:
        this.f399899o = r100;
        H();
        B();
        y(false);
        invalidate();
    }

    public void setSkips(String r100) {
        String r101 = this.f399903s;
        if (r101 != null) goto L5;
    L7:
        this.f399903s = r100;
        y(true);
        invalidate();
        return;
    L5:
        if (r101.equals(r100) == false) goto L7;
    }

    public void setSpans(CharSequence r100) {
        String r101 = this.f399902r;
        if (r101 != null) goto L5;
    L7:
        this.f399902r = r100.toString();
        y(true);
        invalidate();
        return;
    L5:
        if (r101.contentEquals(r100) == false) goto L7;
    }

    public void setVerticalGaps(float r100) {
        if (r100 >= 0.0f) goto L6;
        return;
    L6:
        if (this.f399907w != r100) goto L8;
        return;
    L8:
        this.f399907w = r100;
        y(true);
        invalidate();
    }

    public final void y(boolean r110) {
        if (this.f399897m != null) goto L5;
        return;
    L5:
        if (this.f399898n >= 1) goto L7;
        return;
    L7:
        if (this.f399900p < 1) goto L149;
        int r100 = 0;
        if (r110 == false) goto L20;
        int r111 = 0;
    L13:
        if (r111 >= this.f399910z.length) goto L19;
        int r101 = 0;
    L15:
        boolean[][] r102 = this.f399910z;
        if (r101 >= r102[0].length) goto L18;
        r102[r111][r101] = true;
        r101 = r101 + 1;
        goto L15
    L18:
        r111 = r111 + 1;
        goto L13
    L19:
        ((HashSet) this.A).clear();
    L20:
        this.f399909y = 0;
        int r112 = Math.max(this.f399898n, this.f399900p);
        View[] r103 = this.f399896l;
        if (r103 != null) goto L27;
        this.f399896l = new View[r112];
        int r104 = 0;
    L23:
        View[] r105 = this.f399896l;
        if (r104 >= r105.length) goto L40;
        r105[r104] = D();
        r104 = r104 + 1;
    L40:
        this.B = new int[r112];
        int r113 = 0;
    L41:
        View[] r106 = this.f399896l;
        if (r113 >= r106.length) goto L44;
        this.B[r113] = r106[r113].getId();
        r113 = r113 + 1;
        goto L41
    L44:
        int r114 = getId();
        int r107 = Math.max(this.f399898n, this.f399900p);
        float[] r108 = G(this.f399898n, this.f399904t);
        if (this.f399898n != 1) goto L47;
        ConstraintLayout.LayoutParams r109 = E(this.f399896l[0]);
        w(this.f399896l[0]);
        r109.f400419i = r114;
        r109.f400425l = r114;
        this.f399896l[0].setLayoutParams(r109);
    L65:
        int r115 = getId();
        int r116 = Math.max(this.f399898n, this.f399900p);
        float[] r117 = G(this.f399900p, this.f399905u);
        ConstraintLayout.LayoutParams r118 = E(this.f399896l[0]);
        if (this.f399900p != 1) goto L68;
        v(this.f399896l[0]);
        r118.f400411e = r115;
        r118.f400417h = r115;
        this.f399896l[0].setLayoutParams(r118);
    L86:
        String r119 = this.f399903s;
        if (r119 != null) goto L89;
    L99:
        String r120 = this.f399902r;
        if (r120 != null) goto L102;
    L112:
        View[] r121 = m(this.f399897m);
    L114:
        if (r100 >= this.f400378b) goto L150;
        if (((HashSet) this.A).contains(Integer.valueOf(this.f400377a[r100])) == true) goto L122;
        int r122 = getNextPosition();
        int r123 = A(r122);
        int r124 = z(r122);
        if (r122 == (-1)) goto L151;
        x(r121[r100], r123, r124, 1, 1);
        goto L122
    L151:
        return;
    L122:
        r100 = r100 + 1;
        goto L114
    L150:
        return;
    L102:
        if (r120.trim().isEmpty() == true) goto L112;
        int[][] r125 = F(this.f399902r);
        if (r125 == null) goto L112;
        int[] r126 = this.f400377a;
        View[] r127 = m(this.f399897m);
        int r128 = 0;
    L107:
        if (r128 >= r125.length) goto L112;
        int r129 = A(r125[r128][0]);
        int r130 = z(r125[r128][0]);
        int[] r131 = r125[r128];
        if (C(r129, r130, r131[1], r131[2]) == false) goto L112;
        View r132 = r127[r128];
        int[] r133 = r125[r128];
        x(r132, r129, r130, r133[1], r133[2]);
        ((HashSet) this.A).add(Integer.valueOf(r126[r128]));
        r128 = r128 + 1;
        goto L107
    L89:
        if (r119.trim().isEmpty() == true) goto L99;
        int[][] r134 = F(this.f399903s);
        if (r134 == null) goto L99;
        int r135 = 0;
    L94:
        if (r135 >= r134.length) goto L99;
        int r136 = A(r134[r135][0]);
        int r137 = z(r134[r135][0]);
        int[] r138 = r134[r135];
        if (C(r136, r137, r138[1], r138[2]) == false) goto L99;
        r135 = r135 + 1;
        goto L94
    L68:
        int r139 = 0;
    L69:
        int r140 = this.f399900p;
        if (r139 >= r140) goto L84;
        ConstraintLayout.LayoutParams r141 = E(this.f399896l[r139]);
        v(this.f399896l[r139]);
        if (r117 == null) goto L74;
        r141.H = r117[r139];
    L74:
        if (r139 <= 0) goto L76;
        r141.f400413f = this.B[r139 - 1];
    L78:
        if (r139 >= (this.f399900p - 1)) goto L80;
        r141.f400415g = this.B[r139 + 1];
    L81:
        if (r139 <= 0) goto L83;
        ((ViewGroup.MarginLayoutParams) r141).leftMargin = (int) this.f399906v;
    L83:
        this.f399896l[r139].setLayoutParams(r141);
        r139 = r139 + 1;
        goto L69
    L80:
        r141.f400417h = r115;
        goto L81
    L76:
        r141.f400411e = r115;
    L84:
        if (r140 >= r116) goto L86;
        ConstraintLayout.LayoutParams r142 = E(this.f399896l[r140]);
        v(this.f399896l[r140]);
        r142.f400411e = r115;
        r142.f400417h = r115;
        this.f399896l[r140].setLayoutParams(r142);
        r140 = r140 + 1;
        goto L84
    L47:
        int r143 = 0;
    L48:
        int r144 = this.f399898n;
        if (r143 >= r144) goto L63;
        ConstraintLayout.LayoutParams r145 = E(this.f399896l[r143]);
        w(this.f399896l[r143]);
        if (r108 == null) goto L53;
        r145.I = r108[r143];
    L53:
        if (r143 <= 0) goto L55;
        r145.f400421j = this.B[r143 - 1];
    L57:
        if (r143 >= (this.f399898n - 1)) goto L59;
        r145.f400423k = this.B[r143 + 1];
    L60:
        if (r143 <= 0) goto L62;
        ((ViewGroup.MarginLayoutParams) r145).topMargin = (int) this.f399906v;
    L62:
        this.f399896l[r143].setLayoutParams(r145);
        r143 = r143 + 1;
        goto L48
    L59:
        r145.f400425l = r114;
        goto L60
    L55:
        r145.f400419i = r114;
    L63:
        if (r144 >= r107) goto L65;
        ConstraintLayout.LayoutParams r146 = E(this.f399896l[r144]);
        w(this.f399896l[r144]);
        r146.f400419i = r114;
        r146.f400425l = r114;
        this.f399896l[r144].setLayoutParams(r146);
        r144 = r144 + 1;
        goto L63
    L27:
        if (r112 == r103.length) goto L40;
        View[] r147 = new View[r112];
        int r148 = 0;
    L29:
        if (r148 >= r112) goto L35;
        View[] r149 = this.f399896l;
        if (r148 >= r149.length) goto L33;
        r147[r148] = r149[r148];
    L34:
        r148 = r148 + 1;
        goto L29
    L33:
        r147[r148] = D();
        goto L34
    L35:
        int r150 = r112;
    L36:
        View[] r151 = this.f399896l;
        if (r150 >= r151.length) goto L39;
        this.f399897m.removeView(r151[r150]);
        r150 = r150 + 1;
        goto L36
    L39:
        this.f399896l = r147;
        goto L40
    }

    public final int z(int r100) {
        if (this.f399908x != 1) goto L7;
        return r100 / this.f399898n;
    L7:
        return r100 % this.f399900p;
    }

    public Grid(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f399909y = 0;
        this.A = new HashSet();
    }

    public static float[] G(int r100, String r101) {
        float[] r102 = null;
        if (r101 != null) goto L5;
    L13:
        return r102;
    L5:
        if (r101.trim().isEmpty() == true) goto L13;
        String[] r103 = r101.split(",");
        if (r103.length == r100) goto L10;
        return null;
    L10:
        r102 = new float[r100];
        int r104 = 0;
    L11:
        if (r104 >= r100) goto L13;
        r102[r104] = CastFloatProtector.parseFloat(r103[r104].trim());
        r104 = r104 + 1;
        goto L11
    }

    public Grid(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f399909y = 0;
        this.A = new HashSet();
    }

    public final boolean C(int r100, int r101, int r102, int r103) {
        int r104 = r100;
    L4:
        if (r104 >= (r100 + r102)) goto L18;
        int r105 = r101;
    L7:
        if (r105 >= (r101 + r103)) goto L17;
        boolean[][] r106 = this.f399910z;
        if (r104 >= r106.length) goto L16;
        if (r105 >= r106[0].length) goto L16;
        boolean[] r107 = r106[r104];
        if (r107[r105] == false) goto L16;
        r107[r105] = false;
        r105 = r105 + 1;
    L16:
        return false;
    L17:
        r104 = r104 + 1;
        goto L4
    L18:
        return true;
    }

    public final void x(View r100, int r101, int r102, int r103, int r104) {
        ConstraintLayout.LayoutParams r105 = (ConstraintLayout.LayoutParams) r100.getLayoutParams();
        int[] r106 = this.B;
        r105.f400411e = r106[r102];
        r105.f400419i = r106[r101];
        r105.f400417h = r106[(r102 + r104) - 1];
        r105.f400425l = r106[(r101 + r103) - 1];
        r100.setLayoutParams(r105);
    }
}
