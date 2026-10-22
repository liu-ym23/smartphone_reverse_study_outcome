package x7c;

import com.bytedance.lark.pb.todo.v1.ChatTodoInfo;
import com.bytedance.lark.pb.todo.v1.GetChatCompletedTodosResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class a<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f562878a = null;

    static {
        f562878a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        GetChatCompletedTodosResponse r101 = GetChatCompletedTodosResponse.ADAPTER.decode(r100);
        Boolean r102 = null;
        if (r101 == null) goto L5;
        List<ChatTodoInfo> r103 = r101.todos;
    L6:
        if (r101 == null) goto L8;
        Long r104 = r101.last_offset;
    L9:
        if (r101 == null) goto L12;
        r102 = r101.has_more;
    L12:
        return new y7c.a(r103, r104, r102);
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }
}
