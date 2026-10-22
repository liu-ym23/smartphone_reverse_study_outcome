package hp4;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f486397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Dialog f486398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f486399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CellEditDragView f486400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f486401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f486402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f486403g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout.LayoutParams f486404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f486405i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public mr4.a f486406j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f486407k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f486408l;

    public interface a {
        void onDismiss();
    }

    public interface b<V> {
        void c(V r100);

        void d(Map<String, Object> r100, String r101);
    }

    public abstract View q(Context r100);

    public boolean u() {
        return false;
    }

    public void dismiss() {
        int r100 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.cell_edit_panel_dismiss_crash_fix_enable") == true) goto L5;
        CellEditDragView r101 = this.f486400d;
        if (r101 != null) goto L33;
    L38:
        Dialog r102 = this.f486398b;
        if (r102 == null) goto L47;
        n(r102);
        return;
    L47:
        return;
    L33:
        if (r101.getHeight() == 0) goto L38;
        CellEditDragView r103 = this.f486400d;
        if (r103.getDragUtil() == null) goto L38;
        r103.getDragUtil().l(0.0f);
        goto L38
    L5:
        if (this.f486408l == false) goto L8;
        return;
    L8:
        if (s() == true) goto L10;
        tt5.a.h("BaseCellEditPanel", "dialog is already dismissed or not showing");
        return;
    L10:
        this.f486408l = true;
        CellEditDragView r104 = this.f486400d;     // Catch: Throwable -> L19 IllegalArgumentException -> L21
        if (r104 != null) goto L14;
    L23:
        n(this.f486398b);     // Catch: Throwable -> L19 IllegalArgumentException -> L21
    L26:
        this.f486408l = false;
        return;
    L14:
        if (r104.getHeight() == 0) goto L23;
        CellEditDragView r105 = this.f486400d;     // Catch: Throwable -> L19 IllegalArgumentException -> L21
        if (r105.getDragUtil() == null) goto L23;
        r105.getDragUtil().l(0.0f);     // Catch: Throwable -> L19 IllegalArgumentException -> L21
    L21:
        e = move-exception;
        tt5.a.e("BaseCellEditPanel", "dismiss dialog failed", e, false);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.f486408l = false;
        throw th;
    }

    public void hideKeyboard() {
        rcb.c.d(q(this.f486397a));
    }

    public final int r() {
        View r100 = q(this.f486397a);
        int r101 = 0;
        if ((r100 instanceof ViewGroup) == false) goto L11;
        int r102 = 0;
    L5:
        ViewGroup r103 = (ViewGroup) r100;
        if (r101 >= r103.getChildCount()) goto L9;
        r102 = r102 + r103.getChildAt(r101).getHeight();
        r101 = r101 + 1;
        goto L5
    L9:
        return r102;
    L11:
        return 0;
    }

    public boolean s() {
        Dialog r100 = this.f486398b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isShowing() == false) goto L7;
        return true;
    }

    public void show() {
        if (this.f486398b == null) goto L6;
    L48:
        Dialog r100 = this.f486398b;
        if (r100 != null) goto L53;
        tt5.a.d("BaseCellEditPanel", "dialog has not been initialized");
        return;
    L53:
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L59;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L59:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L58
    L56:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
        return;
    L6:
        if (q(this.f486397a) != null) goto L8;
        tt5.a.d("BaseCellEditPanel", "content view can not be null");
        goto L48
    L8:
        this.f486398b = new Dialog(this.f486397a, R.style.TransparentBackgroundDialogStyle);
        t r101 = new t(this.f486398b.getWindow(), this.f486397a);
        if (this.f486407k == false) goto L12;
        r101.setBackgroundColor(UIUtils.getColor(this.f486397a, R.color.bg_mask));
    L12:
        if (this.f486404h != null) goto L14;
        this.f486404h = new FrameLayout.LayoutParams(-1, -2);
    L14:
        this.f486404h.gravity = 80;
        r101.addView(q(this.f486397a), this.f486404h);
        this.f486398b.setContentView(r101);
        Window r102 = this.f486398b.getWindow();
        if (r102 == null) goto L47;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.width = -1;
        r103.height = -1;
        r103.gravity = 80;
        r103.dimAmount = 0.0f;
        boolean r104 = false;
        if (u() == false) goto L19;
        r102.setStatusBarColor(0);
    L20:
        r103.windowAnimations = R.style.ActionSheetDialogAnimation;
        r102.setAttributes(r103);
        if ((q(this.f486397a) instanceof FrameLayout) == false) goto L46;
        final FrameLayout r105 = (FrameLayout) q(this.f486397a);
        int r106 = 0;
    L24:
        if (r106 >= r105.getChildCount()) goto L29;
        View r107 = r105.getChildAt(r106);
        if ((r107 instanceof CellEditDragView) == true) goto L27;
        r106 = r106 + 1;
        goto L24
    L27:
        this.f486400d = (CellEditDragView) r107;
    L29:
        CellEditDragView r108 = this.f486400d;
        if (r108 == null) goto L33;
        r108.addOnLayoutChangeListener(new d(r105));
    L33:
        if (com.bytedance.ee.bear.bitable.utils.g.b() == false) goto L43;
        mr4.a r109 = this.f486406j;
        if (r109 == null) goto L43;
        if (TextUtils.isEmpty(r109.f514980a) == false) goto L39;
    L41:
        if (r104 == false) goto L43;
        q(this.f486397a).post(new hp4.a(this, r105));
    L44:
        r102.findViewById(android.R.id.content).setOnClickListener(new e(this));
        goto L47
    L39:
        if (r109.f514981b == null) goto L41;
        r104 = true;
    L43:
        q(this.f486397a).post(new hp4.b(r105));
        goto L44
    L46:
        throw new RuntimeException("Content view type must be FrameLayout!");
    L19:
        r102.addFlags(512);
        r102.addFlags(67108864);
    L47:
        this.f486398b.setOnDismissListener(new c(this));
        this.f486398b.setOnShowListener(new f(this));
        goto L48
    }

    public void t() {
        a r100 = this.f486401e;
        if (r100 == null) goto L6;
        r100.onDismiss();
        return;
    }

    public Context getContext() {
        return this.f486397a;
    }

    public g(Context r100) {
        this.f486397a = r100;
        this.f486403g = new HashMap();
    }

    public static void n(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public void a(int r100) {
        this.f486405i = r100;
    }

    public final void h(a r100) {
        this.f486401e = r100;
    }

    public final void o(Object r100) {
        ((HashMap) this.f486403g).put("is_empty", r100);
    }

    public final void p(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getVisibility() == 0) goto L6;
        return;
    L6:
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (this.f486405i != 0) goto L9;
        r101.height = -1;
    L16:
        r100.setLayoutParams(r101);
        return;
    L9:
        int r102 = this.f486399c.findViewById(R.id.contentContainer).getHeight() - this.f486405i;
        if (r102 > 0) goto L13;
        return;
    L13:
        if (r102 < (r100.getResources().getDimensionPixelSize(R.dimen.ccm_emptystate_image_size_middle) + (r100.getResources().getDimensionPixelSize(R.dimen.space_kit_len_16) * 2))) goto L15;
        r101.height = r102;
        goto L16
    L15:
        r101.height = -2;
        goto L16
    }

    public final void v(String r100) {
        if (this.f486402f == null) goto L6;
        HashMap r101 = new HashMap();
        r101.put("click", r100);
        r101.putAll(this.f486403g);
        this.f486402f.d(r101, "EDIT_PANEL_CLICK");
        return;
    }
}
