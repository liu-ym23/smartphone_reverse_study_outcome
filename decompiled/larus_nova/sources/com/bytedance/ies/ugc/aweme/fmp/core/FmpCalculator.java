package com.bytedance.ies.ugc.aweme.fmp.core;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ies.ugc.aweme.fmp.core.diff.DiffCalMode;
import com.bytedance.ies.xelement.viewpager.childitem.LynxFoldHeader;
import com.bytedance.ies.xelement.viewpager.childitem.LynxFoldSlot;
import com.bytedance.ies.xelement.viewpager.childitem.LynxFoldToolbar;
import com.bytedance.ies.xelement.viewpager.childitem.LynxViewpagerItem;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.generic.RootDrawable;
import com.larus.nova.R;
import com.larus.platform.api.creation.TplType;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.text.AndroidText;
import com.lynx.tasm.behavior.ui.text.FlattenUIText;
import com.lynx.tasm.behavior.ui.text.UIText;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.ui.image.FlattenUIImage;
import com.lynx.tasm.ui.image.FrescoImageView;
import com.lynx.tasm.ui.image.UIImage;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes19.dex */
public final class FmpCalculator {
    public static final Lazy<Field> Z = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final Lazy<Field> f248846a0 = null;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final SparseArray<c> f248847b0 = null;
    public int A;
    public final byte[][] B;
    public final byte[][] C;
    public final y46.a[] D;
    public final y46.a[] E;
    public final y46.d F;
    public final byte[] G;
    public final byte[] H;
    public final List<Integer> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final List<Integer> f248848J;
    public final List<Float> K;
    public final List<Float> L;
    public final List<Long> M;
    public volatile boolean N;
    public final Map<Object, Function0<Boolean>> O;
    public k P;
    public final CopyOnWriteArrayList<d> Q;
    public final Lazy R;
    public final CopyOnWriteArrayList<View> S;
    public final e T;
    public final FmpCalculator$onLayoutListener$1 U;
    public long V;
    public final g W;
    public final h X;
    public final int[] Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f248849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Window f248850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f248851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f248852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f248853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f248854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f248855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f248856h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DiffCalMode f248857i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f248858j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.ies.ugc.aweme.fmp.core.b f248859k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f248860l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f248861m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f248862n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f248863o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f248864p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f248865q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final StringBuffer f248866r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public FmpDebugInfoTextView f248867s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public FmpCallback f248868t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f248869u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Handler f248870v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f248871w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile boolean f248872x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f248873y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f248874z;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/ugc/aweme/fmp/core/FmpCalculator$LynxNotRenderException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "()V", "fmp-core_saasRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LynxNotRenderException extends RuntimeException {
        public LynxNotRenderException() {
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f248875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f248876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f248877c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f248875a == r101.f248875a) goto L12;
            return false;
        L12:
            if (this.f248876b == r101.f248876b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f248877c, r101.f248877c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public final int hashCode() {
            boolean r100 = this.f248875a;
            ?? r101 = r100;
            if (r100 == false) goto L6;
            r101 = 1;
        L6:
            return (((r101 * 31) + this.f248876b) * 31) + this.f248877c.hashCode();
        }

        public final String toString() {
            return "ChangeInfo(isStable=" + this.f248875a + ", reason=" + this.f248876b + ", extra=" + this.f248877c + ')';
        }

        public a(boolean r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "extra");
            this.f248875a = r100;
            this.f248876b = r101;
            this.f248877c = r102;
        }
    }

    public static final class b {
    }

    public static final class c implements Window.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f248878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Window.Callback f248879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CopyOnWriteArrayList<FmpCalculator> f248880c;

        @Override // android.view.Window.Callback
        public final void onAttachedToWindow() {
            this.f248879b.onAttachedToWindow();
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
            this.f248879b.onContentChanged();
        }

        @Override // android.view.Window.Callback
        public final void onDetachedFromWindow() {
            Iterator<FmpCalculator> r100 = this.f248880c.iterator();
        L4:
            if (r100.hasNext() == false) goto L10;
            FmpCalculator r101 = r100.next();
            ((LinkedHashMap) r101.O).clear();
            k r102 = r101.P;
            if (r102 == null) goto L4;
            ViewTreeObserver r103 = r101.f248849a.getViewTreeObserver();
            if (r103.isAlive() == false) goto L4;
            r103.removeOnPreDrawListener(r102);
            goto L4
        L10:
            this.f248880c.clear();
            Lazy<Field> r104 = FmpCalculator.Z;
            int r105 = this.f248878a;
            FmpCalculator.f248847b0.remove(r105);
            this.f248879b.onDetachedFromWindow();
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested() {
            return this.f248879b.onSearchRequested();
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchGenericMotionEvent(MotionEvent r100) {
            return this.f248879b.dispatchGenericMotionEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyEvent(KeyEvent r100) {
            return this.f248879b.dispatchKeyEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyShortcutEvent(KeyEvent r100) {
            return this.f248879b.dispatchKeyShortcutEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r100) {
            return this.f248879b.dispatchPopulateAccessibilityEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTouchEvent(MotionEvent r110) {
            Iterator<T> r100 = this.f248880c.iterator();
        L4:
            if (r100.hasNext() == false) goto L26;
            FmpCalculator r101 = (FmpCalculator) r100.next();
            monitor-enter(r101);
            if (r101.f248872x == true) goto L19;
            FmpCallback r102 = r101.f248868t;     // Catch: Throwable -> L22
            boolean r103 = false;
            if (r102 != null) goto L12;
        L14:
            if (r103 == false) goto L19;
            FmpCallback.Type r104 = FmpCallback.Type.Touch;     // Catch: Throwable -> L22
            long r105 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L22
            if (r101.f248872x == true) goto L18;
            r101.f248872x = true;     // Catch: Throwable -> L22
            long r106 = r101.f248851c;     // Catch: Throwable -> L22
            r101.f248862n = r105 - r106;     // Catch: Throwable -> L22
            r101.r(r104, r105 - r106, r105);     // Catch: Throwable -> L22
        L18:
            r101.t();     // Catch: Throwable -> L22
            goto L19
        L12:
            if (r102.g() != true) goto L14;
            r103 = true;
        L19:
            Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L22
            monitor-exit(r101);
        L22:
            th = move-exception;
            throw th;
        L26:
            return this.f248879b.dispatchTouchEvent(r110);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTrackballEvent(MotionEvent r100) {
            return this.f248879b.dispatchTrackballEvent(r100);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeFinished(ActionMode r100) {
            this.f248879b.onActionModeFinished(r100);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeStarted(ActionMode r100) {
            this.f248879b.onActionModeStarted(r100);
        }

        @Override // android.view.Window.Callback
        public final View onCreatePanelView(int r100) {
            return this.f248879b.onCreatePanelView(r100);
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested(SearchEvent r100) {
            return this.f248879b.onSearchRequested(r100);
        }

        @Override // android.view.Window.Callback
        public final void onWindowAttributesChanged(WindowManager.LayoutParams r100) {
            this.f248879b.onWindowAttributesChanged(r100);
        }

        @Override // android.view.Window.Callback
        public final void onWindowFocusChanged(boolean r100) {
            this.f248879b.onWindowFocusChanged(r100);
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback r100) {
            return this.f248879b.onWindowStartingActionMode(r100);
        }

        public c(int r100, Window.Callback r101) {
            Intrinsics.checkNotNullParameter(r101, "originCallback");
            this.f248878a = r100;
            this.f248879b = r101;
            this.f248880c = new CopyOnWriteArrayList();
        }

        @Override // android.view.Window.Callback
        public final boolean onCreatePanelMenu(int r100, Menu r101) {
            Intrinsics.checkNotNullParameter(r101, TplType.MENU);
            return this.f248879b.onCreatePanelMenu(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuItemSelected(int r100, MenuItem r101) {
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            return this.f248879b.onMenuItemSelected(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuOpened(int r100, Menu r101) {
            Intrinsics.checkNotNullParameter(r101, TplType.MENU);
            return this.f248879b.onMenuOpened(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final void onPanelClosed(int r100, Menu r101) {
            Intrinsics.checkNotNullParameter(r101, TplType.MENU);
            this.f248879b.onPanelClosed(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback r100, int r101) {
            return this.f248879b.onWindowStartingActionMode(r100, r101);
        }

        @Override // android.view.Window.Callback
        public final boolean onPreparePanel(int r100, View r101, Menu r102) {
            Intrinsics.checkNotNullParameter(r102, TplType.MENU);
            return this.f248879b.onPreparePanel(r100, r101, r102);
        }
    }

    public interface d {
        void a();

        void b();

        void c();

        void d(long r100, long r101, byte[] r102, byte[] r103, int r104, int r105, int r106, int r110, float r111, float r112, a r113, y46.b r114);
    }

    public static final class e implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f248881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f248882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FmpCalculator f248883c;

        @Override // com.bytedance.ies.ugc.aweme.fmp.core.FmpCalculator.d
        public final void a() {
            if (this.f248883c.f248872x == true) goto L13;
            this.f248882b = true;
            FmpCalculator r100 = this.f248883c;
            r100.f248870v.removeCallbacks(r100.W);
            if (this.f248883c.f248872x == true) goto L14;
            FmpCalculator r101 = this.f248883c;
            if (r101.f248865q == false) goto L15;
            r101.f248866r.append("\n LynxView还没开始渲染，本次计算作废，currentTimestamps=" + SystemClock.elapsedRealtime());
            FmpDebugInfoTextView r102 = r101.f248867s;
            if (r102 == null) goto L16;
            r102.setText(r101.f248866r.toString());
            return;
        L16:
            return;
        L15:
            return;
        L14:
            return;
        }

        @Override // com.bytedance.ies.ugc.aweme.fmp.core.FmpCalculator.d
        public final void b() {
            if (this.f248883c.f248872x == true) goto L11;
            FmpCalculator r100 = this.f248883c;
            if (r100.f248865q == false) goto L9;
            FmpDebugInfoTextView r101 = r100.f248867s;
            if (r101 == null) goto L9;
            r101.f248894e.clear();
            ((ArrayList) r101.f248891b).clear();
            r101.invalidate();
        L9:
            this.f248881a = SystemClock.elapsedRealtime();
            return;
        }

        @Override // com.bytedance.ies.ugc.aweme.fmp.core.FmpCalculator.d
        public final void c() {
            if (this.f248883c.f248872x == false) goto L5;
            return;
        L5:
            if (this.f248883c.f248872x == true) goto L7;
            long r100 = SystemClock.elapsedRealtime();
            FmpCalculator r101 = this.f248883c;
            r101.f248864p++;
            r101.f248863o += r100 - this.f248881a;
        L7:
            this.f248883c.getClass();
            FmpCalculator r102 = this.f248883c;
            r102.f248870v.postDelayed(r102.X, r102.f248854f);
        }

        public e(FmpCalculator r100) {
            this.f248883c = r100;
            this.f248881a = SystemClock.elapsedRealtime();
        }

        @Override // com.bytedance.ies.ugc.aweme.fmp.core.FmpCalculator.d
        public final void d(final long r110, long r210, byte[] r211, byte[] r212, int r213, int r214, final int r215, final int r216, final float r217, final float r218, a r310, y46.b r311) {
            Intrinsics.checkNotNullParameter(r211, "widthResult");
            Intrinsics.checkNotNullParameter(r212, "heightResult");
            Intrinsics.checkNotNullParameter(r310, "changeInfo");
            if (this.f248883c.f248872x == true) goto L28;
            FmpCallback r100 = this.f248883c.f248868t;
            if (r100 == null) goto L7;
            r100.f(r210, r110, r213, r214, r215, r216, r217, r218, r310.f248875a);
        L7:
            FmpCallback r101 = this.f248883c.f248868t;
            if (r101 == null) goto L12;
            r101.d(r210, r110, r211, r212, r213, r214, r215, r216, r217, r218, r310.f248875a, r311);
        L12:
            if (r310.f248875a == true) goto L24;
            this.f248882b = false;
            FmpCalculator r102 = this.f248883c;
            long r103 = this.f248881a;
            r102.f248870v.removeCallbacks(r102.W);
            r102.V = r110;
            r102.f248870v.postDelayed(r102.W, ((long) r102.f248869u) - (r103 - r110));
            if (this.f248883c.f248872x == true) goto L22;
            final FmpCalculator r104 = this.f248883c;
            final long r105 = r110 - r104.f248851c;
            if (r104.f248865q == false) goto L22;
            final long r106 = SystemClock.elapsedRealtime();
            if (FmpCalculator.a(r104.f248850b).isAttachedToWindow() == false) goto L21;
            r104.s(r106, r110, r105, r215, r217, r216, r218);
            goto L22
        L21:
            FmpCalculator.a(r104.f248850b).post(new i(r104, r106, r110, r105, r215, r217, r216, r218));
        L22:
            FmpCalculator.c(this.f248883c, true);
            return;
        L24:
            if (this.f248882b == false) goto L26;
            FmpCalculator r107 = this.f248883c;
            long r108 = this.f248881a;
            r107.f248870v.removeCallbacks(r107.W);
            r107.V = r110;
            r107.f248870v.postDelayed(r107.W, ((long) r107.f248869u) - (r108 - r110));
            this.f248882b = false;
        L26:
            FmpCalculator.c(this.f248883c, false);
            return;
        }
    }

    public final void t() {
        this.f248872x = true;
        e r100 = this.T;
        this.Q.remove(r100);
        ViewTreeObserver r101 = this.f248849a.getViewTreeObserver();
        if (r101 != null) goto L6;
    L15:
        Handler r102 = this.f248870v;
        r102.removeCallbacks(this.W);
        r102.removeCallbacks(this.X);
        ((LinkedHashMap) this.O).clear();
        k r103 = this.P;
        if (r103 == null) goto L20;
        ViewTreeObserver r104 = this.f248849a.getViewTreeObserver();
        if (r104.isAlive() == false) goto L20;
        r104.removeOnPreDrawListener(r103);
    L20:
        this.S.clear();
        if (this.N == false) goto L24;
        this.N = false;
    L24:
        if (this.f248858j == false) goto L28;
        c r105 = this.f248861m;
        if (r105 == null) goto L35;
        Intrinsics.checkNotNullParameter(this, "fmpCalculator");
        r105.f248880c.remove(this);
        return;
    L35:
        return;
    L28:
        int r106 = z46.a.f570025a;
        Runnable r107 = new com.bytedance.ies.ugc.aweme.fmp.core.d(this);
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L31;
        r107.run();
        return;
    L31:
        this.f248870v.post(r107);
        return;
    L6:
        if (this.Q.size() != 0) goto L15;
        FmpCalculator$onLayoutListener$1 r108 = this.U;
        monitor-enter(r108);
        r101.removeOnGlobalLayoutListener(this.U);     // Catch: Throwable -> L12
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r108);
    L12:
        th = move-exception;
        throw th;
    }

    static {
        Z = LazyKt.lazy(FmpCalculator$Companion$srcField$2.INSTANCE);
        f248846a0 = LazyKt.lazy(FmpCalculator$Companion$mIsFirstLayoutField$2.INSTANCE);
        f248847b0 = new SparseArray();
    }

    public final void g() {
        byte[] r100 = this.B[this.A & 1];
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100[r102] = 0;
        r102 = r102 + 1;
        goto L3
    L5:
        byte[] r103 = this.C[this.A & 1];
        int r104 = r103.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L9;
        r103[r105] = 0;
        r105 = r105 + 1;
        goto L6
    L9:
        if (this.f248857i == DiffCalMode.CLOSE) goto L17;
        int r106 = this.A & 1;
        y46.a r107 = this.D[r106];
        ((LinkedHashMap) r107.f566040a).clear();
        Set<String> r108 = r107.f566042c;
        if (r108 == null) goto L13;
        ((HashSet) r108).clear();
    L13:
        r107.f566041b = this.A;
        return;
    }

    public final void h() {
        if (this.f248857i != DiffCalMode.CLOSE) goto L5;
        return;
    L5:
        y46.a[] r100 = this.D;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L6:
        if (r102 >= r101) goto L20;
        y46.a r104 = r100[r102];
        int r105 = r103 + 1;
        y46.a r106 = this.E[r103];
        r106.getClass();
        Intrinsics.checkNotNullParameter(r104, "leafViewsSnapshot");
        r106.f566041b = r104.f566041b;
        ((LinkedHashMap) r106.f566040a).clear();
        Set<String> r107 = r106.f566042c;
        if (r107 == null) goto L10;
        ((HashSet) r107).clear();
    L10:
        r106.f566042c = null;
        Map<String, Pair<Rect, y46.e>> r108 = r104.f566040a;
        if (r108 == null) goto L13;
        r106.f566040a.putAll(r108);
    L13:
        Set<String> r109 = r104.f566042c;
        if (r109 == null) goto L19;
        Set r110 = r106.f566042c;
        if (r110 != null) goto L18;
        r110 = new HashSet();
        r106.f566042c = r110;
    L18:
        r110.addAll(r109);
    L19:
        r102 = r102 + 1;
        r103 = r105;
        goto L6
    }

    public final int n() {
        byte[][] r100 = this.C;
        int r101 = 0;
        byte[] r102 = r100[0];
        byte[] r103 = r100[1];
        int r104 = this.f248874z;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L9;
        byte[] r106 = this.H;
        if (r102[r105] == r103[r105]) goto L7;
        byte r107 = 1;
    L8:
        r106[r105] = r107;
        r105 = r105 + 1;
        goto L3
    L7:
        r107 = 0;
        goto L8
    L9:
        int r108 = this.f248874z;
        int r109 = 0;
    L10:
        if (r101 >= r108) goto L15;
        if (this.H[r101] != 1) goto L14;
        r109 = r109 + 1;
    L14:
        r101 = r101 + 1;
        goto L10
    L15:
        return r109;
    }

    public final int o() {
        byte[][] r100 = this.B;
        int r101 = 0;
        byte[] r102 = r100[0];
        byte[] r103 = r100[1];
        int r104 = this.f248873y;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L9;
        byte[] r106 = this.G;
        if (r102[r105] == r103[r105]) goto L7;
        byte r107 = 1;
    L8:
        r106[r105] = r107;
        r105 = r105 + 1;
        goto L3
    L7:
        r107 = 0;
        goto L8
    L9:
        int r108 = this.f248873y;
        int r109 = 0;
    L10:
        if (r101 >= r108) goto L15;
        if (this.G[r101] != 1) goto L14;
        r109 = r109 + 1;
    L14:
        r101 = r101 + 1;
        goto L10
    L15:
        return r109;
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static boolean m(LynxBaseUI r100) {
        Rect r101 = r100.getBound();
        if (r101 != null) goto L5;
    L14:
        return true;
    L5:
        if (r100.getTop() <= r101.bottom) goto L7;
    L13:
        return false;
    L7:
        if (r100.getLeft() > r101.right) goto L13;
        if ((r100.getLeft() + r100.getWidth()) < r101.left) goto L13;
        if ((r100.getTop() + r100.getHeight()) < r101.top) goto L13;
        goto L13
    }

    public final boolean e(Drawable r100) {
        if (this.f248856h == true) goto L5;
        return true;
    L5:
        if ((r100 instanceof RootDrawable) == false) goto L14;
        Drawable r101 = ((RootDrawable) r100).getDrawable();
        if ((r101 instanceof FadeDrawable) == false) goto L15;
        FadeDrawable r102 = (FadeDrawable) r101;
        if (r102.getNumberOfLayers() > 2) goto L11;
        return true;
    L11:
        return r102.isLayerOn(2);
    L15:
        return true;
    L14:
        return true;
    }

    public final void j(boolean r100) {
        if (this.f248867s != null) goto L5;
        FmpDebugInfoTextView r101 = new FmpDebugInfoTextView(this.f248850b.getContext());
        r101.f248890a = true;
        r101.setTextColor(-65536);
        r101.setBackgroundColor(-16777216);
        r101.setAlpha(0.3f);
        r101.setTextSize(14.0f);
        r101.setGravity(80);
        r101.setPadding((int) m.a(this.f248850b.getContext(), 5.0f), (int) m.a(this.f248850b.getContext(), 5.0f), (int) m.a(this.f248850b.getContext(), 5.0f), (int) m.a(this.f248850b.getContext(), 44.0f));
        this.f248867s = r101;
    L5:
        WindowManager r102 = this.f248850b.getWindowManager();
        if (r100 == false) goto L8;
        int r103 = 536;
    L9:
        FmpDebugInfoTextView r104 = this.f248867s;
        WindowManager.LayoutParams r105 = new WindowManager.LayoutParams(1000, r103);
        r105.token = a(this.f248850b).getWindowToken();
        r105.format = 1;
        r105.gravity = 8388659;
        r105.height = -1;
        r105.width = -1;
        r105.x = 0;
        r105.y = 0;
        Unit r106 = Unit.INSTANCE;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r104, r105);
        r102.addView(r104, r105);
        return;
    L8:
        r103 = 24;
        goto L9
    }

    public static final void c(FmpCalculator r100, boolean r101) {
        if (r100.f248865q == false) goto L15;
        FmpDebugInfoTextView r102 = r100.f248867s;
        if (r102 == null) goto L16;
        if (r101 == false) goto L11;
        ArrayList r103 = new ArrayList();
        r103.addAll(r102.f248894e);
        r102.f248891b = r103;
        ((ArrayList) r102.f248892c).clear();
        Iterator r104 = ((ArrayList) r102.f248891b).iterator();
    L9:
        if (r104.hasNext() == false) goto L12;
        FmpDebugInfoTextView.b r105 = (FmpDebugInfoTextView.b) r104.next();
        ((ArrayList) r102.f248892c).add(r105);
    L12:
        r102.invalidate();
        return;
    L11:
        ArrayList r106 = new ArrayList();
        r106.addAll(r102.f248892c);
        r102.f248891b = r106;
        goto L12
    L16:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.ies.ugc.aweme.fmp.core.k] */
    public final void d(Object r100, Function0<Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        Intrinsics.checkNotNullParameter(r101, "drawableValid");
        if (r101.invoke().booleanValue() == false) goto L7;
        this.O.remove(r100);
        return;
    L7:
        if (this.O.containsKey(r100) == true) goto L10;
        this.O.put(r100, r101);
    L10:
        if (this.P != null) goto L13;
        this.P = new k(this);
        this.f248849a.getViewTreeObserver().addOnPreDrawListener(this.P);
        return;
    }

    public final boolean q(View r100, int r101, int r102) {
        if (r100.isAttachedToWindow() == true) goto L5;
        return false;
    L5:
        if (r100.getVisibility() == 0) goto L7;
        return false;
    L7:
        if (r100.getWidth() > 0) goto L9;
        return false;
    L9:
        if (r100.getHeight() > 0) goto L11;
        return false;
    L11:
        if (r100.getAlpha() <= 0.0f) goto L27;
        int r103 = r100.getMeasuredWidth() + r101;
        int r104 = r100.getMeasuredHeight() + r102;
        if (r101 >= this.f248873y) goto L19;
        if (r103 <= 0) goto L19;
        if (r102 >= this.f248874z) goto L19;
        if (r104 <= 0) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == false) goto L28;
        return true;
    L28:
        return false;
    L19:
        r105 = false;
        goto L20
    L27:
        return false;
    }

    public final void r(final FmpCallback.Type r210, final long r211, final long r212) {
        final long r100 = SystemClock.elapsedRealtime();
        final long r101 = this.f248863o;
        final long r110 = this.f248864p;
        if (this.f248865q == false) goto L6;
        a(this.f248850b).post(new f(this, r100, r212, r211, r210, r101, r110));
    L6:
        FmpCallback r102 = this.f248868t;
        if (r102 == null) goto L14;
        long r103 = this.f248863o;
        long r104 = this.f248864p;
        long r105 = 0;
        if (r104 == 0) goto L12;
        r105 = r103 / r104;
    L12:
        r102.h(r210, r211, r212, new FmpCallback.b(r103, r104, r105));
        return;
    }

    public static final void b(FmpCalculator r210, long r211, Function10 r212, Function0 r213) {
        monitor-enter(r210);
        r210.f248849a.getLocationOnScreen(r210.Y);     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        View r100 = r210.f248849a;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        int[] r101 = r210.Y;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        if (r210.q(r100, r101[0], r101[1]) == true) goto L8;
        monitor-exit(r210);
        return;
    L8:
        r210.S.clear();     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        View r102 = r210.f248849a;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        int[] r103 = r210.Y;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        int r104 = r103[0];     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        int r105 = r103[1];     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        byte[][] r106 = r210.B;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        int r107 = r210.A & 1;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        byte[] r108 = r106[r107];     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        byte[] r109 = r210.C[r107];     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        FmpCallback r110 = r210.f248868t;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        y46.b r111 = null;
        if (r110 == null) goto L11;
        String r112 = r110.e(r102);     // Catch: Throwable -> L37 LynxNotRenderException -> L41
    L12:
        r210.i(r102, r104, r105, r108, r109, null, null, r112);     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        if (r210.A != 0) goto L15;
        long r113 = r210.f248851c;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
    L16:
        int r114 = r210.o();     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        float r115 = r211 - r113;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        float r116 = r114 / r115;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        ((ArrayList) r210.I).add(Integer.valueOf(r114));     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        ((ArrayList) r210.K).add(Float.valueOf(r116));     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        int r117 = r210.n();     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        float r118 = r117 / r115;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        ((ArrayList) r210.f248848J).add(Integer.valueOf(r117));     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        ((ArrayList) r210.L).add(Float.valueOf(r118));     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        ((ArrayList) r210.M).add(Long.valueOf(r211));     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        byte[] r119 = r210.B[r210.A & 1];     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        int r120 = r119.length;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        int r121 = 0;
        int r122 = 0;
    L17:
        if (r121 >= r120) goto L22;
        if (r119[r121] != 1) goto L21;
        r122 = r122 + 1;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
    L21:
        r121 = r121 + 1;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        goto L17
    L22:
        byte[] r123 = r210.C[r210.A & 1];     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        int r124 = r123.length;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        int r125 = 0;
        int r126 = 0;
    L23:
        if (r125 >= r124) goto L28;
        if (r123[r125] != 1) goto L27;
        r126 = r126 + 1;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
    L27:
        r125 = r125 + 1;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        goto L23
    L28:
        a r127 = r210.p(r114, r117, r116, r118);     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        if (r127.f248875a == true) goto L35;
        y46.d r128 = r210.F;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        long[] r129 = r128.f566053a;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        int r130 = r128.f566054b;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        r129[r130] = r211;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        r128.f566054b = (r130 + 1) % 2;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        int r131 = r128.f566055c;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        if (r131 >= 2) goto L33;
        r128.f566055c = r131 + 1;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
    L33:
        r210.h();     // Catch: Throwable -> L37 LynxNotRenderException -> L41
    L35:
        if (r210.f248857i != DiffCalMode.CAL_EACH_CALLBACK) goto L39;
        y46.a[] r132 = r210.D;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        r111 = r132[0].a(r132[1], r210.f248873y, r210.f248874z, 0);     // Catch: Throwable -> L37 LynxNotRenderException -> L41
    L39:
        r212.invoke(Long.valueOf(r211 - r210.f248851c), Long.valueOf(r211), Integer.valueOf(r122), Integer.valueOf(r126), Integer.valueOf(r114), Integer.valueOf(r117), Float.valueOf(r116), Float.valueOf(r118), r127, r111);     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        r210.A++;     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        r210.g();     // Catch: Throwable -> L37 LynxNotRenderException -> L41
    L42:
        Unit r133 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(r210);
        return;
    L15:
        r113 = ((Number) CollectionsKt.last(r210.M)).longValue();     // Catch: Throwable -> L37 LynxNotRenderException -> L41
        goto L16
    L11:
        r112 = null;
    L37:
        th = move-exception;
        throw th;
    L41:
        r213.invoke();     // Catch: Throwable -> L37
        goto L42
    }

    public static void k(FmpCalculator r100, int r101, int r102, byte[] r103) {
        int r104 = r100.f248874z;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "array");
        if (r101 >= 0) goto L6;
        r101 = 0;
    L6:
        if (r102 < r104) goto L9;
        r102 = r104 - 1;
    L9:
        if (r101 >= r102) goto L11;
        r103[r101] = 1;
        r101 = r101 + 1;
        goto L9
    }

    public static void l(FmpCalculator r100, int r101, int r102, byte[] r103) {
        int r104 = r100.f248873y;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "array");
        if (r101 >= 0) goto L6;
        r101 = 0;
    L6:
        if (r102 < r104) goto L9;
        r102 = r104 - 1;
    L9:
        if (r101 >= r102) goto L11;
        r103[r101] = 1;
        r101 = r101 + 1;
        goto L9
    }

    public final a p(int r100, int r101, float r102, float r103) {
        float r104 = this.f248853e;
        if (r102 >= r104) goto L16;
        if (r103 >= r104) goto L16;
        int r105 = this.f248852d;
        if (r100 >= r105) goto L14;
        if (r101 >= r105) goto L14;
        return new a(true, 0, "");
    L14:
        return new a(false, 1, String.valueOf(Math.max(r100, r101)));
    L16:
        return new a(false, 2, String.valueOf(Math.max(r102, r103)));
    }

    public final void u(final int r100, final int r110, final int r111, final int r112) {
        if (this.f248865q == true) goto L6;
        return;
    L6:
        if (a(this.f248850b).isAttachedToWindow() == false) goto L8;
        v(r100, r110, r111, r112);
        return;
    L8:
        a(this.f248850b).post(new j(this, r100, r110, r111, r112));
    }

    public final void v(int r100, int r101, int r102, int r103) {
        if (this.f248872x == true) goto L5;
        int r104 = FakePickerAvatarCreator.CYAN;
    L6:
        FmpDebugInfoTextView r105 = this.f248867s;
        if (r105 == null) goto L10;
        r105.f248894e.add(new FmpDebugInfoTextView.b(r104, new Rect(r100, r101, r102, r103)));
        return;
    L10:
        return;
    L5:
        r104 = -65536;
        goto L6
    }

    public final void s(long r100, long r101, long r102, int r110, float r111, int r112, float r113) {
        long r103 = SystemClock.elapsedRealtime() - r100;
        this.f248866r.append("\nFMP calculating:  currentTimestamps=" + (r101 + r103) + ",diff=" + r103 + " duration=" + r102 + ",widthXor=" + r110 + ",widthRate:" + r111 + ",heightXor=" + r112 + ",heightRate:" + r113);
        FmpDebugInfoTextView r104 = this.f248867s;
        if (r104 == null) goto L7;
        r104.setText(this.f248866r.toString());
        return;
    }

    public final void i(final View r210, int r211, int r212, byte[] r213, byte[] r214, byte[] r310, byte[] r311, String r312) {
        if (this.S.contains(r210) == false) goto L5;
        return;
    L5:
        this.S.add(r210);
        DiffCalMode r100 = this.f248857i;
        DiffCalMode r101 = DiffCalMode.CLOSE;
        if (r100 == r101) goto L21;
        com.bytedance.ies.ugc.aweme.fmp.core.b r102 = this.f248859k;
        if (r102 != null) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r103 == false) goto L21;
        if (r312 == null) goto L21;
        if (((Set) this.f248871w.getValue()).add(r312) == false) goto L21;
        y46.a r104 = this.D[this.A & 1];
        r104.getClass();
        Intrinsics.checkNotNullParameter(r312, "viewGroupTag");
        Set r105 = r104.f566042c;
        if (r105 != null) goto L20;
        r105 = new HashSet();
        r104.f566042c = r105;
    L20:
        r105.add(r312);
        goto L21
    L10:
        if (r102.f248906b != true) goto L12;
        r103 = true;
    L21:
        Unit r110 = null;
        if (Intrinsics.areEqual((Boolean) r210.getTag(R.id.fmp_invalid_view_mark), Boolean.TRUE) == true) goto L28;
        FmpCallback r106 = this.f248868t;
        if (r106 != null) goto L27;
    L216:
        if ((r210 instanceof LynxView) == false) goto L73;
        LynxView r107 = (LynxView) r210;     // Catch: ClassNotFoundException -> L70
        if (r107.getVisibility() != 0) goto L64;
        if (r107.getWidth() <= 0) goto L64;
        if (r107.getHeight() <= 0) goto L64;
        UIGroup<UIBody.UIBodyView> r108 = r107.getLynxUIRoot();     // Catch: ClassNotFoundException -> L70
        if (r108 != null) goto L47;
        com.bytedance.ies.ugc.aweme.fmp.core.b r109 = this.f248859k;     // Catch: ClassNotFoundException -> L45
        if (r109 == null) goto L44;
        if (r109.f248905a != true) goto L44;
    L52:
        boolean r111 = true;
    L65:
        if (r111 == false) goto L214;
        int r112 = r211;
        int r113 = r212;
        byte[] r114 = r310;
        byte[] r115 = r311;
    L67:
        String r116 = r312;
    L125:
        boolean r117 = true;
    L131:
        if (r117 == false) goto L134;
        return;
    L134:
        if ((r210 instanceof ViewGroup) == false) goto L227;
        if (r116 != null) goto L140;
        FmpCallback r118 = this.f248868t;
        if (r118 == null) goto L139;
        String r119 = r118.e(r210);
    L141:
        FmpCallback r120 = this.f248868t;
        if (r120 == null) goto L144;
        boolean r121 = r120.b(r210);
    L145:
        if (r121 == false) goto L150;
        byte[] r122 = new byte[this.f248873y];
        byte[] r123 = new byte[this.f248874z];
        Map r124 = (Map) this.R.getValue();
        Object r125 = r124.get(r210);
        if (r125 != null) goto L149;
        r125 = new com.bytedance.ies.ugc.aweme.fmp.core.a(r112, r113, new byte[this.f248873y], new byte[this.f248874z]);
        r124.put(r210, r125);
    L149:
        byte[] r126 = r123;
        com.bytedance.ies.ugc.aweme.fmp.core.a r127 = (com.bytedance.ies.ugc.aweme.fmp.core.a) r125;
        byte[] r128 = r122;
    L151:
        ViewGroup r129 = (ViewGroup) r210;
        int r130 = r129.getChildCount();
        int r131 = 0;
    L152:
        if (r131 >= r130) goto L160;
        View r132 = r129.getChildAt(r131);
        if (r132 != null) goto L156;
    L155:
        ViewGroup r215 = r129;
        byte[] r133 = r128;
        byte[] r313 = r126;
    L159:
        r131 = r131 + 1;
        r126 = r313;
        r128 = r133;
        r127 = r127;
        r130 = r130;
        r129 = r215;
        r113 = r212;
        goto L152
    L156:
        int r134 = r132.getLeft() + (r112 - r129.getScrollX());
        int r135 = r132.getTop() + (r113 - r129.getScrollY());
        if (q(r132, r134, r135) == false) goto L155;
        r133 = r128;
        r313 = r126;
        r215 = r129;
        i(r132, r134, r135, r213, r214, r133, r313, r119);
        goto L159
    L160:
        ViewGroup r216 = r129;
        byte[] r136 = r128;
        byte[] r314 = r126;
        com.bytedance.ies.ugc.aweme.fmp.core.a r137 = r127;
        if (r121 == false) goto L168;
        if (r114 == null) goto L168;
        if (r115 == null) goto L168;
        if (r136 == null) goto L168;
        byte[] r138 = r314;
        if (r138 == null) goto L169;
        m.b(r136, r114);
        m.b(r138, r115);
    L169:
        if (r137 == null) goto L228;
        byte[] r139 = r137.f248899c;
        Intrinsics.checkNotNull(r136);
        int r140 = m.c(r139, r136);
        byte[] r141 = r137.f248900d;
        Intrinsics.checkNotNull(r138);
        int r142 = m.c(r141, r138);
        long r143 = SystemClock.elapsedRealtime();
        float r144 = r143 - r137.f248902f;
        a r145 = p(r140, r142, r140 / r144, r142 / r144);
        int r146 = r137.f248897a - r112;
        com.bytedance.ies.ugc.aweme.fmp.core.a r147 = r137;
        int r148 = r137.f248898b - r212;
        a r149 = p(r146, r148, r146 / r144, r148 / r144);
        boolean r150 = r145.f248875a;
        boolean r151 = r149.f248875a;
        if (r147.f248903g == r150) goto L173;
    L176:
        boolean r152 = true;
    L177:
        if (r152 == false) goto L208;
        r147.f248903g = r150;
        r147.f248904h = r151;
        FmpCallback r153 = this.f248868t;
        if (r153 == null) goto L183;
        long r154 = r147.f248902f;
        r153.a(r210, r150, r151, r154 - r147.f248901e, r154);
    L183:
        if (this.f248865q == true) goto L185;
    L207:
        r136 = r136;
    L209:
        r147.f248902f = r143;
        r147.f248897a = r112;
        r147.f248898b = r212;
        byte[] r155 = r136;
        Intrinsics.checkNotNullParameter(r155, "<set-?>");
        r147.f248899c = r155;
        byte[] r156 = r138;
        Intrinsics.checkNotNullParameter(r156, "<set-?>");
        r147.f248900d = r156;
        return;
    L185:
        if (r145.f248875a == false) goto L207;
        long r157 = r147.f248902f;
        long r158 = r157 - r147.f248901e;
        Object r159 = r216.getTag(R.id.card_fmp_test);
        if ((r159 instanceof FmpDebugInfoTextView) == false) goto L189;
        FmpDebugInfoTextView r160 = (FmpDebugInfoTextView) r159;
    L190:
        if (r160 != null) goto L193;
        r160 = new FmpDebugInfoTextView(this.f248850b.getContext());
        r160.setTextColor(FakePickerAvatarCreator.GREEN);
        r160.setBackgroundColor(0);
        r160.setTextSize(18.0f);
        r160.setGravity(49);
        r160.setPadding((int) m.a(this.f248850b.getContext(), 5.0f), (int) m.a(this.f248850b.getContext(), 5.0f), (int) m.a(this.f248850b.getContext(), 5.0f), (int) m.a(this.f248850b.getContext(), 44.0f));
        r216.setTag(R.id.card_fmp_test, r160);
    L193:
        StringBuilder r161 = new StringBuilder();
        r161.append(r157);
        r161.append(':');
        r161.append(r158);
        r160.setText(r161.toString());
        WindowManager r162 = this.f248850b.getWindowManager();
        if (this.f248860l == false) goto L196;
        int r163 = 536;
    L197:
        int[] r164 = new int[2];
        r216.getLocationInWindow(r164);
        Result.Companion r165 = Result.Companion;     // Catch: Throwable -> L203
        if (r162 == null) goto L201;
        r162.removeView(r160);     // Catch: Throwable -> L203
        r110 = Unit.INSTANCE;     // Catch: Throwable -> L203
    L201:
        Result.m9449constructorimpl(r110);     // Catch: Throwable -> L203
    L205:
        if (r162 == null) goto L209;
        WindowManager.LayoutParams r166 = new WindowManager.LayoutParams(1000, r163);
        r166.token = a(this.f248850b).getWindowToken();
        r166.format = 1;
        r166.gravity = 8388659;
        r166.height = r216.getMeasuredHeight();
        r166.width = r216.getMeasuredWidth();
        r166.x = r164[0];
        r166.y = r164[1];
        Unit r167 = Unit.INSTANCE;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r160, r166);
        r162.addView(r160, r166);
    L203:
        th = move-exception;
        Result.Companion r168 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L205
    L196:
        r163 = 24;
        goto L197
    L189:
        r160 = null;
        goto L190
    L208:
        r138 = r138;
        r136 = r136;
        r147 = r147;
        goto L209
    L173:
        if (r151 != r147.f248904h) goto L176;
        r152 = false;
        goto L177
    L228:
        return;
    L168:
        r138 = r314;
        goto L169
    L150:
        r128 = r114;
        r126 = r115;
        r127 = null;
        goto L151
    L144:
        r121 = false;
        goto L145
    L139:
        r119 = null;
        goto L141
    L140:
        r119 = r116;
        goto L141
    L227:
        return;
    L214:
        throw new LynxNotRenderException();     // Catch: ClassNotFoundException -> L211
    L44:
        r111 = false;
    L45:
        r116 = r312;
        r115 = r311;
        r112 = r211;
        r114 = r310;
        r113 = r212;
    L130:
        r117 = false;
        goto L131
    L47:
        if (r108.getWidth() > 0) goto L220;
    L55:
        com.bytedance.ies.ugc.aweme.fmp.core.b r169 = this.f248859k;     // Catch: ClassNotFoundException -> L70
        if (r169 == null) goto L62;
        if (r169.f248905a == true) goto L64;
    L62:
        r111 = false;
        goto L65
    L220:
    L54:
        r112 = r211;
        r113 = r212;
        r114 = r310;
        r115 = r311;
        r116 = r312;
        goto L130
    L49:
        if (r108.getHeight() <= 0) goto L55;
        f(r108, r211, r212, r211, r212, r211 + r107.getWidth(), r212 + r107.getHeight(), r213, r214, r310, r311, r312, r108.getName());     // Catch: ClassNotFoundException -> L54
    L64:
        r111 = true;
    L126:
        r112 = r211;
    L127:
        r113 = r212;
    L128:
        r114 = r310;
        r115 = r311;
        r116 = r312;
        goto L130
    L73:
        if ((r210 instanceof ViewStub) == true) goto L126;
        if ((r210 instanceof ViewGroup) == true) goto L126;
        if (TextUtils.equals(r210.getClass().getName(), View.class.getName()) == true) goto L126;
        r112 = r211;
        if (r112 >= this.f248873y) goto L127;
        r113 = r212;
        if (r113 >= this.f248874z) goto L128;
        if ((r210.getWidth() + r112) <= 0) goto L128;
        if ((r210.getHeight() + r113) <= 0) goto L128;
        if ((r210 instanceof ImageView) == false) goto L98;
        d(r210, new FmpCalculator$setMeaningfulAreaForValidView$1(r210, this));
        ImageView r170 = (ImageView) r210;
        if (r170.getDrawable() == null) goto L128;
        if (e(r170.getDrawable()) == false) goto L128;
    L102:
        r114 = r310;
        if (r114 == null) goto L112;
        int r171 = r210.getLeft();
        ViewParent r172 = r210.getParent();
        if ((r172 instanceof ViewGroup) == false) goto L107;
        ViewGroup r173 = (ViewGroup) r172;
    L108:
        if (r173 == null) goto L110;
        int r174 = r173.getScrollX();
    L111:
        int r175 = r171 - r174;
        l(this, r175, r210.getWidth() + r175, r114);
        goto L112
    L110:
        r174 = 0;
        goto L111
    L107:
        r173 = null;
    L112:
        r115 = r311;
        if (r115 == null) goto L122;
        int r176 = r210.getTop();
        ViewParent r177 = r210.getParent();
        if ((r177 instanceof ViewGroup) == false) goto L117;
        ViewGroup r178 = (ViewGroup) r177;
    L118:
        if (r178 == null) goto L120;
        int r179 = r178.getScrollY();
    L121:
        int r180 = r176 - r179;
        k(this, r180, r210.getHeight() + r180, r115);
        goto L122
    L120:
        r179 = 0;
        goto L121
    L117:
        r178 = null;
    L122:
        u(r112, r113, r210.getWidth() + r112, r210.getHeight() + r113);
        l(this, r112, r210.getWidth() + r112, r213);
        k(this, r113, r210.getHeight() + r113, r214);
        if (this.f248857i == r101) goto L67;
        Rect r181 = new Rect(RangesKt.coerceAtLeast(r112, 0), RangesKt.coerceAtLeast(r113, 0), RangesKt.coerceAtMost(r210.getWidth() + r112, this.f248873y - 1), RangesKt.coerceAtMost(r210.getHeight() + r113, this.f248874z - 1));
        y46.a r182 = this.D[this.A & 1];
        String r183 = String.valueOf(r210.hashCode());
        r116 = r312;
        y46.e r184 = new y46.e(r116, 30);
        r182.getClass();
        Intrinsics.checkNotNullParameter(r183, "viewIdentifyId");
        Intrinsics.checkNotNullParameter(r181, "position");
        r182.f566040a.put(r183, new Pair(r181, r184));
        goto L125
    L98:
        if ((r210 instanceof TextView) == false) goto L102;
        if (((TextView) r210).getText() != null) goto L102;
    L129:
        r116 = r312;
        r115 = r311;
        r112 = r211;
        r114 = r310;
        r113 = r212;
        goto L130
    L27:
        if ((!r106.c(r210)) == false) goto L216;
    L28:
        r116 = r312;
        r117 = true;
        r115 = r311;
        r112 = r211;
        r114 = r310;
        r113 = r212;
        goto L131
    }

    /* JADX WARN: Type inference failed for: r1v19, types: [com.bytedance.ies.ugc.aweme.fmp.core.g] */
    /* JADX WARN: Type inference failed for: r1v20, types: [com.bytedance.ies.ugc.aweme.fmp.core.h] */
    public FmpCalculator(String r110, View r111, Window r112, long r113, int r114, float r115, long r116, boolean r117, int r210, boolean r211, DiffCalMode r212, boolean r213, com.bytedance.ies.ugc.aweme.fmp.core.b r214) {
        Intrinsics.checkNotNullParameter(r110, "page");
        Intrinsics.checkNotNullParameter(r111, "mLayout");
        Intrinsics.checkNotNullParameter(r112, LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNullParameter(r212, "calDiffMode");
        this.f248849a = r111;
        this.f248850b = r112;
        this.f248851c = r113;
        this.f248852d = r114;
        this.f248853e = r115;
        this.f248854f = r116;
        this.f248855g = r117;
        this.f248856h = r211;
        this.f248857i = r212;
        this.f248858j = r213;
        this.f248859k = r214;
        if (r114 != Integer.MIN_VALUE) goto L5;
        this.f248852d = (int) m.a(r111.getContext(), 50.0f);
    L5:
        FmpCallback.Type r100 = FmpCallback.Type.Normal;
        this.f248866r = new StringBuffer();
        this.f248869u = r210;
        this.f248870v = new Handler(Looper.getMainLooper());
        this.f248871w = LazyKt.lazy(FmpCalculator$viewGroupTagSet$2.INSTANCE);
        if (r111.getContext().getResources().getConfiguration().orientation != 2) goto L8;
        boolean r101 = true;
    L9:
        int r102 = l.f248936a;
        Context r103 = r111.getContext().getApplicationContext();
        Intrinsics.checkNotNullParameter(r103, "application");
        int r104 = l.f248937b;
        if (r104 > 0) goto L16;
        l.a(r103);
        r104 = l.f248937b;
        if (r104 > 0) goto L16;
        r104 = 0;
    L16:
        Context r105 = r111.getContext().getApplicationContext();
        Intrinsics.checkNotNullParameter(r105, "application");
        int r106 = l.f248936a;
        if (r106 > 0) goto L23;
        l.a(r105);
        r106 = l.f248936a;
        if (r106 > 0) goto L23;
        r106 = 0;
    L23:
        if (r101 == false) goto L25;
        int r107 = r106;
    L26:
        this.f248873y = r107;
        if (r101 == true) goto L30;
        r104 = r106;
    L30:
        this.f248874z = r104;
        this.B = new byte[][]{new byte[r107], new byte[r107]};
        this.C = new byte[][]{new byte[r104], new byte[r104]};
        this.D = new y46.a[]{new y46.a(), new y46.a()};
        this.E = new y46.a[]{new y46.a(), new y46.a()};
        this.F = new y46.d();
        this.G = new byte[r107];
        this.H = new byte[r104];
        this.I = new ArrayList();
        this.f248848J = new ArrayList();
        this.K = new ArrayList();
        this.L = new ArrayList();
        this.M = new ArrayList();
        this.N = true;
        this.O = new LinkedHashMap();
        this.Q = new CopyOnWriteArrayList();
        this.R = LazyKt.lazy(FmpCalculator$cardFmpInfoMap$2.INSTANCE);
        this.S = new CopyOnWriteArrayList();
        this.T = new e(this);
        this.U = new FmpCalculator$onLayoutListener$1(this);
        this.W = new g(this);
        this.X = new h(this);
        this.Y = new int[2];
        return;
    L25:
        r107 = r104;
        goto L26
    L8:
        r101 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(final LynxBaseUI r210, int r211, int r212, int r213, int r214, int r310, int r311, byte[] r312, byte[] r313, byte[] r314, byte[] r315, String r316, String r317) {
        boolean r100 = r210 instanceof LynxUI;
        char r101 = 0;
        if (r100 == false) goto L14;
        View r102 = ((LynxUI) r210).getView();
        if (r102.getVisibility() == 0) goto L7;
    L19:
        boolean r103 = true;
    L20:
        if (r103 == false) goto L22;
        return;
    L22:
        int r104 = r211 + r210.getOriginLeft();
        int r105 = r212 + r210.getOriginTop();
        int r106 = 2;
        if ((r210 instanceof LynxFoldHeader) == false) goto L25;
    L32:
        int[] r107 = new int[2];
        View r108 = ((UIGroup) r210).getView();
        if (r108 == null) goto L252;
        r108.getLocationOnScreen(r107);
        int r109 = r107[0];
        int r110 = r107[1];
        if (q(r108, r109, r110) == true) goto L37;
        return;
    L37:
        int r111 = r109;
        int r112 = r110;
    L39:
        if (r210.getChildren().size() <= 0) goto L94;
        int r113 = r210.getChildren().size();
        int r114 = 0;
    L41:
        if (r114 >= r113) goto L266;
        LynxBaseUI r115 = r210.getChildAt(r114);
        if (r115 != null) goto L46;
    L54:
        r114 = r114;
        r113 = r113;
    L92:
        r114 = r114 + 1;
        r113 = r113;
        r106 = 2;
        r101 = 0;
        goto L41
    L46:
        if ((r210 instanceof UIList) == true) goto L48;
    L66:
        int r116 = r111;
        int r117 = r112;
    L67:
        int r118 = r115.getWidth() + r116;
        int r119 = r115.getHeight() + r117;
        if (r118 <= r310) goto L70;
        r118 = r310;
    L70:
        if (r119 <= r311) goto L72;
        r119 = r311;
    L72:
        if (r116 > r118) goto L91;
        if (r119 < r117) goto L91;
        if (r116 >= this.f248873y) goto L82;
        if (r118 <= 0) goto L82;
        if (r117 >= this.f248874z) goto L82;
        if (r119 <= 0) goto L82;
        boolean r120 = true;
    L83:
        if (r120 == false) goto L91;
        String r121 = r210.getName();
        if (r121 != null) goto L88;
        String r122 = r317;
    L89:
        f(r115, r116, r117, r213, r214, r310, r311, r312, r313, r314, r315, r316, r122);
        goto L91
    L88:
        r122 = r121;
    L82:
        r120 = false;
    L91:
        r112 = r117;
        r111 = r116;
        goto L92
    L48:
        if ((r115 instanceof UIComponent) == false) goto L62;
        UIComponent r123 = (UIComponent) r115;
        if (r123.getView() == 0) goto L57;
        int[] r124 = new int[r106];
        ((com.lynx.tasm.behavior.ui.view.a) r123.getView()).getLocationOnScreen(r124);
        int r125 = r124[r101];
        int r126 = r124[1];
        if (q(r123.getView(), r125, r126) == true) goto L55;
        r112 = r126;
        r111 = r125;
        goto L54
    L55:
        r117 = r126;
        r116 = r125;
        goto L67
    L57:
        if (this.f248865q == false) goto L66;
        throw new RuntimeException("lynx list中的item对应的native view为null");
    L62:
        if (this.f248865q == false) goto L66;
        throw new RuntimeException("lynx list中的item应该是UIComponent，实际却是" + r115);
    L266:
        return;
    L94:
        if ((r210 instanceof UIText) == false) goto L107;
        UIText r127 = (UIText) r210;
        CharSequence r128 = ((AndroidText) r127.getView()).getText();
        if (r128 != null) goto L98;
    L101:
        boolean r129 = true;
    L102:
        if (r129 == false) goto L104;
    L204:
        boolean r130 = false;
    L205:
        if (r130 == false) goto L244;
        int r131 = r210.getWidth() + r111;
        int r132 = r210.getHeight() + r112;
        int r133 = r310;
        if (r131 > r133) goto L210;
        r133 = r131;
    L210:
        int r134 = r311;
        if (r132 > r134) goto L214;
        r134 = r132;
    L214:
        if (r111 > r133) goto L242;
        if (r134 >= r112) goto L218;
        return;
    L218:
        if (r111 >= this.f248873y) goto L224;
        if (r133 <= 0) goto L224;
        if (r112 >= this.f248874z) goto L224;
        if (r134 <= 0) goto L224;
        boolean r135 = true;
    L225:
        if (r135 == true) goto L227;
        return;
    L227:
        u(r111, r112, r133, r134);
        if (r314 == null) goto L231;
        l(this, r111, r133, r314);
    L231:
        if (r315 == null) goto L233;
        k(this, r112, r134, r315);
    L233:
        l(this, r111, r133, r312);
        k(this, r112, r134, r313);
        if (this.f248857i == DiffCalMode.CLOSE) goto L261;
        Rect r136 = new Rect(RangesKt.coerceAtLeast(r111, 0), RangesKt.coerceAtLeast(r112, 0), RangesKt.coerceAtMost(r133, this.f248873y - 1), RangesKt.coerceAtMost(r134, this.f248874z - 1));
        y46.a r137 = this.D[this.A & 1];
        StringBuilder r138 = new StringBuilder();
        r138.append(r210.getLynxContext());
        r138.append('|');
        r138.append(r210.getSign());
        String r139 = r138.toString();
        String r140 = r210.getName();
        if (r140 != null) goto L238;
        r140 = r317;
    L238:
        String r141 = r210.getRefIdSelector();
        if (r141 != null) goto L241;
        r141 = r210.getIdSelector();
    L241:
        y46.e r142 = new y46.e(r316, r140, r141, r210.getExposureID(), r210.getExposureScene());
        r137.getClass();
        Intrinsics.checkNotNullParameter(r139, "viewIdentifyId");
        Intrinsics.checkNotNullParameter(r136, "position");
        r137.f566040a.put(r139, new Pair(r136, r142));
        return;
    L261:
        return;
    L224:
        r135 = false;
        goto L225
    L242:
        return;
    L244:
        if (r100 == false) goto L263;
        LynxUI r143 = (LynxUI) r210;
        View r144 = r143.getView();
        if ((r144 instanceof ViewGroup) == true) goto L248;
        return;
    L248:
        if ((r144 instanceof com.lynx.tasm.behavior.ui.view.a) == true) goto L265;
        i(r143.getView(), r111, r112, r312, r313, r314, r315, r316);
        return;
    L265:
        return;
    L263:
        return;
    L104:
        if (((AndroidText) r127.getView()).isAttachedToWindow() == false) goto L204;
    L203:
        r130 = true;
        goto L205
    L98:
        if (r128.length() == 0) goto L101;
        r129 = false;
        goto L102
    L107:
        if ((r210 instanceof FlattenUIText) == false) goto L120;
        CharSequence r145 = ((FlattenUIText) r210).getText();
        if (r145 != null) goto L111;
    L114:
        boolean r146 = true;
    L115:
        if (r146 == true) goto L204;
        if (m(r210) == false) goto L204;
    L111:
        if (r145.length() == 0) goto L114;
        r146 = false;
        goto L115
    L120:
        if ((r210 instanceof UIImage) == false) goto L134;
        UIImage r147 = (UIImage) r210;
        if (((FrescoImageView) r147.getView()).isAttachedToWindow() == false) goto L204;
        if (TextUtils.isEmpty(((FrescoImageView) r147.getView()).getSrc()) == true) goto L131;
        d(r147.getView(), new FmpCalculator$checkLynxBaseUIValid$valid$1(r210, this));
        if (((FrescoImageView) r147.getView()).getDrawable() == null) goto L204;
        if (e(((FrescoImageView) r147.getView()).getDrawable()) == false) goto L204;
    L131:
        if (((BackgroundDrawable) r147.getLynxBackground().f383142b) == null) goto L204;
    L134:
        if ((r210 instanceof FlattenUIImage) == false) goto L155;
        String r148 = null;
        Field r149 = Z.getValue();     // Catch: Exception -> L142
        if (r149 == null) goto L139;
        Object r150 = r149.get(r210);     // Catch: Exception -> L142
    L140:
        r148 = (String) r150;     // Catch: Exception -> L142
        goto L144
    L139:
        r150 = null;
    L144:
        if (TextUtils.isEmpty(r148) == true) goto L153;
        int r151 = FmpDebugInfoTextView.f248889f;
        Intrinsics.checkNotNullParameter("[FlattenUIImage]: new image -> " + r148, "content");
        d(r210, new FmpCalculator$checkLynxBaseUIValid$valid$2(r210, this));
        FlattenUIImage r152 = (FlattenUIImage) r210;
        if (r152.getImageDrawable() == null) goto L204;
        if (m(r210) == false) goto L204;
        if (e(r152.getImageDrawable()) == false) goto L204;
    L153:
        if (((BackgroundDrawable) ((FlattenUIImage) r210).getLynxBackground().f383142b) == null) goto L204;
    L155:
        if (r100 == false) goto L198;
        LynxUI r153 = (LynxUI) r210;
        if (r153.getView().isAttachedToWindow() == false) goto L204;
        if ((r153.getView() instanceof ImageView) == false) goto L178;
        View r154 = r153.getView();
        if (r154 == null) goto L176;
        d((ImageView) r154, new FmpCalculator$checkLynxBaseUIValid$valid$3(r210, this));
        View r155 = r153.getView();
        if (r155 == null) goto L174;
        if (((ImageView) r155).getDrawable() == null) goto L204;
        View r156 = r153.getView();
        if (r156 == null) goto L172;
        if (e(((ImageView) r156).getDrawable()) == false) goto L204;
    L172:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L174:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L176:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    L178:
        if ((r153.getView() instanceof TextView) == false) goto L193;
        View r157 = r153.getView();
        if (r157 == null) goto L191;
        CharSequence r158 = ((TextView) r157).getText();
        if (r158 != null) goto L184;
    L187:
        boolean r159 = true;
    L188:
        if (r159 == true) goto L204;
    L184:
        if (r158.length() == 0) goto L187;
        r159 = false;
        goto L188
    L191:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L193:
        if (this.f248855g == true) goto L204;
        if (r153.getView().getBackground() == null) goto L204;
    L198:
        if ((r210 instanceof LynxFlattenUI) == false) goto L204;
        if (this.f248855g == true) goto L204;
        if (((LynxFlattenUI) r210).getLynxBackground() == null) goto L204;
    L252:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L25:
        if ((r210 instanceof LynxFoldToolbar) == true) goto L32;
        if ((r210 instanceof LynxFoldSlot) == true) goto L32;
        if ((r210 instanceof LynxViewpagerItem) == true) goto L32;
        r112 = r105;
        r111 = r104;
        goto L39
    L7:
        if (r102.getAlpha() < 0.05d) goto L19;
        if (r102.getScaleX() < 0.01d) goto L19;
        if (r102.getScaleY() < 0.01d) goto L19;
    L18:
        r103 = false;
        goto L20
    L14:
        if ((r210 instanceof LynxFlattenUI) == false) goto L19;
        if (((LynxFlattenUI) r210).getAlpha() >= 0.05d) goto L18;
        goto L18
    }
}
