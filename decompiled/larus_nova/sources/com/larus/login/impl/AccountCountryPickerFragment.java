package com.larus.login.impl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.router.SmartRouter;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.search.SearchBar;
import com.larus.login.impl.databinding.LarusAccountCountryPickerPageBinding;
import com.larus.login.impl.impl.AccountTrace;
import com.larus.nova.R;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0002J \u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#H\u0002J\u001f\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u0007H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/login/impl/AccountCountryPickerFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/login/impl/OnItemClickListener;", "<init>", "()V", "headerTextItems", "", "", "binding", "Lcom/larus/login/impl/databinding/LarusAccountCountryPickerPageBinding;", "isBindPhoneFromH5", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "getData", "onItemClick", "countryNameCode", CommonConstant.KEY_COUNTRY_CODE, "countryName", "scrollToPosition", "index", "sortCountries", "Lorg/json/JSONArray;", "jsonArray", "sortByPinyin", "getPinyin", DistrictSearchQuery.KEYWORDS_COUNTRY, "Lorg/json/JSONObject;", "getSectionName", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Character;", "matchSearchData", "inputString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AccountCountryPickerFragment extends Fragment implements b1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f357119g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f357120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusAccountCountryPickerPageBinding f357121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f357122f;

    public static final class a implements SideIndexBar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccountCountryPickerFragment f357123a;

        public a(AccountCountryPickerFragment r100) {
            this.f357123a = r100;
        }

        @Override // com.larus.login.impl.SideIndexBar.b
        public final void onIndexChanged(String r100) {
            Intrinsics.checkNotNullParameter(r100, "index");
            AccountCountryPickerFragment r101 = this.f357123a;
            LarusAccountCountryPickerPageBinding r102 = r101.f357121e;
            if (r102 == null) goto L7;
            RecyclerView r103 = r102.f357398c;
            if (r103 == null) goto L7;
            RecyclerView.Adapter r104 = r103.getAdapter();
        L9:
            if ((r104 instanceof CountryCodeItemAdapter) == false) goto L11;
            CountryCodeItemAdapter r105 = (CountryCodeItemAdapter) r104;
        L12:
            if (r105 == null) goto L33;
            List<k0> r106 = r105.f357153a;
            if (r106 == null) goto L37;
            int r107 = r106.size();
            int r108 = 0;
        L17:
            if (r108 >= r107) goto L38;
            if (Intrinsics.areEqual(((k0) ListProtector.get(r106, r108)).f357801a, r100) == false) goto L32;
            LarusAccountCountryPickerPageBinding r109 = r101.f357121e;
            if (r109 == null) goto L25;
            RecyclerView r110 = r109.f357398c;
            if (r110 == null) goto L25;
            r110.scrollToPosition(r108);
        L25:
            LarusAccountCountryPickerPageBinding r111 = r101.f357121e;
            if (r111 == null) goto L30;
            RecyclerView r112 = r111.f357398c;
            if (r112 == null) goto L30;
            RecyclerView.LayoutManager r113 = r112.getLayoutManager();
        L31:
            Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) r113).scrollToPositionWithOffset(r108, 0);
        L30:
            r113 = null;
        L32:
            r108 = r108 + 1;
            goto L17
        L38:
            return;
        L37:
            return;
        L33:
            return;
        L11:
            r105 = null;
        L7:
            r104 = null;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.larus.login.impl.AccountCountryPickerFragment$onCreateView$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.login.impl.AccountCountryPickerFragment$onCreateView$2", f = "AccountCountryPickerFragment.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AccountCountryPickerFragment this$0;

        /* JADX INFO: renamed from: com.larus.login.impl.AccountCountryPickerFragment$onCreateView$2$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AccountCountryPickerFragment f357124a;

            public a(AccountCountryPickerFragment r100) {
                this.f357124a = r100;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r100, Continuation r101) {
                AccountCountryPickerFragment r102 = this.f357124a;
                int r103 = AccountCountryPickerFragment.f357119g;
                r102.getClass();
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r102), Dispatchers.getIO(), null, new AccountCountryPickerFragment$matchSearchData$1(r102, (String) r100, null), 2, null);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass2(AccountCountryPickerFragment r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L20:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            LarusAccountCountryPickerPageBinding r103 = this.this$0.f357121e;
            if (r103 == null) goto L20;
            SearchBar r104 = r103.f357399d;
            if (r104 == null) goto L20;
            kotlinx.coroutines.flow.d1<String> r105 = r104.getInputTextFlow();
            if (r105 == null) goto L20;
            Flow r106 = kotlinx.coroutines.flow.e.m(r105, 100);
            if (r106 == null) goto L20;
            a r107 = new a(this.this$0);
            this.label = 1;
            if (r106.collect(r107, this) != r101) goto L20;
            return r101;
        }
    }

    public AccountCountryPickerFragment() {
        this.f357120d = new ArrayList();
    }

    public static String U90(JSONObject r100) {
        if (AppHost.f326268a.isOversea() == true) goto L11;
        String r101 = r100.optString("pin_yin");
        Intrinsics.checkNotNull(r101);
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L11;
        return r101;
    L11:
        return ru7.c.d(r100.optString("country_name"));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        boolean r102 = false;
        if (r101 == null) goto L5;
        r102 = r101.getBoolean("key_bind_phone_from_h5", false);
    L5:
        this.f357122f = r102;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.login.impl.n0] */
    public static final JSONArray T90(AccountCountryPickerFragment r100, JSONArray r101) {
        r100.getClass();
        int r102 = 0;
        if (AppHost.f326268a.isOversea() == true) goto L5;
    L13:
        ArrayList r103 = new ArrayList();
        int r104 = r101.length();
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L17;
        r103.add(JSONArrayProtectorUtils.getJSONObject(r101, r105));
        r105 = r105 + 1;
        goto L14
    L17:
        if (r103.size() <= 1) goto L19;
        CollectionsKt.sortWith(r103, new i(r100));
    L19:
        JSONArray r106 = new JSONArray();
        int r107 = r103.size();
    L20:
        if (r102 >= r107) goto L22;
        r106.put(ListProtector.get(r103, r102));
        r102 = r102 + 1;
    L22:
        return r106;
    L5:
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), Locale.CHINA.getLanguage()) == true) goto L13;
        p0.f358189a.getClass();
        Intrinsics.checkNotNullParameter(r101, "jsonArray");
        ArrayList r108 = new ArrayList();
        int r109 = r101.length();
        int r110 = 0;
    L8:
        if (r110 >= r109) goto L10;
        r108.add(JSONArrayProtectorUtils.getJSONObject(r101, r110));
        r110 = r110 + 1;
        goto L8
    L10:
        final Collator r111 = Collator.getInstance(Locale.getDefault());
        final ?? r112 = new n0(r111);
        CollectionsKt.sortWith(r108, new o0(r112));
        r106 = new JSONArray();
        int r113 = r108.size();
    L11:
        if (r102 >= r113) goto L22;
        r106.put(ListProtector.get(r108, r102));
        r102 = r102 + 1;
        goto L11
    }

    public static final Character S90(AccountCountryPickerFragment r100, JSONObject r101, String r102) {
        r100.getClass();
        if (AppHost.f326268a.isOversea() == true) goto L5;
    L6:
        r102 = U90(r101);
    L7:
        Character r103 = StringsKt.firstOrNull(r102);
        if (r103 != null) goto L12;
        return null;
    L12:
        return Character.valueOf(Character.toUpperCase(r103.charValue()));
    L5:
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), Locale.CHINA.getLanguage()) == false) goto L7;
        goto L6
    }

    @Override // com.larus.login.impl.b1
    public final void j4(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "countryNameCode");
        Intrinsics.checkNotNullParameter(r101, CommonConstant.KEY_COUNTRY_CODE);
        Intrinsics.checkNotNullParameter(r102, "countryName");
        com.bytedance.router.i r103 = SmartRouter.buildRoute(getContext(), "//flow/phone_login");
        r103.f267554c.putExtra("country_code", r100);
        r103.f267554c.putExtra("phone_code", r101);
        Bundle r104 = getArguments();
        Boolean r105 = null;
        if (r104 == null) goto L5;
        String r106 = r104.getString("phoneLoginTitle");
    L6:
        r103.f267554c.putExtra("phoneLoginTitle", r106);
        Bundle r107 = getArguments();
        if (r107 == null) goto L9;
        String r108 = r107.getString("phoneTicket");
    L10:
        r103.f267554c.putExtra("phoneTicket", r108);
        Bundle r109 = getArguments();
        if (r109 == null) goto L13;
        String r110 = r109.getString("unusableMobileTicket");
    L14:
        r103.f267554c.putExtra("unusableMobileTicket", r110);
        Bundle r111 = getArguments();
        if (r111 == null) goto L17;
        String r112 = r111.getString("pending_deeplink_schema");
    L18:
        r103.f267554c.putExtra("pending_deeplink_schema", r112);
        Bundle r113 = getArguments();
        if (r113 == null) goto L21;
        Boolean r114 = Boolean.valueOf(r113.getBoolean("key_bind_phone_when_login", false));
    L22:
        r103.f267554c.putExtra("key_bind_phone_when_login", r114);
        Bundle r115 = getArguments();
        if (r115 == null) goto L25;
        Boolean r116 = Boolean.valueOf(r115.getBoolean("key_bind_phone_is_new_user"));
    L26:
        r103.f267554c.putExtra("key_bind_phone_is_new_user", r116);
        Bundle r117 = getArguments();
        if (r117 == null) goto L29;
        Boolean r118 = Boolean.valueOf(r117.getBoolean("key_bind_phone_profile_key"));
    L30:
        r103.f267554c.putExtra("key_bind_phone_profile_key", r118);
        Bundle r119 = getArguments();
        if (r119 == null) goto L33;
        r105 = Boolean.valueOf(r119.getBoolean("key_bind_phone_from_main"));
    L33:
        r103.f267554c.putExtra("key_bind_phone_from_main", r105);
        Bundle r120 = getArguments();
        String r121 = "";
        if (r120 == null) goto L37;
        String r122 = r120.getString("key_trigger_app_id");
        if (r122 == null) goto L37;
    L38:
        r103.f267554c.putExtra("key_trigger_app_id", r122);
        r103.f267554c.putExtra("key_bind_phone_from_h5", this.f357122f);
        Bundle r123 = getArguments();
        if (r123 == null) goto L44;
        String r124 = r123.getString("account_enter_method");
        if (r124 == null) goto L44;
        r121 = r124;
    L44:
        r103.f267554c.putExtra("account_enter_method", r121);
        r103.f267554c.addFlags(67108864);
        r103.d();
        FragmentActivity r125 = getActivity();
        if (r125 == null) goto L47;
        r125.finish();
    L47:
        new AccountTrace();
        Integer r126 = StringsKt.toIntOrNull(r101);
        Intrinsics.checkNotNullParameter(r102, DistrictSearchQuery.KEYWORDS_COUNTRY);
        IApplog.Companion r127 = IApplog.f287053a;
        JSONObject r128 = new JSONObject();
        r128.put("code", r126);
        r128.put(DistrictSearchQuery.KEYWORDS_COUNTRY, r102);
        Unit r129 = Unit.INSTANCE;
        r127.reportEvent("click_phone_login_region", r128);
        return;
    L37:
        r122 = "";
        goto L38
    L29:
        r118 = null;
        goto L30
    L25:
        r116 = null;
        goto L26
    L21:
        r114 = null;
        goto L22
    L17:
        r112 = null;
        goto L18
    L13:
        r110 = null;
        goto L14
    L9:
        r108 = null;
        goto L10
    L5:
        r106 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.inflate(R.layout.larus_account_country_picker_page, r110, false);
        int r112 = R.id.center_text_view;
        if (((CenterTextView) ViewBindings.findChildViewById(r101, R.id.center_text_view)) == null) goto L52;
        r112 = R.id.country_pick_close;
        ImageView r113 = (ImageView) ViewBindings.findChildViewById(r101, R.id.country_pick_close);
        if (r113 == null) goto L52;
        r112 = R.id.country_pick_title;
        if (((TextView) ViewBindings.findChildViewById(r101, R.id.country_pick_title)) == null) goto L52;
        r112 = R.id.rv_country_code_list;
        RecyclerView r102 = (RecyclerView) ViewBindings.findChildViewById(r101, R.id.rv_country_code_list);
        if (r102 == null) goto L52;
        r112 = R.id.search_country;
        SearchBar r103 = (SearchBar) ViewBindings.findChildViewById(r101, R.id.search_country);
        if (r103 == null) goto L52;
        r112 = R.id.search_country_no_cancel;
        SearchBar r104 = (SearchBar) ViewBindings.findChildViewById(r101, R.id.search_country_no_cancel);
        if (r104 == null) goto L52;
        r112 = R.id.slide_index_bar;
        SideIndexBar r105 = (SideIndexBar) ViewBindings.findChildViewById(r101, R.id.slide_index_bar);
        if (r105 == null) goto L52;
        this.f357121e = new LarusAccountCountryPickerPageBinding((ConstraintLayout) r101, r113, r102, r103, r104, r105);
        if (this.f357122f == false) goto L23;
        r113.setImageResource(R.drawable.larus_ic_nav_back);
        LarusAccountCountryPickerPageBinding r106 = this.f357121e;
        if (r106 == null) goto L23;
        ImageView r107 = r106.f357397b;
        if (r107 == null) goto L23;
        r107.setPadding(0, 0, 0, 0);
    L23:
        LarusAccountCountryPickerPageBinding r108 = this.f357121e;
        if (r108 == null) goto L28;
        ImageView r109 = r108.f357397b;
        if (r109 == null) goto L28;
        r109.setOnClickListener(new f(this));
    L28:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass2(this, null), 3, null);
        LarusAccountCountryPickerPageBinding r114 = this.f357121e;
        if (r114 == null) goto L33;
        SearchBar r115 = r114.f357400e;
        if (r115 == null) goto L33;
        r115.setOnClickListener(new g(this));
    L33:
        LarusAccountCountryPickerPageBinding r116 = this.f357121e;
        if (r116 == null) goto L38;
        SearchBar r117 = r116.f357399d;
        if (r117 == null) goto L38;
        r117.setCustomCancelClickAction(new h(this));
    L38:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AccountCountryPickerFragment$getData$1(this, null), 2, null);
        LarusAccountCountryPickerPageBinding r118 = this.f357121e;
        if (r118 == null) goto L43;
        RecyclerView r119 = r118.f357398c;
        if (r119 == null) goto L43;
        r119.setLayoutManager(new LinearLayoutManager(getContext()));
    L43:
        LarusAccountCountryPickerPageBinding r120 = this.f357121e;
        if (r120 == null) goto L48;
        SideIndexBar r121 = r120.f357401f;
        if (r121 == null) goto L48;
        r121.f357218i = new a(this);
    L48:
        if (r120 != null) goto L50;
        return null;
    L50:
        return r120.f357396a;
    L52:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r112)));
    }
}
