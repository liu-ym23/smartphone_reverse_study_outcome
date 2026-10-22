package yub;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.ss.android.lark.officesdk.minutes.service.fileupload.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public interface a {

    /* JADX INFO: renamed from: yub.a$a, reason: collision with other inner class name */
    public static final class C8392a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f569255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f569256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f569257c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f569258d;

        public C8392a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C8392a) == true) goto L8;
            return false;
        L8:
            C8392a r101 = (C8392a) r100;
            if (Intrinsics.areEqual(this.f569255a, r101.f569255a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f569256b, r101.f569256b) == true) goto L15;
            return false;
        L15:
            if (this.f569257c == r101.f569257c) goto L18;
            return false;
        L18:
            if (this.f569258d == r101.f569258d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f569255a.hashCode() * 31) + this.f569256b.hashCode()) * 31;
            int r101 = 1231;
            if (this.f569257c == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f569258d == true) goto L11;
            r101 = 1237;
        L11:
            return r103 + r101;
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "AppStateInfo(topProcessName=" + this.f569255a + ", topActivityName=" + this.f569256b + ", isAppFront=" + this.f569257c + ", isProcessFront=" + this.f569258d + ')';
        }

        public /* synthetic */ C8392a(int r100) {
            this("", "", false, false);
        }

        public C8392a(String r100, String r101, boolean r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "topProcessName");
            Intrinsics.checkNotNullParameter(r101, "topActivityName");
            this.f569255a = r100;
            this.f569256b = r101;
            this.f569257c = r102;
            this.f569258d = r103;
        }
    }

    public interface b {
        void onActivityCreated(Activity r100);

        void onActivityDestroyed(Activity r100);

        void onActivityPaused(Activity r100);

        void onActivityResumed(Activity r100);

        void onActivitySaveInstanceState(Activity r100, Bundle r101);

        void onActivityStarted(Activity r100);

        void onActivityStopped(Activity r100);
    }

    public interface c {
        void a(C8392a r100, C8392a r101);
    }

    void a(k r100);

    void b(k r100);

    Context getContext();
}
