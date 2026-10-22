package com.bytedance.ee.bear.bitable.toolbox.viewmodel;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.AsyncBitableJsBridgePlugin;
import com.bytedance.ee.bear.bitable.BitableAsyncRequest;
import com.bytedance.ee.bear.bitable.BitableAsyncRequestBiz;
import com.bytedance.ee.bear.bitable.BitableAsyncResponse;
import com.bytedance.ee.bear.bitable.common.BTJson;
import com.bytedance.ee.bear.bitable.common.query.EQueryType;
import com.bytedance.ee.bear.bitable.filter.view.BitableFilterPanel;
import com.bytedance.ee.bear.bitable.load.workimpl.NativeAddRecordCacheRenderPlugin;
import com.bytedance.ee.bear.bitable.n;
import com.bytedance.ee.bear.bitable.sort.BitableSortPanel;
import com.bytedance.ee.bear.bitable.toolbox.model.fab.BitableFabModel;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.EPanelAction;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.EPanelOperationAction;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.PanelData;
import com.bytedance.ee.bear.bitable.toolbox.model.toolbar.EToolbarMenu;
import com.bytedance.ee.bear.bitable.toolbox.model.toolbar.ToolbarData;
import com.bytedance.ee.bear.bitable.toolbox.view.BitableToolboxFragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.fab.FabVisibilityController;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import ew4.h0;
import ew4.x;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001\"\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0004MNOPB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010&\u001a\u00020\u00122\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020)\u0012\b\u0012\u0006\u0012\u0002\b\u00030*0(H\u0016J\u001c\u0010+\u001a\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00100\u001a\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001c\u00101\u001a\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00102\u001a\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u00103\u001a\u00020\u0012H\u0002J\b\u00104\u001a\u00020\u0012H\u0002J\b\u00105\u001a\u00020\u0012H\u0002J\b\u00106\u001a\u00020\u0012H\u0002J\b\u00107\u001a\u00020\u0016H\u0016J\u0006\u00108\u001a\u00020\u0016J\b\u00109\u001a\u00020:H\u0002J\u000e\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u0014J\u000e\u0010=\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u0014J\u000e\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020@J\u0010\u0010A\u001a\u00020\u00122\b\u0010B\u001a\u0004\u0018\u00010\rJ\b\u0010C\u001a\u00020\u0012H\u0016J\b\u0010D\u001a\u00020\u0012H\u0016J\u000e\u0010E\u001a\u00020\u00122\u0006\u0010F\u001a\u00020\u0016J\u0010\u0010G\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u0016H\u0002J\b\u0010I\u001a\u00020\u0012H\u0002J\u0010\u0010J\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u0016H\u0002J\u0010\u0010K\u001a\u00020\u00122\u0006\u0010L\u001a\u00020)H\u0002R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u0014\u0010$\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/BitableToolboxPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/document/orientation/OrientationSupportPanel;", "<init>", "()V", "mToolboxViewModel", "Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/BitableToolboxViewModel;", "kotlin.jvm.PlatformType", "getMToolboxViewModel", "()Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/BitableToolboxViewModel;", "mToolboxViewModel$delegate", "Lkotlin/Lazy;", "mPanelCallback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "mPanelActionListener", "", "Lkotlin/Function1;", "Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/EPanelAction;", "", "panelActionHandlerList", "Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/BitableToolboxPlugin$PanelActionHandler;", "tryFixBitableToolboxNotFindView", "", "observingSheetBottomPanelHeight", "observingOfficeBaseBottomPanelHeight", "observingBitableBottomPanelHeight", "officeBaseBottomPanelAbility", "Lcom/bytedance/ee/bear/bitable/core/bottompanel/OfficeBaseBottomPanelAbility;", "bitableFabConfig", "Lcom/bytedance/ee/bear/config/IBitableFabConfig;", "fabRequestedVisible", "aiChatListExpanded", "fabRequestedHide", "bottomPanelHeightListener", "com/bytedance/ee/bear/bitable/toolbox/viewmodel/BitableToolboxPlugin$bottomPanelHeightListener$1", "Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/BitableToolboxPlugin$bottomPanelHeightListener$1;", "mWebTouchListener", "Landroid/view/View$OnTouchListener;", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToUIContainer", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onAttachToHost", "onDetachFromUIContainer", "onDetachFromHost", "observeBottomPanelHeight", "stopObservingBottomPanelHeight", "createToolboxFragmentIfNeeded", "removeToolboxFragmentIfNeeded", "shouldDisableLandscape", "isFabCreateUseCacheRender", "createPanelDelegate", "Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/IPanelDelegate;", "registerPannelActionHandler", "panelActionHandler", "unRegisterPannelActionHandler", "setToolBoxVMPanelData", "panelData", "Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelData;", "setPanelCallback", "callback", "hideToolBarFragment", "showToolBarFragment", "setFabRequestedHide", "hide", "setFabRequestedVisible", "visible", "updateFabVisibility", "setCurrentPluginFragmentVisible", "logDetail", "msg", "FabHandler", "PanelsActionHandler", "PanelActionHandler", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableToolboxPlugin extends DocumentPlugin implements p {
    private static final String BIZ_PERFORM_PANELS_ACTION = "biz.bitable.performPanelsAction";
    public static final String BIZ_SET_FAB_BUTTONS = "biz.bitable.setFabButtons";
    public static final a Companion = null;
    private static final Map<EToolbarMenu, Class<? extends DialogFragment>> MENU_PANEL_MAP = null;
    private static final String TAG = "BitableToolboxPlugin";
    private boolean aiChatListExpanded;
    private x bitableFabConfig;
    private final e bottomPanelHeightListener;
    private boolean fabRequestedHide;
    private boolean fabRequestedVisible;
    private List<Function1<EPanelAction, Unit>> mPanelActionListener;
    private m mPanelCallback;
    private final Lazy mToolboxViewModel$delegate;
    private View.OnTouchListener mWebTouchListener;
    private boolean observingBitableBottomPanelHeight;
    private boolean observingOfficeBaseBottomPanelHeight;
    private boolean observingSheetBottomPanelHeight;
    private com.bytedance.ee.bear.bitable.core.bottompanel.a officeBaseBottomPanelAbility;
    private List<c> panelActionHandlerList;
    private boolean tryFixBitableToolboxNotFindView;

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<BitableFabModel> {
        public m a;
        public final /* synthetic */ BitableToolboxPlugin b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(BitableToolboxPlugin r1) {
            this.b = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // tb5.i, tb5.o
        public final void handle(Object r3, m r4) {
            BitableFabModel r5 = (BitableFabModel) r3;
            tt5.a.b(BitableToolboxPlugin.TAG, "FabHandler... receive data = " + r5);
            this.a = r4;
            DocumentPluginHost r0 = (DocumentPluginHost) this.b.getHost();
            if (r0 == null) goto L8;
            NativeAddRecordCacheRenderPlugin r1 = r0.findPlugin(NativeAddRecordCacheRenderPlugin.class);
            if (r1 == null) goto L8;
            r1.onReceiveFabData(r5, r4);
        L8:
            if (BitableFabModel.isValid(r5) == true) goto L10;
            BitableToolboxPlugin.access$setFabRequestedVisible(this.b, false);
            BitableToolboxPlugin.access$getMToolboxViewModel(this.b).getFabData().setValue(null);
            BitableToolboxPlugin.access$removeToolboxFragmentIfNeeded(this.b);
            return;
        L10:
            BitableToolboxPlugin.access$createToolboxFragmentIfNeeded(this.b);
            MutableLiveData<BitableFabModel.BitableFabItem[]> r6 = BitableToolboxPlugin.access$getMToolboxViewModel(this.b).getFabData();
            if (r5 == null) goto L14;
            BitableFabModel.BitableFabItem[] r7 = r5.getData();
            if (r7 == null) goto L14;
        L15:
            r6.setValue(r7);
            BitableToolboxPlugin.access$setFabRequestedVisible(this.b, true);
            BitableToolboxPlugin.access$getMToolboxViewModel(this.b).setOnClickFabItem(new BitableToolboxPlugin$FabHandler$handle$1(this));
            return;
        L14:
            r7 = new BitableFabModel.BitableFabItem[0];
            goto L15
        }
    }

    public interface c {
        boolean a(EPanelAction r1, PanelData r2, m r3);
    }

    public final class d implements tb5.i<String> {
        public final /* synthetic */ BitableToolboxPlugin a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[EPanelAction.values().length];
                r0[EPanelAction.SHOW_FILTER_PANEL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[EPanelAction.CLOSE_FILTER_PANEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[EPanelAction.SHOW_SORT_PANEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[EPanelAction.CLOSE_SORT_PANEL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(BitableToolboxPlugin r1) {
            this.a = r1;
        }

        public final void a(EToolbarMenu r4, boolean r5) {
            tt5.a.b(BitableToolboxPlugin.TAG, "handleMenuPanel()... menu = " + r4.getValue() + ", active = " + r5);
            DialogFragment r0 = BitableToolboxPlugin.access$getFragmentManager(this.a).findFragmentByTag(r4.getValue());
            Fragment r2 = null;
            if ((r0 instanceof DialogFragment) == false) goto L5;
            DialogFragment r1 = r0;
        L6:
            if (r5 == false) goto L16;
            if (r1 != null) goto L29;
            Fragment r6 = (DialogFragment) BitableToolboxPlugin.access$instantiateFragment(this.a, (Class) BitableToolboxPlugin.access$getMENU_PANEL_MAP$cp().get(r4));
            FragmentManager r3 = BitableToolboxPlugin.access$getFragmentManager(this.a);
            String r7 = r4.getValue();
            if ((r6 instanceof Fragment) == false) goto L11;
            r2 = r6;
        L11:
            LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, r7, r8);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r8) == true) goto L33;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
        L15:
            r6.show(r3, r7);
            return;
        L33:
            return;
        L29:
            return;
        L16:
            if (r1 == null) goto L31;
            r1.dismissAllowingStateLoss();     // Catch: Exception -> L19
            return;
        L19:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r9 = DialogFragmentLancet.sLastShowStack;
            if (r9 == null) goto L32;
            com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L32:
            return;
        L31:
            return;
        L5:
            r1 = null;
            goto L6
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r10, m r11) {
            String r12 = (String) r10;
            tt5.a.b(BitableToolboxPlugin.TAG, "PanelsActionHandler... receive data = " + JSON.toJSONString(r12));
            if (r12 == null) goto L46;
            BitableToolboxPlugin r0 = this.a;
            EPanelAction r1 = null;
            BitableToolboxPlugin.access$setMPanelCallback$p(r0, null);
            PanelData r13 = (PanelData) BTJson.c.a(r12, PanelData.class);
            if (r13 == null) goto L47;
            EPanelAction.a r2 = EPanelAction.Companion;
            String r3 = r13.getAction();
            r2.getClass();
            EPanelAction[] r4 = EPanelAction.values();
            int r5 = r4.length;
            int r6 = 0;
        L7:
            if (r6 >= r5) goto L12;
            EPanelAction r7 = r4[r6];
            if (TextUtils.equals(r7.getValue(), r3) == true) goto L10;
            r6 = r6 + 1;
            goto L7
        L10:
            r1 = r7;
        L12:
            if (r1 == null) goto L48;
            Iterator r8 = BitableToolboxPlugin.access$getPanelActionHandlerList$p(r0).iterator();
            boolean r9 = false;
        L15:
            if (r8.hasNext() == false) goto L19;
            if (((c) r8.next()).a(r1, r13, r11) == false) goto L15;
            r9 = true;
            goto L15
        L19:
            if (r9 == true) goto L49;
            BitableToolboxPlugin.access$setMPanelCallback$p(r0, r11);
            BitableToolboxPlugin.access$getMToolboxViewModel(r0).getPanelData().setValue(r13);
            Iterator r14 = BitableToolboxPlugin.access$getMPanelActionListener$p(this.a).iterator();
        L22:
            if (r14.hasNext() == false) goto L24;
            ((Function1) r14.next()).invoke(r1);
            goto L22
        L24:
            int r16 = a.a[r1.ordinal()];
            if (r16 != 1) goto L27;
            a(EToolbarMenu.FILTER, true);
            return;
        L27:
            if (r16 != 2) goto L29;
            a(EToolbarMenu.FILTER, false);
            return;
        L29:
            if (r16 != 3) goto L31;
            a(EToolbarMenu.SORT, true);
            return;
        L31:
            if (r16 != 4) goto L53;
            a(EToolbarMenu.SORT, false);
            return;
        L53:
            return;
        L49:
            return;
        L48:
            return;
        L47:
            return;
        }
    }

    public static final class e implements ew4.a {
        public final /* synthetic */ BitableToolboxPlugin a;

        public e(BitableToolboxPlugin r1) {
            this.a = r1;
        }

        @Override // ew4.a
        public final void a(int r2) {
            BitableToolboxPlugin.access$getMToolboxViewModel(this.a).getBottomPanelHeight().setValue(Integer.valueOf(r2));
        }

        @Override // ew4.a
        public final void b(boolean r2) {
            BitableToolboxPlugin.access$setAiChatListExpanded$p(this.a, !r2);
            BitableToolboxPlugin.access$updateFabVisibility(this.a);
        }
    }

    public static final class f implements com.bytedance.ee.bear.bitable.toolbox.viewmodel.b {
        public final /* synthetic */ BitableToolboxPlugin a;

        public f(BitableToolboxPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.bitable.toolbox.viewmodel.b
        public final void a(Function1<? super EPanelAction, Unit> r2) {
            if (r2 == null) goto L5;
            BitableToolboxPlugin.access$getMPanelActionListener$p(this.a).add(r2);
            return;
        }

        @Override // com.bytedance.ee.bear.bitable.toolbox.viewmodel.b
        public final void d(Function1<? super EPanelAction, Unit> r2) {
            if (r2 == null) goto L5;
            BitableToolboxPlugin.access$getMPanelActionListener$p(this.a).remove(r2);
            return;
        }

        @Override // com.bytedance.ee.bear.bitable.toolbox.viewmodel.b
        public final void handleOrientationState(boolean r3) {
            BaseUnspecifiedOrientationPlugin r0 = (BaseUnspecifiedOrientationPlugin) BitableToolboxPlugin.access$findPlugin(this.a, BaseUnspecifiedOrientationPlugin.class);
            if (r0 == null) goto L9;
            BitableToolboxPlugin r1 = this.a;
            if (r3 == false) goto L7;
            r0.onOrientationSupportPanelShowing(r1);
            return;
        L7:
            r0.onOrientationSupportPanelDismiss(r1);
            return;
        }

        @Override // com.bytedance.ee.bear.bitable.toolbox.viewmodel.b
        public final void c(EPanelOperationAction r4, JSONObject r5) {
            Intrinsics.checkNotNullParameter(r4, JSEventListener.ACTION);
            tt5.a.b(BitableToolboxPlugin.TAG, "triggerPanelOptAction()... action = " + r4);
            m r1 = BitableToolboxPlugin.access$getMPanelCallback$p(this.a);
            if (r1 == null) goto L6;
            JSONObject r2 = new JSONObject();
            r2.put(JSEventListener.ACTION, r4.getValue());
            r2.put("payload", r5);
            r1.b(r2);
            return;
        }

        @Override // com.bytedance.ee.bear.bitable.toolbox.viewmodel.b
        public final <T> Observable<T> b(EQueryType r6, JSONObject r7, Class<T> r8, Gson r9) {
            Intrinsics.checkNotNullParameter(r6, "queryType");
            Intrinsics.checkNotNullParameter(r8, "resultType");
            JSONObject r0 = new JSONObject();
            PanelData r1 = (PanelData) BitableToolboxPlugin.access$getMToolboxViewModel(this.a).getPanelData().getValue();
            String r2 = null;
            if (r1 == null) goto L5;
            String r3 = r1.getBaseId();
        L6:
            r0.put("baseId", r3);
            if (r1 == null) goto L9;
            String r4 = r1.getTableId();
        L10:
            r0.put("tableId", r4);
            if (r1 == null) goto L13;
            r2 = r1.getViewId();
        L13:
            r0.put("viewId", r2);
            if (r7 == null) goto L16;
            r0.putAll(r7);
        L16:
            int r10 = nr4.a.a;
            return nr4.a.a(BitableToolboxPlugin.access$getWeb(this.a), r6, r0, r8, r9);
        L9:
            r4 = null;
            goto L10
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class g implements View.OnTouchListener {
        public final /* synthetic */ BitableToolboxPlugin a;

        public g(BitableToolboxPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            BitableToolboxPlugin.access$getMToolboxViewModel(this.a).notifyWebTouchEvent(r2);
            return false;
        }
    }

    public static final class h implements com.bytedance.ee.bear.bitable.a {
        public final /* synthetic */ BitableToolboxPlugin a;

        public static final class a<T, R> implements Function {
            public final /* synthetic */ Function1<String, T> a;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Function1<? super String, ? extends T> r1) {
                this.a = r1;
            }

            public final Object apply(Object r3) {
                BitableAsyncResponse r4 = (BitableAsyncResponse) r3;
                Intrinsics.checkNotNullParameter(r4, "it");
                return this.a.invoke(GsonProtectorUtils.toJson(new Gson(), r4.getData()));
            }
        }

        public h(BitableToolboxPlugin r1) {
            this.a = r1;
        }

        public final <T> Single<T> a(BitableAsyncRequestBiz r4, String r5, String r6, String r7, Map<String, ? extends Object> r8, Function1<? super String, ? extends T> r9) {
            Intrinsics.checkNotNullParameter(r4, "biz");
            Intrinsics.checkNotNullParameter(r5, "router");
            Intrinsics.checkNotNullParameter(r6, "baseId");
            Intrinsics.checkNotNullParameter(r7, "tableId");
            Intrinsics.checkNotNullParameter(r8, "data");
            Intrinsics.checkNotNullParameter(r9, "parser");
            AsyncBitableJsBridgePlugin r0 = BitableToolboxPlugin.access$findPlugin(this.a, AsyncBitableJsBridgePlugin.class);
            if (r0 == null) goto L10;
            BitableAsyncRequest r2 = new BitableAsyncRequest();
            r2.setBiz(r4.getValue());
            r2.setRouter(r5);
            r2.setBaseId(r6);
            r2.setTableId(r7);
            r2.setData(r8);
            Observable r10 = AsyncBitableJsBridgePlugin.beginJsRequest$default(r0, r2, null, 2, null);
            if (r10 == null) goto L11;
            Observable r11 = r10.map(new a(r9));
            if (r11 != null) goto L9;
            return null;
        L9:
            return r11.singleOrError();
        L11:
            return null;
        L10:
            return null;
        }
    }

    public static final class i implements FabVisibilityController.a {
        public final /* synthetic */ BitableToolboxPlugin a;

        public i(BitableToolboxPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.fab.FabVisibilityController.a
        public final void a(boolean r2) {
            BitableToolboxPlugin.access$setFabRequestedVisible(this.a, r2);
        }
    }

    public void hideToolBarFragment() {
        setCurrentPluginFragmentVisible(false);
        setFabRequestedVisible(false);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return true;
    }

    public void showToolBarFragment() {
        setCurrentPluginFragmentVisible(true);
        setFabRequestedVisible(true);
    }

    static {
        Companion = new a();
        MENU_PANEL_MAP = MapsKt.mapOf(new Pair[]{TuplesKt.to(EToolbarMenu.FILTER, BitableFilterPanel.class), TuplesKt.to(EToolbarMenu.SORT, BitableSortPanel.class)});
    }

    private final com.bytedance.ee.bear.bitable.toolbox.viewmodel.b createPanelDelegate() {
        return new f(this);
    }

    private final void createToolboxFragmentIfNeeded() {
        Fragment r1 = null;
        if (this.tryFixBitableToolboxNotFindView == false) goto L15;
        t r0 = getUIContainer();
        if (r0 == null) goto L11;
        ViewGroup r2 = getUIContainer().c(this);
        if (r2 == null) goto L9;
        int r3 = r2.getId();
    L10:
        View r4 = r0.findView(r3);
    L12:
        if (r4 != null) goto L15;
        logDetail("createToolboxFragmentIfNeeded. cannot find view.");
        return;
    L9:
        r3 = -1;
        goto L10
    L11:
        r4 = null;
    L15:
        t r5 = getUIContainer();
        if (r5 == null) goto L18;
        r1 = r5.l(this);
    L18:
        if (r1 != null) goto L21;
        logDetail("createToolboxFragmentIfNeeded");
        addOrReplaceFragment(BitableToolboxFragment.class);
        getWeb().addOnTouchListener(this.mWebTouchListener);
        return;
    }

    private final BitableToolboxViewModel getMToolboxViewModel() {
        return (BitableToolboxViewModel) this.mToolboxViewModel$delegate.getValue();
    }

    private final void stopObservingBottomPanelHeight() {
        if (this.observingSheetBottomPanelHeight == false) goto L6;
        CopyOnWriteArrayList<ew4.a> r0 = h0.a;
        e r1 = this.bottomPanelHeightListener;
        Intrinsics.checkNotNullParameter(r1, "listener");
        h0.a.remove(r1);
        this.observingSheetBottomPanelHeight = false;
    L6:
        if (this.observingOfficeBaseBottomPanelHeight == false) goto L12;
        com.bytedance.ee.bear.bitable.core.bottompanel.a r2 = this.officeBaseBottomPanelAbility;
        if (r2 == null) goto L10;
        r2.L4(this.bottomPanelHeightListener);
    L10:
        this.observingOfficeBaseBottomPanelHeight = false;
    L12:
        if (this.observingBitableBottomPanelHeight == false) goto L17;
        x r3 = this.bitableFabConfig;
        if (r3 == null) goto L16;
        r3.g1(this.bottomPanelHeightListener);
    L16:
        this.observingBitableBottomPanelHeight = false;
    L17:
        this.officeBaseBottomPanelAbility = null;
        this.bitableFabConfig = null;
    }

    public BitableToolboxPlugin() {
        this.mToolboxViewModel$delegate = LazyKt.lazy(new BitableToolboxPlugin$mToolboxViewModel$2(this));
        this.mPanelActionListener = new ArrayList();
        this.panelActionHandlerList = new ArrayList();
        int r0 = com.bytedance.ee.bear.bitable.c.a;
        int r1 = n.a;
        this.tryFixBitableToolboxNotFindView = com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.fix_toolbox_not_find_view");
        this.bottomPanelHeightListener = new e(this);
        this.mWebTouchListener = new g(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void observeBottomPanelHeight() {
        stopObservingBottomPanelHeight();
        com.bytedance.ee.bear.bitable.core.basemain.ability.b r0 = getHostAbilityOrNull(com.bytedance.ee.bear.bitable.core.basemain.ability.b.class);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L14;
        this.observingSheetBottomPanelHeight = true;
        CopyOnWriteArrayList<ew4.a> r2 = h0.a;
        e r3 = this.bottomPanelHeightListener;
        Intrinsics.checkNotNullParameter(r3, "listener");
        CopyOnWriteArrayList<ew4.a> r4 = h0.a;
        if (r4.contains(r3) == true) goto L12;
        r4.add(r3);
    L12:
        r3.a(0);
        r3.b(h0.b);
        return;
    L14:
        com.bytedance.ee.bear.bitable.core.bottompanel.a r5 = getHostAbilityOrNull(com.bytedance.ee.bear.bitable.core.bottompanel.a.class);
        this.officeBaseBottomPanelAbility = r5;
        if (r5 == null) goto L18;
        this.observingOfficeBaseBottomPanelHeight = true;
        r5.u9(this.bottomPanelHeightListener);
        return;
    L18:
        x r6 = (x) ((DocumentPluginHost) getHost()).getUserComponent().a(x.class);
        this.bitableFabConfig = r6;
        if (r6 == null) goto L22;
        this.observingBitableBottomPanelHeight = true;
        r6.j(this.bottomPanelHeightListener);
        getMToolboxViewModel().getBottomPanelHeight().setValue(Integer.valueOf(r6.s()));
        return;
    L22:
        return;
    L5:
        if (r0.D3() != true) goto L7;
        r1 = true;
        goto L8
    }

    private final void removeToolboxFragmentIfNeeded() {
        Object[] r0 = (Object[]) getMToolboxViewModel().getFabData().getValue();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L27;
        ToolbarData r3 = (ToolbarData) getMToolboxViewModel().getToolbarData().getValue();
        if (r3 == null) goto L16;
        ToolbarData.MenuItem[] r4 = r3.getMenus();
    L17:
        if (r4 != null) goto L19;
    L23:
        r1 = true;
    L24:
        if (r1 == false) goto L28;
        logDetail("removeToolboxFragmentIfNeeded");
        removeFragment();
        getWeb().removeOnTouchListener(this.mWebTouchListener);
        return;
    L28:
        return;
    L19:
        if (r4.length != 0) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == false) goto L24;
    L21:
        r5 = false;
        goto L22
    L16:
        r4 = null;
        goto L17
    L27:
        return;
    L5:
        if (r0.length != 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L11;
        r2 = false;
        goto L12
    L7:
        r6 = false;
        goto L8
    }

    private final void updateFabVisibility() {
        MutableLiveData<Boolean> r0 = getMToolboxViewModel().getFabVisible();
        if (this.fabRequestedVisible == true) goto L5;
    L9:
        boolean r1 = false;
    L10:
        r0.setValue(Boolean.valueOf(r1));
        return;
    L5:
        if (this.aiChatListExpanded == true) goto L9;
        if (this.fabRequestedHide == true) goto L9;
        r1 = true;
        goto L10
    }

    public final boolean isFabCreateUseCacheRender() {
        BitableFabModel.BitableFabItem[] r0 = (BitableFabModel.BitableFabItem[]) getMToolboxViewModel().getFabData().getValue();
        if (r0 == null) goto L15;
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L19;
        BitableFabModel.BitableFabItem r4 = r0[r3];
        if (Intrinsics.areEqual(r4.getId(), "createRecord") == true) goto L9;
    L11:
        boolean r5 = false;
    L12:
        if (r5 == true) goto L13;
        r3 = r3 + 1;
        goto L5
    L13:
        return true;
    L9:
        if (r4.fromCache == false) goto L11;
        r5 = true;
        goto L12
    L19:
        return false;
    L15:
        return false;
    }

    public static final /* synthetic */ Map access$getMENU_PANEL_MAP$cp() {
        return MENU_PANEL_MAP;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.bitable.toolbox.viewmodel.b access$createPanelDelegate(BitableToolboxPlugin r0) {
        return r0.createPanelDelegate();
    }

    public static final /* synthetic */ void access$createToolboxFragmentIfNeeded(BitableToolboxPlugin r0) {
        r0.createToolboxFragmentIfNeeded();
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(BitableToolboxPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ FragmentManager access$getFragmentManager(BitableToolboxPlugin r0) {
        return r0.getFragmentManager();
    }

    public static final /* synthetic */ List access$getMPanelActionListener$p(BitableToolboxPlugin r0) {
        return r0.mPanelActionListener;
    }

    public static final /* synthetic */ m access$getMPanelCallback$p(BitableToolboxPlugin r0) {
        return r0.mPanelCallback;
    }

    public static final /* synthetic */ BitableToolboxViewModel access$getMToolboxViewModel(BitableToolboxPlugin r0) {
        return r0.getMToolboxViewModel();
    }

    public static final /* synthetic */ List access$getPanelActionHandlerList$p(BitableToolboxPlugin r0) {
        return r0.panelActionHandlerList;
    }

    public static final /* synthetic */ k access$getWeb(BitableToolboxPlugin r0) {
        return r0.getWeb();
    }

    public static final /* synthetic */ void access$removeToolboxFragmentIfNeeded(BitableToolboxPlugin r0) {
        r0.removeToolboxFragmentIfNeeded();
    }

    public static final /* synthetic */ void access$updateFabVisibility(BitableToolboxPlugin r0) {
        r0.updateFabVisibility();
    }

    private final void logDetail(String r3) {
        if (this.tryFixBitableToolboxNotFindView == true) goto L6;
        return;
    L6:
        if (isUIContainerAttached() == true) goto L8;
        return;
    L8:
        StringBuilder r0 = new StringBuilder("msg:");
        r0.append(r3);
        r0.append(". uiContainerId:");
        t r4 = getUIContainer();
        Integer r1 = null;
        if (r4 == null) goto L11;
        Integer r5 = Integer.valueOf(r4.hashCode());
    L12:
        r0.append(r5);
        r0.append(". viewId:");
        t r6 = getUIContainer();
        if (r6 == null) goto L17;
        ViewGroup r7 = r6.c(this);
        if (r7 == null) goto L17;
        r1 = Integer.valueOf(r7.getId());
    L17:
        r0.append(r1);
        r0.append(", pluginId:");
        r0.append(hashCode());
        tt5.a.h(TAG, r0.toString());
        return;
    L11:
        r5 = null;
        goto L12
    }

    private final void setCurrentPluginFragmentVisible(boolean r4) {
        tt5.a.h(TAG, "setCurrentPluginFragmentVisible>>>" + r4);
        t r0 = getUIContainer();
        if (r0 == null) goto L11;
        Fragment r2 = r0.l(this);
        FragmentManager r1 = r0.getFragmentManager();
        if (r2 == null) goto L9;
        if (r1 == null) goto L9;
        com.bytedance.ee.bear.bitable.utils.e.a(r4, r2, r1);
        return;
    L9:
        tt5.a.k(TAG, "unable to setCurrentPluginFragmentVisible fragment is null");
        return;
    L11:
        tt5.a.k(TAG, "unable to setCurrentPluginFragmentVisible uiContainer: " + getUIContainer());
    }

    private final void setFabRequestedVisible(boolean r1) {
        this.fabRequestedVisible = r1;
        updateFabVisibility();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put(BIZ_SET_FAB_BUTTONS, new b(this));
        r3.put(BIZ_PERFORM_PANELS_ACTION, new d(this));
    }

    public void onAttachToHost(DocumentPluginHost r2) {
        super.onAttachToHost(r2);
        getMToolboxViewModel().setWebService(getWeb());
        getMToolboxViewModel().setAsyncRequestDelegate(new h(this));
        ((FabVisibilityController) viewModel(FabVisibilityController.class)).setDelegate(new i(this));
    }

    public void onDetachFromHost(DocumentPluginHost r3) {
        stopObservingBottomPanelHeight();
        super.onDetachFromHost(r3);
        getMToolboxViewModel().setWebService(null);
        View.OnTouchListener r0 = this.mWebTouchListener;
        if (r0 == null) goto L10;
        if (r3 == null) goto L8;
        k r4 = r3.getWeb();
        if (r4 == null) goto L8;
        r4.removeOnTouchListener(r0);
    L8:
        this.mWebTouchListener = null;
        return;
    }

    public final void registerPannelActionHandler(c r2) {
        Intrinsics.checkNotNullParameter(r2, "panelActionHandler");
        if (this.panelActionHandlerList.contains(r2) == true) goto L6;
        this.panelActionHandlerList.add(r2);
        return;
    }

    public final void setFabRequestedHide(boolean r2) {
        if (this.fabRequestedHide == r2) goto L6;
        this.fabRequestedHide = r2;
        updateFabVisibility();
        return;
    }

    public final void setPanelCallback(m r1) {
        this.mPanelCallback = r1;
    }

    public final void setToolBoxVMPanelData(PanelData r2) {
        Intrinsics.checkNotNullParameter(r2, "panelData");
        getMToolboxViewModel().getPanelData().setValue(r2);
    }

    public final void unRegisterPannelActionHandler(c r2) {
        Intrinsics.checkNotNullParameter(r2, "panelActionHandler");
        if (this.panelActionHandlerList.contains(r2) == false) goto L6;
        this.panelActionHandlerList.remove(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$findPlugin(BitableToolboxPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ Fragment access$instantiateFragment(BitableToolboxPlugin r0, Class r1) {
        return r0.instantiateFragment(r1);
    }

    public static final /* synthetic */ void access$setAiChatListExpanded$p(BitableToolboxPlugin r0, boolean r1) {
        r0.aiChatListExpanded = r1;
    }

    public static final /* synthetic */ void access$setFabRequestedVisible(BitableToolboxPlugin r0, boolean r1) {
        r0.setFabRequestedVisible(r1);
    }

    public static final /* synthetic */ void access$setMPanelCallback$p(BitableToolboxPlugin r0, m r1) {
        r0.mPanelCallback = r1;
    }

    public static final /* synthetic */ ViewModel access$viewModel(BitableToolboxPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        observeBottomPanelHeight();
        logDetail("onAttachToUIContainer");
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        stopObservingBottomPanelHeight();
        super.onDetachFromUIContainer(r1, r2);
        this.fabRequestedVisible = false;
        this.aiChatListExpanded = false;
        this.fabRequestedHide = false;
        getMToolboxViewModel().getFabData().setValue(null);
        getMToolboxViewModel().getToolbarData().setValue(null);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
