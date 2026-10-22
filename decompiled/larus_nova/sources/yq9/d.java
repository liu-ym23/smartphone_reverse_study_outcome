package yq9;

import com.larus.platform.constants.media.DataLoaderPreloadPriority;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f568869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f568870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f568871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataLoaderPreloadPriority f568872d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f568869a, r101.f568869a) == true) goto L12;
        return false;
    L12:
        if (this.f568870b == r101.f568870b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f568871c, r101.f568871c) == true) goto L18;
        return false;
    L18:
        if (this.f568872d == r101.f568872d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f568869a.hashCode() * 31;
        long r101 = this.f568870b;
        return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f568871c.hashCode()) * 31) + this.f568872d.hashCode();
    }

    public final String toString() {
        return "FlowPreloaderURLItem(key=" + this.f568869a + ", preloadSize=" + this.f568870b + ", url=" + this.f568871c + ", priority=" + this.f568872d + ')';
    }

    public d(String r100, long r101, String r102) {
        DataLoaderPreloadPriority r103 = DataLoaderPreloadPriority.DEFAULT;
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r103, "priority");
        this.f568869a = r100;
        this.f568870b = r101;
        this.f568871c = r102;
        this.f568872d = r103;
    }
}
