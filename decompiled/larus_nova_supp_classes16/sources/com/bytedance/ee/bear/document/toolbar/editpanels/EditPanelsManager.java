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
import com.bytedance.ee.bear.document.offline.file.upload.FileUploadModel;
import com.bytedance.ee.bear.edit.component.toolbar2.a0;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.j;
import g45.d;
import java.lang.ref.WeakReference;
import java.util.Stack;
import tb5.i;
import tb5.m;
import tb5.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final /* synthetic */ g45.a a;
        public final /* synthetic */ EditPanelsManager b;

        public a(EditPanelsManager r1, g45.a r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
            if (r3 != Lifecycle.Event.ON_DESTROY) goto L6;
            r2.getLifecycle().removeObserver(this);
            EditPanelsManager.access$100(this.b, this.a, false);
            return;
        }
    }

    public class b implements i<Void> {
        public m a;
        public final /* synthetic */ EditPanelsManager b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(EditPanelsManager r1) {
            this.b = r1;
        }

        public final void a(boolean r12) {
            if (this.a != null) goto L7;
            tt5.a.h(EditPanelsManager.TAG, "notifyKeyboardChanged noop, callback is null");
            return;
        L7:
            if (EditPanelsManager.access$900(this.b) != null) goto L11;
            tt5.a.h(EditPanelsManager.TAG, "notifyKeyboardChanged noop, bridge is null");
            return;
        L11:
            if (EditPanelsManager.access$800(this.b) != null) goto L13;
        L95:
            tt5.a.h(EditPanelsManager.TAG, "notifyKeyboardChanged noop, contentView is null");
            return;
        L13:
            if (EditPanelsManager.access$800(this.b).getRootView() == null) goto L95;
            g45.a r0 = (g45.a) this.b.getActiveEditPanel().getValue();
            if (r0 == null) goto L18;
            String r3 = r0.getPanelName();
        L19:
            tt5.a.h(EditPanelsManager.TAG, "notifyKeyboardChanged: type = " + r3 + ", lastPanelName = " + EditPanelsManager.access$1000(this.b));
            if (TextUtils.equals(r3, "search") == false) goto L22;
        L24:
            EditPanelsManager.access$1002(this.b, r3);
            View r4 = EditPanelsManager.access$800(this.b);
            int[] r6 = new int[2];
            r4.getLocationOnScreen(r6);
            int r7 = 1;
            int r8 = r6[1];
            int r9 = EditPanelsManager.access$500(this.b, r12);
            if (r9 > 0) goto L30;
            View r5 = r4.getRootView().findViewById(R.id.content);
            if (r5 != null) goto L29;
            int r10 = -1;
        L48:
            if (r10 != (-1)) goto L50;
            return;
        L50:
            KeyboardShowingStatusMode r11 = KeyboardShowingStatusMode.FOLLOW_KEYBOARD;
            if (r0 == null) goto L54;
            r11 = r0.getKeyboardShowingStatusMode();
        L54:
            if (EditPanelsManager.access$400(this.b) != null) goto L56;
        L58:
            boolean r1 = false;
        L60:
            if (EditPanelsManager.access$600(this.b) <= 0) goto L62;
        L65:
            tt5.a.h(EditPanelsManager.TAG, "activeEditPanel > " + EditPanelsManager.access$200(this.b) + " type > " + r3 + "; last active panel > " + EditPanelsManager.access$300(this.b));
            if (EditPanelsManager.access$300(this.b) == null) goto L83;
            String r13 = EditPanelsManager.access$300(this.b).getPanelName();
            if (r7 != 0) goto L83;
            if (r3.equals("editor") == false) goto L83;
            if (TextUtils.equals(r13, "equation") == false) goto L74;
        L81:
            tt5.a.h(EditPanelsManager.TAG, "using hideKeyboardType " + r13);
            r3 = r13;
            goto L83
        L74:
            if (TextUtils.equals(r13, FileUploadModel.FROM_COMMENT) == true) goto L81;
            if (TextUtils.equals(r13, "keyboard") == true) goto L81;
            if (TextUtils.equals(r13, "sheetCellContent") == true) goto L81;
            if (TextUtils.equals(r13, "dropdown") == true) goto L81;
        L83:
            if (r3.equals("keyboard") == false) goto L87;
            r10 = com.bytedance.ee.util.ui.n.E(EditPanelsManager.access$600(this.b));
            if (EditPanelsManager.access$600(this.b) != 0) goto L87;
            r7 = 0;
        L87:
            JSONObject r2 = new JSONObject();
            if (r12 == false) goto L90;
            r2.put("isOpenKeyboard", 0);
        L93:
            r2.put("innerHeight", Integer.valueOf(r10));
            r2.put("keyboardType", r3);
            tt5.a.h(EditPanelsManager.TAG, "Notify js keyboard:" + r2.toString() + " keyboard height:" + EditPanelsManager.access$600(this.b) + " isShowingFunctionPanel:" + r1 + " mode = " + r11 + " activePanel:" + EditPanelsManager.access$1100(this.b) + " contentView:" + EditPanelsManager.access$1200(this.b));
            this.a.b(r2);
            EditPanelsManager.access$302(this.b, null);
            return;
        L90:
            r2.put("isOpenKeyboard", Integer.valueOf(r7));
            if (r1 == false) goto L93;
            r2.put("toolbar_v2_compat", Boolean.valueOf(r1));
            goto L93
        L62:
            if (r11 == KeyboardShowingStatusMode.ALWAYS_SHOW) goto L65;
            r7 = 0;
            goto L65
        L56:
            if (EditPanelsManager.access$400(this.b).isShowingFunctionPanel() == false) goto L58;
            r1 = true;
            goto L60
        L29:
            int[] r14 = new int[2];
            r5.getLocationOnScreen(r14);
            r9 = r14[1] + r5.getHeight();
        L30:
            tt5.a.h(EditPanelsManager.TAG, "getWebRemainingHeight: panelTop = " + r9 + ", webViewTop = " + r8 + ", keyboardHeight = " + EditPanelsManager.access$600(this.b) + ", bottomPanelTop = " + EditPanelsManager.access$700(this.b) + ", forceClose = " + r12 + ", type = " + r3);
            int r16 = r9 - r8;
            if (r0 == null) goto L44;
            int r17 = r0.getPanelHeight(EditPanelsManager.access$800(this.b).getContext());
            tt5.a.h(EditPanelsManager.TAG, "getWebRemainingHeight: panelHeight " + r17);
            if (r17 != 0) goto L38;
            if ("editor".equals(r3) == false) goto L38;
            r17 = EditPanelsManager.access$800(this.b).getContext().getResources().getDimensionPixelSize(2131165742);
        L38:
            if (r17 > EditPanelsManager.access$600(this.b)) goto L40;
        L42:
            r16 = r16 - r17;
        L47:
            r10 = com.bytedance.ee.util.ui.n.E(r16);
            goto L48
        L40:
            if (TextUtils.equals("oppanel", r0.getPanelName()) == false) goto L42;
            r17 = r17 - EditPanelsManager.access$600(this.b);
            goto L42
        L44:
            if (EditPanelsManager.access$600(this.b) <= 0) goto L46;
            r16 = r16 - EditPanelsManager.access$800(this.b).getContext().getResources().getDimensionPixelSize(2131165742);
        L46:
            tt5.a.k(EditPanelsManager.TAG, "no active panel !");
            goto L47
        L22:
            if (TextUtils.equals(EditPanelsManager.access$1000(this.b), "search") == false) goto L24;
            rcb.c.d(EditPanelsManager.access$800(this.b));
            goto L24
        L18:
            r3 = "editor";
            goto L19
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            Void r3 = (Void) r1;
            this.a = r2;
        }
    }

    public interface c {
    }

    public static /* synthetic */ void Mo(EditPanelsManager r0, g45.a r1, Boolean r2) {
        r0.lambda$registerEditPanel$1(r1, r2);
    }

    public static /* synthetic */ void yo(EditPanelsManager r0) {
        r0.lambda$new$0();
    }

    public c getPanelHeightDelegate() {
        return null;
    }

    public void setPanelHeightDelegate(c r1) {
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
        g45.a r0 = (g45.a) getActiveEditPanel().getValue();
        if (r0 != null) goto L6;
        return "null";
    L6:
        return r0.getPanelName();
    }

    public n getBridge() {
        return this.bridge;
    }

    public static /* synthetic */ String access$1000(EditPanelsManager r0) {
        return r0.lastPanelName;
    }

    public static /* synthetic */ String access$1100(EditPanelsManager r0) {
        return r0.getActivePanelName();
    }

    public static /* synthetic */ String access$1200(EditPanelsManager r0) {
        return r0.getContentViewDebugInfo();
    }

    public static /* synthetic */ MutableLiveData access$200(EditPanelsManager r0) {
        return r0.activeEditPanel;
    }

    public static /* synthetic */ g45.a access$300(EditPanelsManager r0) {
        return r0.lastActiveEditPanel;
    }

    public static /* synthetic */ a0 access$400(EditPanelsManager r0) {
        return r0.docToolbarV2Compat;
    }

    public static /* synthetic */ int access$600(EditPanelsManager r0) {
        return r0.keyboardHeight;
    }

    public static /* synthetic */ int access$700(EditPanelsManager r0) {
        return r0.bottomPanelTop;
    }

    public static /* synthetic */ View access$800(EditPanelsManager r0) {
        return r0.contentView;
    }

    public static /* synthetic */ n access$900(EditPanelsManager r0) {
        return r0.bridge;
    }

    private int getBottomPanelTop(boolean r1) {
        if (r1 == false) goto L5;
        return 0;
    L5:
        WeakReference<pcb.a> r2 = this.keyboardHeightProviderRef;
        if (r2 == null) goto L12;
        if (r2.get() == null) goto L12;
        return this.keyboardHeightProviderRef.get().getKeyboardTop();
    L12:
        return this.bottomPanelTop;
    }

    public void attachBridge(n r3) {
        this.bridge = r3;
        r3.c("biz.util.onKeyboardChanged", this.keyBoardStatusChangedHandler);
    }

    public void detachBridge(n r3) {
        if (r3 != this.bridge) goto L5;
        this.bridge = null;
    L5:
        r3.b();
        j.e(this.updateJSKeyboardStateTask);
        WeakReference<pcb.a> r4 = this.keyboardHeightProviderRef;
        if (r4 == null) goto L8;
        r4.clear();
        this.keyboardHeightProviderRef = null;
    L8:
        this.activeEditPanelStack.clear();
        MutableLiveData<g45.a> r5 = this.activeEditPanel;
        if (r5 == null) goto L12;
        r5.setValue(null);
        return;
    }

    public void needSetPanelHeight(boolean r1) {
        this.mNeedSetPanelHeight = r1;
    }

    public void onConfigurationChanged(pcb.a r2) {
        this.bottomPanelTop = r2.getKeyboardTop();
        tt5.a.h(TAG, "onConfigurationChanged: bottomPanelTop = " + this.bottomPanelTop);
    }

    public void requestNotFocus(Context r2) {
        g45.a r0 = (g45.a) getActiveEditPanel().getValue();
        if (r0 == null) goto L6;
        r0.requestNotFocus(r2);
        return;
    }

    @Override // g45.d
    public void requestUpdateWebContentHeight(long r4) {
        tt5.a.i(TAG, "requestUpdateWebContentHeight, delay = " + r4 + ", keyboardHeight = " + this.keyboardHeight + ", bottomPanelTop = " + this.bottomPanelTop + ", activePanel = " + getActivePanelName() + ", contentView = " + getContentViewDebugInfo(), new Throwable());
        j.e(this.updateJSKeyboardStateTask);
        j.d(this.updateJSKeyboardStateTask, r4);
    }

    public void setContentView(View r1) {
        this.contentView = r1;
    }

    public void setDocToolbarV2Compat(a0 r1) {
        this.docToolbarV2Compat = r1;
    }

    public void setKeyboardHeightProviderRef(pcb.a r2) {
        this.keyboardHeightProviderRef = new WeakReference(r2);
    }

    public void setScrollWebViewWhenKeyboardHeightChange(boolean r1) {
        this.scrollWebViewWhenKeyboardHeightChange = r1;
    }

    public static /* synthetic */ String access$1002(EditPanelsManager r0, String r1) {
        r0.lastPanelName = r1;
        return r1;
    }

    public static /* synthetic */ g45.a access$302(EditPanelsManager r0, g45.a r1) {
        r0.lastActiveEditPanel = r1;
        return r1;
    }

    public static /* synthetic */ int access$500(EditPanelsManager r0, boolean r1) {
        return r0.getBottomPanelTop(r1);
    }

    private /* synthetic */ void lambda$registerEditPanel$1(g45.a r3, Boolean r4) {
        tt5.a.h(TAG, "onActiveChanged:" + r4 + ", " + r3.getClass().getSimpleName());
        updateActivePanel(r3, Boolean.TRUE.equals(r4));
    }

    private void updateActivePanel(g45.a r6, boolean r7) {
        g45.a r1 = null;
        if (this.activeEditPanelStack.isEmpty() == false) goto L5;
        g45.a r0 = null;
    L6:
        if (r7 == false) goto L9;
        this.lastActiveEditPanel = r0;
        this.activeEditPanelStack.remove(r6);
        this.activeEditPanelStack.push(r6);
    L12:
        if (this.activeEditPanelStack.isEmpty() == true) goto L15;
        r1 = this.activeEditPanelStack.peek();
    L15:
        MutableLiveData r2 = getActiveEditPanel();
        g45.a r3 = (g45.a) r2.getValue();
        if (r3 != null) goto L18;
        if (r1 == null) goto L18;
    L21:
        boolean r4 = true;
    L23:
        if (r4 == false) goto L32;
        tt5.a.h(TAG, "active panel changed to :" + r1);
        r2.setValue(r1);
        if (r7 == false) goto L29;
        r6.onBecomeActive(this, r3);
        if (r3 == null) goto L30;
        r3.onBecomeInactive(this, r6);
    L30:
        requestUpdateWebContentHeight(200);
        return;
    L29:
        r6.onBecomeInactive(this, r1);
        goto L30
    L32:
        return;
    L18:
        if (r3 != null) goto L20;
    L22:
        r4 = false;
        goto L23
    L20:
        if (r3.equals(r1) == true) goto L22;
    L9:
        if (this.activeEditPanelStack.remove(r6) == false) goto L12;
        this.lastActiveEditPanel = r0;
        goto L12
    L5:
        r0 = this.activeEditPanelStack.peek();
        goto L6
    }

    @Override // g45.d
    public void registerEditPanel(LifecycleOwner r3, final g45.a r4) {
        r4.getActive().observe(r3, new g45.c(this, r4));
        r3.getLifecycle().addObserver(new a(this, r4));
    }

    public void setPanelHeight(int r3, String r4) {
        if (this.mNeedSetPanelHeight == true) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        r0.put("height", Integer.valueOf(r3));
        r0.put("keyboardType", r4);
        n r5 = this.bridge;
        if (r5 == null) goto L8;
        r5.a(BIZ_UTIL_SET_PANEL_HEIGHT, r0, null);
        return;
    L8:
        tt5.a.d(TAG, "setPanelHeight bridge is null!");
    }

    public static /* synthetic */ void access$100(EditPanelsManager r0, g45.a r1, boolean r2) {
        r0.updateActivePanel(r1, r2);
    }

    public void onKeyboardHeightChanged(pcb.a r3, int r4, int r5) {
        this.keyboardHeight = r4;
        this.bottomPanelTop = r3.getKeyboardTop();
        this.keyboardHeightProviderRef = new WeakReference(r3);
        tt5.a.h(TAG, "onKeyboardHeightChanged: keyboardHeight = " + r4 + ", visibleKeyboardHeight = " + r3.getVisibleKeyboardHeight() + ", isKeyboardShowing = " + r3.isKeyboardShowing() + ", bottomPanelTop = " + this.bottomPanelTop + ", activePanel = " + getActivePanelName() + ", contentView = " + getContentViewDebugInfo() + ", orientation = " + r5);
        if (this.scrollWebViewWhenKeyboardHeightChange == false) goto L6;
        requestUpdateWebContentHeight();
        return;
    }
}
