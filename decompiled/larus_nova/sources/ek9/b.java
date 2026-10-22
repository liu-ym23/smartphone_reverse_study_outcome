package ek9;

import com.larus.common.apphost.AppHost;
import com.larus.luckydog.api.LuckyDogCountTaskType;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f472953a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile LuckyDogCountTaskType f472954b;

    static {
        f472953a = new b();
    }

    public b() {
    }

    public static LuckyDogCountTaskType a() {
        FLogger.f375446a.i("LuckyDogTaskStorage", "read");
        if (f472954b != null) goto L5;
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        int r101 = AppHost.f326268a.getApplication().getSharedPreferences("lucky_dog_task_sp", 0).getInt("key_lucky_dog_task_type", -1);     // Catch: Throwable -> L8
        LuckyDogCountTaskType.Companion.getClass();     // Catch: Throwable -> L8
        f472954b = LuckyDogCountTaskType.a.a(r101);     // Catch: Throwable -> L8
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L14;
        FLogger.f375446a.e("LuckyDogTaskStorage", "Error in read", r103);
    L14:
        return f472954b;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L5:
        return f472954b;
    }

    public static void b() {
        FLogger.f375446a.i("LuckyDogTaskStorage", "tryInit");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        int r101 = AppHost.f326268a.getApplication().getSharedPreferences("lucky_dog_task_sp", 0).getInt("key_lucky_dog_task_type", -1);     // Catch: Throwable -> L5
        LuckyDogCountTaskType.Companion.getClass();     // Catch: Throwable -> L5
        f472954b = LuckyDogCountTaskType.a.a(r101);     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L13;
        FLogger.f375446a.e("LuckyDogTaskStorage", "Error in tryInit", r103);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void update(LuckyDogCountTaskType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        f472954b = r100;     // Catch: Throwable -> L5
        AppHost.f326268a.getApplication().getSharedPreferences("lucky_dog_task_sp", 0).edit().putInt("key_lucky_dog_task_type", r100.getValue()).apply();     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L13;
        FLogger.f375446a.e("LuckyDogTaskStorage", "Error in update", r103);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
