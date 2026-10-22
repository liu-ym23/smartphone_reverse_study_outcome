package com.bytedance.ee.bear.slides.toolbar;

import an4.e;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.edit_toolbar.BaseDocToolbarV2JsHandlerPlugin;
import com.bytedance.ee.bear.document.edit_toolbar.BaseToolbarV2Plugin;
import com.bytedance.ee.bear.document.edit_toolbar.DocToolbarV2Compat;
import com.bytedance.ee.bear.document.edit_toolbar.ToolbarV2PanelViewModel;
import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.edit.component.toolbar2.ToolBarV2Type;
import com.bytedance.ee.bear.edit.component.toolbar2.a0;
import com.bytedance.ee.bear.edit.component.toolbar2.c0;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeAbsToolbarV2PanelFragment;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.u;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import javax.annotation.Nullable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SlidesToolbarPlugin extends BaseToolbarV2Plugin<DocToolbarV2> implements c0<DocToolbarV2> {
    private static final String EVENT_SLIDE_FLOAT_TOOLBAR_PAGE_CLICK = "ccm_slide_float_toolbar_page_click";
    private static final String EVENT_SPACE_DOCS_TOPBAR_CLICK = "ccm_space_docs_topbar_click";
    private static final String KEY_CLICK = "click";
    private static final String KEY_CLICK_AI_EDIT = "ai_edit";
    private static final String KEY_CLICK_AI_REWRITE = "ai_rewrite";
    private static final String KEY_CLICK_COMMENT = "comment";
    private static final String KEY_CLICK_COPY = "copy";
    private static final String KEY_CLICK_DELETE = "delete";
    private static final String KEY_CLICK_EDIT = "edit";
    private static final String KEY_CLICK_IMAGE_GEN = "image_gen";
    private static final String KEY_CLICK_IMAGE_UPLOAD = "image_upload";
    private static final String KEY_CLICK_REDO = "redo";
    private static final String KEY_CLICK_UNDO = "undo";
    private static final String KEY_ITEM_IMAGE_GEN = "imageGen";
    private static final String KEY_TARGET = "target";
    private static final String KEY_TARGET_NONE = "none";
    private m callBackFunction;
    private EditPanelsManager editPanelsManager;
    private final u toolbarCallback;
    public an4.a toolbarConfig;

    public class a implements u {
        public final /* synthetic */ SlidesToolbarPlugin a;

        public a(SlidesToolbarPlugin r1) {
            this.a = r1;
        }

        public final void a(ItemIdV2 r3, Object r4) {
            this.a.onToolbarItemClick(r3, r4, 3);
        }
    }

    public class b implements BaseToolbarV2PanelViewModel.a {
        public final /* synthetic */ SlidesToolbarPlugin a;

        public final boolean a() {
            y3 r0 = this.a.getDocumentMetadata();
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.getOpenSource() != DocsOpenSource.vc) goto L7;
            return true;
        }

        public final void b() {
            SlidesToolbarPlugin.access$000(this.a).requestUpdateWebContentHeight();
        }

        public b(SlidesToolbarPlugin r1) {
            this.a = r1;
        }

        public final void c(LifecycleOwner r2, Observer r3) {
            SlidesToolbarPlugin.access$000(this.a).getActiveEditPanel().observe(r2, r3);
        }

        public final <V> void onToolbarItemClick(ItemIdV2 r2, V r3, int r4) {
            this.a.onToolbarItemClick(r2, r3, r4);
        }
    }

    public class c implements a0.a {
        public final /* synthetic */ SlidesToolbarPlugin a;

        public final boolean a() {
            if (TextUtils.equals(SlidesToolbarPlugin.access$500(this.a).getShowingItemId(), "insertImage") == false) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean b() {
            return SlidesToolbarPlugin.access$100(this.a).hasToolbarV2();
        }

        public final void c() {
            if (SlidesToolbarPlugin.access$300(this.a).hasToolbarV2() == false) goto L6;
            SlidesToolbarPlugin.access$000(this.a).forceCloseToolbarV2();
            return;
        }

        public final boolean d() {
            return SlidesToolbarPlugin.access$400(this.a).isLastShowingId("insertImage");
        }

        public final void e() {
            SlidesToolbarPlugin.access$000(this.a).requestUpdateWebContentHeight();
        }

        public final void hideAllToolbar() {
            SlidesToolbarPlugin.access$200(this.a).hideToolbar();
        }

        public c(SlidesToolbarPlugin r1) {
            this.a = r1;
        }
    }

    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public int getType() {
        return ToolBarV2Type.SLIDES.getValue();
    }

    public SlidesToolbarPlugin() {
        this.toolbarCallback = new a(this);
    }

    public BaseToolbarV2PanelViewModel<DocToolbarV2> getToolbarViewModel() {
        return q.c(getHost(), ToolbarV2PanelViewModel.class, null);
    }

    public g45.a getEditPanel() {
        return ((BaseToolbarV2Plugin) this).toolbarViewModel;
    }

    public static /* synthetic */ EditPanelsManager access$000(SlidesToolbarPlugin r0) {
        return r0.editPanelsManager;
    }

    public static /* synthetic */ BaseToolbarV2PanelViewModel access$100(SlidesToolbarPlugin r0) {
        return ((BaseToolbarV2Plugin) r0).toolbarViewModel;
    }

    public static /* synthetic */ BaseToolbarV2PanelViewModel access$200(SlidesToolbarPlugin r0) {
        return ((BaseToolbarV2Plugin) r0).toolbarViewModel;
    }

    public static /* synthetic */ BaseToolbarV2PanelViewModel access$300(SlidesToolbarPlugin r0) {
        return ((BaseToolbarV2Plugin) r0).toolbarViewModel;
    }

    public static /* synthetic */ BaseToolbarV2PanelViewModel access$400(SlidesToolbarPlugin r0) {
        return ((BaseToolbarV2Plugin) r0).toolbarViewModel;
    }

    public static /* synthetic */ BaseToolbarV2PanelViewModel access$500(SlidesToolbarPlugin r0) {
        return ((BaseToolbarV2Plugin) r0).toolbarViewModel;
    }

    private String getSlideFloatToolbarClick(String r3) {
        if (ToolbarPrimaryItemId.aiRewrite.name().equals(r3) == false) goto L7;
        return KEY_CLICK_AI_REWRITE;
    L7:
        if (ToolbarPrimaryItemId.inlineAI.name().equals(r3) == false) goto L11;
        return KEY_CLICK_AI_EDIT;
    L11:
        if (ToolbarPrimaryItemId.insertImage.name().equals(r3) == false) goto L15;
        return KEY_CLICK_IMAGE_UPLOAD;
    L15:
        if (KEY_ITEM_IMAGE_GEN.equals(r3) == false) goto L17;
    L30:
        return KEY_CLICK_IMAGE_GEN;
    L17:
        if (KEY_CLICK_IMAGE_GEN.equals(r3) == true) goto L30;
        if (KEY_CLICK_EDIT.equals(r3) == false) goto L22;
        return r3;
    L22:
        if (KEY_CLICK_COPY.equals(r3) == false) goto L24;
        return r3;
    L24:
        if (KEY_CLICK_COMMENT.equals(r3) == false) goto L26;
        return r3;
    L26:
        if ("delete".equals(r3) == true) goto L34;
        return "";
    L34:
        return r3;
    }

    private void reportToolbarItemClick(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return;
    L6:
        if (KEY_CLICK_UNDO.equals(r2) == false) goto L8;
    L14:
        reportEvent(EVENT_SPACE_DOCS_TOPBAR_CLICK, r2);
        return;
    L8:
        if (KEY_CLICK_REDO.equals(r2) == true) goto L14;
        String r3 = getSlideFloatToolbarClick(r2);
        if (TextUtils.isEmpty(r3) == true) goto L16;
        reportEvent(EVENT_SLIDE_FLOAT_TOOLBAR_PAGE_CLICK, r3);
        return;
    }

    public void onAttachToHost(ChameleonPluginHost r3) {
        super.onAttachToHost(r3);
        if (this.toolbarConfig != null) goto L5;
        this.toolbarConfig = new tn5.c();
    L5:
        EditPanelsManager r4 = ViewModelProviders.of(getActivity()).get(EditPanelsManager.class);
        this.editPanelsManager = r4;
        r4.registerEditPanel(getLifecycleOwner(), ((BaseToolbarV2Plugin) this).toolbarViewModel);
        BaseDocToolbarV2JsHandlerPlugin r5 = findPlugin(BaseDocToolbarV2JsHandlerPlugin.class);
        if (r5 == null) goto L8;
        r5.registerHandler(this);
    L9:
        ((BaseToolbarV2Plugin) this).toolbarViewModel.setDelegate(new b(this));
        return;
    L8:
        tt5.a.k("ToolbarV2", "BaseDocToolbarV2JsHandlerPlugin not found when attach SlidesToolbarPlugin");
        goto L9
    }

    public void onDetachFromHost(ChameleonPluginHost r1) {
        super.onDetachFromHost(r1);
        BaseDocToolbarV2JsHandlerPlugin r2 = findPlugin(BaseDocToolbarV2JsHandlerPlugin.class);
        if (r2 == null) goto L6;
        r2.unRegisterHandler(this);
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    private void reportEvent(String r7, String r8) {
        d r2 = (d) org.koin.java.a.a(d.class);     // Catch: Throwable -> L5
        HashMap r3 = new HashMap(r2.m("docCommonParams"));     // Catch: Throwable -> L5
        r3.put(KEY_CLICK, r8);     // Catch: Throwable -> L5
        r3.put(KEY_TARGET, KEY_TARGET_NONE);     // Catch: Throwable -> L5
        r2.u(r7, new JSONObject(r3));     // Catch: Throwable -> L5
        tt5.a.b("ToolbarV2", "report slides toolbar click, event = " + r7 + ", params = " + r3);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("ToolbarV2", "report slides toolbar click failed, event = " + r7 + ", click = " + r8, th, false);
    }

    public void handle(DocToolbarV2 r5, m r6) {
        tt5.a.h("ToolbarV2", "Js update toolbar:" + r5);
        if (r5 == null) goto L13;
        HashSet r0 = new HashSet(Arrays.asList(ToolbarPrimaryItemId.values()));
        an4.a r1 = this.toolbarConfig;
        if (r1 == null) goto L12;
        Iterator r2 = r1.getItemFactorySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        ToolbarPrimaryItemId r3 = ((e) r2.next()).getItemId();
        if ((r3 instanceof ToolbarPrimaryItemId) == false) goto L8;
        r0.add(r3);
    L12:
        r5.initFromJsBridge((ItemIdV2.a[]) r0.toArray(new ItemIdV2.a[0]));
    L13:
        this.callBackFunction = r6;
        if (r5 != null) goto L16;
    L21:
        DocToolbarV2 r7 = null;
    L22:
        updateToolbar(r7);
        ToolbarV2PanelViewModel r8 = ((BaseToolbarV2Plugin) this).toolbarViewModel;
        if ((r8 instanceof ToolbarV2PanelViewModel) == false) goto L25;
        r8.setCurrToolbarV2(r5);
    L25:
        an4.a r9 = this.toolbarConfig;
        if (r9 == null) goto L34;
        r9.getOnUpdateToolBarCallBack().invoke(r5);
        return;
    L34:
        return;
    L16:
        if (r5.getItems() == null) goto L21;
        if (r5.getItems().length == 0) goto L21;
        r7 = r5;
        goto L22
    }

    public void onAttachToUIContainer(ChameleonPluginHost r2, t r3) {
        super.onAttachToUIContainer(r2, r3);
        a0 r4 = ViewModelProviders.of(getActivity()).get(DocToolbarV2Compat.class);
        r4.attach(r2, new c(this));
        this.editPanelsManager.setDocToolbarV2Compat(r4);
    }

    public Fragment onCreateToolbarFragment(Context r2, String r3) {
        Bundle r4 = new Bundle();
        r4.putString(ResourceData.KEY_URL, r3);
        SlidesToolbarV2PanelFragment r5 = instantiateFragment(SlidesToolbarV2PanelFragment.class, r4);
        u r6 = this.toolbarCallback;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "callback");
        ((OfficeAbsToolbarV2PanelFragment) r5).E = new WeakReference(r6);
        r5.F = this.toolbarConfig;
        return r5;
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        DocToolbarV2Compat.of(getActivity()).detach(r1);
        this.editPanelsManager.setDocToolbarV2Compat(null);
    }

    public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
        handle((DocToolbarV2) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }

    public <V> void onToolbarItemClick(ItemIdV2 r2, V r3, int r4) {
        String r5 = r2.name();
        reportToolbarItemClick(r5);
        callBackFunction(this.callBackFunction, r5, r3, r4);
    }
}
