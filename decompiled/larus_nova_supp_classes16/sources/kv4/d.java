package kv4;

import android.app.Dialog;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.ee.bear.bitable.websubpage.WebSubPage;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends WebChromeClient {
    public final /* synthetic */ WebSubPage a;

    public d(WebSubPage r1) {
        this.a = r1;
    }

    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView r3) {
        super.onCloseWindow(r3);
        Dialog r4 = this.a.getDialog();
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        if (r0 == true) goto L16;
        return;
    L16:
        this.a.dismiss();     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L19;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L19:
        return;
    L5:
        if (r4.isShowing() != true) goto L7;
        r0 = true;
        goto L7
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r1, String r2) {
        super.onReceivedTitle(r1, r2);
        WebSubPage r3 = this.a;
        r3.p = r2;
        r3.updateTitle();
    }
}
