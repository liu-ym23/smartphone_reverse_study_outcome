package com.bytedance.ee.bear.middleground.permission.escape;

import android.R;
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
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeApprovalInfo;
import com.bytedance.ee.bear.middleground.permission.escape.model.Instance;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/escape/EscapeApprovalListFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", WikiFolderPushPlugin.DATA, "Lcom/bytedance/ee/bear/middleground/permission/escape/model/EscapeApprovalInfo;", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "onStart", "getAnimations", "", "Companion", "ApprovalRecordAdapter", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EscapeApprovalListFragment extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int j = 0;
    public EscapeApprovalInfo h;
    public AccountService.Account i;

    public final class a extends BaseQuickAdapter<Instance, BaseViewHolder> {
        public final /* synthetic */ EscapeApprovalListFragment a;

        public a(EscapeApprovalListFragment r2, ArrayList<Instance> r3) {
            Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.DATA);
            this.a = r2;
            super(2131558723, r3);
        }

        public final void convert(BaseViewHolder r6, Object r7) {
            Instance r8 = (Instance) r7;
            Intrinsics.checkNotNullParameter(r6, "helper");
            Intrinsics.checkNotNullParameter(r8, "item");
            EscapeApprovalListFragment r0 = this.a;
            r8.getUserAvatarUrl();
            Glide.with(((BaseQuickAdapter) this).mContext).load(new BearGlideUrl(r8.getUserAvatarUrl())).placeholder(2131235295).into((ImageView) r6.getView(2131384002));
            String r1 = r8.getUserId();
            r6.getView(2131384002).setOnClickListener(new c(r1));
            TextView r2 = (TextView) r6.getView(2131384005);
            String r3 = r8.getUserName();
            if (r3 != null) goto L6;
            r3 = "";
        L6:
            r2.setText(r3);
            long r4 = r8.getCreateTime() * ((long) CCMLynxCardView.ViewType.BANNER);
            ((TextView) r6.getView(2131384004)).setText(UIHelper.mustacheFormat(2131889900, SheetInputData.InputData.DateType.TIME, zu5.a.b(r0.getContext(), r4)));
            TextView r9 = (TextView) r6.getView(2131384003);
            String r5 = r8.getUserId();
            AccountService.Account r10 = r0.i;
            if (r10 == null) goto L9;
            String r11 = r10.uid;
        L11:
            if (TextUtils.equals(r5, r11) == false) goto L13;
            int r12 = 0;
        L14:
            r9.setVisibility(r12);
            r9.setOnClickListener(new d(r8));
            return;
        L13:
            r12 = 8;
            goto L14
        L9:
            r11 = null;
            goto L11
        }
    }

    public static final class b {
        public static void a(FragmentActivity r3, EscapeApprovalInfo r4) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            Intrinsics.checkNotNullParameter(r4, "escapeApprovalInfo");
            EscapeApprovalListFragment r0 = new EscapeApprovalListFragment();
            Bundle r1 = new Bundle();
            r1.putSerializable("extra_data", r4);
            r0.setArguments(r1);
            FragmentManager r5 = r3.getSupportFragmentManager();
            LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "EscapeApprovalListFragment", r6);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r0, r6) == true) goto L11;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r0.show(r5, "EscapeApprovalListFragment");
            return;
        }
    }

    static {
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L12;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L13;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        r2.height = -1;
        r1.setAttributes(r2);
        r1.setDimAmount(0.0f);
        r1.setWindowAnimations(2131951620);
        r1.setBackgroundDrawableResource(R.color.transparent);
        int r3 = UIUtils.getColor(getActivity(), 2131100548);
        if (ColorUtils.calculateContrast(-1, r3) > 3.0d) goto L9;
        boolean r4 = true;
    L10:
        bp5.c.f(r1, r3, r4);
        return;
    L9:
        r4 = false;
        goto L10
    L13:
        return;
    }

    public EscapeApprovalListFragment() {
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        setStyle(0, 2131952404);
        Bundle r4 = getArguments();
        if (r4 == null) goto L5;
        this.h = (EscapeApprovalInfo) r4.getSerializable("extra_data");
    L5:
        this.i = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r5, r6);
        View r7 = getView();
        BaseTitleBar r8 = null;
        if (r7 == null) goto L5;
        RecyclerView r9 = (RecyclerView) r7.findViewById(2131384071);
    L6:
        View r0 = getView();
        if (r0 == null) goto L9;
        TextView r1 = (TextView) r0.findViewById(2131363218);
    L10:
        View r2 = getView();
        if (r2 == null) goto L13;
        r8 = (BaseTitleBar) r2.findViewById(2131388775);
    L13:
        if (r9 == null) goto L15;
        r9.setLayoutManager(new LinearLayoutManager(getContext()));
    L15:
        EscapeApprovalInfo r3 = this.h;
        if (r3 == null) goto L21;
        if (r9 == null) goto L19;
        r9.setAdapter(new a(this, r3.getApprovalList().getInstances()));
    L19:
        if (r1 == null) goto L21;
        r1.setText(UIHelper.getQuantityString(2131755042, r3.getApprovalList().getInstances().size()));
    L21:
        if (r8 == null) goto L24;
        r8.setLeftClickListener(new e(this));
        return;
    L24:
        return;
    L9:
        r1 = null;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131558722, r3, false);
    }
}
