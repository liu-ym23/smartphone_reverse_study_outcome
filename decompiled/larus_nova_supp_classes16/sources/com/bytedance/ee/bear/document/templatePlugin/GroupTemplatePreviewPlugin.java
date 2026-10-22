package com.bytedance.ee.bear.document.templatePlugin;

import android.R;
import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import co5.h;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.templates.TemplateViewModel;
import com.bytedance.ee.util.ui.l;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.android.material.appbar.AppBarLayout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J!\u0010\u000e\u001a\u00020\t2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\"\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/document/templatePlugin/GroupTemplatePreviewPlugin;", "Lcom/bytedance/ee/bear/document/templatePlugin/BaseTemplatePreviewPlugin;", "<init>", "()V", "webViewClient", "Lcom/bytedance/ee/bear/document/templatePlugin/BaseTemplatePreviewPlugin$TemplateWebViewClient;", "getWebViewClient", "()Lcom/bytedance/ee/bear/document/templatePlugin/BaseTemplatePreviewPlugin$TemplateWebViewClient;", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "showRightMenu", "items", "", "Lcom/bytedance/ee/bear/browser/plugin/MenuItem;", "([Lcom/bytedance/ee/bear/browser/plugin/MenuItem;)V", "initTitleMenu", "onBackPressed", "", "hideTemplatePreview", "showTemplatePreview", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupTemplatePreviewPlugin extends BaseTemplatePreviewPlugin {
    public static final int CODE_FINISH_TEMPLATE = 100;
    public static final a Companion = null;
    public static final String MENU_ID_GROUP_PREVIEW_SHARE_ACTION = "GROUP_PREVIEW_SHARE_ACTION";
    public static final String TAG = "TemplatePlugin";
    private final BaseTemplatePreviewPlugin.a webViewClient;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements MenuItem.b {
        public final /* synthetic */ GroupTemplatePreviewPlugin a;

        public b(GroupTemplatePreviewPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
        public final void a(MenuItem r1, View r2) {
            com.bytedance.ee.bear.templates.dto.b r3 = ViewModelProviders.of(GroupTemplatePreviewPlugin.access$getActivity(this.a)).get(TemplateViewModel.class).getGroupPreviewCallBack();
            if (r3 == null) goto L6;
            r3.b();
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ GroupTemplatePreviewPlugin a;
        public final /* synthetic */ com.bytedance.ee.bear.templates.dto.b b;

        public c(GroupTemplatePreviewPlugin r1, com.bytedance.ee.bear.templates.dto.b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            GroupTemplatePreviewPlugin.access$getActivity(this.a).finish();
            com.bytedance.ee.bear.templates.dto.b r2 = this.b;
            if (r2 == null) goto L6;
            r2.a();
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ com.bytedance.ee.bear.templates.dto.b a;
        public final /* synthetic */ DocumentPluginHost b;

        public d(com.bytedance.ee.bear.templates.dto.b r1, DocumentPluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            Map r4 = (Map) r3;
            if (r4.containsKey("TEMPLATE_RESULT_KEY") == true) goto L5;
            return;
        L5:
            if (r4.get("TEMPLATE_RESULT_KEY") == null) goto L21;
            com.bytedance.ee.bear.templates.dto.b r1 = this.a;
            if (r1 == null) goto L9;
            r1.c(r4.get("TEMPLATE_RESULT_KEY"));
        L9:
            DocumentPluginHost r5 = this.b;
            if (r5 == null) goto L14;
            FragmentActivity r6 = r5.getActivity();
            if (r6 == null) goto L14;
            r6.setResult(100);
        L14:
            DocumentPluginHost r7 = this.b;
            if (r7 == null) goto L22;
            FragmentActivity r8 = r7.getActivity();
            if (r8 == null) goto L23;
            r8.finish();
            return;
        L23:
            return;
        L22:
            return;
        }
    }

    public static final class e implements com.bytedance.ee.bear.templates.dto.a {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void getTitle() {
        }
    }

    static {
        Companion = new a();
    }

    public GroupTemplatePreviewPlugin() {
        super(false, 1, null);
        this.webViewClient = new BaseTemplatePreviewPlugin.a();
    }

    @Override // com.bytedance.ee.bear.document.templatePlugin.BaseTemplatePreviewPlugin, com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.templatePlugin.BaseTemplatePreviewPlugin
    public void hideTemplatePreview() {
        FragmentActivity r1 = null;
        wn5.a r0 = (wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6);
        DocumentPluginHost r2 = (DocumentPluginHost) getHost();
        if (r2 == null) goto L5;
        r1 = r2.getActivity();
    L5:
        r0.e(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.templatePlugin.BaseTemplatePreviewPlugin
    public void showTemplatePreview() {
        FragmentActivity r1 = null;
        wn5.a r0 = (wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6);
        DocumentPluginHost r2 = (DocumentPluginHost) getHost();
        if (r2 == null) goto L5;
        r1 = r2.getActivity();
    L5:
        r0.d(r1);
    }

    private final void initTitleMenu() {
        MenuItem r2 = new MenuItem(MENU_ID_GROUP_PREVIEW_SHARE_ACTION, l.a(getContext(), 2131255656, 2131101926), "");
        r2.setClickListener(new b(this));
        Unit r0 = Unit.INSTANCE;
        showRightMenu(new MenuItem[]{r2});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.templatePlugin.BaseTemplatePreviewPlugin, sa5.d
    public boolean onBackPressed() {
        DocumentPluginHost r0 = (DocumentPluginHost) getHost();
        if (r0 == null) goto L9;
        FragmentActivity r1 = r0.getActivity();
        if (r1 == null) goto L10;
        r1.finish();
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    public final BaseTemplatePreviewPlugin.a getWebViewClient() {
        return this.webViewClient;
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(GroupTemplatePreviewPlugin r0) {
        return r0.getActivity();
    }

    private final void showRightMenu(MenuItem... r3) {
        getTitleBar().setRightVisible(true);
        getTitleBar().getTitleBarLayout().g();
        getTitleBar().j(ArraysKt.asList(r3), TitleBar.MenuType.Right);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.templatePlugin.BaseTemplatePreviewPlugin
    public void onAttachToUIContainer(DocumentPluginHost r6, t r7) {
        super.onAttachToUIContainer(r6, r7);
        getTitleBar().setTitle(getString(2131887356));
        getTitleBar().d();
        if (sbb.e.k.getType().equals(getDocViewModel().getDocumentType()) == false) goto L17;
        if (r7 == null) goto L10;
        View r8 = r7.getContentView();
        if (r8 == null) goto L10;
        View r9 = r8.findViewById(2131388779);
        if (r9 == null) goto L10;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
    L12:
        if ((r10 instanceof AppBarLayout.LayoutParams) == false) goto L14;
        AppBarLayout.LayoutParams r11 = (AppBarLayout.LayoutParams) r10;
    L15:
        if (r11 == null) goto L17;
        r11.setScrollFlags(0);
        goto L17
    L14:
        r11 = null;
    L10:
        r10 = null;
    L17:
        initTitleMenu();
        Uri r12 = UriProtector.parse(getDocViewModel().getOriginUrl());
        String r0 = UriProtector.getQueryParameter(r12, "collectionId");
        if (r0 != null) goto L20;
        return;
    L20:
        yn5.a r2 = new yn5.a(r0, UriProtector.getQueryParameter(r12, "templateType"), UriProtector.getQueryParameter(r12, "templatecenter_source"));
        wn5.a r13 = (wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6);
        Activity r1 = (Activity) getContext();
        ViewGroup r3 = (ViewGroup) ((DocumentPluginHost) getHost()).getActivity().getWindow().findViewById(R.id.content);
        e r4 = e.a;
        h r14 = r13.f(r1, r3, r2);
        getTitleBar().getTitleBarLayout().setLeftClickListener(new c(this, r14));
        MutableLiveData<Map<String, Object>> r5 = ((DocViewModel) ViewModelProviders.of(getActivity()).get(DocViewModel.class)).getDocExtra();
        if (r5 == null) goto L23;
        r5.observe(getActivity(), new d(r14, r6));
    L23:
        ViewModelProviders.of(getActivity()).get(TemplateViewModel.class).setGroupPreviewCallBack(r14);
    }

    @Override // com.bytedance.ee.bear.document.templatePlugin.BaseTemplatePreviewPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }
}
