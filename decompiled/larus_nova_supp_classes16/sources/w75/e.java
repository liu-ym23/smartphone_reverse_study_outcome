package w75;

import android.util.SparseArray;
import com.bytedance.ee.bear.drive.core.model.PreviewMeta;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static PreviewMeta a(w75.a r5) {
            PreviewMeta r0 = null;
            if (r5 != null) goto L5;
            return null;
        L5:
            int r1 = r5.e;
            SparseArray<PreviewMeta> r6 = r5.c().i;
            if (r6 == null) goto L14;
            r0 = r6.get(r1);
            if (r0 == null) goto L14;
            if (CollectionsKt.listOf(new Integer[]{9, 11, 12}).contains(Integer.valueOf(r1)) == false) goto L14;
            if (r0.getStatus() != 0) goto L14;
            r0.setLinearized(true);
        L14:
            return r0;
        }
    }

    static {
    }
}
