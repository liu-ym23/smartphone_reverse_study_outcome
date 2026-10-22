package com.ss.android.lark.contact.customized.search.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.contact.base.common_ui.InvBaseFragment;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeLoadingView;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteSearchActionItemLayoutBinding;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteSearchEmptyLayoutBinding;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteSearchLoadingLayoutBinding;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteSearchViewLayoutBinding;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.profile.dto.ProfileFinishResult;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.q;
import com.suite.lark.emm.design.edittext.SCEditText;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import mtb.n;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\"\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\u0016\u0010'\u001a\u00020\u00192\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/ss/android/lark/contact/customized/search/view/OfficeInviteExternalSearchFragment;", "Lcom/ss/android/lark/contact/base/common_ui/InvBaseFragment;", "<init>", "()V", "viewBinding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbInviteSearchViewLayoutBinding;", "adapter", "Lcom/ss/android/lark/contact/customized/search/view/OfficeInviteExternalSearchAdapter;", "viewModel", "Lcom/ss/android/lark/contact/customized/search/view/OfficeInviteExternalSearchViewModel;", "getViewModel", "()Lcom/ss/android/lark/contact/customized/search/view/OfficeInviteExternalSearchViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "hasHandledInitialKeyword", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initBackPressed", "initView", "handleInitialKeyword", "initObservers", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "showTypingState", "showLoadingState", "showResultsState", "items", "", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactItemModel;", "showEmptyState", "query", "", "showActionState", "updateTypingState", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeInviteExternalSearchFragment extends InvBaseFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f419411h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ContactDbInviteSearchViewLayoutBinding f419412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OfficeInviteExternalSearchAdapter f419413e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f419414f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f419415g;

    public static final class a {
    }

    static {
    }

    public final OfficeInviteExternalSearchViewModel S90() {
        return (OfficeInviteExternalSearchViewModel) this.f419414f.getValue();
    }

    public final void U90() {
        ContactDbInviteSearchViewLayoutBinding r100 = this.f419412d;
        ContactDbInviteSearchViewLayoutBinding r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r100 = null;
    L5:
        r100.f419073e.f419068c.a();
        ContactDbInviteSearchViewLayoutBinding r102 = this.f419412d;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r102 = null;
    L8:
        r102.f419072d.f419065a.setVisibility(8);
        ContactDbInviteSearchViewLayoutBinding r103 = this.f419412d;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r103 = null;
    L11:
        r103.f419073e.f419066a.setVisibility(8);
        ContactDbInviteSearchViewLayoutBinding r104 = this.f419412d;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r104 = null;
    L14:
        r104.f419074f.setVisibility(8);
        ContactDbInviteSearchViewLayoutBinding r105 = this.f419412d;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L18:
        r101.f419076h.f419063a.setVisibility(8);
        return;
    L17:
        r101 = r105;
        goto L18
    }

    public OfficeInviteExternalSearchFragment() {
        final Function0<Fragment> r100 = new OfficeInviteExternalSearchFragment$special$$inlined$viewModels$default$1(this);
        this.f419414f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OfficeInviteExternalSearchViewModel.class), new OfficeInviteExternalSearchFragment$special$$inlined$viewModels$default$2(r100), new OfficeInviteExternalSearchFragment$special$$inlined$viewModels$default$3(r100, this));
    }

    public final void T90(String r100) {
        ContactDbInviteSearchViewLayoutBinding r101 = this.f419412d;
        ContactDbInviteSearchViewLayoutBinding r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r101 = null;
    L6:
        if (r101.f419076h.f419063a.getVisibility() == 0) goto L23;
        ContactDbInviteSearchViewLayoutBinding r103 = this.f419412d;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r103 = null;
    L10:
        r103.f419073e.f419068c.a();
        ContactDbInviteSearchViewLayoutBinding r104 = this.f419412d;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r104 = null;
    L13:
        r104.f419072d.f419065a.setVisibility(8);
        ContactDbInviteSearchViewLayoutBinding r105 = this.f419412d;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r105 = null;
    L16:
        r105.f419073e.f419066a.setVisibility(8);
        ContactDbInviteSearchViewLayoutBinding r106 = this.f419412d;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r106 = null;
    L19:
        r106.f419074f.setVisibility(8);
        ContactDbInviteSearchViewLayoutBinding r107 = this.f419412d;
        if (r107 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r107 = null;
    L22:
        r107.f419076h.f419063a.setVisibility(0);
    L23:
        ICUUtils.FormatArgsBuilder r108 = new ICUUtils.FormatArgsBuilder();
        r108.b("account", r100);
        List<ICUUtils.UFormatPair> r109 = r108.f285892a;
        ContactDbInviteSearchViewLayoutBinding r110 = this.f419412d;
        if (r110 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L27:
        r102.f419076h.f419064b.setText(ICUUtils.icuFormat(UIHelper.getString(R.string.LarkIM_Friend_SearchAccount_Button), r109));
        return;
    L26:
        r102 = r110;
        goto L27
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        Context r112 = getContext();
        if (r112 == null) goto L5;
        Lazy r113 = OfficeContactUtils.f418960a;
        OfficeContactUtils.e(this, UIUtils.getColor(r112, R.color.flow_ud_bg_base_1));
    L5:
        S90().init();
        ContactDbInviteSearchViewLayoutBinding r114 = this.f419412d;
        ContactDbInviteSearchViewLayoutBinding r115 = null;
        if (r114 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r114 = null;
    L8:
        ViewCompat.setTransitionName(r114.f419079k, "contact_db_transition_invite_search_bar");
        ContactDbInviteSearchViewLayoutBinding r116 = this.f419412d;
        if (r116 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r116 = null;
    L11:
        r116.f419070b.setOnClickListener(new d(this));
        ICUUtils.FormatArgsBuilder r117 = new ICUUtils.FormatArgsBuilder();
        r117.b("brandName", UIHelper.getAppName());
        String r118 = ICUUtils.icuFormat(UIHelper.getString(R.string.LarkIM_Friend_SearchPhoneOrBrandAdd_Placeholder), r117.f285892a);
        ContactDbInviteSearchViewLayoutBinding r100 = this.f419412d;
        if (r100 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r100 = null;
    L14:
        r100.f419078j.setHint(r118);
        ContactDbInviteSearchViewLayoutBinding r101 = this.f419412d;
        if (r101 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r101 = null;
    L17:
        r101.f419078j.addOnLayoutChangeListener(new e(r118));
        ContactDbInviteSearchViewLayoutBinding r119 = this.f419412d;
        if (r119 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r119 = null;
    L20:
        r119.f419078j.post(new f(this));
        ContactDbInviteSearchViewLayoutBinding r120 = this.f419412d;
        if (r120 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r120 = null;
    L23:
        r120.f419078j.addTextChangedListener(new g(this));
        ContactDbInviteSearchViewLayoutBinding r121 = this.f419412d;
        if (r121 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r121 = null;
    L26:
        r121.f419078j.setOnEditorActionListener(new h(this));
        View[] r102 = new View[1];
        ContactDbInviteSearchViewLayoutBinding r103 = this.f419412d;
        if (r103 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r103 = null;
    L29:
        boolean r104 = false;
        r102[0] = r103.f419077i;
        q.b(r102);
        ContactDbInviteSearchViewLayoutBinding r105 = this.f419412d;
        if (r105 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r105 = null;
    L32:
        r105.f419077i.setOnClickListener(new i(this));
        ContactDbInviteSearchViewLayoutBinding r106 = this.f419412d;
        if (r106 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r106 = null;
    L35:
        r106.f419075g.setOnClickListener(new j(this));
        ContactDbInviteSearchViewLayoutBinding r107 = this.f419412d;
        if (r107 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r107 = null;
    L38:
        r107.f419076h.f419063a.setOnClickListener(new k(this));
        this.f419413e = new OfficeInviteExternalSearchAdapter(this);
        ContactDbInviteSearchViewLayoutBinding r108 = this.f419412d;
        if (r108 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r108 = null;
    L41:
        r108.f419074f.setLayoutManager(new LinearLayoutManager(requireContext()));
        ContactDbInviteSearchViewLayoutBinding r109 = this.f419412d;
        if (r109 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r109 = null;
    L44:
        RecyclerView r122 = r109.f419074f;
        OfficeInviteExternalSearchAdapter r123 = this.f419413e;
        if (r123 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r123 = null;
    L47:
        r122.setAdapter(r123);
        ContactDbInviteSearchViewLayoutBinding r124 = this.f419412d;
        if (r124 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r124 = null;
    L50:
        LinearLayout r125 = r124.f419069a;
        r125.getViewTreeObserver().addOnPreDrawListener(new c(r125, this));
        S90().getUiState().observe(getViewLifecycleOwner(), new b(this));
        FragmentActivity r126 = getActivity();
        if (r126 == null) goto L56;
        OnBackPressedDispatcher r127 = r126.getOnBackPressedDispatcher();
        if (r127 == null) goto L56;
        r127.addCallback(getViewLifecycleOwner(), new OfficeInviteExternalSearchFragment$initBackPressed$1(this));
    L56:
        if (this.f419415g == true) goto L89;
        Bundle r128 = getArguments();
        if (r128 == null) goto L61;
        String r129 = r128.getString("contact_db_initial_keyword");
    L62:
        StringBuilder r130 = new StringBuilder("hasInitialKeyword=");
        if (r129 != null) goto L65;
    L68:
        boolean r131 = true;
    L69:
        r130.append(!r131);
        Log.i("Contact_InvExternalSearch", r130.toString());
        if (r129 == null) goto L72;
        String r132 = StringsKt.replace$default(r129, " ", "", false, 4, null);
    L73:
        if (r132 != null) goto L76;
        r132 = "";
    L76:
        if (r132.length() != 0) goto L78;
        r104 = true;
    L78:
        if (r104 == true) goto L90;
        this.f419415g = true;
        ContactDbInviteSearchViewLayoutBinding r133 = this.f419412d;
        if (r133 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r133 = null;
    L83:
        r133.f419078j.setText(r132);
        ContactDbInviteSearchViewLayoutBinding r134 = this.f419412d;
        if (r134 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L87:
        r115.f419078j.setSelection(r132.length());
        S90().onSearch();
        return;
    L86:
        r115 = r134;
        goto L87
    L90:
        return;
    L72:
        r132 = null;
        goto L73
    L65:
        if (r129.length() == 0) goto L68;
        r131 = false;
        goto L69
    L61:
        r129 = null;
        goto L62
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r210, int r211, Intent r212) {
        super.onActivityResult(r210, r211, r212);
        Log.i("Contact_InvExternalSearch", "onActivityResult: requestCode = " + r210 + ", resultCode = " + r211);
        int r100 = -1;
        if (r211 != (-1)) goto L42;
        if (r212 != null) goto L7;
        return;
    L7:
        if (r210 != 273) goto L43;
        Serializable r101 = r212.getSerializableExtra("params_key_profile");
        if ((r101 instanceof ProfileFinishResult) == false) goto L44;
        OfficeInviteExternalSearchAdapter r102 = this.f419413e;
        String r103 = null;
        if (r102 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r102 = null;
    L13:
        ProfileFinishResult r104 = (ProfileFinishResult) r101;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "result");
        String r105 = r104.userId;
        if (r105 == null) goto L45;
        Long r106 = StringsKt.toLongOrNull(r105);
        if (r106 == null) goto L46;
        long r107 = r106.longValue();
        Iterator r108 = ((ArrayList) r102.f419403b).iterator();
        int r109 = 0;
    L19:
        if (r108.hasNext() == false) goto L27;
        if (((mtb.d) r108.next()).f515662a != r107) goto L23;
        boolean r110 = true;
    L24:
        if (r110 == true) goto L25;
        r109 = r109 + 1;
        goto L19
    L25:
        r100 = r109;
        goto L27
    L23:
        r110 = false;
    L27:
        Log.i("Contact_InvExternalSearchAdapter", "updateStatus index=" + r100 + " friend=" + r104.isFriend + " reqApplied=" + r104.isRequestUserApplied + " targetApplied=" + r104.isTargetUserApplied);
        if (r100 < 0) goto L48;
        mtb.d r111 = (mtb.d) ListProtector.get(r102.f419403b, r100);
        n r112 = r111.f515672k;
        boolean r113 = r104.isFriend;
        boolean r114 = r104.isRequestUserApplied;
        if (r112 == null) goto L33;
        long r115 = r112.f515698c;
    L34:
        if (r112 == null) goto L36;
        r103 = r112.f515699d;
    L36:
        if (r103 != null) goto L38;
        r103 = "";
    L38:
        n r213 = new n(r113, r114, r115, r103, r104.isTargetUserApplied);
        List<mtb.d> r116 = r102.f419403b;
        long r117 = r111.f515662a;
        long r118 = r111.f515663b;
        String r119 = r111.f515664c;
        String r120 = r111.f515665d;
        String r121 = r111.f515666e;
        String r122 = r111.f515667f;
        String r123 = r111.f515668g;
        String r124 = r111.f515669h;
        boolean r125 = r111.f515670i;
        boolean r126 = r111.f515671j;
        Intrinsics.checkNotNullParameter(r119, "name");
        Intrinsics.checkNotNullParameter(r120, "alias");
        Intrinsics.checkNotNullParameter(r121, CommonConstant.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(r122, "displayNamePinyin");
        Intrinsics.checkNotNullParameter(r123, "avatarKey");
        Intrinsics.checkNotNullParameter(r124, "doubaoKey");
        ListProtector.set(r116, r100, new mtb.d(r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r213));
        r102.notifyItemChanged(r100);
        return;
    L33:
        r115 = 0;
        goto L34
    L48:
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L43:
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r100 = r110.inflate(R.layout.contact_db_invite_search_view_layout, r111, false);
        int r101 = R.id.ipsCancelTv;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r100, R.id.ipsCancelTv);
        if (r102 == null) goto L40;
        r101 = R.id.ipsContentFl;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.ipsContentFl);
        if (r103 == null) goto L40;
        r101 = R.id.ipsEmptyLayout;
        View r104 = ViewBindings.findChildViewById(r100, R.id.ipsEmptyLayout);
        if (r104 == null) goto L40;
        ContactDbInviteSearchEmptyLayoutBinding r105 = new ContactDbInviteSearchEmptyLayoutBinding((TextView) r104);
        r101 = R.id.ipsLoadingLayout;
        View r106 = ViewBindings.findChildViewById(r100, R.id.ipsLoadingLayout);
        if (r106 == null) goto L40;
        FrameLayout r107 = (FrameLayout) r106;
        ContactOfficeLoadingView r108 = (ContactOfficeLoadingView) ViewBindings.findChildViewById(r106, R.id.ipsLoadingSpinner);
        if (r108 == null) goto L37;
        ContactDbInviteSearchLoadingLayoutBinding r109 = new ContactDbInviteSearchLoadingLayoutBinding(r107, r107, r108);
        r101 = R.id.ipsResultRv;
        RecyclerView r113 = (RecyclerView) ViewBindings.findChildViewById(r100, R.id.ipsResultRv);
        if (r113 == null) goto L40;
        LinearLayout r114 = (LinearLayout) r100;
        View r115 = ViewBindings.findChildViewById(r100, R.id.ipsSearchActionLayout);
        if (r115 == null) goto L35;
        int r116 = R.id.ipsActionIconIv;
        if (((ImageView) ViewBindings.findChildViewById(r115, R.id.ipsActionIconIv)) == null) goto L34;
        LinearLayout r117 = (LinearLayout) r115;
        TextView r118 = (TextView) ViewBindings.findChildViewById(r115, R.id.ipsActionTextTv);
        if (r118 == null) goto L31;
        ContactDbInviteSearchActionItemLayoutBinding r119 = new ContactDbInviteSearchActionItemLayoutBinding(r117, r118);
        ImageView r120 = (ImageView) ViewBindings.findChildViewById(r100, R.id.ipsSearchClearIv);
        if (r120 == null) goto L30;
        SCEditText r121 = (SCEditText) ViewBindings.findChildViewById(r100, R.id.ipsSearchEt);
        if (r121 == null) goto L29;
        LKUIRoundLinearLayout r122 = (LKUIRoundLinearLayout) ViewBindings.findChildViewById(r100, R.id.ipsSearchLl);
        if (r122 == null) goto L28;
        this.f419412d = new ContactDbInviteSearchViewLayoutBinding(r114, r102, r103, r105, r109, r113, r114, r119, r120, r121, r122);
        return r114;
    L28:
        r101 = R.id.ipsSearchLl;
        goto L40
    L29:
        r101 = R.id.ipsSearchEt;
        goto L40
    L30:
        r101 = R.id.ipsSearchClearIv;
        goto L40
    L31:
        r116 = R.id.ipsActionTextTv;
    L34:
        throw new NullPointerException("Missing required view with ID: ".concat(r115.getResources().getResourceName(r116)));
    L35:
        r101 = R.id.ipsSearchActionLayout;
        goto L40
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r106.getResources().getResourceName(R.id.ipsLoadingSpinner)));
    L40:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
