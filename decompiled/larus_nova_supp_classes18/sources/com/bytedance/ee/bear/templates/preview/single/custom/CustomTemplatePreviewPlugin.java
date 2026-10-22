package com.bytedance.ee.bear.templates.preview.single.custom;

import android.R;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.browser.plugin.g;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.templatePlugin.BaseTemplatePreviewPlugin;
import com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin;
import com.bytedance.ee.bear.lark.dependency.j0;
import com.bytedance.ee.util.ui.j;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0002J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020!H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/single/custom/CustomTemplatePreviewPlugin;", "Lcom/bytedance/ee/bear/document/templatePlugin/BaseTemplatePreviewPlugin;", "<init>", "()V", "rootContainer", "Landroid/widget/FrameLayout;", "action", "", "chatId", "templateSource", "objType", "objToken", "templateId", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "updateUIContent", "title", "bindTitle", "updateTitle", "ensureRootContainer", "updateCustomView", "customUI", "Landroid/view/View;", "removeRootAllChildView", "getRootContainerHeight", "", "hideTemplatePreview", "showTemplatePreview", "onBackPressed", "", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomTemplatePreviewPlugin extends BaseTemplatePreviewPlugin {
    public static final a Companion = null;
    public static final String TAG = "CustomTemplatePreviewPlugin";
    private String action;
    private String chatId;
    private String objToken;
    private String objType;
    private FrameLayout rootContainer;
    private String templateId;
    private String templateSource;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ CustomTemplatePreviewPlugin a;

        public b(CustomTemplatePreviewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            String r4 = (String) r3;
            tt5.a.b(CustomTemplatePreviewPlugin.TAG, "observe docViewModel.docTitle: " + CustomTemplatePreviewPlugin.access$getDocViewModel(this.a).getDocTitle() + " title=" + r4);
            CustomTemplatePreviewPlugin.access$updateTitle(this.a, r4);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ CustomTemplatePreviewPlugin a;

        public static final class a<P extends f> implements g {
            public final /* synthetic */ int a;

            public a(int r1) {
                this.a = r1;
            }

            public final void a(f r3) {
                BaseTitlePlugin r4 = (BaseTitlePlugin) r3;
                Intrinsics.checkNotNullParameter(r4, "it");
                r4.updateCustomPreviewStatus(true, this.a);
            }
        }

        public c(CustomTemplatePreviewPlugin r1) {
            this.a = r1;
        }

        public final void a() {
            int r0 = CustomTemplatePreviewPlugin.access$getRootContainerHeight(this.a);
            tt5.a.h(CustomTemplatePreviewPlugin.TAG, "rootContainerHeight: " + r0);
            this.a.getHost().findPluginToDo(BaseTitlePlugin.class, new a(r0));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    public CustomTemplatePreviewPlugin() {
        super(false, 1, null);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void ensureRootContainer() {
        if (this.rootContainer != null) goto L6;
        ViewGroup r0 = (ViewGroup) getHost().getActivity().getWindow().findViewById(R.id.content);
        this.rootContainer = (FrameLayout) LayoutInflater.from(getContext()).inflate(2131559982, r0, true).findViewById(2131368467);
        return;
    }

    private final int getRootContainerHeight() {
        FrameLayout r0 = this.rootContainer;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getHeight();
    }

    private final void removeRootAllChildView() {
        FrameLayout r0 = this.rootContainer;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        if (r0.getChildCount() <= 0) goto L9;
        FrameLayout r1 = this.rootContainer;
        Intrinsics.checkNotNull(r1);
        r1.removeAllViews();
        return;
    L9:
        return;
    }

    public void hideTemplatePreview() {
        FrameLayout r0 = this.rootContainer;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    public void showTemplatePreview() {
        FrameLayout r0 = this.rootContainer;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        return;
    }

    private final void bindTitle() {
        getDocViewModel().getDocName().observe(getLifecycleOwner(), new b(this));
    }

    public boolean onBackPressed() {
        getActivity().finish();
        return false;
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(CustomTemplatePreviewPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ int access$getRootContainerHeight(CustomTemplatePreviewPlugin r0) {
        return r0.getRootContainerHeight();
    }

    private final void updateCustomView(View r3) {
        tt5.a.h(TAG, String.valueOf(r3));
        if (r3 == null) goto L12;
        ensureRootContainer();
        removeRootAllChildView();
        ViewParent r0 = r3.getParent();
        if (r0 != null) goto L7;
    L9:
        FrameLayout r1 = this.rootContainer;
        if (r1 == null) goto L12;
        r1.addView(r3);
        goto L12
    L7:
        if ((r0 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r0).removeView(r3);
    L12:
        j.c(new c(this));
    }

    private final void updateTitle(String r2) {
        getTitleBar().setTitle(r2);
        getTitleBar().d();
    }

    private final void updateUIContent(String r11) {
        FragmentActivity r1 = null;
        if (Intrinsics.areEqual(this.action, "add_chat_tab") == false) goto L45;
        j0 r0 = (j0) org.koin.java.a.c(j0.class, null, null, 6);
        DocumentPluginHost r2 = getHost();
        if (r2 == null) goto L7;
        r1 = r2.getActivity();
    L7:
        FragmentActivity r3 = r1;
        String r4 = this.objToken;
        String r5 = this.objType;
        int r6 = na5.a.a;
        if (r5 != null) goto L10;
    L13:
        boolean r7 = true;
    L14:
        if (r7 == false) goto L17;
    L43:
        String r8 = "UNKNOWN_DOC_TYPE";
    L44:
        r1 = r0.a(new wb5.b(r3, r4, r8, r11, this.templateId, this.chatId));
        goto L45
    L17:
        if (Intrinsics.areEqual(r5, e.g.getType()) == false) goto L20;
        r8 = "DOC";
        goto L44
    L20:
        if (Intrinsics.areEqual(r5, e.h.getType()) == false) goto L23;
        r8 = "SHEET";
        goto L44
    L23:
        if (Intrinsics.areEqual(r5, e.i.getType()) == false) goto L26;
        r8 = "BITABLE";
        goto L44
    L26:
        if (Intrinsics.areEqual(r5, e.k.getType()) == false) goto L29;
        r8 = "MINDNOTE";
        goto L44
    L29:
        if (Intrinsics.areEqual(r5, e.l.getType()) == false) goto L32;
        r8 = "FILE";
        goto L44
    L32:
        if (Intrinsics.areEqual(r5, e.m.getType()) == false) goto L35;
        r8 = "SLIDES";
        goto L44
    L35:
        if (Intrinsics.areEqual(r5, e.n.getType()) == false) goto L38;
        r8 = "WIKI";
        goto L44
    L38:
        if (Intrinsics.areEqual(r5, e.o.getType()) == false) goto L41;
        r8 = "DOCX";
        goto L44
    L41:
        if (Intrinsics.areEqual(r5, e.y.getType()) == false) goto L43;
        r8 = "DOCX_SYNCED_BLOCK";
        goto L44
    L10:
        if (r5.length() == 0) goto L13;
        r7 = false;
    L45:
        updateCustomView(r1);
    }

    public static final /* synthetic */ void access$updateTitle(CustomTemplatePreviewPlugin r0, String r1) {
        r0.updateTitle(r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r4, t r5) {
        super.onAttachToUIContainer(r4, r5);
        Uri r6 = UriProtector.parse(getDocViewModel().getOriginUrl());
        this.action = UriProtector.getQueryParameter(r6, "action");
        this.chatId = UriProtector.getQueryParameter(r6, "chatId");
        this.templateSource = UriProtector.getQueryParameter(r6, "template_source");
        this.objType = UriProtector.getQueryParameter(r6, "objType");
        this.objToken = UriProtector.getQueryParameter(r6, "objToken");
        this.templateId = UriProtector.getQueryParameter(r6, "templateId");
        tt5.a.b(TAG, "url: " + r6);
        updateTitle(getDocViewModel().getDocTitle());
        updateUIContent(getDocViewModel().getDocTitle());
        bindTitle();
        Lazy r7 = CustomTemplatePreviewAnalytic.a;
        String r8 = this.templateSource;
        String r0 = this.objToken;
        String r1 = this.chatId;
        JSONObject r2 = new JSONObject();
        r2.put("template_source", r8);
        r2.put("template_token", du5.b.g(r0));
        r2.put("template_chat_id", r1);
        ((d) CustomTemplatePreviewAnalytic.a.getValue()).o("ccm_template_preview_view", r2, true);
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }
}
