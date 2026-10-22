package ij2;

import android.content.Context;
import android.util.LruCache;
import com.bytedance.android.ec.common.api.jump.model.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public interface c {

    public static final class a {
        public static ij2.a a(c r100, Context r101, LruCache<String, ij2.a> r102) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (r102 == null) goto L5;
            ij2.a r103 = r102.get(r100.getType());
        L6:
            if (r103 != null) goto L10;
            r103 = r100.c(r101);
            if (r102 == null) goto L10;
            ij2.a r104 = r102.put(r103.getType(), r103);
        L10:
            return r103;
        L5:
            r103 = null;
            goto L6
        }
    }

    ij2.a a(Context r100, LruCache<String, ij2.a> r101);

    boolean b(e r100);

    ij2.a c(Context r100);

    String getType();
}
