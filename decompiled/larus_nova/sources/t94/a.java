package t94;

import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.bdp.appbase.locate.map.BdpMapActivity;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BdpMapActivity f545079a;

    public a(BdpMapActivity r100) {
        this.f545079a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BdpMapActivity r101 = this.f545079a;
        l r102 = r101.f200813p;
        l r103 = r101.f200814q;
        if (r102 == null) goto L13;
        if (r103 == null) goto L13;
        StringBuilder r104 = new StringBuilder("amapuri://route/plan/?sourceApplication=");
        String r105 = r101.getPackageManager().getPackageInfo(r101.getPackageName(), 0).versionName;     // Catch: Exception -> L9
    L11:
        r104.append(r105);
        r104.append("&sname=");
        r104.append(r102.f545090a);
        r104.append("&slat=");
        r104.append(r102.f545091b.latitude);
        r104.append("&slon=");
        r104.append(r102.f545091b.longitude);
        r104.append("&dname=");
        r104.append(r103.f545090a);
        r104.append("&dlat=");
        r104.append(r103.f545091b.latitude);
        r104.append("&dlon=");
        r104.append(r103.f545091b.longitude);
        r104.append("&dev=0&t=2");
        r101.startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r104.toString())));
    L9:
        e = move-exception;
        g94.b.c().Y1(e);
        r105 = "";
    L13:
        if (this.f545079a.f200805h.isShowing() == false) goto L31;
        Dialog r106 = this.f545079a.f200805h;
        Handler r107 = DialogLancet.resolveDialogHandler(r106);
        if (r107 != null) goto L17;
    L19:
        DialogLancet.beforeDialogDismiss(r106);
        r106.dismiss();     // Catch: Throwable -> L22 Exception -> L24
    L28:
        DialogLancet.afterDialogDismiss(r106);
        return;
    L24:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L22
        Throwable r108 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L22
        if (r108 == null) goto L28;
        com.bytedance.crash.d.d(r108, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r106);
        throw th;
    L17:
        if (Looper.myLooper() == r107.getLooper()) goto L19;
        r107.post(DialogLancet.createDismissRunnable(r106));
        return;
    }
}
