package com.bytedance.android.livesdk.livecommerce.room.widgets.anim;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class BottomRightAnimController implements ff.a {
    public static final /* synthetic */ int j = 0;
    public com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b a;
    public final LinkedList<com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b> b;
    public com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b c;
    public final Handler d;
    public final Lazy e;
    public final Set<Message> f;
    public final Set<Message> g;
    public final AtomicBoolean h;
    public final RoomContextController i;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ BottomRightAnimController a;
        public final /* synthetic */ Function0 b;
        public final /* synthetic */ Ref.ObjectRef c;
        public final /* synthetic */ Set d;

        public b(BottomRightAnimController r1, Function0 r2, Ref.ObjectRef r3, Set r4) {
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

    public final void c() {
        if (this.b.isEmpty() == false) goto L6;
        return;
    L6:
        if (this.b.size() <= 1) goto L50;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r0 = this.c;
        if (r0 != null) goto L10;
    L31:
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r1 = null;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r3 = null;
    L32:
        if (r1 == null) goto L34;
    L41:
        this.b.clear();
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r4 = this.c;
        if (r4 != null) goto L44;
    L47:
        if (r1 == null) goto L49;
        this.b.offerLast(r1);
    L49:
        Objects.toString(this.a);
        Objects.toString(r3);
        Objects.toString(r1);
        Objects.toString(this.b);
        goto L50
    L44:
        if (r4.d != 0) goto L47;
        if (r3 == null) goto L47;
        this.b.offerLast(r3);
    L34:
        if (this.b.isEmpty() == true) goto L41;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r5 = this.b.pollLast();
        if (r5 == null) goto L41;
        if (r5.d != 0) goto L34;
        r1 = r5;
        goto L41
    L10:
        if (r0.d != 0) goto L31;
        r1 = null;
    L13:
        if (this.b.isEmpty() == true) goto L30;
        r3 = this.b.pollLast();
        if (r3 == null) goto L30;
        String r6 = r3.b;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r7 = this.c;
        if (r7 == null) goto L20;
        String r8 = r7.b;
    L22:
        if (Intrinsics.areEqual(r6, r8) == true) goto L24;
    L26:
        if (r1 != null) goto L13;
        if (r3.d != 0) goto L13;
        r1 = r3;
        goto L13
    L24:
        if (r3.d != 1) goto L26;
    L20:
        r8 = null;
    L30:
        r3 = null;
    L50:
        Objects.toString(this.a);
        Objects.toString(this.b);
        final com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r2 = this.b.pollFirst();
        this.a = r2;
        Objects.toString(r2);
        if (r2 == null) goto L99;
        View r9 = r2.c;
        boolean r10 = false;
        if (r9.getVisibility() == 0) goto L55;
    L57:
        boolean r11 = false;
    L58:
        if (r11 == true) goto L60;
    L61:
        View r12 = r2.c;
        if (r12.getVisibility() != 0) goto L64;
    L66:
        if (r10 == false) goto L71;
        if (r2.d != 1) goto L71;
    L69:
        d(new BottomRightAnimController$executeAnim$$inlined$let$lambda$1(this, r2));
        this.a = null;
        c();
        return;
    L71:
        if (r2.d != 0) goto L73;
        this.c = r2;
    L84:
        r2.a = 1;
        d(new BottomRightAnimController$executeAnim$$inlined$let$lambda$2(r2, this, r2));
        return;
    L73:
        String r13 = r2.b;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r14 = this.c;
        if (r14 == null) goto L76;
        String r15 = r14.b;
    L78:
        if (Intrinsics.areEqual(r13, r15) == false) goto L84;
        int r16 = r2.d;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r17 = this.c;
        if (r17 != null) goto L82;
    L83:
        this.c = null;
        goto L84
    L82:
        if (r16 == r17.d) goto L84;
    L76:
        r15 = null;
        goto L78
    L64:
        if (r12.getAlpha() != 0.0f) goto L66;
        r10 = true;
        goto L66
    L60:
        if (r2.d == 0) goto L69;
    L55:
        if (r9.getAlpha() <= 0.0f) goto L57;
        r11 = true;
        goto L58
    }

    public BottomRightAnimController(RoomContextController r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContextController");
        this.i = r2;
        this.b = new LinkedList();
        Handler r3 = com.bytedance.android.livesdk.livecommerce.room.widgets.anim.a.a;
        this.d = com.bytedance.android.livesdk.livecommerce.room.widgets.anim.a.b;
        this.e = LazyKt.lazy(BottomRightAnimController$work$2.INSTANCE);
        this.f = Collections.synchronizedSet(new HashSet());
        this.g = Collections.synchronizedSet(new HashSet());
        this.h = new AtomicBoolean(false);
    }

    public final void d(Function0<Unit> r4) {
        if (ECLiveABUtils.INSTANCE.getEnableLiveAnimControllerNotChangeThread() == false) goto L13;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        if (t.p == false) goto L13;
        t.p = false;
        goto L13
    L7:
        r0 = false;
    L13:
        if (t.p == false) goto L15;
        r4.invoke();
        return;
    L15:
        e(this.d, this.f, r4);
    }

    public final void f(final com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r3) {
        Intrinsics.checkNotNullParameter(r3, "animRequest");
        if (r3.b.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        Function0<Unit> r1 = new BottomRightAnimController$postAnimation$1(this, r3);
        if (t.p == false) goto L11;
        r1.invoke();
        return;
    L11:
        e((Handler) this.e.getValue(), this.g, r1);
        return;
    L5:
        r0 = false;
        goto L6
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

    public final void a(View r10, final Function0 r11, Function0 r12, Function0 r13, Function0 r14) {
        Intrinsics.checkNotNullParameter(BDLocationException.ERROR_BEACON_ADVERTISING, "id");
        Intrinsics.checkNotNullParameter(r10, "view");
        f(new f(r12, r13, r14, r10, r11, r10, new BottomRightAnimController$postShowLinkAnimation$2(this, r11)));
    }

    public final void b(View r10, final Function0 r11, Function0 r12, Function0 r13, Function0 r14) {
        Intrinsics.checkNotNullParameter(BDLocationException.ERROR_BEACON_ADVERTISING, "id");
        Intrinsics.checkNotNullParameter(r10, "view");
        f(new e(r12, r13, r14, r10, r11, r10, new BottomRightAnimController$postHideLinkAnimation$2(this, r11)));
    }
}
