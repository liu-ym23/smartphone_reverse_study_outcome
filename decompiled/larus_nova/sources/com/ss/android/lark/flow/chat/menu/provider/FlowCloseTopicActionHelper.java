package com.ss.android.lark.flow.chat.menu.provider;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.ThreadState;
import com.bytedance.lark.pb.im.v1.UpdateThreadRequest;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.ThreadStateInfo;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.api.service.impl.q1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowCloseTopicActionHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f422237a = 0;

    static {
    }

    public static void c(final Context r100, String r101, final boolean r102) {
        if (r102 == false) goto L4;
        ThreadStateInfo.ThreadState r103 = ThreadStateInfo.ThreadState.CLOSED;
    L5:
        q1 r104 = q1.d.f411637a;
        UIGetDataCallback r105 = new UIGetDataCallback(new FlowCloseTopicActionHelper$updateCloseStatus$1(r102, r100));
        UpdateThreadRequest.Builder r106 = new UpdateThreadRequest.Builder();
        UpdateThreadRequest.Builder r107 = r106.thread_id(r101);
        int r108 = q1.c.f411635b[r103.ordinal()];
        if (r108 != 1) goto L8;
        ThreadState r109 = ThreadState.OPEN;
    L15:
        r107.thread_state(r109);
        r104.f411629a.c(r106, r105);
        return;
    L8:
        if (r108 != 2) goto L10;
        r109 = ThreadState.CLOSED;
        goto L15
    L10:
        if (r108 == 3) goto L12;
        r109 = ThreadState.UNKNOWN_STATE;
        goto L15
    L12:
        r109 = ThreadState.UNKNOWN_STATE;
        goto L15
    L4:
        r103 = ThreadStateInfo.ThreadState.OPEN;
        goto L5
    }

    public static void b(Context r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chatId");
        Intrinsics.checkNotNullParameter(r102, "rootMessageId");
        if (r103 == false) goto L5;
        int r104 = com.ss.android.lark.statistics.thread.a.f440775a;
        Intrinsics.checkNotNullParameter(r101, "chatId");
        Intrinsics.checkNotNullParameter(r102, "threadId");
        Statistics.sendEvent("group_topicmode_topic_reopen_click", new JSONObject().put("chat_id", r101).put("topic_id", r102));
        c(r100, r102, false);
        return;
    L5:
        int r105 = com.ss.android.lark.statistics.thread.a.f440775a;
        Intrinsics.checkNotNullParameter(r101, "chatId");
        Intrinsics.checkNotNullParameter(r102, "threadId");
        Statistics.sendEvent("group_topicmode_topic_close_click", new JSONObject().put("chat_id", r101).put("topic_id", r102));
        UDBaseDialogBuilder.ActionBuilder r106 = new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).text(UIUtils.getString(r100, R.string.Lark_Legacy_Confirm)).textColorRes(R.color.function_danger_fill_default).onClickListener(new h(r101, r102, r100));
        new UDDialogBuilder(r100).title(R.string.Lark_Groups_TopicToolClose).titleBold(true).message(R.string.Lark_Groups_ClosePostPopUpWindowDescription).addActionButton(R.id.ud_dialog_btn_secondary, R.string.Lark_Chat_TopicToolDeleteTipCancel, new g(r101, r102)).addActionButton(r106).show();
    }

    public static boolean a(Chat r100, ThreadTopic r101, Message r102, Chatter r103, boolean r104, boolean r105, boolean r106) {
        boolean r107 = false;
        if (r105 == false) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
    L48:
        return false;
    L7:
        if (r100.isFrozen() == true) goto L48;
        if (r104 == false) goto L12;
        return true;
    L12:
        if (r106 == false) goto L14;
        return true;
    L14:
        String r108 = null;
        if (r103 == null) goto L17;
        String r109 = r103.getId();
    L18:
        if (r109 != null) goto L20;
    L23:
        boolean r110 = true;
    L24:
        if (r110 == true) goto L31;
        if (r101 == null) goto L27;
        String r111 = r101.getOwnerId();
    L29:
        if (Intrinsics.areEqual(r111, r109) == false) goto L31;
        return true;
    L27:
        r111 = null;
    L31:
        if (r101 == null) goto L33;
        String r112 = r101.getAnonymousId();
    L34:
        if (r112 != null) goto L36;
    L39:
        boolean r113 = true;
    L40:
        if (r113 == true) goto L47;
        if (r102 == null) goto L44;
        r108 = r102.getFromId();
    L44:
        if (Intrinsics.areEqual(r112, r108) == false) goto L47;
        r107 = true;
    L47:
        return r107;
    L36:
        if (r112.length() == 0) goto L39;
        r113 = false;
        goto L40
    L33:
        r112 = null;
        goto L34
    L20:
        if (r109.length() == 0) goto L23;
        r110 = false;
        goto L24
    L17:
        r109 = null;
        goto L18
    }
}
