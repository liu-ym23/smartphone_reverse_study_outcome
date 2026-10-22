package com.bytedance.ee.bear.document.selection;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.b5;
import com.bytedance.ee.bear.document.documentinfo.BlockInfo;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.document.z4;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.space.doc.v1.CCMGetCopyHTMLToSegmentRequest;
import com.bytedance.lark.pb.space.doc.v1.CCMGetCopyHTMLToSegmentResponse;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.pb.security_event.ContainerType;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.LarkContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class SelectionPlugin extends DocumentPlugin implements ocb.a, vz4.d, BaseSelectionPlugin<DocumentPluginHost> {
    private static final sbb.e[] NEW_SELECTION_SUPPORT_TYPES = null;
    private static final String TAG = "SelectionPlugin";
    private static final String WEB_GET_CLIPBOARD_TOKEN = "LARK-PSDA-ccm_android_selection_plugin_get_clipboard";
    private static final String WEB_SET_CLIPBOARD_TOKEN = "LARK-PSDA-ccm_android_selection_plugin_set_clipboard";
    private static boolean enableNewSelection;
    private final String BIZ_CLIPBOARD_GET_CONTENT;
    private final String BIZ_CLIPBOARD_SET_CONTENT;
    private final String BIZ_CLIPBOARD_SET_ENCRYPT_ID;
    private String BIZ_SELECT_CLOSE_HANDLER;
    private ClipboardManager.OnPrimaryClipChangedListener clipboardListener;
    private boolean fallbackEnable;
    private Runnable fallbackRunnable;
    private boolean isReportByFront;
    private List<com.bytedance.ee.bear.document.plugin.selection.a> mObservers;
    List<com.bytedance.ee.bear.document.plugin.selection.d> menuItemClickListeners;
    List<BlockInfo> referList;
    private com.bytedance.ee.bear.document.selection.k selectionHandleViewHelper;
    private WebChromeClient webChromeClient;
    private b5 webViewContainer;

    public static class SelectionPluginCompat extends SelectionPlugin {
        @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
        public void clearSelection() {
        }

        @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, vz4.d, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
        public void closeActionMode() {
        }

        @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
        public boolean isShowingActionMode() {
            return false;
        }

        @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
        public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
        }

        @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin
        public void setSelectionScrollEndRate(float r1) {
        }

        public SelectionPluginCompat() {
        }

        @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
        public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
            super.onAttachToHost((DocumentPluginHost) r1);
        }

        @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
        public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
            super.onDetachFromHost((DocumentPluginHost) r1);
        }

        @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
        public /* bridge */ /* synthetic */ void onStart(PluginHost r1) {
            super.onStart((DocumentPluginHost) r1);
        }

        @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
        public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
            super.onAttachToUIContainer((DocumentPluginHost) r1, r2);
        }

        @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin
        public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
            super.onDetachFromUIContainer((DocumentPluginHost) r1, r2);
        }

        @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
        public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
            super.onDetachFromUIContainer((DocumentPluginHost) r1, r2);
        }
    }

    public class a implements ActionMode.Callback {
        public final /* synthetic */ SelectionPlugin a;

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r1, MenuItem r2) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r1, Menu r2) {
            return false;
        }

        public a(SelectionPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r2) {
            Iterator r3 = SelectionPlugin.access$000(this.a).iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((com.bytedance.ee.bear.document.plugin.selection.a) r3.next()).b();
            goto L4
        L6:
            SelectionPlugin.access$200(this.a).execJS(SelectionPlugin.access$100(this.a));
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r1, Menu r2) {
            Iterator r3 = SelectionPlugin.access$000(this.a).iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((com.bytedance.ee.bear.document.plugin.selection.a) r3.next()).a();
            goto L4
        L6:
            return false;
        }
    }

    public class b implements ClipboardManager.OnPrimaryClipChangedListener {
        public final /* synthetic */ fu5.a a;
        public final /* synthetic */ tb5.m b;
        public final /* synthetic */ SelectionPlugin c;

        @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
        public final void onPrimaryClipChanged() {
            if (SelectionPlugin.access$1800(this.c) == null) goto L5;
            com.bytedance.ee.util.ui.j.e(SelectionPlugin.access$1800(this.c));
        L5:
            SelectionPlugin.access$1900(this.c, this.a, this.b);
            this.a.d(this);
            tt5.a.h(SelectionPlugin.TAG, "copy call back");
        }

        public b(SelectionPlugin r1, fu5.a r2, tb5.m r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class c implements SdkSender.IParser<String> {
        public c() {
        }

        public final Object parse(byte[] r2) throws IOException {
            return ((CCMGetCopyHTMLToSegmentResponse) CCMGetCopyHTMLToSegmentResponse.ADAPTER.decode(r2)).html;
        }
    }

    public class d implements tb5.i {
        public final /* synthetic */ SelectionPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(SelectionPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            tt5.a.h(SelectionPlugin.TAG, "copy");
            if (SelectionPlugin.access$1100(this.a) == true) goto L5;
            SelectionPlugin.access$1200(this.a);
        L5:
            SelectionPlugin.access$1300(this.a, r4);
            SelectionPlugin.access$1400(this.a).getWebView().dispatchKeyEvent(new KeyEvent(0, 278));
        }
    }

    public class e implements tb5.i {
        public final /* synthetic */ SelectionPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(SelectionPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            tt5.a.h(SelectionPlugin.TAG, "cut");
            if (SelectionPlugin.access$1100(this.a) == true) goto L5;
            SelectionPlugin.access$1200(this.a);
        L5:
            SelectionPlugin.access$2100(this.a).getWebView().dispatchKeyEvent(new KeyEvent(0, 277));
        }
    }

    public static class f implements tb5.i<ClipboardContent> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public f() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r7, tb5.m r8) {
            ClipboardContent r9 = (ClipboardContent) r7;
            tt5.a.h(SelectionPlugin.TAG, "GetClipboardContentHandler:" + r9);
            if (r9 != null) goto L27;
            r8.b(new JSONObject());
            tt5.a.h(SelectionPlugin.TAG, "GetClipboardContentHandler data null");
            return;
        L27:
            ClipData r10 = ((fu5.a) org.koin.java.a.a(fu5.a.class)).k(r9.getEncryptId(), new Token(SelectionPlugin.WEB_GET_CLIPBOARD_TOKEN));     // Catch: Exception -> L24
            JSONObject r2 = new JSONObject();     // Catch: Exception -> L24
            if (r10 != null) goto L9;
        L22:
            r8.b(r2);     // Catch: Exception -> L24
            return;
        L9:
            if (r10.getItemCount() <= 0) goto L22;
            ClipData.Item r11 = r10.getItemAt(0);     // Catch: Exception -> L24
            if (r11 == null) goto L22;
            String r5 = "";
            if (r11.getText() != null) goto L16;
            String r4 = "";
        L17:
            r2.put("public.utf8-plain-text", r4);     // Catch: Exception -> L24
            if (r11.getHtmlText() == null) goto L21;
            r5 = r11.getHtmlText();     // Catch: Exception -> L24
        L21:
            r2.put("public.html", r5);     // Catch: Exception -> L24
            goto L22
        L16:
            r4 = String.valueOf(r11.getText());     // Catch: Exception -> L24
        L24:
            e = move-exception;
            r8.b(new JSONObject());
            tt5.a.e(SelectionPlugin.TAG, "ClipboardGetHandler (): copy failed", e, false);
        }
    }

    public class g implements tb5.i {
        public final /* synthetic */ SelectionPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public g(SelectionPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            tt5.a.h(SelectionPlugin.TAG, "paste");
            SelectionPlugin.access$2200(this.a).getWebView().dispatchKeyEvent(new KeyEvent(0, 279));
        }
    }

    public class h implements tb5.i<String> {
        public final /* synthetic */ SelectionPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public h(SelectionPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            String r5 = (String) r3;
            StringBuilder r6 = new StringBuilder("SearchWebMenuClickHandler data: ");
            if (r5 == null) goto L5;
            Integer r0 = Integer.valueOf(r5.length());
        L6:
            r6.append(r0);
            tt5.a.h(SelectionPlugin.TAG, r6.toString());
            String r7 = "";
            if (r5 == null) goto L10;
            r7 = new org.json.JSONObject(r5).optString("content", "");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            tt5.a.j(SelectionPlugin.TAG, th);
            return;
        L10:
            if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.docx.keyword_search") == false) goto L12;
            ((a4c.a) e0c.k.a(LarkContext.getApplication(), a4c.a.class)).b(SelectionPlugin.access$1500(this.a).getWebView().getContext(), r7);     // Catch: Throwable -> L14
            tt5.a.h(SelectionPlugin.TAG, "SearchWebMenuClickHandler ret: false");     // Catch: Throwable -> L14
            SelectionPlugin.access$1600(this.a, r7);     // Catch: Throwable -> L14
            return;
        L12:
            SelectionPlugin.access$1600(this.a, r7);     // Catch: Throwable -> L14
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    public class i implements tb5.i<ClipboardContent> {
        public final /* synthetic */ SelectionPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public i(SelectionPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, tb5.m r5) {
            ClipboardContent r6 = (ClipboardContent) r4;
            if (r6 == null) goto L5;
            SelectionPlugin.access$2300(this.a, r6.getText(), r6.getHtml(), r6.getEncryptId(), r6.isProtect());
            return;
        L5:
            tt5.a.d(SelectionPlugin.TAG, "SetClipboardContentHandler data null");
        }
    }

    public class j implements tb5.i<ClipboardEncrypt> {
        public final /* synthetic */ SelectionPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public j(SelectionPlugin r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // tb5.i, tb5.o
        public final void handle(Object r4, tb5.m r5) {
            HashMap<String, String> r6 = ((ClipboardEncrypt) r4).getEncryptIds();
            if (r6 == null) goto L28;
            tt5.a.h(SelectionPlugin.TAG, "SetClipboardEncryptIdHandler:" + r6.size());
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docs.synced_block.permission.authentication") == true) goto L7;
        L9:
            boolean r7 = false;
        L10:
            if (r7 == false) goto L12;
            String r8 = SelectionPlugin.access$2500(this.a).getOriginBearUrl().b;
        L14:
            if (r6.containsKey(r8) == false) goto L16;
            String r9 = r6.get(r8);
            SelectionPlugin.access$2700(this.a, r9);
            SelectionPlugin.access$2800(this.a).setDocEncryptId(r9);
        L16:
            ArrayList r10 = new ArrayList();
            Iterator<Map.Entry<String, String>> r11 = r6.entrySet().iterator();
        L18:
            if (r11.hasNext() == false) goto L20;
            Map.Entry<String, String> r0 = r11.next();
            BlockInfo r1 = new BlockInfo(r0.getKey());
            r1.setEncryptId(r0.getValue());
            r10.add(r1);
            goto L18
        L20:
            this.a.referList.addAll(r10);
            w05.i r12 = ((w05.b) ((DocumentPluginHost) this.a.getHost()).getHostAbility(w05.b.class)).getDocumentInfoProvider();
            DocumentInfo r13 = (DocumentInfo) r12.g().getValue();
            if (r13 == null) goto L23;
            r13.updateBlockInfo(this.a.referList);
            SelectionPlugin.access$2900(this.a).notifyBlockInfoUpdate();
        L23:
            DocumentInfo r14 = (DocumentInfo) r12.k().getValue();
            if (r14 == null) goto L29;
            r14.updateBlockInfo(this.a.referList);
            return;
        L29:
            return;
        L12:
            r8 = SelectionPlugin.access$2600(this.a).getToken();
            goto L14
        L7:
            if (SelectionPlugin.access$2400(this.a).isSyncBlock() == false) goto L9;
            r7 = true;
            goto L10
        }
    }

    public class k implements tb5.i<String> {
        public final /* synthetic */ SelectionPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public k(SelectionPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r5, tb5.m r6) {
            String r7 = (String) r5;
            StringBuilder r8 = new StringBuilder("ShareMenuClickHandler data: ");
            if (r7 == null) goto L5;
            Integer r0 = Integer.valueOf(r7.length());
        L6:
            r8.append(r0);
            tt5.a.h(SelectionPlugin.TAG, r8.toString());
            String r9 = "";
            if (r7 != null) goto L19;
            String r10 = "";
        L12:
            SelectionPlugin r1 = this.a;     // Catch: Throwable -> L9
            if ((r1 instanceof SelectionPluginNew) == false) goto L15;
            r9 = ((SelectionPluginNew) r1).getShareTitle();     // Catch: Throwable -> L9
        L15:
            Intent r2 = new Intent("android.intent.action.SEND");     // Catch: Throwable -> L9
            r2.addFlags(268435456);     // Catch: Throwable -> L9
            r2.putExtra("android.intent.extra.TEXT", r10);     // Catch: Throwable -> L9
            r2.setType("text/plain");     // Catch: Throwable -> L9
            Intent r11 = Intent.createChooser(r2, r9);     // Catch: Throwable -> L9
            r11.addFlags(268435456);     // Catch: Throwable -> L9
            SelectionPlugin.access$1700(this.a).getWebView().getContext().startActivity(r11);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            tt5.a.j(SelectionPlugin.TAG, th);
            return;
        L19:
            r10 = new org.json.JSONObject(r7).optString("content", "");     // Catch: Throwable -> L9
            goto L12
        L5:
            r0 = null;
            goto L6
        }
    }

    static {
        NEW_SELECTION_SUPPORT_TYPES = new sbb.e[]{sbb.e.g, sbb.e.h, sbb.e.n, sbb.e.o, sbb.e.i};
    }

    public static /* synthetic */ void c(SelectionPlugin r0, String r1) {
        r0.lambda$getMenuItemClickListener$0(r1);
    }

    public static /* synthetic */ void d(SelectionPlugin r0, DocumentInfo r1) {
        r0.lambda$registerDocumentInfoObserver$1(r1);
    }

    public static /* synthetic */ void e(SelectionPlugin r0, DocumentInfo r1) {
        r0.lambda$registerDocumentInfoObserver$2(r1);
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public abstract void clearSelection();

    @Override // vz4.d, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public abstract void closeActionMode();

    @Override // com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public abstract boolean isShowingActionMode();

    @Override // com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public /* synthetic */ void jsClearDocxSelection() {
        BaseSelectionPlugin.CC.$default$jsClearDocxSelection(this);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public abstract void setSelectionScrollEndRate(float r1);

    public boolean shouldEnableTextIntentItems() {
        return true;
    }

    private void registerDocumentInfoObserver() {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        jg5.e r0 = jg5.e.a.a;
        if (com.bytedance.ee.bear.middleground.permission.b.g() == true) goto L5;
        return;
    L5:
        if (getDocViewModel() != null) goto L8;
        return;
    L8:
        if (getDocViewModel().liveOfflineDocumentInfoData() == null) goto L11;
        getDocViewModel().liveOfflineDocumentInfoData().observe(getLifecycleOwner(), new h0(this));
    L11:
        if (getDocViewModel() != null) goto L13;
        return;
    L13:
        if (getDocViewModel().liveDocumentInfoData() == null) goto L19;
        getDocViewModel().liveDocumentInfoData().observe(getLifecycleOwner(), new i0(this));
        return;
    }

    public ActionMode.Callback getActionModeDelegate() {
        return new a(this);
    }

    public com.bytedance.ee.bear.document.plugin.selection.d getMenuItemClickListener() {
        return new j0(this);
    }

    public SelectionPlugin() {
        this.selectionHandleViewHelper = new com.bytedance.ee.bear.document.selection.k();
        this.fallbackEnable = false;
        this.BIZ_SELECT_CLOSE_HANDLER = "window.lark.biz.util.onContextMenuClose";
        this.BIZ_CLIPBOARD_SET_CONTENT = "biz.clipboard.setContent";
        this.BIZ_CLIPBOARD_GET_CONTENT = "biz.clipboard.getContent";
        this.BIZ_CLIPBOARD_SET_ENCRYPT_ID = "biz.clipboard.setEncryptId";
        this.webChromeClient = null;
        this.menuItemClickListeners = new CopyOnWriteArrayList();
        this.referList = new CopyOnWriteArrayList();
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        Application r1 = LarkContext.getApplication();
        r0.getClass();
        UserSession r2 = ((com.ss.android.lark.passportc.convention.a) e0c.k.a(r1, com.ss.android.lark.passportc.convention.a.class)).b();
        this.isReportByFront = ((dn4.a) e0c.k.b(((com.ss.android.lark.passportc.internal.v) e0c.k.a(r1, com.ss.android.lark.passportc.internal.v.class)).c(r2), dn4.a.class)).a().isCurrentEnable("ccm.mobile.audit_report_by_front");
        this.mObservers = new ArrayList();
    }

    private void auditCopyEvent() {
        BearUrl r0 = getDocViewModel().getBearUrl();
        BearUrl r1 = getDocViewModel().getOriginBearUrl();
        boolean r2 = getDocViewModel().isType(sbb.e.n);
        if (r0 == null) goto L14;
        if (r1 == null) goto L15;
        com.bytedance.ee.bear.middleground_permission_export.model.c r3 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.c.class);
        sbb.e r4 = sbb.e.e(r0.a);
        String r5 = r0.b;
        if (r2 == false) goto L8;
        ContainerType r6 = ContainerType.Wiki;
    L9:
        if (r2 == false) goto L11;
        String r7 = r1.b;
    L12:
        r3.b(r4, r5, r6, r7);
        return;
    L11:
        r7 = "";
        goto L12
    L8:
        r6 = ContainerType.ContainerTypeUnknown;
        goto L9
    L15:
        return;
    }

    private void reportCopyEvent() {
        if (getDocViewModel().getDocumentInfoData() == null) goto L5;
        boolean r0 = getDocViewModel().getDocumentInfoData().getDocPermission().a.isCopyAuthByLeader();
    L6:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).j0();
        jg5.k.a.a.d(r0, true);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // vz4.d
    public String getDocEncryptId() {
        return getDocViewModel().getDocEncryptId();
    }

    public static /* synthetic */ List access$000(SelectionPlugin r0) {
        return r0.mObservers;
    }

    public static /* synthetic */ String access$100(SelectionPlugin r0) {
        return r0.BIZ_SELECT_CLOSE_HANDLER;
    }

    public static /* synthetic */ boolean access$1100(SelectionPlugin r0) {
        return r0.isReportByFront;
    }

    public static /* synthetic */ void access$1200(SelectionPlugin r0) {
        r0.auditCopyEvent();
    }

    public static /* synthetic */ vv4.k access$1400(SelectionPlugin r0) {
        return r0.getWeb();
    }

    public static /* synthetic */ vv4.k access$1500(SelectionPlugin r0) {
        return r0.getWeb();
    }

    public static /* synthetic */ vv4.k access$1700(SelectionPlugin r0) {
        return r0.getWeb();
    }

    public static /* synthetic */ Runnable access$1800(SelectionPlugin r0) {
        return r0.fallbackRunnable;
    }

    public static /* synthetic */ vv4.k access$200(SelectionPlugin r0) {
        return r0.getWeb();
    }

    public static /* synthetic */ vv4.k access$2100(SelectionPlugin r0) {
        return r0.getWeb();
    }

    public static /* synthetic */ vv4.k access$2200(SelectionPlugin r0) {
        return r0.getWeb();
    }

    public static /* synthetic */ DocViewModel access$2400(SelectionPlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ DocViewModel access$2500(SelectionPlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ DocViewModel access$2600(SelectionPlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ DocViewModel access$2800(SelectionPlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ DocViewModel access$2900(SelectionPlugin r0) {
        return r0.getDocViewModel();
    }

    public static SelectionPlugin create(PluginHost r1) {
        boolean r2 = enableNewSelection((e4) r1.getHostAbility(e4.class));
        enableNewSelection = r2;
        if (r2 == false) goto L7;
        return new SelectionPluginNew();
    L7:
        if (com.larksuite.framework.utils.x.b() == false) goto L11;
        return new SelectionPluginOld();
    L11:
        return new SelectionPluginCompat();
    }

    private static boolean enableNewSelection(e4 r5) {
        y3 r6 = r5.getDocumentMetadata();
        sbb.e[] r0 = NEW_SELECTION_SUPPORT_TYPES;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (r6.isDocumentType(r0[r3]) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private /* synthetic */ void lambda$getMenuItemClickListener$0(String r3) {
        Iterator r0 = new ArrayList(this.menuItemClickListeners).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.document.plugin.selection.d) r0.next()).a(r3);
        goto L4
    }

    private /* synthetic */ void lambda$registerDocumentInfoObserver$1(DocumentInfo r2) {
        if (r2 == null) goto L5;
        r2.updateBlockInfo(this.referList);
        return;
    }

    private /* synthetic */ void lambda$registerDocumentInfoObserver$2(DocumentInfo r2) {
        if (r2 == null) goto L5;
        r2.updateBlockInfo(this.referList);
        getDocViewModel().notifyBlockInfoUpdate();
        return;
    }

    private void notifyJsCopyFinish(tb5.m r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        fu5.a r0 = (fu5.a) org.koin.java.a.a(fu5.a.class);
        if (r0 == null) goto L8;
        r0.d(this.clipboardListener);
        b r1 = new b(this, r0, r3);
        this.clipboardListener = r1;
        r0.e(r1);
        return;
    }

    private void searchWeb(String r3) {
        Intent r0 = new Intent("android.intent.action.WEB_SEARCH");
        r0.addFlags(268435456);
        r0.putExtra("query", r3);
        getWeb().getWebView().getContext().startActivity(r0);
    }

    private void updateEncryptId(String r2) {
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).a(r2);
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public void addMenuItemClickListener(com.bytedance.ee.bear.document.plugin.selection.d r2) {
        if (this.menuItemClickListeners.contains(r2) == true) goto L6;
        this.menuItemClickListeners.add(r2);
        return;
    }

    public void onAttachToHost(DocumentPluginHost r2) {
        super.onAttachToHost(r2);
        r2.registerHostAbility(this);
        if ((getWeb() instanceof z4) == false) goto L5;
        this.webChromeClient = new com.bytedance.ee.bear.document.plugin.selection.b();
        tt5.a.b(TAG, "addWebChromeClientDelegate");
        getWeb().addWebChromeClientDelegate(this.webChromeClient);
        updateEncryptId(getDocViewModel().getDocEncryptId());
        return;
    L5:
        this.webChromeClient = null;
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        super.onDetachFromHost(r2);
        r2.unregisterHostAbility(this);
        this.mObservers.clear();
        if (this.webChromeClient == null) goto L6;
        getWeb().removeWebChromeClientDelegate(this.webChromeClient);
        this.webChromeClient = null;
        return;
    }

    public void onStart(DocumentPluginHost r3) {
        super.onStart(r3);
        String r4 = getDocEncryptId();
        tt5.a.h(TAG, "onStart:" + du5.b.g(r4));
        updateEncryptId(r4);
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public void registerActionModeObserver(com.bytedance.ee.bear.document.plugin.selection.a r2) {
        if (this.mObservers.contains(r2) == true) goto L6;
        this.mObservers.add(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public void removeMenuItemClickListener(com.bytedance.ee.bear.document.plugin.selection.d r2) {
        this.menuItemClickListeners.remove(r2);
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public void unregisterActionModeObserver(com.bytedance.ee.bear.document.plugin.selection.a r2) {
        this.mObservers.remove(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onStart(PluginHost r1) {
        onStart((DocumentPluginHost) r1);
    }

    public static /* synthetic */ void access$1300(SelectionPlugin r0, tb5.m r1) {
        r0.notifyJsCopyFinish(r1);
    }

    public static /* synthetic */ void access$1600(SelectionPlugin r0, String r1) {
        r0.searchWeb(r1);
    }

    public static /* synthetic */ void access$2700(SelectionPlugin r0, String r1) {
        r0.updateEncryptId(r1);
    }

    private void copyCallback(fu5.a r3, tb5.m r4) {
        JSONObject r0 = new JSONObject();
        r0.put("success", r3.f());
        r4.b(r0);
    }

    public void onAttachToUIContainer(DocumentPluginHost r4, com.bytedance.ee.bear.browser.plugin.t r5) {
        super.onAttachToUIContainer(r4, r5);
        com.bytedance.ee.bear.document.selection.k r6 = this.selectionHandleViewHelper;
        z4 r0 = (z4) r4.getWeb();
        r6.f = r0;
        r0.d(r6.l);
        r6.g = new GestureDetector(r0.getWebView().getContext(), new com.bytedance.ee.bear.document.selection.i(r6));
        r4.getWeb().addOnTouchListener(this.selectionHandleViewHelper);
        pcb.a.a.b(getActivity()).c(this.selectionHandleViewHelper);
        if (com.larksuite.framework.utils.x.b() == false) goto L5;
    L7:
        this.webViewContainer = (b5) r4.getContainer(com.ss.android.lark.chameleonv2.container.webcontainer.util.ContainerType.Web.getValue());
        bindBridgeHandlerAutoUnbind("biz.navigation.handleCopyMenuClick", new d(this));
        bindBridgeHandlerAutoUnbind("biz.navigation.handleCutMenuClick", new e(this));
        bindBridgeHandlerAutoUnbind("biz.navigation.handlePasteMenuClick", new g(this));
        bindBridgeHandler("biz.clipboard.setContent", new i(this));
        bindBridgeHandler("biz.clipboard.getContent", new f());
        bindBridgeHandler("biz.clipboard.setEncryptId", new j(this));
        bindBridgeHandler("biz.navigation.handleSearchWebMenuClick", new h(this));
        bindBridgeHandler("biz.navigation.handleShareMenuClick", new k(this));
        pcb.a.a.b(getActivity()).c(this);
        this.fallbackEnable = com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.doc_copy_fallback", false);
        registerDocumentInfoObserver();
        return;
    L5:
        if (enableNewSelection == true) goto L7;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r3, com.bytedance.ee.bear.browser.plugin.t r4) {
        pcb.a.a.b(getActivity()).a(this.selectionHandleViewHelper);
        r3.getWeb().removeOnTouchListener(this.selectionHandleViewHelper);
        com.bytedance.ee.bear.document.selection.k r0 = this.selectionHandleViewHelper;
        com.bytedance.ee.util.ui.j.e(r0.j);
        com.bytedance.ee.util.ui.j.e(r0.k);
        r0.f.F(r0.l);
        super.onDetachFromUIContainer(r3, r4);
        if (com.larksuite.framework.utils.x.b() == false) goto L5;
    L7:
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).d(this.clipboardListener);
        pcb.a.a.b(getActivity()).a(this);
        return;
    L5:
        if (enableNewSelection == true) goto L7;
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

    public static /* synthetic */ void access$1900(SelectionPlugin r0, fu5.a r1, tb5.m r2) {
        r0.copyCallback(r1, r2);
    }

    public void onKeyboardHeightChanged(pcb.a r2, int r3, int r4) {
        if (com.larksuite.framework.utils.x.b() == false) goto L5;
    L7:
        if (r3 <= 0) goto L9;
        boolean r5 = true;
    L10:
        float r6 = (1.0f - ((r3 + getResources().getDimension(2131168470)) / this.webViewContainer.getHeight())) - 0.13f;
        if (r5 == true) goto L14;
        r6 = 0.87f;
    L14:
        setSelectionScrollEndRate(r6);
        return;
    L9:
        r5 = false;
        goto L10
    L5:
        if (enableNewSelection == true) goto L7;
    }

    private void finallySetClipboardContentData(String r3, String r4, String r5, boolean r6) {
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).g(r5, ClipData.newHtmlText("", new SpannableString(r3), r4), r6, new Token(WEB_SET_CLIPBOARD_TOKEN));
        reportCopyEvent();
    }

    private void setClipboardContentData(String r3, String r4, String r5, boolean r6) {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.copy.atmention.support") == true) goto L5;
    L8:
        finallySetClipboardContentData(r3, r4, r5, r6);
        return;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L8;
        setClipboardContentDataSupportNativeProtocal(r3, r4, r5, r6);
    }

    private void setClipboardContentDataSupportNativeProtocal(final String r10, final String r11, final String r12, final boolean r13) {
        CCMGetCopyHTMLToSegmentRequest.Builder r0 = new CCMGetCopyHTMLToSegmentRequest.Builder();
        r0.html = r11;
        SdkSender.asynSendRequestNonWrap(Command.CCM_GET_COPY_HTML_TO_SEGMENT, r0, new AnonymousClass3(this, r10, r11, r12, r13), new c());
    }

    public static /* synthetic */ void access$2000(SelectionPlugin r0, String r1, String r2, String r3, boolean r4) {
        r0.finallySetClipboardContentData(r1, r2, r3, r4);
    }

    public static /* synthetic */ void access$2300(SelectionPlugin r0, String r1, String r2, String r3, boolean r4) {
        r0.setClipboardContentData(r1, r2, r3, r4);
    }
}
