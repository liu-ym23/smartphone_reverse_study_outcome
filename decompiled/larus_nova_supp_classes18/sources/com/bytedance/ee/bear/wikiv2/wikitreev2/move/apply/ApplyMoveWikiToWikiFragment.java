package com.bytedance.ee.bear.wikiv2.wikitreev2.move.apply;

import android.os.Bundle;
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
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.ApplyMoveWikiToWikiPuller$Params;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetMoveNodeAuthorizedUserInfoPuller;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/move/apply/ApplyMoveWikiToWikiFragment;", "Lcom/bytedance/ee/bear/list/move/ApplyMoveFragment;", "<init>", "()V", "user", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/api/GetMoveNodeAuthorizedUserInfoPuller$Result;", WikiFolderPushPlugin.WIKI_TOKEN, "", "srcSpaceId", "srcParentToken", "destSpaceId", "destParentToken", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getLayoutResId", "", "getDescFormatStringId", "getDescFormatKey", "sendApply", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplyMoveWikiToWikiFragment extends ApplyMoveFragment {
    public static final /* synthetic */ int s = 0;
    public GetMoveNodeAuthorizedUserInfoPuller.Result m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;

    public static final class a {
    }

    public static final class b implements ApplyMoveFragment.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ ApplyMoveWikiToWikiFragment b;

        @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment.a
        public final String a() {
            String r0 = Locale.JAPANESE.getLanguage();
            GetMoveNodeAuthorizedUserInfoPuller.Result r1 = this.b.m;
            String r2 = null;
            if (r1 == null) goto L5;
            DisplayName r3 = r1.display_name;
        L6:
            if (r1 == null) goto L11;
            GetMoveNodeAuthorizedUserInfoPuller.I18nNames r4 = r1.i18n_names;
            if (r4 == null) goto L11;
            r2 = r4.ja_jp;
        L11:
            return ou5.a.a(r0, r3, r2, r2);
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment.a
        public final String b() {
            String r0 = Locale.CHINESE.getLanguage();
            GetMoveNodeAuthorizedUserInfoPuller.Result r1 = this.b.m;
            String r2 = null;
            if (r1 == null) goto L5;
            DisplayName r3 = r1.display_name;
        L6:
            if (r1 == null) goto L11;
            GetMoveNodeAuthorizedUserInfoPuller.I18nNames r4 = r1.i18n_names;
            if (r4 == null) goto L11;
            r2 = r4.zh_cn;
        L11:
            return ou5.a.a(r0, r3, r2, r2);
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment.a
        public final String getEnName() {
            String r0 = Locale.ENGLISH.getLanguage();
            GetMoveNodeAuthorizedUserInfoPuller.Result r1 = this.b.m;
            String r2 = null;
            if (r1 == null) goto L5;
            DisplayName r3 = r1.display_name;
        L6:
            if (r1 == null) goto L11;
            GetMoveNodeAuthorizedUserInfoPuller.I18nNames r4 = r1.i18n_names;
            if (r4 == null) goto L11;
            r2 = r4.en_us;
        L11:
            return ou5.a.a(r0, r3, r2, r2);
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment.a
        public final String getId() {
            GetMoveNodeAuthorizedUserInfoPuller.Result r0 = this.b.m;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.id;
        }

        @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment.a
        public final String getName() {
            String r0 = this.a;
            GetMoveNodeAuthorizedUserInfoPuller.Result r1 = this.b.m;
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

        public b(String r1, ApplyMoveWikiToWikiFragment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ApplyMoveWikiToWikiFragment a;
        public final /* synthetic */ Ref.ObjectRef<ApplyMoveViewModel> b;

        public c(ApplyMoveWikiToWikiFragment r1, Ref.ObjectRef<ApplyMoveViewModel> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            SimpleRequestResult r5 = (SimpleRequestResult) r4;
            tt5.a.h("ApplyMoveWikiToWikiFragment", "apply success.");
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
        public final /* synthetic */ ApplyMoveWikiToWikiFragment b;

        public d(Ref.ObjectRef<ApplyMoveViewModel> r1, ApplyMoveWikiToWikiFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            tt5.a.d("ApplyMoveWikiToWikiFragment", "apply failed, error = " + r6);
            Toast.cancelLoading();
            ApplyMoveViewModel r0 = (ApplyMoveViewModel) this.a.element;
            if (r0 == null) goto L6;
            r0.setState(new com.bytedance.ee.bear.list.move.b(2, ""));
        L6:
            if (tp5.b.b(r6, 920003005) == false) goto L9;
            Toast.showFailureText(this.b.getContext(), this.b.getString(2131887487));
            return;
        L9:
            if (tp5.b.b(r6, 920004106) == false) goto L12;
            Toast.showFailureText(this.b.getContext(), this.b.getString(2131887488));
            return;
        L12:
            if (tp5.b.b(r6, 920004107) == false) goto L14;
            Toast.showFailureText(this.b.getContext(), this.b.getString(2131887480));
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
        return 2131888797;
    }

    @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment
    public final int ga0() {
        return 2131558720;
    }

    @Override // com.bytedance.ee.bear.list.move.ApplyMoveFragment
    public final void ia0() {
        tt5.a.h("ApplyMoveWikiToWikiFragment", "sendApply()...");
        Toast.showLoading(getContext(), getString(2131887121));
        String r1 = null;
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        Z90();
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        Fragment r3 = getParentFragment();
        if (r3 == null) goto L5;
        r2.element = new ViewModelProvider(r3).get(ApplyMoveViewModel.class);
    L5:
        final String r5 = this.o;
        final String r6 = this.q;
        final String r7 = this.p;
        final String r8 = this.r;
        final String r9 = this.n;
        TextView r4 = this.j;
        if (r4 == null) goto L10;
        CharSequence r10 = r4.getText();
        if (r10 == null) goto L10;
        CharSequence r11 = StringsKt.trim(r10);
    L11:
        final String r12 = String.valueOf(r11);
        GetMoveNodeAuthorizedUserInfoPuller.Result r13 = this.m;
        if (r13 == null) goto L14;
        r1 = r13.id;
    L14:
        final String r14 = r1;
        NonProguard r15 = new ApplyMoveWikiToWikiPuller$Params(r5, r6, r7, r8, r9, r12, r14);
        NetService.f r16 = new NetService.f("/space/api/wiki/v2/tree/apply_move_node/");
        ((NetService.e) r16).c = 1;
        ((NetService.e) r16).j = GsonProtectorUtils.toJson(new Gson(), r15);
        this.h = r0.Vc(new f()).a(r16).subscribe(new c(this, r2), new d(r2, this));
        return;
    L10:
        r11 = null;
        goto L11
    }

    public ApplyMoveWikiToWikiFragment() {
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L17;
        GetMoveNodeAuthorizedUserInfoPuller.Result r0 = (GetMoveNodeAuthorizedUserInfoPuller.Result) r4.getSerializable("extra_user");
        this.m = r0;
        if (r0 != null) goto L13;
        tt5.a.d("ApplyMoveWikiToWikiFragment", "user is null");
        dismissAllowingStateLoss();     // Catch: Exception -> L9
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L13;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L13:
        this.n = r4.getString("extra_wiki_token", "");
        this.o = r4.getString("extra_src_space_id", "");
        this.p = r4.getString("extra_src_parent_token", "");
        this.q = r4.getString("extra_space_id", "");
        this.r = r4.getString("extra_parent_token", "");
        this.i = new b(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(), this);
        return;
    }
}
