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
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceLog;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.voiceinput.api.data.model.record.VoiceRecordState;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
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

/* JADX INFO: loaded from: classes18.dex */
public final class CommentUnifiedVoiceComponentSimpleSession implements CommentUnifiedVoiceComponentSessionCoordinator.d, k {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f230593r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f230594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f230595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f230596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f230597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f230598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.o f230599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<Fragment, CommentUnifiedVoiceComponentSessionCoordinator> f230600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<Fragment, Lifecycle> f230601h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n f230602i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final g f230603j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<String> f230604k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f230605l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedHashMap<String, c> f230606m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Set<String> f230607n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c f230608o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f230609p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f230610q;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f230611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CommentUnifiedVoiceComponentSessionCoordinator f230612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CommentUnifiedVoiceComponentSessionCoordinator.c f230613c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ViewGroup f230614d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Lifecycle f230615e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final DefaultLifecycleObserver f230616f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final o f230617g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f230618h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f230611a, r101.f230611a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f230612b, r101.f230612b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f230613c, r101.f230613c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f230614d, r101.f230614d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f230615e, r101.f230615e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f230616f, r101.f230616f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f230617g, r101.f230617g) == true) goto L30;
            return false;
        L30:
            if (this.f230618h == r101.f230618h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((((((this.f230611a.hashCode() * 31) + this.f230612b.hashCode()) * 31) + this.f230613c.hashCode()) * 31) + this.f230614d.hashCode()) * 31) + this.f230615e.hashCode()) * 31) + this.f230616f.hashCode()) * 31) + this.f230617g.hashCode()) * 31;
            if (this.f230618h == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "ProviderHost(token=" + this.f230611a + ", coordinator=" + this.f230612b + ", lease=" + this.f230613c + ", viewOwner=" + this.f230614d + ", lifecycle=" + this.f230615e + ", lifecycleObserver=" + this.f230616f + ", provider=" + this.f230617g + ", released=" + this.f230618h + ')';
        }

        public b(Object r100, CommentUnifiedVoiceComponentSessionCoordinator r101, CommentUnifiedVoiceComponentSessionCoordinator.c r102, ViewGroup r103, Lifecycle r104, CommentUnifiedVoiceComponentSimpleSession$enter$lifecycleObserver$1 r105, o r106) {
            Intrinsics.checkNotNullParameter(r100, "token");
            Intrinsics.checkNotNullParameter(r101, "coordinator");
            Intrinsics.checkNotNullParameter(r102, "lease");
            Intrinsics.checkNotNullParameter(r103, "viewOwner");
            Intrinsics.checkNotNullParameter(r104, NewBroadcastMonitor.STAGE.LIFECYCLE);
            Intrinsics.checkNotNullParameter(r105, "lifecycleObserver");
            Intrinsics.checkNotNullParameter(r106, ShortVideoSegments.KEY_PROP_PROVIDER);
            this.f230611a = r100;
            this.f230612b = r101;
            this.f230613c = r102;
            this.f230614d = r103;
            this.f230615e = r104;
            this.f230616f = r105;
            this.f230617g = r106;
            this.f230618h = false;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p f230619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f230620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f230621c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f230619a, r101.f230619a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f230620b, r101.f230620b) == true) goto L15;
            return false;
        L15:
            if (this.f230621c == r101.f230621c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p r100 = this.f230619a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f230620b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            int r105 = (r103 + r101) * 31;
            if (this.f230621c == false) goto L13;
            int r106 = 1231;
        L15:
            return r105 + r106;
        L13:
            r106 = 1237;
            goto L15
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "TaskRoute(target=" + this.f230619a + ", taskId=" + this.f230620b + ", waitingFinal=" + this.f230621c + ')';
        }

        public c(com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p r100) {
            this.f230619a = r100;
            this.f230620b = null;
            this.f230621c = false;
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f230622a = null;

        static {
            int[] r100 = new int[VoiceRecordState.values().length];
            r100[VoiceRecordState.Stopped.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[VoiceRecordState.Canceled.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[VoiceRecordState.Failed.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[VoiceRecordState.Preparing.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[VoiceRecordState.Prepared.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[VoiceRecordState.Recording.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[VoiceRecordState.Idle.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[VoiceRecordState.Destroy.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f230622a = r100;
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
        boolean r100 = false;
        if (this.f230608o == null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        StringBuilder r102 = new StringBuilder("[simple] cancel requested, host=");
        if (this.f230605l == null) goto L12;
        r100 = true;
    L12:
        r102.append(r100);
        r102.append(", tasks=");
        r102.append(this.f230606m.size());
        tt5.a.h("CommentVoice", r102.toString());
        l(null);
        return r101;
    L5:
        if ((!this.f230606m.isEmpty()) == true) goto L8;
        r101 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [androidx.lifecycle.LifecycleObserver, com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.CommentUnifiedVoiceComponentSimpleSession$enter$lifecycleObserver$1] */
    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.k
    public final boolean c() {
        b r100 = this.f230605l;
        if (r100 != null) goto L5;
    L11:
        l(null);
        StringBuilder r101 = new StringBuilder("[simple] enter requested, ");
        CommentVoiceLog r102 = CommentVoiceLog.f230370a;
        String r103 = this.f230597d;
        r102.getClass();
        r101.append(CommentVoiceLog.d("fileId", r103));
        tt5.a.h("CommentVoice", r101.toString());
        Fragment r104 = this.f230595b;
        if (r104 != null) goto L15;
        i("simple voice fragment is missing");
        return false;
    L15:
        ViewGroup r110 = this.f230599f.f230498a.invoke();
        if (r110 != null) goto L19;
        i("simple voice overlay is missing");
        return false;
    L19:
        CommentUnifiedVoiceComponentSessionCoordinator r111 = this.f230600g.invoke(r104);
        CommentUnifiedVoiceComponentSessionCoordinator.c r112 = r111.acquire(this);
        if (r112.f230592b.isCurrent(r112) == true) goto L23;
        tt5.a.k("CommentVoice", "[simple] enter aborted: lease=" + r112.f230591a + " was superseded");
        return false;
    L23:
        final Object r113 = new Object();
        FrameLayout r114 = new FrameLayout(r110.getContext());
        r114.setBackgroundColor(0);
        r114.setClickable(false);
        r114.setFocusable(false);
        ?? r115 = new CommentUnifiedVoiceComponentSimpleSession$enter$lifecycleObserver$1(this, r113);
        Lifecycle r105 = this.f230601h.invoke(r104);     // Catch: Throwable -> L72
        if (r105.getCurrentState() == Lifecycle.State.DESTROYED) goto L108;
        FrameLayout r106 = r114;
        CommentUnifiedVoiceComponentSessionCoordinator r210 = r111;
        u r107 = this.f230602i.a(new p(r104, this.f230596c, this.f230597d, this.f230598e, this.f230604k.invoke(), new m(new CommentUnifiedVoiceComponentSimpleSession$enter$provider$1(this, r113), new CommentUnifiedVoiceComponentSimpleSession$enter$provider$2(this, r113), new CommentUnifiedVoiceComponentSimpleSession$enter$provider$3(this, r113))));     // Catch: Throwable -> L63
        b r108 = new b(r113, r210, r112, r106, r105, r115, r107);     // Catch: Throwable -> L63
        this.f230605l = r108;     // Catch: Throwable -> L61
        r105.addObserver(r115);     // Catch: Throwable -> L61
        if (j(r108) == true) goto L96;
        this.f230605l = null;     // Catch: Throwable -> L44
        d(r108);     // Catch: Throwable -> L44
        return false;
    L44:
        th = th;
    L60:
        CommentUnifiedVoiceComponentSessionCoordinator.c r109 = r112;
    L75:
        k("enter simple voice failed", th);
        if (r108 != null) goto L78;
        r210.release(r109);
    L82:
        g r116 = this.f230603j;
        tt5.a.h("CommentVoice", "[simple] safely() show simple voice failure");     // Catch: Throwable -> L85
        r116.c();     // Catch: Throwable -> L85
    L87:
        return false;
    L85:
        th = move-exception;
        k("show simple voice failure", th);
        goto L87
    L78:
        if (this.f230605l != r108) goto L80;
        this.f230605l = null;
    L80:
        d(r108);
        goto L82
    L96:
        r110.addView(r106, new ViewGroup.LayoutParams(-1, -1));     // Catch: Throwable -> L59
        r107.a(r106);     // Catch: Throwable -> L59
        if (r106.getChildCount() <= 0) goto L50;
        boolean r117 = true;
    L95:
        if (r117 == false) goto L58;
        r106.bringToFront();     // Catch: Throwable -> L59
        StringBuilder r118 = new StringBuilder("[simple] provider host entered, lease=");     // Catch: Throwable -> L59
        r118.append(r112.f230591a);     // Catch: Throwable -> L55
        r118.append(", ");     // Catch: Throwable -> L55
        r118.append(CommentVoiceLog.d("fileId", this.f230597d));     // Catch: Throwable -> L55
        tt5.a.h("CommentVoice", r118.toString());     // Catch: Throwable -> L55
        return true;
    L58:
        throw new IllegalStateException("Voice view was not attached to its activation owner".toString());     // Catch: Throwable -> L55
    L55:
        th = th;
        r109 = r106;
        goto L75
    L50:
        r117 = false;
    L59:
        th = th;
    L61:
        th = th;
        r109 = r112;
    L63:
        th = th;
        CommentUnifiedVoiceComponentSessionCoordinator.c r119 = r112;
    L65:
        CommentUnifiedVoiceComponentSessionCoordinator.c r120 = r119;
    L74:
        r108 = null;
        r109 = r120;
    L66:
        th = th;
        r119 = r112;
        r210 = r111;
    L68:
        th = th;
        r210 = r111;
        r119 = r112;
    L70:
        th = th;
        r119 = r112;
        r210 = r111;
        goto L65
    L108:
        r111.release(r112);     // Catch: Throwable -> L28
        tt5.a.k("CommentVoice", "[simple] enter aborted: lifecycle destroyed, lease=" + r112.f230591a);     // Catch: Throwable -> L28
        return false;
    L28:
        th = th;
    L29:
        r120 = r112;
        r210 = r111;
    L72:
        th = th;
        goto L29
    L5:
        if (j(r100) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L11;
        tt5.a.h("CommentVoice", "[simple] reuse provider host, lease=" + r100.f230613c.f230591a);
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.k
    public final void destroy() {
        tt5.a.h("CommentVoice", "[simple] destroy");
        l(null);
    }

    public final String f() {
        c r100 = this.f230608o;
        if (r100 != null) goto L5;
    L12:
        Iterator<T> r101 = this.f230606m.entrySet().iterator();
        Object r102 = null;
    L14:
        if (r101.hasNext() == false) goto L18;
        Object r103 = r101.next();
        if ((!((c) ((Map.Entry) r103).getValue()).f230621c) == false) goto L14;
        r102 = r103;
        goto L14
    L18:
        Map.Entry r104 = (Map.Entry) r102;
        if (r104 == null) goto L21;
        String r105 = (String) r104.getKey();
    L22:
        if (r105 == null) goto L30;
        tt5.a.h("CommentVoice", "[currentRecordingTaskId] =".concat(r105));
        return r105;
    L30:
        return null;
    L21:
        r105 = null;
        goto L22
    L5:
        if (r100.f230621c == false) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L12;
        r105 = r100.f230620b;
        if (r105 == null) goto L12;
        goto L12
    }

    public final void g() {
        if (this.f230609p == false) goto L12;
        this.f230609p = false;
        g r100 = this.f230603j;
        tt5.a.h("CommentVoice", "[simple] safely() dismiss simple voice recognizing");     // Catch: Throwable -> L7
        r100.f();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        k("dismiss simple voice recognizing", th);
        return;
    }

    public final void h() {
        c r100 = this.f230608o;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L21;
        Collection<c> r103 = this.f230606m.values();
        if (r103.isEmpty() == false) goto L12;
    L11:
        boolean r104 = false;
    L18:
        if (r104 == true) goto L21;
        r101 = false;
        goto L21
    L12:
        Iterator<T> r105 = r103.iterator();
    L14:
        if (r105.hasNext() == false) goto L11;
        if (((c) r105.next()).f230621c == false) goto L14;
        r104 = true;
    L21:
        if (r101 == true) goto L27;
        g();
        return;
    L27:
        return;
    L5:
        if (r100.f230621c != true) goto L7;
        r102 = true;
        goto L8
    }

    public final void m() {
        if (this.f230610q == true) goto L5;
        return;
    L5:
        this.f230610q = false;
        Function1<Boolean, Unit> r100 = this.f230599f.f230502e;
        if (r100 == null) goto L9;
        r100.invoke(Boolean.FALSE);
        return;
    }

    public final void d(b r100) {
        if (r100.f230618h == false) goto L5;
        return;
    L5:
        r100.f230618h = true;
        o r101 = r100.f230617g;
        tt5.a.h("CommentVoice", "[simple] safely() destroy simple voice provider");     // Catch: Throwable -> L8
        r101.onDestroy();     // Catch: Throwable -> L8
    L36:
        tt5.a.h("CommentVoice", "[simple] safely() remove simple voice lifecycle observer");     // Catch: Throwable -> L12
        r100.f230615e.removeObserver(r100.f230616f);     // Catch: Throwable -> L12
    L30:
        tt5.a.h("CommentVoice", "[simple] safely() remove simple voice view owner");     // Catch: Throwable -> L22
        ViewParent r102 = r100.f230614d.getParent();     // Catch: Throwable -> L22
        if ((r102 instanceof ViewGroup) == false) goto L17;
        ViewGroup r103 = (ViewGroup) r102;     // Catch: Throwable -> L22
    L18:
        if (r103 == null) goto L20;
        r103.removeView(r100.f230614d);     // Catch: Throwable -> L22
    L20:
        r100.f230614d.removeAllViews();     // Catch: Throwable -> L22
    L34:
        tt5.a.h("CommentVoice", "[simple] safely() release simple voice session");     // Catch: Throwable -> L26
        r100.f230612b.release(r100.f230613c);     // Catch: Throwable -> L26
    L28:
        tt5.a.h("CommentVoice", "[simple] provider host released, lease=" + r100.f230613c.f230591a);
        return;
    L26:
        th = move-exception;
        k("release simple voice session", th);
        goto L28
    L17:
        r103 = null;
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

    public final void e(String r100) {
        if (r100 != null) goto L5;
        c r101 = this.f230608o;
    L19:
        if (r100 == null) goto L21;
        this.f230607n.add(r100);
    L21:
        if (r101 != null) goto L23;
        return;
    L23:
        String r102 = r101.f230620b;
        if (r102 == null) goto L26;
        c r103 = this.f230606m.remove(r102);
    L26:
        String r104 = r101.f230620b;
        if (r104 == null) goto L30;
        this.f230607n.add(r104);
    L30:
        if (this.f230608o != r101) goto L32;
        this.f230608o = null;
    L32:
        h();
        return;
    L5:
        r101 = this.f230606m.remove(r100);
        if (r101 != null) goto L19;
        r101 = this.f230608o;
        if (r101 == null) goto L18;
        String r105 = r101.f230620b;
        if (r105 != null) goto L12;
    L15:
        boolean r106 = true;
    L16:
        if (r106 == false) goto L18;
    L12:
        if (Intrinsics.areEqual(r105, r100) == true) goto L15;
        r106 = false;
    L18:
        r101 = null;
        goto L19
    }

    public final void i(String r100) {
        k(r100, new IllegalStateException(r100));
        g r101 = this.f230603j;
        tt5.a.h("CommentVoice", "[simple] safely() show simple voice failure");     // Catch: Throwable -> L5
        r101.c();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        k("show simple voice failure", th);
    }

    public final boolean j(b r100) {
        if (this.f230605l != r100) goto L9;
        CommentUnifiedVoiceComponentSessionCoordinator.c r101 = r100.f230613c;
        if (r101.f230592b.isCurrent(r101) == false) goto L9;
        if (r100.f230618h == true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void l(Object r100) {
        b r101 = this.f230605l;
        if (r101 == null) goto L8;
        if (r100 != null) goto L6;
    L7:
        this.f230605l = null;
        m();
        this.f230606m.clear();
        this.f230607n.clear();
        this.f230608o = null;
        g();
        d(r101);
        return;
    L6:
        if (r101.f230611a == r100) goto L7;
    L8:
        if (r100 != null) goto L12;
        m();
        this.f230606m.clear();
        this.f230607n.clear();
        this.f230608o = null;
        g();
        return;
    }

    public final void k(String r100, Throwable r101) {
        tt5.a.e("CommentVoice", "[simple] ".concat(r100), r101, false);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.k
    public final boolean onTouch(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r101.getActionMasked() != 0) goto L14;
        b r102 = this.f230605l;
        if (r102 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L14;
        if (c() == true) goto L14;
        return false;
    L7:
        if (j(r102) != true) goto L9;
        r103 = true;
    L14:
        b r104 = this.f230605l;
        if (r104 != null) goto L17;
    L55:
        m();
        return false;
    L17:
        if (j(r104) == true) goto L20;
        r104 = null;
    L20:
        if (r104 == null) goto L55;
        if (r101.getActionMasked() != 0) goto L59;
        if (this.f230610q == true) goto L30;
        this.f230610q = true;
        Function1<Boolean, Unit> r105 = this.f230599f.f230502e;
        if (r105 == null) goto L30;
        r105.invoke(Boolean.TRUE);
    L30:
        this.f230608o = new c(this.f230599f.f230499b.invoke());
        tt5.a.h("CommentVoice", "[onTouch] currentTaskRoute=" + this.f230608o);
    L59:
        boolean r106 = r104.f230617g.onTouch(r100, r101);     // Catch: Throwable -> L43
        if (r101.getActionMasked() != 0) goto L38;
        if (r106 == false) goto L36;
        ViewGroup r107 = r104.f230614d;     // Catch: Throwable -> L43
        r107.post(new q(this, r104, r107));     // Catch: Throwable -> L43
        goto L38
    L36:
        this.f230608o = null;     // Catch: Throwable -> L43
        m();     // Catch: Throwable -> L43
    L38:
        if (r101.getActionMasked() != 1) goto L40;
    L41:
        m();
    L42:
        return r106;
    L40:
        if (r101.getActionMasked() != 3) goto L42;
    L43:
        th = move-exception;
    L48:
        th = move-exception;
        if (r101.getActionMasked() != 1) goto L52;
    L53:
        m();
    L54:
        throw th;
    L52:
        if (r101.getActionMasked() != 3) goto L54;
    L45:
        if (r101.getActionMasked() != 0) goto L47;
        m();     // Catch: Throwable -> L48
    L47:
        throw th;     // Catch: Throwable -> L48
    }

    public CommentUnifiedVoiceComponentSimpleSession(Activity r100, Fragment r101, String r102, String r110, String r111, com.bytedance.ee.bear.middleground.comment.audio.voiceinput.o r112) {
        AnonymousClass1 r103 = AnonymousClass1.INSTANCE;
        AnonymousClass2 r104 = AnonymousClass2.INSTANCE;
        v r105 = v.f230672a;
        CommentUnifiedVoiceComponentToastFeedback r106 = new CommentUnifiedVoiceComponentToastFeedback(r100);
        AnonymousClass3 r107 = AnonymousClass3.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "hostActivity");
        Intrinsics.checkNotNullParameter(r102, "psdaToken");
        Intrinsics.checkNotNullParameter(r110, "fileId");
        Intrinsics.checkNotNullParameter(r111, "fileType");
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "coordinatorProvider");
        Intrinsics.checkNotNullParameter(r104, "lifecycleProvider");
        Intrinsics.checkNotNullParameter(r105, "providerFactory");
        Intrinsics.checkNotNullParameter(r106, "feedback");
        Intrinsics.checkNotNullParameter(r107, "traceIdFactory");
        this.f230594a = r100;
        this.f230595b = r101;
        this.f230596c = r102;
        this.f230597d = r110;
        this.f230598e = r111;
        this.f230599f = r112;
        this.f230600g = r103;
        this.f230601h = r104;
        this.f230602i = r105;
        this.f230603j = r106;
        this.f230604k = r107;
        this.f230606m = new LinkedHashMap();
        this.f230607n = new LinkedHashSet();
    }
}
