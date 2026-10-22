package com.bytedance.ee.bear.list.applydelete;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import ax4.f;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.move.ApplyMoveFragment;
import com.bytedance.ee.bear.list.move.ApplyMoveViewModel;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/list/applydelete/ApplyDeleteSpaceFragment;", "Lcom/bytedance/ee/bear/list/move/ApplyMoveFragment;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", ResourceData.KEY_TOKEN, "", "reviewerInfo", "Lcom/bytedance/ee/bear/list/applydelete/DeleteReviewer;", ResourceData.KEY_TYPE, "", "onViewCreated", "view", "Landroid/view/View;", "getDescFormatStringId", "getDescFormatKey", "getFeishuArticalId", "getLarkArticalId", "getHelpQuery", "getHelpCenterPointKey", "sendApply", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplyDeleteSpaceFragment extends ApplyMoveFragment {
    public static final /* synthetic */ int p = 0;
    public String m;
    public DeleteReviewer n;
    public int o;

    public static final class a {
    }

    public static final class b implements ApplyMoveFragment.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ ApplyDeleteSpaceFragment b;

        @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment.a
        public final String a() {
            String r0 = Locale.JAPANESE.getLanguage();
            DeleteReviewer r1 = this.b.n;
            String r2 = null;
            if (r1 == null) goto L5;
            DisplayName r3 = r1.getDisplay_name();
        L6:
            DeleteReviewer r4 = this.b.n;
            if (r4 == null) goto L10;
            r2 = r4.getEn_name();
        L10:
            return ou5.a.a(r0, r3, r2, r2);
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment.a
        public final String b() {
            String r0 = Locale.CHINESE.getLanguage();
            DeleteReviewer r1 = this.b.n;
            String r2 = null;
            if (r1 == null) goto L5;
            DisplayName r3 = r1.getDisplay_name();
        L6:
            DeleteReviewer r4 = this.b.n;
            if (r4 == null) goto L10;
            r2 = r4.getCn_name();
        L10:
            return ou5.a.a(r0, r3, r2, r2);
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment.a
        public final String getEnName() {
            String r0 = Locale.ENGLISH.getLanguage();
            DeleteReviewer r1 = this.b.n;
            String r2 = null;
            if (r1 == null) goto L5;
            DisplayName r3 = r1.getDisplay_name();
        L6:
            DeleteReviewer r4 = this.b.n;
            if (r4 == null) goto L10;
            r2 = r4.getEn_name();
        L10:
            return ou5.a.a(r0, r3, r2, r2);
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment.a
        public final String getId() {
            DeleteReviewer r0 = this.b.n;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getId();
        }

        @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment.a
        public final String getName() {
            String r0 = this.a;
            DeleteReviewer r1 = this.b.n;
            String r2 = null;
            if (r1 == null) goto L5;
            DisplayName r3 = r1.getDisplay_name();
        L6:
            DeleteReviewer r4 = this.b.n;
            if (r4 == null) goto L10;
            r2 = r4.getName();
        L10:
            return ou5.a.a(r0, r3, r2, r2);
        L5:
            r3 = null;
            goto L6
        }

        public b(String r1, ApplyDeleteSpaceFragment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ApplyDeleteSpaceFragment a;
        public final /* synthetic */ Ref.ObjectRef<ApplyMoveViewModel> b;

        public c(ApplyDeleteSpaceFragment r1, Ref.ObjectRef<ApplyMoveViewModel> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            SimpleRequestResult r5 = (SimpleRequestResult) r4;
            tt5.a.h("ApplyMoveSpaceToSpaceFragment", "apply success.");
            Toast.cancelLoading();
            Toast.showSuccessText(this.a.getContext(), this.a.getString(2131887482));
            ApplyMoveViewModel r6 = (ApplyMoveViewModel) this.b.element;
            if (r6 == null) goto L13;
            r6.setState(new com.bytedance.ee.bear.list.move.b(1, ""));
        L13:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r7 = DialogFragmentLancet.sLastShowStack;
            if (r7 == null) goto L15;
            com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Ref.ObjectRef<ApplyMoveViewModel> a;
        public final /* synthetic */ ApplyDeleteSpaceFragment b;

        public d(Ref.ObjectRef<ApplyMoveViewModel> r1, ApplyDeleteSpaceFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            tt5.a.d("ApplyMoveSpaceToSpaceFragment", "apply failed, error = " + ((Throwable) r4));
            Toast.cancelLoading();
            ApplyMoveViewModel r5 = (ApplyMoveViewModel) this.a.element;
            if (r5 == null) goto L5;
            r5.setState(new com.bytedance.ee.bear.list.move.b(2, ""));
        L5:
            Toast.showFailureText(this.b.getContext(), this.b.getString(2131887828));
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment
    public final String aa0() {
        return "userName";
    }

    @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment
    public final int ba0() {
        return 2131888794;
    }

    @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment
    public final String ca0() {
        return "075978095260";
    }

    @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment
    public final String da0() {
        return "cm_apply_delete";
    }

    @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment
    public final String ea0() {
        return "ccm_permission_delete";
    }

    @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment
    public final String fa0() {
        return "991489909111";
    }

    @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment
    public final void ia0() {
        tt5.a.h("ApplyMoveSpaceToSpaceFragment", "sendApply()...");
        Toast.showLoading(getContext(), getString(2131887121));
        CharSequence r1 = null;
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        Z90();
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        Fragment r3 = getParentFragment();
        if (r3 == null) goto L5;
        r2.element = new ViewModelProvider(r3).get(ApplyMoveViewModel.class);
    L5:
        ApplyDeleteSpacePuller r4 = new ApplyDeleteSpacePuller(r0);
        String r5 = this.m;
        int r6 = this.o;
        TextView r7 = this.j;
        if (r7 == null) goto L10;
        CharSequence r8 = r7.getText();
        if (r8 == null) goto L10;
        r1 = StringsKt.trim(r8);
    L10:
        String r9 = String.valueOf(r1);
        DeleteReviewer r10 = this.n;
        if (r10 == null) goto L14;
        String r11 = r10.getId();
        if (r11 == null) goto L14;
    L15:
        ApplyDeleteSpacePuller.Params r12 = new ApplyDeleteSpacePuller.Params(r5, r6, r9, r11);
        Intrinsics.checkNotNullParameter(r12, "params");
        NetService.f r13 = new NetService.f("/space/api/explorer/v2/apply_delete/");
        ((NetService.e) r13).c = 1;
        ((NetService.e) r13).j = GsonProtectorUtils.toJson(new Gson(), r12);
        this.h = r4.a.Vc(new f()).a(r13).subscribe(new c(this, r2), new d(r2, this));
        return;
    L14:
        r11 = "";
        goto L15
    }

    public ApplyDeleteSpaceFragment() {
        this.m = "";
        this.o = -1;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L17;
        this.n = (DeleteReviewer) r4.getSerializable("extra_user");
        this.m = r4.getString("extra_obj_token", "");
        this.o = r4.getInt("extra_obj_type", -1);
        if (this.n != null) goto L13;
        tt5.a.d("ApplyMoveSpaceToSpaceFragment", "reviewerResult is null");
        dismissAllowingStateLoss();     // Catch: Exception -> L9
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L13;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L13:
        this.i = new b(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(), this);
        return;
    }

    @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        BaseTitleBar r4 = this.k;
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.o != 0) goto L7;
        int r5 = 2131888806;
    L8:
        r4.setTitle(r5);
        return;
    L7:
        r5 = 2131888805;
        goto L8
    }
}
