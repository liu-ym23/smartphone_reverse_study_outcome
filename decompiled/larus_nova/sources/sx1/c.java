package sx1;

import am2.x;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.service.f;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.bpea.cert.token.TokenCert;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f543795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f543796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f543797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f543798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<ViewPropertyAnimator> f543799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TokenCert f543800f;

    @Override // android.app.Dialog
    public final void onBackPressed() {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        Iterator r101 = ((ArrayList) this.f543799e).iterator();
    L19:
        if (r101.hasNext() == false) goto L23;
        ViewPropertyAnimator r102 = (ViewPropertyAnimator) r101.next();
        if (r102 == null) goto L19;
        r102.cancel();
        goto L19
    L23:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r103 == null) goto L16;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        a("no_wifi_alert");
        this.f543795a.setAlpha(0.0f);
        this.f543796b.setTranslationY(t6.a(getContext(), 20.0f));
        long r100 = 300;
        ((ArrayList) this.f543799e).add(this.f543795a.animate().alpha(1.0f).setDuration(r100));
        ((ArrayList) this.f543799e).add(this.f543796b.animate().translationY(0.0f).setDuration(r100));
        Iterator r101 = ((ArrayList) this.f543799e).iterator();
    L9:
        if (r101.hasNext() == false) goto L13;
        ViewPropertyAnimator r102 = (ViewPropertyAnimator) r101.next();
        if (r102 == null) goto L9;
        r102.start();
        goto L9
    L13:
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public c(Context r100) {
        super(r100, R.style.ttlive_mobile_flow_dialog);
        this.f543799e = new ArrayList();
        this.f543800f = TokenCert.with("bpea-live_mobile_flow_old");
    }

    public final void a(String r100) {
        String r101 = ((f) TTLiveSDKContext.getHostService()).d().appConfig().getMobileFlowUrl();
        HashMap r102 = new HashMap();
        r102.put("url", URLEncoder.encode(r101, "UTF-8"));     // Catch: Throwable -> L5
    L6:
        r102.put("telecom_carrier", e.a(getContext(), this.f543800f));
        r102.put("enter_from", "live");
        if (TextUtils.equals(r100, "no_wifi_byte_free") == false) goto L9;
        r102.put("alert_type", "popup");
    L9:
        u.l().sendLog(r100, r102, new Object[]{new x()});
        return;
    L5:
        r102.put("url", "");
        goto L6
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f543795a = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_mobile_flow, null);
        if (getWindow() == null) goto L5;
        getWindow().setLayout(-1, -1);
        getWindow().setDimAmount(0.0f);
    L5:
        setContentView(this.f543795a);
        this.f543796b = findViewById(R.id.content_view);
        this.f543797c = (TextView) findViewById(R.id.ttlive_flow_ok);
        this.f543798d = findViewById(R.id.ttlive_buy_flow);
        this.f543797c.setOnClickListener(new a(this));
        this.f543798d.setVisibility(8);
        this.f543797c.setOnTouchListener(new b(this));
    }
}
