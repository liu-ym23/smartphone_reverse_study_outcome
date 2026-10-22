package al3;

import android.content.Context;
import android.graphics.Typeface;
import com.bytedance.android.ec.core.utils.font.e;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements e {
    public final ConcurrentHashMap<String, com.bytedance.android.ec.core.utils.font.a> a;

    /* JADX INFO: renamed from: al3.a$a, reason: collision with other inner class name */
    public static final class C0001a {
    }

    static {
    }

    public a() {
        this.a = new ConcurrentHashMap();
    }

    public final Typeface a(Context r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (1 > r4) goto L9;
        if (400 < r4) goto L9;
    L20:
        String r5 = "fonts/douyin_number_abc_medium.otf";
    L21:
        com.bytedance.android.ec.core.utils.font.a r0 = this.a.get(r5);
        if (r0 != null) goto L31;
        Typeface r6 = Typeface.createFromAsset(r3.getAssets(), r5);     // Catch: Throwable -> L26
    L27:
        this.a.put(r5, new com.bytedance.android.ec.core.utils.font.a(r6));
        return r6;
    L26:
        r6 = null;
        goto L27
    L31:
        return r0.a;
    L9:
        if (401 > r4) goto L15;
        if (500 < r4) goto L15;
        r5 = "fonts/douyin_number_abc_bold.otf";
    L15:
        if (501 > r4) goto L20;
        if (1000 < r4) goto L20;
        r5 = "fonts/douyin_number_abc_extra_bold.otf";
        goto L21
    }
}
