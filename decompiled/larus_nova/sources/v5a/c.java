package v5a;

import android.app.AlertDialog;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.MutableContextWrapper;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import n5a.o;

/* JADX INFO: loaded from: classes32.dex */
public final class c extends Presentation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.OnFocusChangeListener f553304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f553305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f553306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f553307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f553308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f553309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f553310g;

    public static class a extends FrameLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f553311a;

        @Override // android.view.ViewGroup, android.view.ViewParent
        public final boolean requestSendAccessibilityEvent(View r100, AccessibilityEvent r101) {
            return false;
        }

        public a(Context r100, View r101) {
            super(r100);
            this.f553311a = r101;
        }
    }

    public static class b extends ViewGroup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f553312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f553313b;

        public b(Context r100) {
            super(r100);
            this.f553312a = new Rect();
            this.f553313b = new Rect();
        }

        @Override // android.view.View
        public final void onMeasure(int r100, int r101) {
            int r102 = 0;
        L4:
            if (r102 >= getChildCount()) goto L6;
            getChildAt(r102).measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r100), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r101), Integer.MIN_VALUE));
            r102 = r102 + 1;
            goto L4
        L6:
            super.onMeasure(r100, r101);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r110, int r111, int r112, int r113, int r114) {
            int r115 = 0;
        L4:
            if (r115 >= getChildCount()) goto L6;
            View r100 = getChildAt(r115);
            WindowManager.LayoutParams r101 = (WindowManager.LayoutParams) r100.getLayoutParams();
            this.f553312a.set(r111, r112, r113, r114);
            Gravity.apply(r101.gravity, r100.getMeasuredWidth(), r100.getMeasuredHeight(), this.f553312a, r101.x, r101.y, this.f553313b);
            Rect r102 = this.f553313b;
            r100.layout(r102.left, r102.top, r102.right, r102.bottom);
            r115 = r115 + 1;
            goto L4
        }
    }

    /* JADX INFO: renamed from: v5a.c$c, reason: collision with other inner class name */
    public static class C7964c extends ContextWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputMethodManager f553314a;

        @Override // android.content.ContextWrapper, android.content.Context
        public final Context createDisplayContext(Display r100) {
            return new C7964c(super.createDisplayContext(r100), this.f553314a);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final Object getSystemService(String r100) {
            if ("input_method".equals(r100) == false) goto L7;
            return this.f553314a;
        L7:
            return super.getSystemService(r100);
        }

        public C7964c(Context r100, InputMethodManager r101) {
            super(r100);
            if (r101 != null) goto L6;
            r101 = (InputMethodManager) r100.getSystemService("input_method");
        L6:
            this.f553314a = r101;
        }
    }

    public static class d extends ContextWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f553315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WindowManager f553316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Context f553317c;

        @Override // android.content.ContextWrapper, android.content.Context
        public final Object getSystemService(String r100) {
            if (LiveEndPageData.TAG_WINDOW.equals(r100) == false) goto L25;
            StackTraceElement[] r101 = ThreadMethodProxy.currentThread().getStackTrace();
            int r102 = 0;
        L6:
            if (r102 >= r101.length) goto L15;
            if (r102 >= 11) goto L15;
            if (r101[r102].getClassName().equals(AlertDialog.class.getCanonicalName()) == false) goto L14;
            if (r101[r102].getMethodName().equals("<init>") == false) goto L14;
            boolean r103 = true;
        L16:
            if (r103 == false) goto L20;
            return this.f553317c.getSystemService(r100);
        L20:
            if (this.f553316b != null) goto L23;
            f r104 = this.f553315a;
            r104.getClass();
            this.f553316b = (WindowManager) Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[]{WindowManager.class}, r104);
        L23:
            return this.f553316b;
        L14:
            r102 = r102 + 1;
        L15:
            r103 = false;
            goto L16
        L25:
            return super.getSystemService(r100);
        }

        public d(Context r100, f r101, Context r102) {
            super(r100);
            this.f553315a = r101;
            this.f553317c = r102;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public v5a.a f553318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f f553319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f553320c;

        public e() {
        }
    }

    public static class f implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowManager f553321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f553322b;

        public f(WindowManager r100, b r101) {
            this.f553321a = r100;
            this.f553322b = r101;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
            String r103 = r101.getName();
            r103.getClass();
            byte r104 = -1;
            switch(r103.hashCode()) {
                case -1148522778: goto L18;
                case 542766184: goto L14;
                case 931413976: goto L10;
                case 1098630473: goto L6;
                default: goto L22;
            };
        L6:
            if (r103.equals("removeView") == false) goto L22;
            r104 = 3;
            goto L22
        L10:
            if (r103.equals("updateViewLayout") == false) goto L22;
            r104 = 2;
            goto L22
        L14:
            if (r103.equals("removeViewImmediate") == false) goto L22;
            r104 = 1;
            goto L22
        L18:
            if (r103.equals("addView") == false) goto L22;
            r104 = 0;
        L22:
            switch(r104) {
                case 0: goto L43;
                case 1: goto L39;
                case 2: goto L33;
                case 3: goto L28;
                default: goto L48;
            };
        L28:
            b r105 = this.f553322b;
            if (r105 != null) goto L31;
            c5a.c.d(5, "PlatformViewsController", "Embedded view called removeView while detached from presentation");
        L32:
            return null;
        L31:
            r105.removeView((View) r102[0]);
            goto L32
        L33:
            b r106 = this.f553322b;
            if (r106 != null) goto L36;
            c5a.c.d(5, "PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
        L37:
            return null;
        L36:
            r106.updateViewLayout((View) r102[0], (WindowManager.LayoutParams) r102[1]);
            goto L37
        L43:
            b r107 = this.f553322b;
            if (r107 != null) goto L46;
            c5a.c.d(5, "PlatformViewsController", "Embedded view called addView while detached from presentation");
        L47:
            return null;
        L46:
            r107.addView((View) r102[0], (WindowManager.LayoutParams) r102[1]);
            goto L47
        L48:
            return r101.invoke(this.f553321a, r102);
        L25:
            e = move-exception;
            throw e.getCause();
        L39:
            if (this.f553322b != null) goto L41;
            c5a.c.d(5, "PlatformViewsController", "Embedded view called removeViewImmediate while detached from presentation");
        L42:
            return null;
        L41:
            View r108 = (View) r102[0];
            r108.clearAnimation();
            this.f553322b.removeView(r108);
            goto L42
        }
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        e r101 = this.f553308e;
        if (r101.f553320c != null) goto L6;
        r101.f553320c = new b(getContext());
    L6:
        if (this.f553308e.f553319b != null) goto L8;
        WindowManager r102 = (WindowManager) getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        e r103 = this.f553308e;
        r103.f553319b = new f(r102, r103.f553320c);
    L8:
        this.f553307d = new FrameLayout(getContext());
        d r104 = new d(getContext(), this.f553308e.f553319b, this.f553310g);
        View r105 = ((o.a) this.f553308e.f553318a).f518072a;
        if ((r105.getContext() instanceof MutableContextWrapper) == false) goto L11;
        ((MutableContextWrapper) r105.getContext()).setBaseContext(r104);
    L12:
        this.f553307d.addView(r105);
        a r106 = new a(getContext(), r105);
        this.f553306c = r106;
        r106.addView(this.f553307d);
        this.f553306c.addView(this.f553308e.f553320c);
        r105.setOnFocusChangeListener(this.f553304a);
        this.f553306c.setFocusableInTouchMode(true);
        if (this.f553309f == false) goto L15;
        r105.requestFocus();
    L16:
        setContentView(this.f553306c);
        return;
    L15:
        this.f553306c.requestFocus();
        goto L16
    L11:
        c5a.c.d(5, "PlatformViewsController", "Unexpected platform view context for view ID " + this.f553305b + "; some functionality may not work correctly. When constructing a platform view in the factory, ensure that the view returned from PlatformViewFactory#create returns the provided context from getContext(). If you are unable to associate the view with that context, consider using Hybrid Composition instead.");
        goto L12
    }

    public c(Context r100, Display r101, o.a r102, int r103, o.b r104) {
        super(new C7964c(r100, null), r101);
        this.f553309f = false;
        this.f553305b = r103;
        this.f553304a = r104;
        this.f553310g = r100;
        e r105 = new e();
        this.f553308e = r105;
        r105.f553318a = r102;
        getWindow().setFlags(8, 8);
        getWindow().setType(2030);
    }

    public c(Context r100, Display r101, e r102, View.OnFocusChangeListener r103, boolean r104) {
        super(new C7964c(r100, null), r101);
        this.f553309f = false;
        this.f553308e = r102;
        this.f553304a = r103;
        this.f553310g = r100;
        getWindow().setFlags(8, 8);
        this.f553309f = r104;
    }
}
