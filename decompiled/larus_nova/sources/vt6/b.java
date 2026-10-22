package vt6;

import android.app.Activity;
import android.net.Uri;
import com.ss.android.ugc.aweme.poi.bean.DetailEnterPage;
import com.ss.android.ugc.aweme.poi.bean.PoiBizCode;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public interface b {
    void a(PoiBizCode r100, String r101, DetailEnterPage r102, Map<String, String> r103, boolean r104);

    boolean b(PoiBizCode r100, String r101, DetailEnterPage r102, Map<String, String> r103);

    boolean c(PoiBizCode r100, DetailEnterPage r101);

    void d(Activity r100, DetailEnterPage r101);

    void e(Activity r100);

    Object f(Uri r100, boolean r101, String r102);
}
