package j93;

import android.net.Uri;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.i;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f497770a = 0;

    static {
    }

    public static List a(k r100) {
        Iterable r101 = r100.f47130c;
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L12;
        List<ECHybridListItemVO> r104 = ((i) r103.next()).b();
        if (r104 != null) goto L11;
        r104 = CollectionsKt.emptyList();
    L11:
        CollectionsKt.addAll(r102, r104);
        goto L7
    L12:
        return r102;
    }

    public static boolean b(Uri r100) {
        String r101 = UriProtector.getQueryParameter(r100, "embedded_mode");
        if (r101 == null) goto L12;
        Integer r102 = StringsKt.toIntOrNull(r101);
        if (r102 == null) goto L13;
        int r103 = r102.intValue();
        if (r100.getBooleanQueryParameter("enable_lynx_config", false) == true) goto L9;
        return false;
    L9:
        if ((r103 & 1) == 0) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    L12:
        return false;
    }
}
