package o09;

import com.alipay.sdk.m.u.i;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f521649a = 0;

    static {
    }

    public static Pair a(String r100) {
        if (r100 == null) goto L4;
        List r101 = StringsKt.split$default(r100, new String[]{i.f25853b}, false, 0, 6, null);
    L5:
        String r102 = "";
        if (r101 == null) goto L9;
        String r103 = (String) CollectionsKt.first(r101);
        if (r103 == null) goto L9;
    L10:
        if (r101 == null) goto L16;
        String r104 = (String) CollectionsKt.last(r101);
        if (r104 == null) goto L16;
        r102 = r104;
    L16:
        return new Pair(r103, r102);
    L9:
        r103 = "";
        goto L10
    L4:
        r101 = null;
        goto L5
    }
}
