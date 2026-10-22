package com.larus.platform.api;

import android.view.View;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface k3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f365189a = null;

    /* JADX INFO: loaded from: classes31.dex */
    public static final class a implements k3 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f365190b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<k3> f365191c = null;

        public a() {
        }

        static {
            f365190b = new a();
            f365191c = LazyKt.lazy(new j3());
        }

        @Override // com.larus.platform.api.k3
        public final String l() {
            k3 r100 = f365191c.getValue();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.l();
        }

        @Override // com.larus.platform.api.k3
        public final String m() {
            k3 r100 = f365191c.getValue();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.m();
        }

        @Override // com.larus.platform.api.k3
        public final void k(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            k3 r101 = f365191c.getValue();
            if (r101 == null) goto L6;
            r101.k(r100);
            return;
        }
    }

    static {
        f365189a = a.f365190b;
    }

    void k(View r100);

    String l();

    String m();
}
