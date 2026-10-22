package com.ss.android.lark.widget.light;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.larksuite.framework.thread.ThreadUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.viewstub.ViewHolderSpan;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes38.dex */
public final class c extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LKUILightTextView f445974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f445975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<ViewHolderSpan, View> f445976c;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Layout f445977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f445978b;

        public b(Layout r100, c r101) {
            this.f445977a = r100;
            this.f445978b = r101;
        }

        public final void a() {
            Layout r100 = this.f445977a;
            if (r100 == null) goto L33;
            c r101 = this.f445978b;
            r101.getClass();
            CharSequence r102 = r100.getText();
            if ((r102 instanceof Spanned) == false) goto L38;
            Spanned r103 = (Spanned) r102;
            Object[] r104 = r103.getSpans(0, r103.length(), ViewHolderSpan.class);
            int r105 = r104.length;
            int r106 = 0;
        L8:
            if (r106 >= r105) goto L39;
            ViewHolderSpan r107 = (ViewHolderSpan) r104[r106];
            View r108 = r107.a();
            if (r108.getParent() == null) goto L22;
            if ((r108.getParent() instanceof ViewGroup) == false) goto L22;
            if (Intrinsics.areEqual(r108.getParent(), r101) == true) goto L22;
            ViewParent r109 = r108.getParent();
            if ((r109 instanceof ViewGroup) == false) goto L18;
            ViewGroup r110 = (ViewGroup) r109;
        L19:
            if (r110 == null) goto L22;
            r110.removeView(r108);
            goto L22
        L18:
            r110 = null;
        L22:
            if (r101.indexOfChild(r108) == (-1)) goto L24;
            boolean r111 = true;
        L25:
            if (r111 == true) goto L27;
            r101.addView(r108);
        L27:
            r101.f445976c.put(r107, r108);
            r108.setTag(R.id.tag_span_container_view, r101.f445974a);
            if (r108.isLongClickable() == true) goto L32;
            if (r101.f445974a.getCanHandleLongClick() == false) goto L32;
            r108.setOnLongClickListener(new d(r101));
            r108.setTag(R.id.tag_delegate_container_long_click, Boolean.TRUE);
        L32:
            r106 = r106 + 1;
            goto L8
        L24:
            r111 = false;
            goto L25
        L39:
            return;
        L38:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.widget.light.c$c, reason: collision with other inner class name */
    public static final class RunnableC5394c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f445979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Layout f445980b;

        public RunnableC5394c(c r100, Layout r101) {
            this.f445979a = r100;
            this.f445980b = r101;
        }

        public final void a() {
            c r100 = this.f445979a;
            Layout r101 = this.f445980b;
            r100.getClass();
            if (r101 == null) goto L22;
            CharSequence r102 = r101.getText();
            if (r102 != null) goto L8;
            return;
        L8:
            if ((r102 instanceof Spanned) == false) goto L27;
            Spanned r103 = (Spanned) r102;
            Object[] r104 = r103.getSpans(0, r103.length(), ViewHolderSpan.class);
            int r105 = r104.length;
            int r106 = 0;
        L11:
            if (r106 >= r105) goto L28;
            ViewHolderSpan r107 = (ViewHolderSpan) r104[r106];
            View r108 = r107.a();
            if (r100.indexOfChild(r108) == (-1)) goto L15;
            boolean r109 = true;
        L16:
            if (r109 == false) goto L18;
            r100.removeView(r108);
        L18:
            r100.f445976c.remove(r107);
            r108.setTag(R.id.tag_span_container_view, null);
            if (r108.getTag(R.id.tag_delegate_container_long_click) == null) goto L21;
            r108.setTag(R.id.tag_delegate_container_long_click, null);
            r108.setOnLongClickListener(null);
            r108.setLongClickable(false);
        L21:
            r106 = r106 + 1;
            goto L11
        L15:
            r109 = false;
            goto L16
        L28:
            return;
        L27:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // android.view.View
    public void setBackground(Drawable r100) {
    }

    public final void a(Layout r100) {
        ThreadUtils.runOnUIThread(new b(r100, this));
    }

    public final void b(Layout r100) {
        ThreadUtils.runOnUIThread(new RunnableC5394c(this, r100));
    }

    public c(Context r100, LKUILightTextView r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lightTextView");
        super(r100);
        this.f445974a = r101;
        this.f445975b = new Rect();
        this.f445976c = new LinkedHashMap();
        setVisibility(0);
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View r100, int r101, int r102, int r103, int r104) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r105 = r100.getMeasuredWidth();
        int r106 = r100.getMeasuredHeight();
        r100.measure(View.MeasureSpec.makeMeasureSpec(r105, 1073741824), View.MeasureSpec.makeMeasureSpec(r106, 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r112, int r113, int r114) {
        Iterator r115 = ((LinkedHashMap) this.f445976c).entrySet().iterator();
    L4:
        if (r115.hasNext() == false) goto L50;
        ViewHolderSpan r116 = (ViewHolderSpan) ((Map.Entry) r115.next()).getKey();
        this.f445975b.setEmpty();
        Rect r117 = this.f445975b;
        Layout r118 = this.f445974a.getLayout();
        if (r118 == null) goto L48;
        CharSequence r119 = r118.getText();
        if ((r119 instanceof Spanned) == false) goto L11;
        Spanned r120 = (Spanned) r119;
    L12:
        if (r120 == null) goto L48;
        View r100 = r116.a();
        int r101 = r120.getSpanStart(r116);
        if (r101 != (-1)) goto L17;
        Log.w("BlockSpanContainer", "layout text do not contains this span");
        goto L48
    L17:
        int r102 = r118.getLineForOffset(r101);
        boolean r103 = true;
        if (r101 < r118.getLineEnd(r118.getLineCount() - 1)) goto L21;
        Log.i("BlockSpanContainer", "viewHolder span is eclipsed, method return");     // Catch: IndexOutOfBoundsException -> L44
        goto L48
    L21:
        float r121 = r118.getPrimaryHorizontal(r101);     // Catch: IndexOutOfBoundsException -> L44
        float r104 = r100.getMeasuredWidth() + r121;
        r118.getLineBounds(r102, r117);
        if (r102 < (r118.getLineCount() - 1)) goto L25;
    L32:
        int r122 = r100.getMeasuredHeight();
        if (r122 >= r117.height()) goto L39;
        if (Intrinsics.areEqual(r100.getTag(R.id.tag_view_holder_span_top_align), Boolean.TRUE) == false) goto L37;
        r117.bottom = r117.top + r122;
        goto L39
    L37:
        r117.top = r117.bottom - r122;
    L39:
        if (Intrinsics.areEqual(r100.getTag(R.id.tag_view_holder_span_top_align), Boolean.TRUE) == false) goto L43;
        int r123 = r117.top;
        if (r123 >= 0) goto L43;
        r117.offset(0, -r123);
    L43:
        r117.left = MathKt.roundToInt(r121);
        r117.right = MathKt.roundToInt(r104);
        Log.i("BlockSpanContainer", "getBlockSpanLocation: location is " + r117.toShortString() + ", line number is " + r102);
        goto L48
    L25:
        if (r118.getSpacingMultiplier() == 0.0f) goto L28;
        r103 = false;
    L28:
        if (r103 == false) goto L30;
        float r105 = 1.0f;
    L31:
        float r106 = -1;
        r117.offset(0, MathKt.roundToInt(r106 * (r117.height() - ((r117.height() - r118.getSpacingAdd()) / r105))));
        goto L32
    L30:
        r105 = r118.getSpacingMultiplier();
    L44:
        e = move-exception;
        String r124 = "getBlockSpanLocation: error occurred, span start is " + r101 + " , span end is " + r120.getSpanEnd(r116) + ", lineStart is " + r118.getLineStart(r102) + ", lineEnd is " + r118.getLineEnd(r102) + ' ';
        Log.e("BlockSpanContainer", r124);
        if (DevEnvUtil.isDevelopPackage(getContext()) == true) goto L49;
        Log.e(r124, e, true);
        goto L48
    L49:
        throw e;
    L11:
        r120 = null;
    L48:
        Rect r125 = this.f445975b;
        r116.a().layout(r125.left, r125.top, r125.right, r125.bottom);
        goto L4
    }
}
