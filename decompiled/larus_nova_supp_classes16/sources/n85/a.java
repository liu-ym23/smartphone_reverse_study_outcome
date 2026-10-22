package n85;

import com.bytedance.ee.bear.drive.module.nativepreview.model.FileBlockResModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public a() {
    }

    public final String a(HashMap<String, FileBlockResModel> r9) {
        String r2 = "";
        if (r9.size() <= 5) goto L16;
        Iterator<Map.Entry<String, FileBlockResModel>> r10 = r9.entrySet().iterator();
        long r0 = Long.MAX_VALUE;
    L6:
        if (r10.hasNext() == false) goto L16;
        Map.Entry<String, FileBlockResModel> r3 = r10.next();
        if (r3 == null) goto L6;
        if (r3.getValue() == null) goto L6;
        FileBlockResModel r4 = r3.getValue();
        long r5 = r4.getUpdateTime();
        if (r5 >= r0) goto L6;
        if (r4.isNeedShow() == true) goto L6;
        r2 = r3.getKey();
        r0 = r5;
    L16:
        return r2;
    }
}
