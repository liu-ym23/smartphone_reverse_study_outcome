package com.bytedance.ee.bear.document.plugin.selection;

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
import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.documentinfo.BlockInfo;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.space.doc.v1.CCMGetCopyHTMLToSegmentRequest;
import com.bytedance.lark.pb.space.doc.v1.CCMGetCopyHTMLToSegmentResponse;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
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
public abstract class OfficeSelectionPlugin extends DocumentPluginV3 implements ocb.a, vz4.d, BaseSelectionPlugin<ChameleonPluginHost> {
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
    private List<com.bytedance.ee.bear.document.plugin.selection.a> mObservers;
    List<com.bytedance.ee.bear.document.plugin.selection.d> menuItemClickListeners;
    List<BlockInfo> referList;
    private q selectionHandleViewHelper;
    private WebChromeClient webChromeClient;

    public static class OfficeSelectionPluginCompat extends OfficeSelectionPlugin {
        @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
        public void clearSelection() {
        }

        @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin, vz4.d, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
        public void closeActionMode() {
        }

        @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
        public boolean isShowingActionMode() {
            return false;
        }

        @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin, com.bytedance.ee.bear.document.base.DocumentPluginV3
        public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
        }

        @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin
        public void setSelectionScrollEndRate(float r1) {
        }

        public OfficeSelectionPluginCompat() {
        }

