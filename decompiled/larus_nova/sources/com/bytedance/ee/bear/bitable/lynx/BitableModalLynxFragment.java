package com.bytedance.ee.bear.bitable.lynx;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.anniex.holder.BitableLynxViewHolder;
import com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.panel.PanelTitleBarContainer;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0016J\u001a\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010\u0018J\b\u0010'\u001a\u00020\u001eH\u0016J \u0010(\u001a\u00020\u001e2\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*H\u0016J\b\u0010,\u001a\u00020\u0006H\u0016J\u0016\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/bitable/lynx/BitableModalLynxFragment;", "Lcom/bytedance/ee/bear/bitable/common/fragment/BaseActionPanelFragment;", "Lcom/bytedance/ee/bear/bitable/lynx/ILynxToJSBridgeService;", "viewType", "", "bridge", "", "onClose", "Ljava/lang/Runnable;", "<init>", "(ILjava/lang/String;Ljava/lang/Runnable;)V", "getViewType", "()I", "getBridge", "()Ljava/lang/String;", "getOnClose", "()Ljava/lang/Runnable;", "setOnClose", "(Ljava/lang/Runnable;)V", "dataString", "Landroidx/lifecycle/MutableLiveData;", "lynxViewHolder", "Lcom/bytedance/ee/bear/anniex/IBitableLarkLynxKitViewHolder;", "callBack", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "onCreateContentView", "Landroid/view/View;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "", "view", "savedInstanceState", "Landroid/os/Bundle;", "initPanel", WidgetCostModule.TYPE_ON_START, "updateData", "dataJson", "callBackFunction", LiveCommonConstants.REASON_ON_DEDTROY, "onCallback", "params", "", "", "getBridgeName", "updateDragPanelTitleBar", "data", "callback", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableModalLynxFragment extends BaseActionPanelFragment implements h {
    public static final /* synthetic */ int M = 0;
    public final int G;
    public final String H;
    public final Runnable I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final MutableLiveData<String> f214622J;
    public BitableLynxViewHolder K;
    public m L;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        BitableLynxViewHolder r100 = this.K;
        if (r100 == null) goto L5;
        r100.b();
    L5:
        this.I.run();
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L8;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L9;
        r101.setSoftInputMode(48);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.lynx.h
    public final String Hk() {
        return this.H;
    }

    @Override // com.bytedance.ee.bear.bitable.lynx.h
    public final void Gu(Map<String, ? extends Object> r100) {
        tt5.a.h("BitableModalLynxFragment", "onCallBack: " + r100);
        JSONObject r101 = new JSONObject(r100);
        m r102 = this.L;
        if (r102 == null) goto L6;
        r102.b(r101);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment
    public final View la0(CommonActionPanelLayout r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.bitable_lynx_biz_fragment, r100, false);
        fo4.a r102 = new fo4.a(r101.getContext(), this.G);
        d r103 = new d();
        Intrinsics.checkNotNullParameter(r103, "lynxViewClient");
        r102.f478120e = r103;
        e r104 = new e();
        Intrinsics.checkNotNullParameter(r104, NewBroadcastMonitor.STAGE.LIFECYCLE);
        r102.f478119d = r104;
        BitableLynxViewHolder r105 = eo4.a.a(r102);
        this.K = r105;
        View r106 = r105.c(false);
        if (r106 != null) goto L5;
    L10:
        BitableLynxViewHolder r107 = this.K;
        if (r107 == null) goto L13;
        r107.i(h.class, this);
    L13:
        BitableLynxViewHolder r108 = this.K;
        if (r108 == null) goto L16;
        r108.f();
    L16:
        this.f214622J.observe(this, new f(this));
        return r101;
    L5:
        if ((r101 instanceof FrameLayout) == false) goto L7;
        FrameLayout r109 = (FrameLayout) r101;
    L8:
        if (r109 == null) goto L10;
        r109.addView(r106, new ViewGroup.LayoutParams(-1, -1));
        goto L10
    L7:
        r109 = null;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        qa0(true);
        this.f209815p = 0;
        dn(Float.valueOf(0.8f), Float.valueOf(0.4f), Float.valueOf(0.8f));
        pa0(R.color.bg_float);
        wa0(R.color.bg_float);
        PanelTitleBarContainer r102 = null;
        ia0().e(R.drawable.ud_icon_close_small_outlined, null);
        CommonActionPanelLayout r103 = ia0();
        Context r104 = getContext();
        if (r104 == null) goto L5;
        String r105 = r104.getString(R.string.Bitable_Common_ButtonConfirm_Mobile);
    L6:
        r103.h(r105, Integer.valueOf(R.color.primary_content_default));
        ia0().setRightTextSize(16.0f);
        ia0().setTitleBarHeight(54);
        CommonActionPanelLayout r106 = ia0();
        PanelTitleBarContainer r107 = r106.f240270f;
        if (r107 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r107 = null;
    L9:
        r107.setPadding(n.d(0), n.d(1), n.d(0), n.d(0));
        PanelTitleBarContainer r108 = r106.f240270f;
        if (r108 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
    L13:
        r102.requestLayout();
        return;
    L12:
        r102 = r108;
        goto L13
    L5:
        r105 = null;
        goto L6
    }

    public BitableModalLynxFragment(int r100, String r101, com.bytedance.ee.bear.bitable.lynx.a r102) {
        Intrinsics.checkNotNullParameter(r101, "bridge");
        Intrinsics.checkNotNullParameter(r102, "onClose");
        this.G = r100;
        this.H = r101;
        this.I = r102;
        this.f214622J = new MutableLiveData();
    }
}
