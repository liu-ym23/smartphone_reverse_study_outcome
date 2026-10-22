package yc7;

import com.bytedance.sdk.bridge.js.spec.JsBridgeContext;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedBlockingDeque<e> f567230a = null;

    static {
        f567230a = new LinkedBlockingDeque();
    }

    public static boolean a(String r100, JSONObject r101, JsBridgeContext r102) {
        Iterator<e> r103 = f567230a.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        if (r103.next().a(r100, r101, r102) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
