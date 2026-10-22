package com.ss.android.lark.biz.im.api.extension.message;

import android.content.Context;
import com.larksuite.framework.callback.CallbackManager;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
public interface MultiSelectContext {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/message/MultiSelectContext$Page;", "", "<init>", "(Ljava/lang/String;I)V", "CHAT_WINDOW", "THREAD_DETAIL", "REPLY_IN_THREAD", "PRIVATE_THREAD_MERGE_FORWARD", "PRIVATE_MODE_CHAT", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Page extends Enum<Page> {
        public static final Page CHAT_WINDOW = null;
        public static final Page PRIVATE_MODE_CHAT = null;
        public static final Page PRIVATE_THREAD_MERGE_FORWARD = null;
        public static final Page REPLY_IN_THREAD = null;
        public static final Page THREAD_DETAIL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Page[] f410202a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f410203b = null;

        public static EnumEntries<Page> getEntries() {
            return f410203b;
        }

        static {
            Page r100 = new Page("CHAT_WINDOW", 0);
            CHAT_WINDOW = r100;
            Page r101 = new Page("THREAD_DETAIL", 1);
            THREAD_DETAIL = r101;
            Page r102 = new Page("REPLY_IN_THREAD", 2);
            REPLY_IN_THREAD = r102;
            Page r103 = new Page("PRIVATE_THREAD_MERGE_FORWARD", 3);
            PRIVATE_THREAD_MERGE_FORWARD = r103;
            Page r104 = new Page("PRIVATE_MODE_CHAT", 4);
            PRIVATE_MODE_CHAT = r104;
            Page[] r105 = {r100, r101, r102, r103, r104};
            f410202a = r105;
            f410203b = EnumEntriesKt.enumEntries(r105);
        }

        public static Page[] values() {
            return (Page[]) f410202a.clone();
        }

        public static Page valueOf(String r100) {
            return (Page) r27.a.a(Page.class, r100);
        }

        public Page(String r100, int r101) {
            super(r100, r101);
        }
    }

    boolean a();

    CallbackManager b();

    void c();

    Map<String, Message.Type> d();

    List<String> e();

    Chat getChat();

    Context getContext();

    Page getPage();
}
