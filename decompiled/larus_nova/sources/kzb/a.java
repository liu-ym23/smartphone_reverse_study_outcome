package kzb;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.crash.dumper.Scraps;
import com.ss.android.lark.passport.signinsdk_api.env.EnvironmentType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f506825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f506826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EnvironmentType f506827d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f506824a, r101.f506824a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506825b, r101.f506825b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506826c, r101.f506826c) == true) goto L18;
        return false;
    L18:
        if (this.f506827d == r101.f506827d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f506824a.hashCode() * 31) + this.f506825b.hashCode()) * 31) + this.f506826c.hashCode()) * 31) + this.f506827d.hashCode();
    }

    public final String toString() {
        return "Environment(brand=" + this.f506824a + ", unit=" + this.f506825b + ", geo=" + this.f506826c + ", type=" + this.f506827d + ')';
    }

    public final EnvironmentType getType() {
        return this.f506827d;
    }

    public a(String r100, String r101, String r102, EnvironmentType r103) {
        Intrinsics.checkNotNullParameter(r100, "brand");
        Intrinsics.checkNotNullParameter(r101, Scraps.INNER_UNIT);
        Intrinsics.checkNotNullParameter(r102, MapBundleKey.MapObjKey.OBJ_GEO);
        Intrinsics.checkNotNullParameter(r103, "type");
        this.f506824a = r100;
        this.f506825b = r101;
        this.f506826c = r102;
        this.f506827d = r103;
    }
}
