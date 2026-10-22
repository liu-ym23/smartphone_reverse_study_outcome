package fcc;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.ViewUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fcc.c;

/* JADX INFO: loaded from: classes38.dex */
public abstract class c<T extends c> extends com.larksuite.component.ui.dialog.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f476418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LKUIDialog f476419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f476420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f476421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f476422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EditText f476423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f476424g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Runnable f476425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f476426i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f476427j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f476428k;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f476429a;

        public a(c r100) {
            this.f476429a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f476429a.g();
            Runnable r101 = this.f476429a.f476425h;
            if (r101 == null) goto L6;
            r101.run();
            return;
        }
    }

    public class b implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f476430a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f476431a;

            @Override // java.lang.Runnable
            public final void run() {
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L17;
                throw th;
            L17:
                return;
            L3:
                if (UIUtils.isActivityRunning(ViewUtils.getActivityByContext(this.f476431a.f476430a.f476418a)) == true) goto L6;
                return;
            L6:
                if (this.f476431a.f476430a.f476419b.getWindow() == null) goto L16;
                this.f476431a.f476430a.f476419b.getWindow().setWindowAnimations(R.style.WidgetDrawerDialogAnim);     // Catch: Throwable -> L9
                return;
            }

            public a(b r100) {
                this.f476431a = r100;
            }
        }

        public b(c r100) {
            this.f476430a = r100;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r100) {
            if (this.f476430a.f476419b.getWindow() == null) goto L11;
            View r101 = this.f476430a.f476419b.getWindow().getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == com.larus.home.impl.utils.c.f346341a) goto L9;
            com.larus.home.impl.utils.c.a(r102, "getDecorView");
        L9:
            r101.postDelayed(new a(this), 300);
            return;
        }
    }

    /* JADX INFO: renamed from: fcc.c$c, reason: collision with other inner class name */
    public class C5881c extends com.ss.android.lark.widget.util.b {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ c f476432k;

        @Override // com.ss.android.lark.widget.util.b
        public final boolean a() {
            this.f476432k.f();
            return true;
        }

        public C5881c(c r100) {
            this.f476432k = r100;
        }

        @Override // com.ss.android.lark.widget.util.b
        public final boolean c(int r100, MotionEvent r101) {
            if ((-this.f476432k.f476421d.getScrollY()) <= UIHelper.dp2px(60.0f)) goto L24;
            Runnable r102 = this.f476432k.f476425h;
            if (r102 == null) goto L7;
            r102.run();
        L7:
            LKUIDialog r103 = this.f476432k.f476419b;
            Handler r104 = DialogLancet.resolveDialogHandler(r103);
            if (r104 != null) goto L10;
        L12:
            DialogLancet.beforeDialogDismiss(r103);
            r103.dismiss();     // Catch: Throwable -> L15 Exception -> L17
        L21:
            DialogLancet.afterDialogDismiss(r103);
        L25:
            return true;
        L17:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
            Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
            if (r105 == null) goto L21;
            com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r103);
            throw th;
        L10:
            if (Looper.myLooper() == r104.getLooper()) goto L12;
            r104.post(DialogLancet.createDismissRunnable(r103));
            goto L25
        L24:
            ValueAnimator r106 = ValueAnimator.ofInt(new int[]{this.f476432k.f476421d.getScrollY(), 0});
            r106.addUpdateListener(new fcc.d(this));
            r106.setInterpolator(new AccelerateInterpolator(0.5f));
            r106.setDuration(200).start();
            goto L25
        }

        @Override // com.ss.android.lark.widget.util.b
        public final boolean b(int r100, int r101, MotionEvent r102) {
            this.f476432k.f476421d.scrollTo(0, Math.max(Math.min(-r101, 0), -this.f476432k.f476424g.getHeight()));
            return true;
        }
    }

    public class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f476433a;

        public d(c r100) {
            this.f476433a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            return this.f476433a.f476422e.dispatchTouchEvent(r101);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f476434a;

        public final void a() {
            c r100 = this.f476434a;
            int r101 = r100.f476428k;
            if (r101 > 0) goto L6;
            r101 = (DeviceUtils.getScreenHeight(r100.f476418a) * 5) / 6;
        L6:
            if (this.f476434a.f476421d.getHeight() <= r101) goto L9;
            ViewGroup.LayoutParams r102 = this.f476434a.f476421d.getLayoutParams();
            r102.height = r101;
            this.f476434a.f476421d.setLayoutParams(r102);
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

        public e(c r100) {
            this.f476434a = r100;
        }
    }

    public abstract com.larksuite.component.ui.dialog.d d(com.larksuite.component.ui.dialog.d r100);

    public abstract int e();

    public abstract void i(LKUIDialog r100);

    public void f() {
        boolean r100 = true;
        this.f476423f.setFocusable(true);
        this.f476423f.setFocusableInTouchMode(true);
        this.f476423f.requestFocus();
        Activity r101 = ViewUtils.getActivityByContext(this.f476418a);
        if (r101 == null) goto L33;
        long r102 = System.currentTimeMillis();
        long r103 = r102 - com.ss.android.lark.widget.util.a.f449061b;
        View r104 = r101.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L11;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r105 = ThreadMethodProxy.currentThread();
        if (r105 == com.larus.home.impl.utils.c.f346341a) goto L11;
        com.larus.home.impl.utils.c.a(r105, "getDecorView");
    L11:
        if (r104 == null) goto L19;
        Rect r106 = new Rect();
        r104.getWindowVisibleDisplayFrame(r106);
        Log.d("KeyboardUtils", "getDecorViewInvisibleHeight: " + (r104.getBottom() - r106.bottom));
        int r107 = Math.abs(r104.getBottom() - r106.bottom);
        Resources r108 = Resources.getSystem();
        int r109 = r108.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r109 == 0) goto L16;
        int r110 = r108.getDimensionPixelSize(r109);
    L17:
        if (r107 > r110) goto L20;
        com.ss.android.lark.widget.util.a.f449060a = r107;
        goto L19
    L20:
        int r111 = r107 - com.ss.android.lark.widget.util.a.f449060a;
    L21:
        if (r111 > 0) goto L24;
        r100 = false;
    L24:
        if (r100 == true) goto L26;
    L31:
        com.ss.android.lark.widget.util.a.f449061b = r102;
        return;
    L26:
        if (r103 <= 500) goto L31;
        InputMethodManager r112 = (InputMethodManager) LarkContext.getApplication().getSystemService("input_method");
        if (r112 == null) goto L31;
        r112.toggleSoftInput(2, 0);
        goto L31
    L16:
        r110 = 0;
    L19:
        r111 = 0;
        goto L21
    }

    public final void g() {
        LKUIDialog r100 = this.f476419b;
        if (r100 == null) goto L21;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r102 == null) goto L18;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r101.getLooper()) goto L9;
        r101.post(DialogLancet.createDismissRunnable(r100));
        return;
    }

    public final void j() {
        Activity r100 = ViewUtils.getActivityByContext(this.f476418a);
        if (ViewUtils.isActivityAlive(r100) == false) goto L6;
        com.larksuite.component.ui.dialog.d r101 = new com.larksuite.component.ui.dialog.d(r100);
        int r102 = DesktopUtil.f420394a;
        r101.f284132c.width(1.0f);
        r101.e(80);
        fcc.b r103 = new fcc.b(this);
        r101.f284132c.onCancelListener(r103);
        fcc.a r104 = new fcc.a(this);
        r101.f284132c.onDismissListener(r104);
        r101.f284132c.rootLayoutRes(R.layout.widget_base_drawer_dialog);
        r101.g(this);
        this.f476419b = d(r101).i();
        return;
    }

    public c(Context r100) {
        this.f476426i = true;
        this.f476427j = false;
        this.f476418a = r100;
    }

    public static View c(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // com.larksuite.component.ui.dialog.d.a
    public final void a(LKUIDialog r100) {
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        r101.clearFlags(67108864);
        r101.addFlags(Integer.MIN_VALUE);
        int r102 = c(r101).getSystemUiVisibility();
        c(r101).setSystemUiVisibility(r102 | 256);
        r101.setStatusBarColor(0);
        return;
    }

    @Override // com.larksuite.component.ui.dialog.d.a
    public final void b(LKUIDialog r100) {
        Window r101 = r100.getWindow();
        if (r101 != null) goto L5;
        return;
    L5:
        this.f476420c = r100.findViewById(R.id.wbddRootFl);
        this.f476421d = r100.findViewById(R.id.wbddScrollFl);
        this.f476422e = r100.findViewById(R.id.wbddThumbFl);
        this.f476423f = (EditText) r100.findViewById(R.id.wbddFocusEt);
        this.f476424g = (FrameLayout) r100.findViewById(R.id.wbddContentFl);
        r101.getLayoutInflater().inflate(e(), this.f476424g);
        if (this.f476426i == true) goto L8;
        this.f476422e.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        this.f476422e.setAlpha(0.0f);
    L8:
        this.f476420c.setOnClickListener(new a(this));
        r100.setOnShowListener(new b(this));
        View r102 = this.f476422e;
        C5881c r103 = new C5881c(this);
        if (r102 == null) goto L11;
        r102.setOnTouchListener(r103);
    L11:
        this.f476421d.setOnTouchListener(new d(this));
        if (this.f476427j == false) goto L18;
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) this.f476421d.getLayoutParams();
        r104.gravity = -1;
        this.f476421d.setLayoutParams(r104);
        if (this.f476428k > 0) goto L16;
        int r105 = DeviceUtils.getScreenHeight(this.f476418a) / 6;
    L17:
        this.f476420c.setPadding(0, r105, 0, 0);
    L19:
        i(r100);
        return;
    L16:
        r105 = DeviceUtils.getScreenHeight(this.f476418a) - this.f476428k;
        goto L17
    L18:
        this.f476421d.post(new e(this));
        goto L19
    }

    public final <E extends View> E h(int r100) {
        return (E) this.f476420c.findViewById(r100);
    }
}
