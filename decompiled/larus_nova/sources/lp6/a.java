package lp6;

import com.bytedance.locallife.dito.data.DitoPage;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DitoPage f510230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f510231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f510232c;

    public /* synthetic */ a(DitoPage r100, Map r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = new LinkedHashMap();
    L6:
        if ((r102 & 4) == 0) goto L8;
        LinkedHashMap r103 = new LinkedHashMap();
    L9:
        this(r100, r101, r103);
        return;
    L8:
        r103 = null;
        goto L9
    }

    public a(DitoPage r100, Map<String, String> r101, Map<String, Object> r102) {
        Intrinsics.checkNotNullParameter(r101, "header");
        Intrinsics.checkNotNullParameter(r102, "extraInfo");
        this.f510230a = r100;
        this.f510231b = r101;
        this.f510232c = r102;
    }
}
