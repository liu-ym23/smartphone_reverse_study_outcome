package rd4;

import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f537264c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Integer> f537265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f537266b;

    public static final class a {
        public a() {
        }

        public static b a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "jsonObject");
            int r101 = 0;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
            JSONArray r103 = r100.optJSONArray("days");     // Catch: Throwable -> L11
            if (r103 != null) goto L6;
            r103 = new JSONArray();     // Catch: Throwable -> L11
        L6:
            String r104 = r100.optString("url", "");     // Catch: Throwable -> L11
            ArrayList r105 = new ArrayList();     // Catch: Throwable -> L11
            int r106 = r103.length();     // Catch: Throwable -> L11
            int r107 = 0;
        L7:
            if (r107 >= r106) goto L9;
            r105.add(Integer.valueOf(r103.optInt(r107)));     // Catch: Throwable -> L11
            r107 = r107 + 1;     // Catch: Throwable -> L11
            goto L7
        L9:
            return new b(r105, r104);
        L11:
            th = move-exception;
            Result.Companion r108 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            return new b(r101);
        }
    }

    public b() {
        this(0);
    }

    static {
        f537264c = new a();
    }

    public /* synthetic */ b(int r100) {
        this(new ArrayList(), "");
    }

    public b(ArrayList<Integer> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "days");
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f537265a = r100;
        this.f537266b = r101;
    }
}
