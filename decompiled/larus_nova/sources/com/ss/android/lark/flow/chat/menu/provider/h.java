package com.ss.android.lark.flow.chat.menu.provider;

import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f422253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f422254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f422255c;

    public h(String r100, String r101, Context r102) {
        this.f422253a = r100;
        this.f422254b = r101;
        this.f422255c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        int r102 = com.ss.android.lark.statistics.thread.a.f440775a;
        String r103 = this.f422253a;
        String r104 = this.f422254b;
        Intrinsics.checkNotNullParameter(r103, "chatId");
        Intrinsics.checkNotNullParameter(r104, "threadId");
        Statistics.sendEvent("group_topicmode_topic_close_click_confirm", new JSONObject().put("chat_id", r103).put("topic_id", r104));
        int r105 = FlowCloseTopicActionHelper.f422237a;
        FlowCloseTopicActionHelper.c(this.f422255c, this.f422254b, true);
    }
}
