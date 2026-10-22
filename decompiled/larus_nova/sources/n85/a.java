package n85;

import com.bytedance.ee.bear.drive.module.nativepreview.model.FileBlockResModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class a {
    public a() {
    }

    public final String a(HashMap<String, FileBlockResModel> r100) {
        String r101 = "";
        if (r100.size() <= 5) goto L16;
        Iterator<Map.Entry<String, FileBlockResModel>> r102 = r100.entrySet().iterator();
        long r103 = Long.MAX_VALUE;
    L6:
        if (r102.hasNext() == false) goto L16;
        Map.Entry<String, FileBlockResModel> r104 = r102.next();
        if (r104 == null) goto L6;
        if (r104.getValue() == null) goto L6;
        FileBlockResModel r105 = r104.getValue();
        long r106 = r105.getUpdateTime();
        if (r106 >= r103) goto L6;
        if (r105.isNeedShow() == true) goto L6;
        r101 = r104.getKey();
        r103 = r106;
    L16:
        return r101;
    }
}
