package com.ss.android.lark.im.sdk.message.send;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.im.sdk.service.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class k implements jkb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MessageParams<?, ?> f425987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f425988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MessageInfo f425989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f425990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f425991e;

    public k(MessageParams<?, ?> r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "messageParams");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f425987a = r100;
        this.f425988b = r101;
        this.f425990d = r100.f415264w;
    }
}
