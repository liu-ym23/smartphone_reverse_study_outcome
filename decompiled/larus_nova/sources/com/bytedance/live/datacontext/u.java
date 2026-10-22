package com.bytedance.live.datacontext;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Object, a> f255097a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataContext f255098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Disposable f255099b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f255098a, r101.f255098a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f255099b, r101.f255099b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f255098a.hashCode() * 31) + this.f255099b.hashCode();
        }

        public final String toString() {
            return "Entry(dataContext=" + this.f255098a + ", subscription=" + this.f255099b + ')';
        }

        public a(DataContext r100, Disposable r101) {
            Intrinsics.checkNotNullParameter(r100, "dataContext");
            Intrinsics.checkNotNullParameter(r101, LiveEndPageData.TAG_SUBSCRIPTION);
            this.f255098a = r100;
            this.f255099b = r101;
        }
    }

    public u() {
        this.f255097a = new HashMap();
    }

    public final synchronized void a(Object r100) {
        monitor-enter(this);
        a r101 = this.f255097a.remove(r100);     // Catch: Throwable -> L10
        if (r101 == null) goto L8;
        Disposable r102 = r101.f255099b;     // Catch: Throwable -> L10
        if (r102 == null) goto L8;
        r102.dispose();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
