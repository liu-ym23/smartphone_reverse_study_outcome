package com.bytedance.ee.bear.bitable.homepage.badge;

import com.bytedance.ee.bear.bitable.homepage.f0;
import com.bytedance.lark.lark_bitable_android.t;
import com.bytedance.lark.lark_bitable_android.v;
import com.larksuite.framework.callback.UICallbackExecutor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;
import lc5.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f212319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<Object, a> f212320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v f212321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f212322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f212323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f212324f;

    public interface a {
        void a(int r100);
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.homepage.badge.b$b, reason: collision with other inner class name */
    public static final class C3046b {
    }

    public static final class c implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f212325a;

        public c(b r100) {
            this.f212325a = r100;
        }

        @Override // com.bytedance.lark.lark_bitable_android.t
        public final void a(int r100, int r101) {
            b r102 = this.f212325a;
            Object r103 = r102.f212319a;
            monitor-enter(r103);
            r102.j(r100, r101);     // Catch: Throwable -> L7
            Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r103);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    public final void g() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        v r101 = this.f212321c;     // Catch: Throwable -> L9
        if (r101 == null) goto L6;
        r101.c();     // Catch: Throwable -> L9
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L9
    L11:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L14;
        tt5.a.e("FeedInboxBadgeManager", "destroy FeedInboxBadgeContainer failed", r104, false);
    L14:
        this.f212321c = null;
        this.f212322d = 0;
        this.f212323e = 0;
        return;
    L6:
        r102 = null;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static void i() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        f.a r101 = f.f508440a;     // Catch: Throwable -> L8
        com.bytedance.ee.bear.contract.d r102 = f.a.d();     // Catch: Throwable -> L8
        if (r102 == null) goto L5;
        r102.u("ccm_base_im_notice_dot_click", new JSONObject());     // Catch: Throwable -> L8
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L16;
        tt5.a.e("FeedInboxBadgeManager", "report badge dot click failed", r105, false);
        return;
    L16:
        return;
    L5:
        r103 = null;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.badge.d
    public final void a() {
        Object r100 = this.f212319a;
        monitor-enter(r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
        v r102 = this.f212321c;     // Catch: Throwable -> L10
        if (r102 == null) goto L7;
        r102.g();     // Catch: Throwable -> L10
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L10
    L12:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);     // Catch: Throwable -> L17
        if (r105 == null) goto L15;
        tt5.a.e("FeedInboxBadgeManager", "onLeaveHomepageTab failed", r105, false);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r100);
        return;
    L7:
        r103 = null;
    L17:
        th = move-exception;
        throw th;
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L17
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L17
        goto L12
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.badge.d
    public final void b() {
        Object r100 = this.f212319a;
        monitor-enter(r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
        v r102 = this.f212321c;     // Catch: Throwable -> L10
        if (r102 == null) goto L7;
        r102.f();     // Catch: Throwable -> L10
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L10
    L12:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);     // Catch: Throwable -> L17
        if (r105 == null) goto L15;
        tt5.a.e("FeedInboxBadgeManager", "onLeaveFeedTab failed", r105, false);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r100);
        return;
    L7:
        r103 = null;
    L17:
        th = move-exception;
        throw th;
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L17
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L17
        goto L12
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.badge.d
    public final void c() {
        Object r100 = this.f212319a;
        monitor-enter(r100);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.f212322d <= 0) goto L7;
        i();     // Catch: Throwable -> L21
    L7:
        h();     // Catch: Throwable -> L21
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L14
        v r102 = this.f212321c;     // Catch: Throwable -> L14
        if (r102 == null) goto L11;
        r102.e();     // Catch: Throwable -> L14
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);     // Catch: Throwable -> L21
        if (r105 == null) goto L19;
        tt5.a.e("FeedInboxBadgeManager", "onEnterHomepageTab failed", r105, false);     // Catch: Throwable -> L21
    L19:
        monitor-exit(r100);
        return;
    L11:
        r103 = null;
    L14:
        th = move-exception;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L21
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L21
        goto L16
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.badge.d
    public final int d() {
        Object r100 = this.f212319a;
        monitor-enter(r100);
        int r101 = this.f212322d;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.badge.d
    public final void e() {
        Object r100 = this.f212319a;
        monitor-enter(r100);
        h();     // Catch: Throwable -> L18
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        v r102 = this.f212321c;     // Catch: Throwable -> L11
        if (r102 == null) goto L8;
        r102.d();     // Catch: Throwable -> L11
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L11
    L13:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);     // Catch: Throwable -> L18
        if (r105 == null) goto L16;
        tt5.a.e("FeedInboxBadgeManager", "onEnterFeedTab failed", r105, false);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r100);
        return;
    L8:
        r103 = null;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L18
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public final void h() {
        if (this.f212321c == null) goto L32;
        return;
    L32:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L7
        Object r101 = Result.m9449constructorimpl(ULong.m9617boximpl(UStringsKt.toULong(com.bytedance.ee.bear.contract.a.a().docDynamicConfig().f216922f.f216928a)));     // Catch: Throwable -> L7
    L9:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L12;
        tt5.a.e("FeedInboxBadgeManager", "get userId failed", r102, false);
    L12:
        v r103 = null;
        Object r104 = null;
        if (Result.m9455isFailureimpl(r101) == false) goto L15;
        r101 = null;
    L15:
        ULong r105 = (ULong) r101;
        if (r105 != null) goto L34;
    L30:
        this.f212321c = r103;
        return;
    L34:
        Object r106 = Result.m9449constructorimpl(new v(r105.m9675unboximpl(), this.f212324f));     // Catch: Throwable -> L20
    L22:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L26;
        tt5.a.e("FeedInboxBadgeManager", "create FeedInboxBadgeContainer failed", r107, false);
    L26:
        if (Result.m9455isFailureimpl(r106) == true) goto L29;
        r104 = r106;
    L29:
        r103 = (v) r104;
    L20:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public b() {
        this.f212319a = new Object();
        this.f212320b = new LinkedHashMap();
        this.f212324f = new c(this);
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.badge.d
    public final void unregisterListener(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Object r101 = this.f212319a;
        monitor-enter(r101);
        this.f212320b.remove(r100);     // Catch: Throwable -> L10
        if (this.f212320b.isEmpty() == false) goto L7;
        g();     // Catch: Throwable -> L10
    L7:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r101);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.badge.d
    public final void f(Object r100, f0 r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Object r102 = this.f212319a;
        monitor-enter(r102);
        this.f212320b.put(r100, r101);     // Catch: Throwable -> L8
        h();     // Catch: Throwable -> L8
        Pair r103 = TuplesKt.to(Integer.valueOf(this.f212322d), Integer.valueOf(this.f212323e));     // Catch: Throwable -> L8
        monitor-exit(r102);
        UICallbackExecutor.execute(new com.bytedance.ee.bear.bitable.homepage.badge.c(r101, ((Number) r103.getFirst()).intValue(), ((Number) r103.getSecond()).intValue()));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void j(int r100, int r101) {
        if (this.f212322d == r100) goto L5;
    L7:
        this.f212322d = r100;
        this.f212323e = r101;
        Iterator r102 = CollectionsKt.toList(this.f212320b.values()).iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        a r103 = (a) r102.next();
        Intrinsics.checkNotNull(r103);
        UICallbackExecutor.execute(new com.bytedance.ee.bear.bitable.homepage.badge.c(r103, r100, r101));
        goto L9
    L11:
        return;
    L5:
        if (this.f212323e != r101) goto L7;
    }
}
