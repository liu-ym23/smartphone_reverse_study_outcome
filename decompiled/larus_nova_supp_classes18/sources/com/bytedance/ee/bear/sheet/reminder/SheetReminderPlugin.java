package com.bytedance.ee.bear.sheet.reminder;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.reminder.ReminderViewModel;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u000b\u001a\u00020\f2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0014\u0010\u0005\u001a\b\u0018\u00010\u0006R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/sheet/reminder/SheetReminderPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/document/orientation/OrientationSupportPanel;", "<init>", "()V", "reminderHandler", "Lcom/bytedance/ee/bear/sheet/reminder/SheetReminderPlugin$SheetReminderHandler;", "viewModel", "Lcom/bytedance/ee/bear/sheet/reminder/SheetReminderViewModel;", "sheetAnalytic", "Lcom/bytedance/ee/bear/sheet/common/SheetAnalytic;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "showFragment", "hideFragment", "getReminderFragment", "Lcom/bytedance/ee/bear/sheet/reminder/SheetReminderFragment;", "shouldDisableLandscape", "", "Companion", "SheetReminderHandler", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetReminderPlugin extends DocumentPluginV2 implements p {
    public static final a Companion = null;
    public static final String TAG = "SheetReminderPlugin";
    private b reminderHandler;
    private final qm5.a sheetAnalytic;
    private SheetReminderViewModel viewModel;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<SheetReminderModel> {
        public m a;
        public String b;
        public final /* synthetic */ SheetReminderPlugin c;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(SheetReminderPlugin r1) {
            this.c = r1;
        }

        public final void handle(Object r3, m r4) {
            SheetReminderModel r5 = (SheetReminderModel) r3;
            tt5.a.h(SheetReminderPlugin.TAG, "SheetReminderHandler handle data: " + r5);
            this.a = r4;
            if (r5 != null) goto L5;
        L13:
            SheetReminderViewModel r6 = SheetReminderPlugin.access$getViewModel$p(this.c);
            if (r6 == null) goto L19;
            r6.setActive(false);
            return;
        L19:
            return;
        L5:
            if (r5.getData() == null) goto L13;
            this.b = r5.getData().getSheetId();
            SheetReminderViewModel r7 = SheetReminderPlugin.access$getViewModel$p(this.c);
            if (r7 == null) goto L10;
            r7.setOriginReminderSettings(r5.toSheetReminderSettings());
        L10:
            SheetReminderViewModel r8 = SheetReminderPlugin.access$getViewModel$p(this.c);
            if (r8 == null) goto L17;
            r8.setActive(true);
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ SheetReminderPlugin a;

        public c(SheetReminderPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            if (((Boolean) r3).booleanValue() == false) goto L8;
            BaseUnspecifiedOrientationPlugin r4 = SheetReminderPlugin.access$findPlugin(this.a, BaseUnspecifiedOrientationPlugin.class);
            if (r4 == null) goto L7;
            r4.onOrientationSupportPanelShowing(this.a);
        L7:
            tt5.a.h(SheetReminderPlugin.TAG, "show SheetReminderFragment.");
            SheetReminderPlugin.access$showFragment(this.a);
            return;
        L8:
            tt5.a.h(SheetReminderPlugin.TAG, "remove SheetReminderFragment.");
            BaseUnspecifiedOrientationPlugin r5 = SheetReminderPlugin.access$findPlugin(this.a, BaseUnspecifiedOrientationPlugin.class);
            if (r5 == null) goto L11;
            r5.onOrientationSupportPanelDismiss(this.a);
        L11:
            SheetReminderPlugin.access$hideFragment(this.a);
        }
    }

    public static final class d implements ReminderViewModel.a {
        public final /* synthetic */ SheetReminderPlugin a;

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void b() {
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void c() {
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void d() {
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void e() {
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void f() {
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void g() {
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void j() {
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void k() {
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void h() {
            tt5.a.h(SheetReminderPlugin.TAG, "report reminder person count limit event");
            qm5.a r0 = SheetReminderPlugin.access$getSheetAnalytic$p(this.a);
            b r1 = SheetReminderPlugin.access$getReminderHandler$p(this.a);
            if (r1 == null) goto L6;
            String r2 = r1.b;
            if (r2 == null) goto L6;
        L7:
            r0.getClass();
            HashMap r3 = new HashMap();
            r3.put("table_id", r2);
            r3.put("op_item", "reminder_person_num");
            r0.c("show_reminder_limit_toast", r3);
            return;
        L6:
            r2 = "";
            goto L7
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void onClose() {
            tt5.a.h(SheetReminderPlugin.TAG, "close SheetReminderFragment.");
            SheetReminderViewModel r0 = SheetReminderPlugin.access$getViewModel$p(this.a);
            if (r0 == null) goto L5;
            r0.setActive(false);
        L5:
            b r1 = SheetReminderPlugin.access$getReminderHandler$p(this.a);
            if (r1 == null) goto L11;
            JSONObject r2 = new JSONObject();
            r2.put("isCanceled", Boolean.TRUE);
            JSONObject r3 = new JSONObject();
            r3.put("sheetId", r1.b);
            r2.put("reminderUpdateArgs", r3);
            tt5.a.h(SheetReminderPlugin.TAG, "Cancel to edit reminder.");
            m r4 = r1.a;
            if (r4 == null) goto L12;
            r4.b(r2);
            return;
        L12:
            return;
        }

        public d(SheetReminderPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void i(com.bytedance.ee.bear.reminder.model.a r5) {
            tt5.a.h(SheetReminderPlugin.TAG, "save ReminderSettings. " + r5);
            SheetReminderViewModel r0 = SheetReminderPlugin.access$getViewModel$p(this.a);
            if (r0 == null) goto L6;
            r0.setActive(false);
        L6:
            if ((r5 instanceof fn5.c) == false) goto L8;
            fn5.c r6 = (fn5.c) r5;
        L9:
            SheetReminderModel.SheetReminderData r7 = SheetReminderModel.newInstance(r6);
            b r1 = SheetReminderPlugin.access$getReminderHandler$p(this.a);
            if (r1 == null) goto L15;
            Intrinsics.checkNotNull(r7);
            Intrinsics.checkNotNullParameter(r7, WikiFolderPushPlugin.DATA);
            r7.setSheetId(r1.b);
            JSONObject r2 = new JSONObject();
            r2.put("reminderUpdateArgs", r7);
            r2.put("isCanceled", Boolean.FALSE);
            tt5.a.h(SheetReminderPlugin.TAG, "onSave data.");
            m r8 = r1.a;
            if (r8 == null) goto L16;
            r8.b(r2);
            return;
        L16:
            return;
        L15:
            return;
        L8:
            r6 = null;
            goto L9
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public boolean shouldDisableLandscape() {
        return true;
    }

    public SheetReminderPlugin() {
        this.sheetAnalytic = new qm5.a();
    }

    private final SheetReminderFragment getReminderFragment() {
        return getActivity().getSupportFragmentManager().findFragmentByTag(TAG);
    }

    private final void hideFragment() {
        SheetReminderFragment r0 = getReminderFragment();
        if (r0 == null) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_reminder_SheetReminderPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r0);
        return;
    }

    private final void showFragment() {
        if (getReminderFragment() != null) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_reminder_SheetReminderPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(instantiateFragment(SheetReminderFragment.class), getActivity().getSupportFragmentManager(), TAG);
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_reminder_SheetReminderPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(SheetReminderFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static final /* synthetic */ b access$getReminderHandler$p(SheetReminderPlugin r0) {
        return r0.reminderHandler;
    }

    public static final /* synthetic */ qm5.a access$getSheetAnalytic$p(SheetReminderPlugin r0) {
        return r0.sheetAnalytic;
    }

    public static final /* synthetic */ SheetReminderViewModel access$getViewModel$p(SheetReminderPlugin r0) {
        return r0.viewModel;
    }

    public static final /* synthetic */ void access$hideFragment(SheetReminderPlugin r0) {
        r0.hideFragment();
    }

    public static final /* synthetic */ void access$showFragment(SheetReminderPlugin r0) {
        r0.showFragment();
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        b r0 = new b(this);
        this.reminderHandler = r0;
        Intrinsics.checkNotNull(r0);
        r3.put("biz.sheet.showReminderPanel", r0);
    }

    public void onAttachToHost(PluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        SheetReminderViewModel r4 = (SheetReminderViewModel) q.c(getHost(), SheetReminderViewModel.class, null);
        this.viewModel = r4;
        if (r4 == null) goto L7;
        MutableLiveData<Boolean> r5 = r4.getActive();
        if (r5 == null) goto L7;
        r5.observe(getLifecycleOwner(), new c(this));
    L7:
        SheetReminderViewModel r6 = this.viewModel;
        if (r6 == null) goto L10;
        r6.setDelegate(new d(this));
    L10:
        SheetReminderViewModel r7 = this.viewModel;
        if (r7 == null) goto L13;
        r7.setBearUrl(getEditorAbility().getDocumentMetadata().getBearUrl());
    L13:
        qm5.a r8 = this.sheetAnalytic;
        r8.a = getEditorAbility().getDocumentMetadata().getBearUrl();
    }

    public static final /* synthetic */ f access$findPlugin(SheetReminderPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_reminder_SheetReminderPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(SheetReminderFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        SheetReminderFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
