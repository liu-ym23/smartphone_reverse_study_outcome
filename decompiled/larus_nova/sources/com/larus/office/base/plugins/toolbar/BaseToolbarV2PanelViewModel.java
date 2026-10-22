package com.larus.office.base.plugins.toolbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ee.docsdk.impl.utils.keyboard.KeyboardHeightObserver;
import com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider;
import com.bytedance.ee.docsdk.impl.utils.keyboard.utils.KeyBoardUtils;
import com.larus.nova.R;
import com.larus.office.base.plugins.toolbar.editpanel.EditPanelsManager;
import com.larus.office.base.plugins.toolbar.model.Item;
import com.larus.office.base.plugins.toolbar.model.ItemId;
import com.larus.office.base.plugins.toolbar.model.a;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.bridge.IBridge;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 `*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002_`B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010 \u001a\u00020!2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\"H\u0016J\u000e\u0010\u0018\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0015J\u001c\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001e\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040+J\u0012\u0010,\u001a\u00020\u00132\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0006\u0010/\u001a\u00020!J\u000e\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\"J\u0010\u00101\u001a\u00020\u00152\b\u00102\u001a\u0004\u0018\u00010\u0011J\b\u00103\u001a\u0004\u0018\u00010\u0011J\u0010\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\"J\u0010\u00105\u001a\u00020!2\b\u00106\u001a\u0004\u0018\u00010\rJ\u000e\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\"J\u0006\u00108\u001a\u00020\u0015J%\u00109\u001a\u00020!\"\u0004\b\u0001\u0010:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010#\u001a\u0004\u0018\u0001H:¢\u0006\u0002\u0010=J\"\u00109\u001a\u00020!2\b\u0010;\u001a\u0004\u0018\u00010\u00112\b\u0010#\u001a\u0004\u0018\u00010\u00112\u0006\u0010>\u001a\u00020\u0013J\u0018\u0010?\u001a\u00020!2\u0006\u0010;\u001a\u00020<2\b\u0010#\u001a\u0004\u0018\u00010\u0011J\u0012\u0010@\u001a\u00020!2\b\u0010A\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010@\u001a\u00020!H\u0004J\u0006\u0010B\u001a\u00020\u0015J\u0006\u0010C\u001a\u00020\u0015J\b\u0010D\u001a\u00020\u0015H\u0004J\u0006\u0010E\u001a\u00020\u0015J!\u0010F\u001a\u00020!2\b\u0010G\u001a\u0004\u0018\u00018\u00002\b\u0010H\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010IJ\u0015\u0010J\u001a\u00020!2\b\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010KJ\u0006\u0010L\u001a\u00020!J\u0017\u0010M\u001a\u00020!2\b\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0002\u0010KJ\u000e\u0010N\u001a\u00020\u00152\u0006\u0010O\u001a\u00020\u000bJ\u0012\u0010P\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0006\u0010Q\u001a\u00020!J\u0006\u0010R\u001a\u00020!J\u001c\u0010S\u001a\u00020!2\b\u0010T\u001a\u0004\u0018\u00010U2\b\u0010V\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010W\u001a\u00020!2\b\u0010T\u001a\u0004\u0018\u00010U2\b\u0010X\u001a\u0004\u0018\u00010\u0004H\u0016J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\"J\"\u0010Y\u001a\u00020!2\b\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020\u00132\u0006\u0010]\u001a\u00020\u0013H\u0016J\u0010\u0010^\u001a\u00020!2\u0006\u0010\\\u001a\u00020\u0013H\u0004R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006a"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/BaseToolbarV2PanelViewModel;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larus/office/base/plugins/toolbar/model/Toolbar;", "Landroidx/lifecycle/ViewModel;", "Lcom/larus/office/base/plugins/toolbar/editpanel/EditPanel;", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/KeyboardHeightObserver;", "<init>", "()V", NewBroadcastMonitor.STAGE.TOOLBAR, "Landroidx/lifecycle/MutableLiveData;", "expandedSubToolbar", "Lcom/larus/office/base/plugins/toolbar/model/Item;", "subToolbarV2Rect", "Landroid/graphics/Rect;", "delegate", "Lcom/larus/office/base/plugins/toolbar/BaseToolbarV2PanelViewModel$Delegate;", "lastShowingItemIdV2", "", "keyboardHeightLiveData", "", "active", "", "getActive", "()Landroidx/lifecycle/MutableLiveData;", "setActive", "(Landroidx/lifecycle/MutableLiveData;)V", "bridge", "Lcom/ss/android/lark/chameleon/bridge/IBridge;", "getBridge", "()Lcom/ss/android/lark/chameleon/bridge/IBridge;", "setBridge", "(Lcom/ss/android/lark/chameleon/bridge/IBridge;)V", "setDelegate", "", "Landroidx/lifecycle/LiveData;", "value", "onAttachToUI", "activity", "Landroidx/fragment/app/FragmentActivity;", "observeActivePanel", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "getPanelHeight", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "requestUpdateContentHeight", "getToolbar", "isLastShowingId", "itemIdV2", "getShowingItemId", "getSubToolbarV2Rect", "updateSubToolbarV2Rect", "newRect", "getExpandedSubToolbar", "hasFunctionPanel", "processSubToolbarItemClick", "V", "itemId", "Lcom/larus/office/base/plugins/toolbar/model/ItemId;", "(Lcom/larus/office/base/plugins/toolbar/model/ItemId;Ljava/lang/Object;)V", "level", "processToolbarItemClick", "updateExpandedSubToolbar", "itemV2", "clearSubToolbar", "hasExpandedSubToolbar", "hasSubToolBarV2", "hasToolbarV2", "updateLastShowingItemId", "_old", "_new", "(Lcom/larus/office/base/plugins/toolbar/model/Toolbar;Lcom/larus/office/base/plugins/toolbar/model/Toolbar;)V", "updateToolbar", "(Lcom/larus/office/base/plugins/toolbar/model/Toolbar;)V", "hideToolbar", "onUpdateToolbar", "isExpanded", MapController.ITEM_LAYER_TAG, "requestNotFocus", "onDetachFromUI", "onDetachFromHost", "onBecomeActive", "editPanelsManager", "Lcom/larus/office/base/plugins/toolbar/editpanel/EditPanelsManager;", "lastActive", "onBecomeInactive", "nextActive", "onKeyboardHeightChanged", "khp", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/provider/KeyboardHeightProvider;", "keyboardHeight", "orientation", "onKeyboardStateChanged", "Delegate", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseToolbarV2PanelViewModel<T extends com.larus.office.base.plugins.toolbar.model.a> extends ViewModel implements fn9.a, KeyboardHeightObserver {
    public static final a Companion = null;
    private static final String TAG = "BaseToolbarV2PanelViewM";
    private MutableLiveData<Boolean> active;
    private IBridge bridge;
    private b delegate;
    private final MutableLiveData<Item> expandedSubToolbar;
    private final MutableLiveData<Integer> keyboardHeightLiveData;
    private String lastShowingItemIdV2;
    private MutableLiveData<Rect> subToolbarV2Rect;
    private final MutableLiveData<T> toolbar;

    public static final class a {
        public a() {
        }
    }

    public interface b {
    }

    static {
        Companion = new a();
    }

    @Override // fn9.a
    public abstract /* synthetic */ String getPanelName();

    public final void observeActivePanel(LifecycleOwner r100, Observer<fn9.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
    }

    @Override // fn9.a
    public void onBecomeActive(EditPanelsManager r100, fn9.a r101) {
    }

    @Override // fn9.a
    public void onBecomeInactive(EditPanelsManager r100, fn9.a r101) {
    }

    public final void onDetachFromHost() {
    }

    public final void requestUpdateContentHeight() {
    }

    public final void setDelegate(b r100) {
    }

    public final String getShowingItemId() {
        T r100 = this.toolbar.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b();
    }

    public final boolean hasExpandedSubToolbar() {
        if (this.expandedSubToolbar.getValue() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean hasFunctionPanel() {
        Item r100 = this.expandedSubToolbar.getValue();
        if (r100 == null) goto L7;
        ItemId r101 = r100.id();
        if (r101 == null) goto L7;
        ItemId.DisplayMode r102 = r101.displayMode();
    L9:
        if (r102 != ItemId.DisplayMode.FunctionPanel) goto L11;
        return true;
    L11:
        return false;
    L7:
        r102 = null;
        goto L9
    }

    public final boolean hasSubToolBarV2() {
        Item r100 = this.expandedSubToolbar.getValue();
        if (r100 == null) goto L7;
        ItemId r101 = r100.id();
        if (r101 == null) goto L7;
        ItemId.DisplayMode r102 = r101.displayMode();
    L9:
        if (r102 != ItemId.DisplayMode.SubToolBarV2) goto L11;
        return true;
    L11:
        return false;
    L7:
        r102 = null;
        goto L9
    }

    public final void hideToolbar() {
        FLogger.f375446a.i(TAG, "dismissToolBar:" + this.toolbar);
        clearSubToolbar();
        updateToolbar(null);
    }

    public BaseToolbarV2PanelViewModel() {
        this.toolbar = new MutableLiveData();
        this.expandedSubToolbar = new MutableLiveData();
        this.subToolbarV2Rect = new MutableLiveData();
        this.keyboardHeightLiveData = new MutableLiveData();
        this.active = new MutableLiveData(Boolean.FALSE);
    }

    public final boolean clearSubToolbar() {
        if (hasExpandedSubToolbar() == false) goto L13;
        ItemId.DisplayMode r100 = null;
        updateExpandedSubToolbar(null);
        Item r101 = this.expandedSubToolbar.getValue();
        if (r101 == null) goto L10;
        ItemId r102 = r101.id();
        if (r102 == null) goto L10;
        r100 = r102.displayMode();
    L10:
        if (r100 != ItemId.DisplayMode.FunctionPanel) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    }

    public final boolean hasToolbarV2() {
        if (getToolbar().getValue() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void updateExpandedSubToolbar() {
        T r100 = getToolbar().getValue();
        if (r100 != null) goto L6;
        clearSubToolbar();
        return;
    L6:
        FLogger.f375446a.i(TAG, "current showing item id: " + this.expandedSubToolbar.getValue());
        if (TextUtils.isEmpty(r100.b()) == false) goto L9;
        clearSubToolbar();
        return;
    L9:
        Item[] r101 = r100.a();
        if (r101 == null) goto L21;
        int r102 = r101.length;
        int r103 = 0;
    L12:
        if (r103 >= r102) goto L22;
        Item r104 = r101[r103];
        if (Intrinsics.areEqual(r104.id().itemName(), r100.b()) == true) goto L15;
        r103 = r103 + 1;
        goto L12
    L15:
        FLogger.f375446a.i(TAG, "update show subToolbarV2 " + r104);
        updateExpandedSubToolbar(r104);
        return;
    L22:
        return;
    }

    @Override // fn9.a
    public LiveData<Boolean> getActive() {
        return this.active;
    }

    public final IBridge getBridge() {
        return this.bridge;
    }

    public final LiveData<Item> getExpandedSubToolbar() {
        return this.expandedSubToolbar;
    }

    public final LiveData<Rect> getSubToolbarV2Rect() {
        return this.subToolbarV2Rect;
    }

    public final LiveData<T> getToolbar() {
        return this.toolbar;
    }

    public final LiveData<Integer> keyboardHeightLiveData() {
        return this.keyboardHeightLiveData;
    }

    public final void onDetachFromUI() {
        hideToolbar();
    }

    @Override // fn9.a
    public final MutableLiveData<Boolean> getActive() {
        return this.active;
    }

    private final void updateExpandedSubToolbar(Item r100) {
        getExpandedSubToolbar();
        Item r101 = this.expandedSubToolbar.getValue();
        FLogger r102 = FLogger.f375446a;
        r102.e(TAG, "updateExpandedSubToolbar from " + r101 + " to " + r100);
        if (r101 == null) goto L8;
        if (r100 == null) goto L8;
        if (TextUtils.equals(r101.getId(), r100.getId()) == false) goto L8;
        r102.i(TAG, "item no changed , ignore updateExpandedSubToolbar");
    L8:
        this.expandedSubToolbar.setValue(r100);
    }

    @Override // fn9.a
    public int getPanelHeight(Context r100) {
        if (r100 == null) goto L6;
        Resources r101 = r100.getResources();
        if (r101 == null) goto L6;
        return r101.getDimensionPixelSize(R.dimen.toolbar_menu_height);
    L6:
        return 0;
    }

    public final boolean isExpanded(Item r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Item r101 = getExpandedSubToolbar().getValue();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.id() != r100.id()) goto L7;
        return true;
    }

    public final boolean isLastShowingId(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (Intrinsics.areEqual(r100, this.lastShowingItemIdV2) == false) goto L6;
        return true;
    }

    public final void onKeyboardStateChanged(int r100) {
        this.keyboardHeightLiveData.setValue(Integer.valueOf(r100));
    }

    public final void onUpdateToolbar(T r100) {
        FLogger.f375446a.i(TAG, " onUpdateToolbar: " + r100);
        this.toolbar.setValue(r100);
        updateExpandedSubToolbar();
    }

    public void requestNotFocus(Context r100) {
        KeyBoardUtils.hideKeyboard(r100);
        FLogger.f375446a.i(TAG, "requestNotFocus");
        if (hasFunctionPanel() == false) goto L6;
        hideToolbar();
        return;
    }

    public final void setActive(boolean r100) {
        if (this.active.getValue() != null) goto L5;
    L6:
        this.active.setValue(Boolean.valueOf(r100));
        return;
    L5:
        if (Intrinsics.areEqual(this.active.getValue(), Boolean.valueOf(r100)) == false) goto L6;
    }

    public final void setBridge(IBridge r100) {
        this.bridge = r100;
    }

    public final void updateSubToolbarV2Rect(Rect r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        FLogger.f375446a.d(TAG, "updateSubToolbarV2Rect=" + r100);
        if (Intrinsics.areEqual(r100, this.subToolbarV2Rect.getValue()) == true) goto L8;
        this.subToolbarV2Rect.setValue(r100);
        return;
    }

    public final void updateToolbar(T r100) {
        T r101 = getToolbar().getValue();
        updateLastShowingItemId(r101, r100);
        int r102 = com.larus.office.base.plugins.toolbar.model.a.f360933a;
        boolean r103 = true;
        if (r100 != null) goto L7;
        if (r101 != null) goto L6;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L19;
        onUpdateToolbar(r100);
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("set toolbar active: ");
        if (r100 == null) goto L13;
        boolean r107 = true;
    L14:
        r106.append(r107);
        r106.append("  getActive: ");
        r106.append(getActive().getValue());
        r105.i(TAG, r106.toString());
        if (r100 != null) goto L18;
        r103 = false;
    L18:
        setActive(r103);
        return;
    L13:
        r107 = false;
        goto L14
    L19:
        if (r101 != null) goto L23;
        FLogger.f375446a.i(TAG, "all toolbar is null");
        return;
    L23:
        return;
    L6:
        r104 = false;
        goto L9
    L7:
        r104 = Intrinsics.areEqual(r100, r101);
        goto L9
    }

    public final void setActive(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.active = r100;
    }

    private final void updateLastShowingItemId(T r100, T r101) {
        FLogger r102 = FLogger.f375446a;
        r102.i(TAG, "before updateLastShowingItemId: " + this.lastShowingItemIdV2);
        if (r100 != null) goto L5;
        this.lastShowingItemIdV2 = null;
    L9:
        r102.i(TAG, "after updateLastShowingItemId =" + this.lastShowingItemIdV2);
        return;
    L5:
        if (r101 == null) goto L7;
        r102.i(TAG, "### new showing item =" + r101.b());
    L8:
        this.lastShowingItemIdV2 = r100.b();
        goto L9
    L7:
        r102.i(TAG, "### new showing item is null");
        goto L8
    }

    public void onAttachToUI(FragmentActivity r100, IBridge r101) {
        this.bridge = r101;
    }

    public final <V> void processSubToolbarItemClick(ItemId r100, V r101) {
        FLogger.f375446a.d(TAG, "processSubToolbarItemClick:" + r100 + ", " + r101);
        T r102 = getToolbar().getValue();
    }

    public final void processToolbarItemClick(ItemId r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        FLogger r102 = FLogger.f375446a;
        r102.d(TAG, "processToolbarItemClick:" + r100 + ", " + r101);
        if (getToolbar().getValue() != null) goto L6;
        r102.i(TAG, "Toolbar is null");
        return;
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.KeyboardHeightObserver
    public void onKeyboardHeightChanged(KeyboardHeightProvider r100, int r101, int r102) {
        onKeyboardStateChanged(r101);
    }

    public final void processSubToolbarItemClick(String r100, String r101, int r102) {
        FLogger.f375446a.d(TAG, "processSubToolbarItemClick:" + r100 + ", " + r101);
        T r103 = getToolbar().getValue();
    }
}
