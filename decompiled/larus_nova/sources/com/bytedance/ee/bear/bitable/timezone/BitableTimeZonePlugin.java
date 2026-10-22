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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 22\u00020\u00012\u00020\u0002:\u0003234B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0019\u001a\u00020\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d0\u001cH\u0016J\u0012\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010\"\u001a\u00020#H\u0016J \u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u001aH\u0016J\u001e\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007J\u0006\u00100\u001a\u00020\u001aJ\u0018\u00101\u001a\u00020*2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017¨\u00065"}, d2 = {"Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZonePlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/document/BitableTimeZoneAbility;", "<init>", "()V", "fragmentTransactionParams", "Ljava/util/HashMap;", "", "Lcom/bytedance/ee/bear/browser/plugin/TransactionParams;", "params", "pluginHost", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "mTimeZoneAnalytic", "Lcom/bytedance/ee/bear/bitable/common/analytic/BitableAnalytic;", "mViewModel", "Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZoneViewModel;", "getMViewModel", "()Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZoneViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mListViewModel", "Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZoneListViewModel;", "getMListViewModel", "()Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZoneListViewModel;", "mListViewModel$delegate", "getBridgeHandlers", "", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onDetachFromHost", "isViewImmersive", "", "showTimeZonePanel", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "rootView", "Landroid/view/ViewGroup;", "args", "Landroid/os/Bundle;", "closeTimeZonePanel", "showTimeZoneListPanel", "tag", "url", "data", "closeTimeZoneListPanel", "getFragmentArgs", "Companion", "SetBaseTimeZoneHandler", "Delegate", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        void e(String r100, String r101);

        void reportEvent(String r100, Map<String, String> r101);
    }

    public final class c implements i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableTimeZonePlugin f215945a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(BitableTimeZonePlugin r100) {
            this.f215945a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            String r102 = (String) r100;
            if (r101 == null) goto L8;
            i5 r103 = BitableTimeZonePlugin.access$getMListViewModel(this.f215945a).getLynxWebDelegate();
            if (r103 == null) goto L9;
            r103.c(BitableTimeZonePlugin.BIZ_SRT_BASE_TIME_ZONE, r101);
            return;
        L9:
            return;
        }
    }

    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableTimeZonePlugin f215946a;

        @Override // com.bytedance.ee.bear.bitable.timezone.BitableTimeZonePlugin.b
        public final void e(String r100, String r101) {
            Intrinsics.checkNotNullParameter("BitableTimeZoneListPanel", "tag");
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r101, "data");
        }

        @Override // com.bytedance.ee.bear.bitable.timezone.BitableTimeZonePlugin.b
        public final void d() {
            this.f215946a.closeTimeZoneListPanel();
            this.f215946a.closeTimeZonePanel();
        }

        public d(BitableTimeZonePlugin r100) {
            this.f215946a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.timezone.BitableTimeZonePlugin.b
        public final void reportEvent(String r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r100, "evenName");
            Intrinsics.checkNotNullParameter(r101, "params");
            BitableAnalytic r102 = BitableTimeZonePlugin.access$getMTimeZoneAnalytic$p(this.f215946a);
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mTimeZoneAnalytic");
            r102 = null;
        L5:
            r102.t(r100, r101);
        }
    }

    public static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableTimeZonePlugin f215947a;

        @Override // com.bytedance.ee.bear.bitable.timezone.BitableTimeZonePlugin.b
        public final void d() {
            this.f215947a.closeTimeZonePanel();
        }

        public e(BitableTimeZonePlugin r100) {
            this.f215947a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.timezone.BitableTimeZonePlugin.b
        public final void e(String r100, String r101) {
            Intrinsics.checkNotNullParameter("BitableTimeZoneListPanel", "tag");
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f215947a.showTimeZoneListPanel("BitableTimeZoneListPanel", r100, r101);
        }

        @Override // com.bytedance.ee.bear.bitable.timezone.BitableTimeZonePlugin.b
        public final void reportEvent(String r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r100, "evenName");
            Intrinsics.checkNotNullParameter(r101, "params");
            BitableAnalytic r102 = BitableTimeZonePlugin.access$getMTimeZoneAnalytic$p(this.f215947a);
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mTimeZoneAnalytic");
            r102 = null;
        L5:
            r102.t(r100, r101);
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
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private final BitableTimeZoneListViewModel getMListViewModel() {
        return (BitableTimeZoneListViewModel) this.mListViewModel$delegate.getValue();
    }

    private final BitableTimeZoneViewModel getMViewModel() {
        return (BitableTimeZoneViewModel) this.mViewModel$delegate.getValue();
    }

    public final void closeTimeZoneListPanel() {
        DocumentPluginHost r100 = this.pluginHost;
        if (r100 == null) goto L14;
        FragmentActivity r101 = r100.getActivity();
        if (r101 == null) goto L19;
        int r102 = r101.getSupportFragmentManager().getFragments().size();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L20;
        Fragment r104 = (Fragment) ListProtector.get(r101.getSupportFragmentManager().getFragments(), r103);
        if (r104 == null) goto L13;
        if ((r104 instanceof BitableTimeZoneListFragment) == false) goto L13;
        INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_timezone_BitableTimeZonePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss((BitableTimeZoneListFragment) r104);
    L13:
        r103 = r103 + 1;
        goto L7
    L20:
        return;
    L19:
        return;
    }

    public void closeTimeZonePanel() {
        DocumentPluginHost r100 = this.pluginHost;
        if (r100 == null) goto L5;
        com.bytedance.ee.bear.bitable.core.basemain.ability.b r101 = (com.bytedance.ee.bear.bitable.core.basemain.ability.b) r100.getHostAbilityOrNull(com.bytedance.ee.bear.bitable.core.basemain.ability.b.class);
    L6:
        if (r101 == null) goto L9;
        getUIContainer().d(this);
        return;
    L9:
        DocumentPluginHost r102 = this.pluginHost;
        if (r102 == null) goto L26;
        FragmentActivity r103 = r102.getActivity();
        if (r103 == null) goto L27;
        FragmentManager r104 = r103.getSupportFragmentManager();
        if (r104 == null) goto L29;
        s r105 = this.fragmentTransactionParams.remove("Bitable_Time_Zone");
        Fragment r106 = r104.findFragmentByTag("Bitable_Time_Zone");
        if (r106 != null) goto L19;
        return;
    L19:
        if (r104 == r106.getFragmentManager()) goto L21;
        return;
    L21:
        FragmentTransaction r107 = r104.beginTransaction();
        if (r105 == null) goto L24;
        r107.setCustomAnimations(r105.f216644a, r105.f216645b, r105.f216646c, r105.f216647d);
    L24:
        r107.remove(r106).commitAllowingStateLoss();
        return;
    L29:
        return;
    L27:
        return;
    L26:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public BitableTimeZonePlugin() {
        this.fragmentTransactionParams = new HashMap();
        this.mViewModel$delegate = LazyKt.lazy(new BitableTimeZonePlugin$mViewModel$2(this));
        this.mListViewModel$delegate = LazyKt.lazy(new BitableTimeZonePlugin$mListViewModel$2(this));
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_timezone_BitableTimeZonePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(BitableTimeZoneListFragment r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static final /* synthetic */ BitableTimeZoneListViewModel access$getMListViewModel(BitableTimeZonePlugin r100) {
        return r100.getMListViewModel();
    }

    public static final /* synthetic */ BitableAnalytic access$getMTimeZoneAnalytic$p(BitableTimeZonePlugin r100) {
        return r100.mTimeZoneAnalytic;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        r100.put(BIZ_SRT_BASE_TIME_ZONE, new c(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r100) {
        super.onAttachToHost(r100);
        DocumentPluginHost r101 = (DocumentPluginHost) r100;
        this.pluginHost = r101;
        if (r101 == null) goto L5;
        r101.registerHostAbility(this);
    L5:
        k r102 = getWebOrNull();
        if (r102 == null) goto L8;
        getMListViewModel().setLynxWebDelegate(new i5(r102));
    L8:
        this.mTimeZoneAnalytic = new BitableAnalytic(new kr4.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), getDocumentMetadata().getBearUrl(), (TableInfoViewModel) viewModel(TableInfoViewModel.class)));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r100) {
        super.onDetachFromHost(r100);
        if (r100 == null) goto L5;
        r100.unregisterHostAbility(this);
    L5:
        this.pluginHost = null;
    }

    private final Bundle getFragmentArgs(String r100, String r101) {
        Bundle r102 = new Bundle();
        r102.putString("panel_content_page", r100);
        r102.putString("panel_data", r101);
        return r102;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_timezone_BitableTimeZonePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(BitableTimeZoneListFragment r100, FragmentManager r101, String r102) {
        if ((r100 instanceof Fragment) == false) goto L5;
        BitableTimeZoneListFragment r103 = r100;
    L6:
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, r102, r104);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r103, r104) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r100.show(r101, r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void showTimeZoneListPanel(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "data");
        if (getMListViewModel().getPluginDelegate() != null) goto L5;
        getMListViewModel().setPluginDelegate(new d(this));
    L5:
        Fragment r103 = instantiateFragment(BitableTimeZoneListFragment.class, getFragmentArgs(r101, r102));
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.timezone.BitableTimeZoneListFragment");
        BitableTimeZoneListFragment r104 = (BitableTimeZoneListFragment) r103;
        Dialog r105 = r104.getDialog();
        if (r105 == null) goto L8;
        r105.setCanceledOnTouchOutside(true);
    L8:
        DocumentPluginHost r106 = this.pluginHost;
        if (r106 == null) goto L14;
        FragmentActivity r107 = r106.getActivity();
        if (r107 == null) goto L15;
        INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_timezone_BitableTimeZonePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r104, r107.getSupportFragmentManager(), TAG);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ee.bear.document.p
    public void showTimeZonePanel(Context r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r102, "args");
        DocumentPluginHost r103 = this.pluginHost;
        if (r103 == null) goto L21;
        FragmentActivity r104 = r103.getActivity();
        if (r104 == null) goto L22;
        FragmentManager r105 = r104.getSupportFragmentManager();
        if (r105 != null) goto L10;
        return;
    L10:
        if (getMViewModel().getPluginDelegate() != null) goto L12;
        getMViewModel().setPluginDelegate(new e(this));
    L12:
        FragmentTransaction r106 = r105.beginTransaction();
        s r107 = s.a(R.anim.image_pager_enter_animation, R.anim.image_pager_exit_animation, R.anim.image_pager_enter_animation, R.anim.image_pager_exit_animation);
        this.params = r107;
        r106.setCustomAnimations(r107.f216644a, r107.f216645b, r107.f216646c, r107.f216647d);
        this.fragmentTransactionParams.put("Bitable_Time_Zone", r107);
        Fragment r108 = instantiateFragment(BitableTimeZoneFragment.class, r102);
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.timezone.BitableTimeZoneFragment");
        BitableTimeZoneFragment r109 = (BitableTimeZoneFragment) r108;
        DocumentPluginHost r110 = this.pluginHost;
        if (r110 == null) goto L15;
        com.bytedance.ee.bear.bitable.core.basemain.ability.b r111 = (com.bytedance.ee.bear.bitable.core.basemain.ability.b) r110.getHostAbilityOrNull(com.bytedance.ee.bear.bitable.core.basemain.ability.b.class);
    L16:
        if (r111 == null) goto L19;
        getUIContainer().e(this, r109, this.params);
        return;
    L19:
        INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_timezone_BitableTimeZonePlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r106, r101.getId(), r109, "Bitable_Time_Zone");
        r106.commitAllowingStateLoss();
        return;
    L15:
        r111 = null;
        goto L16
    L22:
        return;
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_timezone_BitableTimeZonePlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r100, int r101, Fragment r102, String r103) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r103, r101) == false) goto L6;
        return r100;
    L6:
        return r100.add(r101, r102, r103);
    }
}
