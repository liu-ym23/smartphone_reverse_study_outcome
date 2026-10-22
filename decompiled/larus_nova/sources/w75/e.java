package w75;

import android.util.SparseArray;
import com.bytedance.ee.bear.drive.core.model.PreviewMeta;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f558571a = 0;

    public static final class a {
        @JvmStatic
        public static PreviewMeta a(w75.a r100) {
            PreviewMeta r101 = null;
            if (r100 != null) goto L5;
            return null;
        L5:
            int r102 = r100.f558536e;
            SparseArray<PreviewMeta> r103 = r100.c().f558565i;
            if (r103 == null) goto L14;
            r101 = r103.get(r102);
            if (r101 == null) goto L14;
            if (CollectionsKt.listOf(new Integer[]{9, 11, 12}).contains(Integer.valueOf(r102)) == false) goto L14;
            if (r101.getStatus() != 0) goto L14;
            r101.setLinearized(true);
        L14:
            return r101;
        }
    }

    static {
    }
}
