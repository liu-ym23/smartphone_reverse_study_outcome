package com.ss.android.lark.chat.cot.detail;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.biz.im.extension.panel.drag.DragPanel;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.cot.CotTracker;
import com.ss.android.lark.chat.cot.CotViewModel;
import com.ss.android.lark.chat.cot.detail.blueprint.CotDetailBlueprintAdapter;
import com.ss.android.lark.chat.cot.detail.blueprint.CotDetailBlueprintAdapter$Companion$DIFF_CALLBACK$1;
import com.ss.android.lark.chat.cot.entry.CotEntryView;
import com.ss.android.lark.chat.entity.message.CotContent;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.m0;
import com.ss.android.lark.widget.textview.ShineTextView;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 A2\u00020\u0001:\u0001ABQ\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010.\u001a\u0004\u0018\u00010\u00072\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\u0010H\u0002J\b\u00102\u001a\u00020\u0010H\u0002J\u0010\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020+H\u0002J\b\u00105\u001a\u00020\u0010H\u0002J\b\u00106\u001a\u00020\u0010H\u0002J\b\u00107\u001a\u00020\u0010H\u0002J\u0010\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\nH\u0002J\b\u0010:\u001a\u00020\u0010H\u0002J\b\u0010;\u001a\u00020\u0010H\u0002J\b\u0010<\u001a\u00020\u0010H\u0002J\u0010\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/ss/android/lark/chat/cot/detail/CotDetailSheet;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "activity", "Landroidx/fragment/app/FragmentActivity;", "anchorView", "Landroid/view/View;", "messageId", "", "chatId", "cotViewModel", "Lcom/ss/android/lark/chat/cot/CotViewModel;", "cotFeatureGate", "Lcom/ss/android/lark/chat/cot/CotFeatureGate;", "botId", "onConfirmStop", "Lkotlin/Function0;", "", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chat/cot/CotViewModel;Lcom/ss/android/lark/chat/cot/CotFeatureGate;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "isDisplayUpgradeEnabled", "", "viewModel", "Lcom/ss/android/lark/chat/cot/detail/CotDetailViewModel;", "expandStore", "Lcom/ss/android/lark/chat/cot/detail/CotDetailExpandStore;", "contentController", "Lcom/ss/android/lark/chat/cot/detail/CotDetailContentController;", "panel", "Lcom/ss/android/lark/biz/im/extension/panel/drag/DragPanel;", "stopConfirmDialog", "Lcom/larksuite/component/ui/dialog/LKUIDialog;", "stateJob", "Lkotlinx/coroutines/Job;", "pushJob", "scope", "Lkotlinx/coroutines/CoroutineScope;", "latestTitle", "pushListener", "Lcom/ss/android/lark/biz/im/api/IPushMessageListener;", "pushFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/ss/android/lark/chat/entity/message/CotContent;", "lastSubmittedState", "Lcom/ss/android/lark/chat/cot/detail/CotDetailUiState;", "released", "closeTracked", "resolveStepName", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/chat/cot/detail/CotDetailItem;", "open", "observeData", ChameleonOpenTracker.Stage.RENDER, "state", "subscribePush", "fetchLatestAndSubmit", "unsubscribePush", "calculateTitle", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "showStopConfirmDialog", "sendStopCommand", "release", LiveCommonConstants.REASON_ON_DEDTROY, "owner", "Landroidx/lifecycle/LifecycleOwner;", "trackCloseIfNeeded", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CotDetailSheet implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f414804v = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f414805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f414806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f414807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f414808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CotViewModel f414809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f414810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f414811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final r f414812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j f414813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f414814j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DragPanel f414815k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LKUIDialog f414816l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Job f414817m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Job f414818n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CoroutineScope f414819o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f414820p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public o f414821q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final MutableSharedFlow<CotContent> f414822r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public q f414823s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f414824t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f414825u;

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public static void a(FragmentActivity r210, CotEntryView r211, String r212, String r213, CotViewModel r214, com.ss.android.lark.chat.cot.a r215, String r216, Function0 r310) {
            Intrinsics.checkNotNullParameter(r210, "activity");
            Intrinsics.checkNotNullParameter(r211, "anchorView");
            Intrinsics.checkNotNullParameter(r212, "messageId");
            Intrinsics.checkNotNullParameter(r213, "chatId");
            Intrinsics.checkNotNullParameter(r214, "cotViewModel");
            Intrinsics.checkNotNullParameter(r215, "cotFeatureGate");
            Intrinsics.checkNotNullParameter(r216, "botId");
            if (r210.isFinishing() == false) goto L5;
        L35:
            Log.w("CotDetailSheet", "activity not available, skip show");
            return;
        L5:
            if (r210.isDestroyed() == true) goto L35;
            Lazy r100 = CotTracker.f414784a;
            String r101 = r214.getCotId();
            Intrinsics.checkNotNullParameter(r101, "cotId");
            Intrinsics.checkNotNullParameter(r212, RemoteMessageConst.MSGID);
            Intrinsics.checkNotNullParameter(r213, "chatId");
            CotTracker.b(r101, r212, r213, BitableAnalytic.LinkSceneClickType.EXPAND);
            final CotDetailSheet r110 = new CotDetailSheet(r210, r211, r212, r213, r214, r215, r216, r310);
            if (m0.b(r210) == false) goto L10;
            int r102 = m0.a(r210);
        L11:
            com.ss.android.lark.biz.im.extension.panel.drag.g r103 = new com.ss.android.lark.biz.im.extension.panel.drag.g(new com.ss.android.lark.biz.im.extension.panel.drag.n(new com.ss.android.lark.biz.im.extension.panel.drag.h(0.9f)), new com.ss.android.lark.biz.im.extension.panel.drag.l(h18.d.a(r210, 10.0f), r102));
            m r104 = new m(r110);
            StringBuilder r105 = new StringBuilder("open detail sheet, messageId=");
            r105.append(r212);
            r105.append(", chatId=");
            r105.append(r213);
            r105.append(", cotId=");
            r105.append(r214.getCotId());
            r105.append(", status=");
            r105.append(r214.getOverallStatus());
            r105.append(", hasConfirmStop=");
            boolean r111 = true;
            if (r310 == null) goto L14;
            boolean r106 = true;
        L15:
            r105.append(r106);
            com.ss.android.lark.chat.cot.f.c("detail_stop_visibility", r105.toString());
            if (r310 != null) goto L18;
            Function0<Unit> r107 = null;
        L19:
            r110.f414814j.f414957k = r107;
            DragPanel r108 = new DragPanel(r210, r210, r104, r110.f414814j, r103);
            r110.f414815k = r108;
            l r109 = new l(r110);
            Intrinsics.checkNotNullParameter(r109, "listener");
            r108.f410516n.add(r109);
            r210.getLifecycle().addObserver(r110);
            r110.f414820p = r110.c(r214);
            com.ss.android.lark.chat.cot.f.c("detail_open_snapshot", "messageId=" + r212 + ", chatId=" + r213 + ", cotId=" + r214.getCotId() + ", blocks=" + r214.getBlocks().size() + ", status=" + r214.getOverallStatus());
            r r112 = r110.f414812h;
            r112.getClass();
            Intrinsics.checkNotNullParameter(r214, "viewModel");
            r112.f414999b.setValue(r112.a(r214));
            r110.f414823s = (q) r110.f414812h.f415000c.getValue();
            r110.f414817m = BuildersKt.launch$default(r110.f414819o, null, null, new CotDetailSheet$observeData$1(r110, null), 3, null);
            if (r212.length() != 0) goto L22;
            boolean r113 = true;
        L23:
            if (r113 == false) goto L25;
            Log.i("CotDetailSheet", "messageId is empty, live refresh disabled (snapshot only)");
        L27:
            if (r212.length() == 0) goto L30;
            r111 = false;
        L30:
            if (r111 == true) goto L33;
            ImSdkService.f().Fe(CollectionsKt.listOf(r212), new CotDetailSheet$fetchLatestAndSubmit$1(r110));
        L33:
            r108.g();
            return;
        L25:
            r110.f414818n = BuildersKt.launch$default(r110.f414819o, null, null, new CotDetailSheet$subscribePush$1(r110, null), 3, null);
            o r114 = new o(r110);
            r110.f414821q = r114;
            ImSdkService.e().gc(r114);
            com.ss.android.lark.chat.cot.f.c("detail_subscribe", "cot live refresh subscribed, messageId=".concat(r212));
            goto L27
        L22:
            r113 = false;
            goto L23
        L18:
            r107 = new CotDetailSheet$open$stopClickListener$1(r110);
            goto L19
        L14:
            r106 = false;
            goto L15
        L10:
            r102 = 0;
            goto L11
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f414826a = null;

        static {
            int[] r100 = new int[CotDetailBlockType.values().length];
            r100[CotDetailBlockType.GROUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CotDetailBlockType.TOOLCALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f414826a = r100;
        }
    }

    static {
    }

    public CotDetailSheet() {
        throw null;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onCreate(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onCreate(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onPause(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onPause(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onResume(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onResume(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStart(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStart(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStop(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStop(this, r100);
    }

    public final void d() {
        if (this.f414824t == false) goto L5;
        return;
    L5:
        this.f414824t = true;
        if (this.f414825u == true) goto L9;
        this.f414825u = true;
        Lazy r100 = CotTracker.f414784a;
        String r101 = this.f414809e.getCotId();
        String r102 = this.f414807c;
        String r103 = this.f414808d;
        Intrinsics.checkNotNullParameter(r101, "cotId");
        Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r103, "chatId");
        CotTracker.b(r101, r102, r103, "collapse");
    L9:
        o r104 = this.f414821q;
        if (r104 == null) goto L12;
        ImSdkService.e().O3(r104);
        com.ss.android.lark.chat.cot.f.c("detail_subscribe", "cot live refresh unsubscribed, messageId=" + this.f414807c);
    L12:
        this.f414821q = null;
        Job r105 = this.f414818n;
        if (r105 == null) goto L15;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
    L15:
        this.f414818n = null;
        CoroutineScopeKt.cancel$default(this.f414819o, null, 1, null);
        LKUIDialog r106 = this.f414816l;
        if (r106 == null) goto L18;
        a(r106);
    L18:
        this.f414816l = null;
        c r107 = this.f414814j;
        InvalidDecorationObserver r108 = r107.f414958l;
        if (r108 == null) goto L23;
        CotDetailBlueprintAdapter r109 = r107.f414956j;
        if (r109 == null) goto L23;
        r109.unregisterAdapterDataObserver(r108);
    L23:
        r107.f414958l = null;
        RecyclerView r110 = r107.f414953g;
        if (r110 == null) goto L32;
        CotStepExposureTracker r111 = r107.f414960n;
        if (r111 == null) goto L28;
        r111.f414839e = false;
        r111.b();
        r111.f414835a.removeOnScrollListener(r111.f414843i);
        r111.f414835a.removeOnChildAttachStateChangeListener(r111.f414844j);
        r111.f414838d.clear();
    L28:
        CotDetailContentController$setupStepTracking$2 r112 = r107.f414961o;
        if (r112 == null) goto L31;
        r110.removeOnItemTouchListener(r112);
    L31:
        r110.setAdapter(null);
    L32:
        RecyclerView r113 = r107.f414953g;
        if (r113 == null) goto L44;
        ViewTreeObserver r114 = r113.getViewTreeObserver();
        if (r114 == null) goto L44;
        if (r114.isAlive() == true) goto L40;
        r114 = null;
    L40:
        if (r114 == null) goto L44;
        g r115 = r107.f414959m;
        if (r115 == null) goto L44;
        r114.removeOnGlobalLayoutListener(r115);
    L44:
        r107.f414953g = null;
        CotDetailBlueprintAdapter r116 = r107.f414956j;
        if (r116 == null) goto L47;
        List<k> r117 = CollectionsKt.emptyList();
        CotDetailBlueprintAdapter$Companion$DIFF_CALLBACK$1 r118 = CotDetailBlueprintAdapter.f414850d;
        Intrinsics.checkNotNullParameter(r117, "list");
        r116.f414852c.submitList(r117, null);
    L47:
        r107.f414956j = null;
        ShineTextView r119 = r107.f414954h;
        if (r119 == null) goto L50;
        r119.x();
    L50:
        r107.f414954h = null;
        r107.f414955i = null;
        r107.f414959m = null;
        r107.f414960n = null;
        r107.f414961o = null;
        r107.f414962p = null;
        r107.f414963q = false;
        r107.f414965s = null;
        r107.f414964r = true;
        r107.f414957k = null;
        r107.f414952f = null;
        this.f414812h.f414999b.setValue(q.f414994d);
        this.f414813i.f414981a.clear();
        this.f414823s = null;
        this.f414805a.getLifecycle().removeObserver(this);
        this.f414815k = null;
    }

    public static void a(LKUIDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public final String c(CotViewModel r100) {
        String r101 = com.ss.android.lark.chat.cot.h.c(r100);
        CharSequence r102 = null;
        if (r101 != null) goto L5;
    L9:
        CharSequence r103 = com.ss.android.lark.chat.cot.h.a(r100);
        if (r103 == null) goto L17;
        if ((!StringsKt.isBlank(r103)) == false) goto L14;
        r102 = r103;
    L14:
        if (r102 == null) goto L17;
        return r102.toString();
    L17:
        return com.ss.android.lark.chat.cot.h.b(r100, this.f414805a);
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L9;
        return r101;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        DragPanel r101 = this.f414815k;
        if (r101 == null) goto L5;
        r101.c();
    L5:
        d();
    }

    public static final String b(CotDetailSheet r100, k r101) {
        r100.getClass();
        int r102 = b.f414826a[r101.f414983b.ordinal()];
        if (r102 != 1) goto L5;
        return "Lark_IM_AgentCot_CalledToolTime_Text";
    L5:
        if (r102 != 2) goto L12;
        String r103 = r101.f414984c;
        if (r103 == null) goto L12;
        if ((!StringsKt.isBlank(r103)) == false) goto L12;
        return r103;
    L12:
        return null;
    }

    public CotDetailSheet(FragmentActivity r100, CotEntryView r101, String r102, String r110, CotViewModel r111, com.ss.android.lark.chat.cot.a r112, String r113, Function0 r114) {
        this.f414805a = r100;
        this.f414806b = r101;
        this.f414807c = r102;
        this.f414808d = r110;
        this.f414809e = r111;
        this.f414810f = r113;
        this.f414811g = r114;
        if (r112.f414787a.isEnable("lark.im.agent.cot_message") == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        this.f414812h = new r(r103);
        j r104 = new j();
        this.f414813i = r104;
        this.f414814j = new c(r104, r112, r103, new CotDetailSheet$contentController$1(this), new CotDetailSheet$contentController$2(this));
        this.f414819o = CoroutineScopeKt.MainScope();
        this.f414822r = SharedFlowKt.MutableSharedFlow(1, 1, BufferOverflow.DROP_OLDEST);
        return;
    L5:
        if (r112.f414787a.isEnable("lark.im.agent.cot_display_upgrade") == false) goto L7;
        r103 = true;
        goto L8
    }
}
