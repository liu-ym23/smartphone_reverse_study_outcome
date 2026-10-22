package y90;

import com.facebook.keyframes.model.KFImage;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f566957a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f566957a, ((a) r100).f566957a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<String, Object> r100 = this.f566957a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ShortTermJSBDynamicFactorUpdateEvent(features=" + this.f566957a + ")";
    }

    public a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, KFImage.FEATURES_JSON_FIELD);
        this.f566957a = r100;
    }
}
