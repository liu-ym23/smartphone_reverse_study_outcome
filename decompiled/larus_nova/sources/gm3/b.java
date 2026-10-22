package gm3;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hm3.b f481662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hm3.a f481663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<gm3.a> f481664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f481665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Dialog f481666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f481667f;

    public static final class a implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f481668a;

        public a(b r100) {
            this.f481668a = r100;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            b r101 = this.f481668a;
            if (r101.f481667f == true) goto L8;
            hm3.a r102 = r101.f481663b;
            if (r102 == null) goto L9;
            r102.onCancel();
            return;
        L9:
            return;
        }
    }

    public final void b() {
        Dialog r100 = this.f481666e;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isShowing() == false) goto L8;
        a(r100);
    L8:
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static void a(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public b(hm3.b r100, hm3.a r110, String r111, List<gm3.a> r112, Context r113, String r114) {
        this.f481662a = r100;
        this.f481663b = r110;
        this.f481664c = r112;
        this.f481665d = r114;
        if (r113 == null) goto L31;
        Dialog r101 = new Dialog(r113, R.style.uicomponent_custom_dialog);
        this.f481666e = r101;
        r101.setCancelable(true);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        r102.setBackgroundDrawableResource(android.R.color.transparent);
        r102.setWindowAnimations(R.style.uicomponent_picker_view_slide_anim);
        r102.setAttributes(r102.getAttributes());
        r102.setGravity(80);
    L7:
        View r103 = LayoutInflater.from(r113).inflate(R.layout.uicomponent_action_sheet, null);
        r103.setMinimumWidth(10000);
        TextView r104 = (TextView) r103.findViewById(R.id.action_sheet_cancel);
        if (r111 == null) goto L10;
        r104.setText(r111);
    L10:
        r104.setOnClickListener(new d(this));
        TextView r115 = (TextView) r103.findViewById(R.id.action_sheet_description);
        if (TextUtils.isEmpty(r114) == false) goto L13;
        r115.setVisibility(8);
    L14:
        LinearLayout r116 = (LinearLayout) r103.findViewById(R.id.action_sheet_container);
        if (r112 == null) goto L26;
        int r117 = r112.size();
        int r105 = 0;
    L17:
        if (r105 >= r117) goto L26;
        if (r105 == 0) goto L20;
    L22:
        boolean r106 = false;
    L23:
        if (r106 == true) goto L25;
        View r107 = new View(r113);
        r107.setBackgroundColor(r113.getResources().getColor(R.color.ttlive_std_line_black_1));
        r107.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        r116.addView(r107);
    L25:
        View r108 = LayoutInflater.from(r113).inflate(R.layout.uicomponent_action_sheet_item, null);
        r116.addView(r108);
        gm3.a r109 = (gm3.a) ListProtector.get(r112, r105);
        ((TextView) r108.findViewById(R.id.action_sheet_item_tv)).setText(r109.f481660b);
        r108.setOnClickListener(new c(r109, this));
        r105 = r105 + 1;
        goto L17
    L20:
        if (TextUtils.isEmpty(this.f481665d) == false) goto L22;
        r106 = true;
    L26:
        r101.setContentView(r103);
        r101.setOnDismissListener(new a(this));
        return;
    L13:
        r115.setVisibility(0);
        r115.setText(r114);
        goto L14
    }
}
