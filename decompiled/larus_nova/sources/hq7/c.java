package hq7;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class c {
    public static ArrayList<Long> a() {
        ArrayList<Long> r100 = new ArrayList();
        File[] r101 = new PolarisFileWrapper("/proc/self/task/").listFiles(new b());
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.add(Long.valueOf(CastLongProtector.parseLong(r101[r103].getName())));
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }
}
