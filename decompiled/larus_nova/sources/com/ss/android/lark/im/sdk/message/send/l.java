package com.ss.android.lark.im.sdk.message.send;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.im.sdk.service.o;
import com.ss.android.lark.log.Log;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class l extends jkb.a<k> {

    public static final class a {
    }

    static {
    }

    public l() {
    }

    @Override // jkb.a
    public final void b(jkb.d r100, jkb.b r101, jkb.e r102) {
        k r103 = (k) r101;
        Intrinsics.checkNotNullParameter(r100, "pipelineStep");
        Intrinsics.checkNotNullParameter(r103, "pipelineContext");
        Intrinsics.checkNotNullParameter(r102, "reason");
        Log.e("ImSdkSendPipeline", "Send message pipeline terminated terminated in " + r100.getName() + ", reason is " + r102);
        o r104 = r103.f425988b;
        MessageInfo r105 = r103.f425989c;
        if (r105 == null) goto L5;
        Message r106 = r105.getMessage();
    L6:
        r104.k(r102, r106);
        Long r107 = r103.f425990d;
        Long r108 = r103.f425991e;
        if (r107 == null) goto L35;
        if (r108 == null) goto L38;
        Object r109 = m.f425992a;
        long r110 = r107.longValue();
        long r111 = r108.longValue();
        Object r112 = m.f425992a;
        monitor-enter(r112);
        m.a r113 = (m.a) ((LinkedHashMap) m.f425993b).get(Long.valueOf(r110));     // Catch: Throwable -> L32
        if (r113 != null) goto L15;
        monitor-exit(r112);
        return;
    L15:
        long r114 = r113.f425995b;     // Catch: Throwable -> L32
        if (r111 >= r114) goto L20;
        monitor-exit(r112);
        return;
    L20:
        if (r111 != r114) goto L26;
        r113.f425997d.remove(Long.valueOf(r111));     // Catch: Throwable -> L32
        long r115 = r113.f425995b + 1;     // Catch: Throwable -> L32
        r113.f425995b = r115;     // Catch: Throwable -> L32
        if (r113.f425996c == false) goto L24;
    L27:
        boolean r116 = false;
    L28:
        m.a(r110, r113);     // Catch: Throwable -> L32
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r112);
        if (r116 == false) goto L39;
        m.b(r110);
        return;
    L39:
        return;
    L24:
        if (r113.f425997d.containsKey(Long.valueOf(r115)) == false) goto L27;
        r116 = true;
        r113.f425996c = true;     // Catch: Throwable -> L32
        goto L28
    L26:
        r113.f425997d.remove(Long.valueOf(r111));     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L38:
        return;
    L35:
        return;
    L5:
        r106 = null;
        goto L6
    }
}
