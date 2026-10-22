package j7b;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.k;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Chat.MessagePosition, d> f497655a;

    /* JADX INFO: renamed from: j7b.a$a, reason: collision with other inner class name */
    public static class C6402a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f497656a = null;

        static {
            f497656a = new a();
        }
    }

    public a() {
        this.f497655a = new HashMap(2);
    }

    public final d a(Chat r100) {
        Chat.MessagePosition r101 = k.c(r100);
        d r102 = (d) ((HashMap) this.f497655a).get(r101);
        if (r102 == null) goto L5;
    L9:
        return r102;
    L5:
        if (r101 != Chat.MessagePosition.NEWEST_UNREAD) goto L7;
        r102 = new b();
    L8:
        ((HashMap) this.f497655a).put(r101, r102);
        goto L9
    L7:
        r102 = new c();
        goto L8
    }
}
