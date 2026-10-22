package com.bytedance.android.shopping.slice.elements.bgdecorprojection;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.utils.y;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.common.references.CloseableReference;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SlcBgDecorProjectionOptimizedView extends SlcFlexElementView {
    public static final Paint P = null;
    public boolean A;
    public boolean B;
    public boolean C;
    public final boolean D;
    public final String E;
    public long F;
    public volatile long G;
    public int H;
    public boolean I;
    public int J;
    public volatile int K;
    public volatile boolean L;
    public volatile boolean M;
    public final SlcBgDecorProjectionOptimizedView$headScrollListener$1 N;
    public final com.bytedance.android.shopping.anchorv4.voavhs.blur.f O;
    public final AnonymousClass1 e;
    public final b f;
    public final LinearLayoutManager g;
    public WeakReference<RecyclerView> h;
    public final Map<Integer, Bitmap> i;
    public final Map<Integer, Integer> j;
    public final Map<Integer, String> k;
    public final Set<Integer> l;
    public final Set<Integer> m;
    public final Map<Integer, CloseableReference<Bitmap>> n;
    public final ArrayDeque<d> o;
    public d p;
    public AnchorV4HeadV2VO q;
    public float r;
    public int s;
    public float t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public String z;

    public static final class a extends View {
        public Bitmap a;
        public int b;
        public final Rect c;
        public final Rect d;

        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
            this.b = 1728053247;
            this.c = new Rect();
            this.d = new Rect();
        }

        @Override // android.view.View
        public final void onDraw(Canvas r6) {
            Intrinsics.checkNotNullParameter(r6, "canvas");
            super.onDraw(r6);
            Bitmap r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if ((!r0.isRecycled()) == true) goto L8;
            r0 = null;
        L8:
            if (r0 == null) goto L13;
            this.c.set(0, 0, r0.getWidth(), r0.getHeight());
            this.d.set(0, 0, getWidth(), getHeight());
            r6.drawBitmap(r0, this.c, this.d, SlcBgDecorProjectionOptimizedView.P);
            r6.drawColor(this.b);
            return;
        }
    }

    public final class b extends RecyclerView.Adapter<c> {
        public int a;
        public final Map<Integer, Bitmap> b;
        public final Map<Integer, Integer> c;
        public final /* synthetic */ SlcBgDecorProjectionOptimizedView d;

        public final long getItemId(int r3) {
            return r3;
        }

        public final int getItemCount() {
            return this.a;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [android.view.ViewGroup, com.bytedance.android.shopping.slice.elements.bgdecorprojection.SlcBgDecorProjectionOptimizedView] */
        public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
            c r10 = (c) r8;
            Intrinsics.checkNotNullParameter(r10, "holder");
            Bitmap r0 = this.b.get(Integer.valueOf(r9));
            ?? r1 = this.d;
            Integer r2 = (Integer) ((LinkedHashMap) r1.j).get(Integer.valueOf(r9));
            boolean r3 = true;
            if (r2 != null) goto L5;
        L13:
            WeakReference<RecyclerView> r4 = r1.h;
            if (r4 == null) goto L22;
            RecyclerView r5 = r4.get();
            if (r5 == null) goto L22;
            RecyclerView.LayoutManager r6 = r5.getLayoutManager();
            if (r6 == null) goto L22;
            View r7 = r6.findViewByPosition(r9);
            if (r7 == null) goto L22;
            int r11 = r7.getWidth();
        L23:
            if (r11 <= 0) goto L31;
            int r12 = r1.y;
            if (1 > r9) goto L29;
            if (r12 <= r9) goto L29;
            int r13 = r1.s;
        L30:
            int r14 = r13 + r11;
        L41:
            ViewGroup.LayoutParams r15 = ((RecyclerView.ViewHolder) r10).itemView.getLayoutParams();
            r15.width = r14;
            r15.height = -1;
            ((RecyclerView.ViewHolder) r10).itemView.setLayoutParams(r15);
            r10.a.setBackgroundColor(0);
            a r16 = r10.a;
            int r17 = this.d.H;
            if (r16.b == r17) goto L45;
            r16.b = r17;
            r16.invalidate();
        L45:
            if (r0 != null) goto L47;
        L49:
            a r18 = r10.a;
            r18.a = null;
            r18.invalidate();
            return;
        L47:
            if (r0.isRecycled() == true) goto L49;
            a r19 = r10.a;
            r19.a = r0;
            r19.invalidate();
            return;
        L29:
            r13 = 0;
            goto L30
        L31:
            Integer r20 = Integer.valueOf(r1.x);
            if (r20.intValue() > 0) goto L35;
            r3 = false;
        L35:
            if (r3 == true) goto L38;
            r20 = null;
        L38:
            if (r20 == null) goto L40;
            r14 = r20.intValue();
            goto L41
        L40:
            int r21 = y.a;
            r14 = y.e(r1.getContext(), null, 2);
        L22:
            r11 = 0;
            goto L23
        L5:
            if (r2.intValue() <= 0) goto L7;
            boolean r22 = true;
        L8:
            if (r22 == true) goto L11;
            r2 = null;
        L11:
            if (r2 == null) goto L13;
            r14 = r2.intValue();
            goto L41
        L7:
            r22 = false;
            goto L8
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            a r5 = new a(r3.getContext());
            r5.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            return new c(r5);
        }

        public b(SlcBgDecorProjectionOptimizedView r2, Map<Integer, Bitmap> r3, Map<Integer, Integer> r4) {
            Intrinsics.checkNotNullParameter(r3, "bitmapCache");
            Intrinsics.checkNotNullParameter(r4, "itemWidthMap");
            this.d = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c extends RecyclerView.ViewHolder {
        public final a a;

        public c(a r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2;
        }
    }

    public static final class d {
        public final int a;
        public final CloseableReference<Bitmap> b;
        public final int c;
        public final int d;
        public final int e;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof d) == false) goto L16;
            d r4 = (d) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L14;
            return false;
        L14:
            if (this.e == r4.e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            CloseableReference<Bitmap> r1 = this.b;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return ((((((r0 + r2) * 31) + this.c) * 31) + this.d) * 31) + this.e;
        L5:
            r2 = 0;
            goto L7
        }

        public final String toString() {
            return "BitmapTask(position=" + this.a + ", bitmapRef=" + this.b + ", targetWidth=" + this.c + ", targetHeight=" + this.d + ", version=" + this.e + ")";
        }

        public d(int r2, CloseableReference<Bitmap> r3, int r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r3, "bitmapRef");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class e {
    }

    public static final class f implements Runnable {
        public final /* synthetic */ SlcBgDecorProjectionOptimizedView a;
        public final /* synthetic */ AnchorV4HeadV2VO b;
        public final /* synthetic */ float c;
        public final /* synthetic */ int d;
        public final /* synthetic */ boolean e;

        public f(SlcBgDecorProjectionOptimizedView r1, AnchorV4HeadV2VO r2, float r3, int r4, boolean r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.h(this.b, this.c, this.d, this.e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ SlcBgDecorProjectionOptimizedView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ List c;

        public g(SlcBgDecorProjectionOptimizedView r1, int r2, List r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            if (this.a.L == false) goto L5;
            return;
        L5:
            if (this.a.M == false) goto L7;
            return;
        L7:
            if (this.b != this.a.K) goto L80;
            int r0 = RangesKt.coerceAtLeast(this.a.getHeight(), 1);
            this.a.j();
            SlcBgDecorProjectionOptimizedView r2 = this.a;
            IntRange r3 = CollectionsKt.getIndices(this.c);
            r2.getClass();
            Set r4 = CollectionsKt.toSet(r3);
            Set r5 = ((LinkedHashMap) r2.i).keySet();
            ArrayList r6 = new ArrayList();
            Iterator r7 = r5.iterator();
        L11:
            if (r7.hasNext() == false) goto L15;
            Object r8 = r7.next();
            if ((!r3.contains(((Number) r8).intValue())) == false) goto L11;
            r6.add(r8);
            goto L11
        L15:
            Iterator r9 = r6.iterator();
        L17:
            if (r9.hasNext() == false) goto L19;
            r2.t(((Number) r9.next()).intValue());
            goto L17
        L19:
            Set r10 = r4;
            ((LinkedHashMap) r2.j).keySet().retainAll(r10);
            ((LinkedHashMap) r2.k).keySet().retainAll(r10);
            r2.l.retainAll(r10);
            r2.m.retainAll(r10);
            int r11 = this.c.size();
            int r12 = 0;
        L20:
            if (r12 >= r11) goto L51;
            HeaderContentModel r13 = (HeaderContentModel) ListProtector.get(this.c, r12);
            SlcBgDecorProjectionOptimizedView r14 = this.a;
            float r15 = r14.t;
            if (r12 >= r14.y) goto L26;
            if (r12 != 0) goto L25;
            int r16 = r14.w;
        L27:
            r14.j.put(Integer.valueOf(r12), Integer.valueOf((int) (r16 + ((r14.x - r16) * r15))));
            HeaderMediaModel r17 = r13.getMedia();
            String r18 = null;
            if (r17 == null) goto L32;
            ECUrlModel r19 = HeaderMediaModel.getImageUrl$default(r17, false, 1, null);
            if (r19 == null) goto L32;
            r18 = r19.getUri();
        L32:
            Bitmap r20 = (Bitmap) ((LinkedHashMap) this.a.i).get(Integer.valueOf(r12));
            if (r18 != null) goto L35;
        L40:
            boolean r21 = false;
        L42:
            if (r13.getMedia() == null) goto L49;
            if (r18 == null) goto L45;
            this.a.k.put(Integer.valueOf(r12), r18);
        L46:
            this.a.l.add(Integer.valueOf(r12));
            if (r21 == true) goto L50;
            this.a.m.remove(Integer.valueOf(r12));
            this.a.t(r12);
        L50:
            r12 = r12 + 1;
            goto L20
        L45:
            this.a.k.remove(Integer.valueOf(r12));
            goto L46
        L49:
            this.a.k.remove(Integer.valueOf(r12));
            this.a.l.remove(Integer.valueOf(r12));
            this.a.m.remove(Integer.valueOf(r12));
            this.a.t(r12);
            goto L50
        L35:
            if (Intrinsics.areEqual(r18, (String) ((LinkedHashMap) this.a.k).get(Integer.valueOf(r12))) == false) goto L40;
            if (r20 == null) goto L40;
            if (r20.isRecycled() == true) goto L40;
            r21 = true;
            goto L42
        L25:
            r16 = r14.v;
            goto L27
        L26:
            r16 = r14.x;
            goto L27
        L51:
            b r1 = this.a.f;
            r1.a = this.c.size();
            r1.notifyDataSetChanged();
            this.a.w();
            SlcBgDecorProjectionOptimizedView r22 = this.a;
            r22.A = false;
            int r23 = this.b;
            Map r24 = MapsKt.toMap(r22.n);
            ((LinkedHashMap) r22.n).clear();
            Iterator r25 = r24.entrySet().iterator();
        L53:
            if (r25.hasNext() == false) goto L59;
            Map.Entry r26 = (Map.Entry) r25.next();
            int r27 = ((Number) r26.getKey()).intValue();
            CloseableReference<Bitmap> r28 = (CloseableReference) r26.getValue();
            Integer r29 = (Integer) ((LinkedHashMap) r22.j).get(Integer.valueOf(r27));
            if (r22.l.contains(Integer.valueOf(r27)) == false) goto L58;
            if (r29 == null) goto L58;
            r22.k(r27, r28, r29.intValue(), r0, r23);
        L58:
            r28.close();
            goto L53
        L59:
            SlcBgDecorProjectionOptimizedView.n(this.a, "bind_ready", "version=" + this.b + " media_count=" + this.a.l.size(), 2);
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

    public static final class h implements Runnable {
        public final /* synthetic */ SlcBgDecorProjectionOptimizedView a;

        public h(SlcBgDecorProjectionOptimizedView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.o();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ SlcBgDecorProjectionOptimizedView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ CloseableReference c;

        public i(SlcBgDecorProjectionOptimizedView r1, int r2, CloseableReference r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.p(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class j implements Runnable {
        public final /* synthetic */ SlcBgDecorProjectionOptimizedView a;
        public final /* synthetic */ boolean b;

        public j(SlcBgDecorProjectionOptimizedView r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.q(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class k implements Runnable {
        public final /* synthetic */ SlcBgDecorProjectionOptimizedView a;
        public final /* synthetic */ float b;

        public k(SlcBgDecorProjectionOptimizedView r1, float r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.r(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class l implements Runnable {
        public final /* synthetic */ SlcBgDecorProjectionOptimizedView a;

        public l(SlcBgDecorProjectionOptimizedView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.s();     // Catch: Throwable -> L4
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
        P = new Paint(2);
    }

    public final void i() {
        this.K++;
        j();
        Iterator r0 = ((LinkedHashMap) this.n).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((CloseableReference) r0.next()).close();
        goto L4
    L6:
        ((LinkedHashMap) this.n).clear();
        this.A = false;
        this.C = true;
        if (this.B == true) goto L11;
        this.C = false;
        this.O.d(false);
        return;
    }

    public final void j() {
        Iterator<T> r0 = this.o.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d) r0.next()).b.close();
        goto L4
    L6:
        this.o.clear();
    }

    public final void v() {
        if (this.B == false) goto L5;
        return;
    L5:
        if (this.L == false) goto L7;
        return;
    L7:
        if (this.M == true) goto L16;
        final d r0 = this.o.pollFirst();
        if (r0 != null) goto L12;
        return;
    L12:
        this.B = true;
        this.p = r0;
        final long r1 = SystemClock.elapsedRealtimeNanos();
        m("task_start", r0.a, "version=" + r0.e + " target_width=" + r0.c + " target_height=" + r0.d);
        b2.b(new SlcBgDecorProjectionOptimizedView$startNextBitmapTask$1(this, r0, r1));
        return;
    }

    public final boolean w() {
        WeakReference<RecyclerView> r0 = this.h;
        int r1 = 0;
        if (r0 == null) goto L43;
        RecyclerView r2 = r0.get();
        if (r2 == null) goto L43;
        RecyclerView.LayoutManager r3 = r2.getLayoutManager();
        ViewGroup.LayoutParams r4 = null;
        if ((r3 instanceof LinearLayoutManager) == true) goto L10;
        r3 = null;
    L10:
        LinearLayoutManager r5 = (LinearLayoutManager) r3;
        if (r5 != null) goto L13;
        return false;
    L13:
        Integer r6 = Integer.valueOf(this.u);
        int r7 = r6.intValue();
        int r8 = this.f.a;
        if (r7 < 0) goto L20;
        if (r8 <= r7) goto L20;
        if (r5.findViewByPosition(r7) == null) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == true) goto L24;
        r6 = null;
    L24:
        if (r6 == null) goto L26;
        int r10 = r6.intValue();
    L27:
        int r11 = this.f.a;
        if (r10 < 0) goto L43;
        if (r11 <= r10) goto L43;
        View r12 = r5.findViewByPosition(r10);
        if (r12 != null) goto L34;
        return false;
    L34:
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == false) goto L38;
        r4 = r13;
    L38:
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r4;
        if (r14 == null) goto L41;
        r1 = r14.leftMargin;
    L41:
        this.g.scrollToPositionWithOffset(r10, ((int) r12.getX()) - r1);
        return true;
    L26:
        r10 = r5.findFirstVisibleItemPosition();
    L20:
        r9 = false;
    L43:
        return false;
    }

    public final void o() {
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L7;
        Lazy r0 = UIUtils.a;
        UIUtils.c().post(new h(this));
        return;
    L7:
        if (this.M == false) goto L9;
        return;
    L9:
        if (this.L == true) goto L37;
        WeakReference<RecyclerView> r1 = this.h;
        int r2 = -1;
        if (r1 == null) goto L31;
        RecyclerView r3 = r1.get();
        if (r3 == null) goto L31;
        float r4 = r3.getWidth() / 2.0f;
        int r5 = r3.getChildCount();
        int r6 = 0;
        float r7 = Float.MAX_VALUE;
        int r8 = 0;
        int r9 = -1;
    L17:
        if (r8 >= r5) goto L22;
        View r10 = r3.getChildAt(r8);
        float r11 = Math.abs((r10.getX() + (r10.getWidth() / 2.0f)) - r4);
        if (r11 >= r7) goto L21;
        r9 = r8;
        r7 = r11;
    L21:
        r8 = r8 + 1;
        goto L17
    L22:
        if (r9 != 1) goto L26;
        View r12 = r3.getChildAt(0);
        if ((r12.getWidth() + r12.getX()) <= (r12.getWidth() * 0.75f)) goto L26;
    L27:
        View r13 = r3.getChildAt(r6);
        if (r13 == null) goto L31;
        r2 = r3.getChildAdapterPosition(r13);
    L26:
        r6 = r9;
    L31:
        this.u = r2;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        if (this.M == false) goto L5;
        return;
    L5:
        if (this.L == false) goto L21;
        boolean r0 = false;
        this.L = false;
        n(this, "attached", null, 6);
        WeakReference<RecyclerView> r1 = this.h;
        if (r1 == null) goto L12;
        RecyclerView r2 = r1.get();
        if (r2 == null) goto L12;
        r2.removeOnScrollListener(this.N);
        r2.addOnScrollListener(this.N);
    L12:
        AnchorV4HeadV2VO r3 = this.q;
        if (r3 == null) goto L20;
        float r4 = this.t;
        float r5 = this.r;
        int r6 = this.s;
        if (r4 != 1.0f) goto L17;
        r0 = true;
    L17:
        h(r3, r5, r6, r0);
        r(r4);
        return;
    L20:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        if (this.M == false) goto L5;
        return;
    L5:
        this.L = true;
        this.u = -1;
        WeakReference<RecyclerView> r0 = this.h;
        if (r0 == null) goto L10;
        RecyclerView r1 = r0.get();
        if (r1 == null) goto L10;
        r1.removeOnScrollListener(this.N);
    L10:
        n(this, "detached", null, 6);
        i();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void s() {
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L7;
        Lazy r0 = UIUtils.a;
        UIUtils.c().post(new l(this));
        return;
    L7:
        if (this.M == false) goto L9;
        return;
    L9:
        this.M = true;
        this.L = true;
        this.u = -1;
        WeakReference<RecyclerView> r1 = this.h;
        if (r1 == null) goto L14;
        RecyclerView r2 = r1.get();
        if (r2 == null) goto L14;
        r2.removeOnScrollListener(this.N);
    L14:
        this.h = null;
        this.q = null;
        n(this, "release_before", null, 6);
        u("release_before", 0);
        i();
        this.z = null;
        int r3 = this.e.getChildCount();
        int r4 = 0;
    L15:
        if (r4 >= r3) goto L23;
        View r5 = this.e.getChildAt(r4);
        if ((r5 instanceof a) == true) goto L19;
        r5 = null;
    L19:
        a r6 = (a) r5;
        if (r6 == null) goto L22;
        r6.a = null;
        r6.invalidate();
    L22:
        r4 = r4 + 1;
        goto L15
    L23:
        Iterator r7 = ((LinkedHashMap) this.i).values().iterator();
    L25:
        if (r7.hasNext() == false) goto L27;
        com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.b((Bitmap) r7.next());
        goto L25
    L27:
        ((LinkedHashMap) this.i).clear();
        ((LinkedHashMap) this.j).clear();
        ((LinkedHashMap) this.k).clear();
        this.l.clear();
        this.m.clear();
        this.f.a = 0;
        n(this, "release_after", null, 6);
        u("release_after_1s", 1000);
        u("release_after_5s", 5000);
    }

    public final RecyclerView getRecyclerView() {
        return this.e;
    }

    public final void q(boolean r3) {
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L6;
        Lazy r0 = UIUtils.a;
        UIUtils.c().post(new j(this, r3));
        return;
    L6:
        if (r3 == false) goto L8;
        float r4 = 1.0f;
    L9:
        r(r4);
        this.u = -1;
        return;
    L8:
        r4 = 0.0f;
        goto L9
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void r(float r9) {
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L7;
        Lazy r0 = UIUtils.a;
        UIUtils.c().post(new k(this, r9));
        return;
    L7:
        if (this.M == false) goto L9;
        return;
    L9:
        this.t = RangesKt.coerceIn(r9, 0.0f, 1.0f);
        if (this.L == false) goto L12;
        return;
    L12:
        AnchorV4HeadV2VO r10 = this.q;
        if (r10 == null) goto L51;
        List<HeaderContentModel> r11 = r10.getCells();
        if (r11 == null) goto L52;
        int r12 = r11.size();
        int r1 = 0;
        int r2 = 0;
        boolean r3 = false;
    L18:
        if (r2 >= r12) goto L32;
        float r4 = this.t;
        if (r2 >= this.y) goto L24;
        if (r2 != 0) goto L23;
        int r5 = this.w;
    L25:
        int r6 = (int) (r5 + ((this.x - r5) * r4));
        Integer r7 = (Integer) ((LinkedHashMap) this.j).get(Integer.valueOf(r2));
        if (r7 != null) goto L29;
    L30:
        this.j.put(Integer.valueOf(r2), Integer.valueOf(r6));
        r3 = true;
    L31:
        r2 = r2 + 1;
        goto L18
    L29:
        if (r7.intValue() == r6) goto L31;
    L23:
        r5 = this.v;
        goto L25
    L24:
        r5 = this.x;
        goto L25
    L32:
        if (r3 == false) goto L42;
        int r13 = this.e.getChildCount();
    L34:
        if (r1 >= r13) goto L41;
        View r8 = this.e.getChildAt(r1);
        int r14 = getChildAdapterPosition(r8);
        Integer r15 = (Integer) ((LinkedHashMap) this.j).get(Integer.valueOf(r14));
        if (r15 == null) goto L40;
        int r16 = r15.intValue();
        if (r8.getLayoutParams().width == r16) goto L40;
        ViewGroup.LayoutParams r17 = r8.getLayoutParams();
        r17.width = r16;
        Unit r18 = Unit.INSTANCE;
        r8.setLayoutParams(r17);
    L40:
        r1 = r1 + 1;
        goto L34
    L41:
        requestLayout();
    L42:
        w();
        return;
    L52:
        return;
    }

    public final void t(int r4) {
        RecyclerView.ViewHolder r0 = findViewHolderForAdapterPosition(r4);
        if ((r0 instanceof c) == true) goto L5;
        r0 = null;
    L5:
        c r1 = (c) r0;
        if (r1 == null) goto L10;
        a r2 = r1.a;
        if (r2 == null) goto L10;
        r2.a = null;
        r2.invalidate();
    L10:
        com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.b(this.i.remove(Integer.valueOf(r4)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12, types: [com.bytedance.android.shopping.slice.elements.bgdecorprojection.SlcBgDecorProjectionOptimizedView$headScrollListener$1] */
    /* JADX WARN: Type inference failed for: r4v13, types: [android.view.View, androidx.recyclerview.widget.RecyclerView, com.bytedance.android.shopping.slice.elements.bgdecorprojection.SlcBgDecorProjectionOptimizedView$1] */
    public SlcBgDecorProjectionOptimizedView(final Context r7, com.bytedance.android.shopping.anchorv4.voavhs.blur.f r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "blurManager");
        super(r7, null, 6, 0);
        this.O = r8;
        PagerSnapHelper r9 = new PagerSnapHelper();
        LinkedHashMap r0 = new LinkedHashMap();
        this.i = r0;
        LinkedHashMap r3 = new LinkedHashMap();
        this.j = r3;
        this.k = new LinkedHashMap();
        this.l = new LinkedHashSet();
        this.m = new LinkedHashSet();
        this.n = new LinkedHashMap();
        this.o = new ArrayDeque();
        this.u = -1;
        this.D = ECAppInfoService.e.i();
        this.E = Integer.toHexString(System.identityHashCode(this));
        this.H = 1728053247;
        this.J = Integer.MIN_VALUE;
        this.N = new SlcBgDecorProjectionOptimizedView$headScrollListener$1(this);
        ?? r4 = new AnonymousClass1(r7);
        r4.setItemAnimator(null);
        r4.setNestedScrollingEnabled(false);
        Unit r5 = Unit.INSTANCE;
        this.e = r4;
        LinearLayoutManager r6 = new LinearLayoutManager(r7, 0, false);
        this.g = r6;
        r4.setLayoutManager(r6);
        b r10 = new b(this, r0, r3);
        this.f = r10;
        r10.setHasStableIds(true);
        r4.setAdapter(r10);
        r4.setItemAnimator(null);
        r9.attachToRecyclerView(r4);
        int r11 = com.bytedance.android.ec.hybrid.list.util.c.a;
        addView(r4, new ViewGroup.LayoutParams(com.bytedance.android.ec.hybrid.list.util.c.d(375), com.bytedance.android.ec.hybrid.list.util.c.d(80)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onMeasure(int r4, int r5) {
        super/*com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcYogaLayout*/.onMeasure(r4, r5);
        int r6 = getMeasuredWidth();
        int r7 = getMeasuredHeight();
        this.e.measure(View.MeasureSpec.makeMeasureSpec(r6, 1073741824), View.MeasureSpec.makeMeasureSpec(r7, 1073741824));
        setMeasuredDimension(r6, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p(int r10, CloseableReference<Bitmap> r11) {
        Intrinsics.checkNotNullParameter(r11, "bitmapRef");
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L7;
        Lazy r0 = UIUtils.a;
        UIUtils.c().post(new i(this, r10, r11));
        return;
    L7:
        if (this.L == false) goto L9;
    L25:
        r11.close();
        return;
    L9:
        if (this.M == true) goto L25;
        Integer r1 = (Integer) ((LinkedHashMap) this.j).get(Integer.valueOf(r10));
        if (this.A == true) goto L21;
        if (r1 == null) goto L21;
        if (this.l.contains(Integer.valueOf(r10)) == true) goto L19;
        r11.close();
        return;
    L19:
        k(r10, r11, r1.intValue(), RangesKt.coerceAtLeast(getHeight(), 1), this.K);
        return;
    L21:
        CloseableReference<Bitmap> r12 = this.n.put(Integer.valueOf(r10), r11);
        if (r12 == null) goto L27;
        r12.close();
        return;
    }

    public final void u(final String r5, long r6) {
        if (this.D == true) goto L5;
        return;
    L5:
        final String r0 = this.E;
        Runnable r1 = new SlcBgDecorProjectionOptimizedView$Companion$scheduleProcessMemorySnapshot$action$1(r0, r5);
        if (r6 <= 0) goto L8;
        Lazy r7 = UIUtils.a;
        UIUtils.c().postDelayed(r1, r6);
        return;
    L8:
        r1.run();
    }

    public final void m(String r6, int r7, String r8) {
        if (this.D == true) goto L23;
        return;
    L23:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L20
        Iterator r1 = ((LinkedHashMap) this.i).values().iterator();     // Catch: Throwable -> L20
        long r2 = 0;
    L7:
        if (r1.hasNext() == false) goto L9;
        r2 = r2 + com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a((Bitmap) r1.next());     // Catch: Throwable -> L20
        goto L7
    L9:
        this.F = Math.max(this.F, r2);     // Catch: Throwable -> L20
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L20
        r3.append("event=" + r6 + " impl=optimized instance=" + this.E);     // Catch: Throwable -> L20
        if (r7 == (-1)) goto L12;
        r3.append(" position=" + r7);     // Catch: Throwable -> L20
    L12:
        r3.append(" version=" + this.K);     // Catch: Throwable -> L20
        r3.append(" cache_count=" + this.i.size());     // Catch: Throwable -> L20
        r3.append(" cache_kb=" + (r2 / 1024));     // Catch: Throwable -> L20
        r3.append(" cache_peak_kb=" + (this.F / 1024));     // Catch: Throwable -> L20
        r3.append(" working_peak_kb=" + (this.G / 1024));     // Catch: Throwable -> L20
        r3.append(" pending=" + this.o.size());     // Catch: Throwable -> L20
        r3.append(" waiting=" + this.n.size());     // Catch: Throwable -> L20
        r3.append(" processing=" + this.B);     // Catch: Throwable -> L20
        r3.append(" detached=" + this.L + " destroyed=" + this.M);     // Catch: Throwable -> L20
        if (r8.length() <= 0) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == false) goto L18;
        r3.append(' ');     // Catch: Throwable -> L20
        r3.append(r8);     // Catch: Throwable -> L20
    L18:
        dm.a.a("PdpBgDecorMem").i(r3.toString());     // Catch: Throwable -> L20
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
        return;
    L15:
        r9 = false;
    L20:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static /* synthetic */ void n(SlcBgDecorProjectionOptimizedView r1, String r2, String r3, int r4) {
        if ((r4 & 2) == 0) goto L5;
        int r0 = -1;
    L7:
        if ((r4 & 4) == 0) goto L9;
        r3 = "";
    L9:
        r1.m(r2, r0, r3);
        return;
    L5:
        r0 = 0;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(AnchorV4HeadV2VO r9, float r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r9, "vo");
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L7;
        Lazy r0 = UIUtils.a;
        UIUtils.c().post(new f(this, r9, r10, r11, r12));
        return;
    L7:
        if (this.M == false) goto L9;
        return;
    L9:
        this.q = r9;
        this.r = r10;
        this.s = r11;
        if (r12 == false) goto L12;
        float r13 = 1.0f;
    L13:
        this.t = r13;
        if (this.L == false) goto L16;
        return;
    L16:
        List<HeaderContentModel> r14 = r9.getCells();
        if (r14 != null) goto L19;
        return;
    L19:
        this.y = r9.getChangeKeyPosition();
        int r15 = ECSettingKeys.A0().f();
        int r1 = y.a;
        this.x = y.e(getContext(), null, 2);
        int r2 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b.k;
        int r3 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b.a.b(getContext(), r10, false);
        this.w = r3;
        int r4 = com.bytedance.android.ec.hybrid.list.util.c.a;
        this.v = r3 + com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(r15));
        StringBuilder r16 = new StringBuilder();
        r16.append(r9.hashCode());
        r16.append('#');
        r16.append(Float.floatToIntBits(r10));
        r16.append('#');
        r16.append(this.x);
        r16.append('#');
        r16.append(this.s);
        String r17 = r16.toString();
        if (Intrinsics.areEqual(r17, this.z) == false) goto L23;
        r(this.t);
        return;
    L23:
        this.z = r17;
        this.A = true;
        this.K++;
        int r18 = this.K;
        n(this, "bind_start", "version=" + r18 + " cells=" + r14.size() + " change_key_position=" + this.y, 2);
        if (this.I == true) goto L26;
        this.I = true;
        u("bind_start", 0);
    L26:
        post(new g(this, r18, r14));
        return;
    L12:
        r13 = 0.0f;
        goto L13
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public static final Bitmap g(SlcBgDecorProjectionOptimizedView r19, Bitmap r20, int r21, int r22, int r23) {
        r19.getClass();
        String r10 = "success";
        long r3 = SystemClock.elapsedRealtimeNanos();
        int r15 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r22, r20.getHeight()), 1);     // Catch: Throwable -> L52 Exception -> L55 OutOfMemoryError -> L63
        int r14 = RangesKt.coerceAtLeast(r21, 1);     // Catch: Throwable -> L52 Exception -> L55 OutOfMemoryError -> L63
        Float r0 = Float.valueOf(r19.O.e);     // Catch: Throwable -> L52 Exception -> L55 OutOfMemoryError -> L63
        if (r0.floatValue() <= 0) goto L6;
        boolean r8 = true;
    L7:
        if (r8 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        float r1 = r0.floatValue();     // Catch: Throwable -> L52 Exception -> L55 OutOfMemoryError -> L63
    L13:
        int r9 = RangesKt.coerceAtLeast((int) (r14 / r1), 1);     // Catch: Throwable -> L52 Exception -> L55 OutOfMemoryError -> L63
        int r2 = RangesKt.coerceAtLeast((int) (r15 / r1), 1);     // Catch: Throwable -> L52 Exception -> L55 OutOfMemoryError -> L63
        Bitmap r7 = Bitmap.createBitmap(r9, r2, Bitmap.Config.RGB_565);     // Catch: Throwable -> L52 Exception -> L55 OutOfMemoryError -> L63
        Canvas r12 = new Canvas(r7);     // Catch: Throwable -> L47 Exception -> L49 OutOfMemoryError -> L51
        r12.scale(1.0f, -1.0f, r9 / 2.0f, r2 / 2.0f);     // Catch: Throwable -> L47 Exception -> L49 OutOfMemoryError -> L51
        r12.drawBitmap(r20, new Rect(0, r20.getHeight() - r15, r20.getWidth(), r20.getHeight()), new Rect(0, 0, r9, r2), P);     // Catch: Throwable -> L47 Exception -> L49 OutOfMemoryError -> L51
        if (r19.L == true) goto L32;
    L29:
        th = th;
    L54:
        Throwable r11 = th;
        Bitmap r13 = r7;
        Bitmap r18 = null;
    L97:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L80
        long r5 = com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a(r13);     // Catch: Throwable -> L80
        long r16 = com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a(r18);     // Catch: Throwable -> L80
        Throwable r24 = r11;
        Bitmap r25 = r13;
        r19.G = Math.max(r19.G, r5 + r16);     // Catch: Throwable -> L78
        r19.l(r23, r20, r5, r16, (SystemClock.elapsedRealtimeNanos() - r3) / 1000000, "success");     // Catch: Throwable -> L78
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L78
    L83:
        com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.b(r25);
        throw r24;
    L78:
        th = th;
    L82:
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L80:
        th = th;
        r24 = r11;
        r25 = r13;
        goto L82
    L17:
        if (r19.M == true) goto L32;
        Bitmap r17 = com.bytedance.android.shopping.anchorv4.voavhs.blur.f.b(r19.O, r7, r14, r15, null, 48);     // Catch: Throwable -> L29 Exception -> L49 OutOfMemoryError -> L51
        if (r17 != null) goto L28;
        r10 = "empty";
    L28:
        Bitmap r110 = r17;
        Bitmap r111 = r110;
    L95:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L43
        long r27 = com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a(r7);     // Catch: Throwable -> L43
        long r112 = com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a(r110);     // Catch: Throwable -> L43
        r19.G = Math.max(r19.G, r27 + r112);     // Catch: Throwable -> L41
        Bitmap r113 = r7;
        r19.l(r23, r20, r27, r112, (SystemClock.elapsedRealtimeNanos() - r3) / 1000000, r10);     // Catch: Throwable -> L39
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L46:
        com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.b(r113);
        return r111;
    L39:
        th = th;
    L45:
        Result.Companion r28 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L41:
        th = th;
        r113 = r7;
    L43:
        th = th;
        r113 = r7;
        goto L45
    L32:
        r10 = "cancelled";
        r110 = null;
        r111 = null;
    L47:
        th = th;
        Bitmap r29 = r7;
        Bitmap r114 = null;
    L73:
        r13 = r29;
        r18 = r114;
        r11 = th;
    L49:
        e = e;
        Bitmap r115 = r7;
        Bitmap r30 = null;
    L101:
        String r116 = "error_".concat(e.getClass().getSimpleName());     // Catch: Throwable -> L71
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L61
        long r32 = com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a(r115);     // Catch: Throwable -> L61
        long r33 = com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a(r30);     // Catch: Throwable -> L61
        r19.G = Math.max(r19.G, r32 + r33);     // Catch: Throwable -> L61
        r19.l(r23, r20, r32, r33, (SystemClock.elapsedRealtimeNanos() - r3) / 1000000, r116);     // Catch: Throwable -> L61
    L66:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L61
    L69:
        com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.b(r115);
        return null;
    L71:
        th = th;
        r29 = r115;
        r114 = r30;
    L51:
        r115 = r7;
        Bitmap r34 = null;
    L65:
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L61
        long r36 = com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a(r115);     // Catch: Throwable -> L61
        long r37 = com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a(r34);     // Catch: Throwable -> L61
        r19.G = Math.max(r19.G, r36 + r37);     // Catch: Throwable -> L61
        r19.l(r23, r20, r36, r37, (SystemClock.elapsedRealtimeNanos() - r3) / 1000000, "oom");     // Catch: Throwable -> L61
        goto L66
    L12:
        r1 = 4.0f;
        goto L13
    L6:
        r8 = false;
    L61:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L55:
        e = e;
        r30 = null;
        r115 = null;
    L63:
        r34 = null;
        r115 = null;
    L52:
        th = th;
        r7 = null;
        goto L54
    }

    public final void k(int r9, CloseableReference<Bitmap> r10, int r11, int r12, int r13) {
        if (this.m.contains(Integer.valueOf(r9)) == true) goto L22;
        d r0 = this.p;
        if (r0 != null) goto L7;
    L14:
        Iterator<d> r1 = this.o.iterator();
    L16:
        if (r1.hasNext() == false) goto L20;
        d r2 = r1.next();
        if (r2.a != r9) goto L16;
        r1.remove();
        r2.b.close();
    L20:
        this.o.addLast(new d(r9, r10, r11, r12, r13));
        v();
        return;
    L7:
        if (r0.a == r9) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 != true) goto L14;
    L9:
        if (r0.e != r13) goto L11;
        r3 = true;
    L22:
        r10.close();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super/*com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcYogaLayout*/.onLayout(r1, r2, r3, r4, r5);
        this.e.layout(0, 0, r4 - r2, r5 - r3);
    }

    public final void l(int r14, Bitmap r15, long r16, long r18, long r20, String r22) {
        if (this.D == true) goto L10;
        return;
    L10:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L7
        long r8 = com.bytedance.android.shopping.slice.elements.bgdecorprojection.b.a(r15);     // Catch: Throwable -> L7
        dm.a.a("PdpBgDecorMem").i("event=blur_finish impl=optimized instance=" + this.E + " position=" + r14 + " result=" + r22 + " cost_ms=" + r20 + " source_width=" + r15.getWidth() + " source_height=" + r15.getHeight() + " source_config=" + r15.getConfig() + " source_ref_kb=" + (r8 / 1024) + " projection_kb=" + (r16 / 1024) + " output_kb=" + (r18 / 1024) + " working_kb=" + ((r16 + r18) / 1024) + " working_peak_kb=" + (this.G / 1024));     // Catch: Throwable -> L7
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
