package com.obric.audio.enroll;

import com.obric.audio.enroll.view.EnrollStageView;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<a> f395429a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f395430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.obric.audio.enroll.a f395431b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f395430a, r101.f395430a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f395431b, r101.f395431b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f395430a.hashCode() * 31) + this.f395431b.hashCode();
        }

        public final String toString() {
            return "Pending(taskId=" + this.f395430a + ", callback=" + this.f395431b + ')';
        }

        public a(String r100, EnrollStageView r101) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "callback");
            this.f395430a = r100;
            this.f395431b = r101;
        }
    }

    static {
        f395429a = new AtomicReference(null);
    }
}
