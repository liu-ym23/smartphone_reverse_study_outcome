package com.bytedance.ee.bear.doc.translate;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.documentinfo.TranslateTargetData;
import com.bytedance.ee.bear.document.event.IEventPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.observer.DiffObserver;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.biz.im.api.m0;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.ApiUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class TranslatePlugin extends DocumentPlugin implements m0 {
    private static final String CHOOSE_LANGUAGE = "biz.translate.chooseLanguage";
    private static final String JS_SET_PANEL_HEIGHT = "javascript:lark.biz.util.setPanelHeight";
    private static final String JS_TRANSLATE = "javascript:window.lark.biz.translate.translate";
    private static final String MENU_ID_SWITCH_TO_ORIGINAL = "SWITCH_LANG_ORIGINAL";
    private static final String MENU_ID_SWITCH_TO_TRANSLATE = "SWITCH_LANG_TRANSLATE";
    private static final String SETUP_TRANSLATE = "biz.translate.setupTranslation";
    private static final String SET_ENABLE_SCROLL = "biz.util.setEnableScroll";
    private static final String SET_RIGHT_BOTTOM_MENU = "biz.translate.setLangMenus";
    private static final String SET_TRANSLATE_LANGUAGE_SWITCH_VISIBLE = "biz.translate.setTranslateLanguageSwitchVisible";
    private static final String SHOW_ORIGINAL = "biz.translate.showOriginalLanguage";
    private static final String TAG = "TranslatePlugin";
    private static final String TRANSLATE_SETTING_CHANGE = "javascript:window.lark.biz.translate.settingChange";
    private static final String TRANSLATE_TARGET_CHANGE = "biz.translate.setTranslateItem";
    private Animation dismissAnimation;
    private DocViewModel docViewModel;
    private boolean enableTranslate;
    private GestureDetector gestureDetector;
    private j languageSwitchHandler;
    private View languageViewGroup;
    private ChooseLanguageFragment mChooseLanguageFragment;
    private final IEventPlugin.a mOnDeleteListener;
    private View.OnTouchListener onTouchListener;
    private TextView originalLanguageView;
    private int restoredLanguageSwitchVisible;
    private Animation showAnimation;
    private View switchLangugeView;
    private ImageView translateChooseIcon;
    private volatile TranslateLanguageSetting translateLanguageSetting;
    private TextView translateLanguageView;
    private ImageView translateSwitchIcon;
    private TranslateViewModel translateViewModel;

    public static class EnableData implements NonProguard {
        public boolean enable;

        public EnableData() {
        }
    }

    public static class Translation implements BaseJSModel {
        public boolean enableTranslate;

        public Translation() {
        }
    }

    public static class VisibleData implements NonProguard {
        public boolean visible;

        public VisibleData() {
        }
    }

    public class a implements IEventPlugin.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TranslatePlugin f218341a;

        public a(TranslatePlugin r100) {
            this.f218341a = r100;
        }

        @Override // com.bytedance.ee.bear.document.event.IEventPlugin.a
        public final void a(String r100) {
            TranslatePlugin.access$000(this.f218341a);
        }
    }

    public class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TranslatePlugin f218342a;

        public b(TranslatePlugin r100) {
            this.f218342a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            TranslatePlugin.access$100(this.f218342a).onTouchEvent(r101);
            return false;
        }
    }

    public class c extends com.bytedance.ee.bear.doc.translate.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TranslatePlugin f218343c;

        public c(TranslatePlugin r100, Context r101) {
            this.f218343c = r100;
            super(r101);
        }
    }

    public class d extends DiffObserver<Boolean> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TranslatePlugin f218344b;

        public d(TranslatePlugin r100) {
            this.f218344b = r100;
        }

        @Override // com.bytedance.ee.util.observer.DiffObserver
        public final void a(Boolean r100) {
            Boolean r101 = Boolean.TRUE;
            if (r101.equals(r100) == false) goto L6;
            TranslatePlugin.access$1100(this.f218344b);
            TranslatePlugin.access$1200(this.f218344b);
            return;
        L6:
            if (TranslatePlugin.access$1300(this.f218344b) != null) goto L16;
        L14:
            TranslatePlugin.access$1400(this.f218344b);
            return;
        L16:
            TranslatePlugin.access$1300(this.f218344b).dismissAllowingStateLoss();     // Catch: Exception -> L10
        L10:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r102 = DialogFragmentLancet.sLastShowStack;
            if (r102 == null) goto L14;
            com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L14
        }
    }

    public class e extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MenuItem f218345c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TranslatePlugin f218346d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            TranslatePlugin.access$1500(this.f218346d).c(this.f218345c, r100);
        }

        public e(TranslatePlugin r100, MenuItem r101) {
            this.f218346d = r100;
            this.f218345c = r101;
        }
    }

    public class f extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TranslatePlugin f218347c;

        public f(TranslatePlugin r100) {
            this.f218347c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            final j r101 = TranslatePlugin.access$1500(this.f218347c);
            T r102 = r101.f565638e;
            if (r102 != 0) goto L5;
            return;
        L5:
            if ((r102 instanceof TranslateMenuData) == false) goto L23;
            TranslateMenuData r103 = (TranslateMenuData) r102;
            List<String> r104 = r103.getLanguages();
            List<String> r105 = r103.getDisplay_languages();
            if (r104 == null) goto L20;
            if (r105 == null) goto L20;
            if (r104.isEmpty() == true) goto L20;
            if (r104.size() != r105.size()) goto L20;
            TranslatePlugin.access$2100(r101.f218352i).setShowingChooseLanguageFragment(Boolean.TRUE);
            TranslatePlugin.access$2100(r101.f218352i).setChooseLanguages(LanguageModel.buildLanguageModelList((String[]) r104.toArray(new String[0]), (String[]) r105.toArray(new String[0])));
            int r106 = r103.getDisplay_language_index();
            if (r106 >= 0) goto L16;
        L18:
            tt5.a.d(TranslatePlugin.TAG, "Displaying language index[ " + r106 + "] is invalid ! listSize=" + r105.size());
        L19:
            TranslatePlugin.access$2100(r101.f218352i).setOnLanguageSelectListener(new com.bytedance.ee.bear.doc.translate.m(r101));
            return;
        L16:
            if (r106 >= r105.size()) goto L18;
            TranslatePlugin.access$2100(r101.f218352i).setSelectedLanguage(LanguageModel.buildLanguageModel((String) ListProtector.get(r104, r106), (String) ListProtector.get(r105, r106)));
        L20:
            tt5.a.k(TranslatePlugin.TAG, "Failed to show ChooseTranslateLanguageFragment. TranslateData:" + r103);
            return;
        }
    }

    public class g extends com.bytedance.ee.bear.doc.translate.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TranslatePlugin f218348a;

        public g(TranslatePlugin r100) {
            this.f218348a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            TranslatePlugin.access$1702(this.f218348a, null);
        }
    }

    public class h extends com.bytedance.ee.bear.doc.translate.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TranslatePlugin f218349a;

        public h(TranslatePlugin r100) {
            this.f218349a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            TranslatePlugin.access$1802(this.f218349a, null);
            TranslatePlugin.access$1900(this.f218349a).setVisibility(4);
        }
    }

    public class i implements tb5.i<ChooseLanguageData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public tb5.m f218350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TranslatePlugin f218351b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public i(TranslatePlugin r100) {
            this.f218351b = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r101) {
            ChooseLanguageData r102 = (ChooseLanguageData) r100;
            tt5.a.h(TranslatePlugin.TAG, "choose language:" + r102);
            this.f218350a = r101;
            if (ChooseLanguageData.validate(r102) == false) goto L6;
            TranslatePlugin.access$2100(this.f218351b).setShowingChooseLanguageFragment(Boolean.TRUE);
            TranslatePlugin.access$2100(this.f218351b).setChooseLanguages(LanguageModel.buildLanguageModelList(r102.languages, r102.display_languages));
            TranslatePlugin.access$2100(this.f218351b).setSelectedLanguage(null);
            TranslatePlugin.access$2100(this.f218351b).setOnLanguageSelectListener(new com.bytedance.ee.bear.doc.translate.l(this));
            return;
        }
    }

    public class j extends y15.c<TranslateMenuData> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ TranslatePlugin f218352i;

        @Override // y15.c
        public final List<MenuItem> a(List<MenuItem> r100) {
            if (r100 == null) goto L11;
            Iterator<MenuItem> r101 = r100.iterator();
        L5:
            if (r101.hasNext() == false) goto L11;
            String r102 = r101.next().getId();
            if (TranslatePlugin.MENU_ID_SWITCH_TO_ORIGINAL.equals(r102) == true) goto L5;
            if (TranslatePlugin.MENU_ID_SWITCH_TO_TRANSLATE.equals(r102) == true) goto L5;
            r101.remove();
        L11:
            return r100;
        }

        @Override // y15.c
        public final void e(List<MenuItem> r100) {
            super.e(r100);
            if (TranslatePlugin.access$2200(this.f218352i) == true) goto L5;
            TranslatePlugin.access$000(this.f218352i);
            return;
        L5:
            TranslatePlugin.access$900(this.f218352i);
        }

        public j(TranslatePlugin r100, DocumentPluginHost r101) {
            this.f218352i = r100;
            super(r101.getContext(), r101.a(), r101.getUserComponent());
        }
    }

    public class k implements tb5.i<EnableData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TranslatePlugin f218353a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public k(TranslatePlugin r100) {
            this.f218353a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r101) {
            EnableData r102 = (EnableData) r100;
            if (r102 != null) goto L5;
        L7:
            boolean r103 = false;
        L8:
            TranslatePlugin.access$2400(this.f218353a).getWebView().setNestedScrollingEnabled(r103);
            return;
        L5:
            if (r102.enable == false) goto L7;
            r103 = true;
            goto L8
        }
    }

    public class l implements tb5.i<Translation> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TranslatePlugin f218354a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public l(TranslatePlugin r100) {
            this.f218354a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r101) {
            Translation r102 = (Translation) r100;
            TranslatePlugin r103 = this.f218354a;
            if (r102 != null) goto L5;
        L7:
            boolean r104 = false;
        L8:
            TranslatePlugin.access$2000(r103, r104);
            return;
        L5:
            if (r102.enableTranslate == false) goto L7;
            r104 = true;
            goto L8
        }
    }

    public class m implements tb5.i<VisibleData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TranslatePlugin f218355a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public m(TranslatePlugin r100) {
            this.f218355a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r101) {
            VisibleData r102 = (VisibleData) r100;
            int r103 = 0;
            if (r102 != null) goto L5;
        L7:
            boolean r104 = false;
        L9:
            if (TranslatePlugin.access$1900(this.f218355a) == null) goto L16;
            View r105 = TranslatePlugin.access$1900(this.f218355a);
            if (r104 == true) goto L14;
            r103 = 4;
        L14:
            r105.setVisibility(r103);
            return;
        L16:
            return;
        L5:
            if (r102.visible == false) goto L7;
            r104 = true;
            goto L9
        }
    }

    public class n implements tb5.i<Original> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TranslatePlugin f218356a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public n(TranslatePlugin r100) {
            this.f218356a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r101) {
            TranslateViewModel r102 = TranslatePlugin.access$2100(this.f218356a);
            r102.setActiveOriginal((Original) r100);
        }
    }

    public class o implements tb5.i<TranslateTargetData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TranslatePlugin f218357a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public o(TranslatePlugin r100) {
            this.f218357a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r101) {
            TranslateTargetData r102 = (TranslateTargetData) r100;
            if (TranslatePlugin.access$2300(this.f218357a) == null) goto L6;
            TranslatePlugin.access$2300(this.f218357a).setTranslateTargetData(r102);
            return;
        }
    }

    public static /* synthetic */ void c(TranslatePlugin r100, Original r101) {
        r100.lambda$registerObservers$0(r101);
    }

    public static /* synthetic */ void d(TranslatePlugin r100, Boolean r101) {
        r100.lambda$registerObservers$1(r101);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    @Override // com.ss.android.lark.biz.im.api.m0
    public void onPushDisableAutoTranslateLanguages(List<String> r100) {
    }

    @Override // com.ss.android.lark.biz.im.api.m0
    public void onPushSpecificAutoTranslateScopeChanged(Map<String, Integer> r100) {
    }

    @Override // com.ss.android.lark.biz.im.api.m0
    public void onPushSpecificDisplayChanged(Map<String, Integer> r100) {
    }

    @Override // com.ss.android.lark.biz.im.api.m0
    public void onPushTranslateDisplayRules(TranslateLanguageSetting r100) {
    }

    private void dismissLanguageSwitcher() {
        IEventPlugin r100 = (IEventPlugin) findPlugin(IEventPlugin.class);
        if (r100 == null) goto L5;
        r100.removeDeleteListener(this.mOnDeleteListener);
    L5:
        View r101 = this.languageViewGroup;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.getVisibility() != 0) goto L18;
        Animation r102 = this.dismissAnimation;
        if (r102 != null) goto L13;
    L14:
        Animation r103 = AnimationUtils.loadAnimation(getContext(), R.anim.translate_top_to_bottom);
        this.dismissAnimation = r103;
        r103.setAnimationListener(new h(this));
        this.languageViewGroup.startAnimation(this.dismissAnimation);
        return;
    L13:
        if (r102.hasEnded() == true) goto L14;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.bytedance.ee.bear.browser.plugin.PluginHost, java.lang.Object] */
    private void ensureChooseLanguageFragment() {
        if (this.mChooseLanguageFragment != null) goto L6;
        ChooseLanguageFragment r100 = (ChooseLanguageFragment) Fragment.instantiate(getActivity(), ChooseLanguageFragment.class.getName());
        this.mChooseLanguageFragment = r100;
        ?? r101 = getHost();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "pluginHost");
        r100.f218331p = r101;
    L6:
        if (ForsetiHelper.s(((DocumentPluginHost) getHost()).c()) == true) goto L8;
    L9:
        INVOKEVIRTUAL_com_bytedance_ee_bear_doc_translate_TranslatePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(this.mChooseLanguageFragment, getActivity().getSupportFragmentManager(), ChooseLanguageFragment.class.getName());
        return;
    L8:
        if (com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.c(this.mChooseLanguageFragment, ((DocumentPluginHost) getHost()).c()) == false) goto L9;
    }

    private void ensureLanguageSwitcherView() {
        if (this.languageViewGroup != null) goto L16;
        com.bytedance.ee.bear.browser.plugin.t r100 = getUIContainer();
        View r101 = r100.b(this, R.layout.docs_translate_language_switch);
        this.languageViewGroup = r101;
        com.bytedance.ee.util.ui.l.b(r101, R.color.bg_body);
        this.switchLangugeView = r100.findView(R.id.doc_translate_switch);
        this.originalLanguageView = (TextView) r100.findView(R.id.originalLanguage);
        this.translateLanguageView = (TextView) r100.findView(R.id.translateLanguage);
        this.translateChooseIcon = (ImageView) r100.findView(R.id.doc_translate_choose_icon);
        this.translateSwitchIcon = (ImageView) r100.findView(R.id.doc_translate_switch_icon);
        ImageView r102 = this.translateChooseIcon;
        if (r102 == null) goto L7;
        com.bytedance.ee.util.ui.l.c(r102, R.color.icon_n1);
    L8:
        ImageView r103 = this.translateSwitchIcon;
        if (r103 == null) goto L11;
        com.bytedance.ee.util.ui.l.c(r103, R.color.icon_n1);
    L12:
        IEventPlugin r104 = (IEventPlugin) findPlugin(IEventPlugin.class);
        if (r104 == null) goto L17;
        r104.addDeleteListener(this.mOnDeleteListener);
        return;
    L17:
        return;
    L11:
        tt5.a.d(TAG, "translateSwitchIcon updateImageTint error: null");
        goto L12
    L7:
        tt5.a.d(TAG, "translateChooseIcon updateImageTint error: null");
        goto L8
    }

    private void fetchLanguageSetting() {
        ((com.bytedance.ee.bear.lark.dependency.t) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.t.class)).getTranslateLanguages(new AnonymousClass9(this));
    }

    private boolean hasShowOriginalMenu() {
        List<MenuItem> r100 = this.languageSwitchHandler.f565636c;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return false;
    L7:
        if (MENU_ID_SWITCH_TO_ORIGINAL.equals(((MenuItem) ListProtector.get(r100, 0)).getId()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private void hideLanguageSwitcherIfNeed() {
        View r100 = this.languageViewGroup;
        if (r100 != null) goto L5;
        return;
    L5:
        this.restoredLanguageSwitchVisible = r100.getVisibility();
        if (this.languageViewGroup.getVisibility() == 0) goto L8;
        return;
    L8:
        this.languageViewGroup.setVisibility(4);
    }

    private void registerObservers() {
        this.translateViewModel.getActiveOriginal().observe(getLifecycleOwner(), new com.bytedance.ee.bear.doc.translate.j(this));
        this.translateViewModel.getShowingChooseLanguagePanel().observe(getLifecycleOwner(), new d(this));
        this.translateViewModel.getShowingActiveOriginalPanel().observe(getLifecycleOwner(), new com.bytedance.ee.bear.doc.translate.k(this));
    }

    private void showLanguageSwitcherIfNeed() {
        View r100 = this.languageViewGroup;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.setVisibility(this.restoredLanguageSwitchVisible);
    }

    public TranslateLanguageSetting getTranslateLanguageSetting() {
        if (this.translateLanguageSetting != null) goto L6;
        this.translateLanguageSetting = (TranslateLanguageSetting) LarkKVStorage.p(new com.ss.android.lark.storage.a(ChameleonResConstants.CCM_ROOT_DIR), "translate", true).getJSONObject("config", TranslateLanguageSetting.class);
    L6:
        return this.translateLanguageSetting;
    }

    public TranslatePlugin() {
        this.translateLanguageSetting = null;
        this.restoredLanguageSwitchVisible = 0;
        this.mOnDeleteListener = new a(this);
        this.onTouchListener = new b(this);
    }

    private void showLanguageSwitcher() {
        if (hasShowOriginalMenu() == true) goto L5;
        return;
    L5:
        ensureLanguageSwitcherView();
        List<MenuItem> r100 = this.languageSwitchHandler.f565636c;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.isEmpty() == true) goto L25;
        MenuItem r101 = (MenuItem) ListProtector.get(r100, 0);
        T r102 = this.languageSwitchHandler.f565638e;
        if ((r102 instanceof TranslateMenuData) == true) goto L14;
        tt5.a.d(TAG, "showLanguageSwitcher()... is not translate");
        return;
    L14:
        setTranslateSwitchText((TranslateMenuData) r102);
        this.languageViewGroup.setOnClickListener(null);
        this.originalLanguageView.setOnClickListener(new e(this, r101));
        this.switchLangugeView.setOnClickListener(new f(this));
        if (this.languageViewGroup.getVisibility() == 0) goto L23;
        this.languageViewGroup.setVisibility(0);
        Animation r103 = this.showAnimation;
        if (r103 != null) goto L19;
    L20:
        Animation r104 = AnimationUtils.loadAnimation(getContext(), R.anim.translate_to_top_in);
        this.showAnimation = r104;
        r104.setAnimationListener(new g(this));
        this.languageViewGroup.startAnimation(this.showAnimation);
        return;
    L19:
        if (r103.hasEnded() == true) goto L20;
        return;
    L23:
        return;
    }

    public void translate() {
        getWeb().j(JS_TRANSLATE, new JSONObject());
    }

    public View getLanguageViewGroup() {
        return this.languageViewGroup;
    }

    public boolean isEnableTranslate() {
        return this.enableTranslate;
    }

    public static /* synthetic */ void access$000(TranslatePlugin r100) {
        r100.dismissLanguageSwitcher();
    }

    public static /* synthetic */ GestureDetector access$100(TranslatePlugin r100) {
        return r100.gestureDetector;
    }

    public static /* synthetic */ vv4.k access$1000(TranslatePlugin r100) {
        return r100.getWeb();
    }

    public static /* synthetic */ void access$1100(TranslatePlugin r100) {
        r100.ensureChooseLanguageFragment();
    }

    public static /* synthetic */ void access$1200(TranslatePlugin r100) {
        r100.hideLanguageSwitcherIfNeed();
    }

    public static /* synthetic */ ChooseLanguageFragment access$1300(TranslatePlugin r100) {
        return r100.mChooseLanguageFragment;
    }

    public static /* synthetic */ void access$1400(TranslatePlugin r100) {
        r100.showLanguageSwitcherIfNeed();
    }

    public static /* synthetic */ j access$1500(TranslatePlugin r100) {
        return r100.languageSwitchHandler;
    }

    public static /* synthetic */ View access$1900(TranslatePlugin r100) {
        return r100.languageViewGroup;
    }

    public static /* synthetic */ TranslateViewModel access$2100(TranslatePlugin r100) {
        return r100.translateViewModel;
    }

    public static /* synthetic */ boolean access$2200(TranslatePlugin r100) {
        return r100.hasShowOriginalMenu();
    }

    public static /* synthetic */ DocViewModel access$2300(TranslatePlugin r100) {
        return r100.docViewModel;
    }

    public static /* synthetic */ vv4.k access$2400(TranslatePlugin r100) {
        return r100.getWeb();
    }

    public static /* synthetic */ vv4.k access$800(TranslatePlugin r100) {
        return r100.getWeb();
    }

    public static /* synthetic */ void access$900(TranslatePlugin r100) {
        r100.showLanguageSwitcher();
    }

    private void lambda$registerObservers$0(Original r100) {
        StringBuilder r101 = new StringBuilder("onAttachToUIContainer.observe()... original =");
        if (r100 != null) goto L5;
        String r102 = "";
    L6:
        r101.append(r102);
        tt5.a.h(TAG, r101.toString());
        if (r100 == null) goto L9;
        ensureLanguageSwitcherView();
        addOrReplaceFragment(OriginalLanguageFragment.class, null, s.a(R.anim.dialog_in_from_bottom, R.anim.dialog_out_to_bottom, 0, 0));
        return;
    L9:
        removeFragment();
        return;
    L5:
        r102 = r100.text;
        goto L6
    }

    private /* synthetic */ void lambda$registerObservers$1(Boolean r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.booleanValue() == false) goto L7;
        getTitleBar().hide(true);
    L8:
        notifyOriginalPanelHeight(this.translateViewModel.getActiveOriginalPanelHeight());
        return;
    L7:
        getTitleBar().show(true);
        goto L8
    }

    private void notifyOriginalPanelHeight(int r100) {
        int r101 = com.bytedance.ee.util.ui.n.E(r100);
        tt5.a.b(TAG, "notifyOriginalPanelHeight:" + r101);
        JSONObject r102 = new JSONObject();
        r102.put2("height", Integer.valueOf(r101));
        execJS(String.format(Locale.US, JS_SET_PANEL_HEIGHT, new Object[0]), r102);
    }

    private void pushTranslateSettingChangeToFront(TranslateLanguageSetting r100) {
        JSONObject r101 = new JSONObject();
        r101.put2("targetLanguage", r100.getTargetLanguageKey());
        r101.put2("enableAutoTranslate", Boolean.valueOf(r100.isDocAutoTranslate()));
        getWeb().j(TRANSLATE_SETTING_CHANGE, r101);
    }

    private void setTranslateSwitchText(TranslateMenuData r100) {
        if (this.translateLanguageView != null) goto L6;
        iu5.d.a(TAG, new Throwable("translateLanguageView == null"));
        return;
    L6:
        List<String> r101 = r100.getDisplay_languages();
        int r102 = r100.getDisplay_language_index();
        if (r101 == null) goto L12;
        if (r102 < 0) goto L12;
        if (r102 >= r101.size()) goto L12;
        this.translateLanguageView.setText((CharSequence) ListProtector.get(r100.getDisplay_languages(), r102));
        return;
    L12:
        iu5.d.a(TAG, new Throwable("Received wrong translateMenuData[displayLanguages:  " + r101 + ", displayLanguageIndex: " + r102 + "]"));
        this.translateLanguageView.setText(getContext().getString(R.string.Doc_Translate_ChangeLanguage));
    }

    private void updateTranslateMenu(boolean r100) {
        this.enableTranslate = r100;
        tt5.a.h(TAG, "Update translate enable:" + r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r100) {
        r100.put(SETUP_TRANSLATE, new l(this));
        r100.put(SHOW_ORIGINAL, new n(this));
        j r101 = new j(this, (DocumentPluginHost) getHost());
        this.languageSwitchHandler = r101;
        r100.put(SET_RIGHT_BOTTOM_MENU, r101);
        r100.put(SET_TRANSLATE_LANGUAGE_SWITCH_VISIBLE, new m(this));
        r100.put(SET_ENABLE_SCROLL, new k(this));
        r100.put(CHOOSE_LANGUAGE, new i(this));
        r100.put(TRANSLATE_TARGET_CHANGE, new o(this));
    }

    public void onAttachToHost(DocumentPluginHost r100) {
        super.onAttachToHost(r100);
        this.docViewModel = r100.a();
        fetchLanguageSetting();
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).addPushTranslateLanguageSettingListener(this);
        this.gestureDetector = new GestureDetector(getContext(), new c(this, getContext()));
        this.translateViewModel = (TranslateViewModel) viewModel(TranslateViewModel.class);
        registerObservers();
    }

    public void onDetachFromHost(DocumentPluginHost r100) {
        super.onDetachFromHost(r100);
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).removePushTranslateLanguageSettingListener(this);
    }

    @Override // com.ss.android.lark.biz.im.api.m0
    public void onPushGlobalAutoTranslateScope(int r100) {
        this.translateLanguageSetting.setGlobalAutoTranslateScope(r100);
        pushTranslateSettingChangeToFront(this.translateLanguageSetting);
    }

    @Override // com.ss.android.lark.biz.im.api.m0
    public void onPushTranslateLanguageSetting(TranslateLanguageSetting r100) {
        fetchLanguageSetting();
    }

    public void translateV2(String r100) {
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L8
        if (r100 != null) goto L6;
        r101.put2("target_key", "");     // Catch: Throwable -> L8
    L12:
    L10:
        getWeb().j(JS_TRANSLATE, r101);
        return;
    L6:
        r101.put2("target_key", r100);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        tt5.a.j(TAG, th);
        r101 = new JSONObject();
        goto L10
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DocumentPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((DocumentPluginHost) r100);
    }

    public static /* synthetic */ Animation access$1702(TranslatePlugin r100, Animation r101) {
        r100.showAnimation = r101;
        return r101;
    }

    public static /* synthetic */ Animation access$1802(TranslatePlugin r100, Animation r101) {
        r100.dismissAnimation = r101;
        return r101;
    }

    public static /* synthetic */ void access$2000(TranslatePlugin r100, boolean r101) {
        r100.updateTranslateMenu(r101);
    }

    public static /* synthetic */ TranslateLanguageSetting access$2502(TranslatePlugin r100, TranslateLanguageSetting r101) {
        r100.translateLanguageSetting = r101;
        return r101;
    }

    public static /* synthetic */ void access$2600(TranslatePlugin r100, TranslateLanguageSetting r101) {
        r100.pushTranslateSettingChangeToFront(r101);
    }

    public void onAttachToUIContainer(DocumentPluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        super.onAttachToUIContainer(r100, r101);
        getWeb().addOnTouchListener(this.onTouchListener);
    }

    public void onDetachFromUIContainer(DocumentPluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        super.onDetachFromUIContainer(r100, r101);
        getWeb().removeOnTouchListener(this.onTouchListener);
        View r102 = this.languageViewGroup;
        if (r102 == null) goto L5;
        r101.m(this, r102);
        this.languageViewGroup = null;
    L5:
        this.translateViewModel.setShowingChooseLanguageFragment(Boolean.FALSE);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        onAttachToUIContainer((DocumentPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_doc_translate_TranslatePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(ChooseLanguageFragment r100, FragmentManager r101, String r102) {
        if ((r100 instanceof Fragment) == false) goto L5;
        ChooseLanguageFragment r103 = r100;
    L6:
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, r102, r104);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r103, r104) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r100.show(r101, r102);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
