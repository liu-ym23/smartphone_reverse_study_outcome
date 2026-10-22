package com.bytedance.ee.bear.doc.translate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.CompatLandscapeBottomSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0017H\u0002J\u0006\u0010\u001f\u001a\u00020\u0012J\u0006\u0010 \u001a\u00020\u0012J\u0018\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u0012H\u0002J\b\u0010&\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020\u0012H\u0002J\u0018\u0010(\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020)2\u0006\u0010#\u001a\u00020$H\u0002J\"\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020-H\u0016J\b\u00100\u001a\u00020\u0012H\u0002J\b\u00101\u001a\u00020\u0012H\u0016J\b\u00102\u001a\u00020$H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/doc/translate/ChooseLanguageFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/CompatLandscapeBottomSheetDialogFragment;", "<init>", "()V", "TAG", "", "statusBar", "Lcom/bytedance/ee/util/statusbar/IStatusBar;", "viewModel", "Lcom/bytedance/ee/bear/doc/translate/TranslateViewModel;", "recentlyUseLanguagesFl", "Landroid/widget/LinearLayout;", "recentlyUseLanguagesAdapter", "Lcom/bytedance/ee/bear/doc/translate/ChooseLanguageAdapter;", "translateLanguagesAdapter", "pluginHost", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "setPluginHost", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initViews", "reportTopBarClickCloseEvent", "reportTopBarViewEvent", "reportClickTranslate", "language", "isRecent", "", "reportTranslateView", "isVersion", "initObservers", "onSelectLanguage", "Lcom/bytedance/ee/bear/doc/translate/LanguageModel;", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "", "enter", "nextAnim", "closePanel", "onDestroy", "isSupportScreenLandscape", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChooseLanguageFragment extends CompatLandscapeBottomSheetDialogFragment {
    public final String k;
    public TranslateViewModel l;
    public LinearLayout m;
    public final ChooseLanguageAdapter n;
    public final ChooseLanguageAdapter o;
    public PluginHost p;

    public final boolean ea0() {
        PluginHost r0 = this.p;
        PluginHost r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pluginHost");
        r0 = null;
    L6:
        if ((r0 instanceof DocumentPluginHost) == true) goto L9;
        return false;
    L9:
        PluginHost r2 = this.p;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("pluginHost");
    L14:
        return ((DocumentPluginHost) r1).a().isEditionDoc();
    L12:
        r1 = r2;
        goto L14
    }

    public ChooseLanguageFragment() {
        this.k = "ChooseLanguageFragment";
        this.n = new ChooseLanguageAdapter();
        this.o = new ChooseLanguageAdapter();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment
    public final boolean ba0() {
        return !ku5.c.k(getActivity());
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment
    public final void onDestroy() {
        super.onDestroy();
        TranslateViewModel r0 = this.l;
        if (r0 == null) goto L8;
        MutableLiveData<Boolean> r1 = r0.getShowingChooseLanguagePanel();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.FALSE);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L5;
        xu5.b.b(r4, null);
    L5:
        PluginHost r5 = this.p;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pluginHost");
        r5 = null;
    L8:
        this.l = (TranslateViewModel) q.c(r5, TranslateViewModel.class, null);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final void onViewCreated(View r17, Bundle r18) {
        Intrinsics.checkNotNullParameter(r17, "view");
        super.onViewCreated(r17, r18);
        if (ForsetiHelper.s(this) == false) goto L5;
        r17.setBackgroundColor(0);
    L5:
        r17.findViewById(2131377455).setOnActionListener(new b(this));
        this.m = (LinearLayout) r17.findViewById(2131383871);
        RecyclerView r2 = r17.findViewById(2131383872);
        RecyclerView r0 = r17.findViewById(2131389345);
        r2.setLayoutManager(new LinearLayoutManager(getContext()));
        r0.setLayoutManager(new LinearLayoutManager(getContext()));
        r2.setAdapter(this.n);
        r0.setAdapter(this.o);
        Intrinsics.checkNotNull(r2);
        com.larksuite.component.ignition.widget.setting_group.a.a(r2);
        Intrinsics.checkNotNull(r0);
        com.larksuite.component.ignition.widget.setting_group.a.a(r0);
        this.n.c = new ChooseLanguageFragment$initViews$2(this);
        this.o.c = new ChooseLanguageFragment$initViews$3(this);
        com.bytedance.ee.bear.contract.d r1 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        HashMap<String, Object> r5 = r1.m("docCommonParams");
        r1.n("ccm_space_docs_topbar_view", r5);
        tt5.a.b(this.k, "reportTopBarViewEvent, params = " + r5);
        TranslateViewModel r3 = this.l;
        if (r3 == null) goto L10;
        MutableLiveData<List<LanguageModel>> r4 = r3.getChooseLanguages();
        if (r4 == null) goto L10;
        r4.observe(this, new ChooseLanguageFragment$initObservers$1(this));
    L10:
        TranslateViewModel r6 = this.l;
        if (r6 == null) goto L15;
        MutableLiveData<LanguageModel> r7 = r6.getSelectedLanguage();
        if (r7 == null) goto L15;
        r7.observe(this, new ChooseLanguageFragment$initObservers$2(this));
    L15:
        TranslateViewModel r8 = this.l;
        if (r8 == null) goto L20;
        MutableLiveData<List<LanguageModel>> r9 = r8.getRecentlyUsedLanguages();
        if (r9 == null) goto L20;
        r9.observe(this, new ChooseLanguageFragment$initObservers$3(this));
    L20:
        int r10 = n.a;
        boolean r14 = ea0();
        if (org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6) == null) goto L42;
        HashMap<String, String> r11 = ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).t("tranlste");
        if (r11.size() <= 0) goto L43;
        com.bytedance.ee.bear.more.b r12 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);     // Catch: NumberFormatException -> L34
        String r13 = r11.get("token");     // Catch: NumberFormatException -> L34
        String r16 = r11.get("type");     // Catch: NumberFormatException -> L34
        if (r16 == null) goto L27;
        int r19 = CastIntegerProtector.parseInt(r16);     // Catch: NumberFormatException -> L34
    L28:
        r12.I(new com.bytedance.ee.bear.more.l("ccm_space_translate_view", null, r13, r19, "", Boolean.parseBoolean(r11.get("is_wiki")), Boolean.parseBoolean(r11.get("is_at_vc")), false, r14, ""));     // Catch: NumberFormatException -> L32
        return;
    L32:
        e = e;
    L36:
        tt5.a.f("tranlste", e, false);
        return;
    L27:
        r19 = -1;
    L34:
        e = e;
        goto L36
    L43:
        return;
    }

    public static final void da0(ChooseLanguageFragment r18, LanguageModel r19, boolean r20) {
        TranslateViewModel r1 = r18.l;
        if (r1 == null) goto L5;
        r1.onSelectLanguage(r19);
    L5:
        TranslateViewModel r2 = r18.l;
        if (r2 == null) goto L10;
        MutableLiveData<Boolean> r3 = r2.getShowingChooseLanguagePanel();
        if (r3 == null) goto L10;
        r3.setValue(Boolean.FALSE);
    L10:
        String r12 = r19.getTag();
        int r4 = n.a;
        boolean r16 = r18.ea0();
        Intrinsics.checkNotNullParameter(r12, "language");
        if (org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6) == null) goto L29;
        HashMap<String, String> r0 = ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).t("tranlste");
        if (r0.size() <= 0) goto L30;
        com.bytedance.ee.bear.more.b r5 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);     // Catch: NumberFormatException -> L24
        String r7 = r0.get("token");     // Catch: NumberFormatException -> L24
        String r6 = r0.get("type");     // Catch: NumberFormatException -> L24
        if (r6 == null) goto L17;
        int r8 = CastIntegerProtector.parseInt(r6);     // Catch: NumberFormatException -> L24
    L18:
        boolean r10 = Boolean.parseBoolean(r0.get("is_wiki"));     // Catch: NumberFormatException -> L24
        boolean r11 = Boolean.parseBoolean(r0.get("is_at_vc"));     // Catch: NumberFormatException -> L24
        if (r20 == false) goto L21;
        String r9 = "recent";
    L22:
        r5.E(new com.bytedance.ee.bear.more.m("ccm_space_translate_click", null, r7, r8, "", r10, r11, r12, "ccm_docs_page_view", r9, false, r16, ""));     // Catch: NumberFormatException -> L24
        return;
    L21:
        r9 = "all";
        goto L22
    L17:
        r8 = -1;
    L24:
        e = move-exception;
        tt5.a.f("tranlste", e, false);
        return;
    L30:
        return;
    }

    public final Animation onCreateAnimation(int r1, boolean r2, int r3) {
        if (U90() == false) goto L6;
        return null;
    L6:
        if (r2 == false) goto L9;
        return AnimationUtils.loadAnimation(getContext(), 2130772668);
    L9:
        return AnimationUtils.loadAnimation(getContext(), 2130772669);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131559353, r3, false);
    }
}
