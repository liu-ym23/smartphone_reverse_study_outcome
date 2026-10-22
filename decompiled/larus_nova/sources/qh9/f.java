package qh9;

import com.bytedance.keva.Keva;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import n38.b0;
import org.json.JSONObject;
import xp9.n;

/* JADX INFO: loaded from: classes30.dex */
public final class f implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f533017a = null;

    static {
        f533017a = new f();
    }

    public f() {
    }

    public static void b(Object r100, String r101, String r102) {
        if ((r100 instanceof OfficeSDKGlobalApi) == false) goto L5;
        OfficeSDKGlobalApi r103 = (OfficeSDKGlobalApi) r100;
    L6:
        if (r103 == null) goto L21;
        aza.c r104 = (aza.c) r103.getService(aza.c.class);
        if (r104 != null) goto L19;
        return;
    L19:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L13
        r104.d3(r101);     // Catch: Throwable -> L13
        FLogger.f375446a.i("LarkSocialUserIdCacheClean", "clearFeedLocalCacheData " + r101 + ' ' + r102 + " success");     // Catch: Throwable -> L13
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L22;
        FLogger.f375446a.e("LarkSocialUserIdCacheClean", "clearFeedLocalCacheData " + r101 + ' ' + r102 + " failed", r107);
        return;
    L22:
        return;
    L13:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L21:
        return;
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [T, kotlin.jvm.functions.Function1, qh9.e] */
    @Override // n38.b0
    public final void a(final String r100, final String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "appUserId");
        Intrinsics.checkNotNullParameter(r101, "oldLarkUserId");
        Intrinsics.checkNotNullParameter(r102, "newLarkUserId");
        FLogger r103 = FLogger.f375446a;
        r103.i("LarkSocialUserIdCacheClean", "onLarkUserIdChanged, doubao_uid=" + r100 + ", lark_uid=" + r101 + "->" + r102);
        Object r104 = n.f564774a;
        if (r104 == null) goto L5;
        b(r104, r100, r101);
    L6:
        String r105 = uh9.d.b();
        ((Keva) uh9.d.f550114a.getValue()).storeBoolean(r105, false);
        r103.w("DouBaoFeedMigrationState", "clearMigrateFinished cacheKey=" + r105);
        JSONObject r106 = new JSONObject();
        r106.put("uid", r100);
        r106.put("lark_uid", r101 + "->" + r102);
        g.f365738a.monitorEventForSlardar("lark_uid_changed_clear_cache", r106, null, null);
        return;
    L5:
        r103.i("LarkSocialUserIdCacheClean", "clearFeedLocalCacheWhenGlobalApiReady");
        final AtomicBoolean r107 = new AtomicBoolean(false);
        final Ref.ObjectRef r108 = new Ref.ObjectRef();
        ?? r109 = new e(r107, r108, r100, r101);
        r108.element = r109;
        n.a(r109);
        goto L6
    }
}
