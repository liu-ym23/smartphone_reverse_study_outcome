package io.ktor.client.plugins.cookies;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import io.ktor.http.Url;
import io.ktor.http.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes41.dex */
public final class AcceptAllCookiesStorage implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f491708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutexImpl f491709b;
    private volatile /* synthetic */ long oldestCookie;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    public AcceptAllCookiesStorage() {
        this.f491708a = new ArrayList();
        this.oldestCookie = 0;
        this.f491709b = kotlinx.coroutines.sync.b.a();
    }

    @Override // io.ktor.client.plugins.cookies.a
    public final Object fm(Url r100, Continuation<? super List<d>> r110) {
        if ((r110 instanceof AcceptAllCookiesStorage$get$1) == false) goto L7;
        AcceptAllCookiesStorage$get$1 r101 = (AcceptAllCookiesStorage$get$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        kotlinx.coroutines.sync.a r105 = (kotlinx.coroutines.sync.a) r101.L$2;
        Url r106 = (Url) r101.L$1;
        AcceptAllCookiesStorage r107 = (AcceptAllCookiesStorage) r101.L$0;
        ResultKt.throwOnFailure(r111);
        kotlinx.coroutines.sync.a r112 = r105;
        r100 = r106;
    L39:
        TimeZone r108 = io.ktor.util.date.a.f491954a;     // Catch: Throwable -> L36
        final long r109 = System.currentTimeMillis();     // Catch: Throwable -> L36
        if (r109 < r107.oldestCookie) goto L27;
        CollectionsKt.removeAll(r107.f491708a, new AcceptAllCookiesStorage$cleanup$1(r109));     // Catch: Throwable -> L36
        Iterator r113 = ((ArrayList) r107.f491708a).iterator();     // Catch: Throwable -> L36
        long r114 = Long.MAX_VALUE;
    L22:
        if (r113.hasNext() == false) goto L26;
        hsc.a r115 = ((d) r113.next()).f491846e;     // Catch: Throwable -> L36
        if (r115 == null) goto L22;
        r114 = Math.min(r114, r115.f487089i);     // Catch: Throwable -> L36
        goto L22
    L26:
        r107.oldestCookie = r114;     // Catch: Throwable -> L36
    L27:
        List<d> r116 = r107.f491708a;     // Catch: Throwable -> L36
        ArrayList r117 = new ArrayList();     // Catch: Throwable -> L36
        Iterator r118 = ((ArrayList) r116).iterator();     // Catch: Throwable -> L36
    L28:
        if (r118.hasNext() == false) goto L34;
        Object r119 = r118.next();     // Catch: Throwable -> L36
        if (b.a((d) r119, r100) == false) goto L28;
        r117.add(r119);     // Catch: Throwable -> L36
        goto L28
    L34:
        r112.unlock(null);
        return r117;
    L36:
        th = move-exception;
        r112.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r112 = this.f491709b;
        r101.L$0 = this;
        r101.L$1 = r100;
        r101.L$2 = r112;
        r101.label = 1;
        if (r112.a(null, r101) != r103) goto L17;
        return r103;
    L17:
        r107 = this;
    L7:
        r101 = new AcceptAllCookiesStorage$get$1(this, r110);
        goto L8
    }

    @Override // io.ktor.client.plugins.cookies.a
    public final Object Mc(final Url r100, final d r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof AcceptAllCookiesStorage$addCookie$1) == false) goto L7;
        AcceptAllCookiesStorage$addCookie$1 r101 = (AcceptAllCookiesStorage$addCookie$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = true;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r101.L$3;
        r110 = (d) r101.L$2;
        Url r107 = (Url) r101.L$1;
        AcceptAllCookiesStorage r108 = (AcceptAllCookiesStorage) r101.L$0;
        ResultKt.throwOnFailure(r112);
        kotlinx.coroutines.sync.a r113 = r106;
        r100 = r107;
    L48:
    L45:
        th = move-exception;
        r113.unlock(null);
        throw th;
    L19:
        if (StringsKt.isBlank(r110.f491842a) == true) goto L42;
        CollectionsKt.removeAll(r108.f491708a, new AcceptAllCookiesStorage$addCookie$2$2(r110, r100));     // Catch: Throwable -> L45
        List<d> r109 = r108.f491708a;     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r110, "<this>");     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r100, "requestUrl");     // Catch: Throwable -> L45
        String r114 = r110.f491848g;     // Catch: Throwable -> L45
        if (r114 != null) goto L23;
    L25:
        boolean r115 = false;
    L26:
        if (r115 == true) goto L28;
        d r116 = d.a(r110, null, r100.a(), 959);     // Catch: Throwable -> L45
    L29:
        String r117 = r116.f491847f;     // Catch: Throwable -> L45
        if (r117 != null) goto L32;
    L35:
        if (r105 == false) goto L37;
        r116 = d.a(r116, r100.f491817b, null, 991);     // Catch: Throwable -> L45
    L37:
        ((ArrayList) r109).add(r116);     // Catch: Throwable -> L45
        hsc.a r118 = r110.f491846e;     // Catch: Throwable -> L45
        if (r118 == null) goto L42;
        long r119 = r118.f487089i;     // Catch: Throwable -> L45
        if (r108.oldestCookie <= r119) goto L42;
        r108.oldestCookie = r119;     // Catch: Throwable -> L45
        goto L42
    L32:
        if (StringsKt.isBlank(r117) == true) goto L35;
        r105 = false;
        goto L35
    L28:
        r116 = r110;
        goto L29
    L23:
        if (StringsKt.startsWith$default(r114, HTTP.URL_DEFAULT, false, 2, null) != true) goto L25;
        r115 = true;
    L42:
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L45
        r113.unlock(null);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        r113 = this.f491709b;
        r101.L$0 = this;
        r101.L$1 = r100;
        r101.L$2 = r110;
        r101.L$3 = r113;
        r101.label = 1;
        if (r113.a(null, r101) != r103) goto L17;
        return r103;
    L17:
        r108 = this;
    L7:
        r101 = new AcceptAllCookiesStorage$addCookie$1(this, r111);
        goto L8
    }
}
