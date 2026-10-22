package com.larus.audio.call.play;

import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class AbsAudioPlayManager implements u68.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f289285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f289286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f289287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f289288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f289289e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0084\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/call/play/AbsAudioPlayManager$Wait;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID", "WAIT", "DATA_END", "STOPPED", "COMPLETE", "PAUSED", "RESUME", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Wait extends Enum<Wait> {
        public static final Wait COMPLETE = null;
        public static final Wait DATA_END = null;
        public static final Wait INVALID = null;
        public static final Wait PAUSED = null;
        public static final Wait RESUME = null;
        public static final Wait STOPPED = null;
        public static final Wait WAIT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Wait[] f289290a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f289291b = null;

        public static EnumEntries<Wait> getEntries() {
            return f289291b;
        }

        static {
            Wait r100 = new Wait("INVALID", 0);
            INVALID = r100;
            Wait r101 = new Wait("WAIT", 1);
            WAIT = r101;
            Wait r102 = new Wait("DATA_END", 2);
            DATA_END = r102;
            Wait r103 = new Wait("STOPPED", 3);
            STOPPED = r103;
            Wait r104 = new Wait("COMPLETE", 4);
            COMPLETE = r104;
            Wait r105 = new Wait("PAUSED", 5);
            PAUSED = r105;
            Wait r110 = new Wait("RESUME", 6);
            RESUME = r110;
            Wait[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f289290a = r111;
            f289291b = EnumEntriesKt.enumEntries(r111);
        }

        public static Wait[] values() {
            return (Wait[]) f289290a.clone();
        }

        public static Wait valueOf(String r100) {
            return (Wait) r27.a.a(Wait.class, r100);
        }

        public Wait(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // u68.a
    public void c(boolean r100) {
    }

    @Override // u68.c
    public void f() {
    }

    public b l() {
        return (b) this.f289288d.getValue();
    }

    @Override // u68.a
    public final void i(u68.a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f289289e.h(r100);
    }

    @Override // u68.a
    public final void j(u68.a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        f r101 = this.f289289e;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (((CopyOnWriteArraySet) r101.f289323b).contains(r100) == false) goto L7;
        ((CopyOnWriteArraySet) r101.f289323b).remove(r100);
        return;
    }

    public AbsAudioPlayManager(boolean r100, boolean r101, Integer r102) {
        this.f289285a = r100;
        this.f289286b = r101;
        this.f289287c = r102;
        hashCode();
        this.f289288d = LazyKt.lazy(new a(this));
        this.f289289e = new f();
    }
}
