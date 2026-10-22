package com.larus.media;

import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class MediaResourceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f358950a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f358951b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f358952c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f358953d = false;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/media/MediaResourceManager$FlowAudioBroadcastEvent;", "", "<init>", "(Ljava/lang/String;I)V", "asrWaitReplyBegin", "asrWaitReplyEnd", "media_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FlowAudioBroadcastEvent extends Enum<FlowAudioBroadcastEvent> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FlowAudioBroadcastEvent[] f358954a = null;
        public static final FlowAudioBroadcastEvent asrWaitReplyBegin = null;
        public static final FlowAudioBroadcastEvent asrWaitReplyEnd = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f358955b = null;

        public static EnumEntries<FlowAudioBroadcastEvent> getEntries() {
            return f358955b;
        }

        static {
            FlowAudioBroadcastEvent r100 = new FlowAudioBroadcastEvent("asrWaitReplyBegin", 0);
            asrWaitReplyBegin = r100;
            FlowAudioBroadcastEvent r101 = new FlowAudioBroadcastEvent("asrWaitReplyEnd", 1);
            asrWaitReplyEnd = r101;
            FlowAudioBroadcastEvent[] r102 = {r100, r101};
            f358954a = r102;
            f358955b = EnumEntriesKt.enumEntries(r102);
        }

        public static FlowAudioBroadcastEvent[] values() {
            return (FlowAudioBroadcastEvent[]) f358954a.clone();
        }

        public static FlowAudioBroadcastEvent valueOf(String r100) {
            return (FlowAudioBroadcastEvent) r27.a.a(FlowAudioBroadcastEvent.class, r100);
        }

        public FlowAudioBroadcastEvent(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/media/MediaResourceManager$FlowAudioBroadcastScene;", "", "Companion", "media_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FlowAudioBroadcastScene {
        public static final int ASR_FAILED = 3;
        public static final int AUDIO_PLAYED = 2;
        public static final a Companion = null;
        public static final int MESSAGE_RECEIVED = 1;
        public static final int MESSAGE_RECEIVED_WITHOUT_MSG = 4;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f358956a = null;

            static {
                f358956a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f358956a;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f358957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f358958b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public FlowAudioBroadcastEvent f358959c;

        public a() {
            this.f358957a = 1;
            this.f358958b = "";
            this.f358959c = FlowAudioBroadcastEvent.asrWaitReplyEnd;
        }
    }

    public MediaResourceManager() {
    }

    static {
        f358950a = LazyKt.lazy(new q());
        f358951b = LazyKt.lazy(new r());
        f358952c = LazyKt.lazy(new s());
        f358953d = z2.f365865a.applyAudioFocusNew();
    }

    public static List f() {
        if (f358953d == false) goto L11;
        CopyOnWriteArrayList<lk9.f> r100 = ((lk9.m) h().f359062a.getValue()).f509637a.a();
        if (r100 == null) goto L21;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L22;
        r101.add(((lk9.f) r102.next()).f509628a.f509609a);
        goto L8
    L22:
        return r101;
    L21:
        return CollectionsKt.emptyList();
    L11:
        CopyOnWriteArrayList<com.larus.media.model.a> r103 = g().f358995a.peek();
        if (r103 == null) goto L18;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L15:
        if (r105.hasNext() == false) goto L23;
        r104.add(((com.larus.media.model.a) r105.next()).f359114b);
        goto L15
    L23:
        return r104;
    L18:
        return CollectionsKt.emptyList();
    }

    public static c0 g() {
        return (c0) f358951b.getValue();
    }

    public static g0 h() {
        return (g0) f358952c.getValue();
    }

    public static void a(com.larus.media.model.a r100) {
        Intrinsics.checkNotNullParameter(r100, "applicant");
        if (f358953d == false) goto L5;
        h().a(r100);
        return;
    L5:
        g().i(r100);
    }

    public static void c(com.larus.media.model.a r100) {
        Intrinsics.checkNotNullParameter(r100, "applicant");
        ((j0) f358950a.getValue()).a(r100);
    }

    public static void d(final a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (f358953d == false) goto L5;
        g0 r101 = h();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        final lk9.m r102 = (lk9.m) r101.f359062a.getValue();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        t0.e(new lk9.l(r102, r100));
        return;
    L5:
        final c0 r103 = g();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        t0.e(new b0(r103, r100));
    }

    public static void e(final Function1 r100) {
        t0.e(new u(r100));
    }

    public static boolean i(@MediaScene String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        c0 r101 = g();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "scene");
        CopyOnWriteArrayList<com.larus.media.model.a> r102 = r101.f358995a.peek();
        if (r102 == null) goto L10;
        Iterator<T> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        if (Intrinsics.areEqual(((com.larus.media.model.a) r103.next()).f359114b, r100) == false) goto L6;
        return true;
    L10:
        return false;
    }

    public static void b(com.larus.media.model.a r100, com.larus.media.model.a r101) {
        Intrinsics.checkNotNullParameter(r100, "playApplicant");
        Intrinsics.checkNotNullParameter(r101, "recordApplicant");
        if (f358953d == false) goto L5;
        h().a(r100);
    L6:
        ((j0) f358950a.getValue()).a(r101);
        return;
    L5:
        g().i(r100);
        goto L6
    }

    public static void j(com.larus.media.model.a r110, com.larus.media.model.a r111, Function1 r210, Function1 r211) {
        Intrinsics.checkNotNullParameter(r110, "request");
        Intrinsics.checkNotNullParameter(r111, "abandon");
        if (f358953d == false) goto L18;
        g0 r100 = h();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "request");
        Intrinsics.checkNotNullParameter(r111, "abandon");
        int r112 = lk9.f.f509627c;
        lk9.f r101 = lk9.f.a.a(r110);
        lk9.f r102 = lk9.f.a.a(r111);
        lk9.m r103 = (lk9.m) r100.f359062a.getValue();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "abandon");
        FLogger r104 = FLogger.f375446a;     // Catch: Exception -> L16
        r104.i("OnMediaStateChangeListener", "request " + r101 + " after abandon media: " + r102);     // Catch: Exception -> L16
        lk9.a r105 = r102.f509628a;     // Catch: Exception -> L16
        q0.a(r105.f509609a, r105.f509610b);     // Catch: Exception -> L16
        r102.a(MediaState.INVALID);     // Catch: Exception -> L16
        if (r103.f509637a.f509632a.isEmpty() == true) goto L14;
        CopyOnWriteArrayList<lk9.f> r106 = r103.f509637a.a();     // Catch: Exception -> L16
        if (r106 == null) goto L14;
        r104.i("OnMediaStateChangeListener", "requestFocusAfterAbandon request " + r101 + " after abandon remove media: " + r102 + ", stack:" + r103.f509637a.f509632a.size());     // Catch: Exception -> L16
        r106.remove(r102);     // Catch: Exception -> L16
        if (r106.isEmpty() == false) goto L14;
        if ((!r103.f509637a.f509632a.isEmpty()) == false) goto L14;
        CopyOnWriteArrayList<lk9.f> r107 = r103.f509637a.f509632a.pollFirst();     // Catch: Exception -> L16
        r104.i("OnMediaStateChangeListener", "requestFocusAfterAbandon pop " + r101 + " after abandon remove media: " + r102 + ", stack:" + r103.f509637a.f509632a.size());     // Catch: Exception -> L16
    L14:
        r104.i("OnMediaStateChangeListener", "request play media focusAfterAbandon media, request : " + r101 + ", abandon : " + r102 + ", stack: " + r103.f509637a.f509632a.size());     // Catch: Exception -> L16
        r103.c(r101, r210, r211, LossFocusType.UNKNOWN_FOCUS_CHANGE);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        String r108 = "exception occurred: " + e.getStackTrace();
        FLogger.f375446a.i("OnMediaStateChangeListener", "requestFocusAfterAbandon media failed, reason: " + r108);
        r211.invoke(r108);
        return;
    L18:
        c0 r109 = g();
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, "request");
        Intrinsics.checkNotNullParameter(r111, "abandon");
        FLogger r113 = FLogger.f375446a;     // Catch: Exception -> L28
        r113.i("OnMediaStateChangeListener", "request " + r110 + " after abandon media: " + r111);     // Catch: Exception -> L28
        q0.a(r111.f359114b, r111.f359117e);     // Catch: Exception -> L28
        r111.a(MediaState.INVALID);     // Catch: Exception -> L28
        if (r109.f358995a.isEmpty() == true) goto L26;
        CopyOnWriteArrayList<com.larus.media.model.a> r114 = r109.f358995a.peek();     // Catch: Exception -> L28
        r113.i("OnMediaStateChangeListener", "requestFocusAfterAbandon request " + r110 + " after abandon remove media: " + r111 + ", stack:" + r109.f358995a.size());     // Catch: Exception -> L28
        r114.remove(r111);     // Catch: Exception -> L28
        if (r114.isEmpty() == false) goto L26;
        if ((!r109.f358995a.isEmpty()) == false) goto L26;
        r109.f358995a.pop();     // Catch: Exception -> L28
        r113.i("OnMediaStateChangeListener", "requestFocusAfterAbandon pop " + r110 + " after abandon remove media: " + r111 + ", stack:" + r109.f358995a.size());     // Catch: Exception -> L28
    L26:
        r113.i("OnMediaStateChangeListener", "request play media focusAfterAbandon media, request : " + r110 + ",abandon : " + r111 + " ,stack: " + r109.f358995a.size());     // Catch: Exception -> L28
        m(r110, r210, r211, 0, 8);     // Catch: Exception -> L28
        return;
    L28:
        e = move-exception;
        String r115 = "exception occurred: " + e.getStackTrace();
        FLogger.f375446a.i("OnMediaStateChangeListener", "requestFocusAfterAbandon media failed, reason: " + r115);
    }

    public static /* synthetic */ void l(com.larus.media.model.a r100, com.larus.media.model.a r101, Function1 r110, Function1 r111, int r112) {
        if ((r112 & 4) == 0) goto L5;
        Function1 r102 = null;
    L7:
        if ((r112 & 8) == 0) goto L9;
        Function1 r103 = null;
    L10:
        k(r100, r101, r102, r103, null, null);
        return;
    L9:
        r103 = r111;
        goto L10
    L5:
        r102 = r110;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void m(com.larus.media.model.a r110, Function1 r111, Function1 r112, int r113, int r114) {
        if ((r114 & 2) == 0) goto L5;
        Function1 r100 = null;
    L7:
        if ((r114 & 4) == 0) goto L9;
        Function1 r101 = null;
    L11:
        if ((r114 & 8) == 0) goto L13;
        int r102 = LossFocusType.UNKNOWN_FOCUS_CHANGE;
    L14:
        Intrinsics.checkNotNullParameter(r110, "applicant");
        if (f358953d == false) goto L17;
        g0 r115 = h();
        r115.getClass();
        Intrinsics.checkNotNullParameter(r110, "applicant");
        int r116 = lk9.f.f509627c;
        ((lk9.m) r115.f359062a.getValue()).c(lk9.f.a.a(r110), r100, r101, r102);
        return;
    L17:
        c0 r103 = g();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r110, "applicant");
        r103.l(r110, r101, r100, r102, System.currentTimeMillis(), true, false);
        return;
    L13:
        r102 = r113;
        goto L14
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public static void k(com.larus.media.model.a r110, com.larus.media.model.a r111, Function1 r112, Function1 r113, Function1 r114, Function1 r115) {
        Intrinsics.checkNotNullParameter(r110, "playApplicant");
        Intrinsics.checkNotNullParameter(r111, "recordApplicant");
        if (f358953d == false) goto L5;
        g0 r100 = h();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "applicant");
        int r101 = lk9.f.f509627c;
        lk9.f r102 = lk9.f.a.a(r110);
        ((lk9.m) r100.f359062a.getValue()).c(r102, r112, r113, LossFocusType.UNKNOWN_FOCUS_CHANGE);
    L6:
        ((j0) f358950a.getValue()).b(r111, r115, r114);
        return;
    L5:
        c0 r103 = g();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r110, "applicant");
        r103.l(r110, r113, r112, LossFocusType.UNKNOWN_FOCUS_CHANGE, System.currentTimeMillis(), true, false);
        goto L6
    }
}
