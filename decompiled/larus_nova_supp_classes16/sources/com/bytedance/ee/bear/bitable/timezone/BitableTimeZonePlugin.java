package com.bytedance.ee.bear.bitable.timezone;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.viewmodel.TableInfoViewModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.i5;
import com.bytedance.ee.bear.document.p;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 22\u00020\u00012\u00020\u0002:\u0003234B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0019\u001a\u00020\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d0\u001cH\u0016J\u0012\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010\"\u001a\u00020#H\u0016J \u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u001aH\u0016J\u001e\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007J\u0006\u00100\u001a\u00020\u001aJ\u0018\u00101\u001a\u00020*2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017¨\u00065"}, d2 = {"Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZonePlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/document/BitableTimeZoneAbility;", "<init>", "()V", "fragmentTransactionParams", "Ljava/util/HashMap;", "", "Lcom/bytedance/ee/bear/browser/plugin/TransactionParams;", "params", "pluginHost", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "mTimeZoneAnalytic", "Lcom/bytedance/ee/bear/bitable/common/analytic/BitableAnalytic;", "mViewModel", "Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZoneViewModel;", "getMViewModel", "()Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZoneViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mListViewModel", "Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZoneListViewModel;", "getMListViewModel", "()Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZoneListViewModel;", "mListViewModel$delegate", "getBridgeHandlers", "", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onDetachFromHost", "isViewImmersive", "", "showTimeZonePanel", "context", "Landroid/content/Context;", "rootView", "Landroid/view/ViewGroup;", "args", "Landroid/os/Bundle;", "closeTimeZonePanel", "showTimeZoneListPanel", "tag", "url", "data", "closeTimeZoneListPanel", "getFragmentArgs", "Companion", "SetBaseTimeZoneHandler", "Delegate", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableTimeZonePlugin extends DocumentPluginV2 implements p {
    public static final String BIZ_SRT_BASE_TIME_ZONE = "biz.bitable.setBaseTimeZone";
    public static final a Companion = null;
    private static final String TAG = "BitableTimeZonePlugin";
    private final HashMap<String, s> fragmentTransactionParams;
    private final Lazy mListViewModel$delegate;
    private BitableAnalytic mTimeZoneAnalytic;
    private final Lazy mViewModel$delegate;
    private s params;
    private DocumentPluginHost pluginHost;

    public static final class a {
        public a() {
        }
    }

    public interface b {
        void d();

        void e(String r1, String r2);

        void reportEvent(String r1, Map<String, String> r2);
    }

    public final class c implements i<String> {
        public final /* synthetic */ BitableTimeZonePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(BitableTimeZonePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            String r4 = (String) r2;
            if (r3 == null) goto L8;
            i5 r5 = BitableTimeZonePlugin.access$getMListViewModel(this.a).getLynxWebDelegate();
            if (r5 == null) goto L9;
            r5.c(BitableTimeZonePlugin.BIZ_SRT_BASE_TIME_ZONE, r3);
            return;
        L9:
            return;
        }
    }

    public static final class d implements b {
        public final /* synthetic */ BitableTimeZonePlugin a;

        @Override // com.bytedance.ee.bear.bitable.timezone.BitableTimeZonePlugin.b
        public final void e(String r3, String r4) {
            Intrinsics.checkNotNullParameter("BitableTimeZoneListPanel", "tag");
            Intrinsics.checkNotNullParameter(r3, "url");
            Intrinsics.checkNotNullParameter(r4, "data");
        }

        @Override // com.bytedance.ee.bear.bitable.timezone.BitableTimeZonePlugin.b
        public final void d() {
            this.a.closeTimeZoneListPanel();
            this.a.closeTimeZonePanel();
        }

        public d(BitableTimeZonePlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.bitable.timezone.BitableTimeZonePlugin.b
        public final void reportEvent(String r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "evenName");
            Intrinsics.checkNotNullParameter(r3, "params");
            BitableAnalytic r0 = BitableTimeZonePlugin.access$getMTimeZoneAnalytic$p(this.a);
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mTimeZoneAnalytic");
            r0 = null;
        L5:
            r0.t(r2, r3);
        }
    }

    public static final class e implements b {
        public final /* synthetic */ BitableTimeZonePlugin a;

        @Override // com.bytedance.ee.bear.bitable.timezone.BitableTimeZonePlugin.b
        public final void d() {
            this.a.closeTimeZonePanel();
        }

        public e(BitableTimeZonePlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.bitable.timezone.BitableTimeZonePlugin.b
        public final void e(String r3, String r4) {
            Intrinsics.checkNotNullParameter("BitableTimeZoneListPanel", "tag");
            Intrinsics.checkNotNullParameter(r3, "url");
            Intrinsics.checkNotNullParameter(r4, "data");
            this.a.showTimeZoneListPanel("BitableTimeZoneListPanel", r3, r4);
        }

        @Override // com.bytedance.ee.bear.bitable.timezone.BitableTimeZonePlugin.b
        public final void reportEvent(String r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "evenName");
            Intrinsics.checkNotNullParameter(r3, "params");
            BitableAnalytic r0 = BitableTimeZonePlugin.access$getMTimeZoneAnalytic$p(this.a);
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mTimeZoneAnalytic");
            r0 = null;
        L5:
            r0.t(r2, r3);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public boolean isViewImmersive() {
        return true;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final BitableTimeZoneListViewModel getMListViewModel() {
        return (BitableTimeZoneListViewModel) this.mListViewModel$delegate.getValue();
    }

    private final BitableTimeZoneViewModel getMViewModel() {
        return (BitableTimeZoneViewModel) this.mViewModel$delegate.getValue();
    }

    public final void closeTimeZoneListPanel() {
        DocumentPluginHost r0 = this.pluginHost;
        if (r0 == null) goto L14;
        FragmentActivity r1 = r0.getActivity();
        if (r1 == null) goto L19;
        int r2 = r1.getSupportFragmentManager().getFragments().size();
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L20;
        BitableTimeZoneListFragment r4 = (Fragment) ListProtector.get(r1.getSupportFragmentManager().getFragments(), r3);
        if (r4 == null) goto L13;
        if ((r4 instanceof BitableTimeZoneListFragment) == false) goto L13;
        INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_timezone_BitableTimeZonePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r4);
    L13:
        r3 = r3 + 1;
        goto L7
    L20:
        return;
    L19:
        return;
    }

    public void closeTimeZonePanel() {
        DocumentPluginHost r0 = this.pluginHost;
        if (r0 == null) goto L5;
        com.bytedance.ee.bear.bitable.core.basemain.ability.b r1 = (com.bytedance.ee.bear.bitable.core.basemain.ability.b) r0.getHostAbilityOrNull(com.bytedance.ee.bear.bitable.core.basemain.ability.b.class);
    L6:
        if (r1 == null) goto L9;
        getUIContainer().d(this);
        return;
    L9:
        DocumentPluginHost r2 = this.pluginHost;
        if (r2 == null) goto L26;
        FragmentActivity r3 = r2.getActivity();
        if (r3 == null) goto L27;
        FragmentManager r4 = r3.getSupportFragmentManager();
        if (r4 == null) goto L29;
        s r5 = this.fragmentTransactionParams.remove("Bitable_Time_Zone");
        Fragment r6 = r4.findFragmentByTag("Bitable_Time_Zone");
        if (r6 != null) goto L19;
        return;
    L19:
        if (r4 == r6.getFragmentManager()) goto L21;
        return;
    L21:
        FragmentTransaction r7 = r4.beginTransaction();
        if (r5 == null) goto L24;
        r7.setCustomAnimations(r5.a, r5.b, r5.c, r5.d);
    L24:
        r7.remove(r6).commitAllowingStateLoss();
        return;
    L29:
        return;
    L27:
        return;
    L26:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public BitableTimeZonePlugin() {
        this.fragmentTransactionParams = new HashMap();
        this.mViewModel$delegate = LazyKt.lazy(new BitableTimeZonePlugin$mViewModel$2(this));
        this.mListViewModel$delegate = LazyKt.lazy(new BitableTimeZonePlugin$mListViewModel$2(this));
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_timezone_BitableTimeZonePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(BitableTimeZoneListFragment r1) {
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

    public static final /* synthetic */ BitableTimeZoneListViewModel access$getMListViewModel(BitableTimeZonePlugin r0) {
        return r0.getMListViewModel();
    }

    public static final /* synthetic */ BitableAnalytic access$getMTimeZoneAnalytic$p(BitableTimeZonePlugin r0) {
        return r0.mTimeZoneAnalytic;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put(BIZ_SRT_BASE_TIME_ZONE, new c(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r5) {
        super.onAttachToHost(r5);
        DocumentPluginHost r6 = (DocumentPluginHost) r5;
        this.pluginHost = r6;
        if (r6 == null) goto L5;
        r6.registerHostAbility(this);
    L5:
        k r7 = getWebOrNull();
        if (r7 == null) goto L8;
        getMListViewModel().setLynxWebDelegate(new i5(r7));
    L8:
        this.mTimeZoneAnalytic = new BitableAnalytic(new kr4.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), getDocumentMetadata().getBearUrl(), viewModel(TableInfoViewModel.class)));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r1) {
        super.onDetachFromHost(r1);
        if (r1 == null) goto L5;
        r1.unregisterHostAbility(this);
    L5:
        this.pluginHost = null;
    }

    private final Bundle getFragmentArgs(String r3, String r4) {
        Bundle r0 = new Bundle();
        r0.putString("panel_content_page", r3);
        r0.putString("panel_data", r4);
        return r0;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_timezone_BitableTimeZonePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(BitableTimeZoneListFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        BitableTimeZoneListFragment r0 = r2;
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

    public final void showTimeZoneListPanel(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "data");
        if (getMListViewModel().getPluginDelegate() != null) goto L5;
        getMListViewModel().setPluginDelegate(new d(this));
    L5:
        BitableTimeZoneListFragment r5 = instantiateFragment(BitableTimeZoneListFragment.class, getFragmentArgs(r3, r4));
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.timezone.BitableTimeZoneListFragment");
        BitableTimeZoneListFragment r6 = r5;
        Dialog r7 = r6.getDialog();
        if (r7 == null) goto L8;
        r7.setCanceledOnTouchOutside(true);
    L8:
        DocumentPluginHost r8 = this.pluginHost;
        if (r8 == null) goto L14;
        FragmentActivity r9 = r8.getActivity();
        if (r9 == null) goto L15;
        INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_timezone_BitableTimeZonePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r6, r9.getSupportFragmentManager(), TAG);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ee.bear.document.p
    public void showTimeZonePanel(Context r6, ViewGroup r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "rootView");
        Intrinsics.checkNotNullParameter(r8, "args");
        DocumentPluginHost r9 = this.pluginHost;
        if (r9 == null) goto L21;
        FragmentActivity r10 = r9.getActivity();
        if (r10 == null) goto L22;
        FragmentManager r11 = r10.getSupportFragmentManager();
        if (r11 != null) goto L10;
        return;
    L10:
        if (getMViewModel().getPluginDelegate() != null) goto L12;
        getMViewModel().setPluginDelegate(new e(this));
    L12:
        FragmentTransaction r12 = r11.beginTransaction();
        s r0 = s.a(2130772329, 2130772330, 2130772329, 2130772330);
        this.params = r0;
        r12.setCustomAnimations(r0.a, r0.b, r0.c, r0.d);
        this.fragmentTransactionParams.put("Bitable_Time_Zone", r0);
        Fragment r13 = instantiateFragment(BitableTimeZoneFragment.class, r8);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.timezone.BitableTimeZoneFragment");
        BitableTimeZoneFragment r14 = (BitableTimeZoneFragment) r13;
        DocumentPluginHost r1 = this.pluginHost;
        if (r1 == null) goto L15;
        com.bytedance.ee.bear.bitable.core.basemain.ability.b r2 = (com.bytedance.ee.bear.bitable.core.basemain.ability.b) r1.getHostAbilityOrNull(com.bytedance.ee.bear.bitable.core.basemain.ability.b.class);
    L16:
        if (r2 == null) goto L19;
        getUIContainer().e(this, r14, this.params);
        return;
    L19:
        INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_timezone_BitableTimeZonePlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r12, r7.getId(), r14, "Bitable_Time_Zone");
        r12.commitAllowingStateLoss();
        return;
    L15:
        r2 = null;
        goto L16
    L22:
        return;
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_timezone_BitableTimeZonePlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r1, int r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, r2) == false) goto L6;
        return r1;
    L6:
        return r1.add(r2, r3, r4);
    }
}
