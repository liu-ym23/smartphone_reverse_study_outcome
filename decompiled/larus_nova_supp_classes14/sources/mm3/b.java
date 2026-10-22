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
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends FrameLayout {
    public Map<Integer, View> a;
    public final mm3.a b;
    public final List<d> c;
    public final List<Integer> d;
    public final Dialog e;
    public boolean f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            b r5 = this.a;
            r5.f = true;
            Dialog r6 = r5.e;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r6);
        L17:
            b r7 = this.a;
            nm3.a r1 = r7.b.d;
            if (r1 == null) goto L26;
            r1.d(b.b(r7));
            return;
        L26:
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r2 == null) goto L16;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r6));
            goto L17
        }
    }

    /* JADX INFO: renamed from: mm3.b$b, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0145b implements View.OnClickListener {
        public final /* synthetic */ b a;

        public ViewOnClickListenerC0145b(b r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            b r5 = this.a;
            r5.f = true;
            Dialog r6 = r5.e;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r6);
        L17:
            b r7 = this.a;
            nm3.a r1 = r7.b.d;
            if (r1 == null) goto L26;
            r1.c(b.b(r7));
            return;
        L26:
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r2 == null) goto L16;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r6));
            goto L17
        }
    }

    public static final class c implements DialogInterface.OnDismissListener {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            b r3 = this.a;
            if (r3.f == true) goto L5;
            r3.c();
        L5:
            this.a.f = false;
        }
    }

    private final List<Integer> getSelectedIndex() {
        ((ArrayList) this.d).clear();
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        d r1 = (d) r0.next();
        List<Integer> r2 = this.d;
        ArrayList r3 = (ArrayList) r2;
        r3.add(Integer.valueOf(r1.getCurrentSelectedValue()));
        goto L4
    L7:
        return this.d;
    }

    public final void c() {
        nm3.a r0 = this.b.d;
        if (r0 == null) goto L6;
        r0.b(getSelectedIndex());
        return;
    }

    public final void d() {
        this.e.setCancelable(true);
        Window r0 = this.e.getWindow();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setWindowAnimations(2131954905);
        WindowManager.LayoutParams r1 = r0.getAttributes();
        r1.width = -1;
        r0.setAttributes(r1);
        r0.setGravity(80);
        this.e.setOnDismissListener(new c(this));
        setMinimumWidth(10000);
        this.e.setContentView(this);
        Dialog r2 = this.e;
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(r2);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(r2);
        r2.show();
        DialogLancet.afterDialogShow(r2);
    }

    public static final /* synthetic */ List b(b r0) {
        return r0.getSelectedIndex();
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void e(List<Integer> r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.isEmpty() == false) goto L6;
        return;
    L6:
        int r0 = this.c.size();
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L13;
        if (r6.size() <= r2) goto L11;
        int r3 = ((Number) ListProtector.get(r6, r2)).intValue();
    L12:
        ((d) ListProtector.get(this.c, r2)).setSelectedValue(r3);
        r2 = r2 + 1;
        goto L7
    L11:
        r3 = 0;
        goto L12
    L13:
        invalidate();
    }

    public b(Context r8, mm3.a r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "options");
        super(r8);
        this.a = new LinkedHashMap();
        this.b = r9;
        ArrayList r1 = new ArrayList();
        this.c = r1;
        this.d = new ArrayList();
        this.e = new Dialog(r8, 2131954893);
        if (r9.f == false) goto L5;
        LayoutInflater.from(r8).inflate(2131568114, this, true);
    L6:
        TextView r3 = (TextView) a(2131382272);
        CharSequence r4 = r9.b;
        if (r4 != null) goto L10;
        r4 = r8.getResources().getText(2131923635);
    L10:
        r3.setText(r4);
        ((TextView) a(2131382272)).setOnClickListener(new a(this));
        TextView r5 = (TextView) a(2131382276);
        CharSequence r6 = r9.c;
        if (r6 != null) goto L14;
        r6 = r8.getResources().getText(2131923636);
    L14:
        r5.setText(r6);
        ((TextView) a(2131382276)).setOnClickListener(new ViewOnClickListenerC0145b(this));
        ((TextView) a(2131382290)).setText(r9.a);
        List<? extends List<? extends CharSequence>> r10 = r9.e;
        if (r10 != null) goto L17;
        return;
    L17:
        if (r10.isEmpty() == true) goto L28;
        ((LinearLayout) a(2131382269)).removeAllViews();
        r1.clear();
        int r2 = r10.size();
        int r7 = 0;
    L20:
        if (r7 >= r2) goto L29;
        if (((List) ListProtector.get(r10, r7)).isEmpty() == true) goto L30;
        int r11 = d.D;
        Context r12 = getContext();
        this.b.getClass();
        boolean r13 = this.b.f;
        Intrinsics.checkNotNullParameter(r12, "context");
        d r14 = new d(r12, r13);
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(0, -2);
        r15.weight = 1.0f;
        r14.setLayoutParams(r15);
        r14.setOnChangeListener(new mm3.c(r7, this, r10));
        r14.c((List) ListProtector.get(r10, r7), 0);
        ((LinearLayout) a(2131382269)).addView(r14);
        ((ArrayList) this.c).add(r14);
        r7 = r7 + 1;
        goto L20
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L5:
        LayoutInflater.from(r8).inflate(2131568113, this, true);
        goto L6
    }
}
