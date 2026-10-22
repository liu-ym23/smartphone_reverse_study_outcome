package com.ss.android.lark.biz.im.api;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public interface y0 {

    public static final class a {
        public static void a(List r100, IGetDataCallback r101) {
            Intrinsics.checkNotNullParameter(r100, "missingPositions");
            Intrinsics.checkNotNullParameter(r101, "callback");
        }
    }

    void a(q3b.q<x4b.a<MessageInfo>, MessageInfo> r100);

    void b(int r100, boolean r101, q3b.q<x4b.a<MessageInfo>, MessageInfo> r102);

    void c(IGetDataCallback<ChatMessageResponse> r100);

    boolean canLoadMore();

    boolean canLoadPre();

    void d(List<Integer> r100, IGetDataCallback<Boolean> r101);

    void e(q3b.q<x4b.a<MessageInfo>, MessageInfo> r100);
}
