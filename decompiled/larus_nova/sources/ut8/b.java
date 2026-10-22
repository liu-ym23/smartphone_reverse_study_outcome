package ut8;

import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.os.TraceCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.bmhome.chat.api.d0;
import com.larus.bmhome.utils.e2;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.business.markdown.impl.markwon.MarkwonContent;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f551654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewTreeObserverOnScrollChangedListenerC7930b f551655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f551656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f551657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Spannable f551658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f551659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f551660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i f551661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f551662i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i f551663j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f551664k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f551665l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f551666m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f551667n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final BackgroundColorSpan f551668o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f551669p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Set<st8.c> f551670q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final g f551671r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public d0 f551672s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final f f551673t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ut8.f f551674u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d f551675v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final e f551676w;

    public class a implements g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f551677a;

        @Override // ut8.g.a
        public final void onStart() {
        }

        @Override // ut8.g.a
        public final void b() {
            this.f551677a.l();
        }

        @Override // ut8.g.a
        public final void onStop() {
            b r100 = this.f551677a;
            if (r100.f551661h != null) goto L5;
            return;
        L5:
            if (r100.f551663j == null) goto L9;
            r100.o();
            return;
        }

        public a(b r100) {
            this.f551677a = r100;
        }
    }

    /* JADX INFO: renamed from: ut8.b$b, reason: collision with other inner class name */
    public class ViewTreeObserverOnScrollChangedListenerC7930b implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f551678a;

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            b r100 = this.f551678a;
            if (r100.f551669p == false) goto L15;
            int[] r101 = r100.f551659f;
            float r102 = r101[1];
            r100.f551657d.getLocationInWindow(r101);
            b r103 = this.f551678a;
            if (r102 == r103.f551659f[1]) goto L16;
            g r104 = r103.f551671r;
            if (r104.f551688a == true) goto L11;
            r104.f551688a = true;
            g.a r105 = r104.f551689b;
            if (r105 == null) goto L11;
            r105.onStart();
        L11:
            g.a r106 = r104.f551689b;
            if (r106 == null) goto L17;
            r106.b();
            return;
        L17:
            return;
        L16:
            return;
        }

        public ViewTreeObserverOnScrollChangedListenerC7930b(b r100) {
            this.f551678a = r100;
        }
    }

    public class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f551679a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            b r100 = this.f551679a;
            if (r100.f551669p == false) goto L17;
            View r101 = r100.f551657d;
            if (r101 == null) goto L7;
            r101.removeCallbacks(r100.f551675v);
            r100.f551657d.postDelayed(r100.f551675v, 100);
        L7:
            b r102 = this.f551679a;
            int[] r103 = r102.f551659f;
            float r104 = r103[1];
            r102.f551657d.getLocationInWindow(r103);
            b r105 = this.f551679a;
            if (r104 != r105.f551659f[1]) goto L18;
            g r106 = r105.f551671r;
            if (r106 != null) goto L12;
            return;
        L12:
            if (r106.f551688a == false) goto L20;
            r106.f551688a = false;
            g.a r107 = r106.f551689b;
            if (r107 == null) goto L21;
            r107.onStop();
            return;
        L21:
            return;
        L20:
            return;
        L18:
            return;
        }

        public c(b r100) {
            this.f551679a = r100;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f551680a;

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f551680a;     // Catch: Throwable -> L9
            if (r100.f551669p == true) goto L5;
            return;
        L5:
            if (r100.f551671r.f551688a == true) goto L16;
            r100.l();     // Catch: Throwable -> L9
            return;
        L16:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public d(b r100) {
            this.f551680a = r100;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f551681a;

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f551681a;     // Catch: Throwable -> L10
            if (r100.f551671r.f551688a == true) goto L15;
            View r101 = r100.f551657d;     // Catch: Throwable -> L10
            if (r101 != null) goto L8;
            r100.i();     // Catch: Throwable -> L10
            goto L15
        L8:
            r101.post(new ut8.e(this));     // Catch: Throwable -> L10
        L15:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }

        public e(b r100) {
            this.f551681a = r100;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Pair<Integer, Integer> f551682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Pair<Integer, Integer> f551683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f551684c;

        public final void a() {
            if (this.f551684c.f551671r.f551688a == false) goto L6;
            FLogger.f375446a.i("BaseWordSelector", "SelectorOutsideClickTask.run reset by scrolling");
            b();
            return;
        L6:
            Pair<Integer, Integer> r100 = this.f551683b;
            if (Objects.equals(r100.first, r100.second) == false) goto L21;
            Pair<Integer, Integer> r101 = this.f551682a;
            if (Objects.equals(r101.first, r101.second) == false) goto L21;
            if (((Integer) this.f551683b.first).intValue() == 0) goto L21;
            d0 r102 = this.f551684c.f551672s;
            if (((Integer) this.f551682a.first).intValue() != 1) goto L16;
            if (r102 == null) goto L16;
        L17:
            if (r102 == null) goto L19;
            FLogger.f375446a.i("BaseWordSelector", "SelectorOutsideClickTask.run -> onClickWhenSelected, totalCount=" + this.f551683b.first + ", selectedAreaFirst=" + this.f551682a.first);
            r102.a(this.f551684c.f551657d, ((Integer) this.f551683b.first).intValue(), ((Integer) this.f551682a.first).intValue());
        L19:
            b();
            return;
        L16:
            FLogger.f375446a.i("BaseWordSelector", "SelectorOutsideClickTask.run -> hideTask.run(), callback=" + r102 + ", selectedAreaFirst=" + this.f551682a.first);
            this.f551684c.f551676w.run();
        L21:
            FLogger.f375446a.i("BaseWordSelector", "SelectorOutsideClickTask.run reset by invalid count, totalCount=" + this.f551683b + ", selectedAreaCount=" + this.f551682a);
            b();
        }

        public final void b() {
            ((Integer) this.f551683b.first).intValue();
            ((Integer) this.f551683b.second).intValue();
            this.f551682a = new Pair(0, 0);
            this.f551683b = new Pair(0, 0);
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

        public f(b r100) {
            this.f551684c = r100;
            this.f551682a = new Pair(0, 0);
            this.f551683b = new Pair(0, 0);
        }
    }

    public abstract Rect f();

    public abstract Layout g();

    public abstract CharSequence h();

    public void i() {
        this.f551669p = false;
        i r100 = this.f551661h;
        if (r100 == null) goto L12;
        PopupWindow r101 = r100.f551691a;
        if (r101 == null) goto L12;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);     // Catch: Exception -> L10
        r101.dismiss();     // Catch: Exception -> L10
        i.b r102 = r100.f551699i;     // Catch: Exception -> L10
        if (r102 == null) goto L12;
        ((ut8.a) r102).f551653a.f551662i = -1;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        i r103 = this.f551663j;
        if (r103 == null) goto L22;
        PopupWindow r104 = r103.f551691a;
        if (r104 == null) goto L22;
        PopupWindowLancet.handleDismissBeforeOrigin(r104);     // Catch: Exception -> L20
        r104.dismiss();     // Catch: Exception -> L20
        i.b r105 = r103.f551699i;     // Catch: Exception -> L20
        if (r105 == null) goto L22;
        ((ut8.a) r105).f551653a.f551662i = -1;     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
    L22:
        View r106 = this.f551657d;
        if (r106 != null) goto L25;
    L49:
        this.f551665l = 0;
        this.f551666m = 0;
        return;
    L25:
        if ((r106 instanceof CustomMarkdownTextView) == false) goto L46;
        MarkwonContent r107 = ((CustomMarkdownTextView) r106).getMarkwonContent();
        if (r107 == null) goto L46;
        SpannableStringBuilder r108 = r107.f320556a;
        List r109 = ArraysKt.toList(r108.getSpans(0, r108.length(), wsc.f.class));
        int r110 = e2.f315005a;
        int r111 = this.f551665l;
        int r112 = this.f551666m;
        Intrinsics.checkNotNullParameter(r107, "markwon");
        Intrinsics.checkNotNullParameter(r109, "l");
        ArrayList r113 = new ArrayList();
        Iterator r114 = r109.iterator();
    L30:
        if (r114.hasNext() == false) goto L34;
        Object r115 = r114.next();
        if ((r115 instanceof io.noties.markwon.ext.onetex.c) == false) goto L30;
        r113.add(r115);
        goto L30
    L34:
        Iterator r116 = r113.iterator();
    L36:
        if (r116.hasNext() == false) goto L46;
        io.noties.markwon.ext.onetex.c r117 = (io.noties.markwon.ext.onetex.c) r116.next();
        int r118 = r107.f320556a.getSpanStart(r117);
        int r119 = r107.f320556a.getSpanStart(r117);
        if (r118 < r111) goto L36;
        if (r119 > r112) goto L36;
        if ((r117 instanceof io.noties.markwon.ext.onetex.c) == true) goto L44;
        r117 = null;
    L44:
        if (r117 == null) goto L36;
        r117.f492400g = 0;
    L46:
        Spannable r120 = (Spannable) h();
        this.f551658e = r120;
        if (r120 == null) goto L49;
        r120.removeSpan(this.f551668o);
        this.f551657d.invalidate();
        goto L49
    }

    public abstract void j();

    public abstract void k(Layout r100, int r101, i r102, boolean r103);

    public abstract void p(boolean r100, int r101, int r102);

    public final void l() {
        if (this.f551657d != null) goto L5;
        return;
    L5:
        Layout r100 = g();
        this.f551657d.getLocationInWindow(this.f551659f);
        i r101 = this.f551661h;
        if (r101 == null) goto L8;
        r101.removeCallbacks(this.f551676w);
        this.f551661h.removeCallbacks(this.f551673t);
    L8:
        i r102 = this.f551663j;
        if (r102 == null) goto L11;
        r102.removeCallbacks(this.f551676w);
        this.f551663j.removeCallbacks(this.f551673t);
    L11:
        this.f551673t.b();
        int r103 = this.f551665l;
        i r104 = this.f551661h;
        if (r104.f551694d == false) goto L14;
        boolean r105 = r104.f551696f;
    L16:
        if (r105 == true) goto L19;
        r104 = this.f551663j;
    L19:
        k(r100, r103, r104, true);
        int r106 = this.f551666m;
        i r107 = this.f551661h;
        if (r107.f551694d == false) goto L22;
        boolean r108 = r107.f551696f;
    L23:
        if (r108 == false) goto L26;
        r107 = this.f551663j;
    L26:
        k(r100, r106, r107, false);
        return;
    L22:
        r108 = r107.f551695e;
        goto L23
    L14:
        r105 = r104.f551695e;
        goto L16
    }

    public final void m() {
        if (this.f551657d != null) goto L5;
        return;
    L5:
        n();
        int r100 = this.f551665l;
        if (r100 >= 0) goto L8;
    L35:
        this.f551657d.invalidate();
        TraceCompat.endSection();
        return;
    L8:
        if (this.f551666m <= r100) goto L35;
        BreakIterator r101 = BreakIterator.getCharacterInstance();
        r101.setText(this.f551658e.toString());
        this.f551665l = e(r101, Integer.valueOf(this.f551665l)).intValue();
        this.f551666m = d(r101, Integer.valueOf(this.f551666m)).intValue();
        View r102 = this.f551657d;
        if ((r102 instanceof CustomMarkdownTextView) == false) goto L35;
        MarkwonContent r103 = ((CustomMarkdownTextView) r102).getMarkwonContent();
        if (r103 == null) goto L35;
        SpannableStringBuilder r104 = r103.f320556a;
        List r105 = ArraysKt.toList(r104.getSpans(0, r104.length(), wsc.f.class));
        int r106 = e2.f315005a;
        int r107 = this.f551665l;
        int r108 = this.f551666m;
        int r109 = this.f551667n;
        Intrinsics.checkNotNullParameter(r103, "markwon");
        Intrinsics.checkNotNullParameter(r105, "l");
        ArrayList r110 = new ArrayList();
        Iterator r111 = r105.iterator();
    L15:
        if (r111.hasNext() == false) goto L19;
        Object r112 = r111.next();
        if ((((wsc.f) r112) instanceof io.noties.markwon.ext.onetex.c) == false) goto L15;
        r110.add(r112);
        goto L15
    L19:
        Iterator r113 = r110.iterator();
    L21:
        if (r113.hasNext() == false) goto L35;
        wsc.f r114 = (wsc.f) r113.next();
        int r115 = r103.f320556a.getSpanStart(r114);
        int r116 = r103.f320556a.getSpanStart(r114);
        io.noties.markwon.ext.onetex.c r117 = null;
        if (r115 < r107) goto L31;
        if (r116 > r108) goto L31;
        if ((r114 instanceof io.noties.markwon.ext.onetex.c) == false) goto L28;
        r117 = (io.noties.markwon.ext.onetex.c) r114;
    L28:
        if (r117 == null) goto L21;
        r117.f492400g = r109;
    L31:
        if ((r114 instanceof io.noties.markwon.ext.onetex.c) == false) goto L33;
        r117 = (io.noties.markwon.ext.onetex.c) r114;
    L33:
        if (r117 == null) goto L21;
        r117.f492400g = 0;
        goto L21
    }

    public final void n() {
        Spannable r100 = (Spannable) h();
        this.f551658e = r100;
        if (r100 == null) goto L34;
        int r101 = this.f551665l;
        int r102 = this.f551666m;
        if (r101 < 0) goto L23;
        if (r102 <= r101) goto L23;
        if (r102 > r100.length()) goto L23;
        String r103 = r100.subSequence(r101, r102).toString();
        ArrayList r104 = new ArrayList();
        r104.add("\n");
        r104.add("\n ");
        Iterator r105 = r104.iterator();
    L11:
        if (r105.hasNext() == false) goto L18;
        String r106 = (String) r105.next();
        if (r103.startsWith(r106) == false) goto L16;
        r101 = r101 + r106.length();
    L16:
        if (r103.endsWith(r106) == false) goto L11;
        r102 = r102 - r106.length();
        goto L11
    L18:
        if (r101 < 0) goto L23;
        if (r102 <= r101) goto L23;
        if (r102 > r100.length()) goto L23;
        this.f551665l = r101;
        this.f551666m = r102;
    L23:
        int r107 = this.f551665l;
        if (r107 >= 0) goto L26;
        return;
    L26:
        if (this.f551666m <= r107) goto L36;
        BreakIterator r108 = BreakIterator.getCharacterInstance();
        r108.setText(this.f551658e.toString());
        this.f551665l = e(r108, Integer.valueOf(this.f551665l)).intValue();
        this.f551666m = d(r108, Integer.valueOf(this.f551666m)).intValue();
        FLogger.f375446a.i("TextSelector", "getSafeStartPos process, mStartCursorPos = " + this.f551665l + ", mEndCursorPos = " + this.f551666m);
        this.f551658e.setSpan(this.f551668o, this.f551665l, this.f551666m, 17);
        return;
    L36:
        return;
    }

    public void o() {
        l();
    }

    public b(View r100) {
        int[] r101 = new int[2];
        this.f551659f = r101;
        this.f551660g = new Rect();
        this.f551662i = -1;
        this.f551664k = -1;
        this.f551669p = false;
        this.f551670q = Collections.newSetFromMap(new WeakHashMap());
        this.f551673t = new f(this);
        this.f551675v = new d(this);
        this.f551676w = new e(this);
        Context r102 = r100.getContext();
        this.f551654a = r102;
        this.f551657d = r100;
        int r103 = ContextCompat.getColor(r102, R.color.larus_text_highlight);
        this.f551667n = r103;
        this.f551668o = new BackgroundColorSpan(r103);
        g r104 = new g();
        this.f551671r = r104;
        a r105 = new a(this);
        Intrinsics.checkNotNullParameter(r105, "listener");
        r104.f551689b = r105;
        View r106 = this.f551657d;
        if ((r106 instanceof TextView) == false) goto L6;
        ((TextView) r106).setTextIsSelectable(false);
    L6:
        if ((r100 instanceof TextView) == false) goto L8;
        TextView r107 = (TextView) r100;
        r107.setText(r107.getText(), TextView.BufferType.SPANNABLE);
    L8:
        i r108 = new i(this.f551654a);
        this.f551661h = r108;
        r108.setIsStartCursor(true);
        this.f551661h.setChangeListener(new ut8.a(this));
        this.f551661h.setTouchMoveListener(new ut8.c(this));
        i r109 = new i(this.f551654a);
        this.f551663j = r109;
        r109.setIsStartCursor(false);
        this.f551663j.setTouchMoveListener(new ut8.d(this));
        this.f551657d.getLocationInWindow(r101);
        ViewTreeObserverOnScrollChangedListenerC7930b r110 = new ViewTreeObserverOnScrollChangedListenerC7930b(this);
        this.f551655b = r110;
        this.f551657d.getViewTreeObserver().addOnScrollChangedListener(r110);
        c r111 = new c(this);
        this.f551656c = r111;
        this.f551657d.getViewTreeObserver().addOnGlobalLayoutListener(r111);
    }

    public static Integer d(BreakIterator r100, Integer r101) {
        if (r100.isBoundary(r101.intValue()) == false) goto L5;
        int r102 = r101.intValue();     // Catch: Exception -> L8
    L6:
        return Integer.valueOf(r102);
    L5:
        r102 = r100.following(r101.intValue());     // Catch: Exception -> L8
    L9:
        return Integer.valueOf(r100.getText().getEndIndex());
    }

    public static Integer e(BreakIterator r100, Integer r101) {
        if (r100.isBoundary(r101.intValue()) == false) goto L5;
        int r102 = r101.intValue();     // Catch: Exception -> L8
    L6:
        return Integer.valueOf(r102);
    L5:
        r102 = r100.preceding(r101.intValue());     // Catch: Exception -> L8
    L9:
        return Integer.valueOf(r100.getText().getBeginIndex());
    }

    public static void b(b r100, boolean r101, boolean r110) {
        d0 r102 = r100.f551672s;
        if (r101 == true) goto L17;
        if (r102 == null) goto L18;
        Rect r103 = r100.f();
        CharSequence r104 = r100.h();
        if (r104 == null) goto L14;
        int r105 = r100.f551665l;
        if (r105 < 0) goto L14;
        int r106 = r100.f551666m;
        if (r106 <= r105) goto L14;
        if (r106 > r104.length()) goto L14;
        String r107 = r104.subSequence(r100.f551665l, r100.f551666m).toString();
    L15:
        SelectionRangeType r108 = SelectionRangeType.CUSTOM_RANGE;
        int r109 = r100.f551665l;
        int r111 = r100.f551666m;
        r102.b(r108, r109, r111, true, r110, r103, r107);
        return;
    L14:
        r107 = "";
        goto L15
    L18:
        return;
    }

    public static void c(b r100, i r110, MotionEvent r111, boolean r112) {
        boolean r101 = false;
        if (r111 == null) goto L26;
        View r102 = r100.f551657d;
        if (r102 == null) goto L26;
        int[] r103 = new int[2];     // Catch: Exception -> L25
        r102.getLocationOnScreen(r103);     // Catch: Exception -> L25
        int r104 = r103[0];     // Catch: Exception -> L25
        int r105 = r103[1];     // Catch: Exception -> L25
        float r106 = r111.getRawX() - r104;     // Catch: Exception -> L25
        float r113 = r111.getRawY() - r105;     // Catch: Exception -> L25
        if (r106 < 0.0f) goto L26;
        if (r106 > r100.f551657d.getWidth()) goto L26;
        if (r113 < 0.0f) goto L26;
        if (r113 > r100.f551657d.getHeight()) goto L26;
        View r107 = r100.f551657d;     // Catch: Exception -> L25
        if ((r107 instanceof TextView) == false) goto L26;
        int r114 = j.a((TextView) r107, (int) r106, (int) r113);     // Catch: Exception -> L25
        if (r114 < r100.f551665l) goto L26;
        if (r114 > r100.f551666m) goto L26;
        boolean r115 = true;
    L27:
        f r108 = r100.f551673t;
        r108.getClass();
        if (r115 == false) goto L32;
        if (r112 == false) goto L31;
        r108.f551682a = new Pair(Integer.valueOf(((Integer) r108.f551682a.first).intValue() + 1), (Integer) r108.f551682a.second);
        goto L32
    L31:
        Pair<Integer, Integer> r109 = r108.f551682a;
        r108.f551682a = new Pair((Integer) r109.first, Integer.valueOf(((Integer) r109.second).intValue() + 1));
    L32:
        if (r112 == false) goto L34;
        r108.f551683b = new Pair(Integer.valueOf(((Integer) r108.f551683b.first).intValue() + 1), (Integer) r108.f551683b.second);
    L35:
        FLogger r116 = FLogger.f375446a;
        r116.i("BaseWordSelector", "SelectorOutsideClickTask.count, isStartCursor=" + r112 + ", isInSelectedArea=" + r115 + ", totalCount=" + r108.f551683b + ", selectedAreaCount=" + r108.f551682a);
        r116.i("BaseWordSelector", "onOutsideTouchedByInternal, isStartCursor=" + r112 + ", isInSelectedArea=" + r115 + ", totalCount=" + r100.f551673t.f551683b + ", selectedAreaCount=" + r100.f551673t.f551682a);
        f r117 = r100.f551673t;
        if ((((Integer) r117.f551683b.first).intValue() + ((Integer) r117.f551683b.second).intValue()) != 1) goto L38;
        r101 = true;
    L38:
        if (r101 == false) goto L43;
        r116.i("BaseWordSelector", "onOutsideTouchedByInternal firstClick -> call onTouchOutside and post SelectorOutsideClickTask");
        r100.j();
        r110.postDelayed(r100.f551673t, 300);
        return;
    L43:
        return;
    L34:
        Pair<Integer, Integer> r118 = r108.f551683b;
        r108.f551683b = new Pair((Integer) r118.first, Integer.valueOf(((Integer) r118.second).intValue() + 1));
    L26:
        r115 = false;
        goto L27
    }

    private void update(boolean r100, boolean r101, int r102, int r103) {
        if (this.f551657d != null) goto L5;
        return;
    L5:
        if (r101 == true) goto L13;
        int r104 = this.f551665l;
        int r105 = this.f551666m;
        if (r104 != r105) goto L14;
        if (r104 <= 0) goto L11;
        this.f551665l = r104 - 1;
        goto L14
    L11:
        if (r105 >= (h().length() - 1)) goto L14;
        this.f551666m++;
    L14:
        m();
        l();
        return;
    L13:
        p(r100, r102, r103);
        goto L14
    }

    public static /* synthetic */ void a(b r100, boolean r101, boolean r102, int r103, int r104) {
        r100.update(r101, r102, r103, r104);
    }
}
