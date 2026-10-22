package t2a;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f544238a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f544239b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f544240c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile s2a.a f544241d;

    public c() {
    }

    static {
        f544238a = new c();
        f544239b = LazyKt.lazy(new a());
        f544240c = LazyKt.lazy(new b());
    }

    public static void a() {
        if (f544241d != null) goto L30;
        String r100 = "";
        String r101 = ((Keva) f544239b.getValue()).getString("key_voice_material_response", "");
        if (r101 == null) goto L8;
        r100 = r101;
    L8:
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("[loadVoiceMaterialResponse]: invoke sync dataStr isNotEmpty(");
        boolean r104 = false;
        if (r100.length() <= 0) goto L11;
        boolean r105 = true;
    L12:
        r103.append(r105);
        r103.append(')');
        r102.i("VoiceMaterialRepo", r103.toString());
        if (r100.length() <= 0) goto L15;
        r104 = true;
    L15:
        if (r104 == false) goto L31;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L18
        f544238a.getClass();     // Catch: Throwable -> L18
        Object r107 = Result.m9449constructorimpl((s2a.a) ((Gson) f544240c.getValue()).fromJson(r100, s2a.a.class));     // Catch: Throwable -> L18
    L20:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L24;
        FLogger.f375446a.e("VoiceMaterialRepo", "[loadVoiceMaterialResponse] error", r108);
    L24:
        if (Result.m9455isFailureimpl(r107) == false) goto L26;
        r107 = null;
    L26:
        f544241d = (s2a.a) r107;
        return;
    L18:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L31:
        return;
    L11:
        r105 = false;
        goto L12
    }
}
