package com.larus.login.impl.multiaccount;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.api.IMultiAccountProfileService;
import com.larus.account.base.api.IMultiAccountService;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.login.impl.databinding.LarusItemMultiAccountAddAccountBinding;
import com.larus.login.impl.databinding.LarusItemMultiAccountBinding;
import com.larus.login.impl.databinding.LarusMultiAccountPageBinding;
import com.larus.login.impl.loginfragment.EnterpriseLoginEntryResolver;
import com.larus.nova.R;
import com.larus.settings.value.e10;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.obric.assistant.spi.account.ObricAccountSPIServiceDelegate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.y6;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0016\u0018\u0000 >2\u00020\u0001:\u0002>?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\rH\u0016J\b\u0010!\u001a\u00020\tH\u0016J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010%\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020#H\u0016J\b\u0010(\u001a\u00020#H\u0016J\b\u0010)\u001a\u00020\rH\u0002J\u000f\u0010*\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u0010+J\u000f\u0010,\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u0010+J\b\u0010-\u001a\u00020#H\u0002J\b\u0010.\u001a\u00020#H\u0002J\b\u0010/\u001a\u00020#H\u0002J\b\u00100\u001a\u00020#H\u0002J\u0010\u00101\u001a\u00020#2\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020#H\u0002J\u0010\u00105\u001a\u00020#2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00106\u001a\u00020#2\u0006\u00102\u001a\u000203H\u0002J\n\u00107\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u00108\u001a\u00020\r2\u0006\u00102\u001a\u000203H\u0002J\n\u00109\u001a\u0004\u0018\u00010\tH\u0002J\n\u0010:\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020=H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006@"}, d2 = {"Lcom/larus/login/impl/multiaccount/MultiAccountFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/login/impl/databinding/LarusMultiAccountPageBinding;", "adapter", "Lcom/larus/login/impl/multiaccount/MultiAccountFragment$MultiAccountAdapter;", "initialCurrentSecUserId", "", "initialAccountCount", "", "isAddingAccount", "", "isManageMode", "multiAccountProfileService", "Lcom/larus/account/base/api/IMultiAccountProfileService;", "getMultiAccountProfileService", "()Lcom/larus/account/base/api/IMultiAccountProfileService;", "multiAccountProfileService$delegate", "Lkotlin/Lazy;", "accountStatusListener", "com/larus/login/impl/multiaccount/MultiAccountFragment$accountStatusListener$1", "Lcom/larus/login/impl/multiaccount/MultiAccountFragment$accountStatusListener$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "autoLogEnterPage", "getCurrentPageName", "onViewCreated", "", "view", "onResume", WidgetCostModule.TYPE_ON_START, "onStop", "onDestroyView", "hasAccountChangedSincePanelShown", "setupHeader", "()Lkotlin/Unit;", "setupRecycler", "loadAccounts", "updateManageButton", "refreshAccountProfilesFromServer", "openAddAccount", "handleAccountItemClick", MapController.ITEM_LAYER_TAG, "Lcom/larus/account/base/model/AccountLocalItem;", "handleLoginAccountChanged", "handleRemoveAccountClick", "handleRemoveAccountConfirm", "getEnterMethod", "shouldShowRemoveButton", "getStyle", "getPostSwitchRoute", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "Companion", "MultiAccountAdapter", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiAccountFragment extends TraceFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f358068m = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusMultiAccountPageBinding f358069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MultiAccountAdapter f358070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f358071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f358072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f358073i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f358074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f358075k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f358076l;

    public final class MultiAccountAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<q38.b, Unit> f358077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<q38.b, Unit> f358078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function0<Unit> f358079c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<q38.b> f358080d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f358081e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ MultiAccountFragment f358082f;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/larus/login/impl/multiaccount/MultiAccountFragment$MultiAccountAdapter$AccountViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/login/impl/databinding/LarusItemMultiAccountBinding;", "<init>", "(Lcom/larus/login/impl/multiaccount/MultiAccountFragment$MultiAccountAdapter;Lcom/larus/login/impl/databinding/LarusItemMultiAccountBinding;)V", "getBinding", "()Lcom/larus/login/impl/databinding/LarusItemMultiAccountBinding;", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/account/base/model/AccountLocalItem;", "isManageMode", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class AccountViewHolder extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final LarusItemMultiAccountBinding f358083a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MultiAccountAdapter f358084b;

            public AccountViewHolder(MultiAccountAdapter r100, LarusItemMultiAccountBinding r101) {
                Intrinsics.checkNotNullParameter(r101, "binding");
                this.f358084b = r100;
                super(r101.f357567a);
                this.f358083a = r101;
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/larus/login/impl/multiaccount/MultiAccountFragment$MultiAccountAdapter$AddAccountViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/login/impl/databinding/LarusItemMultiAccountAddAccountBinding;", "<init>", "(Lcom/larus/login/impl/multiaccount/MultiAccountFragment$MultiAccountAdapter;Lcom/larus/login/impl/databinding/LarusItemMultiAccountAddAccountBinding;)V", "getBinding", "()Lcom/larus/login/impl/databinding/LarusItemMultiAccountAddAccountBinding;", "bind", "", "isManageMode", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class AddAccountViewHolder extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final LarusItemMultiAccountAddAccountBinding f358085a;

            public AddAccountViewHolder(LarusItemMultiAccountAddAccountBinding r100) {
                Intrinsics.checkNotNullParameter(r100, "binding");
                super(r100.f357565b);
                this.f358085a = r100;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((ArrayList) this.f358080d).size() + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            if (r100 >= ((ArrayList) this.f358080d).size()) goto L5;
            return 0;
        L5:
            return 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
            Intrinsics.checkNotNullParameter(r110, "holder");
            boolean r100 = true;
            if (((ArrayList) this.f358080d).size() != 1) goto L5;
            r110.itemView.setBackgroundResource(R.drawable.larus_bg_item_selector_only);
        L11:
            float r101 = 1.0f;
            int r102 = 0;
            String r103 = null;
            if ((r110 instanceof AccountViewHolder) == false) goto L52;
            final q38.b r112 = (q38.b) ListProtector.get(this.f358080d, r111);
            AccountViewHolder r104 = (AccountViewHolder) r110;
            boolean r105 = this.f358081e;
            r104.getClass();
            Intrinsics.checkNotNullParameter(r112, MapController.ITEM_LAYER_TAG);
            Context r106 = r104.f358083a.f357567a.getContext();
            RoundAvatarImageView.f(r104.f358083a.f357568b, r112.b(), "settings.multi_account", false, 12);
            AppCompatTextView r107 = r104.f358083a.f357572f;
            String r113 = r112.c();
            if (r113 != null) goto L16;
        L21:
            r113 = r106.getString(R.string.larus_user_default_name);
        L22:
            r107.setText(r113);
            IMultiAccountProfileService r108 = (IMultiAccountProfileService) r104.f358084b.f358082f.f358075k.getValue();
            if (r108 == null) goto L29;
            q38.b.a r109 = r112.i();
            if (r109 == null) goto L27;
            r103 = r109.b();
        L27:
            r103 = r108.a(r103, r112.h(), r112.f(), 2);
        L29:
            if (com.larus.utils.o0.d(r103) == false) goto L31;
            r104.f358083a.f357573g.setText(r103);
            r104.f358083a.f357573g.setVisibility(0);
        L32:
            r104.f358083a.f357569c.setVisibility(4);
            r104.f358083a.f357570d.setVisibility(8);
            r104.f358083a.f357574h.setVisibility(8);
            if (r105 == false) goto L46;
            r104.f358084b.f358082f.getClass();
            if (r112.k() == false) goto L37;
            boolean r114 = false;
        L38:
            ConstraintLayout r115 = r104.f358083a.f357567a;
            if (r112.k() == false) goto L41;
            r101 = 0.5f;
        L41:
            r115.setAlpha(r101);
            AppCompatTextView r116 = r104.f358083a.f357569c;
            if (r114 == true) goto L45;
            r102 = 4;
        L45:
            r116.setVisibility(r102);
        L50:
            e1.d(r110.itemView, new v(this, r112));
            e1.d(((AccountViewHolder) r110).f358083a.f357569c, new w(this, r112));
            return;
        L37:
            r114 = ObricAccountSPIServiceDelegate.f392812b.f(r112.g(), r112.l());
            goto L38
        L46:
            r104.f358083a.f357567a.setAlpha(1.0f);
            if (r112.k() == false) goto L49;
            r104.f358083a.f357570d.setVisibility(0);
            goto L50
        L49:
            r104.f358083a.f357574h.setVisibility(0);
            goto L50
        L31:
            r104.f358083a.f357573g.setVisibility(8);
            goto L32
        L16:
            if ((true ^ StringsKt.isBlank(r113)) == true) goto L19;
            r113 = null;
        L19:
            if (r113 == null) goto L21;
        L52:
            if ((r110 instanceof AddAccountViewHolder) == false) goto L69;
            AddAccountViewHolder r117 = (AddAccountViewHolder) r110;
            if (this.f358081e == false) goto L56;
            r117.f358085a.f357565b.setAlpha(0.5f);
        L57:
            AppCompatTextView r118 = r117.f358085a.f357566c;
            EnterpriseLoginEntryResolver r119 = EnterpriseLoginEntryResolver.f357924a;
            e10 r120 = e10.f368561a;
            if (e10.Z().getEnterpriseAddAccountTipEnabled() == true) goto L60;
        L62:
            r100 = false;
        L63:
            if (r100 == true) goto L66;
            r102 = 8;
        L66:
            r118.setVisibility(r102);
            e1.d(r110.itemView, new x(this));
            return;
        L60:
            if (EnterpriseLoginEntryResolver.a(null) == false) goto L62;
        L56:
            r117.f358085a.f357565b.setAlpha(1.0f);
            goto L57
        L69:
            return;
        L5:
            if (r111 != 0) goto L8;
            r110.itemView.setBackgroundResource(R.drawable.larus_bg_item_selector_first);
            goto L11
        L8:
            if (r111 != ((ArrayList) this.f358080d).size()) goto L10;
            r110.itemView.setBackgroundResource(R.drawable.larus_bg_item_selector_last);
            goto L11
        L10:
            r110.itemView.setBackgroundResource(R.drawable.larus_bg_item_selector_middle);
            goto L11
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r110, int r111) {
            Intrinsics.checkNotNullParameter(r110, "parent");
            LayoutInflater r100 = LayoutInflater.from(r110.getContext());
            int r101 = R.id.tv_subtitle;
            if (r111 != 0) goto L26;
            View r112 = r100.inflate(R.layout.larus_item_multi_account, r110, false);
            RoundAvatarImageView r102 = (RoundAvatarImageView) ViewBindings.findChildViewById(r112, R.id.avatar);
            if (r102 == null) goto L23;
            AppCompatTextView r103 = (AppCompatTextView) ViewBindings.findChildViewById(r112, R.id.btn_remove);
            if (r103 == null) goto L22;
            ImageView r104 = (ImageView) ViewBindings.findChildViewById(r112, R.id.checked_container);
            if (r104 == null) goto L21;
            View r105 = ViewBindings.findChildViewById(r112, R.id.divider);
            if (r105 == null) goto L20;
            AppCompatTextView r113 = (AppCompatTextView) ViewBindings.findChildViewById(r112, R.id.tv_display_name);
            if (r113 == null) goto L19;
            AppCompatTextView r114 = (AppCompatTextView) ViewBindings.findChildViewById(r112, R.id.tv_subtitle);
            if (r114 == null) goto L25;
            r101 = R.id.unchecked_circle;
            View r115 = ViewBindings.findChildViewById(r112, R.id.unchecked_circle);
            if (r115 == null) goto L25;
            RecyclerView.ViewHolder r116 = new AccountViewHolder(this, new LarusItemMultiAccountBinding((ConstraintLayout) r112, r102, r103, r104, r105, r113, r114, r115));
        L33:
            return r116;
        L25:
            throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r101)));
        L19:
            r101 = R.id.tv_display_name;
            goto L25
        L20:
            r101 = R.id.divider;
            goto L25
        L21:
            r101 = R.id.checked_container;
            goto L25
        L22:
            r101 = R.id.btn_remove;
            goto L25
        L23:
            r101 = R.id.avatar;
            goto L25
        L26:
            View r117 = r100.inflate(R.layout.larus_item_multi_account_add_account, r110, false);
            if (((ImageView) ViewBindings.findChildViewById(r117, R.id.iv_add)) == null) goto L34;
            ConstraintLayout r106 = (ConstraintLayout) r117;
            AppCompatTextView r107 = (AppCompatTextView) ViewBindings.findChildViewById(r117, R.id.tv_subtitle);
            if (r107 == null) goto L36;
            r101 = R.id.tv_title;
            if (((AppCompatTextView) ViewBindings.findChildViewById(r117, R.id.tv_title)) == null) goto L36;
            r116 = new AddAccountViewHolder(new LarusItemMultiAccountAddAccountBinding(r106, r106, r107));
        L36:
            throw new NullPointerException("Missing required view with ID: ".concat(r117.getResources().getResourceName(r101)));
        L34:
            r101 = R.id.iv_add;
            goto L36
        }

        public MultiAccountAdapter(MultiAccountFragment r100, n r101, o r102, p r103) {
            Intrinsics.checkNotNullParameter(r101, "onAccountClick");
            Intrinsics.checkNotNullParameter(r102, "onRemoveClick");
            Intrinsics.checkNotNullParameter(r103, "onAddAccountClick");
            this.f358082f = r100;
            this.f358077a = r101;
            this.f358078b = r102;
            this.f358079c = r103;
            this.f358080d = new ArrayList();
        }
    }

    public static final class a {
    }

    public static final class b implements n38.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiAccountFragment f358086a;

        @Override // n38.j
        public final void a(n38.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        public b(MultiAccountFragment r100) {
            this.f358086a = r100;
        }

        @Override // n38.j
        public final void b(n38.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if (Intrinsics.areEqual(r100.f516981d, "login_by_account_switch") == false) goto L5;
            return;
        L5:
            MultiAccountFragment r101 = this.f358086a;
            int r102 = MultiAccountFragment.f358068m;
            if (r101.V90() == true) goto L8;
            return;
        L8:
            final MultiAccountFragment r103 = this.f358086a;
            if (r103.f358073i == false) goto L11;
            r103.f358073i = false;
        L11:
            LarusMultiAccountPageBinding r104 = r103.f358069e;
            if (r104 == null) goto L18;
            LinearLayout r105 = r104.f357610a;
            if (r105 == null) goto L19;
            r105.post(new k(r103));
            return;
        L19:
            return;
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((q38.b) r101).e()), Long.valueOf(((q38.b) r100).e()));
        }
    }

    static {
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return true;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "account_switch";
    }

    public final boolean V90() {
        IMultiAccountService.Companion r100 = IMultiAccountService.f286100a;
        q38.b r101 = r100.c();
        if (r101 == null) goto L5;
        String r102 = r101.g();
    L7:
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
    L17:
        boolean r104 = false;
    L19:
        if (r100.g().size() <= this.f358072h) goto L21;
        boolean r105 = true;
    L22:
        if (r104 == true) goto L24;
        if (r105 == true) goto L24;
        return false;
    L24:
        return true;
    L21:
        r105 = false;
        goto L22
    L15:
        if (Intrinsics.areEqual(r102, this.f358071g) == true) goto L17;
        r104 = true;
        goto L19
    L9:
        if (StringsKt.isBlank(r102) == true) goto L12;
        r103 = false;
        goto L13
    L5:
        r102 = null;
        goto L7
    }

    public final void W90() {
        List r100 = CollectionsKt.sortedWith(IMultiAccountService.f286100a.g(), new c());
        boolean r101 = false;
        if (r100.isEmpty() == false) goto L16;
        LarusMultiAccountPageBinding r102 = this.f358069e;
        if (r102 == null) goto L9;
        RecyclerView r103 = r102.f357611b;
        if (r103 == null) goto L9;
        e1.o(r103);
    L9:
        LarusMultiAccountPageBinding r104 = this.f358069e;
        if (r104 == null) goto L14;
        AppCompatTextView r105 = r104.f357615f;
        if (r105 == null) goto L14;
        r105.setEnabled(false);
    L14:
        X90();
        return;
    L16:
        LarusMultiAccountPageBinding r106 = this.f358069e;
        if (r106 == null) goto L22;
        RecyclerView r107 = r106.f357611b;
        if (r107 == null) goto L22;
        e1.x(r107);
    L22:
        if (r100.size() <= 1) goto L24;
    L28:
        MultiAccountAdapter r108 = this.f358070f;
        if (r108 == null) goto L31;
        Intrinsics.checkNotNullParameter(r100, "list");
        ((ArrayList) r108.f358080d).clear();
        ArrayList r109 = (ArrayList) r108.f358080d;
        r109.addAll(r100);
        r108.notifyDataSetChanged();
    L31:
        LarusMultiAccountPageBinding r110 = this.f358069e;
        if (r110 == null) goto L39;
        AppCompatTextView r111 = r110.f357615f;
        if (r111 == null) goto L39;
        if (r100.size() <= 1) goto L38;
        r101 = true;
    L38:
        r111.setEnabled(r101);
    L39:
        X90();
        return;
    L24:
        if (this.f358074j == false) goto L28;
        this.f358074j = false;
        MultiAccountAdapter r112 = this.f358070f;
        if (r112 == null) goto L28;
        r112.f358081e = false;
        r112.notifyDataSetChanged();
        goto L28
    }

    public final void X90() {
        LarusMultiAccountPageBinding r100 = this.f358069e;
        if (r100 == null) goto L16;
        Context r101 = getContext();
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f358074j == false) goto L10;
        r100.f357615f.setText(getString(R.string.larus_edit_bot_done));
        r100.f357615f.setTextColor(v19.c.a(R.attr.larus_neutral_100, r101, R.color.larus_neutral_100));
    L14:
        r100.f357615f.setAlpha(1.0f);
        return;
    L10:
        r100.f357615f.setText(getString(R.string.larus_switchAccount_manageAcc));
        if (r100.f357615f.isEnabled() == false) goto L13;
        r100.f357615f.setTextColor(v19.c.a(R.attr.larus_neutral_100, r101, R.color.larus_neutral_100));
        goto L14
    L13:
        r100.f357615f.setTextColor(v19.c.a(R.attr.larus_neutral_30, r101, R.color.larus_neutral_30));
        goto L14
    }

    public MultiAccountFragment() {
        this.f358075k = LazyKt.lazy(new u());
        this.f358076l = new b(this);
    }

    public final String U90() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        String r101 = r100.getString("post_switch_route");
    L6:
        if (r101 != null) goto L8;
    L17:
        if (r101 != null) goto L19;
        return null;
    L19:
        return Uri.decode(r101);
    L8:
        if (UriProtector.parse(r101).getScheme() == null) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        String r103 = r101;
    L14:
        if (r103 == null) goto L17;
        return r103;
    L13:
        r103 = null;
        goto L14
    L10:
        r102 = false;
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    public final String getEnterMethod() {
        Bundle r100 = getArguments();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("enter_method");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f358069e = null;
        this.f358070f = null;
        this.f358073i = false;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f358073i == true) goto L5;
        return;
    L5:
        if (V90() == true) goto L9;
        this.f358073i = false;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ILoginService.a.c(ILoginService.f286097a, this.f358076l);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        ILoginService.f286097a.Q(this.f358076l);
    }

    @Override // com.larus.trace.tracknode.TraceFragment, by7.e, by7.d
    public final void fillTrackParams(TrackParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        com.larus.trace.tracknode.a.C4500a.a(this, r100);
        r100.put("enter_method", getEnterMethod());
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.login.impl.multiaccount.n] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.login.impl.multiaccount.o] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.login.impl.multiaccount.p] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        IMultiAccountService.Companion r101 = IMultiAccountService.f286100a;
        q38.b r111 = r101.c();
        String r102 = null;
        if (r111 == null) goto L5;
        String r112 = r111.g();
    L6:
        this.f358071g = r112;
        this.f358072h = r101.g().size();
        final LarusMultiAccountPageBinding r113 = this.f358069e;
        if (r113 == null) goto L22;
        Bundle r103 = getArguments();
        if (r103 == null) goto L11;
        r102 = r103.getString("style");
    L11:
        final String r104 = getEnterMethod();
        if (Intrinsics.areEqual(r102, "full") == false) goto L15;
        e1.o(r113.f357612c);
    L21:
        Unit r114 = Unit.INSTANCE;
        goto L22
    L15:
        if (Intrinsics.areEqual(r104, "setting") == false) goto L17;
    L20:
        e1.d(r113.f357614e, new j(this, r104));
        e1.d(r113.f357615f, new m(r113, this, r104));
        X90();
        goto L21
    L17:
        if (Intrinsics.areEqual(r104, "setting_account_name") == true) goto L20;
        e1.x(r113.f357613d);
        e1.o(r113.f357612c);
    L22:
        LarusMultiAccountPageBinding r115 = this.f358069e;
        if (r115 == null) goto L25;
        this.f358070f = new MultiAccountAdapter(this, new n(this), new o(this), new p(this));
        r115.f357611b.setLayoutManager(new LinearLayoutManager(getContext()));
        r115.f357611b.setAdapter(this.f358070f);
        y6.d(r115.f357611b, new q(this), new r(), null, new s(this), 9);
        Unit r116 = Unit.INSTANCE;
    L25:
        W90();
        r101.f(new t(this));
        return;
    L5:
        r112 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.larus_multi_account_page, r101, false);
        int r103 = R.id.account_list;
        RecyclerView r104 = (RecyclerView) ViewBindings.findChildViewById(r102, R.id.account_list);
        if (r104 == null) goto L22;
        LinearLayout r105 = (LinearLayout) r102;
        RelativeLayout r106 = (RelativeLayout) ViewBindings.findChildViewById(r102, R.id.title);
        if (r106 == null) goto L20;
        View r107 = ViewBindings.findChildViewById(r102, R.id.touch_view);
        if (r107 == null) goto L19;
        AppCompatTextView r108 = (AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.tv_cancel);
        if (r108 == null) goto L18;
        AppCompatTextView r109 = (AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.tv_manage);
        if (r109 != null) goto L13;
        r103 = R.id.tv_manage;
        goto L22
    L13:
        if (((AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.tv_title)) == null) goto L16;
        this.f358069e = new LarusMultiAccountPageBinding(r105, r104, r106, r107, r108, r109);
        return r105;
    L16:
        r103 = R.id.tv_title;
        goto L22
    L18:
        r103 = R.id.tv_cancel;
        goto L22
    L19:
        r103 = R.id.touch_view;
        goto L22
    L20:
        r103 = R.id.title;
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
