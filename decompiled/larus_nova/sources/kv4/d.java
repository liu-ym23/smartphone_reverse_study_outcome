package kv4;

import android.app.Dialog;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.ee.bear.bitable.websubpage.WebSubPage;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebSubPage f506271a;

    public d(WebSubPage r100) {
        this.f506271a = r100;
    }

    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView r100) {
        super.onCloseWindow(r100);
        Dialog r101 = this.f506271a.getDialog();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == true) goto L16;
        return;
    L16:
        this.f506271a.dismiss();     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L19;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L19:
        return;
    L5:
        if (r101.isShowing() != true) goto L7;
        r102 = true;
        goto L7
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r100, String r101) {
        super.onReceivedTitle(r100, r101);
        WebSubPage r102 = this.f506271a;
        r102.f216292p = r101;
        r102.updateTitle();
    }
}
