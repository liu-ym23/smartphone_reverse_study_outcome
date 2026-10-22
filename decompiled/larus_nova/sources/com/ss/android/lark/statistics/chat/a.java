package com.ss.android.lark.statistics.chat;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Chat f440666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.im.sdk.service.h f440667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IChatService f440668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f440669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f440670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f440671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f440672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f440673h;

    public a(Chat r100, com.ss.android.lark.im.sdk.service.h r101, IChatService r102, String r103, String r104, String r105, String r106, String r107) {
        this.f440666a = r100;
        this.f440667b = r101;
        this.f440668c = r102;
        this.f440669d = r103;
        this.f440670e = r104;
        this.f440671f = r105;
        this.f440672g = r106;
        this.f440673h = r107;
    }

    public final void a() {
        Chat r100 = this.f440666a;
        Boolean r101 = null;
        if (r100 != null) goto L5;
        r100 = this.f440668c.getLocalChat(this.f440669d);
    L8:
        ChatChatter r102 = null;
    L9:
        JSONObject r103 = new JSONObject();
        r103.put("stickerpack_id", this.f440670e);
        r103.put("sticker_id", this.f440671f);
        r103.put(DyPayConstant.KEY_USER_UNIQUE_ID, this.f440672g);
        r103.put("cid", this.f440673h);
        r103.put("chat_id", this.f440669d);
        if (r100 == null) goto L12;
        Chat.Type r104 = r100.getType();
    L13:
        r103.put("chat_type", r104);
        if (r102 == null) goto L16;
        Boolean r105 = Boolean.valueOf(r102.isBot());
    L17:
        r103.put("is_bot_chat", r105);
        if (r100 == null) goto L20;
        r101 = Boolean.valueOf(r100.isMeeting());
    L20:
        r103.put("is_meeting_chat", r101);
        ChatHitPoint.f440631a.b().sendEvent("sticker_sent", r103);
        return;
    L16:
        r105 = null;
        goto L17
    L12:
        r104 = null;
        goto L13
    L5:
        if (r100.getType() != Chat.Type.P2P) goto L8;
        r102 = this.f440667b.He(r100.getId(), r100.getP2pChatterId());
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
