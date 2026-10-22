package com.ss.android.lark.imageocr.select;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.imageocr.view.OCRPickTextView;
import com.ss.android.lark.imagewidget.ImageWidgetFG;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f426497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f426498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f426499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.imageocr.select.c f426500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f426501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SelectTextView f426502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Spannable f426503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f426504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f426505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f426506j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f426507k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Rect f426508l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Rect f426509m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<com.ss.android.lark.imageocr.select.b> f426510n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f426511o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f426512p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f426513q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public k f426514r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public l f426515s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RunnableC5048e f426516t;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SelectTextView f426517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f426518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f426519c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f426520d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List<com.ss.android.lark.imageocr.select.b> f426521e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f426522f;

        public a(OCRPickTextView r100) {
            Intrinsics.checkNotNullParameter(r100, "mTextView");
            this.f426517a = r100;
            this.f426518b = -15500842;
            this.f426519c = 24.0f;
            this.f426520d = -5250572;
        }
    }

    public static final class b {
    }

    public final class c extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f426523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PopupWindow f426524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f426525c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f426526d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f426527e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f426528f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f426529g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f426530h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f426531i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f426532j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f426533k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int[] f426534l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ e f426535m;

        public final int a() {
            return (this.f426534l[0] - this.f426529g) + this.f426535m.f426502f.getPaddingLeft();
        }

        public final void c() {
            this.f426535m.f426502f.getLocationInWindow(this.f426534l);
            Layout r100 = this.f426535m.f426502f.getLayout();
            if (this.f426523a == false) goto L13;
            PopupWindow r101 = this.f426524b;
            int r102 = (((int) r100.getPrimaryHorizontal(this.f426535m.f426500d.f426493a)) - this.f426527e) + a();
            int r103 = r100.getLineBottom(r100.getLineForOffset(this.f426535m.f426500d.f426493a)) + (this.f426534l[1] + this.f426535m.f426502f.getPaddingTop());
            if ((r101 instanceof PopupWindow) == false) goto L10;
            if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r101) == false) goto L10;
            r101.update(r102, r103, -1, -1);
            return;
        L10:
            if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r101, r102, r103, -1, -1) == true) goto L26;
            r101.update(r102, r103, -1, -1);
            return;
        L26:
            return;
        L13:
            PopupWindow r104 = this.f426524b;
            int r105 = ((int) r100.getPrimaryHorizontal(this.f426535m.f426500d.f426494b)) + a();
            int r106 = r100.getLineBottom(r100.getLineForOffset(this.f426535m.f426500d.f426494b)) + (this.f426534l[1] + this.f426535m.f426502f.getPaddingTop());
            if ((r104 instanceof PopupWindow) == false) goto L19;
            if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r104) == false) goto L19;
            r104.update(r105, r106, -1, -1);
            return;
        L19:
            if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r104, r105, r106, -1, -1) == true) goto L27;
            r104.update(r105, r106, -1, -1);
            return;
        }

        @Override // android.view.View
        public final void onDraw(Canvas r110) {
            Intrinsics.checkNotNullParameter(r110, "canvas");
            int r100 = this.f426526d;
            r110.drawCircle(this.f426529g + r100, r100, r100, this.f426525c);
            if (this.f426523a == false) goto L5;
            int r101 = this.f426526d;
            int r102 = this.f426529g;
            r110.drawRect(r101 + r102, 0.0f, (r101 * 2) + r102, r101, this.f426525c);
            return;
        L5:
            int r103 = this.f426529g;
            int r104 = this.f426526d;
            r110.drawRect(r103, 0.0f, r103 + r104, r104, this.f426525c);
        }

        @Override // android.view.View
        public final boolean onTouchEvent(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            int r101 = r100.getAction();
            if (r101 == 0) goto L17;
            if (r101 != 1) goto L6;
        L14:
            d r102 = this.f426535m.f426499c;
            if (r102 == null) goto L18;
            r102.a();
        L18:
            return true;
        L6:
            if (r101 != 2) goto L8;
            d r103 = this.f426535m.f426499c;
            if (r103 == null) goto L13;
            PopupWindow r104 = r103.f426536a;
            PopupWindowLancet.handleDismissBeforeOrigin(r104);
            r104.dismiss();
        L13:
            int r105 = (int) r100.getRawX();
            int r106 = (int) r100.getRawY();
            update((r105 + this.f426530h) - this.f426527e, (r106 + this.f426531i) - this.f426528f);
            goto L18
        L8:
            if (r101 == 3) goto L14;
        L17:
            com.ss.android.lark.imageocr.select.c r107 = this.f426535m.f426500d;
            this.f426532j = r107.f426493a;
            this.f426533k = r107.f426494b;
            this.f426530h = (int) r100.getX();
            this.f426531i = (int) r100.getY();
            goto L18
        }

        public c(e r100, boolean r101) {
            this.f426535m = r100;
            super(r100.f426501e);
            this.f426523a = r101;
            Paint r102 = new Paint(1);
            this.f426525c = r102;
            int r103 = r100.f426507k / 2;
            this.f426526d = r103;
            int r104 = r103 * 2;
            this.f426527e = r104;
            int r105 = r103 * 2;
            this.f426528f = r105;
            this.f426529g = 25;
            this.f426534l = new int[2];
            r102.setColor(r100.f426506j);
            PopupWindow r106 = new PopupWindow(this);
            this.f426524b = r106;
            r106.setClippingEnabled(false);
            r106.setWidth(r104 + (25 * 2));
            r106.setHeight(r105 + (25 / 2));
            invalidate();
        }

        public final void b(int r110, int r111) {
            this.f426535m.f426502f.getLocationInWindow(this.f426534l);
            if (this.f426523a == false) goto L5;
            int r100 = this.f426527e;
        L6:
            int r112 = (r110 - r100) + a();
            boolean r101 = true;
            int r113 = r111 + (this.f426534l[1] + this.f426535m.f426502f.getPaddingTop());
            Rect r102 = this.f426535m.f426509m;
            if (r102 != null) goto L9;
        L13:
            PopupWindow r103 = this.f426524b;
            SelectTextView r104 = this.f426535m.f426502f;
            if (PopupWindowLancet.hasSubWindowToken(r104) == false) goto L17;
            return;
        L17:
            if ((r103 instanceof PopupWindow) == true) goto L19;
        L21:
            OverlaySource r105 = PopupWindowLancet.resolveSource(r104);
            if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r103, r104, r105, 0, r112, r113) == true) goto L29;
            r103.showAtLocation(r104, 0, r112, r113);
            PopupWindowLancet.trackAfterShow(r103, r105, r104);
            return;
        L29:
            return;
        L19:
            if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r103) == false) goto L21;
            r103.showAtLocation(r104, 0, r112, r113);
            return;
        L9:
            if (r102.contains(r112, r113) == true) goto L12;
            r101 = false;
        L12:
            if (r101 == true) goto L13;
            return;
        L5:
            r100 = 0;
            goto L6
        }

        public final void update(int r110, int r111) {
            this.f426535m.f426502f.getLocationOnScreen(this.f426534l);
            if (this.f426523a == false) goto L5;
            int r100 = this.f426535m.f426500d.f426493a;
        L6:
            int[] r101 = this.f426534l;
            boolean r102 = false;
            int r112 = r110 - r101[0];
            int r113 = (r111 - r101[1]) - this.f426535m.f426502f.getLineHeight();
            SelectTextView r103 = this.f426535m.f426502f;
            int r104 = com.ss.android.lark.imageocr.select.d.f426496a;
            Intrinsics.checkNotNullParameter(r103, "textView");
            Layout r105 = r103.getLayout();
            if (r105 != null) goto L9;
            int r114 = -1;
        L41:
            if (r114 == r100) goto L74;
            e r115 = this.f426535m;
            r115.f426500d.f426495c = null;
            SelectTextView r116 = r115.f426502f;
            r116.f426484b = -1;
            r116.f426485c = -1;
            r116.invalidate();
            boolean r117 = this.f426523a;
            if (r117 == false) goto L58;
            int r106 = this.f426533k;
            if (r114 <= r106) goto L55;
            e r107 = this.f426535m;
            c r108 = r107.f426497a;
            if (r108 != null) goto L49;
        L51:
            if (r102 == true) goto L54;
            r108 = r107.f426498b;
        L54:
            this.f426523a = !r117;
            invalidate();
            Intrinsics.checkNotNull(r108);
            r108.f426523a = !r108.f426523a;
            r108.invalidate();
            int r118 = this.f426533k;
            this.f426532j = r118;
            this.f426535m.c(r118, r114);
            r108.c();
        L72:
            c();
            return;
        L49:
            if (r108.f426523a == true) goto L51;
            r102 = true;
            goto L51
        L55:
            if (r114 != r106) goto L57;
            this.f426535m.c(r114 - 1, r106);
            goto L72
        L57:
            this.f426535m.c(r114, r106);
            goto L72
        L58:
            int r119 = this.f426532j;
            if (r114 >= r119) goto L69;
            e r120 = this.f426535m;
            c r109 = r120.f426497a;
            if (r109 != null) goto L63;
        L65:
            if (r102 == true) goto L68;
            r109 = r120.f426498b;
        L68:
            Intrinsics.checkNotNull(r109);
            r109.f426523a = !r109.f426523a;
            r109.invalidate();
            this.f426523a = !this.f426523a;
            invalidate();
            int r121 = this.f426532j;
            this.f426533k = r121;
            this.f426535m.c(r114, r121);
            r109.c();
            goto L72
        L63:
            if (r109.f426523a != true) goto L65;
            r102 = true;
            goto L65
        L69:
            if (r119 != r114) goto L71;
            this.f426535m.c(r119, r114 + 1);
            goto L72
        L71:
            this.f426535m.c(r119, r114);
            goto L72
        L74:
            return;
        L9:
            int r122 = r105.getLineForVertical(r113);
            if (r100 > 0) goto L12;
        L14:
            boolean r123 = false;
        L15:
            if (r123 == false) goto L19;
            int r124 = r100 - 1;
            int r125 = (int) r105.getPrimaryHorizontal(r124);
            int r126 = (int) r105.getLineRight(r122);
            if (r112 <= (r126 - ((r126 - r125) / 2))) goto L19;
        L20:
            int r127 = r105.getLineForOffset(r124);
            int r128 = r105.getLineTop(r127);
            int r129 = r105.getLineBottom(r127);
            int r130 = (r129 - r128) / 2;
            if (r122 != (r127 + 1)) goto L25;
            if ((r113 - r129) >= r130) goto L25;
        L28:
            r122 = r127;
        L29:
            r114 = r105.getOffsetForHorizontal(r122, r112);
            if (r114 >= (r103.getText().length() - 1)) goto L41;
            int r131 = r114 + 1;
            if (r131 > 0) goto L34;
        L36:
            boolean r132 = false;
        L37:
            if (r132 == false) goto L41;
            int r133 = (int) r105.getPrimaryHorizontal(r114);
            int r134 = (int) r105.getLineRight(r122);
            if (r112 <= (r134 - ((r134 - r133) / 2))) goto L41;
            r114 = r131;
            goto L41
        L34:
            if (r105.getLineForOffset(r131) != (r105.getLineForOffset(r131 - 1) + 1)) goto L36;
            r132 = true;
        L25:
            if (r122 != (r127 - 1)) goto L29;
            if ((r128 - r113) >= r130) goto L29;
        L19:
            r124 = r100;
            goto L20
        L12:
            if (r105.getLineForOffset(r100) != (r105.getLineForOffset(r100 - 1) + 1)) goto L14;
            r123 = true;
            goto L15
        L5:
            r100 = this.f426535m.f426500d.f426494b;
            goto L6
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PopupWindow f426536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f426537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f426538c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f426539d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f426540e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ e f426541f;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.ss.android.lark.imageocr.select.b f426542a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f426543b;

            public a(com.ss.android.lark.imageocr.select.b r100, e r101) {
                this.f426542a = r100;
                this.f426543b = r101;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                com.ss.android.lark.imageocr.select.b r101 = this.f426542a;
                r101.f426492c.a(r101.f426490a, this.f426543b.f426500d.f426495c);
                this.f426543b.b();
            }
        }

        public final void a() {
            this.f426541f.f426502f.getLocationInWindow(this.f426537b);
            Layout r100 = this.f426541f.f426502f.getLayout();
            Layout r101 = this.f426541f.f426502f.getLayout();
            boolean r102 = true;
            float r103 = 0.0f;
            if (r101 == null) goto L16;
            com.ss.android.lark.imageocr.select.c r104 = this.f426541f.f426500d;
            int r105 = r104.f426493a + 1;
            int r106 = r104.f426494b;
            if (r105 > r106) goto L16;
        L8:
            if (r101.getLineForOffset(r105) != r101.getLineForOffset(this.f426541f.f426500d.f426493a)) goto L16;
            float r107 = r101.getPrimaryHorizontal(r105) - r101.getPrimaryHorizontal(this.f426541f.f426500d.f426493a);
            if (r107 <= r103) goto L14;
            r103 = r107;
        L14:
            if (r105 == r106) goto L16;
            r105 = r105 + 1;
        L13:
            Log.e("TextViewSelectHelper", "getPrimaryHorizontal failed");
        L16:
            int r108 = (((int) r100.getPrimaryHorizontal(this.f426541f.f426500d.f426493a)) - ((int) ((this.f426538c - r103) / 2))) + this.f426537b[0];
            int r109 = ((r100.getLineTop(r100.getLineForOffset(this.f426541f.f426500d.f426493a)) + this.f426537b[1]) - this.f426539d) - 16;
            if (r108 > 0) goto L20;
            r108 = 16;
        L20:
            if (ImageWidgetFG.a() == false) goto L24;
            int r110 = this.f426538c;
            int r111 = r108 + r110;
            int r112 = this.f426540e;
            if (r111 <= (r112 - 16)) goto L27;
            r108 = (r112 - r110) - 16;
        L27:
            this.f426536a.setElevation(8.0f);
            Rect r113 = this.f426541f.f426508l;
            if (r113 != null) goto L30;
        L34:
            PopupWindow r114 = this.f426536a;
            SelectTextView r115 = this.f426541f.f426502f;
            if (PopupWindowLancet.hasSubWindowToken(r115) == false) goto L38;
            return;
        L38:
            if ((r114 instanceof PopupWindow) == true) goto L40;
        L42:
            OverlaySource r116 = PopupWindowLancet.resolveSource(r115);
            if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r114, r115, r116, 0, r108, r109) == true) goto L54;
            r114.showAtLocation(r115, 0, r108, r109);
            PopupWindowLancet.trackAfterShow(r114, r116, r115);
            return;
        L54:
            return;
        L40:
            if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r114) == false) goto L42;
            r114.showAtLocation(r115, 0, r108, r109);
            return;
        L30:
            if (r113.contains(r108, r109) == true) goto L33;
            r102 = false;
        L33:
            if (r102 == true) goto L34;
            return;
        L24:
            int r117 = this.f426538c + r108;
            Context r118 = this.f426541f.f426501e;
            int r119 = com.ss.android.lark.imageocr.select.d.f426496a;
            Intrinsics.checkNotNullParameter(r118, PerfLog.PARAM_KEY_CONTEXT_ID);
            Resources r120 = r118.getResources();
            if (r117 <= (WindowDisplayMetricsOverride.apply(r120, r120.getDisplayMetrics()).widthPixels - 16)) goto L27;
            Context r121 = this.f426541f.f426501e;
            Intrinsics.checkNotNullParameter(r121, PerfLog.PARAM_KEY_CONTEXT_ID);
            Resources r122 = r121.getResources();
            r108 = (WindowDisplayMetricsOverride.apply(r122, r122.getDisplayMetrics()).widthPixels - this.f426538c) - 16;
            goto L27
        }

        public d(e r110, Context r111) {
            this.f426541f = r110;
            this.f426537b = new int[2];
            View r100 = LayoutInflater.from(r111).inflate(R.layout.text_select_operate_window_layout, null);
            ViewGroup r101 = (ViewGroup) r100.findViewById(R.id.image_ocr_operate_list_view);
            List<com.ss.android.lark.imageocr.select.b> r112 = r110.f426510n;
            Intrinsics.checkNotNull(r112);
            int r113 = r112.size();
            int r102 = 0;
        L3:
            if (r102 >= r113) goto L9;
            com.ss.android.lark.imageocr.select.b r103 = (com.ss.android.lark.imageocr.select.b) ListProtector.get(this.f426541f.f426510n, r102);
            View r104 = LayoutInflater.from(r111).inflate(R.layout.text_select_operate_action_layout, null);
            TextView r105 = (TextView) r104.findViewById(R.id.image_ocr_selection_action_name);
            View r106 = r104.findViewById(R.id.image_ocr_selection_action_split);
            r105.setText(r103.f426491b);
            if (r102 == (this.f426541f.f426510n.size() - 1)) goto L7;
            int r107 = 0;
        L8:
            r106.setVisibility(r107);
            r104.setOnClickListener(new a(r103, this.f426541f));
            r101.addView(r104);
            r102 = r102 + 1;
            goto L3
        L7:
            r107 = 8;
            goto L8
        L9:
            r100.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f426538c = r100.getMeasuredWidth();
            this.f426539d = r100.getMeasuredHeight();
            PopupWindow r114 = new PopupWindow(r100, -2, -2, false);
            this.f426536a = r114;
            r114.setClippingEnabled(false);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.imageocr.select.e$e, reason: collision with other inner class name */
    public static final class RunnableC5048e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f426544a;

        public RunnableC5048e(e r100) {
            this.f426544a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e r100 = this.f426544a;     // Catch: Throwable -> L15
            if (r100.f426513q == true) goto L18;
            d r101 = r100.f426499c;     // Catch: Throwable -> L15
            if (r101 == null) goto L8;
            r101.a();     // Catch: Throwable -> L15
        L8:
            e r102 = this.f426544a;     // Catch: Throwable -> L15
            c r103 = r102.f426497a;     // Catch: Throwable -> L15
            if (r103 == null) goto L11;
            Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L15
            r102.d(r103);     // Catch: Throwable -> L15
        L11:
            e r104 = this.f426544a;     // Catch: Throwable -> L15
            c r105 = r104.f426498b;     // Catch: Throwable -> L15
            if (r105 == null) goto L22;
            Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L15
            r104.d(r105);     // Catch: Throwable -> L15
            return;
        L22:
            return;
        L18:
            return;
        L15:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L23;
            throw th;
        }
    }

    static {
    }

    public final void b() {
        this.f426500d.f426495c = null;
        SelectTextView r100 = this.f426502f;
        r100.f426484b = -1;
        r100.f426485c = -1;
        r100.invalidate();
        this.f426513q = true;
        c r101 = this.f426497a;
        if (r101 == null) goto L5;
        PopupWindow r102 = r101.f426524b;
        PopupWindowLancet.handleDismissBeforeOrigin(r102);
        r102.dismiss();
    L5:
        c r103 = this.f426498b;
        if (r103 == null) goto L8;
        PopupWindow r104 = r103.f426524b;
        PopupWindowLancet.handleDismissBeforeOrigin(r104);
        r104.dismiss();
    L8:
        d r105 = this.f426499c;
        if (r105 == null) goto L12;
        PopupWindow r106 = r105.f426536a;
        PopupWindowLancet.handleDismissBeforeOrigin(r106);
        r106.dismiss();
        return;
    }

    public e(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f426500d = new com.ss.android.lark.imageocr.select.c();
        this.f426513q = true;
        this.f426516t = new RunnableC5048e(this);
        SelectTextView r101 = r100.f426517a;
        this.f426502f = r101;
        r101.setSelectionColor(r100.f426520d);
        Context r102 = r101.getContext();
        this.f426501e = r102;
        this.f426506j = r100.f426518b;
        float r103 = r100.f426519c;
        int r104 = com.ss.android.lark.imageocr.select.d.f426496a;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r105 = r102.getResources();
        this.f426507k = (int) ((r103 * WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density) + 0.5f);
        this.f426510n = r100.f426521e;
        this.f426511o = r100.f426522f;
    }

    public final void d(c r100) {
        Layout r101 = this.f426502f.getLayout();
        if (r100.f426523a == false) goto L5;
        int r102 = this.f426500d.f426493a;
    L11:
        r100.b((int) r101.getPrimaryHorizontal(r102), r101.getLineBottom(r101.getLineForOffset(r102)));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e("TextViewSelectHelper", "show cursor exception:" + e);
        return;
    L5:
        r102 = this.f426500d.f426494b;
        goto L11
    }

    public final void c(int r100, int r101) {
        StringBuilder r102 = new StringBuilder("totalSize:");
        Spannable r103 = this.f426503g;
        if (r103 == null) goto L5;
        Integer r104 = Integer.valueOf(r103.length());
    L6:
        r102.append(r104);
        r102.append(", startPos:");
        r102.append(r100);
        r102.append(", endPos:");
        r102.append(r101);
        Log.d("TextViewSelectHelper", r102.toString());
        Spannable r105 = this.f426503g;
        if (r105 != null) goto L9;
        return;
    L9:
        if (r100 < 0) goto L13;
        Intrinsics.checkNotNull(r105);
        if (r100 >= r105.length()) goto L13;
        this.f426500d.f426493a = r100;
    L13:
        if (r101 <= 0) goto L17;
        Spannable r106 = this.f426503g;
        Intrinsics.checkNotNull(r106);
        if (r101 > r106.length()) goto L17;
        this.f426500d.f426494b = r101;
    L17:
        com.ss.android.lark.imageocr.select.c r107 = this.f426500d;
        int r108 = r107.f426493a;
        int r109 = r107.f426494b;
        if (r108 <= r109) goto L20;
        r107.f426493a = r109;
        r107.f426494b = r108;
    L20:
        int r110 = r107.f426493a;
        if (r110 < 0) goto L30;
        Spannable r111 = this.f426503g;
        Intrinsics.checkNotNull(r111);
        if (r110 >= r111.length()) goto L31;
        int r112 = this.f426500d.f426494b;
        if (r112 <= 0) goto L32;
        Spannable r113 = this.f426503g;
        Intrinsics.checkNotNull(r113);
        if (r112 > r113.length()) goto L33;
        com.ss.android.lark.imageocr.select.c r114 = this.f426500d;
        Spannable r115 = this.f426503g;
        Intrinsics.checkNotNull(r115);
        com.ss.android.lark.imageocr.select.c r116 = this.f426500d;
        r114.f426495c = r115.subSequence(r116.f426493a, r116.f426494b).toString();
        SelectTextView r117 = this.f426502f;
        com.ss.android.lark.imageocr.select.c r118 = this.f426500d;
        int r119 = r118.f426493a;
        int r120 = r118.f426494b;
        r117.f426484b = r119;
        r117.f426485c = r120;
        r117.invalidate();
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static final void a(e r100, int r101, int r102) {
        r100.b();
        r100.f426513q = false;
        if (r100.f426499c != null) goto L6;
        r100.f426499c = new d(r100, r100.f426501e);
    L6:
        if (r100.f426497a != null) goto L9;
        r100.f426497a = new c(r100, true);
    L9:
        if (r100.f426498b != null) goto L11;
        r100.f426498b = new c(r100, false);
    L11:
        SelectTextView r103 = r100.f426502f;
        int r104 = com.ss.android.lark.imageocr.select.d.f426496a;
        Intrinsics.checkNotNullParameter(r103, "textView");
        Layout r105 = r103.getLayout();
        if (r105 == null) goto L16;
        int r106 = r105.getOffsetForHorizontal(r105.getLineForVertical(r102), r101);
        if (((int) r105.getPrimaryHorizontal(r106)) <= r101) goto L17;
        r106 = r105.getOffsetToLeftOf(r106);
    L17:
        int r107 = r106 + 2;
        if ((r100.f426502f.getText() instanceof Spannable) == false) goto L21;
        CharSequence r108 = r100.f426502f.getText();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type android.text.Spannable");
        r100.f426503g = (Spannable) r108;
    L21:
        if (r100.f426503g != null) goto L23;
        return;
    L23:
        if (r106 >= r100.f426502f.getText().length()) goto L31;
        r100.c(r106, r107);
        c r109 = r100.f426497a;
        Intrinsics.checkNotNull(r109);
        r100.d(r109);
        c r110 = r100.f426498b;
        Intrinsics.checkNotNull(r110);
        r100.d(r110);
        d r111 = r100.f426499c;
        if (r111 == null) goto L30;
        r111.a();
        return;
    L30:
        return;
    L31:
        return;
    L16:
        r106 = -1;
        goto L17
    }
}
