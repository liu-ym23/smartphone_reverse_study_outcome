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
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BdpMapActivity f545080a;

    public b(BdpMapActivity r100) {
        this.f545080a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BdpMapActivity r101 = this.f545080a;
        l r102 = r101.f200813p;
        l r103 = r101.f200814q;
        if (r102 == null) goto L8;
        if (r103 == null) goto L8;
        r101.startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse("baidumap://map/direction?coord_type=gcj02&origin_region=" + r102.f545090a + "&origin=name:" + r102.f545090a + "|latlng:" + r102.f545091b.latitude + "," + r102.f545091b.longitude + "&destination_region=" + r103.f545090a + "&destination=name:" + r103.f545090a + "|latlng:" + r103.f545091b.latitude + "," + r103.f545091b.longitude + "&mode=walking")));
    L8:
        if (this.f545080a.f200805h.isShowing() == false) goto L26;
        Dialog r104 = this.f545080a.f200805h;
        Handler r105 = DialogLancet.resolveDialogHandler(r104);
        if (r105 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(r104);
        r104.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r104);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r104);
        throw th;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r106 == null) goto L23;
        com.bytedance.crash.d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L23
    L12:
        if (Looper.myLooper() == r105.getLooper()) goto L14;
        r105.post(DialogLancet.createDismissRunnable(r104));
        return;
    }
}
