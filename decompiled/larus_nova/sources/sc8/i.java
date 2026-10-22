package sc8;

import android.os.Handler;
import android.os.Looper;
import com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f541403a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f541404b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f541405c = null;

    public i() {
    }

    static {
        f541403a = new i();
        f541404b = new Handler(Looper.getMainLooper());
        f541405c = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new c());
    }

    public static void a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Iterator r101 = b(r100.f541378a).iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        BubbleBannerSourceListener r102 = (BubbleBannerSourceListener) r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        r102.i(r100);     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L4;
        FLogger.f375446a.w("BubbleBannerEventDispatcher", "dispatch click failed, bannerSource=" + r100.f541378a + ", promptId=" + r100.f541379b, r105);
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static List b(String r100) {
        Lazy r101 = f541405c;
        List r102 = (List) ((Map) r101.getValue()).get("*");
        if (r102 != null) goto L5;
        r102 = CollectionsKt.emptyList();
    L5:
        if (r100 == null) goto L7;
        f541403a.getClass();
        List r103 = (List) ((Map) r101.getValue()).get(r100);
    L8:
        if (r103 != null) goto L11;
        r103 = CollectionsKt.emptyList();
    L11:
        if (r102.isEmpty() == false) goto L14;
        return r103;
    L14:
        return CollectionsKt.plus(r102, r103);
    L7:
        r103 = null;
        goto L8
    }

    public static void c(final Function0 r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        f541404b.post(new h(r100));
    }
}
