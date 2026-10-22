package h86;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f484204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f484205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f484206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f86.c f484207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Dialog f484208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f484209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f484210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f484211h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f484212i;

    /* JADX INFO: renamed from: h86.a$a, reason: collision with other inner class name */
    public class C6113a implements f86.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f484213a;

        public C6113a(a r100) {
            this.f484213a = r100;
        }
    }

    public class b implements View.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f484214a;

        public b(a r100) {
            this.f484214a = r100;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r100, int r101, KeyEvent r102) {
            if (r101 == 4) goto L5;
            return false;
        L5:
            if (r102.getAction() != 0) goto L10;
            this.f484214a.e();
            return false;
        L10:
            return false;
        }
    }

    public class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f484215a;

        public c(a r100) {
            this.f484215a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            if (r101.getAction() != 0) goto L7;
            this.f484215a.a();
            return false;
        L7:
            return false;
        }
    }

    public abstract void e();

    public abstract d86.a f();

    public final void g() {
    }

    public final void c() {
        AnimationUtils.loadAnimation(this.f484204a, R.anim.lynx_picker_slide_in_bottom);
        AnimationUtils.loadAnimation(this.f484204a, R.anim.lynx_picker_slide_out_bottom);
    }

    public final void d() {
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater r101 = LayoutInflater.from(this.f484204a);
        e();
        ViewGroup r102 = (ViewGroup) r101.inflate(R.layout.lynx_layout_basepicker, null, false);
        this.f484206c = r102;
        r102.setBackgroundColor(0);
        ViewGroup r103 = (ViewGroup) this.f484206c.findViewById(R.id.content_container);
        this.f484205b = r103;
        r100.leftMargin = 30;
        r100.rightMargin = 30;
        r103.setLayoutParams(r100);
        if (this.f484206c == null) goto L8;
        Dialog r104 = new Dialog(this.f484204a, R.style.custom_dialog2);
        this.f484208e = r104;
        f().getClass();
        r104.setCancelable(true);
        this.f484208e.setContentView(this.f484206c);
        Window r105 = this.f484208e.getWindow();
        if (r105 == null) goto L7;
        r105.setWindowAnimations(R.style.lynx_picker_scale_anim);
        r105.setGravity(17);
    L7:
        this.f484208e.setOnDismissListener(new h86.b(this));
    L8:
        e();
        ViewGroup r106 = this.f484206c;
        r106.setFocusable(true);
        r106.setFocusableInTouchMode(true);
        r106.setOnKeyListener(this.f484211h);
        this.f484207d = new C6113a(this);
    }

    public final void a() {
        e();
        Dialog r100 = this.f484208e;
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

    public a(Context r100) {
        this.f484210g = false;
        this.f484211h = new b(this);
        this.f484212i = new c(this);
        this.f484204a = r100;
    }

    public final View b(int r100) {
        return this.f484205b.findViewById(r100);
    }

    public final void h(View r100) {
        e();
        Dialog r101 = this.f484208e;
        if (r101 == null) goto L7;
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-1, -2, 80);
        r102.leftMargin = 0;
        r102.rightMargin = 0;
        this.f484205b.setLayoutParams(r102);
        Window r103 = r101.getWindow();
        if (r103 == null) goto L7;
        r103.setWindowAnimations(R.style.lynx_picker_slide_anim);
        r103.setGravity(80);
        r103.setDimAmount(0.3f);
    L7:
        this.f484209f = r100;
        e();
        Dialog r104 = this.f484208e;
        if (r104 != null) goto L10;
        return;
    L10:
        if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r104);
    L14:
        WindowManager.LayoutParams r105 = this.f484208e.getWindow().getAttributes();
        r105.width = -1;
        this.f484208e.getWindow().setAttributes(r105);
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L13:
        DialogLancet.beforeDialogShow(r104);
        r104.show();
        DialogLancet.afterDialogShow(r104);
        goto L14
    }
}
