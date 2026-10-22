package com.larus.doc.sdk.impl.statistics;

import by7.a;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.office.OfflineDocReportGate;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.c0;
import tx9.y3;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JQ\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J{\u0010\u0018\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\rJ&\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005J\u0083\u0001\u0010%\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010&\u001a\u0004\u0018\u00010\u00112\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010\u00052\b\u0010*\u001a\u0004\u0018\u00010\u00112\b\u0010+\u001a\u0004\u0018\u00010\u00052\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00052\b\u0010/\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u00100JG\u00101\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u00102R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/larus/doc/sdk/impl/statistics/DocSdkEventHelper;", "", "<init>", "()V", "TAG", "", "PAGE_AI_DOC_DETAIL", "CLICK_FROM_INSERT_FILE", "DOCX_TYPE", "EVENT_TEXT_SELECTION_BAR_SHOW", "EVENT_TEXT_SELECTION_BAR_CLICK", "EVENT_OUTPUT_PREVIEW_EXIT", "reportToolbarButtonShow", "", "pageToken", "artifactMetaId", "resourceType", "", "buttonName", "conversationId", "previousPage", "params", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "reportToolbarButtonClick", "buttonNameLevelOne", "buttonNameLevelTwo", "buttonLevel", "messageId", "offlineCreateAttemptId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "reportClickUploadEntrance", "reportUploadAttachmentStatus", "isSuccess", "", "picType", "errorMessage", "reportOutputPreviewExit", "contentLength", "duration", "", "leaveReason", "isFinishGeneration", "feishuRecordId", "feishuRecordContentType", "recordScene", "isGeneralAgent", "chatId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "reportContextMenuItemShow", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocSdkEventHelper {
    private static final String CLICK_FROM_INSERT_FILE = "insert_file";
    private static final String DOCX_TYPE = "docx";
    private static final String EVENT_OUTPUT_PREVIEW_EXIT = "output_preview_exit";
    private static final String EVENT_TEXT_SELECTION_BAR_CLICK = "text_selection_bar_click";
    private static final String EVENT_TEXT_SELECTION_BAR_SHOW = "text_selection_bar_show";
    public static final DocSdkEventHelper INSTANCE = null;
    private static final String PAGE_AI_DOC_DETAIL = "ai_doc_detail";
    private static final String TAG = "DocSdkEventHelper";

    static {
        INSTANCE = new DocSdkEventHelper();
    }

    private DocSdkEventHelper() {
    }

    public static /* synthetic */ Unit a(JSONObject r100, String r101) {
        return reportToolbarButtonClick$lambda$0(r100, r101);
    }

    public final void reportClickUploadEntrance() {
        c0.H(null, CLICK_FROM_INSERT_FILE, null, null, null, PAGE_AI_DOC_DETAIL, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, null, null, 33546205);
    }

    private static final Unit reportToolbarButtonClick$lambda$0(JSONObject r100, String r101) {
        if (r101 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == true) goto L10;
        r100.put(MusicAppletPage.KEY_MESSAGE_ID, r101);
    L10:
        TrackParams r103 = new TrackParams().merge(r100);
        a r104 = new a(EVENT_TEXT_SELECTION_BAR_CLICK);
        r104.f21463a.merge(r103);
        r104.b();
        return Unit.INSTANCE;
    L4:
        if (StringsKt.isBlank(r101) == true) goto L7;
        r102 = false;
        goto L8
    }

    public final void reportUploadAttachmentStatus(boolean r410, String r510, String r511) {
        if (r410 == false) goto L4;
        String r100 = "1";
    L5:
        y3.a(null, PAGE_AI_DOC_DETAIL, null, r511, "pic", r510, r100, null, null, CLICK_FROM_INSERT_FILE, null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -33556603, 65535);
        return;
    L4:
        r100 = "0";
        goto L5
    }

    public static /* synthetic */ void reportUploadAttachmentStatus$default(DocSdkEventHelper r100, boolean r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.reportUploadAttachmentStatus(r101, r102, r103);
    }

    public final void reportContextMenuItemShow(String r110, String r111, Integer r112, String r113, String r114, String r115) {
        reportToolbarButtonShow$default(this, r110, r111, r112, r113, r114, r115, null, 64, null);
    }

    public final void reportToolbarButtonShow(String r100, String r101, Integer r102, String r103, String r104, String r105, JSONObject r106) {
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r100 != null) goto L20;
    L7:
        if (r101 == null) goto L9;
        r106.put("artifact_meta_id", r101);     // Catch: JSONException -> L5
    L9:
        if (r103 == null) goto L11;
        r106.put("button_name_level_one", r103);     // Catch: JSONException -> L5
    L11:
        if (r104 == null) goto L13;
        r106.put("conversation_id", r104);     // Catch: JSONException -> L5
    L13:
        r106.put("resource_type", r102);     // Catch: JSONException -> L5
        r106.put("current_page", PAGE_AI_DOC_DETAIL);     // Catch: JSONException -> L5
        if (r105 == null) goto L18;
        r106.put("previous_page", r105);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e(TAG, "error in DocSdkEventHelper reportOutputPreviewToolShow: " + e.getLocalizedMessage());
    L18:
        TrackParams r107 = new TrackParams().merge(r106);
        a r108 = new a(EVENT_TEXT_SELECTION_BAR_SHOW);
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L20:
        r106.put("page_token", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static /* synthetic */ void reportToolbarButtonShow$default(DocSdkEventHelper r100, String r110, String r111, Integer r112, String r113, String r114, String r115, JSONObject r116, int r117, Object r118) {
        if ((r117 & 64) == 0) goto L5;
        JSONObject r101 = new JSONObject();
    L6:
        r100.reportToolbarButtonShow(r110, r111, r112, r113, r114, r115, r101);
        return;
    L5:
        r101 = r116;
        goto L6
    }

    public final void reportToolbarButtonClick(String r100, String r101, Integer r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, JSONObject r112) {
        Intrinsics.checkNotNullParameter(r112, "params");
        if (r100 != null) goto L26;
    L7:
        if (r101 == null) goto L9;
        r112.put("artifact_meta_id", r101);     // Catch: JSONException -> L5
    L9:
        if (r103 == null) goto L11;
        r112.put("button_name_level_one", r103);     // Catch: JSONException -> L5
    L11:
        if (r104 == null) goto L13;
        r112.put("button_name_level_two", r104);     // Catch: JSONException -> L5
    L13:
        if (r105 == null) goto L15;
        r112.put("button_level", r105);     // Catch: JSONException -> L5
    L15:
        if (r106 == null) goto L17;
        r112.put("conversation_id", r106);     // Catch: JSONException -> L5
    L17:
        if (r110 == null) goto L19;
        r112.put(MusicAppletPage.KEY_MESSAGE_ID, r110);     // Catch: JSONException -> L5
    L19:
        r112.put("resource_type", r102);     // Catch: JSONException -> L5
        r112.put("current_page", PAGE_AI_DOC_DETAIL);     // Catch: JSONException -> L5
        if (r107 == null) goto L24;
        r112.put("previous_page", r107);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e(TAG, "error in DocSdkEventHelper reportOutputPreviewToolShow: " + e.getLocalizedMessage());
    L24:
        final JSONObject r108 = new JSONObject(r112.toString());
        OfflineDocReportGate r109 = OfflineDocReportGate.f360434a;
        Function1 r113 = new s39.a(r108);
        r109.getClass();
        OfflineDocReportGate.d(r111, r113);
        return;
    L26:
        r112.put("page_token", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public final void reportOutputPreviewExit(String r100, String r101, Integer r102, Integer r103, Long r104, String r105, Integer r106, String r110, String r111, String r112, String r113, String r114) {
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L39
        if (r100 == null) goto L5;
        r107.put("page_token", r100);     // Catch: Exception -> L39
    L5:
        if (r101 == null) goto L7;
        r107.put("artifact_meta_id", r101);     // Catch: Exception -> L39
    L7:
        if (r103 == null) goto L9;
        r107.put("content_length", r103.intValue());     // Catch: Exception -> L39
    L9:
        if (r105 == null) goto L11;
        r107.put("leave_reason", r105);     // Catch: Exception -> L39
    L11:
        if (r104 == null) goto L13;
        r107.put("duration", r104.longValue());     // Catch: Exception -> L39
    L13:
        if (r106 == null) goto L15;
        r107.put("is_finish_generation", r106.intValue());     // Catch: Exception -> L39
    L15:
        if (r110 == null) goto L17;
        r107.put("feishu_record_id", r110);     // Catch: Exception -> L39
    L17:
        if (r111 == null) goto L19;
        r107.put("feishu_record_generated_type", r111);     // Catch: Exception -> L39
    L19:
        if (r112 == null) goto L22;
        r107.put("record_scene", r112);     // Catch: Exception -> L39
    L22:
        if (r113 != null) goto L24;
    L27:
        boolean r108 = true;
    L29:
        if ((true ^ r108) == true) goto L32;
        r113 = null;
    L32:
        if (r113 != null) goto L34;
        r113 = "0";
    L34:
        r107.put("is_general_agent", r113);     // Catch: Exception -> L39
        if (r114 != null) goto L37;
        r114 = "";
    L37:
        r107.put("chat_id", r114);     // Catch: Exception -> L39
        r107.put("current_page", PAGE_AI_DOC_DETAIL);     // Catch: Exception -> L39
        r107.put("resource_type", r102);     // Catch: Exception -> L39
        TrackParams r109 = new TrackParams().merge(r107);     // Catch: Exception -> L39
        a r115 = new a(EVENT_OUTPUT_PREVIEW_EXIT);     // Catch: Exception -> L39
        r115.f21463a.merge(r109);     // Catch: Exception -> L39
        r115.b();     // Catch: Exception -> L39
        return;
    L24:
        if (r113.length() == 0) goto L27;
        r108 = false;
    L39:
        e = move-exception;
        FLogger.f375446a.e(TAG, "error in DocSdkEventHelper reportOutputPreviewExit: " + e.getLocalizedMessage());
    }

    public static /* synthetic */ void reportToolbarButtonClick$default(DocSdkEventHelper r110, String r111, String r112, Integer r113, String r114, String r115, String r210, String r211, String r212, String r213, String r214, JSONObject r215, int r216, Object r217) {
        if ((r216 & 512) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r216 & 1024) == 0) goto L9;
        JSONObject r117 = new JSONObject();
    L10:
        r110.reportToolbarButtonClick(r111, r112, r113, r114, r115, r210, r211, r212, r213, r116, r117);
        return;
    L9:
        r117 = r215;
        goto L10
    L5:
        r116 = r214;
        goto L7
    }
}
