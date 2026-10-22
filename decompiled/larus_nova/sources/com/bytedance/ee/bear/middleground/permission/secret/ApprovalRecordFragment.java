package com.bytedance.ee.bear.middleground.permission.secret;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.UIHelper;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010!\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020%2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010,\u001a\u00020\u0017H\u0002J\b\u0010-\u001a\u00020\u0017H\u0016J\b\u0010.\u001a\u00020 H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/ApprovalRecordFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "recyclerViewFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerViewFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerViewFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "approvalRecordTipFromXml", "Landroid/widget/TextView;", "getApprovalRecordTipFromXml", "()Landroid/widget/TextView;", "setApprovalRecordTipFromXml", "(Landroid/widget/TextView;)V", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "clearFromXmlViewCache", "", "onDestroyView", "data", "Lcom/bytedance/ee/bear/middleground/permission/secret/SecretReviewModel;", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", "viewFrom", "", "type", "", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", WidgetCostModule.TYPE_ON_START, "getAnimations", "Companion", "ApprovalRecordAdapter", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApprovalRecordFragment extends BaseAntiScreenshotsDialogFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f233893o = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RecyclerView f233894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f233895i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BaseTitleBar f233896j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SecretReviewModel f233897k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AccountService$Account f233898l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f233899m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f233900n;

    public final class a extends BaseQuickAdapter<SecretApprovalInstanceModel.Instance, BaseViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ApprovalRecordFragment f233901a;

        public a(ApprovalRecordFragment r100, ArrayList<SecretApprovalInstanceModel.Instance> r101) {
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f233901a = r100;
            super(R.layout.approval_record_item, r101);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public final void convert(BaseViewHolder r100, SecretApprovalInstanceModel.Instance r101) {
            SecretApprovalInstanceModel.Instance r102 = r101;
            Intrinsics.checkNotNullParameter(r100, "helper");
            ApprovalRecordFragment r103 = this.f233901a;
            if (r102 != null) goto L5;
        L7:
            if (r102 == null) goto L9;
            ((UDAvatar) r100.getView(R.id.record_item_avatar)).setOnClickListener(new com.bytedance.ee.bear.middleground.permission.secret.a(Long.valueOf(r102.getUser_id()).longValue()));
        L9:
            TextView r104 = (TextView) r100.getView(R.id.record_item_name);
            if (r102 == null) goto L14;
            String r105 = r102.getUser_name();
            if (r105 == null) goto L14;
        L15:
            r104.setText(r105);
            if (r102 == null) goto L18;
            long r106 = r102.getCreate_time();
        L19:
            ((TextView) r100.getView(R.id.record_item_info)).setText(UIHelper.mustacheFormat(R.string.LarkCCM_Workspace_SecLeviI_AdjustRequest_ByWhen, "time", zu5.a.b(r103.getContext(), r106 * ((long) 1000))));
            TextView r107 = (TextView) r100.getView(R.id.record_item_check_process);
            String r108 = null;
            if (r102 == null) goto L22;
            Long r109 = Long.valueOf(r102.getUser_id());
        L23:
            String r110 = String.valueOf(r109);
            AccountService$Account r111 = r103.f233898l;
            if (r111 == null) goto L27;
            r108 = r111.uid;
        L27:
            if (TextUtils.equals(r110, r108) == false) goto L29;
            int r112 = 0;
        L30:
            r107.setVisibility(r112);
            r107.setOnClickListener(new com.bytedance.ee.bear.middleground.permission.secret.b(r102, this, r103));
            return;
        L29:
            r112 = 8;
            goto L30
        L22:
            r109 = null;
            goto L23
        L18:
            r106 = 0;
        L14:
            r105 = "";
            goto L15
        L5:
            if (r102.getUser_avatar_url() == null) goto L7;
            Glide.with(this.mContext).load(new BearGlideUrl(r102.getUser_avatar_url())).placeholder(R.drawable.facade_common_avatar_place_holder).into((ImageView) r100.getView(R.id.record_item_avatar));
            goto L7
        }
    }

    public static final class b {
        public static void a(ApprovalRecordFragment r100, FragmentManager r101) {
            LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "ApprovalRecordFragment", r102);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r100.show(r101, "ApprovalRecordFragment");
        }

        public static void b(FragmentActivity r100, SecretReviewModel r101, String r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r102, "viewFrom");
            ApprovalRecordFragment r104 = new ApprovalRecordFragment();
            Bundle r105 = new Bundle();
            r105.putSerializable("extra_data", r101);
            r105.putString("extra_view_from", r102);
            r105.putInt("extra_type", r103);
            r104.setArguments(r105);
            a(r104, r100.getSupportFragmentManager());
            boolean r106 = false;
            if (r101 == null) goto L7;
            ArrayList<SecretApprovalInstanceModel.Instance> r107 = r101.getInstanceArrayList();
            if (r107 == null) goto L7;
            int r108 = r107.size();
        L9:
            if (r108 != 1) goto L11;
            r106 = true;
        L11:
            com.bytedance.ee.bear.middleground.permission.c.j(r106, r102);
            return;
        L7:
            r108 = 0;
            goto L9
        }
    }

    static {
    }

    public ApprovalRecordFragment() {
        this.f233899m = "";
        this.f233900n = sbb.e.f541296g.f541317b;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f233894h = null;
        this.f233895i = null;
        this.f233896j = null;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L12;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L13;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.width = -1;
        r102.height = -1;
        r101.setAttributes(r102);
        r101.setDimAmount(0.0f);
        r101.setWindowAnimations(R.style.ActionSheetAnimation);
        r101.setBackgroundDrawableResource(android.R.color.transparent);
        int r103 = UIUtils.getColor(getActivity(), R.color.bg_body);
        if (ColorUtils.calculateContrast(-1, r103) > 3.0d) goto L9;
        boolean r104 = true;
    L10:
        bp5.c.f(r101, r103, r104);
        return;
    L9:
        r104 = false;
        goto L10
    L13:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(0, R.style.InviteMemberFullDialogFragment);
        Bundle r101 = getArguments();
        if (r101 != null) goto L22;
    L20:
        this.f233898l = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        return;
    L22:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        Serializable r103 = r101.getSerializable("extra_data");     // Catch: Throwable -> L11
        if ((r103 instanceof SecretReviewModel) == false) goto L8;
        SecretReviewModel r104 = (SecretReviewModel) r103;     // Catch: Throwable -> L11
    L9:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L11
    L13:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L17;
        tt5.a.e("ApprovalRecordFragment", "deserialize extra_data failed", r106, false);
    L17:
        if (Result.m9455isFailureimpl(r105) == false) goto L19;
        r105 = null;
    L19:
        this.f233897k = (SecretReviewModel) r105;
        this.f233899m = r101.getString("extra_view_from", "");
        this.f233900n = r101.getInt("extra_type", sbb.e.f541296g.f541317b);
        goto L20
    L8:
        r104 = null;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        View r112 = this.f233894h;
        View r100 = null;
        if (r112 != null) goto L9;
        View r113 = getView();
        if (r113 == null) goto L7;
        r112 = r113.findViewById(R.id.recyclerView);
    L8:
        this.f233894h = (RecyclerView) r112;
        goto L9
    L7:
        r112 = null;
    L9:
        ((RecyclerView) r112).setLayoutManager(new LinearLayoutManager(getContext()));
        SecretReviewModel r114 = this.f233897k;
        if (r114 == null) goto L49;
        ArrayList<SecretApprovalInstanceModel.Instance> r101 = r114.getInstanceArrayList();
        if (r101 != null) goto L14;
        r101 = new ArrayList();
    L14:
        View r102 = this.f233894h;
        if (r102 != null) goto L21;
        View r103 = getView();
        if (r103 == null) goto L19;
        r102 = r103.findViewById(R.id.recyclerView);
    L20:
        this.f233894h = (RecyclerView) r102;
        goto L21
    L19:
        r102 = null;
    L21:
        ((RecyclerView) r102).setAdapter(new a(this, r101));
        int r115 = r101.size();
        if (r115 != 1) goto L32;
        Context r104 = getContext();
        if (r104 == null) goto L30;
        int r105 = a0.f234022a;
        int r106 = this.f233900n;
        if (r115 != 1) goto L28;
        int r116 = a0.a(r106, R.string.LarkCCM_ChatShare_OneSecurityLevelRequestPending_Text, R.string.LarkCCM_Workspace_SecLeviI_xRequest2Adjust_1_Mob);
    L29:
        String r117 = r104.getString(r116);
    L31:
        String r118 = UIHelper.mustacheFormat(r117, "secure_label", r114.getSecretLevel().getName());
    L41:
        View r119 = this.f233895i;
        if (r119 != null) goto L48;
        View r120 = getView();
        if (r120 == null) goto L46;
        r119 = r120.findViewById(R.id.approval_record_tip);
    L47:
        this.f233895i = (TextView) r119;
        goto L48
    L46:
        r119 = null;
    L48:
        ((TextView) r119).setText(r118);
        goto L49
    L28:
        r116 = a0.a(r106, R.string.LarkCCM_ChatShare_SecurityLevelRequestsPending_Text, R.string.LarkCCM_Workspace_SecLeviI_xRequest2Adjust_N_Mob);
        goto L29
    L30:
        r117 = null;
        goto L31
    L32:
        Context r107 = getContext();
        if (r107 == null) goto L39;
        int r108 = a0.f234022a;
        int r109 = this.f233900n;
        if (r115 != 1) goto L37;
        int r121 = a0.a(r109, R.string.LarkCCM_ChatShare_OneSecurityLevelRequestPending_Text, R.string.LarkCCM_Workspace_SecLeviI_xRequest2Adjust_1_Mob);
    L38:
        String r122 = r107.getString(r121);
    L40:
        r118 = UIHelper.mustacheFormat(r122, MapsKt.mapOf(new Pair[]{TuplesKt.to("number", String.valueOf(r115)), TuplesKt.to("secure_label", r114.getSecretLevel().getName())}));
        goto L41
    L37:
        r121 = a0.a(r109, R.string.LarkCCM_ChatShare_SecurityLevelRequestsPending_Text, R.string.LarkCCM_Workspace_SecLeviI_xRequest2Adjust_N_Mob);
        goto L38
    L39:
        r122 = null;
    L49:
        View r123 = this.f233896j;
        if (r123 != null) goto L55;
        View r124 = getView();
        if (r124 == null) goto L54;
        r100 = r124.findViewById(R.id.titleBar);
    L54:
        this.f233896j = (BaseTitleBar) r100;
        r123 = r100;
    L55:
        ((BaseTitleBar) r123).setLeftClickListener(new c(this));
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.approval_record_fragment, r101, false);
    }
}
