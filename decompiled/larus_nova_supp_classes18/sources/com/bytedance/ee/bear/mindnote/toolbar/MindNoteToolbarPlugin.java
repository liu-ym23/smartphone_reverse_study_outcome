package com.bytedance.ee.bear.mindnote.toolbar;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.OrientationViewModel;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel;
import com.bytedance.ee.bear.document.toolbar.BaseToolbarPlugin;
import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.document.toolbar.NavBarBottomInsetCompatEntity;
import com.bytedance.ee.bear.document.toolbar.Toolbar;
import com.bytedance.ee.bear.document.toolbar.n;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.fileselector.FileSelectFragment;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larksuite.framework.utils.KeyboardUtils;
import java.util.Stack;
import org.json.JSONObject;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MindNoteToolbarPlugin extends BaseToolbarPlugin<MindNoteToolbar> implements p {
    private static final String TAG = "MindNoteToolbarPlugin";
    private ArrayMap<String, FragmentManager.FragmentLifecycleCallbacks> callbacksMap;
    private boolean isInEditStatus;
    private OrientationViewModel mOrientationViewModel;
    private ArraySet<String> registerSet;
    private String showingPanel;
    private MindNoteToolbarViewModel viewModel;

    public class a extends FragmentManager.FragmentLifecycleCallbacks {
        public final /* synthetic */ MindNoteToolbarPlugin a;

        public a(MindNoteToolbarPlugin r1) {
            this.a = r1;
        }

        public final void onFragmentViewDestroyed(FragmentManager r2, Fragment r3) {
            MindNoteToolbarPlugin.access$200(this.a, r3);
            super.onFragmentViewDestroyed(r2, r3);
        }

        public final void onFragmentCreated(FragmentManager r1, Fragment r2, Bundle r3) {
            super.onFragmentCreated(r1, r2, r3);
            MindNoteToolbarPlugin.access$100(this.a, r2);
        }
    }

    public class b implements i<String> {
        public final /* synthetic */ MindNoteToolbarPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(MindNoteToolbarPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r4, m r5) {
            String r6 = (String) r4;
            tt5.a.b(MindNoteToolbarPlugin.TAG, "updateEditStatus data: " + r6);     // Catch: Exception -> L11
            JSONObject r1 = new JSONObject(r6);     // Catch: Exception -> L11
            if (r1.has("status") == false) goto L16;
            MindNoteToolbarPlugin r7 = this.a;     // Catch: Exception -> L11
            int r8 = JSONObjectProtectorUtils.getInt(r1, "status");     // Catch: Exception -> L11
            boolean r2 = true;
            if (r8 == 1) goto L9;
            r2 = false;
        L9:
            MindNoteToolbarPlugin.access$402(r7, r2);     // Catch: Exception -> L11
            MindNoteToolbarPlugin.access$500(this.a);     // Catch: Exception -> L11
            return;
        L16:
            return;
        L11:
            e = move-exception;
            tt5.a.l(MindNoteToolbarPlugin.TAG, "Failed to updateEditStatus", e);
        }
    }

    public class c implements BaseToolbarPlugin.b<MindNoteToolbar> {
        public m a;
        public final /* synthetic */ MindNoteToolbarPlugin b;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BaseToolbarPlugin.ToolbarJSHandler.-CC.$default$authType(this);
        }

        public c(MindNoteToolbarPlugin r1) {
            this.b = r1;
        }

        public final void b(ItemId r3, String r4) {
            if (this.a != null) goto L5;
            return;
        L5:
            com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject();
            r0.put(ResourceData.KEY_ID, r3.name());
            r0.put("value", r4);
            this.a.b(r0);
        }

        public final void handle(Object r3, m r4) {
            MindNoteToolbar r5 = (MindNoteToolbar) r3;
            tt5.a.b(MindNoteToolbarPlugin.TAG, "Js update toolbar:" + r5);
            if (r5 == null) goto L5;
            r5.initFromJsBridge(MindNoteItemId.values());
        L5:
            this.a = r4;
            MindNoteToolbarPlugin r6 = this.b;
            if (r5 != null) goto L8;
        L9:
            r5 = null;
        L10:
            MindNoteToolbarPlugin.access$300(r6, r5);
            return;
        L8:
            if (r5.getChildren().length != 0) goto L10;
            goto L9
        }
    }

    public String getToolbarJSBinderName() {
        return "biz.navigation.setMindnoteToolbar";
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void notifyEditStatusChange() {
        if (this.isInEditStatus == true) goto L5;
        notifyOrientationSupportPanelState(Boolean.FALSE);
        return;
    L5:
        notifyOrientationSupportPanelState(Boolean.TRUE);
    }

    public BaseToolbarPlugin.b<MindNoteToolbar> onCreateToolbarJSHandler() {
        return new c(this);
    }

    public boolean shouldDisableLandscape() {
        if (this.isInEditStatus == false) goto L7;
        return true;
    L7:
        return super/*com.bytedance.ee.bear.document.DocumentPlugin*/.shouldDisableLandscape();
    }

    public MindNoteToolbarPlugin() {
        this.callbacksMap = new ArrayMap(2);
        this.registerSet = new ArraySet(4);
        this.isInEditStatus = false;
    }

    public static /* synthetic */ void access$500(MindNoteToolbarPlugin r0) {
        r0.notifyEditStatusChange();
    }

    private void handleOnFragmentCreated(Fragment r5) {
        tt5.a.b(TAG, "onFragmentCreated: ".concat(r5.getClass().getName()));
    L7:
        e = move-exception;
        tt5.a.e(TAG, "onFragmentCreated: ", e, false);
        return;
    L4:
        if (this.registerSet.contains(r5.getClass().getName()) == false) goto L12;
        this.viewModel.setShowingFunctionPanel(true);     // Catch: Exception -> L7
        KeyboardUtils.hideKeyboard(getActivity());     // Catch: Exception -> L7
        this.showingPanel = r5.getClass().getName();     // Catch: Exception -> L7
        return;
    }

    private void handleOnFragmentViewDestroyed(Fragment r7) {
        tt5.a.b(TAG, "onFragmentDestroyed: ".concat(r7.getClass().getName()));
    L35:
        e = move-exception;
        tt5.a.e(TAG, "onFragmentDestroyed: ", e, false);
        return;
    L4:
        if (com.bytedance.ee.util.ui.b.a(getActivity()) == true) goto L8;
        tt5.a.h(TAG, "handleOnFragmentViewDestroyed: activity isActive: false");     // Catch: Exception -> L35
        return;
    L8:
        if (this.registerSet.contains(r7.getClass().getName()) == false) goto L32;
        this.viewModel.setShowingFunctionPanel(false);     // Catch: Exception -> L35
        if (TextUtils.equals(this.showingPanel, r7.getClass().getName()) == false) goto L32;
        if (this.viewModel.getCurrItemId() == ItemId.ConstId.keyboard) goto L32;
        if (this.viewModel.getCurrItemId() == this.viewModel.getLastItemId()) goto L18;
        if (this.viewModel.getLastItemId() == null) goto L18;
    L24:
        if (this.viewModel.getToolbar().getValue() == null) goto L32;
        if (((Stack) this.viewModel.getExpandedSubToolbars().getValue()).empty() == false) goto L32;
        if (pcb.a.a.b(getActivity()).isKeyboardShowing() == true) goto L30;
        KeyboardUtils.showKeyboard(getActivity());     // Catch: Exception -> L35
    L30:
        this.showingPanel = null;     // Catch: Exception -> L35
    L18:
        if (this.viewModel.getToolbar().getValue() == null) goto L24;
        if (pcb.a.a.b(getActivity()).isKeyboardShowing() == true) goto L22;
        KeyboardUtils.showKeyboard(getActivity());     // Catch: Exception -> L35
    L22:
        this.showingPanel = null;     // Catch: Exception -> L35
    L32:
        if (r7.getClass().getName().equals(FileSelectFragment.class.getName()) == false) goto L39;
        this.showingPanel = MindNoteTxtAttrFragment.class.getName();     // Catch: Exception -> L35
        return;
    }

    private void notifyOrientationSupportPanelState(Boolean r3) {
        if (ku5.c.k(getContext()) == false) goto L5;
        return;
    L5:
        BaseUnspecifiedOrientationPlugin r0 = findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r0 != null) goto L10;
        tt5.a.k(TAG, "can not find BaseUnspecifiedOrientationPlugin");
        return;
    L10:
        if (Boolean.TRUE.equals(r3) == false) goto L12;
        r0.onOrientationSupportPanelShowing(this);
        return;
    L12:
        r0.onOrientationSupportPanelDismiss(this);
    }

    private void registerFragmentLifecycleCallbacks(FragmentManager r3) {
        a r0 = new a(this);
        r3.registerFragmentLifecycleCallbacks(r0, false);
        this.callbacksMap.put(String.valueOf(r3.hashCode()), r0);
    }

    private void unregisterFragmentLifecycleCallbacks(FragmentManager r3) {
        if (r3 == null) goto L7;
        FragmentManager.FragmentLifecycleCallbacks r0 = (FragmentManager.FragmentLifecycleCallbacks) this.callbacksMap.get(String.valueOf(r3.hashCode()));
        if (r0 == null) goto L8;
        r3.unregisterFragmentLifecycleCallbacks(r0);
        return;
    L8:
        return;
    }

    public BaseToolbarPanelViewModel<MindNoteToolbar> getToolbarViewModel(FragmentActivity r3) {
        MindNoteToolbarViewModel r4 = q.c(getHost(), MindNoteToolbarViewModel.class, null);
        this.viewModel = r4;
        return r4;
    }

    public void onAttachToHost(DocumentPluginHost r4) {
        super.onAttachToHost(r4);
        NavBarBottomInsetCompatEntity r5 = com.bytedance.ee.bear.appsetting.c.a.a.c("doc_toolbar_android_compat", NavBarBottomInsetCompatEntity.class, new NavBarBottomInsetCompatEntity());
        n.b.a.c(getActivity(), r5);
        registerFragmentLifecycleCallbacks(getActivity().getSupportFragmentManager());
        this.registerSet.add(MindNoteTxtAttrFragment.class.getName());
        this.registerSet.add(FileSelectFragment.class.getName());
        this.mOrientationViewModel = viewModel(OrientationViewModel.class);
        bindBridgeHandler("biz.mindnote.updateEditStatus", new b(this));
    }

    public void onConfigurationChanged(Configuration r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onConfigurationChanged(r1);
        notifyEditStatusChange();
    }

    public void onDetachFromHost(DocumentPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r1);
        unregisterFragmentLifecycleCallbacks(getActivity().getSupportFragmentManager());
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static /* synthetic */ void access$100(MindNoteToolbarPlugin r0, Fragment r1) {
        r0.handleOnFragmentCreated(r1);
    }

    public static /* synthetic */ void access$200(MindNoteToolbarPlugin r0, Fragment r1) {
        r0.handleOnFragmentViewDestroyed(r1);
    }

    public static /* synthetic */ void access$300(MindNoteToolbarPlugin r0, Toolbar r1) {
        r0.updateToolbar(r1);
    }

    public static /* synthetic */ boolean access$402(MindNoteToolbarPlugin r0, boolean r1) {
        r0.isInEditStatus = r1;
        return r1;
    }

    public Fragment onCreateToolbarFragment(Context r4, String r5) {
        Bundle r6 = new Bundle();
        r6.putString(ResourceData.KEY_URL, r5);
        BearUrl r7 = getHost().a().getBearUrl();
        BearUrl r0 = getHost().a().getOriginBearUrl();
        if (r0 != null) goto L5;
    L7:
        r6.putParcelable("bear_url", r7);
        return instantiateFragment(MindNoteToolbarFragment.class, r6);
    L5:
        if (DocumentType.WIKI_NAME.equals(r0.a) == false) goto L7;
        r6.putString("origin_bear_url", r0.b);
        goto L7
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        pcb.a.a.b(r1.getActivity()).setDelayedDuration(null);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
