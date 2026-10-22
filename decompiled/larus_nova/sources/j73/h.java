package j73;

import com.bytedance.android.btm.api.model.PageFinder;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface h {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(d r100, String r110, Map r111, boolean r112, String r113, int r114) {
            if ((r114 & 2) == 0) goto L5;
            Map r101 = null;
        L7:
            if ((r114 & 8) == 0) goto L9;
            boolean r102 = true;
        L11:
            if ((r114 & 16) == 0) goto L13;
            String r103 = null;
        L14:
            r100.n(r110, r101, false, r102, r103, null);
            return;
        L13:
            r103 = r113;
            goto L14
        L9:
            r102 = r112;
            goto L11
        L5:
            r101 = r111;
            goto L7
        }
    }

    void H(String r100, Map<String, Object> r101);

    PageFinder getPageFinder();

    void n(String r100, Map<String, ? extends Object> r101, boolean r102, boolean r103, String r104, PageFinder r105);
}
