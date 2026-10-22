package com.larus.avlink.gallery;

import androidx.lifecycle.MutableLiveData;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<a> f292610a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableLiveData<a> f292611b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f292612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f292613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Long> f292614c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f292612a == r101.f292612a) goto L12;
            return false;
        L12:
            if (this.f292613b == r101.f292613b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f292614c, r101.f292614c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f292612a * 31) + this.f292613b) * 31) + this.f292614c.hashCode();
        }

        public final String toString() {
            return "SyncRequest(photoCnt=" + this.f292612a + ", videoCnt=" + this.f292613b + ", selectedUuids=" + this.f292614c + ')';
        }

        public a(int r100, List r101) {
            Intrinsics.checkNotNullParameter(r101, "selectedUuids");
            this.f292612a = r100;
            this.f292613b = 0;
            this.f292614c = r101;
        }
    }

    static {
        f292610a = new AtomicReference(null);
        f292611b = new MutableLiveData();
    }
}
