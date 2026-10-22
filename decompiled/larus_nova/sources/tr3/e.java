package tr3;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements g {
    public e() {
    }

    public final List a(String r100, long r110, long r111) {
        long r101 = r110 * 1000;
        long r102 = r111 * 1000;
        if (r101 <= r102) goto L5;
        return null;
    L5:
        if (r100 != null) goto L7;
        return null;
    L7:
        PolarisFileWrapper r112 = new PolarisFileWrapper(r100);
        if (r112.exists() == true) goto L10;
    L19:
        return null;
    L10:
        if (r112.isDirectory() == false) goto L19;
        File[] r103 = r112.listFiles(new d(PatternProtector.compile("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__\\S+__\\S+\\.alog\\.hot$"), r102, r101));
        ArrayList r113 = new ArrayList();
        if (r103 != null) goto L15;
        return null;
    L15:
        int r114 = r103.length;
        int r115 = 0;
    L16:
        if (r115 >= r114) goto L18;
        r113.add(r103[r115].getAbsolutePath());
        r115 = r115 + 1;
        goto L16
    L18:
        return r113;
    }
}
