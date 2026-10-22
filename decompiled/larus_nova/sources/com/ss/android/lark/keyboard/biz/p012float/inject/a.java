package com.ss.android.lark.keyboard.biz.p012float.inject;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.keyboard.base.k;
import com.ss.android.lark.statistics.Statistics;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import z5c.p3;
import z5c.r;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FloatExpandPlugin.b f428380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f428381b;

    public a(FloatExpandPlugin.b r100, s5c.a r101) {
        this.f428380a = r100;
        this.f428381b = r101;
    }

    @Override // com.ss.android.lark.keyboard.base.k
    public final void a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Map<String, ? extends Object> r101 = ChatParamUtils.g(r100);
        s5c.a r102 = r.U2;
        d r103 = this.f428380a.f428372b;
        r102.getClass();
        Statistics.sendEvent("im_chat_ai_reply_click", d.b.b(r102, r103).plus(this.f428381b).plus(p3.f570282c).plus(r101).toJson());
    }
}
