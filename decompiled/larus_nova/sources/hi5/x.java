package hi5;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.u4;
import com.bytedance.ee.bear.middleground.permission.external.SceneType;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.PolicyConfig;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.passport.signinsdk_api.base.policy.PolicyAgreement;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f485340a = 0;

    public interface a {
    }

    static {
        f485340a = SceneType.PASSWORD_SHARE.getValue();
    }

    public static void a(UDDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static void c(UDDialog r100) {
        if (com.bytedance.ee.bear.middleground.permission.b.m() == true) goto L6;
        tt5.a.h("LinkShareUtils", "[mask issue fix] fixSafeTipsDialogFrame skip, fg disabled.");
        return;
    L6:
        View r101 = null;
        if (r100 != null) goto L9;
        Window r102 = null;
    L10:
        if (r102 == null) goto L17;
        r101 = r102.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L17;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L17;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L17:
        View r104 = b(r101, "ud_dialog_frame");
        View r105 = b(r101, "ud_dialog_root");
        if (r104 == null) goto L23;
        if (r105 == null) goto L23;
        tt5.a.h("LinkShareUtils", "[mask issue fix] fixSafeTipsDialogFrame register, framePadding=" + d(r104) + ", rootSize=" + r105.getWidth() + "x" + r105.getHeight());
        r105.getViewTreeObserver().addOnPreDrawListener(new w(r105, r104));
        return;
    L23:
        StringBuilder r106 = new StringBuilder("[mask issue fix] fixSafeTipsDialogFrame skip, frameNull=");
        boolean r107 = false;
        if (r104 != null) goto L26;
        boolean r108 = true;
    L27:
        r106.append(r108);
        r106.append(", rootNull=");
        if (r105 != null) goto L30;
        r107 = true;
    L30:
        r106.append(r107);
        tt5.a.h("LinkShareUtils", r106.toString());
        return;
    L26:
        r108 = false;
        goto L27
    L9:
        r102 = r100.getWindow();
        goto L10
    }

    public static String d(View r100) {
        if (r100 != null) goto L6;
        return "null";
    L6:
        return "[" + r100.getPaddingLeft() + "," + r100.getPaddingTop() + "," + r100.getPaddingRight() + "," + r100.getPaddingBottom() + "]";
    }

    public static View b(View r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r102 = r100.getResources().getIdentifier(r101, "id", r100.getContext().getPackageName());
        if (r102 != 0) goto L9;
        return null;
    L9:
        return r100.findViewById(r102);
    }

    public static void g(HashMap<String, String> r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L5;
        String r102 = av5.c.b(r101, r100, false);
        ((com.bytedance.ee.bear.route.h) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).u5(r102);
        return;
    L5:
        tt5.a.d("LinkShareUtils", "empty navigateRealNameDialog");
    }

    public static void h(Context r100, Throwable r101) {
        tt5.a.f("LinkShareUtils", r101, false);
        if (ax4.d.b(r101, 10029) == false) goto L6;
        Toast.showFailureText(r100, R.string.CreationMobile_ECM_ExternalShare_Enable_toast0);
        return;
    L6:
        if (ax4.d.b(r101, 10040) == false) goto L8;
        Toast.showFailureText(r100, R.string.CreationMobile_DataUpgrade_Locked_toast);
        return;
    L8:
        Toast.showFailureText(r100, R.string.Doc_Facade_SetFailed);
    }

    public static String e(Context r100, int r101, boolean r102, boolean r103, Integer r104, String r110) {
        boolean r105 = AppInfoUtils.f().booleanValue();
        boolean r106 = false;
        boolean r107 = com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm.mobile.link_share_disable_privacy_protocol", false);
        if (r104 != null) goto L5;
    L7:
        boolean r108 = false;
    L8:
        int r109 = R.string.Doc_Permission_AnonymousVisitWithPrivacyTips_AddVariable;
        if (r108 == false) goto L24;
        if (TextUtils.isEmpty(r110) == true) goto L24;
        if (r105 == true) goto L14;
        if (r107 == true) goto L14;
    L15:
        if (r103 == true) goto L54;
        if (r106 == true) goto L55;
        StringBuilder r111 = new StringBuilder();
        r111.append(r110);
        r111.append("\n");
        String r112 = r100.getString(R.string.Doc_Permission_AnonymousVisitWithPrivacyTips_AddVariable);
        String[] r113 = r112.split("\\n");
        if (r113.length <= 0) goto L21;
        r112 = r113[r113.length - 1];
    L21:
        r111.append(r112);
        return r111.toString();
    L55:
        return r110;
    L54:
        return r110;
    L14:
        r106 = true;
    L24:
        if (r101 != sbb.e.f541295f.f541317b) goto L35;
        if (r103 == true) goto L27;
        if (r105 == true) goto L33;
        if (r107 == true) goto L33;
        return r100.getString(R.string.Doc_Share_FolderBNoExternalAnonymousVisit);
    L33:
        return r100.getString(R.string.Doc_Share_FolderBNoExternalAnonymousVisit_New);
    L27:
        return r100.getString(R.string.Doc_Share_FolderBOverseaAnonymousVisit);
    L35:
        if (r103 == false) goto L41;
        if (r102 == false) goto L38;
        int r114 = R.string.Doc_Permission_AnonymousVisitTips_AddVariable;
    L39:
        u4.f229807a.getClass();
        return xo5.a.c(r100, r114, "doc_type", u4.a(r100, r101));
    L38:
        r114 = R.string.Doc_Permission_AnonymousEditTips_AddVariable;
        goto L39
    L41:
        if (r105 == true) goto L49;
        if (r107 == true) goto L49;
        if (r102 == true) goto L48;
        r109 = R.string.Doc_Permission_AnonymousEditWithPrivacyTips_AddVariable;
    L48:
        return r100.getString(r109);
    L49:
        if (r102 == false) goto L51;
        int r115 = R.string.Doc_Permission_AnonymousVisitWithPrivacyTips_New;
    L52:
        u4.f229807a.getClass();
        return xo5.a.c(r100, r115, "doc_type", u4.a(r100, r101));
    L51:
        r115 = R.string.Doc_Permission_AnonymousEditWithPrivacyTips_New;
        goto L52
    L5:
        if (r104.intValue() != f485340a) goto L7;
        r108 = true;
        goto L8
    }

    public static UDDialog f(Context r110, String r111, final String r112, final int r113, final String r114, final boolean r115, final String r116, final DialogInterface.OnClickListener r117, final DialogInterface.OnClickListener r118) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDDialogBuilder r100 = new UDDialogBuilder(r110);
        r100.autoDismiss(true);
        r100.title(R.string.Doc_Share_Confirm);
        Intrinsics.checkNotNullParameter(r111, "value");
        r100.message(r111);
        r100.messageGravity(GravityCompat.START);
        DialogInterface.OnClickListener r101 = new m(r117, r112, r113, r114, r115, r116);
        r100.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).text(R.string.Doc_Facade_Confirm).textColorRes(R.color.colorful_red).onClickListener(r101));
        r100.addActionButton(R.id.ud_dialog_btn_secondary, R.string.Doc_Facade_Cancel, new n(r118, r112, r113, r114, r115, r116));
        return r100.build();
    }

    public static void i(Context r110, int r111, String r112, String r113, boolean r210, String r211, boolean r212, DialogInterface.OnClickListener r213, DialogInterface.OnClickListener r214, Integer r215, String r216) {
        boolean r100 = !((b0) org.koin.java.a.a(b0.class)).isChinaMainlandGeo();
        boolean r101 = ((b0) org.koin.java.a.a(b0.class)).f();
        StringBuilder r102 = new StringBuilder("isOverSea:");
        r102.append(r100);
        r102.append(", isKA");
        r102.append(r101);
        r102.append(", scene:");
        r102.append(r215);
        r102.append(", customBodyTextLength:");
        if (r216 != null) goto L5;
        int r103 = 0;
    L6:
        r102.append(r103);
        tt5.a.h("LinkShareUtils", r102.toString());
        if (r100 == true) goto L15;
        if (r101 == true) goto L15;
        String r104 = e(r110, r111, r212, false, r215, r216);
        UDDialog r105 = f(r110, r104, r112, r111, r113, r210, r211, r213, r214);
        a(r105);
        c(r105);
        TextView r106 = (TextView) r105.findViewById(R.id.ud_dialog_content_message_tv);
        com.bytedance.ee.bear.appsetting.c r107 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        if (r107.h("ccm.mobile.privacy_and_userterm_use_passport") == false) goto L13;
        tt5.a.h("LinkShareUtils", "showSafeTipsDialogInternal: use passport enable");
        c.a(r106, r110, r111, r104, new u(c.b(PolicyAgreement.SERVICE_TERM), c.b(PolicyAgreement.PRIVACY)));
    L14:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).j(r112, r111, r105);
        com.bytedance.ee.bear.middleground.permission.c.y(r112, r111, r113, r210, r211);
        return;
    L13:
        c.a(r106, r110, r111, r104, new v((PolicyConfig) r107.c("policy_config", PolicyConfig.class, new PolicyConfig())));
    L15:
        UDDialog r108 = f(r110, e(r110, r111, r212, true, r215, r216), r112, r111, r113, r210, r211, r213, r214);
        a(r108);
        c(r108);
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).j(r112, r111, r108);
        com.bytedance.ee.bear.middleground.permission.c.y(r112, r111, r113, r210, r211);
        return;
    L5:
        r103 = r216.length();
        goto L6
    }
}
