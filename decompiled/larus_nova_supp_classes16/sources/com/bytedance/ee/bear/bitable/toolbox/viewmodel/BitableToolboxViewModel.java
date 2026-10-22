package com.bytedance.ee.bear.bitable.toolbox.viewmodel;

import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.SceneModel;
import com.bytedance.ee.bear.bitable.toolbox.BitableToolboxAnalytic;
import com.bytedance.ee.bear.bitable.toolbox.model.fab.BitableFabModel;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.PanelData;
import com.bytedance.ee.bear.bitable.toolbox.model.toolbar.EToolbarMenu;
import com.bytedance.ee.bear.bitable.toolbox.model.toolbar.ToolbarData;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sk5.c;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0012J\u0006\u0010 \u001a\u00020\u000bJ\u000e\u0010'\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0012J\u0010\u0010A\u001a\u00020\u00132\b\u0010B\u001a\u0004\u0018\u000108J\b\u0010P\u001a\u0004\u0018\u00010KR\u001f\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\tR(\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u0019\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\tR\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R*\u00107\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000108\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0015\"\u0004\b:\u0010\u0017R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010I\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010K\u0018\u00010JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O¨\u0006R"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/BitableToolboxViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "fabData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/bytedance/ee/bear/bitable/toolbox/model/fab/BitableFabModel$BitableFabItem;", "getFabData", "()Landroidx/lifecycle/MutableLiveData;", "fabVisible", "", "getFabVisible", "bottomPanelHeight", "", "getBottomPanelHeight", "onClickFabItem", "Lkotlin/Function1;", "", "", "getOnClickFabItem", "()Lkotlin/jvm/functions/Function1;", "setOnClickFabItem", "(Lkotlin/jvm/functions/Function1;)V", "onBoardingManager", "Lcom/bytedance/ee/bear/onboarding/export/IOnBoardingManager;", "getOnBoardingManager", "()Lcom/bytedance/ee/bear/onboarding/export/IOnBoardingManager;", "onBoardingManager$delegate", "Lkotlin/Lazy;", "clickFabItem", "id", "hasSuperAgentFab", "toolbarData", "Lcom/bytedance/ee/bear/bitable/toolbox/model/toolbar/ToolbarData;", "getToolbarData", "onClickToolbarMenu", "getOnClickToolbarMenu", "setOnClickToolbarMenu", "clickToolbarMenu", "panelData", "Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelData;", "getPanelData", "panelDelegate", "Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/IPanelDelegate;", "getPanelDelegate", "()Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/IPanelDelegate;", "setPanelDelegate", "(Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/IPanelDelegate;)V", "webService", "Lcom/bytedance/ee/bear/browser/Web;", "getWebService", "()Lcom/bytedance/ee/bear/browser/Web;", "setWebService", "(Lcom/bytedance/ee/bear/browser/Web;)V", "webTouchListener", "Landroid/view/MotionEvent;", "getWebTouchListener", "setWebTouchListener", "asyncRequestDelegate", "Lcom/bytedance/ee/bear/bitable/AsyncRequestDelegate;", "getAsyncRequestDelegate", "()Lcom/bytedance/ee/bear/bitable/AsyncRequestDelegate;", "setAsyncRequestDelegate", "(Lcom/bytedance/ee/bear/bitable/AsyncRequestDelegate;)V", "notifyWebTouchEvent", "event", "toolboxAnalytic", "Lcom/bytedance/ee/bear/bitable/toolbox/BitableToolboxAnalytic;", "getToolboxAnalytic", "()Lcom/bytedance/ee/bear/bitable/toolbox/BitableToolboxAnalytic;", "setToolboxAnalytic", "(Lcom/bytedance/ee/bear/bitable/toolbox/BitableToolboxAnalytic;)V", "onGetSceneModel", "Lkotlin/Function0;", "Lcom/bytedance/ee/bear/bitable/core/infoarch/arch/SceneModel;", "getOnGetSceneModel", "()Lkotlin/jvm/functions/Function0;", "setOnGetSceneModel", "(Lkotlin/jvm/functions/Function0;)V", "getSceneModel", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableToolboxViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String FAB_SUPER_AGENT = "bitableSuperAgent";
    private com.bytedance.ee.bear.bitable.a asyncRequestDelegate;
    private final MutableLiveData<Integer> bottomPanelHeight;
    private final MutableLiveData<BitableFabModel.BitableFabItem[]> fabData;
    private final MutableLiveData<Boolean> fabVisible;
    private final Lazy onBoardingManager$delegate;
    private Function1<? super String, Unit> onClickFabItem;
    private Function1<? super String, Unit> onClickToolbarMenu;
    private Function0<SceneModel> onGetSceneModel;
    private final MutableLiveData<PanelData> panelData;
    private b panelDelegate;
    private final MutableLiveData<ToolbarData> toolbarData;
    private BitableToolboxAnalytic toolboxAnalytic;
    private k webService;
    private Function1<? super MotionEvent, Unit> webTouchListener;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final c getOnBoardingManager() {
        return (c) this.onBoardingManager$delegate.getValue();
    }

    public final SceneModel getSceneModel() {
        Function0<SceneModel> r0 = this.onGetSceneModel;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (SceneModel) r0.invoke();
    }

    public final boolean hasSuperAgentFab() {
        BitableFabModel.BitableFabItem[] r0 = (BitableFabModel.BitableFabItem[]) this.fabData.getValue();
        BitableFabModel.BitableFabItem r2 = null;
        if (r0 == null) goto L10;
        int r3 = r0.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L10;
        BitableFabModel.BitableFabItem r5 = r0[r4];
        if (Intrinsics.areEqual(r5.getId(), FAB_SUPER_AGENT) == true) goto L8;
        r4 = r4 + 1;
        goto L5
    L8:
        r2 = r5;
    L10:
        if (r2 == null) goto L15;
        return true;
    L15:
        return false;
    }

    public BitableToolboxViewModel() {
        this.fabData = new MutableLiveData();
        this.fabVisible = new MutableLiveData();
        this.bottomPanelHeight = new MutableLiveData(0);
        this.onBoardingManager$delegate = LazyKt.lazy(BitableToolboxViewModel$onBoardingManager$2.INSTANCE);
        this.toolbarData = new MutableLiveData();
        this.panelData = new MutableLiveData();
    }

    public final com.bytedance.ee.bear.bitable.a getAsyncRequestDelegate() {
        return this.asyncRequestDelegate;
    }

    public final MutableLiveData<Integer> getBottomPanelHeight() {
        return this.bottomPanelHeight;
    }

    public final MutableLiveData<BitableFabModel.BitableFabItem[]> getFabData() {
        return this.fabData;
    }

    public final MutableLiveData<Boolean> getFabVisible() {
        return this.fabVisible;
    }

    public final Function1<String, Unit> getOnClickFabItem() {
        return this.onClickFabItem;
    }

    public final Function1<String, Unit> getOnClickToolbarMenu() {
        return this.onClickToolbarMenu;
    }

    public final Function0<SceneModel> getOnGetSceneModel() {
        return this.onGetSceneModel;
    }

    public final MutableLiveData<PanelData> getPanelData() {
        return this.panelData;
    }

    public final b getPanelDelegate() {
        return this.panelDelegate;
    }

    public final MutableLiveData<ToolbarData> getToolbarData() {
        return this.toolbarData;
    }

    public final BitableToolboxAnalytic getToolboxAnalytic() {
        return this.toolboxAnalytic;
    }

    public final k getWebService() {
        return this.webService;
    }

    public final Function1<MotionEvent, Unit> getWebTouchListener() {
        return this.webTouchListener;
    }

    public final void clickFabItem(String r6) {
        Intrinsics.checkNotNullParameter(r6, "id");
        Function1<? super String, Unit> r0 = this.onClickFabItem;
        if (r0 == null) goto L6;
        r0.invoke(r6);
    L6:
        if (TextUtils.equals(r6, "shareDashboard") == false) goto L11;
        BitableToolboxAnalytic r7 = this.toolboxAnalytic;
        if (r7 == null) goto L12;
        Intrinsics.checkNotNullParameter("dashboard", "shareType");
        HashMap r2 = new HashMap(2);
        r2.put("click", "share");
        r2.put("target", "ccm_bitable_external_permission_view");
        r2.put("shareType", "dashboard");
        r7.t(BitableToolboxAnalytic.ToolboxEvent.NO_PERMISSION_CLICK, r2);
        return;
    L12:
        return;
    }

    public final void clickToolbarMenu(String r6) {
        Intrinsics.checkNotNullParameter(r6, "id");
        Function1<? super String, Unit> r0 = this.onClickToolbarMenu;
        if (r0 == null) goto L6;
        r0.invoke(r6);
    L6:
        if (TextUtils.equals(EToolbarMenu.LAYOUT.getValue(), r6) == true) goto L8;
    L10:
        MutableLiveData<ToolbarData> r1 = this.toolbarData;
        if (r1 == null) goto L32;
        ToolbarData r2 = (ToolbarData) r1.getValue();
        if (r2 == null) goto L33;
        ToolbarData.MenuItem[] r3 = r2.getMenus();
        if (r3 == null) goto L34;
        int r4 = r3.length;
        int r5 = 0;
    L17:
        if (r5 >= r4) goto L22;
        ToolbarData.MenuItem r7 = r3[r5];
        if (TextUtils.equals(r7.getId(), r6) == true) goto L23;
        r5 = r5 + 1;
    L23:
        if (r7 == null) goto L35;
        String r8 = r7.getId();
        if (r8 == null) goto L36;
        BitableToolboxAnalytic r9 = this.toolboxAnalytic;
        if (r9 == null) goto L37;
        boolean r10 = r7.getHasInvalidCondition();
        Intrinsics.checkNotNullParameter(r8, "eMenuStr");
        HashMap r11 = new HashMap(2);
        r11.put("click", r8.toLowerCase(Locale.ROOT) + "_set");
        r11.put("is_premium_limited", Boolean.valueOf(r10));
        r9.t(BitableToolboxAnalytic.ToolboxEvent.NO_PERMISSION_CLICK, r11);
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L22:
        r7 = null;
        goto L23
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L8:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("base.cardview.cover_enable") == false) goto L10;
        getOnBoardingManager().c("base_card_view_cover_support_entry");
        goto L10
    }

    public final void notifyWebTouchEvent(MotionEvent r2) {
        Function1<? super MotionEvent, Unit> r0 = this.webTouchListener;
        if (r0 == null) goto L6;
        r0.invoke(r2);
        return;
    }

    public final void setAsyncRequestDelegate(com.bytedance.ee.bear.bitable.a r1) {
        this.asyncRequestDelegate = r1;
    }

    public final void setOnClickFabItem(Function1<? super String, Unit> r1) {
        this.onClickFabItem = r1;
    }

    public final void setOnClickToolbarMenu(Function1<? super String, Unit> r1) {
        this.onClickToolbarMenu = r1;
    }

    public final void setOnGetSceneModel(Function0<SceneModel> r1) {
        this.onGetSceneModel = r1;
    }

    public final void setPanelDelegate(b r1) {
        this.panelDelegate = r1;
    }

    public final void setToolboxAnalytic(BitableToolboxAnalytic r1) {
        this.toolboxAnalytic = r1;
    }

    public final void setWebService(k r1) {
        this.webService = r1;
    }

    public final void setWebTouchListener(Function1<? super MotionEvent, Unit> r1) {
        this.webTouchListener = r1;
    }
}
