package com.bytedance.ee.bear.list.move;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.move.api.ApplyMoveSpaceToWikiPuller$Params;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/list/move/ApplyMoveSpaceToWikiFragment;", "Lcom/bytedance/ee/bear/list/move/ApplyMoveFragment;", "<init>", "()V", "objToken", "", "objType", "", "parentWikiToken", "spaceId", "reviewerResult", "Lcom/bytedance/ee/bear/list/move/GetMoveReviewerInfoPuller$Result;", "reviewerInfo", "Lcom/bytedance/ee/bear/list/move/GetMoveReviewerInfoPuller$Reviewer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "getDescFormatStringId", "getDescFormatKey", "getLayoutResId", "sendApply", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplyMoveSpaceToWikiFragment extends ApplyMoveFragment {
    public static final /* synthetic */ int s = 0;
    public String m;
    public int n;
    public String o;
    public String p;
    public GetMoveReviewerInfoPuller$Result q;
    public GetMoveReviewerInfoPuller$Reviewer r;

    public static final class a {
    }

    public static final class b implements ApplyMoveFragment.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ ApplyMoveSpaceToWikiFragment b;

        @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment.a
        public final String a() {
            String r0 = Locale.JAPANESE.getLanguage();
            GetMoveReviewerInfoPuller$Reviewer r1 = this.b.r;
            String r2 = null;
            if (r1 == null) goto L5;
            DisplayName r3 = r1.display_name;
        L6:
            if (r1 == null) goto L9;
            r2 = r1.en_name;
        L9:
            return ou5.a.a(r0, r3, r2, r2);
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment.a
        public final String b() {
            String r0 = Locale.CHINESE.getLanguage();
            GetMoveReviewerInfoPuller$Reviewer r1 = this.b.r;
            String r2 = null;
            if (r1 == null) goto L5;
            DisplayName r3 = r1.display_name;
        L6:
            if (r1 == null) goto L9;
            r2 = r1.cn_name;
        L9:
            return ou5.a.a(r0, r3, r2, r2);
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment.a
        public final String getEnName() {
            String r0 = Locale.ENGLISH.getLanguage();
            GetMoveReviewerInfoPuller$Reviewer r1 = this.b.r;
            String r2 = null;
            if (r1 == null) goto L5;
            DisplayName r3 = r1.display_name;
        L6:
            if (r1 == null) goto L9;
            r2 = r1.en_name;
        L9:
            return ou5.a.a(r0, r3, r2, r2);
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment.a
        public final String getId() {
            GetMoveReviewerInfoPuller$Reviewer r0 = this.b.r;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.id;
        }

        @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment.a
        public final String getName() {
            String r0 = this.a;
            GetMoveReviewerInfoPuller$Reviewer r1 = this.b.r;
            String r2 = null;
            if (r1 == null) goto L5;
            DisplayName r3 = r1.display_name;
        L6:
            if (r1 == null) goto L9;
            r2 = r1.name;
        L9:
            return ou5.a.a(r0, r3, r2, r2);
        L5:
            r3 = null;
            goto L6
        }

        public b(String r1, ApplyMoveSpaceToWikiFragment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ApplyMoveSpaceToWikiFragment a;
        public final /* synthetic */ Ref.ObjectRef<ApplyMoveViewModel> b;

        public c(ApplyMoveSpaceToWikiFragment r1, Ref.ObjectRef<ApplyMoveViewModel> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            SimpleRequestResult r5 = (SimpleRequestResult) r4;
            tt5.a.h("ApplyMoveSpaceToWikiFragment", "apply success.");
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
        public final /* synthetic */ ApplyMoveSpaceToWikiFragment b;

        public d(Ref.ObjectRef<ApplyMoveViewModel> r1, ApplyMoveSpaceToWikiFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            tt5.a.d("ApplyMoveSpaceToWikiFragment", "apply failed, error = " + r6);
            Toast.cancelLoading();
            ApplyMoveViewModel r0 = (ApplyMoveViewModel) this.a.element;
            if (r0 == null) goto L6;
            r0.setState(new com.bytedance.ee.bear.list.move.b(2, ""));
        L6:
            if (tp5.b.b(r6, 920003005) == false) goto L9;
            Toast.showFailureText(this.b.getContext(), this.b.getString(2131889819));
            return;
        L9:
            if (tp5.b.b(r6, 920004106) == false) goto L12;
            Toast.showFailureText(this.b.getContext(), this.b.getString(2131889820));
            return;
        L12:
            if (tp5.b.b(r6, 920004107) == false) goto L14;
            Toast.showFailureText(this.b.getContext(), xo5.a.c(this.b.getContext(), 2131889817, "username", this.b.ha0()));
            return;
        L14:
            Toast.showFailureText(this.b.getContext(), this.b.getString(2131887828));
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment
    public final String aa0() {
        return "ownerName";
    }

    @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment
    public final int ba0() {
        return 2131888796;
    }

    @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment
    public final int ga0() {
        return 2131558720;
    }

    @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment
    public final void ia0() {
        tt5.a.h("ApplyMoveSpaceToWikiFragment", "sendApply()...");
        Toast.showLoading(getContext(), getString(2131887121));
        CharSequence r1 = null;
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        Z90();
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        Fragment r3 = getParentFragment();
        if (r3 == null) goto L5;
        r2.element = new ViewModelProvider(r3).get(ApplyMoveViewModel.class);
    L5:
        final String r5 = this.m;
        final int r6 = this.n;
        final String r7 = this.o;
        final String r8 = this.p;
        View r4 = getView();
        if (r4 == null) goto L8;
        SpaceEditText r9 = (SpaceEditText) r4.findViewById(2131363190);
    L9:
        if (r9 == null) goto L13;
        Editable r10 = r9.getText();
        if (r10 == null) goto L13;
        r1 = StringsKt.trim(r10);
    L13:
        final String r11 = String.valueOf(r1);
        GetMoveReviewerInfoPuller$Reviewer r12 = this.r;
        if (r12 == null) goto L17;
        String r13 = r12.id;
        if (r13 == null) goto L17;
    L18:
        final String r14 = r13;
        NonProguard r15 = new ApplyMoveSpaceToWikiPuller$Params(r5, r6, r7, r8, r11, r14);
        NetService.f r16 = new NetService.f("/space/api/wiki/v2/tree/apply_move_from_space2/");
        ((NetService.e) r16).c = 1;
        ((NetService.e) r16).j = GsonProtectorUtils.toJson(new Gson(), r15);
        this.h = r0.Vc(new ax4.f()).a(r16).subscribe(new c(this, r2), new d(r2, this));
        return;
    L17:
        r13 = "";
        goto L18
    L8:
        r9 = null;
        goto L9
    }

    public ApplyMoveSpaceToWikiFragment() {
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        if (r5 == null) goto L25;
        this.q = (GetMoveReviewerInfoPuller$Result) r5.getSerializable("extra_user");
        this.o = r5.getString("extra_wiki_token", "");
        if (this.q != null) goto L13;
        tt5.a.d("ApplyMoveSpaceToWikiFragment", "reviewerResult is null");
        dismissAllowingStateLoss();     // Catch: Exception -> L9
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L13;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L13:
        this.m = r5.getString("extra_obj_token", "");
        this.n = r5.getInt("extra_obj_type");
        this.p = r5.getString("extra_space_id");
        GetMoveReviewerInfoPuller$Result r6 = this.q;
        if (r6 == null) goto L20;
        GetMoveReviewerInfoPuller$Entities r1 = r6.entities;
        if (r1 == null) goto L20;
        HashMap<String, GetMoveReviewerInfoPuller$Reviewer> r2 = r1.users;
        if (r2 == null) goto L20;
        GetMoveReviewerInfoPuller$Reviewer r7 = r2.get(r6.reviewer);
    L21:
        this.r = r7;
        this.i = new b(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(), this);
        return;
    L20:
        r7 = null;
        goto L21
    }

    @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        BaseTitleBar r4 = this.k;
        if (r4 == null) goto L6;
        r4.setTitle(2131889816);
        return;
    }
}
