package y9c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.samskivert.mustache.e;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.HashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f567001a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f567002b = -1;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f567003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f567004b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.f567003a.getViewTreeObserver().removeOnPreDrawListener(this);
            int[] r100 = new int[2];
            DesktopUtil.a(this.f567004b);
            float r101 = d.g(this.f567004b);
            this.f567003a.getLocationOnScreen(r100);
            this.f567003a.setTranslationY((r101 / 3.0f) - (r100[1] - this.f567003a.getTranslationY()));
            return false;
        }

        public a(View r100, Context r101) {
            this.f567003a = r100;
            this.f567004b = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f567005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f567006b;

        @Override // java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L3:
            if (this.f567005a.getWindowToken() != null) goto L5;
            return;
        L5:
            if (this.f567005a.getHeight() <= 0) goto L16;
            d.m(this.f567005a, this.f567006b);     // Catch: Throwable -> L9
            return;
        }

        public b(View r100, Context r101) {
            this.f567005a = r100;
            this.f567006b = r101;
        }
    }

    public class c implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f567007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f567008b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            if (this.f567007a == null) goto L7;
            ViewTreeObserver r101 = r100.getViewTreeObserver();
            if (r101.isAlive() == false) goto L7;
            r101.removeOnGlobalLayoutListener(this.f567007a);
        L7:
            r100.removeCallbacks(this.f567008b);
            r100.removeOnAttachStateChangeListener(this);
        }

        public c(y9c.c r100, b r101) {
            this.f567007a = r100;
            this.f567008b = r101;
        }
    }

    /* JADX INFO: renamed from: y9c.d$d, reason: collision with other inner class name */
    public class RunnableC8319d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f567009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f567010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f567011c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Runnable f567012d;

        @Override // java.lang.Runnable
        public final void run() {
            this.f567009a[0] = d.f(this.f567010b, this.f567011c);     // Catch: Throwable -> L4
            this.f567010b.removeCallbacks(this.f567012d);     // Catch: Throwable -> L4
            this.f567010b.postDelayed(this.f567012d, 200);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC8319d(int[] r100, View r101, Context r102, b r103) {
            this.f567009a = r100;
            this.f567010b = r101;
            this.f567011c = r102;
            this.f567012d = r103;
        }
    }

    public static Context getContext() {
        return LarkContext.getApplication();
    }

    public static int a(int r100) {
        int r101 = com.larksuite.framework.utils.autoscale.a.f285947a;
        Resources r102 = Resources.getSystem();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public static int g(Context r100) {
        int r101 = f567001a;
        if (r101 != 0) goto L6;
        Display r102 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        DisplayMetrics r103 = new DisplayMetrics();
        r102.getRealMetrics(r103);
        int r104 = r103.heightPixels;
        f567001a = r104;
        return r104;
    L6:
        return r101;
    }

    public static Resources getResources(Context r100) {
        return r100.getResources();
    }

    public static String h(int r100) {
        return i(getContext(), r100);
    }

    public static void k(View r100) {
        Context r101 = r100.getContext();
        r100.getViewTreeObserver().addOnPreDrawListener(new a(r100, r101));
    }

    public static int b(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return (int) ((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public static int c(Context r100, int r101) {
        return getResources(r100).getColor(r101);
    }

    public static int d(Context r100, int r101) {
        return getResources(r100).getDimensionPixelSize(r101);
    }

    public static Drawable e(Context r100, int r101) {
        return getResources(r100).getDrawable(r101);
    }

    public static int f(View r100, Context r101) {
        if (DesktopUtil.a(r101) == false) goto L5;
        return 0;
    L5:
        int r102 = Build.VERSION.SDK_INT;
        if (r102 >= 23) goto L8;
    L7:
        int r103 = 0;
    L23:
        if (r103 <= 0) goto L25;
        return r103;
    L25:
        float r104 = g(r101);
        Rect r105 = new Rect();
        r100.getWindowVisibleDisplayFrame(r105);
        return Math.max((int) (r104 - r105.bottom), 0);
    L8:
        WindowInsets r106 = r100.getRootWindowInsets();
        if (r106 == null) goto L7;
        if (r102 < 30) goto L14;
        int r107 = r106.getInsets(WindowInsets.Type.ime()).bottom;
    L22:
        r103 = Math.max(r107, 0);
        goto L23
    L14:
        r107 = r106.getSystemWindowInsetBottom();
        int r108 = f567002b;
        if (r108 != (-1)) goto L20;
        Resources r109 = r101.getResources();
        int r110 = r109.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r110 <= 0) goto L19;
        r108 = r109.getDimensionPixelSize(r110);
        f567002b = r108;
        goto L20
    L19:
        r108 = 0;
    L20:
        if (r107 <= r108) goto L22;
        r107 = r107 - r108;
        goto L22
    }

    public static String i(Context r100, int r101) {
        return getResources(r100).getString(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void l(final View r100, boolean r101) {
        final Context r102 = r100.getContext();
        final int[] r103 = {-1};
        b r104 = new b(r100, r102);
        if (r101 == false) goto L5;
        y9c.c r105 = 0;
    L6:
        r100.addOnAttachStateChangeListener(new c(r105, r104));
        r100.post(new RunnableC8319d(r103, r100, r102, r104));
        return;
    L5:
        ViewTreeObserver.OnGlobalLayoutListener r106 = new y9c.c(r100, r102, r103);
        r100.getViewTreeObserver().addOnGlobalLayoutListener(r106);
        r105 = r106;
        goto L6
    }

    public static void m(View r100, Context r101) {
        int[] r102 = new int[2];
        float r103 = g(r101);
        int r104 = f(r100, r101);
        r100.getLocationOnScreen(r102);
        float r105 = r103 - r104;
        float r106 = r105 / 2.0f;
        if ((r100.getParent() instanceof View) == false) goto L5;
        View r107 = (View) r100.getParent();
    L7:
        if (r107 == null) goto L11;
        int[] r108 = new int[2];
        DesktopUtil.a(r101);
        r107.getLocationOnScreen(r108);
        int r109 = (((int) (r105 - r108[1])) - r107.getPaddingTop()) - r107.getPaddingBottom();
        if (r109 <= 0) goto L11;
        r106 = (r108[1] + r107.getPaddingTop()) + (r109 / 2.0f);
    L11:
        float r110 = r102[1];
        float r111 = r100.getTranslationY();
        float r112 = 0.0f;
        if ((r100.getParent() instanceof View) == false) goto L21;
        View r113 = (View) r100.getParent();     // Catch: Throwable -> L23
    L15:
        if (r113 == null) goto L21;
        r112 = r112 + r113.getTranslationY();     // Catch: Throwable -> L23
        if ((r113.getParent() instanceof View) == false) goto L21;
        r113 = (View) r113.getParent();     // Catch: Throwable -> L23
    L21:
        r100.setTranslationY((((r106 - (r100.getHeight() / 2.0f)) - (r110 - r111)) + r112) - (UIHelper.dp2px(38.0f) / 2.0f));
        return;
    L5:
        r107 = null;
        goto L7
    }

    public static String j(int r100, String r101, String r102) {
        String r103 = UIUtils.getString(getContext(), r100);
        if (r102 == null) goto L10;
        HashMap r104 = new HashMap(1);
        r104.put(r101, r102);
        return e.a().b().a(r103).b(r104);
    L8:
        e = move-exception;
        Log.e("UiUtils", e.getMessage());
    L10:
        return r103;
    }
}
