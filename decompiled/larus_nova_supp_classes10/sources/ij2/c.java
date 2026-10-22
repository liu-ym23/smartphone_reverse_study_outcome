package ij2;

import android.content.Context;
import android.util.LruCache;
import com.bytedance.android.ec.common.api.jump.model.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface c {

    public static final class a {
        public static ij2.a a(c r1, Context r2, LruCache<String, ij2.a> r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            if (r3 == null) goto L5;
            ij2.a r0 = r3.get(r1.getType());
        L6:
            if (r0 != null) goto L10;
            r0 = r1.c(r2);
            if (r3 == null) goto L10;
            ij2.a r4 = r3.put(r0.getType(), r0);
        L10:
            return r0;
        L5:
            r0 = null;
            goto L6
        }
    }

    ij2.a a(Context r1, LruCache<String, ij2.a> r2);

    boolean b(e r1);

    ij2.a c(Context r1);

    String getType();
}
