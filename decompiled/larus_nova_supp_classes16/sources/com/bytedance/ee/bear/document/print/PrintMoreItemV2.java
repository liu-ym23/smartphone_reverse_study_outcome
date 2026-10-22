package com.bytedance.ee.bear.document.print;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenyType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UiStyle;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.more.protocol3.panel.y;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.lark.android.encryption.CipherManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class PrintMoreItemV2 extends BaseMoreItem implements ITextMoreItem {
    private static final String TAG = "PrintMoreItemV2";
    private final FragmentActivity activity;
    private final Observer<Boolean> flowStateObserver;
    private final DocumentPluginHost pluginHost;
    private final PrintActionAvailability printActionAvailability;
    private final PrintExportCoordinator printExportCoordinator;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PrintActionAvailability.DeniedReason.values().length];
            a = r0;
            r0[PrintActionAvailability.DeniedReason.NO_NETWORK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[PrintActionAvailability.DeniedReason.DELETED_SHORTCUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[PrintActionAvailability.DeniedReason.SHORTCUT_PERMISSION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[PrintActionAvailability.DeniedReason.SECURITY_POLICY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[PrintActionAvailability.DeniedReason.USER_PERMISSION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[PrintActionAvailability.DeniedReason.FRONTEND_DISABLED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static /* synthetic */ void a(PrintMoreItemV2 r0, Boolean r1) {
        r0.lambda$new$0(r1);
    }

    public int getIcon() {
        return 2131255450;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return "more.print";
    }

    public String getStateTips() {
        return "";
    }

    public boolean needShowBadge() {
        return false;
    }

    public static boolean isPrintEnabled() {
        return com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.doc.mobile_print");
    }

    private void showOrganizationPolicyDialog() {
        if (this.activity.isFinishing() == false) goto L5;
        return;
    L5:
        if (this.activity.isDestroyed() == true) goto L15;
        UDDialog r0 = new UDDialogBuilder(this.activity).title(2131889214).message(2131889213).addActionButton(2131391777, 2131887759, null).build();     // Catch: RuntimeException -> L9
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_print_PrintMoreItemV2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r0);     // Catch: RuntimeException -> L9
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).d(r0);     // Catch: RuntimeException -> L9
        return;
    L9:
        e = move-exception;
        tt5.a.l(TAG, "show organization policy dialog failed", e);
        return;
    }

    public String getItemDisableReasonByJSMsg() {
        if (this.printExportCoordinator.i() == false) goto L6;
        return "";
    L6:
        PrintActionAvailability.a r0 = getAvailabilityResult();
        if (r0.b != PrintActionAvailability.DeniedReason.FRONTEND_DISABLED) goto L11;
        return r0.c;
    L11:
        return super.getItemDisableReasonByJSMsg();
    }

    public MoreUiAction getMoreAction() {
        if (this.printExportCoordinator.i() == true) goto L5;
        PrintActionAvailability.a r0 = getAvailabilityResult();
        if (r0.f == true) goto L9;
        String r1 = getDisabledMessage(r0);
        if (r0.a != PrintActionAvailability.State.ENABLED) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L21;
        if (isItemDisabledByJSMsg() == false) goto L21;
        String r3 = super.getItemDisableReasonByJSMsg();
        if (TextUtils.isEmpty(r3) == true) goto L21;
        r1 = r3;
    L21:
        return new MoreUiAction(MoreUiAction.MoreAction.UNEAABLE_TIPS, r1);
    L13:
        r2 = false;
        goto L14
    L9:
        return new MoreUiAction(MoreUiAction.MoreAction.PERM_PLATFORM_ACTION, "");
    L5:
        return new MoreUiAction(MoreUiAction.MoreAction.UNEAABLE_TIPS, "");
    }

    public String getUnableTips() {
        if (this.printExportCoordinator.i() == false) goto L7;
        return "";
    L7:
        return getDisabledMessage(getAvailabilityResult());
    }

    public boolean isEnable() {
        if (this.printExportCoordinator.i() == false) goto L5;
        return false;
    L5:
        if (getAvailabilityResult().a != PrintActionAvailability.State.ENABLED) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r0 = false;
        goto L8
    }

    public void onClick() {
        if (this.printExportCoordinator.i() == false) goto L5;
        return;
    L5:
        oj5.c r2 = getMoreInfo();
        if (r2 != null) goto L9;
        tt5.a.k(TAG, "onClick ignored: moreInfo is null");
        return;
    L9:
        String r16 = getRealToken(r2);
        if (TextUtils.isEmpty(r16) == false) goto L13;
        tt5.a.k(TAG, "onClick ignored: export token is empty");
        Toast.showFailureText(this.activity, 2131889210);
        return;
    L13:
        PrintActionAvailability.a r0 = evaluateAvailability(r2, r16, isPrintEnabled());
        if (r0.f == false) goto L18;
        handlePermissionPlatformAction(r0);
        return;
    L18:
        if (r0.a != PrintActionAvailability.State.ENABLED) goto L20;
        boolean r1 = true;
    L21:
        if (r1 == true) goto L24;
        onDisableClick();
        return;
    L24:
        Bundle r4 = getHost().getHostFragment().getArguments();
        int r3 = b.a;
        Intrinsics.checkNotNullParameter(r2, "moreInfo");
        Intrinsics.checkNotNullParameter(r16, "exportToken");
        com.bytedance.ee.bear.more.b r5 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);     // Catch: Throwable -> L31
        oj5.c r23 = r2;
        String r24 = "exportToken";
        String r26 = "moreInfo";
        String r27 = r16;
        r5.c(new com.bytedance.ee.bear.more.i(r4, r16, r2.getType(), r2.isShareFolder(), r2.b(), "print", "ccm_space_print_view", "", "", r2 instanceof oj5.f, r2.m(), r2.H(), r2.isOwner(), r2.L()));     // Catch: Throwable -> L29
    L34:
        getHost().a();
        PrintExportCoordinator r6 = this.printExportCoordinator;
        r6.getClass();
        oj5.c r7 = r23;
        Intrinsics.checkNotNullParameter(r7, r26);
        String r8 = r27;
        Intrinsics.checkNotNullParameter(r8, r24);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L38;
        tt5.a.k("PrintExportCoordinator", "start ignored: not on main thread");
        return;
    L38:
        if (r6.i == null) goto L40;
        return;
    L40:
        if (r6.j.isActive() == false) goto L42;
        return;
    L42:
        if (StringsKt.isBlank(r8) == false) goto L44;
        return;
    L44:
        if (r6.j() == true) goto L47;
        return;
    L47:
        if (r7.getType() == 22) goto L52;
        if (r7.i() == 22) goto L52;
        tt5.a.k("PrintExportCoordinator", "start ignored: print only supports Docx server export");
        return;
    L52:
        if (CipherManager.d() != 1) goto L55;
        FragmentActivity r9 = r6.a;
        Toast.showText(r9, r9.getString(2131889217), 1, true);
        CipherManager.h();
        return;
    L55:
        if (r6.j.tryStart() == false) goto L81;
        long r10 = r6.h + 1;
        r6.h = r10;
        r6.i = Long.valueOf(r10);
        r6.a.getLifecycle().addObserver(r6);     // Catch: Throwable -> L63
        if (PrintExportCoordinator.l(r7) == false) goto L61;
        r6.m(r10, r7, r8);     // Catch: Throwable -> L63
    L66:
        return;
    L61:
        r6.e(r10, r7, r8);     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        tt5.a.d("PrintExportCoordinator", "start print flow failed: ".concat(th.getClass().getSimpleName()));
        r6.f(r10, true);
        PrintExportCoordinator.n(r6);
        return;
    L81:
        return;
    L29:
        th = th;
    L33:
        tt5.a.k("PrintAnalytic", "report more entry click failed: ".concat(th.getClass().getSimpleName()));
    L31:
        th = th;
        r23 = r2;
        r24 = "exportToken";
        r26 = "moreInfo";
        r27 = r16;
        goto L33
    L20:
        r1 = false;
        goto L21
    }

    public void onDisableClick() {
        if (this.printExportCoordinator.i() == false) goto L5;
        return;
    L5:
        PrintActionAvailability.a r0 = getAvailabilityResult();
        if (r0.f == false) goto L10;
        handlePermissionPlatformAction(r0);
        return;
    L10:
        if (r0.b == PrintActionAvailability.DeniedReason.SECURITY_POLICY) goto L12;
        return;
    L12:
        if (FileAuthResultFrom.COME_FROM_FILE_POLICY.equals(r0.e) == false) goto L16;
        showOrganizationPolicyDialog();
        return;
    }

    public void onRelease() {
        PrintExportCoordinator r0 = this.printExportCoordinator;
        Observer<Boolean> r1 = this.flowStateObserver;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.j.getActive().removeObserver(r1);
        super.onRelease();
    }

    private PrintActionAvailability.a getAvailabilityResult() {
        oj5.c r0 = getMoreInfo();
        boolean r1 = isPrintEnabled();
        if (r0 != null) goto L5;
        String r2 = "";
    L7:
        return evaluateAvailability(r0, r2, r1);
    L5:
        r2 = getRealToken(r0);
        goto L7
    }

    public void create() {
        super.create();
        PrintExportCoordinator r0 = this.printExportCoordinator;
        Observer<Boolean> r1 = this.flowStateObserver;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.j.getActive().observe(r0.a, r1);
    }

    public String getTitle() {
        return getString(2131889209);
    }

    public boolean isVisible() {
        if (getAvailabilityResult().a == PrintActionAvailability.State.HIDDEN) goto L5;
        return true;
    L5:
        return false;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_print_PrintMoreItemV2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(UDDialog r1) {
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

    private void applyPrintDlpMessageIfNeeded(PermissionResponse r4) {
        if (r4.getDenySource() != null) goto L5;
        return;
    L5:
        if (r4.getDenySource().getDenyType() != DenyType.DLP_SENSATIVE) goto L10;
        r4.setUiStyle(new UiStyle(this.activity.getString(2131889218)));
        return;
    }

    private String getDisabledMessage(PrintActionAvailability.a r4) {
        switch(a.a[r4.b.ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        return "";
    L6:
        if (TextUtils.isEmpty(r4.c) == true) goto L10;
        return r4.c;
    L10:
        return getString(2131887710);
    L12:
        return getString(2131889212);
    L14:
        if (FileAuthResultFrom.COME_FROM_FILE_POLICY.equals(r4.e) == false) goto L17;
        return "";
    L17:
        return getString(2131889218);
    L19:
        return getString(2131889212);
    L21:
        return getString(2131889206);
    L23:
        return getString(2131887951);
    }

    private String getRealToken(oj5.c r3) {
        String r4 = r3.getToken();
        if (this.pluginHost.a().isEditionDoc() == true) goto L7;
        if (r4 == null) goto L6;
        return r4;
    L6:
        return "";
    L7:
        String r5 = this.pluginHost.a().getEditionToken();
        if (r5 != null) goto L11;
        return "";
    L11:
        return r5;
    }

    private void handlePermissionPlatformAction(PrintActionAvailability.a r3) {
        PermissionResponse r4 = r3.d;
        if (r4 != null) goto L5;
    L9:
        tt5.a.k(TAG, "permission platform action ignored: response or callback is null");
        return;
    L5:
        if (r4.getCallback() == null) goto L9;
        applyPrintDlpMessageIfNeeded(r4);
        r4.getCallback().a(this.activity, r4);
    }

    private /* synthetic */ void lambda$new$0(Boolean r1) {
        notifyItemChanged();
    }

    public PrintMoreItemV2(FragmentActivity r2, DocumentPluginHost r3) {
        this.printActionAvailability = new PrintActionAvailability();
        this.flowStateObserver = new q(this);
        this.activity = r2;
        this.pluginHost = r3;
        this.printExportCoordinator = new PrintExportCoordinator(r2, r3);
    }

    private PrintActionAvailability.a evaluateAvailability(oj5.c r18, String r19, boolean r20) {
        if (r20 == false) goto L5;
        this.printActionAvailability.getClass();
        if (r18 == null) goto L82;
        boolean r8 = false;
        if (r18.getType() != 22) goto L12;
    L15:
        boolean r0 = true;
    L16:
        if (r0 == false) goto L83;
        PermissionResponse r14 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).t(r18.getToken(), r18, BizDomain.FileBizDomainCCM, "EXPORT", r18.c().a);
        boolean r1 = y.a();
        if (r1 == true) goto L24;
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.e(r14) == true) goto L24;
        return PrintActionAvailability.a.b(PrintActionAvailability.DeniedReason.PERMISSION_PLATFORM_HIDDEN);
    L24:
        if (TextUtils.isEmpty(r19) == true) goto L85;
        String r2 = null;
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L30;
        return PrintActionAvailability.a.a(PrintActionAvailability.DeniedReason.NO_NETWORK, null, r14);
    L30:
        if ((r18 instanceof oj5.a) == false) goto L87;
        oj5.a r3 = (oj5.a) r18;
        if (r3.p == true) goto L35;
    L37:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == true) goto L49;
        gj5.c r4 = ((gj5.b) org.koin.java.a.a(gj5.b.class)).g("CCM_EXPORT", FileBizDomain.FileBizDomainCCM, r18.getType(), r19);
        if (r4.a == true) goto L43;
        FileAuthResultFrom r16 = r4.b;
        return new PrintActionAvailability.a(PrintActionAvailability.State.DISABLED, PrintActionAvailability.DeniedReason.SECURITY_POLICY, null, r14, r16, false);
    L43:
        if (r3.p() == false) goto L45;
    L62:
        if (r1 == false) goto L79;
        String[] r5 = r18.B();
        if (r5 == null) goto L72;
        int r6 = r5.length;
        int r7 = 0;
    L67:
        if (r7 >= r6) goto L72;
        if ("export".equals(r5[r7]) == true) goto L70;
        r7 = r7 + 1;
        goto L67
    L70:
        r8 = true;
    L72:
        if (r8 == false) goto L79;
        PrintActionAvailability.DeniedReason r9 = PrintActionAvailability.DeniedReason.FRONTEND_DISABLED;
        Map r10 = r18.M();
        if (r10 == null) goto L93;
        r2 = (String) r10.get("export");
    L93:
        return PrintActionAvailability.a.a(r9, r2, r14);
    L79:
        return new PrintActionAvailability.a(PrintActionAvailability.State.ENABLED, PrintActionAvailability.DeniedReason.NONE, null, r14, null, false);
    L45:
        if (r3.p == false) goto L47;
        PrintActionAvailability.DeniedReason r11 = PrintActionAvailability.DeniedReason.SHORTCUT_PERMISSION;
    L90:
        return PrintActionAvailability.a.a(r11, null, r14);
    L47:
        r11 = PrintActionAvailability.DeniedReason.USER_PERMISSION;
        goto L90
    L49:
        ph5.c r12 = (ph5.c) org.koin.java.a.a(ph5.c.class);
        boolean r13 = r12.e(r14);
        if (r12.d(r14) == true) goto L52;
        if (r13 == true) goto L62;
        if (r3.p == false) goto L60;
        PrintActionAvailability.DeniedReason r17 = PrintActionAvailability.DeniedReason.SHORTCUT_PERMISSION;
    L92:
        return PrintActionAvailability.a.a(r17, null, r14);
    L60:
        r17 = PrintActionAvailability.DeniedReason.USER_PERMISSION;
        goto L92
    L52:
        if (r13 == false) goto L54;
        PrintActionAvailability.State r21 = PrintActionAvailability.State.ENABLED;
    L91:
        return new PrintActionAvailability.a(r21, PrintActionAvailability.DeniedReason.PERMISSION_PLATFORM, null, r14, null, true);
    L54:
        r21 = PrintActionAvailability.State.DISABLED;
        goto L91
    L35:
        if (r3.q == false) goto L37;
        return PrintActionAvailability.a.a(PrintActionAvailability.DeniedReason.DELETED_SHORTCUT, null, r14);
    L87:
        return PrintActionAvailability.a.a(PrintActionAvailability.DeniedReason.UNKNOWN, null, r14);
    L85:
        return PrintActionAvailability.a.b(PrintActionAvailability.DeniedReason.MISSING_EXPORT_TOKEN);
    L83:
        return PrintActionAvailability.a.b(PrintActionAvailability.DeniedReason.UNSUPPORTED_TYPE);
    L12:
        if (r18.i() == 22) goto L15;
        r0 = false;
        goto L16
    L82:
        return PrintActionAvailability.a.b(PrintActionAvailability.DeniedReason.MISSING_DOCUMENT);
    L5:
        return PrintActionAvailability.a.b(PrintActionAvailability.DeniedReason.UNKNOWN);
    }
}
