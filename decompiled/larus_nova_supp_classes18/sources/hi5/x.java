package hi5;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.u4;
import com.bytedance.ee.bear.middleground.permission.external.SceneType;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.PolicyConfig;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.passport.signinsdk_api.base.policy.PolicyAgreement;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x {
    public static final int a = 0;

    public interface a {
    }

    static {
        a = SceneType.PASSWORD_SHARE.getValue();
    }

    public static void a(UDDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public static void c(UDDialog r5) {
        if (com.bytedance.ee.bear.middleground.permission.b.m() == true) goto L6;
        tt5.a.h("LinkShareUtils", "[mask issue fix] fixSafeTipsDialogFrame skip, fg disabled.");
        return;
    L6:
        View r0 = null;
        if (r5 != null) goto L9;
        Window r6 = null;
    L10:
        if (r6 == null) goto L17;
        r0 = r6.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L17;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r7 = ThreadMethodProxy.currentThread();
        if (r7 == com.larus.home.impl.utils.c.a) goto L17;
        com.larus.home.impl.utils.c.a(r7, "getDecorView");
    L17:
        View r8 = b(r0, "ud_dialog_frame");
        View r1 = b(r0, "ud_dialog_root");
        if (r8 == null) goto L23;
        if (r1 == null) goto L23;
        tt5.a.h("LinkShareUtils", "[mask issue fix] fixSafeTipsDialogFrame register, framePadding=" + d(r8) + ", rootSize=" + r1.getWidth() + "x" + r1.getHeight());
        r1.getViewTreeObserver().addOnPreDrawListener(new w(r1, r8));
        return;
    L23:
        StringBuilder r2 = new StringBuilder("[mask issue fix] fixSafeTipsDialogFrame skip, frameNull=");
        boolean r3 = false;
        if (r8 != null) goto L26;
        boolean r9 = true;
    L27:
        r2.append(r9);
        r2.append(", rootNull=");
        if (r1 != null) goto L30;
        r3 = true;
    L30:
        r2.append(r3);
        tt5.a.h("LinkShareUtils", r2.toString());
        return;
    L26:
        r9 = false;
        goto L27
    L9:
        r6 = r5.getWindow();
        goto L10
    }

    public static String d(View r3) {
        if (r3 != null) goto L6;
        return "null";
    L6:
        return "[" + r3.getPaddingLeft() + "," + r3.getPaddingTop() + "," + r3.getPaddingRight() + "," + r3.getPaddingBottom() + "]";
    }

    public static View b(View r4, String r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r6 = r4.getResources().getIdentifier(r5, ResourceData.KEY_ID, r4.getContext().getPackageName());
        if (r6 != 0) goto L9;
        return null;
    L9:
        return r4.findViewById(r6);
    }

    public static void g(HashMap<String, String> r1, String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        String r3 = av5.c.b(r2, r1, false);
        ((com.bytedance.ee.bear.route.h) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).u5(r3);
        return;
    L5:
        tt5.a.d("LinkShareUtils", "empty navigateRealNameDialog");
    }

    public static void h(Context r2, Throwable r3) {
        tt5.a.f("LinkShareUtils", r3, false);
        if (ax4.d.b(r3, 10029) == false) goto L6;
        Toast.showFailureText(r2, 2131887263);
        return;
    L6:
        if (ax4.d.b(r3, 10040) == false) goto L8;
        Toast.showFailureText(r2, 2131887146);
        return;
    L8:
        Toast.showFailureText(r2, 2131887830);
    }

    public static String e(Context r5, int r6, boolean r7, boolean r8, Integer r9, String r10) {
        boolean r0 = AppInfoUtils.f().booleanValue();
        boolean r3 = false;
        boolean r1 = com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.mobile.link_share_disable_privacy_protocol", false);
        if (r9 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        int r4 = 2131888054;
        if (r11 == false) goto L24;
        if (TextUtils.isEmpty(r10) == true) goto L24;
        if (r0 == true) goto L14;
        if (r1 == true) goto L14;
    L15:
        if (r8 == true) goto L54;
        if (r3 == true) goto L55;
        StringBuilder r12 = new StringBuilder();
        r12.append(r10);
        r12.append("\n");
        String r13 = r5.getString(2131888054);
        String[] r14 = r13.split("\\n");
        if (r14.length <= 0) goto L21;
        r13 = r14[r14.length - 1];
    L21:
        r12.append(r13);
        return r12.toString();
    L55:
        return r10;
    L54:
        return r10;
    L14:
        r3 = true;
    L24:
        if (r6 != sbb.e.f.b) goto L35;
        if (r8 == true) goto L27;
        if (r0 == true) goto L33;
        if (r1 == true) goto L33;
        return r5.getString(2131888217);
    L33:
        return r5.getString(2131888218);
    L27:
        return r5.getString(2131888219);
    L35:
        if (r8 == false) goto L41;
        if (r7 == false) goto L38;
        int r15 = 2131888053;
    L39:
        u4.a.getClass();
        return xo5.a.c(r5, r15, "doc_type", u4.a(r5, r6));
    L38:
        r15 = 2131888050;
        goto L39
    L41:
        if (r0 == true) goto L49;
        if (r1 == true) goto L49;
        if (r7 == true) goto L48;
        r4 = 2131888051;
    L48:
        return r5.getString(r4);
    L49:
        if (r7 == false) goto L51;
        int r16 = 2131888055;
    L52:
        u4.a.getClass();
        return xo5.a.c(r5, r16, "doc_type", u4.a(r5, r6));
    L51:
        r16 = 2131888052;
        goto L52
    L5:
        if (r9.intValue() != a) goto L7;
        r11 = true;
        goto L8
    }

    public static UDDialog f(Context r10, String r11, final String r12, final int r13, final String r14, final boolean r15, final String r16, final DialogInterface.OnClickListener r17, final DialogInterface.OnClickListener r18) {
        Intrinsics.checkNotNullParameter(r10, "context");
        UDDialogBuilder r2 = new UDDialogBuilder(r10);
        r2.autoDismiss(true);
        r2.title(2131888206);
        Intrinsics.checkNotNullParameter(r11, "value");
        r2.message(r11);
        r2.messageGravity(8388611);
        DialogInterface.OnClickListener r0 = new m(r17, r12, r13, r14, r15, r16);
        r2.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(2131887719).textColorRes(2131101119).onClickListener(r0));
        r2.addActionButton(2131391778, 2131887716, new n(r18, r12, r13, r14, r15, r16));
        return r2.build();
    }

    public static void i(Context r16, int r17, String r18, String r19, boolean r20, String r21, boolean r22, DialogInterface.OnClickListener r23, DialogInterface.OnClickListener r24, Integer r25, String r26) {
        boolean r0 = !((b0) org.koin.java.a.a(b0.class)).isChinaMainlandGeo();
        boolean r1 = ((b0) org.koin.java.a.a(b0.class)).f();
        StringBuilder r2 = new StringBuilder("isOverSea:");
        r2.append(r0);
        r2.append(", isKA");
        r2.append(r1);
        r2.append(", scene:");
        r2.append(r25);
        r2.append(", customBodyTextLength:");
        if (r26 != null) goto L5;
        int r3 = 0;
    L6:
        r2.append(r3);
        tt5.a.h("LinkShareUtils", r2.toString());
        if (r0 == true) goto L15;
        if (r1 == true) goto L15;
        String r8 = e(r16, r17, r22, false, r25, r26);
        Dialog r4 = f(r16, r8, r18, r17, r19, r20, r21, r23, r24);
        a(r4);
        c(r4);
        TextView r5 = (TextView) r4.findViewById(2131391794);
        com.bytedance.ee.bear.appsetting.c r6 = com.bytedance.ee.bear.appsetting.c.a.a;
        if (r6.h("ccm.mobile.privacy_and_userterm_use_passport") == false) goto L13;
        tt5.a.h("LinkShareUtils", "showSafeTipsDialogInternal: use passport enable");
        c.a(r5, r16, r17, r8, new u(c.b(PolicyAgreement.SERVICE_TERM), c.b(PolicyAgreement.PRIVACY)));
    L14:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).j(r18, r17, r4);
        com.bytedance.ee.bear.middleground.permission.c.y(r18, r17, r19, r20, r21);
        return;
    L13:
        c.a(r5, r16, r17, r8, new v((PolicyConfig) r6.c("policy_config", PolicyConfig.class, new PolicyConfig())));
    L15:
        Dialog r7 = f(r16, e(r16, r17, r22, true, r25, r26), r18, r17, r19, r20, r21, r23, r24);
        a(r7);
        c(r7);
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).j(r18, r17, r7);
        com.bytedance.ee.bear.middleground.permission.c.y(r18, r17, r19, r20, r21);
        return;
    L5:
        r3 = r26.length();
        goto L6
    }
}
