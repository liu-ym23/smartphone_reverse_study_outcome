package com.ss.android.lark.chat.chatwindow.chat.model.data.decorator;

import a2b.j;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import q3b.h;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements i<MessageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f413348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<j.a> f413349b;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.model.data.decorator.a$a, reason: collision with other inner class name */
    public static final class C4809a {
    }

    static {
    }

    @Override // com.ss.android.lark.chatbase.i
    public final void a(f5b.b r100) {
        MessageInfo r101 = (MessageInfo) r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f413348a.G().u3(r101, this.f413349b);
    }

    public a(v r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "mSmartApplyAnswerLoader");
        this.f413348a = r100;
        this.f413349b = r101;
    }
}
