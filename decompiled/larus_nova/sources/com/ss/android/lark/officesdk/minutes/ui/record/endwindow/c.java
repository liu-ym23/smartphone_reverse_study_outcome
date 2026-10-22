package com.ss.android.lark.officesdk.minutes.ui.record.endwindow;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class c implements j {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c f435866a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f435866a, ((a) r100).f435866a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f435866a.hashCode();
        }

        public final String toString() {
            return "InitData(entity=" + this.f435866a + ')';
        }

        public a(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r100) {
            Intrinsics.checkNotNullParameter(r100, "entity");
            this.f435866a = r100;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f435867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c f435868b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f435867a, r101.f435867a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f435868b, r101.f435868b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f435867a.hashCode() * 31) + this.f435868b.hashCode();
        }

        public final String toString() {
            return "UpdateMarkedSpeaker(clusterId=" + this.f435867a + ", speaker=" + this.f435868b + ')';
        }

        public b(String r100, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r101) {
            Intrinsics.checkNotNullParameter(r100, "clusterId");
            Intrinsics.checkNotNullParameter(r101, MmEndWindowAvatar.TYPE_SPEAKER);
            this.f435867a = r100;
            this.f435868b = r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.endwindow.c$c, reason: collision with other inner class name */
    public static final class C5198c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C5198c f435869a = null;

        static {
            f435869a = new C5198c();
        }

        public final String toString() {
            return "WebViewLoadComplete";
        }

        public C5198c() {
        }
    }

    public c() {
    }
}
