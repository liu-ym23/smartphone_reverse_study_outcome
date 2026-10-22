package com.bytedance.ee.bear.document.toolbar.editpanels;

import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.edit.component.toolbar2.a0;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.j;
import com.obric.trace.ObricActionBarTrackType;
import g45.d;
import java.lang.ref.WeakReference;
import java.util.Stack;
import tb5.i;
import tb5.m;
import tb5.n;

/* JADX INFO: loaded from: classes16.dex */
public class EditPanelsManager extends ViewModel implements ocb.a, d {
    private static final String BIZ_UTIL_SET_PANEL_HEIGHT = "lark.biz.util.setPanelHeight";
    private static final String TAG = "EditPanelsManager";
    private MutableLiveData<g45.a> activeEditPanel;
    private final Stack<g45.a> activeEditPanelStack;
    private int bottomPanelTop;
    private n bridge;
    private View contentView;
    private a0 docToolbarV2Compat;
    private b keyBoardStatusChangedHandler;
    private int keyboardHeight;
    private WeakReference<pcb.a> keyboardHeightProviderRef;
    private g45.a lastActiveEditPanel;
    private String lastPanelName;
    private boolean mNeedSetPanelHeight;
    private c panelHeightDelegate;
    private boolean scrollWebViewWhenKeyboardHeightChange;
    private final Runnable updateJSKeyboardStateTask;

    public class a implements GenericLifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g45.a f222314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EditPanelsManager f222315b;

