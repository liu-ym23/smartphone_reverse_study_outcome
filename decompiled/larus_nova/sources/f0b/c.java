package f0b;

import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.utils.LarkContext;
import java.io.File;

/* JADX INFO: loaded from: classes34.dex */
public final class c {
    public static String a() {
        StringBuilder r100 = new StringBuilder();
        int r101 = com.ss.android.lark.diskmanage.storage.d.f420488a;
        r100.append(com.ss.android.lark.diskmanage.storage.d.i(LarkContext.getApplication()));
        String r102 = File.separator;
        r100.append(r102);
        r100.append("camera_view");
        r100.append(r102);
        String r103 = r100.toString();
        FileUtils.t(r103);
        return r103;
    }

    public static String b() {
        String r100 = a() + "photo" + File.separator;
        FileUtils.t(r100);
        return r100;
    }

    public static String c() {
        String r100 = a() + "video" + File.separator;
        FileUtils.t(r100);
        return r100;
    }
}
