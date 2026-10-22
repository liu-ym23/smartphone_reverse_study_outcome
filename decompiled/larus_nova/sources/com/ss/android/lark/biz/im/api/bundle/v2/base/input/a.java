package com.ss.android.lark.biz.im.api.bundle.v2.base.input;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f409991a = 0;

    static {
    }

    public a() {
    }

    public static ChatBundleInput a(String r100) {
        ChatBundleBuilder$chatBundle$1 r101 = ChatBundleBuilder$chatBundle$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "init");
        ChatIdLaunchData r102 = new ChatIdLaunchData(r100);
        gxa.a r103 = new gxa.a();
        r101.invoke(r103);
        return new ChatBundleInput(r102, r103.a());
    }
}
