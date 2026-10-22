package mqc;

import com.volcengine.zeus.util.kv.KVStorage;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "pkgName");
        String r3 = KVStorage.INSTANCE.staticKV().getString("IDENTITY_" + r2, XmlPullParser.NO_NAMESPACE);
        if (r3 != null) goto L5;
        return XmlPullParser.NO_NAMESPACE;
    L5:
        return r3;
    }
}
