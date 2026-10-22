package ds9;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;
import v19.j5;

/* JADX INFO: loaded from: classes31.dex */
public final class f extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f469882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f469883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f469884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f469885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f469886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f469887f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f469888g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f469889h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f469890i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f469891j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g f469892k;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        g r100 = this.f469892k;
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    public static void a(f r100) {
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

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.larus_custom_praise_dialog);
        setCanceledOnTouchOutside(false);
        this.f469884c = (ViewGroup) findViewById(R.id.custom_praise_dialog_container);
        this.f469885d = findViewById(R.id.custom_praise_dialog_close);
        this.f469886e = (TextView) findViewById(R.id.custom_praise_dialog_complaint_text);
        this.f469887f = (TextView) findViewById(R.id.custom_praise_dialog_praise_text);
        this.f469888g = (ImageView) findViewById(R.id.custom_praise_dialog_stars);
        this.f469889h = (TextView) findViewById(R.id.custom_praise_dialog_main_title);
        this.f469890i = (TextView) findViewById(R.id.custom_praise_dialog_subtitle);
        this.f469891j = (ImageView) findViewById(R.id.custom_praise_dialog_avatar);
        LinearLayout.LayoutParams r101 = null;
        if (this.f469883b == false) goto L21;
        ImageView r102 = this.f469888g;
        if (r102 == null) goto L7;
        r102.setVisibility(8);
    L7:
        TextView r103 = this.f469890i;
        if (r103 == null) goto L15;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if ((r104 instanceof LinearLayout.LayoutParams) == false) goto L12;
        r101 = (LinearLayout.LayoutParams) r104;
    L12:
        if (r101 == null) goto L14;
        r101.setMargins(0, i5.r0(), 0, i5.q());
    L14:
        r103.setLayoutParams(r101);
    L15:
        TextView r105 = this.f469887f;
        if (r105 == null) goto L18;
        r105.setText(getContext().getResources().getString(R.string.larus_rate_us_btn));
    L18:
        TextView r106 = this.f469886e;
        if (r106 == null) goto L39;
        r106.setText(getContext().getResources().getString(R.string.larus_feedback_btn));
    L39:
        if (AppHost.f326268a.isOversea() == true) goto L49;
        TextView r107 = this.f469889h;
        if (r107 == null) goto L43;
        r107.setText(getContext().getResources().getString(R.string.larus_rating_title_cn));
    L43:
        TextView r108 = this.f469890i;
        if (r108 == null) goto L46;
        r108.setText(getContext().getResources().getString(R.string.larus_rating_subtitle));
    L46:
        ImageView r109 = this.f469891j;
        if (r109 == null) goto L58;
        r109.setImageResource(R.drawable.larus_ic_custom_praise_dialog_avatar_grace);
    L58:
        setOnShowListener(new ds9.a(this));
        setOnDismissListener(new b(this));
        View r110 = this.f469885d;
        if (r110 == null) goto L61;
        r110.setOnClickListener(new c(this));
    L61:
        TextView r111 = this.f469886e;
        if (r111 == null) goto L64;
        r111.setOnClickListener(new d(this));
    L64:
        TextView r112 = this.f469887f;
        if (r112 == null) goto L68;
        r112.setOnClickListener(new e(this));
        return;
    L68:
        return;
    L49:
        TextView r113 = this.f469889h;
        if (r113 == null) goto L52;
        r113.setText(j5.a(getContext(), R.string.app_string_name, R.string.larus_dola_feedback_popup_card_header_global));
    L52:
        TextView r114 = this.f469890i;
        if (r114 == null) goto L55;
        r114.setText(j5.a(getContext(), R.string.app_string_name, R.string.larus_dola_feedback_popup_card_desc_global));
    L55:
        ImageView r115 = this.f469891j;
        if (r115 == null) goto L58;
        r115.setImageResource(R.drawable.larus_ic_custom_praise_dialog_avatar_cici);
        goto L58
    L21:
        ImageView r116 = this.f469888g;
        if (r116 == null) goto L24;
        r116.setVisibility(0);
    L24:
        TextView r117 = this.f469890i;
        if (r117 == null) goto L32;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        if ((r118 instanceof LinearLayout.LayoutParams) == false) goto L29;
        r101 = (LinearLayout.LayoutParams) r118;
    L29:
        if (r101 == null) goto L31;
        r101.setMargins(0, i5.r0(), 0, i5.r0());
    L31:
        r117.setLayoutParams(r101);
    L32:
        TextView r119 = this.f469887f;
        if (r119 == null) goto L35;
        r119.setText(getContext().getResources().getString(R.string.larus_rating_rating));
    L35:
        TextView r120 = this.f469886e;
        if (r120 == null) goto L39;
        r120.setText(getContext().getResources().getString(R.string.larus_rating_feedback));
        goto L39
    }

    public f(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "from");
        super(r100, R.style.OApp_Praise_Dialog_Alert);
        this.f469882a = r101;
        this.f469883b = false;
    }
}
