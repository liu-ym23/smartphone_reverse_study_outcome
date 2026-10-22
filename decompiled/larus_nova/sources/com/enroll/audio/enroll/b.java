package com.enroll.audio.enroll;

import com.enroll.audio.enroll.view.EnrollStageView;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<a> f273720a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f273721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.enroll.audio.enroll.a f273722b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f273721a, r101.f273721a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f273722b, r101.f273722b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f273721a.hashCode() * 31) + this.f273722b.hashCode();
        }

        public final String toString() {
            return "Pending(taskId=" + this.f273721a + ", callback=" + this.f273722b + ')';
        }

        public a(String r100, EnrollStageView r101) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "callback");
            this.f273721a = r100;
            this.f273722b = r101;
        }
    }

    static {
        f273720a = new AtomicReference(null);
    }
}
