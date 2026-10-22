package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroCardLoadOpt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class IntroCardAnimController implements ff.a {
    public static final /* synthetic */ int k = 0;
    public com.bytedance.android.livesdk.livecommerce.intro.manager.a a;
    public final LinkedList<com.bytedance.android.livesdk.livecommerce.intro.manager.a> b;
    public com.bytedance.android.livesdk.livecommerce.intro.manager.a c;
    public final Handler d;
    public final Lazy e;
    public final Set<Message> f;
    public final Set<Message> g;
    public final AtomicBoolean h;
    public final RoomContextController i;
    public final u j;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ IntroCardAnimController a;
        public final /* synthetic */ Function0 b;
        public final /* synthetic */ Ref.ObjectRef c;
        public final /* synthetic */ Set d;

        public b(IntroCardAnimController r1, Function0 r2, Ref.ObjectRef r3, Set r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (this.a.h.get() == true) goto L5;
            this.b.invoke();     // Catch: Throwable -> L9
        L5:
            Message r0 = (Message) this.c.element;     // Catch: Throwable -> L9
            if (r0 == null) goto L12;
            this.d.remove(r0);     // Catch: Throwable -> L9
            return;
        }
    }

    static {
    }

    public static final void c(IntroCardAnimController r6) {
        if (r6.b.isEmpty() == false) goto L6;
        return;
    L6:
        if (r6.b.size() <= 1) goto L50;
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r0 = r6.c;
        if (r0 != null) goto L10;
    L31:
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r1 = null;
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r3 = null;
    L32:
        if (r1 == null) goto L34;
    L41:
        r6.b.clear();
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r4 = r6.c;
        if (r4 != null) goto L44;
    L47:
        if (r1 == null) goto L49;
        r6.b.offerLast(r1);
    L49:
        Objects.toString(r6.a);
        Objects.toString(r3);
        Objects.toString(r1);
        Objects.toString(r6.b);
        goto L50
    L44:
        if (r4.d != 0) goto L47;
        if (r3 == null) goto L47;
        r6.b.offerLast(r3);
    L34:
        if (r6.b.isEmpty() == true) goto L41;
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r5 = r6.b.pollLast();
        if (r5 == null) goto L41;
        if (r5.d != 0) goto L34;
        r1 = r5;
        goto L41
    L10:
        if (r0.d != 0) goto L31;
        r1 = null;
    L13:
        if (r6.b.isEmpty() == true) goto L30;
        r3 = r6.b.pollLast();
        if (r3 == null) goto L30;
        String r7 = r3.b;
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r8 = r6.c;
        if (r8 == null) goto L20;
        String r9 = r8.b;
    L22:
        if (Intrinsics.areEqual(r7, r9) == true) goto L24;
    L26:
        if (r1 != null) goto L13;
        if (r3.d != 0) goto L13;
        r1 = r3;
        goto L13
    L24:
        if (r3.d != 1) goto L26;
    L20:
        r9 = null;
    L30:
        r3 = null;
    L50:
        Objects.toString(r6.a);
        Objects.toString(r6.b);
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r2 = r6.b.pollFirst();
        r6.a = r2;
        Objects.toString(r2);
        if (r2 != null) goto L53;
        return;
    L53:
        if (r2.d != 0) goto L55;
        r6.c = r2;
    L66:
        r2.a = 1;
        r6.d(new IntroCardAnimController$executeAnim$$inlined$let$lambda$1(r2, r6));
        return;
    L55:
        String r10 = r2.b;
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r11 = r6.c;
        if (r11 == null) goto L58;
        String r12 = r11.b;
    L60:
        if (Intrinsics.areEqual(r10, r12) == false) goto L66;
        int r13 = r2.d;
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r14 = r6.c;
        if (r14 != null) goto L64;
    L65:
        r6.c = null;
        goto L66
    L64:
        if (r13 == r14.d) goto L66;
    L58:
        r12 = null;
        goto L60
    }

    public final void d(Function0<Unit> r4) {
        if (ECLiveABUtils.INSTANCE.getEnableLiveAnimControllerNotChangeThread() == false) goto L13;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        if (IntroCardLoadOpt.n == false) goto L13;
        IntroCardLoadOpt.n = false;
        goto L13
    L7:
        r0 = false;
    L13:
        if (IntroCardLoadOpt.n == false) goto L15;
        r4.invoke();
        return;
    L15:
        e(this.d, this.f, r4);
    }

    public final void f(final com.bytedance.android.livesdk.livecommerce.intro.manager.a r3) {
        Intrinsics.checkNotNullParameter(r3, "animRequest");
        if (r3.b.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        Function0<Unit> r1 = new IntroCardAnimController$postAnimation$1(this, r3);
        if (IntroCardLoadOpt.n == false) goto L11;
        r1.invoke();
        return;
    L11:
        e((Handler) this.e.getValue(), this.g, r1);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public IntroCardAnimController(RoomContextController r2, u r3) {
        Intrinsics.checkNotNullParameter(r2, "roomContextController");
        Intrinsics.checkNotNullParameter(r3, "animDelegate");
        this.i = r2;
        this.j = r3;
        this.b = new LinkedList();
        this.d = com.bytedance.android.livesdk.livecommerce.room.widgets.anim.a.b;
        this.e = LazyKt.lazy(IntroCardAnimController$work$2.INSTANCE);
        this.f = Collections.synchronizedSet(new HashSet());
        this.g = Collections.synchronizedSet(new HashSet());
        this.h = new AtomicBoolean(false);
    }

    public final void e(Handler r3, Set<Message> r4, Function0<Unit> r5) {
        if (this.h.get() == false) goto L5;
        return;
    L5:
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = null;
        Message r6 = Message.obtain(r3, new b(this, r5, r0, r4));
        r0.element = r6;
        if (r6 == null) goto L9;
        r4.add(r6);
        r3.sendMessage(r6);
        return;
    }

    @Deprecated(message = "未被使用，仅接口实现")
    public final void a(View r10, Function0 r11, Function0 r12, Function0 r13, Function0 r14) {
        Intrinsics.checkNotNullParameter(BDLocationException.ERROR_BEACON_ADVERTISING, "id");
        Intrinsics.checkNotNullParameter(r10, "view");
        f(new g(r12, r13, r14, r10, r11, r10, new IntroCardAnimController$postShowLinkAnimation$2(this, r11)));
    }

    @Deprecated(message = "未被使用，仅接口实现")
    public final void b(View r10, Function0 r11, Function0 r12, Function0 r13, Function0 r14) {
        Intrinsics.checkNotNullParameter(BDLocationException.ERROR_BEACON_ADVERTISING, "id");
        Intrinsics.checkNotNullParameter(r10, "view");
        f(new f(r12, r13, r14, r10, r11, r10, new IntroCardAnimController$postHideLinkAnimation$2(this, r11)));
    }
}
