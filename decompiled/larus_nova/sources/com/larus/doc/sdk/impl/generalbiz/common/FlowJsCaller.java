package com.larus.doc.sdk.impl.generalbiz.common;

import android.webkit.WebView;
import ap5.a;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.larus.doc.sdk.impl.generalbiz.state.media.SelectedMediaItemV1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import com.ss.android.lark.chameleon.util.SafeJSExecutor;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p39.b;
import p39.c;
import p39.d;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J$\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u001b\u001a\u00020\u001c2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0016\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J*\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0 2\u0006\u0010\u0013\u001a\u00020\u0014J*\u0010!\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050#2\u0006\u0010\u0013\u001a\u00020\u0014J*\u0010$\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000f0 2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/common/FlowJsCaller;", "", "<init>", "()V", "JS_FUNC_PREFIX", "", "BIZ_UTIL", "FUNC_MORE_OPERATION", "FUNC_CLICK_EDIT_ITEM", "FUNC_INSERT_MEDIA", "FUNC_PREPARE_INSERT_MEDIA", "FUNC_ASR_START", "FUNC_ASR_RESULT", "FUNC_ASR_END", "notifyMoreAction", "", "webView", "Landroid/webkit/WebView;", "type", "version", "Lcom/larus/doc/sdk/impl/generalbiz/common/DocSdkVersion;", "clickEditItem", "id", "insertMedia", "mediaList", "", "Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectedMediaItemV1;", "buildJsonData", "Lcom/google/gson/JsonObject;", "prepareInsertMedia", "startVoiceInput", "callback", "Lkotlin/Function1;", "displayAsrText", "sentence", "Lkotlin/Pair;", "stopVoiceInput", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowJsCaller {
    private static final String BIZ_UTIL = "biz.util.";
    private static final String FUNC_ASR_END = "javascript:window.flow.biz.aiSpeech.end";
    private static final String FUNC_ASR_RESULT = "javascript:window.flow.biz.aiSpeech.speaking";
    private static final String FUNC_ASR_START = "javascript:window.flow.biz.aiSpeech.start";
    private static final String FUNC_CLICK_EDIT_ITEM = "javascript:window.flow.biz.navigation.clickEditItem";
    private static final String FUNC_INSERT_MEDIA = "javascript:window.flow.biz.util.insertMedia";
    private static final String FUNC_MORE_OPERATION = "javascript:window.flow.biz.navigation.moreOperation";
    private static final String FUNC_PREPARE_INSERT_MEDIA = "javascript:window.flow.biz.util.prepareInsertMedia";
    public static final FlowJsCaller INSTANCE = null;
    private static final String JS_FUNC_PREFIX = "javascript:window.flow.";

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
        INSTANCE = new FlowJsCaller();
    }

    private FlowJsCaller() {
    }

    public static /* synthetic */ void a(Function1 r100, String r101) {
        startVoiceInput$lambda$7(r100, r101);
    }

    public static /* synthetic */ void b(Function1 r100, String r101) {
        stopVoiceInput$lambda$17(r100, r101);
    }

    public static /* synthetic */ void c(Function1 r100, String r101) {
        stopVoiceInput$lambda$21(r100, r101);
    }

    public static /* synthetic */ void d(Function1 r100, String r101) {
        startVoiceInput$lambda$11(r100, r101);
    }

    private final JsonObject buildJsonData(List<SelectedMediaItemV1> r100) {
        JsonArray r101 = new JsonArray();
        Iterator<SelectedMediaItemV1> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        SelectedMediaItemV1 r103 = r102.next();
        JsonObject r104 = new JsonObject();
        r104.addProperty("contentType", r103.getContentType());
        r104.addProperty(ST.UUID_DEVICE, r103.getUuid());
        r104.addProperty("src", r103.getMediaFile());
        r104.addProperty("width", Integer.valueOf(r103.getWidth()));
        r104.addProperty("height", Integer.valueOf(r103.getHeight()));
        r104.addProperty("fileSize", Long.valueOf(r103.getFileSize()));
        r104.addProperty("fileName", r103.getFileName());
        r101.add(r104);
        goto L4
    L6:
        JsonObject r105 = new JsonObject();
        r105.addProperty("code", 0);
        r105.add("thumbs", r101);
        r105.addProperty("type", "image");
        return r105;
    }

    private static final void startVoiceInput$lambda$11(Function1 r100, String r101) {
        FLogger.f375446a.i("VoiceInputPlugin", "startVoiceInput: " + r101);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        String r103 = p0.a(r101);     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        String r104 = new JSONObject(r103).optString(PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L9
        r100.invoke(r104);     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L12:
        if (Result.m9452exceptionOrNullimpl(r105) == null) goto L17;
        r100.invoke("");
        return;
    L17:
        return;
    L6:
        r100.invoke("");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    private static final void startVoiceInput$lambda$7(Function1 r100, String r101) {
        FLogger.f375446a.i("VoiceInputPlugin", "startVoiceInput: " + r101);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        String r103 = p0.a(r101);     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        String r104 = new JSONObject(r103).optString(PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L9
        r100.invoke(r104);     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L12:
        if (Result.m9452exceptionOrNullimpl(r105) == null) goto L17;
        r100.invoke("");
        return;
    L17:
        return;
    L6:
        r100.invoke("");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    private static final void stopVoiceInput$lambda$17(Function1 r100, String r101) {
        FLogger.f375446a.i("VoiceInputPlugin", "stopVoiceInput: " + r101);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        String r103 = p0.a(r101);     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        r100.invoke(Integer.valueOf(new JSONObject(r103).optInt("length")));     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L12:
        if (Result.m9452exceptionOrNullimpl(r104) == null) goto L17;
        r100.invoke(0);
        return;
    L17:
        return;
    L6:
        r100.invoke(0);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    private static final void stopVoiceInput$lambda$21(Function1 r100, String r101) {
        FLogger.f375446a.i("VoiceInputPlugin", "stopVoiceInput: " + r101);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        String r103 = p0.a(r101);     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        r100.invoke(Integer.valueOf(new JSONObject(r103).optInt("length")));     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L12:
        if (Result.m9452exceptionOrNullimpl(r104) == null) goto L17;
        r100.invoke(0);
        return;
    L17:
        return;
    L6:
        r100.invoke(0);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final void prepareInsertMedia(WebView r100, DocSdkVersion r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "version");
        int r102 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        if (r102 != 1) goto L5;
        SafeJSExecutor.execJS(r100, FUNC_PREPARE_INSERT_MEDIA);
        return;
    L5:
        if (r102 != 2) goto L8;
        a.a(r100, FUNC_PREPARE_INSERT_MEDIA, null, null);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void clickEditItem(WebView r100, String r101, DocSdkVersion r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "version");
        int r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        if (r103 != 1) goto L5;
        JsonObject r104 = new JsonObject();
        r104.addProperty("id", r101);
        Unit r105 = Unit.INSTANCE;
        SafeJSExecutor.execJS(r100, FUNC_CLICK_EDIT_ITEM, r104);
        return;
    L5:
        if (r103 != 2) goto L8;
        com.alibaba.fastjson.JSONObject r106 = new com.alibaba.fastjson.JSONObject();
        r106.put2("id", r101);
        Unit r107 = Unit.INSTANCE;
        a.a(r100, FUNC_CLICK_EDIT_ITEM, r106, null);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void displayAsrText(WebView r100, Pair<String, String> r101, DocSdkVersion r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "sentence");
        Intrinsics.checkNotNullParameter(r102, "version");
        int r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        if (r103 != 1) goto L5;
        JsonObject r104 = new JsonObject();
        r104.addProperty("streamingSentence", r101.getFirst());
        r104.addProperty("definiteSentence", r101.getSecond());
        Unit r105 = Unit.INSTANCE;
        SafeJSExecutor.execJS(r100, FUNC_ASR_RESULT, r104);
        return;
    L5:
        if (r103 != 2) goto L8;
        com.alibaba.fastjson.JSONObject r106 = new com.alibaba.fastjson.JSONObject();
        r106.put2("streamingSentence", r101.getFirst());
        r106.put2("definiteSentence", r101.getSecond());
        Unit r107 = Unit.INSTANCE;
        a.a(r100, FUNC_ASR_RESULT, r106, null);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void insertMedia(WebView r100, List<SelectedMediaItemV1> r101, DocSdkVersion r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "mediaList");
        Intrinsics.checkNotNullParameter(r102, "version");
        int r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        if (r103 != 1) goto L5;
        SafeJSExecutor.execJS(r100, FUNC_INSERT_MEDIA, buildJsonData(r101));
        return;
    L5:
        if (r103 != 2) goto L8;
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void notifyMoreAction(WebView r100, String r101, DocSdkVersion r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "version");
        int r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        if (r103 != 1) goto L5;
        JsonObject r104 = new JsonObject();
        r104.addProperty("type", r101);
        Unit r105 = Unit.INSTANCE;
        SafeJSExecutor.execJS(r100, FUNC_MORE_OPERATION, r104);
        return;
    L5:
        if (r103 != 2) goto L8;
        com.alibaba.fastjson.JSONObject r106 = new com.alibaba.fastjson.JSONObject();
        r106.put2("type", r101);
        Unit r107 = Unit.INSTANCE;
        a.a(r100, FUNC_MORE_OPERATION, r106, null);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void startVoiceInput(WebView r100, final Function1<? super String, Unit> r101, DocSdkVersion r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "version");
        int r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        if (r103 != 1) goto L5;
        SafeJSExecutor.execJS(r100, FUNC_ASR_START, new JsonObject(), new p39.a(r101));
        return;
    L5:
        if (r103 != 2) goto L8;
        a.a(r100, FUNC_ASR_START, new com.alibaba.fastjson.JSONObject(), new b(r101));
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void stopVoiceInput(WebView r100, final Function1<? super Integer, Unit> r101, DocSdkVersion r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "version");
        int r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        if (r103 != 1) goto L5;
        SafeJSExecutor.execJS(r100, FUNC_ASR_END, new JsonObject(), new c(r101));
        return;
    L5:
        if (r103 != 2) goto L8;
        a.a(r100, FUNC_ASR_END, new com.alibaba.fastjson.JSONObject(), new d(r101));
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
