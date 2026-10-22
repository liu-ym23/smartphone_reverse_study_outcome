package com.larus.media;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface v {

    /* JADX INFO: loaded from: classes30.dex */
    public static final class a {
        public static void c(lk9.g r100, lk9.g r101) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
        }

        public static void d(lk9.g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            FLogger.f375446a.i("OnMediaStateChangeListener", "onMediaInterrupted scene=" + r100.getScene() + "   applicant=" + r100);
        }

        public static MediaOccupyStrategy b(lk9.g r100, lk9.g r101) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            FLogger.f375446a.i("OnMediaStateChangeListener", "gainOccupiedStrategy. applicant:" + r101 + ", current: " + r100 + '.');
            return MediaOccupyStrategy.INTERRUPT;
        }

        public static void e(lk9.g r100, lk9.g r101) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            FLogger.f375446a.i("OnMediaStateChangeListener", "onMediaPaused current_scene=" + r100.getScene() + " applicant_scene=" + r101.getScene() + ". current=" + r100 + "     applicant=" + r101);
        }

        public static void f(lk9.g r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            FLogger.f375446a.i("OnMediaStateChangeListener", "onMediaResume. applicant: " + r100 + ", volumeFactor: " + r101);
        }

        public static void g(lk9.g r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            FLogger.f375446a.i("OnMediaStateChangeListener", "onMediaVolumeChange. applicant:" + r100 + ", volumeFactor: " + r101 + '.');
        }

        public static MediaOccupyStrategy a(v r100, lk9.g r101, lk9.g r102, int r103) {
            Intrinsics.checkNotNullParameter(r101, "current");
            Intrinsics.checkNotNullParameter(r102, "applicant");
            r100.d(r101, r102);
            return r100.h(r101, r102, r103);
        }
    }

    void a(lk9.g r100, float r101);

    boolean b(lk9.g r100);

    MediaOccupyStrategy c(lk9.g r100, lk9.g r101, int r102);

    void d(lk9.g r100, lk9.g r101);

    void e(lk9.g r100);

    void f(MediaResourceManager.a r100);

    void g(lk9.g r100, float r101);

    MediaOccupyStrategy h(lk9.g r100, lk9.g r101, int r102);

    void i(lk9.g r100, lk9.g r101);
}
