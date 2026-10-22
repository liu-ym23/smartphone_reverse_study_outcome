package com.ss.android.lark.flow.chat.menu.provider;

import android.content.DialogInterface;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f422251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f422252b;

    public g(String r100, String r101) {
        this.f422251a = r100;
        this.f422252b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        int r102 = com.ss.android.lark.statistics.thread.a.f440775a;
        String r103 = this.f422251a;
        String r104 = this.f422252b;
        Intrinsics.checkNotNullParameter(r103, "chatId");
        Intrinsics.checkNotNullParameter(r104, "threadId");
        Statistics.sendEvent("group_topicmode_topic_close_click_cancel", new JSONObject().put("chat_id", r103).put("topic_id", r104));
        r100.dismiss();
    }
}
