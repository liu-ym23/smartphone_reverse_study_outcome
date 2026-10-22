package com.ss.android.lark.message.card;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.ss.android.lark.message.card.style.MessageCardStyleProvider;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile MessageCardStyleProvider f431903a;

    public static hrb.a a() {
        return (hrb.a) ClaymoreServiceLoader.loadFirst(hrb.a.class);
    }

    public b() {
    }
}
