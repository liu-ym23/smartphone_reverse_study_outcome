package com.bytedance.ee.bear.document.restore;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.RectColorView;
import com.bytedance.ee.bear.document.restore.api.RestoreFileResult;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0002,-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\n\u0010)\u001a\u0004\u0018\u00010*H\u0002J\b\u0010+\u001a\u00020\u0017H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/document/restore/DocDeletedRestoreFailDialog;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "descriptionFromXml", "Landroid/widget/TextView;", "getDescriptionFromXml", "()Landroid/widget/TextView;", "setDescriptionFromXml", "(Landroid/widget/TextView;)V", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "confirmFromXml", "Lcom/larksuite/component/universe_design/button/UDButton;", "getConfirmFromXml", "()Lcom/larksuite/component/universe_design/button/UDButton;", "setConfirmFromXml", "(Lcom/larksuite/component/universe_design/button/UDButton;)V", "clearFromXmlViewCache", "", "onDestroyView", "params", "Lcom/bytedance/ee/bear/document/restore/DocDeletedRestoreFailDialog$ParamsViewModel;", "getParams", "()Lcom/bytedance/ee/bear/document/restore/DocDeletedRestoreFailDialog$ParamsViewModel;", "params$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "getDesc", "Landroid/text/Spanned;", "onStart", "ParamsViewModel", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocDeletedRestoreFailDialog extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int l = 0;
    public TextView h;
    public BaseTitleBar i;
    public UDButton j;
    public final Lazy k;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/document/restore/DocDeletedRestoreFailDialog$ParamsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "noPermInfo", "Lcom/bytedance/ee/bear/document/restore/api/RestoreFileResult$FailDataNoPermInfo;", "getNoPermInfo", "()Lcom/bytedance/ee/bear/document/restore/api/RestoreFileResult$FailDataNoPermInfo;", "setNoPermInfo", "(Lcom/bytedance/ee/bear/document/restore/api/RestoreFileResult$FailDataNoPermInfo;)V", RectColorView.RectColorType.TYPE_CLEAR, "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ParamsViewModel extends ViewModel {
        private RestoreFileResult.FailDataNoPermInfo noPermInfo;

        public final void clear() {
            this.noPermInfo = null;
        }

        public ParamsViewModel() {
        }

        public final RestoreFileResult.FailDataNoPermInfo getNoPermInfo() {
            return this.noPermInfo;
        }

        public final void setNoPermInfo(RestoreFileResult.FailDataNoPermInfo r1) {
            this.noPermInfo = r1;
        }
    }

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ DocDeletedRestoreFailDialog a;

        public b(DocDeletedRestoreFailDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ DocDeletedRestoreFailDialog a;

        public c(DocDeletedRestoreFailDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public final TextView Z90() {
        View r0 = this.h;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131368849);
    L8:
        this.h = (TextView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (TextView) r0;
    }

    public DocDeletedRestoreFailDialog() {
        this.k = LazyKt.lazy(new DocDeletedRestoreFailDialog$params$2(this));
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.h = null;
        this.i = null;
        this.j = null;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L13;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L14;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        r2.height = -2;
        r2.softInputMode = 16;
        r2.gravity = 80;
        r1.setAttributes(r2);
        r1.setDimAmount(0.2f);
        r1.setWindowAnimations(2131951620);
        r1.setBackgroundDrawableResource(R.color.transparent);
        zo5.b r3 = (zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6);
        View r4 = r1.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r5 = ThreadMethodProxy.currentThread();
        if (r5 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r5, "getDecorView");
    L11:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.widget.FrameLayout");
        r3.p((FrameLayout) r4);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super.onViewCreated(r12, r13);
        TextView r14 = Z90();
        Context r16 = getContext();
        CharSequence r0 = "";
        View r1 = null;
        if (r16 == null) goto L37;
        ParamsViewModel r2 = (ParamsViewModel) this.k.getValue();
        if (r2 == null) goto L37;
        RestoreFileResult.FailDataNoPermInfo r3 = r2.getNoPermInfo();
        if (r3 == null) goto L37;
        String r4 = ou5.a.b(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(), r3.del_operator_cn_name, r3.del_operator_en_name);
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        final String r5 = r3.del_operator_id;
        String r6 = r3.space_name;
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        final String r7 = r3.space_id;
        if (r4.length() <= 0) goto L19;
        boolean r8 = true;
    L21:
        if (r8 == false) goto L24;
        r4 = " @" + r4 + ' ';
    L24:
        if (r6.length() <= 0) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == false) goto L30;
        r6 = " " + r6 + ' ';
    L30:
        if (r6.length() <= 0) goto L32;
        boolean r10 = true;
    L34:
        if (r10 == false) goto L36;
        String r11 = UIHelper.mustacheFormat(2131889869, MapsKt.mapOf(new Pair[]{TuplesKt.to("username", r4), TuplesKt.to("workspace", r6)}));
        int r17 = q35.a.d;
        Intrinsics.checkNotNullParameter(r16, "mContext");
        q35.a r18 = new q35.a(r16);
        Intrinsics.checkNotNull(r11);
        r18.d(r11);
        r18.f(r4);
        r18.e();
        q35.a.c(r18, Z90(), new DocDeletedRestoreFailDialog$getDesc$1(r5));
        r18.f(r6);
        r18.e();
        q35.a.c(r18, Z90(), new DocDeletedRestoreFailDialog$getDesc$2(r7));
        SpannableStringBuilder r19 = r18.a();
    L38:
        if (r19 == null) goto L40;
        r0 = r19;
    L40:
        r14.setText(r0);
        View r110 = this.i;
        if (r110 != null) goto L47;
        View r111 = getView();
        if (r111 == null) goto L45;
        r110 = r111.findViewById(2131388775);
    L46:
        this.i = (BaseTitleBar) r110;
        goto L47
    L45:
        r110 = null;
    L47:
        ((BaseTitleBar) r110).setLeftClickListener(new b(this));
        View r112 = this.j;
        if (r112 != null) goto L53;
        View r113 = getView();
        if (r113 == null) goto L52;
        r1 = r113.findViewById(2131367639);
    L52:
        this.j = (UDButton) r1;
        r112 = r1;
    L53:
        ((UDButton) r112).setOnClickListener(new c(this));
        return;
    L36:
        String r20 = UIHelper.mustacheFormat(2131889868, MapsKt.mapOf(TuplesKt.to("username", r4)));
        int r21 = q35.a.d;
        Intrinsics.checkNotNullParameter(r16, "mContext");
        q35.a r22 = new q35.a(r16);
        Intrinsics.checkNotNull(r20);
        r22.d(r20);
        r22.f(r4);
        r22.e();
        q35.a.c(r22, Z90(), new DocDeletedRestoreFailDialog$getDesc$3(r5));
        r19 = r22.a();
        goto L38
    L32:
        r10 = false;
        goto L34
    L26:
        r9 = false;
        goto L27
    L19:
        r8 = false;
    L37:
        r19 = null;
        goto L38
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560093, r3, false);
    }
}
