package com.larus.bmhome.chat.exposure;

import android.graphics.Rect;
import android.view.View;
import bm8.h;
import com.larus.bmhome.chat.layout.widget.AppletWidget;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ue8.f;
import ue8.g;
import ue8.i;
import ue8.j;
import ue8.m;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f302979g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExposureConfig f302980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f302981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f302982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f302983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TriggerCoordinator f302984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f302985f;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.exposure.a$a, reason: collision with other inner class name */
    public static final class C4054a {

        /* JADX INFO: renamed from: com.larus.bmhome.chat.exposure.a$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4055a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f302986a = null;

            static {
                int[] r100 = new int[ExposureConfig.StrategyType.values().length];
                r100[ExposureConfig.StrategyType.ALL_VISIBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[ExposureConfig.StrategyType.BOTTOM_MOST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f302986a = r100;
            }
        }
    }

    static {
    }

    public final Rect a() {
        j r100 = (j) CollectionsKt.firstOrNull(this.f302981b.a());
        if (r100 == null) goto L7;
        WeakReference<View> r101 = r100.f549827b;
        if (r101 == null) goto L7;
        View r102 = r101.get();
    L8:
        b r103 = this.f302982c;
        WeakReference<View> r104 = r103.f302992f;
        if (r104 == null) goto L14;
        View r105 = r104.get();
        if (r105 == null) goto L14;
        r102 = r105;
    L16:
        r103.a(r102);
        return new Rect(r103.f302989c);
    L14:
        if (r102 != null) goto L16;
        return null;
    L7:
        r102 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [ue8.g] */
    public a(ExposureConfig r100) {
        this.f302980a = r100;
        this.f302981b = new m();
        this.f302982c = new b(r100);
        ExposureConfig.StrategyType r101 = r100.f302954f;
        int r102 = C4054a.C4055a.f302986a[r101.ordinal()];
        if (r102 != 1) goto L5;
        i r103 = new ue8.a();
    L10:
        this.f302983d = r103;
        this.f302984e = new TriggerCoordinator(r100, new g(this));
        return;
    L5:
        if (r102 != 2) goto L8;
        r103 = new ue8.b();
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void b(String r100, AppletWidget r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "callback");
        FLogger.f375446a.i("ExposureManager", "register: key=" + r100 + ", view=" + AppletWidget.class.getSimpleName() + '@' + Integer.toHexString(r101.hashCode()));
        m r103 = this.f302981b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "callback");
        r103.f549834a.put(r100, new j(r100, new WeakReference(r101), r102));
    }
}
