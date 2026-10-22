package ec9;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f472129a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f472130b = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/home/impl/privacy/PrivacyCache$getPrivacyWindowClick$1$result$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/home/impl/privacy/PrivacyCache$getPrivacyWindowShow$1$result$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends String>> {
        public b() {
        }
    }

    public b0() {
    }

    static {
        f472129a = new b0();
        f472130b = LazyKt.lazy(new a0());
    }

    public static List b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        SharedPreferences r103 = r100.getSharedPreferences("privacy_window_cache", 4);     // Catch: Throwable -> L13
        if (r103 == null) goto L6;
        String r104 = r103.getString("privacy_window_show_time", "");     // Catch: Throwable -> L13
    L8:
        if (o0.d(r104) == false) goto L10;
        Object r105 = new Gson().fromJson(r104, new b().getType());     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L13
        List r106 = (List) r105;     // Catch: Throwable -> L13
    L11:
        Object r107 = Result.m9449constructorimpl(CollectionsKt.filterNotNull(r106));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r107) == true) goto L20;
        r101 = r107;
    L20:
        return (List) r101;
    L10:
        r106 = CollectionsKt.emptyList();     // Catch: Throwable -> L13
        goto L11
    L6:
        r104 = null;
    L13:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public static Object d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        List r102 = b(r100);     // Catch: Throwable -> L12
        if (r102 != null) goto L6;
        r102 = CollectionsKt.emptyList();     // Catch: Throwable -> L12
    L6:
        List r103 = CollectionsKt.toMutableList(r102);     // Catch: Throwable -> L12
        r103.add(String.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L12
        SharedPreferences r104 = r100.getSharedPreferences("privacy_window_cache", 4);     // Catch: Throwable -> L12
        if (r104 == null) goto L9;
        SharedPreferences.Editor r105 = r104.edit();     // Catch: Throwable -> L12
        r105.putString("privacy_window_show_time", ((Gson) f472130b.getValue()).toJson(r103));     // Catch: Throwable -> L12
        r105.commit();     // Catch: Throwable -> L12
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        return Result.m9449constructorimpl(r106);
    L9:
        r106 = null;
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static List a(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L16
        SharedPreferences r104 = r100.getSharedPreferences("privacy_window_cache", 4);     // Catch: Throwable -> L16
        if (r104 == null) goto L9;
        if (r101 == false) goto L7;
        String r105 = "privacy_window_click_accept_time";
    L8:
        String r106 = r104.getString(r105, "");     // Catch: Throwable -> L16
    L11:
        if (o0.d(r106) == false) goto L13;
        Object r107 = new Gson().fromJson(r106, new a().getType());     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L16
        List r108 = (List) r107;     // Catch: Throwable -> L16
    L14:
        Object r109 = Result.m9449constructorimpl(CollectionsKt.filterNotNull(r108));     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r109) == true) goto L23;
        r102 = r109;
    L23:
        return (List) r102;
    L13:
        r108 = CollectionsKt.emptyList();     // Catch: Throwable -> L16
        goto L14
    L7:
        r105 = "privacy_window_click_cancel_time";
        goto L8
    L9:
        r106 = null;
    L16:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public static void c(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L16
        List r103 = a(r100, r101);     // Catch: Throwable -> L16
        if (r103 != null) goto L6;
        r103 = CollectionsKt.emptyList();     // Catch: Throwable -> L16
    L6:
        List r104 = CollectionsKt.toMutableList(r103);     // Catch: Throwable -> L16
        r104.add(String.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L16
        SharedPreferences r105 = r100.getSharedPreferences("privacy_window_cache", 4);     // Catch: Throwable -> L16
        if (r105 == null) goto L13;
        SharedPreferences.Editor r106 = r105.edit();     // Catch: Throwable -> L16
        if (r101 == false) goto L11;
        String r107 = "privacy_window_click_accept_time";
    L12:
        r106.putString(r107, ((Gson) f472130b.getValue()).toJson(r104));     // Catch: Throwable -> L16
        r106.commit();     // Catch: Throwable -> L16
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        Result.m9449constructorimpl(r108);     // Catch: Throwable -> L16
        return;
    L11:
        r107 = "privacy_window_click_cancel_time";
        goto L12
    L13:
        r108 = null;
    L16:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
