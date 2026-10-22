package rvb;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmSubtitleAsrOptConfig;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.helper.MmSubtitleSmoothType;
import com.ss.android.lark.pb.minutes.v1.RecordingSubtitleData;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmSubtitleSmoothType f539511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f539512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f539513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<Long, d> f539514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<Long, Boolean> f539515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f539516f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Handler f539517g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f539518h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<c> f539519i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f539520j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MmSubtitleAsrOptConfig f539521k;

    /* JADX INFO: renamed from: rvb.a$a, reason: collision with other inner class name */
    public static final class C7541a {
    }

    public static abstract class b {

        /* JADX INFO: renamed from: rvb.a$b$a, reason: collision with other inner class name */
        public static final class C7542a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C7542a f539522a = null;

            static {
                f539522a = new C7542a();
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C7542a) == true) goto L9;
                return false;
            L9:
                C7542a r101 = (C7542a) r100;
                return true;
            }

            public final int hashCode() {
                return 734576710;
            }

            public final String toString() {
                return "Finished";
            }

            public C7542a() {
            }
        }

        /* JADX INFO: renamed from: rvb.a$b$b, reason: collision with other inner class name */
        public static final class C7543b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C7543b f539523a = null;

            static {
                f539523a = new C7543b();
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C7543b) == true) goto L9;
                return false;
            L9:
                C7543b r101 = (C7543b) r100;
                return true;
            }

            public final int hashCode() {
                return 1589704869;
            }

            public final String toString() {
                return "NoChange";
            }

            public C7543b() {
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f539524a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L9;
                return false;
            L9:
                if (this.f539524a == ((c) r100).f539524a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f539524a;
            }

            public final String toString() {
                return "Progress(nextIndex=" + this.f539524a + ')';
            }

            public c(int r100) {
                this.f539524a = r100;
            }
        }

        public b() {
        }
    }

    public interface c {
        void a(RecordingSubtitleData r100, String r101, MmSubtitleSmoothType r102);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecordingSubtitleData f539525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f539526b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f539525a, r101.f539525a) == true) goto L12;
            return false;
        L12:
            if (this.f539526b == r101.f539526b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f539525a.hashCode() * 31) + this.f539526b;
        }

        public final String toString() {
            return "SmoothSubtitleState(data=" + this.f539525a + ", progress=" + this.f539526b + ')';
        }

        public d(RecordingSubtitleData r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f539525a = r100;
            this.f539526b = r101;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f539527a;

        public e(a r100) {
            this.f539527a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Handler r100 = this.f539527a.f539517g;     // Catch: Throwable -> L12
            if (r100 == null) goto L5;
            r100.removeCallbacksAndMessages(null);     // Catch: Throwable -> L12
        L5:
            Handler r101 = this.f539527a.f539517g;     // Catch: Throwable -> L12
            if (r101 == null) goto L10;
            Looper r102 = r101.getLooper();     // Catch: Throwable -> L12
            if (r102 == null) goto L10;
            ThreadMethodProxy.quit(r102);     // Catch: Throwable -> L12
        L10:
            this.f539527a.f539517g = null;     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L16;
            return;
        L16:
            throw th;
        }
    }

    static {
    }

    public final void a() {
        lvb.a.e(this.f539513c, "clearCache");
        this.f539514d.clear();
        this.f539518h.set(false);
        this.f539516f.clear();
        Handler r100 = this.f539517g;
        if (r100 == null) goto L6;
        r100.post(new e(this));
        return;
    }

    public static boolean b(RecordingSubtitleData r100) {
        if (r100.sound_type == RecordingSubtitleData.SoundType.NOISE) goto L10;
        RecordingSubtitleData.Subtitle r101 = r100.target;
        if (r101 == null) goto L10;
        if (TextUtils.isEmpty(r101.content) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public a(MmSubtitleSmoothType r100, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r101) {
        Intrinsics.checkNotNullParameter(r100, "smoothType");
        Intrinsics.checkNotNullParameter(r101, "mmUccApi");
        this.f539511a = r100;
        this.f539512b = r101;
        this.f539513c = "MmSmoothSubtitleManager_" + r100.name();
        this.f539514d = new ConcurrentHashMap();
        this.f539515e = new ConcurrentHashMap();
        this.f539516f = new ConcurrentHashMap();
        this.f539518h = new AtomicBoolean(false);
        this.f539519i = new CopyOnWriteArrayList();
        this.f539520j = 100;
        this.f539521k = r101.getSettingsService().f434075f;
    }

    public final void c(RecordingSubtitleData r100, String r101) {
        if (this.f539518h.get() == false) goto L8;
        Iterator r102 = ((CopyOnWriteArrayList) this.f539519i).iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ((c) r102.next()).a(r100, r101, this.f539511a);
        goto L6
    L10:
        return;
    }
}
