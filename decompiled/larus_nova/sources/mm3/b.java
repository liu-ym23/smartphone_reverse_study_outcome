package mm3;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f514421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mm3.a f514422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<d> f514423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f514424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Dialog f514425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f514426f;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f514427a;

        public a(b r100) {
            this.f514427a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f514427a;
            r101.f514426f = true;
            Dialog r102 = r101.f514425e;
            Handler r103 = DialogLancet.resolveDialogHandler(r102);
            if (r103 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r102);
            r102.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r102);
        L17:
            b r104 = this.f514427a;
            nm3.a r105 = r104.f514422b.f514418d;
            if (r105 == null) goto L26;
            r105.d(b.b(r104));
            return;
        L26:
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r102);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r106 == null) goto L16;
            com.bytedance.crash.d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r103.getLooper()) goto L7;
            r103.post(DialogLancet.createDismissRunnable(r102));
            goto L17
        }
    }

    /* JADX INFO: renamed from: mm3.b$b, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC6830b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f514428a;

        public ViewOnClickListenerC6830b(b r100) {
            this.f514428a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f514428a;
            r101.f514426f = true;
            Dialog r102 = r101.f514425e;
            Handler r103 = DialogLancet.resolveDialogHandler(r102);
            if (r103 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r102);
            r102.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r102);
        L17:
            b r104 = this.f514428a;
            nm3.a r105 = r104.f514422b.f514418d;
            if (r105 == null) goto L26;
            r105.c(b.b(r104));
            return;
        L26:
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r102);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r106 == null) goto L16;
            com.bytedance.crash.d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r103.getLooper()) goto L7;
            r103.post(DialogLancet.createDismissRunnable(r102));
            goto L17
        }
    }

    public static final class c implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f514429a;

        public c(b r100) {
            this.f514429a = r100;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            b r101 = this.f514429a;
            if (r101.f514426f == true) goto L5;
            r101.c();
        L5:
            this.f514429a.f514426f = false;
        }
    }

    private final List<Integer> getSelectedIndex() {
        ((ArrayList) this.f514424d).clear();
        Iterator r100 = ((ArrayList) this.f514423c).iterator();
    L4:
        if (r100.hasNext() == false) goto L7;
        d r101 = (d) r100.next();
        List<Integer> r102 = this.f514424d;
        ArrayList r103 = (ArrayList) r102;
        r103.add(Integer.valueOf(r101.getCurrentSelectedValue()));
        goto L4
    L7:
        return this.f514424d;
    }

    public final void c() {
        nm3.a r100 = this.f514422b.f514418d;
        if (r100 == null) goto L6;
        r100.b(getSelectedIndex());
        return;
    }

    public final void d() {
        this.f514425e.setCancelable(true);
        Window r100 = this.f514425e.getWindow();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.setWindowAnimations(R.style.uicomponent_picker_view_slide_anim);
        WindowManager.LayoutParams r101 = r100.getAttributes();
        r101.width = -1;
        r100.setAttributes(r101);
        r100.setGravity(80);
        this.f514425e.setOnDismissListener(new c(this));
        setMinimumWidth(10000);
        this.f514425e.setContentView(this);
        Dialog r102 = this.f514425e;
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(r102);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
    }

    public static final /* synthetic */ List b(b r100) {
        return r100.getSelectedIndex();
    }

    public final View a(int r100) {
        if (this.f514421a != null) goto L5;
        this.f514421a = new LinkedHashMap();
    L5:
        View r101 = this.f514421a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f514421a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void e(List<Integer> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == false) goto L6;
        return;
    L6:
        int r101 = this.f514423c.size();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L13;
        if (r100.size() <= r102) goto L11;
        int r103 = ((Number) ListProtector.get(r100, r102)).intValue();
    L12:
        ((d) ListProtector.get(this.f514423c, r102)).setSelectedValue(r103);
        r102 = r102 + 1;
        goto L7
    L11:
        r103 = 0;
        goto L12
    L13:
        invalidate();
    }

    public b(Context r100, mm3.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "options");
        super(r100);
        this.f514421a = new LinkedHashMap();
        this.f514422b = r101;
        ArrayList r102 = new ArrayList();
        this.f514423c = r102;
        this.f514424d = new ArrayList();
        this.f514425e = new Dialog(r100, R.style.uicomponent_custom_dialog);
        if (r101.f514420f == false) goto L5;
        LayoutInflater.from(r100).inflate(R.layout.uicomponent_pickerview_selector_dark, this, true);
    L6:
        TextView r103 = (TextView) a(R.id.picker_left_action_tv);
        CharSequence r104 = r101.f514416b;
        if (r104 != null) goto L10;
        r104 = r100.getResources().getText(R.string.uicomponent_cancel);
    L10:
        r103.setText(r104);
        ((TextView) a(R.id.picker_left_action_tv)).setOnClickListener(new a(this));
        TextView r105 = (TextView) a(R.id.picker_right_action_tv);
        CharSequence r106 = r101.f514417c;
        if (r106 != null) goto L14;
        r106 = r100.getResources().getText(R.string.uicomponent_confirm);
    L14:
        r105.setText(r106);
        ((TextView) a(R.id.picker_right_action_tv)).setOnClickListener(new ViewOnClickListenerC6830b(this));
        ((TextView) a(R.id.picker_title)).setText(r101.f514415a);
        List<? extends List<? extends CharSequence>> r107 = r101.f514419e;
        if (r107 != null) goto L17;
        return;
    L17:
        if (r107.isEmpty() == true) goto L28;
        ((LinearLayout) a(R.id.picker_container)).removeAllViews();
        r102.clear();
        int r108 = r107.size();
        int r109 = 0;
    L20:
        if (r109 >= r108) goto L29;
        if (((List) ListProtector.get(r107, r109)).isEmpty() == true) goto L30;
        int r110 = d.D;
        Context r111 = getContext();
        this.f514422b.getClass();
        boolean r112 = this.f514422b.f514420f;
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        d r113 = new d(r111, r112);
        LinearLayout.LayoutParams r114 = new LinearLayout.LayoutParams(0, -2);
        r114.weight = 1.0f;
        r113.setLayoutParams(r114);
        r113.setOnChangeListener(new mm3.c(r109, this, r107));
        r113.c((List) ListProtector.get(r107, r109), 0);
        ((LinearLayout) a(R.id.picker_container)).addView(r113);
        ((ArrayList) this.f514423c).add(r113);
        r109 = r109 + 1;
        goto L20
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L5:
        LayoutInflater.from(r100).inflate(R.layout.uicomponent_pickerview_selector, this, true);
        goto L6
    }
}
