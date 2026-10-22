package z50;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.service.LevelAbility;
import com.facebook.keyframes.model.KFAnimation;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements LevelAbility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f570045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f570046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f570047c = null;

    public a() {
    }

    static {
        f570047c = new a();
        f570046b = 3;
    }

    @Override // com.bytedance.android.livesdkapi.service.LevelAbility
    public final boolean onLevelChange(int r100) {
        if (r100 >= 0) goto L5;
        f570045a = true;
    L6:
        return true;
    L5:
        f570045a = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.service.AtomicAbility
    public final void onPropertyChange(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L21
        Object r102 = r100.get("trace_atomic_ability_cache_time");     // Catch: Throwable -> L21
        Object r103 = null;
        if (r102 != null) goto L6;
    L8:
        r102 = null;
    L10:
        if ((r102 instanceof String) == false) goto L13;
        r103 = r102;
    L13:
        String r104 = (String) r103;     // Catch: Throwable -> L21
        if (r104 == null) goto L18;
        Integer r105 = StringsKt.toIntOrNull(r104);     // Catch: Throwable -> L21
        if (r105 == null) goto L18;
        int r106 = r105.intValue();     // Catch: Throwable -> L21
    L19:
        f570046b = r106;     // Catch: Throwable -> L21
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L29;
        ALogger.e("LiveTraceScheduleAtomicAbility", "setProperty error " + r108.getMessage());
        return;
    L29:
        return;
    L18:
        r106 = 3;
        goto L19
    L6:
        if ((r102 instanceof String) == false) goto L8;
    L21:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }
}
