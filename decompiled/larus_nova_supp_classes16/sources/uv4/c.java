package uv4;

import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.sharepermissiondialog.BottomPopupData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static final /* synthetic */ int l = 0;
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final UDCheckBox e;
    public final View f;
    public final View g;
    public final BottomSheetDialog h;
    public final BottomSheetBehavior<View> i;
    public String j;
    public a k;

    public interface a {
        void a(String r1, boolean r2);

        void b(String r1);

        void onCancel();

        void onClickClose();
    }

    public static final class b {
    }

    static {
    }

    public final void a() {
        BottomSheetDialog r0 = this.h;
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
        return;
    }

    public final boolean c() {
        BottomSheetDialog r0 = this.h;
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.isShowing());
    L6:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Boolean");
        return r1.booleanValue();
    L5:
        r1 = null;
        goto L6
    }

    public c(FragmentActivity r8) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        View r2 = null;
        View r0 = LayoutInflater.from(r8).inflate(2131559204, null);
        this.f = r0;
        this.a = (TextView) r0.findViewById(2131390246);
        TextView r1 = (TextView) r0.findViewById(2131364689);
        this.b = r1;
        TextView r3 = (TextView) r0.findViewById(2131391403);
        this.c = r3;
        this.d = (TextView) r0.findViewById(2131390383);
        this.e = r0.findViewById(2131393190);
        View r4 = r0.findViewById(2131364679);
        this.g = r4;
        BottomSheetDialog r5 = new BottomSheetDialog(r8, 2131951924);
        this.h = r5;
        r5.setContentView(r0);
        r5.setOnCancelListener(new uv4.a(this));
        Object r9 = r0.getParent();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.view.View");
        View r10 = (View) r9;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L5;
        r2 = r6.findViewById(2131368870);
    L5:
        if (r2 == null) goto L7;
        r2.setBackgroundResource(2131101106);
    L7:
        BottomSheetBehavior<View> r7 = BottomSheetBehavior.from(r10);
        this.i = r7;
        r0.measure(0, 0);
        if (r7 == null) goto L10;
        r7.setPeekHeight(r0.getMeasuredHeight());
    L10:
        CoordinatorLayout.LayoutParams r11 = r10.getLayoutParams();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams r12 = r11;
        r12.gravity = 49;
        r10.setLayoutParams(r12);
        if (r7 == null) goto L13;
        r7.setBottomSheetCallback(new uv4.b(this));
    L13:
        if (r4 == null) goto L15;
        r4.setOnClickListener(new e(this));
    L15:
        if (r3 == null) goto L17;
        r3.setOnClickListener(new f(this));
    L17:
        if (r1 == null) goto L20;
        r1.setOnClickListener(new g(this));
        return;
    }

    public static String b(URLSpan r7) {
        String r3 = r7.getURL();     // Catch: Exception -> L10
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L10
        if (StringsKt.contains$default(r3, "lark://client/contact/personcard", false, 2, null) == false) goto L11;
        String r4 = UriProtector.getQueryParameter(UriProtector.parse(r3), "chatterId");     // Catch: Exception -> L10
        if (r4 == null) goto L8;
        return r4;
    L8:
        tt5.a.d("BottomPopView", "onClickUser: " + r4);     // Catch: Exception -> L10
    L11:
        return null;
    L10:
        tt5.a.d("BottomPopView", "onClick: urlSpan.url" + du5.b.g(r7.getURL()));
        goto L11
    }

    public final void d(BottomPopupData r11) {
        Intrinsics.checkNotNullParameter(r11, "bottomPopupData");
        TextView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setText(r11.getTitle());
    L5:
        TextView r1 = this.b;
        if (r1 == null) goto L8;
        r1.setText(r11.getConfirmBtnText());
    L8:
        TextView r2 = this.c;
        if (r2 == null) goto L11;
        r2.setText(r11.getSendLarkText());
    L11:
        UDCheckBox r3 = this.e;
        if (r3 == null) goto L14;
        r3.setChecked(true);
    L14:
        int r4 = 0;
        if (r11.isShowCheckBox() == false) goto L22;
        TextView r5 = this.c;
        if (r5 == null) goto L19;
        r5.setVisibility(0);
    L19:
        UDCheckBox r6 = this.e;
        if (r6 == null) goto L28;
        r6.setVisibility(0);
    L28:
        String r12 = r11.getDes();
        TextView r7 = this.d;
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.widget.TextView");
        Spanned r8 = Html.fromHtml(r12);
        SpannableStringBuilder r9 = new SpannableStringBuilder(r8);
        URLSpan[] r10 = (URLSpan[]) r9.getSpans(0, r8.length(), URLSpan.class);
        if (r10 != null) goto L31;
    L40:
        r7.setText(r12);
        tt5.a.h("BottomPopView", "setSpanText: have not parse link,not use span");
    L42:
        if (c() == true) goto L55;
        BottomSheetDialog r13 = this.h;
        if (r13 != null) goto L46;
        return;
    L46:
        if (DialogLancet.shouldBlockDialogShow(r13) == false) goto L52;
        DialogLancet.handleBlockedDialogShow(r13);
        return;
    L52:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L51
    L49:
        DialogLancet.beforeDialogShow(r13);
        r13.show();
        DialogLancet.afterDialogShow(r13);
        return;
    L55:
        return;
    L31:
        if (r10.length != 0) goto L33;
        boolean r14 = true;
    L34:
        if (r14 == true) goto L40;
        int r16 = r10.length;
    L37:
        if (r4 >= r16) goto L39;
        URLSpan r17 = r10[r4];
        Intrinsics.checkNotNull(r17);
        int r18 = r9.getSpanStart(r17);
        int r19 = r9.getSpanEnd(r17);
        int r20 = r9.getSpanFlags(r17);
        r9.setSpan(new d(this, r17), r18, r19, r20);
        this.j = b(r17);
        r4 = r4 + 1;
        goto L37
    L39:
        r7.setAutoLinkMask(1);
        r7.setText(r9);
        r7.setMovementMethod(LinkMovementMethod.getInstance());
        goto L42
    L33:
        r14 = false;
        goto L34
    L22:
        TextView r21 = this.c;
        if (r21 == null) goto L25;
        r21.setVisibility(4);
    L25:
        UDCheckBox r22 = this.e;
        if (r22 == null) goto L28;
        r22.setVisibility(4);
        goto L28
    }
}
