package ma3;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import java.util.Iterator;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f512686a = 0;

    static {
    }

    public static String a(SsResponse r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Iterator<T> r101 = r100.headers().iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
        if (StringsKt.equals(((Header) r102).getName(), Constants.Keys.KEY_X_TT_LOGID, true) == false) goto L7;
    L12:
        Header r103 = (Header) r102;
        if (r103 != null) goto L15;
        return null;
    L15:
        return r103.getValue();
    L11:
        r102 = null;
        goto L12
    }
}
