package com.bytedance.locallife.pdp;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.bytedance.locallife.pdp.view.GoodsDetailDialogFragment;
import com.ss.android.ugc.aweme.poi.bean.DetailEnterPage;
import com.ss.android.ugc.aweme.poi.bean.PoiBizCode;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ Fragment a(d r100, Uri r110, Long r111, Object r112, String r113, Object r114, String r115, int r116) {
            if ((r116 & 2) == 0) goto L5;
            Long r101 = null;
        L7:
            if ((r116 & 4) == 0) goto L9;
            Object r102 = null;
        L11:
            if ((r116 & 8) == 0) goto L13;
            String r103 = null;
        L15:
            if ((r116 & 16) == 0) goto L17;
            Object r104 = null;
        L19:
            if ((r116 & 32) == 0) goto L21;
            String r105 = null;
        L23:
            return r100.h(r110, r101, r102, r103, r104, r105);
        L21:
            r105 = r115;
            goto L23
        L17:
            r104 = r114;
            goto L19
        L13:
            r103 = r113;
            goto L15
        L9:
            r102 = r112;
            goto L11
        L5:
            r101 = r111;
            goto L7
        }
    }

    void a(xu6.d r100);

    boolean b(PoiBizCode r100, String r101, DetailEnterPage r102, Map<String, String> r103);

    boolean c(PoiBizCode r100, DetailEnterPage r101);

    void d(Activity r100, DetailEnterPage r101);

    void e(Activity r100);

    boolean f(Context r100, Uri r101, Long r102, Object r103, String r104, Object r105, Object r106);

    void g(PoiBizCode r100, String r101, DetailEnterPage r102, Map<String, String> r103, boolean r104, Map<String, String> r105);

    GoodsDetailDialogFragment h(Uri r100, Long r101, Object r102, String r103, Object r104, String r105);
}
