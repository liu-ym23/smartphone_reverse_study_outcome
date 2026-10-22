package kkb;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageStreamStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    public static final boolean a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getStreamStatus() != MessageStreamStatus.Transport) goto L5;
        return true;
    L5:
        return false;
    }
}