        @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin, com.bytedance.ee.bear.browser.plugin.f
        public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
            super.onAttachToHost((ChameleonPluginHost) r1);
        }

        @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin, com.bytedance.ee.bear.browser.plugin.f
        public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
            super.onDetachFromHost((ChameleonPluginHost) r1);
        }

        @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin, com.bytedance.ee.bear.browser.plugin.f
        public /* bridge */ /* synthetic */ void onStart(PluginHost r1) {
            super.onStart((ChameleonPluginHost) r1);
        }

        @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin, com.bytedance.ee.bear.browser.plugin.f
        public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
            super.onAttachToUIContainer((ChameleonPluginHost) r1, r2);
        }

        @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin, com.bytedance.ee.bear.browser.plugin.f
        public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
            super.onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
        }
    }

    public class a implements ActionMode.Callback {
        public final /* synthetic */ OfficeSelectionPlugin a;

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r1, MenuItem r2) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r1, Menu r2) {
            return false;
        }

        public a(OfficeSelectionPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r2) {
            Iterator r3 = OfficeSelectionPlugin.access$000(this.a).iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((com.bytedance.ee.bear.document.plugin.selection.a) r3.next()).b();
            goto L4
        L6:
            this.a.getHost().getWeb().execJS(OfficeSelectionPlugin.access$100(this.a));
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r1, Menu r2) {
            Iterator r3 = OfficeSelectionPlugin.access$000(this.a).iterator();
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
        public final /* synthetic */ OfficeSelectionPlugin c;

        @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
        public final void onPrimaryClipChanged() {
            if (OfficeSelectionPlugin.access$1200(this.c) == null) goto L5;
            com.bytedance.ee.util.ui.j.e(OfficeSelectionPlugin.access$1200(this.c));
        L5:
            OfficeSelectionPlugin.access$1300(this.c, this.a, this.b);
            this.a.d(this);
            tt5.a.h(OfficeSelectionPlugin.TAG, "copy call back");
        }

        public b(OfficeSelectionPlugin r1, fu5.a r2, tb5.m r3) {
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
        public final /* synthetic */ OfficeSelectionPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(OfficeSelectionPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            tt5.a.h(OfficeSelectionPlugin.TAG, "copy");
            OfficeSelectionPlugin.access$1000(this.a, r4);
            this.a.getWeb().getWebView().dispatchKeyEvent(new KeyEvent(0, 278));
        }
    }

    public class e implements tb5.i {
        public final /* synthetic */ OfficeSelectionPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(OfficeSelectionPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            tt5.a.h(OfficeSelectionPlugin.TAG, "cut");
            this.a.getWeb().getWebView().dispatchKeyEvent(new KeyEvent(0, 277));
        }
    }

    public static class f implements tb5.i<ClipboardContent> {
        public f() {
        }

        @Override // tb5.i, tb5.o
        public final BridgeAuthType authType() {
            return BridgeAuthType.Private;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r7, tb5.m r8) {
            ClipboardContent r9 = (ClipboardContent) r7;
            tt5.a.h(OfficeSelectionPlugin.TAG, "GetClipboardContentHandler:" + r9);
            if (r9 != null) goto L27;
            r8.b(new JSONObject());
            tt5.a.h(OfficeSelectionPlugin.TAG, "GetClipboardContentHandler data null");
            return;
        L27:
            ClipData r10 = ((fu5.a) org.koin.java.a.a(fu5.a.class)).k(r9.getEncryptId(), new Token(OfficeSelectionPlugin.WEB_GET_CLIPBOARD_TOKEN));     // Catch: Exception -> L24
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
            tt5.a.e(OfficeSelectionPlugin.TAG, "ClipboardGetHandler (): copy failed", e, false);
        }
    }

    public class g implements tb5.i {
        public final /* synthetic */ OfficeSelectionPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public g(OfficeSelectionPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            tt5.a.h(OfficeSelectionPlugin.TAG, "paste");
            this.a.getWeb().getWebView().dispatchKeyEvent(new KeyEvent(0, 279));
        }
    }

    public class h implements tb5.i<String> {
        public final /* synthetic */ OfficeSelectionPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public h(OfficeSelectionPlugin r1) {
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
            tt5.a.h(OfficeSelectionPlugin.TAG, r6.toString());
            String r7 = "";
            if (r5 == null) goto L10;
            r7 = new org.json.JSONObject(r5).optString("content", "");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            tt5.a.j(OfficeSelectionPlugin.TAG, th);
            return;
        L10:
            if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.docx.keyword_search") == false) goto L12;
            ((a4c.a) e0c.k.a(LarkContext.getApplication(), a4c.a.class)).b(this.a.getWeb().getWebView().getContext(), r7);     // Catch: Throwable -> L14
            tt5.a.h(OfficeSelectionPlugin.TAG, "SearchWebMenuClickHandler ret: false");     // Catch: Throwable -> L14
            OfficeSelectionPlugin.access$1100(this.a, r7);     // Catch: Throwable -> L14
            return;
        L12:
            OfficeSelectionPlugin.access$1100(this.a, r7);     // Catch: Throwable -> L14
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    public class i implements tb5.i<ClipboardContent> {
        public final /* synthetic */ OfficeSelectionPlugin a;

        @Override // tb5.i, tb5.o
        public final BridgeAuthType authType() {
            return BridgeAuthType.Private;
        }

        public i(OfficeSelectionPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, tb5.m r5) {
            ClipboardContent r6 = (ClipboardContent) r4;
            if (r6 == null) goto L5;
            OfficeSelectionPlugin.access$1500(this.a, r6.getText(), r6.getHtml(), r6.getEncryptId(), r6.isProtect());
            return;
        L5:
            tt5.a.d(OfficeSelectionPlugin.TAG, "SetClipboardContentHandler data null");
        }
    }

    public class j implements tb5.i<ClipboardEncrypt> {
        public final /* synthetic */ OfficeSelectionPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public j(OfficeSelectionPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, tb5.m r5) {
            ClipboardEncrypt r6 = (ClipboardEncrypt) r4;
            if (CCMOfficeSDKAssembleFG.a() == false) goto L33;
            HashMap<String, String> r7 = r6.getEncryptIds();
            if (r7 == null) goto L31;
            tt5.a.h(OfficeSelectionPlugin.TAG, "SetClipboardEncryptIdHandler:" + r7.size());
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docs.synced_block.permission.authentication") == true) goto L10;
        L12:
            boolean r8 = false;
        L13:
            if (r8 == false) goto L15;
            String r9 = this.a.getDocViewModel().getOriginBearUrl().b;
        L17:
            if (r7.containsKey(r9) == false) goto L19;
            String r10 = r7.get(r9);
            OfficeSelectionPlugin.access$1600(this.a, r10);
            this.a.getDocViewModel().setDocEncryptId(r10);
        L19:
            ArrayList r11 = new ArrayList();
            Iterator<Map.Entry<String, String>> r12 = r7.entrySet().iterator();
        L21:
            if (r12.hasNext() == false) goto L23;
            Map.Entry<String, String> r0 = r12.next();
            BlockInfo r1 = new BlockInfo(r0.getKey());
            r1.setEncryptId(r0.getValue());
            r11.add(r1);
            goto L21
        L23:
            this.a.referList.addAll(r11);
            w05.i r13 = ((w05.b) this.a.getHost().getHostAbility(w05.b.class)).getDocumentInfoProvider();
            DocumentInfo r14 = (DocumentInfo) r13.g().getValue();
            if (r14 == null) goto L26;
            r14.updateBlockInfo(this.a.referList);
            this.a.getDocViewModel().notifyBlockInfoUpdate();
        L26:
            DocumentInfo r16 = (DocumentInfo) r13.k().getValue();
            if (r16 == null) goto L32;
            r16.updateBlockInfo(this.a.referList);
            return;
        L32:
            return;
        L15:
            r9 = this.a.getDocViewModel().getToken();
            goto L17
        L10:
            if (this.a.getDocViewModel().isSyncBlock() == false) goto L12;
            r8 = true;
            goto L13
        L31:
            return;
        }
    }

    public class k implements tb5.i<String> {
        public final /* synthetic */ OfficeSelectionPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public k(OfficeSelectionPlugin r1) {
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
            tt5.a.h(OfficeSelectionPlugin.TAG, r8.toString());
            String r9 = "";
            if (r7 != null) goto L19;
            String r10 = "";
        L12:
            OfficeSelectionPlugin r1 = this.a;     // Catch: Throwable -> L9
            if ((r1 instanceof OfficeSelectionPluginNew) == false) goto L15;
            r9 = ((OfficeSelectionPluginNew) r1).getShareTitle();     // Catch: Throwable -> L9
        L15:
            Intent r2 = new Intent("android.intent.action.SEND");     // Catch: Throwable -> L9
            r2.addFlags(268435456);     // Catch: Throwable -> L9
            r2.putExtra("android.intent.extra.TEXT", r10);     // Catch: Throwable -> L9
            r2.setType("text/plain");     // Catch: Throwable -> L9
            Intent r11 = Intent.createChooser(r2, r9);     // Catch: Throwable -> L9
            r11.addFlags(268435456);     // Catch: Throwable -> L9
            this.a.getWeb().getWebView().getContext().startActivity(r11);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            tt5.a.j(OfficeSelectionPlugin.TAG, th);
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
        NEW_SELECTION_SUPPORT_TYPES = new sbb.e[]{sbb.e.g, sbb.e.h, sbb.e.m, sbb.e.n, sbb.e.o, sbb.e.i};
    }

    public static /* synthetic */ void a(OfficeSelectionPlugin r0, DocumentInfo r1) {
        r0.lambda$registerDocumentInfoObserver$2(r1);
    }

    public static /* synthetic */ void c(OfficeSelectionPlugin r0, String r1) {
        r0.lambda$getMenuItemClickListener$0(r1);
    }

    public static /* synthetic */ void d(OfficeSelectionPlugin r0, DocumentInfo r1) {
        r0.lambda$registerDocumentInfoObserver$1(r1);
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public abstract void clearSelection();

    @Override // vz4.d, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public abstract /* synthetic */ void closeActionMode();

    @Override // com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public abstract boolean isShowingActionMode();

    @Override // com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public /* synthetic */ void jsClearDocxSelection() {
        BaseSelectionPlugin.CC.$default$jsClearDocxSelection(this);
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public abstract void setSelectionScrollEndRate(float r1);

    public boolean shouldEnableTextIntentItems() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        getDocViewModel().liveOfflineDocumentInfoData().observe(getLifecycleOwner(), new com.bytedance.ee.bear.document.plugin.selection.f(this));
    L11:
        if (getDocViewModel() != null) goto L13;
        return;
    L13:
        if (getDocViewModel().liveDocumentInfoData() == null) goto L19;
        getDocViewModel().liveDocumentInfoData().observe(getLifecycleOwner(), new com.bytedance.ee.bear.document.plugin.selection.g(this));
        return;
    }

    public ActionMode.Callback getActionModeDelegate() {
        return new a(this);
    }

    public com.bytedance.ee.bear.document.plugin.selection.d getMenuItemClickListener() {
        return new com.bytedance.ee.bear.document.plugin.selection.e(this);
    }

    public OfficeSelectionPlugin() {
        this.selectionHandleViewHelper = new q();
        this.fallbackEnable = false;
        this.BIZ_SELECT_CLOSE_HANDLER = "window.lark.biz.util.onContextMenuClose";
        this.BIZ_CLIPBOARD_SET_CONTENT = "biz.clipboard.setContent";
        this.BIZ_CLIPBOARD_GET_CONTENT = "biz.clipboard.getContent";
        this.BIZ_CLIPBOARD_SET_ENCRYPT_ID = "biz.clipboard.setEncryptId";
        this.webChromeClient = null;
        this.menuItemClickListeners = new CopyOnWriteArrayList();
        this.referList = new CopyOnWriteArrayList();
        this.mObservers = new ArrayList();
    }

    private void reportCopyEvent() {
        if (CCMOfficeSDKAssembleFG.a() == true) goto L6;
        return;
    L6:
        if (getDocViewModel().getDocumentInfoData() == null) goto L8;
        boolean r0 = getDocViewModel().getDocumentInfoData().getDocPermission().a.isCopyAuthByLeader();
    L9:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).j0();
        jg5.k.a.a.d(r0, true);
        return;
    L8:
        r0 = false;
        goto L9
    }

    @Override // vz4.d
    public String getDocEncryptId() {
        if (CCMOfficeSDKAssembleFG.a() == true) goto L7;
        return null;
    L7:
        return getDocViewModel().getDocEncryptId();
    }

    public static /* synthetic */ List access$000(OfficeSelectionPlugin r0) {
        return r0.mObservers;
    }

    public static /* synthetic */ String access$100(OfficeSelectionPlugin r0) {
        return r0.BIZ_SELECT_CLOSE_HANDLER;
    }

    public static /* synthetic */ Runnable access$1200(OfficeSelectionPlugin r0) {
        return r0.fallbackRunnable;
    }

    public static OfficeSelectionPlugin create(PluginHost r1) {
        boolean r2 = enableNewSelection((e4) r1.getHostAbility(e4.class));
        enableNewSelection = r2;
        if (r2 == false) goto L7;
        return new OfficeSelectionPluginNew();
    L7:
        return new OfficeSelectionPluginCompat();
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

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        super.getBridgeHandlers(r3);
        if (com.larksuite.framework.utils.x.b() == false) goto L5;
    L7:
        r3.put("biz.navigation.handleCopyMenuClick", new d(this));
        r3.put("biz.navigation.handleCutMenuClick", new e(this));
        r3.put("biz.navigation.handlePasteMenuClick", new g(this));
        r3.put("biz.clipboard.setContent", new i(this));
        r3.put("biz.clipboard.getContent", new f());
        r3.put("biz.clipboard.setEncryptId", new j(this));
        r3.put("biz.navigation.handleSearchWebMenuClick", new h(this));
        r3.put("biz.navigation.handleShareMenuClick", new k(this));
        return;
    L5:
        if (enableNewSelection == true) goto L7;
    }

    public void onAttachToHost(ChameleonPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        r2.registerHostAbility(this);
        if ((r2.getWeb().getWebView() instanceof ChameleonWebView) == false) goto L5;
        this.webChromeClient = new com.bytedance.ee.bear.document.plugin.selection.b();
        tt5.a.b(TAG, "addWebChromeClientDelegate");
        getWeb().addWebChromeClientDelegate(this.webChromeClient);
        return;
    L5:
        this.webChromeClient = null;
    }

    public void onDetachFromHost(ChameleonPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
        r2.unregisterHostAbility(this);
        this.mObservers.clear();
        if (this.webChromeClient == null) goto L6;
        getWeb().removeWebChromeClientDelegate(this.webChromeClient);
        this.webChromeClient = null;
        return;
    }

    public void onStart(ChameleonPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onStart(r3);
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

    @Override // com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onStart(PluginHost r1) {
        onStart((ChameleonPluginHost) r1);
    }

    public static /* synthetic */ void access$1000(OfficeSelectionPlugin r0, tb5.m r1) {
        r0.notifyJsCopyFinish(r1);
    }

    public static /* synthetic */ void access$1100(OfficeSelectionPlugin r0, String r1) {
        r0.searchWeb(r1);
    }

    public static /* synthetic */ void access$1600(OfficeSelectionPlugin r0, String r1) {
        r0.updateEncryptId(r1);
    }

    private void copyCallback(fu5.a r3, tb5.m r4) {
        JSONObject r0 = new JSONObject();
        r0.put("success", r3.f());
        r4.b(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(ChameleonPluginHost r4, com.bytedance.ee.bear.browser.plugin.t r5) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r4, r5);
        q r6 = this.selectionHandleViewHelper;
        ChameleonWebView r0 = r4.getWeb().getWebView();
        r6.f = r0;
        r6.f.x(r6.l);
        r6.g = new GestureDetector(r0.getContext(), new o(r6));
        r4.getWeb().addOnTouchListener(this.selectionHandleViewHelper);
        pcb.a.a.b(getActivity()).c(this.selectionHandleViewHelper);
        if (com.larksuite.framework.utils.x.b() == false) goto L5;
    L7:
        pcb.a.a.b(getActivity()).c(this);
        this.fallbackEnable = com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.doc_copy_fallback", false);
        if (CCMOfficeSDKAssembleFG.a() == false) goto L11;
        registerDocumentInfoObserver();
        return;
    L11:
        return;
    L5:
        if (enableNewSelection == true) goto L7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromUIContainer(ChameleonPluginHost r3, com.bytedance.ee.bear.browser.plugin.t r4) {
        pcb.a.a.b(getActivity()).a(this.selectionHandleViewHelper);
        r3.getWeb().removeOnTouchListener(this.selectionHandleViewHelper);
        q r0 = this.selectionHandleViewHelper;
        com.bytedance.ee.util.ui.j.e(r0.j);
        com.bytedance.ee.util.ui.j.e(r0.k);
        r0.f.B(r0.l);
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r3, r4);
        if (com.larksuite.framework.utils.x.b() == false) goto L5;
    L7:
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).d(this.clipboardListener);
        pcb.a.a.b(getActivity()).a(this);
        return;
    L5:
        if (enableNewSelection == true) goto L7;
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }

    public static /* synthetic */ void access$1300(OfficeSelectionPlugin r0, fu5.a r1, tb5.m r2) {
        r0.copyCallback(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onKeyboardHeightChanged(pcb.a r2, int r3, int r4) {
        if (com.larksuite.framework.utils.x.b() == false) goto L5;
    L7:
        if (r3 <= 0) goto L9;
        boolean r5 = true;
    L10:
        float r6 = (1.0f - ((r3 + getResources().getDimension(2131165742)) / getHost().getWeb().getWebView().getHeight())) - 0.13f;
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

    private void finallySetClipboardContentData(String r4, String r5, String r6, boolean r7) {
        fu5.a r0 = (fu5.a) org.koin.java.a.a(fu5.a.class);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.g(r6, ClipData.newHtmlText("", new SpannableString(r4), r5), r7, new Token(WEB_SET_CLIPBOARD_TOKEN));
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

    public static /* synthetic */ void access$1400(OfficeSelectionPlugin r0, String r1, String r2, String r3, boolean r4) {
        r0.finallySetClipboardContentData(r1, r2, r3, r4);
    }

    public static /* synthetic */ void access$1500(OfficeSelectionPlugin r0, String r1, String r2, String r3, boolean r4) {
        r0.setClipboardContentData(r1, r2, r3, r4);
    }
}
