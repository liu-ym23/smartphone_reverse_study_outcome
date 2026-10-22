package uo8;

import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f550936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f550937b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f550938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JSONObject f550939b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f550940c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f550938a == r101.f550938a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f550939b, r101.f550939b) == true) goto L15;
            return false;
        L15:
            if (this.f550940c == r101.f550940c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f550938a * 31;
            JSONObject r101 = this.f550939b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            long r104 = this.f550940c;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "PictureInnerStreamTraceInfo(position=" + this.f550938a + ", photoViewerReportParams=" + this.f550939b + ", startReadDuration=" + this.f550940c + ')';
        }

        public a() {
            this(0, null, 0);
        }

        public a(int r100, JSONObject r101, long r102) {
            this.f550938a = r100;
            this.f550939b = r101;
            this.f550940c = r102;
        }
    }

    public static final class b implements f09.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f550941a;

        public b() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            a r100 = l.f550936a;
            if (r100 == null) goto L6;
            this.f550941a = r100;
            l.a(l.f550936a);
            l.f550936a = null;
            return;
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            a r100 = this.f550941a;
            if (r100 == null) goto L6;
            a r101 = l.f550936a;
            l.b(r100.f550938a, r100.f550939b);
            this.f550941a = null;
            return;
        }

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
            l.c();
        }
    }

    static {
        f550937b = new b();
    }

    public static void c() {
        a(f550936a);
        f550936a = null;
        AppHost.f326268a.a().c(f550937b);
    }

    public static void a(a r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f550939b == null) goto L8;
        r100.f550939b.put("duration", System.currentTimeMillis() - r100.f550940c);
        FLogger.f375446a.i("PictureInnerStreamTrace", "mobPictureDuration: " + r100.f550939b);
        by7.a r101 = new by7.a("picture_inner_stream_duration");
        r101.f21463a.merge(new TrackParams().merge(r100.f550939b));
        r101.b();
        return;
    }

    public static void b(int r100, JSONObject r101) {
        a r102 = f550936a;
        if (r102 != null) goto L5;
    L10:
        f550936a = new a(r100, r101, System.currentTimeMillis());
        AppHost.f326268a.a().j(f550937b);
        return;
    L5:
        if (r102.f550938a != r100) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L10;
        a(r102);
        goto L10
    L7:
        r103 = false;
        goto L8
    }
}
