package com.ss.android.lark.statistics.translate;

import com.ss.android.lark.chat.base.view.vo.message.f;
import com.ss.android.lark.chat.entity.chat.Chat;
import h7b.l;
import z5c.q;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f440778a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.statistics.translate.a$a, reason: collision with other inner class name */
    public static final class C5296a {
        public static s5c.a a(m2b.a r100) {
            if (r100 == null) goto L14;
            Chat r101 = r100.getChat();
            if (r101 == null) goto L14;
            if (r101.getChatMode() != Chat.ChatMode.THREAD_V2) goto L9;
            return q.f570301e;
        L9:
            if (r101.getType() != Chat.Type.GROUP) goto L12;
            return q.f570299c;
        L12:
            return q.f570300d;
        L14:
            return q.f570300d;
        }

        public static int b(f r100) {
            if (r100 != null) goto L5;
            return 2;
        L5:
            boolean r101 = !l.d(r100);
            if (r100.f411956f != 3) goto L8;
            boolean r102 = true;
        L9:
            if (r101 == false) goto L13;
            if (r102 == true) goto L13;
            boolean r103 = false;
        L14:
            if (r101 == false) goto L17;
            if (r102 == false) goto L17;
            return 2;
        L17:
            if (r103 == false) goto L19;
            return 0;
        L19:
            return 1;
        L13:
            r103 = true;
            goto L14
        L8:
            r102 = false;
            goto L9
        }
    }

    static {
    }
}
