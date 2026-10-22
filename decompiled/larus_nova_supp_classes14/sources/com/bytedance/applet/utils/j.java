package com.bytedance.applet.utils;

import androidx.collection.LruCache;
import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j {
    public static final LruCache<String, String> a = null;
    public static final LruCache<String, String> b = null;
    public static final a c = null;

    public static final class a implements nf9.b {
        public a() {
        }

        public final void b(String r2, MessageListState r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r4, "msgList");
        }

        public final void c(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void d(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void e(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void f(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "oldMsgList");
            Intrinsics.checkNotNullParameter(r4, "newMsgList");
        }

        public final void a(String r4, Message r5) {
            Intrinsics.checkNotNullParameter(r4, "cid");
            Intrinsics.checkNotNullParameter(r5, "msg");
            LruCache<String, String> r0 = j.b;
            String r1 = r5.getMessageId();
            String r2 = "";
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            r0.put(r4, r1);
            LruCache<String, String> r3 = j.a;
            String r6 = r5.getMessageId();
            if (r6 == null) goto L9;
            r2 = r6;
        L9:
            r3.put(r2, r4);
        }
    }

    static {
        a = new LruCache(20);
        b = new LruCache(20);
        c = new a();
    }
}
