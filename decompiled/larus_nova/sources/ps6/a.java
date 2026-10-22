package ps6;

import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends ll6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f530440a = null;

    /* JADX INFO: renamed from: ps6.a$a, reason: collision with other inner class name */
    public static final class C7234a implements b {
        public C7234a() {
        }

        @Override // ps6.b
        public final void b() {
        }

        @Override // ps6.b
        public final void c(Map r100) {
            Intrinsics.checkNotNullParameter(r100, "extra");
        }

        @Override // ps6.b
        public final void d() {
        }

        @Override // ps6.b
        @Deprecated(message = "已不建议继续使用AdLog", replaceWith = @ReplaceWith(expression = "logAdOpt()", imports = {}))
        public final void log() {
        }

        @Override // ps6.b
        public final void a(String r100, String r101, String r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter("poi_ad", "tag");
            Intrinsics.checkNotNullParameter(r100, "label");
            Intrinsics.checkNotNullParameter(r101, "refer");
            if (TextUtils.isEmpty(r102) == true) goto L22;
        L9:
            new JSONObject();
        L20:
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L15
            Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L15
            CastLongProtector.parseLong(r102);     // Catch: Throwable -> L15
            if (r103 == null) goto L13;
            CastLongProtector.parseLong(r103);     // Catch: Throwable -> L15
        L13:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            return;
        L5:
            if (r104 != null) goto L7;
            r104 = SliceInitService.DEFAULT_SWITCH;
        L7:
            new JSONObject(r104);     // Catch: JSONException -> L9
            goto L20
        }
    }

    static {
        f530440a = new a();
    }

    @Override // ll6.a, ps6.c
    public final b a() {
        return new C7234a();
    }

    public a() {
    }
}
