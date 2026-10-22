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
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.biz.im.api.m0;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.ApiUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final /* synthetic */ TranslatePlugin a;

        public a(TranslatePlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.event.IEventPlugin.a
        public final void a(String r1) {
            TranslatePlugin.access$000(this.a);
        }
    }

    public class b implements View.OnTouchListener {
        public final /* synthetic */ TranslatePlugin a;

        public b(TranslatePlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            TranslatePlugin.access$100(this.a).onTouchEvent(r2);
            return false;
        }
    }

    public class c extends com.bytedance.ee.bear.doc.translate.a {
        public final /* synthetic */ TranslatePlugin c;

        public c(TranslatePlugin r1, Context r2) {
            this.c = r1;
            super(r2);
        }
    }

    public class d extends DiffObserver<Boolean> {
        public final /* synthetic */ TranslatePlugin b;

        public d(TranslatePlugin r1) {
            this.b = r1;
        }

        public final void a(Object r2) {
            Boolean r0 = Boolean.TRUE;
            if (r0.equals((Boolean) r2) == false) goto L6;
            TranslatePlugin.access$1100(this.b);
            TranslatePlugin.access$1200(this.b);
            return;
        L6:
            if (TranslatePlugin.access$1300(this.b) != null) goto L16;
        L14:
            TranslatePlugin.access$1400(this.b);
            return;
        L16:
            TranslatePlugin.access$1300(this.b).dismissAllowingStateLoss();     // Catch: Exception -> L10
        L10:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L14;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L14
        }
    }

    public class e extends t {
        public final /* synthetic */ MenuItem c;
        public final /* synthetic */ TranslatePlugin d;

        public final void a(View r3) {
            TranslatePlugin.access$1500(this.d).c(this.c, r3);
        }

        public e(TranslatePlugin r1, MenuItem r2) {
            this.d = r1;
            this.c = r2;
        }
    }

    public class f extends t {
        public final /* synthetic */ TranslatePlugin c;

        public f(TranslatePlugin r1) {
            this.c = r1;
        }

        public final void a(View r8) {
            final j r9 = TranslatePlugin.access$1500(this.c);
            T r0 = r9.e;
            if (r0 != 0) goto L5;
            return;
        L5:
            if ((r0 instanceof TranslateMenuData) == false) goto L23;
            TranslateMenuData r1 = (TranslateMenuData) r0;
            List<String> r2 = r1.getLanguages();
            List<String> r3 = r1.getDisplay_languages();
            if (r2 == null) goto L20;
            if (r3 == null) goto L20;
            if (r2.isEmpty() == true) goto L20;
            if (r2.size() != r3.size()) goto L20;
            TranslatePlugin.access$2100(r9.i).setShowingChooseLanguageFragment(Boolean.TRUE);
            TranslatePlugin.access$2100(r9.i).setChooseLanguages(LanguageModel.buildLanguageModelList((String[]) r2.toArray(new String[0]), (String[]) r3.toArray(new String[0])));
            int r4 = r1.getDisplay_language_index();
            if (r4 >= 0) goto L16;
        L18:
            tt5.a.d(TranslatePlugin.TAG, "Displaying language index[ " + r4 + "] is invalid ! listSize=" + r3.size());
        L19:
            TranslatePlugin.access$2100(r9.i).setOnLanguageSelectListener(new com.bytedance.ee.bear.doc.translate.m(r9));
            return;
        L16:
            if (r4 >= r3.size()) goto L18;
            TranslatePlugin.access$2100(r9.i).setSelectedLanguage(LanguageModel.buildLanguageModel((String) ListProtector.get(r2, r4), (String) ListProtector.get(r3, r4)));
        L20:
            tt5.a.k(TranslatePlugin.TAG, "Failed to show ChooseTranslateLanguageFragment. TranslateData:" + r1);
            return;
        }
    }

    public class g extends com.bytedance.ee.bear.doc.translate.f {
        public final /* synthetic */ TranslatePlugin a;

        public g(TranslatePlugin r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            TranslatePlugin.access$1702(this.a, null);
        }
    }

    public class h extends com.bytedance.ee.bear.doc.translate.f {
        public final /* synthetic */ TranslatePlugin a;

        public h(TranslatePlugin r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            TranslatePlugin.access$1802(this.a, null);
            TranslatePlugin.access$1900(this.a).setVisibility(4);
        }
    }

    public class i implements tb5.i<ChooseLanguageData> {
        public tb5.m a;
        public final /* synthetic */ TranslatePlugin b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public i(TranslatePlugin r1) {
            this.b = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            ChooseLanguageData r5 = (ChooseLanguageData) r3;
            tt5.a.h(TranslatePlugin.TAG, "choose language:" + r5);
            this.a = r4;
            if (ChooseLanguageData.validate(r5) == false) goto L6;
            TranslatePlugin.access$2100(this.b).setShowingChooseLanguageFragment(Boolean.TRUE);
            TranslatePlugin.access$2100(this.b).setChooseLanguages(LanguageModel.buildLanguageModelList(r5.languages, r5.display_languages));
            TranslatePlugin.access$2100(this.b).setSelectedLanguage(null);
            TranslatePlugin.access$2100(this.b).setOnLanguageSelectListener(new com.bytedance.ee.bear.doc.translate.l(this));
            return;
        }
    }

    public class j extends y15.c<TranslateMenuData> {
        public final /* synthetic */ TranslatePlugin i;

        @Override // y15.c
        public final List<MenuItem> a(List<MenuItem> r4) {
            if (r4 == null) goto L11;
            Iterator<MenuItem> r0 = r4.iterator();
        L5:
            if (r0.hasNext() == false) goto L11;
            String r1 = r0.next().getId();
            if (TranslatePlugin.MENU_ID_SWITCH_TO_ORIGINAL.equals(r1) == true) goto L5;
            if (TranslatePlugin.MENU_ID_SWITCH_TO_TRANSLATE.equals(r1) == true) goto L5;
            r0.remove();
        L11:
            return r4;
        }

        @Override // y15.c
        public final void e(List<MenuItem> r1) {
            super.e(r1);
            if (TranslatePlugin.access$2200(this.i) == true) goto L5;
            TranslatePlugin.access$000(this.i);
            return;
        L5:
            TranslatePlugin.access$900(this.i);
        }

        public j(TranslatePlugin r2, DocumentPluginHost r3) {
            this.i = r2;
            super(r3.getContext(), r3.a(), r3.getUserComponent());
        }
    }

    public class k implements tb5.i<EnableData> {
        public final /* synthetic */ TranslatePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public k(TranslatePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            EnableData r3 = (EnableData) r1;
            if (r3 != null) goto L5;
        L7:
            boolean r4 = false;
        L8:
            TranslatePlugin.access$2400(this.a).getWebView().setNestedScrollingEnabled(r4);
            return;
        L5:
            if (r3.enable == false) goto L7;
            r4 = true;
            goto L8
        }
    }

    public class l implements tb5.i<Translation> {
        public final /* synthetic */ TranslatePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public l(TranslatePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            Translation r3 = (Translation) r1;
            TranslatePlugin r4 = this.a;
            if (r3 != null) goto L5;
        L7:
            boolean r5 = false;
        L8:
            TranslatePlugin.access$2000(r4, r5);
            return;
        L5:
            if (r3.enableTranslate == false) goto L7;
            r5 = true;
            goto L8
        }
    }

    public class m implements tb5.i<VisibleData> {
        public final /* synthetic */ TranslatePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public m(TranslatePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            VisibleData r4 = (VisibleData) r2;
            int r5 = 0;
            if (r4 != null) goto L5;
        L7:
            boolean r6 = false;
        L9:
            if (TranslatePlugin.access$1900(this.a) == null) goto L16;
            View r0 = TranslatePlugin.access$1900(this.a);
            if (r6 == true) goto L14;
            r5 = 4;
        L14:
            r0.setVisibility(r5);
            return;
        L16:
            return;
        L5:
            if (r4.visible == false) goto L7;
            r6 = true;
            goto L9
        }
    }

    public class n implements tb5.i<Original> {
        public final /* synthetic */ TranslatePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public n(TranslatePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            TranslateViewModel r3 = TranslatePlugin.access$2100(this.a);
            r3.setActiveOriginal((Original) r1);
        }
    }

    public class o implements tb5.i<TranslateTargetData> {
        public final /* synthetic */ TranslatePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public o(TranslatePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            TranslateTargetData r3 = (TranslateTargetData) r1;
            if (TranslatePlugin.access$2300(this.a) == null) goto L6;
            TranslatePlugin.access$2300(this.a).setTranslateTargetData(r3);
            return;
        }
    }

    public static /* synthetic */ void c(TranslatePlugin r0, Original r1) {
        r0.lambda$registerObservers$0(r1);
    }

    public static /* synthetic */ void d(TranslatePlugin r0, Boolean r1) {
        r0.lambda$registerObservers$1(r1);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public void onPushDisableAutoTranslateLanguages(List<String> r1) {
    }

    public void onPushSpecificAutoTranslateScopeChanged(Map<String, Integer> r1) {
    }

    public void onPushSpecificDisplayChanged(Map<String, Integer> r1) {
    }

    public void onPushTranslateDisplayRules(TranslateLanguageSetting r1) {
    }

    private void dismissLanguageSwitcher() {
        IEventPlugin r0 = (IEventPlugin) findPlugin(IEventPlugin.class);
        if (r0 == null) goto L5;
        r0.removeDeleteListener(this.mOnDeleteListener);
    L5:
        View r1 = this.languageViewGroup;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.getVisibility() != 0) goto L18;
        Animation r2 = this.dismissAnimation;
        if (r2 != null) goto L13;
    L14:
        Animation r3 = AnimationUtils.loadAnimation(getContext(), 2130772669);
        this.dismissAnimation = r3;
        r3.setAnimationListener(new h(this));
        this.languageViewGroup.startAnimation(this.dismissAnimation);
        return;
    L13:
        if (r2.hasEnded() == true) goto L14;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.bytedance.ee.bear.browser.plugin.PluginHost, java.lang.Object] */
    private void ensureChooseLanguageFragment() {
        if (this.mChooseLanguageFragment != null) goto L6;
        ChooseLanguageFragment r0 = Fragment.instantiate(getActivity(), ChooseLanguageFragment.class.getName());
        this.mChooseLanguageFragment = r0;
        ?? r1 = getHost();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "pluginHost");
        r0.p = r1;
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
        com.bytedance.ee.bear.browser.plugin.t r0 = getUIContainer();
        View r1 = r0.b(this, 2131560116);
        this.languageViewGroup = r1;
        com.bytedance.ee.util.ui.l.b(r1, 2131100548);
        this.switchLangugeView = r0.findView(2131369377);
        this.originalLanguageView = (TextView) r0.findView(2131381681);
        this.translateLanguageView = (TextView) r0.findView(2131389334);
        this.translateChooseIcon = (ImageView) r0.findView(2131369376);
        this.translateSwitchIcon = (ImageView) r0.findView(2131369378);
        ImageView r2 = this.translateChooseIcon;
        if (r2 == null) goto L7;
        com.bytedance.ee.util.ui.l.c(r2, 2131102418);
    L8:
        ImageView r3 = this.translateSwitchIcon;
        if (r3 == null) goto L11;
        com.bytedance.ee.util.ui.l.c(r3, 2131102418);
    L12:
        IEventPlugin r4 = (IEventPlugin) findPlugin(IEventPlugin.class);
        if (r4 == null) goto L17;
        r4.addDeleteListener(this.mOnDeleteListener);
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
        List<MenuItem> r0 = this.languageSwitchHandler.c;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    L7:
        if (MENU_ID_SWITCH_TO_ORIGINAL.equals(((MenuItem) ListProtector.get(r0, 0)).getId()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private void hideLanguageSwitcherIfNeed() {
        View r0 = this.languageViewGroup;
        if (r0 != null) goto L5;
        return;
    L5:
        this.restoredLanguageSwitchVisible = r0.getVisibility();
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
        View r0 = this.languageViewGroup;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setVisibility(this.restoredLanguageSwitchVisible);
    }

    public TranslateLanguageSetting getTranslateLanguageSetting() {
        if (this.translateLanguageSetting != null) goto L6;
        this.translateLanguageSetting = (TranslateLanguageSetting) LarkKVStorage.p(new com.ss.android.lark.storage.a("ccm"), "translate", true).getJSONObject("config", TranslateLanguageSetting.class);
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
        List<MenuItem> r0 = this.languageSwitchHandler.c;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isEmpty() == true) goto L25;
        MenuItem r1 = (MenuItem) ListProtector.get(r0, 0);
        T r2 = this.languageSwitchHandler.e;
        if ((r2 instanceof TranslateMenuData) == true) goto L14;
        tt5.a.d(TAG, "showLanguageSwitcher()... is not translate");
        return;
    L14:
        setTranslateSwitchText((TranslateMenuData) r2);
        this.languageViewGroup.setOnClickListener(null);
        this.originalLanguageView.setOnClickListener(new e(this, r1));
        this.switchLangugeView.setOnClickListener(new f(this));
        if (this.languageViewGroup.getVisibility() == 0) goto L23;
        this.languageViewGroup.setVisibility(0);
        Animation r3 = this.showAnimation;
        if (r3 != null) goto L19;
    L20:
        Animation r4 = AnimationUtils.loadAnimation(getContext(), 2130772668);
        this.showAnimation = r4;
        r4.setAnimationListener(new g(this));
        this.languageViewGroup.startAnimation(this.showAnimation);
        return;
    L19:
        if (r3.hasEnded() == true) goto L20;
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

    public static /* synthetic */ void access$000(TranslatePlugin r0) {
        r0.dismissLanguageSwitcher();
    }

    public static /* synthetic */ GestureDetector access$100(TranslatePlugin r0) {
        return r0.gestureDetector;
    }

    public static /* synthetic */ vv4.k access$1000(TranslatePlugin r0) {
        return r0.getWeb();
    }

    public static /* synthetic */ void access$1100(TranslatePlugin r0) {
        r0.ensureChooseLanguageFragment();
    }

    public static /* synthetic */ void access$1200(TranslatePlugin r0) {
        r0.hideLanguageSwitcherIfNeed();
    }

    public static /* synthetic */ ChooseLanguageFragment access$1300(TranslatePlugin r0) {
        return r0.mChooseLanguageFragment;
    }

    public static /* synthetic */ void access$1400(TranslatePlugin r0) {
        r0.showLanguageSwitcherIfNeed();
    }

    public static /* synthetic */ j access$1500(TranslatePlugin r0) {
        return r0.languageSwitchHandler;
    }

    public static /* synthetic */ View access$1900(TranslatePlugin r0) {
        return r0.languageViewGroup;
    }

    public static /* synthetic */ TranslateViewModel access$2100(TranslatePlugin r0) {
        return r0.translateViewModel;
    }

    public static /* synthetic */ boolean access$2200(TranslatePlugin r0) {
        return r0.hasShowOriginalMenu();
    }

    public static /* synthetic */ DocViewModel access$2300(TranslatePlugin r0) {
        return r0.docViewModel;
    }

    public static /* synthetic */ vv4.k access$2400(TranslatePlugin r0) {
        return r0.getWeb();
    }

    public static /* synthetic */ vv4.k access$800(TranslatePlugin r0) {
        return r0.getWeb();
    }

    public static /* synthetic */ void access$900(TranslatePlugin r0) {
        r0.showLanguageSwitcher();
    }

    private void lambda$registerObservers$0(Original r4) {
        StringBuilder r0 = new StringBuilder("onAttachToUIContainer.observe()... original =");
        if (r4 != null) goto L5;
        String r1 = "";
    L6:
        r0.append(r1);
        tt5.a.h(TAG, r0.toString());
        if (r4 == null) goto L9;
        ensureLanguageSwitcherView();
        addOrReplaceFragment(OriginalLanguageFragment.class, null, s.a(2130772201, 2130772203, 0, 0));
        return;
    L9:
        removeFragment();
        return;
    L5:
        r1 = r4.text;
        goto L6
    }

    private /* synthetic */ void lambda$registerObservers$1(Boolean r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.booleanValue() == false) goto L7;
        getTitleBar().hide(true);
    L8:
        notifyOriginalPanelHeight(this.translateViewModel.getActiveOriginalPanelHeight());
        return;
    L7:
        getTitleBar().show(true);
        goto L8
    }

    private void notifyOriginalPanelHeight(int r4) {
        int r5 = com.bytedance.ee.util.ui.n.E(r4);
        tt5.a.b(TAG, "notifyOriginalPanelHeight:" + r5);
        JSONObject r0 = new JSONObject();
        r0.put("height", Integer.valueOf(r5));
        execJS(String.format(Locale.US, JS_SET_PANEL_HEIGHT, new Object[0]), r0);
    }

    private void pushTranslateSettingChangeToFront(TranslateLanguageSetting r4) {
        JSONObject r0 = new JSONObject();
        r0.put("targetLanguage", r4.getTargetLanguageKey());
        r0.put("enableAutoTranslate", Boolean.valueOf(r4.isDocAutoTranslate()));
        getWeb().j(TRANSLATE_SETTING_CHANGE, r0);
    }

    private void setTranslateSwitchText(TranslateMenuData r6) {
        if (this.translateLanguageView != null) goto L6;
        iu5.d.a(TAG, new Throwable("translateLanguageView == null"));
        return;
    L6:
        List<String> r0 = r6.getDisplay_languages();
        int r2 = r6.getDisplay_language_index();
        if (r0 == null) goto L12;
        if (r2 < 0) goto L12;
        if (r2 >= r0.size()) goto L12;
        this.translateLanguageView.setText((CharSequence) ListProtector.get(r6.getDisplay_languages(), r2));
        return;
    L12:
        iu5.d.a(TAG, new Throwable("Received wrong translateMenuData[displayLanguages:  " + r0 + ", displayLanguageIndex: " + r2 + "]"));
        this.translateLanguageView.setText(getContext().getString(2131888273));
    }

    private void updateTranslateMenu(boolean r3) {
        this.enableTranslate = r3;
        tt5.a.h(TAG, "Update translate enable:" + r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put(SETUP_TRANSLATE, new l(this));
        r3.put(SHOW_ORIGINAL, new n(this));
        j r0 = new j(this, (DocumentPluginHost) getHost());
        this.languageSwitchHandler = r0;
        r3.put(SET_RIGHT_BOTTOM_MENU, r0);
        r3.put(SET_TRANSLATE_LANGUAGE_SWITCH_VISIBLE, new m(this));
        r3.put(SET_ENABLE_SCROLL, new k(this));
        r3.put(CHOOSE_LANGUAGE, new i(this));
        r3.put(TRANSLATE_TARGET_CHANGE, new o(this));
    }

    public void onAttachToHost(DocumentPluginHost r4) {
        super.onAttachToHost(r4);
        this.docViewModel = r4.a();
        fetchLanguageSetting();
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).addPushTranslateLanguageSettingListener(this);
        this.gestureDetector = new GestureDetector(getContext(), new c(this, getContext()));
        this.translateViewModel = (TranslateViewModel) viewModel(TranslateViewModel.class);
        registerObservers();
    }

    public void onDetachFromHost(DocumentPluginHost r1) {
        super.onDetachFromHost(r1);
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).removePushTranslateLanguageSettingListener(this);
    }

    public void onPushGlobalAutoTranslateScope(int r2) {
        this.translateLanguageSetting.setGlobalAutoTranslateScope(r2);
        pushTranslateSettingChangeToFront(this.translateLanguageSetting);
    }

    public void onPushTranslateLanguageSetting(TranslateLanguageSetting r1) {
        fetchLanguageSetting();
    }

    public void translateV2(String r3) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L8
        if (r3 != null) goto L6;
        r0.put("target_key", "");     // Catch: Throwable -> L8
    L12:
    L10:
        getWeb().j(JS_TRANSLATE, r0);
        return;
    L6:
        r0.put("target_key", r3);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        tt5.a.j(TAG, th);
        r0 = new JSONObject();
        goto L10
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static /* synthetic */ Animation access$1702(TranslatePlugin r0, Animation r1) {
        r0.showAnimation = r1;
        return r1;
    }

    public static /* synthetic */ Animation access$1802(TranslatePlugin r0, Animation r1) {
        r0.dismissAnimation = r1;
        return r1;
    }

    public static /* synthetic */ void access$2000(TranslatePlugin r0, boolean r1) {
        r0.updateTranslateMenu(r1);
    }

    public static /* synthetic */ TranslateLanguageSetting access$2502(TranslatePlugin r0, TranslateLanguageSetting r1) {
        r0.translateLanguageSetting = r1;
        return r1;
    }

    public static /* synthetic */ void access$2600(TranslatePlugin r0, TranslateLanguageSetting r1) {
        r0.pushTranslateSettingChangeToFront(r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onAttachToUIContainer(r1, r2);
        getWeb().addOnTouchListener(this.onTouchListener);
    }

    public void onDetachFromUIContainer(DocumentPluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        super.onDetachFromUIContainer(r2, r3);
        getWeb().removeOnTouchListener(this.onTouchListener);
        View r4 = this.languageViewGroup;
        if (r4 == null) goto L5;
        r3.m(this, r4);
        this.languageViewGroup = null;
    L5:
        this.translateViewModel.setShowingChooseLanguageFragment(Boolean.FALSE);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_doc_translate_TranslatePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(ChooseLanguageFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        ChooseLanguageFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
