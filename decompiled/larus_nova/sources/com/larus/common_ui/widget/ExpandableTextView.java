package com.larus.common_ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes27.dex */
public class ExpandableTextView extends AppCompatTextView {
    public static final /* synthetic */ int C = 0;
    public d A;
    public final Pattern B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f328434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f328435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f328436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f328437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f328438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f328439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f328440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f328441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f328442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f328443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f328444k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f328445l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f328446m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f328447n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f328448o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f328449p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f328450q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f328451r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public e f328452s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView.BufferType f328453t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextPaint f328454u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Layout f328455v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f328456w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f328457x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f328458y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence f328459z;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpandableTextView f328460a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.f328460a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ExpandableTextView r100 = this.f328460a;
            ExpandableTextView.y(r100, ExpandableTextView.x(r100), this.f328460a.f328453t);
        }

        public a(ExpandableTextView r100) {
            this.f328460a = r100;
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpandableTextView f328461a;

        public b(ExpandableTextView r100) {
            this.f328461a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ExpandableTextView.z(this.f328461a);
        }
    }

    public class c extends LinkMovementMethod {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f328462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ExpandableTextView f328463b;

        public c(ExpandableTextView r100) {
            this.f328463b = r100;
        }

        public static e a(TextView r100, Spannable r101, MotionEvent r102) {
            int r103 = (int) r102.getX();
            int r104 = (int) r102.getY();
            int r105 = r103 - r100.getTotalPaddingLeft();
            int r106 = r104 - r100.getTotalPaddingTop();
            int r107 = r105 + r100.getScrollX();
            int r108 = r106 + r100.getScrollY();
            Layout r109 = r100.getLayout();
            int r110 = r109.getOffsetForHorizontal(r109.getLineForVertical(r108), r107);
            e[] r111 = (e[]) r101.getSpans(r110, r110, e.class);
            if (r111.length > 0) goto L7;
            return null;
        L7:
            return r111[0];
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public final boolean onTouchEvent(TextView r100, Spannable r101, MotionEvent r102) {
            ExpandableTextView r103 = this.f328463b;
            int r104 = ExpandableTextView.C;
            r103.getClass();
            if (r102.getAction() != 0) goto L8;
            e r105 = a(r100, r101, r102);
            this.f328462a = r105;
            if (r105 == null) goto L17;
            r105.f328464a = true;
            Selection.setSelection(r101, r101.getSpanStart(r105), r101.getSpanEnd(this.f328462a));
        L17:
            return true;
        L8:
            if (r102.getAction() != 2) goto L13;
            e r106 = a(r100, r101, r102);
            e r107 = this.f328462a;
            if (r107 == null) goto L17;
            if (r106 == r107) goto L17;
            r107.f328464a = false;
            this.f328462a = null;
            Selection.removeSelection(r101);
            goto L17
        L13:
            e r108 = this.f328462a;
            if (r108 == null) goto L16;
            r108.f328464a = false;
            super.onTouchEvent(r100, r101, r102);
        L16:
            this.f328462a = null;
            Selection.removeSelection(r101);
            goto L17
        }
    }

    public interface d {
        void a(ExpandableTextView r100);

        void b();

        void c(ExpandableTextView r100);
    }

    public class e extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f328464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f328465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ExpandableTextView f328466c;

        public e(ExpandableTextView r100) {
            this.f328466c = r100;
            this.f328465b = 0;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            long r101 = System.currentTimeMillis();
            if ((r101 - this.f328465b) <= 300) goto L6;
            ExpandableTextView.z(this.f328466c);
            this.f328465b = r101;
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            super.updateDrawState(r100);
            ExpandableTextView r101 = this.f328466c;
            int r102 = r101.f328451r;
            if (r102 != 0) goto L5;
            r100.setColor(r101.f328445l);
            if (this.f328464a == false) goto L15;
            int r103 = this.f328466c.f328447n;
        L16:
            r100.bgColor = r103;
        L17:
            r100.setUnderlineText(false);
            return;
        L15:
            r103 = 0;
            goto L16
        L5:
            if (r102 != 1) goto L17;
            r100.setColor(r101.f328446m);
            if (this.f328464a == false) goto L10;
            int r104 = this.f328466c.f328448o;
        L11:
            r100.bgColor = r104;
            goto L17
        L10:
            r104 = 0;
            goto L11
        }
    }

    private CharSequence getNewTextByConfig() {
        if (TextUtils.isEmpty(this.f328459z) == false) goto L9;
        d r100 = this.A;
        if (r100 == null) goto L8;
        r100.b();
    L8:
        return this.f328459z;
    L9:
        Layout r101 = getLayout();
        this.f328455v = r101;
        if (r101 == null) goto L13;
        this.f328457x = r101.getWidth();
    L13:
        if (this.f328457x <= 0) goto L15;
    L25:
        this.f328454u = getPaint();
        this.f328456w = -1;
        int r102 = this.f328451r;
        String r103 = "";
        if (r102 == 0) goto L65;
        if (r102 == 1) goto L34;
        d r104 = this.A;
        if (r104 == null) goto L32;
        r104.b();
    L32:
        return this.f328459z;
    L34:
        if (this.f328443j == false) goto L36;
    L42:
        DynamicLayout r105 = new DynamicLayout(this.f328459z, this.f328454u, this.f328457x, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.f328455v = r105;
        int r106 = r105.getLineCount();
        this.f328456w = r106;
        if (r106 > this.f328444k) goto L49;
        d r107 = this.A;
        if (r107 == null) goto L48;
        r107.b();
    L48:
        return this.f328459z;
    L49:
        SpannableStringBuilder r108 = new SpannableStringBuilder(this.f328459z);
        if (this.f328443j == false) goto L57;
        SpannableStringBuilder r109 = r108.append(this.f328438e).append(this.f328436c);
        String r110 = this.f328440g;
        if (r110 == null) goto L55;
        r103 = r110;
    L55:
        r109.append(r103);
        int r111 = r108.length() - A(this.f328440g);
        r108.setSpan(this.f328452s, r111 - A(this.f328436c), r111, 33);
    L57:
        if (this.f328450q <= 0) goto L61;
        int r112 = this.f328456w - 1;
        int r113 = getValidLayout().getLineEnd(r112);
        if ((getValidLayout().getWidth() - ((int) (((double) this.f328454u.measureText(this.f328459z.subSequence(getValidLayout().getLineStart(r112), r113).toString())) + 0.5d))) >= this.f328450q) goto L61;
        r108.append("\r\n");
    L61:
        d r114 = this.A;
        if (r114 == null) goto L64;
        r114.b();
    L64:
        return r108;
    L36:
        if (this.f328450q != 0) goto L42;
        d r115 = this.A;
        if (r115 == null) goto L41;
        r115.b();
    L41:
        return this.f328459z;
    L65:
        DynamicLayout r116 = new DynamicLayout(this.f328459z, this.f328454u, this.f328457x, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.f328455v = r116;
        int r117 = r116.getLineCount();
        this.f328456w = r117;
        if (r117 > this.f328444k) goto L72;
        d r118 = this.A;
        if (r118 == null) goto L71;
        r118.b();
    L71:
        return this.f328459z;
    L72:
        int r119 = getValidLayout().getLineEnd(this.f328444k - 1);
        int r120 = getValidLayout().getLineStart(this.f328444k - 1);
        int r121 = r119 - A(this.f328434a);
        int r122 = 0;
        if (this.f328442i == false) goto L75;
        int r123 = (A(this.f328437d) + A(this.f328435b)) + A(this.f328439f);
    L76:
        int r124 = r121 - r123;
        if (r124 <= r120) goto L80;
        r119 = r124;
    L80:
        int r125 = getValidLayout().getWidth() - ((int) (((double) this.f328454u.measureText(this.f328459z.subSequence(r120, r119).toString())) + 0.5d));
        int r126 = this.f328449p;
        if (r126 <= 0) goto L83;
        int r127 = r126 + A(" ");
    L84:
        TextPaint r128 = this.f328454u;
        StringBuilder r129 = new StringBuilder();
        String r130 = this.f328434a;
        if (r130 != null) goto L87;
        r130 = "";
    L87:
        r129.append(r130);
        if (this.f328442i == false) goto L99;
        StringBuilder r131 = new StringBuilder();
        String r132 = this.f328437d;
        if (r132 != null) goto L92;
        r132 = "";
    L92:
        r131.append(r132);
        String r133 = this.f328435b;
        if (r133 != null) goto L95;
        r133 = "";
    L95:
        r131.append(r133);
        String r134 = this.f328439f;
        if (r134 != null) goto L98;
        r134 = "";
    L98:
        r131.append(r134);
        String r135 = r131.toString();
    L100:
        r129.append(r135);
        float r136 = r128.measureText(r129.toString()) + r127;
        float r137 = r125;
        if (r137 <= r136) goto L109;
        int r138 = 0;
        int r139 = 0;
    L104:
        if (r137 <= (r138 + r136)) goto L108;
        r139 = r139 + 1;
        int r140 = r119 + r139;
        if (r140 > this.f328459z.length()) goto L108;
        r138 = (int) (((double) this.f328454u.measureText(this.f328459z.subSequence(r119, r140).toString())) + 0.5d);
    L108:
        int r141 = r119 + (r139 - 1);
    L116:
        CharSequence r142 = this.f328459z;
        ArrayList r143 = new ArrayList();
        Matcher r144 = this.B.matcher(r142);
    L118:
        if (r144.find() == false) goto L120;
        r143.add(r144.group());
        goto L118
    L120:
        int r145 = 0;
        int r146 = 0;
    L121:
        if (r145 >= r141) goto L125;
        if (r146 >= r143.size()) goto L125;
        r145 = r145 + ((String) ListProtector.get(r143, r146)).length();
        r146 = r146 + 1;
    L125:
        CharSequence r147 = this.f328459z.subSequence(0, r145);
    L127:
        if (r147.toString().endsWith("\n") == false) goto L129;
        r147 = r147.subSequence(0, r147.length() - 1);
        goto L127
    L129:
        SpannableStringBuilder r148 = new SpannableStringBuilder(r147).append(this.f328434a);
        if (this.f328442i == false) goto L143;
        StringBuilder r149 = new StringBuilder();
        String r150 = this.f328437d;
        if (r150 != null) goto L134;
        r150 = "";
    L134:
        r149.append(r150);
        String r151 = this.f328435b;
        if (r151 != null) goto L137;
        r151 = "";
    L137:
        r149.append(r151);
        String r152 = this.f328439f;
        if (r152 == null) goto L141;
        r103 = r152;
    L141:
        r149.append(r103);
        r148.append(r149.toString());
        int r153 = r148.length() - A(this.f328439f);
        r148.setSpan(this.f328452s, r153 - A(this.f328435b), r153, 33);
    L143:
        if (this.f328449p <= 0) goto L147;
        int r154 = (this.f328449p / A(" ")) + 1;
    L145:
        if (r122 >= r154) goto L147;
        r148.append(" ");
        r122 = r122 + 1;
    L147:
        d r155 = this.A;
        if (r155 == null) goto L150;
        r155.b();
    L150:
        return r148;
    L109:
        int r156 = 0;
        int r157 = 0;
    L111:
        if ((r156 + r125) >= r136) goto L115;
        r157 = r157 - 1;
        int r158 = r119 + r157;
        if (r158 <= r120) goto L115;
        r156 = (int) (((double) this.f328454u.measureText(this.f328459z.subSequence(r158, r119).toString())) + 0.5d);
    L115:
        r141 = r119 + r157;
        goto L116
    L99:
        r135 = "";
        goto L100
    L83:
        r127 = 0;
        goto L84
    L75:
        r123 = 0;
        goto L76
    L15:
        if (getWidth() != 0) goto L24;
        int r159 = this.f328458y;
        if (r159 != 0) goto L23;
        d r160 = this.A;
        if (r160 == null) goto L22;
        r160.b();
    L22:
        return this.f328459z;
    L23:
        this.f328457x = (r159 - getPaddingLeft()) - getPaddingRight();
        goto L25
    L24:
        this.f328457x = (getWidth() - getPaddingLeft()) - getPaddingRight();
        goto L25
    }

    private Layout getValidLayout() {
        Layout r100 = this.f328455v;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return getLayout();
    }

    public final void init() {
        this.f328452s = new e(this);
        setMovementMethod(new c(this));
        if (TextUtils.isEmpty(this.f328434a) == false) goto L6;
        this.f328434a = DownloadConstants.VULNERABILITY_PATH;
    L6:
        if (this.f328441h == false) goto L8;
        setOnClickListener(new b(this));
    L8:
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public int getCurrentState() {
        return this.f328451r;
    }

    public int getExpandState() {
        return this.f328451r;
    }

    public ExpandableTextView(Context r100) {
        super(r100);
        this.f328437d = " ";
        this.f328438e = " ";
        this.f328439f = "";
        this.f328440g = "";
        this.f328441h = true;
        this.f328442i = true;
        this.f328443j = true;
        this.f328444k = 2;
        this.f328445l = -13330213;
        this.f328446m = -1618884;
        this.f328447n = 1436129689;
        this.f328448o = 1436129689;
        this.f328449p = 0;
        this.f328450q = 0;
        this.f328451r = 0;
        this.f328453t = TextView.BufferType.NORMAL;
        this.f328456w = -1;
        this.f328457x = 0;
        this.f328458y = 0;
        this.B = PatternProtector.compile("\\P{M}\\p{M}*+");
        init();
    }

    public static int A(String r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.length();
    }

    public static /* synthetic */ CharSequence x(ExpandableTextView r100) {
        return r100.getNewTextByConfig();
    }

    public static void z(ExpandableTextView r100) {
        int r101 = r100.f328451r;
        if (r101 == 0) goto L9;
        if (r101 != 1) goto L12;
        r100.f328451r = 0;
        d r102 = r100.A;
        if (r102 == null) goto L12;
        r102.a(r100);
    L12:
        super.setText(r100.getNewTextByConfig(), r100.f328453t);
        return;
    L9:
        r100.f328451r = 1;
        d r103 = r100.A;
        if (r103 == null) goto L12;
        r103.c(r100);
        goto L12
    }

    public void setCurrentState(int r100) {
        this.f328451r = r100;
    }

    public void setExpandListener(d r100) {
        this.A = r100;
    }

    public void setExtendRemianSpace(int r100) {
        this.f328449p = r100;
    }

    public ExpandableTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f328437d = " ";
        this.f328438e = " ";
        this.f328439f = "";
        this.f328440g = "";
        this.f328441h = true;
        this.f328442i = true;
        this.f328443j = true;
        this.f328444k = 2;
        this.f328445l = -13330213;
        this.f328446m = -1618884;
        this.f328447n = 1436129689;
        this.f328448o = 1436129689;
        this.f328449p = 0;
        this.f328450q = 0;
        this.f328451r = 0;
        this.f328453t = TextView.BufferType.NORMAL;
        this.f328456w = -1;
        this.f328457x = 0;
        this.f328458y = 0;
        this.B = PatternProtector.compile("\\P{M}\\p{M}*+");
        B(r100, r101);
        init();
    }

    public final void B(Context r100, AttributeSet r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_etv_EllipsisHint, R.attr.larus_etv_EnableToggle, R.attr.larus_etv_GapAfterExpandHint, R.attr.larus_etv_GapAfterShrinkHint, R.attr.larus_etv_GapToExpandHint, R.attr.larus_etv_GapToShrinkHint, R.attr.larus_etv_InitState, R.attr.larus_etv_MaxLinesOnShrink, R.attr.larus_etv_ToExpandEndRemianSpace, R.attr.larus_etv_ToExpandHint, R.attr.larus_etv_ToExpandHintColor, R.attr.larus_etv_ToExpandHintColorBgPressed, R.attr.larus_etv_ToExpandHintShow, R.attr.larus_etv_ToShrinkEndRemianSpace, R.attr.larus_etv_ToShrinkHint, R.attr.larus_etv_ToShrinkHintColor, R.attr.larus_etv_ToShrinkHintColorBgPressed, R.attr.larus_etv_ToShrinkHintShow});
        if (r102 != null) goto L7;
        return;
    L7:
        int r103 = r102.getIndexCount();
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L62;
        int r105 = r102.getIndex(r104);
        if (r105 != 7) goto L12;
        this.f328444k = r102.getInteger(r105, 2);
    L61:
        r104 = r104 + 1;
        goto L8
    L12:
        if (r105 != 0) goto L15;
        this.f328434a = r102.getString(r105);
        goto L61
    L15:
        if (r105 != 9) goto L18;
        this.f328435b = r102.getString(r105);
        goto L61
    L18:
        if (r105 != 14) goto L21;
        this.f328436c = r102.getString(r105);
        goto L61
    L21:
        if (r105 != 1) goto L24;
        this.f328441h = r102.getBoolean(r105, true);
        goto L61
    L24:
        if (r105 != 12) goto L27;
        this.f328442i = r102.getBoolean(r105, true);
        goto L61
    L27:
        if (r105 != 17) goto L30;
        this.f328443j = r102.getBoolean(r105, true);
        goto L61
    L30:
        if (r105 != 10) goto L33;
        this.f328445l = r102.getInteger(r105, -13330213);
        goto L61
    L33:
        if (r105 != 15) goto L36;
        this.f328446m = r102.getInteger(r105, -1618884);
        goto L61
    L36:
        if (r105 != 11) goto L39;
        this.f328447n = r102.getInteger(r105, 1436129689);
        goto L61
    L39:
        if (r105 != 16) goto L42;
        this.f328448o = r102.getInteger(r105, 1436129689);
        goto L61
    L42:
        if (r105 != 6) goto L45;
        this.f328451r = r102.getInteger(r105, 0);
        goto L61
    L45:
        if (r105 != 4) goto L48;
        this.f328437d = r102.getString(r105);
        goto L61
    L48:
        if (r105 != 5) goto L50;
        this.f328438e = r102.getString(r105);
        goto L61
    L50:
        if (r105 != 2) goto L53;
        this.f328439f = r102.getString(r105);
        goto L61
    L53:
        if (r105 != 3) goto L56;
        this.f328440g = r102.getString(r105);
        goto L61
    L56:
        if (r105 != 13) goto L59;
        this.f328449p = (int) r102.getDimension(r105, 0.0f);
        goto L61
    L59:
        if (r105 != 8) goto L61;
        this.f328450q = (int) r102.getDimension(r105, 0.0f);
        goto L61
    L62:
        r102.recycle();
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        this.f328459z = r100;
        this.f328453t = r101;
        super.setText(getNewTextByConfig(), r101);
    }

    public ExpandableTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f328437d = " ";
        this.f328438e = " ";
        this.f328439f = "";
        this.f328440g = "";
        this.f328441h = true;
        this.f328442i = true;
        this.f328443j = true;
        this.f328444k = 2;
        this.f328445l = -13330213;
        this.f328446m = -1618884;
        this.f328447n = 1436129689;
        this.f328448o = 1436129689;
        this.f328449p = 0;
        this.f328450q = 0;
        this.f328451r = 0;
        this.f328453t = TextView.BufferType.NORMAL;
        this.f328456w = -1;
        this.f328457x = 0;
        this.f328458y = 0;
        this.B = PatternProtector.compile("\\P{M}\\p{M}*+");
        B(r100, r101);
        init();
    }

    public static void y(ExpandableTextView r100, CharSequence r101, TextView.BufferType r102) {
        super.setText(r101, r102);
    }
}
