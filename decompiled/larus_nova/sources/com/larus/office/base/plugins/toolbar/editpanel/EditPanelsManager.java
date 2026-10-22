package com.larus.office.base.plugins.toolbar.editpanel;

import android.R;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ee.docsdk.impl.utils.keyboard.KeyboardHeightObserver;
import com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider;
import com.google.gson.JsonObject;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.bridge.IBridge;
import com.ss.android.lark.chameleon.util.MainLooper;
import java.lang.ref.WeakReference;
import java.util.Stack;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 52\u00020\u00012\u00020\u0002:\u000256B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000eJ\u0006\u0010#\u001a\u00020\u001fJ\u0012\u0010$\u001a\u00020\u001f2\b\b\u0002\u0010%\u001a\u00020&H\u0007J\u0010\u0010'\u001a\u00020\u001f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010(\u001a\u00020\u001f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010)\u001a\u00020\u001f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010*\u001a\u00020\u001f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010,J\u0018\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u0016H\u0002J\u0010\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0016H\u0002J \u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00104\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00060\u0018R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/editpanel/EditPanelsManager;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/KeyboardHeightObserver;", "<init>", "()V", "bridge", "Lcom/ss/android/lark/chameleon/bridge/IBridge;", "keyboardHeight", "", "bottomPanelTop", "contentView", "Landroid/view/View;", "activeEditPanelStack", "Ljava/util/Stack;", "Lcom/larus/office/base/plugins/toolbar/editpanel/EditPanel;", "activeEditPanel", "Landroidx/lifecycle/MutableLiveData;", "lastActiveEditPanel", "keyboardHeightProviderRef", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/provider/KeyboardHeightProvider;", "scrollWebViewWhenKeyboardHeightChange", "", "keyBoardStatusChangedHandler", "Lcom/larus/office/base/plugins/toolbar/editpanel/EditPanelsManager$KeyBoardStatusChangedHandler;", "updateJSKeyboardStateTask", "Ljava/lang/Runnable;", "docToolbarV2Compat", "Lcom/larus/office/base/plugins/toolbar/IDocToolbarV2Compat;", "mNeedSetPanelHeight", "registerEditPanel", "", "editPanelLife", "Landroidx/lifecycle/LifecycleOwner;", "editPanel", "forceCloseToolbarV2", "requestUpdateWebContentHeight", "delay", "", "setDocToolbarV2Compat", "setContentView", "attachBridge", "detachBridge", "getActiveEditPanel", "Landroidx/lifecycle/LiveData;", "updateActivePanel", "panel", "active", "getBottomPanelTop", "forceClose", "onKeyboardHeightChanged", "khp", "orientation", "Companion", "KeyBoardStatusChangedHandler", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EditPanelsManager extends ViewModel implements KeyboardHeightObserver {
    private static String BIZ_UTIL_KEY_BOARD_STATUS_CHANGED = null;
    public static final a Companion = null;
    private static final String TAG = "EditPanelsManager";
    private MutableLiveData<fn9.a> activeEditPanel;
    private final Stack<fn9.a> activeEditPanelStack;
    private int bottomPanelTop;
    private IBridge bridge;
    private View contentView;
    private com.larus.office.base.plugins.toolbar.a docToolbarV2Compat;
    private final b keyBoardStatusChangedHandler;
    private int keyboardHeight;
    private WeakReference<KeyboardHeightProvider> keyboardHeightProviderRef;
    private fn9.a lastActiveEditPanel;
    private boolean mNeedSetPanelHeight;
    private boolean scrollWebViewWhenKeyboardHeightChange;
    private final Runnable updateJSKeyboardStateTask;

    public static final class a {
        public a() {
        }
    }

    public final class b implements BridgeHandlerV2<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CallBackFunction f360856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EditPanelsManager f360857b;

        public b(EditPanelsManager r100) {
            this.f360857b = r100;
        }

        public final void a(boolean r110) {
            if (this.f360856a != null) goto L5;
            return;
        L5:
            if (EditPanelsManager.access$getBridge$p(this.f360857b) == null) goto L99;
            View r100 = EditPanelsManager.access$getContentView$p(this.f360857b);
            if (r100 == null) goto L10;
            View r101 = r100.getRootView();
        L11:
            if (r101 != null) goto L13;
            return;
        L13:
            LiveData<fn9.a> r102 = this.f360857b.getActiveEditPanel();
            if (r102 == null) goto L16;
            fn9.a r103 = r102.getValue();
        L18:
            if (r103 == null) goto L20;
            String r104 = r103.getPanelName();
        L21:
            View r105 = EditPanelsManager.access$getContentView$p(this.f360857b);
            int[] r106 = new int[2];
            if (r105 == null) goto L24;
            r105.getLocationOnScreen(r106);
        L24:
            int r107 = 1;
            int r108 = r106[1];
            int r109 = EditPanelsManager.access$getBottomPanelTop(this.f360857b, r110);
            if (r109 > 0) goto L34;
            if (r105 == null) goto L30;
            View r111 = r105.getRootView();
            if (r111 == null) goto L30;
            View r112 = r111.findViewById(R.id.content);
        L31:
            if (r112 != null) goto L33;
            int r113 = -1;
        L50:
            if (r113 != (-1)) goto L52;
            return;
        L52:
            com.larus.office.base.plugins.toolbar.a r114 = EditPanelsManager.access$getDocToolbarV2Compat$p(this.f360857b);
            if (r114 != null) goto L55;
        L57:
            boolean r115 = false;
        L59:
            if (EditPanelsManager.access$getKeyboardHeight$p(this.f360857b) <= 0) goto L61;
        L65:
            FLogger r116 = FLogger.f375446a;
            r116.i(EditPanelsManager.TAG, "activeEditPanel=" + EditPanelsManager.access$getActiveEditPanel$p(this.f360857b) + ", type=" + r104 + "; last active panel: " + EditPanelsManager.access$getLastActiveEditPanel$p(this.f360857b));
            fn9.a r117 = EditPanelsManager.access$getLastActiveEditPanel$p(this.f360857b);
            if (r117 == null) goto L83;
            String r118 = r117.getPanelName();
            if (r107 != 0) goto L83;
            if (Intrinsics.areEqual(r104, "editor") == false) goto L83;
            if (TextUtils.equals(r118, "equation") == false) goto L74;
        L81:
            r116.i(EditPanelsManager.TAG, "using hideKeyboardType " + r118);
            r104 = r118;
            goto L83
        L74:
            if (TextUtils.equals(r118, "comment") == true) goto L81;
            if (TextUtils.equals(r118, ObricActionBarTrackType.KEY_BOARD) == true) goto L81;
            if (TextUtils.equals(r118, "sheetCellContent") == true) goto L81;
            if (TextUtils.equals(r118, "dropdown") == true) goto L81;
        L83:
            if (Intrinsics.areEqual(r104, ObricActionBarTrackType.KEY_BOARD) == false) goto L87;
            r113 = UIUtils.px2dip(AppHost.f326268a.getApplication(), EditPanelsManager.access$getKeyboardHeight$p(this.f360857b));
            if (EditPanelsManager.access$getKeyboardHeight$p(this.f360857b) != 0) goto L87;
            r107 = 0;
        L87:
            JsonObject r119 = new JsonObject();
            if (r110 == false) goto L90;
            r119.addProperty("isOpenKeyboard", 0);
        L93:
            r119.addProperty("innerHeight", Integer.valueOf(r113));
            r119.addProperty("keyboardType", r104);
            r116.i(EditPanelsManager.TAG, "Notify js keyboard: " + r119 + " keyboard height: " + EditPanelsManager.access$getKeyboardHeight$p(this.f360857b) + " isShowingFunctionPanel:" + r115);
            CallBackFunction r120 = this.f360856a;
            if (r120 == null) goto L96;
            r120.onCallBack(r119);
        L96:
            EditPanelsManager.access$setLastActiveEditPanel$p(this.f360857b, null);
            return;
        L90:
            r119.addProperty("isOpenKeyboard", Integer.valueOf(r107));
            if (r115 == false) goto L93;
            r119.addProperty("toolbar_v2_compat", Boolean.valueOf(r115));
            goto L93
        L61:
            if (Intrinsics.areEqual(r104, "comment") == true) goto L64;
            if (r103 != null) goto L65;
        L64:
            r107 = 0;
            goto L65
        L55:
            if (r114.isShowingFunctionPanel() != true) goto L57;
            r115 = true;
            goto L59
        L33:
            int[] r121 = new int[2];
            r112.getLocationOnScreen(r121);
            r109 = r112.getHeight() + r121[1];
        L30:
            r112 = null;
        L34:
            FLogger r122 = FLogger.f375446a;
            r122.i(EditPanelsManager.TAG, "getWebRemainingHeight: panelTop " + r109);
            int r123 = r109 - r108;
            if (r103 == null) goto L46;
            View r124 = EditPanelsManager.access$getContentView$p(this.f360857b);
            if (r124 == null) goto L39;
            int r125 = r103.getPanelHeight(r124.getContext());
        L40:
            if (r125 == 0) goto L42;
        L44:
            r123 = r123 - r125;
        L49:
            r113 = UIUtils.px2dip(AppHost.f326268a.getApplication(), r123);
            goto L50
        L42:
            if (Intrinsics.areEqual("editor", r104) == false) goto L44;
            View r126 = EditPanelsManager.access$getContentView$p(this.f360857b);
            Intrinsics.checkNotNull(r126);
            r125 = r126.getContext().getResources().getDimensionPixelSize(com.larus.nova.R.dimen.dp_60);
            goto L44
        L39:
            r125 = 0;
            goto L40
        L46:
            if (EditPanelsManager.access$getKeyboardHeight$p(this.f360857b) <= 0) goto L48;
            View r127 = EditPanelsManager.access$getContentView$p(this.f360857b);
            Intrinsics.checkNotNull(r127);
            r123 = r123 - r127.getContext().getResources().getDimensionPixelSize(com.larus.nova.R.dimen.dp_60);
        L48:
            r122.w(EditPanelsManager.TAG, "no active panel !");
            goto L49
        L20:
            r104 = "editor";
            goto L21
        L16:
            r103 = null;
            goto L18
        L10:
            r101 = null;
            goto L11
        }

        @Override // com.ss.android.lark.chameleon.bridge.JSHandler
        public final void handle(Object r100, CallBackFunction r101) {
            Void r102 = (Void) r100;
            this.f360856a = r101;
        }
    }

    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f360858a;

        public c(fn9.c r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f360858a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f360858a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f360858a.invoke(r100);
        }
    }

    public static /* synthetic */ void Mo(EditPanelsManager r100) {
        updateJSKeyboardStateTask$lambda$0(r100);
    }

    public static /* synthetic */ Unit yo(fn9.a r100, EditPanelsManager r101, Boolean r102) {
        return registerEditPanel$lambda$1(r100, r101, r102);
    }

    public final void requestUpdateWebContentHeight() {
        requestUpdateWebContentHeight$default(this, 0, 1, null);
    }

    static {
        Companion = new a();
        BIZ_UTIL_KEY_BOARD_STATUS_CHANGED = "biz.util.onKeyboardChanged";
    }

    public final void forceCloseToolbarV2() {
        this.keyBoardStatusChangedHandler.a(true);
        if (this.activeEditPanelStack.isEmpty() == true) goto L6;
        updateActivePanel(this.activeEditPanelStack.peek(), false);
        return;
    }

    public final LiveData<fn9.a> getActiveEditPanel() {
        if (this.activeEditPanel != null) goto L6;
        this.activeEditPanel = new MutableLiveData();
    L6:
        return this.activeEditPanel;
    }

    public EditPanelsManager() {
        this.activeEditPanelStack = new Stack();
        this.scrollWebViewWhenKeyboardHeightChange = true;
        this.keyBoardStatusChangedHandler = new b(this);
        this.updateJSKeyboardStateTask = new fn9.b(this);
        this.mNeedSetPanelHeight = true;
    }

    public static final /* synthetic */ MutableLiveData access$getActiveEditPanel$p(EditPanelsManager r100) {
        return r100.activeEditPanel;
    }

    public static final /* synthetic */ IBridge access$getBridge$p(EditPanelsManager r100) {
        return r100.bridge;
    }

    public static final /* synthetic */ View access$getContentView$p(EditPanelsManager r100) {
        return r100.contentView;
    }

    public static final /* synthetic */ com.larus.office.base.plugins.toolbar.a access$getDocToolbarV2Compat$p(EditPanelsManager r100) {
        return r100.docToolbarV2Compat;
    }

    public static final /* synthetic */ int access$getKeyboardHeight$p(EditPanelsManager r100) {
        return r100.keyboardHeight;
    }

    public static final /* synthetic */ fn9.a access$getLastActiveEditPanel$p(EditPanelsManager r100) {
        return r100.lastActiveEditPanel;
    }

    private final int getBottomPanelTop(boolean r100) {
        if (r100 == false) goto L5;
        return 0;
    L5:
        WeakReference<KeyboardHeightProvider> r101 = this.keyboardHeightProviderRef;
        if (r101 == null) goto L12;
        KeyboardHeightProvider r102 = r101.get();
        if (r102 == null) goto L12;
        return r102.getKeyboardTop();
    L12:
        return this.bottomPanelTop;
    }

    private static final void updateJSKeyboardStateTask$lambda$0(EditPanelsManager r100) {
        r100.keyBoardStatusChangedHandler.a(false);
    }

    public final void attachBridge(IBridge r100) {
        this.bridge = r100;
        if (r100 == null) goto L6;
        r100.bindBridgeHandler(BIZ_UTIL_KEY_BOARD_STATUS_CHANGED, this.keyBoardStatusChangedHandler);
        return;
    }

    public final void detachBridge(IBridge r100) {
        if (r100 != this.bridge) goto L5;
        this.bridge = null;
    L5:
        if (r100 == null) goto L7;
        r100.unbindBridgeHandler(BIZ_UTIL_KEY_BOARD_STATUS_CHANGED);
    L7:
        MainLooper.removeCallbacks(this.updateJSKeyboardStateTask);
        this.contentView = null;
        WeakReference<KeyboardHeightProvider> r101 = this.keyboardHeightProviderRef;
        if (r101 == null) goto L10;
        r101.clear();
    L10:
        this.keyboardHeightProviderRef = null;
        this.activeEditPanelStack.clear();
        MutableLiveData<fn9.a> r102 = this.activeEditPanel;
        if (r102 == null) goto L14;
        r102.setValue(null);
        return;
    }

    public final void requestUpdateWebContentHeight(long r100) {
        FLogger.f375446a.i(TAG, "requestUpdateWebContentHeight");
        MainLooper.removeCallbacks(this.updateJSKeyboardStateTask);
        MainLooper.postDelayed(this.updateJSKeyboardStateTask, r100);
    }

    public final void setContentView(View r100) {
        this.contentView = r100;
    }

    public final void setDocToolbarV2Compat(com.larus.office.base.plugins.toolbar.a r100) {
        this.docToolbarV2Compat = r100;
    }

    public static final /* synthetic */ int access$getBottomPanelTop(EditPanelsManager r100, boolean r101) {
        return r100.getBottomPanelTop(r101);
    }

    public static final /* synthetic */ void access$setLastActiveEditPanel$p(EditPanelsManager r100, fn9.a r101) {
        r100.lastActiveEditPanel = r101;
    }

    private final void updateActivePanel(fn9.a r100, boolean r101) {
        fn9.a r102 = null;
        if (this.activeEditPanelStack.isEmpty() == false) goto L5;
        fn9.a r103 = null;
    L6:
        if (r101 == false) goto L9;
        this.lastActiveEditPanel = r103;
        this.activeEditPanelStack.remove(r100);
        this.activeEditPanelStack.push(r100);
    L12:
        if (this.activeEditPanelStack.isEmpty() == true) goto L15;
        r102 = this.activeEditPanelStack.peek();
    L15:
        LiveData<fn9.a> r104 = getActiveEditPanel();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.larus.office.base.plugins.toolbar.editpanel.EditPanel?>");
        MutableLiveData r105 = (MutableLiveData) r104;
        fn9.a r106 = (fn9.a) r105.getValue();
        if (r106 != null) goto L18;
        if (r102 == null) goto L18;
    L21:
        boolean r107 = true;
    L23:
        if (r107 == false) goto L32;
        FLogger.f375446a.i(TAG, "active panel changed to :" + r102);
        r105.setValue(r102);
        if (r101 == false) goto L29;
        r100.onBecomeActive(this, r106);
        if (r106 == null) goto L30;
        r106.onBecomeInactive(this, r100);
    L30:
        requestUpdateWebContentHeight(200);
        return;
    L29:
        r100.onBecomeInactive(this, r102);
        goto L30
    L32:
        return;
    L18:
        if (r106 != null) goto L20;
    L22:
        r107 = false;
        goto L23
    L20:
        if (Intrinsics.areEqual(r106, r102) == true) goto L22;
    L9:
        if (this.activeEditPanelStack.remove(r100) == false) goto L12;
        this.lastActiveEditPanel = r103;
        goto L12
    L5:
        r103 = this.activeEditPanelStack.peek();
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [fn9.c] */
    public final void registerEditPanel(LifecycleOwner r100, final fn9.a r101) {
        Intrinsics.checkNotNullParameter(r100, "editPanelLife");
        Intrinsics.checkNotNullParameter(r101, "editPanel");
        LiveData<Boolean> r102 = r101.getActive();
        if (r102 == null) goto L5;
        r102.observe(r100, new c(new fn9.c(r101, this)));
    L5:
        r100.getLifecycle().addObserver(new AnonymousClass2(this, r101));
    }

    public static final /* synthetic */ void access$updateActivePanel(EditPanelsManager r100, fn9.a r101, boolean r102) {
        r100.updateActivePanel(r101, r102);
    }

    private static final Unit registerEditPanel$lambda$1(fn9.a r100, EditPanelsManager r101, Boolean r102) {
        FLogger.f375446a.i(TAG, "onActiveChanged:" + r102 + ", " + r100.getClass().getSimpleName());
        r101.updateActivePanel(r100, Intrinsics.areEqual(Boolean.TRUE, r102));
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.KeyboardHeightObserver
    public void onKeyboardHeightChanged(KeyboardHeightProvider r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "khp");
        this.keyboardHeight = r101;
        this.bottomPanelTop = r100.getKeyboardTop();
        this.keyboardHeightProviderRef = new WeakReference(r100);
        FLogger.f375446a.i(TAG, "onKeyboardHeightChanged: keyboardHeight = " + r101 + ", bottomPanelTop = " + this.bottomPanelTop);
        if (this.scrollWebViewWhenKeyboardHeightChange == false) goto L6;
        requestUpdateWebContentHeight$default(this, 0, 1, null);
        return;
    }

    public static /* synthetic */ void requestUpdateWebContentHeight$default(EditPanelsManager r100, long r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = 0;
    L5:
        r100.requestUpdateWebContentHeight(r101);
    }
}
