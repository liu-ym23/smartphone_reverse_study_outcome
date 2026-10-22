package com.ss.android.lark.chat.chatwindow.chat.data.content;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends MessageContentResolver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f412391b = null;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.data.content.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C4799a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f412392a = null;

        static {
            int[] r100 = new int[Message.Type.values().length];
            r100[Message.Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Message.Type.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f412392a = r100;
        }
    }

    static {
        f412391b = new a();
    }

    public a() {
    }

    public final String a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Message.Type r101 = r100.getType();
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 != 1) goto L9;
        Content r103 = r100.getContent();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.TextContent");
        return ((TextContent) r103).getText();
    L9:
        if (r102 == 2) goto L15;
        return "";
    L15:
        return ((PostContent) r100.getContent()).getText();
    L5:
        r102 = C4799a.f412392a[r101.ordinal()];
        goto L7
    }
}
