package com.larksuite.component.card.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.Layout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f283181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f283182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.larksuite.component.card.action.a f283183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f283184d;

    public static final class a implements UDBaseDialogBuilder.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.larksuite.component.card.action.a f283185a;

        /* JADX INFO: renamed from: com.larksuite.component.card.action.b$a$a, reason: collision with other inner class name */
        public static final class RunnableC3894a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.larksuite.component.card.action.a f283186a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TextView f283187b;

            public RunnableC3894a(com.larksuite.component.card.action.a r100, TextView r101) {
                this.f283186a = r100;
                this.f283187b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.larksuite.component.card.action.a r100 = this.f283186a;     // Catch: Throwable -> L18
                TextView r101 = this.f283187b;     // Catch: Throwable -> L18
                int r102 = com.larksuite.component.card.action.a.f283180a;     // Catch: Throwable -> L18
                r100.getClass();     // Catch: Throwable -> L18
                Layout r103 = r101.getLayout();     // Catch: Throwable -> L18
                if (r103 == null) goto L5;
                int r104 = r103.getLineCount();     // Catch: Throwable -> L18
            L6:
                int r105 = 1;
                if (r104 < 3) goto L9;
                boolean r106 = true;
            L10:
                if (r106 == false) goto L12;
                r105 = GravityCompat.START;
            L12:
                r101.setGravity(r105);     // Catch: Throwable -> L18
                if (r106 == false) goto L15;
                int r107 = 5;
            L16:
                r101.setTextAlignment(r107);     // Catch: Throwable -> L18
                return;
            L15:
                r107 = 4;
                goto L16
            L9:
                r106 = false;
                goto L10
            L5:
                r104 = r101.getLineCount();     // Catch: Throwable -> L18
            L18:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L22;
                return;
            L22:
                throw th;
            }
        }

        @Override // com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder.c
        public final void beforeCreate(UDDialog r100) {
            Intrinsics.checkNotNullParameter(r100, "dialog");
        }

        public a(com.larksuite.component.card.action.a r100) {
            this.f283185a = r100;
        }

        @Override // com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder.c
        public final void a(UDDialog r100) {
            Intrinsics.checkNotNullParameter(r100, "dialog");
            TextView r101 = (TextView) r100.findViewById(R.id.ud_dialog_content_message_tv);
            if (r101 != null) goto L6;
            Log.i("CardToastInterceptor", "messageTextViewNotFound");
            return;
        L6:
            r101.post(new RunnableC3894a(this.f283185a, r101));
        }
    }

    /* JADX INFO: renamed from: com.larksuite.component.card.action.b$b, reason: collision with other inner class name */
    public static final class DialogInterfaceOnClickListenerC3895b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f283188a;

        public DialogInterfaceOnClickListenerC3895b(Function0<Unit> r100) {
            this.f283188a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f283188a.invoke();
            Log.i("CardToastInterceptor", "universal card jump");
        }
    }

    public static final class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f283189a = null;

        static {
            f283189a = new c();
        }

        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            Log.i("CardToastInterceptor", "universal card cancel");
        }
    }

    public b(Activity r100, String r101, com.larksuite.component.card.action.a r102, Function0<Unit> r103) {
        this.f283181a = r100;
        this.f283182b = r101;
        this.f283183c = r102;
        this.f283184d = r103;
    }

    public final void a() {
        new UDDialogBuilder(this.f283181a).message(this.f283182b).messageTextSize(17).lifecycleCallback(new a(this.f283183c)).actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL).addActionButton(R.id.ud_dialog_btn_primary, R.string.Lark_BotCard_CardConfig_Button, new DialogInterfaceOnClickListenerC3895b(this.f283184d)).addActionButton(R.id.ud_dialog_btn_secondary, R.string.Lark_BotCard_CardConfigCancel_Button, c.f283189a).cancelOnTouchOutside(false).show();
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