        public a(EditPanelsManager r100, g45.a r101) {
            this.f222315b = r100;
            this.f222314a = r101;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
            if (r101 != Lifecycle.Event.ON_DESTROY) goto L6;
            r100.getLifecycle().removeObserver(this);
            EditPanelsManager.access$100(this.f222315b, this.f222314a, false);
            return;
        }
    }

    public class b implements i<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m f222316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EditPanelsManager f222317b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(EditPanelsManager r100) {
            this.f222317b = r100;
        }

        public final void a(boolean r110) {
            if (this.f222316a != null) goto L7;
            tt5.a.h(EditPanelsManager.TAG, "notifyKeyboardChanged noop, callback is null");
            return;
        L7:
            if (EditPanelsManager.access$900(this.f222317b) != null) goto L11;
            tt5.a.h(EditPanelsManager.TAG, "notifyKeyboardChanged noop, bridge is null");
            return;
        L11:
            if (EditPanelsManager.access$800(this.f222317b) != null) goto L13;
        L95:
            tt5.a.h(EditPanelsManager.TAG, "notifyKeyboardChanged noop, contentView is null");
            return;
        L13:
            if (EditPanelsManager.access$800(this.f222317b).getRootView() == null) goto L95;
            g45.a r100 = this.f222317b.getActiveEditPanel().getValue();
            if (r100 == null) goto L18;
            String r101 = r100.getPanelName();
        L19:
            tt5.a.h(EditPanelsManager.TAG, "notifyKeyboardChanged: type = " + r101 + ", lastPanelName = " + EditPanelsManager.access$1000(this.f222317b));
            if (TextUtils.equals(r101, "search") == false) goto L22;
        L24:
            EditPanelsManager.access$1002(this.f222317b, r101);
            View r102 = EditPanelsManager.access$800(this.f222317b);
            int[] r103 = new int[2];
            r102.getLocationOnScreen(r103);
            int r104 = 1;
            int r105 = r103[1];
            int r106 = EditPanelsManager.access$500(this.f222317b, r110);
            if (r106 > 0) goto L30;
            View r107 = r102.getRootView().findViewById(R.id.content);
            if (r107 != null) goto L29;
            int r108 = -1;
        L48:
            if (r108 != (-1)) goto L50;
            return;
        L50:
            KeyboardShowingStatusMode r109 = KeyboardShowingStatusMode.FOLLOW_KEYBOARD;
            if (r100 == null) goto L54;
            r109 = r100.getKeyboardShowingStatusMode();
        L54:
            if (EditPanelsManager.access$400(this.f222317b) != null) goto L56;
        L58:
            boolean r111 = false;
        L60:
            if (EditPanelsManager.access$600(this.f222317b) <= 0) goto L62;
        L65:
            tt5.a.h(EditPanelsManager.TAG, "activeEditPanel > " + EditPanelsManager.access$200(this.f222317b) + " type > " + r101 + "; last active panel > " + EditPanelsManager.access$300(this.f222317b));
            if (EditPanelsManager.access$300(this.f222317b) == null) goto L83;
            String r112 = EditPanelsManager.access$300(this.f222317b).getPanelName();
            if (r104 != 0) goto L83;
            if (r101.equals("editor") == false) goto L83;
            if (TextUtils.equals(r112, "equation") == false) goto L74;
        L81:
            tt5.a.h(EditPanelsManager.TAG, "using hideKeyboardType " + r112);
            r101 = r112;
            goto L83
        L74:
            if (TextUtils.equals(r112, "comment") == true) goto L81;
            if (TextUtils.equals(r112, ObricActionBarTrackType.KEY_BOARD) == true) goto L81;
            if (TextUtils.equals(r112, "sheetCellContent") == true) goto L81;
            if (TextUtils.equals(r112, "dropdown") == true) goto L81;
        L83:
            if (r101.equals(ObricActionBarTrackType.KEY_BOARD) == false) goto L87;
            r108 = com.bytedance.ee.util.ui.n.E(EditPanelsManager.access$600(this.f222317b));
            if (EditPanelsManager.access$600(this.f222317b) != 0) goto L87;
            r104 = 0;
        L87:
            JSONObject r113 = new JSONObject();
            if (r110 == false) goto L90;
            r113.put2("isOpenKeyboard", 0);
        L93:
            r113.put2("innerHeight", Integer.valueOf(r108));
            r113.put2("keyboardType", r101);
            tt5.a.h(EditPanelsManager.TAG, "Notify js keyboard:" + r113.toString() + " keyboard height:" + EditPanelsManager.access$600(this.f222317b) + " isShowingFunctionPanel:" + r111 + " mode = " + r109 + " activePanel:" + EditPanelsManager.access$1100(this.f222317b) + " contentView:" + EditPanelsManager.access$1200(this.f222317b));
            this.f222316a.b(r113);
            EditPanelsManager.access$302(this.f222317b, null);
            return;
        L90:
            r113.put2("isOpenKeyboard", Integer.valueOf(r104));
            if (r111 == false) goto L93;
            r113.put2("toolbar_v2_compat", Boolean.valueOf(r111));
            goto L93
        L62:
            if (r109 == KeyboardShowingStatusMode.ALWAYS_SHOW) goto L65;
            r104 = 0;
            goto L65
        L56:
            if (EditPanelsManager.access$400(this.f222317b).isShowingFunctionPanel() == false) goto L58;
            r111 = true;
            goto L60
        L29:
            int[] r114 = new int[2];
            r107.getLocationOnScreen(r114);
            r106 = r114[1] + r107.getHeight();
        L30:
            tt5.a.h(EditPanelsManager.TAG, "getWebRemainingHeight: panelTop = " + r106 + ", webViewTop = " + r105 + ", keyboardHeight = " + EditPanelsManager.access$600(this.f222317b) + ", bottomPanelTop = " + EditPanelsManager.access$700(this.f222317b) + ", forceClose = " + r110 + ", type = " + r101);
            int r115 = r106 - r105;
            if (r100 == null) goto L44;
            int r116 = r100.getPanelHeight(EditPanelsManager.access$800(this.f222317b).getContext());
            tt5.a.h(EditPanelsManager.TAG, "getWebRemainingHeight: panelHeight " + r116);
            if (r116 != 0) goto L38;
            if ("editor".equals(r101) == false) goto L38;
            r116 = EditPanelsManager.access$800(this.f222317b).getContext().getResources().getDimensionPixelSize(com.larus.nova.R.dimen.core_toolbar_menu_height);
        L38:
            if (r116 > EditPanelsManager.access$600(this.f222317b)) goto L40;
        L42:
            r115 = r115 - r116;
        L47:
            r108 = com.bytedance.ee.util.ui.n.E(r115);
            goto L48
        L40:
            if (TextUtils.equals("oppanel", r100.getPanelName()) == false) goto L42;
            r116 = r116 - EditPanelsManager.access$600(this.f222317b);
            goto L42
        L44:
            if (EditPanelsManager.access$600(this.f222317b) <= 0) goto L46;
            r115 = r115 - EditPanelsManager.access$800(this.f222317b).getContext().getResources().getDimensionPixelSize(com.larus.nova.R.dimen.core_toolbar_menu_height);
        L46:
            tt5.a.k(EditPanelsManager.TAG, "no active panel !");
            goto L47
        L22:
            if (TextUtils.equals(EditPanelsManager.access$1000(this.f222317b), "search") == false) goto L24;
            rcb.c.d(EditPanelsManager.access$800(this.f222317b));
            goto L24
        L18:
            r101 = "editor";
            goto L19
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            Void r102 = (Void) r100;
            this.f222316a = r101;
        }
    }

    public interface c {
    }

    public static /* synthetic */ void Mo(EditPanelsManager r100, g45.a r101, Boolean r102) {
        r100.lambda$registerEditPanel$1(r101, r102);
    }

    public static /* synthetic */ void yo(EditPanelsManager r100) {
        r100.lambda$new$0();
    }

    public c getPanelHeightDelegate() {
        return null;
    }

    public void setPanelHeightDelegate(c r100) {
    }

    private String getContentViewDebugInfo() {
        if (this.contentView != null) goto L7;
        return "null";
    L7:
        return "hash=" + System.identityHashCode(this.contentView) + ", hasFocus=" + this.contentView.hasFocus() + ", isFocused=" + this.contentView.isFocused() + ", hasWindowFocus=" + this.contentView.hasWindowFocus() + ", windowVisibility=" + this.contentView.getWindowVisibility() + ", attached=" + this.contentView.isAttachedToWindow();
    }

    private void lambda$new$0() {
        this.keyBoardStatusChangedHandler.a(false);
    }

    public void forceCloseToolbarV2() {
        this.keyBoardStatusChangedHandler.a(true);
        if (this.activeEditPanelStack.isEmpty() == true) goto L6;
        updateActivePanel(this.activeEditPanelStack.peek(), false);
        return;
    }

    @Override // g45.d
    public LiveData<g45.a> getActiveEditPanel() {
        if (this.activeEditPanel != null) goto L6;
        this.activeEditPanel = new MutableLiveData();
    L6:
        return this.activeEditPanel;
    }

    @Override // g45.d
    public void requestUpdateWebContentHeight() {
        requestUpdateWebContentHeight(0);
    }

    public EditPanelsManager() {
        this.scrollWebViewWhenKeyboardHeightChange = true;
        this.updateJSKeyboardStateTask = new g45.b(this);
        this.mNeedSetPanelHeight = true;
        this.activeEditPanelStack = new Stack();
        this.keyBoardStatusChangedHandler = new b(this);
    }

    private String getActivePanelName() {
        g45.a r100 = getActiveEditPanel().getValue();
        if (r100 != null) goto L6;
        return "null";
    L6:
        return r100.getPanelName();
    }

    public n getBridge() {
        return this.bridge;
    }

    public static /* synthetic */ String access$1000(EditPanelsManager r100) {
        return r100.lastPanelName;
    }

    public static /* synthetic */ String access$1100(EditPanelsManager r100) {
        return r100.getActivePanelName();
    }

    public static /* synthetic */ String access$1200(EditPanelsManager r100) {
        return r100.getContentViewDebugInfo();
    }

    public static /* synthetic */ MutableLiveData access$200(EditPanelsManager r100) {
        return r100.activeEditPanel;
    }

    public static /* synthetic */ g45.a access$300(EditPanelsManager r100) {
        return r100.lastActiveEditPanel;
    }

    public static /* synthetic */ a0 access$400(EditPanelsManager r100) {
        return r100.docToolbarV2Compat;
    }

    public static /* synthetic */ int access$600(EditPanelsManager r100) {
        return r100.keyboardHeight;
    }

    public static /* synthetic */ int access$700(EditPanelsManager r100) {
        return r100.bottomPanelTop;
    }

    public static /* synthetic */ View access$800(EditPanelsManager r100) {
        return r100.contentView;
    }

    public static /* synthetic */ n access$900(EditPanelsManager r100) {
        return r100.bridge;
    }

    private int getBottomPanelTop(boolean r100) {
        if (r100 == false) goto L5;
        return 0;
    L5:
        WeakReference<pcb.a> r101 = this.keyboardHeightProviderRef;
        if (r101 == null) goto L12;
        if (r101.get() == null) goto L12;
        return this.keyboardHeightProviderRef.get().getKeyboardTop();
    L12:
        return this.bottomPanelTop;
    }

    public void attachBridge(n r100) {
        this.bridge = r100;
        r100.c("biz.util.onKeyboardChanged", this.keyBoardStatusChangedHandler);
    }

    public void detachBridge(n r100) {
        if (r100 != this.bridge) goto L5;
        this.bridge = null;
    L5:
        r100.b();
        j.e(this.updateJSKeyboardStateTask);
        WeakReference<pcb.a> r101 = this.keyboardHeightProviderRef;
        if (r101 == null) goto L8;
        r101.clear();
        this.keyboardHeightProviderRef = null;
    L8:
        this.activeEditPanelStack.clear();
        MutableLiveData<g45.a> r102 = this.activeEditPanel;
        if (r102 == null) goto L12;
        r102.setValue(null);
        return;
    }

    public void needSetPanelHeight(boolean r100) {
        this.mNeedSetPanelHeight = r100;
    }

    public void onConfigurationChanged(pcb.a r100) {
        this.bottomPanelTop = r100.getKeyboardTop();
        tt5.a.h(TAG, "onConfigurationChanged: bottomPanelTop = " + this.bottomPanelTop);
    }

    public void requestNotFocus(Context r100) {
        g45.a r101 = getActiveEditPanel().getValue();
        if (r101 == null) goto L6;
        r101.requestNotFocus(r100);
        return;
    }

    @Override // g45.d
    public void requestUpdateWebContentHeight(long r100) {
        tt5.a.i(TAG, "requestUpdateWebContentHeight, delay = " + r100 + ", keyboardHeight = " + this.keyboardHeight + ", bottomPanelTop = " + this.bottomPanelTop + ", activePanel = " + getActivePanelName() + ", contentView = " + getContentViewDebugInfo(), new Throwable());
        j.e(this.updateJSKeyboardStateTask);
        j.d(this.updateJSKeyboardStateTask, r100);
    }

    public void setContentView(View r100) {
        this.contentView = r100;
    }

    public void setDocToolbarV2Compat(a0 r100) {
        this.docToolbarV2Compat = r100;
    }

    public void setKeyboardHeightProviderRef(pcb.a r100) {
        this.keyboardHeightProviderRef = new WeakReference(r100);
    }

    public void setScrollWebViewWhenKeyboardHeightChange(boolean r100) {
        this.scrollWebViewWhenKeyboardHeightChange = r100;
    }

    public static /* synthetic */ String access$1002(EditPanelsManager r100, String r101) {
        r100.lastPanelName = r101;
        return r101;
    }

    public static /* synthetic */ g45.a access$302(EditPanelsManager r100, g45.a r101) {
        r100.lastActiveEditPanel = r101;
        return r101;
    }

    public static /* synthetic */ int access$500(EditPanelsManager r100, boolean r101) {
        return r100.getBottomPanelTop(r101);
    }

    private /* synthetic */ void lambda$registerEditPanel$1(g45.a r100, Boolean r101) {
        tt5.a.h(TAG, "onActiveChanged:" + r101 + ", " + r100.getClass().getSimpleName());
        updateActivePanel(r100, Boolean.TRUE.equals(r101));
    }

    private void updateActivePanel(g45.a r100, boolean r101) {
        g45.a r102 = null;
        if (this.activeEditPanelStack.isEmpty() == false) goto L5;
        g45.a r103 = null;
    L6:
        if (r101 == false) goto L9;
        this.lastActiveEditPanel = r103;
        this.activeEditPanelStack.remove(r100);
        this.activeEditPanelStack.push(r100);
    L12:
        if (this.activeEditPanelStack.isEmpty() == true) goto L15;
        r102 = this.activeEditPanelStack.peek();
    L15:
        MutableLiveData r104 = (MutableLiveData) getActiveEditPanel();
        g45.a r105 = (g45.a) r104.getValue();
        if (r105 != null) goto L18;
        if (r102 == null) goto L18;
    L21:
        boolean r106 = true;
    L23:
        if (r106 == false) goto L32;
        tt5.a.h(TAG, "active panel changed to :" + r102);
        r104.setValue(r102);
        if (r101 == false) goto L29;
        r100.onBecomeActive(this, r105);
        if (r105 == null) goto L30;
        r105.onBecomeInactive(this, r100);
    L30:
        requestUpdateWebContentHeight(200);
        return;
    L29:
        r100.onBecomeInactive(this, r102);
        goto L30
    L32:
        return;
    L18:
        if (r105 != null) goto L20;
    L22:
        r106 = false;
        goto L23
    L20:
        if (r105.equals(r102) == true) goto L22;
    L9:
        if (this.activeEditPanelStack.remove(r100) == false) goto L12;
        this.lastActiveEditPanel = r103;
        goto L12
    L5:
        r103 = this.activeEditPanelStack.peek();
        goto L6
    }

    @Override // g45.d
    public void registerEditPanel(LifecycleOwner r100, final g45.a r101) {
        r101.getActive().observe(r100, new g45.c(this, r101));
        r100.getLifecycle().addObserver(new a(this, r101));
    }

    public void setPanelHeight(int r100, String r101) {
        if (this.mNeedSetPanelHeight == true) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject();
        r102.put2("height", Integer.valueOf(r100));
        r102.put2("keyboardType", r101);
        n r103 = this.bridge;
        if (r103 == null) goto L8;
        r103.a(BIZ_UTIL_SET_PANEL_HEIGHT, r102, null);
        return;
    L8:
        tt5.a.d(TAG, "setPanelHeight bridge is null!");
    }

    public static /* synthetic */ void access$100(EditPanelsManager r100, g45.a r101, boolean r102) {
        r100.updateActivePanel(r101, r102);
    }

    @Override // ocb.a
    public void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        this.keyboardHeight = r101;
        this.bottomPanelTop = r100.getKeyboardTop();
        this.keyboardHeightProviderRef = new WeakReference(r100);
        tt5.a.h(TAG, "onKeyboardHeightChanged: keyboardHeight = " + r101 + ", visibleKeyboardHeight = " + r100.getVisibleKeyboardHeight() + ", isKeyboardShowing = " + r100.isKeyboardShowing() + ", bottomPanelTop = " + this.bottomPanelTop + ", activePanel = " + getActivePanelName() + ", contentView = " + getContentViewDebugInfo() + ", orientation = " + r102);
        if (this.scrollWebViewWhenKeyboardHeightChange == false) goto L6;
        requestUpdateWebContentHeight();
        return;
    }
}
