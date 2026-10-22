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
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.sharepermissiondialog.BottomPopupData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f551843l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f551844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f551845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f551846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f551847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UDCheckBox f551848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f551849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f551850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BottomSheetDialog f551851h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BottomSheetBehavior<View> f551852i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f551853j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f551854k;

    public interface a {
        void a(String r100, boolean r101);

        void b(String r100);

        void onCancel();

        void onClickClose();
    }

    public static final class b {
    }

    static {
    }

    public final void a() {
        BottomSheetDialog r100 = this.f551851h;
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

    public final boolean c() {
        BottomSheetDialog r100 = this.f551851h;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.isShowing());
    L6:
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Boolean");
        return r101.booleanValue();
    L5:
        r101 = null;
        goto L6
    }

    public c(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        View r101 = null;
        View r102 = LayoutInflater.from(r100).inflate(R.layout.bottom_pop_layout, null);
        this.f551849f = r102;
        this.f551844a = (TextView) r102.findViewById(R.id.tv_bottom_title);
        TextView r103 = (TextView) r102.findViewById(R.id.btn_confirm);
        this.f551845b = r103;
        TextView r104 = (TextView) r102.findViewById(R.id.tv_send_to_lark);
        this.f551846c = r104;
        this.f551847d = (TextView) r102.findViewById(R.id.tv_confirm_content);
        this.f551848e = (UDCheckBox) r102.findViewById(R.id.widget_circle_check_box);
        View r105 = r102.findViewById(R.id.btn_close);
        this.f551850g = r105;
        BottomSheetDialog r106 = new BottomSheetDialog(r100, R.style.BottomSheetDialog);
        this.f551851h = r106;
        r106.setContentView(r102);
        r106.setOnCancelListener(new uv4.a(this));
        Object r107 = r102.getParent();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.view.View");
        View r108 = (View) r107;
        Window r109 = r106.getWindow();
        if (r109 == null) goto L5;
        r101 = r109.findViewById(R.id.design_bottom_sheet);
    L5:
        if (r101 == null) goto L7;
        r101.setBackgroundResource(R.color.color_transparent);
    L7:
        BottomSheetBehavior<View> r110 = BottomSheetBehavior.from(r108);
        this.f551852i = r110;
        r102.measure(0, 0);
        if (r110 == null) goto L10;
        r110.setPeekHeight(r102.getMeasuredHeight());
    L10:
        ViewGroup.LayoutParams r111 = r108.getLayoutParams();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams r112 = (CoordinatorLayout.LayoutParams) r111;
        r112.gravity = 49;
        r108.setLayoutParams(r112);
        if (r110 == null) goto L13;
        r110.setBottomSheetCallback(new uv4.b(this));
    L13:
        if (r105 == null) goto L15;
        r105.setOnClickListener(new e(this));
    L15:
        if (r104 == null) goto L17;
        r104.setOnClickListener(new f(this));
    L17:
        if (r103 == null) goto L20;
        r103.setOnClickListener(new g(this));
        return;
    }

    public static String b(URLSpan r100) {
        String r101 = r100.getURL();     // Catch: Exception -> L10
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L10
        if (StringsKt.contains$default(r101, "lark://client/contact/personcard", false, 2, null) == false) goto L11;
        String r102 = UriProtector.getQueryParameter(UriProtector.parse(r101), "chatterId");     // Catch: Exception -> L10
        if (r102 == null) goto L8;
        return r102;
    L8:
        tt5.a.d("BottomPopView", "onClickUser: " + r102);     // Catch: Exception -> L10
    L11:
        return null;
    L10:
        tt5.a.d("BottomPopView", "onClick: urlSpan.url" + du5.b.g(r100.getURL()));
        goto L11
    }

    public final void d(BottomPopupData r110) {
        Intrinsics.checkNotNullParameter(r110, "bottomPopupData");
        TextView r100 = this.f551844a;
        if (r100 == null) goto L5;
        r100.setText(r110.getTitle());
    L5:
        TextView r101 = this.f551845b;
        if (r101 == null) goto L8;
        r101.setText(r110.getConfirmBtnText());
    L8:
        TextView r102 = this.f551846c;
        if (r102 == null) goto L11;
        r102.setText(r110.getSendLarkText());
    L11:
        UDCheckBox r103 = this.f551848e;
        if (r103 == null) goto L14;
        r103.setChecked(true);
    L14:
        int r104 = 0;
        if (r110.isShowCheckBox() == false) goto L22;
        TextView r105 = this.f551846c;
        if (r105 == null) goto L19;
        r105.setVisibility(0);
    L19:
        UDCheckBox r106 = this.f551848e;
        if (r106 == null) goto L28;
        r106.setVisibility(0);
    L28:
        String r111 = r110.getDes();
        TextView r107 = this.f551847d;
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.widget.TextView");
        Spanned r108 = Html.fromHtml(r111);
        SpannableStringBuilder r109 = new SpannableStringBuilder(r108);
        URLSpan[] r112 = (URLSpan[]) r109.getSpans(0, r108.length(), URLSpan.class);
        if (r112 != null) goto L31;
    L40:
        r107.setText(r111);
        tt5.a.h("BottomPopView", "setSpanText: have not parse link,not use span");
    L42:
        if (c() == true) goto L55;
        BottomSheetDialog r113 = this.f551851h;
        if (r113 != null) goto L46;
        return;
    L46:
        if (DialogLancet.shouldBlockDialogShow(r113) == false) goto L52;
        DialogLancet.handleBlockedDialogShow(r113);
        return;
    L52:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L51
    L49:
        DialogLancet.beforeDialogShow(r113);
        r113.show();
        DialogLancet.afterDialogShow(r113);
        return;
    L55:
        return;
    L31:
        if (r112.length != 0) goto L33;
        boolean r114 = true;
    L34:
        if (r114 == true) goto L40;
        int r115 = r112.length;
    L37:
        if (r104 >= r115) goto L39;
        URLSpan r116 = r112[r104];
        Intrinsics.checkNotNull(r116);
        int r117 = r109.getSpanStart(r116);
        int r118 = r109.getSpanEnd(r116);
        int r119 = r109.getSpanFlags(r116);
        r109.setSpan(new d(this, r116), r117, r118, r119);
        this.f551853j = b(r116);
        r104 = r104 + 1;
        goto L37
    L39:
        r107.setAutoLinkMask(1);
        r107.setText(r109);
        r107.setMovementMethod(LinkMovementMethod.getInstance());
        goto L42
    L33:
        r114 = false;
        goto L34
    L22:
        TextView r120 = this.f551846c;
        if (r120 == null) goto L25;
        r120.setVisibility(4);
    L25:
        UDCheckBox r121 = this.f551848e;
        if (r121 == null) goto L28;
        r121.setVisibility(4);
        goto L28
    }
}
