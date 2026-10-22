package t4b;

import com.ss.android.lark.chat.chatwindow.chat.data.content.MessageContentResolver;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends MessageContentResolver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f544610b = null;

    /* JADX INFO: renamed from: t4b.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C7685a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f544611a = null;

        static {
            int[] r100 = new int[Message.Type.values().length];
            r100[Message.Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f544611a = r100;
        }
    }

    static {
        f544610b = new a();
    }

    public a() {
    }

    public final String a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Message.Type r101 = r100.getType();
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 != 1) goto L11;
        int r103 = u4b.a.f548744c;
        Content r104 = u4b.a.b.f548747a.b(r100);
        if ((r104 instanceof TextContent) == false) goto L11;
        return ((TextContent) r104).getText();
    L11:
        return "";
    L5:
        r102 = C7685a.f544611a[r101.ordinal()];
        goto L7
    }
}
