package lu;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements ju.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ju.b f510781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f510782b;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f510783a = null;

        static {
            f510783a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
        }
    }

    @Override // ju.b
    public final void onVerifyResult(int r100) {
        ju.b r101 = this.f510781a;
        if (r101 == null) goto L7;
        r101.onVerifyResult(r100);
        return;
    L7:
        if (r100 != 3) goto L9;
        return;
    L9:
        if (r100 != 2) goto L23;
        Activity r102 = this.f510782b;
        String r103 = y0.i(R.string.gamecp_minor_intercept_content);
        String r104 = y0.i(R.string.gamecp_game_race_event_subscribe_success_confirm);
        a r105 = a.f510783a;
        com.bytedance.android.gamecp.common.ui.i.c r106 = new com.bytedance.android.gamecp.common.ui.i.c();
        r106.f57005b = r102;
        r106.f57004a = 0;
        r106.f57007d = r103;
        com.bytedance.android.gamecp.common.ui.i.b[] r107 = r106.f57008e;
        com.bytedance.android.gamecp.common.ui.i.b r108 = r107[0];
        if (r108 != null) goto L13;
        r108 = new com.bytedance.android.gamecp.common.ui.i.b();
        r107[0] = r108;
    L13:
        r108.f57001a = r104;
        r108.f57002b = r105;
        com.bytedance.android.gamecp.common.ui.i r109 = new com.bytedance.android.gamecp.common.ui.i(r106.f57005b, r106);
        if (DialogLancet.shouldBlockDialogShow(r109) == false) goto L20;
        DialogLancet.handleBlockedDialogShow(r109);
        return;
    L20:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L17:
        DialogLancet.beforeDialogShow(r109);
        r109.show();
        DialogLancet.afterDialogShow(r109);
        return;
    }

    public f(ju.b r100, Activity r101) {
        this.f510781a = r100;
        this.f510782b = r101;
    }
}
