package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.message.MessageInfo;

/* JADX INFO: loaded from: classes35.dex */
public final class m0 implements com.ss.android.lark.threaddetail.model.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ThreadTopic f414627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l0 f414628b;

    @Override // com.ss.android.lark.threaddetail.model.g.a
    public final MessageInfo O1() {
        return this.f414628b.f414609e.getTopicMessageInfo();
    }

    @Override // com.ss.android.lark.threaddetail.model.g.a
    public final ThreadTopic N1() {
        return this.f414627a;
    }

    public m0(l0 r100, ThreadTopic r101) {
        this.f414628b = r100;
        this.f414627a = r101;
    }
}
