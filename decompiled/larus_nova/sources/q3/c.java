package q3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes43.dex */
public final class c {
    static {
    }

    public static HttpUrl a(HttpUrl r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Intrinsics.areEqual(ListProtector.get(r100.pathSegments(), r100.pathSize() - 1), "") == true) goto L7;
        HttpUrl.a r101 = r100.newBuilder();
        r101.getClass();
        r101.e("", 0, 0, false, false);
        return r101.b();
    L7:
        return r100;
    }

    public static HttpUrl b(HttpUrl r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.pathSize() - 1;
        if (Intrinsics.areEqual(ListProtector.get(r100.pathSegments(), r101), "") == false) goto L9;
        HttpUrl.a r102 = r100.newBuilder();
        ListProtector.remove(r102.f523781f, r101);
        if (((ArrayList) r102.f523781f).isEmpty() == false) goto L8;
        ((ArrayList) r102.f523781f).add("");
    L8:
        return r102.b();
    L9:
        return r100;
    }
}
