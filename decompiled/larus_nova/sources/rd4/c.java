package rd4;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f537267d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f537268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f537269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f537270c;

    public static final class a {
        public a() {
        }

        public static c a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "jsonObject");
            int r101 = 0;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
            return new c(r100.optLong("timeout", 0), r100.optString("url", ""), r100.optInt("load_times", 0));
        L5:
            th = move-exception;
            Result.Companion r103 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            return new c(r101);
        }
    }

    public c() {
        this(0);
    }

    static {
        f537267d = new a();
    }

    public /* synthetic */ c(int r100) {
        this(0, "", 10);
    }

    public c(long r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f537268a = r100;
        this.f537269b = r101;
        this.f537270c = r102;
    }
}
