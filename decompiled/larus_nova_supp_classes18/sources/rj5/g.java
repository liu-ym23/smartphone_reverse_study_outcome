package rj5;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.k0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g {
    public final Context a;
    public final com.bytedance.ee.bear.widgets.q b;

    public class a implements com.bytedance.ee.bear.contract.c0.a {
        public final /* synthetic */ g a;

        public final void a() {
            tt5.a.b("DeleteItemCallbackV2", "deleteDoc: onPostExecuteSuccess");
            this.a.b.a();
            Context r0 = this.a.a;
            Toast.showSuccessText(r0, r0.getString(2131887741), 0);
        }

        public final void c() {
            tt5.a.b("DeleteItemCallbackV2", "deleteDoc: onPreExecute");
            this.a.b.e();
        }

        public a(g r1) {
            this.a = r1;
        }

        public final void b(boolean r3) {
            tt5.a.h("DeleteItemCallbackV2", "deleteDoc: onOfflinePostExecute, success = " + r3);
            this.a.b.a();
            if (r3 == true) goto L6;
            g.a(this.a, -1);
            return;
        }

        public final void d(int r5, Throwable r6, String r7, int r8) {
            tt5.a.h("DeleteItemCallbackV2", "deleteDoc: onPostExecuteFail");
            this.a.b.a();
            ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
            boolean r0 = jg5.e.a.a.g();
            if (r0 == false) goto L5;
            ErrorResponse r1 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).e(r7, Integer.valueOf(r8), "DELETE_ENTITY", r6);
        L6:
            if (r0 == false) goto L12;
            if (r1 == null) goto L12;
            if (r1.getHasHandledUiAction() == false) goto L12;
            r1.getCallback().a(this.a.a, r1);
            return;
        L12:
            if (r0 == true) goto L18;
            gj5.b r2 = (gj5.b) org.koin.java.a.a(gj5.b.class);
            if (r5 != 900099011) goto L18;
            ((gj5.b) org.koin.java.a.a(gj5.b.class)).c("CCM_MOVE_RECYCLE_BIN", FileBizDomain.FileBizDomainCCM, r8, r7);
            return;
        L18:
            if (r5 == 233525003) goto L20;
            g.a(this.a, r5);
            return;
        L20:
            if ((this.a.a instanceof FragmentActivity) == true) goto L22;
            return;
        L22:
            if ((r6 instanceof NetService.ServerErrorException) == false) goto L27;
            String r9 = ((NetService.ServerErrorException) r6).getData();
            ((com.bytedance.ee.bear.contract.c0) org.koin.java.a.a(com.bytedance.ee.bear.contract.c0.class)).a0(this.a.a.getSupportFragmentManager(), r9, r7, r8);
            return;
        L27:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public g(Activity r3) {
        this.a = r3;
        this.b = new com.bytedance.ee.bear.widgets.q(r3, 0);
    }

    public final void b(final oj5.c r10) {
        tt5.a.b("DeleteItemCallbackV2", "onItemClick: docInfoData = " + r10);
        com.bytedance.ee.bear.more.c.b(r10, "delete");
        if (r10 == null) goto L48;
        final a r0 = new a(this);
        HashMap r1 = new HashMap();
        if (TextUtils.isEmpty(r10.getTitle()) == false) goto L7;
        String r2 = ((rc5.a) org.koin.java.a.a(rc5.a.class)).getDocumentDefaultName(this.a, r10.getType());
    L8:
        r1.put("filename", r2);
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == true) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == false) goto L16;
    L18:
        String r4 = "";
    L20:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("lark.scs.legalhold.delete") == false) goto L22;
        int r5 = 60;
    L23:
        String r6 = String.valueOf(r5);
        if (r3 == false) goto L26;
        String r7 = this.a.getString(2131889453);
    L27:
        if (r3 == false) goto L29;
        String r8 = this.a.getString(2131889414);
    L30:
        fp5.a r9 = (fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) new fp5.a(this.a).title(r7)).titleSize(16)).titleGravity(8388611)).message(r8)).messageTextSize(14)).messageGravity(8388611);
        r9.b(r4);
        r9.e = false;
        UDBaseDialogBuilder.ActionBuilder r11 = new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).textColorRes(2131102093);
        if (r3 == false) goto L33;
        int r12 = 2131889413;
    L34:
        fp5.a r13 = (fp5.a) r9.addActionButton(r11.text(r12).onClickListener(new f(this, r10, r0)));
        if (r3 == false) goto L37;
        int r14 = 2131888904;
    L38:
        Dialog r15 = ((fp5.a) r13.addActionButton(2131391778, r14, null)).build();
        if (DialogLancet.shouldBlockDialogShow(r15) == false) goto L46;
        DialogLancet.handleBlockedDialogShow(r15);
    L43:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).j(r10.getToken(), r10.getType(), r15);
        return;
    L46:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45
    L42:
        DialogLancet.beforeDialogShow(r15);
        r15.show();
        DialogLancet.afterDialogShow(r15);
        goto L43
    L37:
        r14 = 2131887716;
        goto L38
    L33:
        r12 = 2131887736;
        goto L34
    L29:
        r8 = xo5.a.c(this.a, 2131889588, "num", r6);
        goto L30
    L26:
        r7 = xo5.a.d(this.a, 2131889584, r1);
        goto L27
    L22:
        r5 = 30;
        goto L23
    L16:
        if (r10.isOwner() == true) goto L18;
        r4 = this.a.getResources().getString(2131889583);
        goto L20
    L11:
        if (DowngradeSettingUtil.a("downgradeNewDocDelete") == true) goto L13;
        r3 = true;
        goto L14
    L7:
        r2 = r10.getTitle();
        goto L8
    }

    public static void a(g r1, int r2) {
        r1.getClass();
        if (k0.b(r2) == false) goto L6;
        return;
    L6:
        if (r2 != 4202) goto L8;
        Toast.showFailureText(r1.a.getApplicationContext(), 2131887146);
        return;
    L8:
        Toast.showFailureText(r1.a.getApplicationContext(), r1.a.getString(2131887738), 0);
    }
}
