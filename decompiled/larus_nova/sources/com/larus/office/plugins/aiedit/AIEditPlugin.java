package com.larus.office.plugins.aiedit;

import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.network.http.HttpExtKt;
import com.larus.office.IOfficeSdkService;
import com.larus.office.plugins.input.k1;
import com.larus.office.plugins.input.l1;
import com.larus.office.plugins.input.m1;
import com.larus.office.plugins.input.n1;
import com.larus.office.plugins.input.r1;
import com.larus.office.plugins.input.s1;
import com.larus.office.plugins.input.t1;
import com.larus.office.plugins.mode.DocMode;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import go9.g;
import go9.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0006DEFGHIB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0014\u001a\u00020\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u0017H\u0016J\u001c\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001c\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001f\u001a\u00020\u00152\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150!J\u0006\u0010\"\u001a\u00020\u0015J\u0006\u0010#\u001a\u00020\u0015J\u000e\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\tJ\u0016\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\tJ\b\u0010,\u001a\u00020\u0015H\u0016J\u000e\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u000bJ\u0006\u0010/\u001a\u00020\u0015J\u0018\u00100\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u000101J\b\u00102\u001a\u0004\u0018\u00010\u0006J\u0006\u00103\u001a\u00020\u0015J\b\u00104\u001a\u00020\u0015H\u0002J\n\u00105\u001a\u0004\u0018\u00010\u000fH\u0002J\u000f\u00106\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0002\b7J\u000f\u00108\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b9J\u000f\u0010:\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0002\b;J\u0010\u0010<\u001a\u00020\u00152\b\u0010=\u001a\u0004\u0018\u00010\rJ\b\u0010>\u001a\u0004\u0018\u00010\u0006J\u001a\u0010?\u001a\u00020\u00152\b\u0010@\u001a\u0004\u0018\u00010\u00062\b\u0010A\u001a\u0004\u0018\u00010\u0006J\b\u0010B\u001a\u00020\u0015H\u0002J\u000e\u0010C\u001a\u00020\u0006*\u0004\u0018\u00010\u0006H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/larus/office/plugins/aiedit/AIEditPlugin;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "Lcom/larus/office/IReferenceClearListener;", "<init>", "()V", "selectedText", "", "selectedWholeText", "shouldShowBackFunction", "", "currentDocMode", "Lcom/larus/office/plugins/mode/DocMode;", "selectedData", "Lcom/larus/office/plugins/aiedit/SelectChangeData;", "aiChatPlugin", "Lcom/larus/office/plugins/input/OfficeAIChatDocxContract;", "sheetAIChatPlugin", "Lcom/larus/office/plugins/input/OfficeAIChatSheetContract;", "slidesAIChatPlugin", "Lcom/larus/office/plugins/input/OfficeAIChatSlidesContract;", "getBridgeHandlers", "", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToUIContainer", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "enterStreamEditMode", "callback", "Lkotlin/Function1;", "startStreamEdit", "notifyTrackInfoUpdated", "streamEditTextContent", "content", "endStreamEdit", "cancelStreaming", "leaveStreamEditMode", "scene", "", "restoreSelection", "onReferenceCleared", "setCurrentDocMode", "docMode", "enterStreamEditIfNeeded", "getSelectedText", "Lkotlin/Pair;", "getRefBlockInfo", "clearReferenceCache", "resetAiEditState", "getAIChatPlugin", "findDocxAIChatContract", "findDocxAIChatContract$impl_mainlandRelease", "findSheetAIChatContract", "findSheetAIChatContract$impl_mainlandRelease", "findSlidesAIChatContract", "findSlidesAIChatContract$impl_mainlandRelease", "updateSelectedData", "data", "getCachedSelectedText", "updateSelectedText", "text", "wholeText", "setToAiEdit", "safeLogId", "Companion", "AIEditBreakStreamHandler", "AIEditMenuClickHandler", "AIEditStateHandler", "AIEditModeChangedHandler", "GetAIEditStateHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIEditPlugin extends OfficeDocumentPlugin implements com.larus.office.d {
    private static final int AI_EDIT_STATE_DEFAULT = 0;
    private static final int AI_EDIT_STATE_REWRITING = 2;
    private static final int AI_EDIT_STATE_THINKING = 1;
    private static final String BIZ_AIEDIT_BREAK_STREAM = "biz.aiEdit.breakStream";
    private static final String BIZ_AI_EDIT_MODE_CHANGED = "biz.notify.aiEditModeChanged";
    private static final String BIZ_DOUBAO_MENU_CLICK = "biz.navigation.handleDoubaoMenuClick";
    private static final String BIZ_GET_AI_EDIT_STATE = "biz.util.getAIEditState";
    private static final String BIZ_SELECT_TEXT_CHANGED = "biz.notify.selectChange";
    private static final String BIZ_SHEET_SELECTION = "biz.notify.sheetSelectChange";
    private static final String BIZ_SLIDES_SELECTION = "biz.notify.onSlidesSelectionChange";
    private static final String BIZ_UPDATE_AI_EDIT_STATE = "biz.util.updateAIEditState";
    public static final e Companion = null;
    private static final String DEBUG_TAG = "OfficePluginDebug";
    private static final String FUNC_CLEAR_REFERENCE = "javascript:window.flow.biz.util.clearReference";
    private static final String FUNC_END_STREAM_EDIT = "javascript:window.flow.biz.aiEdit.endStreamEdit";
    private static final String FUNC_ENTER_STREAM_EDIT_MODE = "javascript:window.flow.biz.aiEdit.enterStreamEditMode";
    private static final String FUNC_LEAVE_STREAM_EDIT_MODE = "javascript:window.flow.biz.aiEdit.leaveStreamEditMode";
    private static final String FUNC_START_STREAM_EDIT = "javascript:window.flow.biz.aiEdit.startStreamEdit";
    private static final String FUNC_STREAM_EDIT_TEXT_CONTENT = "javascript:window.flow.biz.aiEdit.streamEditTextContent";
    private static final String FUNC_UPDATE_TRACK_INFO = "javascript:window.flow.biz.util.updateTrackInfo";
    private static final String JSB_TAG = "OfficeJSB";
    private static final String JS_FUNC_PREFIX = "javascript:window.flow.";
    public static final String TAG = "AIEditPlugin";
    private m1 aiChatPlugin;
    private DocMode currentDocMode;
    private SelectChangeData selectedData;
    private String selectedText;
    private String selectedWholeText;
    private r1 sheetAIChatPlugin;
    private boolean shouldShowBackFunction;
    private s1 slidesAIChatPlugin;

    public final class a implements i<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AIEditPlugin f362319a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(AIEditPlugin r100) {
            this.f362319a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            Void r102 = (Void) r100;
            FLogger r103 = FLogger.f375446a;
            StringBuilder r104 = new StringBuilder("[AIEditPlugin] handle breakStream hasAIChat=");
            boolean r105 = false;
            if (AIEditPlugin.access$getAiChatPlugin$p(this.f362319a) == null) goto L5;
            boolean r106 = true;
        L6:
            r104.append(r106);
            r103.i(AIEditPlugin.DEBUG_TAG, r104.toString());
            StringBuilder r107 = new StringBuilder("FE->Native biz.aiEdit.breakStream source=AIEditPlugin hasCallback=");
            if (r101 == null) goto L9;
            r105 = true;
        L9:
            r107.append(r105);
            r103.i(AIEditPlugin.JSB_TAG, r107.toString());
            m1 r108 = AIEditPlugin.access$getAiChatPlugin$p(this.f362319a);
            if (r108 == null) goto L12;
            r108.notifyInterruptConversation();
        L12:
            if (r101 == null) goto L15;
            r101.b(new JSONObject());
            return;
        L15:
            return;
        L5:
            r106 = false;
            goto L6
        }
    }

    public final class b implements i<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AIEditPlugin f362320a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(AIEditPlugin r100) {
            this.f362320a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            FLogger r102 = FLogger.f375446a;
            r102.i(AIEditPlugin.DEBUG_TAG, "[AIEditPlugin] handle doubaoMenuClick data=" + r100);
            StringBuilder r103 = new StringBuilder("FE->Native biz.navigation.handleDoubaoMenuClick source=AIEditPlugin hasCallback=");
            if (r101 == null) goto L5;
            boolean r104 = true;
        L6:
            r103.append(r104);
            r102.i(AIEditPlugin.JSB_TAG, r103.toString());
            this.f362320a.enterStreamEditMode(new go9.d());
            final AIEditPlugin r105 = this.f362320a;
            t0.d(new go9.e(r105), 100);
            return;
        L5:
            r104 = false;
            goto L6
        }
    }

    public final class c implements i<AIEditModeChangedData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AIEditPlugin f362321a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(AIEditPlugin r100) {
            this.f362321a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            AIEditModeChangedData r102 = (AIEditModeChangedData) r100;
            FLogger r103 = FLogger.f375446a;     // Catch: Exception -> L28
            StringBuilder r104 = new StringBuilder("[AIEditPlugin] handle aiEditModeChanged mode=");     // Catch: Exception -> L28
            Integer r105 = null;
            if (r102 == null) goto L6;
            Integer r106 = r102.getMode();     // Catch: Exception -> L28
        L7:
            r104.append(r106);     // Catch: Exception -> L28
            r104.append(" data=");     // Catch: Exception -> L28
            r104.append(r102);     // Catch: Exception -> L28
            r103.i(AIEditPlugin.DEBUG_TAG, r104.toString());     // Catch: Exception -> L28
            StringBuilder r107 = new StringBuilder("FE->Native biz.notify.aiEditModeChanged source=AIEditPlugin mode=");     // Catch: Exception -> L28
            if (r102 == null) goto L10;
            r105 = r102.getMode();     // Catch: Exception -> L28
        L10:
            r107.append(r105);     // Catch: Exception -> L28
            r107.append(" hasCallback=");     // Catch: Exception -> L28
            boolean r108 = true;
            if (r101 == null) goto L13;
            boolean r109 = true;
        L14:
            r107.append(r109);     // Catch: Exception -> L28
            r103.i(AIEditPlugin.JSB_TAG, r107.toString());     // Catch: Exception -> L28
            if (r102 == null) goto L22;
            Integer r110 = r102.getMode();     // Catch: Exception -> L28
            if (r110 == null) goto L22;
            if (r110.intValue() != 1) goto L22;
        L23:
            if (r108 == false) goto L33;
            m1 r111 = AIEditPlugin.access$getAIChatPlugin(this.f362321a);     // Catch: Exception -> L28
            if (r111 == null) goto L34;
            r111.markAiEditTriggeredForCurrentAnswer("aiEditModeChanged", false);     // Catch: Exception -> L28
            return;
        L34:
            return;
        L33:
            return;
        L22:
            r108 = false;
            goto L23
        L13:
            r109 = false;
            goto L14
        L6:
            r106 = null;
        L28:
            e = move-exception;
            FLogger.f375446a.e(AIEditPlugin.TAG, "handle aiEditModeChanged failed: " + e.getMessage());
        }
    }

    public final class d implements i<DocStateData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AIEditPlugin f362322a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(AIEditPlugin r100) {
            this.f362322a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r110, m r111) {
            DocStateData r112 = (DocStateData) r110;
            FLogger r100 = FLogger.f375446a;     // Catch: Exception -> L34
            StringBuilder r101 = new StringBuilder("[AIEditPlugin] handle updateAIEditState state=");     // Catch: Exception -> L34
            Integer r102 = null;
            if (r112 == null) goto L6;
            Integer r103 = r112.getState();     // Catch: Exception -> L34
        L7:
            r101.append(r103);     // Catch: Exception -> L34
            r101.append(" data=");     // Catch: Exception -> L34
            r101.append(r112);     // Catch: Exception -> L34
            r100.i(AIEditPlugin.DEBUG_TAG, r101.toString());     // Catch: Exception -> L34
            StringBuilder r104 = new StringBuilder("FE->Native biz.util.updateAIEditState source=AIEditPlugin state=");     // Catch: Exception -> L34
            if (r112 == null) goto L10;
            r102 = r112.getState();     // Catch: Exception -> L34
        L10:
            r104.append(r102);     // Catch: Exception -> L34
            r104.append(" hasCallback=");     // Catch: Exception -> L34
            if (r111 == null) goto L13;
            boolean r113 = true;
        L14:
            r104.append(r113);     // Catch: Exception -> L34
            r100.i(AIEditPlugin.JSB_TAG, r104.toString());     // Catch: Exception -> L34
            if (r112 == null) goto L38;
            Integer r114 = r112.getState();     // Catch: Exception -> L34
            if (r114 == null) goto L39;
            AIEditPlugin r115 = this.f362322a;     // Catch: Exception -> L34
            int r116 = r114.intValue();     // Catch: Exception -> L34
            r100.i(AIEditPlugin.TAG, "handleLoadingDocState state: " + r116);     // Catch: Exception -> L34
            m1 r105 = AIEditPlugin.access$getAIChatPlugin(r115);     // Catch: Exception -> L34
            if (r116 == 0) goto L29;
            if (r116 != 1) goto L22;
            if (r105 == null) goto L42;
            r105.updateLoadingDocState(r116);     // Catch: Exception -> L34
            return;
        L42:
            return;
        L22:
            if (r116 == 2) goto L24;
            r100.i(AIEditPlugin.TAG, "handleLoadingDocState ignored, unknown state=" + r116);     // Catch: Exception -> L34
            return;
        L24:
            if (r105 == null) goto L26;
            r105.updateLoadingDocState(r116);     // Catch: Exception -> L34
        L26:
            r115.notifyTrackInfoUpdated();     // Catch: Exception -> L34
            return;
        L29:
            if (r105 == null) goto L31;
            r105.updateLoadingDocState(r116);     // Catch: Exception -> L34
        L31:
            if (r105 == null) goto L44;
            r105.onAIEditStateIdle();     // Catch: Exception -> L34
            return;
        L44:
            return;
        L39:
            return;
        L38:
            return;
        L13:
            r113 = false;
            goto L14
        L6:
            r103 = null;
        L34:
            e = move-exception;
            FLogger.f375446a.e(AIEditPlugin.TAG, "handleLoadingDocState failed: " + e.getMessage());
        }
    }

    public static final class e {
        public e() {
        }
    }

    public final class f implements i<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AIEditPlugin f362323a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public f(AIEditPlugin r100) {
            this.f362323a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            m1 r102 = AIEditPlugin.access$getAIChatPlugin(this.f362323a);
            boolean r103 = false;
            if (r102 == null) goto L5;
            int r104 = r102.getAIEditState();
        L6:
            FLogger r105 = FLogger.f375446a;
            StringBuilder r106 = new StringBuilder("FE->Native biz.util.getAIEditState source=AIEditPlugin returnState=");
            r106.append(r104);
            r106.append(" hasCallback=");
            if (r101 == null) goto L9;
            r103 = true;
        L9:
            r106.append(r103);
            r105.i(AIEditPlugin.JSB_TAG, r106.toString());
            if (r101 == null) goto L13;
            JSONObject r107 = new JSONObject();
            r107.put2("state", Integer.valueOf(r104));
            r101.b(r107);
            return;
        L13:
            return;
        L5:
            r104 = 0;
            goto L6
        }
    }

    static {
        Companion = new e();
    }

    public static /* synthetic */ Unit a(String r100) {
        return enterStreamEditIfNeeded$lambda$12(r100);
    }

    public static /* synthetic */ void c(AIEditPlugin r100) {
        onReferenceCleared$lambda$11(r100);
    }

    public static /* synthetic */ void d(Function1 r100, String r101) {
        enterStreamEditMode$lambda$1$lambda$0(r100, r101);
    }

    private final void resetAiEditState() {
        this.selectedText = null;
        this.selectedWholeText = null;
        this.selectedData = null;
    }

    @Override // com.bytedance.ee.bear.document.OfficeDocumentPlugin, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private final m1 getAIChatPlugin() {
        if (this.aiChatPlugin != null) goto L6;
        this.aiChatPlugin = n1.a(getHost());
    L6:
        return this.aiChatPlugin;
    }

    public final void enterStreamEditIfNeeded() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("enterStreamEditIfNeeded, selectedText length: ");
        String r102 = this.selectedText;
        if (r102 == null) goto L5;
        Integer r103 = Integer.valueOf(r102.length());
    L6:
        r101.append(r103);
        r101.append(", current doc mode: ");
        r101.append(this.currentDocMode);
        r100.i(TAG, r101.toString());
        StringBuilder r104 = new StringBuilder("[AIEditPlugin] enterStreamEditIfNeeded selectedLength=");
        String r105 = this.selectedText;
        if (r105 == null) goto L9;
        int r106 = r105.length();
    L10:
        r104.append(r106);
        r104.append(" currentDocMode=");
        r104.append(this.currentDocMode);
        r100.i(DEBUG_TAG, r104.toString());
        if (TextUtils.isEmpty(this.selectedText) == false) goto L13;
        return;
    L13:
        if (this.currentDocMode == DocMode.AI_EDIT) goto L17;
        this.shouldShowBackFunction = false;
        enterStreamEditMode(new go9.b());
        return;
    L17:
        return;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final r1 findSheetAIChatContract$impl_mainlandRelease() {
        if (this.sheetAIChatPlugin != null) goto L10;
        ChameleonPluginHost r100 = getHost();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        k1 r101 = l1.a(r100);
        if ((r101 instanceof r1) == false) goto L7;
        r1 r102 = (r1) r101;
    L8:
        this.sheetAIChatPlugin = r102;
        goto L10
    L7:
        r102 = null;
    L10:
        return this.sheetAIChatPlugin;
    }

    public final s1 findSlidesAIChatContract$impl_mainlandRelease() {
        if (this.slidesAIChatPlugin != null) goto L6;
        this.slidesAIChatPlugin = t1.a(getHost());
    L6:
        return this.slidesAIChatPlugin;
    }

    public final String getRefBlockInfo() {
        SelectChangeData r100 = this.selectedData;
        if (r100 == null) goto L5;
        SelectedContent r101 = r100.getSelectedContent();
    L6:
        if (r101 == null) goto L12;
        SelectChangeData r102 = this.selectedData;
        if (r102 == null) goto L10;
        PositionPoint r103 = r102.getCursorPosition();
    L11:
        if (r103 == null) goto L12;
        return null;
    L10:
        r103 = null;
    L12:
        SelectChangeData r104 = this.selectedData;
        if (r104 != null) goto L15;
        return null;
    L15:
        return HttpExtKt.p(r104);
    L5:
        r101 = null;
        goto L6
    }

    public final Pair<String, String> getSelectedText() {
        return new Pair(this.selectedText, this.selectedWholeText);
    }

    public final void notifyTrackInfoUpdated() {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L13
        m1 r101 = getAIChatPlugin();     // Catch: Exception -> L13
        if (r101 == null) goto L6;
        String r102 = r101.getLatestDocMessageId();     // Catch: Exception -> L13
    L7:
        r100.put2(MusicAppletPage.KEY_MESSAGE_ID, r102);     // Catch: Exception -> L13
        FLogger r103 = FLogger.f375446a;     // Catch: Exception -> L13
        r103.i(DEBUG_TAG, "[AIEditPlugin] notifyTrackInfoUpdated messageId=" + safeLogId(r100.getString(MusicAppletPage.KEY_MESSAGE_ID)));     // Catch: Exception -> L13
        k r104 = getHost().getWeb();     // Catch: Exception -> L13
        if (r104 == null) goto L18;
        WebView r105 = r104.getWebView();     // Catch: Exception -> L13
        if (r105 == null) goto L19;
        r103.i(JSB_TAG, "Native->FE biz.util.updateTrackInfo source=AIEditPlugin messageId=" + safeLogId(r100.getString(MusicAppletPage.KEY_MESSAGE_ID)));     // Catch: Exception -> L13
        ap5.a.a(r105, FUNC_UPDATE_TRACK_INFO, r100, null);     // Catch: Exception -> L13
        return;
    L19:
        return;
    L18:
        return;
    L6:
        r102 = null;
    L13:
        e = move-exception;
        FLogger.f375446a.e(TAG, e.getMessage(), e);
    }

    public final void startStreamEdit() {
        FLogger r100 = FLogger.f375446a;
        r100.i(DEBUG_TAG, "[AIEditPlugin] startStreamEdit");
        m1 r101 = getAIChatPlugin();
        if (r101 == null) goto L5;
        r101.markAiEditTriggeredForCurrentAnswer("startStreamEdit", false);
    L5:
        k r102 = getHost().getWeb();
        if (r102 == null) goto L11;
        WebView r103 = r102.getWebView();
        if (r103 == null) goto L12;
        r100.i(JSB_TAG, "Native->FE biz.aiEdit.startStreamEdit source=AIEditPlugin");
        ap5.a.a(r103, FUNC_START_STREAM_EDIT, new JSONObject(), null);
        return;
    L12:
        return;
    }

    public AIEditPlugin() {
        this.shouldShowBackFunction = true;
    }

    private final void setToAiEdit() {
        m1 r100 = getAIChatPlugin();
        if (r100 == null) goto L6;
        r100.setToAiEdit();
        return;
    }

    public final m1 findDocxAIChatContract$impl_mainlandRelease() {
        return getAIChatPlugin();
    }

    @Override // com.larus.office.d
    public void onReferenceCleared() {
        resetAiEditState();
        m1 r100 = getAIChatPlugin();
        if (r100 == null) goto L5;
        r100.onReferenceCacheCleared("ai_edit_reference_cleared");
    L5:
        k r101 = getHost().getWeb();
        if (r101 == null) goto L10;
        WebView r102 = r101.getWebView();
        if (r102 == null) goto L10;
        FLogger.f375446a.i(JSB_TAG, "Native->FE biz.util.clearReference source=AIEditPlugin reason=onReferenceCleared");
        ap5.a.a(r102, FUNC_CLEAR_REFERENCE, new JSONObject(), null);
    L10:
        t0.d(new go9.a(this), 36);
    }

    public final void clearReferenceCache() {
        resetAiEditState();
    }

    public final String getCachedSelectedText() {
        return this.selectedText;
    }

    public static final /* synthetic */ m1 access$getAIChatPlugin(AIEditPlugin r100) {
        return r100.getAIChatPlugin();
    }

    public static final /* synthetic */ m1 access$getAiChatPlugin$p(AIEditPlugin r100) {
        return r100.aiChatPlugin;
    }

    public static final /* synthetic */ void access$setToAiEdit(AIEditPlugin r100) {
        r100.setToAiEdit();
    }

    private static final Unit enterStreamEditIfNeeded$lambda$12(String r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        FLogger.f375446a.i(TAG, "Entered stream edit mode");
        return Unit.INSTANCE;
    }

    private static final void onReferenceCleared$lambda$11(AIEditPlugin r100) {
        m1 r101 = r100.aiChatPlugin;
        if (r101 == null) goto L6;
        r101.notifyPanelHeightChanged();
        return;
    }

    private final String safeLogId(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L14;
        if (r100 != null) goto L11;
        return "null";
    L11:
        return "empty";
    L14:
        return "len=" + r100.length() + ",hash=" + r100.hashCode();
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public final void endStreamEdit(boolean r100) {
        FLogger r101 = FLogger.f375446a;
        r101.i(TAG, "endStreamEdit: " + r100 + ", isAiEditing");
        StringBuilder r102 = new StringBuilder("[AIEditPlugin] endStreamEdit cancelStreaming=");
        r102.append(r100);
        r101.i(DEBUG_TAG, r102.toString());
        k r103 = getHost().getWeb();
        if (r103 == null) goto L8;
        WebView r104 = r103.getWebView();
        if (r104 == null) goto L9;
        r101.i(JSB_TAG, "Native->FE biz.aiEdit.endStreamEdit source=AIEditPlugin cancelStreaming=" + r100);
        JSONObject r105 = new JSONObject();
        r105.put2("cancelStreaming", Boolean.valueOf(r100));
        Unit r106 = Unit.INSTANCE;
        ap5.a.a(r104, FUNC_END_STREAM_EDIT, r105, null);
        return;
    L9:
        return;
    }

    public final void enterStreamEditMode(final Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        FLogger r101 = FLogger.f375446a;
        r101.i(DEBUG_TAG, "[AIEditPlugin] enterStreamEditMode");
        r101.i(JSB_TAG, "Native->FE biz.aiEdit.enterStreamEditMode source=AIEditPlugin");
        k r102 = getHost().getWeb();
        if (r102 == null) goto L8;
        WebView r103 = r102.getWebView();
        if (r103 == null) goto L9;
        ap5.a.a(r103, FUNC_ENTER_STREAM_EDIT_MODE, new JSONObject(), new go9.c(r100));
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        FLogger.f375446a.i(DEBUG_TAG, "[AIEditPlugin] registerBridgeHandlers handlers=biz.notify.selectChange,biz.notify.sheetSelectChange,biz.notify.onSlidesSelectionChange,biz.aiEdit.breakStream,biz.navigation.handleDoubaoMenuClick,biz.util.updateAIEditState,biz.notify.aiEditModeChanged");
        r100.put(BIZ_SELECT_TEXT_CHANGED, new go9.f(this));
        r100.put(BIZ_SHEET_SELECTION, new g(this));
        r100.put(BIZ_SLIDES_SELECTION, new h(this));
        r100.put(BIZ_AIEDIT_BREAK_STREAM, new a(this));
        r100.put(BIZ_DOUBAO_MENU_CLICK, new b(this));
        r100.put(BIZ_UPDATE_AI_EDIT_STATE, new d(this));
        r100.put(BIZ_AI_EDIT_MODE_CHANGED, new c(this));
        r100.put(BIZ_GET_AI_EDIT_STATE, new f(this));
    }

    public final void setCurrentDocMode(DocMode r100) {
        Intrinsics.checkNotNullParameter(r100, "docMode");
        this.currentDocMode = r100;
        FLogger.f375446a.i(DEBUG_TAG, "[AIEditPlugin] setCurrentDocMode docMode=" + r100);
    }

    public final void streamEditTextContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        FLogger r101 = FLogger.f375446a;
        r101.i(DEBUG_TAG, "[AIEditPlugin] streamEditTextContent length=" + r100.length());
        k r102 = getHost().getWeb();
        if (r102 == null) goto L8;
        WebView r103 = r102.getWebView();
        if (r103 == null) goto L9;
        r101.i(JSB_TAG, "Native->FE biz.aiEdit.streamEditTextContent source=AIEditPlugin textLen=" + r100.length());
        JSONObject r104 = new JSONObject();
        r104.put2("text", r100);
        Unit r105 = Unit.INSTANCE;
        ap5.a.a(r103, FUNC_STREAM_EDIT_TEXT_CONTENT, r104, null);
        return;
    L9:
        return;
    }

    public final void updateSelectedData(SelectChangeData r100) {
        this.selectedData = r100;
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("[AIEditPlugin] updateSelectedData hasSelectedContent=");
        PositionPoint r103 = null;
        if (r100 == null) goto L5;
        SelectedContent r104 = r100.getSelectedContent();
    L6:
        boolean r105 = true;
        if (r104 == null) goto L9;
        boolean r106 = true;
    L10:
        r102.append(r106);
        r102.append(" hasCursor=");
        if (r100 == null) goto L13;
        r103 = r100.getCursorPosition();
    L13:
        if (r103 != null) goto L16;
        r105 = false;
    L16:
        r102.append(r105);
        r101.i(DEBUG_TAG, r102.toString());
        return;
    L9:
        r106 = false;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    private static final void enterStreamEditMode$lambda$1$lambda$0(Function1 r100, String r101) {
        if (r101 != null) goto L4;
        r101 = "";
    L4:
        r100.invoke(r101);
    }

    public final void leaveStreamEditMode(int r100, boolean r101) {
        FLogger r102 = FLogger.f375446a;
        r102.i(TAG, "leaveStreamEditMode, is_keyboard_showing: " + rcb.c.e(getHost().getActivity()));
        r102.i(DEBUG_TAG, "[AIEditPlugin] leaveStreamEditMode scene=" + r100 + " restoreSelection=" + r101 + " keyboard=" + rcb.c.e(getHost().getActivity()));
        k r103 = getHost().getWeb();
        if (r103 == null) goto L8;
        WebView r104 = r103.getWebView();
        if (r104 == null) goto L9;
        boolean r105 = rcb.c.e(getHost().getActivity());
        r102.i(JSB_TAG, "Native->FE biz.aiEdit.leaveStreamEditMode source=AIEditPlugin scene=" + r100 + " restoreSelection=" + r101 + " keyboard=" + r105);
        JSONObject r106 = new JSONObject();
        r106.put2("is_keyboard_showing", Boolean.valueOf(r105));
        r106.put2("scene", Integer.valueOf(r100));
        r106.put2("restoreSelection", Boolean.valueOf(r101));
        Unit r107 = Unit.INSTANCE;
        ap5.a.a(r104, FUNC_LEAVE_STREAM_EDIT_MODE, r106, null);
        return;
    L9:
        return;
    }

    public void onAttachToUIContainer(ChameleonPluginHost r100, t r101) {
        super.onAttachToUIContainer(r100, r101);
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("[AIEditPlugin] onAttachToUIContainer host=");
        if (r100 == null) goto L5;
        String r104 = r100.getClass().getSimpleName();
    L6:
        r103.append(r104);
        r102.i(DEBUG_TAG, r103.toString());
        IOfficeSdkService r105 = (IOfficeSdkService) ServiceManager.get().getService(IOfficeSdkService.class);
        if (r105 == null) goto L10;
        r105.e(this);
        return;
    L10:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r100, t r101) {
        super.onDetachFromUIContainer(r100, r101);
        FLogger.f375446a.i(DEBUG_TAG, "[AIEditPlugin] onDetachFromUIContainer");
        IOfficeSdkService r102 = (IOfficeSdkService) ServiceManager.get().getService(IOfficeSdkService.class);
        if (r102 == null) goto L6;
        r102.a(this);
        return;
    }

    public final void updateSelectedText(String r100, String r101) {
        this.selectedText = r100;
        this.selectedWholeText = r101;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("[AIEditPlugin] updateSelectedText selectedLength=");
        int r104 = 0;
        if (r100 == null) goto L5;
        int r105 = r100.length();
    L6:
        r103.append(r105);
        r103.append(" wholeLength=");
        if (r101 == null) goto L9;
        r104 = r101.length();
    L9:
        r103.append(r104);
        r102.i(DEBUG_TAG, r103.toString());
        return;
    L5:
        r105 = 0;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, t r101) {
        onAttachToUIContainer((ChameleonPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((ChameleonPluginHost) r100, r101);
    }
}
