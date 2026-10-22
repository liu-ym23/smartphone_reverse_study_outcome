package com.larus.im.internal.core.conversation.check;

import androidx.collection.LruCache;
import com.larus.im.bean.message.MessageListRequest;
import com.larus.im.internal.database.utils.e;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class MessageCheckManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, Boolean> f347569a = null;

    static {
        f347569a = new LruCache(100);
    }

    public static void a(MessageListRequest r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        e.c(new MessageCheckManager$check$1(r100, r101, null));
    }
}
