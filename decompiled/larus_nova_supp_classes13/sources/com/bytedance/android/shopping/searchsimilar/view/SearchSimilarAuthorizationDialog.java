package com.bytedance.android.shopping.searchsimilar.view;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.abtest.SettingKeys;
import com.bytedance.android.shopping.anchorv3.detail.vo.AuthorizationDialogImageInfo;
import com.bytedance.android.shopping.anchorv3.detail.vo.DialogImageInfo;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import gh3.e;
import gh3.g;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/view/SearchSimilarAuthorizationDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchSimilarAuthorizationDialog extends AppCompatDialog implements View.OnClickListener {
    public SimpleDraweeView a;
    public TextView b;
    public TextView c;
    public View d;
    public boolean e;
    public boolean f;

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Context r0 = getContext();
        if ((r0 instanceof Activity) == true) goto L5;
        r0 = null;
    L5:
        Activity r1 = (Activity) r0;
        if (r1 == null) goto L11;
        if (r1.isFinishing() != true) goto L11;
        return;
    L11:
        if (this.e == true) goto L17;
        int r2 = g.a;
        if (this.f == false) goto L15;
        String r3 = "open";
    L16:
        g.b(r3, "quit");
        goto L17
    L15:
        r3 = FreqActions.ACTION_CLOSE;
    L17:
        Handler r4 = DialogLancet.resolveDialogHandler(this);
        if (r4 != null) goto L20;
    L22:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L25 Exception -> L27
    L31:
        DialogLancet.afterDialogDismiss(this);
        return;
    L27:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L25
        Throwable r5 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L25
        if (r5 == null) goto L31;
        com.bytedance.crash.d.d(r5, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L20:
        if (Looper.myLooper() == r4.getLooper()) goto L22;
        r4.post(DialogLancet.createDismissRunnable(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        Context r0 = getContext();
        if ((r0 instanceof Activity) == true) goto L5;
        r0 = null;
    L5:
        Activity r1 = (Activity) r0;
        if (r1 == null) goto L11;
        if (r1.isFinishing() != true) goto L11;
        return;
    L11:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L22;
        DialogLancet.handleBlockedDialogShow(this);
    L15:
        int r2 = g.a;
        if (this.f == false) goto L18;
        String r3 = "open";
    L19:
        e r4 = new e("similar_product_notice_show");
        r4.a = r3;
        r4.post(null, null);
        return;
    L18:
        r3 = FreqActions.ACTION_CLOSE;
        goto L19
    L22:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L14:
        DialogLancet.beforeDialogShow(this);
        super/*android.app.Dialog*/.show();
        DialogLancet.afterDialogShow(this);
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void I0(SearchSimilarAuthorizationDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        if (r6 == null) goto L4;
        Integer r7 = Integer.valueOf(r6.getId());
    L6:
        if (r7 != null) goto L9;
    L17:
        if (r7 != null) goto L20;
    L28:
        if (r7 != null) goto L31;
        return;
    L31:
        if (r7.intValue() != 2131370766) goto L36;
        I0(this);
        return;
    L36:
        return;
    L20:
        if (r7.intValue() != 2131370840) goto L28;
        if (this.f == true) goto L27;
        int r8 = ECSdk.a;
        s83.g r9 = (s83.g) ECSdk.a(s83.g.class);
        if (r9 == null) goto L26;
        r9.g0(getContext(), true);
    L26:
        UIUtils.displayToast(getContext(), 2131896905);
        g.b(FreqActions.ACTION_CLOSE, "open");
        this.e = true;
    L27:
        I0(this);
        return;
    L9:
        if (r7.intValue() != 2131370839) goto L17;
        if (this.f == false) goto L16;
        int r10 = ECSdk.a;
        s83.g r11 = (s83.g) ECSdk.a(s83.g.class);
        if (r11 == null) goto L15;
        r11.g0(getContext(), false);
    L15:
        UIUtils.displayToast(getContext(), 2131896904);
        g.b("open", FreqActions.ACTION_CLOSE);
        this.e = true;
    L16:
        I0(this);
        return;
    L4:
        r7 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchSimilarAuthorizationDialog(Context r6, boolean r7) {
        super(r6);
        this.f = r7;
        Window r8 = getWindow();
        boolean r9 = false;
        if (r8 == null) goto L10;
        r8.requestFeature(1);
        View r1 = r8.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L9:
        r1.setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams r3 = r8.getAttributes();
        r3.width = -1;
        r3.height = -2;
        r3.windowAnimations = 2131954130;
        r3.gravity = 80;
        r8.setAttributes(r3);
        r8.setBackgroundDrawableResource(R.color.transparent);
    L10:
        setContentView(2131560839);
        this.a = findViewById(2131371212);
        this.b = (TextView) findViewById(2131370839);
        this.c = (TextView) findViewById(2131370840);
        this.d = findViewById(2131370766);
        setCanceledOnTouchOutside(true);
        if (com.bytedance.android.shopping.searchsimilar.utils.a.a() != 1) goto L13;
    L15:
        this.f = r9;
        AuthorizationDialogImageInfo r10 = SettingKeys.getSEARCH_SIMILAR_DIALOG_IMAGE();
        if (r10 == null) goto L28;
        DialogImageInfo r11 = r10.getValues();
        if (r11 == null) goto L28;
        if (this.f == false) goto L24;
        SimpleDraweeView r12 = this.a;
        if (r12 == null) goto L28;
        y.a(r12, r11.getCloseStatusImage());
        goto L28
    L24:
        SimpleDraweeView r13 = this.a;
        if (r13 == null) goto L28;
        y.a(r13, r11.getOpenStatusImage());
    L28:
        if (this.f == false) goto L35;
        TextView r14 = this.b;
        if (r14 == null) goto L32;
        r14.setText(2131896895);
    L32:
        TextView r15 = this.c;
        if (r15 == null) goto L41;
        r15.setText(2131896898);
    L41:
        TextView r16 = this.b;
        if (r16 == null) goto L44;
        r16.setOnClickListener(this);
    L44:
        TextView r17 = this.c;
        if (r17 == null) goto L47;
        r17.setOnClickListener(this);
    L47:
        View r18 = this.d;
        if (r18 == null) goto L51;
        r18.setOnClickListener(this);
        return;
    L51:
        return;
    L35:
        TextView r19 = this.b;
        if (r19 == null) goto L38;
        r19.setText(2131896903);
    L38:
        TextView r20 = this.c;
        if (r20 == null) goto L41;
        r20.setText(2131896902);
        goto L41
    L13:
        if (com.bytedance.android.shopping.searchsimilar.utils.a.a() == 2) goto L15;
        r9 = true;
        goto L15
    }
}
