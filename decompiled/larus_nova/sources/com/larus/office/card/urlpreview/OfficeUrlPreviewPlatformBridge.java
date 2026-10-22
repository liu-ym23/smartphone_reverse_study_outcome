package com.larus.office.card.urlpreview;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.LruCache;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.home.impl.sdk.office.FlowOfficeUrlPreviewHostService;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import com.larus.platform.api.IOfficeUrlPreviewHostService;
import com.larus.platform.api.OfficeUrlPreviewHostCardType;
import com.larus.platform.api.OfficeUrlPreviewHostRenderResult;
import com.larus.platform.api.q4;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class OfficeUrlPreviewPlatformBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OfficeUrlPreviewPlatformBridge f361768a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<c2, z0> f361769b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LruCache<String, d> f361770c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final kotlinx.coroutines.sync.a[] f361771d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final IdentityHashMap<LifecycleOwner, PageBinding> f361772e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final LinkedHashMap<String, IdentityHashMap<LifecycleOwner, a>> f361773f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final IdentityHashMap<ViewGroup, PageBinding> f361774g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final IdentityHashMap<ViewGroup, b> f361775h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Handler f361776i = null;

    public static final class PageBinding {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LifecycleOwner f361777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile int f361778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IdentityHashMap<ViewGroup, b> f361779c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinkedHashSet<String> f361780d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final LinkedHashSet<String> f361781e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final LinkedHashSet<String> f361782f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Map<String, Integer> f361783g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map<String, a> f361784h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f361785i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f361786j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final u1 f361787k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final com.larus.platform.api.z0 f361788l;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Runnable f361789a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f361789a, ((a) r100).f361789a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f361789a.hashCode();
            }

            public final String toString() {
                return "ScheduledRenderRetry(runnable=" + this.f361789a + ')';
            }

            public a(Runnable r100) {
                Intrinsics.checkNotNullParameter(r100, "runnable");
                this.f361789a = r100;
            }
        }

        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f361790a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f361791b = null;

            static {
                int[] r100 = new int[Lifecycle.Event.values().length];
                r100[Lifecycle.Event.ON_PAUSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
            L24:
                r100[Lifecycle.Event.ON_RESUME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
            L30:
                r100[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
            L8:
                f361790a = r100;
                int[] r101 = new int[OfficeUrlPreviewHostRenderResult.values().length];
                r101[OfficeUrlPreviewHostRenderResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
            L26:
                r101[OfficeUrlPreviewHostRenderResult.RENDER_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
            L32:
                r101[OfficeUrlPreviewHostRenderResult.NO_DATA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
            L22:
                r101[OfficeUrlPreviewHostRenderResult.NO_RENDER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
            L13:
                f361791b = r101;
            }
        }

        public final void e() {
            this.f361777a.getLifecycle().removeObserver(this.f361787k);
            Iterator r100 = ((LinkedHashMap) this.f361784h).values().iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            OfficeUrlPreviewPlatformBridge.f361776i.removeCallbacks(((a) r100.next()).f361789a);
            goto L4
        L6:
            ((LinkedHashMap) this.f361784h).clear();
            List r101 = CollectionsKt.toList(this.f361780d);
            FLogger.f375446a.i("OfficeUrlPreviewSDK", "[SDK][page_service_released] maxWidth=" + this.f361778b + ", previewIds=" + r101);
            Iterator r102 = r101.iterator();
        L8:
            if (r102.hasNext() == false) goto L14;
            String r103 = (String) r102.next();
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L12
            this.f361788l.s(r103);     // Catch: Throwable -> L12
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L8
        L14:
            this.f361779c.clear();
            this.f361780d.clear();
            this.f361781e.clear();
            this.f361782f.clear();
            ((LinkedHashMap) this.f361783g).clear();
        }

        public final void i() {
            OfficeUrlPreviewPlatformBridge r100 = OfficeUrlPreviewPlatformBridge.f361768a;
            monitor-enter(r100);
            List r101 = CollectionsKt.toList(this.f361779c.values());     // Catch: Throwable -> L11
            monitor-exit(r100);
            FLogger.f375446a.i("OfficeUrlPreviewSDK", "[SDK][detail_return_refresh_started] candidateCount=" + r101.size() + ", maxWidth=" + this.f361778b);
            Iterator r102 = r101.iterator();
        L8:
            if (r102.hasNext() == false) goto L10;
            final b r103 = (b) r102.next();
            r103.f361805h.post(new w1(this, r103));
            goto L8
        L10:
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public final void a(b r100) {
            Intrinsics.checkNotNullParameter(r100, "request");
            m(r100.f361804g, "bind");
            b r101 = this.f361779c.get(r100.f361805h);
            boolean r102 = false;
            if (r101 == null) goto L31;
            Intrinsics.checkNotNullParameter(r100, "other");
            if (Intrinsics.areEqual(r101.f361801d, r100.f361801d) == true) goto L7;
        L13:
            boolean r103 = false;
        L14:
            if (r103 == false) goto L31;
            r100.f361809l = r101.f361809l;
            r100.f361810m = r101.f361810m;
            r100.f361811n = r101.f361811n;
            this.f361779c.put(r100.f361805h, r100);
            OfficeUrlPreviewPlatformBridge.i(OfficeUrlPreviewPlatformBridge.f361768a, "preview_binding_reused", r100);
            OfficeUrlPreviewHostCardType r104 = r101.f361803f;
            OfficeUrlPreviewHostCardType r105 = r100.f361803f;
            if (r104 == r105) goto L18;
        L20:
            if (r104 == r105) goto L22;
        L27:
            if (r104 == r105) goto L29;
            r100.f361805h.removeAllViews();
        L29:
            g(r100);
            return;
        L22:
            if (r100.f361809l != OfficeUrlPreviewHostRenderResult.RENDER_FAILED) goto L27;
            if (r100.f361811n == false) goto L26;
            OfficeUrlPreviewPlatformBridge.h("preview_recovery_waiting", r100, "result=RENDER_FAILED");
            return;
        L26:
            OfficeUrlPreviewPlatformBridge.h("render_result_reused", r100, "result=RENDER_FAILED");
            r100.f361806i.invoke(Boolean.FALSE);
            return;
        L18:
            if (r100.f361809l != OfficeUrlPreviewHostRenderResult.SUCCESS) goto L20;
            OfficeUrlPreviewPlatformBridge.h("render_result_reused", r100, "result=SUCCESS");
            r100.f361806i.invoke(Boolean.TRUE);
            return;
        L7:
            if (r101.f361802e != r100.f361802e) goto L13;
            if (Intrinsics.areEqual(r101.f361800c, r100.f361800c) == false) goto L13;
            if (r101.f361804g != r100.f361804g) goto L13;
            r103 = true;
        L31:
            if (r101 == null) goto L33;
            f(r100.f361805h);
        L33:
            r100.f361805h.removeAllViews();
            this.f361779c.put(r100.f361805h, r100);
            this.f361782f.add(r100.f361801d);
            OfficeUrlPreviewPlatformBridge.i(OfficeUrlPreviewPlatformBridge.f361768a, "pull_started", r100);
            Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L36
            this.f361788l.t(CollectionsKt.listOf(r100.f361801d), r100.f361802e);     // Catch: Throwable -> L36
            Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L36
        L39:
            if (Result.m9456isSuccessimpl(r107) == false) goto L41;
            Unit r108 = (Unit) r107;
            this.f361780d.add(r100.f361801d);
            OfficeUrlPreviewPlatformBridge.i(OfficeUrlPreviewPlatformBridge.f361768a, "pull_returned", r100);
        L41:
            Throwable r109 = Result.m9452exceptionOrNullimpl(r107);
            if (r109 == null) goto L45;
            OfficeUrlPreviewPlatformBridge.a(OfficeUrlPreviewPlatformBridge.f361768a, "pull_failed", r100, r109);
        L45:
            if (Result.m9456isSuccessimpl(r107) == true) goto L75;
            OfficeUrlPreviewPlatformBridge.i(OfficeUrlPreviewPlatformBridge.f361768a, "pull_failed_and_removed", r100);
            if (f(r100.f361805h) != r100) goto L87;
            Collection<b> r110 = this.f361779c.values();
            if (r110.isEmpty() == true) goto L57;
            Iterator<T> r111 = r110.iterator();
        L53:
            if (r111.hasNext() == false) goto L57;
            if (Intrinsics.areEqual(((b) r111.next()).f361801d, r100.f361801d) == false) goto L53;
            r102 = true;
        L57:
            if (r102 == false) goto L60;
        L73:
            r100.f361806i.invoke(Boolean.FALSE);
            return;
        L60:
            if (this.f361780d.remove(r100.f361801d) == false) goto L73;
            this.f361781e.remove(r100.f361801d);
            Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L65
            this.f361788l.s(r100.f361801d);     // Catch: Throwable -> L65
            Object r113 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L65
        L68:
            if (Result.m9456isSuccessimpl(r113) == false) goto L70;
            Unit r114 = (Unit) r113;
            OfficeUrlPreviewPlatformBridge.i(OfficeUrlPreviewPlatformBridge.f361768a, "preview_removed", r100);
        L70:
            Throwable r115 = Result.m9452exceptionOrNullimpl(r113);
            if (r115 == null) goto L73;
            OfficeUrlPreviewPlatformBridge.a(OfficeUrlPreviewPlatformBridge.f361768a, "preview_remove_failed", r100, r115);
        L65:
            th = move-exception;
            Result.Companion r116 = Result.Companion;
            r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L68
        L87:
            return;
        L75:
            g(r100);
            return;
        L36:
            th = move-exception;
            Result.Companion r117 = Result.Companion;
            r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L39
        }

        public final void b(String r100) {
            a r101 = this.f361784h.remove(r100);
            if (r101 != null) goto L5;
            return;
        L5:
            OfficeUrlPreviewPlatformBridge.f361776i.removeCallbacks(r101.f361789a);
        }

        public final void d(b r100) {
            OfficeUrlPreviewPlatformBridge.i(OfficeUrlPreviewPlatformBridge.f361768a, "render_failed", r100);
            if (this.f361779c.get(r100.f361805h) == r100) goto L5;
            return;
        L5:
            b(r100.f361801d);
            r100.f361811n = false;
            r100.f361809l = OfficeUrlPreviewHostRenderResult.RENDER_FAILED;
            r100.f361806i.invoke(Boolean.FALSE);
        }

        public final b f(ViewGroup r100) {
            b r101 = this.f361779c.remove(r100);
            if (r101 != null) goto L6;
            return null;
        L6:
            Collection<b> r102 = this.f361779c.values();
            boolean r103 = true;
            if (r102.isEmpty() == true) goto L15;
            Iterator<T> r104 = r102.iterator();
        L11:
            if (r104.hasNext() == false) goto L15;
            if (Intrinsics.areEqual(((b) r104.next()).f361801d, r101.f361801d) == false) goto L11;
            r103 = false;
        L15:
            if (r103 == false) goto L17;
            b(r101.f361801d);
        L17:
            return r101;
        }

        public final void g(b r100) {
            if (this.f361779c.get(r100.f361805h) == r100) goto L5;
            return;
        L5:
            if (this.f361777a.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L42;
            m(r100.f361804g, ChameleonOpenTracker.Stage.RENDER);
            OfficeUrlPreviewPlatformBridge.i(OfficeUrlPreviewPlatformBridge.f361768a, "render_started", r100);
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
            Object r102 = Result.m9449constructorimpl(this.f361788l.u(r100.f361801d, r100.f361803f, r100.f361805h));     // Catch: Throwable -> L10
        L12:
            Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
            if (r103 == null) goto L16;
            OfficeUrlPreviewPlatformBridge.a(OfficeUrlPreviewPlatformBridge.f361768a, "render_threw", r100, r103);
        L16:
            if (Result.m9452exceptionOrNullimpl(r102) != null) goto L34;
            OfficeUrlPreviewHostRenderResult r104 = (OfficeUrlPreviewHostRenderResult) r102;
            OfficeUrlPreviewPlatformBridge.f361768a.getClass();
            OfficeUrlPreviewPlatformBridge.h("render_returned", r100, "result=" + r104);
            r100.f361809l = r104;
            int r105 = b.f361791b[r104.ordinal()];
            if (r105 != 1) goto L20;
            b(r100.f361801d);
            this.f361783g.remove(r100.f361801d);
            r100.f361806i.invoke(Boolean.TRUE);
            return;
        L20:
            if (r105 == 2) goto L30;
            if (r105 != 3) goto L24;
        L28:
            k(r100);
            return;
        L24:
            if (r105 == 4) goto L28;
            throw new NoWhenBranchMatchedException();
        L30:
            if (h(r100, "trigger=render_failed") == true) goto L39;
            d(r100);
            return;
        L39:
            return;
        L34:
            d(r100);
            return;
        L10:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L12
        }

        public final void j(final z0 r100) {
            Intrinsics.checkNotNullParameter(r100, "previewInfo");
            final String r101 = r100.f362052a;
            b(r101);
            this.f361783g.remove(r101);
            Iterator<T> r102 = this.f361779c.values().iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            Object r103 = r102.next();
            if (Intrinsics.areEqual(((b) r103).f361801d, r101) == false) goto L4;
        L9:
            b r104 = (b) r103;
            if (r104 != null) goto L12;
            return;
        L12:
            r104.f361805h.post(new r1(this, r101, r100));
            return;
        L8:
            r103 = null;
            goto L9
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, com.larus.office.card.urlpreview.s1, java.lang.Runnable] */
        public final void k(b r100) {
            final String r101 = r100.f361801d;
            Integer r102 = (Integer) ((LinkedHashMap) this.f361783g).get(r101);
            if (r102 == null) goto L5;
            int r103 = r102.intValue();
        L7:
            if (r103 < 2) goto L11;
            c(r100, r103);
            return;
        L11:
            if (this.f361784h.containsKey(r101) == false) goto L13;
            return;
        L13:
            final Ref.ObjectRef r104 = new Ref.ObjectRef();
            ?? r105 = new s1(this, r101, r104);
            r104.element = r105;
            this.f361784h.put(r101, new a(r105));
            OfficeUrlPreviewPlatformBridge.f361768a.getClass();
            OfficeUrlPreviewPlatformBridge.h("pull_retry_scheduled", r100, "delayMs=3000");
            Handler r106 = OfficeUrlPreviewPlatformBridge.f361776i;
            T r107 = r104.element;
            if (r107 != 0) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("retryRunnable");
            Runnable r108 = null;
        L17:
            r106.postDelayed(r108, 3000);
            return;
        L16:
            r108 = (Runnable) r107;
            goto L17
        L5:
            r103 = 0;
            goto L7
        }

        public final void l(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            b r101 = this.f361779c.get(r100);
            if (r101 == null) goto L5;
            OfficeUrlPreviewPlatformBridge.i(OfficeUrlPreviewPlatformBridge.f361768a, "container_unbound", r101);
        L5:
            f(r100);
        }

        public final void c(b r100, int r101) {
            if (this.f361779c.get(r100.f361805h) == r100) goto L5;
            return;
        L5:
            int r102 = y1.f362049a;
            OfficeUrlPreviewHostRenderResult r103 = r100.f361809l;
            OfficeUrlPreviewHostRenderResult r104 = OfficeUrlPreviewHostRenderResult.NO_DATA;
            boolean r105 = false;
            if (r103 != r104) goto L8;
        L13:
            boolean r106 = true;
        L14:
            if (r106 == true) goto L16;
        L18:
            OfficeUrlPreviewPlatformBridge.f361768a.getClass();
            OfficeUrlPreviewPlatformBridge.h("pull_retry_exhausted", r100, "retryCount=" + r101);
            OfficeUrlPreviewHostRenderResult r107 = r100.f361809l;
            if (r107 != r104) goto L21;
        L22:
            r105 = true;
        L23:
            if (r105 == false) goto L26;
            OfficeUrlPreviewPlatformBridge.h("render_waiting_after_retry_exhausted", r100, "retryCount=" + r101);
            return;
        L26:
            d(r100);
            return;
        L21:
            if (r107 != OfficeUrlPreviewHostRenderResult.NO_RENDER) goto L23;
        L16:
            if (h(r100, "trigger=retry_exhausted, retryCount=" + r101) == false) goto L18;
            return;
        L8:
            if (r103 == OfficeUrlPreviewHostRenderResult.NO_RENDER) goto L13;
            if (r103 == OfficeUrlPreviewHostRenderResult.RENDER_FAILED) goto L13;
            r106 = false;
            goto L14
        }

        public final boolean h(b r100, String r101) {
            int r102 = y1.f362049a;
            OfficeUrlPreviewHostRenderResult r103 = r100.f361809l;
            if (r103 != OfficeUrlPreviewHostRenderResult.NO_DATA) goto L5;
        L10:
            boolean r104 = true;
        L11:
            if (r104 == true) goto L13;
        L30:
            return false;
        L13:
            if (r100.f361810m == true) goto L30;
            r100.f361810m = true;
            r100.f361811n = true;
            b(r100.f361801d);
            this.f361783g.remove(r100.f361801d);
            OfficeUrlPreviewPlatformBridge r105 = OfficeUrlPreviewPlatformBridge.f361768a;
            String r106 = r101 + ", result=" + r100.f361809l;
            r105.getClass();
            OfficeUrlPreviewPlatformBridge.h("preview_data_unavailable", r100, r106);
            Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L18
            Object r108 = Result.m9449constructorimpl(Boolean.valueOf(r100.f361807j.invoke().booleanValue()));     // Catch: Throwable -> L18
        L20:
            Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
            if (r109 == null) goto L23;
            OfficeUrlPreviewPlatformBridge.a(OfficeUrlPreviewPlatformBridge.f361768a, "preview_id_refresh_callback_failed", r100, r109);
        L23:
            Boolean r110 = Boolean.FALSE;
            if (Result.m9455isFailureimpl(r108) == false) goto L27;
            r108 = r110;
        L27:
            if (((Boolean) r108).booleanValue() == false) goto L29;
            return true;
        L29:
            r100.f361811n = false;
            OfficeUrlPreviewPlatformBridge r111 = OfficeUrlPreviewPlatformBridge.f361768a;
            String r112 = r101 + ", result=" + r100.f361809l;
            r111.getClass();
            OfficeUrlPreviewPlatformBridge.h("preview_id_refresh_skipped", r100, r112);
        L18:
            th = move-exception;
            Result.Companion r113 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L20
        L5:
            if (r103 == OfficeUrlPreviewHostRenderResult.NO_RENDER) goto L10;
            if (r103 == OfficeUrlPreviewHostRenderResult.RENDER_FAILED) goto L10;
            r104 = false;
            goto L11
        }

        public final void m(int r100, String r101) {
            int r102 = RangesKt.coerceAtLeast(r100, 1);
            if (this.f361778b != r102) goto L5;
            return;
        L5:
            int r103 = this.f361778b;
            this.f361778b = r102;
            FLogger.f375446a.i("OfficeUrlPreviewSDK", "[SDK][page_render_config_updated] reason=" + r101 + ", maxWidth=" + r103 + "->" + r102 + ", owner=" + System.identityHashCode(this.f361777a));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v8, types: [androidx.lifecycle.LifecycleObserver, com.larus.office.card.urlpreview.u1] */
        public PageBinding(Context r100, LifecycleOwner r101, IOfficeUrlPreviewHostService r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r102, "hostService");
            this.f361777a = r101;
            this.f361778b = RangesKt.coerceAtLeast(r103, 1);
            this.f361779c = new IdentityHashMap();
            this.f361780d = new LinkedHashSet();
            this.f361781e = new LinkedHashSet();
            this.f361782f = new LinkedHashSet();
            this.f361783g = new LinkedHashMap();
            this.f361784h = new LinkedHashMap();
            ?? r104 = new u1(this);
            this.f361787k = r104;
            kc9.d r105 = r102.b(r100, r101, new v1(this), new OfficeUrlPreviewPlatformBridge$PageBinding$pageService$2(this));
            if (r105 == null) goto L7;
            this.f361788l = r105;
            r101.getLifecycle().addObserver(r104);
            FLogger.f375446a.i("OfficeUrlPreviewSDK", "[SDK][page_service_created] maxWidth=" + this.f361778b + ", owner=" + System.identityHashCode(r101));
            return;
        L7:
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f361792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LifecycleOwner f361793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final x1 f361794c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<z0> f361795d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f361796e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.larus.platform.api.a1 f361797f;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [androidx.lifecycle.LifecycleObserver, com.larus.office.card.urlpreview.x1] */
        public a(String r100, LifecycleOwner r101) {
            Intrinsics.checkNotNullParameter(r100, "sourceKey");
            Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
            this.f361792a = r100;
            this.f361793b = r101;
            ?? r102 = new x1(this);
            this.f361794c = r102;
            this.f361795d = CollectionsKt.emptyList();
            r101.getLifecycle().addObserver(r102);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f361798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LifecycleOwner f361799b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f361800c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f361801d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f361802e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final OfficeUrlPreviewHostCardType f361803f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f361804g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ViewGroup f361805h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Function1<Boolean, Unit> f361806i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Function0<Boolean> f361807j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final long f361808k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public OfficeUrlPreviewHostRenderResult f361809l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f361810m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f361811n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public LifecycleEventObserver f361812o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public com.larus.platform.api.a1 f361813p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Runnable f361814q;

        public final Context getContext() {
            return this.f361798a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Context r100, LifecycleOwner r101, String r102, String r103, boolean r104, OfficeUrlPreviewHostCardType r105, int r106, ViewGroup r107, Function1<? super Boolean, Unit> r110, Function0<Boolean> r111) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r102, "messageId");
            Intrinsics.checkNotNullParameter(r103, "previewId");
            Intrinsics.checkNotNullParameter(r105, "cardType");
            Intrinsics.checkNotNullParameter(r107, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r110, "onRendered");
            Intrinsics.checkNotNullParameter(r111, "onPreviewDataUnavailable");
            this.f361798a = r100;
            this.f361799b = r101;
            this.f361800c = r102;
            this.f361801d = r103;
            this.f361802e = r104;
            this.f361803f = r105;
            this.f361804g = r106;
            this.f361805h = r107;
            this.f361806i = r110;
            this.f361807j = r111;
            this.f361808k = SystemClock.elapsedRealtime();
        }
    }

    public OfficeUrlPreviewPlatformBridge() {
    }

    static {
        f361768a = new OfficeUrlPreviewPlatformBridge();
        f361769b = new LruCache(200);
        f361770c = new LruCache(200);
        kotlinx.coroutines.sync.a[] r100 = new kotlinx.coroutines.sync.a[16];
        int r101 = 0;
    L3:
        if (r101 >= 16) goto L5;
        r100[r101] = kotlinx.coroutines.sync.b.a();
        r101 = r101 + 1;
        goto L3
    L5:
        f361771d = r100;
        f361772e = new IdentityHashMap();
        f361773f = new LinkedHashMap();
        f361774g = new IdentityHashMap();
        f361775h = new IdentityHashMap();
        f361776i = new Handler(Looper.getMainLooper());
    }

    public static void d(ViewGroup r100) {
        b r101 = f361775h.remove(r100);
        if (r101 == null) goto L15;
        LifecycleEventObserver r102 = r101.f361812o;
        if (r102 == null) goto L7;
        r101.f361799b.getLifecycle().removeObserver(r102);
    L7:
        r101.f361812o = null;
        com.larus.platform.api.a1 r103 = r101.f361813p;
        if (r103 == null) goto L10;
        r103.cancel();
    L10:
        r101.f361813p = null;
        Runnable r104 = r101.f361814q;
        if (r104 == null) goto L13;
        r101.f361805h.removeCallbacks(r104);
    L13:
        r101.f361814q = null;
        return;
    }

    public static boolean g(a r100) {
        IdentityHashMap<LifecycleOwner, a> r101 = f361773f.get(r100.f361792a);
        if (r101 == null) goto L5;
        a r102 = r101.get(r100.f361793b);
    L6:
        if (r102 == r100) goto L8;
    L10:
        return false;
    L8:
        if (r100.f361793b.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        return true;
    L5:
        r102 = null;
        goto L6
    }

    public static void j(final a r110) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        f361776i.post(new j1(r110));
        return;
    L6:
        List<z0> r100 = r110.f361795d;
        if (r100.isEmpty() == false) goto L9;
        return;
    L9:
        IOfficeUrlPreviewHostService r101 = (IOfficeUrlPreviewHostService) ServiceManager.get().getService(IOfficeUrlPreviewHostService.class);
        if (r101 != null) goto L14;
        r110.f361796e = null;
        return;
    L14:
        if (r110.f361797f != null) goto L20;
        final WeakReference r102 = new WeakReference(r110.f361793b);
        FlowOfficeUrlPreviewHostService.a r103 = r101.d(new k1(r102, r110));
        if (r103 != null) goto L19;
        boolean r104 = false;
    L22:
        if (r104 == false) goto L25;
        q4 r105 = r101.a();
        FLogger.f375446a.i("OfficeUrlPreviewSDK", "[SDK][page_prefetch_office_sdk_waiting] sourceKey=" + r110.f361792a + ", globalReady=" + r105.f365248b + ", userReady=" + r105.f365249c);
        return;
    L25:
        com.larus.platform.api.a1 r106 = r110.f361797f;
        if (r106 == null) goto L28;
        r106.cancel();
    L28:
        r110.f361797f = null;
        PageBinding r107 = f361772e.get(r110.f361793b);
        if (r107 != null) goto L31;
        return;
    L31:
        String r111 = r110.f361792a;
        Intrinsics.checkNotNullParameter(r111, "sourceKey");
        Intrinsics.checkNotNullParameter(r100, "previewInfos");
        List r108 = SequencesKt.toList(SequencesKt.take(SequencesKt.distinctBy(SequencesKt.filter(CollectionsKt.asSequence(r100), new t1()), OfficeUrlPreviewPlatformBridge$PageBinding$prefetch$normalized$2.INSTANCE), 4));
        LinkedHashSet r109 = new LinkedHashSet();
        Iterator r112 = r108.iterator();
    L33:
        if (r112.hasNext() == false) goto L35;
        r109.add(((z0) r112.next()).f362052a);
        goto L33
    L35:
        LinkedHashSet<String> r113 = r107.f361781e;
        ArrayList r114 = new ArrayList();
        Iterator<T> r115 = r113.iterator();
    L37:
        if (r115.hasNext() == false) goto L59;
        Object r116 = r115.next();
        String r117 = (String) r116;
        if (r109.contains(r117) == false) goto L41;
    L56:
        boolean r118 = false;
    L57:
        if (r118 == false) goto L37;
        r114.add(r116);
        goto L37
    L41:
        if (r107.f361782f.contains(r117) == true) goto L56;
        Collection<b> r119 = r107.f361779c.values();
        if ((r119 instanceof Collection) == true) goto L45;
    L47:
        Iterator<T> r120 = r119.iterator();
    L49:
        if (r120.hasNext() == false) goto L53;
        if (Intrinsics.areEqual(((b) r120.next()).f361801d, r117) == false) goto L49;
        boolean r121 = false;
    L54:
        if (r121 == false) goto L56;
        r118 = true;
    L53:
        r121 = true;
        goto L54
    L45:
        if (r119.isEmpty() == false) goto L47;
    L59:
        Iterator r122 = r114.iterator();
    L61:
        if (r122.hasNext() == false) goto L68;
        String r123 = (String) r122.next();
        r107.f361781e.remove(r123);
        if (r107.f361780d.remove(r123) == false) goto L61;
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L66
        r107.f361788l.s(r123);     // Catch: Throwable -> L66
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L61
    L68:
        LinkedHashMap r126 = new LinkedHashMap();
        Iterator r127 = r108.iterator();
    L70:
        if (r127.hasNext() == false) goto L75;
        Object r128 = r127.next();
        Boolean r129 = Boolean.valueOf(((z0) r128).f362053b);
        Object r130 = r126.get(r129);
        if (r130 != null) goto L74;
        r130 = new ArrayList();
        r126.put(r129, r130);
    L74:
        ((List) r130).add(r128);
        goto L70
    L75:
        Iterator r131 = r126.entrySet().iterator();
    L77:
        if (r131.hasNext() == false) goto L93;
        Map.Entry r132 = (Map.Entry) r131.next();
        boolean r133 = ((Boolean) r132.getKey()).booleanValue();
        List r134 = (List) r132.getValue();
        ArrayList r135 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r134, 10));
        Iterator r136 = r134.iterator();
    L80:
        if (r136.hasNext() == false) goto L82;
        r135.add(((z0) r136.next()).f362052a);
        goto L80
    L82:
        FLogger.f375446a.i("OfficeUrlPreviewSDK", "[SDK][page_prefetch_pull_started] sourceKey=" + r111 + ", previewCount=" + r135.size() + ", needLocalPreview=" + r133 + ", maxWidth=" + r107.f361778b);
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L85
        r107.f361788l.t(r135, r133);     // Catch: Throwable -> L85
        Object r138 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L85
    L88:
        if (Result.m9456isSuccessimpl(r138) == false) goto L90;
        Unit r139 = (Unit) r138;
        CollectionsKt.addAll(r107.f361780d, r135);
        CollectionsKt.addAll(r107.f361781e, r135);
        FLogger.f375446a.i("OfficeUrlPreviewSDK", "[SDK][page_prefetch_pull_returned] sourceKey=" + r111 + ", previewCount=" + r135.size() + ", needLocalPreview=" + r133 + ", maxWidth=" + r107.f361778b);
    L90:
        Throwable r140 = Result.m9452exceptionOrNullimpl(r138);
        if (r140 == null) goto L77;
        FLogger.f375446a.e("OfficeUrlPreviewSDK", "[SDK][page_prefetch_pull_failed] sourceKey=" + r111 + ", previewCount=" + r135.size() + ", needLocalPreview=" + r133 + ", maxWidth=" + r107.f361778b, r140);
    L85:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L88
    L93:
        return;
    L19:
        r110.f361797f = r103;
    L20:
        r104 = true;
        goto L22
    }

    public static void k(LifecycleOwner r100) {
        Collection<IdentityHashMap<LifecycleOwner, a>> r101 = f361773f.values();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        a r104 = (a) ((IdentityHashMap) r103.next()).get(r100);
        if (r104 == null) goto L4;
        r102.add(r104);
        goto L4
    L8:
        Iterator r105 = r102.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        j((a) r105.next());
        goto L10
    }

    public final synchronized void c(ViewGroup r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);     // Catch: Throwable -> L9
        d(r100);     // Catch: Throwable -> L9
        PageBinding r101 = f361774g.remove(r100);     // Catch: Throwable -> L9
        if (r101 == null) goto L6;
        r101.l(r100);     // Catch: Throwable -> L9
    L6:
        r100.removeAllViews();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean e(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "sourceKey");     // Catch: Throwable -> L12
        IdentityHashMap<LifecycleOwner, a> r101 = f361773f.get(r100);     // Catch: Throwable -> L12
        if (r101 == null) goto L9;
        boolean r102 = true;
        if ((!r101.isEmpty()) != true) goto L9;
    L10:
        monitor-exit(this);
        return r102;
    L9:
        r102 = false;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized void m(a r100) {
        monitor-enter(this);
        LinkedHashMap<String, IdentityHashMap<LifecycleOwner, a>> r101 = f361773f;     // Catch: Throwable -> L20
        IdentityHashMap<LifecycleOwner, a> r102 = r101.get(r100.f361792a);     // Catch: Throwable -> L20
        if (r102 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r102.get(r100.f361793b) == r100) goto L11;
        monitor-exit(this);
        return;
    L11:
        r102.remove(r100.f361793b);     // Catch: Throwable -> L20
        if (r102.isEmpty() == false) goto L14;
        r101.remove(r100.f361792a);     // Catch: Throwable -> L20
    L14:
        com.larus.platform.api.a1 r103 = r100.f361797f;     // Catch: Throwable -> L20
        if (r103 == null) goto L17;
        r103.cancel();     // Catch: Throwable -> L20
    L17:
        r100.f361797f = null;     // Catch: Throwable -> L20
        r100.f361793b.getLifecycle().removeObserver(r100.f361794c);     // Catch: Throwable -> L20
        r100.f361795d = CollectionsKt.emptyList();     // Catch: Throwable -> L20
        r100.f361796e = null;     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final synchronized void p(z0 r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "previewInfo");     // Catch: Throwable -> L14
        if (StringsKt.isBlank(r100.f362052a) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator<T> r101 = f361772e.values().iterator();     // Catch: Throwable -> L14
    L9:
        if (r101.hasNext() == false) goto L12;
        ((PageBinding) r101.next()).j(r100);     // Catch: Throwable -> L14
        goto L9
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static boolean q(final b r100, final IOfficeUrlPreviewHostService r101) {
        f361775h.put(r100.f361805h, r100);
        LifecycleEventObserver r102 = new l1(r100);
        r100.f361799b.getLifecycle().addObserver(r102);
        r100.f361812o = r102;
        final WeakReference r103 = new WeakReference(r100.f361805h);
        final WeakReference r104 = new WeakReference(r100.f361799b);
        FlowOfficeUrlPreviewHostService.a r105 = r101.d(new m1(r103, r104, r100));     // Catch: Throwable -> L12
        if (r105 != null) goto L7;
        d(r100.f361805h);
        return false;
    L7:
        r100.f361813p = r105;
        PageBinding r106 = f361774g.remove(r100.f361805h);
        if (r106 == null) goto L10;
        r106.l(r100.f361805h);
    L10:
        r100.f361805h.removeAllViews();
        Runnable r107 = new n1(r101, r100);
        r100.f361805h.postDelayed(r107, 30000);
        r100.f361814q = r107;
        return true;
    L12:
        th = move-exception;
        d(r100.f361805h);
        throw th;
    }

    public final synchronized void l(String r100, LifecycleOwner r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "sourceKey");     // Catch: Throwable -> L20
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");     // Catch: Throwable -> L20
        if (StringsKt.isBlank(r100) == false) goto L6;
    L18:
        monitor-exit(this);
        return;
    L6:
        if (r101.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L18;
        LinkedHashMap<String, IdentityHashMap<LifecycleOwner, a>> r102 = f361773f;     // Catch: Throwable -> L20
        IdentityHashMap<LifecycleOwner, a> r103 = r102.get(r100);     // Catch: Throwable -> L20
        if (r103 != null) goto L11;
        r103 = new IdentityHashMap();     // Catch: Throwable -> L20
        r102.put(r100, r103);     // Catch: Throwable -> L20
    L11:
        IdentityHashMap<LifecycleOwner, a> r104 = r103;     // Catch: Throwable -> L20
        if (r104.get(r101) == null) goto L15;
        monitor-exit(this);
        return;
    L15:
        r104.put(r101, new a(r100, r101));     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static void h(String r100, b r101, String r102) {
        String r103 = null;
        if (r102 != null) goto L5;
    L10:
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        FLogger.f375446a.i("OfficeUrlPreviewSDK", "[SDK][" + r100 + "] messageId=" + r101.f361800c + ", previewId=" + r101.f361801d + ", cardType=" + r101.f361803f + ", needLocalPreview=" + r101.f361802e + ", maxWidth=" + r101.f361804g + ", container=" + System.identityHashCode(r101.f361805h) + ", elapsedMs=" + (SystemClock.elapsedRealtime() - r101.f361808k) + r103);
        return;
    L5:
        if ((!StringsKt.isBlank(r102)) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L10;
        r103 = ", ".concat(r102);
        goto L10
    }

    public static /* synthetic */ void i(OfficeUrlPreviewPlatformBridge r100, String r101, b r102) {
        r100.getClass();
        h(r101, r102, null);
    }

    public final synchronized void b(String r100, String r101, z0 r102) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "messageId");     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r101, "url");     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r102, "previewInfo");     // Catch: Throwable -> L15
        if (StringsKt.isBlank(r100) == false) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (StringsKt.isBlank(r101) == true) goto L13;
        if (StringsKt.isBlank(r102.f362052a) == true) goto L13;
        f361769b.put(new c2(r100, r101), r102);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized void f(String r100, String r101, String r102) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "messageId");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r101, "url");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r102, "expectedPreviewId");     // Catch: Throwable -> L23
        if (StringsKt.isBlank(r100) == false) goto L6;
    L21:
        monitor-exit(this);
        return;
    L6:
        if (StringsKt.isBlank(r101) == true) goto L21;
        if (StringsKt.isBlank(r102) == true) goto L21;
        c2 r103 = new c2(r100, r101);     // Catch: Throwable -> L23
        LruCache<c2, z0> r104 = f361769b;     // Catch: Throwable -> L23
        z0 r105 = r104.get(r103);     // Catch: Throwable -> L23
        if (r105 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        if (Intrinsics.areEqual(r105.f362052a, r102) == true) goto L18;
        monitor-exit(this);
        return;
    L18:
        r104.remove(r103);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00f3 -> B:15:0x004a). Please report as a decompilation issue!!! */
    public final Object o(String r210, List<String> r211, Continuation<? super Map<String, z0>> r212) {
        if ((r212 instanceof OfficeUrlPreviewPlatformBridge$requestPreviews$1) == false) goto L7;
        OfficeUrlPreviewPlatformBridge$requestPreviews$1 r100 = (OfficeUrlPreviewPlatformBridge$requestPreviews$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = true;
        if (r104 == 0) goto L19;
        if (r104 == 1) goto L18;
        if (r104 != 2) goto L17;
        List r106 = (List) r100.L$4;
        Iterator r107 = (Iterator) r100.L$3;
        d2 r108 = (d2) r100.L$2;
        kotlinx.coroutines.sync.a r110 = (kotlinx.coroutines.sync.a) r100.L$1;
        String r111 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L95
        Iterator r213 = r107;
        List r109 = r106;
        String r112 = r111;
    L15:
        kotlinx.coroutines.sync.a r113 = r110;
        d2 r114 = r108;
        Iterator r115 = r213;
        dm9.a r116 = (dm9.a) r102;     // Catch: Throwable -> L75
        if ((r116 instanceof dm9.a.b) == false) goto L40;
        dm9.a.b r117 = (dm9.a.b) r116;     // Catch: Throwable -> L75
    L41:
        if (r117 == null) goto L74;
        BizResponse<T> r118 = r117.f469231a;     // Catch: Throwable -> L75
        if (r118 == 0) goto L74;
        if (r118.getCode() != 0) goto L74;
        f2 r119 = (f2) r118.getData();     // Catch: Throwable -> L75
        if (r119 == null) goto L50;
        Map<String, g2> r120 = r119.a();     // Catch: Throwable -> L75
    L51:
        if (r120 != null) goto L53;
        r120 = MapsKt.emptyMap();     // Catch: Throwable -> L75
    L53:
        Iterator<Map.Entry<String, g2>> r121 = r120.entrySet().iterator();     // Catch: Throwable -> L75
    L55:
        if (r121.hasNext() == false) goto L74;
        Map.Entry<String, g2> r122 = r121.next();     // Catch: Throwable -> L75
        String r123 = r122.getKey();     // Catch: Throwable -> L75
        g2 r124 = r122.getValue();     // Catch: Throwable -> L75
        if (r109.contains(r123) == false) goto L73;
        if (r124 == null) goto L73;
        String r125 = r124.b();     // Catch: Throwable -> L75
        if (r125 == null) goto L73;
        if ((StringsKt.isBlank(r125) ^ r105) == true) goto L66;
        r125 = null;
    L66:
        if (r125 == null) goto L73;
        OfficeUrlPreviewPlatformBridge r126 = f361768a;     // Catch: Throwable -> L75
        Boolean r127 = r124.a();     // Catch: Throwable -> L75
        if (r127 == null) goto L71;
        boolean r128 = r127.booleanValue();     // Catch: Throwable -> L75
    L72:
        r126.b(r112, r123, new z0(r125, r128));     // Catch: Throwable -> L75
        goto L73
    L71:
        r128 = false;
    L73:
        r105 = true;
        goto L55
    L50:
        r120 = null;
    L74:
        Iterator r129 = r115;
        r108 = r114;
        r110 = r113;
        r105 = true;
    L32:
        if (r129.hasNext() == false) goto L77;
        List r130 = (List) r129.next();     // Catch: Throwable -> L95
        OfficeUrlPreviewApi.a r131 = OfficeUrlPreviewApi.f361692a;     // Catch: Throwable -> L95
        OfficeUrlPreviewPlatformBridge$requestPreviews$2$1$result$1 r132 = new OfficeUrlPreviewPlatformBridge$requestPreviews$2$1$result$1(r130, r112, null);     // Catch: Throwable -> L95
        r100.L$0 = r112;     // Catch: Throwable -> L95
        r100.L$1 = r110;     // Catch: Throwable -> L95
        r100.L$2 = r108;     // Catch: Throwable -> L95
        r100.L$3 = r129;     // Catch: Throwable -> L95
        r100.L$4 = r130;     // Catch: Throwable -> L95
        r100.label = 2;     // Catch: Throwable -> L95
        r131.getClass();     // Catch: Throwable -> L95
        FlowHttpConnection r133 = FlowHttpConnection.f359975a;     // Catch: Throwable -> L95
        Object r134 = FlowHttpConnection.g(ServiceType.BASIC_SERVICE, OfficeUrlPreviewApi.class, r132, false, null, null, null, r100, 248);     // Catch: Throwable -> L95
        if (r134 != r103) goto L36;
        return r103;
    L36:
        r213 = r129;
        r109 = r130;
        r102 = r134;
        goto L15
    L77:
        List<String> r135 = r108.f361885a;     // Catch: Throwable -> L95
        ArrayList r136 = new ArrayList();     // Catch: Throwable -> L95
        Iterator<T> r137 = r135.iterator();     // Catch: Throwable -> L95
    L79:
        if (r137.hasNext() == false) goto L92;
        String r138 = (String) r137.next();     // Catch: Throwable -> L95
        OfficeUrlPreviewPlatformBridge r139 = f361768a;     // Catch: Throwable -> L95
        monitor-enter(r139);     // Catch: Throwable -> L95
        z0 r140 = f361769b.get(new c2(r112, r138));     // Catch: Throwable -> L89
        monitor-exit(r139);     // Catch: Throwable -> L95
        if (r140 == null) goto L86;
        Pair r141 = TuplesKt.to(r138, r140);     // Catch: Throwable -> L95
    L87:
        if (r141 == null) goto L79;
        r136.add(r141);     // Catch: Throwable -> L95
        goto L79
    L86:
        r141 = null;
        goto L87
    L89:
        th = move-exception;
        throw th;     // Catch: Throwable -> L95
    L92:
        Map r142 = MapsKt.toMap(r136);     // Catch: Throwable -> L95
    L93:
        r110.unlock(null);
        return r142;
    L40:
        r117 = null;
    L75:
        th = th;
    L97:
        r113.unlock(null);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        kotlinx.coroutines.sync.a r143 = (kotlinx.coroutines.sync.a) r100.L$2;
        List<String> r144 = (List) r100.L$1;
        String r145 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r110 = r143;
        r112 = r145;
    L27:
        d2 r146 = e2.a(r144, new g1(r112));     // Catch: Throwable -> L95
        if (r146.f361885a.isEmpty() == false) goto L30;
        r142 = MapsKt.emptyMap();     // Catch: Throwable -> L95
        goto L93
    L30:
        r129 = r146.f361886b.iterator();     // Catch: Throwable -> L95
        r108 = r146;
        goto L32
    L19:
        ResultKt.throwOnFailure(r102);
        if (StringsKt.isBlank(r210) == true) goto L22;
        kotlinx.coroutines.sync.a r147 = f361771d[(r210.hashCode() & Integer.MAX_VALUE) % 16];
        r112 = r210;
        r100.L$0 = r112;
        r144 = r211;
        r100.L$1 = r144;
        r100.L$2 = r147;
        r100.label = 1;
        if (r147.a(null, r100) != r103) goto L26;
        return r103;
    L26:
        r110 = r147;
        goto L27
    L22:
        return MapsKt.emptyMap();
    L95:
        th = th;
        r113 = r110;
    L7:
        r100 = new OfficeUrlPreviewPlatformBridge$requestPreviews$1(this, r212);
        goto L8
    }

    public static final void a(OfficeUrlPreviewPlatformBridge r100, String r101, b r102, Throwable r103) {
        r100.getClass();
        FLogger.f375446a.e("OfficeUrlPreviewSDK", "[SDK][" + r101 + "] messageId=" + r102.f361800c + ", previewId=" + r102.f361801d + ", cardType=" + r102.f361803f + ", needLocalPreview=" + r102.f361802e + ", maxWidth=" + r102.f361804g + ", container=" + System.identityHashCode(r102.f361805h) + ", elapsedMs=" + (SystemClock.elapsedRealtime() - r102.f361808k), r103);
    }

    public final synchronized void n(Context r110, LifecycleOwner r210, z0 r211, boolean r212, int r213, ViewGroup r214, Function1<? super Boolean, Unit> r215, Function0<Boolean> r216) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L56
        Intrinsics.checkNotNullParameter(r210, "lifecycleOwner");     // Catch: Throwable -> L56
        Intrinsics.checkNotNullParameter(r211, "previewInfo");     // Catch: Throwable -> L56
        Intrinsics.checkNotNullParameter(r214, KtvSubElement.CONTAINER);     // Catch: Throwable -> L56
        Intrinsics.checkNotNullParameter(r215, "onRendered");     // Catch: Throwable -> L56
        Intrinsics.checkNotNullParameter(r216, "onPreviewDataUnavailable");     // Catch: Throwable -> L56
        d(r214);     // Catch: Throwable -> L56
        if (r210.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L9;
        c(r214);     // Catch: Throwable -> L56
        monitor-exit(this);
        return;
    L9:
        d r100 = f361770c.get(r211.f362052a);     // Catch: Throwable -> L56
        if (r100 == null) goto L12;
        String r101 = r100.f361872a;     // Catch: Throwable -> L56
    L13:
        if (r101 != null) goto L15;
        r101 = "";
    L15:
        String r102 = r101;
        String r103 = r211.f362052a;     // Catch: Throwable -> L56
        boolean r104 = r211.f362053b;     // Catch: Throwable -> L56
        if (r212 == false) goto L18;
        OfficeUrlPreviewHostCardType r105 = OfficeUrlPreviewHostCardType.COMPACT;     // Catch: Throwable -> L56
    L19:
        b r111 = new b(r110, r210, r102, r103, r104, r105, RangesKt.coerceAtLeast(r213, 1), r214, r215, r216);     // Catch: Throwable -> L56
        h("render_requested", r111, null);     // Catch: Throwable -> L56
        IOfficeUrlPreviewHostService r106 = (IOfficeUrlPreviewHostService) ServiceManager.get().getService(IOfficeUrlPreviewHostService.class);     // Catch: Throwable -> L56
        if (r106 != null) goto L26;
        h("url_preview_host_service_missing", r111, null);     // Catch: Throwable -> L56
        c(r214);     // Catch: Throwable -> L56
        r215.invoke(Boolean.FALSE);     // Catch: Throwable -> L56
        monitor-exit(this);
        return;
    L26:
        if (q(r111, r106) == false) goto L30;
        q4 r107 = r106.a();     // Catch: Throwable -> L56
        h("office_sdk_waiting", r111, "globalReady=" + r107.f365248b + ", userReady=" + r107.f365249c);     // Catch: Throwable -> L56
        monitor-exit(this);
        return;
    L30:
        IdentityHashMap<LifecycleOwner, PageBinding> r108 = f361772e;     // Catch: Throwable -> L56
        PageBinding r109 = r108.get(r210);     // Catch: Throwable -> L56
        if (r109 != null) goto L45;
        int r112 = r111.f361804g;     // Catch: Throwable -> L56
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L35
        PageBinding r114 = new PageBinding(r110, r210, r106, r112);     // Catch: Throwable -> L35
        r108.put(r210, r114);     // Catch: Throwable -> L35
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L35
    L37:
        Object r116 = r115;
        if (Result.m9455isFailureimpl(r116) == false) goto L40;
        r116 = null;
    L40:
        PageBinding r117 = (PageBinding) r116;     // Catch: Throwable -> L56
        if (r117 != null) goto L46;
        h("page_service_create_failed", r111, null);     // Catch: Throwable -> L56
        c(r214);     // Catch: Throwable -> L56
        r215.invoke(Boolean.FALSE);     // Catch: Throwable -> L56
        monitor-exit(this);
        return;
    L46:
        IdentityHashMap<ViewGroup, PageBinding> r118 = f361774g;     // Catch: Throwable -> L56
        PageBinding r119 = r118.get(r214);     // Catch: Throwable -> L56
        if (r119 == null) goto L50;
        if (r119 == r117) goto L50;
        r119.l(r214);     // Catch: Throwable -> L56
        r214.removeAllViews();     // Catch: Throwable -> L56
    L50:
        r118.put(r214, r117);     // Catch: Throwable -> L56
        if (r109 != null) goto L53;
        k(r210);     // Catch: Throwable -> L56
    L53:
        r117.a(r111);     // Catch: Throwable -> L56
        monitor-exit(this);
        return;
    L35:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L56
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L37
    L45:
        r117 = r109;
        goto L46
    L18:
        r105 = OfficeUrlPreviewHostCardType.DEFAULT;     // Catch: Throwable -> L56
        goto L19
    L12:
        r101 = null;
    L56:
        th = move-exception;
        throw th;
    }
}
