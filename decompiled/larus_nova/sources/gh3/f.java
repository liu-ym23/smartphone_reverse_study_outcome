package gh3;

import android.text.TextUtils;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f481271b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f481272a;

    public static final class a {
    }

    static {
    }

    public f() {
        this.f481272a = new HashMap();
    }

    public static void a(f r100, String r101, String r102) {
        HashMap<String, String> r103 = r100.f481272a;
        if (TextUtils.isEmpty(r102) == false) goto L5;
    L8:
        r102 = "";
    L9:
        r103.put(r101, r102);
        return;
    L5:
        if (TextUtils.equals("null", r102) == true) goto L8;
        Intrinsics.checkNotNull(r102);
        goto L9
    }
}
