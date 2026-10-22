package cp6;

import com.bytedance.locallife.biz.base.cube.e;
import com.bytedance.locallife.biz.base.cube.h;
import com.bytedance.locallife.biz.base.cube.m;
import com.bytedance.locallife.biz.base.cube.r;
import com.bytedance.locallife.cube.api.i.ICubeCustomizeInterceptor;
import fp6.i;
import fp6.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f464698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f464699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bp6.a f464700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ICubeCustomizeInterceptor f464701d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f464698a, r101.f464698a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464699b, r101.f464699b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464700c, r101.f464700c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464701d, r101.f464701d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464698a.hashCode() * 31) + this.f464699b.hashCode()) * 31) + this.f464700c.hashCode()) * 31;
        ICubeCustomizeInterceptor r101 = this.f464701d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CubeEnvInitConfig(cubeHostDependency=" + this.f464698a + ", logger=" + this.f464699b + ", bizAbilityService=" + this.f464700c + ", schemaInterceptor=" + this.f464701d + ')';
    }

    public b() {
        m r100 = m.f256545a;
        r r101 = r.f256550a;
        e r102 = e.f256535a;
        h r103 = h.f256540a;
        Intrinsics.checkNotNullParameter(r100, "cubeHostDependency");
        Intrinsics.checkNotNullParameter(r101, "logger");
        Intrinsics.checkNotNullParameter(r102, "bizAbilityService");
        this.f464698a = r100;
        this.f464699b = r101;
        this.f464700c = r102;
        this.f464701d = r103;
    }
}
