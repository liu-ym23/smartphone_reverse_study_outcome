package com.bytedance.lynx.webview.internal;

import android.app.AlertDialog;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.bytedance.lynx.webview.TTWebSdk;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes21.dex */
public final class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TTWebSdk.QuickAppHandler f265384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebView f265385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y.b f265386c;

    public class a implements ValueCallback<TTWebSdk.QuickAppHandler.QuickAppAction> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z f265387a;

        public a(z r100) {
            this.f265387a = r100;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(TTWebSdk.QuickAppHandler.QuickAppAction r100) {
            z r101 = this.f265387a;
            y.b r102 = r101.f265386c;
            WebView r103 = r101.f265385b;
            r102.b(r103, r100);
        }
    }

    public final void a() {
        TTWebSdk.QuickAppHandler r100 = this.f265384a;
        WebView r101 = this.f265385b;
        a r102 = new a(this);
        ((TTWebContext.g) r100).getClass();
        AlertDialog r103 = new AlertDialog.Builder(r101.getContext()).create();     // Catch: Exception -> L11
        r103.setMessage(r101.getContext().getString(R.string.leave_goto_quickapp));     // Catch: Exception -> L11
        r103.setButton(-1, r101.getContext().getString(R.string.allow), new v0(r102));     // Catch: Exception -> L11
        r103.setButton(-2, r101.getContext().getString(R.string.cancel), new w0(r102));     // Catch: Exception -> L11
        r103.setButton(-3, r101.getContext().getString(R.string.site_feedback), new x0(r102));     // Catch: Exception -> L11
        r103.setOnCancelListener(new y0(r102));     // Catch: Exception -> L11
        r103.setCanceledOnTouchOutside(false);     // Catch: Exception -> L11
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r103);     // Catch: Exception -> L11
    L9:
        l17.k.d(new String[]{"quick app alert dialog"});     // Catch: Exception -> L11
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L8:
        DialogLancet.beforeDialogShow(r103);     // Catch: Exception -> L11
        r103.show();     // Catch: Exception -> L11
        DialogLancet.afterDialogShow(r103);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        r102.onReceiveValue(TTWebSdk.QuickAppHandler.QuickAppAction.QUICK_APP_ACTION_PROCEED);
        l17.k.b(new String[]{"quick app dialog exception: " + e.toString()});
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

    public z(y.b r100, TTWebSdk.QuickAppHandler r101, WebView r102) {
        this.f265386c = r100;
        this.f265384a = r101;
        this.f265385b = r102;
    }
}
