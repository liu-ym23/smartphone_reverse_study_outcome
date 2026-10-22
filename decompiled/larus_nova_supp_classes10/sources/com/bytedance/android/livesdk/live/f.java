package com.bytedance.android.livesdk.live;

import android.os.Looper;
import android.os.Message;
import com.bytedance.android.livesdk.chatroom.newcontainer.business.community.innerfeed.g;
import com.bytedance.android.livesdk.config.ge;
import com.bytedance.android.livesdk.model.i;
import com.bytedance.android.livesdk.model.q;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.feed.LoadMoreRetryConfig;
import com.bytedance.android.livesdkapi.feed.SOURCE;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements WeakHandler.IHandler {
    public int a;
    public boolean b;
    public Integer c;
    public final WeakHandler d;
    public final e e;

    public static final class a {
    }

    static {
    }

    public static boolean a() {
        ge r0 = ge.a;
        if (((i) r0.getValue()).a() == true) goto L5;
        return false;
    L5:
        if (((i) r0.getValue()).b() == null) goto L10;
        return true;
    L10:
        return false;
    }

    public f(g.a r2) {
        this.e = r2;
        this.d = new WeakHandler(Looper.getMainLooper(), this);
    }

    public final void handleMsg(Message r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.what != 10086) goto L30;
        q r0 = ((i) ge.a.getValue()).b();
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.a(this.c) == true) goto L12;
        return;
    L12:
        int r1 = 0;
        if (r6.arg1 != 1) goto L22;
        this.a++;
        int r2 = com.bytedance.android.live.network.impl.utils.b.c;
        com.bytedance.android.live.network.impl.utils.b.a.a("/webcast/feed/ delay trigger retry " + this.a + ". error_code is " + this.c);
        g.a r3 = this.e;
        if (r3 == null) goto L22;
        SOURCE r4 = SOURCE.WATCH_DELAY;
        Integer r5 = this.c;
        if (r5 == null) goto L19;
        int r7 = r5.intValue();
    L20:
        r3.a(new LoadMoreRetryConfig(r4, r7));
        goto L22
    L19:
        r7 = 0;
    L22:
        if (r6.arg1 != 2) goto L31;
        int r8 = com.bytedance.android.live.network.impl.utils.b.c;
        com.bytedance.android.live.network.impl.utils.b.a.a("/webcast/feed/ scroll trigger retry. error_code is " + this.c);
        g.a r9 = this.e;
        if (r9 == null) goto L32;
        SOURCE r10 = SOURCE.LAST_SLIDE_UP;
        Integer r11 = this.c;
        if (r11 == null) goto L28;
        r1 = r11.intValue();
    L28:
        r9.a(new LoadMoreRetryConfig(r10, r1));
        return;
    L32:
        return;
    L31:
        return;
    }
}
