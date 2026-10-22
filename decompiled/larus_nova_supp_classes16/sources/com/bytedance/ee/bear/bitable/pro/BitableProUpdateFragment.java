package com.bytedance.ee.bear.bitable.pro;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment;
import com.bytedance.ee.bear.shadow.ShadowLinearLayout;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0016J\u0012\u00100\u001a\u0004\u0018\u00010\u001d2\u0006\u00101\u001a\u000202H\u0016J\u0012\u00103\u001a\u00020#2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u001a\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020\u001d2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00108\u001a\u00020#H\u0016J\b\u00109\u001a\u00020#H\u0002J\b\u0010:\u001a\u00020#H\u0002J\b\u0010;\u001a\u00020#H\u0002J\b\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u000202H\u0002J\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/BitableProUpdateFragment;", "Lcom/bytedance/ee/bear/bitable/common/fragment/BaseActionPanelFragment;", "<init>", "()V", "updateImageFromXml", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "getUpdateImageFromXml", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "setUpdateImageFromXml", "(Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;)V", "referenceDataDescFromXml", "Landroid/widget/TextView;", "getReferenceDataDescFromXml", "()Landroid/widget/TextView;", "setReferenceDataDescFromXml", "(Landroid/widget/TextView;)V", "recyclerViewFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerViewFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerViewFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "effectListFromXml", "Lcom/bytedance/ee/bear/shadow/ShadowLinearLayout;", "getEffectListFromXml", "()Lcom/bytedance/ee/bear/shadow/ShadowLinearLayout;", "setEffectListFromXml", "(Lcom/bytedance/ee/bear/shadow/ShadowLinearLayout;)V", "bottomViewFromXml", "Landroid/view/View;", "getBottomViewFromXml", "()Landroid/view/View;", "setBottomViewFromXml", "(Landroid/view/View;)V", "clearFromXmlViewCache", "", "onDestroyView", "showUpdateBtn", "", "formulaInfoList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/pro/PermEffectFieldData$IEffectFormulaDetailInfo;", "Lkotlin/collections/ArrayList;", "adapter", "Lcom/bytedance/ee/bear/bitable/pro/BitableProUpdateAdapter;", "bottomView", "viewModel", "Lcom/bytedance/ee/bear/bitable/pro/BitableProViewModel;", "onCreateContentView", "container", "Landroid/view/ViewGroup;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onStart", "parseArguments", "initPanelStyle", "initView", "getUpdateGifUrl", "", "initBottomView", "dialogContainer", "covertList", "", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableProUpdateFragment extends BaseActionPanelFragment {
    public static final /* synthetic */ int Q = 0;
    public LKUIRoundedImageView2 G;
    public TextView H;
    public RecyclerView I;
    public ShadowLinearLayout J;
    public View K;
    public boolean L;
    public ArrayList<PermEffectFieldData.IEffectFormulaDetailInfo> M;
    public BitableProUpdateAdapter N;
    public View O;
    public BitableProViewModel P;

    public static final class a {
    }

    static {
    }

    public final LKUIRoundedImageView2 ya0() {
        View r0 = this.G;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131391902);
    L8:
        this.G = (LKUIRoundedImageView2) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (LKUIRoundedImageView2) r0;
    }

    public BitableProUpdateFragment() {
        this.M = new ArrayList();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        View r1 = null;
        if (r0 == null) goto L7;
        Window r2 = r0.getWindow();
        if (r2 == null) goto L7;
        FrameLayout r3 = (FrameLayout) r2.findViewById(2131367728);
    L8:
        if (r3 != null) goto L10;
        return;
    L10:
        if (this.L == false) goto L19;
        View r4 = LayoutInflater.from(getContext()).inflate(2131559183, r3);
        this.O = r4;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("bottomView");
        r4 = null;
    L14:
        r4.findViewById(2131365115).setOnClickListener(new d0(this));
        View r5 = this.O;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("bottomView");
    L18:
        r1.findViewById(2131391889).setOnClickListener(new e0(this));
        return;
    L17:
        r1 = r5;
        goto L18
    L19:
        View r6 = LayoutInflater.from(getContext()).inflate(2131559012, r3);
        this.O = r6;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("bottomView");
    L23:
        r1.findViewById(2131374197).setOnClickListener(new f0(this));
        return;
    L22:
        r1 = r6;
    L7:
        r3 = null;
        goto L8
    }

    public final View la0(CommonActionPanelLayout r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        return LayoutInflater.from(requireContext()).inflate(2131559185, r4, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r2) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment*/.onCreate(r2);
        this.P = (BitableProViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, BitableProViewModel.class);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        boolean r4 = r3.getBoolean("show_update");
    L6:
        this.L = r4;
        Bundle r5 = getArguments();
        if (r5 == null) goto L9;
        Serializable r6 = r5.getSerializable("formula_info");
    L10:
        if (r6 == null) goto L13;
        this.M = (ArrayList) r6;
        return;
    L13:
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r7, r8);
        pa0(2131100557);
        ((BaseActionPanelFragment) this).p = 1;
        View r1 = null;
        com.bytedance.ee.bear.bitable.common.fragment.b.c(this, null, null, Float.valueOf(0.9f), 3);
        if (this.L == false) goto L5;
        int r9 = 2131886212;
    L6:
        va0(getString(r9));
        int r3 = 0;
        JSONArray r4 = new JSONArray(((s45.c) org.koin.java.a.c(s45.c.class, null, null, 6)).Ba("overload_static_domain_new"));     // Catch: JSONException -> L11
        if (r4.length() <= 0) goto L13;
        String r0 = r4.optString(0, "");     // Catch: JSONException -> L11
    L15:
        if (TextUtils.isEmpty(r0) == false) goto L17;
        tt5.a.d("BitableProUpdateFragment", "domain is empty.");
    L17:
        String r10 = ((com.bytedance.ee.bear.contract.i0) org.koin.java.a.c(com.bytedance.ee.bear.contract.i0.class, null, null, 6)).a();
        if (Intrinsics.areEqual(Locale.ENGLISH.getLanguage(), r10) == false) goto L21;
    L26:
        String r11 = "/ccm/static_resource/scm_upload/ccm_bitable_permission_update_gif_EN.gif";
    L27:
        Glide.with(requireContext()).load(new BearGlideUrl("https://" + r0 + r11)).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder(2131254899).error(2131254899).addListener(new g0(this)).into(ya0());
        View r12 = this.H;
        if (r12 != null) goto L34;
        View r13 = getView();
        if (r13 == null) goto L32;
        r12 = r13.findViewById(2131384125);
    L33:
        this.H = (TextView) r12;
        goto L34
    L32:
        r12 = null;
    L34:
        TextView r14 = (TextView) r12;
        if (this.L == false) goto L37;
        int r2 = 2131886207;
    L38:
        r14.setText(getString(r2));
        ArrayList r16 = new ArrayList();
        Iterator<PermEffectFieldData.IEffectFormulaDetailInfo> r5 = this.M.iterator();
    L40:
        if (r5.hasNext() == false) goto L47;
        PermEffectFieldData.IEffectFormulaDetailInfo r6 = r5.next();
        r16.add(r6);
        ArrayList<PermEffectFieldData.IEffectFormulaDetailFieldInfo> r17 = r6.getFormulaFieldInfo();
        if (r17 == null) goto L40;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<T> r19 = r17.iterator();
    L45:
        if (r19.hasNext() == false) goto L40;
        r18.add(Boolean.valueOf(r16.add((PermEffectFieldData.IEffectFormulaDetailFieldInfo) r19.next())));
        goto L45
    L47:
        this.N = new BitableProUpdateAdapter(r16);
        View r20 = this.I;
        if (r20 != null) goto L54;
        View r21 = getView();
        if (r21 == null) goto L52;
        r20 = r21.findViewById(2131384076);
    L53:
        this.I = (RecyclerView) r20;
        goto L54
    L52:
        r20 = null;
    L54:
        RecyclerView r22 = (RecyclerView) r20;
        RecyclerView.Adapter r23 = this.N;
        if (r23 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r23 = null;
    L57:
        r22.setAdapter(r23);
        View r24 = this.I;
        if (r24 != null) goto L64;
        View r26 = getView();
        if (r26 == null) goto L62;
        r24 = r26.findViewById(2131384076);
    L63:
        this.I = (RecyclerView) r24;
        goto L64
    L62:
        r24 = null;
    L64:
        ((RecyclerView) r24).setLayoutManager(new LinearLayoutManager(getContext()));
        View r27 = this.J;
        if (r27 != null) goto L71;
        View r28 = getView();
        if (r28 == null) goto L69;
        r27 = r28.findViewById(2131371497);
    L70:
        this.J = (ShadowLinearLayout) r27;
        goto L71
    L69:
        r27 = null;
    L71:
        ShadowLinearLayout r29 = (ShadowLinearLayout) r27;
        if (r16.isEmpty() == false) goto L74;
        r3 = 8;
    L74:
        r29.setVisibility(r3);
        View r30 = this.K;
        if (r30 != null) goto L81;
        View r31 = getView();
        if (r31 == null) goto L79;
        r30 = r31.findViewById(2131364548);
    L80:
        this.K = r30;
        goto L81
    L79:
        r30 = null;
    L81:
        ViewGroup.LayoutParams r32 = r30.getLayoutParams();
        if (this.L == false) goto L84;
        int r33 = 80;
    L85:
        r32.height = com.bytedance.ee.util.ui.n.d(r33);
        View r34 = this.K;
        if (r34 != null) goto L91;
        View r36 = getView();
        if (r36 == null) goto L90;
        r1 = r36.findViewById(2131364548);
    L90:
        this.K = r1;
        r34 = r1;
    L91:
        r34.setLayoutParams(r32);
        int r37 = d.a;
        boolean r38 = true ^ this.L;
        JSONObject r39 = new JSONObject();
        if (r38 == false) goto L94;
        String r40 = "backend";
    L95:
        r39.put("calculation_type", r40);
        d.b("ccm_bitable_premium_permission_calculation_type_view", r39);
        return;
    L94:
        r40 = "frontend";
        goto L95
    L84:
        r33 = 48;
        goto L85
    L37:
        r2 = 2131886126;
        goto L38
    L21:
        if (Intrinsics.areEqual(Locale.JAPANESE.getLanguage(), r10) == false) goto L24;
        r11 = "/ccm/static_resource/scm_upload/ccm_bitable_permission_update_gif_JP.gif";
        goto L27
    L24:
        if (Intrinsics.areEqual(Locale.CHINA.getLanguage(), r10) == false) goto L26;
        r11 = "/ccm/static_resource/scm_upload/ccm_bitable_permission_update_gif_CN.gif";
    L13:
        r0 = "lf-package-cn.feishucdn.com/obj/feishu-static";
    L11:
        e = move-exception;
        tt5.a.d("BitableProUpdateFragment", "getUpdateGifUrl err " + e);
        goto L13
    L5:
        r9 = 2131886125;
        goto L6
    }
}
