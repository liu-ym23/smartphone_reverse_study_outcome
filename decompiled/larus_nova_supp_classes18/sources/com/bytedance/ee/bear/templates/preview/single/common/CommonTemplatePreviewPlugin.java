package com.bytedance.ee.bear.templates.preview.single.common;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.templatePlugin.BaseTemplatePreviewPlugin;
import com.bytedance.ee.bear.templates.TemplateUtils;
import com.bytedance.ee.bear.templates.bean.SelectTemplateConfig;
import com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback;
import com.bytedance.ee.bear.templates.preview.data.CommonPreviewTemplateData;
import com.bytedance.ee.bear.templates.preview.data.Item;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.l;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J!\u0010\u001c\u001a\u00020\u000e2\u0012\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u001e\"\u00020\u001fH\u0002¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u000eH\u0002J\u001c\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u00192\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u0010&\u001a\u00020\u000eH\u0002J\b\u0010'\u001a\u00020\u000eH\u0002J\n\u0010(\u001a\u0004\u0018\u00010)H\u0002J\b\u0010*\u001a\u00020\u001bH\u0016J\b\u0010+\u001a\u00020\u000eH\u0016J\b\u0010,\u001a\u00020\u000eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/single/common/CommonTemplatePreviewPlugin;", "Lcom/bytedance/ee/bear/document/templatePlugin/BaseTemplatePreviewPlugin;", "<init>", "()V", "commonTemplateViewModel", "Lcom/bytedance/ee/bear/templates/preview/single/common/CommonTemplateViewModel;", ResourceData.KEY_TYPE, "", "customCallBack", "Lcom/bytedance/ee/bear/templates/dto/BinderISelectTemplateCallback$Stub;", "customConfig", "Lcom/bytedance/ee/bear/templates/bean/SelectTemplateConfig;", "templateId", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "initTitleMenu", "initTitle", "setCustomMoreMenu", "setShareMenu", "shareSource", "", "isBitableAppPreview", "", "showRightMenu", "items", "", "Lcom/bytedance/ee/bear/browser/plugin/MenuItem;", "([Lcom/bytedance/ee/bear/browser/plugin/MenuItem;)V", "ensurePreviewFragment", "goBackWithResult", "resultCode", "result", "Landroid/os/Bundle;", "goBack", "onPreviewFinish", "getTemplateView", "Landroid/view/ViewGroup;", "onBackPressed", "hideTemplatePreview", "showTemplatePreview", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonTemplatePreviewPlugin extends BaseTemplatePreviewPlugin {
    public static final int CODE_FINISH_TEMPLATE = 100;
    public static final a Companion = null;
    public static final String MENU_ID_PREVIEW_MORE_ACTION = "PREVIEW_MORE_ACTION";
    public static final String MENU_ID_PREVIEW_SHARE_ACTION = "PREVIEW_SHARE_ACTION";
    public static final String TAG = "CommonTemplatePreviewPlugin";
    private CommonTemplateViewModel commonTemplateViewModel;
    private BinderISelectTemplateCallback.Stub customCallBack;
    private SelectTemplateConfig customConfig;
    private String templateId;
    private String type;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ CommonTemplatePreviewPlugin a;

        public b(CommonTemplatePreviewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.FALSE) == false) goto L6;
            CommonTemplatePreviewPlugin.access$onPreviewFinish(this.a);
            return;
        }
    }

    public static final class c implements MenuItem.b {
        public final /* synthetic */ CommonTemplatePreviewPlugin a;
        public final /* synthetic */ int b;

        public c(CommonTemplatePreviewPlugin r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(MenuItem r10, View r11) {
            CommonTemplateViewModel r12 = CommonTemplatePreviewPlugin.access$getCommonTemplateViewModel$p(this.a);
            if (r12 == null) goto L16;
            int r5 = this.b;
            CommonTemplatePreviewPlugin r13 = this.a;
            Item r7 = r12.getCurrTemplate();
            if (r7 == null) goto L17;
            com.bytedance.ee.bear.templates.c r8 = new com.bytedance.ee.bear.templates.c(r7.getObjType(), r7.getObjToken(), r7.getName(), false, r5, 40);
            TemplateUtils r0 = TemplateUtils.a;
            Context r1 = CommonTemplatePreviewPlugin.access$getContext(r13);
            DocViewModel r14 = CommonTemplatePreviewPlugin.access$getDocViewModel(r13);
            if (r14 == null) goto L13;
            DocumentInfo r15 = r14.getDocumentInfoData();
            if (r15 == null) goto L13;
            DocMetaInfo r16 = r15.getDocMetaInfo();
            if (r16 == null) goto L13;
            String r17 = r16.getUrl();
        L14:
            r0.getClass();
            TemplateUtils.p(r1, r8, r17);
            Lazy r18 = CommonTemplatePreviewAnalytic.a;
            CommonTemplatePreviewAnalytic.g(r7, r12.getCommonPreviewTemplateData());
            return;
        L13:
            r17 = null;
            goto L14
        L17:
            return;
        }
    }

    static {
        Companion = new a();
    }

    public CommonTemplatePreviewPlugin() {
        super(false, 1, null);
        this.templateId = "";
    }

    private final void onPreviewFinish() {
        goBackWithResult$default(this, 100, null, 2, null);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void goBack() {
        tt5.a.h(TAG, "goBack");
        if (ForsetiHelper.t(getActivity()) == false) goto L9;
        Fragment r0 = getHost().getHostFragment();
        if (r0 == null) goto L11;
        g r1 = f.b(r0);
        if (r1 == null) goto L12;
        r1.g(null);
        return;
    L12:
        return;
    L11:
        return;
    L9:
        getActivity().setResult(0);
        getActivity().finish();
    }

    private final void initTitle() {
        CommonTemplateViewModel r0 = this.commonTemplateViewModel;
        if (r0 == null) goto L8;
        Item r1 = r0.getCurrTemplate();
        if (r1 == null) goto L9;
        getTitleBar().setTitle(r1.getName());
        getTitleBar().d();
        return;
    L9:
        return;
    }

    private final void initTitleMenu() {
        if (Intrinsics.areEqual(this.type, "custom") == false) goto L9;
        if (isBitableAppPreview() == false) goto L7;
        setShareMenu(4);
        return;
    L7:
        setCustomMoreMenu();
        return;
    L9:
        if (Intrinsics.areEqual(this.type, "system") == false) goto L32;
        CommonTemplateViewModel r0 = this.commonTemplateViewModel;
        if (r0 == null) goto L33;
        Item r1 = r0.getCurrTemplate();
        if (r1 != null) goto L15;
        return;
    L15:
        if (r1.isCategorySdkTemplate() == false) goto L20;
        TitleBar r2 = getTitleBar();
        if (r2 == null) goto L35;
        r2.setRightVisible(false);
        return;
    L35:
        return;
    L20:
        if (r1.isSystemTemplate() == false) goto L23;
        setShareMenu(3);
        return;
    L23:
        if (r1.isCustomTemplate() == true) goto L25;
        tt5.a.d(TAG, "initTitleMenu unexpected...");
        return;
    L25:
        if (isBitableAppPreview() == false) goto L27;
        setShareMenu(4);
        return;
    L27:
        setCustomMoreMenu();
        return;
    L33:
        return;
    }

    private final boolean isBitableAppPreview() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Boolean.valueOf(((bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6)).a(getHost())));     // Catch: Throwable -> L4
    L6:
        Boolean r2 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = r2;
    L10:
        return ((Boolean) r1).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public boolean onBackPressed() {
        CommonTemplateViewModel r0 = this.commonTemplateViewModel;
        if (r0 == null) goto L5;
        r0.onBackPressed();
    L5:
        goBack();
        BinderISelectTemplateCallback.Stub r1 = this.customCallBack;
        if (r1 == null) goto L8;
        r1.onCancel(true);
    L8:
        Lazy r2 = CommonTemplatePreviewAnalytic.a;
        CommonTemplateViewModel r3 = this.commonTemplateViewModel;
        if (r3 == null) goto L11;
        CommonPreviewTemplateData r4 = r3.getCommonPreviewTemplateData();
    L12:
        CommonTemplatePreviewAnalytic.d(r4);
        return true;
    L11:
        r4 = null;
        goto L12
    }

    private final void ensurePreviewFragment() {
        ViewGroup r0 = (ViewGroup) getHost().getActivity().getWindow().findViewById(R.id.content);
        ViewGroup r1 = getTemplateView();
        CommonTemplateViewModel r2 = this.commonTemplateViewModel;
        CommonPreviewTemplateData r3 = null;
        if (r2 == null) goto L5;
        CommonPreviewTemplateView r4 = r2.getCommonPreviewTemplateView();
    L6:
        View r5 = r0.findViewById(2131391146);
        if (r5 == null) goto L9;
        r5.setVisibility(0);
    L9:
        if (r4 != null) goto L19;
        r4 = new CommonPreviewTemplateView();
        CommonTemplateViewModel r6 = this.commonTemplateViewModel;
        if (r6 == null) goto L13;
        r6.setCommonPreviewTemplateView(r4);
    L13:
        CommonTemplateViewModel r7 = this.commonTemplateViewModel;
        if (r7 == null) goto L16;
        r7.initTemplates(getDocViewModel().getPreviewListStr(), getDocViewModel().getToken(), getDocViewModel().getDocumentTypeValue(), getDocViewModel().getDocTitle(), this.templateId);
    L16:
        CommonTemplateViewModel r8 = this.commonTemplateViewModel;
        if (r8 == null) goto L19;
        r8.setType(this.type);
    L19:
        if (r1 != null) goto L28;
        View r9 = getUIContainer().getContentView();
        if ((r9 instanceof ViewGroup) == false) goto L23;
        ViewGroup r10 = (ViewGroup) r9;
    L24:
        if (r10 == null) goto L27;
        r0 = r10;
    L27:
        FragmentActivity r11 = getActivity();
        Intrinsics.checkNotNull(r0);
        r4.b(r11, r0, this.commonTemplateViewModel);
    L29:
        CommonTemplateViewModel r12 = this.commonTemplateViewModel;
        if (r12 == null) goto L34;
        LiveData<Boolean> r13 = r12.getPreviewActive();
        if (r13 == null) goto L34;
        r13.observe(getLifecycleOwner(), new b(this));
    L34:
        CommonTemplateViewModel r14 = this.commonTemplateViewModel;
        if (r14 == null) goto L43;
        Item r15 = r14.getCurrTemplate();
        if (r15 == null) goto L44;
        Lazy r16 = CommonTemplatePreviewAnalytic.a;
        CommonTemplateViewModel r17 = this.commonTemplateViewModel;
        if (r17 == null) goto L41;
        r3 = r17.getCommonPreviewTemplateData();
    L41:
        CommonTemplatePreviewAnalytic.h(r3, r15);
        return;
    L44:
        return;
    L43:
        return;
    L23:
        r10 = null;
        goto L24
    L28:
        r1.setVisibility(0);
        goto L29
    L5:
        r4 = null;
        goto L6
    }

    private final ViewGroup getTemplateView() {
        return (ViewGroup) ((ViewGroup) getHost().getActivity().getWindow().findViewById(R.id.content)).findViewById(2131377465);
    }

    private final void setCustomMoreMenu() {
        MenuItem r2 = new MenuItem("PREVIEW_MORE_ACTION", l.a(getContext(), 2131255147, 2131101926), "");
        r2.setClickListener(new CommonTemplatePreviewPlugin$setCustomMoreMenu$1$1(this));
        Unit r0 = Unit.INSTANCE;
        showRightMenu(new MenuItem[]{r2});
    }

    public void hideTemplatePreview() {
        ViewGroup r0 = getTemplateView();
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    public void showTemplatePreview() {
        ViewGroup r0 = getTemplateView();
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        return;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_ee_bear_templates_preview_single_common_CommonTemplatePreviewPlugin_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static final /* synthetic */ CommonTemplateViewModel access$getCommonTemplateViewModel$p(CommonTemplatePreviewPlugin r0) {
        return r0.commonTemplateViewModel;
    }

    public static final /* synthetic */ Context access$getContext(CommonTemplatePreviewPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(CommonTemplatePreviewPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ void access$onPreviewFinish(CommonTemplatePreviewPlugin r0) {
        r0.onPreviewFinish();
    }

    private final void setShareMenu(int r6) {
        Drawable r0 = l.a(getContext(), 2131255656, 2131101926);
        if (isBitableAppPreview() == false) goto L5;
        r0 = new InsetDrawable(r0, (int) (INVOKEVIRTUAL_com_bytedance_ee_bear_templates_preview_single_common_CommonTemplatePreviewPlugin_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getContext().getResources()).density * 3));
    L5:
        MenuItem r2 = new MenuItem("PREVIEW_SHARE_ACTION", r0, "");
        r2.setClickListener(new c(this, r6));
        Unit r7 = Unit.INSTANCE;
        showRightMenu(new MenuItem[]{r2});
    }

    private final void showRightMenu(MenuItem... r3) {
        getTitleBar().setRightVisible(true);
        getTitleBar().getTitleBarLayout().g();
        getTitleBar().j(ArraysKt.asList(r3), TitleBar.MenuType.Right);
    }

    public void onAttachToHost(DocumentPluginHost r6) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r6);
        SelectTemplateConfig r1 = null;
        if (r6 != null) goto L39;
    L13:
        IBinder r2 = null;
    L15:
        if ((r2 instanceof BinderISelectTemplateCallback.Stub) == false) goto L19;
        this.customCallBack = (BinderISelectTemplateCallback.Stub) r2;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        tt5.a.f(TAG, th, false);
    L19:
        if (r6 == null) goto L27;
        FragmentActivity r3 = r6.getActivity();
        if (r3 == null) goto L27;
        Intent r4 = r3.getIntent();
        if (r4 == null) goto L27;
        Bundle r5 = r4.getExtras();
        if (r5 == null) goto L27;
        String r7 = r5.getString("key_template_select_template_id", "");
    L28:
        this.templateId = r7;
        if (r6 == null) goto L37;
        FragmentActivity r8 = r6.getActivity();
        if (r8 == null) goto L37;
        Intent r9 = r8.getIntent();
        if (r9 == null) goto L37;
        Bundle r10 = r9.getExtras();
        if (r10 == null) goto L37;
        r1 = (SelectTemplateConfig) r10.getParcelable("key_template_select_template_config");
    L37:
        this.customConfig = r1;
        tt5.a.h(TAG, "customCallBack=" + this.customCallBack);
        return;
    L27:
        r7 = null;
        goto L28
    L39:
        FragmentActivity r11 = r6.getActivity();     // Catch: Throwable -> L11
        if (r11 == null) goto L13;
        Intent r12 = r11.getIntent();     // Catch: Throwable -> L11
        if (r12 == null) goto L13;
        Bundle r13 = r12.getExtras();     // Catch: Throwable -> L11
        if (r13 == null) goto L13;
        r2 = r13.getBinder("key_template_select_callback");     // Catch: Throwable -> L11
        goto L15
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    private final void goBackWithResult(int r3, Bundle r4) {
        tt5.a.h(TAG, "goBackWithResult -> resultCode=" + r3);
        if (r4 != null) goto L5;
        Bundle r0 = new Bundle();
    L7:
        if (ForsetiHelper.t(getActivity()) == false) goto L14;
        Fragment r5 = getHost().getHostFragment();
        if (r5 == null) goto L20;
        g r6 = f.b(r5);
        if (r6 == null) goto L21;
        r6.c(r3, r0);
        return;
    L21:
        return;
    L20:
        return;
    L14:
        Intent r1 = new Intent().putExtras(r0);
        if (r4 != null) goto L17;
        getActivity().setResult(r3);
    L18:
        getActivity().finish();
        return;
    L17:
        getActivity().setResult(r3, r1);
        goto L18
    L5:
        r0 = r4;
        goto L7
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        this.type = getDocViewModel().getCommonTemplatePreviewType();
        CommonTemplateViewModel r3 = (CommonTemplateViewModel) new ViewModelProvider(getActivity()).get(CommonTemplateViewModel.class);
        this.commonTemplateViewModel = r3;
        if (r3 == null) goto L5;
        r3.setPreviewActive(Boolean.TRUE);
    L5:
        BinderISelectTemplateCallback.Stub r4 = this.customCallBack;
        if (r4 == null) goto L10;
        CommonTemplateViewModel r5 = this.commonTemplateViewModel;
        if (r5 == null) goto L10;
        r5.setCustomCallback(r4);
    L10:
        SelectTemplateConfig r6 = this.customConfig;
        if (r6 == null) goto L15;
        CommonTemplateViewModel r7 = this.commonTemplateViewModel;
        if (r7 == null) goto L15;
        r7.setCustomConfig(r6);
    L15:
        ensurePreviewFragment();
        initTitle();
        initTitleMenu();
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    public static final /* synthetic */ void access$goBackWithResult(CommonTemplatePreviewPlugin r0, int r1, Bundle r2) {
        r0.goBackWithResult(r1, r2);
    }

    public static /* synthetic */ void goBackWithResult$default(CommonTemplatePreviewPlugin r0, int r1, Bundle r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.goBackWithResult(r1, r2);
    }
}
