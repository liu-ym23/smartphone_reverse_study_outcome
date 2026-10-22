package fd;

import com.bytedance.android.btm.api.PageProp;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.util.f;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, PageInfoStack> f476450a = null;

    static {
        f476450a = new LinkedHashMap();
    }

    public static void a(Object r100, PageProp r101, boolean r102) {
        if (r101.getSingleton() == true) goto L5;
        return;
    L5:
        String r103 = BtmPageRecorder.f42212a;
        PageInfoStack r104 = BtmPageRecorder.m(r100, r102);
        String r105 = r100.getClass().getName();
        Map<String, PageInfoStack> r106 = f476450a;
        PageInfoStack r107 = (PageInfoStack) ((LinkedHashMap) r106).get(r105);
        if (r107 != null) goto L8;
        r106.put(r105, r104);
        return;
    L8:
        String r108 = r104.getBtmPre();
        if (r108 != null) goto L11;
    L14:
        boolean r109 = true;
    L15:
        if (r109 == false) goto L17;
        BtmPageRecorder.f42215d.put(new f(r100), r107);
        return;
    L17:
        r106.put(r105, r104);
        return;
    L11:
        if (r108.length() == 0) goto L14;
        r109 = false;
        goto L15
    }
}
