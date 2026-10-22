package rr9;

import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f539037a = 0;

    /* JADX INFO: renamed from: rr9.a$a, reason: collision with other inner class name */
    public static final class C7527a implements rt7.a {
        public C7527a() {
        }

        @Override // rt7.a
        public final void onReport(String r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r101, "params");
            o.f365780a.reportEvent(r100, new JSONObject(r101));
            FLogger.f375446a.e("QualityReportInitHelper", "event = " + r100 + "  \n params = " + r101);
        }
    }

    public static final class b implements rt7.b {
        public b() {
        }

        @Override // rt7.b
        public final void d(String r100) {
            Intrinsics.checkNotNullParameter("f_quality", "tag");
            Intrinsics.checkNotNullParameter(r100, "msg");
            FLogger.f375446a.d("f_quality", r100);
        }

        @Override // rt7.b
        public final void i(String r100) {
            Intrinsics.checkNotNullParameter("f_quality", "tag");
            Intrinsics.checkNotNullParameter(r100, "msg");
            FLogger.f375446a.i("f_quality", r100);
        }

        @Override // rt7.b
        public final void w(String r100) {
            Intrinsics.checkNotNullParameter("f_quality", "tag");
            Intrinsics.checkNotNullParameter(r100, "msg");
            FLogger.f375446a.w("f_quality", r100);
        }
    }

    static {
    }
}
