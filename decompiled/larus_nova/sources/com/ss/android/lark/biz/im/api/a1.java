package com.ss.android.lark.biz.im.api;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public interface a1 {

    public static final class a implements a1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f409900a = null;

        static {
            f409900a = new a();
        }

        public a() {
        }

        @Override // com.ss.android.lark.biz.im.api.a1
        public final int a(MessageInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            return r100.getMessage().getPosition();
        }

        @Override // com.ss.android.lark.biz.im.api.a1
        public final int b(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            return r100.getPosition();
        }

        @Override // com.ss.android.lark.biz.im.api.a1
        public final int c(y6b.c<?> r100) {
            Intrinsics.checkNotNullParameter(r100, "messageVO");
            return r100.f566499n;
        }
    }

    int a(MessageInfo r100);

    int b(Message r100);

    int c(y6b.c<?> r100);
}
