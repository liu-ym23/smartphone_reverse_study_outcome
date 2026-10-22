package com.larus.camera.impl.edulibs.camera;

import android.content.Context;
import com.larus.camera.impl.edulibs.cameraapi.IdentifyDetectionResult;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import nx8.d;
import nx8.i;
import nx8.k;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f321539a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f321540b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f321541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static nx8.a f321542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, IdentifyDetectionResult> f321543e = null;

    /* JADX INFO: renamed from: com.larus.camera.impl.edulibs.camera.a$a, reason: collision with other inner class name */
    public static final class C4146a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4146a f321544a = null;

        static {
            f321544a = new C4146a();
        }

        public C4146a() {
        }

        @Override // nx8.k
        public final void d(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            FLogger.f375446a.d(r100, r101);
        }

        @Override // nx8.k
        public final void i(String r100, String r101) {
            Intrinsics.checkNotNullParameter("EduCamera", "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            FLogger.f375446a.i("EduCamera", r101);
        }

        @Override // nx8.k
        public final void e(String r100, String r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            FLogger.f375446a.e(r100, r101, r102);
        }
    }

    public static final class b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f321545a;

        public b(k r100) {
            Intrinsics.checkNotNullParameter(r100, "logger");
            this.f321545a = r100;
        }

        @Override // nx8.k
        public final void d(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            this.f321545a.d("EduCamera", "[" + r100 + ']' + r101);
        }

        @Override // nx8.k
        public final void i(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            this.f321545a.i("EduCamera", "[" + r100 + ']' + r101);
        }

        @Override // nx8.k
        public final void e(String r100, String r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            this.f321545a.e("EduCamera", "[" + r100 + ']' + r101, r102);
        }
    }

    public a() {
    }

    static {
        f321539a = new a();
        f321540b = new d(0);
        f321541c = new b(C4146a.f321544a);
        f321543e = new LinkedHashMap();
    }

    public final c a(Context r100, i r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "eduImageScene");
        return new c(r100, r101, r102);
    }
}
