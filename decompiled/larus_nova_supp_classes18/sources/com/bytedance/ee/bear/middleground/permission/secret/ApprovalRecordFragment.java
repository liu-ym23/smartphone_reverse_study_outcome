package com.bytedance.ee.bear.middleground.permission.secret;

import android.R;
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
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
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
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010!\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020%2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010,\u001a\u00020\u0017H\u0002J\b\u0010-\u001a\u00020\u0017H\u0016J\b\u0010.\u001a\u00020 H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/ApprovalRecordFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "recyclerViewFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerViewFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerViewFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "approvalRecordTipFromXml", "Landroid/widget/TextView;", "getApprovalRecordTipFromXml", "()Landroid/widget/TextView;", "setApprovalRecordTipFromXml", "(Landroid/widget/TextView;)V", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "clearFromXmlViewCache", "", "onDestroyView", WikiFolderPushPlugin.DATA, "Lcom/bytedance/ee/bear/middleground/permission/secret/SecretReviewModel;", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", "viewFrom", "", ResourceData.KEY_TYPE, "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "onStart", "getAnimations", "Companion", "ApprovalRecordAdapter", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApprovalRecordFragment extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int o = 0;
    public RecyclerView h;
    public TextView i;
    public BaseTitleBar j;
    public SecretReviewModel k;
    public AccountService.Account l;
    public String m;
    public int n;

    public final class a extends BaseQuickAdapter<SecretApprovalInstanceModel.Instance, BaseViewHolder> {
        public final /* synthetic */ ApprovalRecordFragment a;

        public a(ApprovalRecordFragment r2, ArrayList<SecretApprovalInstanceModel.Instance> r3) {
            Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.DATA);
            this.a = r2;
            super(2131558723, r3);
        }

        public final void convert(BaseViewHolder r6, Object r7) {
            SecretApprovalInstanceModel.Instance r8 = (SecretApprovalInstanceModel.Instance) r7;
            Intrinsics.checkNotNullParameter(r6, "helper");
            ApprovalRecordFragment r0 = this.a;
            if (r8 != null) goto L5;
        L7:
            if (r8 == null) goto L9;
            r6.getView(2131384002).setOnClickListener(new com.bytedance.ee.bear.middleground.permission.secret.a(Long.valueOf(r8.getUser_id()).longValue()));
        L9:
            TextView r1 = (TextView) r6.getView(2131384005);
            if (r8 == null) goto L14;
            String r2 = r8.getUser_name();
            if (r2 == null) goto L14;
        L15:
            r1.setText(r2);
            if (r8 == null) goto L18;
            long r3 = r8.getCreate_time();
        L19:
            ((TextView) r6.getView(2131384004)).setText(UIHelper.mustacheFormat(2131889900, SheetInputData.InputData.DateType.TIME, zu5.a.b(r0.getContext(), r3 * ((long) CCMLynxCardView.ViewType.BANNER))));
            TextView r9 = (TextView) r6.getView(2131384003);
            String r4 = null;
            if (r8 == null) goto L22;
            Long r5 = Long.valueOf(r8.getUser_id());
        L23:
            String r10 = String.valueOf(r5);
            AccountService.Account r11 = r0.l;
            if (r11 == null) goto L27;
            r4 = r11.uid;
        L27:
            if (TextUtils.equals(r10, r4) == false) goto L29;
            int r12 = 0;
        L30:
            r9.setVisibility(r12);
            r9.setOnClickListener(new com.bytedance.ee.bear.middleground.permission.secret.b(r8, this, r0));
            return;
        L29:
            r12 = 8;
            goto L30
        L22:
            r5 = null;
            goto L23
        L18:
            r3 = 0;
        L14:
            r2 = "";
            goto L15
        L5:
            if (r8.getUser_avatar_url() == null) goto L7;
            Glide.with(((BaseQuickAdapter) this).mContext).load(new BearGlideUrl(r8.getUser_avatar_url())).placeholder(2131235295).into((ImageView) r6.getView(2131384002));
            goto L7
        }
    }

    public static final class b {
        public static void a(ApprovalRecordFragment r2, FragmentManager r3) {
            LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "ApprovalRecordFragment", r0);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r2.show(r3, "ApprovalRecordFragment");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void b(FragmentActivity r3, SecretReviewModel r4, String r5, int r6) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            Intrinsics.checkNotNullParameter(r5, "viewFrom");
            ApprovalRecordFragment r0 = new ApprovalRecordFragment();
            Bundle r1 = new Bundle();
            r1.putSerializable("extra_data", r4);
            r1.putString("extra_view_from", r5);
            r1.putInt("extra_type", r6);
            r0.setArguments(r1);
            a(r0, r3.getSupportFragmentManager());
            boolean r7 = false;
            if (r4 == 0) goto L7;
            ArrayList<SecretApprovalInstanceModel.Instance> r8 = r4.getInstanceArrayList();
            if (r8 == null) goto L7;
            int r9 = r8.size();
        L9:
            if (r9 != 1) goto L11;
            r7 = true;
        L11:
            com.bytedance.ee.bear.middleground.permission.c.j(r7, r5);
            return;
        L7:
            r9 = 0;
            goto L9
        }
    }

    static {
    }

    public ApprovalRecordFragment() {
        this.m = "";
        this.n = sbb.e.g.b;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.h = null;
        this.i = null;
        this.j = null;
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

    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        setStyle(0, 2131952404);
        Bundle r0 = getArguments();
        if (r0 != null) goto L22;
    L20:
        this.l = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        return;
    L22:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        Object r2 = r0.getSerializable("extra_data");     // Catch: Throwable -> L11
        if ((r2 instanceof SecretReviewModel) == false) goto L8;
        SecretReviewModel r4 = (SecretReviewModel) r2;     // Catch: Throwable -> L11
    L9:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L11
    L13:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L17;
        tt5.a.e("ApprovalRecordFragment", "deserialize extra_data failed", r6, false);
    L17:
        if (Result.isFailure-impl(r5) == false) goto L19;
        r5 = null;
    L19:
        this.k = (SecretReviewModel) r5;
        this.m = r0.getString("extra_view_from", "");
        this.n = r0.getInt("extra_type", sbb.e.g.b);
        goto L20
    L8:
        r4 = null;
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r10, r11);
        View r12 = this.h;
        View r0 = null;
        if (r12 != null) goto L9;
        View r13 = getView();
        if (r13 == null) goto L7;
        r12 = r13.findViewById(2131384071);
    L8:
        this.h = (RecyclerView) r12;
        goto L9
    L7:
        r12 = null;
    L9:
        ((RecyclerView) r12).setLayoutManager(new LinearLayoutManager(getContext()));
        SecretReviewModel r14 = this.k;
        if (r14 == null) goto L49;
        ArrayList<SecretApprovalInstanceModel.Instance> r1 = r14.getInstanceArrayList();
        if (r1 != null) goto L14;
        r1 = new ArrayList();
    L14:
        RecyclerView r2 = this.h;
        if (r2 != null) goto L21;
        View r3 = getView();
        if (r3 == null) goto L19;
        r2 = r3.findViewById(2131384071);
    L20:
        this.h = r2;
        goto L21
    L19:
        r2 = null;
    L21:
        r2.setAdapter(new a(this, r1));
        int r15 = r1.size();
        if (r15 != 1) goto L32;
        Context r7 = getContext();
        if (r7 == null) goto L30;
        int r8 = a0.a;
        int r9 = this.n;
        if (r15 != 1) goto L28;
        int r16 = a0.a(r9, 2131888876, 2131889924);
    L29:
        String r17 = r7.getString(r16);
    L31:
        String r18 = UIHelper.mustacheFormat(r17, "secure_label", r14.getSecretLevel().getName());
    L41:
        View r19 = this.i;
        if (r19 != null) goto L48;
        View r110 = getView();
        if (r110 == null) goto L46;
        r19 = r110.findViewById(2131363218);
    L47:
        this.i = (TextView) r19;
        goto L48
    L46:
        r19 = null;
    L48:
        ((TextView) r19).setText(r18);
        goto L49
    L28:
        r16 = a0.a(r9, 2131888880, 2131889925);
        goto L29
    L30:
        r17 = null;
        goto L31
    L32:
        Context r20 = getContext();
        if (r20 == null) goto L39;
        int r21 = a0.a;
        int r22 = this.n;
        if (r15 != 1) goto L37;
        int r4 = a0.a(r22, 2131888876, 2131889924);
    L38:
        String r5 = r20.getString(r4);
    L40:
        r18 = UIHelper.mustacheFormat(r5, MapsKt.mapOf(new Pair[]{TuplesKt.to(SheetInputData.InputData.FormatType.NUMBER, String.valueOf(r15)), TuplesKt.to("secure_label", r14.getSecretLevel().getName())}));
        goto L41
    L37:
        r4 = a0.a(r22, 2131888880, 2131889925);
        goto L38
    L39:
        r5 = null;
    L49:
        View r111 = this.j;
        if (r111 != null) goto L55;
        View r112 = getView();
        if (r112 == null) goto L54;
        r0 = r112.findViewById(2131388775);
    L54:
        this.j = (BaseTitleBar) r0;
        r111 = r0;
    L55:
        ((BaseTitleBar) r111).setLeftClickListener(new c(this));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131558722, r3, false);
    }
}
