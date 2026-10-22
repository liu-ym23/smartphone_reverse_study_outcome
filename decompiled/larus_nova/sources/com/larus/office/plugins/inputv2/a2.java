package com.larus.office.plugins.inputv2;

import android.os.Bundle;
import androidx.core.os.BundleCompat;
import com.larus.bmhome.chat.ChatBubbleParams;
import com.larus.office.OfficeInputParam;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f362666a = 0;

    static {
    }

    public static Bundle a(String r100, Long r101, OfficeInputParam r102, com.larus.office.h r103, String r104, Bundle r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r104, "trackingEnterMethod");
        Intrinsics.checkNotNullParameter(r110, "trackingCommonMessageExt");
        Bundle r105 = new Bundle();
        r105.putString("key_action_bar_scene", "doc_exist_content");
        r105.putString("custom_suffix", "doc_detail");
        r105.putBoolean("use_main_conv", false);
        r105.putInt("answer_intent_logic", 2);
        r105.putInt("filter_sug_type", -1);
        r105.putString("conversation_id", r100);
        r105.putString("argConversationId", r100);
        if (r101 == null) goto L5;
        r105.putLong("unread_query_read_message_index", r101.longValue());
    L5:
        String r106 = null;
        if (r102 == null) goto L8;
        String r107 = r102.getResourceId();
    L9:
        r105.putString("key_doc_id", r107);
        if (r102 == null) goto L12;
        String r108 = r102.getArtifactMetaId();
    L13:
        r105.putString("artifact_meta_id", r108);
        if (r102 == null) goto L16;
        int r109 = r102.getResourceType();
    L17:
        r105.putInt("resource_type", r109);
        if (r102 == null) goto L20;
        String r112 = r102.getArtifactVersionId();
    L21:
        r105.putString("key_artifact_version_id", r112);
        if (r102 == null) goto L24;
        String r113 = r102.getPreviousPage();
    L25:
        r105.putString("argPreviousPage", r113);
        r105.putString("enter_method", r104);
        if (r102 == null) goto L36;
        String r114 = r102.getEnterFrom();
        if (r114 == null) goto L36;
        if ((!StringsKt.isBlank(r114)) == true) goto L33;
        r114 = null;
    L33:
        if (r114 == null) goto L36;
        r105.putString("enter_from", r114);
    L36:
        if ((!StringsKt.isBlank(r104)) == true) goto L39;
        r104 = null;
    L39:
        if (r104 == null) goto L41;
        r105.putString("enter_method", r104);
    L41:
        r105.putBundle("common_message_ext", r110);
        if (r102 == null) goto L44;
        String r115 = r102.getMessageId();
    L45:
        r105.putString("key_message_id", r115);
        if (r102 == null) goto L48;
        String r116 = r102.getFeishuRecordId();
    L49:
        r105.putString("feishu_record_id", r116);
        if (r102 == null) goto L52;
        r106 = r102.getFeishuRecordContentType();
    L52:
        r105.putString("feishu_record_generated_type", r106);
        if (r103 == null) goto L55;
        r103.Sm(r105);
    L55:
        r105.putBoolean("isWidthFitRoot", true);
        ChatBubbleParams r117 = (ChatBubbleParams) BundleCompat.getParcelable(r105, "argChatBubbleParamsFromHost", ChatBubbleParams.class);
        if (r117 != null) goto L58;
        r117 = new ChatBubbleParams(false, 7);
    L58:
        r105.putParcelable("argChatBubbleParamsFromHost", new ChatBubbleParams(true, r117.f296841b, r117.f296842c));
        if (r111 == false) goto L61;
        com.larus.bmhome.chat.mode.a.a(r105);
    L61:
        return r105;
    L48:
        r116 = null;
        goto L49
    L44:
        r115 = null;
        goto L45
    L24:
        r113 = null;
        goto L25
    L20:
        r112 = null;
        goto L21
    L16:
        r109 = 0;
        goto L17
    L12:
        r108 = null;
        goto L13
    L8:
        r107 = null;
        goto L9
    }
}
