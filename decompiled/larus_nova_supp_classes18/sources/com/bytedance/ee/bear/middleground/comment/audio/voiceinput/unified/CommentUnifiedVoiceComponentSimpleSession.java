package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceLog;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.voiceinput.api.data.model.record.VoiceRecordState;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommentUnifiedVoiceComponentSimpleSession implements CommentUnifiedVoiceComponentSessionCoordinator.d, k {
    public static final /* synthetic */ int r = 0;
    public final Activity a;
    public final Fragment b;
    public final String c;
    public final String d;
    public final String e;
    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.o f;
    public final Function1<Fragment, CommentUnifiedVoiceComponentSessionCoordinator> g;
    public final Function1<Fragment, Lifecycle> h;
    public final n i;
    public final g j;
    public final Function0<String> k;
    public b l;
    public final LinkedHashMap<String, c> m;
    public final Set<String> n;
    public c o;
    public boolean p;
    public boolean q;

    public static final class a {
    }

    public static final class b {
        public final Object a;
        public final CommentUnifiedVoiceComponentSessionCoordinator b;
        public final CommentUnifiedVoiceComponentSessionCoordinator.c c;
        public final ViewGroup d;
        public final Lifecycle e;
        public final DefaultLifecycleObserver f;
        public final o g;
        public boolean h;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
            if (this.h == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "ProviderHost(token=" + this.a + ", coordinator=" + this.b + ", lease=" + this.c + ", viewOwner=" + this.d + ", lifecycle=" + this.e + ", lifecycleObserver=" + this.f + ", provider=" + this.g + ", released=" + this.h + ')';
        }

        public b(Object r2, CommentUnifiedVoiceComponentSessionCoordinator r3, CommentUnifiedVoiceComponentSessionCoordinator.c r4, ViewGroup r5, Lifecycle r6, CommentUnifiedVoiceComponentSimpleSession$enter$lifecycleObserver$1 r7, o r8) {
            Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r3, "coordinator");
            Intrinsics.checkNotNullParameter(r4, "lease");
            Intrinsics.checkNotNullParameter(r5, "viewOwner");
            Intrinsics.checkNotNullParameter(r6, "lifecycle");
            Intrinsics.checkNotNullParameter(r7, "lifecycleObserver");
            Intrinsics.checkNotNullParameter(r8, "provider");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = false;
        }
    }

    public static final class c {
        public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p a;
        public String b;
        public boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            int r5 = (r3 + r1) * 31;
            if (this.c == false) goto L13;
            int r6 = 1231;
        L15:
            return r5 + r6;
        L13:
            r6 = 1237;
            goto L15
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "TaskRoute(target=" + this.a + ", taskId=" + this.b + ", waitingFinal=" + this.c + ')';
        }

        public c(com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p r1) {
            this.a = r1;
            this.b = null;
            this.c = false;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[VoiceRecordState.values().length];
            r0[VoiceRecordState.Stopped.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[VoiceRecordState.Canceled.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[VoiceRecordState.Failed.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[VoiceRecordState.Preparing.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[VoiceRecordState.Prepared.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[VoiceRecordState.Recording.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[VoiceRecordState.Idle.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[VoiceRecordState.Destroy.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.CommentUnifiedVoiceComponentSessionCoordinator.d
    public final void a() {
        tt5.a.h("CommentVoice", "[simple] revoked for replacement");
        l(null);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.k
    public final boolean b() {
        boolean r1 = false;
        if (this.o == null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        StringBuilder r3 = new StringBuilder("[simple] cancel requested, host=");
        if (this.l == null) goto L12;
        r1 = true;
    L12:
        r3.append(r1);
        r3.append(", tasks=");
        r3.append(this.m.size());
        tt5.a.h("CommentVoice", r3.toString());
        l(null);
        return r0;
    L5:
        if ((!this.m.isEmpty()) == true) goto L8;
        r0 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.k
    public final boolean c() {
        b r3 = this.l;
        if (r3 != null) goto L5;
    L11:
        l(null);
        StringBuilder r4 = new StringBuilder("[simple] enter requested, ");
        CommentVoiceLog r7 = CommentVoiceLog.a;
        String r8 = this.d;
        r7.getClass();
        r4.append(CommentVoiceLog.d("fileId", r8));
        tt5.a.h("CommentVoice", r4.toString());
        Fragment r9 = this.b;
        if (r9 != null) goto L15;
        i("simple voice fragment is missing");
        return false;
    L15:
        ViewGroup r15 = (ViewGroup) this.f.a.invoke();
        if (r15 != null) goto L19;
        i("simple voice overlay is missing");
        return false;
    L19:
        CommentUnifiedVoiceComponentSessionCoordinator r14 = (CommentUnifiedVoiceComponentSessionCoordinator) this.g.invoke(r9);
        CommentUnifiedVoiceComponentSessionCoordinator.c r13 = r14.acquire(this);
        if (r13.b.isCurrent(r13) == true) goto L23;
        tt5.a.k("CommentVoice", "[simple] enter aborted: lease=" + r13.a + " was superseded");
        return false;
    L23:
        final Object r12 = new Object();
        FrameLayout r11 = new FrameLayout(r15.getContext());
        r11.setBackgroundColor(0);
        r11.setClickable(false);
        r11.setFocusable(false);
        LifecycleObserver r10 = new CommentUnifiedVoiceComponentSimpleSession$enter$lifecycleObserver$1(this, r12);
        Lifecycle r16 = (Lifecycle) this.h.invoke(r9);     // Catch: Throwable -> L72
        if (r16.getCurrentState() == Lifecycle.State.DESTROYED) goto L108;
        FrameLayout r5 = r11;
        CommentUnifiedVoiceComponentSessionCoordinator r26 = r14;
        u r2 = this.i.a(new p(r9, this.c, this.d, this.e, (String) this.k.invoke(), new m(new CommentUnifiedVoiceComponentSimpleSession$enter$provider$1(this, r12), new CommentUnifiedVoiceComponentSimpleSession$enter$provider$2(this, r12), new CommentUnifiedVoiceComponentSimpleSession$enter$provider$3(this, r12))));     // Catch: Throwable -> L63
        b r6 = new b(r12, r26, r13, r5, r16, r10, r2);     // Catch: Throwable -> L63
        this.l = r6;     // Catch: Throwable -> L61
        r16.addObserver(r10);     // Catch: Throwable -> L61
        if (j(r6) == true) goto L96;
        this.l = null;     // Catch: Throwable -> L44
        d(r6);     // Catch: Throwable -> L44
        return false;
    L44:
        th = th;
    L60:
        CommentUnifiedVoiceComponentSessionCoordinator.c r17 = r13;
    L75:
        k("enter simple voice failed", th);
        if (r6 != null) goto L78;
        r26.release(r17);
    L82:
        g r0 = this.j;
        tt5.a.h("CommentVoice", "[simple] safely() show simple voice failure");     // Catch: Throwable -> L85
        r0.c();     // Catch: Throwable -> L85
    L87:
        return false;
    L85:
        th = move-exception;
        k("show simple voice failure", th);
        goto L87
    L78:
        if (this.l != r6) goto L80;
        this.l = null;
    L80:
        d(r6);
        goto L82
    L96:
        r15.addView(r5, new ViewGroup.LayoutParams(-1, -1));     // Catch: Throwable -> L59
        r2.a(r5);     // Catch: Throwable -> L59
        if (r5.getChildCount() <= 0) goto L50;
        boolean r18 = true;
    L95:
        if (r18 == false) goto L58;
        r5.bringToFront();     // Catch: Throwable -> L59
        StringBuilder r19 = new StringBuilder("[simple] provider host entered, lease=");     // Catch: Throwable -> L59
        r19.append(r13.a);     // Catch: Throwable -> L55
        r19.append(", ");     // Catch: Throwable -> L55
        r19.append(CommentVoiceLog.d("fileId", this.d));     // Catch: Throwable -> L55
        tt5.a.h("CommentVoice", r19.toString());     // Catch: Throwable -> L55
        return true;
    L58:
        throw new IllegalStateException("Voice view was not attached to its activation owner".toString());     // Catch: Throwable -> L55
    L55:
        th = th;
        r17 = r5;
        goto L75
    L50:
        r18 = false;
    L59:
        th = th;
    L61:
        th = th;
        r17 = r13;
    L63:
        th = th;
        CommentUnifiedVoiceComponentSessionCoordinator.c r20 = r13;
    L65:
        CommentUnifiedVoiceComponentSessionCoordinator.c r21 = r20;
    L74:
        r6 = null;
        r17 = r21;
    L66:
        th = th;
        r20 = r13;
        r26 = r14;
    L68:
        th = th;
        r26 = r14;
        r20 = r13;
    L70:
        th = th;
        r20 = r13;
        r26 = r14;
        goto L65
    L108:
        r14.release(r13);     // Catch: Throwable -> L28
        tt5.a.k("CommentVoice", "[simple] enter aborted: lifecycle destroyed, lease=" + r13.a);     // Catch: Throwable -> L28
        return false;
    L28:
        th = th;
    L29:
        r21 = r13;
        r26 = r14;
    L72:
        th = th;
        goto L29
    L5:
        if (j(r3) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L11;
        tt5.a.h("CommentVoice", "[simple] reuse provider host, lease=" + r3.c.a);
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.k
    public final void destroy() {
        tt5.a.h("CommentVoice", "[simple] destroy");
        l(null);
    }

    public final String f() {
        c r0 = this.o;
        if (r0 != null) goto L5;
    L12:
        Iterator<T> r1 = this.m.entrySet().iterator();
        Object r2 = null;
    L14:
        if (r1.hasNext() == false) goto L18;
        Object r3 = r1.next();
        if ((!((c) ((Map.Entry) r3).getValue()).c) == false) goto L14;
        r2 = r3;
        goto L14
    L18:
        Map.Entry r4 = (Map.Entry) r2;
        if (r4 == null) goto L21;
        String r5 = (String) r4.getKey();
    L22:
        if (r5 == null) goto L30;
        tt5.a.h("CommentVoice", "[currentRecordingTaskId] =".concat(r5));
        return r5;
    L30:
        return null;
    L21:
        r5 = null;
        goto L22
    L5:
        if (r0.c == false) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        r5 = r0.b;
        if (r5 == null) goto L12;
        goto L12
    }

    public final void g() {
        if (this.p == false) goto L12;
        this.p = false;
        g r0 = this.j;
        tt5.a.h("CommentVoice", "[simple] safely() dismiss simple voice recognizing");     // Catch: Throwable -> L7
        r0.f();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        k("dismiss simple voice recognizing", th);
        return;
    }

    public final void h() {
        c r0 = this.o;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L21;
        Collection<c> r3 = this.m.values();
        if (r3.isEmpty() == false) goto L12;
    L11:
        boolean r4 = false;
    L18:
        if (r4 == true) goto L21;
        r1 = false;
        goto L21
    L12:
        Iterator<T> r5 = r3.iterator();
    L14:
        if (r5.hasNext() == false) goto L11;
        if (((c) r5.next()).c == false) goto L14;
        r4 = true;
    L21:
        if (r1 == true) goto L27;
        g();
        return;
    L27:
        return;
    L5:
        if (r0.c != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void m() {
        if (this.q == true) goto L5;
        return;
    L5:
        this.q = false;
        Function1<Boolean, Unit> r0 = this.f.e;
        if (r0 == null) goto L9;
        r0.invoke(Boolean.FALSE);
        return;
    }

    public final void d(b r5) {
        if (r5.h == false) goto L5;
        return;
    L5:
        r5.h = true;
        o r1 = r5.g;
        tt5.a.h("CommentVoice", "[simple] safely() destroy simple voice provider");     // Catch: Throwable -> L8
        r1.onDestroy();     // Catch: Throwable -> L8
    L36:
        tt5.a.h("CommentVoice", "[simple] safely() remove simple voice lifecycle observer");     // Catch: Throwable -> L12
        r5.e.removeObserver(r5.f);     // Catch: Throwable -> L12
    L30:
        tt5.a.h("CommentVoice", "[simple] safely() remove simple voice view owner");     // Catch: Throwable -> L22
        ViewParent r2 = r5.d.getParent();     // Catch: Throwable -> L22
        if ((r2 instanceof ViewGroup) == false) goto L17;
        ViewGroup r3 = (ViewGroup) r2;     // Catch: Throwable -> L22
    L18:
        if (r3 == null) goto L20;
        r3.removeView(r5.d);     // Catch: Throwable -> L22
    L20:
        r5.d.removeAllViews();     // Catch: Throwable -> L22
    L34:
        tt5.a.h("CommentVoice", "[simple] safely() release simple voice session");     // Catch: Throwable -> L26
        r5.b.release(r5.c);     // Catch: Throwable -> L26
    L28:
        tt5.a.h("CommentVoice", "[simple] provider host released, lease=" + r5.c.a);
        return;
    L26:
        th = move-exception;
        k("release simple voice session", th);
        goto L28
    L17:
        r3 = null;
    L22:
        th = move-exception;
        k("remove simple voice view owner", th);
    L12:
        th = move-exception;
        k("remove simple voice lifecycle observer", th);
    L8:
        th = move-exception;
        k("destroy simple voice provider", th);
        goto L36
    }

    public final void e(String r4) {
        if (r4 != null) goto L5;
        c r1 = this.o;
    L19:
        if (r4 == null) goto L21;
        this.n.add(r4);
    L21:
        if (r1 != null) goto L23;
        return;
    L23:
        String r5 = r1.b;
        if (r5 == null) goto L26;
        c r6 = this.m.remove(r5);
    L26:
        String r7 = r1.b;
        if (r7 == null) goto L30;
        this.n.add(r7);
    L30:
        if (this.o != r1) goto L32;
        this.o = null;
    L32:
        h();
        return;
    L5:
        r1 = this.m.remove(r4);
        if (r1 != null) goto L19;
        r1 = this.o;
        if (r1 == null) goto L18;
        String r2 = r1.b;
        if (r2 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == false) goto L18;
    L12:
        if (Intrinsics.areEqual(r2, r4) == true) goto L15;
        r3 = false;
    L18:
        r1 = null;
        goto L19
    }

    public final void i(String r3) {
        k(r3, new IllegalStateException(r3));
        g r4 = this.j;
        tt5.a.h("CommentVoice", "[simple] safely() show simple voice failure");     // Catch: Throwable -> L5
        r4.c();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        k("show simple voice failure", th);
    }

    public final boolean j(b r3) {
        if (this.l != r3) goto L9;
        CommentUnifiedVoiceComponentSessionCoordinator.c r0 = r3.c;
        if (r0.b.isCurrent(r0) == false) goto L9;
        if (r3.h == true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void l(Object r4) {
        b r0 = this.l;
        if (r0 == null) goto L8;
        if (r4 != null) goto L6;
    L7:
        this.l = null;
        m();
        this.m.clear();
        this.n.clear();
        this.o = null;
        g();
        d(r0);
        return;
    L6:
        if (r0.a == r4) goto L7;
    L8:
        if (r4 != null) goto L12;
        m();
        this.m.clear();
        this.n.clear();
        this.o = null;
        g();
        return;
    }

    public final void k(String r3, Throwable r4) {
        tt5.a.e("CommentVoice", "[simple] ".concat(r3), r4, false);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.k
    public final boolean onTouch(View r6, MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r6, "source");
        Intrinsics.checkNotNullParameter(r7, "event");
        if (r7.getActionMasked() != 0) goto L14;
        b r0 = this.l;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L14;
        if (c() == true) goto L14;
        return false;
    L7:
        if (j(r0) != true) goto L9;
        r1 = true;
    L14:
        b r2 = this.l;
        if (r2 != null) goto L17;
    L55:
        m();
        return false;
    L17:
        if (j(r2) == true) goto L20;
        r2 = null;
    L20:
        if (r2 == null) goto L55;
        if (r7.getActionMasked() != 0) goto L59;
        if (this.q == true) goto L30;
        this.q = true;
        Function1<Boolean, Unit> r3 = this.f.e;
        if (r3 == null) goto L30;
        r3.invoke(Boolean.TRUE);
    L30:
        this.o = new c((com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p) this.f.b.invoke());
        tt5.a.h("CommentVoice", "[onTouch] currentTaskRoute=" + this.o);
    L59:
        boolean r8 = r2.g.onTouch(r6, r7);     // Catch: Throwable -> L43
        if (r7.getActionMasked() != 0) goto L38;
        if (r8 == false) goto L36;
        ViewGroup r4 = r2.d;     // Catch: Throwable -> L43
        r4.post(new q(this, r2, r4));     // Catch: Throwable -> L43
        goto L38
    L36:
        this.o = null;     // Catch: Throwable -> L43
        m();     // Catch: Throwable -> L43
    L38:
        if (r7.getActionMasked() != 1) goto L40;
    L41:
        m();
    L42:
        return r8;
    L40:
        if (r7.getActionMasked() != 3) goto L42;
    L43:
        th = move-exception;
    L48:
        th = move-exception;
        if (r7.getActionMasked() != 1) goto L52;
    L53:
        m();
    L54:
        throw th;
    L52:
        if (r7.getActionMasked() != 3) goto L54;
    L45:
        if (r7.getActionMasked() != 0) goto L47;
        m();     // Catch: Throwable -> L48
    L47:
        throw th;     // Catch: Throwable -> L48
    }

    public CommentUnifiedVoiceComponentSimpleSession(Activity r7, Fragment r8, String r9, String r10, String r11, com.bytedance.ee.bear.middleground.comment.audio.voiceinput.o r12) {
        AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
        AnonymousClass2 r1 = AnonymousClass2.INSTANCE;
        v r2 = v.a;
        CommentUnifiedVoiceComponentToastFeedback r3 = new CommentUnifiedVoiceComponentToastFeedback(r7);
        AnonymousClass3 r4 = AnonymousClass3.INSTANCE;
        Intrinsics.checkNotNullParameter(r7, "hostActivity");
        Intrinsics.checkNotNullParameter(r9, "psdaToken");
        Intrinsics.checkNotNullParameter(r10, "fileId");
        Intrinsics.checkNotNullParameter(r11, "fileType");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r0, "coordinatorProvider");
        Intrinsics.checkNotNullParameter(r1, "lifecycleProvider");
        Intrinsics.checkNotNullParameter(r2, "providerFactory");
        Intrinsics.checkNotNullParameter(r3, "feedback");
        Intrinsics.checkNotNullParameter(r4, "traceIdFactory");
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r0;
        this.h = r1;
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.m = new LinkedHashMap();
        this.n = new LinkedHashSet();
    }
}
