package com.ss.android.lark.statistics.announce_opendoc;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.Collections;
import o5c.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f440622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f440623b;

    public a(String r100) {
        this.f440622a = r100;
        this.f440623b = "message";
    }

    public final void a() {
        String r100 = this.f440622a;
        if (r100 == null) goto L8;
        String r101 = this.f440623b;
        Chat r102 = ChatService.c.f411535a.n(Collections.singletonList(r100)).get(r100);
        if (r102 == null) goto L9;
        AnnounceOpenDocHitPoint.f440620a.getClass();
        ((b) AnnounceOpenDocHitPoint.f440621b.getValue()).sendEvent("announcement_view", new JSONObject().put("announcement_view_loacation", r101).put("chat_type", r102.getType().getNumber()).put(DyPayConstant.KEY_USER_UNIQUE_ID, ChatCoreModule.a().getLoginDependency().getUserId()));
        return;
    L9:
        return;
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
