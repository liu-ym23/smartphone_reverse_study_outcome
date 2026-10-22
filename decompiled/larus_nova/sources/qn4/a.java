package qn4;

import com.bytedance.ee.bear.basesdk.api.params.CreateDocScene;
import com.bytedance.ee.bear.basesdk.api.params.CreateDocSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CreateDocSource f534025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CreateDocScene f534026b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f534025a == r101.f534025a) goto L12;
        return false;
    L12:
        if (this.f534026b == r101.f534026b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f534025a.hashCode() * 31) + this.f534026b.hashCode();
    }

    public final String toString() {
        return "CreateDocInfo(source=" + this.f534025a + ", scene=" + this.f534026b + ')';
    }

    public a() {
        CreateDocSource r100 = CreateDocSource.DEFAULT;
        CreateDocScene r101 = CreateDocScene.DEFAULT;
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.f534025a = r100;
        this.f534026b = r101;
    }
}
