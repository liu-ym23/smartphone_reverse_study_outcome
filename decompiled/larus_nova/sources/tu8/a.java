package tu8;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.im.bean.bot.FirstMet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f547640a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Keva f547641b = null;

    public a() {
    }

    static {
        f547640a = new a();
        f547641b = Keva.getRepo("create_bot_cache", 0);
    }

    public static Object a(FirstMet r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        if (r100 != null) goto L6;
        f547641b.erase("key_create_bot_first_met");     // Catch: Throwable -> L9
    L7:
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L6:
        f547641b.storeString("key_create_bot_first_met", new Gson().toJson(r100));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
