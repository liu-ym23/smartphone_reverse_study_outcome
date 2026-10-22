package com.bytedance.ee.bear.wikiv2.wikitreev2.applydelete;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import ax4.f;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.applydelete.DeleteReviewer;
import com.bytedance.ee.bear.list.move.ApplyMoveFragment;
import com.bytedance.ee.bear.list.move.ApplyMoveViewModel;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/applydelete/ApplyDeleteWikiFragment;", "Lcom/bytedance/ee/bear/list/move/ApplyMoveFragment;", "<init>", "()V", ResourceData.KEY_TOKEN, "", "spaceId", "deleteOpt", "", "reviewerInfo", "Lcom/bytedance/ee/bear/list/applydelete/DeleteReviewer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "getDescFormatStringId", "getDescFormatKey", "getFeishuArticalId", "getLarkArticalId", "getHelpQuery", "getHelpCenterPointKey", "sendApply", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplyDeleteWikiFragment extends ApplyMoveFragment {
    public static final /* synthetic */ int q = 0;
    public String m;
    public String n;
    public int o;
    public DeleteReviewer p;

    public static final class a {
    }

    public static final class b implements ApplyMoveFragment.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ ApplyDeleteWikiFragment b;

        @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment.a
        public final String a() {
            String r0 = Locale.JAPANESE.getLanguage();
            DeleteReviewer r1 = this.b.p;
            String r2 = null;
            if (r1 == null) goto L5;
            DisplayName r3 = r1.getDisplay_name();
        L6:
            DeleteReviewer r4 = this.b.p;
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
            DeleteReviewer r1 = this.b.p;
            String r2 = null;
            if (r1 == null) goto L5;
            DisplayName r3 = r1.getDisplay_name();
        L6:
            DeleteReviewer r4 = this.b.p;
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
            DeleteReviewer r1 = this.b.p;
            String r2 = null;
            if (r1 == null) goto L5;
            DisplayName r3 = r1.getDisplay_name();
        L6:
            DeleteReviewer r4 = this.b.p;
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
            DeleteReviewer r0 = this.b.p;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getId();
        }

        @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment.a
        public final String getName() {
            String r0 = this.a;
            DeleteReviewer r1 = this.b.p;
            String r2 = null;
            if (r1 == null) goto L5;
            DisplayName r3 = r1.getDisplay_name();
        L6:
            DeleteReviewer r4 = this.b.p;
            if (r4 == null) goto L10;
            r2 = r4.getName();
        L10:
            return ou5.a.a(r0, r3, r2, r2);
        L5:
            r3 = null;
            goto L6
        }

        public b(String r1, ApplyDeleteWikiFragment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ApplyDeleteWikiFragment a;
        public final /* synthetic */ Ref.ObjectRef<ApplyMoveViewModel> b;

        public c(ApplyDeleteWikiFragment r1, Ref.ObjectRef<ApplyMoveViewModel> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            SimpleRequestResult r5 = (SimpleRequestResult) r4;
            tt5.a.h("ApplyDeleteWikiFragment", "apply success.");
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
        public final /* synthetic */ ApplyDeleteWikiFragment b;

        public d(Ref.ObjectRef<ApplyMoveViewModel> r1, ApplyDeleteWikiFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r11) {
            Throwable r3 = (Throwable) r11;
            tt5.a.d("ApplyDeleteWikiFragment", "apply failed, error = " + r3);
            Toast.cancelLoading();
            ApplyMoveViewModel r12 = (ApplyMoveViewModel) this.a.element;
            if (r12 == null) goto L5;
            r12.setState(new com.bytedance.ee.bear.list.move.b(2, ""));
        L5:
            WikiDialogs r13 = new WikiDialogs();
            FragmentActivity r1 = this.b.getActivity();
            if (this.b.o != 1) goto L8;
            WikiAction r0 = WikiAction.DEL;
        L9:
            WikiAction r4 = r0;
            Intrinsics.checkNotNull(r3);
            ApplyDeleteWikiFragment r2 = this.b;
            String r5 = r2.m;
            String r6 = r2.n;
            if (r2.o != 1) goto L12;
            boolean r7 = true;
        L13:
            r13.e(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.a(r1, r4, r3, r5, r6, r7, 2131887828));
            return;
        L12:
            r7 = false;
            goto L13
        L8:
            r0 = WikiAction.DEL_CURRENT_ONLY;
            goto L9
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
        return 2131888795;
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
        tt5.a.h("ApplyDeleteWikiFragment", "sendApply()...");
        Toast.showLoading(getContext(), getString(2131887121));
        CharSequence r1 = null;
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        Z90();
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        Fragment r3 = getParentFragment();
        if (r3 == null) goto L5;
        r2.element = new ViewModelProvider(r3).get(ApplyMoveViewModel.class);
    L5:
        ApplyDeleteWikiPuller r4 = new ApplyDeleteWikiPuller(r0);
        String r5 = this.m;
        TextView r6 = this.j;
        if (r6 == null) goto L10;
        CharSequence r7 = r6.getText();
        if (r7 == null) goto L10;
        r1 = StringsKt.trim(r7);
    L10:
        String r8 = String.valueOf(r1);
        DeleteReviewer r9 = this.p;
        if (r9 == null) goto L14;
        String r10 = r9.getId();
        if (r10 == null) goto L14;
    L15:
        ApplyDeleteWikiPuller.Params r11 = new ApplyDeleteWikiPuller.Params(r5, r8, r10, this.n, this.o);
        Intrinsics.checkNotNullParameter(r11, "params");
        NetService.f r12 = new NetService.f("/space/api/wiki/v2/tree/apply_delete/");
        ((NetService.e) r12).c = 1;
        ((NetService.e) r12).j = GsonProtectorUtils.toJson(new Gson(), r11);
        this.h = r4.a.Vc(new f()).a(r12).subscribe(new c(this, r2), new d(r2, this));
        return;
    L14:
        r10 = "";
        goto L15
    }

    public ApplyDeleteWikiFragment() {
        this.m = "";
        this.n = "";
        this.o = 1;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L17;
        this.p = (DeleteReviewer) r4.getSerializable("extra_user");
        this.m = r4.getString("extra_token", "");
        this.n = r4.getString("extra_space_id", "");
        this.o = r4.getInt("extra_delete_opt");
        if (this.p != null) goto L13;
        tt5.a.d("ApplyDeleteWikiFragment", "reviewerResult is null");
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
        if (r4 == null) goto L6;
        r4.setTitle(2131888805);
        return;
    }
}
