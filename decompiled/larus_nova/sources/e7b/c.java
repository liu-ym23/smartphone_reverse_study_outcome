package e7b;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends e7b.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f471269f = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ChatChatter f471270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MessageInfo f471271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MessageInfo f471272e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Chat f471273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f471274b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ChatChatter f471275c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public MessageInfo f471276d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public MessageInfo f471277e;

        public a(Chat r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "chat");
            Intrinsics.checkNotNullParameter(r101, "rootMsgId");
            this.f471273a = r100;
            this.f471274b = r101;
        }
    }

    public static final class b {
    }

    static {
    }

    public c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Chat r101 = r100.f471273a;
        String r102 = r100.f471274b;
        ChatChatter r103 = r100.f471275c;
        MessageInfo r104 = r100.f471276d;
        MessageInfo r105 = r100.f471277e;
        super(r101, r102);
        this.f471270c = r103;
        this.f471271d = r104;
        this.f471272e = r105;
    }
}
