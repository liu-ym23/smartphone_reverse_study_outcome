package com.ss.android.lark.todo.impl.features.common.share.helper;

import android.content.Context;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import c8c.c;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.todo.impl.features.common.share.entity.ShareEntity;
import com.ss.android.lark.todo.impl.utils.i;
import com.ss.android.lark.ui.CommonDialog;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f442483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShareEntity f442484b;

    public b(Context r100, ShareEntity r101) {
        this.f442483a = r100;
        this.f442484b = r101;
    }

    public final void a() {
        Context r100 = this.f442483a;
        if (r100 == null) goto L38;
        ShareEntity r101 = this.f442484b;
        int r102 = c.f22758a;
        i r103 = i.f444291a;
        String r104 = r103.g(R.string.Todo_Common_FailToSend);
        String r105 = r101.getErrorStr();
        String r106 = r103.g(R.string.Todo_Task_Confirm);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "title");
        Intrinsics.checkNotNullParameter(r105, "message");
        Intrinsics.checkNotNullParameter(r106, "btnText");
        CommonDialog r107 = new CommonDialog(r100);
        if (TextUtils.isEmpty(r104) == false) goto L9;
        TextView r108 = r107.f444523f;
        if (r108 == null) goto L14;
        r108.setVisibility(8);
    L14:
        if (TextUtils.isEmpty(r105) == false) goto L18;
        TextView r109 = r107.f444524g;
        if (r109 == null) goto L23;
        r109.setVisibility(8);
    L23:
        if (TextUtils.isEmpty(r104) == false) goto L25;
        r107.f444524g.setTypeface(r107.f444524g.getTypeface(), 1);
        r107.f444524g.setTextSize(17);
        r107.f444524g.setTextColor(UIUtils.getColor(r100, R.color.lkui_N900));
    L25:
        c8c.b r110 = new c8c.b(r107);
        r107.f444526i.setVisibility(8);
        r107.f444527j.setVisibility(8);
        r107.f444528k.setVisibility(8);
        r107.f444529l.setVisibility(0);
        if (TextUtils.isEmpty(r106) == false) goto L28;
        r107.f444529l.setText(r107.f444530m.getString(R.string.Lark_Legacy_ConfirmInfo));
    L29:
        TextView r111 = r107.f444529l;
        r111.setVisibility(0);
        r111.setOnClickListener(new CommonDialog.a(r107, r110));
        LinearLayout.LayoutParams r112 = (LinearLayout.LayoutParams) r107.f444523f.getLayoutParams();
        r112.gravity = 1;
        r107.f444523f.setLayoutParams(r112);
        r107.f444524g.setTextSize(14);
        r107.f444524g.setTextColor(r103.a(R.color.lkui_N600));
        r107.setCanceledOnTouchOutside(false);
        r107.setCancelable(false);
        if (DialogLancet.shouldBlockDialogShow(r107) == false) goto L36;
        DialogLancet.handleBlockedDialogShow(r107);
        return;
    L36:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L35
    L33:
        DialogLancet.beforeDialogShow(r107);
        r107.show();
        DialogLancet.afterDialogShow(r107);
        return;
    L28:
        r107.f444529l.setText(r106);
        goto L29
    L18:
        TextView r113 = r107.f444524g;
        if (r113 == null) goto L21;
        r113.setVisibility(0);
    L21:
        r107.f444524g.setText(r105);
        goto L23
    L9:
        TextView r114 = r107.f444523f;
        if (r114 == null) goto L12;
        r114.setVisibility(0);
    L12:
        r107.f444523f.setText(r104);
        goto L14
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
}
