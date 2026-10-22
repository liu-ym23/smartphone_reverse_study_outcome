package h7b;

import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.utils.z0;
import com.ss.android.lark.log.Log;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Chat f484035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.im.sdk.service.h f484036b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ChatChatter f484037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OpenApp f484038b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f484037a, r101.f484037a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f484038b, r101.f484038b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            ChatChatter r100 = this.f484037a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            OpenApp r104 = this.f484038b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ChatterInfo(chatChatter=" + this.f484037a + ", openApp=" + this.f484038b + ')';
        }

        public a(ChatChatter r100, OpenApp r101) {
            this.f484037a = r100;
            this.f484038b = r101;
        }
    }

    public static final class b {
    }

    static {
    }

    public final a a() {
        z0.a();
        if (this.f484035a.isP2PChat() == true) goto L5;
        return null;
    L5:
        ChatChatter r100 = this.f484036b.H5(this.f484035a.getId(), this.f484035a.getP2pChatterId());
        if (r100 != null) goto L19;
        Pair<ChatChatter, OpenApp> r101 = this.f484036b.qb(this.f484035a.getId(), this.f484035a.getP2pChatterId());
        if (r101 == null) goto L20;
        StringBuilder r102 = new StringBuilder("append chat ");
        r102.append(this.f484035a.getId());
        r102.append(" chatter ");
        r102.append(this.f484035a.getP2pChatterId());
        r102.append(" and openApp from net chatter is null: ");
        boolean r103 = true;
        if (r101.getFirst() != null) goto L12;
        boolean r104 = true;
    L13:
        r102.append(r104);
        r102.append(" openApp is null: ");
        if (r101.getSecond() == null) goto L17;
        r103 = false;
    L17:
        r102.append(r103);
        Log.i("LauncherChatterComplete", r102.toString());
        return new a(r101.getFirst(), r101.getSecond());
    L12:
        r104 = false;
        goto L13
    L20:
        return null;
    L19:
        return new a(r100, null);
    }

    public j(Chat r100, com.ss.android.lark.im.sdk.service.h r101) {
        Intrinsics.checkNotNullParameter(r100, "chat");
        Intrinsics.checkNotNullParameter(r101, "chatterService");
        this.f484035a = r100;
        this.f484036b = r101;
    }
}
