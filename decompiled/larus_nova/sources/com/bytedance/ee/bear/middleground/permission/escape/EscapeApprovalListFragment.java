package com.bytedance.ee.bear.middleground.permission.escape;

import android.app.Dialog;
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
import com.baidu.platform.comapi.map.MapController;
import com.bumptech.glide.Glide;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeApprovalInfo;
import com.bytedance.ee.bear.middleground.permission.escape.model.Instance;
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
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/escape/EscapeApprovalListFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "data", "Lcom/bytedance/ee/bear/middleground/permission/escape/model/EscapeApprovalInfo;", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", WidgetCostModule.TYPE_ON_START, "getAnimations", "", "Companion", "ApprovalRecordAdapter", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EscapeApprovalListFragment extends BaseAntiScreenshotsDialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f233847j = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public EscapeApprovalInfo f233848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AccountService$Account f233849i;

    public final class a extends BaseQuickAdapter<Instance, BaseViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EscapeApprovalListFragment f233850a;

        public a(EscapeApprovalListFragment r100, ArrayList<Instance> r101) {
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f233850a = r100;
            super(R.layout.approval_record_item, r101);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public final void convert(BaseViewHolder r100, Instance r101) {
            Instance r102 = r101;
            Intrinsics.checkNotNullParameter(r100, "helper");
            Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
            EscapeApprovalListFragment r103 = this.f233850a;
            r102.getUserAvatarUrl();
            Glide.with(this.mContext).load(new BearGlideUrl(r102.getUserAvatarUrl())).placeholder(R.drawable.facade_common_avatar_place_holder).into((ImageView) r100.getView(R.id.record_item_avatar));
            String r104 = r102.getUserId();
            ((UDAvatar) r100.getView(R.id.record_item_avatar)).setOnClickListener(new c(r104));
            TextView r105 = (TextView) r100.getView(R.id.record_item_name);
            String r106 = r102.getUserName();
            if (r106 != null) goto L6;
            r106 = "";
        L6:
            r105.setText(r106);
            long r107 = r102.getCreateTime() * ((long) 1000);
            ((TextView) r100.getView(R.id.record_item_info)).setText(UIHelper.mustacheFormat(R.string.LarkCCM_Workspace_SecLeviI_AdjustRequest_ByWhen, "time", zu5.a.b(r103.getContext(), r107)));
            TextView r108 = (TextView) r100.getView(R.id.record_item_check_process);
            String r109 = r102.getUserId();
            AccountService$Account r110 = r103.f233849i;
            if (r110 == null) goto L9;
            String r111 = r110.uid;
        L11:
            if (TextUtils.equals(r109, r111) == false) goto L13;
            int r112 = 0;
        L14:
            r108.setVisibility(r112);
            r108.setOnClickListener(new d(r102));
            return;
        L13:
            r112 = 8;
            goto L14
        L9:
            r111 = null;
            goto L11
        }
    }

    public static final class b {
        public static void a(FragmentActivity r100, EscapeApprovalInfo r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "escapeApprovalInfo");
            EscapeApprovalListFragment r102 = new EscapeApprovalListFragment();
            Bundle r103 = new Bundle();
            r103.putSerializable("extra_data", r101);
            r102.setArguments(r103);
            FragmentManager r104 = r100.getSupportFragmentManager();
            LandscapeRestrictionOperation r105 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r102, "EscapeApprovalListFragment", r105);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r104, r102, r105) == true) goto L11;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r102.show(r104, "EscapeApprovalListFragment");
            return;
        }
    }

    static {
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

    public EscapeApprovalListFragment() {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(0, R.style.InviteMemberFullDialogFragment);
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        this.f233848h = (EscapeApprovalInfo) r101.getSerializable("extra_data");
    L5:
        this.f233849i = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = getView();
        BaseTitleBar r103 = null;
        if (r102 == null) goto L5;
        RecyclerView r104 = (RecyclerView) r102.findViewById(R.id.recyclerView);
    L6:
        View r105 = getView();
        if (r105 == null) goto L9;
        TextView r106 = (TextView) r105.findViewById(R.id.approval_record_tip);
    L10:
        View r107 = getView();
        if (r107 == null) goto L13;
        r103 = (BaseTitleBar) r107.findViewById(R.id.titleBar);
    L13:
        if (r104 == null) goto L15;
        r104.setLayoutManager(new LinearLayoutManager(getContext()));
    L15:
        EscapeApprovalInfo r108 = this.f233848h;
        if (r108 == null) goto L21;
        if (r104 == null) goto L19;
        r104.setAdapter(new a(this, r108.getApprovalList().getInstances()));
    L19:
        if (r106 == null) goto L21;
        r106.setText(UIHelper.getQuantityString(R.plurals.LarkCCM_InviteExternalCollab_RequestedByNum_Text, r108.getApprovalList().getInstances().size()));
    L21:
        if (r103 == null) goto L24;
        r103.setLeftClickListener(new e(this));
        return;
    L24:
        return;
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.approval_record_fragment, r101, false);
    }
}
