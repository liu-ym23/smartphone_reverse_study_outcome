package hc9;

import android.os.SystemClock;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.e0;
import com.larus.platform.exp.p;
import com.larus.utils.logger.FLogger;
import hq9.d1;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: classes29.dex */
public final class d implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f484554a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f484555b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f484556c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f484557d = null;

    public d() {
    }

    @Override // com.larus.platform.api.e0
    public final void a() {
    }

    @Override // com.larus.platform.api.e0
    public final void b() {
    }

    @Override // com.larus.platform.api.e0
    public final void c() {
    }

    static {
        f484554a = new d();
        f484555b = LazyKt.lazy(new a());
        f484556c = LazyKt.lazy(new b());
        f484557d = LazyKt.lazy(new c());
    }

    @Override // com.larus.platform.api.e0
    public final List<Message> d(String r100) {
        CompletableDeferred<Boolean> r101 = wr8.d.f560874a;
        wc9.e r102 = wr8.d.b.a();
        if (r100 == null) goto L11;
        if (r102 == null) goto L6;
        String r103 = r102.f559198a;
    L8:
        if (Intrinsics.areEqual(r103, r100) == true) goto L11;
        return CollectionsKt.emptyList();
    L6:
        r103 = null;
    L11:
        ((k) f484555b.getValue()).getClass();
        FLogger.f375446a.i("PreloadMessagesManager", "[getPreloadMessages], preloadMessagesCache.size = " + k.f484563d.size());
        return k.f484563d;
    }

    @Override // com.larus.platform.api.e0
    public final boolean e(String r110, boolean r111) {
        if (((d1) f484556c.getValue()).b() == true) goto L6;
        FLogger.f375446a.i("PreloadMessagesManager", "[preloadMessages] firstFeedOptConfig not enable");
        return false;
    L6:
        CompletableDeferred<Boolean> r100 = wr8.d.f560874a;
        wc9.e r101 = wr8.d.b.a();
        if (r101 == null) goto L9;
        boolean r102 = true;
    L10:
        Lazy r103 = f484557d;
        if (((hq9.j) r103.getValue()).d() == false) goto L13;
        r102 = true;
    L13:
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("[preloadMessages] pre-loading conditions, cvsId=");
        r105.append(r110);
        r105.append(", mainConversationId=");
        String r106 = null;
        if (r101 == null) goto L16;
        String r107 = r101.f559198a;
    L17:
        r105.append(r107);
        r105.append(", isColdStart=");
        r105.append(r111);
        r105.append(", isColdLandingToMainBot=");
        r105.append(com.larus.bmhome.social.userchat.model.e0.f314123b);
        r105.append(", optNewUser=");
        r105.append(((hq9.j) r103.getValue()).d());
        r104.i("PreloadMessagesManager", r105.toString());
        if (r102 == false) goto L30;
        if (r111 == false) goto L30;
        if (com.larus.bmhome.social.userchat.model.e0.f314123b == false) goto L30;
        if (r110 == null) goto L28;
        if (r101 == null) goto L26;
        r106 = r101.f559198a;
    L26:
        if (Intrinsics.areEqual(r106, r110) == false) goto L30;
    L28:
        r104.i("PreloadMessagesManager", "[preloadMessages] Meeting the pre-loading conditions");
        return true;
    L30:
        r104.i("PreloadMessagesManager", "[preloadMessages] Not meeting the pre-loading conditions");
        return false;
    L16:
        r107 = null;
        goto L17
    L9:
        r102 = false;
        goto L10
    }

    public final void f(String r100, List<Message> r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        CompletableDeferred<Boolean> r102 = wr8.d.f560874a;
        wc9.e r103 = wr8.d.b.a();
        if (r103 == null) goto L5;
        String r104 = r103.f559198a;
    L7:
        if (Intrinsics.areEqual(r104, r100) == false) goto L35;
        ((k) f484555b.getValue()).getClass();
        Intrinsics.checkNotNullParameter(r101, "messages");
        Lazy r105 = k.f484562c;
        if (((d1) r105.getValue()).b() == true) goto L12;
        FLogger.f375446a.i("PreloadMessagesManager", "[savePreloadMessages], enableFirstFeedShowOptV2==false");
        return;
    L12:
        if (p.f365389b == true) goto L34;
        k.b(r101);
        return;
    L34:
        Object r106 = k.f484564e;     // Catch: Exception -> L30
        monitor-enter(r106);     // Catch: Exception -> L30
    L27:
        th = move-exception;
        throw th;     // Catch: Exception -> L30
    L17:
        if (SystemClock.elapsedRealtime() >= k.f484569j) goto L21;
        FLogger.f375446a.i("PreloadMessagesManager", "[savePreloadMessages] discard late save after clear, size=" + r101.size());     // Catch: Throwable -> L27
        monitor-exit(r106);     // Catch: Exception -> L30
        return;
    L21:
        k.f484560a.getClass();     // Catch: Throwable -> L27
        k.f484566g = CollectionsKt.take(r101, ((d1) r105.getValue()).c());     // Catch: Throwable -> L27
        k.f484567h++;     // Catch: Throwable -> L27
        if (k.f484568i != null) goto L24;
        k.f484568i = ((ScheduledExecutorService) k.f484565f.getValue()).schedule(new g(), RangesKt.coerceAtLeast(p.f365390c, 0), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L27
    L24:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r106);     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        FLogger.f375446a.i("PreloadMessagesManager", "savePreloadMessages " + r101.size() + ", " + e);
        return;
    L35:
        return;
    L5:
        r104 = null;
        goto L7
    }
}
