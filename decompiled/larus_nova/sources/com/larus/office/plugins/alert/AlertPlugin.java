package com.larus.office.plugins.alert;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.document.y5;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.CommonDialogWithVerticalButton;
import com.larus.common_ui.dialog.f0;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bH\u0016J\u0017\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u0010R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/office/plugins/alert/AlertPlugin;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "dialog", "Landroidx/fragment/app/DialogFragment;", "getPluginId", "", "getBridgeHandlers", "", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "getButtonColor", "", "type", "(Ljava/lang/Integer;)I", "Companion", "ShowAlertHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlertPlugin extends OfficeDocumentPlugin {
    private static final String BIZ_SHOW_ALERT = "biz.util.showAlert";
    public static final a Companion = null;
    private static final String DIRECTION_VERTICAL = "vertical";
    private static final String TAG = "AlertPlugin";
    private DialogFragment dialog;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<AlertModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlertPlugin f362327a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f362328a = null;

            static {
                int[] r100 = new int[AlertActionType.values().length];
                r100[AlertActionType.UPDATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[AlertActionType.DISMISS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[AlertActionType.SHOW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f362328a = r100;
            }
        }

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(AlertPlugin r100) {
            this.f362327a = r100;
        }

        public static void a(DialogFragment r100, FragmentManager r101) {
            LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, null, r102);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r100.show(r101, null);
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r110, m r111) {
            AlertModel r100 = (AlertModel) r110;
            if (r100 != null) goto L5;
            FLogger.f375446a.e(AlertPlugin.TAG, "ShowAlertHandler return for data is null.");
            return;
        L5:
            int r101 = a.f362328a[r100.getAlertActionType().ordinal()];
            boolean r102 = true;
            if (r101 != 2) goto L8;
            DialogFragment r103 = AlertPlugin.access$getDialog$p(this.f362327a);     // Catch: Exception -> L152
            if (r103 != null) goto L138;
        L140:
            r102 = false;
        L141:
            if (r102 == false) goto L173;
            DialogFragment r104 = AlertPlugin.access$getDialog$p(this.f362327a);     // Catch: Exception -> L152
            if (r104 == null) goto L174;
            r104.dismiss();     // Catch: Exception -> L146
        L178:
            return;
        L146:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Exception -> L152
            Throwable r105 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L152
            if (r105 == null) goto L175;
            com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L152
            return;
        L175:
            return;
        L174:
            return;
        L173:
            return;
        L138:
            if (r103.isAdded() != true) goto L140;
        L152:
            e = move-exception;
            FLogger.f375446a.e(AlertPlugin.TAG, e.getMessage(), e);
            return;
        L8:
            if (r101 != 3) goto L176;
        L133:
            e = move-exception;
            FLogger.f375446a.e(AlertPlugin.TAG, "Show alert error: " + e);
            Unit r106 = Unit.INSTANCE;
            return;
        L11:
            if (AlertPlugin.access$getContext(this.f362327a) != null) goto L13;
            FLogger.f375446a.e(AlertPlugin.TAG, "The context is null");     // Catch: Exception -> L133
            return;
        L13:
            List<AlertModel.ButtonsBean> r107 = r100.getButtons();     // Catch: Exception -> L133
            if (r107 == null) goto L161;
            AlertPlugin r108 = this.f362327a;     // Catch: Exception -> L133
            if (r107.size() != 2) goto L52;
            if (Intrinsics.areEqual(r100.getButtonsDirection(), "vertical") == true) goto L52;
            CommonDialog.a r109 = new CommonDialog.a();     // Catch: Exception -> L133
            r109.f327197z = false;     // Catch: Exception -> L133
            String r112 = r100.getTitle();     // Catch: Exception -> L133
            if (r112 != null) goto L23;
            r112 = "";
        L23:
            Intrinsics.checkNotNullParameter(r112, "title");     // Catch: Exception -> L133
            r109.f327172a = r112;     // Catch: Exception -> L133
            String r113 = r100.getMessage();     // Catch: Exception -> L133
            if (r113 != null) goto L26;
            r113 = "";
        L26:
            Intrinsics.checkNotNullParameter(r113, "message");     // Catch: Exception -> L133
            r109.f327180i = r113;     // Catch: Exception -> L133
            com.larus.office.plugins.alert.a r114 = new com.larus.office.plugins.alert.a(r108, r111, r107);     // Catch: Exception -> L133
            AlertModel.ButtonsBean r115 = (AlertModel.ButtonsBean) ListProtector.get(r107, 0);     // Catch: Exception -> L133
            if (r115 == null) goto L29;
            String r116 = r115.getText();     // Catch: Exception -> L133
        L30:
            CommonDialog.a.e(r109, r114, r116, 4);     // Catch: Exception -> L133
            AlertModel.ButtonsBean r117 = (AlertModel.ButtonsBean) ListProtector.get(r107, 0);     // Catch: Exception -> L133
            if (r117 == null) goto L33;
            Integer r118 = Integer.valueOf(r117.getColor());     // Catch: Exception -> L133
        L34:
            f0 r119 = new f0(null, Integer.valueOf(AlertPlugin.access$getButtonColor(r108, r118)), null, 5);     // Catch: Exception -> L133
            Intrinsics.checkNotNullParameter(r119, "commonDialogTextStyleConfig");     // Catch: Exception -> L133
            r109.E = r119;     // Catch: Exception -> L133
            com.larus.office.plugins.alert.b r120 = new com.larus.office.plugins.alert.b(r108, r111, r107);     // Catch: Exception -> L133
            AlertModel.ButtonsBean r121 = (AlertModel.ButtonsBean) ListProtector.get(r107, 1);     // Catch: Exception -> L133
            if (r121 == null) goto L37;
            String r122 = r121.getText();     // Catch: Exception -> L133
        L38:
            CommonDialog.a.f(r109, r120, r122, false, 12);     // Catch: Exception -> L133
            AlertModel.ButtonsBean r123 = (AlertModel.ButtonsBean) ListProtector.get(r107, 1);     // Catch: Exception -> L133
            if (r123 == null) goto L41;
            Integer r124 = Integer.valueOf(r123.getColor());     // Catch: Exception -> L133
        L42:
            f0 r125 = new f0(null, Integer.valueOf(AlertPlugin.access$getButtonColor(r108, r124)), null, 5);     // Catch: Exception -> L133
            Intrinsics.checkNotNullParameter(r125, "commonDialogTextStyleConfig");     // Catch: Exception -> L133
            r109.D = r125;     // Catch: Exception -> L133
            AlertPlugin.access$setDialog$p(r108, r109.a());     // Catch: Exception -> L133
            ChameleonPluginHost r126 = r108.getHost();     // Catch: Exception -> L133
            if (r126 == null) goto L162;
            Fragment r127 = r126.getFragment();     // Catch: Exception -> L133
            if (r127 == null) goto L163;
            FragmentManager r128 = r127.getParentFragmentManager();     // Catch: Exception -> L133
            if (r128 == null) goto L164;
            DialogFragment r129 = AlertPlugin.access$getDialog$p(r108);     // Catch: Exception -> L133
            if (r129 == null) goto L165;
            a(r129, r128);     // Catch: Exception -> L133
            Unit r130 = Unit.INSTANCE;     // Catch: Exception -> L133
            return;
        L165:
            return;
        L164:
            return;
        L163:
            return;
        L162:
            return;
        L41:
            r124 = null;
            goto L42
        L37:
            r122 = null;
            goto L38
        L33:
            r118 = null;
            goto L34
        L29:
            r116 = null;
        L52:
            if (r107.size() != 2) goto L56;
            if (Intrinsics.areEqual(r100.getButtonsDirection(), "vertical") == false) goto L56;
        L61:
            CommonDialogWithVerticalButton.a r131 = new CommonDialogWithVerticalButton.a();     // Catch: Exception -> L133
            r131.f327233m = false;     // Catch: Exception -> L133
            String r132 = r100.getTitle();     // Catch: Exception -> L133
            if (r132 != null) goto L64;
            r132 = "";
        L64:
            Intrinsics.checkNotNullParameter(r132, "title");     // Catch: Exception -> L133
            r131.f327221a = r132;     // Catch: Exception -> L133
            String r133 = r100.getMessage();     // Catch: Exception -> L133
            if (r133 != null) goto L67;
            r133 = "";
        L67:
            Intrinsics.checkNotNullParameter(r133, "message");     // Catch: Exception -> L133
            r131.f327223c = r133;     // Catch: Exception -> L133
            if (r107.size() != 3) goto L96;
            c r134 = new c(r108, r111, r107);     // Catch: Exception -> L133
            AlertModel.ButtonsBean r135 = (AlertModel.ButtonsBean) ListProtector.get(r107, 0);     // Catch: Exception -> L133
            if (r135 == null) goto L73;
            String r136 = r135.getText();     // Catch: Exception -> L133
        L74:
            Intrinsics.checkNotNullParameter(r134, "listener");     // Catch: Exception -> L133
            r131.f327224d = r136;     // Catch: Exception -> L133
            r131.f327226f = r134;     // Catch: Exception -> L133
            AlertModel.ButtonsBean r137 = (AlertModel.ButtonsBean) ListProtector.get(r107, 0);     // Catch: Exception -> L133
            if (r137 == null) goto L77;
            Integer r138 = Integer.valueOf(r137.getColor());     // Catch: Exception -> L133
        L78:
            f0 r139 = new f0(null, Integer.valueOf(AlertPlugin.access$getButtonColor(r108, r138)), null, 5);     // Catch: Exception -> L133
            Intrinsics.checkNotNullParameter(r139, "commonDialogTextStyleConfig");     // Catch: Exception -> L133
            r131.f327225e = r139;     // Catch: Exception -> L133
            d r140 = new d(r108, r111, r107);     // Catch: Exception -> L133
            AlertModel.ButtonsBean r141 = (AlertModel.ButtonsBean) ListProtector.get(r107, 1);     // Catch: Exception -> L133
            if (r141 == null) goto L81;
            String r142 = r141.getText();     // Catch: Exception -> L133
        L82:
            Intrinsics.checkNotNullParameter(r140, "listener");     // Catch: Exception -> L133
            r131.f327227g = r142;     // Catch: Exception -> L133
            r131.f327229i = r140;     // Catch: Exception -> L133
            AlertModel.ButtonsBean r143 = (AlertModel.ButtonsBean) ListProtector.get(r107, 1);     // Catch: Exception -> L133
            if (r143 == null) goto L85;
            Integer r144 = Integer.valueOf(r143.getColor());     // Catch: Exception -> L133
        L86:
            f0 r145 = new f0(null, Integer.valueOf(AlertPlugin.access$getButtonColor(r108, r144)), null, 5);     // Catch: Exception -> L133
            Intrinsics.checkNotNullParameter(r145, "commonDialogTextStyleConfig");     // Catch: Exception -> L133
            r131.f327228h = r145;     // Catch: Exception -> L133
            e r146 = new e(r108, r111, r107);     // Catch: Exception -> L133
            AlertModel.ButtonsBean r147 = (AlertModel.ButtonsBean) ListProtector.get(r107, 2);     // Catch: Exception -> L133
            if (r147 == null) goto L89;
            String r148 = r147.getText();     // Catch: Exception -> L133
        L90:
            Intrinsics.checkNotNullParameter(r146, "listener");     // Catch: Exception -> L133
            r131.f327230j = r148;     // Catch: Exception -> L133
            r131.f327232l = r146;     // Catch: Exception -> L133
            AlertModel.ButtonsBean r149 = (AlertModel.ButtonsBean) ListProtector.get(r107, 2);     // Catch: Exception -> L133
            if (r149 == null) goto L93;
            Integer r150 = Integer.valueOf(r149.getColor());     // Catch: Exception -> L133
        L94:
            f0 r151 = new f0(null, Integer.valueOf(AlertPlugin.access$getButtonColor(r108, r150)), null, 5);     // Catch: Exception -> L133
            Intrinsics.checkNotNullParameter(r151, "commonDialogTextStyleConfig");     // Catch: Exception -> L133
            r131.f327231k = r151;     // Catch: Exception -> L133
            r131.a();     // Catch: Exception -> L133
        L123:
            AlertPlugin.access$setDialog$p(r108, r131.a());     // Catch: Exception -> L133
            ChameleonPluginHost r152 = r108.getHost();     // Catch: Exception -> L133
            if (r152 == null) goto L168;
            Fragment r153 = r152.getFragment();     // Catch: Exception -> L133
            if (r153 == null) goto L169;
            FragmentManager r154 = r153.getParentFragmentManager();     // Catch: Exception -> L133
            if (r154 == null) goto L170;
            DialogFragment r155 = AlertPlugin.access$getDialog$p(r108);     // Catch: Exception -> L133
            if (r155 == null) goto L171;
            a(r155, r154);     // Catch: Exception -> L133
            Unit r156 = Unit.INSTANCE;     // Catch: Exception -> L133
            return;
        L171:
            return;
        L170:
            return;
        L169:
            return;
        L168:
            return;
        L93:
            r150 = null;
            goto L94
        L89:
            r148 = null;
            goto L90
        L85:
            r144 = null;
            goto L86
        L81:
            r142 = null;
            goto L82
        L77:
            r138 = null;
            goto L78
        L73:
            r136 = null;
            goto L74
        L96:
            if (r107.size() != 2) goto L114;
            f r157 = new f(r108, r111, r107);     // Catch: Exception -> L133
            AlertModel.ButtonsBean r158 = (AlertModel.ButtonsBean) ListProtector.get(r107, 0);     // Catch: Exception -> L133
            if (r158 == null) goto L100;
            String r159 = r158.getText();     // Catch: Exception -> L133
        L101:
            Intrinsics.checkNotNullParameter(r157, "listener");     // Catch: Exception -> L133
            r131.f327224d = r159;     // Catch: Exception -> L133
            r131.f327226f = r157;     // Catch: Exception -> L133
            AlertModel.ButtonsBean r160 = (AlertModel.ButtonsBean) ListProtector.get(r107, 0);     // Catch: Exception -> L133
            if (r160 == null) goto L104;
            Integer r161 = Integer.valueOf(r160.getColor());     // Catch: Exception -> L133
        L105:
            f0 r162 = new f0(null, Integer.valueOf(AlertPlugin.access$getButtonColor(r108, r161)), null, 5);     // Catch: Exception -> L133
            Intrinsics.checkNotNullParameter(r162, "commonDialogTextStyleConfig");     // Catch: Exception -> L133
            r131.f327225e = r162;     // Catch: Exception -> L133
            g r163 = new g(r108, r111, r107);     // Catch: Exception -> L133
            AlertModel.ButtonsBean r164 = (AlertModel.ButtonsBean) ListProtector.get(r107, 1);     // Catch: Exception -> L133
            if (r164 == null) goto L108;
            String r165 = r164.getText();     // Catch: Exception -> L133
        L109:
            Intrinsics.checkNotNullParameter(r163, "listener");     // Catch: Exception -> L133
            r131.f327230j = r165;     // Catch: Exception -> L133
            r131.f327232l = r163;     // Catch: Exception -> L133
            AlertModel.ButtonsBean r166 = (AlertModel.ButtonsBean) ListProtector.get(r107, 1);     // Catch: Exception -> L133
            if (r166 == null) goto L112;
            Integer r167 = Integer.valueOf(r166.getColor());     // Catch: Exception -> L133
        L113:
            f0 r168 = new f0(null, Integer.valueOf(AlertPlugin.access$getButtonColor(r108, r167)), null, 5);     // Catch: Exception -> L133
            Intrinsics.checkNotNullParameter(r168, "commonDialogTextStyleConfig");     // Catch: Exception -> L133
            r131.f327231k = r168;     // Catch: Exception -> L133
            r131.a();     // Catch: Exception -> L133
            goto L123
        L112:
            r167 = null;
            goto L113
        L108:
            r165 = null;
            goto L109
        L104:
            r161 = null;
            goto L105
        L100:
            r159 = null;
            goto L101
        L114:
            h r169 = new h(r108, r111, r107);     // Catch: Exception -> L133
            AlertModel.ButtonsBean r170 = (AlertModel.ButtonsBean) ListProtector.get(r107, 0);     // Catch: Exception -> L133
            if (r170 == null) goto L117;
            String r171 = r170.getText();     // Catch: Exception -> L133
        L118:
            Intrinsics.checkNotNullParameter(r169, "listener");     // Catch: Exception -> L133
            r131.f327224d = r171;     // Catch: Exception -> L133
            r131.f327226f = r169;     // Catch: Exception -> L133
            AlertModel.ButtonsBean r172 = (AlertModel.ButtonsBean) ListProtector.get(r107, 0);     // Catch: Exception -> L133
            if (r172 == null) goto L121;
            Integer r173 = Integer.valueOf(r172.getColor());     // Catch: Exception -> L133
        L122:
            f0 r174 = new f0(null, Integer.valueOf(AlertPlugin.access$getButtonColor(r108, r173)), null, 5);     // Catch: Exception -> L133
            Intrinsics.checkNotNullParameter(r174, "commonDialogTextStyleConfig");     // Catch: Exception -> L133
            r131.f327225e = r174;     // Catch: Exception -> L133
            r131.a();     // Catch: Exception -> L133
            goto L123
        L121:
            r173 = null;
            goto L122
        L117:
            r171 = null;
        L56:
            if (r107.size() == 3) goto L61;
            if (r107.size() == 1) goto L61;
            FLogger.f375446a.i(AlertPlugin.TAG, "Invalid alert params");     // Catch: Exception -> L133
            Unit r175 = Unit.INSTANCE;     // Catch: Exception -> L133
            return;
        L161:
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.OfficeDocumentPlugin, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public AlertPlugin() {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin
    public String getPluginId() {
        return y5.f222538g;
    }

    public static final /* synthetic */ Context access$getContext(AlertPlugin r100) {
        return r100.getContext();
    }

    public static final /* synthetic */ DialogFragment access$getDialog$p(AlertPlugin r100) {
        return r100.dialog;
    }

    private final int getButtonColor(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        if (r100 == null) goto L13;
        if (r100.intValue() != 2) goto L13;
        return ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_primary_50, getContext(), R.color.larus_primary_50));
    L13:
        return ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_70, getContext(), R.color.larus_neutral_70));
    L5:
        if (r100.intValue() != 1) goto L7;
        return ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_danger_50, getContext(), R.color.larus_danger_50));
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        r100.put(BIZ_SHOW_ALERT, new b(this));
    }

    public static final /* synthetic */ int access$getButtonColor(AlertPlugin r100, Integer r101) {
        return r100.getButtonColor(r101);
    }

    public static final /* synthetic */ void access$setDialog$p(AlertPlugin r100, DialogFragment r101) {
        r100.dialog = r101;
    }
}
