package com.larus.doc.sdk.impl.generalbiz.rewrite;

import android.webkit.WebView;
import ap5.a;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.doc.sdk.impl.generalbiz.common.DocSdkVersion;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.util.SafeJSExecutor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import q39.b;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015J.\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010!\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/rewrite/PartialRewriteJsCaller;", "", "<init>", "()V", "TAG", "", "JS_FUNC_PREFIX", "FUNC_ENTER_STREAM_EDIT_MODE", "FUNC_LEAVE_STREAM_EDIT_MODE", "FUNC_START_STREAM_EDIT", "FUNC_STREAM_EDIT_TEXT_CONTENT", "FUNC_END_STREAM_EDIT", "FUNC_CLEAR_REFERENCE", "FUNC_UPDATE_TRACK_INFO", "enterStreamEditMode", "", "webView", "Landroid/webkit/WebView;", "callback", "Lkotlin/Function1;", "docSdkVersion", "Lcom/larus/doc/sdk/impl/generalbiz/common/DocSdkVersion;", "startStreamEdit", "streamEditTextContent", "content", "endStreamEdit", "cancelStreaming", "", "leaveStreamEditMode", "scene", "", "restoreSelection", "isKeyboardShowing", "clearReference", "notifyTrackInfoUpdate", "info", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PartialRewriteJsCaller {
    private static final String FUNC_CLEAR_REFERENCE = "javascript:window.flow.biz.util.clearReference";
    private static final String FUNC_END_STREAM_EDIT = "javascript:window.flow.biz.aiEdit.endStreamEdit";
    private static final String FUNC_ENTER_STREAM_EDIT_MODE = "javascript:window.flow.biz.aiEdit.enterStreamEditMode";
    private static final String FUNC_LEAVE_STREAM_EDIT_MODE = "javascript:window.flow.biz.aiEdit.leaveStreamEditMode";
    private static final String FUNC_START_STREAM_EDIT = "javascript:window.flow.biz.aiEdit.startStreamEdit";
    private static final String FUNC_STREAM_EDIT_TEXT_CONTENT = "javascript:window.flow.biz.aiEdit.streamEditTextContent";
    private static final String FUNC_UPDATE_TRACK_INFO = "javascript:window.flow.biz.util.updateTrackInfo";
    public static final PartialRewriteJsCaller INSTANCE = null;
    private static final String JS_FUNC_PREFIX = "javascript:window.flow.";
    private static final String TAG = "PartialRewriteJsCaller";

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[DocSdkVersion.values().length];
            r100[DocSdkVersion.V1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[DocSdkVersion.V2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        INSTANCE = new PartialRewriteJsCaller();
    }

    private PartialRewriteJsCaller() {
    }

    public static /* synthetic */ void a(Function1 r100, String r101) {
        enterStreamEditMode$lambda$1(r100, r101);
    }

    public static /* synthetic */ void b(Function1 r100, String r101) {
        enterStreamEditMode$lambda$0(r100, r101);
    }

    private static final void enterStreamEditMode$lambda$0(Function1 r100, String r101) {
        if (r100 == null) goto L7;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.invoke(r101);
        return;
    }

    private static final void enterStreamEditMode$lambda$1(Function1 r100, String r101) {
        if (r100 == null) goto L7;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.invoke(r101);
        return;
    }

    public final void clearReference(WebView r100, DocSdkVersion r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "docSdkVersion");
        int r102 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        if (r102 != 1) goto L5;
        SafeJSExecutor.execJS(r100, FUNC_CLEAR_REFERENCE, new JsonObject());
        return;
    L5:
        if (r102 != 2) goto L8;
        a.a(r100, FUNC_CLEAR_REFERENCE, new JSONObject(), null);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void startStreamEdit(WebView r100, DocSdkVersion r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "docSdkVersion");
        int r102 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        if (r102 != 1) goto L5;
        SafeJSExecutor.execJS(r100, FUNC_START_STREAM_EDIT, new JsonObject());
        return;
    L5:
        if (r102 != 2) goto L8;
        a.a(r100, FUNC_START_STREAM_EDIT, new JSONObject(), null);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void endStreamEdit(WebView r100, boolean r101, DocSdkVersion r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r102, "docSdkVersion");
        int r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        if (r103 != 1) goto L5;
        JsonObject r104 = new JsonObject();
        r104.addProperty("cancelStreaming", Boolean.valueOf(r101));
        Unit r105 = Unit.INSTANCE;
        SafeJSExecutor.execJS(r100, FUNC_END_STREAM_EDIT, r104);
        return;
    L5:
        if (r103 != 2) goto L8;
        JSONObject r106 = new JSONObject();
        r106.put2("cancelStreaming", Boolean.valueOf(r101));
        Unit r107 = Unit.INSTANCE;
        a.a(r100, FUNC_END_STREAM_EDIT, r106, null);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void enterStreamEditMode(WebView r100, final Function1<? super String, Unit> r101, DocSdkVersion r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r102, "docSdkVersion");
        int r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        if (r103 != 1) goto L5;
        SafeJSExecutor.execJS(r100, FUNC_ENTER_STREAM_EDIT_MODE, new JsonObject(), new q39.a(r101));
        return;
    L5:
        if (r103 != 2) goto L8;
        a.a(r100, FUNC_ENTER_STREAM_EDIT_MODE, new JSONObject(), new b(r101));
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void notifyTrackInfoUpdate(WebView r100, DocSdkVersion r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "docSdkVersion");
        Intrinsics.checkNotNullParameter(r102, "info");
        int r103 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        if (r103 != 1) goto L5;
        SafeJSExecutor.execJS(r100, FUNC_UPDATE_TRACK_INFO, JsonParser.parseString(r102).getAsJsonObject());     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        FLogger.f375446a.e(TAG, e.getMessage(), e);
        return;
    L5:
        if (r103 != 2) goto L11;
        a.a(r100, FUNC_UPDATE_TRACK_INFO, (JSONObject) JSON.parseObject(r102, JSONObject.class), null);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e(TAG, e.getMessage(), e);
        return;
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public final void streamEditTextContent(WebView r100, String r101, DocSdkVersion r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "docSdkVersion");
        int r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        if (r103 != 1) goto L5;
        JsonObject r104 = new JsonObject();
        r104.addProperty("text", r101);
        Unit r105 = Unit.INSTANCE;
        SafeJSExecutor.execJS(r100, FUNC_STREAM_EDIT_TEXT_CONTENT, r104);
        return;
    L5:
        if (r103 != 2) goto L8;
        JSONObject r106 = new JSONObject();
        r106.put2("text", r101);
        Unit r107 = Unit.INSTANCE;
        a.a(r100, FUNC_STREAM_EDIT_TEXT_CONTENT, r106, null);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void leaveStreamEditMode(WebView r100, int r101, boolean r102, boolean r103, DocSdkVersion r110) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r110, "docSdkVersion");
        int r111 = WhenMappings.$EnumSwitchMapping$0[r110.ordinal()];
        if (r111 != 1) goto L5;
        JsonObject r112 = new JsonObject();
        r112.addProperty("is_keyboard_showing", Boolean.valueOf(r103));
        r112.addProperty("scene", Integer.valueOf(r101));
        r112.addProperty("restoreSelection", Boolean.valueOf(r102));
        Unit r104 = Unit.INSTANCE;
        SafeJSExecutor.execJS(r100, FUNC_LEAVE_STREAM_EDIT_MODE, r112);
        return;
    L5:
        if (r111 != 2) goto L8;
        JSONObject r113 = new JSONObject();
        r113.put2("is_keyboard_showing", Boolean.valueOf(r103));
        r113.put2("scene", Integer.valueOf(r101));
        r113.put2("restoreSelection", Boolean.valueOf(r102));
        Unit r105 = Unit.INSTANCE;
        a.a(r100, FUNC_LEAVE_STREAM_EDIT_MODE, r113, null);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
