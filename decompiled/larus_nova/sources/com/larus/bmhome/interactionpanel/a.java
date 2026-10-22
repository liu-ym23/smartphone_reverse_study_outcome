package com.larus.bmhome.interactionpanel;

import com.larus.bmhome.clarification.j2;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.thread.ThreadMessageListRequest;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j2 f312322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f312323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f312324c;

    /* JADX INFO: renamed from: com.larus.bmhome.interactionpanel.a$a, reason: collision with other inner class name */
    public static final class C4087a {
    }

    static {
    }

    public a(j2 r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        Intrinsics.checkNotNullParameter(r101, "manager");
        this.f312322a = r100;
        this.f312323b = r101;
        this.f312324c = new AtomicInteger();
    }

    public final boolean update(m r110, String r210) {
        Intrinsics.checkNotNullParameter(r110, "entry");
        Intrinsics.checkNotNullParameter(r210, "hostId");
        t r100 = r110.f312376c;
        boolean r101 = false;
        if (r100 != null) goto L8;
        r100 = r110.f312377d;
        if (r100 != null) goto L8;
        FLogger.f375446a.w("ClarificationPanelAdapter", "skip clarification update, payload empty, key=" + r110.f312374a);
        return false;
    L8:
        int r102 = this.f312324c.incrementAndGet();
        if ((r100 instanceof t.b) == false) goto L12;
        return b(r110, r210, ((t.b) r100).f312422a, r102);
    L12:
        if ((r100 instanceof t.a) == false) goto L20;
        t.a r103 = (t.a) r100;
        String r104 = r103.f312420d;
        if (StringsKt.isBlank(r104) == false) goto L16;
        FLogger.f375446a.w("ClarificationPanelAdapter", "skip clarification update, messageId empty, key=" + r110.f312374a);
        this.f312323b.e(r110.f312374a, "clarification_message_id_empty");
    L18:
        return r101;
    L16:
        com.larus.im.d.e().q(new ThreadMessageListRequest(r103.f312418b, null, 0, 50, true, 6, null), new d(r110, r104, this, r210, r102));
        r101 = true;
        goto L18
    L20:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean a(m r100, String r101, Message r102, int r103) {
        if (r103 == this.f312324c.get()) goto L6;
        FLogger.f375446a.i("ClarificationPanelAdapter", "skip stale clarification show, key=" + r100.f312374a);
        return false;
    L6:
        this.f312322a.fY(r100, r102, new b(this, r101));
        return true;
    }

    public final boolean b(m r100, String r101, Message r102, int r103) {
        if (r103 == this.f312324c.get()) goto L5;
        FLogger.f375446a.i("ClarificationPanelAdapter", "skip stale clarification update, key=" + r100.f312374a);
        boolean r104 = false;
    L6:
        if (r104 == false) goto L9;
        return true;
    L9:
        FLogger.f375446a.i("ClarificationPanelAdapter", "fallback to clarification show on update miss, key=" + r100.f312374a);
        return a(r100, r101, r102, r103);
    L5:
        r104 = this.f312322a.update(r100, r102);
        goto L6
    }
}
